package com.getpebble.android.framework.jskit;

public class e {
    private static e a;
    private b b;

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (a == null) {
                a = new e();
            }
            eVar = a;
        }
        return eVar;
    }

    public void a(b bVar) {
        this.b = bVar;
    }

    public void a(String str) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(str);
        }
    }
}
