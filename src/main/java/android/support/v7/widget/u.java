package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

class u extends s {
    u() {
    }

    public void a() {
        ao.c = new a(this) {
            final /* synthetic */ u a;

            {
                this.a = r1;
            }

            public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
                canvas.drawRoundRect(rectF, f, f, paint);
            }
        };
    }
}
