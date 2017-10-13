package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v7.c.a.b;

class ao extends Drawable {
    static final double a = Math.cos(Math.toRadians(45.0d));
    static a c;
    final int b;
    Paint d;
    Paint e;
    Paint f;
    final RectF g;
    float h;
    Path i;
    float j;
    float k;
    float l;
    float m;
    private ColorStateList n;
    private boolean o = true;
    private final int p;
    private final int q;
    private boolean r = true;
    private boolean s = false;

    interface a {
        void a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    ao(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.p = resources.getColor(android.support.v7.c.a.a.cardview_shadow_start_color);
        this.q = resources.getColor(android.support.v7.c.a.a.cardview_shadow_end_color);
        this.b = resources.getDimensionPixelSize(b.cardview_compat_inset_shadow);
        this.d = new Paint(5);
        b(colorStateList);
        this.e = new Paint(5);
        this.e.setStyle(Style.FILL);
        this.h = (float) ((int) (0.5f + f));
        this.g = new RectF();
        this.f = new Paint(this.e);
        this.f.setAntiAlias(false);
        a(f2, f3);
    }

    private void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.n = colorStateList;
        this.d.setColor(this.n.getColorForState(getState(), this.n.getDefaultColor()));
    }

    private int d(float f) {
        int i = (int) (0.5f + f);
        if (i % 2 == 1) {
            return i - 1;
        }
        return i;
    }

    public void a(boolean z) {
        this.r = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        this.d.setAlpha(i);
        this.e.setAlpha(i);
        this.f.setAlpha(i);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.o = true;
    }

    void a(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        } else {
            float d = (float) d(f);
            float d2 = (float) d(f2);
            if (d > d2) {
                if (!this.s) {
                    this.s = true;
                }
                d = d2;
            }
            if (this.m != d || this.k != d2) {
                this.m = d;
                this.k = d2;
                this.l = (float) ((int) (((d * 1.5f) + ((float) this.b)) + 0.5f));
                this.j = ((float) this.b) + d2;
                this.o = true;
                invalidateSelf();
            }
        }
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) a(this.k, this.h, this.r));
        int ceil2 = (int) Math.ceil((double) b(this.k, this.h, this.r));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    static float a(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f)) + ((1.0d - a) * ((double) f2)));
        }
        return 1.5f * f;
    }

    static float b(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - a) * ((double) f2)));
        }
        return f;
    }

    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.n.getColorForState(iArr, this.n.getDefaultColor());
        if (this.d.getColor() == colorForState) {
            return false;
        }
        this.d.setColor(colorForState);
        this.o = true;
        invalidateSelf();
        return true;
    }

    public boolean isStateful() {
        return (this.n != null && this.n.isStateful()) || super.isStateful();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -3;
    }

    void a(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
        }
        float f2 = (float) ((int) (0.5f + f));
        if (this.h != f2) {
            this.h = f2;
            this.o = true;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.o) {
            b(getBounds());
            this.o = false;
        }
        canvas.translate(0.0f, this.m / 2.0f);
        a(canvas);
        canvas.translate(0.0f, (-this.m) / 2.0f);
        c.a(canvas, this.g, this.h, this.d);
    }

    private void a(Canvas canvas) {
        Object obj;
        float f = (-this.h) - this.l;
        float f2 = (this.h + ((float) this.b)) + (this.m / 2.0f);
        Object obj2 = this.g.width() - (2.0f * f2) > 0.0f ? 1 : null;
        if (this.g.height() - (2.0f * f2) > 0.0f) {
            obj = 1;
        } else {
            obj = null;
        }
        int save = canvas.save();
        canvas.translate(this.g.left + f2, this.g.top + f2);
        canvas.drawPath(this.i, this.e);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.g.width() - (2.0f * f2), -this.h, this.f);
        }
        canvas.restoreToCount(save);
        save = canvas.save();
        canvas.translate(this.g.right - f2, this.g.bottom - f2);
        canvas.rotate(180.0f);
        canvas.drawPath(this.i, this.e);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.g.width() - (2.0f * f2), this.l + (-this.h), this.f);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.g.left + f2, this.g.bottom - f2);
        canvas.rotate(270.0f);
        canvas.drawPath(this.i, this.e);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.g.height() - (2.0f * f2), -this.h, this.f);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.g.right - f2, this.g.top + f2);
        canvas.rotate(90.0f);
        canvas.drawPath(this.i, this.e);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.g.height() - (2.0f * f2), -this.h, this.f);
        }
        canvas.restoreToCount(save2);
    }

    private void g() {
        RectF rectF = new RectF(-this.h, -this.h, this.h, this.h);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.l, -this.l);
        if (this.i == null) {
            this.i = new Path();
        } else {
            this.i.reset();
        }
        this.i.setFillType(FillType.EVEN_ODD);
        this.i.moveTo(-this.h, 0.0f);
        this.i.rLineTo(-this.l, 0.0f);
        this.i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.i.arcTo(rectF, 270.0f, -90.0f, false);
        this.i.close();
        float f = this.h / (this.h + this.l);
        float[] fArr = new float[]{0.0f, f, 1.0f};
        f = 0.0f;
        this.e.setShader(new RadialGradient(0.0f, f, this.h + this.l, new int[]{this.p, this.p, this.q}, fArr, TileMode.CLAMP));
        float f2 = 0.0f;
        this.f.setShader(new LinearGradient(0.0f, (-this.h) + this.l, f2, (-this.h) - this.l, new int[]{this.p, this.p, this.q}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        this.f.setAntiAlias(false);
    }

    private void b(Rect rect) {
        float f = this.k * 1.5f;
        this.g.set(((float) rect.left) + this.k, ((float) rect.top) + f, ((float) rect.right) - this.k, ((float) rect.bottom) - f);
        g();
    }

    float a() {
        return this.h;
    }

    void a(Rect rect) {
        getPadding(rect);
    }

    void b(float f) {
        a(f, this.k);
    }

    void c(float f) {
        a(this.m, f);
    }

    float b() {
        return this.m;
    }

    float c() {
        return this.k;
    }

    float d() {
        return (Math.max(this.k, (this.h + ((float) this.b)) + (this.k / 2.0f)) * 2.0f) + ((this.k + ((float) this.b)) * 2.0f);
    }

    float e() {
        return (Math.max(this.k, (this.h + ((float) this.b)) + ((this.k * 1.5f) / 2.0f)) * 2.0f) + (((this.k * 1.5f) + ((float) this.b)) * 2.0f);
    }

    void a(ColorStateList colorStateList) {
        b(colorStateList);
        invalidateSelf();
    }

    ColorStateList f() {
        return this.n;
    }
}
