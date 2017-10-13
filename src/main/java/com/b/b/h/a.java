package com.b.b.h;

import android.content.Context;
import android.net.Uri;
import com.b.a.b.e;
import com.b.a.b.f;
import com.b.a.c.d;
import com.b.a.e.c;
import com.b.a.m;
import com.b.b.a.b;
import com.b.b.j;
import com.b.b.y;
import java.io.InputStream;

public class a extends k {
    public e<b> a(Context context, j jVar, String str, String str2, int i, int i2, boolean z) {
        if (str2.startsWith("file:///android_asset/")) {
            return super.a(context, jVar, str, str2, i, i2, z);
        }
        return null;
    }

    protected InputStream a(Context context, String str) {
        return context.getAssets().open(Uri.parse(str).getPath().replaceFirst("^/android_asset/", ""));
    }

    public e<m> a(j jVar, d dVar, f<com.b.b.u.a> fVar) {
        if (!dVar.d().toString().startsWith("file:///android_asset/")) {
            return null;
        }
        final e<m> fVar2 = new f();
        final j jVar2 = jVar;
        final d dVar2 = dVar;
        final f<com.b.b.u.a> fVar3 = fVar;
        jVar.e().e().a(new Runnable(this) {
            final /* synthetic */ a e;

            public void run() {
                try {
                    InputStream a = this.e.a(jVar2.c(), dVar2.d().toString());
                    if (a == null) {
                        throw new Exception("Unable to load content stream");
                    }
                    int available = a.available();
                    m cVar = new c(jVar2.e().e(), a);
                    fVar2.b((Object) cVar);
                    fVar3.a(null, new com.b.b.u.a(cVar, (long) available, y.LOADED_FROM_CACHE, null, null));
                } catch (Exception e) {
                    fVar2.a(e);
                    fVar3.a(e, null);
                }
            }
        });
        return fVar2;
    }
}
