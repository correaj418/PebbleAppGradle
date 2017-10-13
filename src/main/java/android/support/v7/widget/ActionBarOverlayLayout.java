package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.aa;
import android.support.v4.view.ah;
import android.support.v4.view.aw;
import android.support.v4.view.az;
import android.support.v4.view.ba;
import android.support.v4.view.z;
import android.support.v4.widget.q;
import android.support.v7.b.a.f;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;

public class ActionBarOverlayLayout extends ViewGroup implements z {
    static final int[] a = new int[]{android.support.v7.b.a.a.actionBarSize, 16842841};
    private final Runnable A;
    private final aa B;
    private int b;
    private int c;
    private ContentFrameLayout d;
    private ActionBarContainer e;
    private w f;
    private Drawable g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private final Rect o;
    private final Rect p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private a u;
    private final int v;
    private q w;
    private aw x;
    private final az y;
    private final Runnable z;

    public interface a {
        void a();

        void a(int i);

        void a(boolean z);

        void b();

        void c();

        void d();
    }

    public static class b extends MarginLayoutParams {
        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return a();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.v = 600;
        this.y = new ba(this) {
            final /* synthetic */ ActionBarOverlayLayout a;

            {
                this.a = r1;
            }

            public void b(View view) {
                this.a.x = null;
                this.a.l = false;
            }

            public void c(View view) {
                this.a.x = null;
                this.a.l = false;
            }
        };
        this.z = new Runnable(this) {
            final /* synthetic */ ActionBarOverlayLayout a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.c();
                this.a.x = ah.p(this.a.e).c(0.0f).a(this.a.y);
            }
        };
        this.A = new Runnable(this) {
            final /* synthetic */ ActionBarOverlayLayout a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.c();
                this.a.x = ah.p(this.a.e).c((float) (-this.a.e.getHeight())).a(this.a.y);
            }
        };
        a(context);
        this.B = new aa(this);
    }

    private void a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(a);
        this.b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.g = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.g == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.h = z;
        this.w = q.a(context);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public void setActionBarVisibilityCallback(a aVar) {
        this.u = aVar;
        if (getWindowToken() != null) {
            this.u.a(this.c);
            if (this.n != 0) {
                onWindowSystemUiVisibilityChanged(this.n);
                ah.s(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.i = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.h = z2;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.j = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        a(getContext());
        ah.s(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z;
        boolean z2 = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        b();
        int i2 = this.n ^ i;
        this.n = i;
        boolean z3 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.u != null) {
            a aVar = this.u;
            if (z) {
                z2 = false;
            }
            aVar.a(z2);
            if (z3 || !z) {
                this.u.a();
            } else {
                this.u.b();
            }
        }
        if ((i2 & 256) != 0 && this.u != null) {
            ah.s(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.c = i;
        if (this.u != null) {
            this.u.a(i);
        }
    }

    private boolean a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        b bVar = (b) view.getLayoutParams();
        if (z && bVar.leftMargin != rect.left) {
            bVar.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && bVar.topMargin != rect.top) {
            bVar.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && bVar.rightMargin != rect.right) {
            bVar.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || bVar.bottomMargin == rect.bottom) {
            return z5;
        }
        bVar.bottomMargin = rect.bottom;
        return true;
    }

    protected boolean fitSystemWindows(Rect rect) {
        boolean a;
        b();
        if ((ah.r(this) & 256) != 0) {
            a = a(this.e, rect, true, true, false, true);
            this.r.set(rect);
            bd.a(this, this.r, this.o);
        } else {
            a = a(this.e, rect, true, true, false, true);
            this.r.set(rect);
            bd.a(this, this.r, this.o);
        }
        if (!this.p.equals(this.o)) {
            this.p.set(this.o);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    protected b a() {
        return new b(-1, -1);
    }

    public b a(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    protected void onMeasure(int i, int i2) {
        Object obj;
        int i3;
        b();
        measureChildWithMargins(this.e, i, 0, i2, 0);
        b bVar = (b) this.e.getLayoutParams();
        int max = Math.max(0, (this.e.getMeasuredWidth() + bVar.leftMargin) + bVar.rightMargin);
        int max2 = Math.max(0, bVar.bottomMargin + (this.e.getMeasuredHeight() + bVar.topMargin));
        int a = bd.a(0, ah.j(this.e));
        if ((ah.r(this) & 256) != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i3 = this.b;
            if (this.j && this.e.getTabContainer() != null) {
                i3 += this.b;
            }
        } else {
            i3 = this.e.getVisibility() != 8 ? this.e.getMeasuredHeight() : 0;
        }
        this.q.set(this.o);
        this.s.set(this.r);
        Rect rect;
        Rect rect2;
        if (this.i || obj != null) {
            rect = this.s;
            rect.top = i3 + rect.top;
            rect2 = this.s;
            rect2.bottom += 0;
        } else {
            rect = this.q;
            rect.top = i3 + rect.top;
            rect2 = this.q;
            rect2.bottom += 0;
        }
        a(this.d, this.q, true, true, true, true);
        if (!this.t.equals(this.s)) {
            this.t.set(this.s);
            this.d.a(this.s);
        }
        measureChildWithMargins(this.d, i, 0, i2, 0);
        bVar = (b) this.d.getLayoutParams();
        int max3 = Math.max(max, (this.d.getMeasuredWidth() + bVar.leftMargin) + bVar.rightMargin);
        i3 = Math.max(max2, bVar.bottomMargin + (this.d.getMeasuredHeight() + bVar.topMargin));
        int a2 = bd.a(a, ah.j(this.d));
        setMeasuredDimension(ah.a(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, a2), ah.a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, a2 << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        paddingRight = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                int i6 = bVar.leftMargin + paddingLeft;
                paddingRight = bVar.topMargin + paddingTop;
                childAt.layout(i6, paddingRight, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + paddingRight);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.g != null && !this.h) {
            int bottom = this.e.getVisibility() == 0 ? (int) ((((float) this.e.getBottom()) + ah.l(this.e)) + 0.5f) : 0;
            this.g.setBounds(0, bottom, getWidth(), this.g.getIntrinsicHeight() + bottom);
            this.g.draw(canvas);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.e.getVisibility() != 0) {
            return false;
        }
        return this.k;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.B.a(view, view2, i);
        this.m = getActionBarHideOffset();
        c();
        if (this.u != null) {
            this.u.c();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.m += i2;
        setActionBarHideOffset(this.m);
    }

    public void onStopNestedScroll(View view) {
        if (this.k && !this.l) {
            if (this.m <= this.e.getHeight()) {
                d();
            } else {
                e();
            }
        }
        if (this.u != null) {
            this.u.d();
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.k || !z) {
            return false;
        }
        if (a(f, f2)) {
            g();
        } else {
            f();
        }
        this.l = true;
        return true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.B.a();
    }

    void b() {
        if (this.d == null) {
            this.d = (ContentFrameLayout) findViewById(f.action_bar_activity_content);
            this.e = (ActionBarContainer) findViewById(f.action_bar_container);
            this.f = a(findViewById(f.action_bar));
        }
    }

    private w a(View view) {
        if (view instanceof w) {
            return (w) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.k) {
            this.k = z;
            if (!z) {
                c();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        return this.e != null ? -((int) ah.l(this.e)) : 0;
    }

    public void setActionBarHideOffset(int i) {
        c();
        ah.b(this.e, (float) (-Math.max(0, Math.min(i, this.e.getHeight()))));
    }

    private void c() {
        removeCallbacks(this.z);
        removeCallbacks(this.A);
        if (this.x != null) {
            this.x.a();
        }
    }

    private void d() {
        c();
        postDelayed(this.z, 600);
    }

    private void e() {
        c();
        postDelayed(this.A, 600);
    }

    private void f() {
        c();
        this.z.run();
    }

    private void g() {
        c();
        this.A.run();
    }

    private boolean a(float f, float f2) {
        this.w.a(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.w.e() > this.e.getHeight()) {
            return true;
        }
        return false;
    }

    public void setWindowCallback(Callback callback) {
        b();
        this.f.a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        b();
        this.f.a(charSequence);
    }

    public CharSequence getTitle() {
        b();
        return this.f.a();
    }

    public void setUiOptions(int i) {
    }

    public void setIcon(int i) {
        b();
        this.f.a(i);
    }

    public void setIcon(Drawable drawable) {
        b();
        this.f.a(drawable);
    }

    public void setLogo(int i) {
        b();
        this.f.b(i);
    }
}
