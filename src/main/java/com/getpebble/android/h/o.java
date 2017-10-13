package com.getpebble.android.h;

import android.net.wifi.WifiManager;
import com.getpebble.android.common.a;
import com.getpebble.android.common.b.a.f;
import java.net.InetAddress;

public class o {
    public static String a() {
        try {
            return InetAddress.getByAddress(a(((WifiManager) a.K().getSystemService("wifi")).getConnectionInfo().getIpAddress())).getHostAddress();
        } catch (Throwable e) {
            f.a("IPUtil", "Failed to get ip address", e);
            return null;
        }
    }

    private static byte[] a(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }
}
