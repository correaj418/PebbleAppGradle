package com.b.a.c;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.b.a.b.e;
import com.b.a.b.i;
import com.b.a.c;
import com.b.a.c.f.p;
import com.b.a.g;
import com.b.a.m;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeoutException;

public class a {
    static final /* synthetic */ boolean f = (!a.class.desiredAssertionStatus());
    private static a g;
    final List<b> a = new CopyOnWriteArrayList();
    p b;
    i c;
    p d;
    g e;

    private class a extends i<e> {
        public com.b.a.i a;
        public Object b;
        public Runnable c;
        final /* synthetic */ a m;

        private a(a aVar) {
            this.m = aVar;
        }

        public boolean b() {
            if (!super.b()) {
                return false;
            }
            if (this.a != null) {
                this.a.a(new com.b.a.a.d.a());
                this.a.d();
            }
            if (this.b != null) {
                this.m.e.a(this.b);
            }
            return true;
        }
    }

    public interface b {
        void a(Exception exception, z zVar);
    }

    public static a a() {
        if (g == null) {
            g = new a(g.a());
        }
        return g;
    }

    public Collection<b> b() {
        return this.a;
    }

    public void a(b bVar) {
        this.a.add(0, bVar);
    }

    public a(g gVar) {
        this.e = gVar;
        b iVar = new i(this);
        this.c = iVar;
        a(iVar);
        iVar = new p(this);
        this.b = iVar;
        a(iVar);
        iVar = new p();
        this.d = iVar;
        a(iVar);
        this.b.a(new x());
    }

