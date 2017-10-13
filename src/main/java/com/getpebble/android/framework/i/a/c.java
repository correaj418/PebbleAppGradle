package com.getpebble.android.framework.i.a;

import android.os.Handler;
import android.os.Looper;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.i.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c {
    protected Map<b, d> a = new HashMap();
    private Handler b = new Handler(Looper.getMainLooper());
    private b c;

    class a implements Runnable {
        b a;
        final /* synthetic */ c b;

        public a(c cVar, b bVar) {
            this.b = cVar;
            this.a = bVar;
        }

        public void run() {
            synchronized (this.b) {
                this.b.a(this.a);
            }
        }
    }

    public c(b bVar) {
        this.c = bVar;
    }

    public void a(com.getpebble.android.notifications.a.b bVar) {
        f.d("GroupManager", "storeGroupNotification: " + bVar.q() + " uuid = " + bVar.a());
        a(b(bVar));
    }

    protected void a(d dVar) {
        long a = dVar.c().a();
        this.b.removeCallbacks(dVar.a());
        this.b.postDelayed(dVar.a(), a);
    }

    private d b(com.getpebble.android.notifications.a.b bVar) {
        d b = b(b.a(bVar));
        b.a(bVar);
        return b;
    }

    private d b(b bVar) {
        d dVar = (d) this.a.get(bVar);
        if (dVar != null) {
            return dVar;
        }
        f.d("GroupManager", "... is first for group: " + bVar);
        dVar = new d(bVar, new a(this, bVar));
        this.a.put(bVar, dVar);
        return dVar;
    }

    public void a() {
        for (b bVar : this.a.keySet()) {
            this.b.removeCallbacks(((d) this.a.get(bVar)).a());
        }
    }

    public void b() {
        for (b bVar : this.a.keySet()) {
            d dVar = (d) this.a.get(bVar);
            this.b.postDelayed(dVar.a(), dVar.c().a());
        }
    }

    protected int a(b bVar) {
        d dVar = (d) this.a.get(bVar);
        if (dVar == null) {
            f.b("GroupManager", "Processing GroupMeta for " + bVar.toString() + " - no metaLookup so not processing");
            return 0;
        }
        f.d("GroupManager", "Processing GroupMeta for " + bVar.toString());
        int b = b(dVar);
        this.a.remove(bVar);
        return b;
    }

    protected int b(d dVar) {
        int i = 0;
        if (dVar == null) {
            f.b("GroupManager", "No GroupMeta stored for groupKey notification >= 4.3. This is not expected");
            return 0;
        }
        f.d("GroupManager", "displayGroup: meta key: " + dVar.b() + " count: " + dVar.d().size());
        List e = dVar.e();
        com.getpebble.android.notifications.a.b[] bVarArr = (com.getpebble.android.notifications.a.b[]) e.toArray(new com.getpebble.android.notifications.a.b[e.size()]);
        int i2 = 0;
        while (i < bVarArr.length) {
            this.c.d(bVarArr[i]);
            i2++;
            i++;
        }
        return i2;
    }
}
