package com.b.b.a;

public class a extends Exception {
    public final int a;
    public final int b;

    public a(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public String toString() {
        return super.toString() + " size=" + this.a + 'x' + this.b;
    }
}
