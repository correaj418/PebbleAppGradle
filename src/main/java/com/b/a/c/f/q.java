package com.b.a.c.f;

import com.b.a.c.u;
import java.util.List;
import java.util.Locale;

final class q {
    private static final List<String> a = r.a("connection", "host", "keep-alive", "proxy-connection", "transfer-encoding");
    private static final List<String> b = r.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    static boolean a(u uVar, String str) {
        if (uVar == u.SPDY_3) {
            return a.contains(str.toLowerCase(Locale.US));
        }
        if (uVar == u.HTTP_2) {
            return b.contains(str.toLowerCase(Locale.US));
        }
        throw new AssertionError(uVar);
    }
}
