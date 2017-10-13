package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.q;
import android.support.v7.view.menu.s;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

class d extends android.support.v7.view.menu.b implements android.support.v4.view.d.a {
    private b A;
    final f g = new f();
    int h;
    private d i;
    private Drawable j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private final SparseBooleanArray v = new SparseBooleanArray();
    private View w;
    private e x;
    private a y;
    private c z;

    private class a extends l {
        final /* synthetic */ d a;

        public a(d dVar, Context context, s sVar, View view) {
            this.a = dVar;
            super(context, sVar, view, false, android.support.v7.b.a.a.actionOverflowMenuStyle);
            if (!((h) sVar.getItem()).j()) {
                a(dVar.i == null ? (View) dVar.f : dVar.i);
            }
            a(dVar.g);
        }

        protected void e() {
            this.a.y = null;
            this.a.h = 0;
            super.e();
        }
    }

    private class b extends android.support.v7.view.menu.ActionMenuItemView.b {
        final /* synthetic */ d a;

        private b(d dVar) {
            this.a = dVar;
        }

        public q a() {
            return this.a.y != null ? this.a.y.b() : null;
        }
    }

    private class c implements Runnable {
        final /* synthetic */ d a;
        private e b;

        public c(d dVar, e eVar) {
            this.a = dVar;
            this.b = eVar;
        }

        public void run() {
            if (this.a.c != null) {
                this.a.c.e();
            }
            View view = (View) this.a.f;
            if (!(view == null || view.getWindowToken() == null || !this.b.c())) {
                this.a.x = this.b;
            }
            this.a.z = null;
        }
    }

    private class d extends k implements android.support.v7.widget.ActionMenuView.a {
        final /* synthetic */ d a;
        private final float[] b = new float[2];

