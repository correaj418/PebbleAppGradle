package com.b.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import com.b.a.b.f;
import com.b.a.f.c;
import com.b.b.a.b;
import com.b.b.a.d;
import com.b.b.a.g;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;

abstract class a {
    final String a;
    final j b;
    final boolean c;

    public static void a(j jVar, b bVar) {
        if (bVar.f != null) {
            c a = jVar.i.a();
            if (a != null) {
                File a2 = a.a();
                try {
                    OutputStream fileOutputStream = new FileOutputStream(a2);
                    bVar.f.compress(bVar.f.hasAlpha() ? CompressFormat.PNG : CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.close();
                    a.a(bVar.d, a2);
                } catch (Exception e) {
                } finally {
                    a2.delete();
                }
            }
        }
    }

    public static void a(final j jVar, final String str, final ArrayList<g> arrayList) {
        if (jVar.x.a(str) == null) {
            final a qVar = new q(jVar, str, true);
            j.a().execute(new Runnable() {
                public void run() {
                    if (jVar.x.a(str) == qVar) {
                        try {
                            Bitmap a = d.a(jVar.i.a().d(str), null);
                            if (a == null) {
                                throw new Exception("Bitmap failed to load");
                            }
                            b bVar = new b(str, "image/jpeg", a, null);
                            bVar.e = y.LOADED_FROM_CACHE;
                            if (arrayList != null) {
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    ((g) it.next()).a(bVar);
                                }
                            }
                            qVar.a(null, bVar);
                        } catch (Throwable e) {
                            qVar.a(new Exception(e), null);
                        } catch (Exception e2) {
                            qVar.a(e2, null);
                            try {
                                jVar.i.a().a(str);
                            } catch (Exception e3) {
                            }
                        }
                    }
                }
            });
        }
    }

    protected a(j jVar, String str, boolean z) {
        this.a = str;
        this.c = z;
        this.b = jVar;
        jVar.x.a(str, this);
    }

    boolean a() {
        return this.c;
    }

    protected void b() {
        this.b.b();
    }

    protected void a(final Exception exception, final b bVar) {
        com.b.a.g.a(j.a, new Runnable(this) {
            final /* synthetic */ a c;

            public void run() {
                b bVar = bVar;
                b bVar2;
                if (bVar == null) {
                    bVar = new b(this.c.a, null, null, new Point());
                    bVar.g = exception;
                    if (exception instanceof CancellationException) {
                        bVar2 = bVar;
                    } else {
                        this.c.b.h().a(bVar);
                        Object obj = bVar;
                    }
                } else if (this.c.a()) {
                    this.c.b.h().a(bVar);
                    bVar2 = bVar;
                } else {
                    this.c.b.h().b(bVar);
                    bVar2 = bVar;
                }
                ArrayList b = this.c.b.x.b(this.c.a);
                if (b == null || b.size() == 0) {
                    this.c.b();
                    return;
                }
                Iterator it = b.iterator();
                while (it.hasNext()) {
                    ((f) it.next()).a(exception, obj);
                }
                this.c.b();
            }
        });
        if (bVar != null && bVar.a != null && bVar.i == null && this.c && bVar.f != null && bVar.h == null && bVar.a() <= 1048576) {
            a(this.b, bVar);
        }
    }
}
