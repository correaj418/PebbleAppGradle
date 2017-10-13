package com.getpebble.android.framework.g;

import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.framework.l.a.x;
import com.getpebble.android.framework.l.b.af;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

class ah extends j {
    private static final Set<com.getpebble.android.bluetooth.g.a> a = Collections.unmodifiableSet(EnumSet.of(com.getpebble.android.bluetooth.g.a.VERSIONS));
    private final a b;
    private p c;

    interface a {
        void a(x xVar);
    }

    ah(p pVar, a aVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("'messageSender' cannot be null!");
        }
        this.c = pVar;
        this.b = aVar;
    }

    private a d() {
        return this.b;
    }

    private p e() {
        return this.c;
    }

    Set<com.getpebble.android.bluetooth.g.a> a() {
        return a;
    }

    boolean c() {
        return e().a(new af());
    }

    boolean a(b bVar) {
        if (bVar.a() != com.getpebble.android.bluetooth.g.a.VERSIONS.getCode()) {
            return false;
        }
        x xVar = new x(bVar);
        a d = d();
        if (d != null) {
            d.a(xVar);
        }
        return true;
    }

    void b() {
    }
}
