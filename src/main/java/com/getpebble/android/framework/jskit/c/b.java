package com.getpebble.android.framework.jskit.c;

import android.content.SharedPreferences;
import android.text.TextUtils;
import c.a.a.a.e;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.install.app.b.c;
import com.getpebble.android.common.model.AppInfo;
import com.getpebble.android.common.model.i;
import com.getpebble.android.framework.PebbleFrameworkService;
import com.google.a.b.ad;
import com.google.b.g;
import com.google.b.l;
import com.google.b.o;
import com.google.b.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class b {
    private UUID a;
    private File b;
    private File c;
    private SharedPreferences d;

    public enum a {
        SUCCESS,
        DOWNGRADE,
        SHOULD_REFETCH,
        FAILURE
    }

    public b(UUID uuid, File file, File file2, SharedPreferences sharedPreferences) {
        this.a = uuid;
        this.b = file;
        this.c = file2;
        this.d = sharedPreferences;
    }

    public UUID a() {
        return this.a;
    }

    boolean b() {
        return new File(this.b, "pebble-js-app.js").isFile();
    }

    void a(File file) {
        file.mkdir();
    }

    boolean b(File file) {
        return file.exists();
    }

    boolean c(File file) {
        return file.isDirectory();
    }

    boolean d(File file) {
        return Arrays.asList(file.list()).containsAll(ad.a((Object) "appinfo.json", (Object) "pebble-js-app.js"));
    }

    void e(File file) {
        c.a.a.a.b.b(file);
    }

    boolean f(File file) {
        try {
            File file2 = new File(this.b, "appinfo.json");
            File file3 = new File(this.b, "pebble-js-app.js");
            c.a.a.a.b.a(file2, file);
            c.a.a.a.b.a(file3, file);
            return true;
        } catch (Throwable e) {
            f.a("JsAppMigration", "copyFilesTojskit2Dir: failed ", e);
            return false;
        }
    }

    AppInfo g(File file) {
        Throwable e;
        String b;
        try {
            Reader bufferedReader = new BufferedReader(new FileReader(new File(file, "appinfo.json")));
            b = e.b(bufferedReader);
            try {
                g gVar = new g();
                gVar.a(com.google.a.f.e.class, new c());
                AppInfo appInfo = (AppInfo) gVar.c().a(b, AppInfo.class);
                bufferedReader.close();
                return appInfo;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            b = null;
            f.a("JsAppMigration", "getAppInfoFromFolder: error (json = '" + b + "'", e);
            return null;
        }
    }

    boolean a(float f, float f2) {
        return f2 > f;
    }

    boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return true;
        }
        double parseDouble;
        double parseDouble2;
        boolean z;
        if (str != null) {
            try {
                parseDouble = Double.parseDouble(str);
            } catch (Throwable e) {
                f.b("JsAppMigration", "versionLabelNewer: current is not a number", e);
            }
            if (str2 != null) {
                try {
                    parseDouble2 = Double.parseDouble(str2);
                } catch (Throwable e2) {
                    f.b("JsAppMigration", "versionLabelNewer: toCheck is not a number", e2);
                }
                if (parseDouble2 <= parseDouble || (parseDouble == -1.0d && parseDouble2 != -1.0d)) {
                    z = true;
                } else {
                    z = false;
                }
                return z;
            }
            parseDouble2 = -1.0d;
            if (parseDouble2 <= parseDouble) {
            }
            z = true;
            return z;
        }
        parseDouble = -1.0d;
        if (str2 != null) {
            parseDouble2 = Double.parseDouble(str2);
            if (parseDouble2 <= parseDouble) {
            }
            z = true;
            return z;
        }
        parseDouble2 = -1.0d;
        if (parseDouble2 <= parseDouble) {
        }
        z = true;
        return z;
    }

    boolean b(String str, String str2) {
        return new i(str2).a(new i(str)) > 0;
    }

    boolean a(File file, File file2) {
        AppInfo g = g(file);
        AppInfo g2 = g(file2);
        if (g2 == null) {
            return false;
        }
        if (g == null) {
            return true;
        }
        if (a(g.getVersionCode(), g2.getVersionCode()) || b(g.getVersionLabel(), g2.getVersionLabel()) || a(g.getSdkVersion(), g2.getSdkVersion())) {
            return true;
        }
        return false;
    }

    a c() {
        a aVar = a.SUCCESS;
        File file = new File(this.c, this.a.toString());
        if (b()) {
            if (b(file)) {
                if (c(file)) {
                    f.d("JsAppMigration", "migrateAppFiles: folder exists for " + this.a);
                    if (d(file)) {
                        f.d("JsAppMigration", "migrateAppFiles: folder is latest version");
                        if (!a(file, this.b)) {
                            f.b("JsAppMigration", "migrateAppFiles: folder is latest for " + this.a + ", not copying");
                            e(this.b);
                            return a.DOWNGRADE;
                        }
                    }
                    aVar = a.SHOULD_REFETCH;
                } else {
                    f.b("JsAppMigration", "migrateAppFiles: " + file + " contains a file named " + this.a + " not a directory. Deleting");
                    e(file);
                    a(file);
                    if (!c(file)) {
                        f.a("JsAppMigration", "migrateAppFiles: could not create directory for " + this.a);
                        e(this.b);
                        return a.FAILURE;
                    }
                }
            }
            if (f(file)) {
                f.d("JsAppMigration", "migrateAppFiles: copied files for " + this.a);
                e(this.b);
                return aVar;
            }
            f.a("JsAppMigration", "migrateAppFiles: copying files failed for " + this.a);
            return a.FAILURE;
        }
        f.a("JsAppMigration", "migrateAppFiles: no JS file in legacy directory!");
        return a.FAILURE;
    }

    o a(String str, q qVar) {
        try {
            return qVar.a(str).l();
        } catch (Throwable e) {
            f.a("JsAppMigration", "getJsonObjectFromPrefs: malformed json", e);
            return null;
        }
    }

    String d() {
        return this.d.getString("hls_" + this.a, null);
    }

    void a(Set<Entry<String, String>> set) {
        PebbleFrameworkService.a().a(this.a.toString(), (Set) set);
    }

    void e() {
        this.d.edit().remove("hls_" + this.a).remove("app_settings_storage" + this.a + "_*").remove("JsAppPersistentSettings_" + this.a).apply();
    }

    boolean f() {
        String d = d();
        if (d == null) {
            f.d("JsAppMigration", "migrateLocalStorage: no localstorage string in sharedprefs");
            return false;
        }
        o a = a(d, new q());
        f.d("JsAppMigration", "migrateLocalStorage: appUUID = " + this.a + ", localStorageJsonObject = " + a);
        if (a == null) {
            f.d("JsAppMigration", "getJsonObjectFromPrefs: no localstorage object to migrate for " + this.a);
            return false;
        }
        Set hashSet = new HashSet();
        for (Entry entry : a.a()) {
            l lVar = (l) entry.getValue();
            if (lVar.j()) {
                hashSet.add(new SimpleImmutableEntry(entry.getKey(), lVar.c()));
            }
        }
        a(hashSet);
        f.d("JsAppMigration", "getJsonObjectFromPrefs: localstorage migrated for " + this.a + "; deleting old storage");
        e();
        return true;
    }

    public a g() {
        a c = c();
        f();
        return c;
    }
}
