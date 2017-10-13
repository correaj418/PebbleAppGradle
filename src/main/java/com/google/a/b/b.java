package com.google.a.b;

import com.google.a.a.h;
import java.util.NoSuchElementException;

public abstract class b<T> extends ce<T> {
    private a a = a.NOT_READY;
    private T b;

    private enum a {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected abstract T a();

    protected b() {
    }

    protected final T b() {
        this.a = a.DONE;
        return null;
    }

    public final boolean hasNext() {
        h.b(this.a != a.FAILED);
        switch (this.a) {
            case DONE:
                return false;
            case READY:
                return true;
            default:
                return c();
        }
    }

    private boolean c() {
        this.a = a.FAILED;
        this.b = a();
        if (this.a == a.DONE) {
            return false;
        }
        this.a = a.READY;
        return true;
    }

    public final T next() {
        if (hasNext()) {
            this.a = a.NOT_READY;
            T t = this.b;
            this.b = null;
            return t;
        }
        throw new NoSuchElementException();
    }
}
