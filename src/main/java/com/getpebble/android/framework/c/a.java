package com.getpebble.android.framework.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.os.Looper;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.b.c;
import com.getpebble.android.b.d;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.h;
import com.getpebble.android.common.b.a.a.f;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.au;
import com.getpebble.android.framework.g.n;
import java.util.List;

public class a extends c implements com.getpebble.android.framework.g.n.b {

    private class a extends b {
        final /* synthetic */ a e;
        private com.getpebble.android.framework.b.a f;

        private a(a aVar, PebbleDevice pebbleDevice) {
            this.e = aVar;
            super(aVar, pebbleDevice);
            this.f = com.getpebble.android.framework.b.a.a(aVar.g, pebbleDevice);
        }

        protected void a(a aVar) {
            if (aVar == a.DISCONNECTED) {
                this.e.j(this.a);
                f.a(this.a, this.e.h);
            } else if (aVar == a.CONNECTED) {
                this.e.i(this.a);
                f.a(this.a, this.c);
            } else if (aVar == a.CONNECTED_PRF) {
                this.e.k(this.a);
                f.a(this.a, this.c);
            }
            super.a(aVar);
        }
    }

    public static class b implements c.c {
        private final ContentResolver a;

        public b(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        public void a(PebbleDevice pebbleDevice, d dVar) {
            ContentValues contentValues = new ContentValues(2);
            contentValues.put(ak.CONNECTION_STATUS, Integer.valueOf(dVar.getIntValue()));
            if (dVar == d.CONNECTED) {
                contentValues.put(ak.LAST_CONNECTED_TIME, Long.valueOf(System.currentTimeMillis()));
                com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
                if (!(p == null || p.pebbleDevice.equals(pebbleDevice))) {
                    com.getpebble.android.common.b.a.f.d("FrameworkConnectionStateManager", "Resetting fw nag timeout because connecting to a different device");
                    PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.FIRMWARE_NAG_TIME, 0);
                    PebbleApplication.v().c();
                }
            }
            if (!ak.updateDevice(this.a, pebbleDevice, contentValues)) {
                com.getpebble.android.common.b.a.f.f("FrameworkConnectionStateManager", "onConnectionStatusUpdated: Failed to update device status in database / " + pebbleDevice + " / " + dVar);
            }
        }

        public void a(PebbleDevice pebbleDevice, com.getpebble.android.b.a aVar) {
            ContentValues contentValues = new ContentValues(1);
            contentValues.put(ak.CONNECTION_GOAL, Integer.valueOf(aVar.getIntValue()));
            ak.updateDevice(this.a, pebbleDevice, contentValues);
        }
    }

    public a(Looper looper, Context context, h.c cVar, com.getpebble.android.bluetooth.h.a aVar, h.h hVar, c.c cVar2) {
        super(looper, context, cVar, aVar, hVar, cVar2, "app");
    }

    protected void b() {
        ak.setAllDevicesDisconnected(d().getContentResolver());
        List<com.getpebble.android.common.model.ak.a> pebbleDeviceRecords = ak.getPebbleDeviceRecords(d().getContentResolver(), com.getpebble.android.common.model.ak.b.CONNECTION_GOAL_CONNECT);
        if (pebbleDeviceRecords != null) {
            for (com.getpebble.android.common.model.ak.a aVar : pebbleDeviceRecords) {
                e(aVar.pebbleDevice);
            }
        }
    }

    protected b d(PebbleDevice pebbleDevice) {
        return new a(pebbleDevice);
    }

    private void j(PebbleDevice pebbleDevice) {
        a l = l(pebbleDevice);
        if (l == null) {
            com.getpebble.android.common.b.a.f.a("FrameworkConnectionStateManager", "actionRemoveEndpointSet() device state not found! device = " + pebbleDevice);
            return;
        }
        com.getpebble.android.common.b.a.f.d("FrameworkConnectionStateManager", "actionRemoveEndpointSet: " + pebbleDevice);
        l.f.b(null);
    }

    protected void i(PebbleDevice pebbleDevice) {
        a l = l(pebbleDevice);
        if (l == null) {
            com.getpebble.android.common.b.a.f.a("FrameworkConnectionStateManager", "actionDefaultEndpointSet() device state not found! device = " + pebbleDevice);
            return;
        }
        com.getpebble.android.common.b.a.f.d("FrameworkConnectionStateManager", "actionDefaultEndpointSet: " + pebbleDevice);
        l.f.a(d());
    }

