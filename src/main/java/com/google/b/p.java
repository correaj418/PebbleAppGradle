package com.google.b;

public class p extends RuntimeException {
    public p(String str) {
        super(str);
    }

    public p(String str, Throwable th) {
        super(str, th);
    }

    public p(Throwable th) {
        super(th);
    }
}
