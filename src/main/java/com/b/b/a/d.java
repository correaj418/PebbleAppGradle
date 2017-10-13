package com.b.b.a;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.b.a.f.g;
import com.b.b.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class d {
    static final /* synthetic */ boolean g = (!d.class.desiredAssertionStatus());
    Resources a;
    DisplayMetrics b;
    e c;
    j d;
    long e = 30000;
    double f = 0.14285714285714285d;

    public d(j jVar) {
        Context applicationContext = jVar.c().getApplicationContext();
        this.d = jVar;
        this.b = new DisplayMetrics();
        ((WindowManager) applicationContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.b);
        this.a = new Resources(applicationContext.getAssets(), this.b, applicationContext.getResources().getConfiguration());
        this.c = new e(a(applicationContext) / 7);
    }

    public void a(b bVar) {
        if (g || Thread.currentThread() == Looper.getMainLooper().getThread()) {
            int a = (int) (((double) a(this.d.c())) * this.f);
            if (((long) a) != this.c.a()) {
                this.c.a((long) a);
            }
            this.c.b(bVar.d, bVar);
            return;
        }
        throw new AssertionError();
    }

    public void b(b bVar) {
        if (g || Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.c.a(bVar.d, bVar);
            return;
        }
        throw new AssertionError();
    }

    public b a(String str) {
        if (str == null) {
            return null;
        }
        b a = this.c.a(str);
        if (a == null) {
            return null;
        }
        if (a.f != null && a.f.isRecycled()) {
            Log.w("ION", "Cached bitmap was recycled.");
            Log.w("ION", "This may happen if passing Ion bitmaps directly to notification builders or remote media clients.");
            Log.w("ION", "Create a deep copy before doing this.");
            this.c.b((Object) str);
            return null;
        } else if (a.g == null) {
            return a;
        } else {
            if (a.b + this.e > System.currentTimeMillis()) {
                return a;
            }
            this.c.b((Object) str);
            return null;
        }
    }

    private Point a(int i, int i2) {
        int i3;
        int i4;
        int i5 = Integer.MAX_VALUE;
        if (i == 0) {
            i3 = this.b.widthPixels;
        } else {
            i3 = i;
        }
        if (i3 <= 0) {
            i4 = Integer.MAX_VALUE;
        } else {
            i4 = i3;
        }
        if (i2 == 0) {
            i3 = this.b.heightPixels;
        } else {
            i3 = i2;
        }
        if (i3 > 0) {
            i5 = i3;
        }
        return new Point(i4, i5);
    }

    private Options a(Options options, int i, int i2) {
        if (options.outWidth < 0 || options.outHeight < 0) {
            throw new a(options.outWidth, options.outHeight);
        }
        Point a = a(i, i2);
        int round = Math.round(Math.max(((float) options.outWidth) / ((float) a.x), ((float) options.outHeight) / ((float) a.y)));
        Options options2 = new Options();
        options2.inSampleSize = round;
        options2.outWidth = options.outWidth;
        options2.outHeight = options.outHeight;
        options2.outMimeType = options.outMimeType;
        return options2;
    }

    public Options a(File file, int i, int i2) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.toString(), options);
        return a(options, i, i2);
    }

    public Options a(byte[] bArr, int i, int i2, int i3, int i4) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, i, i2, options);
        return a(options, i3, i4);
    }

    public Options a(Resources resources, int i, int i2, int i3) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        return a(options, i2, i3);
    }

    public Options a(InputStream inputStream, int i, int i2) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        return a(options, i, i2);
    }

    private static Bitmap a(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        if (i == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap a(byte[] bArr, int i, int i2, Options options) {
        if (g || Thread.currentThread() != Looper.getMainLooper().getThread()) {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, i, i2, options);
            if (decodeByteArray == null) {
                return null;
            }
            return a(decodeByteArray, c.a(bArr, i, i2));
        }
        throw new AssertionError();
    }

    @TargetApi(10)
    public static Bitmap a(BitmapRegionDecoder bitmapRegionDecoder, Rect rect, int i) {
        Options options = new Options();
        options.inSampleSize = i;
        return bitmapRegionDecoder.decodeRegion(rect, options);
    }

    public static Bitmap a(Resources resources, int i, Options options) {
        if (g || Thread.currentThread() != Looper.getMainLooper().getThread()) {
            int a;
            InputStream inputStream = null;
            try {
                inputStream = resources.openRawResource(i);
                byte[] bArr = new byte[50000];
                a = c.a(bArr, 0, inputStream.read(bArr));
            } catch (Exception e) {
                a = 0;
            }
            g.a(inputStream);
            return a(BitmapFactory.decodeResource(resources, i, options), a);
        }
        throw new AssertionError();
    }

    public static Bitmap a(InputStream inputStream, Options options) {
        int i = 0;
        if (g || Thread.currentThread() != Looper.getMainLooper().getThread()) {
            InputStream fVar = new f(inputStream);
            fVar.mark(50000);
            try {
                byte[] bArr = new byte[50000];
                i = c.a(bArr, 0, fVar.read(bArr));
            } catch (Exception e) {
            }
            fVar.reset();
            return a(BitmapFactory.decodeStream(fVar, null, options), i);
        }
        throw new AssertionError();
    }

    public static Bitmap a(File file, Options options) {
        FileInputStream fileInputStream;
        int a;
        if (g || Thread.currentThread() != Looper.getMainLooper().getThread()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[50000];
                    a = c.a(bArr, 0, fileInputStream.read(bArr));
                } catch (Exception e) {
                    a = 0;
                    g.a(fileInputStream);
                    return a(BitmapFactory.decodeFile(file.toString(), options), a);
                }
            } catch (Exception e2) {
                fileInputStream = null;
                a = 0;
                g.a(fileInputStream);
                return a(BitmapFactory.decodeFile(file.toString(), options), a);
            }
            g.a(fileInputStream);
            return a(BitmapFactory.decodeFile(file.toString(), options), a);
        }
        throw new AssertionError();
    }

    private static int a(Context context) {
        return (((ActivityManager) context.getSystemService("activity")).getMemoryClass() * 1024) * 1024;
    }
}
