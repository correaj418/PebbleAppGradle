package c.b.a.b;

import c.b.a.f;
import c.b.a.k;

class m {
    private final f a;
    private final k b;
    private final int c;

    m(f fVar, k kVar, int i) {
        this.a = fVar;
        this.b = kVar;
        this.c = i;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((this.b == null ? 0 : this.b.hashCode()) + 31) * 31) + this.c) * 31;
        if (this.a != null) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (this.b == null) {
            if (mVar.b != null) {
                return false;
            }
        } else if (!this.b.equals(mVar.b)) {
            return false;
        }
        if (this.c != mVar.c) {
            return false;
        }
        if (this.a == null) {
            if (mVar.a != null) {
                return false;
            }
            return true;
        } else if (this.a.equals(mVar.a)) {
            return true;
        } else {
            return false;
        }
    }
}
