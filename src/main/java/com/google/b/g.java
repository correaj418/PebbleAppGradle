package com.google.b;

import com.google.b.b.a;
import com.google.b.b.a.l;
import com.google.b.b.a.n;
import com.google.b.b.d;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g {
    private d a = d.a;
    private v b = v.DEFAULT;
    private e c = d.IDENTITY;
    private final Map<Type, h<?>> d = new HashMap();
    private final List<x> e = new ArrayList();
    private final List<x> f = new ArrayList();
    private boolean g = false;
    private String h;
    private int i = 2;
    private int j = 2;
    private boolean k = false;
    private boolean l = false;
    private boolean m = true;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    public g a() {
        this.g = true;
        return this;
    }

    public g b() {
        this.n = true;
        return this;
    }

    public g a(Type type, Object obj) {
        boolean z = (obj instanceof t) || (obj instanceof k) || (obj instanceof h) || (obj instanceof w);
        a.a(z);
        if (obj instanceof h) {
            this.d.put(type, (h) obj);
        }
        if ((obj instanceof t) || (obj instanceof k)) {
            this.e.add(l.b(com.google.b.c.a.get(type), obj));
        }
        if (obj instanceof w) {
            this.e.add(n.a(com.google.b.c.a.get(type), (w) obj));
        }
        return this;
    }

    public g a(x xVar) {
        this.e.add(xVar);
        return this;
    }

    public f c() {
        List arrayList = new ArrayList();
        arrayList.addAll(this.e);
        Collections.reverse(arrayList);
        arrayList.addAll(this.f);
        a(this.h, this.i, this.j, arrayList);
        return new f(this.a, this.c, this.d, this.g, this.k, this.o, this.m, this.n, this.p, this.l, this.b, arrayList);
    }

    private void a(String str, int i, int i2, List<x> list) {
        Object aVar;
        if (str != null && !"".equals(str.trim())) {
            aVar = new a(str);
        } else if (i != 2 && i2 != 2) {
            aVar = new a(i, i2);
        } else {
            return;
        }
        list.add(l.a(com.google.b.c.a.get(Date.class), aVar));
        list.add(l.a(com.google.b.c.a.get(Timestamp.class), aVar));
        list.add(l.a(com.google.b.c.a.get(java.sql.Date.class), aVar));
    }
}
