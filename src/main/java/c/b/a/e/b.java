package c.b.a.e;

import c.b.a.a;
import c.b.a.e;
import c.b.a.f;
import c.b.a.s;
import c.b.a.u;
import java.io.IOException;
import java.util.Locale;

public class b {
    private final m a;
    private final k b;
    private final Locale c;
    private final boolean d;
    private final a e;
    private final f f;
    private final Integer g;
    private final int h;

    b(m mVar, k kVar) {
        this.a = mVar;
        this.b = kVar;
        this.c = null;
        this.d = false;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = 2000;
    }

    private b(m mVar, k kVar, Locale locale, boolean z, a aVar, f fVar, Integer num, int i) {
        this.a = mVar;
        this.b = kVar;
        this.c = locale;
        this.d = z;
        this.e = aVar;
        this.f = fVar;
        this.g = num;
        this.h = i;
    }

    m a() {
        return this.a;
    }

    public d b() {
        return l.a(this.b);
    }

    k c() {
        return this.b;
    }

    public b d() {
        return this.d ? this : new b(this.a, this.b, this.c, true, this.e, null, this.g, this.h);
    }

    public b a(a aVar) {
        if (this.e == aVar) {
            return this;
        }
        return new b(this.a, this.b, this.c, this.d, aVar, this.f, this.g, this.h);
    }

    public b e() {
        return a(f.a);
    }

    public b a(f fVar) {
        if (this.f == fVar) {
            return this;
        }
        return new b(this.a, this.b, this.c, false, this.e, fVar, this.g, this.h);
    }

    public void a(Appendable appendable, s sVar) {
        a(appendable, e.a(sVar), e.b(sVar));
    }

    public void a(StringBuffer stringBuffer, long j) {
        try {
            a((Appendable) stringBuffer, j);
        } catch (IOException e) {
        }
    }

    public void a(Appendable appendable, long j) {
        a(appendable, j, null);
    }

    public void a(Appendable appendable, u uVar) {
        m f = f();
        if (uVar == null) {
            throw new IllegalArgumentException("The partial must not be null");
        }
        f.printTo(appendable, uVar, this.c);
    }

    public String a(s sVar) {
        Appendable stringBuilder = new StringBuilder(f().estimatePrintedLength());
        try {
            a(stringBuilder, sVar);
        } catch (IOException e) {
        }
        return stringBuilder.toString();
    }

    public String a(u uVar) {
        Appendable stringBuilder = new StringBuilder(f().estimatePrintedLength());
        try {
            a(stringBuilder, uVar);
        } catch (IOException e) {
        }
        return stringBuilder.toString();
    }

    private void a(Appendable appendable, long j, a aVar) {
        m f = f();
        a b = b(aVar);
        f a = b.a();
        int b2 = a.b(j);
        long j2 = ((long) b2) + j;
        if ((j ^ j2) < 0 && (((long) b2) ^ j) >= 0) {
            a = f.a;
            b2 = 0;
            j2 = j;
        }
        f.printTo(appendable, j2, b.b(), b2, a, this.c);
    }

    private m f() {
        m mVar = this.a;
        if (mVar != null) {
            return mVar;
        }
        throw new UnsupportedOperationException("Printing not supported");
    }

    public long a(String str) {
        return new e(0, b(this.e), this.c, this.g, this.h).a(g(), (CharSequence) str);
    }

    public c.b.a.b b(String str) {
        k g = g();
        a b = b(null);
        e eVar = new e(0, b, this.c, this.g, this.h);
        int parseInto = g.parseInto(eVar, str, 0);
        if (parseInto < 0) {
            parseInto ^= -1;
        } else if (parseInto >= str.length()) {
            long a = eVar.a(true, str);
            if (this.d && eVar.d() != null) {
                b = b.a(f.a(eVar.d().intValue()));
            } else if (eVar.c() != null) {
                b = b.a(eVar.c());
            }
            c.b.a.b bVar = new c.b.a.b(a, b);
            if (this.f != null) {
                return bVar.b(this.f);
            }
            return bVar;
        }
        throw new IllegalArgumentException(i.a(str, parseInto));
    }

    private k g() {
        k kVar = this.b;
        if (kVar != null) {
            return kVar;
        }
        throw new UnsupportedOperationException("Parsing not supported");
    }

    private a b(a aVar) {
        a a = e.a(aVar);
        if (this.e != null) {
            a = this.e;
        }
        if (this.f != null) {
            return a.a(this.f);
        }
        return a;
    }
}
