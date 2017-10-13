package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.a.b;
import com.google.android.gms.b.as;
import com.google.android.gms.common.a.g;
import com.google.android.gms.common.a.h;
import com.google.android.gms.common.a.o;
import com.google.android.gms.common.internal.j;
import java.util.concurrent.atomic.AtomicBoolean;

public class k {
    private static String a = null;
    @Deprecated
    public static final int b = b();
    public static boolean c = false;
    public static boolean d = false;
    static boolean e = false;
    static final AtomicBoolean f = new AtomicBoolean();
    private static int g = 0;
    private static boolean h = false;
    private static final AtomicBoolean i = new AtomicBoolean();

    @Deprecated
    public static int a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(b.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            i(context);
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
            l a = l.a(context);
            if (!g.a(context)) {
                try {
                    if (a.a(packageManager.getPackageInfo("com.android.vending", 8256), d.a) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }
                    if (a.a(packageInfo, a.a(packageManager.getPackageInfo("com.android.vending", 8256), d.a)) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (NameNotFoundException e) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
                    return 9;
                }
            } else if (a.a(packageInfo, d.a) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (h.a(packageInfo.versionCode) < h.a(b)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + b + " but found " + packageInfo.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (Throwable e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static boolean a() {
        return "user".equals(Build.TYPE);
    }

    static boolean a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 18:
            case 42:
                return true;
            default:
                return false;
        }
    }

    @TargetApi(21)
    static boolean a(Context context, String str) {
        if (com.google.android.gms.common.a.k.h()) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        if (h(context)) {
            return false;
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 8192).enabled;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private static int b() {
        return j.a;
    }

    @Deprecated
    public static void b(Context context) {
        int a = i.b().a(context);
        if (a != 0) {
            Intent a2 = i.b().a(context, a, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + a);
            if (a2 == null) {
                throw new c(a);
            }
            throw new d(a, "Google Play Services not available", a2);
        }
    }

    @Deprecated
    public static boolean b(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public static boolean b(Context context, int i) {
        return o.a(context, i);
    }

    public static boolean c(Context context) {
        j(context);
        return e;
    }

    @Deprecated
    public static boolean c(Context context, int i) {
        return i == 18 ? true : i == 1 ? a(context, "com.google.android.gms") : false;
    }

    public static boolean d(Context context) {
        return c(context) || !a();
    }

    @Deprecated
    public static void e(Context context) {
        if (!f.getAndSet(true)) {
            try {
                ((NotificationManager) context.getSystemService("notification")).cancel(10436);
            } catch (SecurityException e) {
            }
        }
    }

    public static Context f(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static String g(Context context) {
        Object obj = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        ApplicationInfo a;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            a = as.b(context).a(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            a = null;
        }
        return a != null ? packageManager.getApplicationLabel(a).toString() : packageName;
    }

    @TargetApi(18)
    public static boolean h(Context context) {
        if (com.google.android.gms.common.a.k.e()) {
            Bundle applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
            if (applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"))) {
                return true;
            }
        }
        return false;
    }

    private static void i(Context context) {
        if (!i.get()) {
            j(context);
            if (g == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (g != b) {
                int i = b;
                int i2 = g;
                String valueOf = String.valueOf("com.google.android.gms.version");
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 290).append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ").append(i).append(" but found ").append(i2).append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"").append(valueOf).append("\" android:value=\"@integer/google_play_services_version\" />").toString());
            }
        }
    }

    private static void j(Context context) {
        if (!h) {
            k(context);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void k(android.content.Context r7) {
        /*
        r6 = 1;
        r0 = r7.getPackageName();	 Catch:{ NameNotFoundException -> 0x003a }
        a = r0;	 Catch:{ NameNotFoundException -> 0x003a }
        r0 = com.google.android.gms.b.as.b(r7);	 Catch:{ NameNotFoundException -> 0x003a }
        r1 = com.google.android.gms.common.internal.aa.a(r7);	 Catch:{ NameNotFoundException -> 0x003a }
        g = r1;	 Catch:{ NameNotFoundException -> 0x003a }
        r1 = "com.google.android.gms";
        r2 = 64;
        r0 = r0.b(r1, r2);	 Catch:{ NameNotFoundException -> 0x003a }
        if (r0 == 0) goto L_0x0036;
    L_0x001b:
        r1 = com.google.android.gms.common.l.a(r7);	 Catch:{ NameNotFoundException -> 0x003a }
        r2 = 1;
        r2 = new com.google.android.gms.common.j.a[r2];	 Catch:{ NameNotFoundException -> 0x003a }
        r3 = 0;
        r4 = com.google.android.gms.common.j.d.a;	 Catch:{ NameNotFoundException -> 0x003a }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ NameNotFoundException -> 0x003a }
        r2[r3] = r4;	 Catch:{ NameNotFoundException -> 0x003a }
        r0 = r1.a(r0, r2);	 Catch:{ NameNotFoundException -> 0x003a }
        if (r0 == 0) goto L_0x0036;
    L_0x0030:
        r0 = 1;
        e = r0;	 Catch:{ NameNotFoundException -> 0x003a }
    L_0x0033:
        h = r6;
    L_0x0035:
        return;
    L_0x0036:
        r0 = 0;
        e = r0;	 Catch:{ NameNotFoundException -> 0x003a }
        goto L_0x0033;
    L_0x003a:
        r0 = move-exception;
        r1 = "GooglePlayServicesUtil";
        r2 = "Cannot find Google Play services package name.";
        android.util.Log.w(r1, r2, r0);	 Catch:{ all -> 0x0045 }
        h = r6;
        goto L_0x0035;
    L_0x0045:
        r0 = move-exception;
        h = r6;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.k.k(android.content.Context):void");
    }
}
