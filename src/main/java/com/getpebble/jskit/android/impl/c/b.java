package com.getpebble.jskit.android.impl.c;

import com.getpebble.jskit.android.impl.c;
import com.getpebble.jskit.android.impl.c.a.d;
import com.getpebble.jskit.android.impl.c.a.e;
import com.getpebble.jskit.android.impl.c.a.f;
import java.util.HashSet;
import java.util.Set;

public class b extends c implements a {
    private final Set<a> a = new HashSet();

    protected void b() {
    }

    public void a(a aVar) {
        this.a.add(aVar);
    }

    public void a(com.getpebble.jskit.android.impl.c.a.c cVar) {
        for (a a : c()) {
            a.a(cVar);
        }
    }

    public void a(com.getpebble.jskit.android.impl.c.a.b bVar) {
        for (a a : c()) {
            a.a(bVar);
        }
    }

    public void a(d dVar) {
        for (a a : c()) {
            a.a(dVar);
        }
    }

    public void a(e eVar) {
        for (a a : c()) {
            a.a(eVar);
        }
    }

    public void a(f fVar) {
        for (a a : c()) {
            a.a(fVar);
        }
    }

    public void a(String str, String str2) {
        for (a a : c()) {
            a.a(str, str2);
        }
    }

    public void a(String str) {
        for (a a : c()) {
            a.a(str);
        }
    }

    private Set<a> c() {
        return new HashSet(this.a);
    }
}
