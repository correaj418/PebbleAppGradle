package com.b.b.d;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.b.a.c.b.d;
import com.b.a.c.b.e;
import com.b.a.c.n;
import com.b.a.c.y;
import com.b.b.j;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class a extends y {
    CookieManager a;
    SharedPreferences b;
    j c;

    public a(j jVar) {
        this.c = jVar;
    }

    public void a() {
        this.a = new CookieManager(null, null);
        this.b = this.c.c().getSharedPreferences(this.c.d() + "-cookies", 0);
        for (String str : this.b.getAll().keySet()) {
            try {
                String string = this.b.getString(str, null);
                n nVar = new n();
                String[] split = string.split("\n");
                int i = 1;
                for (Object obj : split) {
                    if (i != 0) {
                        i = 0;
                    } else if (!TextUtils.isEmpty(obj)) {
                        nVar.b(obj);
                    }
                }
                this.a.put(URI.create(str), nVar.a());
            } catch (Throwable e) {
                Log.e("Ion", "unable to load cookies", e);
            }
        }
    }

    public static void a(Map<String, List<String>> map, n nVar) {
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if ("Cookie".equalsIgnoreCase(str) || "Cookie2".equalsIgnoreCase(str)) {
                nVar.a(str, (List) entry.getValue());
            }
        }
    }

    private void b() {
        if (this.a == null) {
            a();
        }
    }

    public void a(e eVar) {
        b();
        try {
            a(this.a.get(URI.create(eVar.j.d().toString()), eVar.j.e().a()), eVar.j.e());
        } catch (Exception e) {
        }
    }

    public void a(d dVar) {
        b();
        try {
            a(URI.create(dVar.j.d().toString()), dVar.f.k());
        } catch (Exception e) {
        }
    }

    public void a(URI uri, n nVar) {
        b();
        try {
            this.a.put(uri, nVar.a());
            if (nVar.a("Set-Cookie") != null) {
                List<HttpCookie> list = this.a.getCookieStore().get(uri);
                n nVar2 = new n();
                for (HttpCookie httpCookie : list) {
                    nVar2.b("Set-Cookie", httpCookie.getName() + "=" + httpCookie.getValue() + "; path=" + httpCookie.getPath());
                }
                this.b.edit().putString(uri.getScheme() + "://" + uri.getAuthority(), nVar2.e("HTTP/1.1 200 OK")).commit();
            }
        } catch (Exception e) {
        }
    }
}
