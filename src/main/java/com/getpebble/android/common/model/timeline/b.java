package com.getpebble.android.common.model.timeline;

import android.content.Context;
import android.text.TextUtils;
import com.getpebble.android.framework.jskit.g;
import com.getpebble.android.framework.timeline.c;
import com.getpebble.android.framework.timeline.e;
import com.getpebble.android.h.p;
import com.google.b.c.a;
import com.google.b.o;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class b {
    static final String a = com.getpebble.android.framework.timeline.e.b.ACTION_RESULT_DONE.getSerializedName();
    static final String b = null;
    private static final Type c = new a<Map<String, String>>() {
    }.getType();
    private String d;
    private String e;
    private Map<String, String> f;
    private String g;
    private o h;
    private String i;
    private String j;
    private String k;
    private String l;

    public void a(String str) {
        this.d = str;
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    public Map<String, String> c() {
        return this.f;
    }

    public String d() {
        return this.g;
    }

    public o e() {
        return this.h;
    }

    public String f() {
        return this.i;
    }

    public String g() {
        return this.j;
    }

    public String h() {
        return this.k;
    }

    public String i() {
        return this.l;
    }

    public static String a(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    public static b a(c cVar, UUID uuid, String str, String str2) {
        e[] attributes = cVar.getAttributes();
        b bVar = new b();
        for (e eVar : attributes) {
            String name = eVar.getName();
            Object obj = -1;
            switch (name.hashCode()) {
                case -1268631780:
                    if (name.equals("successIcon")) {
                        obj = 6;
                        break;
                    }
                    break;
                case -1268301872:
                    if (name.equals("successText")) {
                        obj = 5;
                        break;
                    }
                    break;
                case -1077554975:
                    if (name.equals("method")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 116079:
                    if (name.equals("url")) {
                        obj = null;
                        break;
                    }
                    break;
                case 795307910:
                    if (name.equals("headers")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 1702329738:
                    if (name.equals("bodyJSON")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 1702646255:
                    if (name.equals("bodyText")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 2071399715:
                    if (name.equals("failureIcon")) {
                        obj = 8;
                        break;
                    }
                    break;
                case 2071729623:
                    if (name.equals("failureText")) {
                        obj = 7;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    bVar.d = eVar.getValue().c();
                    break;
                case 1:
                    bVar.e = eVar.getValue().c();
                    break;
                case 2:
                    bVar.f = (Map) p.a(eVar.getValue().toString(), c);
                    break;
                case 3:
                    bVar.g = eVar.getValue().c();
                    break;
                case 4:
                    bVar.h = eVar.getValue().l();
                    break;
                case 5:
                    bVar.i = eVar.getValue().c();
                    break;
                case 6:
                    bVar.j = eVar.getValue().c();
                    break;
                case 7:
                    bVar.k = eVar.getValue().c();
                    break;
                case 8:
                    bVar.l = eVar.getValue().c();
                    break;
                default:
                    break;
            }
        }
        if (TextUtils.isEmpty(bVar.d)) {
            throw new IllegalArgumentException("URL not set!");
        }
        bVar.e = a(bVar.e, "POST");
        bVar.g = a(bVar.g, "");
        bVar.i = a(bVar.i, str);
        bVar.j = a(bVar.j, a);
        bVar.k = a(bVar.k, str2);
        bVar.l = a(bVar.l, b);
        if (uuid != null) {
            if (bVar.f == null) {
                bVar.f = new HashMap();
            }
            Context K = com.getpebble.android.common.a.K();
            CharSequence c = g.a(K).c(uuid);
            if (!(TextUtils.isEmpty(c) || bVar.f.containsKey("X-Pebble-Account-Token"))) {
                bVar.f.put("X-Pebble-Account-Token", c);
            }
            CharSequence b = g.a(K).b(uuid);
            if (!(TextUtils.isEmpty(b) || bVar.f.containsKey("X-Pebble-Watch-Token"))) {
                bVar.f.put("X-Pebble-Watch-Token", b);
            }
        }
        return bVar;
    }
}
