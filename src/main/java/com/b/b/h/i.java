package com.b.b.h;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.net.Uri;
import android.text.TextUtils;
import com.b.a.b.e;
import com.b.a.b.f;
import com.b.a.e.c;
import com.b.a.f.g;
import com.b.a.m;
import com.b.b.a.b;
import com.b.b.a.d;
import com.b.b.j;
import com.b.b.y;
import java.io.InputStream;

public class i extends k {

    private static class a {
        Resources a;
        int b;

        private a() {
        }
    }

    private static a c(Context context, String str) {
        Uri parse = Uri.parse(str);
        if (parse.getPathSegments() == null) {
            throw new IllegalArgumentException("uri is not a valid resource uri");
        }
        int intValue;
        String authority = parse.getAuthority();
        Resources resources = context.createPackageContext(authority, 0).getResources();
        if (parse.getPathSegments().size() == 1) {
            intValue = Integer.valueOf((String) parse.getPathSegments().get(0)).intValue();
        } else if (parse.getPathSegments().size() == 2) {
            intValue = resources.getIdentifier((String) parse.getPathSegments().get(1), (String) parse.getPathSegments().get(0), authority);
            if (intValue == 0) {
                throw new IllegalArgumentException("resource not found in given package");
            }
        } else {
            throw new IllegalArgumentException("uri is not a valid resource uri");
        }
        a aVar = new a();
        aVar.a = resources;
        aVar.b = intValue;
        return aVar;
    }

    public e<b> a(Context context, j jVar, String str, String str2, int i, int i2, boolean z) {
        if (str2 == null || !str2.startsWith("android.resource:/")) {
            return null;
        }
        final e<b> iVar = new com.b.a.b.i();
        final Context context2 = context;
        final String str3 = str2;
        final j jVar2 = jVar;
        final int i3 = i;
        final int i4 = i2;
        final boolean z2 = z;
        final String str4 = str;
        j.a().execute(new Runnable(this) {
            final /* synthetic */ i i;

            public void run() {
                try {
                    Object a;
                    a b = i.c(context2, str3);
                    Options a2 = jVar2.h().a(b.a, b.b, i3, i4);
                    Point point = new Point(a2.outWidth, a2.outHeight);
                    if (z2 && TextUtils.equals("image/gif", a2.outMimeType)) {
                        a = this.i.a(str4, point, b.a.openRawResource(b.b), a2);
                        g.a(b.a.openRawResource(b.b));
                    } else {
                        Bitmap a3 = d.a(b.a, b.b, a2);
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
        });
        return iVar;
    }

    public e<m> a(j jVar, com.b.a.c.d dVar, f<com.b.b.u.a> fVar) {
        if (!dVar.d().getScheme().equals("android.resource")) {
            return null;
        }
        final e<m> fVar2 = new f();
        final j jVar2 = jVar;
        final com.b.a.c.d dVar2 = dVar;
        final f<com.b.b.u.a> fVar3 = fVar;
        jVar.e().e().a(new Runnable(this) {
            final /* synthetic */ i e;

            public void run() {
                try {
                    a b = i.c(jVar2.c(), dVar2.d().toString());
                    InputStream openRawResource = b.a.openRawResource(b.b);
                    if (openRawResource == null) {
                        throw new Exception("Unable to load content stream");
                    }
                    int available = openRawResource.available();
                    m cVar = new c(jVar2.e().e(), openRawResource);
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
