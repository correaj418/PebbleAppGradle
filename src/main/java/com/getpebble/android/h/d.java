package com.getpebble.android.h;

import android.content.Context;
import android.text.TextUtils;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.j.a;

public class d {
    private static String a = "(?i)^(?=.*?\\bpebble\\b)((?!time).)*$";
    private static String b = "(?i)^(?=.*?\\bpebble\\b)(?=.*?\\btime\\b)(.)*$";

    public static boolean a(Context context) {
        return new a(context, false).c();
    }

    public static boolean a(PebbleDevice pebbleDevice) {
        if (pebbleDevice == null || TextUtils.isEmpty(pebbleDevice.getName())) {
            return false;
        }
        return pebbleDevice.getName().matches(a);
    }
}
