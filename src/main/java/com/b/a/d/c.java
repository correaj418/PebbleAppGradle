package com.b.a.d;

import com.b.a.b.e;
import com.b.a.b.j;
import com.b.a.m;
import java.lang.reflect.Type;
import org.json.JSONObject;

public class c implements a<JSONObject> {
    public e<JSONObject> a(m mVar) {
        return (e) new d().a(mVar).b(new j<JSONObject, String>(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            protected void a(String str) {
                b((Object) new JSONObject(str));
            }
        });
    }

    public Type a() {
        return JSONObject.class;
    }
}
