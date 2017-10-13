package c.b.a;

public abstract class g implements Comparable<g> {
    public abstract long a(long j, int i);

    public abstract long a(long j, long j2);

    public abstract h a();

    public abstract boolean b();

    public abstract boolean c();

    public abstract long d();

    public long b(long j, int i) {
        if (i == Integer.MIN_VALUE) {
            return b(j, (long) i);
        }
        return a(j, -i);
    }

    public long b(long j, long j2) {
        if (j2 != Long.MIN_VALUE) {
            return a(j, -j2);
        }
        throw new ArithmeticException("Long.MIN_VALUE cannot be negated");
    }
}
