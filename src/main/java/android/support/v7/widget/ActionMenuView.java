package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.n;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends ad implements android.support.v7.view.menu.g.b, n {
    private g a;
    private Context b;
    private int c;
    private boolean d;
    private d e;
    private android.support.v7.view.menu.m.a f;
    private android.support.v7.view.menu.g.a g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private e l;

    public interface a {
        boolean c();

        boolean d();
    }

    private class b implements android.support.v7.view.menu.m.a {
        final /* synthetic */ ActionMenuView a;

        private b(ActionMenuView actionMenuView) {
            this.a = actionMenuView;
        }

        public void a(g gVar, boolean z) {
        }

        public boolean a(g gVar) {
            return false;
        }
    }

    public static class c extends android.support.v7.widget.ad.a {
        @ExportedProperty
        public boolean a;
        @ExportedProperty
        public int b;
        @ExportedProperty
        public int c;
        @ExportedProperty
        public boolean d;
        @ExportedProperty
        public boolean e;
        boolean f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.a = cVar.a;
        }

        public c(int i, int i2) {
            super(i, i2);
            this.a = false;
        }
    }

    private class d implements android.support.v7.view.menu.g.a {
        final /* synthetic */ ActionMenuView a;

        private d(ActionMenuView actionMenuView) {
            this.a = actionMenuView;
        }

        public boolean a(g gVar, MenuItem menuItem) {
            return this.a.l != null && this.a.l.a(menuItem);
        }

        public void a(g gVar) {
            if (this.a.g != null) {
                this.a.g.a(gVar);
            }
        }
    }

    public interface e {
        boolean a(MenuItem menuItem);
    }

    public /* synthetic */ android.support.v7.widget.ad.a b(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ android.support.v7.widget.ad.a b(LayoutParams layoutParams) {
        return a(layoutParams);
    }

    protected /* synthetic */ android.support.v7.widget.ad.a g() {
        return a();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return a();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.j = (int) (56.0f * f);
        this.k = (int) (f * 4.0f);
        this.b = context;
        this.c = 0;
    }

    public void setPopupTheme(int i) {
        if (this.c != i) {
            this.c = i;
            if (i == 0) {
                this.b = getContext();
            } else {
                this.b = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.c;
    }

    public void setPresenter(d dVar) {
        this.e = dVar;
        this.e.a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.e != null) {
            this.e.b(false);
            if (this.e.h()) {
                this.e.e();
                this.e.d();
            }
        }
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.l = eVar;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.h;
        this.h = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.h) {
            this.i = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.h || this.a == null || size == this.i)) {
            this.i = size;
            this.a.b(true);
        }
        int childCount = getChildCount();
        if (!this.h || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                c cVar = (c) getChildAt(i3).getLayoutParams();
                cVar.rightMargin = 0;
                cVar.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        c(i, i2);
    }

    private void c(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i3 = size - paddingLeft;
        int i4 = i3 / this.j;
        size = i3 % this.j;
        if (i4 == 0) {
            setMeasuredDimension(i3, 0);
            return;
        }
        Object obj;
        Object obj2;
        int i5 = this.j + (size / i4);
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        paddingLeft = 0;
        Object obj3 = null;
        long j = 0;
        int childCount = getChildCount();
        int i9 = 0;
        while (i9 < childCount) {
            int i10;
            long j2;
            int i11;
            int i12;
            int i13;
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 8) {
                i10 = paddingLeft;
                j2 = j;
                i11 = i6;
                i12 = i4;
                i4 = i7;
            } else {
                c cVar;
                boolean z = childAt instanceof ActionMenuItemView;
                i13 = paddingLeft + 1;
                if (z) {
                    childAt.setPadding(this.k, 0, this.k, 0);
                }
                cVar = (c) childAt.getLayoutParams();
                cVar.f = false;
                cVar.c = 0;
                cVar.b = 0;
                cVar.d = false;
                cVar.leftMargin = 0;
                cVar.rightMargin = 0;
                boolean z2 = z && ((ActionMenuItemView) childAt).b();
                cVar.e = z2;
                if (cVar.a) {
                    paddingLeft = 1;
                } else {
                    paddingLeft = i4;
                }
                int a = a(childAt, i5, paddingLeft, childMeasureSpec, paddingTop);
                i7 = Math.max(i7, a);
                if (cVar.d) {
                    paddingLeft = i8 + 1;
                } else {
                    paddingLeft = i8;
                }
                if (cVar.a) {
                    obj = 1;
                } else {
                    obj = obj3;
                }
                int i14 = i4 - a;
                i8 = Math.max(i6, childAt.getMeasuredHeight());
                if (a == 1) {
                    long j3 = ((long) (1 << i9)) | j;
                    i11 = i8;
                    i12 = i14;
                    i8 = paddingLeft;
                    obj3 = obj;
                    j2 = j3;
                    i4 = i7;
                    i10 = i13;
                } else {
                    i10 = i13;
                    i4 = i7;
                    long j4 = j;
                    i11 = i8;
                    i12 = i14;
                    obj3 = obj;
                    i8 = paddingLeft;
                    j2 = j4;
                }
            }
            i9++;
            i7 = i4;
            i6 = i11;
            i4 = i12;
            j = j2;
            paddingLeft = i10;
        }
        if (obj3 == null || paddingLeft != 2) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        Object obj4 = null;
        long j5 = j;
        paddingTop = i4;
        while (i8 > 0 && paddingTop > 0) {
            i13 = Integer.MAX_VALUE;
            j = 0;
            i4 = 0;
            int i15 = 0;
            while (i15 < childCount) {
                cVar = (c) getChildAt(i15).getLayoutParams();
                if (!cVar.d) {
                    size = i4;
                    i4 = i13;
                } else if (cVar.b < i13) {
                    i4 = cVar.b;
                    j = (long) (1 << i15);
                    size = 1;
                } else if (cVar.b == i13) {
                    j |= (long) (1 << i15);
                    size = i4 + 1;
                    i4 = i13;
                } else {
                    size = i4;
                    i4 = i13;
                }
                i15++;
                i13 = i4;
                i4 = size;
            }
            j5 |= j;
            if (i4 > paddingTop) {
                j = j5;
                break;
            }
            i15 = i13 + 1;
            i13 = 0;
            i4 = paddingTop;
            long j6 = j5;
            while (i13 < childCount) {
                View childAt2 = getChildAt(i13);
                cVar = (c) childAt2.getLayoutParams();
                if ((((long) (1 << i13)) & j) != 0) {
                    if (obj2 != null && cVar.e && i4 == 1) {
                        childAt2.setPadding(this.k + i5, 0, this.k, 0);
                    }
                    cVar.b++;
                    cVar.f = true;
                    size = i4 - 1;
                } else if (cVar.b == i15) {
                    j6 |= (long) (1 << i13);
                    size = i4;
                } else {
                    size = i4;
                }
                i13++;
                i4 = size;
            }
            j5 = j6;
            i9 = 1;
            paddingTop = i4;
        }
        j = j5;
        obj = (obj3 == null && paddingLeft == 1) ? 1 : null;
        if (paddingTop <= 0 || j == 0 || (paddingTop >= paddingLeft - 1 && obj == null && i7 <= 1)) {
            obj2 = obj4;
        } else {
            float f;
            View childAt3;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((c) getChildAt(0).getLayoutParams()).e)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount - 1))) & j) == 0 || ((c) getChildAt(childCount - 1).getLayoutParams()).e)) {
                    f = bitCount - 0.5f;
                    paddingLeft = f <= 0.0f ? (int) (((float) (paddingTop * i5)) / f) : 0;
                    i4 = 0;
                    obj2 = obj4;
                    while (i4 < childCount) {
                        if ((((long) (1 << i4)) & j) != 0) {
                            obj = obj2;
                        } else {
                            childAt3 = getChildAt(i4);
                            cVar = (c) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                cVar.c = paddingLeft;
                                cVar.f = true;
                                if (i4 == 0 && !cVar.e) {
                                    cVar.leftMargin = (-paddingLeft) / 2;
                                }
                                obj = 1;
                            } else if (cVar.a) {
                                if (i4 != 0) {
                                    cVar.leftMargin = paddingLeft / 2;
                                }
                                if (i4 != childCount - 1) {
                                    cVar.rightMargin = paddingLeft / 2;
                                }
                                obj = obj2;
                            } else {
                                cVar.c = paddingLeft;
                                cVar.f = true;
                                cVar.rightMargin = (-paddingLeft) / 2;
                                obj = 1;
                            }
                        }
                        i4++;
                        obj2 = obj;
                    }
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
            }
            i4 = 0;
            obj2 = obj4;
            while (i4 < childCount) {
                if ((((long) (1 << i4)) & j) != 0) {
                    childAt3 = getChildAt(i4);
                    cVar = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar.c = paddingLeft;
                        cVar.f = true;
                        cVar.leftMargin = (-paddingLeft) / 2;
                        obj = 1;
                    } else if (cVar.a) {
                        if (i4 != 0) {
                            cVar.leftMargin = paddingLeft / 2;
                        }
                        if (i4 != childCount - 1) {
                            cVar.rightMargin = paddingLeft / 2;
                        }
                        obj = obj2;
                    } else {
                        cVar.c = paddingLeft;
                        cVar.f = true;
                        cVar.rightMargin = (-paddingLeft) / 2;
                        obj = 1;
                    }
                } else {
                    obj = obj2;
                }
                i4++;
                obj2 = obj;
            }
        }
        if (obj2 != null) {
            for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
                childAt = getChildAt(paddingLeft);
                cVar = (c) childAt.getLayoutParams();
                if (cVar.f) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(cVar.c + (cVar.b * i5), 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode == 1073741824) {
            i6 = size2;
        }
        setMeasuredDimension(i3, i6);
    }

    static int a(View view, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        boolean z2 = false;
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        if (actionMenuItemView == null || !actionMenuItemView.b()) {
            z = false;
        } else {
            z = true;
        }
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z && r1 < 2) {
                i5 = 2;
            }
        }
        if (!cVar.a && z) {
            z2 = true;
        }
        cVar.d = z2;
        cVar.b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.h) {
            int i5;
            int i6;
            c cVar;
            int paddingLeft;
            int childCount = getChildCount();
            int i7 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i8 = 0;
            int i9 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean a = bd.a(this);
            int i10 = 0;
            while (i10 < childCount) {
                Object obj2;
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() == 8) {
                    obj2 = obj;
                    i5 = i9;
                    i6 = paddingRight;
                    paddingRight = i8;
                } else {
                    cVar = (c) childAt.getLayoutParams();
                    if (cVar.a) {
                        i6 = childAt.getMeasuredWidth();
                        if (a(i10)) {
                            i6 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            paddingLeft = cVar.leftMargin + getPaddingLeft();
                            i5 = paddingLeft + i6;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                            paddingLeft = i5 - i6;
                        }
                        int i11 = i7 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i11, i5, measuredHeight + i11);
                        i6 = paddingRight - i6;
                        obj2 = 1;
                        i5 = i9;
                        paddingRight = i8;
                    } else {
                        i5 = (childAt.getMeasuredWidth() + cVar.leftMargin) + cVar.rightMargin;
                        paddingLeft = i8 + i5;
                        i5 = paddingRight - i5;
                        if (a(i10)) {
                            paddingLeft += dividerWidth;
                        }
                        Object obj3 = obj;
                        i6 = i5;
                        i5 = i9 + 1;
                        paddingRight = paddingLeft;
                        obj2 = obj3;
                    }
                }
                i10++;
                i8 = paddingRight;
                paddingRight = i6;
                i9 = i5;
                obj = obj2;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                i6 = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (i6 / 2);
                i9 = i7 - (i5 / 2);
                childAt2.layout(paddingRight, i9, i6 + paddingRight, i5 + i9);
                return;
            }
            paddingLeft = i9 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, paddingLeft > 0 ? paddingRight / paddingLeft : 0);
            View childAt3;
            if (a) {
                i6 = getWidth() - getPaddingRight();
                i5 = 0;
                while (i5 < childCount) {
                    childAt3 = getChildAt(i5);
                    cVar = (c) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8) {
                        paddingLeft = i6;
                    } else if (cVar.a) {
                        paddingLeft = i6;
                    } else {
                        i6 -= cVar.rightMargin;
                        i8 = childAt3.getMeasuredWidth();
                        i10 = childAt3.getMeasuredHeight();
                        dividerWidth = i7 - (i10 / 2);
                        childAt3.layout(i6 - i8, dividerWidth, i6, i10 + dividerWidth);
                        paddingLeft = i6 - ((cVar.leftMargin + i8) + paddingRight);
                    }
                    i5++;
                    i6 = paddingLeft;
                }
                return;
            }
            i6 = getPaddingLeft();
            i5 = 0;
            while (i5 < childCount) {
                childAt3 = getChildAt(i5);
                cVar = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    paddingLeft = i6;
                } else if (cVar.a) {
                    paddingLeft = i6;
                } else {
                    i6 += cVar.leftMargin;
                    i8 = childAt3.getMeasuredWidth();
                    i10 = childAt3.getMeasuredHeight();
                    dividerWidth = i7 - (i10 / 2);
                    childAt3.layout(i6, dividerWidth, i6 + i8, i10 + dividerWidth);
                    paddingLeft = ((cVar.rightMargin + i8) + paddingRight) + i6;
                }
                i5++;
                i6 = paddingLeft;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.e.a(drawable);
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.e.c();
    }

    public void setOverflowReserved(boolean z) {
        this.d = z;
    }

    protected c a() {
        c cVar = new c(-2, -2);
        cVar.h = 16;
        return cVar;
    }

    public c a(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    protected c a(LayoutParams layoutParams) {
        if (layoutParams == null) {
            return a();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (cVar.h > 0) {
            return cVar;
        }
        cVar.h = 16;
        return cVar;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof c);
    }

    public c b() {
        c a = a();
        a.a = true;
        return a;
    }

    public boolean a(h hVar) {
        return this.a.a((MenuItem) hVar, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void a(g gVar) {
        this.a = gVar;
    }

    public Menu getMenu() {
        if (this.a == null) {
            Context context = getContext();
            this.a = new g(context);
            this.a.a(new d());
            this.e = new d(context);
            this.e.c(true);
            this.e.a(this.f != null ? this.f : new b());
            this.a.a(this.e, this.b);
            this.e.a(this);
        }
        return this.a;
    }

    public void a(android.support.v7.view.menu.m.a aVar, android.support.v7.view.menu.g.a aVar2) {
        this.f = aVar;
        this.g = aVar2;
    }

    public g c() {
        return this.a;
    }

    public boolean d() {
        return this.e != null && this.e.d();
    }

    public boolean e() {
        return this.e != null && this.e.h();
    }

    public void f() {
        if (this.e != null) {
            this.e.f();
        }
    }

    protected boolean a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            z = 0 | ((a) childAt).d();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? z : ((a) childAt2).c() | z;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.e.d(z);
    }
}
