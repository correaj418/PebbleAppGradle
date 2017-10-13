package com.b.a.c;

import android.net.Uri;
import android.util.Log;
import com.b.a.c;
import com.b.a.c.a.a;
import java.util.Locale;

public class d {
    static final /* synthetic */ boolean h = (!d.class.desiredAssertionStatus());
    Uri a;
    int b;
    String c;
    int d;
    String e;
    int f;
    long g;
    private String i;
    private n j;
    private boolean k;
    private a l;

    public w a() {
        return new w(this) {
            final /* synthetic */ d a;

            {
                this.a = r1;
            }

            public String toString() {
                if (this.a.c != null) {
                    return String.format(Locale.ENGLISH, "%s %s HTTP/1.1", new Object[]{this.a.i, this.a.d()});
                }
                String encodedPath = this.a.d().getEncodedPath();
                if (encodedPath == null || encodedPath.length() == 0) {
                    encodedPath = "/";
                }
                String encodedQuery = this.a.d().getEncodedQuery();
                if (!(encodedQuery == null || encodedQuery.length() == 0)) {
                    encodedPath = encodedPath + "?" + encodedQuery;
                }
                return String.format(Locale.ENGLISH, "%s %s HTTP/1.1", new Object[]{this.a.i, encodedPath});
            }
        };
    }

    protected static String b() {
        String property = System.getProperty("http.agent");
        return property != null ? property : "Java" + System.getProperty("java.version");
    }

    public String c() {
        return this.i;
    }

    public d(Uri uri, String str) {
        this(uri, str, null);
    }

    public static void a(n nVar, Uri uri) {
        if (uri != null) {
            String host = uri.getHost();
            if (uri.getPort() != -1) {
                host = host + ":" + uri.getPort();
            }
            if (host != null) {
                nVar.a("Host", host);
            }
        }
        nVar.a("User-Agent", b());
        nVar.a("Accept-Encoding", "gzip, deflate");
        nVar.a("Connection", "keep-alive");
        nVar.a("Accept", "*/*");
    }

    public d(Uri uri, String str, n nVar) {
        this.j = new n();
        this.k = true;
        this.b = 30000;
        this.d = -1;
        if (h || uri != null) {
            this.i = str;
            this.a = uri;
            if (nVar == null) {
                this.j = new n();
            } else {
                this.j = nVar;
            }
            if (nVar == null) {
                a(this.j, uri);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    public Uri d() {
        return this.a;
    }

    public n e() {
        return this.j;
    }

    public boolean f() {
        return this.k;
    }

    public d a(boolean z) {
        this.k = z;
        return this;
    }

    public void a(a aVar) {
        this.l = aVar;
    }

    public a g() {
        return this.l;
    }

    public void a(c cVar) {
    }

    public int h() {
        return this.b;
    }

    public d a(int i) {
        this.b = i;
        return this;
    }

    public void a(String str, int i) {
        this.c = str;
        this.d = i;
    }

    public String i() {
        return this.c;
    }

    public int j() {
        return this.d;
    }

    public String toString() {
        if (this.j == null) {
            return super.toString();
        }
        return this.j.e(this.a.toString());
    }

    public void b(String str, int i) {
        this.e = str;
        this.f = i;
    }

    private String d(String str) {
        long j = 0;
        if (this.g != 0) {
            j = System.currentTimeMillis() - this.g;
        }
        return String.format(Locale.ENGLISH, "(%d ms) %s: %s", new Object[]{Long.valueOf(j), d(), str});
    }

    public void a(String str) {
        if (this.e != null && this.f <= 4) {
            Log.i(this.e, d(str));
        }
    }

    public void b(String str) {
        if (this.e != null && this.f <= 2) {
            Log.v(this.e, d(str));
        }
    }

    public void c(String str) {
        if (this.e != null && this.f <= 3) {
            Log.d(this.e, d(str));
        }
    }

    public void a(String str, Exception exception) {
        if (this.e != null && this.f <= 6) {
            Log.e(this.e, d(str));
            Log.e(this.e, exception.getMessage(), exception);
        }
    }
}
