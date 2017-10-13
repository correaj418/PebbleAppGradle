package com.getpebble.android.mms;

import android.telephony.TelephonyManager;
import android.util.LruCache;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.common.b.b.c.a;
import com.getpebble.android.framework.m.j;
import com.getpebble.android.mms.b.b;
import java.util.ArrayList;
import java.util.List;

public class i implements b {
    protected LruCache<Integer, Mms> a = new LruCache(10);
    private final c b;

    protected i(c cVar) {
        this.b = cVar;
    }

    public int a() {
        return this.b.a(a.MMS_LATEST_ID, 0);
    }

    public void a(int i) {
        f.c("PebbleMms", "setLatestId(" + i + ")");
        if (a() > i) {
            f.c("PebbleMms", "setLatestId(" + i + "): latest id is already set to " + a() + " skipping...");
        } else {
            this.b.b(a.MMS_LATEST_ID, i);
        }
    }

    public void a(Mms mms) {
        a(mms.a);
        this.a.remove(Integer.valueOf(mms.a));
        f.e("PebbleMms", "add() mms:" + mms.toString());
        b(mms);
    }

    public static void b(Mms mms) {
        com.getpebble.android.notifications.a.b a = com.getpebble.android.notifications.a.b.a(new e(((TelephonyManager) com.getpebble.android.common.a.K().getSystemService("phone")).getLine1Number()).a(mms, com.getpebble.android.common.a.K()), com.getpebble.android.notifications.a.b.c.MMS, System.currentTimeMillis());
        if (j.b.a()) {
            com.getpebble.android.framework.i.b.a(a);
        }
    }

    public void a(List<Mms> list) {
        for (Mms a : list) {
            a(a);
        }
    }

    public boolean b() {
        return this.a.size() > 0;
    }

    public List<Mms> c() {
        return this.a != null ? new ArrayList(this.a.snapshot().values()) : new ArrayList();
    }

    private void c(List<Mms> list) {
        for (Mms mms : list) {
            f.c("PebbleMms", "Setting invalid mms: " + mms.a);
            a(mms.a);
        }
    }

    protected void b(List<Mms> list) {
        for (Mms mms : list) {
            f.c("PebbleMms", "Adding incomplete mms: " + mms.a);
            f.c("PebbleMms", "mIncompleteMms Count: " + this.a.size());
            this.a.put(Integer.valueOf(mms.a), mms);
            a(mms.a);
        }
    }

    public void a(a aVar) {
        c(aVar.c());
        a(aVar.a());
        b(aVar.b());
    }
}
