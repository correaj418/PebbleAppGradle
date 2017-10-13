package com.getpebble.android.main.sections.mypebble.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.getpebble.android.main.sections.mypebble.view.SlidingTabLayout.d;

class b extends LinearLayout {
    private final int a;
    private final Paint b;
    private final int c;
    private final Paint d;
    private final int e;
    private int f;
    private float g;
    private d h;
    private final a i;

    private static class a implements d {
        private int[] a;

        private a() {
        }

        public final int a(int i) {
            return this.a[i % this.a.length];
        }

        void a(int... iArr) {
            this.a = iArr;
        }
    }

    b(Context context) {
        this(context, null);
    }

    b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        float f = getResources().getDisplayMetrics().density;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842800, typedValue, true);
        this.e = a(typedValue.data, (byte) 38);
        this.i = new a();
        this.i.a(-13388315);
        this.a = (int) (0.0f * f);
        this.b = new Paint();
        this.b.setColor(this.e);
        this.c = (int) (f * 3.0f);
        this.d = new Paint();
    }

    void a(d dVar) {
        this.h = dVar;
        invalidate();
    }

    void a(int... iArr) {
        this.h = null;
        this.i.a(iArr);
        invalidate();
    }

    void a(int i, float f) {
        this.f = i;
        this.g = f;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        int height = getHeight();
        int childCount = getChildCount();
        if (this.h != null) {
            d dVar = this.h;
        } else {
            Object obj = this.i;
        }
        if (childCount > 0) {
            int i;
            View childAt = getChildAt(this.f);
            int left = childAt.getLeft();
            childCount = childAt.getRight();
            int a = dVar.a(this.f);
            if (this.g <= 0.0f || this.f >= getChildCount() - 1) {
                i = childCount;
                childCount = left;
            } else {
                i = dVar.a(this.f + 1);
                if (a != i) {
                    a = a(i, a, this.g);
                }
                View childAt2 = getChildAt(this.f + 1);
                left = (int) ((((float) left) * (1.0f - this.g)) + (this.g * ((float) childAt2.getLeft())));
                i = (int) ((((float) childCount) * (1.0f - this.g)) + (((float) childAt2.getRight()) * this.g));
                childCount = left;
            }
            this.d.setColor(a);
            canvas.drawRect((float) childCount, (float) (height - this.c), (float) i, (float) height, this.d);
        }
        canvas.drawRect(0.0f, (float) (height - this.a), (float) getWidth(), (float) height, this.b);
    }

    private static int a(int i, byte b) {
        return Color.argb(b, Color.red(i), Color.green(i), Color.blue(i));
    }

    private static int a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.rgb((int) ((((float) Color.red(i)) * f) + (((float) Color.red(i2)) * f2)), (int) ((((float) Color.green(i)) * f) + (((float) Color.green(i2)) * f2)), (int) ((f2 * ((float) Color.blue(i2))) + (((float) Color.blue(i)) * f)));
    }
}
