package com.getpebble.android.bluetooth;

import android.content.Context;
import android.text.TextUtils;
import com.getpebble.android.bluetooth.d.f.a;
import com.getpebble.android.bluetooth.e.m;
import com.getpebble.android.bluetooth.h.b;
import com.getpebble.android.bluetooth.h.c;
import com.getpebble.android.bluetooth.h.e;
import com.getpebble.android.bluetooth.h.f;
import com.getpebble.android.bluetooth.h.g;
import com.getpebble.android.bluetooth.h.h;
import com.getpebble.android.bluetooth.h.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class d implements a, e, m.a, h.a, c, e, h {
    protected final com.getpebble.android.bluetooth.j.a a;
    protected final com.getpebble.android.bluetooth.d.a b;
    protected final Context c;
    protected final m d;
    protected final com.getpebble.android.bluetooth.e.h e;
    private final Set<b> f = new HashSet();
    private final Set<f> g = new HashSet();
    private final Set<com.getpebble.android.bluetooth.h.d> h = new HashSet();
    private final Set<g> i = new HashSet();
    private final Set<i> j = new HashSet();
    private final Map<PebbleDevice, i> k = new HashMap();
    private final com.getpebble.android.bluetooth.k.a l;
    private final com.getpebble.android.bluetooth.k.b m;
    private final com.getpebble.android.bluetooth.d.f n;
    private final a o;
    private boolean p = false;

    public static d a(Context context) {
        com.getpebble.android.bluetooth.j.a aVar = new com.getpebble.android.bluetooth.j.a(context, true);
        return new d(context, aVar, new a(aVar, a.a.RESET_IF_NOTHING_CONNECTED), new com.getpebble.android.bluetooth.e.h());
    }

    protected m a() {
        if (this.e.i()) {
            return null;
        }
        return new m(this);
    }

    public d(Context context, com.getpebble.android.bluetooth.j.a aVar, a aVar2, com.getpebble.android.bluetooth.e.h hVar) {
        this.c = context;
        this.a = aVar;
        this.e = hVar;
        this.d = a();
        if (this.d != null) {
            if (aVar.c()) {
                this.d.a(context);
            } else {
                com.getpebble.android.common.b.a.f.d("BluetoothManager", "Waiting for adapter to come up before opening GATT server");
            }
        }
        this.o = aVar2;
        this.m = new com.getpebble.android.bluetooth.k.b(this.c);
        this.b = new com.getpebble.android.bluetooth.d.a(this.c, new com.getpebble.android.bluetooth.d.a.a(this) {
            final /* synthetic */ d a;

            {
                this.a = r1;
            }

            public void a() {
                com.getpebble.android.common.b.a.f.d("BluetoothManager", "Discovery started");
                for (f a : new HashSet(this.a.g)) {
                    a.a();
                }
            }

            public void a(com.getpebble.android.bluetooth.d.b bVar) {
                for (f a : new HashSet(this.a.g)) {
                    a.a(bVar);
                }
            }

            public void b() {
                com.getpebble.android.common.b.a.f.d("BluetoothManager", "Discovery finished");
                for (f b : new HashSet(this.a.g)) {
                    b.b();
                }
            }
        }, aVar);
        this.l = new com.getpebble.android.bluetooth.k.a(this, this.c) {
            final /* synthetic */ d a;

            public void a(com.getpebble.android.bluetooth.j.a.a aVar) {
                switch (aVar) {
                    case ON:
                        this.a.b();
                        return;
                    case OFF:
                        this.a.o.a();
                        break;
                    case TURNING_OFF:
                        break;
                    case TURNING_ON:
                        com.getpebble.android.common.b.a.f.c("BluetoothManager", "Adapter turning on");
                        return;
                    default:
                        com.getpebble.android.common.b.a.f.a("BluetoothManager", "Adapter error!");
                        this.a.c();
                        return;
                }
                com.getpebble.android.common.b.a.f.c("BluetoothManager", "Adapter is off");
                if (this.a.d != null) {
                    this.a.d.a();
                }
                for (b a : new HashSet(this.a.f)) {
                    a.a(false);
                }
            }
        };
        if (aVar.c()) {
            g();
        }
        if (com.getpebble.android.bluetooth.d.f.b()) {
            this.n = new com.getpebble.android.bluetooth.d.f(aVar, this);
        } else {
            this.n = null;
        }
    }

    protected void b() {
        com.getpebble.android.common.b.a.f.c("BluetoothManager", "Adapter is on");
        this.o.c();
        if (this.d != null) {
            this.d.a(this.c);
        }
        g();
        for (b a : new HashSet(this.f)) {
            a.a(true);
        }
        if (this.p) {
            com.getpebble.android.common.b.a.f.c("BluetoothManager", "PBL-39357 Re-starting LE scan after adapter reset");
            this.p = false;
            a(Transport.LE);
        }
    }

    void c() {
        for (b a : new HashSet(this.f)) {
            a.a();
        }
    }

    synchronized i a(PebbleDevice pebbleDevice) {
        if (!this.k.containsKey(pebbleDevice)) {
            this.k.put(pebbleDevice, b(pebbleDevice));
        }
        return (i) this.k.get(pebbleDevice);
    }

    protected i b(PebbleDevice pebbleDevice) {
        return new i(pebbleDevice);
    }

    public boolean a(Transport transport) {
        boolean a = this.b.a(transport);
        Object obj = (a || !Transport.LE.equals(transport)) ? null : 1;
        if (obj != null) {
            com.getpebble.android.common.b.a.f.c("BluetoothManager", "PBL-39357 LE scan returned false; restarting Bluetooth");
            i();
        }
        return a;
    }

    public void d() {
        this.b.c();
    }

    public boolean e() {
        return this.a.c();
    }

    public void a(b bVar) {
        this.f.add(bVar);
    }

    public List<PebbleDevice> f() {
        List arrayList = new ArrayList();
        Set<com.getpebble.android.bluetooth.j.b> e = this.a.e();
        if (e != null) {
            for (com.getpebble.android.bluetooth.j.b bVar : e) {
                Transport transport;
                int e2 = bVar.e();
                if (e2 == 2) {
                    transport = Transport.LE;
                } else if (e2 == 1) {
                    transport = Transport.CLASSIC;
                }
                String b = bVar.b();
                if (TextUtils.isEmpty(b)) {
                    com.getpebble.android.common.b.a.f.b("BluetoothManager", "Found bonded device but failed to get display name: " + bVar.a());
                } else {
                    PebbleDevice pebbleDevice = new PebbleDevice(b, bVar.a(), transport, (short) 0);
                    if (com.getpebble.android.bluetooth.h.d.a().a(b, bVar.a(), transport, bVar.c(), bVar.e(), null)) {
                        arrayList.add(pebbleDevice);
                    }
                }
            }
        }
        return arrayList;
    }

    public void a(f fVar) {
        this.g.add(fVar);
    }

    public boolean a(PebbleDevice pebbleDevice, String str) {
        if (pebbleDevice == null) {
            throw new IllegalArgumentException("'device' cannot be null!");
        }
        com.getpebble.android.common.b.a.f.c("BluetoothManager", "connectToDevice(" + pebbleDevice + ")");
        g();
        b.a();
        return a(pebbleDevice).a(this, this.c, this.a, this.b, this.d, this.e, str);
    }

    public boolean c(PebbleDevice pebbleDevice) {
        if (pebbleDevice == null) {
            throw new IllegalArgumentException("'device' cannot be null!");
        }
        com.getpebble.android.common.b.a.f.c("BluetoothManager", "disconnectFromDevice(" + pebbleDevice + ")");
        return a(pebbleDevice).a();
    }

    public void a(com.getpebble.android.bluetooth.h.d dVar) {
        this.h.add(dVar);
    }

    public void d(PebbleDevice pebbleDevice) {
        if (com.getpebble.android.bluetooth.d.f.b()) {
            this.n.a(pebbleDevice);
        }
    }

    public void e(PebbleDevice pebbleDevice) {
        if (com.getpebble.android.bluetooth.d.f.b()) {
            this.n.a();
        }
    }

    public boolean a(PebbleDevice pebbleDevice, com.getpebble.android.bluetooth.g.b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("'message' cannot be null!");
        } else if (pebbleDevice == null) {
            throw new IllegalArgumentException("'device' cannot be null!");
        } else if (!a(pebbleDevice).a(bVar)) {
            return false;
        } else {
            for (i b : new HashSet(this.j)) {
                b.b(pebbleDevice, bVar);
            }
            return true;
        }
    }

    public void a(PebbleDevice pebbleDevice, com.getpebble.android.bluetooth.e.a.e eVar) {
        if (pebbleDevice == null) {
            throw new IllegalArgumentException("'device' cannot be null!");
        }
        a(pebbleDevice).a(eVar);
    }

    public void a(g gVar) {
        this.i.add(gVar);
    }

    public void b(g gVar) {
        this.i.remove(gVar);
    }

    public void a(i iVar) {
        this.j.add(iVar);
    }

    public void b(i iVar) {
        this.j.remove(iVar);
    }

    public void a(PebbleDevice pebbleDevice, f fVar) {
        com.getpebble.android.common.b.a.f.c("BluetoothManager", "Connecting to " + pebbleDevice + " success");
        if (a(pebbleDevice).a(fVar)) {
            this.o.c();
            for (com.getpebble.android.bluetooth.h.d a : new HashSet(this.h)) {
                a.a(pebbleDevice, new g.a(g.a.a.SUCCESS, null));
            }
            h();
        }
    }

    public void f(PebbleDevice pebbleDevice) {
        for (com.getpebble.android.bluetooth.h.d c : new HashSet(this.h)) {
            c.c(pebbleDevice);
        }
        this.o.c();
    }

    public void a(PebbleDevice pebbleDevice, g.a aVar) {
        com.getpebble.android.common.b.a.f.c("BluetoothManager", "Connecting to " + pebbleDevice + " failed: result = " + aVar);
        if (aVar.b != null) {
            this.o.a(pebbleDevice, aVar.b);
        }
        if (a(pebbleDevice).b()) {
            for (com.getpebble.android.bluetooth.h.d a : new HashSet(this.h)) {
                a.a(pebbleDevice, aVar);
            }
            h();
        }
    }

    public void g(PebbleDevice pebbleDevice) {
        com.getpebble.android.common.b.a.f.c("BluetoothManager", "Disconnected from " + pebbleDevice);
        if (a(pebbleDevice).b()) {
            for (com.getpebble.android.bluetooth.h.d a : new HashSet(this.h)) {
                a.a(pebbleDevice);
            }
            h();
        }
    }

    public void h(PebbleDevice pebbleDevice) {
        for (g a : new HashSet(this.i)) {
            a.a(pebbleDevice);
        }
    }

    public void i(PebbleDevice pebbleDevice) {
        com.getpebble.android.common.b.a.f.c("BluetoothManager", "Data failed to send to " + pebbleDevice);
        for (g b : new HashSet(this.i)) {
            b.b(pebbleDevice);
        }
    }

    public void b(PebbleDevice pebbleDevice, com.getpebble.android.bluetooth.g.b bVar) {
        for (g a : new HashSet(this.i)) {
            a.a(pebbleDevice, bVar);
        }
    }

    public void g() {
        try {
            this.b.b();
            this.a.f();
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.d("BluetoothManager", "dumpAllDevices: error dumping BT state", e);
        }
    }

    public void h() {
        try {
            this.b.b();
            this.a.g();
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.d("BluetoothManager", "dumpAllDevices: error dumping BT state", e);
        }
    }

    public void j(PebbleDevice pebbleDevice) {
        for (com.getpebble.android.bluetooth.h.d b : new HashSet(this.h)) {
            b.b(pebbleDevice);
        }
    }

    public void i() {
        this.p = true;
        this.o.b();
    }
}
