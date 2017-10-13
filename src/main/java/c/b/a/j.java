package c.b.a;

import c.b.a.e.a;

public class j extends IllegalArgumentException {
    public j(String str) {
        super(str);
    }

    public j(long j, String str) {
        super(a(j, str));
    }

    private static String a(long j, String str) {
        return "Illegal instant due to time zone offset transition (daylight savings time 'gap'): " + a.a("yyyy-MM-dd'T'HH:mm:ss.SSS").a(new k(j)) + (str != null ? " (" + str + ")" : "");
    }
}
