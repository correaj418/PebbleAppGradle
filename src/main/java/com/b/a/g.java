package com.b.a;

import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import com.b.a.b.i;
import com.b.a.b.j;
import java.io.Closeable;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class g {
    static g a = new g();
    static final WeakHashMap<Thread, g> e = new WeakHashMap();
    static final /* synthetic */ boolean g;
    private static ExecutorService i = c("AsyncServer-worker-");
    private static final Comparator<InetAddress> j = new Comparator<InetAddress>() {
        public /* synthetic */ int compare(Object obj, Object obj2) {
            return a((InetAddress) obj, (InetAddress) obj2);
        }

        public int a(InetAddress inetAddress, InetAddress inetAddress2) {
            if ((inetAddress instanceof Inet4Address) && (inetAddress2 instanceof Inet4Address)) {
                return 0;
            }
            if ((inetAddress instanceof Inet6Address) && (inetAddress2 instanceof Inet6Address)) {
                return 0;
            }
            if ((inetAddress instanceof Inet4Address) && (inetAddress2 instanceof Inet6Address)) {
                return -1;
            }
            return 1;
        }
    };
    private static ExecutorService k = c("AsyncServer-resolver-");
    String b;
    int c;
    PriorityQueue<f> d;
    Thread f;
    private y h;

    private static class a extends IOException {
        public a(Exception exception) {
            super(exception);
        }
    }

    private class b extends i<b> {
        SocketChannel a;
        com.b.a.a.b b;
        final /* synthetic */ g c;

        private b(g gVar) {
            this.c = gVar;
        }

        protected void a() {
            super.a();
            try {
                if (this.a != null) {
                    this.a.close();
                }
            } catch (IOException e) {
            }
        }
    }

    private static class c implements ThreadFactory {
        private final ThreadGroup a;
        private final AtomicInteger b = new AtomicInteger(1);
        private final String c;

        c(String str) {
            ThreadGroup threadGroup;
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.a = threadGroup;
            this.c = str;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.a, runnable, this.c + this.b.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    private static class d<T> {
        T a;

        private d() {
        }
    }

    private static class e implements Runnable {
        boolean a;
        Runnable b;
        ab c;
        Handler d;

        private e() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r3 = this;
            r2 = 0;
            monitor-enter(r3);
            r0 = r3.a;	 Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0008;
        L_0x0006:
            monitor-exit(r3);	 Catch:{ all -> 0x0022 }
        L_0x0007:
            return;
        L_0x0008:
            r0 = 1;
            r3.a = r0;	 Catch:{ all -> 0x0022 }
            monitor-exit(r3);	 Catch:{ all -> 0x0022 }
            r0 = r3.b;	 Catch:{ all -> 0x0025 }
            r0.run();	 Catch:{ all -> 0x0025 }
            r0 = r3.c;
            r0.remove(r3);
            r0 = r3.d;
            r0.removeCallbacks(r3);
            r3.c = r2;
            r3.d = r2;
            r3.b = r2;
            goto L_0x0007;
        L_0x0022:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0022 }
            throw r0;
        L_0x0025:
            r0 = move-exception;
            r1 = r3.c;
            r1.remove(r3);
            r1 = r3.d;
            r1.removeCallbacks(r3);
            r3.c = r2;
            r3.d = r2;
            r3.b = r2;
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.b.a.g.e.run():void");
        }
    }

    private static class f {
        public Runnable a;
        public long b;

        public f(Runnable runnable, long j) {
            this.a = runnable;
            this.b = j;
        }
    }

    static class g implements Comparator<f> {
        public static g a = new g();

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return a((f) obj, (f) obj2);
        }

        private g() {
        }

        public int a(f fVar, f fVar2) {
            if (fVar.b == fVar2.b) {
                return 0;
            }
            if (fVar.b > fVar2.b) {
                return 1;
            }
            return -1;
        }
    }

    static {
        boolean z;
        if (g.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        g = z;
        try {
            if (VERSION.SDK_INT <= 8) {
                System.setProperty("java.net.preferIPv4Stack", "true");
                System.setProperty("java.net.preferIPv6Addresses", "false");
            }
        } catch (Throwable th) {
        }
    }

    public static void a(Handler handler, Runnable runnable) {
        Runnable eVar = new e();
        ab a = ab.a(handler.getLooper().getThread());
        eVar.c = a;
        eVar.d = handler;
        eVar.b = runnable;
        a.a(eVar);
        handler.post(eVar);
        a.b.release();
    }

    public static g a() {
        return a;
    }

    public g() {
        this(null);
    }

    public g(String str) {
        this.c = 0;
        this.d = new PriorityQueue(1, g.a);
        if (str == null) {
            str = "AsyncServer";
        }
        this.b = str;
    }

    public void a(Object obj) {
        synchronized (this) {
            this.d.remove(obj);
        }
    }

    private static void a(final y yVar) {
        i.execute(new Runnable() {
            public void run() {
                try {
                    yVar.h();
                } catch (Exception e) {
                    Log.i("NIO", "Selector Exception? L Preview?");
                }
            }
        });
    }

    public Object a(Runnable runnable, long j) {
        f fVar;
        long j2 = 0;
        synchronized (this) {
            if (j > 0) {
                j2 = System.currentTimeMillis() + j;
            } else if (j == 0) {
                int i = this.c;
                this.c = i + 1;
                j2 = (long) i;
            } else if (this.d.size() > 0) {
                j2 = Math.min(0, ((f) this.d.peek()).b - 1);
            }
            PriorityQueue priorityQueue = this.d;
            fVar = new f(runnable, j2);
            priorityQueue.add(fVar);
            if (this.h == null) {
                a(true);
            }
            if (!c()) {
                a(this.h);
            }
        }
        return fVar;
    }

    public Object a(Runnable runnable) {
        return a(runnable, 0);
    }

    public void b(final Runnable runnable) {
        if (Thread.currentThread() == this.f) {
            a(runnable);
            a(this, this.d);
            return;
        }
        final Semaphore semaphore = new Semaphore(0);
        a(new Runnable(this) {
            final /* synthetic */ g c;

            public void run() {
                runnable.run();
                semaphore.release();
            }
        });
        try {
            semaphore.acquire();
        } catch (Throwable e) {
            Log.e("NIO", "run", e);
        }
    }

    protected void a(int i) {
    }

    protected void b(int i) {
    }

    public h a(InetAddress inetAddress, int i, com.b.a.a.e eVar) {
        final d dVar = new d();
        final InetAddress inetAddress2 = inetAddress;
        final int i2 = i;
        final com.b.a.a.e eVar2 = eVar;
        b(new Runnable(this) {
            final /* synthetic */ g e;

            public void run() {
                final z zVar;
                Throwable e;
                Closeable closeable = null;
                try {
                    final ServerSocketChannel open = ServerSocketChannel.open();
                    try {
                        zVar = new z(open);
                        try {
                            SocketAddress inetSocketAddress;
                            if (inetAddress2 == null) {
                                inetSocketAddress = new InetSocketAddress(i2);
                            } else {
                                inetSocketAddress = new InetSocketAddress(inetAddress2, i2);
                            }
                            open.socket().bind(inetSocketAddress);
                            final SelectionKey a = zVar.a(this.e.h.a());
                            a.attach(eVar2);
                            com.b.a.a.e eVar = eVar2;
                            d dVar = dVar;
                            AnonymousClass1 anonymousClass1 = new h(this) {
                                final /* synthetic */ AnonymousClass5 d;

                                public void a() {
                                    com.b.a.f.g.a(zVar);
                                    try {
                                        a.cancel();
                                    } catch (Exception e) {
                                    }
                                }
                            };
                            dVar.a = anonymousClass1;
                            eVar.a((h) anonymousClass1);
                        } catch (IOException e2) {
                            e = e2;
                            closeable = open;
                            Log.e("NIO", "wtf", e);
                            com.b.a.f.g.a(zVar, closeable);
                            eVar2.a(e);
                        }
                    } catch (IOException e3) {
                        e = e3;
                        zVar = null;
                        Object obj = open;
                        Log.e("NIO", "wtf", e);
                        com.b.a.f.g.a(zVar, closeable);
                        eVar2.a(e);
                    }
                } catch (IOException e4) {
                    e = e4;
                    zVar = null;
                    Log.e("NIO", "wtf", e);
                    com.b.a.f.g.a(zVar, closeable);
                    eVar2.a(e);
                }
            }
        });
        return (h) dVar.a;
    }

    private b b(final InetSocketAddress inetSocketAddress, final com.b.a.a.b bVar) {
        final b bVar2 = new b();
        if (g || !inetSocketAddress.isUnresolved()) {
            a(new Runnable(this) {
                final /* synthetic */ g d;

                public void run() {
                    Throwable th;
                    SelectionKey selectionKey = null;
                    if (!bVar2.isCancelled()) {
                        bVar2.b = bVar;
                        SocketChannel open;
                        try {
                            b bVar = bVar2;
                            open = SocketChannel.open();
                            bVar.a = open;
                            try {
                                open.configureBlocking(false);
                                selectionKey = open.register(this.d.h.a(), 8);
                                selectionKey.attach(bVar2);
                                open.connect(inetSocketAddress);
                            } catch (Throwable th2) {
                                th = th2;
                                if (selectionKey != null) {
                                    selectionKey.cancel();
                                }
                                com.b.a.f.g.a(open);
                                bVar2.a(new RuntimeException(th));
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            open = null;
                            if (selectionKey != null) {
                                selectionKey.cancel();
                            }
                            com.b.a.f.g.a(open);
                            bVar2.a(new RuntimeException(th));
                        }
                    }
                }
            });
            return bVar2;
        }
        throw new AssertionError();
    }

    public com.b.a.b.a a(final InetSocketAddress inetSocketAddress, final com.b.a.a.b bVar) {
        if (!inetSocketAddress.isUnresolved()) {
            return b(inetSocketAddress, bVar);
        }
        final com.b.a.b.a iVar = new i();
        com.b.a.b.a b = b(inetSocketAddress.getHostName());
        iVar.c(b);
        b.a(new com.b.a.b.f<InetAddress>(this) {
            final /* synthetic */ g d;

            public void a(Exception exception, InetAddress inetAddress) {
                if (exception != null) {
                    bVar.a(exception, null);
                    iVar.a(exception);
                    return;
                }
                iVar.a(this.d.b(new InetSocketAddress(inetAddress, inetSocketAddress.getPort()), bVar));
            }
        });
        return iVar;
    }

    public com.b.a.b.a a(String str, int i, com.b.a.a.b bVar) {
        return a(InetSocketAddress.createUnresolved(str, i), bVar);
    }

    private static ExecutorService c(String str) {
        return new ThreadPoolExecutor(1, 4, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c(str));
    }

    public com.b.a.b.e<InetAddress[]> a(final String str) {
        final com.b.a.b.e iVar = new i();
        k.execute(new Runnable(this) {
            final /* synthetic */ g c;

            public void run() {
                try {
                    final InetAddress[] allByName = InetAddress.getAllByName(str);
                    Arrays.sort(allByName, g.j);
                    if (allByName == null || allByName.length == 0) {
                        throw new v("no addresses for host");
                    }
                    this.c.a(new Runnable(this) {
                        final /* synthetic */ AnonymousClass9 b;

                        public void run() {
                            iVar.b(null, allByName);
                        }
                    });
                } catch (final Exception e) {
                    this.c.a(new Runnable(this) {
                        final /* synthetic */ AnonymousClass9 b;

                        public void run() {
                            iVar.b(e, null);
                        }
                    });
                }
            }
        });
        return iVar;
    }

    public com.b.a.b.e<InetAddress> b(String str) {
        return (com.b.a.b.e) a(str).b(new j<InetAddress, InetAddress[]>(this) {
            final /* synthetic */ g a;

            {
                this.a = r1;
            }

            protected void a(InetAddress[] inetAddressArr) {
                b(inetAddressArr[0]);
            }
        });
    }

    private boolean e() {
        synchronized (e) {
            if (((g) e.get(this.f)) != null) {
                return false;
            }
            e.put(this.f, this);
            return true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(boolean r6) {
        /*
        r5 = this;
        r0 = 0;
        monitor-enter(r5);
        r1 = r5.h;	 Catch:{ all -> 0x001f }
        if (r1 == 0) goto L_0x002e;
    L_0x0006:
        r0 = "NIO";
        r1 = "Reentrant call";
        android.util.Log.i(r0, r1);	 Catch:{ all -> 0x001f }
        r0 = g;	 Catch:{ all -> 0x001f }
        if (r0 != 0) goto L_0x0022;
    L_0x0011:
        r0 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x001f }
        r1 = r5.f;	 Catch:{ all -> 0x001f }
        if (r0 == r1) goto L_0x0022;
    L_0x0019:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x001f }
        r0.<init>();	 Catch:{ all -> 0x001f }
        throw r0;	 Catch:{ all -> 0x001f }
    L_0x001f:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x001f }
        throw r0;
    L_0x0022:
        r0 = 1;
        r2 = r5.h;	 Catch:{ all -> 0x001f }
        r1 = r5.d;	 Catch:{ all -> 0x001f }
    L_0x0027:
        monitor-exit(r5);	 Catch:{ all -> 0x001f }
        if (r0 == 0) goto L_0x0082;
    L_0x002a:
        c(r5, r2, r1);	 Catch:{ a -> 0x0070 }
    L_0x002d:
        return;
    L_0x002e:
        r2 = new com.b.a.y;	 Catch:{ IOException -> 0x005d }
        r1 = java.nio.channels.spi.SelectorProvider.provider();	 Catch:{ IOException -> 0x005d }
        r1 = r1.openSelector();	 Catch:{ IOException -> 0x005d }
        r2.<init>(r1);	 Catch:{ IOException -> 0x005d }
        r5.h = r2;	 Catch:{ IOException -> 0x005d }
        r1 = r5.d;	 Catch:{ IOException -> 0x005d }
        if (r6 == 0) goto L_0x0060;
    L_0x0041:
        r3 = new com.b.a.g$3;	 Catch:{ all -> 0x001f }
        r4 = r5.b;	 Catch:{ all -> 0x001f }
        r3.<init>(r5, r4, r2, r1);	 Catch:{ all -> 0x001f }
        r5.f = r3;	 Catch:{ all -> 0x001f }
    L_0x004a:
        r3 = r5.e();	 Catch:{ all -> 0x001f }
        if (r3 != 0) goto L_0x0067;
    L_0x0050:
        r0 = r5.h;	 Catch:{ Exception -> 0x0086 }
        r0.f();	 Catch:{ Exception -> 0x0086 }
    L_0x0055:
        r0 = 0;
        r5.h = r0;	 Catch:{ all -> 0x001f }
        r0 = 0;
        r5.f = r0;	 Catch:{ all -> 0x001f }
        monitor-exit(r5);	 Catch:{ all -> 0x001f }
        goto L_0x002d;
    L_0x005d:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x001f }
        goto L_0x002d;
    L_0x0060:
        r3 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x001f }
        r5.f = r3;	 Catch:{ all -> 0x001f }
        goto L_0x004a;
    L_0x0067:
        if (r6 == 0) goto L_0x0027;
    L_0x0069:
        r0 = r5.f;	 Catch:{ all -> 0x001f }
        r0.start();	 Catch:{ all -> 0x001f }
        monitor-exit(r5);	 Catch:{ all -> 0x001f }
        goto L_0x002d;
    L_0x0070:
        r0 = move-exception;
        r1 = "NIO";
        r3 = "Selector closed";
        android.util.Log.i(r1, r3, r0);
        r0 = r2.a();	 Catch:{ Exception -> 0x0080 }
        r0.close();	 Catch:{ Exception -> 0x0080 }
        goto L_0x002d;
    L_0x0080:
        r0 = move-exception;
        goto L_0x002d;
    L_0x0082:
        b(r5, r2, r1);
        goto L_0x002d;
    L_0x0086:
        r0 = move-exception;
        goto L_0x0055;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.g.a(boolean):void");
    }

    private static void b(g gVar, y yVar, PriorityQueue<f> priorityQueue) {
        while (true) {
            try {
                c(gVar, yVar, priorityQueue);
            } catch (Throwable e) {
                Log.i("NIO", "Selector exception, shutting down", e);
                try {
                    yVar.a().close();
                } catch (Exception e2) {
                }
            }
            synchronized (gVar) {
                if (!yVar.g() || (yVar.d().size() <= 0 && priorityQueue.size() <= 0)) {
                    break;
                }
            }
        }
        c(yVar);
        if (gVar.h == yVar) {
            gVar.d = new PriorityQueue(1, g.a);
            gVar.h = null;
            gVar.f = null;
        }
        synchronized (e) {
            e.remove(Thread.currentThread());
        }
    }

    private static void b(y yVar) {
        try {
            for (SelectionKey channel : yVar.d()) {
                com.b.a.f.g.a(channel.channel());
                try {
                    ((SelectionKey) r1.next()).cancel();
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
        }
    }

    private static void c(y yVar) {
        b(yVar);
        try {
            yVar.f();
        } catch (Exception e) {
        }
    }

    private static long a(g gVar, PriorityQueue<f> priorityQueue) {
        long j = Long.MAX_VALUE;
        while (true) {
            long j2;
            f fVar;
            synchronized (gVar) {
                long currentTimeMillis = System.currentTimeMillis();
                if (priorityQueue.size() > 0) {
                    f fVar2 = (f) priorityQueue.remove();
                    if (fVar2.b <= currentTimeMillis) {
                        f fVar3 = fVar2;
                        j2 = j;
                        fVar = fVar3;
                    } else {
                        j = fVar2.b - currentTimeMillis;
                        priorityQueue.add(fVar2);
                    }
                }
                j2 = j;
                fVar = null;
            }
            if (fVar == null) {
                gVar.c = 0;
                return j2;
            }
            fVar.a.run();
            j = j2;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void c(com.b.a.g r8, com.b.a.y r9, java.util.PriorityQueue<com.b.a.g.f> r10) {
        /*
        r6 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r4 = 0;
        r1 = 0;
        r0 = 1;
        r2 = a(r8, r10);
        monitor-enter(r8);	 Catch:{ Exception -> 0x009a }
        r5 = r9.b();	 Catch:{ all -> 0x0097 }
        if (r5 != 0) goto L_0x0023;
    L_0x0013:
        r1 = r9.d();	 Catch:{ all -> 0x0097 }
        r1 = r1.size();	 Catch:{ all -> 0x0097 }
        if (r1 != 0) goto L_0x0024;
    L_0x001d:
        r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r1 != 0) goto L_0x0024;
    L_0x0021:
        monitor-exit(r8);	 Catch:{ all -> 0x0097 }
    L_0x0022:
        return;
    L_0x0023:
        r0 = r1;
    L_0x0024:
        monitor-exit(r8);	 Catch:{ all -> 0x0097 }
        if (r0 == 0) goto L_0x002e;
    L_0x0027:
        r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r0 != 0) goto L_0x00a1;
    L_0x002b:
        r9.c();	 Catch:{ Exception -> 0x009a }
    L_0x002e:
        r5 = r9.e();
        r6 = r5.iterator();
    L_0x0036:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x013b;
    L_0x003c:
        r0 = r6.next();
        r0 = (java.nio.channels.SelectionKey) r0;
        r1 = r0.isAcceptable();	 Catch:{ CancelledKeyException -> 0x0095 }
        if (r1 == 0) goto L_0x00a5;
    L_0x0048:
        r1 = r0.channel();	 Catch:{ CancelledKeyException -> 0x0095 }
        r1 = (java.nio.channels.ServerSocketChannel) r1;	 Catch:{ CancelledKeyException -> 0x0095 }
        r3 = r1.accept();	 Catch:{ IOException -> 0x0140 }
        if (r3 == 0) goto L_0x0036;
    L_0x0054:
        r1 = 0;
        r3.configureBlocking(r1);	 Catch:{ IOException -> 0x0145 }
        r1 = r9.a();	 Catch:{ IOException -> 0x0145 }
        r2 = 1;
        r2 = r3.register(r1, r2);	 Catch:{ IOException -> 0x0145 }
        r0 = r0.attachment();	 Catch:{ IOException -> 0x0083 }
        r0 = (com.b.a.a.e) r0;	 Catch:{ IOException -> 0x0083 }
        r7 = new com.b.a.b;	 Catch:{ IOException -> 0x0083 }
        r7.<init>();	 Catch:{ IOException -> 0x0083 }
        r1 = r3.socket();	 Catch:{ IOException -> 0x0083 }
        r1 = r1.getRemoteSocketAddress();	 Catch:{ IOException -> 0x0083 }
        r1 = (java.net.InetSocketAddress) r1;	 Catch:{ IOException -> 0x0083 }
        r7.a(r3, r1);	 Catch:{ IOException -> 0x0083 }
        r7.a(r8, r2);	 Catch:{ IOException -> 0x0083 }
        r2.attach(r7);	 Catch:{ IOException -> 0x0083 }
        r0.a(r7);	 Catch:{ IOException -> 0x0083 }
        goto L_0x0036;
    L_0x0083:
        r0 = move-exception;
        r0 = r2;
        r1 = r3;
    L_0x0086:
        r2 = 1;
        r2 = new java.io.Closeable[r2];	 Catch:{ CancelledKeyException -> 0x0095 }
        r3 = 0;
        r2[r3] = r1;	 Catch:{ CancelledKeyException -> 0x0095 }
        com.b.a.f.g.a(r2);	 Catch:{ CancelledKeyException -> 0x0095 }
        if (r0 == 0) goto L_0x0036;
    L_0x0091:
        r0.cancel();	 Catch:{ CancelledKeyException -> 0x0095 }
        goto L_0x0036;
    L_0x0095:
        r0 = move-exception;
        goto L_0x0036;
    L_0x0097:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x0097 }
        throw r0;	 Catch:{ Exception -> 0x009a }
    L_0x009a:
        r0 = move-exception;
        r1 = new com.b.a.g$a;
        r1.<init>(r0);
        throw r1;
    L_0x00a1:
        r9.a(r2);	 Catch:{ Exception -> 0x009a }
        goto L_0x002e;
    L_0x00a5:
        r1 = r0.isReadable();	 Catch:{ CancelledKeyException -> 0x0095 }
        if (r1 == 0) goto L_0x00ba;
    L_0x00ab:
        r0 = r0.attachment();	 Catch:{ CancelledKeyException -> 0x0095 }
        r0 = (com.b.a.b) r0;	 Catch:{ CancelledKeyException -> 0x0095 }
        r0 = r0.c();	 Catch:{ CancelledKeyException -> 0x0095 }
        r8.a(r0);	 Catch:{ CancelledKeyException -> 0x0095 }
        goto L_0x0036;
    L_0x00ba:
        r1 = r0.isWritable();	 Catch:{ CancelledKeyException -> 0x0095 }
        if (r1 == 0) goto L_0x00cb;
    L_0x00c0:
        r0 = r0.attachment();	 Catch:{ CancelledKeyException -> 0x0095 }
        r0 = (com.b.a.b) r0;	 Catch:{ CancelledKeyException -> 0x0095 }
        r0.b();	 Catch:{ CancelledKeyException -> 0x0095 }
        goto L_0x0036;
    L_0x00cb:
        r1 = r0.isConnectable();	 Catch:{ CancelledKeyException -> 0x0095 }
        if (r1 == 0) goto L_0x012c;
    L_0x00d1:
        r1 = r0.attachment();	 Catch:{ CancelledKeyException -> 0x0095 }
        r1 = (com.b.a.g.b) r1;	 Catch:{ CancelledKeyException -> 0x0095 }
        r2 = r0.channel();	 Catch:{ CancelledKeyException -> 0x0095 }
        r2 = (java.nio.channels.SocketChannel) r2;	 Catch:{ CancelledKeyException -> 0x0095 }
        r3 = 1;
        r0.interestOps(r3);	 Catch:{ CancelledKeyException -> 0x0095 }
        r2.finishConnect();	 Catch:{ IOException -> 0x0111 }
        r7 = new com.b.a.b;	 Catch:{ IOException -> 0x0111 }
        r7.<init>();	 Catch:{ IOException -> 0x0111 }
        r7.a(r8, r0);	 Catch:{ IOException -> 0x0111 }
        r3 = r2.socket();	 Catch:{ IOException -> 0x0111 }
        r3 = r3.getRemoteSocketAddress();	 Catch:{ IOException -> 0x0111 }
        r3 = (java.net.InetSocketAddress) r3;	 Catch:{ IOException -> 0x0111 }
        r7.a(r2, r3);	 Catch:{ IOException -> 0x0111 }
        r0.attach(r7);	 Catch:{ IOException -> 0x0111 }
        r0 = r1.b(r7);	 Catch:{ Exception -> 0x010a }
        if (r0 == 0) goto L_0x0036;
    L_0x0102:
        r0 = r1.b;	 Catch:{ Exception -> 0x010a }
        r1 = 0;
        r0.a(r1, r7);	 Catch:{ Exception -> 0x010a }
        goto L_0x0036;
    L_0x010a:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;	 Catch:{ CancelledKeyException -> 0x0095 }
        r1.<init>(r0);	 Catch:{ CancelledKeyException -> 0x0095 }
        throw r1;	 Catch:{ CancelledKeyException -> 0x0095 }
    L_0x0111:
        r3 = move-exception;
        r0.cancel();	 Catch:{ CancelledKeyException -> 0x0095 }
        r0 = 1;
        r0 = new java.io.Closeable[r0];	 Catch:{ CancelledKeyException -> 0x0095 }
        r7 = 0;
        r0[r7] = r2;	 Catch:{ CancelledKeyException -> 0x0095 }
        com.b.a.f.g.a(r0);	 Catch:{ CancelledKeyException -> 0x0095 }
        r0 = r1.a(r3);	 Catch:{ CancelledKeyException -> 0x0095 }
        if (r0 == 0) goto L_0x0036;
    L_0x0124:
        r0 = r1.b;	 Catch:{ CancelledKeyException -> 0x0095 }
        r1 = 0;
        r0.a(r3, r1);	 Catch:{ CancelledKeyException -> 0x0095 }
        goto L_0x0036;
    L_0x012c:
        r0 = "NIO";
        r1 = "wtf";
        android.util.Log.i(r0, r1);	 Catch:{ CancelledKeyException -> 0x0095 }
        r0 = new java.lang.RuntimeException;	 Catch:{ CancelledKeyException -> 0x0095 }
        r1 = "Unknown key state.";
        r0.<init>(r1);	 Catch:{ CancelledKeyException -> 0x0095 }
        throw r0;	 Catch:{ CancelledKeyException -> 0x0095 }
    L_0x013b:
        r5.clear();
        goto L_0x0022;
    L_0x0140:
        r0 = move-exception;
        r0 = r4;
        r1 = r4;
        goto L_0x0086;
    L_0x0145:
        r0 = move-exception;
        r0 = r4;
        r1 = r3;
        goto L_0x0086;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.g.c(com.b.a.g, com.b.a.y, java.util.PriorityQueue):void");
    }

    public Thread b() {
        return this.f;
    }

    public boolean c() {
        return this.f == Thread.currentThread();
    }
}
