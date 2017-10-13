package b;

import java.io.EOFException;

final class g implements c {
    public final a a = new a();
    public final l b;
    boolean c;

    g(l lVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.b = lVar;
    }

    public long b(a aVar, long j) {
        if (aVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.c) {
            throw new IllegalStateException("closed");
        } else if (this.a.b == 0 && this.b.b(this.a, 8192) == -1) {
            return -1;
        } else {
            return this.a.b(aVar, Math.min(j, this.a.b));
        }
    }

    public boolean c() {
        if (!this.c) {
            return this.a.c() && this.b.b(this.a, 8192) == -1;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public void a(long j) {
        if (!b(j)) {
            throw new EOFException();
        }
    }

    public boolean b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.c) {
            throw new IllegalStateException("closed");
        } else {
            while (this.a.b < j) {
                if (this.b.b(this.a, 8192) == -1) {
                    return false;
                }
            }
            return true;
        }
    }

    public byte e() {
        a(1);
        return this.a.e();
    }

    public d c(long j) {
        a(j);
        return this.a.c(j);
    }

    public byte[] e(long j) {
        a(j);
        return this.a.e(j);
    }

    public String d(long j) {
        a(j);
        return this.a.d(j);
    }

    public int h() {
        a(4);
        return this.a.h();
    }

    public long i() {
        a(8);
        return this.a.i();
    }

    public void f(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.a.b == 0 && this.b.b(this.a, 8192) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.a.a());
            this.a.f(min);
            j -= min;
        }
    }

    public void close() {
        if (!this.c) {
            this.c = true;
            this.b.close();
            this.a.l();
        }
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
