package com.b.a.c;

import android.text.TextUtils;
import com.b.a.ac;
import com.b.a.c.a.a;
import com.b.a.c.b.c;
import com.b.a.c.b.f;
import com.b.a.j;
import com.b.a.m;
import com.b.a.w;
import java.io.IOException;

public class p extends y {
    public boolean a(final c cVar) {
        u uVar = u.get(cVar.c);
        if (uVar != null && uVar != u.HTTP_1_0 && uVar != u.HTTP_1_1) {
            return super.a(cVar);
        }
        com.b.a.p jVar;
        j jVar2;
        d dVar = cVar.j;
        a g = cVar.j.g();
        if (g != null) {
            if (g.c() >= 0) {
                dVar.e().a("Content-Length", String.valueOf(g.c()));
                cVar.f.a(cVar.e);
            } else if ("close".equals(dVar.e().a("Connection"))) {
                cVar.f.a(cVar.e);
            } else {
                dVar.e().a("Transfer-Encoding", "Chunked");
                cVar.f.a(new com.b.a.c.d.c(cVar.e));
            }
        }
        String e = dVar.e().e(dVar.a().toString());
        byte[] bytes = e.getBytes();
        boolean z = g != null && g.c() >= 0 && g.c() + bytes.length < 1024;
        if (z) {
            jVar = new j(cVar.f.m_());
            jVar.a(true);
            cVar.f.a(jVar);
            jVar2 = jVar;
        } else {
            jVar2 = null;
            jVar = cVar.e;
        }
        dVar.b("\n" + e);
        final com.b.a.a.a aVar = cVar.g;
        ac.a(jVar, bytes, new com.b.a.a.a(this) {
            final /* synthetic */ p c;

            public void a(Exception exception) {
                ac.a(aVar, exception);
                if (jVar2 != null) {
                    jVar2.a(false);
                    jVar2.a(0);
                }
            }
        });
        w.a anonymousClass2 = new w.a(this) {
            n a = new n();
            String b;
            final /* synthetic */ p d;

            public void a(String str) {
                try {
                    Object trim = str.trim();
                    if (this.b == null) {
                        this.b = trim;
                    } else if (TextUtils.isEmpty(trim)) {
                        String[] split = this.b.split(" ", 3);
                        if (split.length < 2) {
                            throw new Exception(new IOException("Not HTTP"));
                        }
                        cVar.f.a(this.a);
                        String str2 = split[0];
                        cVar.f.a(str2);
                        cVar.f.a(Integer.parseInt(split[1]));
                        cVar.f.b(split.length == 3 ? split[2] : "");
                        cVar.h.a(null);
                        m e = cVar.f.e();
                        if (e != null) {
                            if ("HEAD".equalsIgnoreCase(cVar.j.c())) {
                                e = a.a(e.m(), null);
                            } else {
                                e = q.a(e, u.get(str2), this.a, false);
                            }
                            cVar.f.b(e);
                        }
                    } else {
                        this.a.b(trim);
                    }
                } catch (Exception e2) {
                    cVar.h.a(e2);
                }
            }
        };
        Object wVar = new w();
        cVar.e.a(wVar);
        wVar.a(anonymousClass2);
        return true;
    }

    public void a(f fVar) {
        u uVar = u.get(fVar.c);
        if ((uVar == null || uVar == u.HTTP_1_0 || uVar == u.HTTP_1_1) && (fVar.f.m_() instanceof com.b.a.c.d.c)) {
            fVar.f.m_().a();
        }
    }
}
