package c.b.a.f;

import c.b.a.f;

public class a extends f {
    private static final int b;
    private final f c;
    private final transient a[] d = new a[(b + 1)];

    private static final class a {
        public final long a;
        public final f b;
        a c;
        private String d;
        private int e = Integer.MIN_VALUE;
        private int f = Integer.MIN_VALUE;

        a(f fVar, long j) {
            this.a = j;
            this.b = fVar;
        }

        public String a(long j) {
            if (this.c != null && j >= this.c.a) {
                return this.c.a(j);
            }
            if (this.d == null) {
                this.d = this.b.a(this.a);
            }
            return this.d;
        }

        public int b(long j) {
            if (this.c != null && j >= this.c.a) {
                return this.c.b(j);
            }
            if (this.e == Integer.MIN_VALUE) {
                this.e = this.b.b(this.a);
            }
            return this.e;
        }

        public int c(long j) {
            if (this.c != null && j >= this.c.a) {
                return this.c.c(j);
            }
            if (this.f == Integer.MIN_VALUE) {
                this.f = this.b.c(this.a);
            }
            return this.f;
        }
    }

    static {
        Integer integer;
        int i;
        try {
            integer = Integer.getInteger("org.joda.time.tz.CachedDateTimeZone.size");
        } catch (SecurityException e) {
            integer = null;
        }
        if (integer == null) {
            i = 512;
        } else {
            i = 0;
            for (int intValue = integer.intValue() - 1; intValue > 0; intValue >>= 1) {
                i++;
            }
            i = 1 << i;
        }
        b = i - 1;
    }

    public static a b(f fVar) {
        if (fVar instanceof a) {
            return (a) fVar;
        }
        return new a(fVar);
    }

    private a(f fVar) {
        super(fVar.e());
        this.c = fVar;
    }

    public String a(long j) {
        return i(j).a(j);
    }

    public int b(long j) {
        return i(j).b(j);
    }

    public int c(long j) {
        return i(j).c(j);
    }

    public boolean f() {
        return this.c.f();
    }

    public long g(long j) {
        return this.c.g(j);
    }

    public long h(long j) {
        return this.c.h(j);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            return this.c.equals(((a) obj).c);
        }
        return false;
    }

    private a i(long j) {
        int i = (int) (j >> 32);
        a[] aVarArr = this.d;
        int i2 = i & b;
        a aVar = aVarArr[i2];
        if (aVar != null && ((int) (aVar.a >> 32)) == i) {
            return aVar;
        }
        aVar = j(j);
        aVarArr[i2] = aVar;
        return aVar;
    }

    private a j(long j) {
        long j2 = j & -4294967296L;
        a aVar = new a(this.c, j2);
        long j3 = j2 | 4294967295L;
        a aVar2 = aVar;
        while (true) {
            long g = this.c.g(j2);
            if (g == j2 || g > j3) {
                return aVar;
            }
            a aVar3 = new a(this.c, g);
            aVar2.c = aVar3;
            aVar2 = aVar3;
            j2 = g;
        }
        return aVar;
    }
}
