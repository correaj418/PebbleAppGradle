package com.google.android.gms.b;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class az {
    private static final double a = (1000.0d / ((double) TimeUnit.SECONDS.toNanos(1)));
    private static final double b = (1000.0d / ((double) TimeUnit.SECONDS.toNanos(1)));
    private static final az e = new az();
    private final Map<String, Map<String, a>> c;
    private final Map<String, a> d;

    public static class a {
        private final double a;
        private final double b;

        private a(double d, double d2) {
            this.a = d;
            this.b = d2;
        }

        public boolean a(double d) {
            return d >= this.a && d <= this.b;
        }
    }

    private az() {
        Map hashMap = new HashMap();
        hashMap.put(av.j.b, new a(-90.0d, 90.0d));
        hashMap.put(av.k.b, new a(-180.0d, 180.0d));
        hashMap.put(av.l.b, new a(0.0d, 10000.0d));
        hashMap.put(av.i.b, new a(0.0d, 1000.0d));
        hashMap.put(av.m.b, new a(-100000.0d, 100000.0d));
        hashMap.put(av.t.b, new a(0.0d, 100.0d));
        hashMap.put(av.b.b, new a(0.0d, 100.0d));
        hashMap.put(av.e.b, new a(0.0d, 9.223372036854776E18d));
        hashMap.put(av.q.b, new a(0.0d, 10.0d));
        hashMap.put(av.r.b, new a(0.0d, 1000.0d));
        hashMap.put(av.u.b, new a(0.0d, 200000.0d));
        this.d = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.put("com.google.step_count.delta", a(av.d.b, new a(0.0d, a)));
        hashMap.put("com.google.calories.consumed", a(av.x.b, new a(0.0d, b)));
        hashMap.put("com.google.calories.expended", a(av.x.b, new a(0.0d, b)));
        this.c = Collections.unmodifiableMap(hashMap);
    }

    public static az a() {
        return e;
    }

    private static <K, V> Map<K, V> a(K k, V v) {
        Map<K, V> hashMap = new HashMap();
        hashMap.put(k, v);
        return hashMap;
    }

    public a a(String str) {
        return (a) this.d.get(str);
    }

    public a a(String str, String str2) {
        Map map = (Map) this.c.get(str);
        return map != null ? (a) map.get(str2) : null;
    }
}
