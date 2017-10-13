package c.b.a;

import c.b.a.b.u;
import java.text.DateFormatSymbols;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class e {
    public static final a a = new b();
    private static volatile a b = a;
    private static final AtomicReference<Map<String, f>> c = new AtomicReference();

    public interface a {
        long a();
    }

    static class b implements a {
        b() {
        }

        public long a() {
            return System.currentTimeMillis();
        }
    }

    public static final long a() {
        return b.a();
    }

    public static final long a(s sVar) {
        if (sVar == null) {
            return a();
        }
        return sVar.c();
    }

    public static final a b(s sVar) {
        if (sVar == null) {
            return u.O();
        }
        a d = sVar.d();
        if (d == null) {
            return u.O();
        }
        return d;
    }

    public static final a a(a aVar) {
        if (aVar == null) {
            return u.O();
        }
        return aVar;
    }

    public static final f a(f fVar) {
        if (fVar == null) {
            return f.a();
        }
        return fVar;
    }

    public static final DateFormatSymbols a(Locale locale) {
        try {
            return (DateFormatSymbols) DateFormatSymbols.class.getMethod("getInstance", new Class[]{Locale.class}).invoke(null, new Object[]{locale});
        } catch (Exception e) {
            return new DateFormatSymbols(locale);
        }
    }

    public static final Map<String, f> b() {
        Map<String, f> map = (Map) c.get();
        if (map != null) {
            return map;
        }
        map = c();
        if (c.compareAndSet(null, map)) {
            return map;
        }
        return (Map) c.get();
    }

    private static Map<String, f> c() {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("UT", f.a);
        linkedHashMap.put("UTC", f.a);
        linkedHashMap.put("GMT", f.a);
        a(linkedHashMap, "EST", "America/New_York");
        a(linkedHashMap, "EDT", "America/New_York");
        a(linkedHashMap, "CST", "America/Chicago");
        a(linkedHashMap, "CDT", "America/Chicago");
        a(linkedHashMap, "MST", "America/Denver");
        a(linkedHashMap, "MDT", "America/Denver");
        a(linkedHashMap, "PST", "America/Los_Angeles");
        a(linkedHashMap, "PDT", "America/Los_Angeles");
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static void a(Map<String, f> map, String str, String str2) {
        try {
            map.put(str, f.a(str2));
        } catch (RuntimeException e) {
        }
    }
}
