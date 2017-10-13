package net.hockeyapp.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.util.Log;
import java.io.File;
import java.security.MessageDigest;

public class a {
    public static String a = null;
    public static String b = null;
    public static String c = null;
    public static String d = null;
    public static String e = null;
    public static String f = null;
    public static String g = null;
    public static String h = null;

    public static void a(Context context) {
        e = VERSION.RELEASE;
        f = Build.MODEL;
        g = Build.MANUFACTURER;
        b(context);
        c(context);
        d(context);
    }

    public static File a() {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "HockeyApp");
        if (!Boolean.valueOf(file.mkdirs()).booleanValue()) {
            Log.d("HockeyApp", "Couldn't create HockeyApp Storage dir");
        }
        return file;
    }

    private static void b(Context context) {
        if (context != null) {
            try {
                File filesDir = context.getFilesDir();
                if (filesDir != null) {
                    a = filesDir.getAbsolutePath();
                }
            } catch (Exception e) {
                Log.e("HockeyApp", "Exception thrown when accessing the files dir:");
                e.printStackTrace();
            }
        }
    }

    private static void c(Context context) {
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                d = packageInfo.packageName;
                b = "" + packageInfo.versionCode;
                c = packageInfo.versionName;
                int a = a(context, packageManager);
                if (a != 0 && a > packageInfo.versionCode) {
                    b = "" + a;
                }
            } catch (NameNotFoundException e) {
                Log.e("HockeyApp", "Exception thrown when accessing the package info:");
                e.printStackTrace();
            }
        }
    }

    private static int a(Context context, PackageManager packageManager) {
        int i = 0;
        try {
            Bundle bundle = packageManager.getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                i = bundle.getInt("buildNumber", 0);
            }
        } catch (NameNotFoundException e) {
            Log.e("HockeyApp", "Exception thrown when accessing the application info:");
            e.printStackTrace();
        }
        return i;
    }

    private static void d(Context context) {
        String string = Secure.getString(context.getContentResolver(), "android_id");
        if (d != null && string != null) {
            string = d + ":" + string + ":" + e(context);
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                byte[] bytes = string.getBytes("UTF-8");
                instance.update(bytes, 0, bytes.length);
                h = a(instance.digest());
            } catch (Throwable th) {
            }
        }
    }

    @SuppressLint({"InlinedApi"})
    private static String e(Context context) {
        String str;
        if (VERSION.SDK_INT >= 21) {
            str = Build.SUPPORTED_ABIS[0];
        } else {
            str = Build.CPU_ABI;
        }
        String str2 = "HA" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (str.length() % 10) + (Build.PRODUCT.length() % 10);
        str = "";
        try {
            str = Build.class.getField("SERIAL").get(null).toString();
        } catch (Throwable th) {
        }
        return str2 + ":" + str;
    }

    private static String a(byte[] bArr) {
        char[] toCharArray = "0123456789ABCDEF".toCharArray();
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = toCharArray[i2 >>> 4];
            cArr[(i * 2) + 1] = toCharArray[i2 & 15];
        }
        return new String(cArr).replaceAll("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5");
    }
}
