package com.getpebble.android.framework.g;

import com.getpebble.android.framework.l.a.u;
import com.getpebble.android.framework.l.b.ab.b;
import com.getpebble.android.framework.l.b.ab.c;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

class ab extends j {
    private static final Set<com.getpebble.android.bluetooth.g.a> a = Collections.unmodifiableSet(EnumSet.of(com.getpebble.android.bluetooth.g.a.FCT_REG, com.getpebble.android.bluetooth.g.a.SYS_REG));
    private final a b;
    private p c;

    interface a {
        void a(u uVar);
    }

    ab(p pVar, a aVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("'messageSender cannot be null!");
        }
        this.c = pVar;
        this.b = aVar;
    }

    Set<com.getpebble.android.bluetooth.g.a> a() {
        return a;
    }

    private a c() {
        return this.b;
    }

    private p d() {
        return this.c;
    }

    public boolean a(b bVar, int i, c cVar, com.getpebble.android.framework.l.b.ab.a aVar) {
        return d().a(new com.getpebble.android.framework.l.b.ab(bVar, i, cVar, aVar));
    }

    boolean a(com.getpebble.android.bluetooth.g.b bVar) {
        if (bVar.a() != com.getpebble.android.bluetooth.g.a.FCT_REG.getCode() && bVar.a() != com.getpebble.android.bluetooth.g.a.SYS_REG.getCode()) {
            return false;
        }
        u uVar = new u(bVar);
        a c = c();
        if (c != null) {
            c.a(uVar);
        }
        return true;
    }

    void b() {
    }
}
