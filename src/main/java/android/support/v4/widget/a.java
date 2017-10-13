package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.ah;
import android.support.v4.view.t;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class a implements OnTouchListener {
    private static final int r = ViewConfiguration.getTapTimeout();
    private final a a = new a();
    private final Interpolator b = new AccelerateInterpolator();
    private final View c;
    private Runnable d;
    private float[] e = new float[]{0.0f, 0.0f};
    private float[] f = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int g;
    private int h;
    private float[] i = new float[]{0.0f, 0.0f};
    private float[] j = new float[]{0.0f, 0.0f};
    private float[] k = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;

    private static class a {
        private int a;
        private int b;
        private float c;
        private float d;
        private long e = Long.MIN_VALUE;
        private long f = 0;
        private int g = 0;
        private int h = 0;
        private long i = -1;
        private float j;
        private int k;

        public void a(int i) {
            this.a = i;
        }

        public void b(int i) {
            this.b = i;
        }

        public void a() {
            this.e = AnimationUtils.currentAnimationTimeMillis();
            this.i = -1;
            this.f = this.e;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }

        public void b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.b((int) (currentAnimationTimeMillis - this.e), 0, this.b);
            this.j = a(currentAnimationTimeMillis);
            this.i = currentAnimationTimeMillis;
        }

        public boolean c() {
            return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
        }

        private float a(long j) {
            if (j < this.e) {
                return 0.0f;
            }
            if (this.i < 0 || j < this.i) {
                return a.b(((float) (j - this.e)) / ((float) this.a), 0.0f, 1.0f) * 0.5f;
            }
            long j2 = j - this.i;
            return (a.b(((float) j2) / ((float) this.k), 0.0f, 1.0f) * this.j) + (1.0f - this.j);
        }

        private float a(float f) {
            return ((-4.0f * f) * f) + (4.0f * f);
        }

        public void d() {
            if (this.f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a = a(a(currentAnimationTimeMillis));
            long j = currentAnimationTimeMillis - this.f;
            this.f = currentAnimationTimeMillis;
            this.g = (int) ((((float) j) * a) * this.c);
            this.h = (int) ((((float) j) * a) * this.d);
        }

        public void a(float f, float f2) {
            this.c = f;
            this.d = f2;
        }

        public int e() {
            return (int) (this.c / Math.abs(this.c));
        }

        public int f() {
            return (int) (this.d / Math.abs(this.d));
        }

        public int g() {
            return this.g;
        }

        public int h() {
            return this.h;
        }
    }

    private class b implements Runnable {
        final /* synthetic */ a a;

        private b(a aVar) {
            this.a = aVar;
        }

        public void run() {
            if (this.a.o) {
                if (this.a.m) {
                    this.a.m = false;
                    this.a.a.a();
                }
                a c = this.a.a;
                if (c.c() || !this.a.a()) {
                    this.a.o = false;
                    return;
                }
                if (this.a.n) {
                    this.a.n = false;
                    this.a.d();
                }
                c.d();
                this.a.a(c.g(), c.h());
                ah.a(this.a.c, (Runnable) this);
            }
        }
    }

    public abstract void a(int i, int i2);

    public abstract boolean e(int i);

    public abstract boolean f(int i);

    public a(View view) {
        this.c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        a((float) i, (float) i);
        b((float) i2, (float) i2);
        a(1);
        e(Float.MAX_VALUE, Float.MAX_VALUE);
        d(0.2f, 0.2f);
        c(1.0f, 1.0f);
        b(r);
        c(500);
        d(500);
    }

    public a a(boolean z) {
        if (this.p && !z) {
            c();
        }
        this.p = z;
        return this;
    }

    public a a(float f, float f2) {
        this.k[0] = f / 1000.0f;
        this.k[1] = f2 / 1000.0f;
        return this;
    }

    public a b(float f, float f2) {
        this.j[0] = f / 1000.0f;
        this.j[1] = f2 / 1000.0f;
        return this;
    }

    public a c(float f, float f2) {
        this.i[0] = f / 1000.0f;
        this.i[1] = f2 / 1000.0f;
        return this;
    }

    public a a(int i) {
        this.g = i;
        return this;
    }

    public a d(float f, float f2) {
        this.e[0] = f;
        this.e[1] = f2;
        return this;
    }

    public a e(float f, float f2) {
        this.f[0] = f;
        this.f[1] = f2;
        return this;
    }

    public a b(int i) {
        this.h = i;
        return this;
    }

    public a c(int i) {
        this.a.a(i);
        return this;
    }

    public a d(int i) {
        this.a.b(i);
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.p) {
            return false;
        }
        switch (t.a(motionEvent)) {
            case 0:
                this.n = true;
                this.l = false;
                break;
            case 1:
            case 3:
                c();
                break;
            case 2:
                break;
        }
        this.a.a(a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.c.getWidth()), a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.c.getHeight()));
        if (!this.o && a()) {
            b();
        }
        if (!(this.q && this.o)) {
            z = false;
        }
        return z;
    }

    private boolean a() {
        a aVar = this.a;
        int f = aVar.f();
        int e = aVar.e();
        return (f != 0 && f(f)) || (e != 0 && e(e));
    }

    private void b() {
        if (this.d == null) {
            this.d = new b();
        }
        this.o = true;
        this.m = true;
        if (this.l || this.h <= 0) {
            this.d.run();
        } else {
            ah.a(this.c, this.d, (long) this.h);
        }
        this.l = true;
    }

    private void c() {
        if (this.m) {
            this.o = false;
        } else {
            this.a.b();
        }
    }

    private float a(int i, float f, float f2, float f3) {
        float a = a(this.e[i], f2, this.f[i], f);
        if (a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.i[i];
        float f5 = this.j[i];
        float f6 = this.k[i];
        f4 *= f3;
        if (a > 0.0f) {
            return b(a * f4, f5, f6);
        }
        return -b((-a) * f4, f5, f6);
    }

    private float a(float f, float f2, float f3, float f4) {
        float f5;
        float b = b(f * f2, 0.0f, f3);
        b = f(f2 - f4, b) - f(f4, b);
        if (b < 0.0f) {
            f5 = -this.b.getInterpolation(-b);
        } else if (b <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.b.getInterpolation(b);
        }
        return b(f5, -1.0f, 1.0f);
    }

    private float f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.g) {
            case 0:
            case 1:
                if (f >= f2) {
                    return 0.0f;
                }
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.o && this.g == 1) {
                    return 1.0f;
                }
                return 0.0f;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    private static int b(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        if (i < i2) {
            return i2;
        }
        return i;
    }

    private static float b(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }

    private void d() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.c.onTouchEvent(obtain);
        obtain.recycle();
    }
}
