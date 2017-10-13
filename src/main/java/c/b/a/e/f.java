package c.b.a.e;

class f implements k {
    private final d a;

    static k a(d dVar) {
        if (dVar instanceof l) {
            return (k) dVar;
        }
        if (dVar == null) {
            return null;
        }
        return new f(dVar);
    }

    private f(d dVar) {
        this.a = dVar;
    }

    d a() {
        return this.a;
    }

    public int estimateParsedLength() {
        return this.a.estimateParsedLength();
    }

    public int parseInto(e eVar, CharSequence charSequence, int i) {
        return this.a.a(eVar, charSequence.toString(), i);
    }
}
