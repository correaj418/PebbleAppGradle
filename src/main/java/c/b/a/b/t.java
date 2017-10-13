package c.b.a.b;

import c.b.a.a;
import c.b.a.f;
import java.util.concurrent.ConcurrentHashMap;

public final class t extends f {
    private static final t a = b(f.a);
    private static final ConcurrentHashMap<f, t[]> b = new ConcurrentHashMap();

    public static t Z() {
        return a;
    }

    public static t b(f fVar) {
        return a(fVar, 4);
    }

    public static t a(f fVar, int i) {
        Object obj;
        if (fVar == null) {
            fVar = f.a();
        }
        Object obj2 = (t[]) b.get(fVar);
        if (obj2 == null) {
            obj = new t[7];
            obj2 = (t[]) b.putIfAbsent(fVar, obj);
            if (obj2 != null) {
                obj = obj2;
            }
        } else {
            obj = obj2;
        }
        try {
            t tVar = obj[i - 1];
            if (tVar == null) {
                synchronized (obj) {
                    tVar = obj[i - 1];
                    if (tVar == null) {
                        if (fVar == f.a) {
                            tVar = new t(null, null, i);
                        } else {
                            tVar = new t(y.a(a(f.a, i), fVar), null, i);
                        }
                        obj[i - 1] = tVar;
                    }
                }
            }
            return tVar;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid min days in first week: " + i);
        }
    }

    private t(a aVar, Object obj, int i) {
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

    protected void a(a.a aVar) {
        if (L() == null) {
            super.a(aVar);
        }
    }

    boolean e(int i) {
        return (i & 3) == 0 && (i % 100 != 0 || i % 400 == 0);
    }

    long f(int i) {
        int i2 = i / 100;
        if (i < 0) {
            i2 = (((i2 + 3) >> 2) + (((i + 3) >> 2) - i2)) - 1;
        } else {
            i2 = (i2 >> 2) + ((i >> 2) - i2);
            if (e(i)) {
                i2--;
            }
        }
        return (((long) (i2 - 719527)) + (((long) i) * 365)) * 86400000;
    }

    int Q() {
        return -292275054;
    }

    int R() {
        return 292278993;
    }

    long T() {
        return 31556952000L;
    }

    long U() {
        return 15778476000L;
    }

    long V() {
        return 2629746000L;
    }

    long W() {
        return 31083597720000L;
    }
}
