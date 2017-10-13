package b;

final class f implements b {
    public final a a = new a();
    public final k b;
    boolean c;

    f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.b = kVar;
    }

    public void a(a aVar, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(aVar, j);
        a();
    }

    public b b(d dVar) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(dVar);
        return a();
    }

    public b b(String str) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(str);
        return a();
    }

    public long a(l lVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b = lVar.b(this.a, 8192);
            if (b == -1) {
                return j;
            }
            j += b;
            a();
        }
    }

    public b g(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(i);
        return a();
    }

    public b f(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.c(i);
        return a();
    }

    public b i(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.h(j);
        return a();
    }

    public b a() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long d = this.a.d();
        if (d > 0) {
            this.b.a(this.a, d);
        }
        return this;
    }

    public b b() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long a = this.a.a();
        if (a > 0) {
            this.b.a(this.a, a);
        }
        return this;
    }

    public void flush() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.a.b > 0) {
            this.b.a(this.a, this.a.b);
        }
        this.b.flush();
    }

    public void close() {
        if (!this.c) {
            Throwable th = null;
            try {
                if (this.a.b > 0) {
                    this.b.a(this.a, this.a.b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.c = true;
            if (th != null) {
                n.a(th);
            }
        }
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
