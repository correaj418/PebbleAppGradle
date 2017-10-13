package com.google.b.b.a;

import com.google.b.b.c;
import com.google.b.b.e;
import com.google.b.b.h;
import com.google.b.b.j;
import com.google.b.d.b;
import com.google.b.f;
import com.google.b.l;
import com.google.b.r;
import com.google.b.u;
import com.google.b.w;
import com.google.b.x;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class g implements x {
    final boolean a;
    private final c b;

    private final class a<K, V> extends w<Map<K, V>> {
        final /* synthetic */ g a;
        private final w<K> b;
        private final w<V> c;
        private final h<? extends Map<K, V>> d;

        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public a(g gVar, f fVar, Type type, w<K> wVar, Type type2, w<V> wVar2, h<? extends Map<K, V>> hVar) {
            this.a = gVar;
            this.b = new m(fVar, wVar, type);
            this.c = new m(fVar, wVar2, type2);
            this.d = hVar;
        }

        public Map<K, V> a(com.google.b.d.a aVar) {
            b f = aVar.f();
            if (f == b.NULL) {
                aVar.j();
                return null;
            }
            Map<K, V> map = (Map) this.d.a();
            Object b;
            if (f == b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.e()) {
                    aVar.a();
                    b = this.b.b(aVar);
                    if (map.put(b, this.c.b(aVar)) != null) {
                        throw new u("duplicate key: " + b);
                    }
                    aVar.b();
                }
                aVar.b();
                return map;
            }
            aVar.c();
            while (aVar.e()) {
                e.a.a(aVar);
                b = this.b.b(aVar);
                if (map.put(b, this.c.b(aVar)) != null) {
                    throw new u("duplicate key: " + b);
                }
            }
            aVar.d();
            return map;
        }

        public void a(com.google.b.d.c cVar, Map<K, V> map) {
            int i = 0;
            if (map == null) {
                cVar.f();
            } else if (this.a.a) {
                List arrayList = new ArrayList(map.size());
                List arrayList2 = new ArrayList(map.size());
                int i2 = 0;
                for (Entry entry : map.entrySet()) {
                    int i3;
                    l a = this.b.a(entry.getKey());
                    arrayList.add(a);
                    arrayList2.add(entry.getValue());
                    if (a.h() || a.i()) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    i2 = i3 | i2;
                }
                if (i2 != 0) {
                    cVar.b();
                    while (i < arrayList.size()) {
                        cVar.b();
                        j.a((l) arrayList.get(i), cVar);
                        this.c.a(cVar, arrayList2.get(i));
                        cVar.c();
                        i++;
                    }
                    cVar.c();
                    return;
                }
                cVar.d();
                while (i < arrayList.size()) {
                    cVar.a(a((l) arrayList.get(i)));
                    this.c.a(cVar, arrayList2.get(i));
                    i++;
                }
                cVar.e();
            } else {
                cVar.d();
                for (Entry entry2 : map.entrySet()) {
                    cVar.a(String.valueOf(entry2.getKey()));
                    this.c.a(cVar, entry2.getValue());
                }
                cVar.e();
            }
        }

        private String a(l lVar) {
            if (lVar.j()) {
                r n = lVar.n();
                if (n.p()) {
                    return String.valueOf(n.b());
                }
                if (n.a()) {
                    return Boolean.toString(n.g());
                }
                if (n.q()) {
                    return n.c();
                }
                throw new AssertionError();
            } else if (lVar.k()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }

    public g(c cVar, boolean z) {
        this.b = cVar;
        this.a = z;
    }

    public <T> w<T> a(f fVar, com.google.b.c.a<T> aVar) {
        Type type = aVar.getType();
        if (!Map.class.isAssignableFrom(aVar.getRawType())) {
            return null;
        }
        Type[] b = com.google.b.b.b.b(type, com.google.b.b.b.e(type));
        w a = a(fVar, b[0]);
        w a2 = fVar.a(com.google.b.c.a.get(b[1]));
        h a3 = this.b.a((com.google.b.c.a) aVar);
        return new a(this, fVar, b[0], a, b[1], a2, a3);
    }

    private w<?> a(f fVar, Type type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            return n.f;
        }
        return fVar.a(com.google.b.c.a.get(type));
    }
}
