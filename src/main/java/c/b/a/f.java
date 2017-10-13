package c.b.a;

import c.b.a.e.b;
import c.b.a.e.c;
import c.b.a.e.i;
import c.b.a.f.d;
import c.b.a.f.e;
import c.b.a.f.g;
import c.b.a.f.h;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherChannelDataModels;
import java.io.File;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.convert.FromString;
import org.joda.convert.ToString;

public abstract class f implements Serializable {
    public static final f a = w.b;
    private static final AtomicReference<c.b.a.f.f> b = new AtomicReference();
    private static final AtomicReference<e> c = new AtomicReference();
    private static final AtomicReference<f> d = new AtomicReference();
    private final String e;

    static final class a {
        static final Map<String, String> a = b();
        static final b b = a();

        private static b a() {
            return new c().a(null, true, 2, 4).a().a(new c.b.a.b.b() {
                public f a() {
                    return null;
                }

                public a b() {
                    return this;
                }

                public a a(f fVar) {
                    return this;
                }

                public String toString() {
                    return getClass().getName();
                }
            });
        }

        private static Map<String, String> b() {
            Map hashMap = new HashMap();
            hashMap.put("GMT", "UTC");
            hashMap.put("WET", "WET");
            hashMap.put("CET", "CET");
            hashMap.put("MET", "CET");
            hashMap.put("ECT", "CET");
            hashMap.put("EET", "EET");
            hashMap.put("MIT", "Pacific/Apia");
            hashMap.put("HST", "Pacific/Honolulu");
            hashMap.put("AST", "America/Anchorage");
            hashMap.put("PST", "America/Los_Angeles");
            hashMap.put("MST", "America/Denver");
            hashMap.put("PNT", "America/Phoenix");
            hashMap.put("CST", "America/Chicago");
            hashMap.put("EST", "America/New_York");
            hashMap.put("IET", "America/Indiana/Indianapolis");
            hashMap.put("PRT", "America/Puerto_Rico");
            hashMap.put("CNT", "America/St_Johns");
            hashMap.put("AGT", "America/Argentina/Buenos_Aires");
            hashMap.put("BET", "America/Sao_Paulo");
            hashMap.put("ART", "Africa/Cairo");
            hashMap.put("CAT", "Africa/Harare");
            hashMap.put("EAT", "Africa/Addis_Ababa");
            hashMap.put("NET", "Asia/Yerevan");
            hashMap.put("PLT", "Asia/Karachi");
            hashMap.put("IST", "Asia/Kolkata");
            hashMap.put("BST", "Asia/Dhaka");
            hashMap.put("VST", "Asia/Ho_Chi_Minh");
            hashMap.put("CTT", "Asia/Shanghai");
            hashMap.put("JST", "Asia/Tokyo");
            hashMap.put("ACT", "Australia/Darwin");
            hashMap.put("AET", "Australia/Sydney");
            hashMap.put("SST", "Pacific/Guadalcanal");
            hashMap.put("NST", "Pacific/Auckland");
            return Collections.unmodifiableMap(hashMap);
        }
    }

    public abstract String a(long j);

    public abstract int b(long j);

    public abstract int c(long j);

    public abstract boolean equals(Object obj);

    public abstract boolean f();

    public abstract long g(long j);

    public abstract long h(long j);

    public static f a() {
        f fVar = (f) d.get();
        if (fVar != null) {
            return fVar;
        }
        try {
            String property = System.getProperty("user.timezone");
            if (property != null) {
                fVar = a(property);
            }
        } catch (RuntimeException e) {
        }
        if (fVar == null) {
            try {
                fVar = a(TimeZone.getDefault());
            } catch (IllegalArgumentException e2) {
            }
        }
        if (fVar == null) {
            fVar = a;
        }
        if (d.compareAndSet(null, fVar)) {
            return fVar;
        }
        return (f) d.get();
    }

