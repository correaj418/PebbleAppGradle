package c.b.a.e;

import c.b.a.a;
import c.b.a.f;
import c.b.a.u;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

class n implements g, m {
    private final m a;

    public int estimatePrintedLength() {
        return this.a.estimatePrintedLength();
    }

    public void a(StringBuffer stringBuffer, long j, a aVar, int i, f fVar, Locale locale) {
        try {
            this.a.printTo(stringBuffer, j, aVar, i, fVar, locale);
        } catch (IOException e) {
        }
    }

    public void a(Writer writer, long j, a aVar, int i, f fVar, Locale locale) {
        this.a.printTo(writer, j, aVar, i, fVar, locale);
    }

    public void printTo(Appendable appendable, long j, a aVar, int i, f fVar, Locale locale) {
        this.a.printTo(appendable, j, aVar, i, fVar, locale);
    }

    public void a(StringBuffer stringBuffer, u uVar, Locale locale) {
        try {
            this.a.printTo(stringBuffer, uVar, locale);
        } catch (IOException e) {
        }
    }

    public void a(Writer writer, u uVar, Locale locale) {
        this.a.printTo(writer, uVar, locale);
    }

    public void printTo(Appendable appendable, u uVar, Locale locale) {
        this.a.printTo(appendable, uVar, locale);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        return this.a.equals(((n) obj).a);
    }
}
