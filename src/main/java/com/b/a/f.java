package com.b.a;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class f {
    Semaphore a = new Semaphore(0);

    public void a() {
        ab a = ab.a(Thread.currentThread());
        f fVar = a.a;
        a.a = this;
        Semaphore semaphore = a.b;
        try {
            if (!this.a.tryAcquire()) {
                while (true) {
                    Runnable a2 = a.a();
                    if (a2 == null) {
                        semaphore.acquire(Math.max(1, semaphore.availablePermits()));
                        if (this.a.tryAcquire()) {
                            a.a = fVar;
                            return;
                        }
                    } else {
                        a2.run();
                    }
                }
            }
        } finally {
            a.a = fVar;
        }
    }

    public boolean a(long j, TimeUnit timeUnit) {
        long convert = TimeUnit.MILLISECONDS.convert(j, timeUnit);
        ab a = ab.a(Thread.currentThread());
        f fVar = a.a;
        a.a = this;
        Semaphore semaphore = a.b;
        if (this.a.tryAcquire()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            Runnable a2 = a.a();
            if (a2 != null) {
                a2.run();
            } else if (semaphore.tryAcquire(Math.max(1, semaphore.availablePermits()), convert, TimeUnit.MILLISECONDS)) {
                try {
                    if (this.a.tryAcquire()) {
                        a.a = fVar;
                        return true;
                    } else if (System.currentTimeMillis() - currentTimeMillis >= convert) {
                        a.a = fVar;
                        return false;
                    }
                } finally {
                    a.a = fVar;
                }
            } else {
                a.a = fVar;
                return false;
            }
        }
    }

    public void b() {
        this.a.release();
        ab.a(this);
    }
}
