package c.b.a.e;

class l implements d, k {
    private final k a;

    static d a(k kVar) {
        if (kVar instanceof f) {
            return ((f) kVar).a();
        }
        if (kVar instanceof d) {
            return (d) kVar;
        }
        if (kVar == null) {
            return null;
        }
        return new l(kVar);
    }

    private l(k kVar) {
        this.a = kVar;
    }

    public int estimateParsedLength() {
        return this.a.estimateParsedLength();
    }

    public int parseInto(e eVar, CharSequence charSequence, int i) {
        return this.a.parseInto(eVar, charSequence, i);
    }

    public int a(e eVar, String str, int i) {
        return this.a.parseInto(eVar, str, i);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        return this.a.equals(((l) obj).a);
    }
}
