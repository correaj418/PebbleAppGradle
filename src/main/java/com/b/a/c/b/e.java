package com.b.a.c.b;

import android.net.Uri;
import android.util.Base64;
import com.b.a.ac;
import com.b.a.c.n;
import com.b.a.c.y;
import com.b.a.i;
import com.b.a.k;
import com.b.a.m;
import com.b.a.t;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.CacheResponse;
import java.nio.ByteBuffer;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.SSLEngine;

public class e extends y {
    private boolean a = true;
    private int b;
    private int c;
    private com.b.a.f.c d;
    private com.b.a.g e;
    private int f;
    private int g;
    private int h;
    private int i;

    private static class a extends t {
        h d;
        k e;

        private a() {
        }

        protected void b(Exception exception) {
            super.b(exception);
            if (exception != null) {
                a();
            }
        }

        public void a(m mVar, k kVar) {
            ByteBuffer n;
            if (this.e != null) {
                super.a(mVar, this.e);
                if (this.e.d() <= 0) {
                    this.e = null;
                } else {
                    return;
                }
            }
            k kVar2 = new k();
            try {
                if (this.d != null) {
                    OutputStream a = this.d.a(1);
                    if (a != null) {
                        while (!kVar.c()) {
                            n = kVar.n();
                            k.a(a, n);
                            kVar2.a(n);
                        }
                    } else {
                        a();
                    }
                }
                kVar.a(kVar2);
                kVar2.a(kVar);
            } catch (Exception e) {
                a();
                kVar.a(kVar2);
                kVar2.a(kVar);
            } catch (Throwable th) {
                kVar.a(kVar2);
                kVar2.a(kVar);
            }
            super.a(mVar, kVar);
            if (this.d != null && kVar.d() > 0) {
                this.e = new k();
                kVar.a(this.e);
            }
        }

        public void d() {
            a();
            super.d();
        }

        public void a() {
            if (this.d != null) {
                this.d.b();
                this.d = null;
            }
        }

        public void b() {
            if (this.d != null) {
                this.d.a();
                this.d = null;
            }
        }
    }

    public static class b {
        FileInputStream[] a;
        g b;
        long c;
        f d;
    }

    private static class c extends t {
        static final /* synthetic */ boolean h = (!e.class.desiredAssertionStatus());
        g d;
        k e = new k();
        boolean f;
        Runnable g = new Runnable(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.c();
            }
        };
        private boolean i;
        private com.b.a.f.a j = new com.b.a.f.a();

        public c(g gVar, long j) {
            this.d = gVar;
            this.j.b((int) j);
        }

        void c() {
            if (this.e.d() > 0) {
                super.a(this, this.e);
                if (this.e.d() > 0) {
                    return;
                }
            }
            try {
                ByteBuffer a = this.j.a();
                if (h || a.position() == 0) {
                    int read = this.d.a().read(a.array(), a.arrayOffset(), a.capacity());
                    if (read == -1) {
                        k.c(a);
                        this.f = true;
                        b(null);
                        return;
                    }
                    this.j.a((long) read);
                    a.limit(read);
                    this.e.a(a);
                    super.a(this, this.e);
                    if (this.e.d() <= 0) {
                        m().a(this.g, 10);
                        return;
                    }
                    return;
                }
                throw new AssertionError();
            } catch (Exception e) {
                this.f = true;
                b(e);
            }
        }

        void e() {
            m().a(this.g);
        }

        public void o_() {
            this.i = false;
            e();
        }

        public boolean l() {
            return this.i;
        }

