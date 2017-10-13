package com.getpebble.android.bluetooth.k;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.Transport;
import com.getpebble.android.bluetooth.j.b;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.timeline.e;
import java.lang.ref.WeakReference;

public abstract class d extends BroadcastReceiver {
    private WeakReference<Context> a = null;

    public abstract void a();

    public abstract void a(PebbleDevice pebbleDevice);

    public abstract void b();

    public d(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        f.d("ClassicDiscoveryReceiver", "Registering discovery receiver");
        context.registerReceiver(this, intentFilter);
        this.a = new WeakReference(context);
    }

    public final void onReceive(Context context, Intent intent) {
        System.currentTimeMillis();
        f.d("ClassicDiscoveryReceiver", "onReceive(" + context + e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + intent + ")");
        if (intent != null) {
            String action = intent.getAction();
            if (action != null) {
                if (action.equals("android.bluetooth.adapter.action.DISCOVERY_STARTED")) {
                    f.d("ClassicDiscoveryReceiver", "Discovery started.");
                    a();
                } else if (action.equals("android.bluetooth.device.action.FOUND")) {
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice == null) {
                        f.b("ClassicDiscoveryReceiver", "onReceive: device is null");
                        return;
                    }
                    Transport transport = Transport.CLASSIC;
                    int a = b.a(bluetoothDevice);
                    if (a != 1) {
                        return;
                    }
                    if (com.getpebble.android.bluetooth.h.d.a().a(bluetoothDevice.getName(), bluetoothDevice.getAddress(), transport, bluetoothDevice.getBluetoothClass(), a, null)) {
                        Object name = bluetoothDevice.getName();
                        if (TextUtils.isEmpty(name)) {
                            f.d("ClassicDiscoveryReceiver", "onReceive: name is null: " + bluetoothDevice.getAddress());
                            return;
                        } else {
                            a(new PebbleDevice(name, bluetoothDevice.getAddress(), transport, intent.getShortExtra("android.bluetooth.device.extra.RSSI", Short.MIN_VALUE)));
                            return;
                        }
                    }
                    f.e("ClassicDiscoveryReceiver", "onReceive: device is not a pebble: " + bluetoothDevice.getAddress());
                } else if (action.equals("android.bluetooth.adapter.action.DISCOVERY_FINISHED")) {
                    f.d("ClassicDiscoveryReceiver", "Discovery finished.");
                    b();
                }
            }
        }
    }
}
