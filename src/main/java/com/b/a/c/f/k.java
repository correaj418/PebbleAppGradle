package com.b.a.c.f;

import com.b.a.a.d;
import com.b.a.j;
import com.b.a.m;
import com.b.a.o;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

final class k implements s {
    private static final Logger a = Logger.getLogger(k.class.getName());
    private static final c b = c.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    static final class a {
        private static final String[] a = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        private static final String[] b = new String[64];
        private static final String[] c = new String[256];

        static String a(boolean z, int i, int i2, byte b, byte b2) {
            String format = b < a.length ? a[b] : String.format(Locale.ENGLISH, "0x%02x", new Object[]{Byte.valueOf(b)});
            String a = a(b, b2);
            Locale locale = Locale.ENGLISH;
            String str = "%s 0x%08x %5d %-13s %s";
            Object[] objArr = new Object[5];
            objArr[0] = z ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = format;
            objArr[4] = a;
            return String.format(locale, str, objArr);
        }

        static String a(byte b, byte b2) {
            if (b2 == (byte) 0) {
                return "";
            }
            switch (b) {
                case (byte) 2:
                case (byte) 3:
                case (byte) 7:
                case (byte) 8:
                    return c[b2];
                case (byte) 4:
                case (byte) 6:
                    return b2 == (byte) 1 ? "ACK" : c[b2];
                default:
                    String str = b2 < b.length ? b[b2] : c[b2];
                    if (b == (byte) 5 && (b2 & 4) != 0) {
                        return str.replace("HEADERS", "PUSH_PROMISE");
                    }
                    if (b != (byte) 0 || (b2 & 32) == 0) {
                        return str;
                    }
                    return str.replace("PRIORITY", "COMPRESSED");
            }
        }

        static {
            int i = 0;
            for (int i2 = 0; i2 < c.length; i2++) {
                c[i2] = String.format(Locale.ENGLISH, "%8s", new Object[]{Integer.toBinaryString(i2)}).replace(' ', '0');
            }
            b[0] = "";
            b[1] = "END_STREAM";
            b[2] = "END_SEGMENT";
            b[3] = "END_STREAM|END_SEGMENT";
            int[] iArr = new int[]{1, 2, 3};
            b[8] = "PADDED";
            for (int i3 : iArr) {
                b[i3 | 8] = b[i3] + "|PADDED";
            }
            b[4] = "END_HEADERS";
            b[32] = "PRIORITY";
            b[36] = "END_HEADERS|PRIORITY";
            for (int i4 : new int[]{4, 32, 36}) {
                for (int i5 : iArr) {
                    b[i5 | i4] = b[i5] + '|' + b[i4];
                    b[(i5 | i4) | 8] = b[i5] + '|' + b[i4] + "|PADDED";
                }
            }
            while (i < b.length) {
                if (b[i] == null) {
                    b[i] = c[i];
                }
                i++;
            }
        }
    }

    static final class b implements e {
        final a a;
        int b;
        int c;
        byte d;
        byte e;
        short f;
        int g;
        byte h;
        int i;
        int j;
        private final m k;
        private final boolean l;
        private final com.b.a.c.f.e.a m;
        private final o n;
        private final d o = new d(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void a(m mVar, com.b.a.k kVar) {
                kVar.a(ByteOrder.BIG_ENDIAN);
                this.a.b = kVar.f();
                this.a.c = kVar.f();
                this.a.f = (short) ((this.a.b & 1073676288) >> 16);
                this.a.e = (byte) ((this.a.b & 65280) >> 8);
                this.a.d = (byte) (this.a.b & 255);
                this.a.g = this.a.c & Integer.MAX_VALUE;
                if (k.a.isLoggable(Level.FINE)) {
                    k.a.fine(a.a(true, this.a.g, this.a.f, this.a.e, this.a.d));
                }
                this.a.n.a(this.a.f, this.a.p);
            }
        };
        private final d p = new d(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void a(m mVar, com.b.a.k kVar) {
                try {
                    switch (this.a.e) {
                        case (byte) 0:
                            this.a.c(kVar, this.a.f, this.a.d, this.a.g);
                            break;
                        case (byte) 1:
                            this.a.a(kVar, this.a.f, this.a.d, this.a.g);
                            break;
                        case (byte) 2:
                            this.a.d(kVar, this.a.f, this.a.d, this.a.g);
                            break;
                        case (byte) 3:
                            this.a.e(kVar, this.a.f, this.a.d, this.a.g);
                            break;
                        case (byte) 4:
                            this.a.f(kVar, this.a.f, this.a.d, this.a.g);
                            break;
                        case (byte) 5:
                            this.a.g(kVar, this.a.f, this.a.d, this.a.g);
                            break;
                        case (byte) 6:
                            this.a.h(kVar, this.a.f, this.a.d, this.a.g);
                            break;
                        case (byte) 7:
                            this.a.i(kVar, this.a.f, this.a.d, this.a.g);
                            break;
                        case (byte) 8:
                            this.a.j(kVar, this.a.f, this.a.d, this.a.g);
                            break;
                        case (byte) 9:
                            this.a.b(kVar, this.a.f, this.a.d, this.a.g);
                            break;
                        default:
                            kVar.m();
                            break;
                    }
                    this.a.a();
                } catch (Exception e) {
                    this.a.m.a(e);
                }
            }
        };

