package com.b.a.c.d;

import com.b.a.ac;
import com.b.a.k;
import com.b.a.m;
import com.b.a.t;
import java.nio.ByteBuffer;
import java.util.zip.Inflater;

public class g extends t {
    static final /* synthetic */ boolean g = (!g.class.desiredAssertionStatus());
    private Inflater d;
    k f;

    protected void b(Exception exception) {
        this.d.end();
        if (exception != null && this.d.getRemaining() > 0) {
            exception = new e("data still remaining in inflater", exception);
        }
        super.b(exception);
    }

    public void a(m mVar, k kVar) {
        try {
            ByteBuffer c = k.c(kVar.d() * 2);
            while (kVar.o() > 0) {
                ByteBuffer n = kVar.n();
                if (n.hasRemaining()) {
                    int remaining = n.remaining();
                    this.d.setInput(n.array(), n.arrayOffset() + n.position(), n.remaining());
                    do {
                        c.position(this.d.inflate(c.array(), c.arrayOffset() + c.position(), c.remaining()) + c.position());
                        if (!c.hasRemaining()) {
                            c.flip();
                            this.f.a(c);
                            if (g || remaining != 0) {
                                c = k.c(c.capacity() * 2);
                            } else {
                                throw new AssertionError();
                            }
                        }
                        if (this.d.needsInput()) {
                            break;
                        }
                    } while (!this.d.finished());
                }
                k.c(n);
            }
            c.flip();
            this.f.a(c);
            ac.a((m) this, this.f);
        } catch (Exception e) {
            b(e);
        }
    }

    public g() {
        this(new Inflater());
    }

    public g(Inflater inflater) {
        this.f = new k();
        this.d = inflater;
    }
}
