package com.getpebble.android.bluetooth.h;

import android.bluetooth.BluetoothClass;
import android.content.ContentResolver;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.Transport;
import com.getpebble.android.bluetooth.d.g;

public class d {
    private static a a;

    public interface a {
        void a(PebbleDevice pebbleDevice, int i, int i2, Boolean bool);

        void a(PebbleDevice pebbleDevice, com.getpebble.android.bluetooth.a.a aVar, boolean z, com.getpebble.android.bluetooth.b.d dVar);

        void a(PebbleDevice pebbleDevice, String str);

        void a(PebbleDevice pebbleDevice, boolean z);

        void a(com.getpebble.android.bluetooth.a.a aVar, boolean z);

        void a(com.getpebble.android.bluetooth.h.e.a aVar, ContentResolver contentResolver);

        boolean a();

        boolean a(String str, String str2, Transport transport, BluetoothClass bluetoothClass, int i, g gVar);

        boolean b();

        void c();
    }

    public static void a(a aVar) {
        a = aVar;
    }

    public static a a() {
        return a;
    }
}
