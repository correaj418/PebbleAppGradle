package com.b.a.c.a;

import com.b.a.a.a;
import com.b.a.c.n;
import com.b.a.c.s;
import com.b.a.c.t;
import com.b.a.p;
import java.util.List;
import java.util.Locale;

public class e {
    static final /* synthetic */ boolean d = (!e.class.desiredAssertionStatus());
    private long a = -1;
    n b;
    s c;

    public e(n nVar) {
        this.b = nVar;
        this.c = s.b(this.b.a("Content-Disposition"));
    }

    public String b() {
        return this.c.a("name");
    }

    public e(String str, long j, List<t> list) {
        this.a = j;
        this.b = new n();
        StringBuilder stringBuilder = new StringBuilder(String.format(Locale.ENGLISH, "form-data; name=\"%s\"", new Object[]{str}));
        if (list != null) {
            for (t tVar : list) {
                stringBuilder.append(String.format(Locale.ENGLISH, "; %s=\"%s\"", new Object[]{tVar.a(), tVar.b()}));
            }
        }
        this.b.a("Content-Disposition", stringBuilder.toString());
        this.c = s.b(this.b.a("Content-Disposition"));
    }

    public n c() {
        return this.b;
    }

    public void a(String str) {
        this.b.a("Content-Type", str);
    }

    public boolean d() {
        return this.c.containsKey("filename");
    }

    public long e() {
        return this.a;
    }

    public void a(p pVar, a aVar) {
        if (!d) {
            throw new AssertionError();
        }
    }
}
