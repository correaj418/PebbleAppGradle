package com.getpebble.android.framework.g;

import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.framework.g.k.a;
import com.getpebble.android.framework.l.b.ac;
import com.google.a.b.am;
import java.util.Set;

public class ad extends ac {
    private final p a;

    public ad(p pVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("'messageSender' cannot be null");
        }
        this.a = pVar;
    }

    boolean a(k kVar, FrameworkState frameworkState) {
        if (kVar.b().equals(a.FORCE_CORE_DUMP)) {
            c();
            return true;
        } else if (kVar.b().equals(a.RESET_INTO_PRF)) {
            d();
            return true;
        } else {
            f.d("ResetEndpoint", "onRequest: Unsupported action: " + kVar.b());
            return false;
        }
    }

    private void c() {
        this.a.a(new ac(ac.a.NEW_CORE_DUMP));
    }

    private void d() {
        this.a.a(new ac(ac.a.RESET_INTO_PRF));
    }

    Set<com.getpebble.android.bluetooth.g.a> a() {
        return am.b(com.getpebble.android.bluetooth.g.a.RESET);
    }

    boolean a(b bVar) {
        return false;
    }

    void b() {
    }
}
