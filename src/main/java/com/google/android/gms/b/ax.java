package com.google.android.gms.b;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.telephony.TelephonyManager;
import android.util.Log;

public class ax {
    private static int a = -1;

    public static boolean a(Context context) {
        return b(context) == 3;
    }

    public static int b(Context context) {
        if (a == -1) {
            switch (c(context)) {
                case 8:
                case 13:
                    a = 0;
                    break;
                case 10:
                    a = 3;
                    break;
                default:
                    a = e(context) ? 1 : 2;
                    break;
            }
        }
        return a;
    }

    private static int c(Context context) {
        return ((d(context) % 1000) / 100) + 5;
    }

    private static int d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("Fitness", "Could not find package info for Google Play Services");
            return -1;
        }
    }

    private static boolean e(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0;
        } catch (Throwable e) {
            Log.wtf("Fitness", "Unable to determine type of device, assuming phone.  Version: " + d(context), e);
            return true;
        }
    }
}
