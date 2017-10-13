package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;

public abstract class d<R extends f> {

    public interface a {
        void a(Status status);
    }

    public abstract R a(long j, TimeUnit timeUnit);

    public Integer a() {
        throw new UnsupportedOperationException();
    }

    public abstract void a(g<? super R> gVar);
}
