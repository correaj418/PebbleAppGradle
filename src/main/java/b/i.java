package b;

final class i {
    static h a;
    static long b;

    private i() {
    }

    static h a() {
        synchronized (i.class) {
            if (a != null) {
                h hVar = a;
                a = hVar.f;
                hVar.f = null;
                b -= 8192;
                return hVar;
            }
            return new h();
        }
    }

    static void a(h hVar) {
        if (hVar.f != null || hVar.g != null) {
            throw new IllegalArgumentException();
        } else if (!hVar.d) {
            synchronized (i.class) {
                if (b + 8192 > 65536) {
                    return;
                }
                b += 8192;
                hVar.f = a;
                hVar.c = 0;
                hVar.b = 0;
                a = hVar;
            }
        }
    }
}
