package com.b.a.c.b;

import android.net.Uri;
import com.b.a.c.b.a.a;
import com.b.a.c.o;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

final class f {
    private final Uri a;
    private final c b;
    private Date c;
    private Date d;
    private Date e;
    private long f;
    private long g;
    private boolean h;
    private boolean i;
    private int j = -1;
    private int k = -1;
    private boolean l;
    private boolean m;
    private String n;
    private int o = -1;
    private Set<String> p = Collections.emptySet();
    private String q;
    private String r;
    private long s = -1;
    private String t;
    private String u;
    private String v;

    public f(Uri uri, c cVar) {
        this.a = uri;
        this.b = cVar;
        a anonymousClass1 = new a(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public void a(String str, String str2) {
                if (str.equalsIgnoreCase("no-cache")) {
                    this.a.h = true;
                } else if (str.equalsIgnoreCase("no-store")) {
                    this.a.i = true;
                } else if (str.equalsIgnoreCase("max-age")) {
                    this.a.j = a.a(str2);
                } else if (str.equalsIgnoreCase("s-maxage")) {
                    this.a.k = a.a(str2);
                } else if (str.equalsIgnoreCase("public")) {
                    this.a.l = true;
                } else if (str.equalsIgnoreCase("must-revalidate")) {
                    this.a.m = true;
                }
            }
        };
        for (int i = 0; i < cVar.d(); i++) {
            String a = cVar.a(i);
            String b = cVar.b(i);
            if ("Cache-Control".equalsIgnoreCase(a)) {
                a.a(b, anonymousClass1);
            } else if ("Date".equalsIgnoreCase(a)) {
                this.c = o.a(b);
            } else if ("Expires".equalsIgnoreCase(a)) {
                this.e = o.a(b);
            } else if ("Last-Modified".equalsIgnoreCase(a)) {
                this.d = o.a(b);
            } else if ("ETag".equalsIgnoreCase(a)) {
                this.n = b;
            } else if ("Pragma".equalsIgnoreCase(a)) {
                if (b.equalsIgnoreCase("no-cache")) {
                    this.h = true;
                }
            } else if ("Age".equalsIgnoreCase(a)) {
                this.o = a.a(b);
            } else if ("Vary".equalsIgnoreCase(a)) {
                if (this.p.isEmpty()) {
                    this.p = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : b.split(",")) {
                    this.p.add(trim.trim().toLowerCase(Locale.US));
                }
            } else if ("Content-Encoding".equalsIgnoreCase(a)) {
                this.q = b;
            } else if ("Transfer-Encoding".equalsIgnoreCase(a)) {
                this.r = b;
            } else if ("Content-Length".equalsIgnoreCase(a)) {
                try {
                    this.s = Long.parseLong(b);
                } catch (NumberFormatException e) {
                }
            } else if ("Connection".equalsIgnoreCase(a)) {
                this.t = b;
            } else if ("Proxy-Authenticate".equalsIgnoreCase(a)) {
                this.u = b;
            } else if ("WWW-Authenticate".equalsIgnoreCase(a)) {
                this.v = b;
            } else if ("X-Android-Sent-Millis".equalsIgnoreCase(a)) {
                this.f = Long.parseLong(b);
            } else if ("X-Android-Received-Millis".equalsIgnoreCase(a)) {
                this.g = Long.parseLong(b);
            }
        }
    }

    public c a() {
        return this.b;
    }

    public Set<String> b() {
        return this.p;
    }

    public void a(long j, long j2) {
        this.f = j;
        this.b.a("X-Android-Sent-Millis", Long.toString(j));
        this.g = j2;
        this.b.a("X-Android-Received-Millis", Long.toString(j2));
    }

    private long a(long j) {
        long j2 = 0;
        if (this.c != null) {
            j2 = Math.max(0, this.g - this.c.getTime());
        }
        if (this.o != -1) {
            j2 = Math.max(j2, TimeUnit.SECONDS.toMillis((long) this.o));
        }
        return (j2 + (this.g - this.f)) + (j - this.g);
    }

