package com.cocosw.bottomsheet;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ah;
import android.support.v4.widget.t;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;

class ClosableSlidingLayout extends FrameLayout {
    View a;
    boolean b;
    private final float c;
    private t d;
    private a e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private float j;
    private boolean k;
    private float l;

    interface a {
        void a();

        void b();
    }

    private class b extends android.support.v4.widget.t.a {
        final /* synthetic */ ClosableSlidingLayout a;

        private b(ClosableSlidingLayout closableSlidingLayout) {
            this.a = closableSlidingLayout;
        }

        public boolean b(View view, int i) {
            return true;
        }

        public void a(View view, float f, float f2) {
            if (f2 > this.a.c) {
                this.a.b(view, f2);
            } else if (view.getTop() >= this.a.g + (this.a.f / 2)) {
                this.a.b(view, f2);
            } else {
                this.a.d.a(view, 0, this.a.g);
                ah.d(this.a);
            }
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            if (VERSION.SDK_INT < 11) {
                this.a.invalidate();
            }
            if (this.a.f - i2 < 1 && this.a.e != null) {
                this.a.d.c();
                this.a.e.a();
                this.a.d.a(view, 0, i2);
            }
        }

        public int b(View view, int i, int i2) {
            return Math.max(i, this.a.g);
        }
    }

    public ClosableSlidingLayout(Context context) {
        this(context, null);
    }

    public ClosableSlidingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @TargetApi(11)
    public ClosableSlidingLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = true;
        this.k = false;
        this.d = t.a((ViewGroup) this, 0.8f, new b());
        this.c = getResources().getDisplayMetrics().density * 400.0f;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int a = android.support.v4.view.t.a(motionEvent);
        if (!isEnabled() || a()) {
            return false;
        }
        if (a == 3 || a == 1) {
            this.h = -1;
            this.i = false;
            if (this.k && (-this.l) > ((float) this.d.b())) {
                a(this.d.a(), 0.0f);
            }
            this.d.c();
            return false;
        }
        float a2;
        switch (a) {
            case 0:
                this.f = getChildAt(0).getHeight();
                this.g = getChildAt(0).getTop();
                this.h = android.support.v4.view.t.b(motionEvent, 0);
                this.i = false;
                a2 = a(motionEvent, this.h);
                if (a2 != -1.0f) {
                    this.j = a2;
                    this.l = 0.0f;
                    break;
                }
                return false;
            case 2:
                if (this.h == -1) {
                    return false;
                }
                a2 = a(motionEvent, this.h);
                if (a2 != -1.0f) {
                    this.l = a2 - this.j;
                    if (this.b && this.l > ((float) this.d.b()) && !this.i) {
                        this.i = true;
                        this.d.a(getChildAt(0), 0);
                        break;
                    }
                }
                return false;
        }
        this.d.a(motionEvent);
        return this.i;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    private boolean a() {
        boolean z = true;
        if (VERSION.SDK_INT >= 14) {
            return ah.b(this.a, -1);
        }
        if (this.a instanceof AbsListView) {
            AbsListView absListView = (AbsListView) this.a;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        } else {
            if (this.a.getScrollY() <= 0) {
                z = false;
            }
            return z;
        }
    }

    private float a(MotionEvent motionEvent, int i) {
        int a = android.support.v4.view.t.a(motionEvent, i);
        if (a < 0) {
            return -1.0f;
        }
        return android.support.v4.view.t.d(motionEvent, a);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || a()) {
            return super.onTouchEvent(motionEvent);
        }
        try {
            if (this.b) {
                this.d.b(motionEvent);
            }
        } catch (Exception e) {
        }
        return true;
    }

    public void computeScroll() {
        if (this.d.a(true)) {
            ah.d(this);
        }
    }

    void a(a aVar) {
        this.e = aVar;
    }

    void a(boolean z) {
        this.k = z;
    }

    private void a(View view, float f) {
        if (this.e != null) {
            this.e.b();
        }
    }

    private void b(View view, float f) {
        this.d.a(view, 0, this.g + this.f);
        ah.d(this);
    }
}