    @SuppressLint({"NewApi"})
    private static void c(d dVar) {
        if (dVar.c == null) {
            try {
                List select = ProxySelector.getDefault().select(URI.create(dVar.d().toString()));
                if (!select.isEmpty()) {
                    Proxy proxy = (Proxy) select.get(0);
                    if (proxy.type() == Type.HTTP && (proxy.address() instanceof InetSocketAddress)) {
                        String hostString;
                        InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                        if (VERSION.SDK_INT >= 14) {
                            hostString = inetSocketAddress.getHostString();
                        } else {
                            InetAddress address = inetSocketAddress.getAddress();
                            if (address != null) {
                                hostString = address.getHostAddress();
                            } else {
                                hostString = inetSocketAddress.getHostName();
                            }
                        }
                        dVar.a(hostString, inetSocketAddress.getPort());
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public i c() {
        return this.c;
    }

    public p d() {
        return this.b;
    }

    public e<e> a(d dVar, com.b.a.c.c.a aVar) {
        e aVar2 = new a();
        a(dVar, 0, aVar2, aVar);
        return aVar2;
    }

    private void a(a aVar, Exception exception, f fVar, d dVar, com.b.a.c.c.a aVar2) {
        if (f || aVar2 != null) {
            boolean a;
            this.e.a(aVar.b);
            if (exception != null) {
                dVar.a("Connection error", exception);
                a = aVar.a(exception);
            } else {
                dVar.c("Connection successful");
                a = aVar.b((Object) fVar);
            }
            if (a) {
                aVar2.a(exception, fVar);
                if (!f && exception == null && fVar.e() != null && fVar.f() == null && !fVar.l()) {
                    throw new AssertionError();
                }
                return;
            } else if (fVar != null) {
                fVar.a(new com.b.a.a.d.a());
                fVar.d();
                return;
            } else {
                return;
            }
        }
        throw new AssertionError();
    }

    private void a(d dVar, int i, a aVar, com.b.a.c.c.a aVar2) {
        if (this.e.c()) {
            b(dVar, i, aVar, aVar2);
            return;
        }
        final d dVar2 = dVar;
        final int i2 = i;
        final a aVar3 = aVar;
        final com.b.a.c.c.a aVar4 = aVar2;
        this.e.a(new Runnable(this) {
            final /* synthetic */ a e;

            public void run() {
                this.e.b(dVar2, i2, aVar3, aVar4);
            }
        });
    }

    private static long d(d dVar) {
        return (long) dVar.h();
    }

    private static void b(d dVar, d dVar2, String str) {
        String a = dVar.e().a(str);
        if (!TextUtils.isEmpty(a)) {
            dVar2.e().a(str, a);
        }
    }

    private void b(d dVar, int i, a aVar, com.b.a.c.c.a aVar2) {
        if (!f && !this.e.c()) {
            throw new AssertionError();
        } else if (i > 15) {
            a(aVar, new v("too many redirects"), null, dVar, aVar2);
        } else {
            dVar.d();
            final com.b.a.c.b.a gVar = new b.g();
            dVar.g = System.currentTimeMillis();
            gVar.j = dVar;
            dVar.c("Executing request.");
            for (b a : this.a) {
                a.a((b.e) gVar);
            }
            if (dVar.h() > 0) {
                final a aVar3 = aVar;
                final d dVar2 = dVar;
                final com.b.a.c.c.a aVar4 = aVar2;
                aVar.c = new Runnable(this) {
                    final /* synthetic */ a e;

                    public void run() {
                        if (gVar.b != null) {
                            gVar.b.b();
                            if (gVar.e != null) {
                                gVar.e.d();
                            }
                        }
                        this.e.a(aVar3, new TimeoutException(), null, dVar2, aVar4);
                    }
                };
                aVar.b = this.e.a(aVar.c, d(dVar));
            }
            final d dVar3 = dVar;
            final a aVar5 = aVar;
            final com.b.a.c.c.a aVar6 = aVar2;
            final b.e eVar = gVar;
            final int i2 = i;
            gVar.a = new com.b.a.a.b(this) {
                boolean a;
                final /* synthetic */ a g;

                public void a(Exception exception, com.b.a.i iVar) {
                    if (!this.a || iVar == null) {
                        this.a = true;
                        dVar3.b("socket connected");
                        if (!aVar5.isCancelled()) {
                            if (aVar5.c != null) {
                                this.g.e.a(aVar5.b);
                            }
                            if (exception != null) {
                                this.g.a(aVar5, exception, null, dVar3, aVar6);
                                return;
                            }
                            eVar.e = iVar;
                            aVar5.a = iVar;
                            this.g.a(dVar3, i2, aVar5, aVar6, eVar);
                            return;
                        } else if (iVar != null) {
                            iVar.d();
                            return;
                        } else {
                            return;
                        }
                    }
                    iVar.a(new com.b.a.a.d.a());
                    iVar.b(new com.b.a.a.a.a());
                    iVar.d();
                    throw new AssertionError("double connect callback");
                }
            };
            c(dVar);
            if (dVar.g() != null && dVar.e().a("Content-Type") == null) {
                dVar.e().a("Content-Type", dVar.g().a());
            }
            for (b a2 : this.a) {
                com.b.a.b.a a3 = a2.a(gVar);
                if (a3 != null) {
                    gVar.b = a3;
                    aVar.c(a3);
                    return;
                }
            }
            a(aVar, new IllegalArgumentException("invalid uri=" + dVar.d() + " middlewares=" + this.a), null, dVar, aVar2);
        }
    }

    private void a(d dVar, int i, a aVar, com.b.a.c.c.a aVar2, b.g gVar) {
        final a aVar3 = aVar;
        final d dVar2 = dVar;
        final com.b.a.c.c.a aVar4 = aVar2;
        final b.g gVar2 = gVar;
        final int i2 = i;
        final Object anonymousClass5 = new f(this, dVar) {
            final /* synthetic */ a i;

            protected void a(Exception exception) {
                if (exception != null) {
                    this.i.a(aVar3, exception, null, dVar2, aVar4);
                    return;
                }
                dVar2.b("request completed");
                if (!aVar3.isCancelled()) {
                    if (aVar3.c != null && this.j == null) {
                        this.i.e.a(aVar3.b);
                        aVar3.b = this.i.e.a(aVar3.c, a.d(dVar2));
                    }
                    for (b a : this.i.a) {
                        a.a(gVar2);
                    }
                }
            }

            public void a(m mVar) {
                gVar2.d = mVar;
                for (b a : this.i.a) {
                    a.a(gVar2);
                }
                super.a(gVar2.d);
                n nVar = this.j;
                int j = j();
                if ((j == 301 || j == 302 || j == 307) && dVar2.f()) {
                    String a2 = nVar.a("Location");
                    try {
                        Uri parse = Uri.parse(a2);
                        if (parse.getScheme() == null) {
                            parse = Uri.parse(new URL(new URL(dVar2.d().toString()), a2).toString());
                        }
                        d dVar = new d(parse, dVar2.c().equals("HEAD") ? "HEAD" : "GET");
                        dVar.g = dVar2.g;
                        dVar.f = dVar2.f;
                        dVar.e = dVar2.e;
                        dVar.c = dVar2.c;
                        dVar.d = dVar2.d;
                        a.c(dVar);
                        a.b(dVar2, dVar, "User-Agent");
                        a.b(dVar2, dVar, "Range");
                        dVar2.a("Redirecting");
                        dVar.a("Redirected");
                        this.i.a(dVar, i2 + 1, aVar3, aVar4);
                        a(new com.b.a.a.d.a());
                        return;
                    } catch (Exception e) {
                        this.i.a(aVar3, e, (f) this, dVar2, aVar4);
                        return;
                    }
                }
                dVar2.b("Final (post cache response) headers:\n" + toString());
                this.i.a(aVar3, null, (f) this, dVar2, aVar4);
            }

            protected void b() {
                super.b();
                if (!aVar3.isCancelled()) {
                    if (aVar3.c != null) {
                        this.i.e.a(aVar3.b);
                    }
                    dVar2.b("Received headers:\n" + toString());
                    for (b a : this.i.a) {
                        a.a(gVar2);
                    }
                }
            }

            protected void b(Exception exception) {
                if (exception != null) {
                    dVar2.a("exception during response", exception);
                }
                if (!aVar3.isCancelled()) {
                    if (exception instanceof c) {
                        dVar2.a("SSL Exception", exception);
                        c cVar = (c) exception;
                        dVar2.a(cVar);
                        if (cVar.a()) {
                            return;
                        }
                    }
                    com.b.a.i e = e();
                    if (e != null) {
                        super.b(exception);
                        if (!((e.i() && exception == null) || k() != null || exception == null)) {
                            this.i.a(aVar3, exception, null, dVar2, aVar4);
                        }
                        gVar2.k = exception;
                        for (b a : this.i.a) {
                            a.a(gVar2);
                        }
                    }
                }
            }

            public com.b.a.i c() {
                dVar2.c("Detaching socket");
                com.b.a.i e = e();
                if (e == null) {
                    return null;
                }
                e.a(null);
                e.a(null);
                e.b(null);
                e.a(null);
                a(null);
                return e;
            }
        };
        gVar.g = new com.b.a.a.a(this) {
            final /* synthetic */ a b;

            public void a(Exception exception) {
                if (exception != null) {
                    anonymousClass5.b(exception);
                } else {
                    anonymousClass5.p();
                }
            }
        };
        gVar.h = new com.b.a.a.a(this) {
            final /* synthetic */ a b;

            public void a(Exception exception) {
                if (exception != null) {
                    anonymousClass5.b(exception);
                } else {
                    anonymousClass5.b();
                }
            }
        };
        gVar.f = anonymousClass5;
        anonymousClass5.a(gVar.e);
        for (b a : this.a) {
            if (a.a((b.c) gVar)) {
                return;
            }
        }
    }

    public e<z> a(final d dVar, String str, final b bVar) {
        ab.a(dVar, str);
        final e iVar = new i();
        iVar.c(a(dVar, new com.b.a.c.c.a(this) {
            final /* synthetic */ a d;

            public void a(Exception exception, e eVar) {
                if (exception == null) {
                    Object a = ab.a(dVar.e(), eVar);
                    if (a == null) {
                        exception = new aa("Unable to complete websocket handshake");
                        if (!iVar.a(exception)) {
                            return;
                        }
                    } else if (!iVar.b(a)) {
                        return;
                    }
                    if (bVar != null) {
                        bVar.a(exception, a);
                    }
                } else if (iVar.a(exception) && bVar != null) {
                    bVar.a(exception, null);
                }
            }
        }));
        return iVar;
    }

    public e<z> a(String str, String str2, b bVar) {
        return a(new c(str.replace("ws://", "http://").replace("wss://", "https://")), str2, bVar);
    }

    public g e() {
        return this.e;
    }
}
