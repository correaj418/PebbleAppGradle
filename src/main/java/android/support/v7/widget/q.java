package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

class q implements t {
    q() {
    }

    public void a(r rVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        rVar.a(new an(colorStateList, f));
        View d = rVar.d();
        d.setClipToOutline(true);
        d.setElevation(f2);
        b(rVar, f3);
    }

    public void a(r rVar, float f) {
        j(rVar).a(f);
    }

    public void a() {
    }

    public void b(r rVar, float f) {
        j(rVar).a(f, rVar.a(), rVar.b());
        f(rVar);
    }

    public float a(r rVar) {
        return j(rVar).a();
    }

    public float b(r rVar) {
        return d(rVar) * 2.0f;
    }

    public float c(r rVar) {
        return d(rVar) * 2.0f;
    }

    public float d(r rVar) {
        return j(rVar).b();
    }

    public void c(r rVar, float f) {
        rVar.d().setElevation(f);
    }

    public float e(r rVar) {
        return rVar.d().getElevation();
    }

    public void f(r rVar) {
        if (rVar.a()) {
            float a = a(rVar);
            float d = d(rVar);
            int ceil = (int) Math.ceil((double) ao.b(a, d, rVar.b()));
            int ceil2 = (int) Math.ceil((double) ao.a(a, d, rVar.b()));
            rVar.a(ceil, ceil2, ceil, ceil2);
            return;
        }
        rVar.a(0, 0, 0, 0);
    }

    public void g(r rVar) {
        b(rVar, a(rVar));
    }

    public void h(r rVar) {
        b(rVar, a(rVar));
    }

    public void a(r rVar, ColorStateList colorStateList) {
        j(rVar).a(colorStateList);
    }

    public ColorStateList i(r rVar) {
        return j(rVar).c();
    }

    private an j(r rVar) {
        return (an) rVar.c();
    }
}
