package com.b.b.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.text.TextUtils;
import com.b.a.b.e;
import com.b.a.b.i;
import com.b.a.f.g;
import com.b.b.a.b;
import com.b.b.a.d;
import com.b.b.f.a;
import com.b.b.j;
import com.b.b.y;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class k extends j {
    protected b a(String str, Point point, InputStream inputStream, Options options) {
        a aVar = new a(ByteBuffer.wrap(g.a(inputStream)));
        b bVar = new b(str, options.outMimeType, aVar.g().a, point);
        bVar.h = aVar;
        return bVar;
    }

    protected InputStream a(Context context, String str) {
        return null;
    }

    public e<b> a(Context context, j jVar, String str, String str2, int i, int i2, boolean z) {
        final e iVar = new i();
        final Context context2 = context;
        final String str3 = str2;
        final j jVar2 = jVar;
        final int i3 = i;
        final int i4 = i2;
        final boolean z2 = z;
        final String str4 = str;
        j.a().execute(new Runnable(this) {
            final /* synthetic */ k i;

            public void run() {
                InputStream inputStream = null;
                try {
                    Object a;
                    Options a2 = jVar2.h().a(this.i.a(context2, str3), i3, i4);
                    g.a(inputStream);
                    Point point = new Point(a2.outWidth, a2.outHeight);
                    inputStream = this.i.a(context2, str3);
                    if (z2 && TextUtils.equals("image/gif", a2.outMimeType)) {
                        a = this.i.a(str4, point, inputStream, a2);
                    } else {
                        Bitmap a3 = d.a(inputStream, a2);
                        if (a3 == null) {
                            throw new Exception("Bitmap failed to load");
                        }
                        a = new b(str4, a2.outMimeType, a3, point);
                    }
                    a.e = y.LOADED_FROM_CACHE;
                    iVar.b(a);
                    g.a(inputStream);
                } catch (Throwable e) {
                    iVar.b(new Exception(e), null);
                    g.a(inputStream);
                } catch (Exception e2) {
                    iVar.a(e2);
                    g.a(inputStream);
                } catch (Throwable th) {
                    g.a(inputStream);
                }
            }
        });
        return iVar;
    }
}
