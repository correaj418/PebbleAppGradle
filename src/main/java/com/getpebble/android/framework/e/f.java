package com.getpebble.android.framework.e;

import android.content.Context;
import android.database.ContentObserver;
import com.getpebble.android.b.d;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.common.b.b.b;
import com.getpebble.android.common.model.ak;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class f extends ContentObserver {
    private final String a = "PebbleDeviceObserver";
    private CopyOnWriteArrayList<a> b = new CopyOnWriteArrayList();
    private com.getpebble.android.common.model.ak.a c;
    private com.getpebble.android.common.model.ak.a d;
    private com.getpebble.android.common.model.ak.a e;
    private final Runnable f = new Runnable(this) {
        final /* synthetic */ f a;

        {
            this.a = r1;
        }

        public void run() {
            this.a.e();
        }
    };

    public interface a {
        void e_();
    }

    public f(Context context) {
        super(null);
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        }
        a(context);
        e();
    }

    public void a(Context context) {
        context.getContentResolver().registerContentObserver(b.a(ak.TABLE_NAME), true, this);
    }

    public void b(Context context) {
        context.getContentResolver().unregisterContentObserver(this);
    }

    public void a(a aVar) {
        if (!this.b.contains(aVar)) {
            this.b.add(aVar);
        }
    }

    public void b(a aVar) {
        this.b.remove(aVar);
    }

    public PebbleDevice a() {
        com.getpebble.android.common.model.ak.a d = d();
        if (d != null) {
            return d.pebbleDevice;
        }
        return null;
    }

    public synchronized com.getpebble.android.common.model.ak.a b() {
        return this.d;
    }

    public synchronized com.getpebble.android.common.model.ak.a c() {
        return this.e;
    }

    public synchronized com.getpebble.android.common.model.ak.a d() {
        return this.c;
    }

    private synchronized boolean a(com.getpebble.android.common.model.ak.a aVar) {
        boolean z = false;
        synchronized (this) {
            if (!(this.c == null && aVar == null)) {
                if (!(com.getpebble.android.common.b.b.a.a(this.c, aVar) && this.c.connectionStatus.equals(aVar.connectionStatus))) {
                    z = true;
                }
                this.c = aVar;
            }
        }
        return z;
    }

    private synchronized void b(com.getpebble.android.common.model.ak.a aVar) {
        this.d = aVar;
    }

    private synchronized boolean c(com.getpebble.android.common.model.ak.a aVar) {
        boolean z = false;
        synchronized (this) {
            if (!(this.e == null && aVar == null)) {
                if (!(com.getpebble.android.common.b.b.a.a(this.e, aVar) && this.e.connectionStatus.equals(aVar.connectionStatus))) {
                    z = true;
                }
                this.e = aVar;
            }
        }
        return z;
    }

    public void onChange(boolean z) {
        com.getpebble.android.common.framework.a.a(this.f);
    }

    public void e() {
        com.getpebble.android.common.model.ak.a aVar;
        com.getpebble.android.common.model.ak.a aVar2 = null;
        List<com.getpebble.android.common.model.ak.a> pebbleDeviceRecords = ak.getPebbleDeviceRecords(com.getpebble.android.common.a.K().getContentResolver(), ak.b.LAST_CONNECTED_OR_CONNECTING);
        if (pebbleDeviceRecords.isEmpty()) {
            aVar = null;
        } else {
            aVar = (com.getpebble.android.common.model.ak.a) pebbleDeviceRecords.get(0);
        }
        boolean c = c(aVar);
        for (com.getpebble.android.common.model.ak.a aVar3 : pebbleDeviceRecords) {
            if (aVar3.lastConnectedTimeMillis >= 1) {
                break;
            }
        }
        com.getpebble.android.common.model.ak.a aVar32 = null;
        b(aVar32);
        if (aVar != null && aVar.connectionStatus.equals(d.CONNECTED)) {
            aVar2 = aVar;
        }
        int i = (a(aVar2) || c) ? 1 : 0;
        if (i != 0) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((a) it.next()).e_();
            }
        }
    }
}
