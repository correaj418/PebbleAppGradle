package com.b.a;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class y {
    boolean a;
    Semaphore b = new Semaphore(0);
    private Selector c;

    public Selector a() {
        return this.c;
    }

    public y(Selector selector) {
        this.c = selector;
    }

    public int b() {
        return this.c.selectNow();
    }

    public void c() {
        a(0);
    }

    public void a(long j) {
        try {
            this.b.drainPermits();
            this.c.select(j);
        } finally {
            this.b.release(Integer.MAX_VALUE);
        }
    }

    public Set<SelectionKey> d() {
        return this.c.keys();
    }

    public Set<SelectionKey> e() {
        return this.c.selectedKeys();
    }

    public void f() {
        this.c.close();
    }

    public boolean g() {
        return this.c.isOpen();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h() {
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        r2 = r5.b;
        r2 = r2.tryAcquire();
        if (r2 != 0) goto L_0x0012;
    L_0x000a:
        r2 = r5.c;
        r2.wakeup();
        if (r0 == 0) goto L_0x0014;
    L_0x0011:
        return;
    L_0x0012:
        r0 = r1;
        goto L_0x000a;
    L_0x0014:
        monitor-enter(r5);
        r0 = r5.a;	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x001e;
    L_0x0019:
        monitor-exit(r5);	 Catch:{ all -> 0x001b }
        goto L_0x0011;
    L_0x001b:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x001b }
        throw r0;
    L_0x001e:
        r0 = 1;
        r5.a = r0;	 Catch:{ all -> 0x001b }
        monitor-exit(r5);	 Catch:{ all -> 0x001b }
    L_0x0022:
        r0 = 100;
        if (r1 >= r0) goto L_0x0044;
    L_0x0026:
        r0 = r5.b;	 Catch:{ InterruptedException -> 0x003b }
        r2 = 10;
        r4 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x003b }
        r0 = r0.tryAcquire(r2, r4);	 Catch:{ InterruptedException -> 0x003b }
        if (r0 == 0) goto L_0x003c;
    L_0x0032:
        monitor-enter(r5);
        r0 = 0;
        r5.a = r0;	 Catch:{ all -> 0x0038 }
        monitor-exit(r5);	 Catch:{ all -> 0x0038 }
        goto L_0x0011;
    L_0x0038:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0038 }
        throw r0;
    L_0x003b:
        r0 = move-exception;
    L_0x003c:
        r0 = r5.c;	 Catch:{ all -> 0x004d }
        r0.wakeup();	 Catch:{ all -> 0x004d }
        r1 = r1 + 1;
        goto L_0x0022;
    L_0x0044:
        monitor-enter(r5);
        r0 = 0;
        r5.a = r0;	 Catch:{ all -> 0x004a }
        monitor-exit(r5);	 Catch:{ all -> 0x004a }
        goto L_0x0011;
    L_0x004a:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x004a }
        throw r0;
    L_0x004d:
        r0 = move-exception;
        monitor-enter(r5);
        r1 = 0;
        r5.a = r1;	 Catch:{ all -> 0x0054 }
        monitor-exit(r5);	 Catch:{ all -> 0x0054 }
        throw r0;
    L_0x0054:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0054 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.y.h():void");
    }
}
