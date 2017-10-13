package com.b.a.c.f;

import android.net.Uri;
import android.text.TextUtils;
import com.b.a.b.f;
import com.b.a.b.g;
import com.b.a.b.j;
import com.b.a.c.b.c;
import com.b.a.c.h;
import com.b.a.c.n;
import com.b.a.c.q;
import com.b.a.c.s;
import com.b.a.c.u;
import com.b.a.d;
import com.b.a.i;
import com.b.a.k;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

public class p extends h {
    private static final a z = new a();
    boolean n;
    Field o;
    Field p;
    Field q;
    Field r;
    Field s;
    Field t;
    Field u;
    Method v;
    Method w;
    Hashtable<String, b> x = new Hashtable();
    boolean y;

    private static class a extends Exception {
        private a() {
        }
    }

    private static class b extends g<a> {
        com.b.a.b.h c;

        private b() {
            this.c = new com.b.a.b.h();
        }
    }

    public p(com.b.a.c.a aVar) {
        super(aVar);
        a(new com.b.a.c.g(this) {
            final /* synthetic */ p a;

            {
                this.a = r1;
            }

            public SSLEngine a(SSLContext sSLContext, String str, int i) {
                return null;
            }

            public void a(SSLEngine sSLEngine, com.b.a.c.b.a aVar, String str, int i) {
                this.a.a(sSLEngine, aVar, str, i);
            }
        });
    }

