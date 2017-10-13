package com.b.a.c.f;

import android.os.Build.VERSION;
import com.b.a.a.d;
import com.b.a.j;
import com.b.a.k;
import com.b.a.m;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Locale;
import java.util.zip.Deflater;

final class o implements s {
    static final byte[] a;

    static final class a implements e {
        int a;
        int b;
        int c;
        int d;
        int e;
        boolean f;
        k g = new k();
        private final h h = new h();
        private final m i;
        private final boolean j;
        private final com.b.a.c.f.e.a k;
        private final com.b.a.o l;
        private final k m = new k();
        private final d n = new d(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void a(m mVar, k kVar) {
                boolean z = true;
                kVar.a(ByteOrder.BIG_ENDIAN);
                this.a.a = kVar.f();
                this.a.b = kVar.f();
                boolean z2 = (this.a.a & Integer.MIN_VALUE) != 0;
                this.a.c = (this.a.b & -16777216) >>> 24;
                this.a.d = this.a.b & 16777215;
                if (z2) {
                    this.a.l.a(this.a.d, this.a.p);
                    return;
                }
                this.a.e = this.a.a & Integer.MAX_VALUE;
                a aVar = this.a;
                if ((this.a.c & 1) == 0) {
                    z = false;
                }
                aVar.f = z;
                mVar.a(this.a.o);
                if (this.a.d == 0) {
                    this.a.o.a(mVar, this.a.m);
                }
            }
        };
        private final d o = new d(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void a(m mVar, k kVar) {
                int min = Math.min(kVar.d(), this.a.d);
                if (min < kVar.d()) {
                    kVar.a(this.a.g, min);
                    kVar = this.a.g;
                }
                a aVar = this.a;
                aVar.d -= min;
                com.b.a.c.f.e.a e = this.a.k;
                boolean z = this.a.d == 0 && this.a.f;
                e.a(z, this.a.e, kVar);
                if (this.a.d == 0) {
                    this.a.a();
                }
            }
        };
        private final d p = new d(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void a(m mVar, k kVar) {
                kVar.a(ByteOrder.BIG_ENDIAN);
                int i = (this.a.a & 2147418112) >>> 16;
                int i2 = this.a.a & 65535;
                if (i != 3) {
                    try {
                        throw new ProtocolException("version != 3: " + i);
                    } catch (Exception e) {
                        this.a.k.a(e);
                        return;
                    }
                }
                switch (i2) {
                    case 1:
                        this.a.a(kVar, this.a.c, this.a.d);
                        break;
                    case 2:
                        this.a.b(kVar, this.a.c, this.a.d);
                        break;
                    case 3:
                        this.a.c(kVar, this.a.c, this.a.d);
                        break;
                    case 4:
                        this.a.h(kVar, this.a.c, this.a.d);
                        break;
                    case 6:
                        this.a.f(kVar, this.a.c, this.a.d);
                        break;
                    case 7:
                        this.a.g(kVar, this.a.c, this.a.d);
                        break;
                    case 8:
                        this.a.d(kVar, this.a.c, this.a.d);
                        break;
                    case 9:
                        this.a.e(kVar, this.a.c, this.a.d);
                        break;
                    default:
                        kVar.m();
                        break;
                }
                this.a.a();
            }
        };

        a(m mVar, com.b.a.c.f.e.a aVar, boolean z) {
            this.i = mVar;
            this.k = aVar;
            this.j = z;
            mVar.b(new com.b.a.a.a(this) {
                final /* synthetic */ a a;

                {
                    this.a = r1;
                }

                public void a(Exception exception) {
                }
            });
            this.l = new com.b.a.o();
            a();
        }

        private void a() {
            this.i.a(this.l);
            this.l.a(8, this.n);
        }

