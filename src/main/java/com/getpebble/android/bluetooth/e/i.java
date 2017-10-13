package com.getpebble.android.bluetooth.e;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Build.VERSION;
import com.getpebble.android.bluetooth.b.d;
import com.getpebble.android.bluetooth.e.h.c;
import com.getpebble.android.common.b.a.f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

class i {
    static final UUID a = UUID.fromString("00000003-328E-0FBB-C642-1AA6699BDADA");
    protected b b = b.IDLE;
    private final BluetoothGatt c;
    private final com.getpebble.android.bluetooth.e.h.b d;
    private final a e;
    private final int f;

    public interface a {
        void a(d dVar);

        void b(int i);
    }

    enum b {
        IDLE,
        SUBSCRIBING,
        REQUESTING,
        REQUESTING_GOT_MTU,
        WAITING_FOR_MTU
    }

    i(BluetoothGatt bluetoothGatt, h hVar, a aVar, int i) {
        this.c = bluetoothGatt;
        this.d = hVar.b();
        this.e = aVar;
        this.f = i;
    }

    synchronized void a() {
        if (!this.b.equals(b.IDLE)) {
            f.b("MtuNegotiator", "negotiateMtu: can't execute in state " + this.b);
            a(d.MTU);
        } else if (this.d.a.equals(c.DO_NOT_NEGOTIATE)) {
            f.c("MtuNegotiator", "negotiateMtu: device should be left at default value");
            a(23);
        } else if (VERSION.SDK_INT >= 21) {
            b();
        } else {
            c();
        }
    }

    @TargetApi(21)
    protected void b() {
        int i = 339;
        if (this.d.a.equals(c.LOW_MTU)) {
            f.d("MtuNegotiator", "negotiateMtuNative: needsLowMtu() / using low MTU = " + this.d.b);
            i = this.d.b;
        }
        this.c.requestMtu(i);
    }

    protected void c() {
        if (this.d.a.equals(c.LOW_MTU)) {
            f.c("MtuNegotiator", "negotiateMtuCharacteristic: needs low MTU - this is not supported via characteristic; leaving at default");
            a(23);
            return;
        }
        BluetoothGattCharacteristic characteristic = this.c.getService(g.g).getCharacteristic(a);
        if (characteristic == null) {
            f.a("MtuNegotiator", "mtuCharacteristic is null - not negotiating mtu");
            a(23);
            return;
        }
        BluetoothGattDescriptor descriptor = characteristic.getDescriptor(m.e);
        descriptor.setValue(g.i);
        if (!this.c.writeDescriptor(descriptor)) {
            f.a("MtuNegotiator", "negotiateMtu: error subscribing via descriptor write");
            a(d.MTU);
        } else if (this.c.setCharacteristicNotification(characteristic, true)) {
            f.d("MtuNegotiator", "negotiateMtuCharacteristic: subscribing to mtu characteristic");
            this.b = b.SUBSCRIBING;
        } else {
            f.a("MtuNegotiator", "negotiateMtu: error subscribing");
            a(d.MTU);
        }
    }

    synchronized void a(BluetoothGattDescriptor bluetoothGattDescriptor) {
        BluetoothGattCharacteristic characteristic = bluetoothGattDescriptor.getCharacteristic();
        if (characteristic.getUuid().equals(a)) {
            if (this.b.equals(b.SUBSCRIBING)) {
                characteristic.setValue(com.getpebble.android.bluetooth.b.b.a(339));
                if (this.c.writeCharacteristic(characteristic)) {
                    f.d("MtuNegotiator", "onDescriptorWrite: writing to mtu characteristic");
                    this.b = b.REQUESTING;
                } else {
                    f.a("MtuNegotiator", "onDescriptorWrite: error requesting new mtu!");
                    a(d.MTU);
                }
            } else {
                f.d("MtuNegotiator", "onDescriptorWrite: ignoring in state " + this.b);
            }
        }
    }

    synchronized void a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic.getUuid().equals(a)) {
            if (this.b.equals(b.REQUESTING)) {
                f.d("MtuNegotiator", "onCharacteristicWrite: now waiting for mtu value...");
                this.b = b.WAITING_FOR_MTU;
            } else if (this.b.equals(b.REQUESTING_GOT_MTU)) {
                c(bluetoothGattCharacteristic);
            }
        }
    }

    synchronized void b(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic.getUuid().equals(a)) {
            if (this.b.equals(b.REQUESTING)) {
                f.d("MtuNegotiator", "onCharacteristicChanged: got mtu value before onCharacteristicWrite(); waiting for that...");
                this.b = b.REQUESTING_GOT_MTU;
            } else if (this.b.equals(b.WAITING_FOR_MTU)) {
                c(bluetoothGattCharacteristic);
            }
        }
    }

    static int a(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        return com.getpebble.android.bluetooth.b.b.b(wrap).intValue();
    }

    void c(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] value = bluetoothGattCharacteristic.getValue();
        if (value == null) {
            f.a("MtuNegotiator", "processMtuFromCharacteristic: mtu bytes are null");
            a(d.MTU);
            return;
        }
        try {
            int a = a(value);
            f.c("MtuNegotiator", "processMtuFromCharacteristic: New MTU is " + a);
            a(a);
        } catch (Throwable e) {
            f.a("MtuNegotiator", "processMtuFromCharacteristic: error decoding new mtu!", e);
            a(d.MTU);
        }
    }

    private void a(int i) {
        this.b = b.IDLE;
        this.e.b(i);
    }

    private void a(d dVar) {
        this.b = b.IDLE;
        this.e.a(dVar);
    }
}
