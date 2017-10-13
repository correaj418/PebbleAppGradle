package com.b.b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.ImageView;
import com.b.a.b.f;
import com.b.a.f.c;
import java.lang.ref.WeakReference;

class l extends LayerDrawable {
    private static final double a = Math.log(2.0d);
    private f<com.b.b.a.b> A = new f<com.b.b.a.b>(this) {
        final /* synthetic */ l a;

        {
            this.a = r1;
        }

        public void a(Exception exception, com.b.b.a.b bVar) {
            this.a.invalidateSelf();
        }
    };
    private Paint b;
    private int c = 255;
    private com.b.b.a.b d;
    private int e;
    private Drawable f;
    private int g;
    private Drawable h;
    private Resources i;
    private y j;
    private boolean k;
    private int l;
    private int m;
    private boolean n;
    private j o;
    private c p;
    private a q;
    private f<l> r;
    private b s;
    private Drawable t;
    private int u;
    private int v;
    private b w;
    private final Drawable x;
    private final Drawable y;
    private final Drawable z;

    static class a implements f<com.b.b.a.b> {
        static final /* synthetic */ boolean a = (!l.class.desiredAssertionStatus());
        private WeakReference<l> b;
        private String c;
        private j d;

        public a(l lVar) {
            this.b = new WeakReference(lVar);
        }

        public void a(j jVar, String str) {
            Object obj = this.c;
            j jVar2 = this.d;
            if (!TextUtils.equals(obj, str) || this.d != jVar) {
                this.d = jVar;
                this.c = str;
                if (jVar != null) {
                    jVar.x.b(str, this);
                }
                b(jVar2, obj);
            }
        }

        private void b(j jVar, String str) {
            if (str != null) {
                if (jVar.x.c(str, this)) {
                    Object a;
                    Object a2 = jVar.x.a(str);
                    if (a2 instanceof aa) {
                        aa aaVar = (aa) a2;
                        jVar.x.b(aaVar.a);
                        if (jVar.x.c(aaVar.f, aaVar)) {
                            a = jVar.x.a(aaVar.f);
                            if (a instanceof f) {
                                jVar.x.b(((f) a).a);
                            }
                        }
                    }
                    a = a2;
                    if (a instanceof f) {
                        jVar.x.b(((f) a).a);
                    }
                }
                jVar.b();
            }
        }

        public void a(Exception exception, com.b.b.a.b bVar) {
            if (!a && Thread.currentThread() != Looper.getMainLooper().getThread()) {
                throw new AssertionError();
            } else if (a || bVar != null) {
                l lVar = (l) this.b.get();
                if (lVar != null) {
                    lVar.a(bVar, bVar.e).e();
                    f a = lVar.r;
                    if (a != null) {
                        a.a(exception, lVar);
                    }
                }
            } else {
                throw new AssertionError();
            }
        }
    }

    class b {
        com.b.b.f.a a;
        Exception b;
        com.b.b.f.b c;
        long d;
        Runnable e = new Runnable(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void run() {
                try {
                    this.a.a.g();
                } catch (Throwable e) {
                    this.a.b = new Exception(e);
                } catch (Exception e2) {
                    this.a.b = e2;
                }
                j.a.post(this.a.f);
            }
        };
        Runnable f = new Runnable(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.g = false;
                this.a.h.invalidateSelf();
            }
        };
        boolean g;
        final /* synthetic */ l h;

        public b(l lVar, com.b.b.a.b bVar) {
            this.h = lVar;
            this.a = bVar.h.a();
            this.c = this.a.e();
        }

        long a() {
            if (this.c == null) {
                return 100;
            }
            long j = (long) this.c.b;
            if (j != 0) {
                return j;
            }
            return 100;
        }

