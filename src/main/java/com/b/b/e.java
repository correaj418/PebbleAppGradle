package com.b.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.b.b.a.j;

class e implements j {
    static final Paint d = new Paint(2);
    final z a;
    final int b;
    final int c;

    public e(int i, int i2, z zVar) {
        this.b = i;
        this.c = i2;
        if (zVar == null) {
            this.a = z.FitXY;
        } else {
            this.a = zVar;
        }
    }

    public Bitmap a(Bitmap bitmap) {
        Config config = bitmap.getConfig();
        if (config == null) {
            config = Config.ARGB_8888;
        }
        int i = this.b;
        int i2 = this.c;
        if (i <= 0) {
            i = (int) ((((float) bitmap.getWidth()) / ((float) bitmap.getHeight())) * ((float) i2));
        } else if (i2 <= 0) {
            i2 = (int) ((((float) bitmap.getHeight()) / ((float) bitmap.getWidth())) * ((float) i));
        }
        RectF rectF = new RectF(0.0f, 0.0f, (float) i, (float) i2);
        z zVar = this.a;
        if (zVar == z.CenterInside && (i <= bitmap.getWidth() || i2 <= bitmap.getHeight())) {
            zVar = z.FitCenter;
        }
        float width;
        float height;
        if (zVar == z.CenterInside) {
            width = ((float) (i - bitmap.getWidth())) / 2.0f;
            height = ((float) (i2 - bitmap.getHeight())) / 2.0f;
            rectF.set(width, height, ((float) bitmap.getWidth()) + width, ((float) bitmap.getHeight()) + height);
        } else if (zVar != z.FitXY) {
            height = ((float) i) / ((float) bitmap.getWidth());
            float height2 = ((float) i2) / ((float) bitmap.getHeight());
            if (zVar == z.CenterCrop) {
                width = Math.max(height, height2);
            } else {
                width = Math.min(height, height2);
            }
            if (width == 0.0f) {
                return bitmap;
            }
            height = ((float) bitmap.getWidth()) * width;
            height = (((float) i) - height) / 2.0f;
            width = (((float) i2) - (width * ((float) bitmap.getHeight()))) / 2.0f;
            rectF.set(height, width, ((float) i) - height, ((float) i2) - width);
        }
        if (rectF.width() == ((float) bitmap.getWidth()) && rectF.height() == ((float) bitmap.getHeight()) && rectF.top == 0.0f && rectF.left == 0.0f) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        new Canvas(createBitmap).drawBitmap(bitmap, null, rectF, d);
        return createBitmap;
    }

    public String a() {
        return this.a.name() + this.b + "x" + this.c;
    }
}
