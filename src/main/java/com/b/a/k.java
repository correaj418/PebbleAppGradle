package com.b.a;

import android.annotation.TargetApi;
import android.os.Looper;
import com.b.a.f.b;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

@TargetApi(9)
public class k {
    static PriorityQueue<ByteBuffer> c = new PriorityQueue(8, new a());
    public static int d = 262144;
    static int e = 0;
    static int f = 0;
    public static final ByteBuffer g = ByteBuffer.allocate(0);
    static final /* synthetic */ boolean h;
    private static int j = 1048576;
    private static final Object k = new Object();
    a<ByteBuffer> a = new a();
    ByteOrder b = ByteOrder.BIG_ENDIAN;
    private int i = 0;

    static class a implements Comparator<ByteBuffer> {
        a() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return a((ByteBuffer) obj, (ByteBuffer) obj2);
        }

        public int a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
            if (byteBuffer.capacity() == byteBuffer2.capacity()) {
                return 0;
            }
            if (byteBuffer.capacity() > byteBuffer2.capacity()) {
                return 1;
            }
            return -1;
        }
    }

    static {
        boolean z;
        if (k.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        h = z;
    }

    public k a(ByteOrder byteOrder) {
        this.b = byteOrder;
        return this;
    }

    public k(ByteBuffer... byteBufferArr) {
        a(byteBufferArr);
    }

    public k(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
    }

    public k a(ByteBuffer... byteBufferArr) {
        for (ByteBuffer a : byteBufferArr) {
            a(a);
        }
        return this;
    }

    public byte[] a(int i) {
        byte[] bArr = new byte[i];
        a(bArr);
        return bArr;
    }

    public byte[] a() {
        if (this.a.size() == 1) {
            ByteBuffer byteBuffer = (ByteBuffer) this.a.peek();
            if (byteBuffer.capacity() == d() && byteBuffer.isDirect()) {
                this.i = 0;
                return ((ByteBuffer) this.a.remove()).array();
            }
        }
        byte[] bArr = new byte[d()];
        a(bArr);
        return bArr;
    }

    public ByteBuffer[] b() {
        ByteBuffer[] byteBufferArr = (ByteBuffer[]) this.a.toArray(new ByteBuffer[this.a.size()]);
        this.a.clear();
        this.i = 0;
        return byteBufferArr;
    }

    public boolean c() {
        return this.i == 0;
    }

    public int d() {
        return this.i;
    }

    public boolean e() {
        return d() > 0;
    }

    public k b(int i) {
        a(null, 0, i);
        return this;
    }

    public int f() {
        int i = d(4).getInt();
        this.i -= 4;
        return i;
    }

    public char g() {
        char c = (char) d(1).get();
        this.i--;
        return c;
    }

    public short h() {
        short s = d(2).getShort();
        this.i -= 2;
        return s;
    }

    public byte i() {
        byte b = d(1).get();
        this.i--;
        return b;
    }

    public long j() {
        long j = d(8).getLong();
        this.i -= 8;
        return j;
    }

    public void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i, int i2) {
        if (d() < i2) {
            throw new IllegalArgumentException("length");
        }
        int i3 = i2;
        while (i3 > 0) {
            ByteBuffer byteBuffer = (ByteBuffer) this.a.peek();
            int min = Math.min(byteBuffer.remaining(), i3);
            if (bArr != null) {
                byteBuffer.get(bArr, i, min);
            } else {
                byteBuffer.position(byteBuffer.position() + min);
            }
            int i4 = i3 - min;
            i += min;
            if (byteBuffer.remaining() == 0) {
                ByteBuffer byteBuffer2 = (ByteBuffer) this.a.remove();
                if (h || byteBuffer == byteBuffer2) {
                    c(byteBuffer);
                } else {
                    throw new AssertionError();
                }
            }
            i3 = i4;
        }
        this.i -= i2;
    }

    public void a(k kVar, int i) {
        if (d() < i) {
            throw new IllegalArgumentException("length");
        }
        int i2 = 0;
        while (i2 < i) {
            ByteBuffer byteBuffer = (ByteBuffer) this.a.remove();
            int remaining = byteBuffer.remaining();
            if (remaining == 0) {
                c(byteBuffer);
            } else if (i2 + remaining > i) {
                i2 = i - i2;
                ByteBuffer c = c(i2);
                c.limit(i2);
                byteBuffer.get(c.array(), 0, i2);
                kVar.a(c);
                this.a.a((Object) byteBuffer);
                if (h || c.capacity() >= i2) {
                    if (!(h || c.position() == 0)) {
                        throw new AssertionError();
                    }
                    this.i -= i;
                }
                throw new AssertionError();
            } else {
                kVar.a(byteBuffer);
                i2 += remaining;
            }
        }
        this.i -= i;
    }

    public void a(k kVar) {
        a(kVar, d());
    }

    public ByteBuffer k() {
        if (d() == 0) {
            return g;
        }
        d(d());
        return n();
    }

    private ByteBuffer d(int i) {
        if (d() < i) {
            throw new IllegalArgumentException("count : " + d() + "/" + i);
        }
        ByteBuffer byteBuffer = (ByteBuffer) this.a.peek();
        while (byteBuffer != null && !byteBuffer.hasRemaining()) {
            c((ByteBuffer) this.a.remove());
            byteBuffer = (ByteBuffer) this.a.peek();
        }
        if (byteBuffer == null) {
            return g;
        }
        if (byteBuffer.remaining() >= i) {
            return byteBuffer.order(this.b);
        }
        Object c = c(i);
        c.limit(i);
        byte[] array = c.array();
        int i2 = 0;
        Object obj = null;
        while (i2 < i) {
            obj = (ByteBuffer) this.a.remove();
            int min = Math.min(i - i2, obj.remaining());
            obj.get(array, i2, min);
            i2 += min;
            if (obj.remaining() == 0) {
                c((ByteBuffer) obj);
                obj = null;
            }
        }
        if (obj != null && obj.remaining() > 0) {
            this.a.a(obj);
        }
        this.a.a(c);
        return c.order(this.b);
    }

    public void l() {
        d(0);
    }

    public k b(k kVar) {
        kVar.a(this);
        return this;
    }

    public k a(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 0) {
            c(byteBuffer);
        } else {
            e(byteBuffer.remaining());
            if (this.a.size() > 0) {
                ByteBuffer byteBuffer2 = (ByteBuffer) this.a.d();
                if (byteBuffer2.capacity() - byteBuffer2.limit() >= byteBuffer.remaining()) {
                    byteBuffer2.mark();
                    byteBuffer2.position(byteBuffer2.limit());
                    byteBuffer2.limit(byteBuffer2.capacity());
                    byteBuffer2.put(byteBuffer);
                    byteBuffer2.limit(byteBuffer2.position());
                    byteBuffer2.reset();
                    c(byteBuffer);
                    l();
                }
            }
            this.a.add(byteBuffer);
            l();
        }
        return this;
    }

    public void b(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 0) {
            c(byteBuffer);
            return;
        }
        e(byteBuffer.remaining());
        if (this.a.size() > 0) {
            ByteBuffer byteBuffer2 = (ByteBuffer) this.a.c();
            if (byteBuffer2.position() >= byteBuffer.remaining()) {
                byteBuffer2.position(byteBuffer2.position() - byteBuffer.remaining());
                byteBuffer2.mark();
                byteBuffer2.put(byteBuffer);
                byteBuffer2.reset();
                c(byteBuffer);
                return;
            }
        }
        this.a.a((Object) byteBuffer);
    }

    private void e(int i) {
        if (d() >= 0) {
            this.i += i;
        }
    }

    public void m() {
        while (this.a.size() > 0) {
            c((ByteBuffer) this.a.remove());
        }
        if (h || this.a.size() == 0) {
            this.i = 0;
            return;
        }
        throw new AssertionError();
    }

    public ByteBuffer n() {
        ByteBuffer byteBuffer = (ByteBuffer) this.a.remove();
        this.i -= byteBuffer.remaining();
        return byteBuffer;
    }

    public int o() {
        return this.a.size();
    }

    public String p() {
        return a(null);
    }

    public String a(Charset charset) {
        if (charset == null) {
            charset = b.a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            int remaining;
            int i;
            byte[] bArr;
            ByteBuffer byteBuffer = (ByteBuffer) it.next();
            if (byteBuffer.isDirect()) {
                byte[] bArr2 = new byte[byteBuffer.remaining()];
                remaining = byteBuffer.remaining();
                byteBuffer.get(bArr2);
                i = remaining;
                remaining = 0;
                bArr = bArr2;
            } else {
                bArr = byteBuffer.array();
                remaining = byteBuffer.arrayOffset() + byteBuffer.position();
                i = byteBuffer.remaining();
            }
            stringBuilder.append(new String(bArr, remaining, i, charset));
        }
        return stringBuilder.toString();
    }

    public String q() {
        return b(null);
    }

    public String b(Charset charset) {
        String a = a(charset);
        m();
        return a;
    }

    private static PriorityQueue<ByteBuffer> r() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null || Thread.currentThread() != mainLooper.getThread()) {
            return c;
        }
        return null;
    }

    private static boolean d(ByteBuffer byteBuffer) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            if (((ByteBuffer) it.next()) == byteBuffer) {
                return true;
            }
        }
        return false;
    }

    public static void c(ByteBuffer byteBuffer) {
        if (byteBuffer != null && !byteBuffer.isDirect() && byteBuffer.arrayOffset() == 0 && byteBuffer.array().length == byteBuffer.capacity() && byteBuffer.capacity() >= 8192 && byteBuffer.capacity() <= d) {
            PriorityQueue r = r();
            if (r != null) {
                synchronized (k) {
                    while (e > j && r.size() > 0 && ((ByteBuffer) r.peek()).capacity() < byteBuffer.capacity()) {
                        e -= ((ByteBuffer) r.remove()).capacity();
                    }
                    if (e > j) {
                    } else if (h || !d(byteBuffer)) {
                        byteBuffer.position(0);
                        byteBuffer.limit(byteBuffer.capacity());
                        e += byteBuffer.capacity();
                        r.add(byteBuffer);
                        if (!h) {
                            if (((e == 0 ? 1 : 0) ^ (r.size() != 0 ? 1 : 0)) == 0) {
                                throw new AssertionError();
                            }
                        }
                        f = Math.max(f, byteBuffer.capacity());
                    } else {
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    public static ByteBuffer c(int i) {
        if (i <= f) {
            PriorityQueue r = r();
            if (r != null) {
                synchronized (k) {
                    ByteBuffer byteBuffer;
                    do {
                        if (r.size() > 0) {
                            byteBuffer = (ByteBuffer) r.remove();
                            if (r.size() == 0) {
                                f = 0;
                            }
                            e -= byteBuffer.capacity();
                            if (!h) {
                                if (((e == 0 ? 1 : 0) ^ (r.size() != 0 ? 1 : 0)) == 0) {
                                    throw new AssertionError();
                                }
                            }
                        }
                    } while (byteBuffer.capacity() < i);
                    return byteBuffer;
                }
            }
        }
        return ByteBuffer.allocate(Math.max(8192, i));
    }

    public static void a(OutputStream outputStream, ByteBuffer byteBuffer) {
        byte[] bArr;
        int i;
        int remaining;
        if (byteBuffer.isDirect()) {
            bArr = new byte[byteBuffer.remaining()];
            i = 0;
            remaining = byteBuffer.remaining();
            byteBuffer.get(bArr);
        } else {
            bArr = byteBuffer.array();
            i = byteBuffer.position() + byteBuffer.arrayOffset();
            remaining = byteBuffer.remaining();
        }
        outputStream.write(bArr, i, remaining);
    }
}
