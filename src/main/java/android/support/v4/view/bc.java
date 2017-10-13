package android.support.v4.view;

import android.view.WindowInsets;

class bc extends bb {
    private final WindowInsets a;

    bc(WindowInsets windowInsets) {
        this.a = windowInsets;
    }

    public int a() {
        return this.a.getSystemWindowInsetLeft();
    }

    public int b() {
        return this.a.getSystemWindowInsetTop();
    }

    public int c() {
        return this.a.getSystemWindowInsetRight();
    }

    public int d() {
        return this.a.getSystemWindowInsetBottom();
    }

    public boolean e() {
        return this.a.isConsumed();
    }

    public bb a(int i, int i2, int i3, int i4) {
        return new bc(this.a.replaceSystemWindowInsets(i, i2, i3, i4));
    }

    WindowInsets f() {
        return this.a;
    }
}
