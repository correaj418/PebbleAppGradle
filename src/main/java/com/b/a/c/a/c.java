package com.b.a.c.a;

import com.b.a.a.a;
import com.b.a.ac;
import com.b.a.b.f;
import com.b.a.c.d;
import com.b.a.m;
import com.b.a.p;
import org.json.JSONObject;

public class c implements a<JSONObject> {
    byte[] a;
    JSONObject b;

    public void a(m mVar, final a aVar) {
        new com.b.a.d.c().a(mVar).a(new f<JSONObject>(this) {
            final /* synthetic */ c b;

            public void a(Exception exception, JSONObject jSONObject) {
                this.b.b = jSONObject;
                aVar.a(exception);
            }
        });
    }

    public void a(d dVar, p pVar, a aVar) {
        ac.a(pVar, this.a, aVar);
    }

    public String a() {
        return "application/json";
    }

    public boolean b() {
        return true;
    }

    public int c() {
        this.a = this.b.toString().getBytes();
        return this.a.length;
    }
}
