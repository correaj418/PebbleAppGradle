package com.b.a;

public class c extends Exception {
    private boolean a = false;

    public c(Throwable th) {
        super("Peer not trusted by any of the system trust managers.", th);
    }

    public boolean a() {
        return this.a;
    }
}
