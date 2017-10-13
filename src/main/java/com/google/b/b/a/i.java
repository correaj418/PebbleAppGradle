package com.google.b.b.a;

import com.google.b.b.c;
import com.google.b.b.d;
import com.google.b.b.h;
import com.google.b.e;
import com.google.b.f;
import com.google.b.u;
import com.google.b.w;
import com.google.b.x;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class i implements x {
    private final c a;
    private final e b;
    private final d c;
    private final d d;

    static abstract class b {
        final String h;
        final boolean i;
        final boolean j;

        abstract void a(com.google.b.d.a aVar, Object obj);

        abstract void a(com.google.b.d.c cVar, Object obj);

        abstract boolean a(Object obj);

        protected b(String str, boolean z, boolean z2) {
            this.h = str;
            this.i = z;
            this.j = z2;
        }
    }

    public static final class a<T> extends w<T> {
        private final h<T> a;
        private final Map<String, b> b;

        a(h<T> hVar, Map<String, b> map) {
            this.a = hVar;
            this.b = map;
        }

        public T b(com.google.b.d.a aVar) {
            if (aVar.f() == com.google.b.d.b.NULL) {
                aVar.j();
                return null;
            }
            T a = this.a.a();
            try {
                aVar.c();
                while (aVar.e()) {
                    b bVar = (b) this.b.get(aVar.g());
                    if (bVar == null || !bVar.j) {
                        aVar.n();
                    } else {
                        bVar.a(aVar, (Object) a);
                    }
                }
                aVar.d();
                return a;
            } catch (Throwable e) {
                throw new u(e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public void a(com.google.b.d.c cVar, T t) {
            if (t == null) {
                cVar.f();
                return;
            }
            cVar.d();
            try {
                for (b bVar : this.b.values()) {
                    if (bVar.a(t)) {
                        cVar.a(bVar.h);
                        bVar.a(cVar, (Object) t);
                    }
                }
                cVar.e();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    public i(c cVar, e eVar, d dVar, d dVar2) {
        this.a = cVar;
        this.b = eVar;
        this.c = dVar;
        this.d = dVar2;
    }

    public boolean a(Field field, boolean z) {
        return a(field, z, this.c);
    }

    static boolean a(Field field, boolean z, d dVar) {
        return (dVar.a(field.getType(), z) || dVar.a(field, z)) ? false : true;
    }

    private List<String> a(Field field) {
        com.google.b.a.c cVar = (com.google.b.a.c) field.getAnnotation(com.google.b.a.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.b.translateName(field));
        }
        String a = cVar.a();
        String[] b = cVar.b();
        if (b.length == 0) {
            return Collections.singletonList(a);
        }
        List<String> arrayList = new ArrayList(b.length + 1);
        arrayList.add(a);
        for (Object add : b) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public <T> w<T> a(f fVar, com.google.b.c.a<T> aVar) {
        Class rawType = aVar.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new a(this.a.a((com.google.b.c.a) aVar), a(fVar, (com.google.b.c.a) aVar, rawType));
        }
        return null;
    }

    private b a(f fVar, Field field, String str, com.google.b.c.a<?> aVar, boolean z, boolean z2) {
        final boolean a = com.google.b.b.i.a(aVar.getRawType());
        com.google.b.a.b bVar = (com.google.b.a.b) field.getAnnotation(com.google.b.a.b.class);
        w wVar = null;
        if (bVar != null) {
            wVar = this.d.a(this.a, fVar, aVar, bVar);
        }
        final boolean z3 = wVar != null;
        if (wVar == null) {
            wVar = fVar.a((com.google.b.c.a) aVar);
        }
        final Field field2 = field;
        final f fVar2 = fVar;
        final com.google.b.c.a<?> aVar2 = aVar;
        return new b(this, str, z, z2) {
            final /* synthetic */ i g;

            void a(com.google.b.d.c cVar, Object obj) {
                w wVar;
                Object obj2 = field2.get(obj);
                if (z3) {
                    wVar = wVar;
                } else {
                    wVar = new m(fVar2, wVar, aVar2.getType());
                }
                wVar.a(cVar, obj2);
            }

            void a(com.google.b.d.a aVar, Object obj) {
                Object b = wVar.b(aVar);
                if (b != null || !a) {
                    field2.set(obj, b);
                }
            }

            public boolean a(Object obj) {
                if (this.i && field2.get(obj) != obj) {
                    return true;
                }
                return false;
            }
        };
    }

    private Map<String, b> a(f fVar, com.google.b.c.a<?> aVar, Class<?> cls) {
        Map<String, b> linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = aVar.getType();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean a = a(field, true);
                boolean a2 = a(field, false);
                if (a || a2) {
                    field.setAccessible(true);
                    Type a3 = com.google.b.b.b.a(aVar.getType(), (Class) cls, field.getGenericType());
                    List a4 = a(field);
                    b bVar = null;
                    int i = 0;
                    while (i < a4.size()) {
                        String str = (String) a4.get(i);
                        if (i != 0) {
                            a = false;
                        }
                        b bVar2 = (b) linkedHashMap.put(str, a(fVar, field, str, com.google.b.c.a.get(a3), a, a2));
                        if (bVar != null) {
                            bVar2 = bVar;
                        }
                        i++;
                        bVar = bVar2;
                    }
                    if (bVar != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + bVar.h);
                    }
                }
            }
            aVar = com.google.b.c.a.get(com.google.b.b.b.a(aVar.getType(), (Class) cls, cls.getGenericSuperclass()));
            cls = aVar.getRawType();
        }
        return linkedHashMap;
    }
}