        public void d() {
            if (m().b() != Thread.currentThread()) {
                m().a(new Runnable(this) {
                    final /* synthetic */ c a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        this.a.d();
                    }
                });
                return;
            }
            this.e.m();
            com.b.a.f.g.a(this.d.a());
            super.d();
        }

        protected void b(Exception exception) {
            if (this.f) {
                com.b.a.f.g.a(this.d.a());
                super.b(exception);
            }
        }
    }

    private class e extends c implements i {
        boolean j;
        boolean k;
        com.b.a.a.a l;
        final /* synthetic */ e m;

        public e(e eVar, g gVar, long j) {
            this.m = eVar;
            super(gVar, j);
            this.f = true;
        }

        public void a() {
        }

        protected void b(Exception exception) {
            super.b(exception);
            if (!this.j) {
                this.j = true;
                if (this.l != null) {
                    this.l.a(exception);
                }
            }
        }

        public void a(k kVar) {
            kVar.m();
        }

        public com.b.a.a.f g() {
            return null;
        }

        public void a(com.b.a.a.f fVar) {
        }

        public boolean i() {
            return this.k;
        }

        public void d() {
            this.k = false;
        }

        public void a(com.b.a.a.a aVar) {
            this.l = aVar;
        }

        public com.b.a.g m() {
            return this.m.e;
        }
    }

    private class d extends e implements com.b.a.d {
        final /* synthetic */ e i;

        public d(e eVar, g gVar, long j) {
            this.i = eVar;
            super(eVar, gVar, j);
        }

        public SSLEngine b() {
            return null;
        }
    }

    private static final class f {
        private final String a;
        private final c b;
        private final String c;
        private final c d;
        private final String e;
        private final Certificate[] f;
        private final Certificate[] g;

        public f(InputStream inputStream) {
            Throwable th;
            h hVar;
            try {
                hVar = new h(inputStream, com.b.a.f.b.a);
                try {
                    int i;
                    this.a = hVar.a();
                    this.c = hVar.a();
                    this.b = new c();
                    int b = hVar.b();
                    for (i = 0; i < b; i++) {
                        this.b.b(hVar.a());
                    }
                    this.d = new c();
                    this.d.a(hVar.a());
                    b = hVar.b();
                    for (i = 0; i < b; i++) {
                        this.d.b(hVar.a());
                    }
                    this.e = null;
                    this.f = null;
                    this.g = null;
                    com.b.a.f.g.a(hVar, inputStream);
                } catch (Throwable th2) {
                    th = th2;
                    com.b.a.f.g.a(hVar, inputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                hVar = null;
                com.b.a.f.g.a(hVar, inputStream);
                throw th;
            }
        }

        public f(Uri uri, c cVar, com.b.a.c.d dVar, c cVar2) {
            this.a = uri.toString();
            this.b = cVar;
            this.c = dVar.c();
            this.d = cVar2;
            this.e = null;
            this.f = null;
            this.g = null;
        }

        public void a(h hVar) {
            int i = 0;
            Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(hVar.a(0), com.b.a.f.b.b));
            bufferedWriter.write(this.a + '\n');
            bufferedWriter.write(this.c + '\n');
            bufferedWriter.write(Integer.toString(this.b.d()) + '\n');
            for (int i2 = 0; i2 < this.b.d(); i2++) {
                bufferedWriter.write(this.b.a(i2) + ": " + this.b.b(i2) + '\n');
            }
            bufferedWriter.write(this.d.a() + '\n');
            bufferedWriter.write(Integer.toString(this.d.d()) + '\n');
            while (i < this.d.d()) {
                bufferedWriter.write(this.d.a(i) + ": " + this.d.b(i) + '\n');
                i++;
            }
            if (a()) {
                bufferedWriter.write(10);
                bufferedWriter.write(this.e + '\n');
                a(bufferedWriter, this.f);
                a(bufferedWriter, this.g);
            }
            bufferedWriter.close();
        }

        private boolean a() {
            return this.a.startsWith("https://");
        }

        private void a(Writer writer, Certificate[] certificateArr) {
            if (certificateArr == null) {
                writer.write("-1\n");
                return;
            }
            try {
                writer.write(Integer.toString(certificateArr.length) + '\n');
                for (Certificate encoded : certificateArr) {
                    writer.write(Base64.encodeToString(encoded.getEncoded(), 0) + '\n');
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public boolean a(Uri uri, String str, Map<String, List<String>> map) {
            return this.a.equals(uri.toString()) && this.c.equals(str) && new f(uri, this.d).a(this.b.f(), (Map) map);
        }
    }

    static class g extends CacheResponse {
        private final f a;
        private final FileInputStream b;

        public /* synthetic */ InputStream getBody() {
            return a();
        }

        public g(f fVar, FileInputStream fileInputStream) {
            this.a = fVar;
            this.b = fileInputStream;
        }

        public Map<String, List<String>> getHeaders() {
            return this.a.d.f();
        }

        public FileInputStream a() {
            return this.b;
        }
    }

    class h {
        String a;
        File[] b;
        FileOutputStream[] c = new FileOutputStream[2];
        boolean d;
        final /* synthetic */ e e;

        public h(e eVar, String str) {
            this.e = eVar;
            this.a = str;
            this.b = eVar.d.a(2);
        }

        void a() {
            com.b.a.f.g.a(this.c);
            if (!this.d) {
                this.e.d.a(this.a, this.b);
                this.e.b = this.e.b + 1;
                this.d = true;
            }
        }

        FileOutputStream a(int i) {
            if (this.c[i] == null) {
                this.c[i] = new FileOutputStream(this.b[i]);
            }
            return this.c[i];
        }

        void b() {
            com.b.a.f.g.a(this.c);
            com.b.a.f.c.a(this.b);
            if (!this.d) {
                this.e.c = this.e.c + 1;
                this.d = true;
            }
        }
    }

    private e() {
    }

    public static e a(com.b.a.c.a aVar, File file, long j) {
        for (com.b.a.c.b bVar : aVar.b()) {
            if (bVar instanceof e) {
                throw new IOException("Response cache already added to http client");
            }
        }
        com.b.a.c.b bVar2 = new e();
        bVar2.e = aVar.e();
        bVar2.d = new com.b.a.f.c(file, j, false);
        aVar.a(bVar2);
        return bVar2;
    }

    public com.b.a.f.c a() {
        return this.d;
    }

    public com.b.a.b.a a(final com.b.a.c.b.a aVar) {
        d dVar = new d(aVar.j.d(), c.a(aVar.j.e().a()));
        aVar.i.a("request-headers", dVar);
        if (this.d == null || !this.a || dVar.b()) {
            this.h++;
            return null;
        }
        Closeable[] a;
        try {
            a = this.d.a(com.b.a.f.c.a(aVar.j.d()), 2);
            if (a == null) {
                try {
                    this.h++;
                    return null;
                } catch (IOException e) {
                    this.h++;
                    com.b.a.f.g.a(a);
                    return null;
                }
            }
            long available = (long) a[1].available();
            f fVar = new f(a[0]);
            if (fVar.a(aVar.j.d(), aVar.j.c(), aVar.j.e().a())) {
                g gVar = new g(fVar, a[1]);
                try {
                    Map headers = gVar.getHeaders();
                    FileInputStream a2 = gVar.a();
                    if (headers == null || a2 == null) {
                        this.h++;
                        com.b.a.f.g.a(a);
                        return null;
                    }
                    c a3 = c.a(headers);
                    f fVar2 = new f(aVar.j.d(), a3);
                    a3.b("Content-Length", String.valueOf(available));
                    a3.c("Content-Encoding");
                    a3.c("Transfer-Encoding");
                    fVar2.a(System.currentTimeMillis(), System.currentTimeMillis());
                    g a4 = fVar2.a(System.currentTimeMillis(), dVar);
                    if (a4 == g.CACHE) {
                        e dVar2;
                        aVar.j.a("Response retrieved from cache");
                        if (fVar.a()) {
                            dVar2 = new d(this, gVar, available);
                        } else {
                            dVar2 = new e(this, gVar, available);
                        }
                        dVar2.e.a(ByteBuffer.wrap(a3.e().getBytes()));
                        this.e.a(new Runnable(this) {
                            final /* synthetic */ e c;

                            public void run() {
                                aVar.a.a(null, dVar2);
                                dVar2.c();
                            }
                        });
                        this.g++;
                        aVar.i.a("socket-owner", this);
                        com.b.a.b.a hVar = new com.b.a.b.h();
                        hVar.f();
                        return hVar;
                    } else if (a4 == g.CONDITIONAL_CACHE) {
                        aVar.j.a("Response may be served from conditional cache");
                        b bVar = new b();
                        bVar.a = a;
                        bVar.c = available;
                        bVar.d = fVar2;
                        bVar.b = gVar;
                        aVar.i.a("cache-data", bVar);
                        return null;
                    } else {
                        aVar.j.c("Response can not be served from cache");
                        this.h++;
                        com.b.a.f.g.a(a);
                        return null;
                    }
                } catch (Exception e2) {
                    this.h++;
                    com.b.a.f.g.a(a);
                    return null;
                }
            }
            this.h++;
            com.b.a.f.g.a(a);
            return null;
        } catch (IOException e3) {
            a = null;
            this.h++;
            com.b.a.f.g.a(a);
            return null;
        }
    }

    public void a(com.b.a.c.b.b bVar) {
        if (((e) ac.a(bVar.e, e.class)) != null) {
            bVar.f.k().a("X-Served-From", "cache");
            return;
        }
        b bVar2 = (b) bVar.i.b("cache-data");
        c a = c.a(bVar.f.k().a());
        a.c("Content-Length");
        a.a(String.format(Locale.ENGLISH, "%s %s %s", new Object[]{bVar.f.k_(), Integer.valueOf(bVar.f.j()), bVar.f.l_()}));
        f fVar = new f(bVar.j.d(), a);
        bVar.i.a("response-headers", fVar);
        if (bVar2 != null) {
            if (bVar2.d.a(fVar)) {
                bVar.j.a("Serving response from conditional cache");
                f b = bVar2.d.b(fVar);
                bVar.f.a(new n(b.a().f()));
                bVar.f.a(b.a().b());
                bVar.f.b(b.a().c());
                bVar.f.k().a("X-Served-From", "conditional-cache");
                this.f++;
                Object cVar = new c(bVar2.b, bVar2.c);
                cVar.a(bVar.d);
                bVar.d = cVar;
                cVar.e();
                return;
            }
            bVar.i.a("cache-data");
            com.b.a.f.g.a(bVar2.a);
        }
        if (this.a) {
            d dVar = (d) bVar.i.b("request-headers");
            if (dVar != null && fVar.a(dVar) && bVar.j.c().equals("GET")) {
                String a2 = com.b.a.f.c.a(bVar.j.d());
                f fVar2 = new f(bVar.j.d(), dVar.a().a(fVar.b()), bVar.j, fVar.a());
                m aVar = new a();
                h hVar = new h(this, a2);
                try {
                    fVar2.a(hVar);
                    hVar.a(1);
                    aVar.d = hVar;
                    aVar.a(bVar.d);
                    bVar.d = aVar;
                    bVar.i.a("body-cacher", aVar);
                    bVar.j.c("Caching response");
                    this.i++;
                    return;
                } catch (Exception e) {
                    hVar.b();
                    this.h++;
                    return;
                }
            }
            this.h++;
            bVar.j.c("Response is not cacheable");
        }
    }

    public void a(com.b.a.c.b.g gVar) {
        b bVar = (b) gVar.i.b("cache-data");
        if (!(bVar == null || bVar.a == null)) {
            com.b.a.f.g.a(bVar.a);
        }
        if (((e) ac.a(gVar.e, e.class)) != null) {
            com.b.a.f.g.a(((e) ac.a(gVar.e, e.class)).d.a());
        }
        a aVar = (a) gVar.i.b("body-cacher");
        if (aVar == null) {
            return;
        }
        if (gVar.k != null) {
            aVar.a();
        } else {
            aVar.b();
        }
    }
}
