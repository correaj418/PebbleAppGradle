package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ad;
import android.support.v4.view.af;
import android.support.v4.view.ah;
import android.support.v4.view.ar;
import android.support.v4.view.x;
import android.support.v4.view.y;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements ad, x {
    static final boolean a;
    private static final Interpolator au = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    private static final int[] l = new int[]{16843830};
    private static final int[] m = new int[]{16842987};
    private static final boolean n;
    private static final Class<?>[] o = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    private k A;
    private boolean B;
    private boolean C;
    private int D;
    private boolean E;
    private boolean F;
    private boolean G;
    private int H;
    private boolean I;
    private final boolean J;
    private final AccessibilityManager K;
    private List<j> L;
    private boolean M;
    private int N;
    private android.support.v4.widget.d O;
    private android.support.v4.widget.d P;
    private android.support.v4.widget.d Q;
    private android.support.v4.widget.d R;
    private int S;
    private int T;
    private VelocityTracker U;
    private int V;
    private int W;
    private int aa;
    private int ab;
    private int ac;
    private final int ad;
    private final int ae;
    private float af;
    private boolean ag;
    private final t ah;
    private l ai;
    private List<l> aj;
    private b ak;
    private boolean al;
    private al am;
    private d an;
    private final int[] ao;
    private y ap;
    private final int[] aq;
    private final int[] ar;
    private final int[] as;
    private Runnable at;
    private final b av;
    final n b;
    f c;
    v d;
    final bc e;
    h f;
    boolean g;
    e h;
    final r i;
    boolean j;
    boolean k;
    private final p p;
    private SavedState q;
    private boolean r;
    private final Runnable s;
    private final Rect t;
    private final Rect u;
    private final RectF v;
    private a w;
    private o x;
    private final ArrayList<g> y;
    private final ArrayList<k> z;

    public static class i extends MarginLayoutParams {
        u a;
        final Rect b = new Rect();
        boolean c = true;
        boolean d = false;

        public i(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public i(int i, int i2) {
            super(i, i2);
        }

        public i(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public i(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public i(i iVar) {
            super(iVar);
        }

        public boolean c() {
            return this.a.q();
        }

        public boolean d() {
            return this.a.x();
        }

        public int e() {
            return this.a.d();
        }
    }

    public static abstract class h {
        private boolean a = false;
        private boolean b = false;
        private boolean c = true;
        private int d;
        private int e;
        private int f;
        private int g;
        v p;
        RecyclerView q;
        q r;
        boolean s = false;

        public static class a {
            public int a;
            public int b;
            public boolean c;
            public boolean d;
        }

        public abstract i a();

        void b(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.q = null;
                this.p = null;
                this.f = 0;
                this.g = 0;
            } else {
                this.q = recyclerView;
                this.p = recyclerView.d;
                this.f = recyclerView.getWidth();
                this.g = recyclerView.getHeight();
            }
            this.d = 1073741824;
            this.e = 1073741824;
        }

        void b(int i, int i2) {
            this.f = MeasureSpec.getSize(i);
            this.d = MeasureSpec.getMode(i);
            if (this.d == 0 && !RecyclerView.a) {
                this.f = 0;
            }
            this.g = MeasureSpec.getSize(i2);
            this.e = MeasureSpec.getMode(i2);
            if (this.e == 0 && !RecyclerView.a) {
                this.g = 0;
            }
        }

        void c(int i, int i2) {
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int t = t();
            if (t == 0) {
                this.q.d(i, i2);
                return;
            }
            int i5 = 0;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MAX_VALUE;
            while (i5 < t) {
                int i8;
                View i9 = i(i5);
                i iVar = (i) i9.getLayoutParams();
                Rect r = this.q.t;
                a(i9, r);
                if (r.left < i7) {
                    i8 = r.left;
                } else {
                    i8 = i7;
                }
                if (r.right > i6) {
                    i7 = r.right;
                } else {
                    i7 = i6;
                }
                if (r.top < i3) {
                    i6 = r.top;
                } else {
                    i6 = i3;
                }
                if (r.bottom > i4) {
                    i3 = r.bottom;
                } else {
                    i3 = i4;
                }
                i5++;
                i4 = i3;
                i3 = i6;
                i6 = i7;
                i7 = i8;
            }
            this.q.t.set(i7, i3, i6, i4);
            a(this.q.t, i, i2);
        }

        public void a(Rect rect, int i, int i2) {
            e(a(i, (rect.width() + y()) + A(), D()), a(i2, (rect.height() + z()) + B(), E()));
        }

        public void n() {
            if (this.q != null) {
                this.q.requestLayout();
            }
        }

        public static int a(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return Math.min(size, Math.max(i2, i3));
                case 1073741824:
                    return size;
                default:
                    return Math.max(i2, i3);
            }
        }

        public void a(String str) {
            if (this.q != null) {
                this.q.a(str);
            }
        }

        public void c(boolean z) {
            this.b = z;
        }

        public boolean b() {
            return false;
        }

        void c(RecyclerView recyclerView) {
            this.s = true;
            d(recyclerView);
        }

        void b(RecyclerView recyclerView, n nVar) {
            this.s = false;
            a(recyclerView, nVar);
        }

        public boolean o() {
            return this.s;
        }

        public boolean a(Runnable runnable) {
            if (this.q != null) {
                return this.q.removeCallbacks(runnable);
            }
            return false;
        }

        public void d(RecyclerView recyclerView) {
        }

        @Deprecated
        public void e(RecyclerView recyclerView) {
        }

        public void a(RecyclerView recyclerView, n nVar) {
            e(recyclerView);
        }

        public boolean p() {
            return this.q != null && this.q.r;
        }

        public void c(n nVar, r rVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void a(r rVar) {
        }

        public boolean a(i iVar) {
            return iVar != null;
        }

        public i a(LayoutParams layoutParams) {
            if (layoutParams instanceof i) {
                return new i((i) layoutParams);
            }
            if (layoutParams instanceof MarginLayoutParams) {
                return new i((MarginLayoutParams) layoutParams);
            }
            return new i(layoutParams);
        }

        public i a(Context context, AttributeSet attributeSet) {
            return new i(context, attributeSet);
        }

        public int a(int i, n nVar, r rVar) {
            return 0;
        }

        public int b(int i, n nVar, r rVar) {
            return 0;
        }

        public boolean d() {
            return false;
        }

        public boolean e() {
            return false;
        }

        public void e(int i) {
        }

        public void a(RecyclerView recyclerView, r rVar, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void a(q qVar) {
            if (!(this.r == null || qVar == this.r || !this.r.h())) {
                this.r.f();
            }
            this.r = qVar;
            this.r.a(this.q, this);
        }

        public boolean q() {
            return this.r != null && this.r.h();
        }

        public int r() {
            return ah.h(this.q);
        }

        public void a(View view) {
            a(view, -1);
        }

        public void a(View view, int i) {
            a(view, i, true);
        }

        public void b(View view) {
            b(view, -1);
        }

        public void b(View view, int i) {
            a(view, i, false);
        }

        private void a(View view, int i, boolean z) {
            u d = RecyclerView.d(view);
            if (z || d.q()) {
                this.q.e.e(d);
            } else {
                this.q.e.f(d);
            }
            i iVar = (i) view.getLayoutParams();
            if (d.k() || d.i()) {
                if (d.i()) {
                    d.j();
                } else {
                    d.l();
                }
                this.p.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.q) {
                int b = this.p.b(view);
                if (i == -1) {
                    i = this.p.b();
                }
                if (b == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.q.indexOfChild(view));
                } else if (b != i) {
                    this.q.f.d(b, i);
                }
            } else {
                this.p.a(view, i, false);
                iVar.c = true;
                if (this.r != null && this.r.h()) {
                    this.r.b(view);
                }
            }
            if (iVar.d) {
                d.a.invalidate();
                iVar.d = false;
            }
        }

        public void c(View view) {
            this.p.a(view);
        }

        public void g(int i) {
            if (i(i) != null) {
                this.p.a(i);
            }
        }

        public int s() {
            return -1;
        }

        public int d(View view) {
            return ((i) view.getLayoutParams()).e();
        }

        public View e(View view) {
            if (this.q == null) {
                return null;
            }
            View b = this.q.b(view);
            if (b == null || this.p.c(b)) {
                return null;
            }
            return b;
        }

        public View c(int i) {
            int t = t();
            for (int i2 = 0; i2 < t; i2++) {
                View i3 = i(i2);
                u d = RecyclerView.d(i3);
                if (d != null && d.d() == i && !d.c() && (this.q.i.a() || !d.q())) {
                    return i3;
                }
            }
            return null;
        }

        public void h(int i) {
            a(i, i(i));
        }

        private void a(int i, View view) {
            this.p.d(i);
        }

        public void a(View view, int i, i iVar) {
            u d = RecyclerView.d(view);
            if (d.q()) {
                this.q.e.e(d);
            } else {
                this.q.e.f(d);
            }
            this.p.a(view, i, iVar, d.q());
        }

        public void c(View view, int i) {
            a(view, i, (i) view.getLayoutParams());
        }

        public void d(int i, int i2) {
            View i3 = i(i);
            if (i3 == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i);
            }
            h(i);
            c(i3, i2);
        }

        public void a(View view, n nVar) {
            c(view);
            nVar.a(view);
        }

        public void a(int i, n nVar) {
            View i2 = i(i);
            g(i);
            nVar.a(i2);
        }

        public int t() {
            return this.p != null ? this.p.b() : 0;
        }

        public View i(int i) {
            return this.p != null ? this.p.b(i) : null;
        }

        public int u() {
            return this.d;
        }

        public int v() {
            return this.e;
        }

        public int w() {
            return this.f;
        }

        public int x() {
            return this.g;
        }

        public int y() {
            return this.q != null ? this.q.getPaddingLeft() : 0;
        }

        public int z() {
            return this.q != null ? this.q.getPaddingTop() : 0;
        }

        public int A() {
            return this.q != null ? this.q.getPaddingRight() : 0;
        }

        public int B() {
            return this.q != null ? this.q.getPaddingBottom() : 0;
        }

        public View C() {
            if (this.q == null) {
                return null;
            }
            View focusedChild = this.q.getFocusedChild();
            if (focusedChild == null || this.p.c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void j(int i) {
            if (this.q != null) {
                this.q.e(i);
            }
        }

        public void k(int i) {
            if (this.q != null) {
                this.q.d(i);
            }
        }

        public void a(n nVar) {
            for (int t = t() - 1; t >= 0; t--) {
                a(nVar, t, i(t));
            }
        }

        private void a(n nVar, int i, View view) {
            u d = RecyclerView.d(view);
            if (!d.c()) {
                if (!d.n() || d.q() || this.q.w.b()) {
                    h(i);
                    nVar.c(view);
                    this.q.e.h(d);
                    return;
                }
                g(i);
                nVar.b(d);
            }
        }

        void b(n nVar) {
            int d = nVar.d();
            for (int i = d - 1; i >= 0; i--) {
                View e = nVar.e(i);
                u d2 = RecyclerView.d(e);
                if (!d2.c()) {
                    d2.a(false);
                    if (d2.r()) {
                        this.q.removeDetachedView(e, false);
                    }
                    if (this.q.h != null) {
                        this.q.h.c(d2);
                    }
                    d2.a(true);
                    nVar.b(e);
                }
            }
            nVar.e();
            if (d > 0) {
                this.q.invalidate();
            }
        }

        boolean a(View view, int i, int i2, i iVar) {
            return (this.c && b(view.getMeasuredWidth(), i, iVar.width) && b(view.getMeasuredHeight(), i2, iVar.height)) ? false : true;
        }

        boolean b(View view, int i, int i2, i iVar) {
            return (!view.isLayoutRequested() && this.c && b(view.getWidth(), i, iVar.width) && b(view.getHeight(), i2, iVar.height)) ? false : true;
        }

        private static boolean b(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            switch (mode) {
                case Integer.MIN_VALUE:
                    if (size < i) {
                        return false;
                    }
                    return true;
                case 0:
                    return true;
                case 1073741824:
                    if (size != i) {
                        return false;
                    }
                    return true;
                default:
                    return false;
            }
        }

        public void a(View view, int i, int i2) {
            i iVar = (i) view.getLayoutParams();
            Rect h = this.q.h(view);
            int i3 = (h.left + h.right) + i;
            int i4 = (h.bottom + h.top) + i2;
            i3 = a(w(), u(), i3 + (((y() + A()) + iVar.leftMargin) + iVar.rightMargin), iVar.width, d());
            i4 = a(x(), v(), i4 + (((z() + B()) + iVar.topMargin) + iVar.bottomMargin), iVar.height, e());
            if (b(view, i3, i4, iVar)) {
                view.measure(i3, i4);
            }
        }

        public static int a(int i, int i2, int i3, int i4, boolean z) {
            int i5 = 0;
            int max = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i5 = 1073741824;
                    max = i4;
                } else if (i4 == -1) {
                    switch (i2) {
                        case Integer.MIN_VALUE:
                        case 1073741824:
                            i5 = max;
                            break;
                        case 0:
                            i2 = 0;
                            break;
                        default:
                            i2 = 0;
                            break;
                    }
                    max = i5;
                    i5 = i2;
                } else {
                    if (i4 == -2) {
                        max = 0;
                    }
                    max = 0;
                }
            } else if (i4 >= 0) {
                i5 = 1073741824;
                max = i4;
            } else if (i4 == -1) {
                i5 = i2;
            } else {
                if (i4 == -2) {
                    if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                        i5 = Integer.MIN_VALUE;
                    }
                }
                max = 0;
            }
            return MeasureSpec.makeMeasureSpec(max, i5);
        }

        public int f(View view) {
            Rect rect = ((i) view.getLayoutParams()).b;
            return rect.right + (view.getMeasuredWidth() + rect.left);
        }

        public int g(View view) {
            Rect rect = ((i) view.getLayoutParams()).b;
            return rect.bottom + (view.getMeasuredHeight() + rect.top);
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            i iVar = (i) view.getLayoutParams();
            Rect rect = iVar.b;
            view.layout((rect.left + i) + iVar.leftMargin, (rect.top + i2) + iVar.topMargin, (i3 - rect.right) - iVar.rightMargin, (i4 - rect.bottom) - iVar.bottomMargin);
        }

        public void a(View view, boolean z, Rect rect) {
            if (z) {
                Rect rect2 = ((i) view.getLayoutParams()).b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, rect2.bottom + view.getHeight());
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.q != null) {
                Matrix m = ah.m(view);
                if (!(m == null || m.isIdentity())) {
                    RectF t = this.q.v;
                    t.set(rect);
                    m.mapRect(t);
                    rect.set((int) Math.floor((double) t.left), (int) Math.floor((double) t.top), (int) Math.ceil((double) t.right), (int) Math.ceil((double) t.bottom));
                }
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void a(View view, Rect rect) {
            i iVar = (i) view.getLayoutParams();
            Rect rect2 = iVar.b;
            rect.set((view.getLeft() - rect2.left) - iVar.leftMargin, (view.getTop() - rect2.top) - iVar.topMargin, (view.getRight() + rect2.right) + iVar.rightMargin, iVar.bottomMargin + (rect2.bottom + view.getBottom()));
        }

        public int h(View view) {
            return view.getLeft() - n(view);
        }

        public int i(View view) {
            return view.getTop() - l(view);
        }

        public int j(View view) {
            return view.getRight() + o(view);
        }

        public int k(View view) {
            return view.getBottom() + m(view);
        }

        public void b(View view, Rect rect) {
            if (this.q == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.q.h(view));
            }
        }

        public int l(View view) {
            return ((i) view.getLayoutParams()).b.top;
        }

        public int m(View view) {
            return ((i) view.getLayoutParams()).b.bottom;
        }

        public int n(View view) {
            return ((i) view.getLayoutParams()).b.left;
        }

        public int o(View view) {
            return ((i) view.getLayoutParams()).b.right;
        }

        public View a(View view, int i, n nVar, r rVar) {
            return null;
        }

        public View d(View view, int i) {
            return null;
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int y = y();
            int z2 = z();
            int w = w() - A();
            int x = x() - B();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = left + rect.width();
            int height = top + rect.height();
            int min = Math.min(0, left - y);
            int min2 = Math.min(0, top - z2);
            int max = Math.max(0, width - w);
            x = Math.max(0, height - x);
            if (r() == 1) {
                if (max == 0) {
                    max = Math.max(min, width - w);
                }
                min = max;
            } else {
                if (min != 0) {
                    max = min;
                } else {
                    max = Math.min(left - y, max);
                }
                min = max;
            }
            if (min2 != 0) {
                max = min2;
            } else {
                max = Math.min(top - z2, x);
            }
            if (min == 0 && max == 0) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(min, max);
            } else {
                recyclerView.a(min, max);
            }
            return true;
        }

        @Deprecated
        public boolean a(RecyclerView recyclerView, View view, View view2) {
            return q() || recyclerView.j();
        }

        public boolean a(RecyclerView recyclerView, r rVar, View view, View view2) {
            return a(recyclerView, view, view2);
        }

        public void a(a aVar, a aVar2) {
        }

        public boolean a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void a(RecyclerView recyclerView) {
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
        }

        public void c(RecyclerView recyclerView, int i, int i2) {
        }

        public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
            c(recyclerView, i, i2);
        }

        public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public int e(r rVar) {
            return 0;
        }

        public int c(r rVar) {
            return 0;
        }

        public int g(r rVar) {
            return 0;
        }

        public int f(r rVar) {
            return 0;
        }

        public int d(r rVar) {
            return 0;
        }

        public int h(r rVar) {
            return 0;
        }

        public void a(n nVar, r rVar, int i, int i2) {
            this.q.d(i, i2);
        }

        public void e(int i, int i2) {
            this.q.setMeasuredDimension(i, i2);
        }

        public int D() {
            return ah.n(this.q);
        }

        public int E() {
            return ah.o(this.q);
        }

        public Parcelable c() {
            return null;
        }

        public void a(Parcelable parcelable) {
        }

        void F() {
            if (this.r != null) {
                this.r.f();
            }
        }

        private void b(q qVar) {
            if (this.r == qVar) {
                this.r = null;
            }
        }

        public void l(int i) {
        }

        public void c(n nVar) {
            for (int t = t() - 1; t >= 0; t--) {
                if (!RecyclerView.d(i(t)).c()) {
                    a(t, nVar);
                }
            }
        }

        void a(android.support.v4.view.a.c cVar) {
            a(this.q.b, this.q.i, cVar);
        }

        public void a(n nVar, r rVar, android.support.v4.view.a.c cVar) {
            if (ah.b(this.q, -1) || ah.a(this.q, -1)) {
                cVar.a(8192);
                cVar.a(true);
            }
            if (ah.b(this.q, 1) || ah.a(this.q, 1)) {
                cVar.a(4096);
                cVar.a(true);
            }
            cVar.a(android.support.v4.view.a.c.k.a(a(nVar, rVar), b(nVar, rVar), e(nVar, rVar), d(nVar, rVar)));
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            a(this.q.b, this.q.i, accessibilityEvent);
        }

        public void a(n nVar, r rVar, AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            android.support.v4.view.a.k a = android.support.v4.view.a.a.a(accessibilityEvent);
            if (this.q != null && a != null) {
                if (!(ah.b(this.q, 1) || ah.b(this.q, -1) || ah.a(this.q, -1) || ah.a(this.q, 1))) {
                    z = false;
                }
                a.a(z);
                if (this.q.w != null) {
                    a.a(this.q.w.a());
                }
            }
        }

        void a(View view, android.support.v4.view.a.c cVar) {
            u d = RecyclerView.d(view);
            if (d != null && !d.q() && !this.p.c(d.a)) {
                a(this.q.b, this.q.i, view, cVar);
            }
        }

        public void a(n nVar, r rVar, View view, android.support.v4.view.a.c cVar) {
            int d;
            int d2 = e() ? d(view) : 0;
            if (d()) {
                d = d(view);
            } else {
                d = 0;
            }
            cVar.b(android.support.v4.view.a.c.l.a(d2, 1, d, 1, false, false));
        }

        public void G() {
            this.a = true;
        }

        public int d(n nVar, r rVar) {
            return 0;
        }

        public int a(n nVar, r rVar) {
            if (this.q == null || this.q.w == null || !e()) {
                return 1;
            }
            return this.q.w.a();
        }

        public int b(n nVar, r rVar) {
            if (this.q == null || this.q.w == null || !d()) {
                return 1;
            }
            return this.q.w.a();
        }

        public boolean e(n nVar, r rVar) {
            return false;
        }

        boolean a(int i, Bundle bundle) {
            return a(this.q.b, this.q.i, i, bundle);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(android.support.v7.widget.RecyclerView.n r7, android.support.v7.widget.RecyclerView.r r8, int r9, android.os.Bundle r10) {
            /*
            r6 = this;
            r4 = -1;
            r2 = 1;
            r1 = 0;
            r0 = r6.q;
            if (r0 != 0) goto L_0x0008;
        L_0x0007:
            return r1;
        L_0x0008:
            switch(r9) {
                case 4096: goto L_0x004a;
                case 8192: goto L_0x0018;
                default: goto L_0x000b;
            };
        L_0x000b:
            r0 = r1;
            r3 = r1;
        L_0x000d:
            if (r3 != 0) goto L_0x0011;
        L_0x000f:
            if (r0 == 0) goto L_0x0007;
        L_0x0011:
            r1 = r6.q;
            r1.scrollBy(r0, r3);
            r1 = r2;
            goto L_0x0007;
        L_0x0018:
            r0 = r6.q;
            r0 = android.support.v4.view.ah.b(r0, r4);
            if (r0 == 0) goto L_0x007f;
        L_0x0020:
            r0 = r6.x();
            r3 = r6.z();
            r0 = r0 - r3;
            r3 = r6.B();
            r0 = r0 - r3;
            r0 = -r0;
        L_0x002f:
            r3 = r6.q;
            r3 = android.support.v4.view.ah.a(r3, r4);
            if (r3 == 0) goto L_0x007a;
        L_0x0037:
            r3 = r6.w();
            r4 = r6.y();
            r3 = r3 - r4;
            r4 = r6.A();
            r3 = r3 - r4;
            r3 = -r3;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x004a:
            r0 = r6.q;
            r0 = android.support.v4.view.ah.b(r0, r2);
            if (r0 == 0) goto L_0x007d;
        L_0x0052:
            r0 = r6.x();
            r3 = r6.z();
            r0 = r0 - r3;
            r3 = r6.B();
            r0 = r0 - r3;
        L_0x0060:
            r3 = r6.q;
            r3 = android.support.v4.view.ah.a(r3, r2);
            if (r3 == 0) goto L_0x007a;
        L_0x0068:
            r3 = r6.w();
            r4 = r6.y();
            r3 = r3 - r4;
            r4 = r6.A();
            r3 = r3 - r4;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x007a:
            r3 = r0;
            r0 = r1;
            goto L_0x000d;
        L_0x007d:
            r0 = r1;
            goto L_0x0060;
        L_0x007f:
            r0 = r1;
            goto L_0x002f;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.h.a(android.support.v7.widget.RecyclerView$n, android.support.v7.widget.RecyclerView$r, int, android.os.Bundle):boolean");
        }

        boolean a(View view, int i, Bundle bundle) {
            return a(this.q.b, this.q.i, view, i, bundle);
        }

        public boolean a(n nVar, r rVar, View view, int i, Bundle bundle) {
            return false;
        }

        public static a a(Context context, AttributeSet attributeSet, int i, int i2) {
            a aVar = new a();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.f.a.c.RecyclerView, i, i2);
            aVar.a = obtainStyledAttributes.getInt(android.support.v7.f.a.c.RecyclerView_android_orientation, 1);
            aVar.b = obtainStyledAttributes.getInt(android.support.v7.f.a.c.RecyclerView_spanCount, 1);
            aVar.c = obtainStyledAttributes.getBoolean(android.support.v7.f.a.c.RecyclerView_reverseLayout, false);
            aVar.d = obtainStyledAttributes.getBoolean(android.support.v7.f.a.c.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return aVar;
        }

        void f(RecyclerView recyclerView) {
            b(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        boolean k() {
            return false;
        }

        boolean H() {
            int t = t();
            for (int i = 0; i < t; i++) {
                LayoutParams layoutParams = i(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public static abstract class q {
        private int a = -1;
        private RecyclerView b;
        private h c;
        private boolean d;
        private boolean e;
        private View f;
        private final a g = new a(0, 0);

        public static class a {
            private int a;
            private int b;
            private int c;
            private int d;
            private Interpolator e;
            private boolean f;
            private int g;

            public a(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            public a(int i, int i2, int i3, Interpolator interpolator) {
                this.d = -1;
                this.f = false;
                this.g = 0;
                this.a = i;
                this.b = i2;
                this.c = i3;
                this.e = interpolator;
            }

            public void a(int i) {
                this.d = i;
            }

            boolean a() {
                return this.d >= 0;
            }

            private void a(RecyclerView recyclerView) {
                if (this.d >= 0) {
                    int i = this.d;
                    this.d = -1;
                    recyclerView.h(i);
                    this.f = false;
                } else if (this.f) {
                    b();
                    if (this.e != null) {
                        recyclerView.ah.a(this.a, this.b, this.c, this.e);
                    } else if (this.c == Integer.MIN_VALUE) {
                        recyclerView.ah.b(this.a, this.b);
                    } else {
                        recyclerView.ah.a(this.a, this.b, this.c);
                    }
                    this.g++;
                    if (this.g > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f = false;
                } else {
                    this.g = 0;
                }
            }

            private void b() {
                if (this.e != null && this.c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void a(int i, int i2, int i3, Interpolator interpolator) {
                this.a = i;
                this.b = i2;
                this.c = i3;
                this.e = interpolator;
                this.f = true;
            }
        }

        protected abstract void a();

        protected abstract void a(int i, int i2, r rVar, a aVar);

        protected abstract void a(View view, r rVar, a aVar);

        protected abstract void b();

        void a(RecyclerView recyclerView, h hVar) {
            this.b = recyclerView;
            this.c = hVar;
            if (this.a == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            this.b.i.e = this.a;
            this.e = true;
            this.d = true;
            this.f = e(i());
            a();
            this.b.ah.a();
        }

        public void d(int i) {
            this.a = i;
        }

        public h e() {
            return this.c;
        }

        protected final void f() {
            if (this.e) {
                b();
                this.b.i.e = -1;
                this.f = null;
                this.a = -1;
                this.d = false;
                this.e = false;
                this.c.b(this);
                this.c = null;
                this.b = null;
            }
        }

        public boolean g() {
            return this.d;
        }

        public boolean h() {
            return this.e;
        }

        public int i() {
            return this.a;
        }

        private void a(int i, int i2) {
            RecyclerView recyclerView = this.b;
            if (!this.e || this.a == -1 || recyclerView == null) {
                f();
            }
            this.d = false;
            if (this.f != null) {
                if (a(this.f) == this.a) {
                    a(this.f, recyclerView.i, this.g);
                    this.g.a(recyclerView);
                    f();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f = null;
                }
            }
            if (this.e) {
                a(i, i2, recyclerView.i, this.g);
                boolean a = this.g.a();
                this.g.a(recyclerView);
                if (!a) {
                    return;
                }
                if (this.e) {
                    this.d = true;
                    recyclerView.ah.a();
                    return;
                }
                f();
            }
        }

        public int a(View view) {
            return this.b.e(view);
        }

        public int j() {
            return this.b.f.t();
        }

        public View e(int i) {
            return this.b.f.c(i);
        }

        protected void b(View view) {
            if (a(view) == i()) {
                this.f = view;
            }
        }

        protected void a(PointF pointF) {
            double sqrt = Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
            pointF.x = (float) (((double) pointF.x) / sqrt);
            pointF.y = (float) (((double) pointF.y) / sqrt);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = android.support.v4.d.d.a(new android.support.v4.d.e<SavedState>() {
            public /* synthetic */ Object a(Parcel parcel, ClassLoader classLoader) {
                return b(parcel, classLoader);
            }

            public /* synthetic */ Object[] a(int i) {
                return b(i);
            }

            public SavedState b(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] b(int i) {
                return new SavedState[i];
            }
        });
        Parcelable b;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = h.class.getClassLoader();
            }
            this.b = parcel.readParcelable(classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.b, 0);
        }

        private void a(SavedState savedState) {
            this.b = savedState.b;
        }
    }

    public static abstract class a<VH extends u> {
        private final b a = new b();
        private boolean b = false;

        public abstract int a();

        public abstract VH a(ViewGroup viewGroup, int i);

        public abstract void a(VH vh, int i);

        public void a(VH vh, int i, List<Object> list) {
            a((u) vh, i);
        }

        public final VH b(ViewGroup viewGroup, int i) {
            android.support.v4.d.h.a("RV CreateView");
            VH a = a(viewGroup, i);
            a.e = i;
            android.support.v4.d.h.a();
            return a;
        }

        public final void b(VH vh, int i) {
            vh.b = i;
            if (b()) {
                vh.d = b(i);
            }
            vh.a(1, 519);
            android.support.v4.d.h.a("RV OnBindView");
            a(vh, i, vh.u());
            vh.t();
            android.support.v4.d.h.a();
        }

        public int a(int i) {
            return 0;
        }

        public void a(boolean z) {
            if (c()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.b = z;
        }

        public long b(int i) {
            return -1;
        }

        public final boolean b() {
            return this.b;
        }

        public void a(VH vh) {
        }

        public boolean b(VH vh) {
            return false;
        }

        public void c(VH vh) {
        }

        public void d(VH vh) {
        }

        public final boolean c() {
            return this.a.a();
        }

        public void a(c cVar) {
            this.a.registerObserver(cVar);
        }

        public void b(c cVar) {
            this.a.unregisterObserver(cVar);
        }

        public void a(RecyclerView recyclerView) {
        }

        public void b(RecyclerView recyclerView) {
        }

        public final void d() {
            this.a.b();
        }

        public final void c(int i) {
            this.a.a(i, 1);
        }

        public final void d(int i) {
            this.a.b(i, 1);
        }

        public final void a(int i, int i2) {
            this.a.d(i, i2);
        }

        public final void e(int i) {
            this.a.c(i, 1);
        }
    }

    static class b extends Observable<c> {
        b() {
        }

        public boolean a() {
            return !this.mObservers.isEmpty();
        }

        public void b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a();
            }
        }

        public void a(int i, int i2) {
            a(i, i2, null);
        }

        public void a(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a(i, i2, obj);
            }
        }

        public void b(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).b(i, i2);
            }
        }

        public void c(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).c(i, i2);
            }
        }

        public void d(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a(i, i2, 1);
            }
        }
    }

    public static abstract class c {
        public void a() {
        }

        public void a(int i, int i2) {
        }

        public void a(int i, int i2, Object obj) {
            a(i, i2);
        }

        public void b(int i, int i2) {
        }

        public void c(int i, int i2) {
        }

        public void a(int i, int i2, int i3) {
        }
    }

    public interface d {
        int a(int i, int i2);
    }

    public static abstract class e {
        private b a = null;
        private ArrayList<a> b = new ArrayList();
        private long c = 120;
        private long d = 120;
        private long e = 250;
        private long f = 250;

        public interface a {
            void a();
        }

        interface b {
            void a(u uVar);
        }

        public static class c {
            public int a;
            public int b;
            public int c;
            public int d;

            public c a(u uVar) {
                return a(uVar, 0);
            }

            public c a(u uVar, int i) {
                View view = uVar.a;
                this.a = view.getLeft();
                this.b = view.getTop();
                this.c = view.getRight();
                this.d = view.getBottom();
                return this;
            }
        }

        public abstract void a();

        public abstract boolean a(u uVar, c cVar, c cVar2);

        public abstract boolean a(u uVar, u uVar2, c cVar, c cVar2);

        public abstract boolean b();

        public abstract boolean b(u uVar, c cVar, c cVar2);

        public abstract void c();

        public abstract void c(u uVar);

        public abstract boolean c(u uVar, c cVar, c cVar2);

        public long d() {
            return this.e;
        }

        public long e() {
            return this.c;
        }

        public long f() {
            return this.d;
        }

        public long g() {
            return this.f;
        }

        void a(b bVar) {
            this.a = bVar;
        }

        public c a(r rVar, u uVar, int i, List<Object> list) {
            return i().a(uVar);
        }

        public c a(r rVar, u uVar) {
            return i().a(uVar);
        }

        static int d(u uVar) {
            int f = uVar.l & 14;
            if (uVar.n()) {
                return 4;
            }
            if ((f & 4) != 0) {
                return f;
            }
            int f2 = uVar.f();
            int e = uVar.e();
            if (f2 == -1 || e == -1 || f2 == e) {
                return f;
            }
            return f | 2048;
        }

        public final void e(u uVar) {
            f(uVar);
            if (this.a != null) {
                this.a.a(uVar);
            }
        }

        public void f(u uVar) {
        }

        public final boolean a(a aVar) {
            boolean b = b();
            if (aVar != null) {
                if (b) {
                    this.b.add(aVar);
                } else {
                    aVar.a();
                }
            }
            return b;
        }

        public boolean g(u uVar) {
            return true;
        }

        public boolean a(u uVar, List<Object> list) {
            return g(uVar);
        }

        public final void h() {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                ((a) this.b.get(i)).a();
            }
            this.b.clear();
        }

        public c i() {
            return new c();
        }
    }

    private class f implements b {
        final /* synthetic */ RecyclerView a;

        private f(RecyclerView recyclerView) {
            this.a = recyclerView;
        }

        public void a(u uVar) {
            uVar.a(true);
            if (uVar.g != null && uVar.h == null) {
                uVar.g = null;
            }
            uVar.h = null;
            if (!uVar.B() && !this.a.i(uVar.a) && uVar.r()) {
                this.a.removeDetachedView(uVar.a, false);
            }
        }
    }

    public static abstract class g {
        public void a(Canvas canvas, RecyclerView recyclerView, r rVar) {
            a(canvas, recyclerView);
        }

        @Deprecated
        public void a(Canvas canvas, RecyclerView recyclerView) {
        }

        public void b(Canvas canvas, RecyclerView recyclerView, r rVar) {
            b(canvas, recyclerView);
        }

        @Deprecated
        public void b(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void a(Rect rect, View view, RecyclerView recyclerView, r rVar) {
            a(rect, ((i) view.getLayoutParams()).e(), recyclerView);
        }
    }

    public interface j {
        void a(View view);

        void b(View view);
    }

    public interface k {
        void a(boolean z);

        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class l {
        public void a(RecyclerView recyclerView, int i) {
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static class m {
        private SparseArray<ArrayList<u>> a = new SparseArray();
        private SparseIntArray b = new SparseIntArray();
        private int c = 0;

        public void a() {
            this.a.clear();
        }

        public u a(int i) {
            ArrayList arrayList = (ArrayList) this.a.get(i);
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            int size = arrayList.size() - 1;
            u uVar = (u) arrayList.get(size);
            arrayList.remove(size);
            return uVar;
        }

        public void a(u uVar) {
            int h = uVar.h();
            ArrayList b = b(h);
            if (this.b.get(h) > b.size()) {
                uVar.v();
                b.add(uVar);
            }
        }

        void a(a aVar) {
            this.c++;
        }

        void b() {
            this.c--;
        }

        void a(a aVar, a aVar2, boolean z) {
            if (aVar != null) {
                b();
            }
            if (!z && this.c == 0) {
                a();
            }
            if (aVar2 != null) {
                a(aVar2);
            }
        }

        private ArrayList<u> b(int i) {
            ArrayList<u> arrayList = (ArrayList) this.a.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.a.put(i, arrayList);
                if (this.b.indexOfKey(i) < 0) {
                    this.b.put(i, 5);
                }
            }
            return arrayList;
        }
    }

    public final class n {
        final ArrayList<u> a = new ArrayList();
        final ArrayList<u> b = new ArrayList();
        final /* synthetic */ RecyclerView c;
        private ArrayList<u> d = null;
        private final List<u> e = Collections.unmodifiableList(this.a);
        private int f = 2;
        private m g;
        private s h;

        public n(RecyclerView recyclerView) {
            this.c = recyclerView;
        }

        public void a() {
            this.a.clear();
            c();
        }

        public void a(int i) {
            this.f = i;
            for (int size = this.b.size() - 1; size >= 0 && this.b.size() > i; size--) {
                d(size);
            }
        }

        public List<u> b() {
            return this.e;
        }

        boolean a(u uVar) {
            if (uVar.q()) {
                return this.c.i.a();
            }
            if (uVar.b < 0 || uVar.b >= this.c.w.a()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + uVar);
            } else if (!this.c.i.a() && this.c.w.a(uVar.b) != uVar.h()) {
                return false;
            } else {
                if (!this.c.w.b() || uVar.g() == this.c.w.b(uVar.b)) {
                    return true;
                }
                return false;
            }
        }

        public int b(int i) {
            if (i >= 0 && i < this.c.i.e()) {
                return !this.c.i.a() ? i : this.c.c.b(i);
            } else {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State " + "item count is " + this.c.i.e());
            }
        }

        public View c(int i) {
            return a(i, false);
        }

        View a(int i, boolean z) {
            boolean z2 = true;
            if (i < 0 || i >= this.c.i.e()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.c.i.e());
            }
            u f;
            boolean z3;
            u uVar;
            boolean z4;
            int b;
            boolean z5;
            int b2;
            LayoutParams layoutParams;
            i iVar;
            if (this.c.i.a()) {
                f = f(i);
                u uVar2 = f;
                z3 = f != null;
                uVar = uVar2;
            } else {
                uVar = null;
                z3 = false;
            }
            if (uVar == null) {
                uVar = a(i, -1, z);
                if (uVar != null) {
                    if (a(uVar)) {
                        z4 = true;
                    } else {
                        if (!z) {
                            uVar.b(4);
                            if (uVar.i()) {
                                this.c.removeDetachedView(uVar.a, false);
                                uVar.j();
                            } else if (uVar.k()) {
                                uVar.l();
                            }
                            b(uVar);
                        }
                        uVar = null;
                        z4 = z3;
                    }
                    if (uVar == null) {
                        b = this.c.c.b(i);
                        if (b >= 0 || b >= this.c.w.a()) {
                            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ")." + "state:" + this.c.i.e());
                        }
                        int a = this.c.w.a(b);
                        if (this.c.w.b()) {
                            uVar = a(this.c.w.b(b), a, z);
                            if (uVar != null) {
                                uVar.b = b;
                                z4 = true;
                            }
                        }
                        if (uVar == null && this.h != null) {
                            View a2 = this.h.a(this, i, a);
                            if (a2 != null) {
                                uVar = this.c.a(a2);
                                if (uVar == null) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                } else if (uVar.c()) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                }
                            }
                        }
                        if (uVar == null) {
                            uVar = f().a(a);
                            if (uVar != null) {
                                uVar.v();
                                if (RecyclerView.n) {
                                    f(uVar);
                                }
                            }
                        }
                        if (uVar == null) {
                            f = this.c.w.b(this.c, a);
                            z5 = z4;
                            if (z5 && !this.c.i.a() && f.a(8192)) {
                                f.a(0, 8192);
                                if (this.c.i.l) {
                                    this.c.a(f, this.c.h.a(this.c.i, f, e.d(f) | 4096, f.u()));
                                }
                            }
                            int i2;
                            if (!this.c.i.a() && f.p()) {
                                f.f = i;
                                i2 = 0;
                            } else if (f.p() || f.o() || f.n()) {
                                b2 = this.c.c.b(i);
                                f.k = this.c;
                                this.c.w.b(f, b2);
                                d(f.a);
                                if (this.c.i.a()) {
                                    f.f = i;
                                }
                                z4 = true;
                            } else {
                                i2 = 0;
                            }
                            layoutParams = f.a.getLayoutParams();
                            if (layoutParams != null) {
                                iVar = (i) this.c.generateDefaultLayoutParams();
                                f.a.setLayoutParams(iVar);
                            } else if (this.c.checkLayoutParams(layoutParams)) {
                                iVar = (i) layoutParams;
                            } else {
                                iVar = (i) this.c.generateLayoutParams(layoutParams);
                                f.a.setLayoutParams(iVar);
                            }
                            iVar.a = f;
                            if (!z5 || r3 == 0) {
                                z2 = false;
                            }
                            iVar.d = z2;
                            return f.a;
                        }
                    }
                    f = uVar;
                    z5 = z4;
                    f.a(0, 8192);
                    if (this.c.i.l) {
                        this.c.a(f, this.c.h.a(this.c.i, f, e.d(f) | 4096, f.u()));
                    }
                    if (!this.c.i.a()) {
                    }
                    if (f.p()) {
                    }
                    b2 = this.c.c.b(i);
                    f.k = this.c;
                    this.c.w.b(f, b2);
                    d(f.a);
                    if (this.c.i.a()) {
                        f.f = i;
                    }
                    z4 = true;
                    layoutParams = f.a.getLayoutParams();
                    if (layoutParams != null) {
                        iVar = (i) this.c.generateDefaultLayoutParams();
                        f.a.setLayoutParams(iVar);
                    } else if (this.c.checkLayoutParams(layoutParams)) {
                        iVar = (i) layoutParams;
                    } else {
                        iVar = (i) this.c.generateLayoutParams(layoutParams);
                        f.a.setLayoutParams(iVar);
                    }
                    iVar.a = f;
                    z2 = false;
                    iVar.d = z2;
                    return f.a;
                }
            }
            z4 = z3;
            if (uVar == null) {
                b = this.c.c.b(i);
                if (b >= 0) {
                }
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ")." + "state:" + this.c.i.e());
            }
            f = uVar;
            z5 = z4;
            f.a(0, 8192);
            if (this.c.i.l) {
                this.c.a(f, this.c.h.a(this.c.i, f, e.d(f) | 4096, f.u()));
            }
            if (!this.c.i.a()) {
            }
            if (f.p()) {
            }
            b2 = this.c.c.b(i);
            f.k = this.c;
            this.c.w.b(f, b2);
            d(f.a);
            if (this.c.i.a()) {
                f.f = i;
            }
            z4 = true;
            layoutParams = f.a.getLayoutParams();
            if (layoutParams != null) {
                iVar = (i) this.c.generateDefaultLayoutParams();
                f.a.setLayoutParams(iVar);
            } else if (this.c.checkLayoutParams(layoutParams)) {
                iVar = (i) this.c.generateLayoutParams(layoutParams);
                f.a.setLayoutParams(iVar);
            } else {
                iVar = (i) layoutParams;
            }
            iVar.a = f;
            z2 = false;
            iVar.d = z2;
            return f.a;
        }

        private void d(View view) {
            if (this.c.i()) {
                if (ah.e(view) == 0) {
                    ah.c(view, 1);
                }
                if (!ah.b(view)) {
                    ah.a(view, this.c.am.b());
                }
            }
        }

        private void f(u uVar) {
            if (uVar.a instanceof ViewGroup) {
                a((ViewGroup) uVar.a, false);
            }
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (!z) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        public void a(View view) {
            u d = RecyclerView.d(view);
            if (d.r()) {
                this.c.removeDetachedView(view, false);
            }
            if (d.i()) {
                d.j();
            } else if (d.k()) {
                d.l();
            }
            b(d);
        }

        void c() {
            for (int size = this.b.size() - 1; size >= 0; size--) {
                d(size);
            }
            this.b.clear();
        }

        void d(int i) {
            c((u) this.b.get(i));
            this.b.remove(i);
        }

        void b(u uVar) {
            boolean z = true;
            int i = 0;
            if (uVar.i() || uVar.a.getParent() != null) {
                StringBuilder append = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(uVar.i()).append(" isAttached:");
                if (uVar.a.getParent() == null) {
                    z = false;
                }
                throw new IllegalArgumentException(append.append(z).toString());
            } else if (uVar.r()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + uVar);
            } else if (uVar.c()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            } else {
                int i2;
                boolean c = uVar.C();
                boolean z2 = this.c.w != null && c && this.c.w.b(uVar);
                if (z2 || uVar.w()) {
                    if (!uVar.a(14)) {
                        int size = this.b.size();
                        if (size >= this.f && size > 0) {
                            d(0);
                            size--;
                        }
                        if (size < this.f) {
                            this.b.add(uVar);
                            z2 = true;
                            if (z2) {
                                c(uVar);
                                i = 1;
                                i2 = z2;
                            } else {
                                z = z2;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                        z = z2;
                    } else {
                        c(uVar);
                        i = 1;
                        i2 = z2;
                    }
                } else {
                    i2 = 0;
                }
                this.c.e.g(uVar);
                if (i2 == 0 && r1 == 0 && c) {
                    uVar.k = null;
                }
            }
        }

        void c(u uVar) {
            ah.a(uVar.a, null);
            e(uVar);
            uVar.k = null;
            f().a(uVar);
        }

        void b(View view) {
            u d = RecyclerView.d(view);
            d.o = null;
            d.p = false;
            d.l();
            b(d);
        }

        void c(View view) {
            u d = RecyclerView.d(view);
            if (!d.a(12) && d.x() && !this.c.c(d)) {
                if (this.d == null) {
                    this.d = new ArrayList();
                }
                d.a(this, true);
                this.d.add(d);
            } else if (!d.n() || d.q() || this.c.w.b()) {
                d.a(this, false);
                this.a.add(d);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            }
        }

        void d(u uVar) {
            if (uVar.p) {
                this.d.remove(uVar);
            } else {
                this.a.remove(uVar);
            }
            uVar.o = null;
            uVar.p = false;
            uVar.l();
        }

        int d() {
            return this.a.size();
        }

        View e(int i) {
            return ((u) this.a.get(i)).a;
        }

        void e() {
            this.a.clear();
            if (this.d != null) {
                this.d.clear();
            }
        }

        u f(int i) {
            int i2 = 0;
            if (this.d != null) {
                int size = this.d.size();
                if (size != 0) {
                    u uVar;
                    int i3 = 0;
                    while (i3 < size) {
                        uVar = (u) this.d.get(i3);
                        if (uVar.k() || uVar.d() != i) {
                            i3++;
                        } else {
                            uVar.b(32);
                            return uVar;
                        }
                    }
                    if (this.c.w.b()) {
                        int b = this.c.c.b(i);
                        if (b > 0 && b < this.c.w.a()) {
                            long b2 = this.c.w.b(b);
                            while (i2 < size) {
                                uVar = (u) this.d.get(i2);
                                if (uVar.k() || uVar.g() != b2) {
                                    i2++;
                                } else {
                                    uVar.b(32);
                                    return uVar;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        u a(int i, int i2, boolean z) {
            View a;
            int i3 = 0;
            int size = this.a.size();
            int i4 = 0;
            while (i4 < size) {
                u uVar = (u) this.a.get(i4);
                if (uVar.k() || uVar.d() != i || uVar.n() || (!this.c.i.k && uVar.q())) {
                    i4++;
                } else if (i2 == -1 || uVar.h() == i2) {
                    uVar.b(32);
                    return uVar;
                } else {
                    Log.e("RecyclerView", "Scrap view for position " + i + " isn't dirty but has" + " wrong view type! (found " + uVar.h() + " but expected " + i2 + ")");
                    if (!z) {
                        a = this.c.d.a(i, i2);
                        if (a != null) {
                            uVar = RecyclerView.d(a);
                            this.c.d.e(a);
                            i3 = this.c.d.b(a);
                            if (i3 != -1) {
                                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + uVar);
                            }
                            this.c.d.d(i3);
                            c(a);
                            uVar.b(8224);
                            return uVar;
                        }
                    }
                    i4 = this.b.size();
                    while (i3 < i4) {
                        uVar = (u) this.b.get(i3);
                        if (uVar.n() || uVar.d() != i) {
                            i3++;
                        } else if (z) {
                            return uVar;
                        } else {
                            this.b.remove(i3);
                            return uVar;
                        }
                    }
                    return null;
                }
            }
            if (z) {
                a = this.c.d.a(i, i2);
                if (a != null) {
                    uVar = RecyclerView.d(a);
                    this.c.d.e(a);
                    i3 = this.c.d.b(a);
                    if (i3 != -1) {
                        this.c.d.d(i3);
                        c(a);
                        uVar.b(8224);
                        return uVar;
                    }
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + uVar);
                }
            }
            i4 = this.b.size();
            while (i3 < i4) {
                uVar = (u) this.b.get(i3);
                if (uVar.n()) {
                }
                i3++;
            }
            return null;
        }

        u a(long j, int i, boolean z) {
            int size;
            for (size = this.a.size() - 1; size >= 0; size--) {
                u uVar = (u) this.a.get(size);
                if (uVar.g() == j && !uVar.k()) {
                    if (i == uVar.h()) {
                        uVar.b(32);
                        if (!uVar.q() || this.c.i.a()) {
                            return uVar;
                        }
                        uVar.a(2, 14);
                        return uVar;
                    } else if (!z) {
                        this.a.remove(size);
                        this.c.removeDetachedView(uVar.a, false);
                        b(uVar.a);
                    }
                }
            }
            for (size = this.b.size() - 1; size >= 0; size--) {
                uVar = (u) this.b.get(size);
                if (uVar.g() == j) {
                    if (i == uVar.h()) {
                        if (z) {
                            return uVar;
                        }
                        this.b.remove(size);
                        return uVar;
                    } else if (!z) {
                        d(size);
                    }
                }
            }
            return null;
        }

        void e(u uVar) {
            if (this.c.x != null) {
                this.c.x.a(uVar);
            }
            if (this.c.w != null) {
                this.c.w.a(uVar);
            }
            if (this.c.i != null) {
                this.c.e.g(uVar);
            }
        }

        void a(a aVar, a aVar2, boolean z) {
            a();
            f().a(aVar, aVar2, z);
        }

        void a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i3 = -1;
                i4 = i2;
                i5 = i;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.b.size();
            for (int i6 = 0; i6 < size; i6++) {
                u uVar = (u) this.b.get(i6);
                if (uVar != null && uVar.b >= r3 && uVar.b <= r2) {
                    if (uVar.b == i) {
                        uVar.a(i2 - i, false);
                    } else {
                        uVar.a(i3, false);
                    }
                }
            }
        }

        void b(int i, int i2) {
            int size = this.b.size();
            for (int i3 = 0; i3 < size; i3++) {
                u uVar = (u) this.b.get(i3);
                if (uVar != null && uVar.b >= i) {
                    uVar.a(i2, true);
                }
            }
        }

        void b(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.b.size() - 1; size >= 0; size--) {
                u uVar = (u) this.b.get(size);
                if (uVar != null) {
                    if (uVar.b >= i3) {
                        uVar.a(-i2, z);
                    } else if (uVar.b >= i) {
                        uVar.b(8);
                        d(size);
                    }
                }
            }
        }

        void a(s sVar) {
            this.h = sVar;
        }

        void a(m mVar) {
            if (this.g != null) {
                this.g.b();
            }
            this.g = mVar;
            if (mVar != null) {
                this.g.a(this.c.getAdapter());
            }
        }

        m f() {
            if (this.g == null) {
                this.g = new m();
            }
            return this.g;
        }

        void c(int i, int i2) {
            int i3 = i + i2;
            for (int size = this.b.size() - 1; size >= 0; size--) {
                u uVar = (u) this.b.get(size);
                if (uVar != null) {
                    int d = uVar.d();
                    if (d >= i && d < i3) {
                        uVar.b(2);
                        d(size);
                    }
                }
            }
        }

        void g() {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                u uVar = (u) this.b.get(i);
                if (uVar != null) {
                    uVar.b(512);
                }
            }
        }

        void h() {
            if (this.c.w == null || !this.c.w.b()) {
                c();
                return;
            }
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                u uVar = (u) this.b.get(i);
                if (uVar != null) {
                    uVar.b(6);
                    uVar.a(null);
                }
            }
        }

        void i() {
            int i;
            int i2 = 0;
            int size = this.b.size();
            for (i = 0; i < size; i++) {
                ((u) this.b.get(i)).a();
            }
            size = this.a.size();
            for (i = 0; i < size; i++) {
                ((u) this.a.get(i)).a();
            }
            if (this.d != null) {
                i = this.d.size();
                while (i2 < i) {
                    ((u) this.d.get(i2)).a();
                    i2++;
                }
            }
        }

        void j() {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                i iVar = (i) ((u) this.b.get(i)).a.getLayoutParams();
                if (iVar != null) {
                    iVar.c = true;
                }
            }
        }
    }

    public interface o {
        void a(u uVar);
    }

    private class p extends c {
        final /* synthetic */ RecyclerView a;

        private p(RecyclerView recyclerView) {
            this.a = recyclerView;
        }

        public void a() {
            this.a.a(null);
            if (this.a.w.b()) {
                this.a.i.j = true;
                this.a.L();
            } else {
                this.a.i.j = true;
                this.a.L();
            }
            if (!this.a.c.d()) {
                this.a.requestLayout();
            }
        }

        public void a(int i, int i2, Object obj) {
            this.a.a(null);
            if (this.a.c.a(i, i2, obj)) {
                b();
            }
        }

        public void b(int i, int i2) {
            this.a.a(null);
            if (this.a.c.b(i, i2)) {
                b();
            }
        }

        public void c(int i, int i2) {
            this.a.a(null);
            if (this.a.c.c(i, i2)) {
                b();
            }
        }

        public void a(int i, int i2, int i3) {
            this.a.a(null);
            if (this.a.c.a(i, i2, i3)) {
                b();
            }
        }

        void b() {
            if (this.a.J && this.a.C && this.a.B) {
                ah.a(this.a, this.a.s);
                return;
            }
            this.a.I = true;
            this.a.requestLayout();
        }
    }

    public static class r {
        int a = 0;
        int b;
        long c;
        int d;
        private int e = -1;
        private int f = 1;
        private SparseArray<Object> g;
        private int h = 0;
        private int i = 0;
        private boolean j = false;
        private boolean k = false;
        private boolean l = false;
        private boolean m = false;
        private boolean n = false;
        private boolean o = false;

        void a(int i) {
            if ((this.f & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f));
            }
        }

        public boolean a() {
            return this.k;
        }

        public boolean b() {
            return this.m;
        }

        public int c() {
            return this.e;
        }

        public boolean d() {
            return this.e != -1;
        }

        public int e() {
            return this.k ? this.h - this.i : this.a;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.e + ", mData=" + this.g + ", mItemCount=" + this.a + ", mPreviousLayoutItemCount=" + this.h + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.i + ", mStructureChanged=" + this.j + ", mInPreLayout=" + this.k + ", mRunSimpleAnimations=" + this.l + ", mRunPredictiveAnimations=" + this.m + '}';
        }
    }

    public static abstract class s {
        public abstract View a(n nVar, int i, int i2);
    }

    private class t implements Runnable {
        final /* synthetic */ RecyclerView a;
        private int b;
        private int c;
        private android.support.v4.widget.q d;
        private Interpolator e = RecyclerView.au;
        private boolean f = false;
        private boolean g = false;

        public t(RecyclerView recyclerView) {
            this.a = recyclerView;
            this.d = android.support.v4.widget.q.a(recyclerView.getContext(), RecyclerView.au);
        }

        public void run() {
            if (this.a.f == null) {
                b();
                return;
            }
            c();
            this.a.t();
            android.support.v4.widget.q qVar = this.d;
            q qVar2 = this.a.f.r;
            if (qVar.g()) {
                int e;
                int i;
                int f;
                int i2;
                Object obj;
                Object obj2;
                int b = qVar.b();
                int c = qVar.c();
                int i3 = b - this.b;
                int i4 = c - this.c;
                int i5 = 0;
                int i6 = 0;
                this.b = b;
                this.c = c;
                int i7 = 0;
                int i8 = 0;
                if (this.a.w != null) {
                    this.a.b();
                    this.a.z();
                    android.support.v4.d.h.a("RV Scroll");
                    if (i3 != 0) {
                        i5 = this.a.f.a(i3, this.a.b, this.a.i);
                        i7 = i3 - i5;
                    }
                    if (i4 != 0) {
                        i6 = this.a.f.b(i4, this.a.b, this.a.i);
                        i8 = i4 - i6;
                    }
                    android.support.v4.d.h.a();
                    this.a.M();
                    this.a.A();
                    this.a.a(false);
                    if (!(qVar2 == null || qVar2.g() || !qVar2.h())) {
                        e = this.a.i.e();
                        if (e == 0) {
                            qVar2.f();
                            i = i7;
                            i7 = i6;
                            i6 = i;
                        } else if (qVar2.i() >= e) {
                            qVar2.d(e - 1);
                            qVar2.a(i3 - i7, i4 - i8);
                            i = i7;
                            i7 = i6;
                            i6 = i;
                        } else {
                            qVar2.a(i3 - i7, i4 - i8);
                        }
                        if (!this.a.y.isEmpty()) {
                            this.a.invalidate();
                        }
                        if (ah.a(this.a) != 2) {
                            this.a.i(i3, i4);
                        }
                        if (!(i6 == 0 && i8 == 0)) {
                            f = (int) qVar.f();
                            if (i6 == b) {
                                e = i6 >= 0 ? -f : i6 <= 0 ? f : 0;
                                i2 = e;
                            } else {
                                i2 = 0;
                            }
                            if (i8 != c) {
                                f = 0;
                            } else if (i8 < 0) {
                                f = -f;
                            } else if (i8 <= 0) {
                                f = 0;
                            }
                            if (ah.a(this.a) != 2) {
                                this.a.c(i2, f);
                            }
                            if ((i2 != 0 || i6 == b || qVar.d() == 0) && (f != 0 || i8 == c || qVar.e() == 0)) {
                                qVar.h();
                            }
                        }
                        if (!(i5 == 0 && i7 == 0)) {
                            this.a.h(i5, i7);
                        }
                        if (!this.a.awakenScrollBars()) {
                            this.a.invalidate();
                        }
                        obj = (i4 == 0 && this.a.f.e() && i7 == i4) ? 1 : null;
                        obj2 = (i3 == 0 && this.a.f.d() && i5 == i3) ? 1 : null;
                        obj2 = ((i3 == 0 || i4 != 0) && obj2 == null && obj == null) ? null : 1;
                        if (!qVar.a() || obj2 == null) {
                            this.a.setScrollState(0);
                        } else {
                            a();
                        }
                    }
                }
                i = i7;
                i7 = i6;
                i6 = i;
                if (this.a.y.isEmpty()) {
                    this.a.invalidate();
                }
                if (ah.a(this.a) != 2) {
                    this.a.i(i3, i4);
                }
                f = (int) qVar.f();
                if (i6 == b) {
                    i2 = 0;
                } else {
                    if (i6 >= 0) {
                        if (i6 <= 0) {
                        }
                    }
                    i2 = e;
                }
                if (i8 != c) {
                    f = 0;
                } else if (i8 < 0) {
                    f = -f;
                } else if (i8 <= 0) {
                    f = 0;
                }
                if (ah.a(this.a) != 2) {
                    this.a.c(i2, f);
                }
                qVar.h();
                this.a.h(i5, i7);
                if (this.a.awakenScrollBars()) {
                    this.a.invalidate();
                }
                if (i4 == 0) {
                }
                if (i3 == 0) {
                }
                if (i3 == 0) {
                }
                if (qVar.a()) {
                }
                this.a.setScrollState(0);
            }
            if (qVar2 != null) {
                if (qVar2.g()) {
                    qVar2.a(0, 0);
                }
                if (!this.g) {
                    qVar2.f();
                }
            }
            d();
        }

        private void c() {
            this.g = false;
            this.f = true;
        }

        private void d() {
            this.f = false;
            if (this.g) {
                a();
            }
        }

        void a() {
            if (this.f) {
                this.g = true;
                return;
            }
            this.a.removeCallbacks(this);
            ah.a(this.a, (Runnable) this);
        }

        public void a(int i, int i2) {
            this.a.setScrollState(2);
            this.c = 0;
            this.b = 0;
            this.d.a(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            a();
        }

        public void b(int i, int i2) {
            a(i, i2, 0, 0);
        }

        public void a(int i, int i2, int i3, int i4) {
            a(i, i2, b(i, i2, i3, i4));
        }

        private float a(float f) {
            return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
        }

        private int b(int i, int i2, int i3, int i4) {
            int round;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            Object obj = abs > abs2 ? 1 : null;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = obj != null ? this.a.getWidth() : this.a.getHeight();
            int i5 = width / 2;
            float a = (a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width))) * ((float) i5)) + ((float) i5);
            if (sqrt > 0) {
                round = Math.round(1000.0f * Math.abs(a / ((float) sqrt))) * 4;
            } else {
                if (obj != null) {
                    round = abs;
                } else {
                    round = abs2;
                }
                round = (int) (((((float) round) / ((float) width)) + 1.0f) * 300.0f);
            }
            return Math.min(round, 2000);
        }

        public void a(int i, int i2, int i3) {
            a(i, i2, i3, RecyclerView.au);
        }

        public void a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.e != interpolator) {
                this.e = interpolator;
                this.d = android.support.v4.widget.q.a(this.a.getContext(), interpolator);
            }
            this.a.setScrollState(2);
            this.c = 0;
            this.b = 0;
            this.d.a(0, 0, i, i2, i3);
            a();
        }

        public void b() {
            this.a.removeCallbacks(this);
            this.d.h();
        }
    }

    public static abstract class u {
        private static final List<Object> m = Collections.EMPTY_LIST;
        public final View a;
        int b = -1;
        int c = -1;
        long d = -1;
        int e = -1;
        int f = -1;
        u g = null;
        u h = null;
        List<Object> i = null;
        List<Object> j = null;
        RecyclerView k;
        private int l;
        private int n = 0;
        private n o = null;
        private boolean p = false;
        private int q = 0;

        public u(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.a = view;
        }

        void a(int i, int i2, boolean z) {
            b(8);
            a(i2, z);
            this.b = i;
        }

        void a(int i, boolean z) {
            if (this.c == -1) {
                this.c = this.b;
            }
            if (this.f == -1) {
                this.f = this.b;
            }
            if (z) {
                this.f += i;
            }
            this.b += i;
            if (this.a.getLayoutParams() != null) {
                ((i) this.a.getLayoutParams()).c = true;
            }
        }

        void a() {
            this.c = -1;
            this.f = -1;
        }

        void b() {
            if (this.c == -1) {
                this.c = this.b;
            }
        }

        boolean c() {
            return (this.l & 128) != 0;
        }

        public final int d() {
            return this.f == -1 ? this.b : this.f;
        }

        public final int e() {
            if (this.k == null) {
                return -1;
            }
            return this.k.d(this);
        }

        public final int f() {
            return this.c;
        }

        public final long g() {
            return this.d;
        }

        public final int h() {
            return this.e;
        }

        boolean i() {
            return this.o != null;
        }

        void j() {
            this.o.d(this);
        }

        boolean k() {
            return (this.l & 32) != 0;
        }

        void l() {
            this.l &= -33;
        }

        void m() {
            this.l &= -257;
        }

        void a(n nVar, boolean z) {
            this.o = nVar;
            this.p = z;
        }

        boolean n() {
            return (this.l & 4) != 0;
        }

        boolean o() {
            return (this.l & 2) != 0;
        }

        boolean p() {
            return (this.l & 1) != 0;
        }

        boolean q() {
            return (this.l & 8) != 0;
        }

        boolean a(int i) {
            return (this.l & i) != 0;
        }

        boolean r() {
            return (this.l & 256) != 0;
        }

        boolean s() {
            return (this.l & 512) != 0 || n();
        }

        void a(int i, int i2) {
            this.l = (this.l & (i2 ^ -1)) | (i & i2);
        }

        void b(int i) {
            this.l |= i;
        }

        void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((this.l & 1024) == 0) {
                y();
                this.i.add(obj);
            }
        }

        private void y() {
            if (this.i == null) {
                this.i = new ArrayList();
                this.j = Collections.unmodifiableList(this.i);
            }
        }

        void t() {
            if (this.i != null) {
                this.i.clear();
            }
            this.l &= -1025;
        }

        List<Object> u() {
            if ((this.l & 1024) != 0) {
                return m;
            }
            if (this.i == null || this.i.size() == 0) {
                return m;
            }
            return this.j;
        }

        void v() {
            this.l = 0;
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.f = -1;
            this.n = 0;
            this.g = null;
            this.h = null;
            t();
            this.q = 0;
        }

        private void z() {
            this.q = ah.e(this.a);
            ah.c(this.a, 4);
        }

        private void A() {
            ah.c(this.a, this.q);
            this.q = 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.b + " id=" + this.d + ", oldPos=" + this.c + ", pLpos:" + this.f);
            if (i()) {
                stringBuilder.append(" scrap ").append(this.p ? "[changeScrap]" : "[attachedScrap]");
            }
            if (n()) {
                stringBuilder.append(" invalid");
            }
            if (!p()) {
                stringBuilder.append(" unbound");
            }
            if (o()) {
                stringBuilder.append(" update");
            }
            if (q()) {
                stringBuilder.append(" removed");
            }
            if (c()) {
                stringBuilder.append(" ignored");
            }
            if (r()) {
                stringBuilder.append(" tmpDetached");
            }
            if (!w()) {
                stringBuilder.append(" not recyclable(" + this.n + ")");
            }
            if (s()) {
                stringBuilder.append(" undefined adapter position");
            }
            if (this.a.getParent() == null) {
                stringBuilder.append(" no parent");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public final void a(boolean z) {
            this.n = z ? this.n - 1 : this.n + 1;
            if (this.n < 0) {
                this.n = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && this.n == 1) {
                this.l |= 16;
            } else if (z && this.n == 0) {
                this.l &= -17;
            }
        }

        public final boolean w() {
            return (this.l & 16) == 0 && !ah.c(this.a);
        }

        private boolean B() {
            return (this.l & 16) != 0;
        }

        private boolean C() {
            return (this.l & 16) == 0 && ah.c(this.a);
        }

        boolean x() {
            return (this.l & 2) != 0;
        }
    }

    static {
        boolean z = VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20;
        n = z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        a = z;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2 = true;
        super(context, attributeSet, i);
        this.p = new p();
        this.b = new n(this);
        this.e = new bc();
        this.s = new Runnable(this) {
            final /* synthetic */ RecyclerView a;

            {
                this.a = r1;
            }

            public void run() {
                if (this.a.g && !this.a.isLayoutRequested()) {
                    if (!this.a.B) {
                        this.a.requestLayout();
                    } else if (this.a.F) {
                        this.a.E = true;
                    } else {
                        this.a.t();
                    }
                }
            }
        };
        this.t = new Rect();
        this.u = new Rect();
        this.v = new RectF();
        this.y = new ArrayList();
        this.z = new ArrayList();
        this.D = 0;
        this.M = false;
        this.N = 0;
        this.h = new x();
        this.S = 0;
        this.T = -1;
        this.af = Float.MIN_VALUE;
        this.ag = true;
        this.ah = new t(this);
        this.i = new r();
        this.j = false;
        this.k = false;
        this.ak = new f();
        this.al = false;
        this.ao = new int[2];
        this.aq = new int[2];
        this.ar = new int[2];
        this.as = new int[2];
        this.at = new Runnable(this) {
            final /* synthetic */ RecyclerView a;

            {
                this.a = r1;
            }

            public void run() {
                if (this.a.h != null) {
                    this.a.h.a();
                }
                this.a.al = false;
            }
        };
        this.av = new b(this) {
            final /* synthetic */ RecyclerView a;

            {
                this.a = r1;
            }

            public void a(u uVar, c cVar, c cVar2) {
                this.a.b.d(uVar);
                this.a.b(uVar, cVar, cVar2);
            }

            public void b(u uVar, c cVar, c cVar2) {
                this.a.a(uVar, cVar, cVar2);
            }

            public void c(u uVar, c cVar, c cVar2) {
                uVar.a(false);
                if (this.a.M) {
                    if (this.a.h.a(uVar, uVar, cVar, cVar2)) {
                        this.a.C();
                    }
                } else if (this.a.h.c(uVar, cVar, cVar2)) {
                    this.a.C();
                }
            }

            public void a(u uVar) {
                this.a.f.a(uVar.a, this.a.b);
            }
        };
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m, i, 0);
            this.r = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.r = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        if (VERSION.SDK_INT >= 16) {
            z = true;
        } else {
            z = false;
        }
        this.J = z;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.ac = viewConfiguration.getScaledTouchSlop();
        this.ad = viewConfiguration.getScaledMinimumFlingVelocity();
        this.ae = viewConfiguration.getScaledMaximumFlingVelocity();
        if (ah.a(this) == 2) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        this.h.a(this.ak);
        a();
        s();
        if (ah.e(this) == 0) {
            ah.c((View) this, 1);
        }
        this.K = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new al(this));
        if (attributeSet != null) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.f.a.c.RecyclerView, i, 0);
            String string = obtainStyledAttributes.getString(android.support.v7.f.a.c.RecyclerView_layoutManager);
            if (obtainStyledAttributes.getInt(android.support.v7.f.a.c.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            obtainStyledAttributes.recycle();
            a(context, string, attributeSet, i, 0);
            if (VERSION.SDK_INT >= 21) {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l, i, 0);
                z2 = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z2);
    }

    public al getCompatAccessibilityDelegate() {
        return this.am;
    }

    public void setAccessibilityDelegateCompat(al alVar) {
        this.am = alVar;
        ah.a((View) this, this.am);
    }

    private void a(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        if (str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                String a = a(context, trim);
                try {
                    ClassLoader classLoader;
                    Object[] objArr;
                    Constructor constructor;
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class asSubclass = classLoader.loadClass(a).asSubclass(h.class);
                    try {
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                        constructor = asSubclass.getConstructor(o);
                    } catch (Throwable e) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                        objArr = null;
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((h) constructor.newInstance(objArr));
                } catch (Throwable e2) {
                    e2.initCause(e);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a, e2);
                } catch (Throwable e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a, e3);
                } catch (Throwable e32) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e32);
                } catch (Throwable e322) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e322);
                } catch (Throwable e3222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a, e3222);
                } catch (Throwable e32222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a, e32222);
                }
            }
        }
    }

    private String a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        return !str.contains(".") ? RecyclerView.class.getPackage().getName() + '.' + str : str;
    }

    private void s() {
        this.d = new v(new b(this) {
            final /* synthetic */ RecyclerView a;

            {
                this.a = r1;
            }

            public int a() {
                return this.a.getChildCount();
            }

            public void a(View view, int i) {
                this.a.addView(view, i);
                this.a.l(view);
            }

            public int a(View view) {
                return this.a.indexOfChild(view);
            }

            public void a(int i) {
                View childAt = this.a.getChildAt(i);
                if (childAt != null) {
                    this.a.k(childAt);
                }
                this.a.removeViewAt(i);
            }

            public View b(int i) {
                return this.a.getChildAt(i);
            }

            public void b() {
                int a = a();
                for (int i = 0; i < a; i++) {
                    this.a.k(b(i));
                }
                this.a.removeAllViews();
            }

            public u b(View view) {
                return RecyclerView.d(view);
            }

            public void a(View view, int i, LayoutParams layoutParams) {
                u d = RecyclerView.d(view);
                if (d != null) {
                    if (d.r() || d.c()) {
                        d.m();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + d);
                    }
                }
                this.a.attachViewToParent(view, i, layoutParams);
            }

            public void c(int i) {
                View b = b(i);
                if (b != null) {
                    u d = RecyclerView.d(b);
                    if (d != null) {
                        if (!d.r() || d.c()) {
                            d.b(256);
                        } else {
                            throw new IllegalArgumentException("called detach on an already detached child " + d);
                        }
                    }
                }
                this.a.detachViewFromParent(i);
            }

            public void c(View view) {
                u d = RecyclerView.d(view);
                if (d != null) {
                    d.z();
                }
            }

            public void d(View view) {
                u d = RecyclerView.d(view);
                if (d != null) {
                    d.A();
                }
            }
        });
    }

    void a() {
        this.c = new f(new a(this) {
            final /* synthetic */ RecyclerView a;

            {
                this.a = r1;
            }

            public u a(int i) {
                u a = this.a.a(i, true);
                if (a == null || this.a.d.c(a.a)) {
                    return null;
                }
                return a;
            }

            public void a(int i, int i2) {
                this.a.a(i, i2, true);
                this.a.j = true;
                r rVar = this.a.i;
                rVar.i = rVar.i + i2;
            }

            public void b(int i, int i2) {
                this.a.a(i, i2, false);
                this.a.j = true;
            }

            public void a(int i, int i2, Object obj) {
                this.a.a(i, i2, obj);
                this.a.k = true;
            }

            public void a(b bVar) {
                c(bVar);
            }

            void c(b bVar) {
                switch (bVar.a) {
                    case 1:
                        this.a.f.a(this.a, bVar.b, bVar.d);
                        return;
                    case 2:
                        this.a.f.b(this.a, bVar.b, bVar.d);
                        return;
                    case 4:
                        this.a.f.a(this.a, bVar.b, bVar.d, bVar.c);
                        return;
                    case 8:
                        this.a.f.a(this.a, bVar.b, bVar.d, 1);
                        return;
                    default:
                        return;
                }
            }

            public void b(b bVar) {
                c(bVar);
            }

            public void c(int i, int i2) {
                this.a.f(i, i2);
                this.a.j = true;
            }

            public void d(int i, int i2) {
                this.a.e(i, i2);
                this.a.j = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.C = z;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.r) {
            h();
        }
        this.r = z;
        super.setClipToPadding(z);
        if (this.g) {
            requestLayout();
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.ac = ar.a(viewConfiguration);
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.ac = viewConfiguration.getScaledTouchSlop();
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        a(aVar, false, true);
        requestLayout();
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (this.w != null) {
            this.w.b(this.p);
            this.w.b(this);
        }
        if (!z || z2) {
            if (this.h != null) {
                this.h.c();
            }
            if (this.f != null) {
                this.f.c(this.b);
                this.f.b(this.b);
            }
            this.b.a();
        }
        this.c.a();
        a aVar2 = this.w;
        this.w = aVar;
        if (aVar != null) {
            aVar.a(this.p);
            aVar.a(this);
        }
        if (this.f != null) {
            this.f.a(aVar2, this.w);
        }
        this.b.a(aVar2, this.w, z);
        this.i.j = true;
        o();
    }

    public a getAdapter() {
        return this.w;
    }

    public void setRecyclerListener(o oVar) {
        this.x = oVar;
    }

    public int getBaseline() {
        if (this.f != null) {
            return this.f.s();
        }
        return super.getBaseline();
    }

    public void a(j jVar) {
        if (this.L == null) {
            this.L = new ArrayList();
        }
        this.L.add(jVar);
    }

    public void b(j jVar) {
        if (this.L != null) {
            this.L.remove(jVar);
        }
    }

    public void setLayoutManager(h hVar) {
        if (hVar != this.f) {
            c();
            if (this.f != null) {
                if (this.B) {
                    this.f.b(this, this.b);
                }
                this.f.b(null);
            }
            this.b.a();
            this.d.a();
            this.f = hVar;
            if (hVar != null) {
                if (hVar.q != null) {
                    throw new IllegalArgumentException("LayoutManager " + hVar + " is already attached to a RecyclerView: " + hVar.q);
                }
                this.f.b(this);
                if (this.B) {
                    this.f.c(this);
                }
            }
            requestLayout();
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.q != null) {
            savedState.a(this.q);
        } else if (this.f != null) {
            savedState.b = this.f.c();
        } else {
            savedState.b = null;
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.q = (SavedState) parcelable;
            super.onRestoreInstanceState(this.q.a());
            if (this.f != null && this.q.b != null) {
                this.f.a(this.q.b);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void b(u uVar) {
        View view = uVar.a;
        boolean z = view.getParent() == this;
        this.b.d(a(view));
        if (uVar.r()) {
            this.d.a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.d.d(view);
        } else {
            this.d.a(view, true);
        }
    }

    private boolean i(View view) {
        b();
        boolean f = this.d.f(view);
        if (f) {
            u d = d(view);
            this.b.d(d);
            this.b.b(d);
        }
        a(!f);
        return f;
    }

    public h getLayoutManager() {
        return this.f;
    }

    public m getRecycledViewPool() {
        return this.b.f();
    }

    public void setRecycledViewPool(m mVar) {
        this.b.a(mVar);
    }

    public void setViewCacheExtension(s sVar) {
        this.b.a(sVar);
    }

    public void setItemViewCacheSize(int i) {
        this.b.a(i);
    }

    public int getScrollState() {
        return this.S;
    }

    private void setScrollState(int i) {
        if (i != this.S) {
            this.S = i;
            if (i != 2) {
                v();
            }
            g(i);
        }
    }

    public void a(g gVar, int i) {
        if (this.f != null) {
            this.f.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.y.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.y.add(gVar);
        } else {
            this.y.add(i, gVar);
        }
        l();
        requestLayout();
    }

    public void a(g gVar) {
        a(gVar, -1);
    }

    public void b(g gVar) {
        if (this.f != null) {
            this.f.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.y.remove(gVar);
        if (this.y.isEmpty()) {
            setWillNotDraw(ah.a(this) == 2);
        }
        l();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar != this.an) {
            this.an = dVar;
            setChildrenDrawingOrderEnabled(this.an != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(l lVar) {
        this.ai = lVar;
    }

    public void a(int i) {
        if (!this.F) {
            c();
            if (this.f == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            this.f.e(i);
            awakenScrollBars();
        }
    }

    private void h(int i) {
        if (this.f != null) {
            this.f.e(i);
            awakenScrollBars();
        }
    }

    public void b(int i) {
        if (!this.F) {
            if (this.f == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                this.f.a(this, this.i, i);
            }
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollBy(int i, int i2) {
        if (this.f == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.F) {
            boolean d = this.f.d();
            boolean e = this.f.e();
            if (d || e) {
                if (!d) {
                    i = 0;
                }
                if (!e) {
                    i2 = 0;
                }
                a(i, i2, null);
            }
        }
    }

    private void t() {
        if (!this.g || this.M) {
            android.support.v4.d.h.a("RV FullInvalidate");
            k();
            android.support.v4.d.h.a();
        } else if (!this.c.d()) {
        } else {
            if (this.c.a(4) && !this.c.a(11)) {
                android.support.v4.d.h.a("RV PartialInvalidate");
                b();
                this.c.b();
                if (!this.E) {
                    if (u()) {
                        k();
                    } else {
                        this.c.c();
                    }
                }
                a(true);
                android.support.v4.d.h.a();
            } else if (this.c.d()) {
                android.support.v4.d.h.a("RV FullInvalidate");
                k();
                android.support.v4.d.h.a();
            }
        }
    }

    private boolean u() {
        int b = this.d.b();
        for (int i = 0; i < b; i++) {
            u d = d(this.d.b(i));
            if (d != null && !d.c() && d.x()) {
                return true;
            }
        }
        return false;
    }

    boolean a(int i, int i2, MotionEvent motionEvent) {
        int a;
        int i3;
        int i4;
        int i5;
        t();
        if (this.w != null) {
            int b;
            b();
            z();
            android.support.v4.d.h.a("RV Scroll");
            if (i != 0) {
                a = this.f.a(i, this.b, this.i);
                i3 = i - a;
            } else {
                a = 0;
                i3 = 0;
            }
            if (i2 != 0) {
                b = this.f.b(i2, this.b, this.i);
                i4 = i2 - b;
            } else {
                b = 0;
                i4 = 0;
            }
            android.support.v4.d.h.a();
            M();
            A();
            a(false);
            i5 = i4;
            i4 = a;
            a = b;
        } else {
            a = 0;
            i4 = 0;
            i5 = 0;
            i3 = 0;
        }
        if (!this.y.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, a, i3, i5, this.aq)) {
            this.aa -= this.aq[0];
            this.ab -= this.aq[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.aq[0], (float) this.aq[1]);
            }
            int[] iArr = this.as;
            iArr[0] = iArr[0] + this.aq[0];
            iArr = this.as;
            iArr[1] = iArr[1] + this.aq[1];
        } else if (ah.a(this) != 2) {
            if (motionEvent != null) {
                a(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i5);
            }
            i(i, i2);
        }
        if (!(i4 == 0 && a == 0)) {
            h(i4, a);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i4 == 0 && a == 0) {
            return false;
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        if (this.f != null && this.f.d()) {
            return this.f.c(this.i);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        if (this.f != null && this.f.d()) {
            return this.f.e(this.i);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        if (this.f != null && this.f.d()) {
            return this.f.g(this.i);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        if (this.f != null && this.f.e()) {
            return this.f.d(this.i);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        if (this.f != null && this.f.e()) {
            return this.f.f(this.i);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        if (this.f != null && this.f.e()) {
            return this.f.h(this.i);
        }
        return 0;
    }

    void b() {
        this.D++;
        if (this.D == 1 && !this.F) {
            this.E = false;
        }
    }

    void a(boolean z) {
        if (this.D < 1) {
            this.D = 1;
        }
        if (!z) {
            this.E = false;
        }
        if (this.D == 1) {
            if (!(!z || !this.E || this.F || this.f == null || this.w == null)) {
                k();
            }
            if (!this.F) {
                this.E = false;
            }
        }
        this.D--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.F) {
            a("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.F = true;
                this.G = true;
                c();
                return;
            }
            this.F = false;
            if (!(!this.E || this.f == null || this.w == null)) {
                requestLayout();
            }
            this.E = false;
        }
    }

    public void a(int i, int i2) {
        int i3 = 0;
        if (this.f == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.F) {
            if (!this.f.d()) {
                i = 0;
            }
            if (this.f.e()) {
                i3 = i2;
            }
            if (i != 0 || i3 != 0) {
                this.ah.b(i, i3);
            }
        }
    }

    public boolean b(int i, int i2) {
        if (this.f == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.F) {
            return false;
        } else {
            boolean d = this.f.d();
            boolean e = this.f.e();
            if (!d || Math.abs(i) < this.ad) {
                i = 0;
            }
            if (!e || Math.abs(i2) < this.ad) {
                i2 = 0;
            }
            if ((i == 0 && i2 == 0) || dispatchNestedPreFling((float) i, (float) i2)) {
                return false;
            }
            d = d || e;
            dispatchNestedFling((float) i, (float) i2, d);
            if (!d) {
                return false;
            }
            this.ah.a(Math.max(-this.ae, Math.min(i, this.ae)), Math.max(-this.ae, Math.min(i2, this.ae)));
            return true;
        }
    }

    public void c() {
        setScrollState(0);
        v();
    }

    private void v() {
        this.ah.b();
        if (this.f != null) {
            this.f.F();
        }
    }

    public int getMinFlingVelocity() {
        return this.ad;
    }

    public int getMaxFlingVelocity() {
        return this.ae;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(float r8, float r9, float r10, float r11) {
        /*
        r7 = this;
        r6 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = 1;
        r5 = 0;
        r1 = 0;
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x0050;
    L_0x0009:
        r7.d();
        r2 = r7.O;
        r3 = -r9;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r4 = r6 - r4;
        r2 = r2.a(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x0024:
        r1 = r0;
    L_0x0025:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x006f;
    L_0x0029:
        r7.f();
        r2 = r7.P;
        r3 = -r11;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r2 = r2.a(r3, r4);
        if (r2 == 0) goto L_0x008e;
    L_0x0042:
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r0 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r0 != 0) goto L_0x004c;
    L_0x0048:
        r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r0 == 0) goto L_0x004f;
    L_0x004c:
        android.support.v4.view.ah.d(r7);
    L_0x004f:
        return;
    L_0x0050:
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x0025;
    L_0x0054:
        r7.e();
        r2 = r7.Q;
        r3 = r7.getWidth();
        r3 = (float) r3;
        r3 = r9 / r3;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r2 = r2.a(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x006d:
        r1 = r0;
        goto L_0x0025;
    L_0x006f:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x008e;
    L_0x0073:
        r7.g();
        r2 = r7.R;
        r3 = r7.getHeight();
        r3 = (float) r3;
        r3 = r11 / r3;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r4 = r6 - r4;
        r2 = r2.a(r3, r4);
        if (r2 != 0) goto L_0x0042;
    L_0x008e:
        r0 = r1;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.a(float, float, float, float):void");
    }

    private void w() {
        int i = 0;
        if (this.O != null) {
            i = this.O.c();
        }
        if (this.P != null) {
            i |= this.P.c();
        }
        if (this.Q != null) {
            i |= this.Q.c();
        }
        if (this.R != null) {
            i |= this.R.c();
        }
        if (i != 0) {
            ah.d(this);
        }
    }

    private void i(int i, int i2) {
        int i3 = 0;
        if (!(this.O == null || this.O.a() || i <= 0)) {
            i3 = this.O.c();
        }
        if (!(this.Q == null || this.Q.a() || i >= 0)) {
            i3 |= this.Q.c();
        }
        if (!(this.P == null || this.P.a() || i2 <= 0)) {
            i3 |= this.P.c();
        }
        if (!(this.R == null || this.R.a() || i2 >= 0)) {
            i3 |= this.R.c();
        }
        if (i3 != 0) {
            ah.d(this);
        }
    }

    void c(int i, int i2) {
        if (i < 0) {
            d();
            this.O.a(-i);
        } else if (i > 0) {
            e();
            this.Q.a(i);
        }
        if (i2 < 0) {
            f();
            this.P.a(-i2);
        } else if (i2 > 0) {
            g();
            this.R.a(i2);
        }
        if (i != 0 || i2 != 0) {
            ah.d(this);
        }
    }

    void d() {
        if (this.O == null) {
            this.O = new android.support.v4.widget.d(getContext());
            if (this.r) {
                this.O.a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.O.a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void e() {
        if (this.Q == null) {
            this.Q = new android.support.v4.widget.d(getContext());
            if (this.r) {
                this.Q.a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.Q.a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void f() {
        if (this.P == null) {
            this.P = new android.support.v4.widget.d(getContext());
            if (this.r) {
                this.P.a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.P.a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void g() {
        if (this.R == null) {
            this.R = new android.support.v4.widget.d(getContext());
            if (this.r) {
                this.R.a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.R.a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void h() {
        this.R = null;
        this.P = null;
        this.Q = null;
        this.O = null;
    }

    public View focusSearch(View view, int i) {
        boolean z = true;
        View d = this.f.d(view, i);
        if (d != null) {
            return d;
        }
        boolean z2 = (this.w == null || this.f == null || j() || this.F) ? false : true;
        FocusFinder instance = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            if (this.f.e()) {
                if (instance.findNextFocus(this, view, i == 2 ? 130 : 33) == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (z2 || !this.f.d()) {
                z = z2;
            } else {
                int i2;
                int i3;
                if (this.f.r() == 1) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i == 2) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (instance.findNextFocus(this, view, (i3 ^ i2) != 0 ? 66 : 17) != null) {
                    z = false;
                }
            }
            if (z) {
                t();
                if (b(view) == null) {
                    return null;
                }
                b();
                this.f.a(view, i, this.b, this.i);
                a(false);
            }
            d = instance.findNextFocus(this, view, i);
        } else {
            View findNextFocus = instance.findNextFocus(this, view, i);
            if (findNextFocus == null && z2) {
                t();
                if (b(view) == null) {
                    return null;
                }
                b();
                d = this.f.a(view, i, this.b, this.i);
                a(false);
            } else {
                d = findNextFocus;
            }
        }
        return !a(view, d, i) ? super.focusSearch(view, i) : d;
    }

    private boolean a(View view, View view2, int i) {
        int i2 = 0;
        if (view2 == null || view2 == this) {
            return false;
        }
        if (view == null) {
            return true;
        }
        if (i != 2 && i != 1) {
            return b(view, view2, i);
        }
        int i3;
        if (this.f.r() == 1) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i == 2) {
            i2 = 1;
        }
        if (b(view, view2, (i2 ^ i3) != 0 ? 66 : 17)) {
            return true;
        }
        if (i == 2) {
            return b(view, view2, 130);
        }
        return b(view, view2, 33);
    }

    private boolean b(View view, View view2, int i) {
        this.t.set(0, 0, view.getWidth(), view.getHeight());
        this.u.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.t);
        offsetDescendantRectToMyCoords(view2, this.u);
        switch (i) {
            case 17:
                if ((this.t.right > this.u.right || this.t.left >= this.u.right) && this.t.left > this.u.left) {
                    return true;
                }
                return false;
            case 33:
                if ((this.t.bottom > this.u.bottom || this.t.top >= this.u.bottom) && this.t.top > this.u.top) {
                    return true;
                }
                return false;
            case 66:
                if ((this.t.left < this.u.left || this.t.right <= this.u.left) && this.t.right < this.u.right) {
                    return true;
                }
                return false;
            case 130:
                if ((this.t.top < this.u.top || this.t.bottom <= this.u.top) && this.t.bottom < this.u.bottom) {
                    return true;
                }
                return false;
            default:
                throw new IllegalArgumentException("direction must be absolute. received:" + i);
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!(this.f.a(this, this.i, view, view2) || view2 == null)) {
            Rect rect;
            boolean z;
            this.t.set(0, 0, view2.getWidth(), view2.getHeight());
            LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof i) {
                i iVar = (i) layoutParams;
                if (!iVar.c) {
                    Rect rect2 = iVar.b;
                    rect = this.t;
                    rect.left -= rect2.left;
                    rect = this.t;
                    rect.right += rect2.right;
                    rect = this.t;
                    rect.top -= rect2.top;
                    rect = this.t;
                    rect.bottom = rect2.bottom + rect.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.t);
            offsetRectIntoDescendantCoords(view, this.t);
            rect = this.t;
            if (this.g) {
                z = false;
            } else {
                z = true;
            }
            requestChildRectangleOnScreen(view, rect, z);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f.a(this, view, rect, z);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.f == null || !this.f.a(this, (ArrayList) arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (j()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    protected void onAttachedToWindow() {
        boolean z = true;
        super.onAttachedToWindow();
        this.N = 0;
        this.B = true;
        if (!this.g || isLayoutRequested()) {
            z = false;
        }
        this.g = z;
        if (this.f != null) {
            this.f.c(this);
        }
        this.al = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.h != null) {
            this.h.c();
        }
        c();
        this.B = false;
        if (this.f != null) {
            this.f.b(this, this.b);
        }
        removeCallbacks(this.at);
        this.e.b();
    }

    public boolean isAttachedToWindow() {
        return this.B;
    }

    void a(String str) {
        if (!j()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    public void a(k kVar) {
        this.z.add(kVar);
    }

    public void b(k kVar) {
        this.z.remove(kVar);
        if (this.A == kVar) {
            this.A = null;
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.A = null;
        }
        int size = this.z.size();
        int i = 0;
        while (i < size) {
            k kVar = (k) this.z.get(i);
            if (!kVar.a(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.A = kVar;
                return true;
            }
        }
        return false;
    }

    private boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.A != null) {
            if (action == 0) {
                this.A = null;
            } else {
                this.A.b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.A = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.z.size();
            for (int i = 0; i < size; i++) {
                k kVar = (k) this.z.get(i);
                if (kVar.a(this, motionEvent)) {
                    this.A = kVar;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        boolean z = true;
        if (this.F) {
            return false;
        }
        if (a(motionEvent)) {
            y();
            return true;
        } else if (this.f == null) {
            return false;
        } else {
            boolean d = this.f.d();
            boolean e = this.f.e();
            if (this.U == null) {
                this.U = VelocityTracker.obtain();
            }
            this.U.addMovement(motionEvent);
            int a = android.support.v4.view.t.a(motionEvent);
            int b = android.support.v4.view.t.b(motionEvent);
            int i2;
            switch (a) {
                case 0:
                    if (this.G) {
                        this.G = false;
                    }
                    this.T = android.support.v4.view.t.b(motionEvent, 0);
                    i = (int) (motionEvent.getX() + 0.5f);
                    this.aa = i;
                    this.V = i;
                    i = (int) (motionEvent.getY() + 0.5f);
                    this.ab = i;
                    this.W = i;
                    if (this.S == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.as;
                    this.as[1] = 0;
                    iArr[0] = 0;
                    if (d) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (e) {
                        i2 |= 2;
                    }
                    startNestedScroll(i2);
                    break;
                case 1:
                    this.U.clear();
                    stopNestedScroll();
                    break;
                case 2:
                    a = android.support.v4.view.t.a(motionEvent, this.T);
                    if (a >= 0) {
                        b = (int) (android.support.v4.view.t.c(motionEvent, a) + 0.5f);
                        a = (int) (android.support.v4.view.t.d(motionEvent, a) + 0.5f);
                        if (this.S != 1) {
                            b -= this.V;
                            a -= this.W;
                            if (!d || Math.abs(b) <= this.ac) {
                                d = false;
                            } else {
                                this.aa = ((b < 0 ? -1 : 1) * this.ac) + this.V;
                                d = true;
                            }
                            if (e && Math.abs(a) > this.ac) {
                                i2 = this.W;
                                int i3 = this.ac;
                                if (a >= 0) {
                                    i = 1;
                                }
                                this.ab = i2 + (i * i3);
                                d = true;
                            }
                            if (d) {
                                setScrollState(1);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.T + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    y();
                    break;
                case 5:
                    this.T = android.support.v4.view.t.b(motionEvent, b);
                    i2 = (int) (android.support.v4.view.t.c(motionEvent, b) + 0.5f);
                    this.aa = i2;
                    this.V = i2;
                    i2 = (int) (android.support.v4.view.t.d(motionEvent, b) + 0.5f);
                    this.ab = i2;
                    this.W = i2;
                    break;
                case 6:
                    c(motionEvent);
                    break;
            }
            if (this.S != 1) {
                z = false;
            }
            return z;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.z.size();
        for (int i = 0; i < size; i++) {
            ((k) this.z.get(i)).a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.F || this.G) {
            return false;
        }
        if (b(motionEvent)) {
            y();
            return true;
        } else if (this.f == null) {
            return false;
        } else {
            boolean d = this.f.d();
            boolean e = this.f.e();
            if (this.U == null) {
                this.U = VelocityTracker.obtain();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int a = android.support.v4.view.t.a(motionEvent);
            int b = android.support.v4.view.t.b(motionEvent);
            if (a == 0) {
                int[] iArr = this.as;
                this.as[1] = 0;
                iArr[0] = 0;
            }
            obtain.offsetLocation((float) this.as[0], (float) this.as[1]);
            switch (a) {
                case 0:
                    this.T = android.support.v4.view.t.b(motionEvent, 0);
                    a = (int) (motionEvent.getX() + 0.5f);
                    this.aa = a;
                    this.V = a;
                    a = (int) (motionEvent.getY() + 0.5f);
                    this.ab = a;
                    this.W = a;
                    if (d) {
                        a = 1;
                    } else {
                        a = 0;
                    }
                    if (e) {
                        a |= 2;
                    }
                    startNestedScroll(a);
                    break;
                case 1:
                    this.U.addMovement(obtain);
                    this.U.computeCurrentVelocity(1000, (float) this.ae);
                    float f = d ? -af.a(this.U, this.T) : 0.0f;
                    float f2;
                    if (e) {
                        f2 = -af.b(this.U, this.T);
                    } else {
                        f2 = 0.0f;
                    }
                    if ((f == 0.0f && r0 == 0.0f) || !b((int) f, (int) r0)) {
                        setScrollState(0);
                    }
                    x();
                    z = true;
                    break;
                case 2:
                    a = android.support.v4.view.t.a(motionEvent, this.T);
                    if (a >= 0) {
                        int c = (int) (android.support.v4.view.t.c(motionEvent, a) + 0.5f);
                        int d2 = (int) (android.support.v4.view.t.d(motionEvent, a) + 0.5f);
                        int i = this.aa - c;
                        a = this.ab - d2;
                        if (dispatchNestedPreScroll(i, a, this.ar, this.aq)) {
                            i -= this.ar[0];
                            a -= this.ar[1];
                            obtain.offsetLocation((float) this.aq[0], (float) this.aq[1]);
                            int[] iArr2 = this.as;
                            iArr2[0] = iArr2[0] + this.aq[0];
                            iArr2 = this.as;
                            iArr2[1] = iArr2[1] + this.aq[1];
                        }
                        if (this.S != 1) {
                            boolean z2;
                            if (!d || Math.abs(i) <= this.ac) {
                                z2 = false;
                            } else {
                                if (i > 0) {
                                    i -= this.ac;
                                } else {
                                    i += this.ac;
                                }
                                z2 = true;
                            }
                            if (e && Math.abs(a) > this.ac) {
                                if (a > 0) {
                                    a -= this.ac;
                                } else {
                                    a += this.ac;
                                }
                                z2 = true;
                            }
                            if (z2) {
                                setScrollState(1);
                            }
                        }
                        if (this.S == 1) {
                            this.aa = c - this.aq[0];
                            this.ab = d2 - this.aq[1];
                            if (!d) {
                                i = 0;
                            }
                            if (!e) {
                                a = 0;
                            }
                            if (a(i, a, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.T + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    y();
                    break;
                case 5:
                    this.T = android.support.v4.view.t.b(motionEvent, b);
                    a = (int) (android.support.v4.view.t.c(motionEvent, b) + 0.5f);
                    this.aa = a;
                    this.V = a;
                    a = (int) (android.support.v4.view.t.d(motionEvent, b) + 0.5f);
                    this.ab = a;
                    this.W = a;
                    break;
                case 6:
                    c(motionEvent);
                    break;
            }
            if (!z) {
                this.U.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
    }

    private void x() {
        if (this.U != null) {
            this.U.clear();
        }
        stopNestedScroll();
        w();
    }

    private void y() {
        x();
        setScrollState(0);
    }

    private void c(MotionEvent motionEvent) {
        int b = android.support.v4.view.t.b(motionEvent);
        if (android.support.v4.view.t.b(motionEvent, b) == this.T) {
            b = b == 0 ? 1 : 0;
            this.T = android.support.v4.view.t.b(motionEvent, b);
            int c = (int) (android.support.v4.view.t.c(motionEvent, b) + 0.5f);
            this.aa = c;
            this.V = c;
            b = (int) (android.support.v4.view.t.d(motionEvent, b) + 0.5f);
            this.ab = b;
            this.W = b;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.f == null || this.F || (android.support.v4.view.t.d(motionEvent) & 2) == 0 || motionEvent.getAction() != 8)) {
            float f;
            float e;
            if (this.f.e()) {
                f = -android.support.v4.view.t.e(motionEvent, 9);
            } else {
                f = 0.0f;
            }
            if (this.f.d()) {
                e = android.support.v4.view.t.e(motionEvent, 10);
            } else {
                e = 0.0f;
            }
            if (!(f == 0.0f && e == 0.0f)) {
                float scrollFactor = getScrollFactor();
                a((int) (e * scrollFactor), (int) (f * scrollFactor), motionEvent);
            }
        }
        return false;
    }

    private float getScrollFactor() {
        if (this.af == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 0.0f;
            }
            this.af = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return this.af;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.f == null) {
            d(i, i2);
        } else if (this.f.b) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.f.a(this.b, this.i, i, i2);
            if (!z && this.w != null) {
                if (this.i.f == 1) {
                    I();
                }
                this.f.b(i, i2);
                this.i.o = true;
                J();
                this.f.c(i, i2);
                if (this.f.k()) {
                    this.f.b(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.i.o = true;
                    J();
                    this.f.c(i, i2);
                }
            }
        } else if (this.C) {
            this.f.a(this.b, this.i, i, i2);
        } else {
            if (this.I) {
                b();
                E();
                if (this.i.m) {
                    this.i.k = true;
                } else {
                    this.c.e();
                    this.i.k = false;
                }
                this.I = false;
                a(false);
            }
            if (this.w != null) {
                this.i.a = this.w.a();
            } else {
                this.i.a = 0;
            }
            b();
            this.f.a(this.b, this.i, i, i2);
            a(false);
            this.i.k = false;
        }
    }

    void d(int i, int i2) {
        setMeasuredDimension(h.a(i, getPaddingLeft() + getPaddingRight(), ah.n(this)), h.a(i2, getPaddingTop() + getPaddingBottom(), ah.o(this)));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            h();
        }
    }

    public void setItemAnimator(e eVar) {
        if (this.h != null) {
            this.h.c();
            this.h.a(null);
        }
        this.h = eVar;
        if (this.h != null) {
            this.h.a(this.ak);
        }
    }

    private void z() {
        this.N++;
    }

    private void A() {
        this.N--;
        if (this.N < 1) {
            this.N = 0;
            B();
        }
    }

    boolean i() {
        return this.K != null && this.K.isEnabled();
    }

    private void B() {
        int i = this.H;
        this.H = 0;
        if (i != 0 && i()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            android.support.v4.view.a.a.a(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public boolean j() {
        return this.N > 0;
    }

    boolean a(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (!j()) {
            return false;
        }
        int b;
        if (accessibilityEvent != null) {
            b = android.support.v4.view.a.a.b(accessibilityEvent);
        } else {
            b = 0;
        }
        if (b != 0) {
            i = b;
        }
        this.H = i | this.H;
        return true;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public e getItemAnimator() {
        return this.h;
    }

    private void C() {
        if (!this.al && this.B) {
            ah.a((View) this, this.at);
            this.al = true;
        }
    }

    private boolean D() {
        return this.h != null && this.f.b();
    }

    private void E() {
        boolean z;
        boolean z2 = true;
        if (this.M) {
            this.c.a();
            o();
            this.f.a(this);
        }
        if (D()) {
            this.c.b();
        } else {
            this.c.e();
        }
        boolean z3;
        if (this.j || this.k) {
            z3 = true;
        } else {
            z3 = false;
        }
        r rVar = this.i;
        if (!this.g || this.h == null || (!(this.M || r0 || this.f.a) || (this.M && !this.w.b()))) {
            z = false;
        } else {
            z = true;
        }
        rVar.l = z;
        r rVar2 = this.i;
        if (!(this.i.l && r0 && !this.M && D())) {
            z2 = false;
        }
        rVar2.m = z2;
    }

    void k() {
        if (this.w == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.f == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.i.o = false;
            if (this.i.f == 1) {
                I();
                this.f.f(this);
                J();
            } else if (!this.c.f() && this.f.w() == getWidth() && this.f.x() == getHeight()) {
                this.f.f(this);
            } else {
                this.f.f(this);
                J();
            }
            K();
        }
    }

    private void F() {
        View focusedChild;
        if (this.ag && hasFocus() && this.w != null) {
            focusedChild = getFocusedChild();
        } else {
            focusedChild = null;
        }
        u c = focusedChild == null ? null : c(focusedChild);
        if (c == null) {
            G();
            return;
        }
        int i;
        this.i.c = this.w.b() ? c.g() : -1;
        r rVar = this.i;
        if (this.M) {
            i = -1;
        } else {
            i = c.e();
        }
        rVar.b = i;
        this.i.d = j(c.a);
    }

    private void G() {
        this.i.c = -1;
        this.i.b = -1;
        this.i.d = -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void H() {
        /*
        r6 = this;
        r4 = -1;
        r0 = r6.ag;
        if (r0 == 0) goto L_0x0010;
    L_0x0006:
        r0 = r6.w;
        if (r0 == 0) goto L_0x0010;
    L_0x000a:
        r0 = r6.hasFocus();
        if (r0 != 0) goto L_0x0011;
    L_0x0010:
        return;
    L_0x0011:
        r0 = r6.isFocused();
        if (r0 != 0) goto L_0x0025;
    L_0x0017:
        r0 = r6.getFocusedChild();
        if (r0 == 0) goto L_0x0010;
    L_0x001d:
        r1 = r6.d;
        r0 = r1.c(r0);
        if (r0 == 0) goto L_0x0010;
    L_0x0025:
        r0 = 0;
        r1 = r6.i;
        r1 = r1.b;
        r2 = -1;
        if (r1 == r2) goto L_0x0035;
    L_0x002d:
        r0 = r6.i;
        r0 = r0.b;
        r0 = r6.c(r0);
    L_0x0035:
        if (r0 != 0) goto L_0x004f;
    L_0x0037:
        r1 = r6.i;
        r2 = r1.c;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 == 0) goto L_0x004f;
    L_0x003f:
        r1 = r6.w;
        r1 = r1.b();
        if (r1 == 0) goto L_0x004f;
    L_0x0047:
        r0 = r6.i;
        r0 = r0.c;
        r0 = r6.a(r0);
    L_0x004f:
        if (r0 == 0) goto L_0x0010;
    L_0x0051:
        r1 = r0.a;
        r1 = r1.hasFocus();
        if (r1 != 0) goto L_0x0010;
    L_0x0059:
        r1 = r0.a;
        r1 = r1.hasFocusable();
        if (r1 == 0) goto L_0x0010;
    L_0x0061:
        r1 = r0.a;
        r2 = r6.i;
        r2 = r2.d;
        r2 = (long) r2;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0082;
    L_0x006c:
        r0 = r0.a;
        r2 = r6.i;
        r2 = r2.d;
        r0 = r0.findViewById(r2);
        if (r0 == 0) goto L_0x0082;
    L_0x0078:
        r2 = r0.isFocusable();
        if (r2 == 0) goto L_0x0082;
    L_0x007e:
        r0.requestFocus();
        goto L_0x0010;
    L_0x0082:
        r0 = r1;
        goto L_0x007e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.H():void");
    }

    private int j(View view) {
        int id = view.getId();
        View view2 = view;
        while (!view2.isFocused() && (view2 instanceof ViewGroup) && view2.hasFocus()) {
            int id2;
            view = ((ViewGroup) view2).getFocusedChild();
            if (view.getId() != -1) {
                id2 = view.getId();
            } else {
                id2 = id;
            }
            id = id2;
            view2 = view;
        }
        return id;
    }

    private void I() {
        int b;
        int i;
        u d;
        boolean z = true;
        this.i.a(1);
        this.i.o = false;
        b();
        this.e.a();
        z();
        F();
        E();
        r rVar = this.i;
        if (!(this.i.l && this.k)) {
            z = false;
        }
        rVar.n = z;
        this.k = false;
        this.j = false;
        this.i.k = this.i.m;
        this.i.a = this.w.a();
        a(this.ao);
        if (this.i.l) {
            b = this.d.b();
            for (i = 0; i < b; i++) {
                d = d(this.d.b(i));
                if (!d.c() && (!d.n() || this.w.b())) {
                    this.e.a(d, this.h.a(this.i, d, e.d(d), d.u()));
                    if (!(!this.i.n || !d.x() || d.q() || d.c() || d.n())) {
                        this.e.a(a(d), d);
                    }
                }
            }
        }
        if (this.i.m) {
            m();
            z = this.i.j;
            this.i.j = false;
            this.f.c(this.b, this.i);
            this.i.j = z;
            for (i = 0; i < this.d.b(); i++) {
                d = d(this.d.b(i));
                if (!(d.c() || this.e.d(d))) {
                    b = e.d(d);
                    boolean a = d.a(8192);
                    if (!a) {
                        b |= 4096;
                    }
                    c a2 = this.h.a(this.i, d, b, d.u());
                    if (a) {
                        a(d, a2);
                    } else {
                        this.e.b(d, a2);
                    }
                }
            }
            n();
        } else {
            n();
        }
        A();
        a(false);
        this.i.f = 2;
    }

    private void J() {
        boolean z;
        b();
        z();
        this.i.a(6);
        this.c.e();
        this.i.a = this.w.a();
        this.i.i = 0;
        this.i.k = false;
        this.f.c(this.b, this.i);
        this.i.j = false;
        this.q = null;
        r rVar = this.i;
        if (!this.i.l || this.h == null) {
            z = false;
        } else {
            z = true;
        }
        rVar.l = z;
        this.i.f = 4;
        A();
        a(false);
    }

    private void K() {
        this.i.a(4);
        b();
        z();
        this.i.f = 1;
        if (this.i.l) {
            for (int b = this.d.b() - 1; b >= 0; b--) {
                u d = d(this.d.b(b));
                if (!d.c()) {
                    long a = a(d);
                    c a2 = this.h.a(this.i, d);
                    u a3 = this.e.a(a);
                    if (a3 == null || a3.c()) {
                        this.e.c(d, a2);
                    } else {
                        boolean a4 = this.e.a(a3);
                        boolean a5 = this.e.a(d);
                        if (a4 && a3 == d) {
                            this.e.c(d, a2);
                        } else {
                            c b2 = this.e.b(a3);
                            this.e.c(d, a2);
                            c c = this.e.c(d);
                            if (b2 == null) {
                                a(a, d, a3);
                            } else {
                                a(a3, d, b2, c, a4, a5);
                            }
                        }
                    }
                }
            }
            this.e.a(this.av);
        }
        this.f.b(this.b);
        this.i.h = this.i.a;
        this.M = false;
        this.i.l = false;
        this.i.m = false;
        this.f.a = false;
        if (this.b.d != null) {
            this.b.d.clear();
        }
        this.f.a(this.i);
        A();
        a(false);
        this.e.a();
        if (j(this.ao[0], this.ao[1])) {
            h(0, 0);
        }
        H();
        G();
    }

    private void a(long j, u uVar, u uVar2) {
        int b = this.d.b();
        int i = 0;
        while (i < b) {
            u d = d(this.d.b(i));
            if (d == uVar || a(d) != j) {
                i++;
            } else if (this.w == null || !this.w.b()) {
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + d + " \n View Holder 2:" + uVar);
            } else {
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + d + " \n View Holder 2:" + uVar);
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + uVar2 + " cannot be found but it is necessary for " + uVar);
    }

    private void a(u uVar, c cVar) {
        uVar.a(0, 8192);
        if (this.i.n && uVar.x() && !uVar.q() && !uVar.c()) {
            this.e.a(a(uVar), uVar);
        }
        this.e.a(uVar, cVar);
    }

    private void a(int[] iArr) {
        int b = this.d.b();
        if (b == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < b) {
            int i4;
            u d = d(this.d.b(i3));
            if (d.c()) {
                i4 = i;
            } else {
                i4 = d.d();
                if (i4 < i) {
                    i = i4;
                }
                if (i4 > i2) {
                    i2 = i4;
                    i4 = i;
                } else {
                    i4 = i;
                }
            }
            i3++;
            i = i4;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean j(int i, int i2) {
        if (this.d.b() != 0) {
            a(this.ao);
            if (this.ao[0] == i && this.ao[1] == i2) {
                return false;
            }
            return true;
        } else if (i == 0 && i2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    protected void removeDetachedView(View view, boolean z) {
        u d = d(view);
        if (d != null) {
            if (d.r()) {
                d.m();
            } else if (!d.c()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + d);
            }
        }
        k(view);
        super.removeDetachedView(view, z);
    }

    long a(u uVar) {
        return this.w.b() ? uVar.g() : (long) uVar.b;
    }

    private void a(u uVar, c cVar, c cVar2) {
        uVar.a(false);
        if (this.h.b(uVar, cVar, cVar2)) {
            C();
        }
    }

    private void b(u uVar, c cVar, c cVar2) {
        b(uVar);
        uVar.a(false);
        if (this.h.a(uVar, cVar, cVar2)) {
            C();
        }
    }

    private void a(u uVar, u uVar2, c cVar, c cVar2, boolean z, boolean z2) {
        uVar.a(false);
        if (z) {
            b(uVar);
        }
        if (uVar != uVar2) {
            if (z2) {
                b(uVar2);
            }
            uVar.g = uVar2;
            b(uVar);
            this.b.d(uVar);
            uVar2.a(false);
            uVar2.h = uVar;
        }
        if (this.h.a(uVar, uVar2, cVar, cVar2)) {
            C();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        android.support.v4.d.h.a("RV OnLayout");
        k();
        android.support.v4.d.h.a();
        this.g = true;
    }

    public void requestLayout() {
        if (this.D != 0 || this.F) {
            this.E = true;
        } else {
            super.requestLayout();
        }
    }

    void l() {
        int c = this.d.c();
        for (int i = 0; i < c; i++) {
            ((i) this.d.c(i).getLayoutParams()).c = true;
        }
        this.b.j();
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        super.draw(canvas);
        int size = this.y.size();
        for (i = 0; i < size; i++) {
            ((g) this.y.get(i)).b(canvas, this, this.i);
        }
        if (this.O == null || this.O.a()) {
            i2 = 0;
        } else {
            i = canvas.save();
            i2 = this.r ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            if (this.O == null || !this.O.a(canvas)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            canvas.restoreToCount(i);
        }
        if (!(this.P == null || this.P.a())) {
            size = canvas.save();
            if (this.r) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            if (this.P == null || !this.P.a(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.Q == null || this.Q.a())) {
            size = canvas.save();
            int width = getWidth();
            if (this.r) {
                i = getPaddingTop();
            } else {
                i = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            if (this.Q == null || !this.Q.a(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.R == null || this.R.a())) {
            i = canvas.save();
            canvas.rotate(180.0f);
            if (this.r) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.R != null && this.R.a(canvas)) {
                i4 = 1;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.h == null || this.y.size() <= 0 || !this.h.b()) {
            i3 = i2;
        }
        if (i3 != 0) {
            ah.d(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            ((g) this.y.get(i)).a(canvas, this, this.i);
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof i) && this.f.a((i) layoutParams);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        if (this.f != null) {
            return this.f.a();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.f != null) {
            return this.f.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (this.f != null) {
            return this.f.a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    void m() {
        int c = this.d.c();
        for (int i = 0; i < c; i++) {
            u d = d(this.d.c(i));
            if (!d.c()) {
                d.b();
            }
        }
    }

    void n() {
        int c = this.d.c();
        for (int i = 0; i < c; i++) {
            u d = d(this.d.c(i));
            if (!d.c()) {
                d.a();
            }
        }
        this.b.i();
    }

    void e(int i, int i2) {
        int i3;
        int c = this.d.c();
        int i4;
        int i5;
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        for (int i6 = 0; i6 < c; i6++) {
            u d = d(this.d.c(i6));
            if (d != null && d.b >= r3 && d.b <= r2) {
                if (d.b == i) {
                    d.a(i2 - i, false);
                } else {
                    d.a(i3, false);
                }
                this.i.j = true;
            }
        }
        this.b.a(i, i2);
        requestLayout();
    }

    void f(int i, int i2) {
        int c = this.d.c();
        for (int i3 = 0; i3 < c; i3++) {
            u d = d(this.d.c(i3));
            if (!(d == null || d.c() || d.b < i)) {
                d.a(i2, false);
                this.i.j = true;
            }
        }
        this.b.b(i, i2);
        requestLayout();
    }

    void a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int c = this.d.c();
        for (int i4 = 0; i4 < c; i4++) {
            u d = d(this.d.c(i4));
            if (!(d == null || d.c())) {
                if (d.b >= i3) {
                    d.a(-i2, z);
                    this.i.j = true;
                } else if (d.b >= i) {
                    d.a(i - 1, -i2, z);
                    this.i.j = true;
                }
            }
        }
        this.b.b(i, i2, z);
        requestLayout();
    }

    void a(int i, int i2, Object obj) {
        int c = this.d.c();
        int i3 = i + i2;
        for (int i4 = 0; i4 < c; i4++) {
            View c2 = this.d.c(i4);
            u d = d(c2);
            if (d != null && !d.c() && d.b >= i && d.b < i3) {
                d.b(2);
                d.a(obj);
                ((i) c2.getLayoutParams()).c = true;
            }
        }
        this.b.c(i, i2);
    }

    private boolean c(u uVar) {
        return this.h == null || this.h.a(uVar, uVar.u());
    }

    private void L() {
        if (!this.M) {
            this.M = true;
            int c = this.d.c();
            for (int i = 0; i < c; i++) {
                u d = d(this.d.c(i));
                if (!(d == null || d.c())) {
                    d.b(512);
                }
            }
            this.b.g();
        }
    }

    void o() {
        int c = this.d.c();
        for (int i = 0; i < c; i++) {
            u d = d(this.d.c(i));
            if (!(d == null || d.c())) {
                d.b(6);
            }
        }
        l();
        this.b.h();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.ag;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.ag = z;
    }

    public u a(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return d(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public View b(View view) {
        RecyclerView parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != this && (parent instanceof View)) {
            View view3 = parent;
            view2 = view3;
            ViewParent parent2 = view3.getParent();
        }
        return parent == this ? view2 : null;
    }

    public u c(View view) {
        View b = b(view);
        return b == null ? null : a(b);
    }

    static u d(View view) {
        if (view == null) {
            return null;
        }
        return ((i) view.getLayoutParams()).a;
    }

    public int e(View view) {
        u d = d(view);
        return d != null ? d.d() : -1;
    }

    public u c(int i) {
        if (this.M) {
            return null;
        }
        int c = this.d.c();
        int i2 = 0;
        u uVar = null;
        while (i2 < c) {
            u d = d(this.d.c(i2));
            if (d == null || d.q() || d(d) != i) {
                d = uVar;
            } else if (!this.d.c(d.a)) {
                return d;
            }
            i2++;
            uVar = d;
        }
        return uVar;
    }

    u a(int i, boolean z) {
        int c = this.d.c();
        u uVar = null;
        for (int i2 = 0; i2 < c; i2++) {
            u d = d(this.d.c(i2));
            if (!(d == null || d.q())) {
                if (z) {
                    if (d.b != i) {
                        continue;
                    }
                } else if (d.d() != i) {
                    continue;
                }
                if (!this.d.c(d.a)) {
                    return d;
                }
                uVar = d;
            }
        }
        return uVar;
    }

    public u a(long j) {
        if (this.w == null || !this.w.b()) {
            return null;
        }
        int c = this.d.c();
        int i = 0;
        u uVar = null;
        while (i < c) {
            u d = d(this.d.c(i));
            if (d == null || d.q() || d.g() != j) {
                d = uVar;
            } else if (!this.d.c(d.a)) {
                return d;
            }
            i++;
            uVar = d;
        }
        return uVar;
    }

    public View a(float f, float f2) {
        for (int b = this.d.b() - 1; b >= 0; b--) {
            View b2 = this.d.b(b);
            float k = ah.k(b2);
            float l = ah.l(b2);
            if (f >= ((float) b2.getLeft()) + k && f <= k + ((float) b2.getRight()) && f2 >= ((float) b2.getTop()) + l && f2 <= ((float) b2.getBottom()) + l) {
                return b2;
            }
        }
        return null;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void d(int i) {
        int b = this.d.b();
        for (int i2 = 0; i2 < b; i2++) {
            this.d.b(i2).offsetTopAndBottom(i);
        }
    }

    public void f(View view) {
    }

    public void g(View view) {
    }

    public void e(int i) {
        int b = this.d.b();
        for (int i2 = 0; i2 < b; i2++) {
            this.d.b(i2).offsetLeftAndRight(i);
        }
    }

    Rect h(View view) {
        i iVar = (i) view.getLayoutParams();
        if (!iVar.c) {
            return iVar.b;
        }
        Rect rect = iVar.b;
        rect.set(0, 0, 0, 0);
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            this.t.set(0, 0, 0, 0);
            ((g) this.y.get(i)).a(this.t, view, this, this.i);
            rect.left += this.t.left;
            rect.top += this.t.top;
            rect.right += this.t.right;
            rect.bottom += this.t.bottom;
        }
        iVar.c = false;
        return rect;
    }

    public void g(int i, int i2) {
    }

    void h(int i, int i2) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        g(i, i2);
        if (this.ai != null) {
            this.ai.a(this, i, i2);
        }
        if (this.aj != null) {
            for (scrollY = this.aj.size() - 1; scrollY >= 0; scrollY--) {
                ((l) this.aj.get(scrollY)).a(this, i, i2);
            }
        }
    }

    public void f(int i) {
    }

    void g(int i) {
        if (this.f != null) {
            this.f.l(i);
        }
        f(i);
        if (this.ai != null) {
            this.ai.a(this, i);
        }
        if (this.aj != null) {
            for (int size = this.aj.size() - 1; size >= 0; size--) {
                ((l) this.aj.get(size)).a(this, i);
            }
        }
    }

    public boolean p() {
        return !this.g || this.M || this.c.d();
    }

    private void M() {
        int b = this.d.b();
        for (int i = 0; i < b; i++) {
            View b2 = this.d.b(i);
            u a = a(b2);
            if (!(a == null || a.h == null)) {
                View view = a.h.a;
                int left = b2.getLeft();
                int top = b2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private void k(View view) {
        u d = d(view);
        g(view);
        if (!(this.w == null || d == null)) {
            this.w.d(d);
        }
        if (this.L != null) {
            for (int size = this.L.size() - 1; size >= 0; size--) {
                ((j) this.L.get(size)).b(view);
            }
        }
    }

    private void l(View view) {
        u d = d(view);
        f(view);
        if (!(this.w == null || d == null)) {
            this.w.c(d);
        }
        if (this.L != null) {
            for (int size = this.L.size() - 1; size >= 0; size--) {
                ((j) this.L.get(size)).a(view);
            }
        }
    }

    private int d(u uVar) {
        if (uVar.a(524) || !uVar.p()) {
            return -1;
        }
        return this.c.c(uVar.b);
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().a();
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().a(i);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().b();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().a(f, f2);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.an == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return this.an.a(i, i2);
    }

    private y getScrollingChildHelper() {
        if (this.ap == null) {
            this.ap = new y(this);
        }
        return this.ap;
    }
}
