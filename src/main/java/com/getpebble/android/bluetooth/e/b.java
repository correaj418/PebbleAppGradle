package com.getpebble.android.bluetooth.e;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import com.getpebble.android.bluetooth.b.d;
import com.getpebble.android.common.b.a.f;
import java.util.UUID;

public class b {
    static final UUID a = UUID.fromString("00000001-328E-0FBB-C642-1AA6699BDADA");
    protected boolean b;
    private final BluetoothGatt c;
    private a d;

    public interface a {
        void a(d dVar);

        void a(c cVar);
    }

    enum b {
        NO_ERROR(0),
        PASSKEY_NETRY_FAILED(1),
        OOB_NOT_AVAILABLE(2),
        AUTHENTICATION_REQUIREMENTS(3),
        CONFIRM_VALUE_FAILED(4),
        PAIRING_NOT_SUPPORTED(5),
        ENCRYPTION_KEY_SIZE(6),
        COMMAND_NOT_SUPPORTED(7),
        UNSPECIFIED_REASON(8),
        REPEATED_ATTEMPTS(9),
        INVALID_PARAMETERS(10),
        DHKEY_CHECK_FAILED(11),
        NUMERIC_COMPARISON_FAILED(12),
        BR_EDR_PAIRING_IN_PROGRESS(13),
        CROSS_TRANSPORT_KEY_DERIVATION_NOT_ALLOWED(14),
        UNKNOWN_ERROR(255);
        
        final byte code;

        private b(int i) {
            this.code = (byte) i;
        }

        static b from(byte b) {
            for (b bVar : values()) {
                if (bVar.code == b) {
                    return bVar;
                }
            }
            return UNKNOWN_ERROR;
        }
    }

    static class c {
        public final boolean a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        public final b g;

        c(byte[] bArr) {
            boolean[] f = com.getpebble.android.bluetooth.b.b.f(new byte[]{bArr[0]});
            this.a = f[0];
            this.b = f[1];
            this.c = f[2];
            this.d = f[3];
            this.e = f[4];
            this.f = f[5];
            this.g = b.from(bArr[3]);
        }

        public String toString() {
            return "Connectivity status [connected = " + this.a + ", paired = " + this.b + ", encrypted = " + this.c + ", hasBondedGateway = " + this.d + ", supportsPinningWithoutSlaveSecurity = " + this.e + ", hasRemoteAttemptedToUseStalePairing = " + this.f + ", pairingErrorCode = " + this.g + "]";
        }
    }

    b(BluetoothGatt bluetoothGatt, a aVar) {
        this.c = bluetoothGatt;
        this.d = aVar;
    }

    synchronized void a() {
        BluetoothGattService service = this.c.getService(g.g);
        if (service == null) {
            f.a("ConnectivityWatcher", "subscribe: pairingService is null");
            a(d.NO_PAIRING_SERVICE);
        } else {
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(a);
            if (characteristic == null) {
                f.a("ConnectivityWatcher", "subscribe: connectivityStatusCharacteristic is null");
                a(d.CHARACTERISTIC_SUBSCRIBE);
            } else {
                BluetoothGattDescriptor descriptor = characteristic.getDescriptor(m.e);
                descriptor.setValue(g.i);
                f.d("ConnectivityWatcher", "subscribe: writing to connectivity status descriptor (subscribing to notifications)");
                if (!this.c.writeDescriptor(descriptor)) {
                    f.b("ConnectivityWatcher", "subscribe: !writeDescriptor");
                    a(d.CHARACTERISTIC_SUBSCRIBE);
                } else if (!this.c.setCharacteristicNotification(characteristic, true)) {
                    f.a("ConnectivityWatcher", "subscribe: error subscribing to connectivitySubscribeSuccess");
                    a(d.CHARACTERISTIC_SUBSCRIBE);
                }
            }
        }
    }

    protected synchronized void a(BluetoothGattDescriptor bluetoothGattDescriptor) {
        if (bluetoothGattDescriptor.getCharacteristic().getUuid().equals(a)) {
            this.b = true;
            f.d("ConnectivityWatcher", "onDescriptorWrite (confirmed subscribed)");
            if (bluetoothGattDescriptor.getCharacteristic().getValue() == null) {
                f.d("ConnectivityWatcher", "onDescriptorWrite: value is null");
            } else {
                c cVar = new c(bluetoothGattDescriptor.getCharacteristic().getValue());
                f.d("ConnectivityWatcher", "onDescriptorWrite: " + cVar);
                a(cVar);
            }
        }
    }

    synchronized void a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic.getUuid().equals(a)) {
            c cVar = new c(bluetoothGattCharacteristic.getValue());
            if (this.b) {
                f.d("ConnectivityWatcher", "onCharacteristicChanged: " + cVar);
                a(cVar);
            } else {
                f.d("ConnectivityWatcher", "onCharacteristicChanged before subscribed, so ignoring: " + cVar);
            }
        }
    }

    void a(a aVar) {
        this.d = aVar;
    }

    private void a(c cVar) {
        if (this.d != null) {
            this.d.a(cVar);
        }
    }

    private void a(d dVar) {
        if (this.d != null) {
            this.d.a(dVar);
        }
    }
}
