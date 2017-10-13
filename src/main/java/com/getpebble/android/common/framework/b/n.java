package com.getpebble.android.common.framework.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class n {

    public interface b {
        void a(Canvas canvas, Paint paint, Bitmap bitmap);
    }

    public static class a implements b {
        public void a(Canvas canvas, Paint paint, Bitmap bitmap) {
            int width = bitmap.getWidth() / 2;
            int height = bitmap.getHeight() / 2;
            canvas.drawCircle((float) width, (float) height, (float) Math.min(width, height), paint);
        }

        public boolean equals(Object obj) {
            return obj instanceof a;
        }
    }

    public static class c implements b {
        private final int a;

        public c(int i) {
            this.a = i;
        }

        public void a(Canvas canvas, Paint paint, Bitmap bitmap) {
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight()), (float) this.a, (float) this.a, paint);
        }

        public boolean equals(Object obj) {
            if ((obj instanceof c) && ((c) obj).a == this.a) {
                return true;
            }
            return false;
        }
    }

    public static class d implements b {
        public void a(Canvas canvas, Paint paint, Bitmap bitmap) {
            canvas.drawRect(new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight()), paint);
        }

        public boolean equals(Object obj) {
            return obj instanceof d;
        }
    }

    public static Bitmap a(Bitmap bitmap, b bVar) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP));
        bVar.a(canvas, paint, createBitmap);
        return createBitmap;
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static final b a(com.getpebble.android.common.framework.install.app.b.b bVar, boolean z, int i) {
        if (bVar == com.getpebble.android.common.framework.install.app.b.b.CIRCLE && z) {
            return new a();
        }
        if (bVar == com.getpebble.android.common.framework.install.app.b.b.ROUND_RECT) {
            return new c(i);
        }
        return new d();
    }
}
