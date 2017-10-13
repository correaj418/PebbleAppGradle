package com.b.a.d;

import com.b.a.b.e;
import com.b.a.b.j;
import com.b.a.k;
import com.b.a.m;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

public class d implements a<String> {
    Charset a;

    public e<String> a(m mVar) {
        final String n = mVar.n();
        return (e) new b().a(mVar).b(new j<String, k>(this) {
            final /* synthetic */ d b;

            protected void a(k kVar) {
                Charset charset = this.b.a;
                if (charset == null && n != null) {
                    charset = Charset.forName(n);
                }
                b((Object) kVar.b(charset));
            }
        });
    }

    public Type a() {
        return String.class;
    }
}
