package com.b.a.c;

import com.b.a.c.a.c;
import com.b.a.c.a.d;
import com.b.a.c.a.h;
import com.b.a.c.d.b;
import com.b.a.c.d.f;
import com.b.a.g;
import com.b.a.m;
import com.b.a.t;

public class q {

    static class a extends t {
        private a() {
        }

        public static a a(g gVar, final Exception exception) {
            final a aVar = new a();
            gVar.a(new Runnable() {
                public void run() {
                    aVar.b(exception);
                }
            });
            return aVar;
        }
    }

    public static com.b.a.c.a.a a(m mVar, com.b.a.a.a aVar, n nVar) {
        int i = 0;
        String a = nVar.a("Content-Type");
        if (a != null) {
            int i2;
            String[] split = a.split(";");
            for (i2 = 0; i2 < split.length; i2++) {
                split[i2] = split[i2].trim();
            }
            i2 = split.length;
            while (i < i2) {
                Object obj = split[i];
                if ("application/x-www-form-urlencoded".equals(obj)) {
                    return new h();
                }
                if ("application/json".equals(obj)) {
                    return new c();
                }
                if ("text/plain".equals(obj)) {
                    return new com.b.a.c.a.g();
                }
                if ("multipart/form-data".equals(obj)) {
                    return new d(split);
                }
                i++;
            }
        }
        return null;
    }

    public static m a(m mVar, u uVar, n nVar, boolean z) {
        long parseLong;
        try {
            parseLong = Long.parseLong(nVar.a("Content-Length"));
        } catch (Exception e) {
            parseLong = -1;
        }
        a a;
        if (-1 != parseLong) {
            if (parseLong < 0) {
                a = a.a(mVar.m(), new k("not using chunked encoding, and no content-length found."));
                a.a(mVar);
                return a;
            } else if (parseLong == 0) {
                a = a.a(mVar.m(), null);
                a.a(mVar);
                return a;
            } else {
                com.b.a.c.d.d dVar = new com.b.a.c.d.d(parseLong);
                dVar.a(mVar);
                mVar = dVar;
            }
        } else if ("chunked".equalsIgnoreCase(nVar.a("Transfer-Encoding"))) {
            b bVar = new b();
            bVar.a(mVar);
            Object obj = bVar;
        } else if ((z || uVar == u.HTTP_1_1) && !"close".equalsIgnoreCase(nVar.a("Connection"))) {
            a = a.a(mVar.m(), null);
            a.a(mVar);
            return a;
        }
        if ("gzip".equals(nVar.a("Content-Encoding"))) {
            f fVar = new f();
            fVar.a(mVar);
            return fVar;
        } else if (!"deflate".equals(nVar.a("Content-Encoding"))) {
            return mVar;
        } else {
            com.b.a.c.d.g gVar = new com.b.a.c.d.g();
            gVar.a(mVar);
            return gVar;
        }
    }

    public static boolean a(u uVar, n nVar) {
        String a = nVar.a("Connection");
        if (a == null) {
            return uVar == u.HTTP_1_1;
        } else {
            return "keep-alive".equalsIgnoreCase(a);
        }
    }

    public static boolean a(String str, n nVar) {
        String a = nVar.a("Connection");
        if (a == null) {
            return u.get(str) == u.HTTP_1_1;
        } else {
            return "keep-alive".equalsIgnoreCase(a);
        }
    }

    public static int a(n nVar) {
        int i = -1;
        String a = nVar.a("Content-Length");
        if (a != null) {
            try {
                i = Integer.parseInt(a);
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }
}
