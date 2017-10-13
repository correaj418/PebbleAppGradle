package com.b.a.f;

import java.util.LinkedHashMap;
import java.util.Locale;

public class f<K, V> {
    private final LinkedHashMap<K, V> a;
    private long b;
    private long c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public f(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.c = j;
        this.a = new LinkedHashMap(0, 0.75f, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V a(K r7) {
        /*
        r6 = this;
        if (r7 != 0) goto L_0x000a;
    L_0x0002:
        r0 = new java.lang.NullPointerException;
        r1 = "key == null";
        r0.<init>(r1);
        throw r0;
    L_0x000a:
        monitor-enter(r6);
        r0 = r6.a;	 Catch:{ all -> 0x002a }
        r0 = r0.get(r7);	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x001b;
    L_0x0013:
        r1 = r6.g;	 Catch:{ all -> 0x002a }
        r1 = r1 + 1;
        r6.g = r1;	 Catch:{ all -> 0x002a }
        monitor-exit(r6);	 Catch:{ all -> 0x002a }
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = r6.h;	 Catch:{ all -> 0x002a }
        r0 = r0 + 1;
        r6.h = r0;	 Catch:{ all -> 0x002a }
        monitor-exit(r6);	 Catch:{ all -> 0x002a }
        r1 = r6.c(r7);
        if (r1 != 0) goto L_0x002d;
    L_0x0028:
        r0 = 0;
        goto L_0x001a;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x002a }
        throw r0;
    L_0x002d:
        monitor-enter(r6);
        r0 = r6.e;	 Catch:{ all -> 0x0053 }
        r0 = r0 + 1;
        r6.e = r0;	 Catch:{ all -> 0x0053 }
        r0 = r6.a;	 Catch:{ all -> 0x0053 }
        r0 = r0.put(r7, r1);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0049;
    L_0x003c:
        r2 = r6.a;	 Catch:{ all -> 0x0053 }
        r2.put(r7, r0);	 Catch:{ all -> 0x0053 }
    L_0x0041:
        monitor-exit(r6);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0056;
    L_0x0044:
        r2 = 0;
        r6.a(r2, r7, r1, r0);
        goto L_0x001a;
    L_0x0049:
        r2 = r6.b;	 Catch:{ all -> 0x0053 }
        r4 = r6.c(r7, r1);	 Catch:{ all -> 0x0053 }
        r2 = r2 + r4;
        r6.b = r2;	 Catch:{ all -> 0x0053 }
        goto L_0x0041;
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0053 }
        throw r0;
    L_0x0056:
        r2 = r6.c;
        r6.b(r2);
        r0 = r1;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.f.f.a(java.lang.Object):V");
    }

    public final V b(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V put;
        synchronized (this) {
            this.d++;
            this.b += c(k, v);
            put = this.a.put(k, v);
            if (put != null) {
                this.b -= c(k, put);
            }
        }
        if (put != null) {
            a(false, k, put, v);
        }
        b(this.c);
        return put;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(long r10) {
        /*
        r9 = this;
        r6 = 0;
    L_0x0002:
        monitor-enter(r9);
        r0 = r9.b;	 Catch:{ all -> 0x0038 }
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 < 0) goto L_0x0017;
    L_0x0009:
        r0 = r9.a;	 Catch:{ all -> 0x0038 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0038 }
        if (r0 == 0) goto L_0x003b;
    L_0x0011:
        r0 = r9.b;	 Catch:{ all -> 0x0038 }
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 == 0) goto L_0x003b;
    L_0x0017:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0038 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0038 }
        r1.<init>();	 Catch:{ all -> 0x0038 }
        r2 = r9.getClass();	 Catch:{ all -> 0x0038 }
        r2 = r2.getName();	 Catch:{ all -> 0x0038 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0038 }
        r2 = ".sizeOf() is reporting inconsistent results!";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0038 }
        r1 = r1.toString();	 Catch:{ all -> 0x0038 }
        r0.<init>(r1);	 Catch:{ all -> 0x0038 }
        throw r0;	 Catch:{ all -> 0x0038 }
    L_0x0038:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0038 }
        throw r0;
    L_0x003b:
        r0 = r9.b;	 Catch:{ all -> 0x0038 }
        r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1));
        if (r0 <= 0) goto L_0x0049;
    L_0x0041:
        r0 = r9.a;	 Catch:{ all -> 0x0038 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0038 }
        if (r0 == 0) goto L_0x004b;
    L_0x0049:
        monitor-exit(r9);	 Catch:{ all -> 0x0038 }
        return;
    L_0x004b:
        r0 = r9.a;	 Catch:{ all -> 0x0038 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0038 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0038 }
        r0 = r0.next();	 Catch:{ all -> 0x0038 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0038 }
        r1 = r0.getKey();	 Catch:{ all -> 0x0038 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0038 }
        r2 = r9.a;	 Catch:{ all -> 0x0038 }
        r2.remove(r1);	 Catch:{ all -> 0x0038 }
        r2 = r9.b;	 Catch:{ all -> 0x0038 }
        r4 = r9.c(r1, r0);	 Catch:{ all -> 0x0038 }
        r2 = r2 - r4;
        r9.b = r2;	 Catch:{ all -> 0x0038 }
        r2 = r9.f;	 Catch:{ all -> 0x0038 }
        r2 = r2 + 1;
        r9.f = r2;	 Catch:{ all -> 0x0038 }
        monitor-exit(r9);	 Catch:{ all -> 0x0038 }
        r2 = 1;
        r3 = 0;
        r9.a(r2, r1, r0, r3);
        goto L_0x0002;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.f.f.b(long):void");
    }

    public final V b(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        V remove;
        synchronized (this) {
            remove = this.a.remove(k);
            if (remove != null) {
                this.b -= c(k, remove);
            }
        }
        if (remove != null) {
            a(false, k, remove, null);
        }
        return remove;
    }

    protected void a(boolean z, K k, V v, V v2) {
    }

    protected V c(K k) {
        return null;
    }

    private long c(K k, V v) {
        long a = a(k, v);
        if (a >= 0) {
            return a;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    protected long a(K k, V v) {
        return 1;
    }

    public void a(long j) {
        this.c = j;
    }

    public final synchronized long a() {
        return this.c;
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.g + this.h;
            if (i2 != 0) {
                i = (this.g * 100) / i2;
            }
            format = String.format(Locale.ENGLISH, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Long.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i)});
        }
        return format;
    }
}
