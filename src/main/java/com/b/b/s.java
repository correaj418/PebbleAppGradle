package com.b.b;

import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import com.b.b.a.b;
import com.b.b.a.d;

public class s extends a {
    public s(j jVar, String str, BitmapRegionDecoder bitmapRegionDecoder, Rect rect, int i) {
        super(jVar, str, true);
        final BitmapRegionDecoder bitmapRegionDecoder2 = bitmapRegionDecoder;
        final Rect rect2 = rect;
        final int i2 = i;
        final String str2 = str;
        j.a().execute(new Runnable(this) {
            final /* synthetic */ s e;

            public void run() {
                try {
                    Bitmap a = d.a(bitmapRegionDecoder2, rect2, i2);
                    if (a == null) {
                        throw new Exception("failed to load bitmap region");
                    }
                    this.e.a(null, new b(str2, null, a, new Point(a.getWidth(), a.getHeight())));
                } catch (Exception e) {
                    this.e.a(e, null);
                }
            }
        });
    }
}
