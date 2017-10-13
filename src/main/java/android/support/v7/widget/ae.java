package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.q.a;
import android.support.v7.widget.RecyclerView.r;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public abstract class ae extends q {
    private final float a;
    protected final LinearInterpolator b = new LinearInterpolator();
    protected final DecelerateInterpolator c = new DecelerateInterpolator();
    protected PointF d;
    protected int e = 0;
    protected int f = 0;

    public abstract PointF a(int i);

    public ae(Context context) {
        this.a = a(context.getResources().getDisplayMetrics());
    }

    protected void a() {
    }

    protected void a(View view, r rVar, a aVar) {
        int b = b(view, c());
        int a = a(view, d());
        int b2 = b((int) Math.sqrt((double) ((b * b) + (a * a))));
        if (b2 > 0) {
            aVar.a(-b, -a, b2, this.c);
        }
    }

    protected void a(int i, int i2, r rVar, a aVar) {
        if (j() == 0) {
            f();
            return;
        }
        this.e = a(this.e, i);
        this.f = a(this.f, i2);
        if (this.e == 0 && this.f == 0) {
            a(aVar);
        }
    }

    protected void b() {
        this.f = 0;
        this.e = 0;
        this.d = null;
    }

    protected float a(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    protected int b(int i) {
        return (int) Math.ceil(((double) c(i)) / 0.3356d);
    }

    protected int c(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.a));
    }

    protected int c() {
        if (this.d == null || this.d.x == 0.0f) {
            return 0;
        }
        return this.d.x > 0.0f ? 1 : -1;
    }

    protected int d() {
        if (this.d == null || this.d.y == 0.0f) {
            return 0;
        }
        return this.d.y > 0.0f ? 1 : -1;
    }

    protected void a(a aVar) {
        PointF a = a(i());
        if (a == null || (a.x == 0.0f && a.y == 0.0f)) {
            Log.e("LinearSmoothScroller", "To support smooth scrolling, you should override \nLayoutManager#computeScrollVectorForPosition.\nFalling back to instant scroll");
            aVar.a(i());
            f();
            return;
        }
        a(a);
        this.d = a;
        this.e = (int) (a.x * 10000.0f);
        this.f = (int) (a.y * 10000.0f);
        aVar.a((int) (((float) this.e) * 1.2f), (int) (((float) this.f) * 1.2f), (int) (((float) c(10000)) * 1.2f), this.b);
    }

    private int a(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    public int a(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case -1:
                return i3 - i;
            case 0:
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                i6 = i4 - i2;
                return i6 >= 0 ? 0 : i6;
            case 1:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int a(View view, int i) {
        h e = e();
        if (e == null || !e.e()) {
            return 0;
        }
        i iVar = (i) view.getLayoutParams();
        return a(e.i(view) - iVar.topMargin, e.k(view) + iVar.bottomMargin, e.z(), e.x() - e.B(), i);
    }

    public int b(View view, int i) {
        h e = e();
        if (e == null || !e.d()) {
            return 0;
        }
        i iVar = (i) view.getLayoutParams();
        return a(e.h(view) - iVar.leftMargin, e.j(view) + iVar.rightMargin, e.y(), e.w() - e.A(), i);
    }
}
