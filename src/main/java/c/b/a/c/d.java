package c.b.a.c;

public final class d {
    private static d a;
    private e b = new e(new c[]{o.a, s.a, b.a, f.a, j.a, k.a});
    private e c = new e(new c[]{q.a, o.a, s.a, b.a, f.a, j.a, k.a});
    private e d = new e(new c[]{n.a, p.a, s.a, j.a, k.a});
    private e e = new e(new c[]{n.a, r.a, p.a, s.a, k.a});
    private e f = new e(new c[]{p.a, s.a, k.a});

    public static d a() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    protected d() {
    }

    public h a(Object obj) {
        h hVar = (h) this.b.a(obj == null ? null : obj.getClass());
        if (hVar != null) {
            return hVar;
        }
        throw new IllegalArgumentException("No instant converter found for type: " + (obj == null ? "null" : obj.getClass().getName()));
    }

    public String toString() {
        return "ConverterManager[" + this.b.a() + " instant," + this.c.a() + " partial," + this.d.a() + " duration," + this.e.a() + " period," + this.f.a() + " interval]";
    }
}
