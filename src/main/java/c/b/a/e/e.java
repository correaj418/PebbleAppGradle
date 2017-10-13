package c.b.a.e;

import c.b.a.c;
import c.b.a.d;
import c.b.a.f;
import c.b.a.g;
import c.b.a.h;
import c.b.a.i;
import c.b.a.j;
import java.util.Arrays;
import java.util.Locale;

public class e {
    private final c.b.a.a a;
    private final long b;
    private final Locale c;
    private final int d;
    private final f e;
    private final Integer f;
    private f g;
    private Integer h;
    private Integer i;
    private a[] j;
    private int k;
    private boolean l;
    private Object m;

    static class a implements Comparable<a> {
        c a;
        int b;
        String c;
        Locale d;

        public /* synthetic */ int compareTo(Object obj) {
            return a((a) obj);
        }

        a() {
        }

        void a(c cVar, int i) {
            this.a = cVar;
            this.b = i;
            this.c = null;
            this.d = null;
        }

        void a(c cVar, String str, Locale locale) {
            this.a = cVar;
            this.b = 0;
            this.c = str;
            this.d = locale;
        }

        long a(long j, boolean z) {
            long c;
            if (this.c == null) {
                c = this.a.c(j, this.b);
            } else {
                c = this.a.a(j, this.c, this.d);
            }
            if (z) {
                return this.a.d(c);
            }
            return c;
        }

        public int a(a aVar) {
            c cVar = aVar.a;
            int a = e.a(this.a.e(), cVar.e());
            return a != 0 ? a : e.a(this.a.d(), cVar.d());
        }
    }

    class b {
        final f a;
        final Integer b;
        final a[] c;
        final int d;
        final /* synthetic */ e e;

        b(e eVar) {
            this.e = eVar;
            this.a = eVar.g;
            this.b = eVar.h;
            this.c = eVar.j;
            this.d = eVar.k;
        }

        boolean a(e eVar) {
            if (eVar != this.e) {
                return false;
            }
            eVar.g = this.a;
            eVar.h = this.b;
            eVar.j = this.c;
            if (this.d < eVar.k) {
                eVar.l = true;
            }
            eVar.k = this.d;
            return true;
        }
    }

    public e(long j, c.b.a.a aVar, Locale locale, Integer num, int i) {
        c.b.a.a a = c.b.a.e.a(aVar);
        this.b = j;
        this.e = a.a();
        this.a = a.b();
        if (locale == null) {
            locale = Locale.getDefault();
        }
        this.c = locale;
        this.d = i;
        this.f = num;
        this.g = this.e;
        this.i = this.f;
        this.j = new a[8];
    }

    long a(k kVar, CharSequence charSequence) {
        int parseInto = kVar.parseInto(this, charSequence, 0);
        if (parseInto < 0) {
            parseInto ^= -1;
        } else if (parseInto >= charSequence.length()) {
            return a(true, charSequence);
        }
        throw new IllegalArgumentException(i.a(charSequence.toString(), parseInto));
    }

    public c.b.a.a a() {
        return this.a;
    }

    public Locale b() {
        return this.c;
    }

    public f c() {
        return this.g;
    }

    public void a(f fVar) {
        this.m = null;
        this.g = fVar;
    }

    public Integer d() {
        return this.h;
    }

    public void a(Integer num) {
        this.m = null;
        this.h = num;
    }

    public Integer e() {
        return this.i;
    }

    public void a(c cVar, int i) {
        g().a(cVar, i);
    }

    public void a(d dVar, int i) {
        g().a(dVar.a(this.a), i);
    }

    public void a(d dVar, String str, Locale locale) {
        g().a(dVar.a(this.a), str, locale);
    }

    private a g() {
        Object obj;
        a aVar;
        Object obj2 = this.j;
        int i = this.k;
        if (i == obj2.length || this.l) {
            obj = new a[(i == obj2.length ? i * 2 : obj2.length)];
            System.arraycopy(obj2, 0, obj, 0, i);
            this.j = obj;
            this.l = false;
        } else {
            obj = obj2;
        }
        this.m = null;
        a aVar2 = obj[i];
        if (aVar2 == null) {
            aVar2 = new a();
            obj[i] = aVar2;
            aVar = aVar2;
        } else {
            aVar = aVar2;
        }
        this.k = i + 1;
        return aVar;
    }

    public Object f() {
        if (this.m == null) {
            this.m = new b(this);
        }
        return this.m;
    }

    public boolean a(Object obj) {
        if (!(obj instanceof b) || !((b) obj).a(this)) {
            return false;
        }
        this.m = obj;
        return true;
    }

    public long a(boolean z, String str) {
        return a(z, (CharSequence) str);
    }

    public long a(boolean z, CharSequence charSequence) {
        a[] aVarArr = this.j;
        int i = this.k;
        if (this.l) {
            aVarArr = (a[]) this.j.clone();
            this.j = aVarArr;
            this.l = false;
        }
        a(aVarArr, i);
        if (i > 0) {
            g a = h.i().a(this.a);
            g a2 = h.f().a(this.a);
            g d = aVarArr[0].a.d();
            if (a(d, a) >= 0 && a(d, a2) <= 0) {
                a(d.s(), this.d);
                return a(z, charSequence);
            }
        }
        long j = this.b;
        int i2 = 0;
        while (i2 < i) {
            try {
                j = aVarArr[i2].a(j, z);
                i2++;
            } catch (i e) {
                if (charSequence != null) {
                    e.a("Cannot parse \"" + charSequence + '\"');
                }
                throw e;
            }
        }
        if (z) {
            for (int i3 = 0; i3 < i; i3++) {
                boolean z2;
                a aVar = aVarArr[i3];
                if (i3 == i - 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                j = aVar.a(j, z2);
            }
        }
        long j2 = j;
        if (this.h != null) {
            return j2 - ((long) this.h.intValue());
        }
        if (this.g == null) {
            return j2;
        }
        int e2 = this.g.e(j2);
        j2 -= (long) e2;
        if (e2 == this.g.b(j2)) {
            return j2;
        }
        String str = "Illegal instant due to time zone offset transition (" + this.g + ')';
        if (charSequence != null) {
            str = "Cannot parse \"" + charSequence + "\": " + str;
        }
        throw new j(str);
    }

    private static void a(a[] aVarArr, int i) {
        int i2 = 0;
        if (i > 10) {
            Arrays.sort(aVarArr, 0, i);
            return;
        }
        while (i2 < i) {
            int i3 = i2;
            while (i3 > 0 && aVarArr[i3 - 1].a(aVarArr[i3]) > 0) {
                a aVar = aVarArr[i3];
                aVarArr[i3] = aVarArr[i3 - 1];
                aVarArr[i3 - 1] = aVar;
                i3--;
            }
            i2++;
        }
    }

    static int a(g gVar, g gVar2) {
        if (gVar == null || !gVar.b()) {
            if (gVar2 == null || !gVar2.b()) {
                return 0;
            }
            return -1;
        } else if (gVar2 == null || !gVar2.b()) {
            return 1;
        } else {
            return -gVar.compareTo(gVar2);
        }
    }
}
