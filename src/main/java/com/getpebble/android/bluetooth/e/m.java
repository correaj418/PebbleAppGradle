package com.getpebble.android.bluetooth.e;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build.VERSION;
import com.getpebble.android.common.b.a.f;
import com.google.a.f.d;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class m extends BluetoothGattServerCallback implements e {
    static final UUID a = UUID.fromString("10000000-328E-0FBB-C642-1AA6699BDADA");
    static final UUID b = UUID.fromString("10000001-328E-0FBB-C642-1AA6699BDADA");
    static final UUID c = UUID.fromString("10000002-328E-0FBB-C642-1AA6699BDADA");
    static final UUID d = UUID.fromString("10000003-328E-0FBB-C642-1AA6699BDADA");
    static final UUID e = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    protected static final UUID f = UUID.fromString("BADBADBA-DBAD-BADB-ADBA-BADBADBADBAD");
    static final byte[] g = new byte[]{d.a((long) c.minSupportedVersion().version), d.a((long) c.maxSupportedVersion().version), (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1};
    protected BluetoothGattServer h;
    protected Map<String, b> i = new HashMap();
    protected final a j;
    private BluetoothGattCharacteristic k;

    public interface a {
    }

    static class b {
        final k a;
        private final boolean b;
        private boolean c;

        boolean a() {
            return this.b && this.c;
        }

        b(k kVar, boolean z) {
            this.a = kVar;
            this.b = z;
        }
    }

    public m(a aVar) {
        this.j = aVar;
    }

    public synchronized void a(Context context) {
        if (this.h != null) {
            f.d("PPoGServer", "openServer: server is already open");
        } else {
            f.d("PPoGServer", "openServer()");
            BluetoothManager bluetoothManager = (BluetoothManager) context.getApplicationContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                f.a("PPoGServer", "openServer: Manager is null!");
            } else {
                try {
                    this.h = bluetoothManager.openGattServer(context, this);
                    if (this.h == null) {
                        f.a("PPoGServer", "openServer: Error opening gatt server!");
                    } else {
                        BluetoothGattService b = b();
                        b.addCharacteristic(c());
                        this.k = d();
                        this.k.addDescriptor(new BluetoothGattDescriptor(e, 16));
                        b.addCharacteristic(this.k);
                        if (this.h.getService(a) != null) {
                            f.f("PPoGServer", "openServer: service already exists with PPoGATT UUID!! Clearing services");
                            this.h.clearServices();
                        }
                        this.h.addService(b);
                        f.d("PPoGServer", "openServer: added service/characteristics");
                    }
                } catch (Throwable e) {
                    f.a("PPoGServer", "openServer: Exception thrown attempting to open server!", e);
                }
            }
        }
    }

    public synchronized void a() {
        if (this.h == null) {
            f.d("PPoGServer", "closeServer: server is already closed");
        } else {
            f.c("PPoGServer", "closeServer()");
            this.h.clearServices();
            try {
                this.h.close();
            } catch (Throwable e) {
                f.a("PPoGServer", "closeServer: error closing server", e);
            }
            this.h = null;
        }
    }

    public synchronized void a(k kVar, Context context) {
        if (this.h == null) {
            f.c("PPoGServer", "registerConnection: server not open; opening...");
            a(context);
        }
        if (this.i.containsKey(kVar.h().getAddress())) {
            throw new IllegalStateException(kVar.h() + " is already registered!");
        }
        f.d("PPoGServer", "registerConnection: " + kVar.h());
        this.i.put(kVar.h().getAddress(), new b(kVar, f()));
    }

    public synchronized void a(k kVar) {
        String address = kVar.h().getAddress();
        if (this.i.containsKey(address)) {
            f.d("PPoGServer", "unregisterConnection: " + address);
            this.i.remove(address);
            if (this.h == null) {
                f.d("PPoGServer", "unregisterConnection: mGattServer is null");
            } else {
                this.h.cancelConnection(kVar.i().d());
            }
        } else {
            f.d("PPoGServer", "unregisterConnection: no registered connection for " + address + ", so ignoring");
        }
    }

    protected BluetoothGattService b() {
        return new BluetoothGattService(a, 0);
    }

    protected BluetoothGattCharacteristic c() {
        return new BluetoothGattCharacteristic(c, 2, 2);
    }

    protected BluetoothGattCharacteristic d() {
        return new BluetoothGattCharacteristic(b, 20, 32);
    }

    protected void e() {
        if (this.h == null) {
            f.d("PPoGServer", "padPPoGattWithFakeService: gatt server is null");
        } else if (this.h.getService(a) == null) {
            f.d("PPoGServer", "padPPoGattWithFakeService: Haven't added PPoGATT service yet!");
        } else {
            f.d("PPoGServer", "padPPoGattWithFakeService: Adding fake service...");
            BluetoothGattService bluetoothGattService = new BluetoothGattService(f, 0);
            bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(f, 2, 1));
            this.h.addService(bluetoothGattService);
        }
    }

    public synchronized void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte[] bArr) {
        b bVar = (b) this.i.get(bluetoothDevice.getAddress());
        if (bVar == null) {
            f.b("PPoGServer", "onCharacteristicWriteRequest: for unregistered device " + bluetoothDevice.getAddress());
        } else if (this.h == null) {
            f.d("PPoGServer", "onCharacteristicWriteRequest: gatt server is null");
        } else {
            a(bluetoothDevice, i, bluetoothGattCharacteristic, z, z2, i2, bArr, bVar);
        }
    }

    protected void a(BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte[] bArr, b bVar) {
        if (bluetoothGattCharacteristic.getUuid().equals(b)) {
            try {
                bVar.a.a(new l(bArr));
                return;
            } catch (Throwable e) {
                f.b("PPoGServer", "onCharacteristicWriteRequest: error decoding packet: " + com.getpebble.android.bluetooth.b.b.c(bArr), e);
                bVar.a.a(com.getpebble.android.bluetooth.b.d.GATT_SERVER);
                return;
            }
        }
        f.d("PPoGServer", "onCharacteristicWriteRequest: unknown characteristic UUID: " + bluetoothGattCharacteristic.getUuid());
    }

    public synchronized void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2) {
        d fromCode = d.fromCode(i);
        c fromCode2 = c.fromCode(i2);
        if (d.GATT_SUCCESS.equals(fromCode)) {
            f.d("PPoGServer", "onConnectionStateChange: (may be disconn. event of no consequence) device = " + bluetoothDevice.getAddress() + " status = " + fromCode + " connectionState = " + fromCode2);
        } else {
            f.b("PPoGServer", "onConnectionStateChange: (failure) device = " + bluetoothDevice.getAddress() + " status = " + fromCode + " connectionState = " + fromCode2);
        }
        if (!fromCode2.equals(c.STATE_CONNECTED)) {
            b bVar = (b) this.i.get(bluetoothDevice.getAddress());
            if (bVar != null) {
                bVar.a.b(i);
            }
        }
    }

    public synchronized void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        b bVar = (b) this.i.get(bluetoothDevice.getAddress());
        if (bVar == null) {
            f.b("PPoGServer", "onCharacteristicReadRequest: for unregistered device " + bluetoothDevice.getAddress());
        } else if (this.h == null) {
            f.d("PPoGServer", "onCharacteristicReadRequest: gatt server is null");
        } else {
            a(bluetoothDevice, i, i2, bluetoothGattCharacteristic, bVar);
        }
    }

    protected void a(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic, b bVar) {
        if (bluetoothGattCharacteristic.getUuid().equals(c)) {
            f.e("PPoGServer", "onCharacteristicReadRequest: is PP meta characteristic - sending response...");
            if (!this.h.sendResponse(bluetoothDevice, i, 0, i2, g)) {
                f.a("PPoGServer", "onCharacteristicReadRequest: error sending response!");
                bVar.a.a(com.getpebble.android.bluetooth.b.d.GATT_SERVER);
            }
        }
    }

    public synchronized void onDescriptorWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z, boolean z2, int i2, byte[] bArr) {
        b bVar = (b) this.i.get(bluetoothDevice.getAddress());
        if (bVar == null) {
            f.b("PPoGServer", "onDescriptorWriteRequest: for unregistered device " + bluetoothDevice.getAddress());
        } else if (this.h == null) {
            f.d("PPoGServer", "onDescriptorWriteRequest: gatt server is null");
        } else {
            a(bluetoothDevice, i, bluetoothGattDescriptor, z, z2, i2, bArr, bVar);
        }
    }

    protected void a(BluetoothDevice bluetoothDevice, int i, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z, boolean z2, int i2, byte[] bArr, b bVar) {
        if (bluetoothGattDescriptor.getCharacteristic().getUuid().equals(b)) {
            boolean a = a(bArr[0]);
            f.d("PPoGServer", "onDescriptorWriteRequest: notifications enabled = " + a);
            bVar.a.a(a);
            if (!this.h.sendResponse(bluetoothDevice, i, 0, i2, bArr)) {
                f.a("PPoGServer", "onDescriptorWriteRequest: error sending response!");
                bVar.a.a(com.getpebble.android.bluetooth.b.d.GATT_SERVER);
            }
        }
    }

    public synchronized void onServiceAdded(int i, BluetoothGattService bluetoothGattService) {
        d fromCode = d.fromCode(i);
        f.d("PPoGServer", "onServiceAdded: status = " + fromCode + " service = " + bluetoothGattService.getUuid());
        if (bluetoothGattService.getUuid().equals(a) && fromCode.equals(d.GATT_SUCCESS)) {
            e();
        }
    }

    static boolean a(byte b) {
        return (b & 1) > 0;
    }

    public synchronized boolean a(com.getpebble.android.bluetooth.j.b bVar, byte[] bArr) {
        boolean z;
        b bVar2 = (b) this.i.get(bVar.a());
        if (bVar2 == null) {
            f.b("PPoGServer", "sendBytesToDevice: can't send a message to device " + bVar.a() + "; not registered with us!");
            throw new IllegalStateException("Can't send message to an unregistered device");
        } else if (bVar2.a()) {
            z = false;
        } else {
            z = a(bVar2, bVar, bArr);
        }
        return z;
    }

    protected boolean a(b bVar, com.getpebble.android.bluetooth.j.b bVar2, byte[] bArr) {
        if (this.h == null) {
            f.d("PPoGServer", "sendNotificationToDevice: gatt server is null");
            return false;
        }
        this.k.setValue(bArr);
        try {
            boolean notifyCharacteristicChanged = this.h.notifyCharacteristicChanged(bVar2.d(), this.k, false);
            if (notifyCharacteristicChanged) {
                bVar.c = true;
            }
            return notifyCharacteristicChanged;
        } catch (Throwable e) {
            f.a("PPoGServer", "sendNotificationToDevice: NPE inside stack!", e);
            return false;
        }
    }

    protected boolean f() {
        return VERSION.SDK_INT >= 21;
    }

    public synchronized void onNotificationSent(BluetoothDevice bluetoothDevice, int i) {
        d fromCode = d.fromCode(i);
        if (!fromCode.equals(d.GATT_SUCCESS)) {
            f.c("PPoGServer", "onNotificationSent: gattStatus = " + fromCode);
        }
        b bVar = (b) this.i.get(bluetoothDevice.getAddress());
        if (bVar == null) {
            f.b("PPoGServer", "onNotificationSent: device " + bluetoothDevice.getAddress() + "; not registered with us!!");
        } else {
            bVar.c = false;
            a(bVar);
        }
    }

    protected void a(b bVar) {
        bVar.a.j();
    }
}
