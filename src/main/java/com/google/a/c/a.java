package com.google.a.c;

import java.io.InputStream;

public abstract class a {
    public abstract InputStream a();

    protected a() {
    }

    public byte[] b() {
        d a = d.a();
        try {
            byte[] a2 = b.a((InputStream) a.a(a()));
            a.close();
            return a2;
        } catch (Throwable th) {
            a.close();
        }
    }
}
