package com.getpebble.android.notifications.a.a;

public class b {
    public static a a(com.getpebble.android.notifications.a.b bVar) {
        String g = bVar.g();
        if (b(bVar)) {
            return new g();
        }
        if (d.a.contains(g)) {
            return new d();
        }
        if (g.equals("com.whatsapp")) {
            return new j();
        }
        if (g.equals("com.google.android.keep")) {
            return new c();
        }
        return new g();
    }

    private static boolean b(com.getpebble.android.notifications.a.b bVar) {
        return (bVar.r() || bVar.q() == null) ? false : true;
    }
}
