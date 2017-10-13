package com.b.b.h;

import android.content.Context;
import android.net.Uri;
import com.b.a.b.e;
import com.b.a.b.f;
import com.b.a.c.d;
import com.b.a.m;
import com.b.b.a.b;
import com.b.b.j;
import com.b.b.u.a;
import com.b.b.y;
import java.io.InputStream;

public class c extends k {
    public e<b> a(Context context, j jVar, String str, String str2, int i, int i2, boolean z) {
        if (str2.startsWith("content:/")) {
            return super.a(context, jVar, str, str2, i, i2, z);
        }
        return null;
    }

    protected InputStream a(Context context, String str) {
        return context.getContentResolver().openInputStream(Uri.parse(str));
    }

    public e<m> a(j jVar, d dVar, f<a> fVar) {
        if (!dVar.d().getScheme().startsWith("content")) {
            return null;
        }
        final e<m> fVar2 = new f();
        final j jVar2 = jVar;
        final d dVar2 = dVar;
        final f<a> fVar3 = fVar;
        jVar.e().e().a(new Runnable(this) {
            final /* synthetic */ c e;

            public void run() {
                try {
                    InputStream openInputStream = jVar2.c().getContentResolver().openInputStream(Uri.parse(dVar2.d().toString()));
                    if (openInputStream == null) {
                        throw new Exception("Unable to load content stream");
                    }
                    int available = openInputStream.available();
                    m cVar = new com.b.a.e.c(jVar2.e().e(), openInputStream);
                    fVar2.b((Object) cVar);
                    fVar3.a(null, new a(cVar, (long) available, y.LOADED_FROM_CACHE, null, null));
                } catch (Exception e) {
                    fVar2.a(e);
                    fVar3.a(e, null);
                }
            }
        });
        return fVar2;
    }
}
