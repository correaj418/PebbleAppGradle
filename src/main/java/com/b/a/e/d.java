package com.b.a.e;

import com.b.a.a.a;
import com.b.a.a.f;
import com.b.a.g;
import com.b.a.k;
import com.b.a.p;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class d implements p {
    g b;
    OutputStream c;
    f d;
    boolean e;
    Exception f;
    a g;

    public d(g gVar) {
        this(gVar, null);
    }

    public void a() {
        try {
            if (this.c != null) {
                this.c.close();
            }
            a(null);
        } catch (Exception e) {
            a(e);
        }
    }

    public d(g gVar, OutputStream outputStream) {
        this.b = gVar;
        a(outputStream);
    }

    public void a(OutputStream outputStream) {
        this.c = outputStream;
    }

    public OutputStream b() {
        return this.c;
    }

    public void a(k kVar) {
        while (kVar.o() > 0) {
            try {
                ByteBuffer n = kVar.n();
                b().write(n.array(), n.arrayOffset() + n.position(), n.remaining());
                k.c(n);
            } catch (Exception e) {
                a(e);
            } finally {
                kVar.m();
            }
        }
    }

    public void a(f fVar) {
        this.d = fVar;
    }

    public f g() {
        return this.d;
    }

    public boolean i() {
        return this.e;
    }

    public void a(Exception exception) {
        if (!this.e) {
            this.e = true;
            this.f = exception;
            if (this.g != null) {
                this.g.a(this.f);
            }
        }
    }

    public void a(a aVar) {
        this.g = aVar;
    }

    public g m() {
        return this.b;
    }
}
