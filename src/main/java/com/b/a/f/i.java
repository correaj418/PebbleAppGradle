package com.b.a.f;

import java.util.Hashtable;

public class i {
    private Hashtable<String, Object> a = new Hashtable();

    public void a(String str, Object obj) {
        this.a.put(str, obj);
    }

    public void a(String str) {
        this.a.remove(str);
    }

    public <T> T b(String str) {
        return this.a.get(str);
    }
}
