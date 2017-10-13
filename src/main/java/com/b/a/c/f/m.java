package com.b.a.c.f;

import java.util.concurrent.CountDownLatch;

final class m {
    private final CountDownLatch a = new CountDownLatch(1);
    private long b = -1;
    private long c = -1;

    m() {
    }

    public void a() {
        if (this.b != -1) {
            throw new IllegalStateException();
        }
        this.b = System.nanoTime();
    }

    public void b() {
        if (this.c != -1 || this.b == -1) {
            throw new IllegalStateException();
        }
        this.c = System.nanoTime();
        this.a.countDown();
    }
}