    private void a(SSLEngine sSLEngine, com.b.a.c.b.a aVar, String str, int i) {
        if (!this.n && this.y) {
            this.n = true;
            try {
                this.o = sSLEngine.getClass().getSuperclass().getDeclaredField("peerHost");
                this.p = sSLEngine.getClass().getSuperclass().getDeclaredField("peerPort");
                this.q = sSLEngine.getClass().getDeclaredField("sslParameters");
                this.r = this.q.getType().getDeclaredField("npnProtocols");
                this.s = this.q.getType().getDeclaredField("alpnProtocols");
                this.u = this.q.getType().getDeclaredField("useSni");
                this.t = sSLEngine.getClass().getDeclaredField("sslNativePointer");
                String str2 = this.q.getType().getPackage().getName() + ".NativeCrypto";
                this.v = Class.forName(str2, true, this.q.getType().getClassLoader()).getDeclaredMethod("SSL_get_npn_negotiated_protocol", new Class[]{Long.TYPE});
                this.w = Class.forName(str2, true, this.q.getType().getClassLoader()).getDeclaredMethod("SSL_get0_alpn_selected", new Class[]{Long.TYPE});
                this.o.setAccessible(true);
                this.p.setAccessible(true);
                this.q.setAccessible(true);
                this.r.setAccessible(true);
                this.s.setAccessible(true);
                this.u.setAccessible(true);
                this.t.setAccessible(true);
                this.v.setAccessible(true);
                this.w.setAccessible(true);
            } catch (Exception e) {
                this.q = null;
                this.r = null;
                this.s = null;
                this.u = null;
                this.t = null;
                this.v = null;
                this.w = null;
            }
        }
        if (b(aVar) && this.q != null) {
            try {
                Object a = a(u.SPDY_3);
                this.o.set(sSLEngine, str);
                this.p.set(sSLEngine, Integer.valueOf(i));
                Object obj = this.q.get(sSLEngine);
                this.s.set(obj, a);
                this.u.set(obj, Boolean.valueOf(true));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void b(boolean z) {
        this.y = z;
    }

    public void a(SSLContext sSLContext) {
        super.a(sSLContext);
        this.n = false;
    }

    static byte[] a(u... uVarArr) {
        ByteBuffer allocate = ByteBuffer.allocate(8192);
        for (u uVar : uVarArr) {
            if (uVar != u.HTTP_1_0) {
                allocate.put((byte) uVar.toString().length());
                allocate.put(uVar.toString().getBytes(com.b.a.f.b.b));
            }
        }
        allocate.flip();
        return new k(allocate).a();
    }

    private static String b(Uri uri) {
        String encodedPath = uri.getEncodedPath();
        if (encodedPath == null) {
            encodedPath = "/";
        } else if (!encodedPath.startsWith("/")) {
            encodedPath = "/" + encodedPath;
        }
        if (TextUtils.isEmpty(uri.getEncodedQuery())) {
            return encodedPath;
        }
        return encodedPath + "?" + uri.getEncodedQuery();
    }

    private void a(String str) {
        b bVar = (b) this.x.remove(str);
        if (bVar != null) {
            bVar.a(z);
        }
    }

    private void a(String str, com.b.a.a.b bVar, Exception exception, d dVar) {
        b bVar2 = (b) this.x.get(str);
        if (bVar2 == null || bVar2.c.f()) {
            bVar.a(exception, dVar);
        }
    }

    protected com.b.a.e.a a(final com.b.a.c.b.a aVar, final com.b.a.a.b bVar) {
        final String str = (String) aVar.i.b("spdykey");
        if (str == null) {
            return super.a(aVar, bVar);
        }
        return new com.b.a.e.a(this) {
            final /* synthetic */ p d;

            public void a(Exception exception, d dVar) {
                aVar.j.b("checking spdy handshake");
                if (exception != null || this.d.w == null) {
                    this.d.a(str, bVar, exception, dVar);
                    this.d.a(str);
                    return;
                }
                try {
                    long longValue = ((Long) this.d.t.get(dVar.b())).longValue();
                    byte[] bArr = (byte[]) this.d.w.invoke(null, new Object[]{Long.valueOf(longValue)});
                    if (bArr == null) {
                        this.d.a(str, bVar, null, dVar);
                        this.d.a(str);
                        return;
                    }
                    String str = new String(bArr);
                    u uVar = u.get(str);
                    if (uVar == null || !uVar.needsSpdyConnection()) {
                        this.d.a(str, bVar, null, dVar);
                        this.d.a(str);
                        return;
                    }
                    try {
                        new a(this, dVar, u.get(str)) {
                            boolean n;
                            final /* synthetic */ AnonymousClass2 o;

                            public void a(boolean z, n nVar) {
                                super.a(z, nVar);
                                if (!this.n) {
                                    this.n = true;
                                    b bVar = (b) this.o.d.x.get(str);
                                    if (bVar.c.f()) {
                                        aVar.j.b("using new spdy connection for host: " + aVar.j.d().getHost());
                                        this.o.d.a(aVar, this, bVar);
                                    }
                                    bVar.b((Object) this);
                                }
                            }
                        }.a();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    throw new AssertionError(e2);
                }
            }
        };
    }

    private void a(com.b.a.c.b.a aVar, a aVar2, com.b.a.a.b bVar) {
        com.b.a.c.d dVar = aVar.j;
        aVar.c = aVar2.g.toString();
        com.b.a.c.a.a g = aVar.j.g();
        List arrayList = new ArrayList();
        arrayList.add(new g(g.b, dVar.c()));
        arrayList.add(new g(g.c, b(dVar.d())));
        String a = dVar.e().a("Host");
        if (u.SPDY_3 == aVar2.g) {
            arrayList.add(new g(g.g, "HTTP/1.1"));
            arrayList.add(new g(g.f, a));
        } else if (u.HTTP_2 == aVar2.g) {
            arrayList.add(new g(g.e, a));
        } else {
            throw new AssertionError();
        }
        arrayList.add(new g(g.d, dVar.d().getScheme()));
        s a2 = dVar.e().a();
        for (String a3 : a2.keySet()) {
            if (!q.a(aVar2.g, a3)) {
                for (String gVar : (List) a2.get(a3)) {
                    arrayList.add(new g(a3.toLowerCase(Locale.US), gVar));
                }
            }
        }
        dVar.b("\n" + dVar);
        bVar.a(null, aVar2.a(arrayList, g != null, true));
    }

    private boolean b(com.b.a.c.b.a aVar) {
        return aVar.j.g() == null;
    }

    protected com.b.a.a.b a(com.b.a.c.b.a aVar, Uri uri, int i, boolean z, com.b.a.a.b bVar) {
        final com.b.a.a.b a = super.a(aVar, uri, i, z, bVar);
        final String str = (String) aVar.i.b("spdykey");
        if (str == null) {
            return a;
        }
        return new com.b.a.a.b(this) {
            final /* synthetic */ p c;

            public void a(Exception exception, i iVar) {
                if (exception != null) {
                    b bVar = (b) this.c.x.remove(str);
                    if (bVar != null) {
                        bVar.a(exception);
                    }
                }
                a.a(exception, iVar);
            }
        };
    }

    public com.b.a.b.a a(final com.b.a.c.b.a aVar) {
        Uri d = aVar.j.d();
        int a = a(aVar.j.d());
        if (a == -1) {
            return null;
        }
        if (!this.y) {
            return super.a(aVar);
        }
        if (!b(aVar)) {
            return super.a(aVar);
        }
        b bVar;
        com.b.a.b.a a2;
        String str = d.getHost() + a;
        b bVar2 = (b) this.x.get(str);
        if (bVar2 != null) {
            if (bVar2.l() instanceof a) {
                return super.a(aVar);
            }
            if (!(bVar2.m() == null || ((a) bVar2.m()).a.i())) {
                this.x.remove(str);
                bVar = null;
                if (bVar != null) {
                    aVar.i.a("spdykey", str);
                    a2 = super.a(aVar);
                    if (a2.isDone() && !a2.isCancelled()) {
                        bVar2 = new b();
                        this.x.put(str, bVar2);
                        return bVar2.c;
                    }
                }
                aVar.j.b("waiting for potential spdy connection for host: " + aVar.j.d().getHost());
                a2 = new com.b.a.b.h();
                bVar.c(new f<a>(this) {
                    final /* synthetic */ p c;

                    public void a(Exception exception, a aVar) {
                        if (exception instanceof a) {
                            aVar.j.b("spdy not available");
                            a2.b(super.a(aVar));
                        } else if (exception == null) {
                            aVar.j.b("using existing spdy connection for host: " + aVar.j.d().getHost());
                            if (a2.f()) {
                                this.c.a(aVar, aVar, aVar.a);
                            }
                        } else if (a2.f()) {
                            aVar.a.a(exception, null);
                        }
                    }
                });
                return a2;
            }
        }
        bVar = bVar2;
        if (bVar != null) {
            aVar.j.b("waiting for potential spdy connection for host: " + aVar.j.d().getHost());
            a2 = new com.b.a.b.h();
            bVar.c(/* anonymous class already generated */);
            return a2;
        }
        aVar.i.a("spdykey", str);
        a2 = super.a(aVar);
        return a2.isDone() ? a2 : a2;
    }

    public boolean a(final c cVar) {
        if (!(cVar.e instanceof com.b.a.c.f.a.a)) {
            return super.a(cVar);
        }
        if (cVar.j.g() != null) {
            cVar.f.a(cVar.e);
        }
        cVar.g.a(null);
        final com.b.a.c.f.a.a aVar = (com.b.a.c.f.a.a) cVar.e;
        ((AnonymousClass6) aVar.c().b(new j<n, List<g>>(this) {
            final /* synthetic */ p b;

            protected void a(List<g> list) {
                n nVar = new n();
                for (g gVar : list) {
                    nVar.b(gVar.h.a(), gVar.i.a());
                }
                String[] split = nVar.d(g.a.a()).split(" ", 2);
                cVar.f.a(Integer.parseInt(split[0]));
                if (split.length == 2) {
                    cVar.f.b(split[1]);
                }
                cVar.f.a(nVar.d(g.g.a()));
                cVar.f.a(nVar);
                b((Object) nVar);
            }
        })).d(new f<n>(this) {
            final /* synthetic */ p c;

            public void a(Exception exception, n nVar) {
                cVar.h.a(exception);
                cVar.f.b(q.a(aVar, aVar.b().g, nVar, false));
            }
        });
        return true;
    }

    public void a(com.b.a.c.b.f fVar) {
        if ((fVar.e instanceof com.b.a.c.f.a.a) && fVar.j.g() != null) {
            fVar.f.m_().a();
        }
    }
}
