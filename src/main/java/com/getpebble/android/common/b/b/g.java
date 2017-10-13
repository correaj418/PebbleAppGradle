package com.getpebble.android.common.b.b;

import com.getpebble.android.common.b.a.f;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class g {

    public static class a {
        final CountDownLatch a = new CountDownLatch(1);
        final long b;

        public a(long j) {
            this.b = j;
        }

        public boolean a() {
            try {
                this.a.await(this.b, TimeUnit.MILLISECONDS);
                return true;
            } catch (Throwable e) {
                f.a("ThreadUtil", "block: interrupted", e);
                return false;
            }
        }

        public void b() {
            this.a.countDown();
        }
    }

    public static class b implements ThreadFactory {
        private static final AtomicInteger a = new AtomicInteger(1);
        private final ThreadGroup b;
        private final AtomicInteger c = new AtomicInteger(1);
        private final String d;

        public b(String str) {
            ThreadGroup threadGroup;
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.b = threadGroup;
            this.d = str + a.getAndIncrement() + "-thread-";
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.b, runnable, this.d + this.c.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    public static void a(String str, String str2) {
        f.c(str, "NOTE Process and thread ID should NOT match for: " + str2);
    }
}
