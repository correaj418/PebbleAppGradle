package com.getpebble.android.framework.i.a;

import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.i.a.a.a;
import com.getpebble.android.notifications.a.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class d {
    private final b a;
    private final Runnable b;
    private final a c;
    private List<b> d = Collections.synchronizedList(new ArrayList());

    public d(b bVar, Runnable runnable) {
        this.a = bVar;
        this.b = runnable;
        this.c = a.a(bVar.a());
    }

    public void a(b bVar) {
        this.d.add(bVar);
    }

    public Runnable a() {
        return this.b;
    }

    public b b() {
        return this.a;
    }

    public a c() {
        return this.c;
    }

    public List<b> d() {
        return this.d;
    }

    public List<b> e() {
        List<b> arrayList = new ArrayList();
        if (f()) {
            e eVar = new e(g());
            f.e("GroupMeta", "Found group summary. Uuid: " + eVar.c().a());
            synchronized (this.d) {
                for (b bVar : this.d) {
                    if (!bVar.r()) {
                        bVar.a(eVar.a());
                        for (com.getpebble.android.notifications.a.a.b a : eVar.b()) {
                            bVar.a(a);
                        }
                    }
                }
            }
            arrayList.addAll(this.d);
            if (!a(eVar, this.c)) {
                Collection<b> arrayList2 = new ArrayList();
                for (b bVar2 : arrayList) {
                    if (bVar2.r()) {
                        arrayList2.add(bVar2);
                    }
                }
                for (b bVar22 : arrayList2) {
                    f.d("GroupMeta", String.format(Locale.US, "Removing group summary #%d with uuid: %s", new Object[]{Integer.valueOf(arrayList2.indexOf(bVar22)), bVar22.a()}));
                }
                arrayList.removeAll(arrayList2);
            }
            return arrayList;
        }
        f.d("GroupMeta", "No group summary, displaying all notifications");
        return this.d;
    }

    private boolean f() {
        return g() != null;
    }

    private b g() {
        for (b bVar : d()) {
            if (bVar.r()) {
                return bVar;
            }
        }
        return null;
    }

    protected boolean a(e eVar, a aVar) {
        if (h()) {
            return false;
        }
        return aVar.a(eVar.c());
    }

    private boolean h() {
        for (b bVar : d()) {
            if (!bVar.r() && !bVar.equals(g())) {
                return true;
            }
        }
        return false;
    }
}
