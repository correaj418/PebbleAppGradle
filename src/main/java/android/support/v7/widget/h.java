package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ah;
import android.support.v7.b.a.k;
import android.util.AttributeSet;
import android.view.View;

class h {
    private final View a;
    private final i b;
    private ax c;
    private ax d;
    private ax e;

    h(View view, i iVar) {
        this.a = view;
        this.b = iVar;
    }

    void a(AttributeSet attributeSet, int i) {
        az a = az.a(this.a.getContext(), attributeSet, k.ViewBackgroundHelper, i, 0);
        try {
            if (a.f(k.ViewBackgroundHelper_android_background)) {
                ColorStateList b = this.b.b(this.a.getContext(), a.g(k.ViewBackgroundHelper_android_background, -1));
                if (b != null) {
                    b(b);
                }
            }
            if (a.f(k.ViewBackgroundHelper_backgroundTint)) {
                ah.a(this.a, a.d(k.ViewBackgroundHelper_backgroundTint));
            }
            if (a.f(k.ViewBackgroundHelper_backgroundTintMode)) {
                ah.a(this.a, y.a(a.a(k.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            a.a();
        } catch (Throwable th) {
            a.a();
        }
    }

    void a(int i) {
        b(this.b != null ? this.b.b(this.a.getContext(), i) : null);
    }

    void a(Drawable drawable) {
        b(null);
    }

    void a(ColorStateList colorStateList) {
        if (this.d == null) {
            this.d = new ax();
        }
        this.d.a = colorStateList;
        this.d.d = true;
        c();
    }

    ColorStateList a() {
        return this.d != null ? this.d.a : null;
    }

    void a(Mode mode) {
        if (this.d == null) {
            this.d = new ax();
        }
        this.d.b = mode;
        this.d.c = true;
        c();
    }

    Mode b() {
        return this.d != null ? this.d.b : null;
    }

    void c() {
        Drawable background = this.a.getBackground();
        if (background == null) {
            return;
        }
        if (VERSION.SDK_INT != 21 || !b(background)) {
            if (this.d != null) {
                i.a(background, this.d, this.a.getDrawableState());
            } else if (this.c != null) {
                i.a(background, this.c, this.a.getDrawableState());
            }
        }
    }

    void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.c == null) {
                this.c = new ax();
            }
            this.c.a = colorStateList;
            this.c.d = true;
        } else {
            this.c = null;
        }
        c();
    }

    private boolean b(Drawable drawable) {
        if (this.e == null) {
            this.e = new ax();
        }
        ax axVar = this.e;
        axVar.a();
        ColorStateList v = ah.v(this.a);
        if (v != null) {
            axVar.d = true;
            axVar.a = v;
        }
        Mode w = ah.w(this.a);
        if (w != null) {
            axVar.c = true;
            axVar.b = w;
        }
        if (!axVar.d && !axVar.c) {
            return false;
        }
        i.a(drawable, axVar, this.a.getDrawableState());
        return true;
    }
}
