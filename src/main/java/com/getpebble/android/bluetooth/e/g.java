package com.getpebble.android.bluetooth.e;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.b.d;
import com.getpebble.android.bluetooth.c;
import com.getpebble.android.bluetooth.d.h;
import com.getpebble.android.bluetooth.e;
import com.getpebble.android.bluetooth.i;
import com.getpebble.android.bluetooth.j.b;
import com.getpebble.android.common.b.a.f;
import java.io.UnsupportedEncodingException;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class g extends c implements com.getpebble.android.bluetooth.e.a.a, com.getpebble.android.bluetooth.e.b.a, com.getpebble.android.bluetooth.e.i.a, a, a {
    static final UUID g = UUID.fromString("0000fed9-0000-1000-8000-00805f9b34fb");
    static final UUID h = UUID.fromString("00000002-328E-0FBB-C642-1AA6699BDADA");
    static final byte[] i = new byte[]{(byte) 1, (byte) 0};
    private static final long v = TimeUnit.SECONDS.toMillis(40);
    private static final long w = TimeUnit.SECONDS.toMillis(1);
    private boolean A = false;
    private ByteBuffer B;
    private final com.getpebble.android.bluetooth.d.a C;
    private final m D;
    private final i E;
    private boolean F;
    private c G;
    private final String H;
    private int I;
    private a J;
    private Boolean K = null;
    private final Runnable L = new Runnable(this) {
        final /* synthetic */ g a;

        {
            this.a = r1;
        }

        public void run() {
            this.a.p();
        }
    };
    protected BluetoothGatt j;
    protected k k;
    protected a l = a.DISCONNECTED_IDLE;
    protected com.getpebble.android.bluetooth.g.a.a m;
    protected d n;
    protected LeScanCallback o;
    protected boolean p = false;
    protected String q;
    protected a r;
    protected i s;
    protected b t;
    protected j u;
    private final Handler x;
    private n y;
    private final h z;

    public enum a {
        DISCONNECTED_IDLE,
        WAITING_FOR_CONNECTION,
        WAITING_FOR_SDP,
        CONNECTION_PARAMS,
        NEGOTIATING_MTU,
        SUBSCRIBING_CONNECTIVITY,
        PP_GATT_CLIENT,
        PAIRED,
        PAIRING,
        DISCONNECTING,
        LINK_ESTABLISHED,
        SCANNING
    }

    public static g a(PebbleDevice pebbleDevice, e eVar, Context context, com.getpebble.android.bluetooth.j.a aVar, com.getpebble.android.bluetooth.d.a aVar2, m mVar, i iVar, h hVar, String str) {
        return new g(pebbleDevice, aVar.a(pebbleDevice.getAddress()), eVar, context, aVar, hVar, aVar2, mVar, iVar, str);
    }

    g(PebbleDevice pebbleDevice, b bVar, e eVar, Context context, com.getpebble.android.bluetooth.j.a aVar, h hVar, com.getpebble.android.bluetooth.d.a aVar2, m mVar, i iVar, String str) {
        super(pebbleDevice, bVar, eVar, context, aVar);
        this.z = hVar;
        this.x = new Handler(Looper.getMainLooper());
        this.C = aVar2;
        this.E = iVar;
        this.D = mVar;
        this.H = str;
    }

    protected void a(Runnable runnable) {
        this.x.post(runnable);
    }

    protected void a(a aVar) {
        if (this.l.equals(aVar)) {
            f.d("LeDeviceConnector", "setState: already in " + aVar);
            return;
        }
        q();
        f.d("LeDeviceConnector", "setState: " + this.l + " -> " + aVar);
        if (aVar.equals(a.DISCONNECTED_IDLE) && this.J == null) {
            this.J = this.l;
        }
        this.l = aVar;
        if (this.l.equals(a.PAIRED) && this.A) {
            f.d("LeDeviceConnector", "PAIRED and mLinkAlreadyEstablished; calling onLinkEstablished() again...");
            a(new Runnable(this) {
                final /* synthetic */ g a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.a_();
                }
            });
        } else if (this.l.equals(a.DISCONNECTED_IDLE)) {
            if (this.m == null) {
                f.d("LeDeviceConnector", "setState: Defaulting connection result to NOT_AVAILABLE");
                this.m = com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE;
            }
            if (this.n == null) {
                f.d("LeDeviceConnector", "setState: Defaulting connection failure reason to DISCONNECTED");
                this.n = d.DISCONNECTED;
            }
            a(new com.getpebble.android.bluetooth.g.a(this.m, this.n, this.q, this.I, this.J, this.K));
        } else if (!this.l.equals(a.LINK_ESTABLISHED)) {
            r();
        }
    }

    protected synchronized void e() {
        f.d("LeDeviceConnector", "cleanup()");
        q();
        this.E.a(this.F);
        Boolean b = b.b(this.a.k());
        if (b != null && b.booleanValue()) {
            f.b("LeDeviceConnector", "cleanup: device is still connected?");
        }
        if (this.k != null) {
            this.k.g();
        }
        if (this.j != null) {
            this.j.disconnect();
            a(new Runnable(this) {
                final /* synthetic */ g a;

                {
                    this.a = r1;
                }

                public void run() {
                    BluetoothGatt bluetoothGatt = this.a.j;
                    if (bluetoothGatt != null) {
                        bluetoothGatt.close();
                    }
                }
            });
        }
        if (this.o != null) {
            this.b.b(this.o);
        }
    }

    public synchronized void f() {
        a(com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE, d.CANCELLED);
    }

    protected synchronized void a(com.getpebble.android.bluetooth.g.a.a aVar, d dVar) {
        if (this.m == null) {
            this.m = aVar;
        }
        if (this.n == null) {
            this.n = dVar;
        }
        this.J = this.l;
        if (this.l.equals(a.SCANNING)) {
            f.d("LeDeviceConnector", "cancelConnection: SCANNING; stopping scan and marking as disconnected");
            this.b.b(this.o);
            a(a.DISCONNECTED_IDLE);
        } else if (this.l.equals(a.DISCONNECTED_IDLE) || this.l.equals(a.DISCONNECTING)) {
            f.d("LeDeviceConnector", "internalDisconnect: already " + this.l);
        } else {
            if (this.j == null) {
                f.f("LeDeviceConnector", "cancelConnection: mGatt is null! Should not happen in this state! (" + this.l + ")");
            } else {
                f.d("LeDeviceConnector", "cancelConnection: calling disconnect()");
                this.j.disconnect();
            }
            a(a.DISCONNECTING);
        }
    }

    public void g() {
        a(new Runnable(this) {
            final /* synthetic */ g a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.t();
            }
        });
    }

    protected void j() {
        this.B = ByteBuffer.allocate(100);
    }

    private synchronized void t() {
        f.d("LeDeviceConnector", "startConnection()");
        if (this.l.equals(a.DISCONNECTED_IDLE)) {
            j();
            this.K = b.b(this.a.k());
            if (this.K != null && this.K.booleanValue()) {
                f.b("LeDeviceConnector", "startConnection: device is already connected?");
            }
            this.C.c();
            if (k()) {
                o();
            } else {
                l();
            }
        } else {
            f.b("LeDeviceConnector", "startConnection: not idle! - " + this.l);
        }
    }

    protected boolean k() {
        return this.z.a() || this.E.c();
    }

    protected synchronized void l() {
        this.y = m();
        this.j = this.a.a(this.y, this.f);
        if (this.j == null) {
            f.b("LeDeviceConnector", "requestGattConnection: mGatt is null");
            a(new com.getpebble.android.bluetooth.g.a(com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE, d.NO_GATT));
        } else {
            this.s = new i(this.j, this.z, this, h());
            this.r = new a(this.j, this.z, this);
            this.t = new b(this.j, this);
            if (this.z.i()) {
                this.u = new j(this.j, true);
            }
            try {
                this.k = a(this.z.i() ? this.u : this.D);
                a(a.WAITING_FOR_CONNECTION);
            } catch (Throwable e) {
                f.f("LeDeviceConnector", "startConnection: error creating PPoGATT!", e);
                a(new com.getpebble.android.bluetooth.g.a(com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE, d.PPoGATT));
            }
        }
    }

    protected n m() {
        return new n(this, this.d);
    }

    protected synchronized void c() {
        f.d("LeDeviceConnector", "onDeviceBonded; waiting for watch...");
        if (!this.l.equals(a.PAIRING)) {
            f.c("LeDeviceConnector", "onConnectionStateChange while not WAITING_FOR_CONNECTION");
        } else if (this.z.i()) {
            n();
        } else {
            b("WAITING FOR WATCH");
            a(a.PAIRED);
        }
    }

    private void b(final String str) {
        com.getpebble.android.bluetooth.b.c.a(new Runnable(this) {
            final /* synthetic */ g b;

            public void run() {
                com.getpebble.android.bluetooth.h.b.a(this.b.d, str);
            }
        });
    }

    protected void n() {
        try {
            this.u.a();
            a(a.PP_GATT_CLIENT);
        } catch (Throwable e) {
            f.a("LeDeviceConnector", "initPpGattClient: error subscribing", e);
            a(com.getpebble.android.bluetooth.g.a.a.NOT_BONDED, d.PP_GATT_CLIENT);
        }
    }

    protected synchronized void d() {
        f.b("LeDeviceConnector", "onDeviceUnbonded: disconnecting");
        a(com.getpebble.android.bluetooth.g.a.a.NOT_BONDED, d.BONDING_FAILED_IMPLICIT);
    }

    public synchronized void a(c cVar, d dVar, int i) {
        this.I = i;
        if (dVar.equals(d.GATT_ERROR)) {
            if (this.E.d() + 1 >= 3) {
                this.n = d.DISCONNECTED_MULTIPLE_GATT_ERROR;
            }
            this.F = true;
        }
        if (!cVar.equals(c.STATE_CONNECTED)) {
            f.c("LeDeviceConnector", "onConnectionStateChange: !STATE_CONNECTED: " + cVar);
            if (dVar.equals(d.GATT_UNKNOWN_0X16)) {
                f.a("LeDeviceConnector", "onConnectionStateChange: PBL-40058 unexpected GattStatus (0x16)");
            }
            if (this.n == null) {
                this.n = d.DISCONNECTED;
            }
            a(a.DISCONNECTED_IDLE);
        } else if (!dVar.equals(d.GATT_SUCCESS)) {
            f.c("LeDeviceConnector", "onConnectionStateChange !GATT_SUCCESS: " + dVar);
            a(com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE, d.STATUS);
        } else if (this.l.equals(a.WAITING_FOR_CONNECTION)) {
            b("NEGOTIATING");
            f.d("LeDeviceConnector", "onConnectionStateChange: Connected; starting SDP discovery");
            if (this.j.discoverServices()) {
                a(a.WAITING_FOR_SDP);
            } else {
                f.b("LeDeviceConnector", "onConnectionStateChange: !sdpRes");
                a(com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE, d.SDP_FAILED);
            }
        } else {
            f.c("LeDeviceConnector", "onConnectionStateChange: while not WAITING_FOR_CONNECTION");
        }
    }

    public synchronized void a(final int i) {
        f.d("LeDeviceConnector", "onServerDisconnected: posting to mark disconnected in " + w + " ms");
        this.x.postDelayed(new Runnable(this) {
            final /* synthetic */ g b;

            public void run() {
                this.b.c(i);
            }
        }, w);
    }

    synchronized void c(int i) {
        f.c("LeDeviceConnector", "onServerDisconnectedDebounced()");
        if (this.n == null) {
            this.I = i;
            this.n = d.DISCONNECTED;
        }
        a(a.DISCONNECTED_IDLE);
    }

    protected void o() {
        this.o = new LeScanCallback(this) {
            final /* synthetic */ g a;

            {
                this.a = r1;
            }

            public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                this.a.a(bluetoothDevice, bArr);
            }
        };
        if (this.b.a(this.o)) {
            a(a.SCANNING);
            return;
        }
        f.d("LeDeviceConnector", "startScan: failed to start");
        this.b.b(this.o);
        a(new com.getpebble.android.bluetooth.g.a(com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE, d.SCAN_START));
    }

    protected synchronized void a(BluetoothDevice bluetoothDevice, byte[] bArr) {
        try {
            a(bluetoothDevice, new com.getpebble.android.bluetooth.d.g(h.a(bArr)).d);
        } catch (UnsupportedEncodingException e) {
        } catch (BufferUnderflowException e2) {
        } catch (com.getpebble.android.bluetooth.d.g.b e3) {
        }
    }

    protected synchronized void a(BluetoothDevice bluetoothDevice, String str) {
        if (!this.l.equals(a.SCANNING)) {
            this.b.b(this.o);
            f.e("LeDeviceConnector", "onScanResult: not in SCANNING state");
        } else if (str.equals(this.H)) {
            f.d("LeDeviceConnector", "onLeScan: found serial match; address = " + bluetoothDevice.getAddress());
            this.b.b(this.o);
            if (this.d.getAddress().equals(bluetoothDevice.getAddress())) {
                l();
            } else {
                f.c("LeDeviceConnector", "onLeScan: address changed from " + this.d.getAddress() + " to " + bluetoothDevice.getAddress() + "!!");
                this.p = true;
                this.q = bluetoothDevice.getAddress();
                this.n = d.ADDRESS_CHANGED;
                a(a.DISCONNECTED_IDLE);
            }
        }
    }

    protected k a(e eVar) {
        return new k(this, this.d, 23, this.a, this.z, eVar, this.f);
    }

    public synchronized void i() {
        if (!this.l.equals(a.WAITING_FOR_SDP)) {
            f.c("LeDeviceConnector", "onServicesDiscovered while not WAITING_FOR_SDP");
        } else if (this.r.a()) {
            a(a.CONNECTION_PARAMS);
            this.r.b();
        } else {
            f.c("LeDeviceConnector", "onServicesDiscovered: !hasParamsCharacteristic (expected on older FW)");
            a(a.NEGOTIATING_MTU);
            this.s.a();
        }
    }

    public synchronized void a(BluetoothGattCharacteristic bluetoothGattCharacteristic, d dVar) {
        if (!dVar.equals(d.GATT_SUCCESS)) {
            a(com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE, d.STATUS);
        } else if (bluetoothGattCharacteristic.getUuid().equals(h)) {
            f.d("LeDeviceConnector", "got pairing trigger read OK");
        }
    }

    public synchronized void a(BluetoothGattDescriptor bluetoothGattDescriptor) {
        this.s.a(bluetoothGattDescriptor);
        this.t.a(bluetoothGattDescriptor);
        if (bluetoothGattDescriptor.getCharacteristic().getUuid().equals(a.a)) {
            this.r.c();
        }
    }

    public synchronized void a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.r.a(bluetoothGattCharacteristic);
        this.s.b(bluetoothGattCharacteristic);
        this.t.a(bluetoothGattCharacteristic);
        if (this.u != null) {
            this.u.b(bluetoothGattCharacteristic);
        }
    }

    static byte[] a(boolean z, boolean z2, boolean z3) {
        boolean[] zArr = new boolean[5];
        zArr[0] = true;
        zArr[1] = z;
        zArr[3] = z2;
        zArr[4] = z3;
        return com.getpebble.android.bluetooth.b.b.a(zArr);
    }

    protected synchronized void b(c cVar) {
        BluetoothGattService service = this.j.getService(g);
        if (service == null) {
            f.a("LeDeviceConnector", "doPairingAndPinning: pairingService is null");
            a(com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE, d.NO_PAIRING_SERVICE);
        } else {
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(h);
            if (characteristic == null) {
                f.a("LeDeviceConnector", "doPairingAndPinning: pairingTriggerCharacteristic is null");
                a(com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE, d.NO_PAIRING_CHARACTERISTIC);
            } else {
                a(this.d.getAddress());
                boolean z = true;
                if ((characteristic.getProperties() & 8) > 0) {
                    z = cVar.e;
                    f.d("LeDeviceConnector", "Using characteristic write for pairing/pinning trigger: mSupportsPinningWithoutSlaveSecurity = " + cVar.e);
                    characteristic.setValue(a(cVar.e, this.z.h(), this.z.i()));
                    if (!this.j.writeCharacteristic(characteristic)) {
                        f.c("LeDeviceConnector", "doPairingAndPinning: !pinRequestSuccess; aborting");
                        a(com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE, d.FAILED_CHARACTERISTIC_READ);
                    }
                }
                if (z) {
                    try {
                        f.d("LeDeviceConnector", "Using createBond");
                        if (!this.a.f()) {
                            f.c("LeDeviceConnector", "doPairingAndPinning: !pairingTriggerSuccess; aborting");
                            a(com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE, d.BONDING_FAILED_CREATE_BOND);
                        }
                    } catch (Throwable e) {
                        f.b("LeDeviceConnector", "Error calling createBond()", e);
                        a(com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE, d.BONDING_FAILED_INIT);
                    }
                }
                a(a.PAIRING);
            }
        }
    }

    public synchronized void b(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        UUID uuid = bluetoothGattCharacteristic.getUuid();
        if (uuid.equals(h)) {
            f.d("LeDeviceConnector", "got pairing trigger write OK");
        } else if (uuid.equals(a.a)) {
            this.r.d();
        }
        this.s.a(bluetoothGattCharacteristic);
        if (this.u != null) {
            this.u.a(bluetoothGattCharacteristic);
        }
    }

    public synchronized void b(int i) {
        if (this.l.equals(a.NEGOTIATING_MTU)) {
            f.d("LeDeviceConnector", "onMtuChanged: " + i);
            a(a.SUBSCRIBING_CONNECTIVITY);
            this.t.a();
            this.k.a(i);
            this.k.a();
        } else {
            f.c("LeDeviceConnector", "onMtuChanged while not NEGOTIATING_MTU (" + this.l + ")");
        }
    }

    protected synchronized void p() {
        f.b("LeDeviceConnector", "Timeout runnable firing while in state " + this.l);
        if (this.l.equals(a.PAIRED) && this.G != null) {
            if (this.G.c) {
                this.n = d.NO_PPOG_CONNECTION_HAS_ENCRYPTION;
            } else {
                this.n = d.NO_PPOG_CONNECTION_NO_ENCRYPTION;
            }
        }
        if (this.l.equals(a.DISCONNECTING)) {
            f.a("LeDeviceConnector", "onTimeout: while waiting for disconnection: marking as disconnected!!");
            this.n = d.GATT_TIMEOUT;
            a(a.DISCONNECTED_IDLE);
        } else if (this.l.equals(a.SCANNING)) {
            this.b.b(this.o);
            f.a("LeDeviceConnector", "onTimeout: while waiting for scan: marking as disconnected!!");
            this.n = d.GATT_TIMEOUT;
            a(a.DISCONNECTED_IDLE);
        } else {
            a(com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE, d.GATT_TIMEOUT);
        }
    }

    protected void q() {
        this.x.removeCallbacks(this.L);
    }

    protected void r() {
        this.x.postDelayed(this.L, v);
    }

    public synchronized void c(byte[] bArr) {
        f.c("LeDeviceConnector", "onBytesReceived: queueing " + bArr.length + " bytes to pass to LeConnectionManager later...");
        try {
            this.B.put(bArr);
        } catch (BufferOverflowException e) {
            f.a("LeDeviceConnector", "onBytesReceived: overflow queueing PP bytes");
            a(com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE, d.QUEUE_OVERFLOW);
        }
    }

    public synchronized void a_() {
        if (this.l.equals(a.DISCONNECTED_IDLE) || this.l.equals(a.DISCONNECTING) || this.l.equals(a.LINK_ESTABLISHED)) {
            f.b("LeDeviceConnector", "onLinkEstablished: ignoring in state " + this.l);
        } else if (this.l.equals(a.PAIRED) || this.l.equals(a.PP_GATT_CLIENT)) {
            try {
                com.getpebble.android.bluetooth.f s = s();
                a(a.LINK_ESTABLISHED);
                if (this.B.position() > 0) {
                    byte[] bArr = new byte[this.B.position()];
                    this.B.position(0);
                    this.B.get(bArr);
                    f.d("LeDeviceConnector", "onLinkEstablished: forwarding " + bArr.length + " bytes to connection manager");
                    s.c(bArr);
                }
                this.E.a(false);
                a(s);
            } catch (Throwable e) {
                f.a("LeDeviceConnector", "onLinkEstablished: error creating LeConnectionManager!", e);
                a(com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE, d.CREATE_PIPES);
            }
        } else {
            f.c("LeDeviceConnector", "onLinkEstablished: before state PAIRED: " + this.l + " - waiting for SDP/subscriptions to complete");
            this.A = true;
        }
    }

    public synchronized void b_() {
        if (this.l.equals(a.CONNECTION_PARAMS)) {
            f.d("LeDeviceConnector", "onParamsCompleted()");
            a(a.NEGOTIATING_MTU);
            this.s.a();
        } else {
            f.b("LeDeviceConnector", "onParamsCompleted: not expected in state " + this.l + "; ignoring...");
        }
    }

    public synchronized void a(c cVar) {
        this.G = cVar;
        if (cVar.g.equals(b.CONFIRM_VALUE_FAILED)) {
            if (this.l.equals(a.PAIRING)) {
                f.b("LeDeviceConnector", "onConnectivityChange: pairing error code " + cVar.g + " needs BT reset to fix!");
                a(com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE, d.BONDING_FAILED_WRONG_CONFIRM);
            } else {
                f.b("LeDeviceConnector", "onConnectivityChange: pairing error code " + cVar.g + " but not in state PAIRING, so not taking action right now");
            }
        }
        if (this.l.equals(a.SUBSCRIBING_CONNECTIVITY)) {
            if (cVar.b) {
                if (!this.a.h()) {
                    f.b("LeDeviceConnector", "onConnectivityDescriptorWrite: Watch is paired, but phone is not. Request re-pairing..");
                } else if (this.z.i()) {
                    n();
                } else {
                    f.d("LeDeviceConnector", "onConnectivityDescriptorWrite: pairing = OK! Waiting for watch...");
                    b("WAITING FOR WATCH");
                    a(a.PAIRED);
                }
            } else if (this.a.h()) {
                f.b("LeDeviceConnector", "onConnectivityDescriptorWrite: Phone is bonded, watch is not; removing bond");
                this.a.j();
            }
            f.d("LeDeviceConnector", "onConnectivityDescriptorWrite: Not paired; attempt pairing");
            b(cVar);
        } else {
            f.b("LeDeviceConnector", "onParamsCompleted: not expected in state " + this.l + "; ignoring...");
        }
    }

    public void a(d dVar) {
        a(com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE, dVar);
    }

    protected f s() {
        return f.a(this.d, this.e, this.k, this.j, this.y, this.z, this.a, this.r, this.t, this.u, this.D);
    }
}
