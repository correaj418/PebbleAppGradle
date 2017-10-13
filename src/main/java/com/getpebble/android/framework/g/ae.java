package com.getpebble.android.framework.g;

import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.l.a.v;
import com.getpebble.android.framework.l.b.ad;
import com.google.a.b.am;
import java.util.Set;

public class ae extends j {
    private p a;
    private a b;

    public interface a {
        void a(v vVar);
    }

    public ae(p pVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("'messageSender' cannot be null");
        }
        this.a = pVar;
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    private a d() {
        return this.b;
    }

    private p e() {
        return this.a;
    }

    Set<com.getpebble.android.bluetooth.g.a> a() {
        return am.b(com.getpebble.android.bluetooth.g.a.SYSTEM_MESSAGE);
    }

    private boolean a(com.getpebble.android.bluetooth.g.a aVar) {
        return a().contains(aVar);
    }

    public void a(com.getpebble.android.framework.l.b.ad.a aVar) {
        e().a(new ad(aVar));
    }

    public void c() {
        e().a(new ad(com.getpebble.android.framework.l.b.ad.a.FIRMWARE_START));
    }

    public void a(int i, int i2) {
        e().a(new ad(i, i2));
    }

    boolean a(b bVar) {
        if (!a(com.getpebble.android.bluetooth.g.a.fromCode(bVar.a()))) {
            return false;
        }
        try {
            v vVar = new v(bVar);
            if (vVar.c() == null) {
                f.b("SystemMessageEndpoint", "Received a system message with unsupported type; dropping");
                return true;
            }
            a d = d();
            if (d == null) {
                return true;
            }
            d.a(vVar);
            return true;
        } catch (Throwable e) {
            f.b("SystemMessageEndpoint", "Received invalid system message", e);
            return true;
        }
    }

    void b() {
    }
}
