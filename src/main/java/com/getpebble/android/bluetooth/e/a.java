package com.getpebble.android.bluetooth.e;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public class a {
    static final UUID a = UUID.fromString("00000005-328E-0FBB-C642-1AA6699BDADA");
    static final c d = new c(135, 161, 4, 6000);
    static final c e = new c(135, 161, 2, 6000);
    static final c f = new c(9, 17, 0, 6000);
    boolean b;
    f c = f.IDLE;
    private final BluetoothGatt g;
    private final h h;
    private a i;
    private b j;

    public interface a {
        void a(com.getpebble.android.bluetooth.b.d dVar);

        void b_();
    }

    public static class b {
        public final int a;
        public final float b;
        public final int c;
        public final int d;

        private b(byte[] bArr) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            wrap.position(1);
            this.a = com.getpebble.android.bluetooth.b.b.b(wrap).intValue();
            this.b = ((float) this.a) * 1.25f;
            this.c = com.getpebble.android.bluetooth.b.b.b(wrap).intValue();
            this.d = com.getpebble.android.bluetooth.b.b.b(wrap).intValue() * 10;
        }

        public String toString() {
            return "CurrentParams [currentIntervalSlots = " + this.a + " (" + this.b + " ms), slaveLatencyConnectionEvents = " + this.c + ", currentSupervisionTimeoutMs = " + this.d + "]";
        }
    }

    static class c {
        final int a;
        final int b;
        final int c;
        final int d;

        c(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public String toString() {
            return "ParamMode [intervalMinSlots = " + this.a + ", intervalMaxSlots = " + this.b + ", slaveLatencyConnectionEvents = " + this.c + ", supervisionTimeoutMs = " + this.d + "]";
        }
    }

    static class d {
        final c a;
        final c b;
        final c c;

        d(c cVar, c cVar2, c cVar3) {
            this.a = cVar;
            this.b = cVar2;
            this.c = cVar3;
        }

        public String toString() {
            return "ParamSet [max = " + this.a + ", middle = " + this.b + ", min = " + this.c + "]";
        }
    }

    public enum e {
        MAX(0),
        MIDDLE(1),
        MIN(2);
        
        private final byte byteValue;

        private e(int i) {
            this.byteValue = (byte) i;
        }
    }

    enum f {
        IDLE,
        SUBSCRIBING,
        REQUESTING_MGMT,
        REQUESTING_PACKET_LENGTH_EXTENSION
    }

    a(BluetoothGatt bluetoothGatt, h hVar, a aVar) {
        this.g = bluetoothGatt;
        this.h = hVar;
        this.i = aVar;
    }

    void a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic.getUuid().equals(a)) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (value == null) {
                com.getpebble.android.common.b.a.f.b("ConnectionParamManager", "onCharacteristicChanged: param bytes are null");
                return;
            }
            this.j = new b(value);
            com.getpebble.android.common.b.a.f.d("ConnectionParamManager", "New params set by Pebble: " + this.j);
        }
    }

    boolean a(e eVar) {
        com.getpebble.android.common.b.a.f.d("ConnectionParamManager", "Requesting params: " + eVar);
        return a(new byte[]{(byte) 1, eVar.byteValue});
    }

    private boolean e() {
        com.getpebble.android.common.b.a.f.d("ConnectionParamManager", "Requesting packet length extension");
        return a(new byte[]{(byte) 2, (byte) 1});
    }

    private BluetoothGattCharacteristic f() {
        BluetoothGattService service = this.g.getService(g.g);
        if (service != null) {
            return service.getCharacteristic(a);
        }
        com.getpebble.android.common.b.a.f.a("ConnectionParamManager", "onServicesDiscovered: pairingService is null");
        return null;
    }

    boolean a() {
        return f() != null;
    }

    synchronized void b() {
        if (this.c.equals(f.IDLE)) {
            BluetoothGattCharacteristic f = f();
            if (f == null) {
                com.getpebble.android.common.b.a.f.a("ConnectionParamManager", "subscribeAndSetup: paramsCharacteristic is null");
                a(com.getpebble.android.bluetooth.b.d.NO_PAIRING_SERVICE);
            } else {
                com.getpebble.android.common.b.a.f.d("ConnectionParamManager", "subscribeAndSetup: subscribing connectivity params characteristic");
                BluetoothGattDescriptor descriptor = f.getDescriptor(m.e);
                descriptor.setValue(g.i);
                if (!this.g.writeDescriptor(descriptor)) {
                    com.getpebble.android.common.b.a.f.a("ConnectionParamManager", "subscribeAndSetup: error subscribing to params via descriptor write");
                    a(com.getpebble.android.bluetooth.b.d.PARAM_SUBSCRIBE);
                } else if (this.g.setCharacteristicNotification(f, true)) {
                    this.c = f.SUBSCRIBING;
                } else {
                    com.getpebble.android.common.b.a.f.a("ConnectionParamManager", "onServicesDiscovered: error subscribing to params");
                    a(com.getpebble.android.bluetooth.b.d.PARAM_SUBSCRIBE);
                }
            }
        } else {
            com.getpebble.android.common.b.a.f.a("ConnectionParamManager", "onServicesDiscovered: error subscribing to params");
            a(com.getpebble.android.bluetooth.b.d.PARAM_SUBSCRIBE);
        }
    }

    synchronized void c() {
        if (this.c.equals(f.SUBSCRIBING)) {
            this.b = true;
            if (!a(this.h.c(), this.h.d())) {
                com.getpebble.android.common.b.a.f.a("ConnectionParamManager", "onParamsDescriptorWrite: error requesting mgmt params");
                a(com.getpebble.android.bluetooth.b.d.PARAM_REQUEST);
            }
            this.c = f.REQUESTING_MGMT;
        } else {
            com.getpebble.android.common.b.a.f.c("ConnectionParamManager", "onParamsDescriptorWrite while not SUBSCRIBING_PARAMS");
        }
    }

    synchronized void d() {
        com.getpebble.android.common.b.a.f.d("ConnectionParamManager", "onParamsCharacteristicWrite: in state " + this.c);
        if (this.c.equals(f.REQUESTING_MGMT)) {
            if (this.h.g()) {
                this.c = f.REQUESTING_PACKET_LENGTH_EXTENSION;
                e();
            } else {
                g();
            }
        } else if (this.c.equals(f.REQUESTING_PACKET_LENGTH_EXTENSION)) {
            g();
        }
    }

    private boolean a(boolean z, d dVar) {
        byte b;
        com.getpebble.android.common.b.a.f.d("ConnectionParamManager", "Requesting mgmt settings: disablePebbleParamManagement = " + z + " paramSet = " + dVar);
        byte b2 = dVar != null ? (byte) 1 : (byte) 0;
        ByteBuffer allocate = ByteBuffer.allocate(b2 != (byte) 0 ? 17 : 2);
        allocate.put((byte) 0);
        if (z) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        allocate.put(b);
        if (b2 != (byte) 0) {
            a(dVar, allocate);
        }
        return a(allocate.array());
    }

    private boolean a(byte[] bArr) {
        if (this.b) {
            BluetoothGattService service = this.g.getService(g.g);
            if (service == null) {
                com.getpebble.android.common.b.a.f.b("ConnectionParamManager", "requestParams: service is null");
                return false;
            }
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(a);
            if (characteristic == null) {
                com.getpebble.android.common.b.a.f.b("ConnectionParamManager", "requestParams: characteristic is null");
                return false;
            }
            com.getpebble.android.common.b.a.f.e("ConnectionParamManager", "sendRequest: " + com.getpebble.android.bluetooth.b.b.c(bArr) + " len = " + bArr.length);
            characteristic.setValue(bArr);
            return this.g.writeCharacteristic(characteristic);
        }
        com.getpebble.android.common.b.a.f.d("ConnectionParamManager", "requestParams: not subscribed");
        return false;
    }

    private static void a(d dVar, ByteBuffer byteBuffer) {
        a(dVar.a, byteBuffer);
        a(dVar.b, byteBuffer);
        a(dVar.c, byteBuffer);
    }

    private static void a(c cVar, ByteBuffer byteBuffer) {
        byteBuffer.put(com.getpebble.android.bluetooth.b.b.b(com.google.a.f.e.a((long) cVar.a), ByteOrder.LITTLE_ENDIAN));
        byteBuffer.put(com.google.a.f.d.a((long) (cVar.b - cVar.a)));
        byteBuffer.put(com.google.a.f.d.a((long) cVar.c));
        byteBuffer.put(com.google.a.f.d.a((long) (cVar.d / 30)));
    }

    synchronized void a(a aVar) {
        this.i = aVar;
    }

    private synchronized void g() {
        this.c = f.IDLE;
        if (this.i != null) {
            this.i.b_();
        }
    }

    private synchronized void a(com.getpebble.android.bluetooth.b.d dVar) {
        this.c = f.IDLE;
        if (this.i != null) {
            this.i.a(dVar);
        }
    }
}
