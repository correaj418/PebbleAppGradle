package net.hockeyapp.android.views;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import java.util.Iterator;
import java.util.Stack;

public class c extends ImageView {
    private Path a = new Path();
    private Stack<Path> b = new Stack();
    private Paint c = new Paint();
    private float d;
    private float e;

    public static int a(ContentResolver contentResolver, Uri uri) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(contentResolver.openInputStream(uri), null, options);
            if (((float) options.outWidth) / ((float) options.outHeight) > 1.0f) {
                return 0;
            }
            return 1;
        } catch (Throwable e) {
            Log.e("HockeyApp", "Unable to determine necessary screen orientation.", e);
            return 1;
        }
    }

    private static int a(Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            i3 /= 2;
            i4 /= 2;
            while (i3 / i5 > i2 && i4 / i5 > i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    private static Bitmap b(ContentResolver contentResolver, Uri uri, int i, int i2) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(contentResolver.openInputStream(uri), null, options);
        options.inSampleSize = a(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(contentResolver.openInputStream(uri), null, options);
    }

    public c(Context context, Uri uri, int i, int i2) {
        super(context);
        this.c.setAntiAlias(true);
        this.c.setDither(true);
        this.c.setColor(-65536);
        this.c.setStyle(Style.STROKE);
        this.c.setStrokeJoin(Join.ROUND);
        this.c.setStrokeCap(Cap.ROUND);
        this.c.setStrokeWidth(12.0f);
        new AsyncTask<Object, Void, Bitmap>(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                return a(objArr);
            }

            protected /* synthetic */ void onPostExecute(Object obj) {
                a((Bitmap) obj);
            }

            protected void onPreExecute() {
                this.a.setAdjustViewBounds(true);
            }

            protected Bitmap a(Object... objArr) {
                try {
                    return c.b(((Context) objArr[0]).getContentResolver(), (Uri) objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
                } catch (Throwable e) {
                    Log.e("HockeyApp", "Could not load image into ImageView.", e);
                    return null;
                }
            }

            protected void a(Bitmap bitmap) {
                if (bitmap != null) {
                    this.a.setImageBitmap(bitmap);
                }
            }
        }.execute(new Object[]{context, uri, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public void a() {
        this.b.clear();
        invalidate();
    }

    public void b() {
        if (!this.b.empty()) {
            this.b.pop();
            invalidate();
        }
    }

    public boolean c() {
        return this.b.empty();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            canvas.drawPath((Path) it.next(), this.c);
        }
        canvas.drawPath(this.a, this.c);
    }

    private void a(float f, float f2) {
        this.a.reset();
        this.a.moveTo(f, f2);
        this.d = f;
        this.e = f2;
    }

    private void b(float f, float f2) {
        float abs = Math.abs(f - this.d);
        float abs2 = Math.abs(f2 - this.e);
        if (abs >= 4.0f || abs2 >= 4.0f) {
            this.a.quadTo(this.d, this.e, (this.d + f) / 2.0f, (this.e + f2) / 2.0f);
            this.d = f;
            this.e = f2;
        }
    }

    private void d() {
        this.a.lineTo(this.d, this.e);
        this.b.push(this.a);
        this.a = new Path();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                a(x, y);
                invalidate();
                break;
            case 1:
                d();
                invalidate();
                break;
            case 2:
                b(x, y);
                invalidate();
                break;
        }
        return true;
    }
}
