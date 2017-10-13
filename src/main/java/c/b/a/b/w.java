package c.b.a.b;

import c.b.a.a;
import c.b.a.d;
import c.b.a.d.q;
import c.b.a.f;
import c.b.a.i;
import java.util.concurrent.ConcurrentHashMap;

public final class w extends f {
    private static final w a = b(f.a);
    private static final ConcurrentHashMap<f, w[]> b = new ConcurrentHashMap();

    static int h(int i) {
        if (i > 0) {
            return i;
        }
        if (i != 0) {
            return i + 1;
        }
        throw new i(d.s(), Integer.valueOf(i), null, null);
    }

    public static w b(f fVar) {
        return a(fVar, 4);
    }

    public static w a(f fVar, int i) {
        Object obj;
        if (fVar == null) {
            fVar = f.a();
        }
        Object obj2 = (w[]) b.get(fVar);
        if (obj2 == null) {
            obj = new w[7];
            obj2 = (w[]) b.putIfAbsent(fVar, obj);
            if (obj2 != null) {
                obj = obj2;
            }
        } else {
            obj = obj2;
        }
        try {
            w wVar = obj[i - 1];
            if (wVar == null) {
                synchronized (obj) {
                    wVar = obj[i - 1];
                    if (wVar == null) {
                        if (fVar == f.a) {
                            wVar = new w(null, null, i);
                        } else {
                            wVar = new w(y.a(a(f.a, i), fVar), null, i);
                        }
                        obj[i - 1] = wVar;
                    }
                }
            }
            return wVar;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid min days in first week: " + i);
        }
    }

    w(a aVar, Object obj, int i) {
        super(aVar, obj, i);
    }

    public a b() {
        return a;
    }

    public a a(f fVar) {
        if (fVar == null) {
            fVar = f.a();
        }
        return fVar == a() ? this : b(fVar);
    }

    long b(int i, int i2, int i3) {
        return super.b(h(i), i2, i3);
    }

    boolean e(int i) {
        return (i & 3) == 0;
    }

    long f(int i) {
        int i2;
        int i3 = i - 1968;
        if (i3 <= 0) {
            i2 = (i3 + 3) >> 2;
        } else {
            i2 = i3 >> 2;
            if (!e(i)) {
                i2++;
            }
        }
        return ((((long) i2) + (((long) i3) * 365)) * 86400000) - 62035200000L;
    }

    int Q() {
        return -292269054;
    }

    int R() {
        return 292272992;
    }

    long T() {
        return 31557600000L;
    }

    long U() {
        return 15778800000L;
    }

    long V() {
        return 2629800000L;
    }

    long W() {
        return 31083663600000L;
    }

    protected void a(a.a aVar) {
        if (L() == null) {
            super.a(aVar);
            aVar.E = new q(this, aVar.E);
            aVar.B = new q(this, aVar.B);
        }
    }
}
