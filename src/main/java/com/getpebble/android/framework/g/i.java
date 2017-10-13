package com.getpebble.android.framework.g;

import android.content.Context;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.framework.d.a;
import com.getpebble.android.framework.g.k.b;
import com.getpebble.android.framework.l.a.k;
import com.getpebble.android.framework.l.b.m;
import com.google.a.b.am;
import com.google.a.f.e;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class i extends ac {
    protected a a;
    private final p b;

    public i(Context context, p pVar) {
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        } else if (pVar == null) {
            throw new IllegalArgumentException("messageSender cannot be null");
        } else {
            this.a = a.a();
            this.b = pVar;
        }
    }

    boolean a(k kVar, FrameworkState frameworkState) {
        int i = 0;
        f.d("DataloggingEndpoint", "onRequest: action = " + kVar.b());
        switch (kVar.b()) {
            case SEND_DATALOGGING_ACK:
                this.b.a(m.a(e.a((long) kVar.a(b.DATALOGGING_SESSION).intValue())));
                return true;
            case SEND_DATALOGGING_NACK:
                this.b.a(m.b(e.a((long) kVar.a(b.DATALOGGING_SESSION).intValue())));
                return true;
            case SEND_DATALOGGING_REPORT_OPEN_SESSIONS:
                int[] e = kVar.e(b.DATALOGGING_SESSIONS);
                List linkedList = new LinkedList();
                int length = e.length;
                while (i < length) {
                    linkedList.add(e.a((long) e[i]));
                    i++;
                }
                this.b.a(m.a(linkedList));
                return true;
            default:
                f.d("DataloggingEndpoint", "onRequest: No matching request found in DataloggingEndpoint, not handling.");
                return false;
        }
    }

    Set<com.getpebble.android.bluetooth.g.a> a() {
        return am.b(com.getpebble.android.bluetooth.g.a.DATA_LOG);
    }

    boolean a(com.getpebble.android.bluetooth.g.b bVar) {
        if (bVar == null) {
            f.a("DataloggingEndpoint", "onReceive: Received null message, dropping");
            return false;
        }
        this.a.a(new k(bVar));
        return true;
    }

    void b() {
    }
}
