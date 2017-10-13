package android.support.v7.widget;

import android.support.v4.e.e;
import android.support.v7.widget.RecyclerView.e.c;
import android.support.v7.widget.RecyclerView.u;

class bc {
    final android.support.v4.e.a<u, a> a = new android.support.v4.e.a();
    final e<u> b = new e();

    interface b {
        void a(u uVar);

        void a(u uVar, c cVar, c cVar2);

        void b(u uVar, c cVar, c cVar2);

        void c(u uVar, c cVar, c cVar2);
    }

    static class a {
        static android.support.v4.e.h.a<a> d = new android.support.v4.e.h.b(20);
        int a;
        c b;
        c c;

        private a() {
        }

        static a a() {
            a aVar = (a) d.a();
            return aVar == null ? new a() : aVar;
        }

        static void a(a aVar) {
            aVar.a = 0;
            aVar.b = null;
            aVar.c = null;
            d.a(aVar);
        }

        static void b() {
            do {
            } while (d.a() != null);
        }
    }

    bc() {
    }

    void a() {
        this.a.clear();
        this.b.c();
    }

    void a(u uVar, c cVar) {
        a aVar = (a) this.a.get(uVar);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(uVar, aVar);
        }
        aVar.b = cVar;
        aVar.a |= 4;
    }

    boolean a(u uVar) {
        a aVar = (a) this.a.get(uVar);
        return (aVar == null || (aVar.a & 1) == 0) ? false : true;
    }

    c b(u uVar) {
        return a(uVar, 4);
    }

    c c(u uVar) {
        return a(uVar, 8);
    }

    private c a(u uVar, int i) {
        c cVar = null;
        int a = this.a.a((Object) uVar);
        if (a >= 0) {
            a aVar = (a) this.a.c(a);
            if (!(aVar == null || (aVar.a & i) == 0)) {
                aVar.a &= i ^ -1;
                if (i == 4) {
                    cVar = aVar.b;
                } else if (i == 8) {
                    cVar = aVar.c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((aVar.a & 12) == 0) {
                    this.a.d(a);
                    a.a(aVar);
                }
            }
        }
        return cVar;
    }

    void a(long j, u uVar) {
        this.b.b(j, uVar);
    }

    void b(u uVar, c cVar) {
        a aVar = (a) this.a.get(uVar);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(uVar, aVar);
        }
        aVar.a |= 2;
        aVar.b = cVar;
    }

    boolean d(u uVar) {
        a aVar = (a) this.a.get(uVar);
        return (aVar == null || (aVar.a & 4) == 0) ? false : true;
    }

    u a(long j) {
        return (u) this.b.a(j);
    }

    void c(u uVar, c cVar) {
        a aVar = (a) this.a.get(uVar);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(uVar, aVar);
        }
        aVar.c = cVar;
        aVar.a |= 8;
    }

    void e(u uVar) {
        a aVar = (a) this.a.get(uVar);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(uVar, aVar);
        }
        r0.a |= 1;
    }

    void f(u uVar) {
        a aVar = (a) this.a.get(uVar);
        if (aVar != null) {
            aVar.a &= -2;
        }
    }

    void a(b bVar) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            u uVar = (u) this.a.b(size);
            a aVar = (a) this.a.d(size);
            if ((aVar.a & 3) == 3) {
                bVar.a(uVar);
            } else if ((aVar.a & 1) != 0) {
                if (aVar.b == null) {
                    bVar.a(uVar);
                } else {
                    bVar.a(uVar, aVar.b, aVar.c);
                }
            } else if ((aVar.a & 14) == 14) {
                bVar.b(uVar, aVar.b, aVar.c);
            } else if ((aVar.a & 12) == 12) {
                bVar.c(uVar, aVar.b, aVar.c);
            } else if ((aVar.a & 4) != 0) {
                bVar.a(uVar, aVar.b, null);
            } else if ((aVar.a & 8) != 0) {
                bVar.b(uVar, aVar.b, aVar.c);
            } else if ((aVar.a & 2) != 0) {
            }
            a.a(aVar);
        }
    }

    void g(u uVar) {
        for (int b = this.b.b() - 1; b >= 0; b--) {
            if (uVar == this.b.c(b)) {
                this.b.a(b);
                break;
            }
        }
        a aVar = (a) this.a.remove(uVar);
        if (aVar != null) {
            a.a(aVar);
        }
    }

    void b() {
        a.b();
    }

    public void h(u uVar) {
        f(uVar);
    }
}
