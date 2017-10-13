package com.b.a.c.a;

import com.b.a.a.a;
import com.b.a.ac;
import com.b.a.c.d;
import com.b.a.c.s;
import com.b.a.c.t;
import com.b.a.k;
import com.b.a.m;
import com.b.a.p;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

public class h implements a<s> {
    private s a;
    private byte[] b;

    private void d() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Iterator it = this.a.iterator();
            Object obj = 1;
            while (it.hasNext()) {
                t tVar = (t) it.next();
                if (tVar.b() != null) {
                    if (obj == null) {
                        stringBuilder.append('&');
                    }
                    obj = null;
                    stringBuilder.append(URLEncoder.encode(tVar.a(), "UTF-8"));
                    stringBuilder.append('=');
                    stringBuilder.append(URLEncoder.encode(tVar.b(), "UTF-8"));
                }
            }
            this.b = stringBuilder.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public void a(d dVar, p pVar, a aVar) {
        if (this.b == null) {
            d();
        }
        ac.a(pVar, this.b, aVar);
    }

    public String a() {
        return "application/x-www-form-urlencoded; charset=utf-8";
    }

    public void a(m mVar, final a aVar) {
        final k kVar = new k();
        mVar.a(new com.b.a.a.d(this) {
            final /* synthetic */ h b;

            public void a(m mVar, k kVar) {
                kVar.a(kVar);
            }
        });
        mVar.b(new a(this) {
            final /* synthetic */ h c;

            public void a(Exception exception) {
                if (exception != null) {
                    aVar.a(exception);
                    return;
                }
                try {
                    this.c.a = s.c(kVar.q());
                    aVar.a(null);
                } catch (Exception e) {
                    aVar.a(e);
                }
            }
        });
    }

    public boolean b() {
        return true;
    }

    public int c() {
        if (this.b == null) {
            d();
        }
        return this.b.length;
    }
}
