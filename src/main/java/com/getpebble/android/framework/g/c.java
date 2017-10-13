package com.getpebble.android.framework.g;

import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.common.a;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.am.d;
import com.getpebble.android.common.model.am.e;
import com.getpebble.android.framework.l.b.g;
import com.getpebble.android.framework.l.b.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class c extends ac {
    private final p a;
    private g b;
    private int c = 0;

    public c(p pVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("'messageSender' cannot be null!");
        }
        this.a = pVar;
    }

    protected List<UUID> c() {
        int i = 0;
        List b = am.b(e.APP, a.K().getContentResolver());
        List<UUID> arrayList = new ArrayList();
        arrayList.add(d.SYSTEM_APP_SPORTS);
        arrayList.add(d.SYSTEM_APP_GOLF);
        int i2 = 0;
        while (i2 < b.size() && !((com.getpebble.android.common.model.am.c) b.get(i2)).b.equals(e.APP.getArchiveHeaderUuid()) && !((com.getpebble.android.common.model.am.c) b.get(i2)).b.equals(e.APP.getNotSupportedHeaderUuid())) {
            arrayList.add(((com.getpebble.android.common.model.am.c) b.get(i2)).b);
            i2++;
        }
        arrayList.add(am.b);
        List b2 = am.b(e.WATCHFACE, a.K().getContentResolver());
        while (i < b2.size() && !((com.getpebble.android.common.model.am.c) b2.get(i)).b.equals(e.WATCHFACE.getArchiveHeaderUuid()) && !((com.getpebble.android.common.model.am.c) b2.get(i)).b.equals(e.WATCHFACE.getNotSupportedHeaderUuid())) {
            arrayList.add(((com.getpebble.android.common.model.am.c) b2.get(i)).b);
            i++;
        }
        return arrayList;
    }

    boolean a(k kVar, FrameworkState frameworkState) {
        if (!kVar.b().equals(k.a.SEND_APP_ORDER)) {
            return false;
        }
        r a = g.a(c());
        f.d("AppReorderEndpoint", "onRequest: Sending app reorder message to watch");
        this.b = a;
        this.c = 0;
        this.a.a(a);
        return true;
    }

    Set<com.getpebble.android.bluetooth.g.a> a() {
        return com.google.a.b.am.b(com.getpebble.android.bluetooth.g.a.APP_REORDER);
    }

    boolean a(b bVar) {
        com.getpebble.android.framework.l.a.e eVar = new com.getpebble.android.framework.l.a.e(bVar);
        f.d("AppReorderEndpoint", "onReceive: Reorder message result: " + eVar.c());
        if (com.getpebble.android.framework.l.a.e.a.RETRY.equals(eVar.c())) {
            int i = this.c;
            this.c = i + 1;
            if (i < 3) {
                f.d("AppReorderEndpoint", "onReceive: Retry command received; re-sending last app reorder message");
                this.a.a(this.b);
            } else {
                f.c("AppReorderEndpoint", "onReceive: MAx retries exceeded; discarding message");
                this.b = null;
            }
        } else {
            this.b = null;
        }
        return true;
    }

    void b() {
    }
}