        public com.b.b.f.b b() {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.d == 0) {
                this.d = a() + currentTimeMillis;
                c();
            }
            if (currentTimeMillis >= this.d) {
                if (this.a.e() != this.c) {
                    this.c = this.a.e();
                    if (currentTimeMillis > this.d + a()) {
                        this.d = currentTimeMillis + a();
                    } else {
                        this.d += a();
                    }
                }
                c();
            }
            return this.c;
        }

        public synchronized void c() {
            if (!this.g) {
                if (this.b == null) {
                    if (this.a.h() == -1 && this.h.n) {
                        this.a.f();
                    }
                    this.g = true;
                    j.a().execute(this.e);
                }
            }
        }
    }

    public f<l> a() {
        return this.r;
    }

    public l a(f<l> fVar) {
        this.r = fVar;
        return this;
    }

    public l a(j jVar) {
        if (jVar == null) {
            throw new AssertionError("null ion");
        }
        this.o = jVar;
        return this;
    }

    public Drawable b() {
        if (this.d == null && this.e != 0) {
            return this.i.getDrawable(this.e);
        }
        if (this.d != null) {
            if (this.d.f != null) {
                return new BitmapDrawable(this.i, this.d.f);
            }
            if (this.d.h != null) {
                com.b.b.f.b e = this.d.h.e();
                if (e != null) {
                    return new BitmapDrawable(this.i, e.a);
                }
                if (this.e != 0) {
                    return this.i.getDrawable(this.e);
                }
                return null;
            }
        }
        if (this.g != 0) {
            return this.i.getDrawable(this.g);
        }
        return null;
    }

    public com.b.b.a.b c() {
        return this.d;
    }

    public l a(boolean z) {
        this.k = z;
        return this;
    }

    public l a(c cVar) {
        this.p = cVar;
        if (this.o != null) {
            return this;
        }
        throw new AssertionError("null ion");
    }

    public l a(b bVar) {
        this.w = bVar;
        return this;
    }

    public void d() {
        this.q.a(null, null);
        this.p = null;
    }

    public l(Resources resources) {
        super(new Drawable[]{new BitmapDrawable((Bitmap) null), new BitmapDrawable((Bitmap) null), new BitmapDrawable((Bitmap) null)});
        setId(0, 0);
        setId(1, 1);
        setId(2, 2);
        this.x = getDrawable(0);
        this.y = getDrawable(1);
        this.z = getDrawable(2);
        this.i = resources;
        this.b = new Paint(6);
        this.q = new a(this);
    }

    public l e() {
        h();
        if (this.f == null) {
            setDrawableByLayerId(0, this.x);
        } else {
            setDrawableByLayerId(0, this.f);
        }
        if (this.d == null) {
            setDrawableByLayerId(1, this.y);
            setDrawableByLayerId(2, this.z);
        } else if (this.d.f == null && this.d.i == null && this.d.h == null) {
            setDrawableByLayerId(1, this.y);
            f();
            if (this.h == null) {
                setDrawableByLayerId(2, this.z);
            } else {
                setDrawableByLayerId(2, this.h);
            }
        } else {
            if (this.d.i == null && this.d.h == null) {
                g();
                setDrawableByLayerId(1, this.t);
            } else {
                setDrawableByLayerId(1, this.y);
            }
            setDrawableByLayerId(2, this.z);
        }
        return this;
    }

    public l a(com.b.b.a.b bVar, y yVar) {
        if (this.d != bVar) {
            d();
            this.j = yVar;
            this.d = bVar;
            this.s = null;
            this.t = null;
            invalidateSelf();
            if (bVar != null) {
                if (bVar.i != null) {
                    this.v = (int) Math.ceil(Math.log(Math.max(((double) bVar.a.x) / 256.0d, ((double) bVar.a.y) / 256.0d)) / a);
                    this.u = 256 << this.v;
                } else if (bVar.h != null) {
                    this.s = new b(this, bVar);
                }
            }
        }
        return this;
    }

    public l b(boolean z) {
        this.n = z;
        return this;
    }

    public l a(int i, int i2) {
        if (!(this.l == i && this.m == i2)) {
            this.l = i;
            this.m = i2;
            invalidateSelf();
        }
        return this;
    }

    public l a(int i, Drawable drawable) {
        if ((drawable == null || drawable != this.h) && (i == 0 || i != this.g)) {
            this.g = i;
            this.h = drawable;
        }
        return this;
    }

    public l b(int i, Drawable drawable) {
        if ((drawable == null || drawable != this.f) && (i == 0 || i != this.e)) {
            this.e = i;
            this.f = drawable;
        }
        return this;
    }

    private Drawable f() {
        if (this.h != null) {
            return this.h;
        }
        if (this.g == 0) {
            return null;
        }
        this.h = this.i.getDrawable(this.g);
        return this.h;
    }

    private Drawable g() {
        if (this.t != null) {
            return this.t;
        }
        if (this.d == null || this.d.h != null || this.d.i != null || this.d.f == null) {
            return null;
        }
        this.t = this.w.a(this.i, this.d.f);
        return this.t;
    }

    private Drawable h() {
        if (this.f != null) {
            return this.f;
        }
        if (this.e == 0) {
            return null;
        }
        this.f = this.i.getDrawable(this.e);
        return this.f;
    }

    public int getIntrinsicWidth() {
        if (this.d != null) {
            if (this.d.i != null) {
                return this.d.a.x;
            }
            if (this.d.f != null) {
                return this.d.f.getScaledWidth(this.i.getDisplayMetrics().densityDpi);
            }
        }
        if (this.s != null) {
            return this.s.a.b();
        }
        if (this.l > 0) {
            return this.l;
        }
        Drawable f;
        if (this.d != null) {
            f = f();
            if (f != null) {
                return f.getIntrinsicWidth();
            }
        }
        f = h();
        if (f != null) {
            return f.getIntrinsicWidth();
        }
        return -1;
    }

    public int getIntrinsicHeight() {
        if (this.d != null) {
            if (this.d.i != null) {
                return this.d.a.y;
            }
            if (this.d.f != null) {
                return this.d.f.getScaledHeight(this.i.getDisplayMetrics().densityDpi);
            }
        }
        if (this.s != null) {
            return this.s.a.c();
        }
        if (this.m > 0) {
            return this.m;
        }
        Drawable f;
        if (this.d != null) {
            f = f();
            if (f != null) {
                return f.getIntrinsicHeight();
            }
        }
        f = h();
        if (f != null) {
            return f.getIntrinsicHeight();
        }
        return -1;
    }

    public void draw(Canvas canvas) {
        if (this.d == null) {
            super.draw(canvas);
            if (this.p != null) {
                if (this.p.g == 0 && this.p.h == 0) {
                    if (canvas.getWidth() != 1) {
                        this.p.g = canvas.getWidth();
                    }
                    if (canvas.getHeight() != 1) {
                        this.p.h = canvas.getHeight();
                    }
                    this.p.a();
                    com.b.b.a.b a = this.o.z.a(this.p.b);
                    if (a != null) {
                        this.p = null;
                        this.q.a(null, a);
                        return;
                    }
                }
                this.q.a(this.o, this.p.b);
                if (c.a(this.o)) {
                    this.p.b();
                } else {
                    this.p.c();
                }
                this.p = null;
            }
        } else if (this.d.i != null) {
            a(canvas);
        } else {
            if (this.d.c == 0) {
                this.d.c = SystemClock.uptimeMillis();
            }
            long j = (long) this.c;
            if (this.k) {
                j = Math.min(((SystemClock.uptimeMillis() - this.d.c) << 8) / 200, (long) this.c);
            }
            if (j == ((long) this.c)) {
                if (this.f != null) {
                    this.f = null;
                    setDrawableByLayerId(0, this.x);
                }
            } else if (this.f != null) {
                invalidateSelf();
            }
            if (this.d.h != null) {
                super.draw(canvas);
                com.b.b.f.b b = this.s.b();
                if (b != null) {
                    this.b.setAlpha((int) j);
                    canvas.drawBitmap(b.a, null, getBounds(), this.b);
                    this.b.setAlpha(this.c);
                    invalidateSelf();
                    return;
                }
                return;
            }
            if (this.d.f != null) {
                if (this.t != null) {
                    this.t.setAlpha((int) j);
                }
            } else if (this.h != null) {
                this.h.setAlpha((int) j);
            }
            super.draw(canvas);
        }
    }

    private void a(Canvas canvas) {
        Rect clipBounds = canvas.getClipBounds();
        Rect bounds = getBounds();
        float width = ((float) canvas.getWidth()) / ((float) clipBounds.width());
        double max = Math.max(Math.log((double) ((((float) bounds.width()) * width) / 256.0f)) / a, Math.log((double) ((width * ((float) bounds.height())) / 256.0f)) / a);
        int max2 = Math.max(0, clipBounds.left);
        int min = Math.min(bounds.width(), clipBounds.right);
        int max3 = Math.max(0, clipBounds.top);
        int min2 = Math.min(bounds.height(), clipBounds.bottom);
        int max4 = Math.max(Math.min(this.v, (int) Math.floor(max)), 0);
        int i = 1 << max4;
        int i2 = this.u / i;
        if (this.d.f != null) {
            canvas.drawBitmap(this.d.f, null, getBounds(), this.b);
        } else {
            this.b.setColor(-16777216);
            canvas.drawRect(getBounds(), this.b);
        }
        int i3 = 1;
        while (i2 / i3 > 256) {
            i3 <<= 1;
        }
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i2 * i4;
            int min3 = Math.min((i4 + 1) * i2, bounds.bottom);
            if (min3 >= max3) {
                if (i5 <= min2) {
                    for (int i6 = 0; i6 < i; i6++) {
                        int i7 = i2 * i6;
                        int min4 = Math.min((i6 + 1) * i2, bounds.right);
                        if (min4 >= max2) {
                            if (i7 > min) {
                                break;
                            }
                            Rect rect = new Rect(i7, i5, min4, min3);
                            String a = c.a(this.d.d, ",", Integer.valueOf(max4), ",", Integer.valueOf(i6), ",", Integer.valueOf(i4));
                            com.b.b.a.b a2 = this.o.z.a(a);
                            if (a2 == null || a2.f == null) {
                                com.b.b.a.b bVar;
                                if (this.o.x.a(a) == null) {
                                    s sVar = new s(this.o, a, this.d.i, rect, i3);
                                }
                                this.o.x.b(a, this.A);
                                i7 = 0;
                                min4 = 0;
                                int i8 = max4 - 1;
                                if (i6 % 2 == 1) {
                                    i7 = 1;
                                }
                                if (i4 % 2 == 1) {
                                    min4 = 1;
                                }
                                com.b.b.a.b bVar2 = a2;
                                int i9 = 1;
                                int i10 = i8;
                                i8 = i6 >> 1;
                                int i11 = i4 >> 1;
                                while (i10 >= 0) {
                                    bVar2 = this.o.z.a(c.a(this.d.d, ",", Integer.valueOf(i10), ",", Integer.valueOf(i8), ",", Integer.valueOf(i11)));
                                    if (bVar2 != null && bVar2.f != null) {
                                        bVar = bVar2;
                                        break;
                                    }
                                    if (i8 % 2 == 1) {
                                        i7 += 1 << i9;
                                    }
                                    if (i11 % 2 == 1) {
                                        min4 += 1 << i9;
                                    }
                                    i10--;
                                    i9++;
                                    i8 >>= 1;
                                    i11 >>= 1;
                                }
                                bVar = bVar2;
                                if (!(bVar == null || bVar.f == null)) {
                                    i8 = this.u / (1 << i10);
                                    int i12 = 1;
                                    while (i8 / i12 > 256) {
                                        i12 <<= 1;
                                    }
                                    i12 = (i8 / i12) >> i9;
                                    i7 *= i12;
                                    min4 *= i12;
                                    Rect rect2 = new Rect(i7, min4, i7 + i12, i12 + min4);
                                    canvas.drawBitmap(bVar.f, rect2, rect, this.b);
                                }
                            } else {
                                canvas.drawBitmap(a2.f, null, rect, this.b);
                            }
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.c = i;
        this.b.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
        this.b.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        if (this.d == null || this.d.f == null || this.d.f.hasAlpha() || this.b.getAlpha() < 255) {
            return -3;
        }
        return super.getOpacity();
    }

    static l a(ImageView imageView) {
        l lVar;
        Drawable drawable = imageView.getDrawable();
        if (drawable == null || !(drawable instanceof l)) {
            lVar = new l(imageView.getResources());
        } else {
            lVar = (l) drawable;
        }
        imageView.setImageDrawable(null);
        return lVar;
    }
}
