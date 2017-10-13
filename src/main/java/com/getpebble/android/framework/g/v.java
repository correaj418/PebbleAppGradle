package com.getpebble.android.framework.g;

import android.content.Context;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.framework.g.k.b;
import com.getpebble.android.framework.l.a.q;
import com.getpebble.android.framework.l.b.r;
import com.getpebble.android.framework.l.b.x;
import com.getpebble.android.framework.l.b.x.a;
import com.getpebble.android.framework.o.c;
import com.google.a.b.am;
import java.util.Set;

public class v extends ac {
    private p a;
    private Context b;

    public v(Context context, p pVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("'messageSender' cannot be null!");
        } else if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        } else {
            this.a = pVar;
            this.b = context;
        }
    }

    boolean a(k kVar, FrameworkState frameworkState) {
        byte[] d = kVar.d(b.PHONE_COOKIE);
        String b = kVar.b(b.PHONE_NAME);
        String b2 = kVar.b(b.PHONE_NUMBER);
        r rVar = null;
        switch (kVar.b()) {
            case SEND_PHONE_INCOMING_CALL_NOTIFICATION:
                rVar = new x(a.INCOMING_CALL, d, b2, b);
                break;
            case SEND_PHONE_RING_NOTIFICATION:
                rVar = new x(a.RING, d);
                break;
            case SEND_PHONE_START_NOTIFICATION:
                rVar = new x(a.START, d);
                break;
            case SEND_PHONE_END_NOTIFICATION:
                rVar = new x(a.END, d);
                break;
        }
        if (rVar != null && this.a.a(rVar)) {
            return true;
        }
        f.d("PhoneControlEndpoint", "onRequest: send failed");
        return false;
    }

    Set<com.getpebble.android.bluetooth.g.a> a() {
        return am.b(com.getpebble.android.bluetooth.g.a.PHONE_CONTROL);
    }

    boolean a(com.getpebble.android.bluetooth.g.b bVar) {
        if (bVar == null) {
            f.a("PhoneControlEndpoint", "onReceive: Received null message, dropping");
            return false;
        }
        try {
            switch (new q(bVar).c()) {
                case HANGUP:
                    f.d("PhoneControlEndpoint", "onReceive: Received Hangup message");
                    c();
                    break;
                case UNKNOWN:
                    f.b("PhoneControlEndpoint", "onReceive: Unknown command");
                    break;
            }
            return true;
        } catch (Throwable e) {
            f.b("PhoneControlEndpoint", "Invalid inbound message", e);
            return false;
        }
    }

    protected void c() {
        c.a(this.b);
    }

    void b() {
    }
}
