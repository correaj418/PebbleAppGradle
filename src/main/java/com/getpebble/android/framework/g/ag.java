package com.getpebble.android.framework.g;

import android.content.Context;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.aw;
import com.getpebble.android.common.model.aw.d;
import com.getpebble.android.common.model.v;
import com.getpebble.android.common.model.z;
import com.getpebble.android.framework.i.b;
import com.getpebble.android.framework.l.a.w;
import com.getpebble.android.framework.l.b.ae;
import com.getpebble.android.framework.timeline.f;
import com.getpebble.android.framework.timeline.h;
import com.google.a.b.am;
import java.lang.ref.WeakReference;
import java.util.Set;

public class ag extends ac {
    private final p a;
    private final Context b;
    private final v c;
    private final z d;
    private boolean e = false;
    private final b f = b.b();

    public static class a {
        private final w a;
        private final WeakReference<ag> b;

        private a(w wVar, ag agVar) {
            this.a = wVar;
            this.b = new WeakReference(agVar);
        }

        public void a(boolean z, f fVar, f fVar2) {
            ag agVar = (ag) this.b.get();
            if (agVar == null) {
                com.getpebble.android.common.b.a.f.b("TimelineActionsEndpoint", "ActionInvocationResultHandler: result: Action result received, but endpoint is GCd");
            } else {
                agVar.a(z, fVar, fVar2, this.a);
            }
        }
    }

    public ag(p pVar, Context context) {
        if (pVar == null) {
            throw new IllegalArgumentException("'messageSender' cannot be null!");
        } else if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        } else {
            this.b = context;
            this.a = pVar;
            com.getpebble.android.common.model.ak.a pebbleDeviceRecord = ak.getPebbleDeviceRecord(context.getContentResolver(), pVar.e());
            this.c = pebbleDeviceRecord.getFwVersion();
            this.d = pebbleDeviceRecord.hwPlatform;
        }
    }

    Set<com.getpebble.android.bluetooth.g.a> a() {
        return am.b(com.getpebble.android.bluetooth.g.a.TIMELINE_ACTIONS);
    }

    boolean a(com.getpebble.android.bluetooth.g.b bVar) {
        h mapper = h.getMapper(this.b, this.c, this.d);
        if (mapper == null) {
            com.getpebble.android.common.b.a.f.a("TimelineActionsEndpoint", "onReceive: Failed to invoke action, failed to deserialize message due to null mapper. NACKing");
            this.a.a(ae.a(new w(bVar).c(), com.getpebble.android.framework.l.b.ae.a.NACK, null, null, this.d.getPlatformCode()));
        } else {
            a(new w(bVar, mapper));
        }
        return true;
    }

    void b() {
        this.e = true;
    }

    boolean a(k kVar, FrameworkState frameworkState) {
        com.getpebble.android.common.b.a.f.b("TimelineActionsEndpoint", "onReceive: No requests are supported by this endpoint; got: " + kVar.toString());
        return true;
    }

    private void a(w wVar) {
        com.getpebble.android.common.b.a.f.d("TimelineActionsEndpoint", "handleInvokeAction: INVOKE_ACTION message: uuid = " + wVar.c() + " actionId = " + wVar.d());
        a aVar = new a(wVar, this);
        if (com.getpebble.android.framework.k.b.a.equals(wVar.c())) {
            com.getpebble.android.framework.k.b.a(wVar, aVar);
            return;
        }
        d h = aw.h(this.b.getContentResolver(), wVar.c());
        if (h != null && !a(h) && h.a(wVar, this.b, aVar)) {
            return;
        }
        if (this.f != null) {
            this.f.a(wVar.c(), wVar.d(), wVar.e(), this.b, aVar);
            return;
        }
        com.getpebble.android.common.b.a.f.a("TimelineActionsEndpoint", "handleInvokeAction: Failed to invoke action, notification Processor was null");
        this.a.a(ae.a(wVar.c(), com.getpebble.android.framework.l.b.ae.a.NACK, null, null, this.d.getPlatformCode()));
    }

    private boolean a(d dVar) {
        if (dVar.b == null || dVar.b.b == null) {
            return false;
        }
        return dVar.b.b.equals(aw.d);
    }

    public void a(boolean z, f fVar, f fVar2, w wVar) {
        f fVar3 = null;
        if (this.e) {
            com.getpebble.android.common.b.a.f.b("TimelineActionsEndpoint", "sendActionResponse: Action result received, but endpoint is torn down");
            return;
        }
        f fVar4;
        com.getpebble.android.framework.l.b.ae.a aVar = z ? com.getpebble.android.framework.l.b.ae.a.ACK : com.getpebble.android.framework.l.b.ae.a.NACK;
        h mapper = h.getMapper(this.b, this.c, this.d);
        if (mapper == null) {
            com.getpebble.android.common.b.a.f.a("TimelineActionsEndpoint", "ActionInvocationResultHandler: result: Null mapper when sending action result");
            fVar4 = null;
        } else {
            fVar3 = fVar2;
            fVar4 = fVar;
        }
        if (z) {
            fVar3 = fVar4;
        }
        com.getpebble.android.common.b.a.f.d("TimelineActionsEndpoint", "ActionInvocationResultHandler: result: Sending " + aVar + " to watch (sent = " + this.a.a(ae.a(wVar.c(), aVar, mapper, fVar3, this.d.getPlatformCode())) + ") attributes = " + fVar3);
    }
}
