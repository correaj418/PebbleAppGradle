package com.getpebble.android.bluetooth.k;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.getpebble.android.common.b.a.f;

public abstract class c extends BroadcastReceiver {
    private final Context a;
    private final String b;
    private int c = -1;
    private int d = -1;

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public c(Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
        context.registerReceiver(this, intentFilter);
        this.a = context;
        this.b = str;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            f.b("BondReceiver", "onReceive: intent is null");
            return;
        }
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice == null || !this.b.equals(bluetoothDevice.getAddress())) {
            f.d("BondReceiver", "onReceive: wrong device to listening to " + bluetoothDevice);
            return;
        }
        f.d("BondReceiver", "onReceive: " + intent.getAction());
        String action = intent.getAction();
        if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equals(action)) {
            a(intent);
        } else if ("android.bluetooth.device.action.PAIRING_REQUEST".equals(action)) {
            b(intent);
        }
    }

    private void a(Intent intent) {
        int intExtra = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", -1);
        int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1);
        if (intExtra == this.c && intExtra2 == this.d) {
            f.d("BondReceiver", "onReceive: duplicated event prev state = " + this.c + " new state = " + this.d);
            return;
        }
        this.c = intExtra;
        this.d = intExtra2;
        f.d("BondReceiver", "handleBondingEvents: device = " + ((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress() + " prev state = " + this.c + " new state = " + this.d + " reason = " + intent.getIntExtra("android.bluetooth.device.extra.REASON", -1));
        if (this.c == 12 && this.d == 10) {
            f.e("BondReceiver", "handleBondingEvents: onDeviceUnbonded");
            c();
        } else if (this.c == 11 && this.d == 10) {
            f.e("BondReceiver", "handleBondingEvents: onDeviceBondingFailed");
            b();
        } else if (this.c == 11 && this.d == 12) {
            f.e("BondReceiver", "handleBondingEvents: onDeviceBonded");
            a();
        }
    }

    private void b(Intent intent) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice == null) {
            f.b("BondReceiver", "handlePairingRequest: device is null");
        } else if (VERSION.SDK_INT >= 19) {
            a(bluetoothDevice, intent);
        } else {
            a(bluetoothDevice);
        }
    }

    private void a(BluetoothDevice bluetoothDevice) {
        f.e("BondReceiver", "defaultHandlePairingRequest: device is null");
        d();
    }

    @TargetApi(19)
    private void a(BluetoothDevice bluetoothDevice, Intent intent) {
        int intExtra = intent.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", Integer.MIN_VALUE);
        f.d("BondReceiver", "kitkatHandlePairingRequest: type = " + intExtra);
        switch (intExtra) {
            case 2:
                if (intent.getIntExtra("android.bluetooth.device.extra.PAIRING_KEY", Integer.MIN_VALUE) == Integer.MIN_VALUE) {
                    f.a("BondReceiver", "kitkatHandlePairingRequest: invalide passkey received, even Android won't show the accept/cancel to pair dialog");
                    return;
                } else {
                    b(bluetoothDevice);
                    return;
                }
            case 3:
                b(bluetoothDevice);
                return;
            default:
                return;
        }
    }

    @TargetApi(19)
    private void b(BluetoothDevice bluetoothDevice) {
        if (VERSION.SDK_INT >= 25) {
            f.d("BondReceiver", "Not doing auto-accept on 7.1+");
            return;
        }
        try {
            if (bluetoothDevice.setPairingConfirmation(true)) {
                abortBroadcast();
            }
        } catch (Throwable e) {
            f.a("BondReceiver", "kitkatHandlePairingRequest: error ", e);
            a(bluetoothDevice);
        } catch (Throwable e2) {
            f.a("BondReceiver", "kitkatHandlePairingRequest: error ", e2);
            a(bluetoothDevice);
        }
    }

    public void e() {
        try {
            this.a.unregisterReceiver(this);
        } catch (Throwable e) {
            f.b("BondReceiver", "Error unregistering bond receiver!", e);
        }
    }
}
