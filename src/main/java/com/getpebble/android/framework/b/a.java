package com.getpebble.android.framework.b;

import android.content.Context;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.bluetooth.h.g;
import com.getpebble.android.bluetooth.h.h;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.framework.g.aa;
import com.getpebble.android.framework.g.k;
import com.getpebble.android.framework.g.l;
import com.getpebble.android.framework.g.u;
import com.getpebble.android.framework.g.y;
import com.google.a.b.am;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class a implements g {
    private static final Map<PebbleDevice, a> a = new HashMap();
    private l b;
    private aa c;
    private final PebbleDevice d;
    private final b e;
    private final String f = "ENDPOINT_SET_LOCK";

    public String toString() {
        return "MessageRouter[" + this.d + "]";
    }

    protected a(h hVar, PebbleDevice pebbleDevice) {
        this.d = pebbleDevice;
        this.e = new b(hVar, pebbleDevice);
        this.c = new aa();
    }

    public static a a(h hVar, PebbleDevice pebbleDevice) {
        if (hVar == null) {
            throw new IllegalArgumentException("getOrCreateRouter: 'deviceMessageSender' cannot be null!");
        } else if (pebbleDevice == null) {
            throw new IllegalArgumentException("getOrCreateRouter: 'device' cannot be null!");
        } else {
            a aVar;
            synchronized ("ROUTER_LOCK") {
                if (a.containsKey(pebbleDevice)) {
                    aVar = (a) a.get(pebbleDevice);
                } else {
                    g aVar2 = new a(hVar, pebbleDevice);
                    hVar.a(aVar2);
                    a.put(pebbleDevice, aVar2);
                }
            }
            return aVar;
        }
    }

    public static a c(PebbleDevice pebbleDevice) {
        if (pebbleDevice == null) {
            throw new IllegalArgumentException("getRouter: 'device' cannot be null!");
        }
        a aVar;
        synchronized ("ROUTER_LOCK") {
            if (a.containsKey(pebbleDevice)) {
                aVar = (a) a.get(pebbleDevice);
            } else {
                f.f("MessageRouter", "getRouter: no MessageRouter for device " + pebbleDevice);
                aVar = null;
            }
        }
        return aVar;
    }

    public b a(l lVar) {
        if (lVar != null && (lVar instanceof l)) {
            return this.e;
        }
        throw new IllegalArgumentException("getMessageSender: Only endpoint sets can get the message sender");
    }

    public PebbleDevice a() {
        return this.d;
    }

    private l d() {
        l lVar;
        synchronized ("ENDPOINT_SET_LOCK") {
            lVar = this.b;
        }
        return lVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(com.getpebble.android.framework.g.l r7) {
        /*
        r6 = this;
        r1 = 1;
        r0 = 0;
        r2 = "ENDPOINT_SET_LOCK";
        monitor-enter(r2);
        r3 = r6.b;	 Catch:{ all -> 0x003b }
        if (r3 != r7) goto L_0x0013;
    L_0x0009:
        r0 = "MessageRouter";
        r3 = "setCurrentEndpointSet: No change";
        com.getpebble.android.common.b.a.f.d(r0, r3);	 Catch:{ all -> 0x003b }
        monitor-exit(r2);	 Catch:{ all -> 0x003b }
        r0 = r1;
    L_0x0012:
        return r0;
    L_0x0013:
        r3 = r6.b;	 Catch:{ all -> 0x003b }
        if (r3 != 0) goto L_0x003e;
    L_0x0017:
        r3 = r7 instanceof com.getpebble.android.framework.g.n;	 Catch:{ all -> 0x003b }
        if (r3 != 0) goto L_0x003e;
    L_0x001b:
        r1 = "MessageRouter";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003b }
        r3.<init>();	 Catch:{ all -> 0x003b }
        r4 = "setCurrentEndpointSet: Can't move from null endpoint set to non-handshake (";
        r3 = r3.append(r4);	 Catch:{ all -> 0x003b }
        r3 = r3.append(r7);	 Catch:{ all -> 0x003b }
        r4 = ")";
        r3 = r3.append(r4);	 Catch:{ all -> 0x003b }
        r3 = r3.toString();	 Catch:{ all -> 0x003b }
        com.getpebble.android.common.b.a.f.f(r1, r3);	 Catch:{ all -> 0x003b }
        monitor-exit(r2);	 Catch:{ all -> 0x003b }
        goto L_0x0012;
    L_0x003b:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x003b }
        throw r0;
    L_0x003e:
        r3 = r6.b;	 Catch:{ all -> 0x003b }
        r3 = r3 instanceof com.getpebble.android.framework.g.n;	 Catch:{ all -> 0x003b }
        if (r3 == 0) goto L_0x006e;
    L_0x0044:
        r3 = r7 instanceof com.getpebble.android.framework.g.u;	 Catch:{ all -> 0x003b }
        if (r3 != 0) goto L_0x006e;
    L_0x0048:
        r3 = r7 instanceof com.getpebble.android.framework.g.y;	 Catch:{ all -> 0x003b }
        if (r3 != 0) goto L_0x006e;
    L_0x004c:
        if (r7 == 0) goto L_0x006e;
    L_0x004e:
        r1 = "MessageRouter";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003b }
        r3.<init>();	 Catch:{ all -> 0x003b }
        r4 = "setCurrentEndpointSet: Can't move from handshake to anything but normal/null (";
        r3 = r3.append(r4);	 Catch:{ all -> 0x003b }
        r3 = r3.append(r7);	 Catch:{ all -> 0x003b }
        r4 = ")";
        r3 = r3.append(r4);	 Catch:{ all -> 0x003b }
        r3 = r3.toString();	 Catch:{ all -> 0x003b }
        com.getpebble.android.common.b.a.f.f(r1, r3);	 Catch:{ all -> 0x003b }
        monitor-exit(r2);	 Catch:{ all -> 0x003b }
        goto L_0x0012;
    L_0x006e:
        r0 = r6.b;	 Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x007e;
    L_0x0072:
        r0 = "MessageRouter";
        r3 = "setCurrentEndpointSet: Current endpoint set is not null; destroying";
        com.getpebble.android.common.b.a.f.d(r0, r3);	 Catch:{ all -> 0x003b }
        r0 = r6.b;	 Catch:{ all -> 0x003b }
        r0.c();	 Catch:{ all -> 0x003b }
    L_0x007e:
        r0 = "MessageRouter";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003b }
        r3.<init>();	 Catch:{ all -> 0x003b }
        r4 = "setCurrentEndpointSet: Endpoint set is now ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x003b }
        r3 = r3.append(r7);	 Catch:{ all -> 0x003b }
        r3 = r3.toString();	 Catch:{ all -> 0x003b }
        com.getpebble.android.common.b.a.f.c(r0, r3);	 Catch:{ all -> 0x003b }
        r6.b = r7;	 Catch:{ all -> 0x003b }
        monitor-exit(r2);	 Catch:{ all -> 0x003b }
        if (r7 == 0) goto L_0x0128;
    L_0x009b:
        r7.g();
        r0 = r6.c;
        r0 = r0.c();
        r2 = r0.iterator();
    L_0x00a8:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x0128;
    L_0x00ae:
        r0 = r2.next();
        r0 = (com.getpebble.android.bluetooth.g.b) r0;
        r3 = "MessageRouter";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "setCurrentEndpointSet: De-queueing message for new endpoint set: ";
        r4 = r4.append(r5);
        r5 = r0.a();
        r5 = com.getpebble.android.bluetooth.g.a.fromCode(r5);
        r4 = r4.append(r5);
        r5 = " (";
        r4 = r4.append(r5);
        r5 = r0.a();
        r4 = r4.append(r5);
        r5 = ")";
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.getpebble.android.common.b.a.f.d(r3, r4);
        r3 = r7.a(r0);
        if (r3 != 0) goto L_0x00a8;
    L_0x00ee:
        r3 = "MessageRouter";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "setCurrentEndpointSet: Re-queueing message: ";
        r4 = r4.append(r5);
        r5 = r0.a();
        r5 = com.getpebble.android.bluetooth.g.a.fromCode(r5);
        r4 = r4.append(r5);
        r5 = " (";
        r4 = r4.append(r5);
        r5 = r0.a();
        r4 = r4.append(r5);
        r5 = ")";
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.getpebble.android.common.b.a.f.d(r3, r4);
        r3 = r6.c;
        r3.a(r0);
        goto L_0x00a8;
    L_0x0128:
        r0 = r1;
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.framework.b.a.b(com.getpebble.android.framework.g.l):boolean");
    }

    public boolean a(Context context) {
        f.d("MessageRouter", "setEndpointSetToDefault()");
        return b(new u(context, this));
    }

    public boolean b(Context context) {
        f.d("MessageRouter", "setEndpointSetToPrf()");
        return b(new y(context, this));
    }

    public boolean a(k kVar, FrameworkState frameworkState) {
        if (kVar == null) {
            f.f("MessageRouter", "onRequest: Cannot send null request");
            return false;
        }
        l d = d();
        if (d != null) {
            return d.a(kVar, frameworkState);
        }
        f.d("MessageRouter", "onRequest: Cannot handle this request (" + kVar.b() + " / " + kVar.a() + ") right now, no active endpointSet");
        return false;
    }

    private static boolean a(com.getpebble.android.bluetooth.g.a aVar) {
        switch (aVar) {
            case LOG_DUMP:
            case GET_BYTES:
            case AUDIO_STREAMING:
            case BLOBDB_V1:
            case BLOBDB_V2:
                return false;
            default:
                return true;
        }
    }

    public void a(PebbleDevice pebbleDevice, b bVar) {
        int i = 0;
        if (this.d.equals(pebbleDevice)) {
            l d = d();
            if (d != null) {
                if (a(com.getpebble.android.bluetooth.g.a.fromCode(bVar.a()))) {
                    f.d("MessageRouter", String.format("onDeviceMessageReceived: Received protocol message from %s; sending to %s endpoint (%d)", new Object[]{pebbleDevice.getName(), com.getpebble.android.bluetooth.g.a.fromCode(bVar.a()), Short.valueOf(bVar.a())}));
                }
                i = d.a(bVar);
            }
            if (i != 0) {
                return;
            }
            if (this.c.a(com.getpebble.android.bluetooth.g.a.fromCode(bVar.a()))) {
                f.d("MessageRouter", "onDeviceMessageReceived: Inbound message not handled; queueing: " + com.getpebble.android.bluetooth.g.a.fromCode(bVar.a()) + " (" + bVar.a() + ")");
                this.c.a(bVar);
                return;
            }
            f.d("MessageRouter", "onDeviceMessageReceived: Inbound message not handled; discarding: " + com.getpebble.android.bluetooth.g.a.fromCode(bVar.a()) + " (" + bVar.a() + ")");
        }
    }

    public void a(PebbleDevice pebbleDevice) {
        if (this.d.equals(pebbleDevice)) {
            l d = d();
            if (d != null) {
                d.b();
            }
        }
    }

    public void b(PebbleDevice pebbleDevice) {
        f.d("MessageRouter", "onMessageSendFailed: device = " + pebbleDevice);
        if (this.d.equals(pebbleDevice)) {
            l d = d();
            if (d != null) {
                d.a();
            }
        }
    }

    public static Set<a> b() {
        Set a;
        synchronized ("ROUTER_LOCK") {
            a = am.a(a.values());
        }
        return a;
    }

    public boolean c() {
        boolean z;
        synchronized ("ENDPOINT_SET_LOCK") {
            z = this.b instanceof y;
        }
        return z;
    }

    public static boolean a(k kVar) {
        PebbleDevice n = PebbleApplication.n();
        if (n != null) {
            return a(kVar, n);
        }
        f.b("MessageRouter", "sendRequestToConnectedWatch: Could not send request, connected device was null!");
        return false;
    }

    public static boolean a(k kVar, PebbleDevice pebbleDevice) {
        a c = c(pebbleDevice);
        if (c != null) {
            return c.a(kVar, null);
        }
        f.a("MessageRouter", "sendRequestToWatch: Failed to send request to watch, router was null. Action: " + kVar.b().toString());
        return false;
    }
}
