package com.getpebble.android.framework.jskit.c;

import android.content.Context;
import android.content.SharedPreferences;
import c.a.a.a.a.j;
import c.a.a.a.b;
import c.a.a.a.d;
import c.a.a.a.e;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.AppInfo;
import com.google.b.g;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class c {
    private SharedPreferences a;
    private a b;
    private File c;
    private File d;

    c(SharedPreferences sharedPreferences, a aVar, File file, File file2) {
        this.a = sharedPreferences;
        this.b = aVar;
        this.c = file;
        this.d = file2;
    }

    public static c a(Context context, File file) {
        SharedPreferences a = com.getpebble.android.common.b.b.c.a(context);
        return new c(a, new a(a), context.getDir("jskit_installed_apps", 0), file);
    }

    AppInfo a(File file) {
        Throwable e;
        String b;
        try {
            Reader bufferedReader = new BufferedReader(new FileReader(file));
            b = e.b(bufferedReader);
            try {
                g gVar = new g();
                gVar.a(com.google.a.f.e.class, new com.getpebble.android.common.framework.install.app.b.c());
                AppInfo appInfo = (AppInfo) gVar.c().a(b, AppInfo.class);
                bufferedReader.close();
                return appInfo;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            b = null;
            f.a("JsAppMigrator", "getAppInfoFromFile: error parsing app info. json = '" + b + "'", e);
            return null;
        }
    }

    b a(AppInfo appInfo, File file) {
        if (appInfo == null) {
            f.a("JsAppMigrator", "createMigrationIfPossible: Could not deserialize json");
            return null;
        }
        UUID uuid = appInfo.getUuid();
        if (uuid == null) {
            f.a("JsAppMigrator", "createMigrationIfPossible: UUID is null!");
            return null;
        } else if (file != null) {
            return new b(uuid, file, this.d, this.a);
        } else {
            f.a("JsAppMigrator", "createMigrationIfPossible: legacyAppRootDir is null. Adding " + uuid + " directly to refetch list");
            this.b.a(uuid);
            return null;
        }
    }

    Collection<File> a() {
        return b.a(this.c, c.a.a.a.a.e.a("appinfo.json", d.INSENSITIVE), j.a);
    }

    boolean b() {
        return this.c.list().length == 0;
    }

    void c() {
        b.b(this.c);
    }

    public static void a(Context context, ZipOutputStream zipOutputStream, PrintStream printStream) {
        File file = new File(context.getDir(com.getpebble.android.framework.jskit.c.a(), 0), "jskit-legacy-fs-tree.log");
        if (file.isFile()) {
            try {
                zipOutputStream.putNextEntry(new ZipEntry("jskit-legacy-fs-tree.log"));
                b.a(file, (OutputStream) printStream);
                zipOutputStream.closeEntry();
            } catch (Throwable e) {
                f.a("JsAppMigrator", "catLegacyFsToStream: error copying file", e);
            }
        }
    }

    Collection<File> d() {
        return b.a(this.c, j.a, j.a);
    }

    Writer b(File file) {
        return new FileWriter(file, true);
    }

    void e() {
        f.d("JsAppMigrator", "writeLegacyFsToFile: ");
        Collection<File> d = d();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(b(new File(this.d, "jskit-legacy-fs-tree.log")));
            bufferedWriter.write("Dumping legacy JsKit file tree at " + new c.b.a.b().toString());
            bufferedWriter.newLine();
            for (File absolutePath : d) {
                bufferedWriter.write(absolutePath.getAbsolutePath());
                bufferedWriter.newLine();
            }
            bufferedWriter.write("END");
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Throwable e) {
            f.a("JsAppMigrator", "writeLegacyFsToFile: IO error", e);
        }
        f.d("JsAppMigrator", "writeLegacyFsToFile: finished");
    }

    public void f() {
        f.d("JsAppMigrator", "migrateApps: mJsKit2RootDir = " + this.d);
        if (b()) {
            f.d("JsAppMigrator", "migrateApps: legacy directory empty");
            return;
        }
        e();
        Collection<File> a = a();
        f.d("JsAppMigrator", "migrateApps: " + a.size() + " legacy apps: " + a);
        for (File file : a) {
            b a2 = a(a(file), file.getParentFile());
            if (a2 != null) {
                switch (a2.g()) {
                    case SUCCESS:
                        this.b.b(a2.a());
                        break;
                    case FAILURE:
                    case SHOULD_REFETCH:
                        this.b.a(a2.a());
                        break;
                    default:
                        break;
                }
            }
            f.b("JsAppMigrator", "migrateApps: no migration for " + file);
        }
        this.b.d();
        this.b.b();
        c();
    }
}
