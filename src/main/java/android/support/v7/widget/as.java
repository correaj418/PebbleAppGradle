package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.e;
import android.support.v7.widget.RecyclerView.e.c;
import android.support.v7.widget.RecyclerView.u;
import android.view.View;

public abstract class as extends e {
    boolean a = true;

    public abstract boolean a(u uVar);

    public abstract boolean a(u uVar, int i, int i2, int i3, int i4);

    public abstract boolean a(u uVar, u uVar2, int i, int i2, int i3, int i4);

    public abstract boolean b(u uVar);

    public boolean g(u uVar) {
        return !this.a || uVar.n();
    }

    public boolean a(u uVar, c cVar, c cVar2) {
        int i = cVar.a;
        int i2 = cVar.b;
        View view = uVar.a;
        int left = cVar2 == null ? view.getLeft() : cVar2.a;
        int top = cVar2 == null ? view.getTop() : cVar2.b;
        if (uVar.q() || (i == left && i2 == top)) {
            return a(uVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(uVar, i, i2, left, top);
    }

    public boolean b(u uVar, c cVar, c cVar2) {
        if (cVar == null || (cVar.a == cVar2.a && cVar.b == cVar2.b)) {
            return b(uVar);
        }
        return a(uVar, cVar.a, cVar.b, cVar2.a, cVar2.b);
    }

    public boolean c(u uVar, c cVar, c cVar2) {
        if (cVar.a == cVar2.a && cVar.b == cVar2.b) {
            i(uVar);
            return false;
        }
        return a(uVar, cVar.a, cVar.b, cVar2.a, cVar2.b);
    }

    public boolean a(u uVar, u uVar2, c cVar, c cVar2) {
        int i;
        int i2;
        int i3 = cVar.a;
        int i4 = cVar.b;
        if (uVar2.c()) {
            i = cVar.a;
            i2 = cVar.b;
        } else {
            i = cVar2.a;
            i2 = cVar2.b;
        }
        return a(uVar, uVar2, i3, i4, i, i2);
    }

    public final void h(u uVar) {
        o(uVar);
        e(uVar);
    }

    public final void i(u uVar) {
        s(uVar);
        e(uVar);
    }

    public final void j(u uVar) {
        q(uVar);
        e(uVar);
    }

    public final void a(u uVar, boolean z) {
        d(uVar, z);
        e(uVar);
    }

    public final void k(u uVar) {
        n(uVar);
    }

    public final void l(u uVar) {
        r(uVar);
    }

    public final void m(u uVar) {
        p(uVar);
    }

    public final void b(u uVar, boolean z) {
        c(uVar, z);
    }

    public void n(u uVar) {
    }

    public void o(u uVar) {
    }

    public void p(u uVar) {
    }

    public void q(u uVar) {
    }

    public void r(u uVar) {
    }

    public void s(u uVar) {
    }

    public void c(u uVar, boolean z) {
    }

    public void d(u uVar, boolean z) {
    }
}
