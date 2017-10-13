package com.getpebble.android.main.sections.support;

import android.accounts.Account;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import c.a.a.a.b;
import com.b.b.x;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.g.m;
import com.google.b.a.c;
import com.google.b.l;
import com.google.b.o;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class a {
    public static final long a = TimeUnit.DAYS.toMillis(5);
    private static final long b = TimeUnit.SECONDS.toMillis(90);
    private static final long c = TimeUnit.SECONDS.toMillis(30);
    private static final SimpleDateFormat d = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);

    private static class a {
        @c(a = "from_prf")
        public boolean a;
        @c(a = "phone_app_version")
        public String b = "4.4.1-1404-01abd2f76-endframe";
        @c(a = "phone_model")
        public String c = Build.MODEL;
        @c(a = "phone_os")
        public String d = "android";
        @c(a = "phone_os_version")
        public String e = VERSION.RELEASE;
        @c(a = "user_id")
        public String f;

        public a(File file) {
            this.a = file.getName().endsWith("_prf");
            com.getpebble.android.common.a.a u = PebbleApplication.u();
            Account g = u != null ? u.g() : null;
            this.f = g != null ? u.b(g) : "";
        }
    }

    public static void a(String str, PebbleDevice pebbleDevice, Context context, boolean z) {
        File file = new File(str);
        if (file.exists()) {
            File file2 = new File(a(context), a(pebbleDevice, System.currentTimeMillis(), z));
            f.c("AutoCoreDumpManager", "handleAutoCoreDump: Storing auto core dump " + file2.getPath());
            try {
                b.b(file, file2);
                PebbleApplication.v().i();
                return;
            } catch (Throwable e) {
                f.b("AutoCoreDumpManager", "handleAutoCoreDump: error copying core dump", e);
                return;
            }
        }
        f.b("AutoCoreDumpManager", "handleAutoCoreDump: source does not exist " + file.getPath());
    }

    public static List<Uri> a(Context context, long j, Map<String, Long> map) {
        Throwable th;
        List<Uri> arrayList = new ArrayList();
        File[] c = c(context);
        if (m.e()) {
            f.d("AutoCoreDumpManager", "Not attaching stored CoreDumps to support email; auto upload is enabled (" + c.length + " stored)");
            return arrayList;
        }
        int i = 0;
        for (File file : c) {
            if (file.length() + 0 > j) {
                f.b("AutoCoreDumpManager", "getFilesForSupportEmail: not adding " + file.getName() + " (over size limit)");
            } else {
                File supportFile = b.getSupportFile(context, file.getName());
                try {
                    f.d("AutoCoreDumpManager", "getFilesForSupportEmail: Copying " + file.getPath() + " to " + supportFile.getPath());
                    b.b(file, supportFile);
                    arrayList.add(b.getFileUri(context, supportFile));
                    StringBuilder append = new StringBuilder().append("core");
                    int i2 = i + 1;
                    try {
                        map.put(append.append(i).toString(), Long.valueOf(supportFile.length()));
                        if (!(m.e() || file.delete())) {
                            f.a("AutoCoreDumpManager", "getFilesForSupportEmail: Error deleting " + file.getPath());
                        }
                        i = i2;
                    } catch (Throwable e) {
                        Throwable th2 = e;
                        i = i2;
                        th = th2;
                        f.a("AutoCoreDumpManager", "Error copying auto core dump for support email", th);
                    }
                } catch (IOException e2) {
                    th = e2;
                    f.a("AutoCoreDumpManager", "Error copying auto core dump for support email", th);
                }
            }
        }
        return arrayList;
    }

    private static File[] c(Context context) {
        return a(context).listFiles();
    }

    public static File a(Context context) {
        return context.getDir("auto_core", 0);
    }

    private static String a(PebbleDevice pebbleDevice, long j, boolean z) {
        return d.format(new Date(j)) + "_auto_core_" + pebbleDevice.getAddress() + (z ? "_prf" : "");
    }

    private static String a() {
        return "https://files.pebblecorp.com/upload";
    }

    private static String a(String str, long j) {
        return "https://files.pebblecorp.com/core/" + str + "/" + j + "/";
    }

    private static void a(Context context, File file) {
        f.d("AutoCoreDumpManager", "uploadCoreDump: coreDump = " + file);
        try {
            x a = com.getpebble.android.d.a.a(context, a(), file, b);
            if (com.getpebble.android.d.a.a(a)) {
                PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.LAST_CORE_DUMP, ((o) a.b()).toString());
                l b = ((o) a.b()).b("watch_sn");
                l b2 = ((o) a.b()).b("timestamp");
                if (b == null || b2 == null) {
                    f.a("AutoCoreDumpManager", "uploadCoreDump: something was null in the file upload response! serialElement = " + b + " timestampElement = " + b2);
                    return;
                }
                String c = b.c();
                long e = b2.e();
                x xVar = null;
                try {
                    xVar = com.getpebble.android.d.a.b(context, a(c, e), new a(file), c);
                } catch (Throwable e2) {
                    f.b("AutoCoreDumpManager", "Core dump metadata upload failed", e2);
                }
                if (!com.getpebble.android.d.a.a(xVar)) {
                    f.b("AutoCoreDumpManager", "uploadCoreDump: error uploading metadata for " + file + " (still purging this core)");
                }
                if (!file.delete()) {
                    f.f("AutoCoreDumpManager", "uploadCoreDump: error deleting " + file);
                }
            } else if (a.d().b() == 409) {
                f.c("AutoCoreDumpManager", "uploadCoreDump: server detected a duplicate core; deleting");
                if (!file.delete()) {
                    f.f("AutoCoreDumpManager", "uploadCoreDump: error deleting duplicate: " + file);
                }
            } else {
                f.b("AutoCoreDumpManager", "uploadCoreDump: error uploading " + file + " / " + a.d().b());
            }
        } catch (Throwable e3) {
            f.a("AutoCoreDumpManager", "Core dump upload failed", e3);
        }
    }

    public static void b(Context context) {
        if (m.e()) {
            long currentTimeMillis = System.currentTimeMillis();
            f.d("AutoCoreDumpManager", "uploadAutoCoreDumpsBlocking()");
            for (File a : c(context)) {
                a(context, a);
            }
            f.d("AutoCoreDumpManager", "uploadAutoCoreDumpsBlocking: complete (took " + (System.currentTimeMillis() - currentTimeMillis) + " ms)");
            return;
        }
        f.d("AutoCoreDumpManager", "uploadAutoCoreDumps: auto upload disabled");
    }
}
