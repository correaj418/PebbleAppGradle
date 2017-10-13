package com.getpebble.android.onboarding;

import android.content.SharedPreferences;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.firmware.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {
    private static Integer a = null;
    private static Map<String, Integer> b = new ConcurrentHashMap();
    private static Map<String, Integer> c = new ConcurrentHashMap();
    private static Map<String, com.getpebble.android.onboarding.activity.a.a> d = new ConcurrentHashMap();

    public static void a(int i) {
        a = Integer.valueOf(i);
        f.c("OnboardingPreferences", String.format("Setting application onboarding version %d", new Object[]{Integer.valueOf(i)}));
        b().edit().putInt("pref_key_app_onboarding_version", i).apply();
    }

    public static void a(PebbleDevice pebbleDevice, int i) {
        if (pebbleDevice == null) {
            f.a("OnboardingPreferences", "*** Failed to set onboarding version, device is null");
            return;
        }
        b.put(pebbleDevice.getAddress(), Integer.valueOf(i));
        f.c("OnboardingPreferences", String.format("Setting onboarding version %d for device %s", new Object[]{Integer.valueOf(i), pebbleDevice.getAddress()}));
        b().edit().putInt("pref_key_lp_onboarding_version_" + pebbleDevice.getAddress(), i).apply();
    }

    public static void b(PebbleDevice pebbleDevice, int i) {
        if (pebbleDevice != null) {
            c.put(pebbleDevice.getAddress(), Integer.valueOf(i));
            f.c("OnboardingPreferences", String.format("Setting health onboarding version %d for device %s", new Object[]{Integer.valueOf(i), pebbleDevice.getAddress()}));
            b().edit().putInt("pref_key_health_onboarding_version" + pebbleDevice.getAddress(), i).apply();
        }
    }

    public static void a(PebbleDevice pebbleDevice, com.getpebble.android.onboarding.activity.a.a aVar) {
        if (pebbleDevice != null) {
            d.put(pebbleDevice.getAddress(), aVar);
            f.c("OnboardingPreferences", String.format("Setting device onboarding version %s for device %s", new Object[]{aVar.name(), pebbleDevice.getAddress()}));
            b().edit().putInt("pref_key_device_onboarding_version" + pebbleDevice.getAddress(), aVar.serializedValue).apply();
        }
    }

    public static int a(PebbleDevice pebbleDevice) {
        if (pebbleDevice == null) {
            return -1;
        }
        if (b.containsKey(pebbleDevice.getAddress())) {
            return ((Integer) b.get(pebbleDevice.getAddress())).intValue();
        }
        return b().getInt("pref_key_lp_onboarding_version_" + pebbleDevice.getAddress(), -1);
    }

    public static int b(PebbleDevice pebbleDevice) {
        if (pebbleDevice == null) {
            return -1;
        }
        if (c.containsKey(pebbleDevice.getAddress())) {
            return ((Integer) c.get(pebbleDevice.getAddress())).intValue();
        }
        return b().getInt("pref_key_health_onboarding_version" + pebbleDevice.getAddress(), -1);
    }

    public static com.getpebble.android.onboarding.activity.a.a c(PebbleDevice pebbleDevice) {
        if (pebbleDevice == null) {
            return com.getpebble.android.onboarding.activity.a.a.UNKNOWN;
        }
        if (d.containsKey(pebbleDevice.getAddress())) {
            return (com.getpebble.android.onboarding.activity.a.a) d.get(pebbleDevice.getAddress());
        }
        return com.getpebble.android.onboarding.activity.a.a.from(b().getInt("pref_key_device_onboarding_version" + pebbleDevice.getAddress(), com.getpebble.android.onboarding.activity.a.a.ZERO.serializedValue));
    }

    public static int a() {
        if (a != null) {
            return a.intValue();
        }
        return b().getInt("pref_key_app_onboarding_version", -1);
    }

    private static SharedPreferences b() {
        return com.getpebble.android.common.a.K().getSharedPreferences("ONBOARDING_PREFERENCE", 4);
    }

    private static String e(PebbleDevice pebbleDevice) {
        if (pebbleDevice == null) {
            return "pref_key_migration_agreement_UNKNOWN";
        }
        return "pref_key_migration_agreement_" + pebbleDevice.getAddress();
    }

    public static void a(boolean z, PebbleDevice pebbleDevice) {
        b().edit().putBoolean(e(pebbleDevice), z).commit();
    }

    private static boolean f(PebbleDevice pebbleDevice) {
        String e = e(pebbleDevice);
        boolean z = b().getBoolean(e, false);
        f.e("OnboardingPreferences", "hasMigrationAgreement: key = " + e + ", hasMigrationAgreement = " + z);
        return z;
    }

    public static boolean d(PebbleDevice pebbleDevice) {
        if (!b.a() || f(pebbleDevice)) {
            return false;
        }
        return true;
    }
}
