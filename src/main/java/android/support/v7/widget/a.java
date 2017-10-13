package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.aw;
import android.support.v4.view.az;
import android.support.v4.view.t;
import android.support.v7.b.a.k;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

abstract class a extends ViewGroup {
    protected final a a;
    protected final Context b;
    protected ActionMenuView c;
    protected d d;
    protected int e;
    protected aw f;
    private boolean g;
    private boolean h;

    protected class a implements az {
        int a;
        final /* synthetic */ a b;
        private boolean c = false;

        protected a(a aVar) {
            this.b = aVar;
        }

        public void a(View view) {
            super.setVisibility(0);
            this.c = false;
        }

        public void b(View view) {
            if (!this.c) {
                this.b.f = null;
                super.setVisibility(this.a);
            }
        }

        public void c(View view) {
            this.c = true;
        }
    }

    a(Context context) {
        this(context, null);
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new a(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(android.support.v7.b.a.a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.b = context;
        } else {
            this.b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, k.ActionBar, android.support.v7.b.a.a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(k.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.d != null) {
            this.d.a(configuration);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = t.a(motionEvent);
        if (a == 0) {
            this.g = false;
        }
        if (!this.g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.g = true;
            }
        }
        if (a == 1 || a == 3) {
            this.g = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = t.a(motionEvent);
        if (a == 9) {
            this.h = false;
        }
        if (!this.h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.h = true;
            }
        }
        if (a == 10 || a == 3) {
            this.h = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.e = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.e;
    }

    public int getAnimatedVisibility() {
        if (this.f != null) {
            return this.a.a;
        }
        return getVisibility();
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f != null) {
                this.f.a();
            }
            super.setVisibility(i);
        }
    }

    protected int a(View view, int i, int i2, int i3) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected static int a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
