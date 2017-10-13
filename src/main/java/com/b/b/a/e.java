package com.b.b.a;

import com.b.a.f.f;

class e extends f<String, b> {
    private i<String, b> a = new i();

    protected /* synthetic */ long a(Object obj, Object obj2) {
        return b((String) obj, (b) obj2);
    }

    public void a(String str, b bVar) {
        this.a.a(str, bVar);
    }

    public e(int i) {
        super((long) i);
    }

    protected long b(String str, b bVar) {
        return (long) bVar.a();
    }

    public b a(String str) {
        b bVar = (b) a((Object) str);
        if (bVar == null) {
            bVar = (b) this.a.b(str);
            if (bVar != null) {
                b(str, bVar);
            }
        }
        return bVar;
    }

    protected void a(boolean z, String str, b bVar, b bVar2) {
        super.a(z, str, bVar, bVar2);
        if (z) {
            this.a.a(str, bVar);
        }
    }
}
