package com.b.a.c.a;

import com.b.a.a.a;
import com.b.a.ac;
import com.b.a.b.f;
import com.b.a.d.d;
import com.b.a.m;
import com.b.a.p;

public class g implements a<String> {
    byte[] a;
    String b;

    public g(String str) {
        this();
        this.b = str;
    }

    public void a(m mVar, final a aVar) {
        new d().a(mVar).a(new f<String>(this) {
            final /* synthetic */ g b;

            public void a(Exception exception, String str) {
                this.b.b = str;
                aVar.a(exception);
            }
        });
    }

    public void a(com.b.a.c.d dVar, p pVar, a aVar) {
        if (this.a == null) {
            this.a = this.b.getBytes();
        }
        ac.a(pVar, this.a, aVar);
    }

    public String a() {
        return "text/plain";
    }

    public boolean b() {
        return true;
    }

    public int c() {
        if (this.a == null) {
            this.a = this.b.getBytes();
        }
        return this.a.length;
    }

    public String toString() {
        return this.b;
    }
}
