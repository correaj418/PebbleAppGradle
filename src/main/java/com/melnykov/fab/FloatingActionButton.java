package com.melnykov.fab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewOutlineProvider;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageButton;
import com.melnykov.fab.a.a;
import com.melnykov.fab.a.b;
import com.melnykov.fab.a.c;
import com.melnykov.fab.a.d;

public class FloatingActionButton extends ImageButton {
    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private final Interpolator k;

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = new AccelerateDecelerateInterpolator();
        a(context, attributeSet);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = new AccelerateDecelerateInterpolator();
        a(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int c = c(this.g == 0 ? b.fab_size_normal : b.fab_size_mini);
        if (this.f && !c()) {
            c += this.h * 2;
            b();
        }
        setMeasuredDimension(c, c);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.a = true;
        this.b = b(a.material_blue_500);
        this.c = d(this.b);
        this.d = e(this.b);
        this.e = b(17170432);
        this.g = 0;
        this.f = true;
        this.i = getResources().getDimensionPixelOffset(b.fab_scroll_threshold);
        this.h = c(b.fab_shadow_size);
        if (attributeSet != null) {
            b(context, attributeSet);
        }
        a();
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray a = a(context, attributeSet, d.FloatingActionButton);
        if (a != null) {
            try {
                this.b = a.getColor(d.FloatingActionButton_fab_colorNormal, b(a.material_blue_500));
                this.c = a.getColor(d.FloatingActionButton_fab_colorPressed, d(this.b));
                this.d = a.getColor(d.FloatingActionButton_fab_colorRipple, e(this.b));
                this.e = a.getColor(d.FloatingActionButton_fab_colorDisabled, this.e);
                this.f = a.getBoolean(d.FloatingActionButton_fab_shadow, true);
                this.g = a.getInt(d.FloatingActionButton_fab_type, 0);
            } finally {
                a.recycle();
            }
        }
    }

    private void a() {
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, a(this.c));
        stateListDrawable.addState(new int[]{-16842910}, a(this.e));
        stateListDrawable.addState(new int[0], a(this.b));
        setBackgroundCompat(stateListDrawable);
    }

    private Drawable a(int i) {
        Drawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(i);
        if (!this.f || c()) {
            return shapeDrawable;
        }
        Resources resources = getResources();
        int i2 = this.g == 0 ? c.fab_shadow : c.fab_shadow_mini;
        Drawable layerDrawable = new LayerDrawable(new Drawable[]{resources.getDrawable(i2), shapeDrawable});
        layerDrawable.setLayerInset(1, this.h, this.h, this.h, this.h);
        return layerDrawable;
    }

    private TypedArray a(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private int b(int i) {
        return getResources().getColor(i);
    }

    private int c(int i) {
        return getResources().getDimensionPixelSize(i);
    }

    private void b() {
        if (!this.j && (getLayoutParams() instanceof MarginLayoutParams)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin - this.h, marginLayoutParams.topMargin - this.h, marginLayoutParams.rightMargin - this.h, marginLayoutParams.bottomMargin - this.h);
            requestLayout();
            this.j = true;
        }
    }

    @SuppressLint({"NewApi"})
    private void setBackgroundCompat(Drawable drawable) {
        float f = 0.0f;
        if (c()) {
            if (this.f) {
                if (getElevation() > 0.0f) {
                    f = getElevation();
                } else {
                    f = (float) c(b.fab_elevation_lollipop);
                }
            }
            setElevation(f);
            Drawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{this.d}), drawable, null);
            setOutlineProvider(new ViewOutlineProvider(this) {
                final /* synthetic */ FloatingActionButton a;

                {
                    this.a = r1;
                }

                public void getOutline(View view, Outline outline) {
                    int a = this.a.c(this.a.g == 0 ? b.fab_size_normal : b.fab_size_mini);
                    outline.setOval(0, 0, a, a);
                }
            });
            setClipToOutline(true);
            setBackground(rippleDrawable);
        } else if (d()) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    private int getMarginBottom() {
        LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            return ((MarginLayoutParams) layoutParams).bottomMargin;
        }
        return 0;
    }

    public void setColorNormal(int i) {
        if (i != this.b) {
            this.b = i;
            a();
        }
    }

    public void setColorNormalResId(int i) {
        setColorNormal(b(i));
    }

    public int getColorNormal() {
        return this.b;
    }

    public void setColorPressed(int i) {
        if (i != this.c) {
            this.c = i;
            a();
        }
    }

    public void setColorPressedResId(int i) {
        setColorPressed(b(i));
    }

    public int getColorPressed() {
        return this.c;
    }

    public void setColorRipple(int i) {
        if (i != this.d) {
            this.d = i;
            a();
        }
    }

    public void setColorRippleResId(int i) {
        setColorRipple(b(i));
    }

    public int getColorRipple() {
        return this.d;
    }

    public void setShadow(boolean z) {
        if (z != this.f) {
            this.f = z;
            a();
        }
    }

    public void setType(int i) {
        if (i != this.g) {
            this.g = i;
            a();
        }
    }

    public int getType() {
        return this.g;
    }

    private boolean c() {
        return VERSION.SDK_INT >= 21;
    }

    private boolean d() {
        return VERSION.SDK_INT >= 16;
    }

    private static int d(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[2] = fArr[2] * 0.9f;
        return Color.HSVToColor(fArr);
    }

    private static int e(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[2] = fArr[2] * 1.1f;
        return Color.HSVToColor(fArr);
    }
}
