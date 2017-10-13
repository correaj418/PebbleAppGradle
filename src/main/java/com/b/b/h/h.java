package com.b.b.h;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import com.b.a.b.e;
import com.b.a.b.i;
import com.b.b.a.b;
import com.b.b.j;
import com.b.b.y;
import java.net.URI;

public class h extends j {
    public e<b> a(Context context, j jVar, String str, String str2, int i, int i2, boolean z) {
        if (str2 == null || !str2.startsWith("package:")) {
            return null;
        }
        final e<b> iVar = new i();
        final String str3 = str2;
        final j jVar2 = jVar;
        final String str4 = str;
        j.a().execute(new Runnable(this) {
            final /* synthetic */ h e;

            public void run() {
                try {
                    String host = URI.create(str3).getHost();
                    PackageManager packageManager = jVar2.c().getPackageManager();
                    Bitmap bitmap = ((BitmapDrawable) packageManager.getPackageInfo(host, 0).applicationInfo.loadIcon(packageManager)).getBitmap();
                    if (bitmap == null) {
                        throw new Exception("package icon failed to load");
                    }
                    Object bVar = new b(str4, null, bitmap, new Point(bitmap.getWidth(), bitmap.getHeight()));
                    bVar.e = y.LOADED_FROM_CACHE;
                    iVar.b(bVar);
                } catch (Exception e) {
                    iVar.a(e);
                }
            }
        });
        return iVar;
    }
}
