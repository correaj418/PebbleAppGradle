package com.b.a.f;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class e<T> {
    Hashtable<String, h<T>> a = new Hashtable();

    public Set<String> a() {
        return this.a.keySet();
    }

    public synchronized <V> V a(String str) {
        V v;
        h hVar = (h) this.a.get(str);
        if (hVar == null) {
            v = null;
        } else {
            v = hVar.a();
        }
        return v;
    }

    public synchronized <V> void a(String str, V v) {
        h hVar = (h) this.a.get(str);
        if (hVar == null) {
            hVar = new h();
            this.a.put(str, hVar);
        }
        hVar.a(v);
    }

    public synchronized ArrayList<T> b(String str) {
        return (ArrayList) this.a.remove(str);
    }

    public synchronized ArrayList<T> c(String str) {
        return (ArrayList) this.a.get(str);
    }

    public synchronized void b(String str, T t) {
        ArrayList c = c(str);
        if (c == null) {
            c = new h();
            this.a.put(str, c);
        }
        c.add(t);
    }

    public synchronized boolean c(String str, T t) {
        boolean z = false;
        synchronized (this) {
            h hVar = (h) this.a.get(str);
            if (hVar != null) {
                hVar.remove(t);
                z = hVar.size() == 0;
            }
        }
        return z;
    }
}
