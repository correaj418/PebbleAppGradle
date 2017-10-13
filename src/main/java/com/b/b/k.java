package com.b.b;

import android.graphics.Bitmap;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.b.a.b.i;
import com.b.a.f.c;
import com.b.b.a.g;
import com.b.b.a.j;
import com.b.b.b.a;
import com.b.b.b.c.a.b;
import java.util.ArrayList;
import java.util.List;

abstract class k implements b {
    static final /* synthetic */ boolean j = (!k.class.desiredAssertionStatus());
    private static final i<Bitmap> k = new i<Bitmap>() {
        {
            a(new NullPointerException("uri"));
        }
    };
    o a;
    j b;
    ArrayList<j> c;
    z d;
    int e;
    int f;
    a g = a.ANIMATE;
    boolean h;
    ArrayList<g> i;

    public /* synthetic */ com.b.b.b.b b(j jVar) {
        return a(jVar);
    }

    public /* synthetic */ com.b.b.b.b f() {
        return d();
    }

    void a() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = a.ANIMATE;
        this.a = null;
        this.h = false;
        this.i = null;
    }

    public k(j jVar) {
        this.b = jVar;
    }

    static void a(ImageView imageView, Animation animation, int i) {
        if (imageView != null) {
            if (animation == null && i != 0) {
                animation = AnimationUtils.loadAnimation(imageView.getContext(), i);
            }
            if (animation == null) {
                imageView.setAnimation(null);
            } else {
                imageView.startAnimation(animation);
            }
        }
    }

    protected o b() {
        return this.a;
    }

    public k a(j jVar) {
        if (jVar != null) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            this.c.add(jVar);
        }
        return this;
    }

    private String g() {
        return a(this.a, this.e, this.f, this.g != a.NO_ANIMATE, this.h);
    }

    public static String a(o oVar, int i, int i2, boolean z, boolean z2) {
        String str = oVar.e + "resize=" + i + "," + i2;
        if (!z) {
            str = str + ":noAnimate";
        }
        if (z2) {
            str = str + ":deepZoom";
        }
        return c.a(str);
    }

    public void c() {
        if (this.f > 0 || this.e > 0) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            this.c.add(0, new e(this.e, this.f, this.d));
        } else if (this.d != null) {
            throw new IllegalStateException("Must call resize when using " + this.d);
        }
    }

    public String a(String str) {
        return a(str, this.c);
    }

    public static String a(String str, List<j> list) {
        if (!j && str == null) {
            throw new AssertionError();
        } else if (list == null || list.size() <= 0) {
            return str;
        } else {
            for (j a : list) {
                str = str + a.a();
            }
            return c.a(str);
        }
    }

    c a(int i, int i2) {
        String g = g();
        String a = a(g);
        c cVar = new c();
        cVar.b = a;
        cVar.a = g;
        cVar.d = e();
        cVar.g = i;
        cVar.h = i2;
        cVar.f = this.a;
        cVar.e = this.c;
        cVar.i = this.g != a.NO_ANIMATE;
        cVar.j = this.h;
        cVar.k = this.i;
        if (!this.a.h) {
            com.b.b.a.b a2 = this.a.a.z.a(a);
            if (a2 != null) {
                cVar.c = a2;
                return cVar;
            }
        }
        return cVar;
    }

    private void b(String str) {
        if (e()) {
            throw new IllegalStateException("Can't apply " + str + " after transform has been called." + str + " is applied to the original resized bitmap.");
        }
    }

    public k d() {
        b("fitCenter");
        this.d = z.FitCenter;
        return this;
    }

    boolean e() {
        return this.c != null && this.c.size() > 0;
    }
}
