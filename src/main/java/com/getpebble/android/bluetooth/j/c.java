package com.getpebble.android.bluetooth.j;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.ParcelFileDescriptor;
import com.getpebble.android.common.b.a.f;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

public class c {
    private BluetoothSocket a;
    private BluetoothDevice b;

    c(BluetoothSocket bluetoothSocket, BluetoothDevice bluetoothDevice) {
        this.a = bluetoothSocket;
        this.b = bluetoothDevice;
    }

    public void a() {
        f.d("PebbleBluetoothSocket", "close();");
        if (this.a == null) {
            f.b("PebbleBluetoothSocket", "close: mBluetoothSocket is null");
            return;
        }
        this.a.close();
        try {
            Field declaredField = BluetoothSocket.class.getDeclaredField("mPfd");
            declaredField.setAccessible(true);
            ((ParcelFileDescriptor) declaredField.get(this.a)).close();
        } catch (Exception e) {
        }
    }

    public void b() {
        f.d("PebbleBluetoothSocket", "connect();");
        this.a.connect();
    }

    public InputStream c() {
        f.d("PebbleBluetoothSocket", "getInputStream();");
        return this.a.getInputStream();
    }

    public OutputStream d() {
        f.d("PebbleBluetoothSocket", "getOutputStream();");
        return this.a.getOutputStream();
    }
}