    public static void a(f fVar) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new l("DateTimeZone.setDefault"));
        }
        if (fVar == null) {
            throw new IllegalArgumentException("The datetime zone must not be null");
        }
        d.set(fVar);
    }

    @FromString
    public static f a(String str) {
        if (str == null) {
            return a();
        }
        if (str.equals("UTC")) {
            return a;
        }
        f a = c().a(str);
        if (a != null) {
            return a;
        }
        if (str.startsWith("+") || str.startsWith("-")) {
            int c = c(str);
            if (((long) c) == 0) {
                return a;
            }
            return a(b(c), c);
        }
        throw new IllegalArgumentException("The datetime zone id '" + str + "' is not recognised");
    }

    public static f a(int i) {
        if (i >= -86399999 && i <= 86399999) {
            return a(b(i), i);
        }
        throw new IllegalArgumentException("Millis out of range: " + i);
    }

    public static f a(TimeZone timeZone) {
        if (timeZone == null) {
            return a();
        }
        String id = timeZone.getID();
        if (id == null) {
            throw new IllegalArgumentException("The TimeZone id must not be null");
        } else if (id.equals("UTC")) {
            return a;
        } else {
            f fVar = null;
            String b = b(id);
            c.b.a.f.f c = c();
            if (b != null) {
                fVar = c.a(b);
            }
            if (fVar == null) {
                fVar = c.a(id);
            }
            if (fVar != null) {
                return fVar;
            }
            if (b == null && (id.startsWith("GMT+") || id.startsWith("GMT-"))) {
                int c2 = c(id.substring(3));
                if (((long) c2) == 0) {
                    return a;
                }
                return a(b(c2), c2);
            }
            throw new IllegalArgumentException("The datetime zone id '" + id + "' is not recognised");
        }
    }

    private static f a(String str, int i) {
        if (i == 0) {
            return a;
        }
        return new d(str, null, i, i);
    }

    public static Set<String> b() {
        return c().a();
    }

    public static c.b.a.f.f c() {
        c.b.a.f.f fVar = (c.b.a.f.f) b.get();
        if (fVar != null) {
            return fVar;
        }
        fVar = h();
        if (b.compareAndSet(null, fVar)) {
            return fVar;
        }
        return (c.b.a.f.f) b.get();
    }

    public static void a(c.b.a.f.f fVar) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new l("DateTimeZone.setProvider"));
        }
        if (fVar == null) {
            fVar = h();
        } else {
            b(fVar);
        }
        b.set(fVar);
    }

    private static c.b.a.f.f b(c.b.a.f.f fVar) {
        Set a = fVar.a();
        if (a == null || a.size() == 0) {
            throw new IllegalArgumentException("The provider doesn't have any available ids");
        } else if (!a.contains("UTC")) {
            throw new IllegalArgumentException("The provider doesn't support UTC");
        } else if (a.equals(fVar.a("UTC"))) {
            return fVar;
        } else {
            throw new IllegalArgumentException("Invalid UTC zone provided");
        }
    }

    private static c.b.a.f.f h() {
        String property;
        try {
            property = System.getProperty("org.joda.time.DateTimeZone.Provider");
            if (property != null) {
                return b((c.b.a.f.f) Class.forName(property).newInstance());
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (SecurityException e2) {
        }
        try {
            property = System.getProperty("org.joda.time.DateTimeZone.Folder");
            if (property != null) {
                return b(new h(new File(property)));
            }
        } catch (Throwable e3) {
            throw new RuntimeException(e3);
        } catch (SecurityException e4) {
        }
        try {
            return b(new h("org/joda/time/tz/data"));
        } catch (Exception e5) {
            e5.printStackTrace();
            return new g();
        }
    }

    public static e d() {
        e eVar = (e) c.get();
        if (eVar != null) {
            return eVar;
        }
        eVar = i();
        if (c.compareAndSet(null, eVar)) {
            return eVar;
        }
        return (e) c.get();
    }

    private static e i() {
        e eVar;
        try {
            String property = System.getProperty("org.joda.time.DateTimeZone.NameProvider");
            eVar = property != null ? (e) Class.forName(property).newInstance() : null;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (SecurityException e2) {
            eVar = null;
        }
        if (eVar == null) {
            return new c.b.a.f.c();
        }
        return eVar;
    }

    private static String b(String str) {
        return (String) a.a.get(str);
    }

    private static int c(String str) {
        return -((int) a.b.a(str));
    }

    private static String b(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i >= 0) {
            stringBuffer.append('+');
        } else {
            stringBuffer.append('-');
            i = -i;
        }
        int i2 = i / 3600000;
        i.a(stringBuffer, i2, 2);
        i2 = i - (i2 * 3600000);
        int i3 = i2 / WeatherChannelDataModels.MS_TO_MIN_DIVISOR;
        stringBuffer.append(':');
        i.a(stringBuffer, i3, 2);
        i2 -= i3 * WeatherChannelDataModels.MS_TO_MIN_DIVISOR;
        if (i2 == 0) {
            return stringBuffer.toString();
        }
        i3 = i2 / 1000;
        stringBuffer.append(':');
        i.a(stringBuffer, i3, 2);
        i2 -= i3 * 1000;
        if (i2 == 0) {
            return stringBuffer.toString();
        }
        stringBuffer.append('.');
        i.a(stringBuffer, i2, 3);
        return stringBuffer.toString();
    }

    protected f(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Id must not be null");
        }
        this.e = str;
    }

    @ToString
    public final String e() {
        return this.e;
    }

    public String a(long j, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String a = a(j);
        if (a == null) {
            return this.e;
        }
        String a2;
        e d = d();
        if (d instanceof c.b.a.f.c) {
            a2 = ((c.b.a.f.c) d).a(locale, this.e, a, d(j));
        } else {
            a2 = d.a(locale, this.e, a);
        }
        if (a2 == null) {
            return b(b(j));
        }
        return a2;
    }

    public String b(long j, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String a = a(j);
        if (a == null) {
            return this.e;
        }
        String b;
        e d = d();
        if (d instanceof c.b.a.f.c) {
            b = ((c.b.a.f.c) d).b(locale, this.e, a, d(j));
        } else {
            b = d.b(locale, this.e, a);
        }
        if (b == null) {
            return b(b(j));
        }
        return b;
    }

    public final int a(s sVar) {
        if (sVar == null) {
            return b(e.a());
        }
        return b(sVar.c());
    }

    public boolean d(long j) {
        return b(j) == c(j);
    }

    public int e(long j) {
        long j2 = Long.MAX_VALUE;
        int b = b(j);
        long j3 = j - ((long) b);
        int b2 = b(j3);
        if (b != b2) {
            if (b - b2 < 0) {
                long g = g(j3);
                if (g == j - ((long) b)) {
                    g = Long.MAX_VALUE;
                }
                j3 = g(j - ((long) b2));
                if (j3 != j - ((long) b2)) {
                    j2 = j3;
                }
                if (g != j2) {
                    return b;
                }
            }
        } else if (b >= 0) {
            j2 = h(j3);
            if (j2 < j3) {
                int b3 = b(j2);
                if (j3 - j2 <= ((long) (b3 - b))) {
                    return b3;
                }
            }
        }
        return b2;
    }

    public long f(long j) {
        int b = b(j);
        long j2 = ((long) b) + j;
        if ((j ^ j2) >= 0 || (((long) b) ^ j) < 0) {
            return j2;
        }
        throw new ArithmeticException("Adding time zone offset caused overflow");
    }

    public long a(long j, boolean z, long j2) {
        int b = b(j2);
        long j3 = j - ((long) b);
        return b(j3) == b ? j3 : a(j, z);
    }

    public long a(long j, boolean z) {
        int i;
        long j2 = Long.MAX_VALUE;
        int b = b(j);
        int b2 = b(j - ((long) b));
        if (b != b2 && (z || b < 0)) {
            long g = g(j - ((long) b));
            if (g == j - ((long) b)) {
                g = Long.MAX_VALUE;
            }
            long g2 = g(j - ((long) b2));
            if (g2 != j - ((long) b2)) {
                j2 = g2;
            }
            if (g != j2) {
                if (z) {
                    throw new j(j, e());
                }
                i = b;
                j2 = j - ((long) i);
                if ((j ^ j2) < 0 || (((long) i) ^ j) >= 0) {
                    return j2;
                }
                throw new ArithmeticException("Subtracting time zone offset caused overflow");
            }
        }
        i = b2;
        j2 = j - ((long) i);
        if ((j ^ j2) < 0) {
        }
        return j2;
    }

    public long a(f fVar, long j) {
        f a;
        if (fVar == null) {
            a = a();
        } else {
            a = fVar;
        }
        return a == this ? j : a.a(f(j), false, j);
    }

    public TimeZone g() {
        return TimeZone.getTimeZone(this.e);
    }

    public int hashCode() {
        return e().hashCode() + 57;
    }

    public String toString() {
        return e();
    }
}
