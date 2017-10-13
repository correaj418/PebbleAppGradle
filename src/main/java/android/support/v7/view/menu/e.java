package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.f;
import android.support.v7.b.a.d;
import android.support.v7.b.a.h;
import android.support.v7.widget.ah;
import android.support.v7.widget.ai;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class e extends k implements m, OnKeyListener, OnDismissListener {
    private final Context a;
    private final int b;
    private final int c;
    private final int d;
    private final boolean e;
    private final Handler f;
    private final List<g> g = new LinkedList();
    private final List<a> h = new ArrayList();
    private final OnGlobalLayoutListener i = new OnGlobalLayoutListener(this) {
        final /* synthetic */ e a;

        {
            this.a = r1;
        }

        public void onGlobalLayout() {
            if (this.a.d() && this.a.h.size() > 0 && !((a) this.a.h.get(0)).a.g()) {
                View b = this.a.n;
                if (b == null || !b.isShown()) {
                    this.a.c();
                    return;
                }
                for (a aVar : this.a.h) {
                    aVar.a.a();
                }
            }
        }
    };
    private final ah j = new ah(this) {
        final /* synthetic */ e a;

        {
            this.a = r1;
        }

        public void a(g gVar, MenuItem menuItem) {
            this.a.f.removeCallbacksAndMessages(gVar);
        }

        public void b(final g gVar, final MenuItem menuItem) {
            int i;
            this.a.f.removeCallbacksAndMessages(null);
            int size = this.a.h.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (gVar == ((a) this.a.h.get(i2)).b) {
                    i = i2;
                    break;
                }
            }
            i = -1;
            if (i != -1) {
                a aVar;
                i++;
                if (i < this.a.h.size()) {
                    aVar = (a) this.a.h.get(i);
                } else {
                    aVar = null;
                }
                this.a.f.postAtTime(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 d;

                    public void run() {
                        if (aVar != null) {
                            this.d.a.y = true;
                            aVar.b.a(false);
                            this.d.a.y = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            gVar.a(menuItem, 0);
                        }
                    }
                }, gVar, SystemClock.uptimeMillis() + 200);
            }
        }
    };
    private int k = 0;
    private int l = 0;
    private View m;
    private View n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private android.support.v7.view.menu.m.a v;
    private ViewTreeObserver w;
    private OnDismissListener x;
    private boolean y;

    private static class a {
        public final ai a;
        public final g b;
        public final int c;

        public a(ai aiVar, g gVar, int i) {
            this.a = aiVar;
            this.b = gVar;
            this.c = i;
        }

        public ListView a() {
            return this.a.e();
        }
    }

    public e(Context context, View view, int i, int i2, boolean z) {
        this.a = context;
        this.m = view;
        this.c = i;
        this.d = i2;
        this.e = z;
        this.t = false;
        this.o = h();
        Resources resources = context.getResources();
        this.b = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.f = new Handler();
    }

    public void a(boolean z) {
        this.t = z;
    }

    private ai g() {
        ai aiVar = new ai(this.a, null, this.c, this.d);
        aiVar.a(this.j);
        aiVar.a((OnItemClickListener) this);
        aiVar.a((OnDismissListener) this);
        aiVar.a(this.m);
        aiVar.e(this.l);
        aiVar.a(true);
        return aiVar;
    }

    public void a() {
        if (!d()) {
            for (g c : this.g) {
                c(c);
            }
            this.g.clear();
            this.n = this.m;
            if (this.n != null) {
                Object obj = this.w == null ? 1 : null;
                this.w = this.n.getViewTreeObserver();
                if (obj != null) {
                    this.w.addOnGlobalLayoutListener(this.i);
                }
            }
        }
    }

    public void c() {
        int size = this.h.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.h.toArray(new a[size]);
            for (size--; size >= 0; size--) {
                a aVar = aVarArr[size];
                if (aVar.a.d()) {
                    aVar.a.c();
                }
            }
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        c();
        return true;
    }

    private int h() {
        if (android.support.v4.view.ah.h(this.m) == 1) {
            return 0;
        }
        return 1;
    }

    private int d(int i) {
        ListView a = ((a) this.h.get(this.h.size() - 1)).a();
        int[] iArr = new int[2];
        a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.n.getWindowVisibleDisplayFrame(rect);
        if (this.o == 1) {
            if ((a.getWidth() + iArr[0]) + i > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public void a(g gVar) {
        gVar.a((m) this, this.a);
        if (d()) {
            c(gVar);
        } else {
            this.g.add(gVar);
        }
    }

    private void c(g gVar) {
        View a;
        a aVar;
        LayoutInflater from = LayoutInflater.from(this.a);
        Object fVar = new f(gVar, from, this.e);
        if (!d() && this.t) {
            fVar.a(true);
        } else if (d()) {
            fVar.a(k.b(gVar));
        }
        int a2 = k.a(fVar, null, this.a, this.b);
        ai g = g();
        g.a((ListAdapter) fVar);
        g.f(a2);
        g.e(this.l);
        if (this.h.size() > 0) {
            a aVar2 = (a) this.h.get(this.h.size() - 1);
            a = a(aVar2, gVar);
            aVar = aVar2;
        } else {
            a = null;
            aVar = null;
        }
        if (a != null) {
            boolean z;
            int i;
            g.b(false);
            g.a(null);
            int d = d(a2);
            if (d == 1) {
                z = true;
            } else {
                z = false;
            }
            this.o = d;
            int[] iArr = new int[2];
            a.getLocationInWindow(iArr);
            int j = aVar.a.j() + iArr[0];
            int k = iArr[1] + aVar.a.k();
            if ((this.l & 5) == 5) {
                if (z) {
                    i = j + a2;
                } else {
                    i = j - a.getWidth();
                }
            } else if (z) {
                i = a.getWidth() + j;
            } else {
                i = j - a2;
            }
            g.c(i);
            g.d(k);
        } else {
            if (this.p) {
                g.c(this.r);
            }
            if (this.q) {
                g.d(this.s);
            }
            g.a(f());
        }
        this.h.add(new a(g, gVar, this.o));
        g.a();
        if (aVar == null && this.u && gVar.l() != null) {
            ViewGroup e = g.e();
            FrameLayout frameLayout = (FrameLayout) from.inflate(h.abc_popup_menu_header_item_layout, e, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            frameLayout.setEnabled(false);
            textView.setText(gVar.l());
            e.addHeaderView(frameLayout, null, false);
            g.a();
        }
    }

    private MenuItem a(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = gVar.getItem(i);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(a aVar, g gVar) {
        int i = 0;
        MenuItem a = a(aVar.b, gVar);
        if (a == null) {
            return null;
        }
        int headersCount;
        f fVar;
        int i2;
        ListView a2 = aVar.a();
        ListAdapter adapter = a2.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            headersCount = 0;
        }
        int count = fVar.getCount();
        while (i < count) {
            if (a == fVar.a(i)) {
                i2 = i;
                break;
            }
            i++;
        }
        i2 = -1;
        if (i2 == -1) {
            return null;
        }
        i2 = (i2 + headersCount) - a2.getFirstVisiblePosition();
        if (i2 < 0 || i2 >= a2.getChildCount()) {
            return null;
        }
        return a2.getChildAt(i2);
    }

    public boolean d() {
        return this.h.size() > 0 && ((a) this.h.get(0)).a.d();
    }

    public void onDismiss() {
        a aVar;
        int size = this.h.size();
        for (int i = 0; i < size; i++) {
            aVar = (a) this.h.get(i);
            if (!aVar.a.d()) {
                break;
            }
        }
        aVar = null;
        if (aVar != null) {
            aVar.b.a(false);
        }
    }

    public void b(boolean z) {
        for (a a : this.h) {
            k.a(a.a().getAdapter()).notifyDataSetChanged();
        }
    }

    public void a(android.support.v7.view.menu.m.a aVar) {
        this.v = aVar;
    }

    public boolean a(s sVar) {
        for (a aVar : this.h) {
            if (sVar == aVar.b) {
                aVar.a().requestFocus();
                return true;
            }
        }
        if (!sVar.hasVisibleItems()) {
            return false;
        }
        a((g) sVar);
        if (this.v != null) {
            this.v.a(sVar);
        }
        return true;
    }

    private int d(g gVar) {
        int size = this.h.size();
        for (int i = 0; i < size; i++) {
            if (gVar == ((a) this.h.get(i)).b) {
                return i;
            }
        }
        return -1;
    }

    public void a(g gVar, boolean z) {
        int d = d(gVar);
        if (d >= 0) {
            int i = d + 1;
            if (i < this.h.size()) {
                ((a) this.h.get(i)).b.a(false);
            }
            a aVar = (a) this.h.remove(d);
            aVar.b.a((m) this);
            if (this.y) {
                aVar.a.b(null);
                aVar.a.b(0);
            }
            aVar.a.c();
            d = this.h.size();
            if (d > 0) {
                this.o = ((a) this.h.get(d - 1)).c;
            } else {
                this.o = h();
            }
            if (d == 0) {
                c();
                if (this.v != null) {
                    this.v.a(gVar, true);
                }
                if (this.w != null) {
                    if (this.w.isAlive()) {
                        this.w.removeGlobalOnLayoutListener(this.i);
                    }
                    this.w = null;
                }
                this.x.onDismiss();
            } else if (z) {
                ((a) this.h.get(0)).b.a(false);
            }
        }
    }

    public boolean b() {
        return false;
    }

    public void a(int i) {
        if (this.k != i) {
            this.k = i;
            this.l = f.a(i, android.support.v4.view.ah.h(this.m));
        }
    }

    public void a(View view) {
        if (this.m != view) {
            this.m = view;
            this.l = f.a(this.k, android.support.v4.view.ah.h(this.m));
        }
    }

    public void a(OnDismissListener onDismissListener) {
        this.x = onDismissListener;
    }

    public ListView e() {
        if (this.h.isEmpty()) {
            return null;
        }
        return ((a) this.h.get(this.h.size() - 1)).a();
    }

    public void b(int i) {
        this.p = true;
        this.r = i;
    }

    public void c(int i) {
        this.q = true;
        this.s = i;
    }

    public void c(boolean z) {
        this.u = z;
    }
}
