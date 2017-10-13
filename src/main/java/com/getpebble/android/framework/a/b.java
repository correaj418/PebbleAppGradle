package com.getpebble.android.framework.a;

import android.content.ContentResolver;
import com.getpebble.android.common.model.aw;
import com.getpebble.android.common.model.aw.d;
import com.getpebble.android.common.model.n;
import com.getpebble.android.common.model.n.c;
import com.getpebble.android.common.model.o;
import com.getpebble.android.common.model.o.a;
import com.getpebble.android.h.f;
import com.google.a.b.bt;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public abstract class b {
    public abstract void a(d dVar);

    public abstract void a(c cVar);

    public abstract void a(c cVar, long j, UUID uuid);

    public abstract void a(a aVar);

    public abstract void a(UUID uuid);

    public abstract void b(d dVar);

    public abstract void b(c cVar);

    public abstract void b(a aVar);

    public abstract void c(a aVar);

    public void a(Map<Long, com.getpebble.android.common.model.n.b> map, Map<Long, com.getpebble.android.common.model.n.b> map2) {
        com.getpebble.android.common.model.n.b bVar;
        c cVar;
        List<com.getpebble.android.common.model.n.b> linkedList = new LinkedList();
        Map hashMap = new HashMap();
        for (com.getpebble.android.common.model.n.b bVar2 : map.values()) {
            com.getpebble.android.common.model.n.b bVar3 = (com.getpebble.android.common.model.n.b) map2.get(Long.valueOf(bVar2.a.b));
            if (bVar3 == null) {
                linkedList.add(bVar2);
                f.a("CalendarProcessor", "Adding to eventsToInsert: " + bVar2);
            } else if (!bVar2.equals(bVar3)) {
                hashMap.put(bVar3, bVar2);
                f.a("CalendarProcessor", "Adding to eventsToUpdateLocalToSystemMap: " + bVar2 + " (!= " + bVar3 + ")");
            }
        }
        for (com.getpebble.android.common.model.n.b bVar22 : map2.values()) {
            Iterator it;
            if (!map.containsKey(Long.valueOf(bVar22.a.b))) {
                it = linkedList.iterator();
                while (it.hasNext()) {
                    bVar3 = (com.getpebble.android.common.model.n.b) it.next();
                    if ((bVar3.a.c == bVar22.a.c || bVar3.a.r == bVar22.a.c) && bVar3.a.i == bVar22.a.i) {
                        com.getpebble.android.common.b.a.f.d("CalendarProcessor", "Treating insert and delete as update for " + bVar3.a + " / " + bVar22.a);
                        it.remove();
                        hashMap.put(bVar22, bVar3);
                        break;
                    }
                }
                com.getpebble.android.common.b.a.f.d("CalendarProcessor", "Marking event as deleted: " + bVar22.a);
                if (bVar22.a instanceof c) {
                    cVar = (c) bVar22.a;
                    b(cVar);
                    if (c(cVar)) {
                        a(cVar.a);
                        for (n.a aVar : bVar22.b) {
                            if (aVar instanceof n.f) {
                                a(((n.f) aVar).b());
                            } else {
                                com.getpebble.android.common.b.a.f.f("CalendarProcessor", "Calendar Alert not instance of timeline calendar alert");
                            }
                        }
                    }
                } else {
                    com.getpebble.android.common.b.a.f.a("CalendarProcessor", "Invalid local event instance instance: " + bVar22.a.getClass().getSimpleName());
                }
            }
        }
        for (com.getpebble.android.common.model.n.b bVar222 : linkedList) {
            c cVar2 = new c(bVar222.a, a(bVar222));
            com.getpebble.android.common.b.a.f.d("CalendarProcessor", "inserting record: " + cVar2.toString());
            if (c(cVar2)) {
                a(cVar2.b());
                Object obj = cVar2.i > System.currentTimeMillis() ? 1 : null;
                Object obj2;
                if (cVar2.l == 3) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (!(obj == null || r4 == null || !bVar222.a.s)) {
                    a(cVar2.c());
                }
                for (n.a aVar2 : bVar222.b) {
                    a(n.f.a(aVar2, cVar2));
                }
            }
            a(cVar2);
        }
        for (Entry entry : hashMap.entrySet()) {
            bVar3 = (com.getpebble.android.common.model.n.b) entry.getKey();
            bVar222 = (com.getpebble.android.common.model.n.b) entry.getValue();
            if (bVar3.a instanceof c) {
                c cVar3;
                c cVar4 = (c) bVar3.a;
                if (bVar3.a.equals(bVar222.a)) {
                    cVar3 = null;
                } else {
                    com.getpebble.android.common.b.a.f.d("CalendarProcessor", "updating event: " + bVar3.a + " -> " + bVar222.a);
                    c cVar5 = new c(bVar222.a, cVar4.a);
                    if (c(cVar5)) {
                        b(cVar5.b());
                    }
                    a(cVar5, bVar3.a.b, cVar4.a);
                    cVar3 = cVar5;
                }
                if (c(cVar4)) {
                    for (n.a aVar3 : a(bVar3.b, bVar222.b)) {
                        if (aVar3 instanceof n.f) {
                            a(((n.f) aVar3).b());
                        } else {
                            com.getpebble.android.common.b.a.f.a("CalendarProcessor", "Calendar Alert not instance of timeline calendar alert");
                        }
                    }
                    Set set = bVar3.b;
                    Set set2 = bVar222.b;
                    for (n.a aVar22 : b(set, set2)) {
                        if (cVar3 != null) {
                            cVar = cVar3;
                        } else {
                            cVar = cVar4;
                        }
                        a(n.f.a(aVar22, cVar));
                    }
                    if (cVar3 != null) {
                        for (n.a aVar222 : c(set2, set)) {
                            n.f fVar = (n.f) aVar222;
                            b(n.f.a(fVar, cVar3, fVar.b()));
                            f.a("CalendarProcessor", "...updating calendar alert: " + fVar + " / " + cVar3);
                        }
                    }
                }
            } else {
                com.getpebble.android.common.b.a.f.a("CalendarProcessor", "Invalid local event instance instance: " + bVar3.a.getClass().getSimpleName());
            }
        }
    }

    public void b(Map<Long, a> map, Map<Long, a> map2) {
        ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
        Set hashSet = new HashSet();
        for (a aVar : map.values()) {
            a aVar2 = (a) map2.get(Long.valueOf(aVar.a));
            if (aVar2 == null) {
                if (o.a(contentResolver, aVar.c)) {
                    hashSet.add(aVar.c);
                }
                if (hashSet.contains(aVar.c)) {
                    aVar.h = aVar.f;
                } else {
                    aVar.h = false;
                }
                com.getpebble.android.common.b.a.f.d("CalendarProcessor", "inserting calendar: " + aVar);
                a(aVar);
            } else if (!aVar2.equals(aVar)) {
                com.getpebble.android.common.b.a.f.d("CalendarProcessor", "updating calendar: " + aVar2);
                aVar.h = aVar2.h;
                b(aVar);
            }
        }
        for (a aVar3 : map2.values()) {
            if (!map.containsKey(Long.valueOf(aVar3.a))) {
                com.getpebble.android.common.b.a.f.d("CalendarProcessor", "Marking calendar as deleted: " + aVar3);
                c(aVar3);
            }
        }
    }

    Set<n.a> a(Set<n.a> set, Set<n.a> set2) {
        return bt.c(set, set2);
    }

    Set<n.a> b(Set<n.a> set, Set<n.a> set2) {
        return bt.c(set2, set);
    }

    Set<n.a> c(Set<n.a> set, Set<n.a> set2) {
        return bt.b(set2, set);
    }

    protected UUID a(com.getpebble.android.common.model.n.b bVar) {
        d dVar = bVar.a.t;
        if (dVar == null) {
            return UUID.randomUUID();
        }
        return dVar.b();
    }

    private boolean c(c cVar) {
        d dVar = cVar.t;
        if (dVar != null && dVar.c().equals(aw.f)) {
            return false;
        }
        return true;
    }
}
