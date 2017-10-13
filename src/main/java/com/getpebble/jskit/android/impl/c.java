package com.getpebble.jskit.android.impl;

public abstract class c {
    private a a = a.STOPPED;

    protected enum a {
        STARTED,
        STOPPED
    }

    protected abstract void b();

    public final void a() {
        this.a = a.STARTED;
        b();
    }
}
