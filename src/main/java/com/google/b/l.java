package com.google.b;

import com.google.b.b.j;
import com.google.b.d.c;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class l {
    public boolean h() {
        return this instanceof i;
    }

    public boolean i() {
        return this instanceof o;
    }

    public boolean j() {
        return this instanceof r;
    }

    public boolean k() {
        return this instanceof n;
    }

    public o l() {
        if (i()) {
            return (o) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public i m() {
        if (h()) {
            return (i) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public r n() {
        if (j()) {
            return (r) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean o() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            Writer stringWriter = new StringWriter();
            c cVar = new c(stringWriter);
            cVar.b(true);
            j.a(this, cVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
