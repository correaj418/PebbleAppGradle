package com.google.android.gms.b;

import com.google.android.gms.common.internal.b;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ap implements ThreadFactory {
    private final String a;
    private final int b;
    private final AtomicInteger c;
    private final ThreadFactory d;

    public ap(String str) {
        this(str, 0);
    }

    public ap(String str, int i) {
        this.c = new AtomicInteger();
        this.d = Executors.defaultThreadFactory();
        this.a = (String) b.a((Object) str, (Object) "Name must not be null");
        this.b = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.d.newThread(new aq(runnable, this.b));
        String str = this.a;
        newThread.setName(new StringBuilder(String.valueOf(str).length() + 13).append(str).append("[").append(this.c.getAndIncrement()).append("]").toString());
        return newThread;
    }
}
