package com.b.a.b;

import com.b.a.f;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class i<T> extends h implements d<T> {
    f d;
    Exception i;
    T j;
    boolean k;
    f<T> l;

    public /* synthetic */ c a(a aVar) {
        return c(aVar);
    }

    public /* synthetic */ e a(f fVar) {
        return d(fVar);
    }

    public /* synthetic */ h b(a aVar) {
        return c(aVar);
    }

    public /* synthetic */ a g() {
        return k();
    }

    public boolean cancel(boolean z) {
        return b();
    }

    private boolean a(boolean z) {
        if (!super.b()) {
            return false;
        }
        f o;
        synchronized (this) {
            this.i = new CancellationException();
            h();
            o = o();
            this.k = z;
        }
        c(o);
        return true;
    }

    public boolean c() {
        return a(true);
    }

    public boolean b() {
        return a(this.k);
    }

    public T get() {
        synchronized (this) {
            if (isCancelled() || isDone()) {
                T n = n();
                return n;
            }
            f i = i();
            i.a();
            return n();
        }
    }

    private T n() {
        if (this.i == null) {
            return this.j;
        }
        throw new ExecutionException(this.i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T get(long r2, java.util.concurrent.TimeUnit r4) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.isCancelled();	 Catch:{ all -> 0x0024 }
        if (r0 != 0) goto L_0x000d;
    L_0x0007:
        r0 = r1.isDone();	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x0013;
    L_0x000d:
        r0 = r1.n();	 Catch:{ all -> 0x0024 }
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
    L_0x0012:
        return r0;
    L_0x0013:
        r0 = r1.i();	 Catch:{ all -> 0x0024 }
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
        r0 = r0.a(r2, r4);
        if (r0 != 0) goto L_0x0027;
    L_0x001e:
        r0 = new java.util.concurrent.TimeoutException;
        r0.<init>();
        throw r0;
    L_0x0024:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
        throw r0;
    L_0x0027:
        r0 = r1.n();
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.b.i.get(long, java.util.concurrent.TimeUnit):T");
    }

    public boolean f() {
        return b(null);
    }

    private f<T> o() {
        f<T> fVar = this.l;
        this.l = null;
        return fVar;
    }

    private void c(f<T> fVar) {
        if (fVar != null && !this.k) {
            fVar.a(this.i, this.j);
        }
    }

    void h() {
        if (this.d != null) {
            this.d.b();
            this.d = null;
        }
    }

    f i() {
        if (this.d == null) {
            this.d = new f();
        }
        return this.d;
    }

    public boolean a(Exception exception) {
        return b(exception, null);
    }

    public boolean b(T t) {
        return b(null, t);
    }

    public boolean b(Exception exception, T t) {
        synchronized (this) {
            if (super.f()) {
                this.j = t;
                this.i = exception;
                h();
                f o = o();
                c(o);
                return true;
            }
            return false;
        }
    }

    public f<T> j() {
        return new f<T>(this) {
            final /* synthetic */ i a;

            {
                this.a = r1;
            }

            public void a(Exception exception, T t) {
                this.a.b(exception, t);
            }
        };
    }

    public i<T> a(e<T> eVar) {
        eVar.a(j());
        c((a) eVar);
        return this;
    }

    public i<T> d(f<T> fVar) {
        f o;
        synchronized (this) {
            this.l = fVar;
            if (isDone() || isCancelled()) {
                o = o();
            } else {
                o = null;
            }
        }
        c(o);
        return this;
    }

    public final <C extends f<T>> C b(C c) {
        if (c instanceof c) {
            ((c) c).a(this);
        }
        d(c);
        return c;
    }

    public i<T> c(a aVar) {
        super.b(aVar);
        return this;
    }

    public i<T> k() {
        super.g();
        this.j = null;
        this.i = null;
        this.d = null;
        this.l = null;
        this.k = false;
        return this;
    }

    public Exception l() {
        return this.i;
    }

    public T m() {
        return this.j;
    }
}
