package com.getpebble.android.bluetooth.j;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothHealth;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.bluetooth.le.BluetoothLeScanner;
import android.content.Context;
import android.os.Build;
import com.getpebble.android.common.b.a.f;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class a {
    private final Context a;
    private final boolean b;
    private final BluetoothAdapter c;
    private BluetoothA2dp d;
    private BluetoothHeadset e;
    private BluetoothHealth f;
    private ServiceListener g = new ServiceListener(this) {
        final /* synthetic */ a a;

        {
            this.a = r1;
        }

        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            this.a.a(i, bluetoothProfile);
        }

        public void onServiceDisconnected(int i) {
            this.a.a(i, null);
        }
    };

    public enum a {
        TURNING_OFF,
        OFF,
        TURNING_ON,
        ON,
        ERROR,
        UNKNOWN;

        public static a from(b bVar) {
            switch (bVar) {
                case OFF:
                    return OFF;
                case TURNING_OFF:
                case BLE_TURNING_OFF:
                    return TURNING_OFF;
                case ON:
                case BLE_ON:
                    return ON;
                case TURNING_ON:
                case BLE_TURNING_ON:
                    return TURNING_ON;
                case ERROR:
                    return ERROR;
                default:
                    return UNKNOWN;
            }
        }
    }

    public enum b {
        OFF(10),
        TURNING_ON(11),
        ON(12),
        TURNING_OFF(13),
        BLE_TURNING_ON(14),
        BLE_ON(15),
        BLE_TURNING_OFF(16),
        ERROR(Integer.MIN_VALUE),
        UNKNOWN(-1);
        
        public final int code;

        private b(int i) {
            this.code = i;
        }

        public static b fromCode(int i) {
            for (b bVar : values()) {
                if (bVar.code == i) {
                    return bVar;
                }
            }
            f.b("PebbleBluetoothAdapter", "unknown state: " + i);
            return UNKNOWN;
        }
    }

    public a(Context context, boolean z) {
        this.a = context;
        this.b = m();
        if (this.b) {
            this.c = null;
            return;
        }
        this.c = n();
        if (z) {
            this.c.getProfileProxy(context, this.g, 2);
            this.c.getProfileProxy(context, this.g, 1);
            this.c.getProfileProxy(context, this.g, 3);
        }
    }

    private static boolean m() {
        return Build.FINGERPRINT.contains("generic");
    }

    @SuppressLint({"NewApi"})
    private BluetoothAdapter n() {
        return ((BluetoothManager) this.a.getApplicationContext().getSystemService("bluetooth")).getAdapter();
    }

    public boolean a() {
        f.d("PebbleBluetoothAdapter", "cancelDiscovery()");
        if (this.b) {
            return true;
        }
        return this.c.cancelDiscovery();
    }

    public boolean b() {
        if (this.b) {
            return true;
        }
        return this.c.isDiscovering();
    }

    public b a(String str) {
        if (this.b) {
            return null;
        }
        try {
            return new b(this.c.getRemoteDevice(str), this);
        } catch (Throwable e) {
            f.a("PebbleBluetoothAdapter", "getPebbleBluetoothDevice: error : ", e);
            return null;
        }
    }

    public boolean c() {
        if (this.b) {
            return true;
        }
        return this.c.isEnabled();
    }

    public boolean d() {
        f.d("PebbleBluetoothAdapter", "startDiscovery()");
        if (this.b) {
            return true;
        }
        return this.c.startDiscovery();
    }

    public Set<b> e() {
        Set<b> hashSet = new HashSet();
        if (this.b) {
            return hashSet;
        }
        Set<BluetoothDevice> bondedDevices = this.c.getBondedDevices();
        if (bondedDevices == null) {
            f.b("PebbleBluetoothAdapter", "getBondedDevices: androidDevices is null");
            return hashSet;
        }
        for (BluetoothDevice bVar : bondedDevices) {
            try {
                hashSet.add(new b(bVar, this));
            } catch (Throwable e) {
                f.a("PebbleBluetoothAdapter", "getBondedDevices: error : ", e);
            }
        }
        f.d("PebbleBluetoothAdapter", "getBondedDevices() Returning: " + hashSet.size());
        return hashSet;
    }

    public boolean a(LeScanCallback leScanCallback) {
        if (this.b) {
            return true;
        }
        return this.c.startLeScan(leScanCallback);
    }

    public void b(LeScanCallback leScanCallback) {
        if (!this.b) {
            this.c.stopLeScan(leScanCallback);
        }
    }

    private void a(int i, BluetoothProfile bluetoothProfile) {
        f.d("PebbleBluetoothAdapter", "handleProfileServiceChange: profile = " + i + " proxy = " + bluetoothProfile);
        switch (i) {
            case 1:
                this.e = (BluetoothHeadset) bluetoothProfile;
                return;
            case 2:
                this.d = (BluetoothA2dp) bluetoothProfile;
                return;
            case 3:
                this.f = (BluetoothHealth) bluetoothProfile;
                return;
            default:
                return;
        }
    }

    private List<BluetoothDevice> o() {
        BluetoothManager bluetoothManager = (BluetoothManager) this.a.getApplicationContext().getSystemService("bluetooth");
        if (bluetoothManager == null) {
            return Collections.emptyList();
        }
        return bluetoothManager.getConnectedDevices(7);
    }

    public void f() {
        a(false);
    }

    public void g() {
        a(true);
    }

    private void a(boolean z) {
        if (!m()) {
            boolean z2;
            f.d("PebbleBluetoothAdapter", "dumpAllDevices(" + z + ") adapter state = " + j());
            int[] iArr = new int[]{2, 1, 0, 3, 12, 11, 10};
            BluetoothManager bluetoothManager = (BluetoothManager) this.a.getApplicationContext().getSystemService("bluetooth");
            if (bluetoothManager != null) {
                List<BluetoothDevice> devicesMatchingConnectionStates = bluetoothManager.getDevicesMatchingConnectionStates(7, iArr);
                List o = o();
                for (BluetoothDevice bluetoothDevice : devicesMatchingConnectionStates) {
                    if (bluetoothDevice == null) {
                        f.d("PebbleBluetoothAdapter", "> GATT: null!");
                    } else {
                        a(z, bluetoothDevice, o.contains(bluetoothDevice), "> GATT: connected = ");
                    }
                }
            }
            BluetoothA2dp bluetoothA2dp = this.d;
            if (bluetoothA2dp != null) {
                for (BluetoothDevice bluetoothDevice2 : bluetoothA2dp.getDevicesMatchingConnectionStates(iArr)) {
                    if (bluetoothDevice2 == null) {
                        f.d("PebbleBluetoothAdapter", "> a2dp: null!");
                    } else {
                        if (bluetoothA2dp.getConnectionState(bluetoothDevice2) > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        a(z, bluetoothDevice2, z2, "> a2dp: state = ");
                    }
                }
            }
            BluetoothHeadset bluetoothHeadset = this.e;
            if (bluetoothHeadset != null) {
                for (BluetoothDevice bluetoothDevice22 : bluetoothHeadset.getDevicesMatchingConnectionStates(iArr)) {
                    if (bluetoothDevice22 == null) {
                        f.d("PebbleBluetoothAdapter", "> headset: null!");
                    } else {
                        if (bluetoothHeadset.getConnectionState(bluetoothDevice22) > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        a(z, bluetoothDevice22, z2, "> headset: state = ");
                    }
                }
            }
            BluetoothHealth bluetoothHealth = this.f;
            if (bluetoothHealth != null) {
                for (BluetoothDevice bluetoothDevice222 : bluetoothHealth.getDevicesMatchingConnectionStates(iArr)) {
                    if (bluetoothDevice222 == null) {
                        f.d("PebbleBluetoothAdapter", "> health: null!");
                    } else {
                        if (bluetoothHealth.getConnectionState(bluetoothDevice222) > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        a(z, bluetoothDevice222, z2, "> health: state = ");
                    }
                }
            }
            for (BluetoothDevice bluetoothDevice2222 : this.c.getBondedDevices()) {
                if (bluetoothDevice2222 == null) {
                    f.d("PebbleBluetoothAdapter", "> bonded: null!");
                } else {
                    a(z, bluetoothDevice2222, false, "> bonded: ");
                }
            }
        }
    }

    private void a(boolean z, BluetoothDevice bluetoothDevice, boolean z2, String str) {
        b bVar = new b(bluetoothDevice, this);
        int k = bVar.k();
        if (!z || z2 || b.c(k)) {
            f.d("PebbleBluetoothAdapter", str + z2 + " / " + bVar.a(k));
        }
    }

    Object h() {
        try {
            Field declaredField = this.c.getClass().getDeclaredField("mService");
            declaredField.setAccessible(true);
            return declaredField.get(this.c);
        } catch (Throwable e) {
            f.c("PebbleBluetoothAdapter", "getIBluetooth: error doing reflection", e);
            return null;
        }
    }

    @TargetApi(21)
    public BluetoothLeScanner i() {
        return this.c == null ? null : this.c.getBluetoothLeScanner();
    }

    public b j() {
        try {
            Method declaredMethod = this.c.getClass().getDeclaredMethod("getLeState", new Class[0]);
            declaredMethod.setAccessible(true);
            return b.fromCode(((Integer) declaredMethod.invoke(this.c, new Object[0])).intValue());
        } catch (Throwable e) {
            f.c("PebbleBluetoothAdapter", "getLeState: error doing reflection", e);
            return b.ERROR;
        }
    }

    public boolean k() {
        return this.c.disable();
    }

    public boolean l() {
        return this.c.enable();
    }
}
