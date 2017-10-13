package com.getpebble.android.h;

public class ac {
    public static int a(double d) {
        return (int) Math.round(45.3592d * d);
    }

    @Deprecated
    public static int a(int i) {
        return (int) Math.round(((double) i) * 25.4d);
    }

    @Deprecated
    public static int b(double d) {
        return (int) Math.round(1000.0d * d);
    }

    public static int c(double d) {
        return (int) Math.round(100.0d * d);
    }

    @Deprecated
    public static short d(double d) {
        return (short) ((int) Math.round(10.0d * d));
    }

    @Deprecated
    public static int b(int i) {
        return (int) Math.round(((double) i) * 0.1d);
    }

    @Deprecated
    public static int c(int i) {
        return (int) Math.round(((double) i) * 0.001d);
    }

    public static int d(int i) {
        return (int) Math.round(((double) i) * 0.01d);
    }

    public static int e(int i) {
        return (int) Math.round(((double) i) * 0.0220462d);
    }

    @Deprecated
    public static int f(int i) {
        return (int) Math.round(((double) i) * 0.0393701d);
    }

    @Deprecated
    public static double g(int i) {
        return ((double) i) / 100.0d;
    }
}
