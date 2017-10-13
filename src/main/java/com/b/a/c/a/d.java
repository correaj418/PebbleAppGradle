package com.b.a.c.a;

import com.b.a.a.c;
import com.b.a.ac;
import com.b.a.b.b;
import com.b.a.c.e.f;
import com.b.a.c.n;
import com.b.a.c.s;
import com.b.a.k;
import com.b.a.m;
import com.b.a.p;
import com.b.a.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class d extends f implements a<s> {
    w d;
    n e;
    k f;
    String g;
    String h = "multipart/form-data";
    a i;
    int j;
    int k;
    private ArrayList<e> n;

    public interface a {
        void a(e eVar);
    }

    public void a(m mVar, com.b.a.a.a aVar) {
        a(mVar);
        b(aVar);
    }

    void e() {
        if (this.f != null) {
            if (this.e == null) {
                this.e = new n();
            }
            this.e.b(this.g, this.f.p());
            this.g = null;
            this.f = null;
        }
    }

    protected void g() {
        super.g();
        e();
    }

    protected void i() {
        final n nVar = new n();
        this.d = new w();
        this.d.a(new com.b.a.w.a(this) {
            final /* synthetic */ d b;

            public void a(String str) {
                if ("\r".equals(str)) {
                    this.b.e();
                    this.b.d = null;
                    this.b.a(null);
                    e eVar = new e(nVar);
                    if (this.b.i != null) {
                        this.b.i.a(eVar);
                    }
                    if (this.b.f() != null) {
                        return;
                    }
                    if (eVar.d()) {
                        this.b.a(new com.b.a.a.d.a());
                        return;
                    }
                    this.b.g = eVar.b();
                    this.b.f = new k();
                    this.b.a(new com.b.a.a.d(this) {
                        final /* synthetic */ AnonymousClass1 a;

                        {
                            this.a = r1;
                        }

                        public void a(m mVar, k kVar) {
                            kVar.a(this.a.b.f);
                        }
                    });
                    return;
                }
                nVar.b(str);
            }
        });
        a(this.d);
    }

    public d(String[] strArr) {
        for (String split : strArr) {
            String[] split2 = split.split("=");
            if (split2.length == 2 && "boundary".equals(split2[0])) {
                a(split2[1]);
                return;
            }
        }
        b(new Exception("No boundary found for multipart/form-data"));
    }

    public void a(com.b.a.c.d dVar, final p pVar, final com.b.a.a.a aVar) {
        if (this.n != null) {
            b bVar = new b(new com.b.a.a.a(this) {
                final /* synthetic */ d b;

                public void a(Exception exception) {
                    aVar.a(exception);
                }
            });
            Iterator it = this.n.iterator();
            while (it.hasNext()) {
                final e eVar = (e) it.next();
                bVar.a(new c(this) {
                    final /* synthetic */ d c;

                    public void a(b bVar, com.b.a.a.a aVar) {
                        byte[] bytes = eVar.c().e(this.c.p()).getBytes();
                        ac.a(pVar, bytes, aVar);
                        d dVar = this.c;
                        dVar.j = bytes.length + dVar.j;
                    }
                }).a(new c(this) {
                    final /* synthetic */ d c;

                    public void a(b bVar, com.b.a.a.a aVar) {
                        long e = eVar.e();
                        if (e >= 0) {
                            d dVar = this.c;
                            dVar.j = (int) (e + ((long) dVar.j));
                        }
                        eVar.a(pVar, aVar);
                    }
                }).a(new c(this) {
                    final /* synthetic */ d b;

                    public void a(b bVar, com.b.a.a.a aVar) {
                        byte[] bytes = "\r\n".getBytes();
                        ac.a(pVar, bytes, aVar);
                        d dVar = this.b;
                        dVar.j = bytes.length + dVar.j;
                    }
                });
            }
            bVar.a(new c(this) {
                static final /* synthetic */ boolean a = (!d.class.desiredAssertionStatus());
                final /* synthetic */ d c;

                public void a(b bVar, com.b.a.a.a aVar) {
                    byte[] bytes = this.c.q().getBytes();
                    ac.a(pVar, bytes, aVar);
                    d dVar = this.c;
                    dVar.j = bytes.length + dVar.j;
                    if (!a && this.c.j != this.c.k) {
                        throw new AssertionError();
                    }
                }
            });
            bVar.c();
        }
    }

    public String a() {
        if (o() == null) {
            a("----------------------------" + UUID.randomUUID().toString().replace("-", ""));
        }
        return this.h + "; boundary=" + o();
    }

    public boolean b() {
        return false;
    }

    public int c() {
        if (o() == null) {
            a("----------------------------" + UUID.randomUUID().toString().replace("-", ""));
        }
        Iterator it = this.n.iterator();
        int i = 0;
        while (it.hasNext()) {
            e eVar = (e) it.next();
            String e = eVar.c().e(p());
            if (eVar.e() == -1) {
                return -1;
            }
            i = (int) (((eVar.e() + ((long) e.getBytes().length)) + ((long) "\r\n".length())) + ((long) i));
        }
        int length = q().getBytes().length + i;
        this.k = length;
        return length;
    }

    public void a(e eVar) {
        if (this.n == null) {
            this.n = new ArrayList();
        }
        this.n.add(eVar);
    }
}
