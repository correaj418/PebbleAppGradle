package com.b.a.b;

public abstract class j<T, F> extends i<T> implements f<F> {
    protected abstract void a(F f);

    public void a(Exception exception, F f) {
        if (!isCancelled()) {
            if (exception != null) {
                b(exception);
                return;
            }
            try {
                a(f);
            } catch (Exception e) {
                b(e);
            }
        }
    }

    protected void b(Exception exception) {
        a(exception);
    }
}
