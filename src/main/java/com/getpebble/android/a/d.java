package com.getpebble.android.a;

import com.b.b.b.c.a.c;
import com.b.b.j;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.a.a.a;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.h.p;
import com.google.b.i;
import com.google.b.l;
import com.google.b.o;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class d extends f<a> {
    private int a = 0;

    public d() {
        super("AnalyticsUploader");
    }

    protected int a() {
        return a.a();
    }

    protected List<a> b() {
        return a.a(100, this.a);
    }

    protected boolean a(List<a> list) {
        if (!PebbleApplication.w().E()) {
            return false;
        }
        try {
            i a = a(b(list), list.size());
            if (a == null) {
                f.a("AnalyticsUploader", "Failed to get expected json array out of TD response, aborting ...");
                return false;
            }
            this.a += a((List) list, a);
            return true;
        } catch (Throwable e) {
            f.a("AnalyticsUploader", "Couldn't upload analytics events", e);
            return false;
        }
    }

    public void c() {
        this.a = 0;
        super.c();
    }

    o b(List<a> list) {
        return (o) ((c) ((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) j.a(com.getpebble.android.common.a.K()).d(e())).e("X_TD_WRITE_KEY", f())).e("X_TD_DATA_TYPE", "k")).e("Content-Type", "application/json")).b(c(list))).a().get();
    }

    static o c(List<a> list) {
        l iVar = new i();
        for (a a : list) {
            iVar.a(p.b(a(a)));
        }
        o oVar = new o();
        oVar.a(d(), iVar);
        return oVar;
    }

    static l a(a aVar) {
        Map hashMap = new HashMap();
        hashMap.put("data", aVar.c);
        Map map = aVar.g;
        if (map == null) {
            map = b.getGlobalEventProperties();
        }
        hashMap.putAll(map);
        map = a(hashMap);
        map.put("collection", aVar.a);
        map.put("event", aVar.b);
        map.put("time", Long.valueOf(aVar.f));
        return p.b(map);
    }

    static i a(o oVar, int i) {
        if (oVar == null || oVar.k()) {
            f.a("AnalyticsUploader", "Treasure data returned null result");
            return null;
        }
        l b = oVar.b(d());
        if (b == null || b.k() || !b.h()) {
            f.a("AnalyticsUploader", "Treasure data response contained unexpected data: " + oVar);
            return null;
        }
        i m = b.m();
        if (m.a() == i) {
            return m;
        }
        f.a("AnalyticsUploader", "Treasure data response array does not match records array");
        return null;
    }

    static int a(List<a> list, i iVar) {
        Set hashSet = new HashSet();
        Set hashSet2 = new HashSet();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            a aVar = (a) list.get(i3);
            if (a(iVar.a(i3), aVar)) {
                hashSet.add(aVar.e.toString());
                i2++;
            } else if (aVar.d <= 5) {
                hashSet2.add(aVar.e);
                i++;
            } else {
                f.a("AnalyticsUploader", "Reached max number of upload attempts for analyticsevent record: " + aVar + ".  Deleting record");
                hashSet.add(aVar.e.toString());
            }
        }
        a.b(hashSet);
        a.a(hashSet2);
        f.c("AnalyticsUploader", "Successfully uploaded " + i2 + " records out of " + list.size());
        return i;
    }

    static boolean a(l lVar, a aVar) {
        if (lVar == null || lVar.k() || !lVar.i()) {
            f.a("AnalyticsUploader", "Treasure data response contained unexpected record: " + lVar);
            return false;
        }
        Object b = lVar.l().b("success");
        if (b == null || b.k()) {
            f.a("AnalyticsUploader", "Treasure data response did not contain success field: " + lVar + " for record: " + a(aVar));
            return false;
        }
        try {
            if (b.c().equals("true")) {
                return true;
            }
            f.a("AnalyticsUploader", "Failed to upload event: " + a(aVar).toString());
            try {
                f.a("AnalyticsUploader", "Reason for failed upload: " + lVar.l().b("error").l().b("name").c());
                return false;
            } catch (ClassCastException e) {
                f.a("AnalyticsUploader", "Couldn't parse upload error reason for result: " + lVar);
                return false;
            } catch (NullPointerException e2) {
                f.a("AnalyticsUploader", "Couldn't parse upload error reason for result: " + lVar);
                return false;
            }
        } catch (ClassCastException e3) {
            f.a("AnalyticsUploader", "Treasure data response record did not contain String value for success field, got " + b + " for record: " + a(aVar));
            return false;
        }
    }

    static Map<String, Object> a(Map<String, Object> map) {
        Map<String, Object> hashMap = new HashMap();
        a(hashMap, map, null);
        return hashMap;
    }

    private static void a(Map<String, Object> map, Map<String, Object> map2, String str) {
        for (Entry entry : map2.entrySet()) {
            String str2;
            if (str == null) {
                str2 = (String) entry.getKey();
            } else {
                str2 = str + "_0_" + ((String) entry.getKey());
            }
            Object value = entry.getValue();
            if (value instanceof Map) {
                a(map, (Map) value, str2);
            } else {
                map.put(str2, entry.getValue());
            }
        }
    }

    static String d() {
        return "pebble." + e.a();
    }

    private static String e() {
        String D = com.getpebble.android.config.a.c().D();
        if (D == null) {
            D = "https://in.treasuredata.com";
        }
        return D + "/android/v3/event";
    }

    private static String f() {
        String F = com.getpebble.android.config.a.c().F();
        return F == null ? "4432/541b1bca7e5f67138908d4cb7a5634600709e405" : F;
    }
}
