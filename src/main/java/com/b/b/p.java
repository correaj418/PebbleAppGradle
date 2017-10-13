package com.b.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.text.TextUtils;
import com.b.a.b.f;
import com.b.a.k;
import com.b.b.a.b;
import com.b.b.a.d;
import com.b.b.f.a;
import java.nio.ByteBuffer;

class p extends r implements f<x<k>> {
    int d;
    int e;

    public p(j jVar, String str, boolean z, int i, int i2, boolean z2) {
        super(jVar, str, z, z2);
        this.d = i;
        this.e = i2;
    }

    public void a(Exception exception, final x<k> xVar) {
        if (exception == null) {
            exception = xVar.c();
        }
        if (exception != null) {
            a(exception, null);
            return;
        }
        final k kVar = (k) xVar.b();
        if (this.b.x.a(this.a) != this) {
            kVar.m();
        } else {
            j.a().execute(new Runnable(this) {
                final /* synthetic */ p c;

                public void run() {
                    Throwable e;
                    Exception e2;
                    a aVar = null;
                    if (this.c.b.x.a(this.c.a) != this.c) {
                        kVar.m();
                        return;
                    }
                    ByteBuffer k;
                    ByteBuffer byteBuffer;
                    try {
                        Options a;
                        Point point;
                        Bitmap bitmap;
                        k = kVar.k();
                        try {
                            a = this.c.b.z.a(k.array(), k.arrayOffset() + k.position(), k.remaining(), this.c.d, this.c.e);
                            point = new Point(a.outWidth, a.outHeight);
                            if (this.c.f && TextUtils.equals("image/gif", a.outMimeType)) {
                                a aVar2 = new a(k.array(), k.arrayOffset() + k.position(), k.remaining());
                                a aVar3 = aVar2;
                                bitmap = aVar2.g().a;
                                byteBuffer = null;
                                aVar = aVar3;
                            } else {
                                bitmap = d.a(k.array(), k.arrayOffset() + k.position(), k.remaining(), a);
                                if (bitmap == null) {
                                    throw new Exception("failed to load bitmap");
                                }
                                byteBuffer = k;
                            }
                        } catch (OutOfMemoryError e3) {
                            e = e3;
                            byteBuffer = k;
                            try {
                                this.c.a(new Exception(e), null);
                                k.c(byteBuffer);
                            } catch (Throwable th) {
                                e = th;
                                k = byteBuffer;
                                k.c(k);
                                throw e;
                            }
                        } catch (Exception e4) {
                            e2 = e4;
                            try {
                                this.c.a(e2, null);
                                k.c(k);
                            } catch (Throwable th2) {
                                e = th2;
                                k.c(k);
                                throw e;
                            }
                        }
                        try {
                            b bVar = new b(this.c.a, a.outMimeType, bitmap, point);
                            bVar.h = aVar;
                            bVar.e = xVar.a();
                            this.c.a(null, bVar);
                            k.c(byteBuffer);
                        } catch (OutOfMemoryError e5) {
                            e = e5;
                            this.c.a(new Exception(e), null);
                            k.c(byteBuffer);
                        } catch (Exception e6) {
                            e2 = e6;
                            k = byteBuffer;
                            this.c.a(e2, null);
                            k.c(k);
                        }
                    } catch (OutOfMemoryError e7) {
                        e = e7;
                        byteBuffer = null;
                        this.c.a(new Exception(e), null);
                        k.c(byteBuffer);
                    } catch (Exception e8) {
                        e2 = e8;
                        k = null;
                        this.c.a(e2, null);
                        k.c(k);
                    } catch (Throwable th3) {
                        e = th3;
                        k = null;
                        k.c(k);
                        throw e;
                    }
                }
            });
        }
    }
}
