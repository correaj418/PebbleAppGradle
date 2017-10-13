package com.getpebble.android.main.sections.mypebble.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.getpebble.android.basalt.R;

public class a extends Drawable {
    final Paint a = new Paint(1);
    final Path b = new Path();
    RectF c = null;
    private final float d;

    public a(float f, int i) {
        this.d = f;
        this.a.setStyle(Style.FILL);
        this.a.setColor(i);
        this.a.setStrokeWidth(0.0f);
    }

    public void draw(Canvas canvas) {
        if (this.c == null) {
            this.c = new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
        }
        this.b.reset();
        this.b.addRoundRect(this.c, this.d, this.d, Direction.CW);
        this.b.setFillType(FillType.INVERSE_EVEN_ODD);
        canvas.drawPath(this.b, this.a);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.c = new RectF(rect);
    }

    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -2;
    }

    public static a a(Context context) {
        return new a((float) context.getResources().getDimensionPixelOffset(R.dimen.health_card_radius), context.getResources().getColor(R.color.my_pebble_background_gray));
    }
}
