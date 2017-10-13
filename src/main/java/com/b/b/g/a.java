package com.b.b.g;

import com.b.a.ac;
import com.b.a.c.d;
import com.b.a.m;
import com.b.a.p;
import com.google.b.f;
import com.google.b.l;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class a<T extends l> implements com.b.a.c.a.a<T> {
    byte[] a;
    T b;
    f c;

    public a(f fVar, T t) {
        this.b = t;
        this.c = fVar;
    }

    public void a(m mVar, com.b.a.a.a aVar) {
        throw new AssertionError("not implemented");
    }

    public void a(d dVar, p pVar, com.b.a.a.a aVar) {
        if (this.a == null) {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.c.a(this.b, new OutputStreamWriter(byteArrayOutputStream));
            this.a = byteArrayOutputStream.toByteArray();
        }
        ac.a(pVar, this.a, aVar);
    }

    public String a() {
        return "application/json";
    }

    public boolean b() {
        return true;
    }

    public int c() {
        if (this.a == null) {
            this.a = this.b.toString().getBytes();
        }
        return this.a.length;
    }
}