        private void a(k kVar, int i, int i2) {
            boolean z;
            boolean z2 = true;
            int f = kVar.f() & Integer.MAX_VALUE;
            int f2 = kVar.f() & Integer.MAX_VALUE;
            kVar.h();
            List a = this.h.a(kVar, i2 - 10);
            if ((i & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((i & 2) == 0) {
                z2 = false;
            }
            this.k.a(z2, z, f, f2, a, i.SPDY_SYN_STREAM);
        }

        private void b(k kVar, int i, int i2) {
            boolean z;
            int f = kVar.f() & Integer.MAX_VALUE;
            List a = this.h.a(kVar, i2 - 4);
            if ((i & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            this.k.a(false, z, f, -1, a, i.SPDY_REPLY);
        }

        private void c(k kVar, int i, int i2) {
            if (i2 != 8) {
                throw a("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i2));
            }
            int f = kVar.f() & Integer.MAX_VALUE;
            d fromSpdy3Rst = d.fromSpdy3Rst(kVar.f());
            if (fromSpdy3Rst == null) {
                throw a("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(r1));
            } else {
                this.k.a(f, fromSpdy3Rst);
            }
        }

        private void d(k kVar, int i, int i2) {
            boolean z = false;
            this.k.a(false, z, kVar.f() & Integer.MAX_VALUE, -1, this.h.a(kVar, i2 - 4), i.SPDY_HEADERS);
        }

        private void e(k kVar, int i, int i2) {
            if (i2 != 8) {
                throw a("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i2));
            }
            int f = kVar.f() & Integer.MAX_VALUE;
            long f2 = (long) (kVar.f() & Integer.MAX_VALUE);
            if (f2 == 0) {
                throw a("windowSizeIncrement was 0", Long.valueOf(f2));
            } else {
                this.k.a(f, f2);
            }
        }

        private void f(k kVar, int i, int i2) {
            boolean z = true;
            if (i2 != 4) {
                throw a("TYPE_PING length: %d != 4", Integer.valueOf(i2));
            }
            boolean z2;
            int f = kVar.f();
            boolean z3 = this.j;
            if ((f & 1) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z3 != z2) {
                z = false;
            }
            this.k.a(z, f, 0);
        }

        private void g(k kVar, int i, int i2) {
            if (i2 != 8) {
                throw a("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i2));
            }
            int f = kVar.f() & Integer.MAX_VALUE;
            d fromSpdyGoAway = d.fromSpdyGoAway(kVar.f());
            if (fromSpdyGoAway == null) {
                throw a("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(r1));
            } else {
                this.k.a(f, fromSpdyGoAway, c.a);
            }
        }

        private void h(k kVar, int i, int i2) {
            boolean z = true;
            int f = kVar.f();
            if (i2 != (f * 8) + 4) {
                throw a("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i2), Integer.valueOf(f));
            }
            n nVar = new n();
            for (int i3 = 0; i3 < f; i3++) {
                int f2 = kVar.f();
                int i4 = (-16777216 & f2) >>> 24;
                nVar.a(f2 & 16777215, i4, kVar.f());
            }
            if ((i & 1) == 0) {
                z = false;
            }
            this.k.a(z, nVar);
        }

        private static IOException a(String str, Object... objArr) {
            throw new IOException(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    static final class b implements f {
        k a = new k();
        k b = new k();
        private final j c;
        private final boolean d;
        private boolean e;
        private k f = new k();
        private final Deflater g = new Deflater();

        b(j jVar, boolean z) {
            this.c = jVar;
            this.d = z;
            this.g.setDictionary(o.a);
        }

        public void b() {
        }

        public void a(int i, int i2, List<g> list) {
        }

        public synchronized void a() {
        }

        public synchronized void a(boolean z, boolean z2, int i, int i2, List<g> list) {
            if (this.e) {
                throw new IOException("closed");
            }
            k a = a((List) list);
            int d = a.d() + 10;
            int i3 = (z2 ? 2 : 0) | (z ? 1 : 0);
            ByteBuffer order = k.c(256).order(ByteOrder.BIG_ENDIAN);
            order.putInt(-2147287039);
            order.putInt(((i3 & 255) << 24) | (d & 16777215));
            order.putInt(i & Integer.MAX_VALUE);
            order.putInt(i2 & Integer.MAX_VALUE);
            order.putShort((short) null);
            order.flip();
            this.c.a(this.f.a(order).b(a));
        }

        public synchronized void a(int i, d dVar) {
            if (this.e) {
                throw new IOException("closed");
            } else if (dVar.spdyRstCode == -1) {
                throw new IllegalArgumentException();
            } else {
                ByteBuffer order = k.c(256).order(ByteOrder.BIG_ENDIAN);
                order.putInt(-2147287037);
                order.putInt(8);
                order.putInt(Integer.MAX_VALUE & i);
                order.putInt(dVar.spdyRstCode);
                order.flip();
                this.c.a(this.f.a(order));
            }
        }

        public synchronized void a(boolean z, int i, k kVar) {
            a(i, z ? 1 : 0, kVar);
        }

        void a(int i, int i2, k kVar) {
            if (this.e) {
                throw new IOException("closed");
            }
            int d = kVar.d();
            if (((long) d) > 16777215) {
                throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + d);
            }
            ByteBuffer order = k.c(256).order(ByteOrder.BIG_ENDIAN);
            order.putInt(Integer.MAX_VALUE & i);
            order.putInt((d & 16777215) | ((i2 & 255) << 24));
            order.flip();
            this.a.a(order).b(kVar);
            this.c.a(this.a);
        }

        private k a(List<g> list) {
            if (this.b.e()) {
                throw new IllegalStateException();
            }
            ByteBuffer order = k.c(8192).order(ByteOrder.BIG_ENDIAN);
            order.putInt(list.size());
            int size = list.size();
            int i = 0;
            while (i < size) {
                ByteBuffer order2;
                c cVar = ((g) list.get(i)).h;
                order.putInt(cVar.d());
                order.put(cVar.e());
                cVar = ((g) list.get(i)).i;
                order.putInt(cVar.d());
                order.put(cVar.e());
                if (order.remaining() < order.capacity() / 2) {
                    order2 = k.c(order.capacity() * 2).order(ByteOrder.BIG_ENDIAN);
                    order.flip();
                    order2.put(order);
                    k.c(order);
                } else {
                    order2 = order;
                }
                i++;
                order = order2;
            }
            order.flip();
            this.g.setInput(order.array(), 0, order.remaining());
            while (!this.g.needsInput()) {
                int deflate;
                ByteBuffer order3 = k.c(order.capacity()).order(ByteOrder.BIG_ENDIAN);
                if (VERSION.SDK_INT >= 19) {
                    deflate = this.g.deflate(order3.array(), 0, order3.capacity(), 2);
                } else {
                    deflate = this.g.deflate(order3.array(), 0, order3.capacity());
                }
                order3.limit(deflate);
                this.b.a(order3);
            }
            k.c(order);
            return this.b;
        }

        public synchronized void a(n nVar) {
            synchronized (this) {
                if (this.e) {
                    throw new IOException("closed");
                }
                int b = nVar.b();
                int i = (b * 8) + 4;
                ByteBuffer order = k.c(256).order(ByteOrder.BIG_ENDIAN);
                order.putInt(-2147287036);
                order.putInt((i & 16777215) | 0);
                order.putInt(b);
                for (int i2 = 0; i2 <= 10; i2++) {
                    if (nVar.a(i2)) {
                        order.putInt(((nVar.c(i2) & 255) << 24) | (i2 & 16777215));
                        order.putInt(nVar.b(i2));
                    }
                }
                order.flip();
                this.c.a(this.f.a(order));
            }
        }

        public synchronized void a(boolean z, int i, int i2) {
            boolean z2 = true;
            synchronized (this) {
                if (this.e) {
                    throw new IOException("closed");
                }
                boolean z3;
                boolean z4 = this.d;
                if ((i & 1) == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z4 == z3) {
                    z2 = false;
                }
                if (z != z2) {
                    throw new IllegalArgumentException("payload != reply");
                }
                ByteBuffer order = k.c(256).order(ByteOrder.BIG_ENDIAN);
                order.putInt(-2147287034);
                order.putInt(4);
                order.putInt(i);
                order.flip();
                this.c.a(this.f.a(order));
            }
        }

        public synchronized void a(int i, long j) {
            if (this.e) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + j);
            } else {
                ByteBuffer order = k.c(256).order(ByteOrder.BIG_ENDIAN);
                order.putInt(-2147287031);
                order.putInt(8);
                order.putInt(i);
                order.putInt((int) j);
                order.flip();
                this.c.a(this.f.a(order));
            }
        }

        public synchronized void close() {
            this.e = true;
        }
    }

    o() {
    }

    static {
        try {
            a = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(com.b.a.f.b.b.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError();
        }
    }

    public e a(m mVar, com.b.a.c.f.e.a aVar, boolean z) {
        return new a(mVar, aVar, z);
    }

    public f a(j jVar, boolean z) {
        return new b(jVar, z);
    }
}
