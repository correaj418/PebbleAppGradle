package com.google.a.b;

import com.google.a.a.h;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

abstract class e<E> extends h<E> implements Serializable {
    private transient Map<E, o> a;
    private transient long b = ((long) super.size());

    private class a implements Iterator<E> {
        final Iterator<Entry<E, o>> a;
        Entry<E, o> b;
        int c;
        boolean d;
        final /* synthetic */ e e;

        a(e eVar) {
            this.e = eVar;
            this.a = eVar.a.entrySet().iterator();
        }

        public boolean hasNext() {
            return this.c > 0 || this.a.hasNext();
        }

        public E next() {
            if (this.c == 0) {
                this.b = (Entry) this.a.next();
                this.c = ((o) this.b.getValue()).a();
            }
            this.c--;
            this.d = true;
            return this.b.getKey();
        }

        public void remove() {
            k.a(this.d);
            if (((o) this.b.getValue()).a() <= 0) {
                throw new ConcurrentModificationException();
            }
            if (((o) this.b.getValue()).b(-1) == 0) {
                this.a.remove();
            }
            this.e.b = this.e.b - 1;
            this.d = false;
        }
    }

    static /* synthetic */ long a(e eVar, long j) {
        long j2 = eVar.b - j;
        eVar.b = j2;
        return j2;
    }

    protected e(Map<E, o> map) {
        this.a = (Map) h.a((Object) map);
    }

    public Set<com.google.a.b.bc.a<E>> a() {
        return super.a();
    }

    Iterator<com.google.a.b.bc.a<E>> b() {
        final Iterator it = this.a.entrySet().iterator();
        return new Iterator<com.google.a.b.bc.a<E>>(this) {
            Entry<E, o> a;
            final /* synthetic */ e c;

            public /* synthetic */ Object next() {
                return a();
            }

            public boolean hasNext() {
                return it.hasNext();
            }

            public com.google.a.b.bc.a<E> a() {
                final Entry entry = (Entry) it.next();
                this.a = entry;
                return new a<E>(this) {
                    final /* synthetic */ AnonymousClass1 b;

                    public E a() {
                        return entry.getKey();
                    }

                    public int b() {
                        o oVar = (o) entry.getValue();
                        if (oVar == null || oVar.a() == 0) {
                            o oVar2 = (o) this.b.c.a.get(a());
                            if (oVar2 != null) {
                                return oVar2.a();
                            }
                        }
                        return oVar == null ? 0 : oVar.a();
                    }
                };
            }

            public void remove() {
                boolean z;
                if (this.a != null) {
                    z = true;
                } else {
                    z = false;
                }
                k.a(z);
                e.a(this.c, (long) ((o) this.a.getValue()).d(0));
                it.remove();
                this.a = null;
            }
        };
    }

    public void clear() {
        for (o c : this.a.values()) {
            c.c(0);
        }
        this.a.clear();
        this.b = 0;
    }

    int c() {
        return this.a.size();
    }

    public int size() {
        return com.google.a.f.a.b(this.b);
    }

    public Iterator<E> iterator() {
        return new a(this);
    }

    public int a(@Nullable Object obj) {
        o oVar = (o) ay.a(this.a, obj);
        return oVar == null ? 0 : oVar.a();
    }

    public int a(@Nullable E e, int i) {
        int i2 = 0;
        if (i == 0) {
            return a((Object) e);
        }
        h.a(i > 0, "occurrences cannot be negative: %s", Integer.valueOf(i));
        o oVar = (o) this.a.get(e);
        if (oVar == null) {
            this.a.put(e, new o(i));
        } else {
            boolean z;
            int a = oVar.a();
            if (((long) a) + ((long) i) <= 2147483647L) {
                z = true;
            } else {
                z = false;
            }
            h.a(z, "too many occurrences: %s", Long.valueOf(((long) a) + ((long) i)));
            oVar.a(i);
            i2 = a;
        }
        this.b += (long) i;
        return i2;
    }

    public int b(@Nullable Object obj, int i) {
        if (i == 0) {
            return a(obj);
        }
        h.a(i > 0, "occurrences cannot be negative: %s", Integer.valueOf(i));
        o oVar = (o) this.a.get(obj);
        if (oVar == null) {
            return 0;
        }
        int a = oVar.a();
        if (a <= i) {
            this.a.remove(obj);
            i = a;
        }
        oVar.b(-i);
        this.b -= (long) i;
        return a;
    }

    public int c(@Nullable E e, int i) {
        int a;
        k.a(i, "count");
        if (i == 0) {
            a = a((o) this.a.remove(e), i);
        } else {
            o oVar = (o) this.a.get(e);
            int a2 = a(oVar, i);
            if (oVar == null) {
                this.a.put(e, new o(i));
            }
            a = a2;
        }
        this.b += (long) (i - a);
        return a;
    }

    private static int a(o oVar, int i) {
        if (oVar == null) {
            return 0;
        }
        return oVar.d(i);
    }
}
