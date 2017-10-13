package c.b.a.d;

import c.b.a.c;
import c.b.a.d;
import c.b.a.i;

public class h {
    public static int a(int i, int i2) {
        int i3 = i + i2;
        if ((i ^ i3) >= 0 || (i ^ i2) < 0) {
            return i3;
        }
        throw new ArithmeticException("The calculation caused an overflow: " + i + " + " + i2);
    }

    public static long a(long j, long j2) {
        long j3 = j + j2;
        if ((j ^ j3) >= 0 || (j ^ j2) < 0) {
            return j3;
        }
        throw new ArithmeticException("The calculation caused an overflow: " + j + " + " + j2);
    }

    public static long a(long j, int i) {
        switch (i) {
            case -1:
                if (j != Long.MIN_VALUE) {
                    return -j;
                }
                throw new ArithmeticException("Multiplication overflows a long: " + j + " * " + i);
            case 0:
                return 0;
            case 1:
                return j;
            default:
                long j2 = ((long) i) * j;
                if (j2 / ((long) i) == j) {
                    return j2;
                }
                throw new ArithmeticException("Multiplication overflows a long: " + j + " * " + i);
        }
    }

    public static long b(long j, long j2) {
        if (j2 == 1) {
            return j;
        }
        if (j == 1) {
            return j2;
        }
        if (j == 0 || j2 == 0) {
            return 0;
        }
        long j3 = j * j2;
        if (j3 / j2 == j && ((j != Long.MIN_VALUE || j2 != -1) && (j2 != Long.MIN_VALUE || j != -1))) {
            return j3;
        }
        throw new ArithmeticException("Multiplication overflows a long: " + j + " * " + j2);
    }

    public static int a(long j) {
        if (-2147483648L <= j && j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("Value cannot fit in an int: " + j);
    }

    public static void a(c cVar, int i, int i2, int i3) {
        if (i < i2 || i > i3) {
            throw new i(cVar.a(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public static void a(d dVar, int i, int i2, int i3) {
        if (i < i2 || i > i3) {
            throw new i(dVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }
}
