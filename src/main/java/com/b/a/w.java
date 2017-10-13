package com.b.a;

import com.b.a.a.d;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class w implements d {
    static final /* synthetic */ boolean d = (!w.class.desiredAssertionStatus());
    Charset a;
    k b;
    a c;

    public interface a {
        void a(String str);
    }

    public w() {
        this(null);
    }

    public w(Charset charset) {
        this.b = new k();
        this.a = charset;
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    public void a(m mVar, k kVar) {
        ByteBuffer allocate = ByteBuffer.allocate(kVar.d());
        while (kVar.d() > 0) {
            byte i = kVar.i();
            if (i != (byte) 10) {
                allocate.put(i);
            } else if (d || this.c != null) {
                allocate.flip();
                this.b.a(allocate);
                this.c.a(this.b.b(this.a));
                this.b = new k();
                return;
            } else {
                throw new AssertionError();
            }
        }
        allocate.flip();
        this.b.a(allocate);
    }
}
