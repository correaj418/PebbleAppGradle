package com.getpebble.android.framework.d;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.analytics.WatchAnalytics;
import com.getpebble.android.framework.g.k.b;
import com.getpebble.android.framework.l.a.k;
import com.google.a.f.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class a {
    private static a a;
    private final b b;
    private final List<d> c;
    private final ContentResolver d;
    private final com.getpebble.android.framework.pebblekit.a e;
    private final Handler f;

    a(b bVar, Looper looper, ContentResolver contentResolver, com.getpebble.android.framework.pebblekit.a aVar) {
        f.d("Datalogging", "Datalogging()");
        if (bVar == null) {
            throw new IllegalArgumentException("database cannot be null");
        } else if (looper == null) {
            throw new IllegalArgumentException("looper cannot be null");
        } else if (contentResolver == null) {
            throw new IllegalArgumentException("resolver cannot be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("pebbleKit cannot be null");
        } else {
            this.f = new Handler(looper);
            this.b = bVar;
            this.d = contentResolver;
            this.e = aVar;
            this.c = this.b.a();
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.b()) {
                    this.b.d(dVar);
                    it.remove();
                }
            }
            a(WatchAnalytics.a);
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            aVar = a;
        }
        return aVar;
    }

    public static synchronized a a(Context context, HandlerThread handlerThread) {
        a aVar;
        synchronized (a.class) {
            if (a != null) {
                throw new IllegalStateException("Cannot create - already created!");
            }
            com.getpebble.android.framework.pebblekit.a a = com.getpebble.android.framework.pebblekit.a.a(context);
            a = new a(new b(context, a), handlerThread.getLooper(), context.getContentResolver(), a);
            aVar = a;
        }
        return aVar;
    }

    public void a(final k kVar) {
        f.e("Datalogging", "handleWatchMessage()");
        if (kVar == null) {
            f.b("Datalogging", "message is null");
        } else {
            this.f.post(new Runnable(this) {
                final /* synthetic */ a b;

                public void run() {
                    this.b.b(kVar);
                }
            });
        }
    }

    public void a(final UUID uuid, final int i) {
        this.f.post(new Runnable(this) {
            final /* synthetic */ a c;

            public void run() {
                this.c.b(uuid, i);
            }
        });
    }

    public void a(final UUID uuid) {
        this.f.post(new Runnable(this) {
            final /* synthetic */ a b;

            public void run() {
                this.b.b(uuid);
            }
        });
    }

    private void b(k kVar) {
        f.e("Datalogging", "handleWatchMessageInternal()");
        switch (kVar.c()) {
            case OPEN_SESSION:
                c(kVar);
                return;
            case DATA:
                d(kVar);
                return;
            case CLOSE_SESSION:
                e(kVar);
                return;
            case TIMEOUT:
                b();
                return;
            default:
                return;
        }
    }

    private void b() {
        List linkedList = new LinkedList();
        for (d dVar : this.c) {
            if (!dVar.m()) {
                linkedList.add(dVar.i());
            }
        }
        if (linkedList.size() != 0) {
            int[] iArr = new int[linkedList.size()];
            for (int i = 0; i < linkedList.size(); i++) {
                iArr[i] = ((e) linkedList.get(i)).intValue();
            }
            Bundle bundle = new Bundle();
            bundle.putIntArray(b.DATALOGGING_SESSIONS.toString(), iArr);
            a(new com.getpebble.android.framework.g.k(com.getpebble.android.bluetooth.g.a.DATA_LOG, com.getpebble.android.framework.g.k.a.SEND_DATALOGGING_REPORT_OPEN_SESSIONS, bundle));
        }
    }

    private void b(UUID uuid, int i) {
        f.e("Datalogging", "handleClientAckInternal()");
        d c = c(uuid);
        if (c == null) {
            f.b("Datalogging", "handleClientAckInternal(): session not found for local UUID = " + uuid);
        } else {
            c.a(i);
        }
    }

    private void b(UUID uuid) {
        f.e("Datalogging", "handleClientRequestDataInternal()");
        if (uuid == null) {
            f.b("Datalogging", "handleClientRequestDataInternal(): appUuid is null");
            return;
        }
        for (d dVar : this.c) {
            if (uuid.equals(dVar.f())) {
                dVar.c();
            }
        }
    }

    private boolean a(e eVar) {
        if (eVar == null) {
            f.b("Datalogging", "sendAckToWatch(): sessionId is null");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(b.DATALOGGING_SESSION.toString(), eVar.intValue());
        return a(new com.getpebble.android.framework.g.k(com.getpebble.android.bluetooth.g.a.DATA_LOG, com.getpebble.android.framework.g.k.a.SEND_DATALOGGING_ACK, bundle));
    }

    private void b(e eVar) {
        if (eVar == null) {
            f.b("Datalogging", "sendNackToWatch(): sessionId is null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(b.DATALOGGING_SESSION.toString(), eVar.intValue());
        a(new com.getpebble.android.framework.g.k(com.getpebble.android.bluetooth.g.a.DATA_LOG, com.getpebble.android.framework.g.k.a.SEND_DATALOGGING_NACK, bundle));
    }

    protected boolean a(com.getpebble.android.framework.g.k kVar) {
        PebbleDevice n = PebbleApplication.n();
        if (n == null) {
            f.d("Datalogging", "Can't send Ack to watch: no connected device");
            return false;
        }
        com.getpebble.android.framework.b.a c = com.getpebble.android.framework.b.a.c(n);
        if (c == null) {
            return false;
        }
        f.d("Datalogging", "Sending " + kVar.b() + " request to " + n);
        return c.a(kVar, null);
    }

    private void c(k kVar) {
        if (kVar == null) {
            f.b("Datalogging", "openSession(): message is null");
            return;
        }
        f.e("Datalogging", "openSession() id = " + kVar.d());
        Object obj = 1;
        try {
            d c = c(kVar.d());
            if (c != null) {
                if (c.a(kVar)) {
                    f.d("Datalogging", "Found open session with matching parameters id = " + kVar.d());
                    obj = null;
                } else {
                    f.d("Datalogging", "Found open session with mismatched parameters id = " + kVar.d());
                    c.a();
                }
            }
            if (obj != null) {
                f.e("Datalogging", "addNewSession id = " + kVar.d());
                this.c.add(new d(kVar, this.b, this.e));
            }
            a(kVar.d());
        } catch (Throwable e) {
            f.b("Datalogging", "Error opening session: sending nack", e);
            b(kVar.d());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(com.getpebble.android.framework.l.a.k r5) {
        /*
        r4 = this;
        r0 = "Datalogging";
        r1 = "receiveData()";
        com.getpebble.android.common.b.a.f.e(r0, r1);
        if (r5 != 0) goto L_0x0011;
    L_0x0009:
        r0 = "Datalogging";
        r1 = "receiveData(): message is null";
        com.getpebble.android.common.b.a.f.b(r0, r1);
    L_0x0010:
        return;
    L_0x0011:
        r0 = r5.d();
        r1 = r4.c(r0);
        if (r1 != 0) goto L_0x003f;
    L_0x001b:
        r0 = "Datalogging";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "receiveData(): open session not found with ID = ";
        r1 = r1.append(r2);
        r2 = r5.d();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.getpebble.android.common.b.a.f.c(r0, r1);
        r0 = r5.d();
        r4.b(r0);
        goto L_0x0010;
    L_0x003f:
        r0 = r4.b;	 Catch:{ e -> 0x0077, SQLException -> 0x009a }
        r0.b();	 Catch:{ e -> 0x0077, SQLException -> 0x009a }
        r0 = r1.k();	 Catch:{ e -> 0x0077, SQLException -> 0x009a }
        r2 = r1.j();	 Catch:{ e -> 0x0077, SQLException -> 0x009a }
        r0 = r5.a(r0, r2);	 Catch:{ e -> 0x0077, SQLException -> 0x009a }
        r0 = r1.a(r0);	 Catch:{ e -> 0x0077, SQLException -> 0x009a }
        r2 = r1.i();	 Catch:{ e -> 0x0077, SQLException -> 0x009a }
        r2 = r4.a(r2);	 Catch:{ e -> 0x0077, SQLException -> 0x009a }
        if (r2 == 0) goto L_0x008c;
    L_0x005e:
        r2 = r4.b;	 Catch:{ e -> 0x0077, SQLException -> 0x009a }
        r2.c();	 Catch:{ e -> 0x0077, SQLException -> 0x009a }
        r2 = r0.iterator();	 Catch:{ e -> 0x0077, SQLException -> 0x009a }
    L_0x0067:
        r0 = r2.hasNext();	 Catch:{ e -> 0x0077, SQLException -> 0x009a }
        if (r0 == 0) goto L_0x0093;
    L_0x006d:
        r0 = r2.next();	 Catch:{ e -> 0x0077, SQLException -> 0x009a }
        r0 = (com.getpebble.android.framework.d.c) r0;	 Catch:{ e -> 0x0077, SQLException -> 0x009a }
        r0.b();	 Catch:{ e -> 0x0077, SQLException -> 0x009a }
        goto L_0x0067;
    L_0x0077:
        r0 = move-exception;
        r2 = "Datalogging";
        r3 = "Invalid payload: sending nack";
        com.getpebble.android.common.b.a.f.b(r2, r3, r0);	 Catch:{ all -> 0x00b0 }
        r0 = r1.i();	 Catch:{ all -> 0x00b0 }
        r4.b(r0);	 Catch:{ all -> 0x00b0 }
        r0 = r4.b;
        r0.d();
        goto L_0x0010;
    L_0x008c:
        r0 = "Datalogging";
        r2 = "Ack not sent: transaction will be rolled back";
        com.getpebble.android.common.b.a.f.b(r0, r2);	 Catch:{ e -> 0x0077, SQLException -> 0x009a }
    L_0x0093:
        r0 = r4.b;
        r0.d();
        goto L_0x0010;
    L_0x009a:
        r0 = move-exception;
        r2 = "Datalogging";
        r3 = "Error inserting: sending nack";
        com.getpebble.android.common.b.a.f.b(r2, r3, r0);	 Catch:{ all -> 0x00b0 }
        r0 = r1.i();	 Catch:{ all -> 0x00b0 }
        r4.b(r0);	 Catch:{ all -> 0x00b0 }
        r0 = r4.b;
        r0.d();
        goto L_0x0010;
    L_0x00b0:
        r0 = move-exception;
        r1 = r4.b;
        r1.d();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.framework.d.a.d(com.getpebble.android.framework.l.a.k):void");
    }

    private void e(k kVar) {
        f.e("Datalogging", "closeSession()");
        if (kVar == null) {
            f.b("Datalogging", "closeSession(): message is null");
            return;
        }
        a(kVar.d());
        d c = c(kVar.d());
        if (c == null) {
            f.c("Datalogging", "closeSession(): open session not found with ID = " + kVar.d());
        } else {
            c.a();
        }
    }

    private d c(e eVar) {
        for (d dVar : this.c) {
            if (dVar.i().equals(eVar) && !dVar.m()) {
                return dVar;
            }
        }
        return null;
    }

    private d c(UUID uuid) {
        for (d dVar : this.c) {
            if (dVar.e().equals(uuid)) {
                return dVar;
            }
        }
        return null;
    }
}