        public d(final d dVar, Context context) {
            this.a = dVar;
            super(context, null, android.support.v7.b.a.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new ab(this, this) {
                final /* synthetic */ d b;

                public q a() {
                    if (this.b.a.x == null) {
                        return null;
                    }
                    return this.b.a.x.b();
                }

                public boolean b() {
                    this.b.a.d();
                    return true;
                }

                public boolean c() {
                    if (this.b.a.z != null) {
                        return false;
                    }
                    this.b.a.e();
                    return true;
                }
            });
        }

        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                this.a.d();
            }
            return true;
        }

        public boolean c() {
            return false;
        }

        public boolean d() {
            return false;
        }

        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                android.support.v4.b.a.a.a(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    private class e extends l {
        final /* synthetic */ d a;

        public e(d dVar, Context context, g gVar, View view, boolean z) {
            this.a = dVar;
            super(context, gVar, view, z, android.support.v7.b.a.a.actionOverflowMenuStyle);
            a(8388613);
            a(dVar.g);
        }

        protected void e() {
            if (this.a.c != null) {
                this.a.c.close();
            }
            this.a.x = null;
            super.e();
        }
    }

    private class f implements android.support.v7.view.menu.m.a {
        final /* synthetic */ d a;

        private f(d dVar) {
            this.a = dVar;
        }

        public boolean a(g gVar) {
            if (gVar == null) {
                return false;
            }
            this.a.h = ((s) gVar).getItem().getItemId();
            android.support.v7.view.menu.m.a a = this.a.a();
            return a != null ? a.a(gVar) : false;
        }

        public void a(g gVar, boolean z) {
            if (gVar instanceof s) {
                gVar.m().a(false);
            }
            android.support.v7.view.menu.m.a a = this.a.a();
            if (a != null) {
                a.a(gVar, z);
            }
        }
    }

    public d(Context context) {
        super(context, android.support.v7.b.a.h.abc_action_menu_layout, android.support.v7.b.a.h.abc_action_menu_item_layout);
    }

    public void a(Context context, g gVar) {
        super.a(context, gVar);
        Resources resources = context.getResources();
        android.support.v7.view.a a = android.support.v7.view.a.a(context);
        if (!this.m) {
            this.l = a.b();
        }
        if (!this.s) {
            this.n = a.c();
        }
        if (!this.q) {
            this.p = a.a();
        }
        int i = this.n;
        if (this.l) {
            if (this.i == null) {
                this.i = new d(this, this.a);
                if (this.k) {
                    this.i.setImageDrawable(this.j);
                    this.j = null;
                    this.k = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.i.getMeasuredWidth();
        } else {
            this.i = null;
        }
        this.o = i;
        this.u = (int) (56.0f * resources.getDisplayMetrics().density);
        this.w = null;
    }

    public void a(Configuration configuration) {
        if (!this.q) {
            this.p = android.support.v7.view.a.a(this.b).a();
        }
        if (this.c != null) {
            this.c.b(true);
        }
    }

    public void c(boolean z) {
        this.l = z;
        this.m = true;
    }

    public void d(boolean z) {
        this.t = z;
    }

    public void a(Drawable drawable) {
        if (this.i != null) {
            this.i.setImageDrawable(drawable);
            return;
        }
        this.k = true;
        this.j = drawable;
    }

    public Drawable c() {
        if (this.i != null) {
            return this.i.getDrawable();
        }
        if (this.k) {
            return this.j;
        }
        return null;
    }

    public View a(h hVar, View view, ViewGroup viewGroup) {
        View actionView = hVar.getActionView();
        if (actionView == null || hVar.n()) {
            actionView = super.a(hVar, view, viewGroup);
        }
        actionView.setVisibility(hVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.a(layoutParams));
        }
        return actionView;
    }

    public void a(h hVar, android.support.v7.view.menu.n.a aVar) {
        aVar.a(hVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.A == null) {
            this.A = new b();
        }
        actionMenuItemView.setPopupCallback(this.A);
    }

    public boolean a(int i, h hVar) {
        return hVar.j();
    }

    public void b(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ViewGroup viewGroup = (ViewGroup) ((View) this.f).getParent();
        if (viewGroup != null) {
            android.support.v7.h.a.a(viewGroup);
        }
        super.b(z);
        ((View) this.f).requestLayout();
        if (this.c != null) {
            ArrayList j = this.c.j();
            int size = j.size();
            for (i = 0; i < size; i++) {
                android.support.v4.view.d a = ((h) j.get(i)).a();
                if (a != null) {
                    a.a((android.support.v4.view.d.a) this);
                }
            }
        }
        ArrayList k = this.c != null ? this.c.k() : null;
        if (this.l && k != null) {
            i = k.size();
            if (i == 1) {
                int i4;
                if (((h) k.get(0)).isActionViewExpanded()) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                i3 = i4;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.i == null) {
                this.i = new d(this, this.a);
            }
            viewGroup = (ViewGroup) this.i.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.i, actionMenuView.b());
            }
        } else if (this.i != null && this.i.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.i);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.l);
    }

    public boolean a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.i) {
            return false;
        }
        return super.a(viewGroup, i);
    }

    public boolean a(s sVar) {
        if (!sVar.hasVisibleItems()) {
            return false;
        }
        s sVar2 = sVar;
        while (sVar2.p() != this.c) {
            sVar2 = (s) sVar2.p();
        }
        View a = a(sVar2.getItem());
        if (a == null) {
            return false;
        }
        boolean z;
        this.h = sVar.getItem().getItemId();
        int size = sVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = sVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        z = false;
        this.y = new a(this, this.b, sVar, a);
        this.y.a(z);
        this.y.a();
        super.a(sVar);
        return true;
    }

    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof android.support.v7.view.menu.n.a) && ((android.support.v7.view.menu.n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean d() {
        if (!this.l || h() || this.c == null || this.f == null || this.z != null || this.c.k().isEmpty()) {
            return false;
        }
        this.z = new c(this, new e(this, this.b, this.c, this.i, true));
        ((View) this.f).post(this.z);
        super.a(null);
        return true;
    }

    public boolean e() {
        if (this.z == null || this.f == null) {
            l lVar = this.x;
            if (lVar == null) {
                return false;
            }
            lVar.d();
            return true;
        }
        ((View) this.f).removeCallbacks(this.z);
        this.z = null;
        return true;
    }

    public boolean f() {
        return e() | g();
    }

    public boolean g() {
        if (this.y == null) {
            return false;
        }
        this.y.d();
        return true;
    }

    public boolean h() {
        return this.x != null && this.x.f();
    }

    public boolean b() {
        int size;
        ArrayList arrayList;
        int i;
        if (this.c != null) {
            ArrayList h = this.c.h();
            size = h.size();
            arrayList = h;
        } else {
            size = 0;
            arrayList = null;
        }
        int i2 = this.p;
        int i3 = this.o;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f;
        int i4 = 0;
        int i5 = 0;
        Object obj = null;
        int i6 = 0;
        while (i6 < size) {
            h hVar = (h) arrayList.get(i6);
            if (hVar.l()) {
                i4++;
            } else if (hVar.k()) {
                i5++;
            } else {
                obj = 1;
            }
            if (this.t && hVar.isActionViewExpanded()) {
                i = 0;
            } else {
                i = i2;
            }
            i6++;
            i2 = i;
        }
        if (this.l && (r4 != null || i4 + i5 > i2)) {
            i2--;
        }
        i6 = i2 - i4;
        SparseBooleanArray sparseBooleanArray = this.v;
        sparseBooleanArray.clear();
        i = 0;
        if (this.r) {
            i = i3 / this.u;
            i5 = ((i3 % this.u) / i) + this.u;
        } else {
            i5 = 0;
        }
        int i7 = 0;
        i2 = 0;
        int i8 = i;
        while (i7 < size) {
            hVar = (h) arrayList.get(i7);
            int i9;
            if (hVar.l()) {
                View a = a(hVar, this.w, viewGroup);
                if (this.w == null) {
                    this.w = a;
                }
                if (this.r) {
                    i8 -= ActionMenuView.a(a, i5, i8, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i4 = a.getMeasuredWidth();
                i9 = i3 - i4;
                if (i2 != 0) {
                    i4 = i2;
                }
                i2 = hVar.getGroupId();
                if (i2 != 0) {
                    sparseBooleanArray.put(i2, true);
                }
                hVar.d(true);
                i = i9;
                i2 = i6;
            } else if (hVar.k()) {
                boolean z;
                int groupId = hVar.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i6 > 0 || z2) && i3 > 0 && (!this.r || i8 > 0);
                if (z3) {
                    View a2 = a(hVar, this.w, viewGroup);
                    if (this.w == null) {
                        this.w = a2;
                    }
                    boolean z4;
                    if (this.r) {
                        int a3 = ActionMenuView.a(a2, i5, i8, makeMeasureSpec, 0);
                        i9 = i8 - a3;
                        if (a3 == 0) {
                            i8 = 0;
                        } else {
                            z4 = z3;
                        }
                        i4 = i9;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i4 = i8;
                        z4 = z5;
                    }
                    i9 = a2.getMeasuredWidth();
                    i3 -= i9;
                    if (i2 == 0) {
                        i2 = i9;
                    }
                    if (this.r) {
                        z = i8 & (i3 >= 0 ? 1 : 0);
                        i9 = i2;
                        i2 = i4;
                    } else {
                        z = i8 & (i3 + i2 > 0 ? 1 : 0);
                        i9 = i2;
                        i2 = i4;
                    }
                } else {
                    z = z3;
                    i9 = i2;
                    i2 = i8;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i8 = i6;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i4 = i6;
                    for (i6 = 0; i6 < i7; i6++) {
                        h hVar2 = (h) arrayList.get(i6);
                        if (hVar2.getGroupId() == groupId) {
                            if (hVar2.j()) {
                                i4++;
                            }
                            hVar2.d(false);
                        }
                    }
                    i8 = i4;
                } else {
                    i8 = i6;
                }
                if (z) {
                    i8--;
                }
                hVar.d(z);
                i4 = i9;
                i = i3;
                int i10 = i2;
                i2 = i8;
                i8 = i10;
            } else {
                hVar.d(false);
                i4 = i2;
                i = i3;
                i2 = i6;
            }
            i7++;
            i3 = i;
            i6 = i2;
            i2 = i4;
        }
        return true;
    }

    public void a(g gVar, boolean z) {
        f();
        super.a(gVar, z);
    }

    public void a(boolean z) {
        if (z) {
            super.a(null);
        } else if (this.c != null) {
            this.c.a(false);
        }
    }

    public void a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.a(this.c);
    }
}
