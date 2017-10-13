package com.getpebble.android.h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.getpebble.android.common.b.a.f;

public class h {
    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        if (!z) {
            f.d("ConnectivityUtils", "hasInternetConnection: no connection. active = " + activeNetworkInfo);
        }
        return z;
    }

    public static boolean b(Context context) {
        for (NetworkInfo networkInfo : ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getAllNetworkInfo()) {
            if (networkInfo.getType() == 1 && networkInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

    public static String c(Context context) {
        if (b(context)) {
            return "WiFi";
        }
        switch (((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getNetworkType()) {
            case 0:
                return "Unknown";
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO rev. 0";
            case 6:
                return "EVDO rev. A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "iDen";
            case 12:
                return "EVDO rev. B";
            case 13:
                return "LTE";
            case 14:
                return "eHRPD";
            case 15:
                return "HSPA+";
            default:
                return "Unknown";
        }
    }
}
