package com.b.b;

import com.b.a.b.e;
import com.b.a.b.f;
import com.b.a.c.d;
import com.b.b.a.b;
import com.b.b.a.g;
import com.b.b.a.j;
import com.b.b.h.g.a;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;

class c implements b {
    String a;
    String b;
    b c;
    boolean d;
    ArrayList<j> e;
    o f;
    int g;
    int h;
    boolean i;
    boolean j;
    ArrayList<g> k;

    c() {
    }

    public void a() {
        this.a = k.a(this.f, this.g, this.h, this.i, this.j);
        this.b = k.a(this.a, this.e);
    }

    private boolean a(String str) {
        j jVar = this.f.a;
        if (this.j) {
            if (str == null || !str.startsWith("file:/")) {
                return false;
            }
            File file = new File(URI.create(str));
            if (!file.exists()) {
                return false;
            }
            a a = com.b.b.h.g.a(file.getAbsolutePath());
            if (a == null || !com.b.b.h.g.a(a.a)) {
                new t(jVar, this.a, this.i, null).a(null, new x(null, y.LOADED_FROM_CACHE, null, null, file));
                return true;
            }
        }
        boolean z = !this.d;
        for (u a2 : jVar.g().c()) {
            e a3 = a2.a(this.f.b.b(), jVar, this.a, str, this.g, this.h, this.i);
            if (a3 != null) {
                final a qVar = new q(jVar, this.a, z);
                a3.a(new f<b>(this) {
                    final /* synthetic */ c b;

                    public void a(Exception exception, b bVar) {
                        qVar.a(exception, bVar);
                    }
                });
                return true;
            }
        }
        return false;
    }

    public static boolean a(j jVar) {
        if (jVar.x.a().size() <= 5) {
            return false;
        }
        int i = 0;
        for (String a : jVar.x.a()) {
            int i2;
            if (jVar.x.a(a) instanceof q) {
                i2 = i + 1;
                if (i2 > 5) {
                    return true;
                }
            } else {
                i2 = i;
            }
            i = i2;
        }
        return false;
    }

    public f b() {
        f fVar = new f(this.f.a, this.a, this);
        b(this.f.a);
        return fVar;
    }

    private void b(j jVar) {
        if (this.d && jVar.x.a(this.b) == null) {
            jVar.x.b(this.a, new aa(jVar, this.b, this.a, this.e, this.k));
        }
    }

    public boolean a(d dVar) {
        return !a(dVar.d().toString());
    }

    public void c() {
        final j jVar = this.f.a;
        com.b.a.f.c a = jVar.i.a();
        if (this.f.h || !a.b(this.b) || this.j) {
            if (jVar.x.a(this.a) == null && !a(this.f.e)) {
                this.f.a(null);
                this.f.m = this;
                if (this.j) {
                    this.f.a(a.a()).n().a(new t(jVar, this.a, this.i, a));
                } else {
                    boolean z;
                    e n = this.f.a(new com.b.a.d.b(), new Runnable(this) {
                        final /* synthetic */ c b;

                        public void run() {
                            com.b.a.g.a(j.a, new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 a;

                                {
                                    this.a = r1;
                                }

                                public void run() {
                                    jVar.x.b(this.a.b.a);
                                }
                            });
                        }
                    }).n();
                    String str = this.a;
                    if (this.d) {
                        z = false;
                    } else {
                        z = true;
                    }
                    n.a(new p(jVar, str, z, this.g, this.h, this.i));
                }
            }
            b(jVar);
            return;
        }
        a.a(jVar, this.b, this.k);
    }
}