    private long c() {
        if (this.j != -1) {
            return TimeUnit.SECONDS.toMillis((long) this.j);
        }
        long time;
        if (this.e != null) {
            time = this.e.getTime() - (this.c != null ? this.c.getTime() : this.g);
            if (time <= 0) {
                time = 0;
            }
            return time;
        } else if (this.d == null || this.a.getEncodedQuery() != null) {
            return 0;
        } else {
            time = (this.c != null ? this.c.getTime() : this.f) - this.d.getTime();
            if (time > 0) {
                return time / 10;
            }
            return 0;
        }
    }

    private boolean d() {
        return this.j == -1 && this.e == null;
    }

    public boolean a(d dVar) {
        int b = this.b.b();
        if (b != 200 && b != 203 && b != 300 && b != 301 && b != 410) {
            return false;
        }
        if ((!dVar.f() || this.l || this.m || this.k != -1) && !this.i) {
            return true;
        }
        return false;
    }

    public boolean a(Map<String, List<String>> map, Map<String, List<String>> map2) {
        for (String str : this.p) {
            if (!b.a(map.get(str), map2.get(str))) {
                return false;
            }
        }
        return true;
    }

    public g a(long j, d dVar) {
        long j2 = 0;
        if (!a(dVar)) {
            return g.NETWORK;
        }
        if (dVar.b() || dVar.g()) {
            return g.NETWORK;
        }
        long toMillis;
        long a = a(j);
        long c = c();
        if (dVar.c() != -1) {
            c = Math.min(c, TimeUnit.SECONDS.toMillis((long) dVar.c()));
        }
        if (dVar.e() != -1) {
            toMillis = TimeUnit.SECONDS.toMillis((long) dVar.e());
        } else {
            toMillis = 0;
        }
        if (!(this.m || dVar.d() == -1)) {
            j2 = TimeUnit.SECONDS.toMillis((long) dVar.d());
        }
        if (this.h || a + toMillis >= r4 + c) {
            if (this.n != null) {
                dVar.a(this.n);
            } else if (this.d != null) {
                dVar.a(this.d);
            } else if (this.c != null) {
                dVar.a(this.c);
            }
            if (dVar.g()) {
                return g.CONDITIONAL_CACHE;
            }
            return g.NETWORK;
        }
        if (toMillis + a >= c) {
            this.b.a("Warning", "110 HttpURLConnection \"Response is stale\"");
        }
        if (a > 86400000 && d()) {
            this.b.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
        }
        return g.CACHE;
    }

    public boolean a(f fVar) {
        if (fVar.b.b() == 304) {
            return true;
        }
        if (this.d == null || fVar.d == null || fVar.d.getTime() >= this.d.getTime()) {
            return false;
        }
        return true;
    }

    public f b(f fVar) {
        int i = 0;
        c cVar = new c();
        for (int i2 = 0; i2 < this.b.d(); i2++) {
            String a = this.b.a(i2);
            String b = this.b.b(i2);
            if (!(a.equals("Warning") && b.startsWith("1")) && (!a(a) || fVar.b.d(a) == null)) {
                cVar.a(a, b);
            }
        }
        while (i < fVar.b.d()) {
            String a2 = fVar.b.a(i);
            if (a(a2)) {
                cVar.a(a2, fVar.b.b(i));
            }
            i++;
        }
        return new f(this.a, cVar);
    }

    private static boolean a(String str) {
        if (str.equalsIgnoreCase("Connection") || str.equalsIgnoreCase("Keep-Alive") || str.equalsIgnoreCase("Proxy-Authenticate") || str.equalsIgnoreCase("Proxy-Authorization") || str.equalsIgnoreCase("TE") || str.equalsIgnoreCase("Trailers") || str.equalsIgnoreCase("Transfer-Encoding") || str.equalsIgnoreCase("Upgrade")) {
            return false;
        }
        return true;
    }
}
