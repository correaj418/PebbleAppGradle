package com.a.a.a;

import java.net.URLEncoder;
import org.json.JSONObject;

abstract class d {
    private a a;
    private String b;
    private String c;
    private final long d = 10000;

    protected d(a aVar, String str) {
        try {
            this.a = aVar;
            this.b = URLEncoder.encode(str, "UTF-8");
            this.c = str;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    protected JSONObject a(h hVar) {
        String a = hVar.a();
        if (a.length() > 0) {
            return this.a.a("/1/indexes/" + this.b + "?" + a, true);
        }
        return this.a.a("/1/indexes/" + this.b, true);
    }
}
