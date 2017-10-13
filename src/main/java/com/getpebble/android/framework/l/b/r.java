package com.getpebble.android.framework.l.b;

import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.b.b.a;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.framework.o.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public abstract class r implements a {
    final short b;
    final ByteBuffer c;
    protected byte[] d;

    public r(com.getpebble.android.bluetooth.g.a aVar) {
        this(aVar.getCode());
    }

    public r(short s) {
        this.d = null;
        this.b = s;
        this.c = ByteBuffer.allocate(a(com.getpebble.android.bluetooth.g.a.fromCode(s), f()));
        this.c.position(4);
    }

    public synchronized void a(Byte... bArr) {
        this.d = null;
        try {
            for (Byte byteValue : bArr) {
                this.c.put(byteValue.byteValue());
            }
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public synchronized void a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        a(bArr, bArr.length);
    }

    public synchronized void a(byte[] bArr, int i) {
        b(ByteBuffer.wrap(bArr, 0, i));
    }

    public synchronized void b(ByteBuffer byteBuffer) {
        this.d = null;
        try {
            this.c.put(byteBuffer);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public ByteBuffer c() {
        e();
        return this.c;
    }

    protected boolean d() {
        return this.d != null;
    }

    protected void e() {
        this.d = null;
    }

    public synchronized byte[] c_() {
        byte[] bArr;
        if (d()) {
            bArr = this.d;
        } else {
            ByteOrder order = this.c.order();
            int position = this.c.position();
            int i = position - 4;
            this.c.position(0);
            this.c.order(ByteOrder.BIG_ENDIAN);
            this.c.putShort((short) i);
            this.c.putShort(this.b);
            this.c.order(order);
            this.c.position(position);
            this.d = Arrays.copyOf(this.c.array(), this.c.position());
            bArr = this.d;
        }
        return bArr;
    }

    protected b f() {
        return g();
    }

    public static b g() {
        ak.a r = PebbleApplication.r();
        if (r != null) {
            return r.capabilities;
        }
        return new b(null);
    }

    public static int a(com.getpebble.android.bluetooth.g.a aVar) {
        return a(aVar, g()) - 4;
    }

    public static int a(com.getpebble.android.bluetooth.g.a aVar, b bVar) {
        if (aVar.equals(com.getpebble.android.bluetooth.g.a.APP_MESSAGE) && bVar.support8kAppMessage) {
            return 8222;
        }
        return 2048;
    }
}
