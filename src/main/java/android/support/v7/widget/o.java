package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.b.a.k;
import android.util.AttributeSet;
import android.widget.TextView;

class o extends n {
    private ax b;
    private ax c;

    o(TextView textView) {
        super(textView);
    }

    void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        Context context = this.a.getContext();
        i a = i.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.AppCompatTextHelper, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.b = n.a(context, a, obtainStyledAttributes.getResourceId(k.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.c = n.a(context, a, obtainStyledAttributes.getResourceId(k.AppCompatTextHelper_android_drawableEnd, 0));
        }
        obtainStyledAttributes.recycle();
    }

    void a() {
        super.a();
        if (this.b != null || this.c != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.b);
            a(compoundDrawablesRelative[2], this.c);
        }
    }
}
