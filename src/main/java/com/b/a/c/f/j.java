package com.b.a.c.f;

import com.b.a.k;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class j {
    private static final g[] a = new g[]{new g(g.e, ""), new g(g.b, "GET"), new g(g.b, "POST"), new g(g.c, "/"), new g(g.c, "/index.html"), new g(g.d, "http"), new g(g.d, "https"), new g(g.a, "200"), new g(g.a, "204"), new g(g.a, "206"), new g(g.a, "304"), new g(g.a, "400"), new g(g.a, "404"), new g(g.a, "500"), new g("accept-charset", ""), new g("accept-encoding", "gzip, deflate"), new g("accept-language", ""), new g("accept-ranges", ""), new g("accept", ""), new g("access-control-allow-origin", ""), new g("age", ""), new g("allow", ""), new g("authorization", ""), new g("cache-control", ""), new g("content-disposition", ""), new g("content-encoding", ""), new g("content-language", ""), new g("content-length", ""), new g("content-location", ""), new g("content-range", ""), new g("content-type", ""), new g("cookie", ""), new g("date", ""), new g("etag", ""), new g("expect", ""), new g("expires", ""), new g("from", ""), new g("host", ""), new g("if-match", ""), new g("if-modified-since", ""), new g("if-none-match", ""), new g("if-range", ""), new g("if-unmodified-since", ""), new g("last-modified", ""), new g("link", ""), new g("location", ""), new g("max-forwards", ""), new g("proxy-authenticate", ""), new g("proxy-authorization", ""), new g("range", ""), new g("referer", ""), new g("refresh", ""), new g("retry-after", ""), new g("server", ""), new g("set-cookie", ""), new g("strict-transport-security", ""), new g("transfer-encoding", ""), new g("user-agent", ""), new g("vary", ""), new g("via", ""), new g("www-authenticate", "")};
    private static final Map<c, Integer> b = c();

    static final class a {
        g[] a = new g[8];
        int b = (this.a.length - 1);
        int c = 0;
        b d = new com.b.a.c.f.b.a();
        b e = new com.b.a.c.f.b.a();
        int f = 0;
        private final List<g> g = new ArrayList();
        private final k h = new k();
        private int i;
        private int j;

        a(int i) {
            this.i = i;
            this.j = i;
        }

        public void a(k kVar) {
            kVar.a(this.h);
        }

        void a(int i) {
            this.i = i;
            this.j = this.i;
            e();
        }

        private void e() {
            if (this.j >= this.f) {
                return;
            }
            if (this.j == 0) {
                f();
            } else {
                b(this.f - this.j);
            }
        }

        private void f() {
            g();
            Arrays.fill(this.a, null);
            this.b = this.a.length - 1;
            this.c = 0;
            this.f = 0;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                for (int length = this.a.length - 1; length >= this.b && i > 0; length--) {
                    i -= this.a[length].j;
                    this.f -= this.a[length].j;
                    this.c--;
                    i2++;
                }
                this.d.d(i2);
                this.e.d(i2);
                System.arraycopy(this.a, this.b + 1, this.a, (this.b + 1) + i2, this.c);
                this.b += i2;
            }
            return i2;
        }

        void a() {
            while (this.h.e()) {
                int i = this.h.i() & 255;
                if (i == 128) {
                    throw new IOException("index == 0");
                } else if ((i & 128) == 128) {
                    c(a(i, 127) - 1);
                } else if (i == 64) {
                    i();
                } else if ((i & 64) == 64) {
                    f(a(i, 63) - 1);
                } else if ((i & 32) == 32) {
                    if ((i & 16) != 16) {
                        this.j = a(i, 15);
                        if (this.j < 0 || this.j > this.i) {
                            throw new IOException("Invalid header table byte count " + this.j);
                        }
                        e();
                    } else if ((i & 15) != 0) {
                        throw new IOException("Invalid header table state change " + i);
                    } else {
                        g();
                    }
                } else if (i == 16 || i == 0) {
                    h();
                } else {
                    e(a(i, 15) - 1);
                }
            }
        }

        private void g() {
            this.d.a();
            this.e.a();
        }

        void b() {
            int length = this.a.length - 1;
            while (length != this.b) {
                if (this.d.c(length) && !this.e.c(length)) {
                    this.g.add(this.a[length]);
                }
                length--;
            }
        }

        List<g> c() {
            List arrayList = new ArrayList(this.g);
            this.g.clear();
            this.e.a();
            return arrayList;
        }

        private void c(int i) {
            int i2;
            if (h(i)) {
                i2 = i - this.c;
                if (i2 > j.a.length - 1) {
                    throw new IOException("Header index too large " + (i2 + 1));
                }
                g gVar = j.a[i2];
                if (this.j == 0) {
                    this.g.add(gVar);
                    return;
                } else {
                    a(-1, gVar);
                    return;
                }
            }
            i2 = d(i);
            if (!this.d.c(i2)) {
                this.g.add(this.a[i2]);
                this.e.a(i2);
            }
            this.d.b(i2);
        }

        private int d(int i) {
            return (this.b + 1) + i;
        }

        private void e(int i) {
            this.g.add(new g(g(i), d()));
        }

        private void h() {
            this.g.add(new g(j.b(d()), d()));
        }

        private void f(int i) {
            a(-1, new g(g(i), d()));
        }

        private void i() {
            a(-1, new g(j.b(d()), d()));
        }

        private c g(int i) {
            if (h(i)) {
                return j.a[i - this.c].h;
            }
            return this.a[d(i)].h;
        }

        private boolean h(int i) {
            return i >= this.c;
        }

        private void a(int i, g gVar) {
            int i2;
            int i3 = gVar.j;
            if (i != -1) {
                i2 = i3 - this.a[d(i)].j;
            } else {
                i2 = i3;
            }
            if (i2 > this.j) {
                f();
                this.g.add(gVar);
                return;
            }
            i3 = b((this.f + i2) - this.j);
            if (i == -1) {
                if (this.c + 1 > this.a.length) {
                    Object obj = new g[(this.a.length * 2)];
                    System.arraycopy(this.a, 0, obj, this.a.length, this.a.length);
                    if (obj.length == 64) {
                        this.d = ((com.b.a.c.f.b.a) this.d).b();
                        this.e = ((com.b.a.c.f.b.a) this.e).b();
                    }
                    this.d.d(this.a.length);
                    this.e.d(this.a.length);
                    this.b = this.a.length - 1;
                    this.a = obj;
                }
                i3 = this.b;
                this.b = i3 - 1;
                this.d.a(i3);
                this.a[i3] = gVar;
                this.c++;
            } else {
                i3 = (i3 + d(i)) + i;
                this.d.a(i3);
                this.a[i3] = gVar;
            }
            this.f += i2;
        }

        private int j() {
            return this.h.i() & 255;
        }

        int a(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            i3 = 0;
            while (true) {
                int j = j();
                if ((j & 128) == 0) {
                    return (j << i3) + i2;
                }
                i2 += (j & 127) << i3;
                i3 += 7;
            }
        }

        c d() {
            int j = j();
            Object obj = (j & 128) == 128 ? 1 : null;
            j = a(j, 127);
            if (obj != null) {
                return c.a(l.a().a(this.h.a(j)));
            }
            return c.a(this.h.a(j));
        }
    }

    static final class b {
        b() {
        }

        k a(List<g> list) {
            k kVar = new k();
            ByteBuffer c = k.c(8192);
            int size = list.size();
            int i = 0;
            while (i < size) {
                ByteBuffer c2;
                if (c.remaining() < c.capacity() / 2) {
                    c.flip();
                    kVar.a(c);
                    c2 = k.c(c.capacity() * 2);
                } else {
                    c2 = c;
                }
                c c3 = ((g) list.get(i)).h.c();
                Integer num = (Integer) j.b.get(c3);
                if (num != null) {
                    a(c2, num.intValue() + 1, 15, 0);
                    a(c2, ((g) list.get(i)).i);
                } else {
                    c2.put((byte) 0);
                    a(c2, c3);
                    a(c2, ((g) list.get(i)).i);
                }
                i++;
                c = c2;
            }
            kVar.a(c);
            return kVar;
        }

        void a(ByteBuffer byteBuffer, int i, int i2, int i3) {
            if (i < i2) {
                byteBuffer.put((byte) (i3 | i));
                return;
            }
            byteBuffer.put((byte) (i3 | i2));
            int i4 = i - i2;
            while (i4 >= 128) {
                byteBuffer.put((byte) ((i4 & 127) | 128));
                i4 >>>= 7;
            }
            byteBuffer.put((byte) i4);
        }

        void a(ByteBuffer byteBuffer, c cVar) {
            a(byteBuffer, cVar.d(), 127, 0);
            byteBuffer.put(cVar.e());
        }
    }

    private static Map<c, Integer> c() {
        Map linkedHashMap = new LinkedHashMap(a.length);
        for (int i = 0; i < a.length; i++) {
            if (!linkedHashMap.containsKey(a[i].h)) {
                linkedHashMap.put(a[i].h, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static c b(c cVar) {
        int i = 0;
        int d = cVar.d();
        while (i < d) {
            byte a = cVar.a(i);
            if (a < (byte) 65 || a > (byte) 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + cVar.a());
            }
        }
        return cVar;
    }
}
