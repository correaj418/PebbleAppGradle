package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final int[] a = new int[]{16842931};
    private static final i ai = new i();
    private static final Comparator<b> c = new Comparator<b>() {
        public /* synthetic */ int compare(Object obj, Object obj2) {
            return a((b) obj, (b) obj2);
        }

        public int a(b bVar, b bVar2) {
            return bVar.b - bVar2.b;
        }
    };
    private static final Interpolator d = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    private int A = 1;
    private boolean B;
    private boolean C;
    private int D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private float J;
    private int K = -1;
    private VelocityTracker L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private android.support.v4.widget.d R;
    private android.support.v4.widget.d S;
    private boolean T = true;
    private boolean U = false;
    private boolean V;
    private int W;
    private List<f> aa;
    private f ab;
    private f ac;
    private List<e> ad;
    private g ae;
    private Method af;
    private int ag;
    private ArrayList<View> ah;
    private final Runnable aj = new Runnable(this) {
        final /* synthetic */ ViewPager a;

        {
            this.a = r1;
        }

        public void run() {
            this.a.setScrollState(0);
            this.a.c();
        }
    };
    private int ak = 0;
    private int b;
    private final ArrayList<b> e = new ArrayList();
    private final b f = new b();
    private final Rect g = new Rect();
    private ac h;
    private int i;
    private int j = -1;
    private Parcelable k = null;
    private ClassLoader l = null;
    private Scroller m;
    private boolean n;
    private h o;
    private int p;
    private Drawable q;
    private int r;
    private int s;
    private float t = -3.4028235E38f;
    private float u = Float.MAX_VALUE;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private boolean z;

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
        int b;
        Parcelable c;
        ClassLoader d;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b);
            parcel.writeParcelable(this.c, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.b + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.b = parcel.readInt();
            this.c = parcel.readParcelable(classLoader);
            this.d = classLoader;
        }
    }

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
    }

    static class b {
        Object a;
        int b;
        boolean c;
        float d;
        float e;

        b() {
        }
    }

    public static class c extends LayoutParams {
        public boolean a;
        public int b;
        float c = 0.0f;
        boolean d;
        int e;
        int f;

        public c() {
            super(-1, -1);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.a);
            this.b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    class d extends a {
        final /* synthetic */ ViewPager b;

        d(ViewPager viewPager) {
            this.b = viewPager;
        }

        public void d(View view, AccessibilityEvent accessibilityEvent) {
            super.d(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            k a = android.support.v4.view.a.a.a(accessibilityEvent);
            a.a(b());
            if (accessibilityEvent.getEventType() == 4096 && this.b.h != null) {
                a.a(this.b.h.a());
                a.b(this.b.i);
                a.c(this.b.i);
            }
        }

        public void a(View view, android.support.v4.view.a.c cVar) {
            super.a(view, cVar);
            cVar.a(ViewPager.class.getName());
            cVar.a(b());
            if (this.b.canScrollHorizontally(1)) {
                cVar.a(4096);
            }
            if (this.b.canScrollHorizontally(-1)) {
                cVar.a(8192);
            }
        }

        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (!this.b.canScrollHorizontally(1)) {
                        return false;
                    }
                    this.b.setCurrentItem(this.b.i + 1);
                    return true;
                case 8192:
                    if (!this.b.canScrollHorizontally(-1)) {
                        return false;
                    }
                    this.b.setCurrentItem(this.b.i - 1);
                    return true;
                default:
                    return false;
            }
        }

        private boolean b() {
            return this.b.h != null && this.b.h.a() > 1;
        }
    }

    public interface e {
        void a(ViewPager viewPager, ac acVar, ac acVar2);
    }

    public interface f {
        void a(int i);

        void a(int i, float f, int i2);

        void b(int i);
    }

    public interface g {
        void a(View view, float f);
    }

    private class h extends DataSetObserver {
        final /* synthetic */ ViewPager a;

        private h(ViewPager viewPager) {
            this.a = viewPager;
        }

        public void onChanged() {
            this.a.b();
        }

        public void onInvalidated() {
            this.a.b();
        }
    }

    static class i implements Comparator<View> {
        i() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return a((View) obj, (View) obj2);
        }

        public int a(View view, View view2) {
            c cVar = (c) view.getLayoutParams();
            c cVar2 = (c) view2.getLayoutParams();
            if (cVar.a != cVar2.a) {
                return cVar.a ? 1 : -1;
            } else {
                return cVar.e - cVar2.e;
            }
        }
    }

    public ViewPager(Context context) {
        super(context);
        a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    void a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.m = new Scroller(context, d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.F = ar.a(viewConfiguration);
        this.M = (int) (400.0f * f);
        this.N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.R = new android.support.v4.widget.d(context);
        this.S = new android.support.v4.widget.d(context);
        this.O = (int) (25.0f * f);
        this.P = (int) (2.0f * f);
        this.D = (int) (16.0f * f);
        ah.a((View) this, new d(this));
        if (ah.e(this) == 0) {
            ah.c((View) this, 1);
        }
        ah.a((View) this, new ab(this) {
            final /* synthetic */ ViewPager a;
            private final Rect b = new Rect();

            {
                this.a = r2;
            }

            public bb a(View view, bb bbVar) {
                bb a = ah.a(view, bbVar);
                if (a.e()) {
                    return a;
                }
                Rect rect = this.b;
                rect.left = a.a();
                rect.top = a.b();
                rect.right = a.c();
                rect.bottom = a.d();
                int childCount = this.a.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    bb b = ah.b(this.a.getChildAt(i), a);
                    rect.left = Math.min(b.a(), rect.left);
                    rect.top = Math.min(b.b(), rect.top);
                    rect.right = Math.min(b.c(), rect.right);
                    rect.bottom = Math.min(b.d(), rect.bottom);
                }
                return a.a(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.aj);
        if (!(this.m == null || this.m.isFinished())) {
            this.m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    private void setScrollState(int i) {
        if (this.ak != i) {
            this.ak = i;
            if (this.ae != null) {
                b(i != 0);
            }
            f(i);
        }
    }

    public void setAdapter(ac acVar) {
        int i = false;
        if (this.h != null) {
            this.h.a(null);
            this.h.a((ViewGroup) this);
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                b bVar = (b) this.e.get(i2);
                this.h.a((ViewGroup) this, bVar.b, bVar.a);
            }
            this.h.b((ViewGroup) this);
            this.e.clear();
            g();
            this.i = 0;
            scrollTo(0, 0);
        }
        ac acVar2 = this.h;
        this.h = acVar;
        this.b = 0;
        if (this.h != null) {
            if (this.o == null) {
                this.o = new h();
            }
            this.h.a(this.o);
            this.z = false;
            boolean z = this.T;
            this.T = true;
            this.b = this.h.a();
            if (this.j >= 0) {
                this.h.a(this.k, this.l);
                a(this.j, false, true);
                this.j = -1;
                this.k = null;
                this.l = null;
            } else if (z) {
                requestLayout();
            } else {
                c();
            }
        }
        if (this.ad != null && !this.ad.isEmpty()) {
            int size = this.ad.size();
            while (i < size) {
                ((e) this.ad.get(i)).a(this, acVar2, acVar);
                i++;
            }
        }
    }

    private void g() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((c) getChildAt(i).getLayoutParams()).a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public ac getAdapter() {
        return this.h;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        boolean z;
        this.z = false;
        if (this.T) {
            z = false;
        } else {
            z = true;
        }
        a(i, z, false);
    }

    public void a(int i, boolean z) {
        this.z = false;
        a(i, z, false);
    }

    public int getCurrentItem() {
        return this.i;
    }

    void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    void a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.h == null || this.h.a() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.i != i || this.e.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.h.a()) {
                i = this.h.a() - 1;
            }
            int i3 = this.A;
            if (i > this.i + i3 || i < this.i - i3) {
                for (int i4 = 0; i4 < this.e.size(); i4++) {
                    ((b) this.e.get(i4)).c = true;
                }
            }
            if (this.i != i) {
                z3 = true;
            }
            if (this.T) {
                this.i = i;
                if (z3) {
                    e(i);
                }
                requestLayout();
                return;
            }
            a(i);
            a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        int max;
        b b = b(i);
        if (b != null) {
            max = (int) (Math.max(this.t, Math.min(b.e, this.u)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            a(max, 0, i2);
            if (z2) {
                e(i);
                return;
            }
            return;
        }
        if (z2) {
            e(i);
        }
        a(false);
        scrollTo(max, 0);
        d(max);
    }

    @Deprecated
    public void setOnPageChangeListener(f fVar) {
        this.ab = fVar;
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.af == null) {
                try {
                    this.af = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.af.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ag == 2) {
            i2 = (i - 1) - i2;
        }
        return ((c) ((View) this.ah.get(i2)).getLayoutParams()).f;
    }

    public int getOffscreenPageLimit() {
        return this.A;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.A) {
            this.A = i;
            c();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.p;
        this.p = i;
        int width = getWidth();
        a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.p;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.q;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    float a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    void a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int i4;
        boolean z = (this.m == null || this.m.isFinished()) ? false : true;
        if (z) {
            int currX = this.n ? this.m.getCurrX() : this.m.getStartX();
            this.m.abortAnimation();
            setScrollingCacheEnabled(false);
            i4 = currX;
        } else {
            i4 = getScrollX();
        }
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            a(false);
            c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        currX = getClientWidth();
        int i7 = currX / 2;
        float a = (((float) i7) * a(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / ((float) currX)))) + ((float) i7);
        int abs = Math.abs(i3);
        if (abs > 0) {
            currX = Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4;
        } else {
            currX = (int) (((((float) Math.abs(i5)) / ((((float) currX) * this.h.b(this.i)) + ((float) this.p))) + 1.0f) * 100.0f);
        }
        i7 = Math.min(currX, 600);
        this.n = false;
        this.m.startScroll(i4, scrollY, i5, i6, i7);
        ah.d(this);
    }

    b a(int i, int i2) {
        b bVar = new b();
        bVar.b = i;
        bVar.a = this.h.a((ViewGroup) this, i);
        bVar.d = this.h.b(i);
        if (i2 < 0 || i2 >= this.e.size()) {
            this.e.add(bVar);
        } else {
            this.e.add(i2, bVar);
        }
        return bVar;
    }

    void b() {
        boolean z;
        int a = this.h.a();
        this.b = a;
        if (this.e.size() >= (this.A * 2) + 1 || this.e.size() >= a) {
            z = false;
        } else {
            z = true;
        }
        boolean z2 = false;
        int i = this.i;
        boolean z3 = z;
        int i2 = 0;
        while (i2 < this.e.size()) {
            int i3;
            boolean z4;
            int i4;
            boolean z5;
            b bVar = (b) this.e.get(i2);
            int a2 = this.h.a(bVar.a);
            if (a2 == -1) {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            } else if (a2 == -2) {
                this.e.remove(i2);
                i2--;
                if (!z2) {
                    this.h.a((ViewGroup) this);
                    z2 = true;
                }
                this.h.a((ViewGroup) this, bVar.b, bVar.a);
                if (this.i == bVar.b) {
                    i3 = i2;
                    z4 = z2;
                    i4 = Math.max(0, Math.min(this.i, a - 1));
                    z5 = true;
                } else {
                    i3 = i2;
                    z4 = z2;
                    i4 = i;
                    z5 = true;
                }
            } else if (bVar.b != a2) {
                if (bVar.b == this.i) {
                    i = a2;
                }
                bVar.b = a2;
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = true;
            } else {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            }
            z3 = z5;
            i = i4;
            z2 = z4;
            i2 = i3 + 1;
        }
        if (z2) {
            this.h.b((ViewGroup) this);
        }
        Collections.sort(this.e, c);
        if (z3) {
            i4 = getChildCount();
            for (i2 = 0; i2 < i4; i2++) {
                c cVar = (c) getChildAt(i2).getLayoutParams();
                if (!cVar.a) {
                    cVar.c = 0.0f;
                }
            }
            a(i, false, true);
            requestLayout();
        }
    }

    void c() {
        a(this.i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void a(int r18) {
        /*
        r17 = this;
        r2 = 0;
        r0 = r17;
        r3 = r0.i;
        r0 = r18;
        if (r3 == r0) goto L_0x0323;
    L_0x0009:
        r0 = r17;
        r2 = r0.i;
        r0 = r17;
        r2 = r0.b(r2);
        r0 = r18;
        r1 = r17;
        r1.i = r0;
        r3 = r2;
    L_0x001a:
        r0 = r17;
        r2 = r0.h;
        if (r2 != 0) goto L_0x0024;
    L_0x0020:
        r17.h();
    L_0x0023:
        return;
    L_0x0024:
        r0 = r17;
        r2 = r0.z;
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r17.h();
        goto L_0x0023;
    L_0x002e:
        r2 = r17.getWindowToken();
        if (r2 == 0) goto L_0x0023;
    L_0x0034:
        r0 = r17;
        r2 = r0.h;
        r0 = r17;
        r2.a(r0);
        r0 = r17;
        r2 = r0.A;
        r4 = 0;
        r0 = r17;
        r5 = r0.i;
        r5 = r5 - r2;
        r10 = java.lang.Math.max(r4, r5);
        r0 = r17;
        r4 = r0.h;
        r11 = r4.a();
        r4 = r11 + -1;
        r0 = r17;
        r5 = r0.i;
        r2 = r2 + r5;
        r12 = java.lang.Math.min(r4, r2);
        r0 = r17;
        r2 = r0.b;
        if (r11 == r2) goto L_0x00cb;
    L_0x0064:
        r2 = r17.getResources();	 Catch:{ NotFoundException -> 0x00c1 }
        r3 = r17.getId();	 Catch:{ NotFoundException -> 0x00c1 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00c1 }
    L_0x0070:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r17;
        r5 = r0.b;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r11);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r17.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r17;
        r4 = r0.h;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00c1:
        r2 = move-exception;
        r2 = r17.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x0070;
    L_0x00cb:
        r5 = 0;
        r2 = 0;
        r4 = r2;
    L_0x00ce:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.size();
        if (r4 >= r2) goto L_0x0320;
    L_0x00d8:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.b) r2;
        r6 = r2.b;
        r0 = r17;
        r7 = r0.i;
        if (r6 < r7) goto L_0x01bc;
    L_0x00ea:
        r6 = r2.b;
        r0 = r17;
        r7 = r0.i;
        if (r6 != r7) goto L_0x0320;
    L_0x00f2:
        if (r2 != 0) goto L_0x031d;
    L_0x00f4:
        if (r11 <= 0) goto L_0x031d;
    L_0x00f6:
        r0 = r17;
        r2 = r0.i;
        r0 = r17;
        r2 = r0.a(r2, r4);
        r9 = r2;
    L_0x0101:
        if (r9 == 0) goto L_0x016d;
    L_0x0103:
        r8 = 0;
        r7 = r4 + -1;
        if (r7 < 0) goto L_0x01c1;
    L_0x0108:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x0112:
        r13 = r17.getClientWidth();
        if (r13 > 0) goto L_0x01c4;
    L_0x0118:
        r5 = 0;
    L_0x0119:
        r0 = r17;
        r6 = r0.i;
        r6 = r6 + -1;
        r15 = r6;
        r6 = r8;
        r8 = r15;
        r16 = r7;
        r7 = r4;
        r4 = r16;
    L_0x0127:
        if (r8 < 0) goto L_0x0131;
    L_0x0129:
        r14 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r14 < 0) goto L_0x0203;
    L_0x012d:
        if (r8 >= r10) goto L_0x0203;
    L_0x012f:
        if (r2 != 0) goto L_0x01d3;
    L_0x0131:
        r5 = r9.d;
        r8 = r7 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0168;
    L_0x013b:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.size();
        if (r8 >= r2) goto L_0x0239;
    L_0x0145:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.ViewPager.b) r2;
        r6 = r2;
    L_0x0150:
        if (r13 > 0) goto L_0x023c;
    L_0x0152:
        r2 = 0;
        r4 = r2;
    L_0x0154:
        r0 = r17;
        r2 = r0.i;
        r2 = r2 + 1;
        r15 = r2;
        r2 = r6;
        r6 = r8;
        r8 = r15;
    L_0x015e:
        if (r8 >= r11) goto L_0x0168;
    L_0x0160:
        r10 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r10 < 0) goto L_0x0283;
    L_0x0164:
        if (r8 <= r12) goto L_0x0283;
    L_0x0166:
        if (r2 != 0) goto L_0x0249;
    L_0x0168:
        r0 = r17;
        r0.a(r9, r7, r3);
    L_0x016d:
        r0 = r17;
        r3 = r0.h;
        r0 = r17;
        r4 = r0.i;
        if (r9 == 0) goto L_0x02cd;
    L_0x0177:
        r2 = r9.a;
    L_0x0179:
        r0 = r17;
        r3.b(r0, r4, r2);
        r0 = r17;
        r2 = r0.h;
        r0 = r17;
        r2.b(r0);
        r4 = r17.getChildCount();
        r2 = 0;
        r3 = r2;
    L_0x018d:
        if (r3 >= r4) goto L_0x02d0;
    L_0x018f:
        r0 = r17;
        r5 = r0.getChildAt(r3);
        r2 = r5.getLayoutParams();
        r2 = (android.support.v4.view.ViewPager.c) r2;
        r2.f = r3;
        r6 = r2.a;
        if (r6 != 0) goto L_0x01b8;
    L_0x01a1:
        r6 = r2.c;
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 != 0) goto L_0x01b8;
    L_0x01a8:
        r0 = r17;
        r5 = r0.a(r5);
        if (r5 == 0) goto L_0x01b8;
    L_0x01b0:
        r6 = r5.d;
        r2.c = r6;
        r5 = r5.b;
        r2.e = r5;
    L_0x01b8:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x018d;
    L_0x01bc:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x00ce;
    L_0x01c1:
        r2 = 0;
        goto L_0x0112;
    L_0x01c4:
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r9.d;
        r5 = r5 - r6;
        r6 = r17.getPaddingLeft();
        r6 = (float) r6;
        r14 = (float) r13;
        r6 = r6 / r14;
        r5 = r5 + r6;
        goto L_0x0119;
    L_0x01d3:
        r14 = r2.b;
        if (r8 != r14) goto L_0x01fd;
    L_0x01d7:
        r14 = r2.c;
        if (r14 != 0) goto L_0x01fd;
    L_0x01db:
        r0 = r17;
        r14 = r0.e;
        r14.remove(r4);
        r0 = r17;
        r14 = r0.h;
        r2 = r2.a;
        r0 = r17;
        r14.a(r0, r8, r2);
        r4 = r4 + -1;
        r7 = r7 + -1;
        if (r4 < 0) goto L_0x0201;
    L_0x01f3:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x01fd:
        r8 = r8 + -1;
        goto L_0x0127;
    L_0x0201:
        r2 = 0;
        goto L_0x01fd;
    L_0x0203:
        if (r2 == 0) goto L_0x021d;
    L_0x0205:
        r14 = r2.b;
        if (r8 != r14) goto L_0x021d;
    L_0x0209:
        r2 = r2.d;
        r6 = r6 + r2;
        r4 = r4 + -1;
        if (r4 < 0) goto L_0x021b;
    L_0x0210:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.b) r2;
        goto L_0x01fd;
    L_0x021b:
        r2 = 0;
        goto L_0x01fd;
    L_0x021d:
        r2 = r4 + 1;
        r0 = r17;
        r2 = r0.a(r8, r2);
        r2 = r2.d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        if (r4 < 0) goto L_0x0237;
    L_0x022c:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.b) r2;
        goto L_0x01fd;
    L_0x0237:
        r2 = 0;
        goto L_0x01fd;
    L_0x0239:
        r6 = 0;
        goto L_0x0150;
    L_0x023c:
        r2 = r17.getPaddingRight();
        r2 = (float) r2;
        r4 = (float) r13;
        r2 = r2 / r4;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r4;
        r4 = r2;
        goto L_0x0154;
    L_0x0249:
        r10 = r2.b;
        if (r8 != r10) goto L_0x0318;
    L_0x024d:
        r10 = r2.c;
        if (r10 != 0) goto L_0x0318;
    L_0x0251:
        r0 = r17;
        r10 = r0.e;
        r10.remove(r6);
        r0 = r17;
        r10 = r0.h;
        r2 = r2.a;
        r0 = r17;
        r10.a(r0, r8, r2);
        r0 = r17;
        r2 = r0.e;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x0281;
    L_0x026d:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x0277:
        r15 = r5;
        r5 = r2;
        r2 = r15;
    L_0x027a:
        r8 = r8 + 1;
        r15 = r2;
        r2 = r5;
        r5 = r15;
        goto L_0x015e;
    L_0x0281:
        r2 = 0;
        goto L_0x0277;
    L_0x0283:
        if (r2 == 0) goto L_0x02a8;
    L_0x0285:
        r10 = r2.b;
        if (r8 != r10) goto L_0x02a8;
    L_0x0289:
        r2 = r2.d;
        r5 = r5 + r2;
        r6 = r6 + 1;
        r0 = r17;
        r2 = r0.e;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02a6;
    L_0x0298:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x02a2:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02a6:
        r2 = 0;
        goto L_0x02a2;
    L_0x02a8:
        r0 = r17;
        r2 = r0.a(r8, r6);
        r6 = r6 + 1;
        r2 = r2.d;
        r5 = r5 + r2;
        r0 = r17;
        r2 = r0.e;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02cb;
    L_0x02bd:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x02c7:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02cb:
        r2 = 0;
        goto L_0x02c7;
    L_0x02cd:
        r2 = 0;
        goto L_0x0179;
    L_0x02d0:
        r17.h();
        r2 = r17.hasFocus();
        if (r2 == 0) goto L_0x0023;
    L_0x02d9:
        r2 = r17.findFocus();
        if (r2 == 0) goto L_0x0316;
    L_0x02df:
        r0 = r17;
        r2 = r0.b(r2);
    L_0x02e5:
        if (r2 == 0) goto L_0x02ef;
    L_0x02e7:
        r2 = r2.b;
        r0 = r17;
        r3 = r0.i;
        if (r2 == r3) goto L_0x0023;
    L_0x02ef:
        r2 = 0;
    L_0x02f0:
        r3 = r17.getChildCount();
        if (r2 >= r3) goto L_0x0023;
    L_0x02f6:
        r0 = r17;
        r3 = r0.getChildAt(r2);
        r0 = r17;
        r4 = r0.a(r3);
        if (r4 == 0) goto L_0x0313;
    L_0x0304:
        r4 = r4.b;
        r0 = r17;
        r5 = r0.i;
        if (r4 != r5) goto L_0x0313;
    L_0x030c:
        r4 = 2;
        r3 = r3.requestFocus(r4);
        if (r3 != 0) goto L_0x0023;
    L_0x0313:
        r2 = r2 + 1;
        goto L_0x02f0;
    L_0x0316:
        r2 = 0;
        goto L_0x02e5;
    L_0x0318:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x031d:
        r9 = r2;
        goto L_0x0101;
    L_0x0320:
        r2 = r5;
        goto L_0x00f2;
    L_0x0323:
        r3 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(int):void");
    }

    private void h() {
        if (this.ag != 0) {
            if (this.ah == null) {
                this.ah = new ArrayList();
            } else {
                this.ah.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ah.add(getChildAt(i));
            }
            Collections.sort(this.ah, ai);
        }
    }

    private void a(b bVar, int i, b bVar2) {
        float f;
        float f2;
        int i2;
        b bVar3;
        int i3;
        int a = this.h.a();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f = ((float) this.p) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        if (bVar2 != null) {
            clientWidth = bVar2.b;
            int i4;
            if (clientWidth < bVar.b) {
                f2 = (bVar2.e + bVar2.d) + f;
                i4 = clientWidth + 1;
                i2 = 0;
                while (i4 <= bVar.b && i2 < this.e.size()) {
                    bVar3 = (b) this.e.get(i2);
                    while (i4 > bVar3.b && i2 < this.e.size() - 1) {
                        i2++;
                        bVar3 = (b) this.e.get(i2);
                    }
                    while (i4 < bVar3.b) {
                        f2 += this.h.b(i4) + f;
                        i4++;
                    }
                    bVar3.e = f2;
                    f2 += bVar3.d + f;
                    i4++;
                }
            } else if (clientWidth > bVar.b) {
                i2 = this.e.size() - 1;
                f2 = bVar2.e;
                i4 = clientWidth - 1;
                while (i4 >= bVar.b && i2 >= 0) {
                    bVar3 = (b) this.e.get(i2);
                    while (i4 < bVar3.b && i2 > 0) {
                        i2--;
                        bVar3 = (b) this.e.get(i2);
                    }
                    while (i4 > bVar3.b) {
                        f2 -= this.h.b(i4) + f;
                        i4--;
                    }
                    f2 -= bVar3.d + f;
                    bVar3.e = f2;
                    i4--;
                }
            }
        }
        int size = this.e.size();
        float f3 = bVar.e;
        i2 = bVar.b - 1;
        this.t = bVar.b == 0 ? bVar.e : -3.4028235E38f;
        this.u = bVar.b == a + -1 ? (bVar.e + bVar.d) - 1.0f : Float.MAX_VALUE;
        for (i3 = i - 1; i3 >= 0; i3--) {
            bVar3 = (b) this.e.get(i3);
            f2 = f3;
            while (i2 > bVar3.b) {
                f2 -= this.h.b(i2) + f;
                i2--;
            }
            f3 = f2 - (bVar3.d + f);
            bVar3.e = f3;
            if (bVar3.b == 0) {
                this.t = f3;
            }
            i2--;
        }
        f3 = (bVar.e + bVar.d) + f;
        i2 = bVar.b + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            bVar3 = (b) this.e.get(i3);
            f2 = f3;
            while (i2 < bVar3.b) {
                f2 = (this.h.b(i2) + f) + f2;
                i2++;
            }
            if (bVar3.b == a - 1) {
                this.u = (bVar3.d + f2) - 1.0f;
            }
            bVar3.e = f2;
            f3 = f2 + (bVar3.d + f);
            i2++;
        }
        this.U = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.b = this.i;
        if (this.h != null) {
            savedState.c = this.h.b();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.a());
            if (this.h != null) {
                this.h.a(savedState.c, savedState.d);
                a(savedState.b, false, true);
                return;
            }
            this.j = savedState.b;
            this.k = savedState.c;
            this.l = savedState.d;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (checkLayoutParams(layoutParams)) {
            layoutParams2 = layoutParams;
        } else {
            layoutParams2 = generateLayoutParams(layoutParams);
        }
        c cVar = (c) layoutParams2;
        cVar.a |= c(view);
        if (!this.x) {
            super.addView(view, i, layoutParams2);
        } else if (cVar == null || !cVar.a) {
            cVar.d = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    private static boolean c(View view) {
        return view.getClass().getAnnotation(a.class) != null;
    }

    public void removeView(View view) {
        if (this.x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    b a(View view) {
        for (int i = 0; i < this.e.size(); i++) {
            b bVar = (b) this.e.get(i);
            if (this.h.a(view, bVar.a)) {
                return bVar;
            }
        }
        return null;
    }

    b b(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    b b(int i) {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            b bVar = (b) this.e.get(i2);
            if (bVar.b == i) {
                return bVar;
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.T = true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.E = Math.min(measuredWidth / 10, this.D);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            c cVar;
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                cVar = (c) childAt.getLayoutParams();
                if (cVar != null && cVar.a) {
                    int i6 = cVar.b & 7;
                    int i7 = cVar.b & 112;
                    i3 = Integer.MIN_VALUE;
                    i5 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (cVar.width != -2) {
                        i7 = 1073741824;
                        i3 = cVar.width != -1 ? cVar.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (cVar.height != -2) {
                        i5 = 1073741824;
                        if (cVar.height != -1) {
                            measuredWidth = cVar.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.v = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.w = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.x = true;
        c();
        this.x = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                cVar = (c) childAt2.getLayoutParams();
                if (cVar == null || !cVar.a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (cVar.c * ((float) paddingLeft)), 1073741824), this.w);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            a(i, i3, this.p, this.p);
        }
    }

    private void a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.e.isEmpty()) {
            b b = b(this.i);
            int min = (int) ((b != null ? Math.min(b.e, this.u) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                a(false);
                scrollTo(min, getScrollY());
            }
        } else if (this.m.isFinished()) {
            scrollTo((int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)))), getScrollY());
        } else {
            this.m.setFinalX(getCurrentItem() * getClientWidth());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            c cVar;
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                cVar = (c) childAt.getLayoutParams();
                if (cVar.a) {
                    int i9 = cVar.b & 112;
                    switch (cVar.b & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                cVar = (c) childAt2.getLayoutParams();
                if (!cVar.a) {
                    b a = a(childAt2);
                    if (a != null) {
                        i5 = ((int) (a.e * ((float) max))) + paddingLeft;
                        if (cVar.d) {
                            cVar.d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (cVar.c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.r = paddingTop;
        this.s = i6 - paddingBottom;
        this.W = i7;
        if (this.T) {
            a(this.i, false, 0, false);
        }
        this.T = false;
    }

    public void computeScroll() {
        this.n = true;
        if (this.m.isFinished() || !this.m.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.m.getCurrX();
        int currY = this.m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!d(currX)) {
                this.m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ah.d(this);
    }

    private boolean d(int i) {
        if (this.e.size() != 0) {
            b j = j();
            int clientWidth = getClientWidth();
            int i2 = this.p + clientWidth;
            float f = ((float) this.p) / ((float) clientWidth);
            int i3 = j.b;
            float f2 = ((((float) i) / ((float) clientWidth)) - j.e) / (j.d + f);
            clientWidth = (int) (((float) i2) * f2);
            this.V = false;
            a(i3, f2, clientWidth);
            if (this.V) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.T) {
            return false;
        } else {
            this.V = false;
            a(0, 0.0f, 0);
            if (this.V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    protected void a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.W > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.a) {
                    int max;
                    switch (cVar.b & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        b(i, f, i2);
        if (this.ae != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((c) childAt2.getLayoutParams()).a) {
                    this.ae.a(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.V = true;
    }

    private void b(int i, float f, int i2) {
        if (this.ab != null) {
            this.ab.a(i, f, i2);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar = (f) this.aa.get(i3);
                if (fVar != null) {
                    fVar.a(i, f, i2);
                }
            }
        }
        if (this.ac != null) {
            this.ac.a(i, f, i2);
        }
    }

    private void e(int i) {
        if (this.ab != null) {
            this.ab.a(i);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                f fVar = (f) this.aa.get(i2);
                if (fVar != null) {
                    fVar.a(i);
                }
            }
        }
        if (this.ac != null) {
            this.ac.a(i);
        }
    }

    private void f(int i) {
        if (this.ab != null) {
            this.ab.b(i);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                f fVar = (f) this.aa.get(i2);
                if (fVar != null) {
                    fVar.b(i);
                }
            }
        }
        if (this.ac != null) {
            this.ac.b(i);
        }
    }

    private void a(boolean z) {
        int scrollX;
        boolean z2 = this.ak == 2;
        if (z2) {
            boolean z3;
            setScrollingCacheEnabled(false);
            if (this.m.isFinished()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                this.m.abortAnimation();
                scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.m.getCurrX();
                int currY = this.m.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        d(currX);
                    }
                }
            }
        }
        this.z = false;
        boolean z4 = z2;
        for (scrollX = 0; scrollX < this.e.size(); scrollX++) {
            b bVar = (b) this.e.get(scrollX);
            if (bVar.c) {
                bVar.c = false;
                z4 = true;
            }
        }
        if (!z4) {
            return;
        }
        if (z) {
            ah.a((View) this, this.aj);
        } else {
            this.aj.run();
        }
    }

    private boolean a(float f, float f2) {
        return (f < ((float) this.E) && f2 > 0.0f) || (f > ((float) (getWidth() - this.E)) && f2 < 0.0f);
    }

    private void b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            int i2;
            if (z) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            ah.a(getChildAt(i), i2, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            i();
            return false;
        }
        if (action != 0) {
            if (this.B) {
                return true;
            }
            if (this.C) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.I = x;
                this.G = x;
                x = motionEvent.getY();
                this.J = x;
                this.H = x;
                this.K = t.b(motionEvent, 0);
                this.C = false;
                this.n = true;
                this.m.computeScrollOffset();
                if (this.ak == 2 && Math.abs(this.m.getFinalX() - this.m.getCurrX()) > this.P) {
                    this.m.abortAnimation();
                    this.z = false;
                    c();
                    this.B = true;
                    c(true);
                    setScrollState(1);
                    break;
                }
                a(false);
                this.B = false;
                break;
            case 2:
                action = this.K;
                if (action != -1) {
                    action = t.a(motionEvent, action);
                    float c = t.c(motionEvent, action);
                    float f = c - this.G;
                    float abs = Math.abs(f);
                    float d = t.d(motionEvent, action);
                    float abs2 = Math.abs(d - this.J);
                    if (f == 0.0f || a(this.G, f) || !a(this, false, (int) f, (int) c, (int) d)) {
                        if (abs > ((float) this.F) && 0.5f * abs > abs2) {
                            this.B = true;
                            c(true);
                            setScrollState(1);
                            this.G = f > 0.0f ? this.I + ((float) this.F) : this.I - ((float) this.F);
                            this.H = d;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.F)) {
                            this.C = true;
                        }
                        if (this.B && b(c)) {
                            ah.d(this);
                            break;
                        }
                    }
                    this.G = c;
                    this.H = d;
                    this.C = true;
                    return false;
                }
                break;
            case 6:
                a(motionEvent);
                break;
        }
        if (this.L == null) {
            this.L = VelocityTracker.obtain();
        }
        this.L.addMovement(motionEvent);
        return this.B;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.Q) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.h == null || this.h.a() == 0) {
            return false;
        }
        if (this.L == null) {
            this.L = VelocityTracker.obtain();
        }
        this.L.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.m.abortAnimation();
                this.z = false;
                c();
                x = motionEvent.getX();
                this.I = x;
                this.G = x;
                x = motionEvent.getY();
                this.J = x;
                this.H = x;
                this.K = t.b(motionEvent, 0);
                break;
            case 1:
                if (this.B) {
                    VelocityTracker velocityTracker = this.L;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.N);
                    a = (int) af.a(velocityTracker, this.K);
                    this.z = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    b j = j();
                    a(a(j.b, ((((float) scrollX) / ((float) clientWidth)) - j.e) / (j.d + (((float) this.p) / ((float) clientWidth))), a, (int) (t.c(motionEvent, t.a(motionEvent, this.K)) - this.I)), true, true, a);
                    z = i();
                    break;
                }
                break;
            case 2:
                if (!this.B) {
                    a = t.a(motionEvent, this.K);
                    if (a == -1) {
                        z = i();
                        break;
                    }
                    float c = t.c(motionEvent, a);
                    float abs = Math.abs(c - this.G);
                    float d = t.d(motionEvent, a);
                    x = Math.abs(d - this.H);
                    if (abs > ((float) this.F) && abs > x) {
                        this.B = true;
                        c(true);
                        if (c - this.I > 0.0f) {
                            x = this.I + ((float) this.F);
                        } else {
                            x = this.I - ((float) this.F);
                        }
                        this.G = x;
                        this.H = d;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.B) {
                    z = false | b(t.c(motionEvent, t.a(motionEvent, this.K)));
                    break;
                }
                break;
            case 3:
                if (this.B) {
                    a(this.i, true, 0, false);
                    z = i();
                    break;
                }
                break;
            case 5:
                a = t.b(motionEvent);
                this.G = t.c(motionEvent, a);
                this.K = t.b(motionEvent, a);
                break;
            case 6:
                a(motionEvent);
                this.G = t.c(motionEvent, t.a(motionEvent, this.K));
                break;
        }
        if (z) {
            ah.d(this);
        }
        return true;
    }

    private boolean i() {
        this.K = -1;
        k();
        return this.R.c() | this.S.c();
    }

    private void c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.G - f;
        this.G = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.t;
        float f5 = ((float) clientWidth) * this.u;
        b bVar = (b) this.e.get(0);
        b bVar2 = (b) this.e.get(this.e.size() - 1);
        if (bVar.b != 0) {
            f4 = bVar.e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (bVar2.b != this.h.a() - 1) {
            f2 = bVar2.e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.R.a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.S.a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.G += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        d((int) f4);
        return z3;
    }

    private b j() {
        float f;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        if (clientWidth > 0) {
            f = ((float) this.p) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        b bVar = null;
        while (i2 < this.e.size()) {
            int i3;
            b bVar2;
            b bVar3 = (b) this.e.get(i2);
            b bVar4;
            if (obj != null || bVar3.b == i + 1) {
                bVar4 = bVar3;
                i3 = i2;
                bVar2 = bVar4;
            } else {
                bVar3 = this.f;
                bVar3.e = (f2 + f3) + f;
                bVar3.b = i + 1;
                bVar3.d = this.h.b(bVar3.b);
                bVar4 = bVar3;
                i3 = i2 - 1;
                bVar2 = bVar4;
            }
            f2 = bVar2.e;
            f3 = (bVar2.d + f2) + f;
            if (obj == null && scrollX < f2) {
                return bVar;
            }
            if (scrollX < f3 || i3 == this.e.size() - 1) {
                return bVar2;
            }
            f3 = f2;
            i = bVar2.b;
            obj = null;
            f2 = bVar2.d;
            bVar = bVar2;
            i2 = i3 + 1;
        }
        return bVar;
    }

    private int a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.O || Math.abs(i2) <= this.M) {
            i += (int) ((i >= this.i ? 0.4f : 0.6f) + f);
        } else if (i2 <= 0) {
            i++;
        }
        if (this.e.size() <= 0) {
            return i;
        }
        return Math.max(((b) this.e.get(0)).b, Math.min(i, ((b) this.e.get(this.e.size() - 1)).b));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int a = ah.a(this);
        if (a == 0 || (a == 1 && this.h != null && this.h.a() > 1)) {
            int height;
            int width;
            if (!this.R.a()) {
                a = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.t * ((float) width));
                this.R.a(height, width);
                i = 0 | this.R.a(canvas);
                canvas.restoreToCount(a);
            }
            if (!this.S.a()) {
                a = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.u + 1.0f)) * ((float) height));
                this.S.a(width, height);
                i |= this.S.a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.R.b();
            this.S.b();
        }
        if (i != 0) {
            ah.d(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.p > 0 && this.q != null && this.e.size() > 0 && this.h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.p) / ((float) width);
            b bVar = (b) this.e.get(0);
            float f2 = bVar.e;
            int size = this.e.size();
            int i = bVar.b;
            int i2 = ((b) this.e.get(size - 1)).b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > bVar.b && i3 < size) {
                    i3++;
                    bVar = (b) this.e.get(i3);
                }
                if (i4 == bVar.b) {
                    f3 = (bVar.e + bVar.d) * ((float) width);
                    f2 = (bVar.e + bVar.d) + f;
                } else {
                    float b = this.h.b(i4);
                    f3 = (f2 + b) * ((float) width);
                    f2 += b + f;
                }
                if (((float) this.p) + f3 > ((float) scrollX)) {
                    this.q.setBounds(Math.round(f3), this.r, Math.round(((float) this.p) + f3), this.s);
                    this.q.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    private void a(MotionEvent motionEvent) {
        int b = t.b(motionEvent);
        if (t.b(motionEvent, b) == this.K) {
            b = b == 0 ? 1 : 0;
            this.G = t.c(motionEvent, b);
            this.K = t.b(motionEvent, b);
            if (this.L != null) {
                this.L.clear();
            }
        }
    }

    private void k() {
        this.B = false;
        this.C = false;
        if (this.L != null) {
            this.L.recycle();
            this.L = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.y != z) {
            this.y = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.t))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.u))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && ah.a(view, -i)) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return c(17);
            case 22:
                return c(66);
            case 61:
                if (VERSION.SDK_INT < 11) {
                    return false;
                }
                if (h.a(keyEvent)) {
                    return c(2);
                }
                if (h.a(keyEvent, 1)) {
                    return c(1);
                }
                return false;
            default:
                return false;
        }
    }

    public boolean c(int i) {
        View view;
        boolean d;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                d = d();
            } else {
                if (i == 66 || i == 2) {
                    d = e();
                }
                d = false;
            }
        } else if (i == 17) {
            d = (view == null || a(this.g, findNextFocus).left < a(this.g, view).left) ? findNextFocus.requestFocus() : d();
        } else {
            if (i == 66) {
                d = (view == null || a(this.g, findNextFocus).left > a(this.g, view).left) ? findNextFocus.requestFocus() : e();
            }
            d = false;
        }
        if (d) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return d;
    }

    private Rect a(Rect rect, View view) {
        Rect rect2;
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    boolean d() {
        if (this.i <= 0) {
            return false;
        }
        a(this.i - 1, true);
        return true;
    }

    boolean e() {
        if (this.h == null || this.i >= this.h.a() - 1) {
            return false;
        }
        a(this.i + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    b a = a(childAt);
                    if (a != null && a.b == this.i) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                b a = a(childAt);
                if (a != null && a.b == this.i) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                b a = a(childAt);
                if (a != null && a.b == this.i && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                b a = a(childAt);
                if (a != null && a.b == this.i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof c) && super.checkLayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }
}
