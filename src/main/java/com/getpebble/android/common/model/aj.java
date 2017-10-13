package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.common.b.b.b;

public class aj extends ai {
    public static final Uri a = b.a(a());

    public static String a() {
        return "manifests JOIN devices ON manifests.hw_platform = devices.hw_platform";
    }

    public static Cursor a(ContentResolver contentResolver, PebbleDevice pebbleDevice) {
        String[] strArr = new String[]{"manifests.*"};
        String[] strArr2 = new String[]{pebbleDevice.getAddress()};
        return contentResolver.query(a, strArr, "devices.address = ?", strArr2, null);
    }
}
