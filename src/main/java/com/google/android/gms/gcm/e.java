package com.google.android.gms.gcm;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.concurrent.atomic.AtomicInteger;

public class e {
    public static int a = 5000000;
    public static int b = 6500000;
    public static int c = 7000000;
    private static final AtomicInteger d = new AtomicInteger(1);

    public static String a(Context context) {
        return com.google.android.gms.iid.e.a(context);
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(a(context), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }
}
