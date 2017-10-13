package android.support.v7.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;

public abstract class ak {
    protected final h a;
    final Rect b;
    private int c;

    public abstract int a(View view);

    public abstract void a(int i);

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public abstract int h();

    public abstract int i();

    private ak(h hVar) {
        this.c = Integer.MIN_VALUE;
        this.b = new Rect();
        this.a = hVar;
    }

    public void a() {
        this.c = f();
    }

    public int b() {
        return Integer.MIN_VALUE == this.c ? 0 : f() - this.c;
    }

    public static ak a(h hVar, int i) {
        switch (i) {
            case 0:
                return a(hVar);
            case 1:
                return b(hVar);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static ak a(h hVar) {
        return new ak(hVar) {
            public int d() {
                return this.a.w() - this.a.A();
            }

            public int e() {
                return this.a.w();
            }

            public void a(int i) {
                this.a.j(i);
            }

            public int c() {
                return this.a.y();
            }

            public int e(View view) {
                i iVar = (i) view.getLayoutParams();
                return iVar.rightMargin + (this.a.f(view) + iVar.leftMargin);
            }

            public int f(View view) {
                i iVar = (i) view.getLayoutParams();
                return iVar.bottomMargin + (this.a.g(view) + iVar.topMargin);
            }

            public int b(View view) {
                i iVar = (i) view.getLayoutParams();
                return iVar.rightMargin + this.a.j(view);
            }

            public int a(View view) {
                return this.a.h(view) - ((i) view.getLayoutParams()).leftMargin;
            }

            public int c(View view) {
                this.a.a(view, true, this.b);
                return this.b.right;
            }

            public int d(View view) {
                this.a.a(view, true, this.b);
                return this.b.left;
            }

            public int f() {
                return (this.a.w() - this.a.y()) - this.a.A();
            }

            public int g() {
                return this.a.A();
            }

            public int h() {
                return this.a.u();
            }

            public int i() {
                return this.a.v();
            }
        };
    }

    public static ak b(h hVar) {
        return new ak(hVar) {
            public int d() {
                return this.a.x() - this.a.B();
            }

            public int e() {
                return this.a.x();
            }

            public void a(int i) {
                this.a.k(i);
            }

            public int c() {
                return this.a.z();
            }

            public int e(View view) {
                i iVar = (i) view.getLayoutParams();
                return iVar.bottomMargin + (this.a.g(view) + iVar.topMargin);
            }

            public int f(View view) {
                i iVar = (i) view.getLayoutParams();
                return iVar.rightMargin + (this.a.f(view) + iVar.leftMargin);
            }

            public int b(View view) {
                i iVar = (i) view.getLayoutParams();
                return iVar.bottomMargin + this.a.k(view);
            }

            public int a(View view) {
                return this.a.i(view) - ((i) view.getLayoutParams()).topMargin;
            }

            public int c(View view) {
                this.a.a(view, true, this.b);
                return this.b.bottom;
            }

            public int d(View view) {
                this.a.a(view, true, this.b);
                return this.b.top;
            }

            public int f() {
                return (this.a.x() - this.a.z()) - this.a.B();
            }

            public int g() {
                return this.a.B();
            }

            public int h() {
                return this.a.v();
            }

            public int i() {
                return this.a.u();
            }
        };
    }
}
