package c.b.a.c;

import c.b.a.a;
import c.b.a.b.l;
import c.b.a.b.n;
import c.b.a.b.t;
import c.b.a.b.u;
import c.b.a.b.w;
import c.b.a.f;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class b extends a implements h, l {
    static final b a = new b();

    protected b() {
    }

    public a b(Object obj, a aVar) {
        if (aVar != null) {
            return aVar;
        }
        f a;
        obj = (Calendar) obj;
        try {
            a = f.a(obj.getTimeZone());
        } catch (IllegalArgumentException e) {
            a = f.a();
        }
        return a(obj, a);
    }

    public a a(Object obj, f fVar) {
        if (obj.getClass().getName().endsWith(".BuddhistCalendar")) {
            return l.b(fVar);
        }
        if (!(obj instanceof GregorianCalendar)) {
            return u.b(fVar);
        }
        long time = ((GregorianCalendar) obj).getGregorianChange().getTime();
        if (time == Long.MIN_VALUE) {
            return t.b(fVar);
        }
        if (time == Long.MAX_VALUE) {
            return w.b(fVar);
        }
        return n.a(fVar, time, 4);
    }

    public long a(Object obj, a aVar) {
        return ((Calendar) obj).getTime().getTime();
    }

    public Class<?> a() {
        return Calendar.class;
    }
}
