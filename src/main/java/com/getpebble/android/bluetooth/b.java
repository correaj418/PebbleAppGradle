package com.getpebble.android.bluetooth;

import com.getpebble.android.bluetooth.h.c;
import com.getpebble.android.common.b.a.f;

public class b {
    private static boolean a = false;

    public static void a(String str, String str2) {
        if (a) {
            f.d(str, str2);
        }
    }

    public static void a() {
        a = c.b();
    }
}
