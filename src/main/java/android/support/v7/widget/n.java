package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.b.a.k;
import android.support.v7.g.a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class n {
    final TextView a;
    private ax b;
    private ax c;
    private ax d;
    private ax e;

    static n a(TextView textView) {
        if (VERSION.SDK_INT >= 17) {
            return new o(textView);
        }
        return new n(textView);
    }

    n(TextView textView) {
        this.a = textView;
    }

    void a(AttributeSet attributeSet, int i) {
        boolean z;
        Context context = this.a.getContext();
        i a = i.a();
        az a2 = az.a(context, attributeSet, k.AppCompatTextHelper, i, 0);
        int g = a2.g(k.AppCompatTextHelper_android_textAppearance, -1);
        if (a2.f(1)) {
            this.b = a(context, a, a2.g(k.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a2.f(2)) {
            this.c = a(context, a, a2.g(k.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a2.f(3)) {
            this.d = a(context, a, a2.g(k.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a2.f(4)) {
            this.e = a(context, a, a2.g(k.AppCompatTextHelper_android_drawableBottom, 0));
        }
        a2.a();
        boolean z2 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        ColorStateList colorStateList = null;
        boolean z3;
        if (g != -1) {
            az a3 = az.a(context, g, k.TextAppearance);
            if (z2 || !a3.f(k.TextAppearance_textAllCaps)) {
                z3 = false;
                z = false;
            } else {
                z = a3.a(k.TextAppearance_textAllCaps, false);
                int i2 = 1;
            }
            if (VERSION.SDK_INT < 23 && a3.f(k.TextAppearance_android_textColor)) {
                colorStateList = a3.d(k.TextAppearance_android_textColor);
            }
            a3.a();
        } else {
            z3 = false;
            z = false;
        }
        az a4 = az.a(context, attributeSet, k.TextAppearance, i, 0);
        if (!z2 && a4.f(k.TextAppearance_textAllCaps)) {
            z = a4.a(k.TextAppearance_textAllCaps, false);
            i2 = 1;
        }
        if (VERSION.SDK_INT < 23 && a4.f(k.TextAppearance_android_textColor)) {
            colorStateList = a4.d(k.TextAppearance_android_textColor);
        }
        a4.a();
        if (colorStateList != null) {
            this.a.setTextColor(colorStateList);
        }
        if (!z2 && r0 != 0) {
            a(z);
        }
    }

    void a(Context context, int i) {
        az a = az.a(context, i, k.TextAppearance);
        if (a.f(k.TextAppearance_textAllCaps)) {
            a(a.a(k.TextAppearance_textAllCaps, false));
        }
        if (VERSION.SDK_INT < 23 && a.f(k.TextAppearance_android_textColor)) {
            ColorStateList d = a.d(k.TextAppearance_android_textColor);
            if (d != null) {
                this.a.setTextColor(d);
            }
        }
        a.a();
    }

    void a(boolean z) {
        this.a.setTransformationMethod(z ? new a(this.a.getContext()) : null);
    }

    void a() {
        if (this.b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
    }

    final void a(Drawable drawable, ax axVar) {
        if (drawable != null && axVar != null) {
            i.a(drawable, axVar, this.a.getDrawableState());
        }
    }

    protected static ax a(Context context, i iVar, int i) {
        ColorStateList b = iVar.b(context, i);
        if (b == null) {
            return null;
        }
        ax axVar = new ax();
        axVar.d = true;
        axVar.a = b;
        return axVar;
    }
}
