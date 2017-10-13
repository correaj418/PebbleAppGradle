package c.b.a.d;

import c.b.a.d;
import c.b.a.g;
import c.b.a.h;

public abstract class i extends b {
    private final g a;
    final long b;

    private final class a extends c {
        final /* synthetic */ i a;

        a(i iVar, h hVar) {
            this.a = iVar;
            super(hVar);
        }

        public boolean c() {
            return false;
        }

        public long d() {
            return this.a.b;
        }

        public long a(long j, int i) {
            return this.a.a(j, i);
        }

        public long a(long j, long j2) {
            return this.a.a(j, j2);
        }
    }

    public abstract long a(long j, int i);

    public abstract long a(long j, long j2);

    public i(d dVar, long j) {
        super(dVar);
        this.b = j;
        this.a = new a(this, dVar.y());
    }

    public final g d() {
        return this.a;
    }
}
