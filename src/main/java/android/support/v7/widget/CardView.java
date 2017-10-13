package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.c.a.a;
import android.support.v7.c.a.c;
import android.support.v7.c.a.d;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView extends FrameLayout {
    private static final int[] a = new int[]{16842801};
    private static final t b;
    private boolean c;
    private boolean d;
    private int e;
    private int f;
    private final Rect g = new Rect();
    private final Rect h = new Rect();
    private final r i = new r(this) {
        final /* synthetic */ CardView a;
        private Drawable b;

        {
            this.a = r1;
        }

        public void a(Drawable drawable) {
            this.b = drawable;
            this.a.setBackgroundDrawable(drawable);
        }

        public boolean a() {
            return this.a.getUseCompatPadding();
        }

        public boolean b() {
            return this.a.getPreventCornerOverlap();
        }

        public void a(int i, int i2, int i3, int i4) {
            this.a.h.set(i, i2, i3, i4);
            super.setPadding(this.a.g.left + i, this.a.g.top + i2, this.a.g.right + i3, this.a.g.bottom + i4);
        }

        public void a(int i, int i2) {
            if (i > this.a.e) {
                super.setMinimumWidth(i);
            }
            if (i2 > this.a.f) {
                super.setMinimumHeight(i2);
            }
        }

        public Drawable c() {
            return this.b;
        }

        public View d() {
            return this.a;
        }
    };

    static {
        if (VERSION.SDK_INT >= 21) {
            b = new q();
        } else if (VERSION.SDK_INT >= 17) {
            b = new u();
        } else {
            b = new s();
        }
        b.a();
    }

    public CardView(Context context) {
        super(context);
        a(context, null, 0);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public boolean getUseCompatPadding() {
        return this.c;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.c != z) {
            this.c = z;
            b.g(this.i);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (b instanceof q) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) b.b(this.i)), MeasureSpec.getSize(i)), mode);
                break;
        }
        mode = MeasureSpec.getMode(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) b.c(this.i)), MeasureSpec.getSize(i2)), mode);
                break;
        }
        super.onMeasure(i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        int color;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.CardView, i, c.CardView);
        if (obtainStyledAttributes.hasValue(d.CardView_cardBackgroundColor)) {
            colorStateList = obtainStyledAttributes.getColorStateList(d.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(a);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(a.cardview_light_background);
            } else {
                color = getResources().getColor(a.cardview_dark_background);
            }
            colorStateList = ColorStateList.valueOf(color);
        }
        float dimension = obtainStyledAttributes.getDimension(d.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(d.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(d.CardView_cardMaxElevation, 0.0f);
        this.c = obtainStyledAttributes.getBoolean(d.CardView_cardUseCompatPadding, false);
        this.d = obtainStyledAttributes.getBoolean(d.CardView_cardPreventCornerOverlap, true);
        color = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPadding, 0);
        this.g.left = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingLeft, color);
        this.g.top = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingTop, color);
        this.g.right = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingRight, color);
        this.g.bottom = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingBottom, color);
        if (dimension2 > dimension3) {
            dimension3 = dimension2;
        }
        this.e = obtainStyledAttributes.getDimensionPixelSize(d.CardView_android_minWidth, 0);
        this.f = obtainStyledAttributes.getDimensionPixelSize(d.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        b.a(this.i, context, colorStateList, dimension, dimension2, dimension3);
    }

    public void setMinimumWidth(int i) {
        this.e = i;
        super.setMinimumWidth(i);
    }

    public void setMinimumHeight(int i) {
        this.f = i;
        super.setMinimumHeight(i);
    }

    public void setCardBackgroundColor(int i) {
        b.a(this.i, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        b.a(this.i, colorStateList);
    }

    public ColorStateList getCardBackgroundColor() {
        return b.i(this.i);
    }

    public int getContentPaddingLeft() {
        return this.g.left;
    }

    public int getContentPaddingRight() {
        return this.g.right;
    }

    public int getContentPaddingTop() {
        return this.g.top;
    }

    public int getContentPaddingBottom() {
        return this.g.bottom;
    }

    public void setRadius(float f) {
        b.a(this.i, f);
    }

    public float getRadius() {
        return b.d(this.i);
    }

    public void setCardElevation(float f) {
        b.c(this.i, f);
    }

    public float getCardElevation() {
        return b.e(this.i);
    }

    public void setMaxCardElevation(float f) {
        b.b(this.i, f);
    }

    public float getMaxCardElevation() {
        return b.a(this.i);
    }

    public boolean getPreventCornerOverlap() {
        return this.d;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.d) {
            this.d = z;
            b.h(this.i);
        }
    }
}
