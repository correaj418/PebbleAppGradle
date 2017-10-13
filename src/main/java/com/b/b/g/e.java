package com.b.b.g;

import com.b.a.ac;
import com.b.a.c.a.a;
import com.b.a.c.d;
import com.b.a.m;
import com.b.a.p;
import com.google.b.f;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;

public class e<T> implements a<T> {
    T a;
    byte[] b;
    Type c;
    f d;

    public e(f fVar, T t, com.google.b.c.a<T> aVar) {
        this.a = t;
        if (aVar != null) {
            this.c = aVar.getType();
        }
        this.d = fVar;
        if (t.getClass().isPrimitive() || (t instanceof String)) {
            throw new AssertionError("must provide a non-primitive type");
        }
    }

    byte[] d() {
        if (this.b != null) {
            return this.b;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Appendable outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
        if (this.c == null) {
            this.d.a(this.a, outputStreamWriter);
        } else {
            this.d.a(this.a, this.c, outputStreamWriter);
        }
        try {
            outputStreamWriter.flush();
            byteArrayOutputStream.flush();
        } catch (Exception e) {
        }
        this.b = byteArrayOutputStream.toByteArray();
        return this.b;
    }

    public void a(d dVar, p pVar, com.b.a.a.a aVar) {
        ac.a(pVar, d(), aVar);
    }

    public void a(m mVar, com.b.a.a.a aVar) {
    }

    public String a() {
        return "application/json";
    }

    public boolean b() {
        return true;
    }

    public int c() {
        return d().length;
    }
}
