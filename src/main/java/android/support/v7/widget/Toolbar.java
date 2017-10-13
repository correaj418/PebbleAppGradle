package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.d.d;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ah;
import android.support.v4.view.f;
import android.support.v4.view.o;
import android.support.v4.view.q;
import android.support.v4.view.t;
import android.support.v7.b.a.k;
import android.support.v7.view.menu.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.s;
import android.support.v7.widget.ActionMenuView.e;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private int A;
    private boolean B;
    private boolean C;
    private final ArrayList<View> D;
    private final ArrayList<View> E;
    private final int[] F;
    private c G;
    private final e H;
    private ba I;
    private a J;
    private android.support.v7.view.menu.m.a K;
    private android.support.v7.view.menu.g.a L;
    private boolean M;
    private final Runnable N;
    private final i O;
    View a;
    private ActionMenuView b;
    private TextView c;
    private TextView d;
    private ImageButton e;
    private ImageView f;
    private Drawable g;
    private CharSequence h;
    private ImageButton i;
    private Context j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private final ap t;
    private int u;
    private int v;
    private int w;
    private CharSequence x;
    private CharSequence y;
    private int z;

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = d.a(new android.support.v4.d.e<SavedState>() {
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
        boolean c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = parcel.readInt();
            this.c = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }
    }

    private class a implements m {
        g a;
        h b;
        final /* synthetic */ Toolbar c;

        private a(Toolbar toolbar) {
            this.c = toolbar;
        }

        public void a(Context context, g gVar) {
            if (!(this.a == null || this.b == null)) {
                this.a.d(this.b);
            }
            this.a = gVar;
        }

        public void b(boolean z) {
            Object obj = null;
            if (this.b != null) {
                if (this.a != null) {
                    int size = this.a.size();
                    for (int i = 0; i < size; i++) {
                        if (this.a.getItem(i) == this.b) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    b(this.a, this.b);
                }
            }
        }

        public void a(android.support.v7.view.menu.m.a aVar) {
        }

        public boolean a(s sVar) {
            return false;
        }

        public void a(g gVar, boolean z) {
        }

        public boolean b() {
            return false;
        }

        public boolean a(g gVar, h hVar) {
            this.c.k();
            if (this.c.i.getParent() != this.c) {
                this.c.addView(this.c.i);
            }
            this.c.a = hVar.getActionView();
            this.b = hVar;
            if (this.c.a.getParent() != this.c) {
                LayoutParams d = this.c.d();
                d.a = 8388611 | (this.c.n & 112);
                d.b = 2;
                this.c.a.setLayoutParams(d);
                this.c.addView(this.c.a);
            }
            this.c.e();
            this.c.requestLayout();
            hVar.e(true);
            if (this.c.a instanceof android.support.v7.view.b) {
                ((android.support.v7.view.b) this.c.a).a();
            }
            return true;
        }

        public boolean b(g gVar, h hVar) {
            if (this.c.a instanceof android.support.v7.view.b) {
                ((android.support.v7.view.b) this.c.a).b();
            }
            this.c.removeView(this.c.a);
            this.c.removeView(this.c.i);
            this.c.a = null;
            this.c.f();
            this.b = null;
            this.c.requestLayout();
            hVar.e(false);
            return true;
        }
    }

    public static class b extends android.support.v7.a.a.a {
        int b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0;
        }

        public b(int i, int i2) {
            super(i, i2);
            this.b = 0;
            this.a = 8388627;
        }

        public b(b bVar) {
            super((android.support.v7.a.a.a) bVar);
            this.b = 0;
            this.b = bVar.b;
        }

        public b(android.support.v7.a.a.a aVar) {
            super(aVar);
            this.b = 0;
        }

        public b(MarginLayoutParams marginLayoutParams) {
            super((LayoutParams) marginLayoutParams);
            this.b = 0;
            a(marginLayoutParams);
        }

        public b(LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }

        void a(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public interface c {
        boolean a(MenuItem menuItem);
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return d();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.b.a.a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.t = new ap();
        this.w = 8388627;
        this.D = new ArrayList();
        this.E = new ArrayList();
        this.F = new int[2];
        this.H = new e(this) {
            final /* synthetic */ Toolbar a;

            {
                this.a = r1;
            }

            public boolean a(MenuItem menuItem) {
                if (this.a.G != null) {
                    return this.a.G.a(menuItem);
                }
                return false;
            }
        };
        this.N = new Runnable(this) {
            final /* synthetic */ Toolbar a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.b();
            }
        };
        az a = az.a(getContext(), attributeSet, k.Toolbar, i, 0);
        this.l = a.g(k.Toolbar_titleTextAppearance, 0);
        this.m = a.g(k.Toolbar_subtitleTextAppearance, 0);
        this.w = a.c(k.Toolbar_android_gravity, this.w);
        this.n = a.c(k.Toolbar_buttonGravity, 48);
        int d = a.d(k.Toolbar_titleMargin, 0);
        if (a.f(k.Toolbar_titleMargins)) {
            d = a.d(k.Toolbar_titleMargins, d);
        }
        this.s = d;
        this.r = d;
        this.q = d;
        this.p = d;
        d = a.d(k.Toolbar_titleMarginStart, -1);
        if (d >= 0) {
            this.p = d;
        }
        d = a.d(k.Toolbar_titleMarginEnd, -1);
        if (d >= 0) {
            this.q = d;
        }
        d = a.d(k.Toolbar_titleMarginTop, -1);
        if (d >= 0) {
            this.r = d;
        }
        d = a.d(k.Toolbar_titleMarginBottom, -1);
        if (d >= 0) {
            this.s = d;
        }
        this.o = a.e(k.Toolbar_maxButtonHeight, -1);
        d = a.d(k.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d2 = a.d(k.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        this.t.b(a.e(k.Toolbar_contentInsetLeft, 0), a.e(k.Toolbar_contentInsetRight, 0));
        if (!(d == Integer.MIN_VALUE && d2 == Integer.MIN_VALUE)) {
            this.t.a(d, d2);
        }
        this.u = a.d(k.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.v = a.d(k.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.g = a.a(k.Toolbar_collapseIcon);
        this.h = a.b(k.Toolbar_collapseContentDescription);
        CharSequence b = a.b(k.Toolbar_title);
        if (!TextUtils.isEmpty(b)) {
            setTitle(b);
        }
        b = a.b(k.Toolbar_subtitle);
        if (!TextUtils.isEmpty(b)) {
            setSubtitle(b);
        }
        this.j = getContext();
        setPopupTheme(a.g(k.Toolbar_popupTheme, 0));
        Drawable a2 = a.a(k.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        b = a.b(k.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(b)) {
            setNavigationContentDescription(b);
        }
        a2 = a.a(k.Toolbar_logo);
        if (a2 != null) {
            setLogo(a2);
        }
        b = a.b(k.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(b)) {
            setLogoDescription(b);
        }
        if (a.f(k.Toolbar_titleTextColor)) {
            setTitleTextColor(a.b(k.Toolbar_titleTextColor, -1));
        }
        if (a.f(k.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.b(k.Toolbar_subtitleTextColor, -1));
        }
        a.a();
        this.O = i.a();
    }

    public void setPopupTheme(int i) {
        if (this.k != i) {
            this.k = i;
            if (i == 0) {
                this.j = getContext();
            } else {
                this.j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.k;
    }

    public int getTitleMarginStart() {
        return this.p;
    }

    public void setTitleMarginStart(int i) {
        this.p = i;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.r;
    }

    public void setTitleMarginTop(int i) {
        this.r = i;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.q;
    }

    public void setTitleMarginEnd(int i) {
        this.q = i;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.s;
    }

    public void setTitleMarginBottom(int i) {
        this.s = i;
        requestLayout();
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        ap apVar = this.t;
        if (i != 1) {
            z = false;
        }
        apVar.a(z);
    }

    public void setLogo(int i) {
        setLogo(this.O.a(getContext(), i));
    }

    public boolean a() {
        return this.b != null && this.b.e();
    }

    public boolean b() {
        return this.b != null && this.b.d();
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!d(this.f)) {
                a(this.f, true);
            }
        } else if (this.f != null && d(this.f)) {
            removeView(this.f);
            this.E.remove(this.f);
        }
        if (this.f != null) {
            this.f.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        return this.f != null ? this.f.getDrawable() : null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        if (this.f != null) {
            this.f.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        return this.f != null ? this.f.getContentDescription() : null;
    }

    private void g() {
        if (this.f == null) {
            this.f = new ImageView(getContext());
        }
    }

    public void c() {
        h hVar = this.J == null ? null : this.J.b;
        if (hVar != null) {
            hVar.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.x;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.c == null) {
                Context context = getContext();
                this.c = new TextView(context);
                this.c.setSingleLine();
                this.c.setEllipsize(TruncateAt.END);
                if (this.l != 0) {
                    this.c.setTextAppearance(context, this.l);
                }
                if (this.z != 0) {
                    this.c.setTextColor(this.z);
                }
            }
            if (!d(this.c)) {
                a(this.c, true);
            }
        } else if (this.c != null && d(this.c)) {
            removeView(this.c);
            this.E.remove(this.c);
        }
        if (this.c != null) {
            this.c.setText(charSequence);
        }
        this.x = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.y;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.d == null) {
                Context context = getContext();
                this.d = new TextView(context);
                this.d.setSingleLine();
                this.d.setEllipsize(TruncateAt.END);
                if (this.m != 0) {
                    this.d.setTextAppearance(context, this.m);
                }
                if (this.A != 0) {
                    this.d.setTextColor(this.A);
                }
            }
            if (!d(this.d)) {
                a(this.d, true);
            }
        } else if (this.d != null && d(this.d)) {
            removeView(this.d);
            this.E.remove(this.d);
        }
        if (this.d != null) {
            this.d.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void a(Context context, int i) {
        this.l = i;
        if (this.c != null) {
            this.c.setTextAppearance(context, i);
        }
    }

    public void b(Context context, int i) {
        this.m = i;
        if (this.d != null) {
            this.d.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        this.z = i;
        if (this.c != null) {
            this.c.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.A = i;
        if (this.d != null) {
            this.d.setTextColor(i);
        }
    }

    public CharSequence getNavigationContentDescription() {
        return this.e != null ? this.e.getContentDescription() : null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            j();
        }
        if (this.e != null) {
            this.e.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.O.a(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            j();
            if (!d(this.e)) {
                a(this.e, true);
            }
        } else if (this.e != null && d(this.e)) {
            removeView(this.e);
            this.E.remove(this.e);
        }
        if (this.e != null) {
            this.e.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        return this.e != null ? this.e.getDrawable() : null;
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        j();
        this.e.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        h();
        return this.b.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        h();
        this.b.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        h();
        return this.b.getOverflowIcon();
    }

    private void h() {
        i();
        if (this.b.c() == null) {
            g gVar = (g) this.b.getMenu();
            if (this.J == null) {
                this.J = new a();
            }
            this.b.setExpandedActionViewsExclusive(true);
            gVar.a(this.J, this.j);
        }
    }

    private void i() {
        if (this.b == null) {
            this.b = new ActionMenuView(getContext());
            this.b.setPopupTheme(this.k);
            this.b.setOnMenuItemClickListener(this.H);
            this.b.a(this.K, this.L);
            LayoutParams d = d();
            d.a = 8388613 | (this.n & 112);
            this.b.setLayoutParams(d);
            a(this.b, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new android.support.v7.view.d(getContext());
    }

    public void setOnMenuItemClickListener(c cVar) {
        this.G = cVar;
    }

    public void a(int i, int i2) {
        this.t.a(i, i2);
    }

    public int getContentInsetStart() {
        return this.t.c();
    }

    public int getContentInsetEnd() {
        return this.t.d();
    }

    public int getContentInsetLeft() {
        return this.t.a();
    }

    public int getContentInsetRight() {
        return this.t.b();
    }

    public int getContentInsetStartWithNavigation() {
        if (this.u != Integer.MIN_VALUE) {
            return this.u;
        }
        return getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.u) {
            this.u = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        if (this.v != Integer.MIN_VALUE) {
            return this.v;
        }
        return getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.v) {
            this.v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.u, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        int i;
        if (this.b != null) {
            g c = this.b.c();
            i = (c == null || !c.hasVisibleItems()) ? 0 : 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            return Math.max(getContentInsetEnd(), Math.max(this.v, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (ah.h(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ah.h(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    private void j() {
        if (this.e == null) {
            this.e = new ImageButton(getContext(), null, android.support.v7.b.a.a.toolbarNavigationButtonStyle);
            LayoutParams d = d();
            d.a = 8388611 | (this.n & 112);
            this.e.setLayoutParams(d);
        }
    }

    private void k() {
        if (this.i == null) {
            this.i = new ImageButton(getContext(), null, android.support.v7.b.a.a.toolbarNavigationButtonStyle);
            this.i.setImageDrawable(this.g);
            this.i.setContentDescription(this.h);
            LayoutParams d = d();
            d.a = 8388611 | (this.n & 112);
            d.b = 2;
            this.i.setLayoutParams(d);
            this.i.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ Toolbar a;

                {
                    this.a = r1;
                }

                public void onClick(View view) {
                    this.a.c();
                }
            });
        }
    }

    private void a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = d();
        } else if (checkLayoutParams(layoutParams)) {
            b bVar = (b) layoutParams;
        } else {
            layoutParams = a(layoutParams);
        }
        layoutParams.b = 1;
        if (!z || this.a == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.E.add(view);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.J == null || this.J.b == null)) {
            savedState.b = this.J.b.getItemId();
        }
        savedState.c = a();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.a());
            Menu c = this.b != null ? this.b.c() : null;
            if (!(savedState.b == 0 || this.J == null || c == null)) {
                MenuItem findItem = c.findItem(savedState.b);
                if (findItem != null) {
                    q.b(findItem);
                }
            }
            if (savedState.c) {
                l();
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void l() {
        removeCallbacks(this.N);
        post(this.N);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.N);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = t.a(motionEvent);
        if (a == 0) {
            this.B = false;
        }
        if (!this.B) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.B = true;
            }
        }
        if (a == 1 || a == 3) {
            this.B = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = t.a(motionEvent);
        if (a == 9) {
            this.C = false;
        }
        if (!this.C) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.C = true;
            }
        }
        if (a == 10 || a == 3) {
            this.C = false;
        }
        return true;
    }

    private void a(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private boolean m() {
        if (!this.M) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.F;
        if (bd.a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i7 = 0;
        if (a(this.e)) {
            a(this.e, i, 0, i2, 0, this.o);
            i7 = this.e.getMeasuredWidth() + b(this.e);
            max = Math.max(0, this.e.getMeasuredHeight() + c(this.e));
            i6 = bd.a(0, ah.j(this.e));
            i5 = max;
        }
        if (a(this.i)) {
            a(this.i, i, 0, i2, 0, this.o);
            i7 = this.i.getMeasuredWidth() + b(this.i);
            i5 = Math.max(i5, this.i.getMeasuredHeight() + c(this.i));
            i6 = bd.a(i6, ah.j(this.i));
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max2 = 0 + Math.max(currentContentInsetStart, i7);
        iArr[i4] = Math.max(0, currentContentInsetStart - i7);
        i7 = 0;
        if (a(this.b)) {
            a(this.b, i, max2, i2, 0, this.o);
            i7 = this.b.getMeasuredWidth() + b(this.b);
            i5 = Math.max(i5, this.b.getMeasuredHeight() + c(this.b));
            i6 = bd.a(i6, ah.j(this.b));
        }
        currentContentInsetStart = getCurrentContentInsetEnd();
        max2 += Math.max(currentContentInsetStart, i7);
        iArr[i3] = Math.max(0, currentContentInsetStart - i7);
        if (a(this.a)) {
            max2 += a(this.a, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.a.getMeasuredHeight() + c(this.a));
            i6 = bd.a(i6, ah.j(this.a));
        }
        if (a(this.f)) {
            max2 += a(this.f, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f.getMeasuredHeight() + c(this.f));
            i6 = bd.a(i6, ah.j(this.f));
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = i5;
        i5 = i6;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((b) childAt.getLayoutParams()).b != 0) {
                i7 = i5;
                currentContentInsetStart = i8;
            } else if (a(childAt)) {
                max2 += a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + c(childAt));
                i7 = bd.a(i5, ah.j(childAt));
                currentContentInsetStart = max;
            } else {
                i7 = i5;
                currentContentInsetStart = i8;
            }
            i3++;
            i5 = i7;
            i8 = currentContentInsetStart;
        }
        currentContentInsetStart = 0;
        i7 = 0;
        i6 = this.r + this.s;
        max = this.p + this.q;
        if (a(this.c)) {
            a(this.c, i, max2 + max, i2, i6, iArr);
            currentContentInsetStart = b(this.c) + this.c.getMeasuredWidth();
            i7 = this.c.getMeasuredHeight() + c(this.c);
            i5 = bd.a(i5, ah.j(this.c));
        }
        if (a(this.d)) {
            currentContentInsetStart = Math.max(currentContentInsetStart, a(this.d, i, max2 + max, i2, i6 + i7, iArr));
            i7 += this.d.getMeasuredHeight() + c(this.d);
            i5 = bd.a(i5, ah.j(this.d));
        }
        currentContentInsetStart += max2;
        i7 = Math.max(i8, i7) + (getPaddingTop() + getPaddingBottom());
        currentContentInsetStart = ah.a(Math.max(currentContentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, -16777216 & i5);
        i7 = ah.a(Math.max(i7, getSuggestedMinimumHeight()), i2, i5 << 16);
        if (m()) {
            i7 = 0;
        }
        setMeasuredDimension(currentContentInsetStart, i7);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object obj;
        int i5;
        int measuredHeight;
        int measuredWidth;
        if (ah.h(this) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i6 = width - paddingRight;
        int[] iArr = this.F;
        iArr[1] = 0;
        iArr[0] = 0;
        int o = ah.o(this);
        if (!a(this.e)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i6 = b(this.e, i6, iArr, o);
            i5 = paddingLeft;
        } else {
            i5 = a(this.e, paddingLeft, iArr, o);
        }
        if (a(this.i)) {
            if (obj != null) {
                i6 = b(this.i, i6, iArr, o);
            } else {
                i5 = a(this.i, i5, iArr, o);
            }
        }
        if (a(this.b)) {
            if (obj != null) {
                i5 = a(this.b, i5, iArr, o);
            } else {
                i6 = b(this.b, i6, iArr, o);
            }
        }
        int currentContentInsetLeft = getCurrentContentInsetLeft();
        int currentContentInsetRight = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft - i5);
        iArr[1] = Math.max(0, currentContentInsetRight - ((width - paddingRight) - i6));
        i5 = Math.max(i5, currentContentInsetLeft);
        i6 = Math.min(i6, (width - paddingRight) - currentContentInsetRight);
        if (a(this.a)) {
            if (obj != null) {
                i6 = b(this.a, i6, iArr, o);
            } else {
                i5 = a(this.a, i5, iArr, o);
            }
        }
        if (!a(this.f)) {
            currentContentInsetLeft = i6;
            currentContentInsetRight = i5;
        } else if (obj != null) {
            currentContentInsetLeft = b(this.f, i6, iArr, o);
            currentContentInsetRight = i5;
        } else {
            currentContentInsetLeft = i6;
            currentContentInsetRight = a(this.f, i5, iArr, o);
        }
        boolean a = a(this.c);
        boolean a2 = a(this.d);
        i5 = 0;
        if (a) {
            b bVar = (b) this.c.getLayoutParams();
            i5 = 0 + (bVar.bottomMargin + (bVar.topMargin + this.c.getMeasuredHeight()));
        }
        if (a2) {
            bVar = (b) this.d.getLayoutParams();
            measuredHeight = (bVar.bottomMargin + (bVar.topMargin + this.d.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (a || a2) {
            int paddingTop2;
            bVar = (b) (a ? this.c : this.d).getLayoutParams();
            b bVar2 = (b) (a2 ? this.d : this.c).getLayoutParams();
            Object obj2 = ((!a || this.c.getMeasuredWidth() <= 0) && (!a2 || this.d.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.w & 112) {
                case 48:
                    paddingTop2 = (bVar.topMargin + getPaddingTop()) + this.r;
                    break;
                case 80:
                    paddingTop2 = (((height - paddingBottom) - bVar2.bottomMargin) - this.s) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < bVar.topMargin + this.r) {
                        i6 = bVar.topMargin + this.r;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        if (measuredHeight < bVar.bottomMargin + this.s) {
                            i6 = Math.max(0, paddingTop2 - ((bVar2.bottomMargin + this.s) - measuredHeight));
                        } else {
                            i6 = paddingTop2;
                        }
                    }
                    paddingTop2 = paddingTop + i6;
                    break;
            }
            if (obj != null) {
                i6 = (obj2 != null ? this.p : 0) - iArr[1];
                i5 = currentContentInsetLeft - Math.max(0, i6);
                iArr[1] = Math.max(0, -i6);
                if (a) {
                    bVar = (b) this.c.getLayoutParams();
                    measuredWidth = i5 - this.c.getMeasuredWidth();
                    currentContentInsetLeft = this.c.getMeasuredHeight() + paddingTop2;
                    this.c.layout(measuredWidth, paddingTop2, i5, currentContentInsetLeft);
                    paddingTop2 = currentContentInsetLeft + bVar.bottomMargin;
                    currentContentInsetLeft = measuredWidth - this.q;
                } else {
                    currentContentInsetLeft = i5;
                }
                if (a2) {
                    bVar = (b) this.d.getLayoutParams();
                    measuredWidth = bVar.topMargin + paddingTop2;
                    measuredHeight = this.d.getMeasuredHeight() + measuredWidth;
                    this.d.layout(i5 - this.d.getMeasuredWidth(), measuredWidth, i5, measuredHeight);
                    i6 = bVar.bottomMargin + measuredHeight;
                    i6 = i5 - this.q;
                } else {
                    i6 = i5;
                }
                if (obj2 != null) {
                    i6 = Math.min(currentContentInsetLeft, i6);
                } else {
                    i6 = i5;
                }
                currentContentInsetLeft = i6;
            } else {
                i6 = (obj2 != null ? this.p : 0) - iArr[0];
                currentContentInsetRight += Math.max(0, i6);
                iArr[0] = Math.max(0, -i6);
                if (a) {
                    bVar = (b) this.c.getLayoutParams();
                    i5 = this.c.getMeasuredWidth() + currentContentInsetRight;
                    measuredWidth = this.c.getMeasuredHeight() + paddingTop2;
                    this.c.layout(currentContentInsetRight, paddingTop2, i5, measuredWidth);
                    i6 = bVar.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.q;
                    i5 = i6;
                } else {
                    measuredWidth = currentContentInsetRight;
                    i5 = paddingTop2;
                }
                if (a2) {
                    bVar = (b) this.d.getLayoutParams();
                    i5 += bVar.topMargin;
                    paddingTop2 = this.d.getMeasuredWidth() + currentContentInsetRight;
                    measuredHeight = this.d.getMeasuredHeight() + i5;
                    this.d.layout(currentContentInsetRight, i5, paddingTop2, measuredHeight);
                    i6 = bVar.bottomMargin + measuredHeight;
                    i6 = this.q + paddingTop2;
                } else {
                    i6 = currentContentInsetRight;
                }
                if (obj2 != null) {
                    currentContentInsetRight = Math.max(measuredWidth, i6);
                }
            }
        }
        a(this.D, 3);
        int size = this.D.size();
        i5 = currentContentInsetRight;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = a((View) this.D.get(measuredWidth), i5, iArr, o);
        }
        a(this.D, 5);
        currentContentInsetRight = this.D.size();
        for (measuredWidth = 0; measuredWidth < currentContentInsetRight; measuredWidth++) {
            currentContentInsetLeft = b((View) this.D.get(measuredWidth), currentContentInsetLeft, iArr, o);
        }
        a(this.D, 1);
        measuredWidth = a(this.D, iArr);
        i6 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += i6;
        if (i6 < i5) {
            i6 = i5;
        } else if (measuredWidth > currentContentInsetLeft) {
            i6 -= measuredWidth - currentContentInsetLeft;
        }
        paddingLeft = this.D.size();
        measuredWidth = i6;
        for (i5 = 0; i5 < paddingLeft; i5++) {
            measuredWidth = a((View) this.D.get(i5), measuredWidth, iArr, o);
        }
        this.D.clear();
    }

    private int a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            b bVar = (b) view.getLayoutParams();
            i6 = bVar.leftMargin - i6;
            i = bVar.rightMargin - i5;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i);
            i6 = Math.max(0, -i6);
            i5 = Math.max(0, -i);
            i3++;
            i4 += (view.getMeasuredWidth() + max) + max2;
        }
        return i4;
    }

    private int a(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (bVar.rightMargin + measuredWidth) + max;
    }

    private int b(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (bVar.leftMargin + measuredWidth);
    }

    private int a(View view, int i) {
        b bVar = (b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (a(bVar.a)) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < bVar.topMargin) {
                    i3 = bVar.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < bVar.bottomMargin ? Math.max(0, i2 - (bVar.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int a(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.w & 112;
        }
    }

    private void a(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (ah.h(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int a = f.a(i, ah.h(this));
        list.clear();
        b bVar;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                bVar = (b) childAt.getLayoutParams();
                if (bVar.b == 0 && a(childAt) && b(bVar.a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            bVar = (b) childAt2.getLayoutParams();
            if (bVar.b == 0 && a(childAt2) && b(bVar.a) == a) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private int b(int i) {
        int h = ah.h(this);
        int a = f.a(i, h) & 7;
        switch (a) {
            case 1:
            case 3:
            case 5:
                return a;
            default:
                return h == 1 ? 5 : 3;
        }
    }

    private boolean a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int b(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return o.b(marginLayoutParams) + o.a(marginLayoutParams);
    }

    private int c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    public b a(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    protected b a(LayoutParams layoutParams) {
        if (layoutParams instanceof b) {
            return new b((b) layoutParams);
        }
        if (layoutParams instanceof android.support.v7.a.a.a) {
            return new b((android.support.v7.a.a.a) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new b((MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    protected b d() {
        return new b(-2, -2);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b);
    }

    public w getWrapper() {
        if (this.I == null) {
            this.I = new ba(this, true);
        }
        return this.I;
    }

    void e() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((b) childAt.getLayoutParams()).b == 2 || childAt == this.b)) {
                removeViewAt(childCount);
                this.E.add(childAt);
            }
        }
    }

    void f() {
        for (int size = this.E.size() - 1; size >= 0; size--) {
            addView((View) this.E.get(size));
        }
        this.E.clear();
    }

    private boolean d(View view) {
        return view.getParent() == this || this.E.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.M = z;
        requestLayout();
    }
}
