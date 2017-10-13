package com.b.b;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.b.a.b.f;
import com.b.a.f.c;
import com.b.a.f.g;
import com.b.b.a.b;
import com.b.b.f.a;
import java.io.File;
import java.nio.ByteBuffer;

@TargetApi(10)
public class t extends r implements f<x<File>> {
    c d;

    public t(j jVar, String str, boolean z, c cVar) {
        super(jVar, str, true, z);
        this.d = cVar;
    }

    public void a(Exception exception, final x<File> xVar) {
        if (exception == null) {
            exception = xVar.c();
        }
        if (exception != null) {
            a(exception, null);
            return;
        }
        final File file = (File) xVar.b();
        if (this.b.x.a(this.a) == this) {
            j.a().execute(new Runnable(this) {
                final /* synthetic */ t c;

                public void run() {
                    try {
                        File d;
                        if (this.c.d != null) {
                            this.c.d.a(this.c.a, file);
                            d = this.c.d.d(this.c.a);
                        } else {
                            d = file;
                        }
                        Options a = this.c.b.h().a(d, 0, 0);
                        Point point = new Point(a.outWidth, a.outHeight);
                        if (this.c.f && TextUtils.equals("image/gif", a.outMimeType)) {
                            a aVar = new a(ByteBuffer.wrap(g.a(this.c.d.c(this.c.a))));
                            b bVar = new b(this.c.a, a.outMimeType, aVar.g().a, point);
                            bVar.h = aVar;
                            this.c.a(null, bVar);
                            g.a(this.c.d.c(this.c.a));
                            return;
                        }
                        BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(d.toString(), false);
                        Bitmap decodeRegion = newInstance.decodeRegion(new Rect(0, 0, point.x, point.y), a);
                        if (decodeRegion == null) {
                            throw new Exception("unable to load decoder");
                        }
                        b bVar2 = new b(this.c.a, a.outMimeType, decodeRegion, point);
                        bVar2.i = newInstance;
                        bVar2.j = d;
                        bVar2.e = xVar.a();
                        this.c.a(null, bVar2);
                        g.a(null);
                    } catch (Exception e) {
                        this.c.a(e, null);
                        g.a(null);
                    } catch (Throwable th) {
                        g.a(null);
                    }
                }
            });
        }
    }
}
