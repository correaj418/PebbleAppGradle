package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.view.ah;
import android.support.v7.b.a.k;
import android.support.v7.view.menu.q;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class af implements q {
    private static Method a;
    private static Method d;
    private static Method e;
    private final d A;
    private final c B;
    private final a C;
    private Runnable D;
    private final Handler E;
    private final Rect F;
    private Rect G;
    private boolean H;
    int b;
    PopupWindow c;
    private Context f;
    private ListAdapter g;
    private z h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private int p;
    private boolean q;
    private boolean r;
    private View s;
    private int t;
    private DataSetObserver u;
    private View v;
    private Drawable w;
    private OnItemClickListener x;
    private OnItemSelectedListener y;
    private final e z;

    class AnonymousClass1 extends ab {
        final /* synthetic */ af a;

        public /* synthetic */ q a() {
            return d();
        }

        public af d() {
            return this.a;
        }
    }

    private class a implements Runnable {
        final /* synthetic */ af a;

        private a(af afVar) {
            this.a = afVar;
        }

        public void run() {
            this.a.m();
        }
    }

    private class b extends DataSetObserver {
        final /* synthetic */ af a;

        private b(af afVar) {
            this.a = afVar;
        }

        public void onChanged() {
            if (this.a.d()) {
                this.a.a();
            }
        }

        public void onInvalidated() {
            this.a.c();
        }
    }

    private class c implements OnScrollListener {
        final /* synthetic */ af a;

        private c(af afVar) {
            this.a = afVar;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.a.n() && this.a.c.getContentView() != null) {
                this.a.E.removeCallbacks(this.a.z);
                this.a.z.run();
            }
        }
    }

    private class d implements OnTouchListener {
        final /* synthetic */ af a;

        private d(af afVar) {
            this.a = afVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.a.c != null && this.a.c.isShowing() && x >= 0 && x < this.a.c.getWidth() && y >= 0 && y < this.a.c.getHeight()) {
                this.a.E.postDelayed(this.a.z, 250);
            } else if (action == 1) {
                this.a.E.removeCallbacks(this.a.z);
            }
            return false;
        }
    }

    private class e implements Runnable {
        final /* synthetic */ af a;

        private e(af afVar) {
            this.a = afVar;
        }

        public void run() {
            if (this.a.h != null && ah.y(this.a.h) && this.a.h.getCount() > this.a.h.getChildCount() && this.a.h.getChildCount() <= this.a.b) {
                this.a.c.setInputMethodMode(2);
                this.a.a();
            }
        }
    }

    static {
        try {
            a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            d = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            e = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
        } catch (NoSuchMethodException e3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public af(Context context) {
        this(context, null, android.support.v7.b.a.a.listPopupWindowStyle);
    }

    public af(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public af(Context context, AttributeSet attributeSet, int i, int i2) {
        this.i = -2;
        this.j = -2;
        this.m = 1002;
        this.o = true;
        this.p = 0;
        this.q = false;
        this.r = false;
        this.b = Integer.MAX_VALUE;
        this.t = 0;
        this.z = new e();
        this.A = new d();
        this.B = new c();
        this.C = new a();
        this.F = new Rect();
        this.f = context;
        this.E = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ListPopupWindow, i, i2);
        this.k = obtainStyledAttributes.getDimensionPixelOffset(k.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.l = obtainStyledAttributes.getDimensionPixelOffset(k.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.l != 0) {
            this.n = true;
        }
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 11) {
            this.c = new l(context, attributeSet, i, i2);
        } else {
            this.c = new l(context, attributeSet, i);
        }
        this.c.setInputMethodMode(1);
    }

    public void a(ListAdapter listAdapter) {
        if (this.u == null) {
            this.u = new b();
        } else if (this.g != null) {
            this.g.unregisterDataSetObserver(this.u);
        }
        this.g = listAdapter;
        if (this.g != null) {
            listAdapter.registerDataSetObserver(this.u);
        }
        if (this.h != null) {
            this.h.setAdapter(this.g);
        }
    }

    public void a(int i) {
        this.t = i;
    }

    public void a(boolean z) {
        this.H = z;
        this.c.setFocusable(z);
    }

    public boolean g() {
        return this.H;
    }

    public Drawable h() {
        return this.c.getBackground();
    }

    public void a(Drawable drawable) {
        this.c.setBackgroundDrawable(drawable);
    }

    public void b(int i) {
        this.c.setAnimationStyle(i);
    }

    public View i() {
        return this.v;
    }

    public void a(View view) {
        this.v = view;
    }

    public int j() {
        return this.k;
    }

    public void c(int i) {
        this.k = i;
    }

    public int k() {
        if (this.n) {
            return this.l;
        }
        return 0;
    }

    public void d(int i) {
        this.l = i;
        this.n = true;
    }

    public void a(Rect rect) {
        this.G = rect;
    }

    public void e(int i) {
        this.p = i;
    }

    public int l() {
        return this.j;
    }

    public void f(int i) {
        this.j = i;
    }

    public void g(int i) {
        Drawable background = this.c.getBackground();
        if (background != null) {
            background.getPadding(this.F);
            this.j = (this.F.left + this.F.right) + i;
            return;
        }
        f(i);
    }

    public void a(OnItemClickListener onItemClickListener) {
        this.x = onItemClickListener;
    }

    public void a() {
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int f = f();
        boolean n = n();
        android.support.v4.widget.k.a(this.c, this.m);
        int i2;
        if (this.c.isShowing()) {
            int i3;
            int i4;
            if (this.j == -1) {
                i3 = -1;
            } else if (this.j == -2) {
                i3 = i().getWidth();
            } else {
                i3 = this.j;
            }
            if (this.i == -1) {
                if (!n) {
                    f = -1;
                }
                PopupWindow popupWindow;
                if (n) {
                    popupWindow = this.c;
                    if (this.j == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow.setWidth(i2);
                    this.c.setHeight(0);
                    i4 = f;
                } else {
                    popupWindow = this.c;
                    if (this.j == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow.setWidth(i2);
                    this.c.setHeight(-1);
                    i4 = f;
                }
            } else if (this.i == -2) {
                i4 = f;
            } else {
                i4 = this.i;
            }
            PopupWindow popupWindow2 = this.c;
            if (!(this.r || this.q)) {
                z2 = true;
            }
            popupWindow2.setOutsideTouchable(z2);
            popupWindow2 = this.c;
            View i5 = i();
            f = this.k;
            int i6 = this.l;
            if (i3 < 0) {
                i3 = -1;
            }
            if (i4 >= 0) {
                i = i4;
            }
            popupWindow2.update(i5, f, i6, i3, i);
            return;
        }
        if (this.j == -1) {
            i2 = -1;
        } else if (this.j == -2) {
            i2 = i().getWidth();
        } else {
            i2 = this.j;
        }
        if (this.i == -1) {
            f = -1;
        } else if (this.i != -2) {
            f = this.i;
        }
        this.c.setWidth(i2);
        this.c.setHeight(f);
        b(true);
        popupWindow2 = this.c;
        if (this.r || this.q) {
            z = false;
        }
        popupWindow2.setOutsideTouchable(z);
        this.c.setTouchInterceptor(this.A);
        if (e != null) {
            try {
                e.invoke(this.c, new Object[]{this.G});
            } catch (Throwable e) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
            }
        }
        android.support.v4.widget.k.a(this.c, i(), this.k, this.l, this.p);
        this.h.setSelection(-1);
        if (!this.H || this.h.isInTouchMode()) {
            m();
        }
        if (!this.H) {
            this.E.post(this.C);
        }
    }

    public void c() {
        this.c.dismiss();
        b();
        this.c.setContentView(null);
        this.h = null;
        this.E.removeCallbacks(this.z);
    }

    public void a(OnDismissListener onDismissListener) {
        this.c.setOnDismissListener(onDismissListener);
    }

    private void b() {
        if (this.s != null) {
            ViewParent parent = this.s.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.s);
            }
        }
    }

    public void h(int i) {
        this.c.setInputMethodMode(i);
    }

    public void i(int i) {
        z zVar = this.h;
        if (d() && zVar != null) {
            zVar.setListSelectionHidden(false);
            zVar.setSelection(i);
            if (VERSION.SDK_INT >= 11 && zVar.getChoiceMode() != 0) {
                zVar.setItemChecked(i, true);
            }
        }
    }

    public void m() {
        z zVar = this.h;
        if (zVar != null) {
            zVar.setListSelectionHidden(true);
            zVar.requestLayout();
        }
    }

    public boolean d() {
        return this.c.isShowing();
    }

    public boolean n() {
        return this.c.getInputMethodMode() == 2;
    }

    public ListView e() {
        return this.h;
    }

    z a(Context context, boolean z) {
        return new z(context, z);
    }

    private int f() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z = true;
        LayoutParams layoutParams;
        View view;
        if (this.h == null) {
            Context context = this.f;
            this.D = new Runnable(this) {
                final /* synthetic */ af a;

                {
                    this.a = r1;
                }

                public void run() {
                    View i = this.a.i();
                    if (i != null && i.getWindowToken() != null) {
                        this.a.a();
                    }
                }
            };
            this.h = a(context, !this.H);
            if (this.w != null) {
                this.h.setSelector(this.w);
            }
            this.h.setAdapter(this.g);
            this.h.setOnItemClickListener(this.x);
            this.h.setFocusable(true);
            this.h.setFocusableInTouchMode(true);
            this.h.setOnItemSelectedListener(new OnItemSelectedListener(this) {
                final /* synthetic */ af a;

                {
                    this.a = r1;
                }

                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != -1) {
                        z a = this.a.h;
                        if (a != null) {
                            a.setListSelectionHidden(false);
                        }
                    }
                }

                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.h.setOnScrollListener(this.B);
            if (this.y != null) {
                this.h.setOnItemSelectedListener(this.y);
            }
            View view2 = this.h;
            View view3 = this.s;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.t) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.t);
                        break;
                }
                if (this.j >= 0) {
                    i = this.j;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                i2 = 0;
            }
            this.c.setContentView(view);
            i3 = i2;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.c.getContentView();
            view = this.s;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i3 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i3 = 0;
            }
        }
        Drawable background = this.c.getBackground();
        if (background != null) {
            background.getPadding(this.F);
            i2 = this.F.top + this.F.bottom;
            if (this.n) {
                i4 = i2;
            } else {
                this.l = -this.F.top;
                i4 = i2;
            }
        } else {
            this.F.setEmpty();
            i4 = 0;
        }
        if (this.c.getInputMethodMode() != 2) {
            z = false;
        }
        i = a(i(), this.l, z);
        if (this.q || this.i == -1) {
            return i + i4;
        }
        int makeMeasureSpec;
        switch (this.j) {
            case -2:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f.getResources().getDisplayMetrics().widthPixels - (this.F.left + this.F.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f.getResources().getDisplayMetrics().widthPixels - (this.F.left + this.F.right), 1073741824);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.j, 1073741824);
                break;
        }
        i2 = this.h.a(makeMeasureSpec, 0, -1, i - i3, -1);
        if (i2 > 0) {
            i3 += (this.h.getPaddingTop() + this.h.getPaddingBottom()) + i4;
        }
        return i2 + i3;
    }

    private void b(boolean z) {
        if (a != null) {
            try {
                a.invoke(this.c, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int a(View view, int i, boolean z) {
        if (d != null) {
            try {
                return ((Integer) d.invoke(this.c, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.c.getMaxAvailableHeight(view, i);
    }
}
