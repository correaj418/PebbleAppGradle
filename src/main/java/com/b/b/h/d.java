package com.b.b.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.text.TextUtils;
import com.b.a.b.e;
import com.b.a.b.f;
import com.b.a.b.i;
import com.b.a.f.g;
import com.b.a.m;
import com.b.a.s;
import com.b.b.a.b;
import com.b.b.j;
import com.b.b.y;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;

public class d extends k {

    private static final class a extends i<m> {
        private a() {
        }
    }

    public e<b> a(Context context, j jVar, String str, String str2, int i, int i2, boolean z) {
        if (str2 == null || !str2.startsWith("file:/")) {
            return null;
        }
        final e<b> iVar = new i();
        final String str3 = str2;
        final j jVar2 = jVar;
        final int i3 = i;
        final int i4 = i2;
        final boolean z2 = z;
        final String str4 = str;
        j.a().execute(new Runnable(this) {
            final /* synthetic */ d h;

            public void run() {
                if (!iVar.isCancelled()) {
                    try {
                        Object a;
                        File file = new File(URI.create(str3));
                        Options a2 = jVar2.h().a(file, i3, i4);
                        Point point = new Point(a2.outWidth, a2.outHeight);
                        if (z2 && TextUtils.equals("image/gif", a2.outMimeType)) {
                            a = this.h.a(str4, point, new FileInputStream(file), a2);
                            g.a(new FileInputStream(file));
                        } else {
                            Bitmap a3 = com.b.b.a.d.a(file, a2);
                            if (a3 == null) {
                                throw new Exception("Bitmap failed to load");
                            }
                            a = new b(str4, a2.outMimeType, a3, point);
                        }
                        a.e = y.LOADED_FROM_CACHE;
                        iVar.b(a);
                    } catch (Throwable e) {
                        iVar.b(new Exception(e), null);
                    } catch (Exception e2) {
                        iVar.a(e2);
                    } catch (Throwable th) {
                        g.a(r3);
                    }
                }
            }
        });
        return iVar;
    }

    public e<m> a(j jVar, com.b.a.c.d dVar, f<com.b.b.u.a> fVar) {
        if (!dVar.d().getScheme().startsWith("file")) {
            return null;
        }
        final e<m> aVar = new a();
        final com.b.a.c.d dVar2 = dVar;
        final j jVar2 = jVar;
        final f<com.b.b.u.a> fVar2 = fVar;
        jVar.e().e().a(new Runnable(this) {
            final /* synthetic */ d e;

            public void run() {
                File file = new File(URI.create(dVar2.d().toString()));
                m sVar = new s(jVar2.e().e(), file);
                aVar.b((Object) sVar);
                fVar2.a(null, new com.b.b.u.a(sVar, (long) ((int) file.length()), y.LOADED_FROM_CACHE, null, dVar2));
            }
        });
        return aVar;
    }
}
