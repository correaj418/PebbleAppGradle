package com.getpebble.android.common.b.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.getpebble.android.a.b;
import com.getpebble.android.common.a;
import java.util.Locale;
import java.util.Map;

public class c {
    private static String a = null;

    public static void a(Context context) {
        Map globalEventProperties = b.getGlobalEventProperties();
        if (!globalEventProperties.containsKey("platform")) {
            globalEventProperties.put("platform", "android");
        }
        b.getOrCreateChildMap(globalEventProperties, "app").put("locale", context.getResources().getConfiguration().locale.toString());
        Map orCreateChildMap = b.getOrCreateChildMap(globalEventProperties, "device_phone");
        orCreateChildMap.put("locale", Locale.getDefault().toString());
        orCreateChildMap.put("system_name", "Android OS");
        orCreateChildMap.put("model", a());
        orCreateChildMap.put("system_version", VERSION.RELEASE);
        boolean z = false;
        try {
            z = a.K().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        } catch (Throwable e) {
            f.b("Trace", "appendDeviceDataToAnalyticsGlobals: ", e);
        }
        orCreateChildMap.put("supports_ble", Boolean.valueOf(z));
        Map orCreateChildMap2 = b.getOrCreateChildMap(globalEventProperties, "identity");
        String toUpperCase = b(context).toUpperCase(Locale.US);
        orCreateChildMap2.put("device", toUpperCase);
        globalEventProperties.put("session", toUpperCase);
    }

    public static String b(Context context) {
        if (a == null) {
            c(context);
        }
        return a;
    }

    public static String a() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return a(str2);
        }
        return a(str) + " " + str2;
    }

    private static String a(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        return !Character.isUpperCase(charAt) ? Character.toUpperCase(charAt) + str.substring(1) : str;
    }

    private static synchronized void c(Context context) {
        synchronized (c.class) {
            if (a == null) {
                String string = Secure.getString(context.getContentResolver(), "android_id");
                if ("9774d56d682e549c".equals(string)) {
                    string = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getDeviceId();
                    if (string == null) {
                        string = "unknown";
                    }
                    a = string;
                } else {
                    a = string;
                }
            }
        }
    }
}
