package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.ah;
import android.support.v4.view.f;
import android.support.v7.b.a.d;
import android.support.v7.view.menu.m.a;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;

public class l {
    private final Context a;
    private final g b;
    private final boolean c;
    private final int d;
    private final int e;
    private View f;
    private int g;
    private boolean h;
    private a i;
    private k j;
    private OnDismissListener k;
    private final OnDismissListener l;

    public l(Context context, g gVar, View view, boolean z, int i) {
        this(context, gVar, view, z, i, 0);
    }

    public l(Context context, g gVar, View view, boolean z, int i, int i2) {
        this.g = 8388611;
        this.l = new OnDismissListener(this) {
            final /* synthetic */ l a;

            {
                this.a = r1;
            }

            public void onDismiss() {
                this.a.e();
            }
        };
        this.a = context;
        this.b = gVar;
        this.f = view;
        this.c = z;
        this.d = i;
        this.e = i2;
    }

    public void a(OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    public void a(View view) {
        this.f = view;
    }

    public void a(boolean z) {
        this.h = z;
        if (this.j != null) {
            this.j.a(z);
        }
    }

    public void a(int i) {
        this.g = i;
    }

    public void a() {
        if (!c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public k b() {
        if (this.j == null) {
            this.j = g();
        }
        return this.j;
    }

    public boolean c() {
        if (f()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public boolean a(int i, int i2) {
        if (f()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(i, i2, true, true);
        return true;
    }

    private k g() {
        k eVar;
        Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else if (VERSION.SDK_INT >= 13) {
            defaultDisplay.getSize(point);
        } else {
            point.set(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        }
        if ((Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(d.abc_cascading_menus_min_smallest_width) ? 1 : null) != null) {
            eVar = new e(this.a, this.f, this.d, this.e, this.c);
        } else {
            eVar = new r(this.a, this.b, this.f, this.d, this.e, this.c);
        }
        eVar.a(this.b);
        eVar.a(this.l);
        eVar.a(this.f);
        eVar.a(this.i);
        eVar.a(this.h);
        eVar.a(this.g);
        return eVar;
    }

    private void a(int i, int i2, boolean z, boolean z2) {
        k b = b();
        b.c(z2);
        if (z) {
            if ((f.a(this.g, ah.h(this.f)) & 7) == 5) {
                i -= this.f.getWidth();
            }
            b.b(i);
            b.c(i2);
            int i3 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            b.a(new Rect(i - i3, i2 - i3, i + i3, i3 + i2));
        }
        b.a();
    }

    public void d() {
        if (f()) {
            this.j.c();
        }
    }

    protected void e() {
        this.j = null;
        if (this.k != null) {
            this.k.onDismiss();
        }
    }

    public boolean f() {
        return this.j != null && this.j.d();
    }

    public void a(a aVar) {
        this.i = aVar;
        if (this.j != null) {
            this.j.a(aVar);
        }
    }
}
