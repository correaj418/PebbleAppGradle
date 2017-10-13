package com.b.a;

public class u extends j {
    static final /* synthetic */ boolean h = (!u.class.desiredAssertionStatus());

    public u(p pVar) {
        super(pVar);
        a(0);
    }

    public k b(k kVar) {
        return kVar;
    }

    public final void a(k kVar) {
        if (!b() || d() == Integer.MAX_VALUE) {
            k b = b(kVar);
            if (h || kVar == null || b == kVar || kVar.c()) {
                super.a(b, true);
                if (kVar != null) {
                    kVar.m();
                    return;
                }
                return;
            }
            throw new AssertionError();
        }
    }
}