    private void k(PebbleDevice pebbleDevice) {
        a l = l(pebbleDevice);
        if (l == null) {
            com.getpebble.android.common.b.a.f.a("FrameworkConnectionStateManager", "actionPrfEndpointSet() device state not found! device = " + pebbleDevice);
            return;
        }
        com.getpebble.android.common.b.a.f.d("FrameworkConnectionStateManager", "actionPrfEndpointSet: " + pebbleDevice);
        l.f.b(d());
    }

    private a l(PebbleDevice pebbleDevice) {
        return (a) this.b.get(pebbleDevice);
    }

    protected String h(PebbleDevice pebbleDevice) {
        return ak.getPebbleDeviceRecord(this.e.getContentResolver(), pebbleDevice).serialNumber;
    }

    protected void a(b bVar) {
        a aVar = (a) bVar;
        aVar.f.b(a(aVar.f, d(), (com.getpebble.android.framework.g.n.b) this));
    }

    n a(com.getpebble.android.framework.b.a aVar, Context context, com.getpebble.android.framework.g.n.b bVar) {
        return new n(aVar, context, bVar);
    }

    protected void a(PebbleDevice pebbleDevice, com.getpebble.android.bluetooth.g.a aVar, boolean z) {
        a l = l(pebbleDevice);
        PebbleDevice pebbleDevice2 = pebbleDevice;
        boolean z2 = z;
        f.a(pebbleDevice2, aVar.b, l.c, this.h, f(), z2, ak.hasDeviceEverConnected(this.e.getContentResolver(), pebbleDevice), aVar.d, aVar.e, aVar.f);
    }

    protected void a(PebbleDevice pebbleDevice, String str) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(ak.ADDRESS, str);
        com.getpebble.android.common.b.a.f.c("FrameworkConnectionStateManager", "onDeviceConnectionResult: updating address of " + pebbleDevice + " in database to " + str);
        ak.updateDevice(com.getpebble.android.common.a.K().getContentResolver(), pebbleDevice, contentValues);
        a l = l(pebbleDevice);
        l.f = com.getpebble.android.framework.b.a.a(this.g, l.a);
    }

    protected void a(com.getpebble.android.b.a aVar) {
        if (aVar.equals(com.getpebble.android.b.a.CONNECT)) {
            au.a(com.getpebble.android.common.model.au.a.UNEXPECTED_DISCONNECT, this.e.getContentResolver());
        } else {
            au.a(com.getpebble.android.common.model.au.a.EXPECTED_DISCONNECT, this.e.getContentResolver());
        }
    }

    public synchronized void a(PebbleDevice pebbleDevice, boolean z, boolean z2, com.getpebble.android.bluetooth.b.d dVar) {
        boolean z3 = true;
        synchronized (this) {
            a l = l(pebbleDevice);
            if (l == null) {
                com.getpebble.android.common.b.a.f.a("FrameworkConnectionStateManager", "handshakeResult: Device state not found! device = " + pebbleDevice);
            } else if (l.b != a.HANDSHAKE_INITIATED) {
                com.getpebble.android.common.b.a.f.b("FrameworkConnectionStateManager", "Handshake result received when not expected for " + pebbleDevice);
            } else {
                com.getpebble.android.common.b.a.f.d("FrameworkConnectionStateManager", "Handshake result for " + pebbleDevice + " success = " + z);
                if (z) {
                    l.a(z2 ? a.CONNECTED_PRF : a.CONNECTED);
                    this.i = false;
                    au.a(com.getpebble.android.common.model.au.a.CONNECT, this.e.getContentResolver());
                } else {
                    com.getpebble.android.common.b.a.f.a("FrameworkConnectionStateManager", "Handshake failed: initiating disconnect");
                    l.a(a.HANDSHAKE_FAILED);
                    au.a(com.getpebble.android.common.model.au.a.HANDSHAKE_FAIL, this.e.getContentResolver());
                    if (this.i) {
                        com.getpebble.android.common.b.a.f.c("FrameworkConnectionStateManager", "Multiple handshake failures; setting goal to DISCONNECT");
                        l.a(com.getpebble.android.b.a.DISCONNECT);
                    } else {
                        com.getpebble.android.common.b.a.f.c("FrameworkConnectionStateManager", "First handshake failure; will retry");
                        this.i = true;
                        z3 = false;
                    }
                    f.a(pebbleDevice, dVar, l.c, this.h, f(), z3, ak.hasDeviceEverConnected(this.e.getContentResolver(), pebbleDevice), 99999, null, null);
                }
                e();
            }
        }
    }
}
