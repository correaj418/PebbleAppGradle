package com.getpebble.android.framework.g;

import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.g.a;
import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.framework.l.a.m;
import com.getpebble.android.framework.l.b.p;
import com.getpebble.android.framework.l.b.r;
import com.getpebble.android.h.ab;
import com.google.a.f.e;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

class o extends ac {
    private static final Set<a> a = Collections.unmodifiableSet(EnumSet.of(a.HEALTH_SYNC));
    private final p b;

    o(p pVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("'messageSender' cannot be null!");
        }
        this.b = pVar;
    }

    Set<a> a() {
        return a;
    }

    private p d() {
        return this.b;
    }

    boolean a(b bVar) {
        if (bVar.a() != a.HEALTH_SYNC.getCode()) {
            return false;
        }
        m mVar = new m(bVar);
        if (mVar.c() != (byte) 17) {
            f.a("HealthSyncEndpoint", "Received unknown health data command: " + mVar.c());
            return true;
        } else if (mVar.d()) {
            f.d("HealthSyncEndpoint", "Received health sync ACK");
            return true;
        } else {
            f.a("HealthSyncEndpoint", "Did not receive health data ACK: " + mVar.e());
            return true;
        }
    }

    void b() {
    }

    boolean a(k kVar, FrameworkState frameworkState) {
        if (k.a.SYNC_HEALTH.equals(kVar.b())) {
            e c = c();
            r pVar = new p(c);
            f.d("HealthSyncEndpoint", "Sending health sync request; last sync time: " + c);
            d().a(pVar);
        }
        return false;
    }

    e c() {
        long j = 0;
        long a = PebbleApplication.y().a(c.a.HEALTH_LAST_SYNC_TIME_MS, 0);
        long currentTimeMillis = System.currentTimeMillis() - a;
        if (currentTimeMillis < 0) {
            f.b("HealthSyncEndpoint", "secondsSyncLastSync: negative time (clock may have changed): " + currentTimeMillis + "; last sync time: " + a);
        } else {
            j = currentTimeMillis;
        }
        return e.a((long) ab.a(j));
    }
}
