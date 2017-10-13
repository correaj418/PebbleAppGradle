package com.getpebble.android.bluetooth.e;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import com.getpebble.android.bluetooth.b.d;
import com.getpebble.android.bluetooth.j.b;
import com.getpebble.android.common.b.a.f;
import java.util.UUID;

public class j implements e {
    static final UUID a = UUID.fromString("30000003-328E-0FBB-C642-1AA6699BDADA");
    static final UUID b = UUID.fromString("30000004-328E-0FBB-C642-1AA6699BDADA");
    static final UUID c = UUID.fromString("30000005-328E-0FBB-C642-1AA6699BDADA");
    static final UUID d = UUID.fromString("30000006-328E-0FBB-C642-1AA6699BDADA");
    private k e;
    private final BluetoothGatt f;
    private BluetoothGattCharacteristic g;
    private boolean h;
    private final UUID i;
    private final UUID j;
    private final UUID k;

    j(BluetoothGatt bluetoothGatt, boolean z) {
        this.f = bluetoothGatt;
        if (z) {
            this.i = a;
            this.j = b;
            this.k = d;
            return;
        }
        this.i = m.a;
        this.j = m.b;
        this.k = this.j;
    }

    synchronized void a() {
        if (this.e == null) {
            throw new IllegalStateException("ppoGConnection is null!");
        }
        BluetoothGattService service = this.f.getService(this.i);
        if (service == null) {
            f.a("PPoGClient", "subscribe: ppogService is null");
            this.e.a(d.PP_GATT_CLIENT);
        } else {
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(this.j);
            this.g = service.getCharacteristic(this.k);
            if (characteristic == null) {
                f.a("PPoGClient", "subscribe: dataCharacteristic is null");
                this.e.a(d.PP_GATT_CLIENT);
            } else if (this.g == null) {
                f.a("PPoGClient", "subscribe: dataCharacteristicWr is null");
                this.e.a(d.PP_GATT_CLIENT);
            } else {
                BluetoothGattDescriptor descriptor = characteristic.getDescriptor(m.e);
                descriptor.setValue(g.i);
                f.d("PPoGClient", "subscribe: writing to pp data descriptor (subscribing to notifications)");
                if (!this.f.writeDescriptor(descriptor)) {
                    f.b("PPoGClient", "subscribe: !writeDescriptor");
                    this.e.a(d.PP_GATT_CLIENT);
                } else if (!this.f.setCharacteristicNotification(characteristic, true)) {
                    f.a("PPoGClient", "subscribe: error subscribing to data characteristic");
                    this.e.a(d.PP_GATT_CLIENT);
                }
            }
        }
    }

    public synchronized boolean a(b bVar, byte[] bArr) {
        boolean z;
        if (this.h) {
            com.getpebble.android.bluetooth.b.a("PPoGClient", "sendBytesToDevice: busy");
            z = false;
        } else {
            this.g.setValue(bArr);
            z = this.f.writeCharacteristic(this.g);
            if (z) {
                this.h = true;
            } else {
                f.b("PPoGClient", "sendBytesToDevice: gatt returned false!!");
            }
        }
        return z;
    }

    public synchronized void a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic.getUuid().equals(this.k) || bluetoothGattCharacteristic.getUuid().equals(a.a)) {
            this.h = false;
            if (this.e == null) {
                f.b("PPoGClient", "onCharacteristicWrite: ppoGConnection is null");
            } else {
                this.e.j();
            }
        }
    }

    public synchronized void b(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic.getUuid().equals(this.j)) {
            if (this.e == null) {
                f.b("PPoGClient", "onCharacteristicWrite: ppoGConnection is null");
            } else {
                byte[] value = bluetoothGattCharacteristic.getValue();
                try {
                    this.e.a(new l(value));
                } catch (Throwable e) {
                    f.b("PPoGClient", "onCharacteristicWriteRequest: error decoding packet: " + com.getpebble.android.bluetooth.b.b.c(value), e);
                    this.e.a(d.GATT_SERVER);
                }
            }
        }
    }

    public synchronized void a(k kVar, Context context) {
        this.e = kVar;
    }

    public synchronized void a(k kVar) {
        this.e = null;
    }
}
