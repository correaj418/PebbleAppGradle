package android.support.v7.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.b.a.k;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public abstract class a {

    public static class a extends MarginLayoutParams {
        public int a;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ActionBarLayout);
            this.a = obtainStyledAttributes.getInt(k.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public a(int i, int i2) {
            super(i, i2);
            this.a = 0;
            this.a = 8388627;
        }

        public a(a aVar) {
            super(aVar);
            this.a = 0;
            this.a = aVar.a;
        }

        public a(LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
        }
    }

    @Deprecated
    public static abstract class b {
        public abstract Drawable a();

        public abstract CharSequence b();

        public abstract View c();

        public abstract void d();

        public abstract CharSequence e();
    }
}
