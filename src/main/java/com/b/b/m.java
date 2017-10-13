package com.b.b;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.b.b.a.b;
import com.b.b.b.c.b.a;
import com.b.b.b.f;

public class m extends k implements a {
    static final /* synthetic */ boolean w = (!m.class.desiredAssertionStatus());
    Drawable k;
    int l;
    Drawable m;
    int n;
    Animation o;
    Animation p;
    int q;
    int r;
    b s;
    boolean t = true;
    boolean u;
    b v = b.a;

    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    public /* synthetic */ f d(int i) {
        return c(i);
    }

    public /* bridge */ /* synthetic */ k d() {
        return super.d();
    }

    public /* synthetic */ f e(int i) {
        return b(i);
    }

    public /* synthetic */ f f(int i) {
        return a(i);
    }

    public m(j jVar) {
        super(jVar);
    }

    void a() {
        super.a();
        this.t = true;
        this.u = false;
        this.s = null;
        this.k = null;
        this.v = b.a;
        this.l = 0;
        this.m = null;
        this.n = 0;
        this.o = null;
        this.r = 0;
        this.p = null;
        this.q = 0;
    }

    protected o b() {
        if (this.a == null) {
            this.a = new o(d.a(this.s.b().getApplicationContext()), this.b);
        }
        return this.a;
    }

    public com.b.b.e.a b(String str) {
        b();
        this.a.a(str);
        return b((ImageView) this.s.get());
    }

    m a(ImageView imageView) {
        if (this.s == null || this.s.get() != imageView) {
            this.s = new b(imageView);
        }
        return this;
    }

    private l a(ImageView imageView, c cVar, y yVar) {
        b bVar;
        boolean z = false;
        if (cVar != null) {
            bVar = cVar.c;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            cVar = null;
        }
        l b = l.a(imageView).a(this.b).a(bVar, yVar).a(cVar).b(this.g == com.b.b.b.a.ANIMATE).a(this.e, this.f).a(this.n, this.m).b(this.l, this.k);
        if (this.t || this.u) {
            z = true;
        }
        Drawable e = b.a(z).a(this.v).e();
        imageView.setImageDrawable(e);
        return e;
    }

    @TargetApi(16)
    private static boolean c(ImageView imageView) {
        return imageView.getAdjustViewBounds();
    }

    private static boolean d(ImageView imageView) {
        return VERSION.SDK_INT >= 16 && c(imageView);
    }

    public com.b.b.e.a b(ImageView imageView) {
        if (!w && Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new AssertionError();
        } else if (imageView == null) {
            throw new NullPointerException("imageView");
        } else if (this.a.e == null) {
            a(imageView, null, y.LOADED_FROM_NETWORK).d();
            return i.a;
        } else {
            a(imageView);
            if (this.u) {
                Drawable drawable = imageView.getDrawable();
                if (drawable instanceof l) {
                    drawable = ((l) drawable).b();
                }
                a(drawable);
            }
            int i = this.e;
            int i2 = this.f;
            if (this.f == 0 && this.e == 0 && !d(imageView)) {
                i = imageView.getMeasuredWidth();
                i2 = imageView.getMeasuredHeight();
            } else {
                c();
            }
            c a = a(i, i2);
            l a2;
            com.b.b.e.a a3;
            if (a.c != null) {
                k.a(imageView, null, 0);
                a2 = a(imageView, a, y.LOADED_FROM_MEMORY);
                a2.d();
                a3 = i.a(this.s, a2).a(this.o, this.r).a(this.d);
                i.a(imageView, this.d);
                a3.k();
                a3.b(a.c.g, imageView);
                return a3;
            }
            a2 = a(imageView, a, y.LOADED_FROM_NETWORK);
            k.a(imageView, this.p, this.q);
            a3 = i.a(this.s, a2).a(this.o, this.r).a(this.d);
            a3.k();
            return a3;
        }
    }

    public m a(Drawable drawable) {
        this.k = drawable;
        return this;
    }

    public m a(int i) {
        this.l = i;
        return this;
    }

    public m b(int i) {
        this.n = i;
        return this;
    }

    public m c(int i) {
        this.r = i;
        return this;
    }
}
