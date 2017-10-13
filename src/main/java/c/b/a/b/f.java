package c.b.a.b;

import c.b.a.a;

abstract class f extends c {
    private static final int[] a = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] b = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final long[] c = new long[12];
    private static final long[] d = new long[12];

    static {
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < 11; i++) {
            j2 += ((long) a[i]) * 86400000;
            c[i + 1] = j2;
            j += ((long) b[i]) * 86400000;
            d[i + 1] = j;
        }
    }

    f(a aVar, Object obj, int i) {
        super(aVar, obj, i);
    }

    boolean j(long j) {
        return u().a(j) == 29 && C().b(j);
    }

    int a(long j, int i) {
        int d = (int) ((j - d(i)) >> 10);
        if (e(i)) {
            if (d < 15356250) {
                if (d < 7678125) {
                    if (d < 2615625) {
                        return 1;
                    }
                    return d < 5062500 ? 2 : 3;
                } else if (d < 10209375) {
                    return 4;
                } else {
                    return d < 12825000 ? 5 : 6;
                }
            } else if (d < 23118750) {
                if (d < 17971875) {
                    return 7;
                }
                return d < 20587500 ? 8 : 9;
            } else if (d < 25734375) {
                return 10;
            } else {
                return d < 28265625 ? 11 : 12;
            }
        } else if (d < 15271875) {
            if (d < 7593750) {
                if (d >= 2615625) {
                    return d < 4978125 ? 2 : 3;
                } else {
                    return 1;
                }
            } else if (d < 10125000) {
                return 4;
            } else {
                return d < 12740625 ? 5 : 6;
            }
        } else if (d < 23034375) {
            if (d < 17887500) {
                return 7;
            }
            return d < 20503125 ? 8 : 9;
        } else if (d < 25650000) {
            return 10;
        } else {
            return d < 28181250 ? 11 : 12;
        }
    }

    int b(int i, int i2) {
        if (e(i)) {
            return b[i2 - 1];
        }
        return a[i2 - 1];
    }

    int e(long j, int i) {
        return (i > 28 || i < 1) ? i(j) : 28;
    }

    long c(int i, int i2) {
        if (e(i)) {
            return d[i2 - 1];
        }
        return c[i2 - 1];
    }

    long f(long j, int i) {
        int a = a(j);
        int c = c(j, a);
        int h = h(j);
        if (c > 59) {
            if (e(a)) {
                if (!e(i)) {
                    c--;
                }
            } else if (e(i)) {
                c++;
            }
        }
        return a(i, 1, c) + ((long) h);
    }
}
