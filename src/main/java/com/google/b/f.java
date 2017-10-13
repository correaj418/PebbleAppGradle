package com.google.b;

import com.google.b.b.a.b;
import com.google.b.b.a.e;
import com.google.b.b.a.g;
import com.google.b.b.a.h;
import com.google.b.b.a.i;
import com.google.b.b.a.j;
import com.google.b.b.a.k;
import com.google.b.b.a.n;
import com.google.b.b.c;
import com.google.b.b.d;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class f {
    private static final com.google.b.c.a<?> a = new com.google.b.c.a<Object>() {
    };
    private final ThreadLocal<Map<com.google.b.c.a<?>, a<?>>> b;
    private final Map<com.google.b.c.a<?>, w<?>> c;
    private final List<x> d;
    private final c e;
    private final d f;
    private final e g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final com.google.b.b.a.d m;

    static class a<T> extends w<T> {
        private w<T> a;

        a() {
        }

        public void a(w<T> wVar) {
            if (this.a != null) {
                throw new AssertionError();
            }
            this.a = wVar;
        }

        public T b(com.google.b.d.a aVar) {
            if (this.a != null) {
                return this.a.b(aVar);
            }
            throw new IllegalStateException();
        }

        public void a(com.google.b.d.c cVar, T t) {
            if (this.a == null) {
                throw new IllegalStateException();
            }
            this.a.a(cVar, t);
        }
    }

    public f() {
        this(d.a, d.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, v.DEFAULT, Collections.emptyList());
    }

    f(d dVar, e eVar, Map<Type, h<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, v vVar, List<x> list) {
        this.b = new ThreadLocal();
        this.c = new ConcurrentHashMap();
        this.e = new c(map);
        this.f = dVar;
        this.g = eVar;
        this.h = z;
        this.j = z3;
        this.i = z4;
        this.k = z5;
        this.l = z6;
        List arrayList = new ArrayList();
        arrayList.add(n.Y);
        arrayList.add(h.a);
        arrayList.add(dVar);
        arrayList.addAll(list);
        arrayList.add(n.D);
        arrayList.add(n.m);
        arrayList.add(n.g);
        arrayList.add(n.i);
        arrayList.add(n.k);
        w a = a(vVar);
        arrayList.add(n.a(Long.TYPE, Long.class, a));
        arrayList.add(n.a(Double.TYPE, Double.class, a(z7)));
        arrayList.add(n.a(Float.TYPE, Float.class, b(z7)));
        arrayList.add(n.x);
        arrayList.add(n.o);
        arrayList.add(n.q);
        arrayList.add(n.a(AtomicLong.class, a(a)));
        arrayList.add(n.a(AtomicLongArray.class, b(a)));
        arrayList.add(n.s);
        arrayList.add(n.z);
        arrayList.add(n.F);
        arrayList.add(n.H);
        arrayList.add(n.a(BigDecimal.class, n.B));
        arrayList.add(n.a(BigInteger.class, n.C));
        arrayList.add(n.J);
        arrayList.add(n.L);
        arrayList.add(n.P);
        arrayList.add(n.R);
        arrayList.add(n.W);
        arrayList.add(n.N);
        arrayList.add(n.d);
        arrayList.add(com.google.b.b.a.c.a);
        arrayList.add(n.U);
        arrayList.add(k.a);
        arrayList.add(j.a);
        arrayList.add(n.S);
        arrayList.add(com.google.b.b.a.a.a);
        arrayList.add(n.b);
        arrayList.add(new b(this.e));
        arrayList.add(new g(this.e, z2));
        this.m = new com.google.b.b.a.d(this.e);
        arrayList.add(this.m);
        arrayList.add(n.Z);
        arrayList.add(new i(this.e, eVar, dVar, this.m));
        this.d = Collections.unmodifiableList(arrayList);
    }

    private w<Number> a(boolean z) {
        if (z) {
            return n.v;
        }
        return new w<Number>(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public /* synthetic */ Object b(com.google.b.d.a aVar) {
                return a(aVar);
            }

            public Double a(com.google.b.d.a aVar) {
                if (aVar.f() != com.google.b.d.b.NULL) {
                    return Double.valueOf(aVar.k());
                }
                aVar.j();
                return null;
            }

            public void a(com.google.b.d.c cVar, Number number) {
                if (number == null) {
                    cVar.f();
                    return;
                }
                f.a(number.doubleValue());
                cVar.a(number);
            }
        };
    }

    private w<Number> b(boolean z) {
        if (z) {
            return n.u;
        }
        return new w<Number>(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public /* synthetic */ Object b(com.google.b.d.a aVar) {
                return a(aVar);
            }

            public Float a(com.google.b.d.a aVar) {
                if (aVar.f() != com.google.b.d.b.NULL) {
                    return Float.valueOf((float) aVar.k());
                }
                aVar.j();
                return null;
            }

            public void a(com.google.b.d.c cVar, Number number) {
                if (number == null) {
                    cVar.f();
                    return;
                }
                f.a((double) number.floatValue());
                cVar.a(number);
            }
        };
    }

    static void a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static w<Number> a(v vVar) {
        if (vVar == v.DEFAULT) {
            return n.t;
        }
        return new w<Number>() {
            public /* synthetic */ Object b(com.google.b.d.a aVar) {
                return a(aVar);
            }

            public Number a(com.google.b.d.a aVar) {
                if (aVar.f() != com.google.b.d.b.NULL) {
                    return Long.valueOf(aVar.l());
                }
                aVar.j();
                return null;
            }

            public void a(com.google.b.d.c cVar, Number number) {
                if (number == null) {
                    cVar.f();
                } else {
                    cVar.b(number.toString());
                }
            }
        };
    }

    private static w<AtomicLong> a(final w<Number> wVar) {
        return new w<AtomicLong>() {
            public /* synthetic */ Object b(com.google.b.d.a aVar) {
                return a(aVar);
            }

            public void a(com.google.b.d.c cVar, AtomicLong atomicLong) {
                wVar.a(cVar, Long.valueOf(atomicLong.get()));
            }

            public AtomicLong a(com.google.b.d.a aVar) {
                return new AtomicLong(((Number) wVar.b(aVar)).longValue());
            }
        }.a();
    }

    private static w<AtomicLongArray> b(final w<Number> wVar) {
        return new w<AtomicLongArray>() {
            public /* synthetic */ Object b(com.google.b.d.a aVar) {
                return a(aVar);
            }

            public void a(com.google.b.d.c cVar, AtomicLongArray atomicLongArray) {
                cVar.b();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    wVar.a(cVar, Long.valueOf(atomicLongArray.get(i)));
                }
                cVar.c();
            }

            public AtomicLongArray a(com.google.b.d.a aVar) {
                List arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(Long.valueOf(((Number) wVar.b(aVar)).longValue()));
                }
                aVar.b();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }
        }.a();
    }

    public <T> w<T> a(com.google.b.c.a<T> aVar) {
        Object obj;
        Map map = this.c;
        if (aVar == null) {
            obj = a;
        } else {
            com.google.b.c.a<T> aVar2 = aVar;
        }
        w<T> wVar = (w) map.get(obj);
        if (wVar == null) {
            Map map2;
            Map map3 = (Map) this.b.get();
            Object obj2 = null;
            if (map3 == null) {
                HashMap hashMap = new HashMap();
                this.b.set(hashMap);
                map2 = hashMap;
                obj2 = 1;
            } else {
                map2 = map3;
            }
            a aVar3 = (a) map2.get(aVar);
            if (aVar3 == null) {
                try {
                    a aVar4 = new a();
                    map2.put(aVar, aVar4);
                    for (x a : this.d) {
                        wVar = a.a(this, aVar);
                        if (wVar != null) {
                            aVar4.a(wVar);
                            this.c.put(aVar, wVar);
                            map2.remove(aVar);
                            if (obj2 != null) {
                                this.b.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    map2.remove(aVar);
                    if (obj2 != null) {
                        this.b.remove();
                    }
                }
            }
        }
        return wVar;
    }

    public <T> w<T> a(x xVar, com.google.b.c.a<T> aVar) {
        if (!this.d.contains(xVar)) {
            xVar = this.m;
        }
        Object obj = null;
        for (x xVar2 : this.d) {
            if (obj != null) {
                w<T> a = xVar2.a(this, aVar);
                if (a != null) {
                    return a;
                }
            } else if (xVar2 == xVar) {
                obj = 1;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public <T> w<T> a(Class<T> cls) {
        return a(com.google.b.c.a.get((Class) cls));
    }

    public l a(Object obj) {
        if (obj == null) {
            return n.a;
        }
        return a(obj, obj.getClass());
    }

    public l a(Object obj, Type type) {
        com.google.b.d.c fVar = new com.google.b.b.a.f();
        a(obj, type, fVar);
        return fVar.a();
    }

    public String b(Object obj) {
        if (obj == null) {
            return a(n.a);
        }
        return b(obj, obj.getClass());
    }

    public String b(Object obj, Type type) {
        Appendable stringWriter = new StringWriter();
        a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void a(Object obj, Appendable appendable) {
        if (obj != null) {
            a(obj, obj.getClass(), appendable);
        } else {
            a(n.a, appendable);
        }
    }

    public void a(Object obj, Type type, Appendable appendable) {
        try {
            a(obj, type, a(com.google.b.b.j.a(appendable)));
        } catch (Throwable e) {
            throw new m(e);
        }
    }

    public void a(Object obj, Type type, com.google.b.d.c cVar) {
        w a = a(com.google.b.c.a.get(type));
        boolean g = cVar.g();
        cVar.b(true);
        boolean h = cVar.h();
        cVar.c(this.i);
        boolean i = cVar.i();
        cVar.d(this.h);
        try {
            a.a(cVar, obj);
            cVar.b(g);
            cVar.c(h);
            cVar.d(i);
        } catch (Throwable e) {
            throw new m(e);
        } catch (Throwable th) {
            cVar.b(g);
            cVar.c(h);
            cVar.d(i);
        }
    }

    public String a(l lVar) {
        Appendable stringWriter = new StringWriter();
        a(lVar, stringWriter);
        return stringWriter.toString();
    }

    public void a(l lVar, Appendable appendable) {
        try {
            a(lVar, a(com.google.b.b.j.a(appendable)));
        } catch (Throwable e) {
            throw new m(e);
        }
    }

    public com.google.b.d.c a(Writer writer) {
        if (this.j) {
            writer.write(")]}'\n");
        }
        com.google.b.d.c cVar = new com.google.b.d.c(writer);
        if (this.k) {
            cVar.c("  ");
        }
        cVar.d(this.h);
        return cVar;
    }

    public com.google.b.d.a a(Reader reader) {
        com.google.b.d.a aVar = new com.google.b.d.a(reader);
        aVar.a(this.l);
        return aVar;
    }

    public void a(l lVar, com.google.b.d.c cVar) {
        boolean g = cVar.g();
        cVar.b(true);
        boolean h = cVar.h();
        cVar.c(this.i);
        boolean i = cVar.i();
        cVar.d(this.h);
        try {
            com.google.b.b.j.a(lVar, cVar);
            cVar.b(g);
            cVar.c(h);
            cVar.d(i);
        } catch (Throwable e) {
            throw new m(e);
        } catch (Throwable th) {
            cVar.b(g);
            cVar.c(h);
            cVar.d(i);
        }
    }

    public <T> T a(String str, Class<T> cls) {
        return com.google.b.b.i.a((Class) cls).cast(a(str, (Type) cls));
    }

    public <T> T a(String str, Type type) {
        if (str == null) {
            return null;
        }
        return a(new StringReader(str), type);
    }

    public <T> T a(Reader reader, Class<T> cls) {
        com.google.b.d.a a = a(reader);
        Object a2 = a(a, (Type) cls);
        a(a2, a);
        return com.google.b.b.i.a((Class) cls).cast(a2);
    }

    public <T> T a(Reader reader, Type type) {
        com.google.b.d.a a = a(reader);
        Object a2 = a(a, type);
        a(a2, a);
        return a2;
    }

    private static void a(Object obj, com.google.b.d.a aVar) {
        if (obj != null) {
            try {
                if (aVar.f() != com.google.b.d.b.END_DOCUMENT) {
                    throw new m("JSON document was not fully consumed.");
                }
            } catch (Throwable e) {
                throw new u(e);
            } catch (Throwable e2) {
                throw new m(e2);
            }
        }
    }

    public <T> T a(com.google.b.d.a aVar, Type type) {
        boolean z = true;
        boolean q = aVar.q();
        aVar.a(true);
        try {
            aVar.f();
            z = false;
            T b = a(com.google.b.c.a.get(type)).b(aVar);
            aVar.a(q);
            return b;
        } catch (Throwable e) {
            if (z) {
                aVar.a(q);
                return null;
            }
            throw new u(e);
        } catch (Throwable e2) {
            throw new u(e2);
        } catch (Throwable e22) {
            throw new u(e22);
        } catch (Throwable th) {
            aVar.a(q);
        }
    }

    public <T> T a(l lVar, Class<T> cls) {
        return com.google.b.b.i.a((Class) cls).cast(a(lVar, (Type) cls));
    }

    public <T> T a(l lVar, Type type) {
        if (lVar == null) {
            return null;
        }
        return a(new e(lVar), type);
    }

    public String toString() {
        return "{serializeNulls:" + this.h + "factories:" + this.d + ",instanceCreators:" + this.e + "}";
    }
}
