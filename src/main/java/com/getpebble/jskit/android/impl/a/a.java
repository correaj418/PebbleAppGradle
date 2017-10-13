package com.getpebble.jskit.android.impl.a;

import com.getpebble.jskit.android.impl.b;
import com.getpebble.jskit.android.impl.c;
import java.util.HashSet;
import java.util.Set;

public class a extends c {
    private b a;
    private Set<String> b;

    public a(b bVar) {
        this.a = bVar;
    }

    protected void b() {
        this.b = new HashSet();
    }

    public void a(String str) {
        this.b.add(str);
    }

    public void b(String str) {
        this.b.remove(str);
    }

    public boolean c(String str) {
        return this.b.contains(str);
    }
}
