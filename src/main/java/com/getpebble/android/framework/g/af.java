package com.getpebble.android.framework.g;

import com.getpebble.android.bluetooth.g.a;
import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.v;
import com.getpebble.android.framework.l.a.x;
import com.getpebble.android.framework.l.b.ai;
import com.google.a.b.am;
import java.util.Set;

public class af extends ac {
    private p a;

    public af(p pVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("'messageSender' cannot be null!");
        }
        this.a = pVar;
    }

    private boolean c() {
        if (a(this.a)) {
            f.d("TimeControlEndpoint", "sendSetTimeMessage: Sending set time message");
            return this.a.a(new ai());
        }
        f.b("TimeControlEndpoint", "sendSetTimeMessage: setTime can not be sent because it is a 2.x or 1.x firmware");
        return false;
    }

    Set<a> a() {
        return am.b(a.TIME);
    }

    boolean a(b bVar) {
        f.a("TimeControlEndpoint", "onReceive: Received unexpected Get Time request from Pebble; should validate the message");
        return c();
    }

    void b() {
    }

    boolean a(k kVar, FrameworkState frameworkState) {
        switch (kVar.b()) {
            case SEND_SET_TIME_MESSAGE:
                f.d("TimeControlEndpoint", "onRequest: Send set time message");
                c();
                return true;
            default:
                f.d("TimeControlEndpoint", "onRequest: No matching request found in TimeControlEndpoint, not handling.");
                return false;
        }
    }

    private boolean a(p pVar) {
        v b;
        if (this.a instanceof n) {
            x i = ((n) this.a).i();
            if (i != null) {
                b = i.d().b();
                if (b == null) {
                    ak.a pebbleDeviceRecord = ak.getPebbleDeviceRecord(com.getpebble.android.common.a.K().getContentResolver(), pVar.e());
                    b = (pebbleDeviceRecord != null || pebbleDeviceRecord.getFwVersion() == null) ? null : pebbleDeviceRecord.getFwVersion();
                }
                if (b != null) {
                    f.b("TimeControlEndpoint", "canSendSetTimeMessage: can not send setTimeMessage to this firmwareVersion = " + b);
                    return false;
                } else if (a(b)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        b = null;
        if (b == null) {
            ak.a pebbleDeviceRecord2 = ak.getPebbleDeviceRecord(com.getpebble.android.common.a.K().getContentResolver(), pVar.e());
            if (pebbleDeviceRecord2 != null) {
            }
        }
        if (b != null) {
            f.b("TimeControlEndpoint", "canSendSetTimeMessage: can not send setTimeMessage to this firmwareVersion = " + b);
            return false;
        } else if (a(b)) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean a(v vVar) {
        if (vVar != null && vVar.compareTo(n.a) < 0) {
            return true;
        }
        f.b("TimeControlEndpoint", "doesWatchNeedMigration: active device does not need migration. firmwareVersion = " + vVar);
        return false;
    }
}
