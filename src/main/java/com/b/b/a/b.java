package com.b.b.a;

import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import com.b.a.f.i;
import com.b.b.f.a;
import com.b.b.y;
import java.io.File;

public class b {
    public final Point a;
    public long b = System.currentTimeMillis();
    public long c;
    public final String d;
    public y e;
    public final Bitmap f;
    public Exception g;
    public a h;
    public BitmapRegionDecoder i;
    public File j;
    public final String k;
    public final i l = new i();

    public b(String str, String str2, Bitmap bitmap, Point point) {
        this.a = point;
        this.f = bitmap;
        this.d = str;
        this.k = str2;
    }

    public int a() {
        if (this.f != null) {
            return this.f.getRowBytes() * this.f.getHeight();
        }
        if (this.h != null) {
            return this.h.d();
        }
        return 0;
    }
}
