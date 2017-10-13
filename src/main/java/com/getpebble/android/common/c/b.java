package com.getpebble.android.common.c;

import android.bluetooth.BluetoothClass;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.Transport;
import com.getpebble.android.bluetooth.d.g;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.c.a;
import com.getpebble.android.common.model.l;
import java.util.Locale;

public class b {
    private static final String[] a = new String[]{"D0:07:90", "00:18:33", "00:18:34", "D8:95:2F"};

    public static boolean a(String str, String str2, Transport transport, BluetoothClass bluetoothClass, int i, g gVar) {
        if (transport.equals(Transport.LE)) {
            return a(gVar);
        }
        if (transport.equals(Transport.CLASSIC)) {
            return a(str, str2, bluetoothClass, i);
        }
        return false;
    }

    private static boolean a(String str, String str2, BluetoothClass bluetoothClass, int i) {
        if (bluetoothClass == null) {
            f.d("DiscoveryUtils", "isPebbleDevice: class is null: " + str2);
            return false;
        } else if (!a.a(str2)) {
            f.d("DiscoveryUtils", "isPebbleDevice: it is not a debug pebble device / " + str2);
            return false;
        } else if (i == 1 && bluetoothClass.getDeviceClass() != 1796) {
            f.e("DiscoveryUtils", "isPebbleDevice: not WEARABLE_WRIST_WATCH: " + str2);
            if (bluetoothClass.getDeviceClass() != 7936) {
                return false;
            }
            f.d("DiscoveryUtils", "isPebbleDevice: " + str2 + " => is uncategorized.  falling back to prefix search.");
            for (String toLowerCase : a) {
                if (str2.toLowerCase(Locale.US).startsWith(toLowerCase.toLowerCase(Locale.US))) {
                    f.d("DiscoveryUtils", str2 + " => prefix search positive");
                    return true;
                }
            }
            return false;
        } else if (str == null) {
            f.d("DiscoveryUtils", "isPebbleDevice: name is null: " + str2);
            return false;
        } else if (str.toLowerCase(Locale.US).startsWith("pebble")) {
            f.e("DiscoveryUtils", "isPebbleDevice: detected a pebble device " + str2 + " / " + str);
            return true;
        } else {
            f.d("DiscoveryUtils", "isPebbleDevice: " + str + " does not start with " + "pebble" + ". It is not a pebble device / " + str2);
            return false;
        }
    }

    private static boolean a(g gVar) {
        if (gVar == null || gVar.e == null) {
            return false;
        }
        if (PebbleApplication.y().a(a.LEGACY_DEVICE_BLUETOOTH_LE_ENABLED, false)) {
            return true;
        }
        return l.a(gVar.e.a).getPlatformCode().useBle;
    }
}
