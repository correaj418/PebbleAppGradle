package com.getpebble.android.framework.g;

import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.framework.l.a.r;
import com.getpebble.android.framework.l.b.y;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

class w extends j {
    private static final Set<com.getpebble.android.bluetooth.g.a> a = Collections.unmodifiableSet(EnumSet.of(com.getpebble.android.bluetooth.g.a.PHONE_VERSION));
    private final p b;
    private final a c;

    interface a {
        boolean a(r rVar);
    }

    w(p pVar, a aVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("'messageSender' cannot be null!");
        }
        this.b = pVar;
        this.c = aVar;
    }

    Set<com.getpebble.android.bluetooth.g.a> a() {
        return a;
    }

    private a d() {
        return this.c;
    }

    private p e() {
        return this.b;
    }

    boolean c() {
        return e().a(new y(com.getpebble.android.common.d.a.d()));
    }

    boolean a(b bVar) {
        if (bVar.a() != com.getpebble.android.bluetooth.g.a.PHONE_VERSION.getCode()) {
            return false;
        }
        r rVar = new r(bVar);
        a d = d();
        if (d != null && d.a(rVar)) {
            return true;
        }
        c();
        return true;
    }

    void b() {
    }
}
