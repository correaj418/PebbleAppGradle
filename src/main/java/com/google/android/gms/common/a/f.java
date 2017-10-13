package com.google.android.gms.common.a;

public final class f implements d {
    private static f a;

    public static synchronized d b() {
        d dVar;
        synchronized (f.class) {
            if (a == null) {
                a = new f();
            }
            dVar = a;
        }
        return dVar;
    }

    public long a() {
        return System.currentTimeMillis();
    }
}
