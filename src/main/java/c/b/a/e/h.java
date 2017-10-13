package c.b.a.e;

import c.b.a.a;
import c.b.a.f;
import c.b.a.u;
import java.io.Writer;
import java.util.Locale;

class h implements m {
    private final g a;

    static m a(g gVar) {
        if (gVar instanceof n) {
            return (m) gVar;
        }
        if (gVar == null) {
            return null;
        }
        return new h(gVar);
    }

    private h(g gVar) {
        this.a = gVar;
    }

    public int estimatePrintedLength() {
        return this.a.estimatePrintedLength();
    }

    public void printTo(Appendable appendable, long j, a aVar, int i, f fVar, Locale locale) {
        if (appendable instanceof StringBuffer) {
            this.a.a((StringBuffer) appendable, j, aVar, i, fVar, locale);
        }
        if (appendable instanceof Writer) {
            this.a.a((Writer) appendable, j, aVar, i, fVar, locale);
        }
        StringBuffer stringBuffer = new StringBuffer(estimatePrintedLength());
        this.a.a(stringBuffer, j, aVar, i, fVar, locale);
        appendable.append(stringBuffer);
    }

    public void printTo(Appendable appendable, u uVar, Locale locale) {
        if (appendable instanceof StringBuffer) {
            this.a.a((StringBuffer) appendable, uVar, locale);
        }
        if (appendable instanceof Writer) {
            this.a.a((Writer) appendable, uVar, locale);
        }
        StringBuffer stringBuffer = new StringBuffer(estimatePrintedLength());
        this.a.a(stringBuffer, uVar, locale);
        appendable.append(stringBuffer);
    }
}