        b(m mVar, com.b.a.c.f.e.a aVar, int i, boolean z) {
            this.k = mVar;
            this.l = z;
            this.a = new a(i);
            this.m = aVar;
            this.n = new o();
            a();
        }

        private void a() {
            this.k.a(this.n);
            this.n.a(8, this.o);
        }

        private void a(com.b.a.k kVar, short s, byte b, int i) {
            short s2 = (short) 0;
            if (i == 0) {
                throw k.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            if ((b & 8) != 0) {
                s2 = (short) (kVar.i() & 255);
            }
            if ((b & 32) != 0) {
                a(kVar, i);
                s = (short) (s - 5);
            }
            short a = k.b(s, b, s2);
            this.h = this.e;
            a(kVar, a, s2, b, i);
        }

        private void b(com.b.a.k kVar, short s, byte b, int i) {
            if (i != this.i) {
                throw new IOException("continuation stream id mismatch");
            }
            a(kVar, s, (short) 0, b, i);
        }

        private void a(com.b.a.k kVar, short s, short s2, byte b, int i) {
            boolean z = true;
            kVar.b((int) s2);
            this.a.a(kVar);
            this.a.a();
            this.a.b();
            if ((b & 4) == 0) {
                this.i = i;
            } else if (this.h == (byte) 1) {
                if ((b & 1) == 0) {
                    z = false;
                }
                this.m.a(false, z, i, -1, this.a.c(), i.HTTP_20_HEADERS);
            } else if (this.h == (byte) 5) {
                this.m.a(i, this.j, this.a.c());
            } else {
                throw new AssertionError("unknown header type");
            }
        }

        private void c(com.b.a.k kVar, short s, byte b, int i) {
            boolean z;
            short s2 = (short) 1;
            int i2 = (short) 0;
            if ((b & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((b & 32) == 0) {
                s2 = (short) 0;
            }
            if (s2 != (short) 0) {
                throw k.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            if ((b & 8) != 0) {
                i2 = (short) (kVar.i() & 255);
            }
            k.b(s, b, i2);
            this.m.a(z, i, kVar);
            kVar.b(i2);
        }

        private void d(com.b.a.k kVar, short s, byte b, int i) {
            if (s != (short) 5) {
                throw k.d("TYPE_PRIORITY length: %d != 5", Short.valueOf(s));
            } else if (i == 0) {
                throw k.d("TYPE_PRIORITY streamId == 0", new Object[0]);
            } else {
                a(kVar, i);
            }
        }

        private void a(com.b.a.k kVar, int i) {
            int f = kVar.f();
            this.m.a(i, f & Integer.MAX_VALUE, (kVar.i() & 255) + 1, (Integer.MIN_VALUE & f) != 0);
        }

        private void e(com.b.a.k kVar, short s, byte b, int i) {
            if (s != (short) 4) {
                throw k.d("TYPE_RST_STREAM length: %d != 4", Short.valueOf(s));
            } else if (i == 0) {
                throw k.d("TYPE_RST_STREAM streamId == 0", new Object[0]);
            } else {
                d fromHttp2 = d.fromHttp2(kVar.f());
                if (fromHttp2 == null) {
                    throw k.d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(r0));
                } else {
                    this.m.a(i, fromHttp2);
                }
            }
        }

        private void f(com.b.a.k kVar, short s, byte b, int i) {
            if (i != 0) {
                throw k.d("TYPE_SETTINGS streamId != 0", new Object[0]);
            } else if ((b & 1) != 0) {
                if (s != (short) 0) {
                    throw k.d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                }
                this.m.b();
            } else if (s % 6 != 0) {
                throw k.d("TYPE_SETTINGS length %% 6 != 0: %s", Short.valueOf(s));
            } else {
                n nVar = new n();
                for (short s2 = (short) 0; s2 < s; s2 += 6) {
                    int h = kVar.h();
                    int f = kVar.f();
                    switch (h) {
                        case 1:
                        case 5:
                            break;
                        case 2:
                            if (!(f == 0 || f == 1)) {
                                throw k.d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                            }
                        case 3:
                            h = 4;
                            break;
                        case 4:
                            h = 7;
                            if (f >= 0) {
                                break;
                            }
                            throw k.d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        default:
                            throw k.d("PROTOCOL_ERROR invalid settings id: %s", Short.valueOf(h));
                    }
                    nVar.a(h, 0, f);
                }
                this.m.a(false, nVar);
                if (nVar.c() >= 0) {
                    this.a.a(nVar.c());
                }
            }
        }

        private void g(com.b.a.k kVar, short s, byte b, int i) {
            short s2 = (short) 0;
            if (i == 0) {
                throw k.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            }
            if ((b & 8) != 0) {
                s2 = (short) (kVar.i() & 255);
            }
            this.j = kVar.f() & Integer.MAX_VALUE;
            short a = k.b((short) (s - 4), b, s2);
            this.h = (byte) 5;
            a(kVar, a, s2, b, i);
        }

        private void h(com.b.a.k kVar, short s, byte b, int i) {
            boolean z = true;
            if (s != (short) 8) {
                throw k.d("TYPE_PING length != 8: %s", Short.valueOf(s));
            } else if (i != 0) {
                throw k.d("TYPE_PING streamId != 0", new Object[0]);
            } else {
                int f = kVar.f();
                int f2 = kVar.f();
                if ((b & 1) == 0) {
                    z = false;
                }
                this.m.a(z, f, f2);
            }
        }

        private void i(com.b.a.k kVar, short s, byte b, int i) {
            if (s < (short) 8) {
                throw k.d("TYPE_GOAWAY length < 8: %s", Short.valueOf(s));
            } else if (i != 0) {
                throw k.d("TYPE_GOAWAY streamId != 0", new Object[0]);
            } else {
                int f = kVar.f();
                int i2 = s - 8;
                d fromHttp2 = d.fromHttp2(kVar.f());
                if (fromHttp2 == null) {
                    throw k.d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(r0));
                }
                c cVar = c.a;
                if (i2 > 0) {
                    cVar = c.a(kVar.a(i2));
                }
                this.m.a(f, fromHttp2, cVar);
            }
        }

        private void j(com.b.a.k kVar, short s, byte b, int i) {
            if (s != (short) 4) {
                throw k.d("TYPE_WINDOW_UPDATE length !=4: %s", Short.valueOf(s));
            }
            long f = ((long) kVar.f()) & 2147483647L;
            if (f == 0) {
                throw k.d("windowSizeIncrement was 0", Long.valueOf(f));
            } else {
                this.m.a(i, f);
            }
        }
    }

    static final class c implements f {
        private final j a;
        private final boolean b;
        private final b c;
        private boolean d;
        private final com.b.a.k e = new com.b.a.k();

        c(j jVar, boolean z) {
            this.a = jVar;
            this.b = z;
            this.c = new b();
        }

        public synchronized void b() {
            if (this.d) {
                throw new IOException("closed");
            }
            a(0, 0, (byte) 4, (byte) 1);
        }

        public synchronized void a() {
            if (this.d) {
                throw new IOException("closed");
            } else if (this.b) {
                if (k.a.isLoggable(Level.FINE)) {
                    k.a.fine(String.format(Locale.ENGLISH, ">> CONNECTION %s", new Object[]{k.b.b()}));
                }
                this.a.a(new com.b.a.k(k.b.e()));
            }
        }

        public synchronized void a(boolean z, boolean z2, int i, int i2, List<g> list) {
            if (z2) {
                throw new UnsupportedOperationException();
            } else if (this.d) {
                throw new IOException("closed");
            } else {
                a(z, i, (List) list);
            }
        }

        public synchronized void a(int i, int i2, List<g> list) {
            if (this.d) {
                throw new IOException("closed");
            }
            com.b.a.k a = this.c.a(list);
            long d = (long) a.d();
            int min = (int) Math.min(16379, d);
            a(i, min + 4, (byte) 5, d == ((long) min) ? (byte) 4 : (byte) 0);
            ByteBuffer order = com.b.a.k.c(8192).order(ByteOrder.BIG_ENDIAN);
            order.putInt(Integer.MAX_VALUE & i2);
            order.flip();
            this.e.a(order);
            a.a(this.e, min);
            this.a.a(this.e);
            if (d > ((long) min)) {
                a(a, i);
            }
        }

        void a(boolean z, int i, List<g> list) {
            if (this.d) {
                throw new IOException("closed");
            }
            com.b.a.k a = this.c.a(list);
            long d = (long) a.d();
            int min = (int) Math.min(16383, d);
            byte b = d == ((long) min) ? (byte) 4 : (byte) 0;
            if (z) {
                b = (byte) (b | 1);
            }
            a(i, min, (byte) 1, b);
            a.a(this.e, min);
            this.a.a(this.e);
            if (d > ((long) min)) {
                a(a, i);
            }
        }

        private void a(com.b.a.k kVar, int i) {
            while (kVar.e()) {
                int min = Math.min(16383, kVar.d());
                a(i, min, (byte) 9, kVar.d() - min == 0 ? (byte) 4 : (byte) 0);
                kVar.a(this.e, min);
                this.a.a(this.e);
            }
        }

        public synchronized void a(int i, d dVar) {
            if (this.d) {
                throw new IOException("closed");
            } else if (dVar.spdyRstCode == -1) {
                throw new IllegalArgumentException();
            } else {
                a(i, 4, (byte) 3, (byte) 0);
                ByteBuffer order = com.b.a.k.c(8192).order(ByteOrder.BIG_ENDIAN);
                order.putInt(dVar.httpCode);
                order.flip();
                this.a.a(this.e.a(order));
            }
        }

        public synchronized void a(boolean z, int i, com.b.a.k kVar) {
            if (this.d) {
                throw new IOException("closed");
            }
            byte b = (byte) 0;
            if (z) {
                b = (byte) 1;
            }
            a(i, b, kVar);
        }

        void a(int i, byte b, com.b.a.k kVar) {
            a(i, kVar.d(), (byte) 0, b);
            this.a.a(kVar);
        }

        public synchronized void a(n nVar) {
            synchronized (this) {
                if (this.d) {
                    throw new IOException("closed");
                }
                a(0, nVar.b() * 6, (byte) 4, (byte) 0);
                ByteBuffer order = com.b.a.k.c(8192).order(ByteOrder.BIG_ENDIAN);
                for (int i = 0; i < 10; i++) {
                    if (nVar.a(i)) {
                        int i2;
                        if (i == 4) {
                            i2 = 3;
                        } else if (i == 7) {
                            i2 = 4;
                        } else {
                            i2 = i;
                        }
                        order.putShort((short) i2);
                        order.putInt(nVar.b(i));
                    }
                }
                order.flip();
                this.a.a(this.e.a(order));
            }
        }

        public synchronized void a(boolean z, int i, int i2) {
            byte b = (byte) 0;
            synchronized (this) {
                if (this.d) {
                    throw new IOException("closed");
                }
                if (z) {
                    b = (byte) 1;
                }
                a(0, 8, (byte) 6, b);
                ByteBuffer order = com.b.a.k.c(256).order(ByteOrder.BIG_ENDIAN);
                order.putInt(i);
                order.putInt(i2);
                order.flip();
                this.a.a(this.e.a(order));
            }
        }

        public synchronized void a(int i, long j) {
            if (this.d) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw k.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            } else {
                a(i, 4, (byte) 8, (byte) 0);
                ByteBuffer order = com.b.a.k.c(256).order(ByteOrder.BIG_ENDIAN);
                order.putInt((int) j);
                order.flip();
                this.a.a(this.e.a(order));
            }
        }

        public synchronized void close() {
            this.d = true;
        }

        void a(int i, int i2, byte b, byte b2) {
            if (k.a.isLoggable(Level.FINE)) {
                k.a.fine(a.a(false, i, i2, b, b2));
            }
            if (i2 > 16383) {
                throw k.c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(16383), Integer.valueOf(i2));
            } else if ((Integer.MIN_VALUE & i) != 0) {
                throw k.c("reserved bit set: %s", Integer.valueOf(i));
            } else {
                ByteBuffer order = com.b.a.k.c(256).order(ByteOrder.BIG_ENDIAN);
                order.putInt((((i2 & 16383) << 16) | ((b & 255) << 8)) | (b2 & 255));
                order.putInt(Integer.MAX_VALUE & i);
                order.flip();
                this.a.a(this.e.a(order));
            }
        }
    }

    k() {
    }

    public e a(m mVar, com.b.a.c.f.e.a aVar, boolean z) {
        return new b(mVar, aVar, 4096, z);
    }

    public f a(j jVar, boolean z) {
        return new c(jVar, z);
    }

    private static IllegalArgumentException c(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(Locale.ENGLISH, str, objArr));
    }

    private static IOException d(String str, Object... objArr) {
        throw new IOException(String.format(Locale.ENGLISH, str, objArr));
    }

    private static short b(short s, byte b, short s2) {
        if ((b & 8) != 0) {
            s = (short) (s - 1);
        }
        if (s2 <= s) {
            return (short) (s - s2);
        }
        throw d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s2), Short.valueOf(s));
    }
}
