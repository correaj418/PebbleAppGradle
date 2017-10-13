package com.getpebble.android.framework.g;

import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.e.a.e;
import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.framework.b.a;
import com.getpebble.android.framework.l.b.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class l implements p {
    private boolean a = false;
    private final a b;
    private Map<com.getpebble.android.bluetooth.g.a, List<ac>> c;

    protected abstract void f();

    protected l(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("'router' cannot be null!");
        }
        this.b = aVar;
    }

    public void a() {
        f.d("EndpointSet", "EndpointSet: Message send failed.");
    }

    public void b() {
    }

    public final synchronized void c() {
        f.d("EndpointSet", "Destroy: endpoint set: " + getClass().getSimpleName() + " location: " + this);
        this.a = false;
        d();
    }

    protected void d() {
        f.d("EndpointSet", "onDestroy() set:" + getClass().getSimpleName());
        a(e.MAX);
        for (List<ac> it : this.c.values()) {
            for (ac g : it) {
                g.g();
            }
        }
    }

    public final synchronized void g() {
        f.d("EndpointSet", "Init: endpoint set: " + getClass().getSimpleName());
        this.a = true;
        this.c = new HashMap();
        f();
    }

    public final synchronized boolean a(r rVar) {
        boolean a;
        if (this.a) {
            a = this.b.a(this).a(rVar);
        } else {
            f.d("EndpointSet", "sendMessage: blocking message; endpoint not active");
            a = false;
        }
        return a;
    }

    public final synchronized void a(e eVar) {
        if (this.a) {
            this.b.a(this).a(eVar);
        } else {
            f.d("EndpointSet", "requestLeInterval: blocking message; endpoint not active");
        }
    }

    public final PebbleDevice e() {
        return this.b.a();
    }

    protected final boolean h() {
        return this.a;
    }

    protected void a(ac acVar) {
        for (com.getpebble.android.bluetooth.g.a aVar : acVar.a()) {
            List list;
            f.d("EndpointSet", "AddToMap: Adding " + acVar.getClass().getSimpleName() + " for " + aVar.toString());
            if (this.c.containsKey(aVar)) {
                list = (List) this.c.get(aVar);
            } else {
                list = new ArrayList();
            }
            list.add(acVar);
            this.c.put(aVar, list);
        }
    }

    public boolean a(k kVar, FrameworkState frameworkState) {
        if (kVar == null) {
            throw new IllegalArgumentException("'endpointRequest' cannot be null!");
        } else if (this.c == null) {
            f.b("EndpointSet", "handleRequest: mEndpoints is null");
            return false;
        } else {
            List<ac> list = (List) this.c.get(kVar.a());
            if (list == null || list.isEmpty()) {
                f.d("EndpointSet", "handleRequest: Didn't find endpoint for handling request; this = " + this + " mEndpoints.size() = " + this.c.size() + " requested endpoint = " + kVar.a());
                return false;
            }
            for (ac acVar : list) {
                f.e("EndpointSet", "handleRequest: Sending request to " + acVar.getClass().getSimpleName() + " for: " + kVar.a());
                if (a(acVar, kVar, frameworkState)) {
                    return true;
                }
            }
            return false;
        }
    }

    protected boolean a(ac acVar, k kVar, FrameworkState frameworkState) {
        if (acVar.b(kVar)) {
            return acVar.a(kVar, frameworkState);
        }
        return false;
    }

    public boolean a(b bVar) {
        com.getpebble.android.bluetooth.g.a fromCode = com.getpebble.android.bluetooth.g.a.fromCode(bVar.a());
        if (fromCode.equals(com.getpebble.android.bluetooth.g.a.SYSTEM_MESSAGE)) {
            f.c("EndpointSet", "handleMessage: Dropping system message");
            return true;
        } else if (this.c == null) {
            f.e("EndpointSet", "handleMessage: Dropping incoming message - mEndpoints is not yet initialised");
            return false;
        } else {
            List<ac> list = (List) this.c.get(fromCode);
            if (list == null || list.isEmpty()) {
                f.d("EndpointSet", "handleMessage: No endpoints exist that can handle this message with endpointId: " + bVar.a());
                return false;
            }
            for (ac a : list) {
                if (a.a(bVar)) {
                    return true;
                }
            }
            return false;
        }
    }
}
