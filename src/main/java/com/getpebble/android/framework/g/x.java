package com.getpebble.android.framework.g;

import com.getpebble.android.bluetooth.g.a;
import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.framework.l.a.s;
import com.getpebble.android.framework.l.b.z;
import com.google.a.b.am;
import java.util.Set;

public class x extends ac {
    private final String a = "PingEndpoint";
    private final p b;

    public x(p pVar) {
        this.b = pVar;
    }

    Set<a> a() {
        return am.b(a.PING);
    }

    boolean a(b bVar) {
        s sVar = new s(bVar);
        f.d("PingEndpoint", "onReceive: Receieved ping message. isIdle = " + sVar.d());
        this.b.a(new z(sVar.c()));
        return true;
    }

    void b() {
    }

    boolean a(k kVar, FrameworkState frameworkState) {
        return false;
    }
}
