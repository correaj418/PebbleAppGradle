package b;

final class h {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    h f;
    h g;

    h() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    h(h hVar) {
        this(hVar.a, hVar.b, hVar.c);
        hVar.d = true;
    }

    h(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.e = false;
        this.d = true;
    }

    public h a() {
        h hVar = this.f != this ? this.f : null;
        this.g.f = this.f;
        this.f.g = this.g;
        this.f = null;
        this.g = null;
        return hVar;
    }

    public h a(h hVar) {
        hVar.g = this;
        hVar.f = this.f;
        this.f.g = hVar;
        this.f = hVar;
        return hVar;
    }

    public h a(int i) {
        if (i <= 0 || i > this.c - this.b) {
            throw new IllegalArgumentException();
        }
        h hVar;
        if (i >= 1024) {
            hVar = new h(this);
        } else {
            hVar = i.a();
            System.arraycopy(this.a, this.b, hVar.a, 0, i);
        }
        hVar.c = hVar.b + i;
        this.b += i;
        this.g.a(hVar);
        return hVar;
    }

    public void b() {
        if (this.g == this) {
            throw new IllegalStateException();
        } else if (this.g.e) {
            int i = this.c - this.b;
            if (i <= (this.g.d ? 0 : this.g.b) + (8192 - this.g.c)) {
                a(this.g, i);
                a();
                i.a(this);
            }
        }
    }

    public void a(h hVar, int i) {
        if (hVar.e) {
            if (hVar.c + i > 8192) {
                if (hVar.d) {
                    throw new IllegalArgumentException();
                } else if ((hVar.c + i) - hVar.b > 8192) {
                    throw new IllegalArgumentException();
                } else {
                    System.arraycopy(hVar.a, hVar.b, hVar.a, 0, hVar.c - hVar.b);
                    hVar.c -= hVar.b;
                    hVar.b = 0;
                }
            }
            System.arraycopy(this.a, this.b, hVar.a, hVar.c, i);
            hVar.c += i;
            this.b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
