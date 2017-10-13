package c.b.a;

import c.b.a.a.e;
import c.b.a.b.u;
import c.b.a.e.j;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import org.joda.convert.ToString;

public final class m extends e implements u, Serializable {
    private static final Set<h> a = new HashSet();
    private final long b;
    private final a c;
    private transient int d;

    public /* synthetic */ int compareTo(Object obj) {
        return a((u) obj);
    }

    static {
        a.add(h.f());
        a.add(h.g());
        a.add(h.i());
        a.add(h.h());
        a.add(h.j());
        a.add(h.k());
        a.add(h.l());
    }

    public static m a(Calendar calendar) {
        if (calendar == null) {
            throw new IllegalArgumentException("The calendar must not be null");
        }
        int i = calendar.get(0);
        int i2 = calendar.get(1);
        if (i != 1) {
            i2 = 1 - i2;
        }
        return new m(i2, calendar.get(2) + 1, calendar.get(5));
    }

    public static m a(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (date.getTime() >= 0) {
            return new m(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
        } else {
            Calendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(date);
            return a(gregorianCalendar);
        }
    }

    public m() {
        this(e.a(), u.O());
    }

    public m(long j, a aVar) {
        a a = e.a(aVar);
        long a2 = a.a().a(f.a, j);
        a = a.b();
        this.b = a.u().d(a2);
        this.c = a;
    }

    public m(int i, int i2, int i3) {
        this(i, i2, i3, u.N());
    }

    public m(int i, int i2, int i3, a aVar) {
        a b = e.a(aVar).b();
        long a = b.a(i, i2, i3, 0);
        this.c = b;
        this.b = a;
    }

    public int a() {
        return 3;
    }

    protected c a(int i, a aVar) {
        switch (i) {
            case 0:
                return aVar.E();
            case 1:
                return aVar.C();
            case 2:
                return aVar.u();
            default:
                throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
    }

    public int a(int i) {
        switch (i) {
            case 0:
                return c().E().a(b());
            case 1:
                return c().C().a(b());
            case 2:
                return c().u().a(b());
            default:
                throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
    }

    public int a(d dVar) {
        if (dVar == null) {
            throw new IllegalArgumentException("The DateTimeFieldType must not be null");
        } else if (b(dVar)) {
            return dVar.a(c()).a(b());
        } else {
            throw new IllegalArgumentException("Field '" + dVar + "' is not supported");
        }
    }

    public boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        h y = dVar.y();
        if (a.contains(y) || y.a(c()).d() >= c().s().d()) {
            return dVar.a(c()).c();
        }
        return false;
    }

    protected long b() {
        return this.b;
    }

    public a c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (this.c.equals(mVar.c)) {
                return this.b == mVar.b;
            }
        }
        return super.equals(obj);
    }

    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        i = super.hashCode();
        this.d = i;
        return i;
    }

    public int a(u uVar) {
        if (this == uVar) {
            return 0;
        }
        if (uVar instanceof m) {
            m mVar = (m) uVar;
            if (this.c.equals(mVar.c)) {
                int i = this.b < mVar.b ? -1 : this.b == mVar.b ? 0 : 1;
                return i;
            }
        }
        return super.a(uVar);
    }

    public b a(f fVar) {
        f a = e.a(fVar);
        a a2 = c().a(a);
        return new b(a2.u().d(a.a(b() + 21600000, false)), a2);
    }

    public int d() {
        return c().E().a(b());
    }

    public int e() {
        return c().C().a(b());
    }

    public int f() {
        return c().u().a(b());
    }

    @ToString
    public String toString() {
        return j.b().a((u) this);
    }
}
