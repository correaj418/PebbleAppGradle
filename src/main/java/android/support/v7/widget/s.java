package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class s implements t {
    final RectF a = new RectF();

    s() {
    }

    public void a() {
        ao.c = new a(this) {
            final /* synthetic */ s a;

            {
                this.a = r1;
            }

            public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
                float f2 = 2.0f * f;
                float width = (rectF.width() - f2) - 1.0f;
                float height = (rectF.height() - f2) - 1.0f;
                if (f >= 1.0f) {
                    float f3 = f + 0.5f;
                    this.a.a.set(-f3, -f3, f3, f3);
                    int save = canvas.save();
                    canvas.translate(rectF.left + f3, rectF.top + f3);
                    canvas.drawArc(this.a.a, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(this.a.a, 180.0f, 90.0f, true, paint);
                    canvas.translate(height, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(this.a.a, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(this.a.a, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(save);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, 1.0f + (rectF.right - f3), rectF.top + f3, paint);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.bottom - f3, 1.0f + (rectF.right - f3), rectF.bottom, paint);
                }
                canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
            }
        };
    }

    public void a(r rVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        Drawable a = a(context, colorStateList, f, f2, f3);
        a.a(rVar.b());
        rVar.a(a);
        f(rVar);
    }

    private ao a(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new ao(context.getResources(), colorStateList, f, f2, f3);
    }

    public void f(r rVar) {
        Rect rect = new Rect();
        j(rVar).a(rect);
        rVar.a((int) Math.ceil((double) b(rVar)), (int) Math.ceil((double) c(rVar)));
        rVar.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void g(r rVar) {
    }

    public void h(r rVar) {
        j(rVar).a(rVar.b());
        f(rVar);
    }

    public void a(r rVar, ColorStateList colorStateList) {
        j(rVar).a(colorStateList);
    }

    public ColorStateList i(r rVar) {
        return j(rVar).f();
    }

    public void a(r rVar, float f) {
        j(rVar).a(f);
        f(rVar);
    }

    public float d(r rVar) {
        return j(rVar).a();
    }

    public void c(r rVar, float f) {
        j(rVar).b(f);
    }

    public float e(r rVar) {
        return j(rVar).b();
    }

    public void b(r rVar, float f) {
        j(rVar).c(f);
        f(rVar);
    }

    public float a(r rVar) {
        return j(rVar).c();
    }

    public float b(r rVar) {
        return j(rVar).d();
    }

    public float c(r rVar) {
        return j(rVar).e();
    }

    private ao j(r rVar) {
        return (ao) rVar.c();
    }
}
