package com.google.a.b;

import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

class bk<K, V> extends y<K, V> {
    static final bk<Object, Object> b = new bk(null, null, af.a, 0, 0);
    private final transient ag<K, V>[] c;
    private final transient ag<K, V>[] d;
    private final transient Entry<K, V>[] e;
    private final transient int f;
    private final transient int g;
    private transient y<V, K> h;

    private final class a extends y<V, K> {
        final /* synthetic */ bk b;

        final class a extends ah<V, K> {
            final /* synthetic */ a a;

            public /* synthetic */ Iterator iterator() {
                return j_();
            }

            a(a aVar) {
                this.a = aVar;
            }

            af<V, K> c() {
                return this.a;
            }

            boolean g_() {
                return true;
            }

            public int hashCode() {
                return this.a.b.g;
            }

            public ce<Entry<V, K>> j_() {
                return f().j_();
            }

            ad<Entry<V, K>> g() {
                return new x<Entry<V, K>>(this) {
                    final /* synthetic */ a a;

                    {
                        this.a = r1;
                    }

                    public /* synthetic */ Object get(int i) {
                        return b(i);
                    }

                    public Entry<V, K> b(int i) {
                        Entry entry = this.a.a.b.e[i];
                        return ay.a(entry.getValue(), entry.getKey());
                    }

                    z<Entry<V, K>> b() {
                        return this.a;
                    }
                };
            }
        }

        private a(bk bkVar) {
            this.b = bkVar;
        }

        public int size() {
            return b().size();
        }

        public y<K, V> b() {
            return this.b;
        }

        public K get(@Nullable Object obj) {
            if (obj == null || this.b.d == null) {
                return null;
            }
            for (ag agVar = this.b.d[w.a(obj.hashCode()) & this.b.f]; agVar != null; agVar = agVar.b()) {
                if (obj.equals(agVar.getValue())) {
                    return agVar.getKey();
                }
            }
            return null;
        }

        am<Entry<V, K>> h() {
            return new a(this);
        }

        boolean c() {
            return false;
        }
    }

    private bk(ag<K, V>[] agVarArr, ag<K, V>[] agVarArr2, Entry<K, V>[] entryArr, int i, int i2) {
        this.c = agVarArr;
        this.d = agVarArr2;
        this.e = entryArr;
        this.f = i;
        this.g = i2;
    }

    @Nullable
    public V get(@Nullable Object obj) {
        return this.c == null ? null : bm.a(obj, this.c, this.f);
    }

    am<Entry<K, V>> h() {
        return isEmpty() ? am.h() : new a(this, this.e);
    }

    boolean k() {
        return true;
    }

    public int hashCode() {
        return this.g;
    }

    boolean c() {
        return false;
    }

    public int size() {
        return this.e.length;
    }

    public y<V, K> b() {
        if (isEmpty()) {
            return y.h_();
        }
        y<V, K> yVar = this.h;
        if (yVar != null) {
            return yVar;
        }
        yVar = new a();
        this.h = yVar;
        return yVar;
    }
}
