package com.b.b;

import android.app.ProgressDialog;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ProgressBar;
import com.b.a.ac;
import com.b.a.b.i;
import com.b.a.b.j;
import com.b.a.c.a.d;
import com.b.a.c.n;
import com.b.a.c.s;
import com.b.a.k;
import com.b.a.m;
import com.b.a.p;
import com.b.a.q;
import com.b.a.t;
import com.b.b.b.c.a.c;
import com.b.b.b.c.a.e;
import com.b.b.b.c.a.f;
import com.b.b.b.g;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class o implements com.b.b.b.c.a.a, c, e, f, g<com.b.b.b.c.a.a> {
    static final /* synthetic */ boolean C = (!o.class.desiredAssertionStatus());
    v A;
    g B;
    j a;
    d b;
    Handler c = j.a;
    String d = "GET";
    String e;
    boolean f;
    n g;
    boolean h;
    s i;
    int j = 30000;
    com.b.a.c.a.a k;
    boolean l = true;
    b m;
    WeakReference<ProgressBar> n;
    WeakReference<ProgressDialog> o;
    v p;
    v q;
    d r;
    String s;
    int t;
    ArrayList<WeakReference<Object>> u;
    String v;
    int w;
    v x;
    ProgressBar y;
    ProgressDialog z;

    interface b {
        boolean a(com.b.a.c.d dVar);
    }

    class a<T> extends j<T, com.b.b.u.a> implements com.b.b.e.b<T> {
        com.b.a.c.d o;
        com.b.a.c.d p;
        y q;
        Runnable r;
        h s;
        m t;
        final /* synthetic */ o u;

        public x<T> c(Exception exception, T t) {
            return new x(this.p, this.q, this.s, exception, t);
        }

        public com.b.a.b.e<x<T>> n() {
            final com.b.a.b.e iVar = new i();
            d(new com.b.a.b.f<T>(this) {
                final /* synthetic */ a b;

                public void a(Exception exception, T t) {
                    if (this.b.t != null) {
                        iVar.b(this.b.c(exception, t));
                    } else {
                        iVar.b(exception, null);
                    }
                }
            });
            iVar.c((com.b.a.b.a) this);
            return iVar;
        }

        public a(o oVar, Runnable runnable) {
            this.u = oVar;
            this.r = runnable;
            oVar.a.a((com.b.a.b.e) this, oVar.b.b());
            if (oVar.u != null) {
                Iterator it = oVar.u.iterator();
                while (it.hasNext()) {
                    Object obj = ((WeakReference) it.next()).get();
                    if (obj != null) {
                        oVar.a.a((com.b.a.b.e) this, obj);
                    }
                }
            }
        }

        protected void a() {
            super.a();
            if (this.t != null) {
                this.t.d();
            }
            if (this.r != null) {
                this.r.run();
            }
        }

        protected void b(Exception exception) {
            this.u.a(this, exception, null);
        }

        protected void a(com.b.b.u.a aVar) {
            Object tVar;
            this.t = aVar.a();
            this.q = aVar.c();
            this.s = aVar.d();
            this.p = aVar.e();
            if (this.u.B != null) {
                final h d = aVar.d();
                com.b.a.g.a(this.u.c, new Runnable(this) {
                    final /* synthetic */ a b;

                    public void run() {
                        this.b.u.B.a(d);
                    }
                });
            }
            final long b = aVar.b();
            if (this.t instanceof q) {
                q qVar = (q) this.t;
            } else {
                tVar = new t();
                tVar.a(this.t);
            }
            this.t = tVar;
            tVar.a(new com.b.a.q.a(this) {
                static final /* synthetic */ boolean b = (!o.class.desiredAssertionStatus());
                int a;
                final /* synthetic */ a d;

                public void a(final int i) {
                    if (!b && Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        throw new AssertionError();
                    } else if (this.d.u.b.a() != null) {
                        this.d.o.c("context has died, cancelling");
                        this.d.c();
                    } else {
                        final int i2 = (int) ((((float) i) / ((float) b)) * 100.0f);
                        if (!((this.d.u.n == null && this.d.u.o == null) || i2 == this.a)) {
                            com.b.a.g.a(j.a, new Runnable(this) {
                                final /* synthetic */ AnonymousClass3 b;

                                public void run() {
                                    if (!this.b.d.isCancelled() && !this.b.d.isDone()) {
                                        if (this.b.d.u.n != null) {
                                            ProgressBar progressBar = (ProgressBar) this.b.d.u.n.get();
                                            if (progressBar != null) {
                                                progressBar.setProgress(i2);
                                            }
                                        }
                                        if (this.b.d.u.o != null) {
                                            ProgressDialog progressDialog = (ProgressDialog) this.b.d.u.o.get();
                                            if (progressDialog != null) {
                                                progressDialog.setProgress(i2);
                                            }
                                        }
                                    }
                                }
                            });
                        }
                        this.a = i2;
                        if (this.d.u.p != null) {
                            this.d.u.p.a((long) i, b);
                        }
                        if (this.d.u.q != null) {
                            com.b.a.g.a(j.a, new Runnable(this) {
                                final /* synthetic */ AnonymousClass3 b;

                                public void run() {
                                    if (!this.b.d.isCancelled() && !this.b.d.isDone()) {
                                        this.b.d.u.q.a((long) i, b);
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    public /* synthetic */ com.b.b.b.i b(String str, File file) {
        return a(str, file);
    }

    public /* synthetic */ com.b.b.b.j b(int i) {
        return a(i);
    }

    public /* synthetic */ com.b.b.b.j b(Map map) {
        return a(map);
    }

    public /* synthetic */ com.b.b.b.j b(boolean z) {
        return a(z);
    }

    public /* synthetic */ Object b(com.google.b.o oVar) {
        return a(oVar);
    }

    public /* synthetic */ Object b(Object obj) {
        return a(obj);
    }

    public /* synthetic */ Object c(String str) {
        return b(str);
    }

    public /* synthetic */ com.b.b.b.j d(String str, String str2) {
        return c(str, str2);
    }

    public /* synthetic */ Object d(String str) {
        return a(str);
    }

    public /* synthetic */ com.b.b.b.j e(String str, String str2) {
        return b(str, str2);
    }

    public /* synthetic */ Object f(String str, String str2) {
        return a(str, str2);
    }

    public o(d dVar, j jVar) {
        String a = dVar.a();
        if (a != null) {
            Log.w("Ion", "Building request with dead context: " + a);
        }
        this.a = jVar;
        this.b = dVar;
    }

    public o a(String str) {
        return g("GET", str);
    }

    private o g(String str, String str2) {
        this.d = str;
        if (!TextUtils.isEmpty(str2) && str2.startsWith("/")) {
            str2 = new File(str2).toURI().toString();
        }
        this.e = str2;
        return this;
    }

    public o a(String str, String str2) {
        this.f = true;
        return g(str, str2);
    }

    private n d() {
        if (this.g == null) {
            this.g = new n();
            com.b.a.c.d.a(this.g, this.e == null ? null : Uri.parse(this.e));
        }
        return this.g;
    }

    public o b(String str, String str2) {
        if (str2 == null) {
            d().c(str);
        } else {
            d().a(str, str2);
        }
        return this;
    }

    public o c(String str, String str2) {
        if (str2 != null) {
            d().b(str, str2);
        }
        return this;
    }

    public o a(Map<String, List<String>> map) {
        if (map != null) {
            n d = d();
            for (Entry entry : map.entrySet()) {
                d.a((String) entry.getKey(), (List) entry.getValue());
            }
        }
        return this;
    }

    public o a(int i) {
        this.j = i;
        return this;
    }

    public o a(Handler handler) {
        this.c = handler;
        return this;
    }

    private <T> o a(com.b.a.c.a.a<T> aVar) {
        if (!this.f) {
            this.d = "POST";
        }
        this.k = aVar;
        return this;
    }

    public o a(com.google.b.o oVar) {
        return a(new com.b.b.g.a(this.a.g().a(), oVar));
    }

    public o b(String str) {
        return a(new com.b.a.c.a.g(str));
    }

    public o a(boolean z) {
        this.l = z;
        return this;
    }

    private <T> void a(final a<T> aVar, final Exception exception, final T t) {
        Runnable anonymousClass1 = new Runnable(this) {
            final /* synthetic */ o d;

            public void run() {
                String a = this.d.b.a();
                if (a != null) {
                    aVar.o.c("context has died: " + a);
                    aVar.c();
                } else if (exception != null) {
                    aVar.a(exception);
                } else {
                    aVar.b(t);
                }
            }
        };
        if (this.c == null) {
            this.a.f.e().a(anonymousClass1);
        } else {
            com.b.a.g.a(this.c, anonymousClass1);
        }
    }

    private Uri e() {
        Uri build;
        try {
            if (this.i != null) {
                Builder buildUpon = Uri.parse(this.e).buildUpon();
                for (String str : this.i.keySet()) {
                    for (String appendQueryParameter : (List) this.i.get(str)) {
                        buildUpon = buildUpon.appendQueryParameter(str, appendQueryParameter);
                    }
                }
                build = buildUpon.build();
            } else {
                build = Uri.parse(this.e);
            }
        } catch (Exception e) {
            build = null;
        }
        if (build == null || build.getScheme() == null) {
            return null;
        }
        return build;
    }

    private com.b.a.c.d a(Uri uri) {
        com.b.a.c.d a = this.a.g().b().a(uri, this.d, this.g);
        a.a(this.l);
        a.a(this.k);
        a.b(this.a.r, this.a.s);
        if (this.s != null) {
            a.b(this.s, this.t);
        }
        a.a(this.v, this.w);
        a.a(this.j);
        a.c("preparing request");
        return a;
    }

    private <T> void a(a<T> aVar) {
        Uri e = e();
        if (e == null) {
            aVar.a(new Exception("Invalid URI"));
            return;
        }
        com.b.a.c.d a = a(e);
        aVar.o = a;
        a((a) aVar, a);
    }

    private <T> void a(final a<T> aVar, com.b.a.c.d dVar) {
        if (!(this.k == null || (this.A == null && this.y == null && this.x == null && this.z == null))) {
            dVar.a(new w(this.k, new v(this) {
                static final /* synthetic */ boolean a = (!o.class.desiredAssertionStatus());
                final /* synthetic */ o c;

                public void a(long j, long j2) {
                    if (a || Thread.currentThread() != Looper.getMainLooper().getThread()) {
                        int i = (int) ((((float) j) / ((float) j2)) * 100.0f);
                        if (this.c.y != null) {
                            this.c.y.setProgress(i);
                        }
                        if (this.c.z != null) {
                            this.c.z.setProgress(i);
                        }
                        if (this.c.x != null) {
                            this.c.x.a(j, j2);
                        }
                        if (this.c.A != null) {
                            final long j3 = j;
                            final long j4 = j2;
                            com.b.a.g.a(j.a, new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 c;

                                public void run() {
                                    if (!aVar.isCancelled() && !aVar.isDone()) {
                                        this.c.c.A.a(j3, j4);
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                    throw new AssertionError();
                }
            }));
        }
        a(dVar, (a) aVar);
    }

    com.b.a.b.e<com.b.a.c.d> a(final com.b.a.c.d dVar) {
        final com.b.a.b.e iVar = new i();
        new Runnable(this) {
            com.b.a.c.d a = dVar;
            Runnable b = this;
            final /* synthetic */ o e;

            public void run() {
                com.b.a.b.e b = this.e.b(this.a);
                if (b == null) {
                    iVar.b(this.a);
                } else {
                    b.a(new com.b.a.b.f<com.b.a.c.d>(this) {
                        final /* synthetic */ AnonymousClass3 a;

                        {
                            this.a = r1;
                        }

                        public void a(Exception exception, com.b.a.c.d dVar) {
                            if (exception != null) {
                                iVar.a(exception);
                                return;
                            }
                            this.a.a = dVar;
                            this.a.b.run();
                        }
                    });
                }
            }
        }.run();
        return iVar;
    }

    <T> void a(final com.b.a.c.d dVar, final a<T> aVar) {
        a(dVar).a(new com.b.a.b.f<com.b.a.c.d>(this) {
            final /* synthetic */ o c;

            public void a(Exception exception, com.b.a.c.d dVar) {
                if (exception != null) {
                    aVar.a(exception);
                    return;
                }
                aVar.p = dVar;
                if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                    com.b.a.g.a(j.a, new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            this.a.c.b(dVar, aVar);
                        }
                    });
                } else {
                    this.c.b(dVar, aVar);
                }
            }
        });
    }

    <T> void b(com.b.a.c.d dVar, a<T> aVar) {
        if (this.m == null || this.m.a(dVar)) {
            c(dVar, (a) aVar);
        }
    }

    <T> void c(com.b.a.c.d dVar, a<T> aVar) {
        Iterator it = this.a.v.iterator();
        while (it.hasNext()) {
            u uVar = (u) it.next();
            com.b.a.b.a a = uVar.a(this.a, dVar, (com.b.a.b.f) aVar);
            if (a != null) {
                dVar.a("Using loader: " + uVar);
                aVar.c(a);
                return;
            }
        }
        aVar.a(new Exception("Unknown uri scheme"));
    }

    <T> com.b.a.b.e<com.b.a.c.d> b(com.b.a.c.d dVar) {
        Iterator it = this.a.v.iterator();
        while (it.hasNext()) {
            com.b.a.b.e<com.b.a.c.d> a = ((u) it.next()).a(this.b.b(), this.a, dVar);
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    <T> a<T> a(p pVar, boolean z, T t, Runnable runnable) {
        final boolean z2 = z;
        final p pVar2 = pVar;
        final T t2 = t;
        a anonymousClass5 = new a<T>(this, runnable) {
            a<T> a = this;
            final /* synthetic */ o n;

            protected void d() {
                super.d();
                if (z2) {
                    pVar2.a();
                }
            }

            protected void a(com.b.b.u.a aVar) {
                super.a(aVar);
                ac.a(this.t, pVar2, new com.b.a.a.a(this) {
                    final /* synthetic */ AnonymousClass5 a;

                    {
                        this.a = r1;
                    }

                    public void a(Exception exception) {
                        this.a.n.a(this.a.a, exception, t2);
                    }
                });
            }
        };
        a(anonymousClass5);
        return anonymousClass5;
    }

    <T> com.b.b.e.b<T> a(com.b.a.d.a<T> aVar) {
        return a((com.b.a.d.a) aVar, null);
    }

    <T> com.b.b.e.b<T> a(final com.b.a.d.a<T> aVar, Runnable runnable) {
        if (C || aVar != null) {
            Uri e = e();
            com.b.a.c.d dVar = null;
            if (e != null) {
                com.b.a.c.d a = a(e);
                Type a2 = aVar.a();
                Iterator it = this.a.v.iterator();
                while (it.hasNext()) {
                    com.b.b.e.b<T> a3 = ((u) it.next()).a(this.a, a, a2);
                    if (a3 != null) {
                        return a3;
                    }
                }
                dVar = a;
            }
            a anonymousClass6 = new a<T>(this, runnable) {
                a<T> a = this;
                final /* synthetic */ o c;

                protected void a(com.b.b.u.a aVar) {
                    super.a(aVar);
                    aVar.a(this.t).a(new com.b.a.b.f<T>(this) {
                        final /* synthetic */ AnonymousClass6 a;

                        {
                            this.a = r1;
                        }

                        public void a(Exception exception, T t) {
                            this.a.c.a(this.a.a, exception, (Object) t);
                        }
                    });
                }
            };
            if (e == null) {
                anonymousClass6.a(new Exception("Invalid URI"));
                return anonymousClass6;
            }
            anonymousClass6.o = dVar;
            a(anonymousClass6);
            return anonymousClass6;
        }
        throw new AssertionError();
    }

    public com.b.b.e.b<com.google.b.o> a() {
        return a(new com.b.b.g.b());
    }

    public com.b.b.e.b<String> b() {
        return a(new com.b.a.d.d());
    }

    public com.b.b.e.b<byte[]> c() {
        return a(new com.b.a.d.a<byte[]>(this) {
            final /* synthetic */ o a;

            {
                this.a = r1;
            }

            public com.b.a.b.e<byte[]> a(m mVar) {
                return (com.b.a.b.e) new com.b.a.d.b().a(mVar).b(new j<byte[], k>(this) {
                    final /* synthetic */ AnonymousClass7 a;

                    {
                        this.a = r1;
                    }

                    protected void a(k kVar) {
                        b(kVar.a());
                    }
                });
            }

            public Type a() {
                return byte[].class;
            }
        });
    }

    public a<File> a(final File file) {
        return a(new com.b.a.e.b(this.a.f(), file), true, (Object) file, new Runnable(this) {
            final /* synthetic */ o b;

            public void run() {
                file.delete();
            }
        });
    }

    public o a(String str, File file) {
        return a(str, null, file);
    }

    public o a(String str, String str2, File file) {
        if (this.r == null) {
            this.r = new d();
            a(this.r);
        }
        com.b.a.c.a.e bVar = new com.b.a.c.a.b(str, file);
        if (str2 == null) {
            str2 = com.b.a.c.e.a.a(file.getAbsolutePath());
        }
        if (str2 != null) {
            bVar.a(str2);
        }
        this.r.a(bVar);
        return this;
    }

    public <T> com.b.b.e.b<T> a(Class<T> cls) {
        return a(new com.b.b.g.d(this.a.g().a(), cls));
    }

    public o a(Object obj) {
        a(new com.b.b.g.e(this.a.g().a(), obj, null));
        return this;
    }
}
