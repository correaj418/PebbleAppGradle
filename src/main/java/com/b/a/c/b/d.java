package com.b.a.c.b;

import android.net.Uri;
import com.b.a.c.b.a.a;
import com.b.a.c.o;
import java.util.Date;

final class d {
    private final Uri a;
    private final c b;
    private boolean c;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private boolean g;
    private boolean h;
    private int i = -1;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;

    public d(Uri uri, c cVar) {
        this.a = uri;
        this.b = cVar;
        a anonymousClass1 = new a(this) {
            final /* synthetic */ d a;

            {
                this.a = r1;
            }

            public void a(String str, String str2) {
                if (str.equalsIgnoreCase("no-cache")) {
                    this.a.c = true;
                } else if (str.equalsIgnoreCase("max-age")) {
                    this.a.d = a.a(str2);
                } else if (str.equalsIgnoreCase("max-stale")) {
                    this.a.e = a.a(str2);
                } else if (str.equalsIgnoreCase("min-fresh")) {
                    this.a.f = a.a(str2);
                } else if (str.equalsIgnoreCase("only-if-cached")) {
                    this.a.g = true;
                }
            }
        };
        for (int i = 0; i < cVar.d(); i++) {
            String a = cVar.a(i);
            String b = cVar.b(i);
            if ("Cache-Control".equalsIgnoreCase(a)) {
                a.a(b, anonymousClass1);
            } else if ("Pragma".equalsIgnoreCase(a)) {
                if (b.equalsIgnoreCase("no-cache")) {
                    this.c = true;
                }
            } else if ("If-None-Match".equalsIgnoreCase(a)) {
                this.q = b;
            } else if ("If-Modified-Since".equalsIgnoreCase(a)) {
                this.p = b;
            } else if ("Authorization".equalsIgnoreCase(a)) {
                this.h = true;
            } else if ("Content-Length".equalsIgnoreCase(a)) {
                try {
                    this.i = Integer.parseInt(b);
                } catch (NumberFormatException e) {
                }
            } else if ("Transfer-Encoding".equalsIgnoreCase(a)) {
                this.j = b;
            } else if ("User-Agent".equalsIgnoreCase(a)) {
                this.k = b;
            } else if ("Host".equalsIgnoreCase(a)) {
                this.l = b;
            } else if ("Connection".equalsIgnoreCase(a)) {
                this.m = b;
            } else if ("Accept-Encoding".equalsIgnoreCase(a)) {
                this.n = b;
            } else if ("Content-Type".equalsIgnoreCase(a)) {
                this.o = b;
            } else if ("Proxy-Authorization".equalsIgnoreCase(a)) {
                this.r = b;
            }
        }
    }

    public c a() {
        return this.b;
    }

    public boolean b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public int e() {
        return this.f;
    }

    public boolean f() {
        return this.h;
    }

    public void a(Date date) {
        if (this.p != null) {
            this.b.c("If-Modified-Since");
        }
        String a = o.a(date);
        this.b.a("If-Modified-Since", a);
        this.p = a;
    }

    public void a(String str) {
        if (this.q != null) {
            this.b.c("If-None-Match");
        }
        this.b.a("If-None-Match", str);
        this.q = str;
    }

    public boolean g() {
        return (this.p == null && this.q == null) ? false : true;
    }
}
