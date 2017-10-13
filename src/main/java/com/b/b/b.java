package com.b.b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public interface b {
    public static final b a = new b() {
        public Drawable a(Resources resources, Bitmap bitmap) {
            return new BitmapDrawable(resources, bitmap);
        }
    };

    Drawable a(Resources resources, Bitmap bitmap);
}
