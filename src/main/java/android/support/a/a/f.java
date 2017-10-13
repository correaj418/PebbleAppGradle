package android.support.a.a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public class f extends e {
    static final Mode b = Mode.SRC_IN;
    private f c;
    private PorterDuffColorFilter d;
    private ColorFilter e;
    private boolean f;
    private boolean g;
    private ConstantState h;
    private final float[] i;
    private final Matrix j;
    private final Rect k;

    private static class d {
        protected android.support.a.a.c.b[] m = null;
        String n;
        int o;

        public d(d dVar) {
            this.n = dVar.n;
            this.o = dVar.o;
            this.m = c.a(dVar.m);
        }

        public void a(Path path) {
            path.reset();
            if (this.m != null) {
                android.support.a.a.c.b.a(this.m, path);
            }
        }

        public String b() {
            return this.n;
        }

        public boolean a() {
            return false;
        }
    }

    private static class a extends d {
        public a(a aVar) {
            super(aVar);
        }

        public void a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            if (d.a(xmlPullParser, "pathData")) {
                TypedArray b = e.b(resources, theme, attributeSet, a.d);
                a(b);
                b.recycle();
            }
        }

        private void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.n = string;
            }
            string = typedArray.getString(1);
            if (string != null) {
                this.m = c.a(string);
            }
        }

        public boolean a() {
            return true;
        }
    }

    private static class b extends d {
        int a = 0;
        float b = 0.0f;
        int c = 0;
        float d = 1.0f;
        int e;
        float f = 1.0f;
        float g = 0.0f;
        float h = 1.0f;
        float i = 0.0f;
        Cap j = Cap.BUTT;
        Join k = Join.MITER;
        float l = 4.0f;
        private int[] p;

        public b(b bVar) {
            super(bVar);
            this.p = bVar.p;
            this.a = bVar.a;
            this.b = bVar.b;
            this.d = bVar.d;
            this.c = bVar.c;
            this.e = bVar.e;
            this.f = bVar.f;
            this.g = bVar.g;
            this.h = bVar.h;
            this.i = bVar.i;
            this.j = bVar.j;
            this.k = bVar.k;
            this.l = bVar.l;
        }

        private Cap a(int i, Cap cap) {
            switch (i) {
                case 0:
                    return Cap.BUTT;
                case 1:
                    return Cap.ROUND;
                case 2:
                    return Cap.SQUARE;
                default:
                    return cap;
            }
        }

        private Join a(int i, Join join) {
            switch (i) {
                case 0:
                    return Join.MITER;
                case 1:
                    return Join.ROUND;
                case 2:
                    return Join.BEVEL;
                default:
                    return join;
            }
        }

        public void a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray b = e.b(resources, theme, attributeSet, a.c);
            a(b, xmlPullParser);
            b.recycle();
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.p = null;
            if (d.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.n = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.m = c.a(string);
                }
                this.c = d.b(typedArray, xmlPullParser, "fillColor", 1, this.c);
                this.f = d.a(typedArray, xmlPullParser, "fillAlpha", 12, this.f);
                this.j = a(d.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.j);
                this.k = a(d.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.k);
                this.l = d.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.l);
                this.a = d.b(typedArray, xmlPullParser, "strokeColor", 3, this.a);
                this.d = d.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.d);
                this.b = d.a(typedArray, xmlPullParser, "strokeWidth", 4, this.b);
                this.h = d.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.h);
                this.i = d.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.i);
                this.g = d.a(typedArray, xmlPullParser, "trimPathStart", 5, this.g);
            }
        }
    }

    private static class c {
        final ArrayList<Object> a = new ArrayList();
        private final Matrix b = new Matrix();
        private float c = 0.0f;
        private float d = 0.0f;
        private float e = 0.0f;
        private float f = 1.0f;
        private float g = 1.0f;
        private float h = 0.0f;
        private float i = 0.0f;
        private final Matrix j = new Matrix();
        private int k;
        private int[] l;
        private String m = null;

        public c(c cVar, android.support.v4.e.a<String, Object> aVar) {
            this.c = cVar.c;
            this.d = cVar.d;
            this.e = cVar.e;
            this.f = cVar.f;
            this.g = cVar.g;
            this.h = cVar.h;
            this.i = cVar.i;
            this.l = cVar.l;
            this.m = cVar.m;
            this.k = cVar.k;
            if (this.m != null) {
                aVar.put(this.m, this);
            }
            this.j.set(cVar.j);
            ArrayList arrayList = cVar.a;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof c) {
                    this.a.add(new c((c) obj, aVar));
                } else {
                    d bVar;
                    if (obj instanceof b) {
                        bVar = new b((b) obj);
                    } else if (obj instanceof a) {
                        bVar = new a((a) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.a.add(bVar);
                    if (bVar.n != null) {
                        aVar.put(bVar.n, bVar);
                    }
                }
            }
        }

        public String a() {
            return this.m;
        }

        public void a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray b = e.b(resources, theme, attributeSet, a.b);
            a(b, xmlPullParser);
            b.recycle();
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.c = d.a(typedArray, xmlPullParser, "rotation", 5, this.c);
            this.d = typedArray.getFloat(1, this.d);
            this.e = typedArray.getFloat(2, this.e);
            this.f = d.a(typedArray, xmlPullParser, "scaleX", 3, this.f);
            this.g = d.a(typedArray, xmlPullParser, "scaleY", 4, this.g);
            this.h = d.a(typedArray, xmlPullParser, "translateX", 6, this.h);
            this.i = d.a(typedArray, xmlPullParser, "translateY", 7, this.i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            b();
        }

        private void b() {
            this.j.reset();
            this.j.postTranslate(-this.d, -this.e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.d, this.i + this.e);
        }
    }

    private static class e {
        private static final Matrix j = new Matrix();
        float a;
        float b;
        float c;
        float d;
        int e;
        String f;
        final android.support.v4.e.a<String, Object> g;
        private final Path h;
        private final Path i;
        private final Matrix k;
        private Paint l;
        private Paint m;
        private PathMeasure n;
        private int o;
        private final c p;

        public e() {
            this.k = new Matrix();
            this.a = 0.0f;
            this.b = 0.0f;
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 255;
            this.f = null;
            this.g = new android.support.v4.e.a();
            this.p = new c();
            this.h = new Path();
            this.i = new Path();
        }

        public void a(int i) {
            this.e = i;
        }

        public int a() {
            return this.e;
        }

        public void a(float f) {
            a((int) (255.0f * f));
        }

        public float b() {
            return ((float) a()) / 255.0f;
        }

        public e(e eVar) {
            this.k = new Matrix();
            this.a = 0.0f;
            this.b = 0.0f;
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 255;
            this.f = null;
            this.g = new android.support.v4.e.a();
            this.p = new c(eVar.p, this.g);
            this.h = new Path(eVar.h);
            this.i = new Path(eVar.i);
            this.a = eVar.a;
            this.b = eVar.b;
            this.c = eVar.c;
            this.d = eVar.d;
            this.o = eVar.o;
            this.e = eVar.e;
            this.f = eVar.f;
            if (eVar.f != null) {
                this.g.put(eVar.f, this);
            }
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.b.set(matrix);
            cVar.b.preConcat(cVar.j);
            for (int i3 = 0; i3 < cVar.a.size(); i3++) {
                Object obj = cVar.a.get(i3);
                if (obj instanceof c) {
                    a((c) obj, cVar.b, canvas, i, i2, colorFilter);
                } else if (obj instanceof d) {
                    a(cVar, (d) obj, canvas, i, i2, colorFilter);
                }
            }
        }

        public void a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            a(this.p, j, canvas, i, i2, colorFilter);
        }

        private void a(c cVar, d dVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = ((float) i) / this.c;
            float f2 = ((float) i2) / this.d;
            float min = Math.min(f, f2);
            Matrix b = cVar.b;
            this.k.set(b);
            this.k.postScale(f, f2);
            f = a(b);
            if (f != 0.0f) {
                dVar.a(this.h);
                Path path = this.h;
                this.i.reset();
                if (dVar.a()) {
                    this.i.addPath(path, this.k);
                    canvas.clipPath(this.i, Op.REPLACE);
                    return;
                }
                Paint paint;
                b bVar = (b) dVar;
                if (!(bVar.g == 0.0f && bVar.h == 1.0f)) {
                    float f3 = (bVar.g + bVar.i) % 1.0f;
                    float f4 = (bVar.h + bVar.i) % 1.0f;
                    if (this.n == null) {
                        this.n = new PathMeasure();
                    }
                    this.n.setPath(this.h, false);
                    float length = this.n.getLength();
                    f3 *= length;
                    f4 *= length;
                    path.reset();
                    if (f3 > f4) {
                        this.n.getSegment(f3, length, path, true);
                        this.n.getSegment(0.0f, f4, path, true);
                    } else {
                        this.n.getSegment(f3, f4, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.i.addPath(path, this.k);
                if (bVar.c != 0) {
                    if (this.m == null) {
                        this.m = new Paint();
                        this.m.setStyle(Style.FILL);
                        this.m.setAntiAlias(true);
                    }
                    paint = this.m;
                    paint.setColor(f.b(bVar.c, bVar.f));
                    paint.setColorFilter(colorFilter);
                    canvas.drawPath(this.i, paint);
                }
                if (bVar.a != 0) {
                    if (this.l == null) {
                        this.l = new Paint();
                        this.l.setStyle(Style.STROKE);
                        this.l.setAntiAlias(true);
                    }
                    paint = this.l;
                    if (bVar.k != null) {
                        paint.setStrokeJoin(bVar.k);
                    }
                    if (bVar.j != null) {
                        paint.setStrokeCap(bVar.j);
                    }
                    paint.setStrokeMiter(bVar.l);
                    paint.setColor(f.b(bVar.a, bVar.d));
                    paint.setColorFilter(colorFilter);
                    paint.setStrokeWidth((f * min) * bVar.b);
                    canvas.drawPath(this.i, paint);
                }
            }
        }

        private static float a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private float a(Matrix matrix) {
            float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
            float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
            float a = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            hypot = Math.max(hypot, hypot2);
            if (hypot > 0.0f) {
                return Math.abs(a) / hypot;
            }
            return 0.0f;
        }
    }

    private static class f extends ConstantState {
        int a;
        e b;
        ColorStateList c;
        Mode d;
        boolean e;
        Bitmap f;
        ColorStateList g;
        Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public f(f fVar) {
            this.c = null;
            this.d = f.b;
            if (fVar != null) {
                this.a = fVar.a;
                this.b = new e(fVar.b);
                if (fVar.b.m != null) {
                    this.b.m = new Paint(fVar.b.m);
                }
                if (fVar.b.l != null) {
                    this.b.l = new Paint(fVar.b.l);
                }
                this.c = fVar.c;
                this.d = fVar.d;
                this.e = fVar.e;
            }
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f, null, rect, a(colorFilter));
        }

        public boolean a() {
            return this.b.a() < 255;
        }

        public Paint a(ColorFilter colorFilter) {
            if (!a() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                this.l = new Paint();
                this.l.setFilterBitmap(true);
            }
            this.l.setAlpha(this.b.a());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        public void a(int i, int i2) {
            this.f.eraseColor(0);
            this.b.a(new Canvas(this.f), i, i2, null);
        }

        public void b(int i, int i2) {
            if (this.f == null || !c(i, i2)) {
                this.f = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                this.k = true;
            }
        }

        public boolean c(int i, int i2) {
            if (i == this.f.getWidth() && i2 == this.f.getHeight()) {
                return true;
            }
            return false;
        }

        public boolean b() {
            if (!this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.b.a()) {
                return true;
            }
            return false;
        }

        public void c() {
            this.g = this.c;
            this.h = this.d;
            this.i = this.b.a();
            this.j = this.e;
            this.k = false;
        }

        public f() {
            this.c = null;
            this.d = f.b;
            this.b = new e();
        }

        public Drawable newDrawable() {
            return new f();
        }

        public Drawable newDrawable(Resources resources) {
            return new f();
        }

        public int getChangingConfigurations() {
            return this.a;
        }
    }

    private static class g extends ConstantState {
        private final ConstantState a;

        public g(ConstantState constantState) {
            this.a = constantState;
        }

        public Drawable newDrawable() {
            Drawable fVar = new f();
            fVar.a = (VectorDrawable) this.a.newDrawable();
            return fVar;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable fVar = new f();
            fVar.a = (VectorDrawable) this.a.newDrawable(resources);
            return fVar;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable fVar = new f();
            fVar.a = (VectorDrawable) this.a.newDrawable(resources, theme);
            return fVar;
        }

        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    private f() {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.c = new f();
    }

    private f(f fVar) {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.c = fVar;
        this.d = a(this.d, fVar.c, fVar.d);
    }

    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
        } else if (!this.f && super.mutate() == this) {
            this.c = new f(this.c);
            this.f = true;
        }
        return this;
    }

    Object a(String str) {
        return this.c.b.g.get(str);
    }

    public ConstantState getConstantState() {
        if (this.a != null) {
            return new g(this.a.getConstantState());
        }
        this.c.a = getChangingConfigurations();
        return this.c;
    }

    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        copyBounds(this.k);
        if (this.k.width() > 0 && this.k.height() > 0) {
            ColorFilter colorFilter = this.e == null ? this.d : this.e;
            canvas.getMatrix(this.j);
            this.j.getValues(this.i);
            float abs = Math.abs(this.i[0]);
            float abs2 = Math.abs(this.i[4]);
            float abs3 = Math.abs(this.i[1]);
            float abs4 = Math.abs(this.i[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs2 = 1.0f;
                abs = 1.0f;
            }
            int height = (int) (abs2 * ((float) this.k.height()));
            int min = Math.min(2048, (int) (abs * ((float) this.k.width())));
            height = Math.min(2048, height);
            if (min > 0 && height > 0) {
                int save = canvas.save();
                canvas.translate((float) this.k.left, (float) this.k.top);
                if (a()) {
                    canvas.translate((float) this.k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.k.offsetTo(0, 0);
                this.c.b(min, height);
                if (!this.g) {
                    this.c.a(min, height);
                } else if (!this.c.b()) {
                    this.c.a(min, height);
                    this.c.c();
                }
                this.c.a(canvas, colorFilter, this.k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        if (this.a != null) {
            return android.support.v4.b.a.a.c(this.a);
        }
        return this.c.b.a();
    }

    public void setAlpha(int i) {
        if (this.a != null) {
            this.a.setAlpha(i);
        } else if (this.c.b.a() != i) {
            this.c.b.a(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
            return;
        }
        this.e = colorFilter;
        invalidateSelf();
    }

    PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void setTint(int i) {
        if (this.a != null) {
            android.support.v4.b.a.a.a(this.a, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            android.support.v4.b.a.a.a(this.a, colorStateList);
            return;
        }
        f fVar = this.c;
        if (fVar.c != colorStateList) {
            fVar.c = colorStateList;
            this.d = a(this.d, colorStateList, fVar.d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        if (this.a != null) {
            android.support.v4.b.a.a.a(this.a, mode);
            return;
        }
        f fVar = this.c;
        if (fVar.d != mode) {
            fVar.d = mode;
            this.d = a(this.d, fVar.c, mode);
            invalidateSelf();
        }
    }

    public boolean isStateful() {
        if (this.a != null) {
            return this.a.isStateful();
        }
        return super.isStateful() || !(this.c == null || this.c.c == null || !this.c.c.isStateful());
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.a != null) {
            return this.a.setState(iArr);
        }
        f fVar = this.c;
        if (fVar.c == null || fVar.d == null) {
            return false;
        }
        this.d = a(this.d, fVar.c, fVar.d);
        invalidateSelf();
        return true;
    }

    public int getOpacity() {
        if (this.a != null) {
            return this.a.getOpacity();
        }
        return -3;
    }

    public int getIntrinsicWidth() {
        if (this.a != null) {
            return this.a.getIntrinsicWidth();
        }
        return (int) this.c.b.a;
    }

    public int getIntrinsicHeight() {
        if (this.a != null) {
            return this.a.getIntrinsicHeight();
        }
        return (int) this.c.b.b;
    }

    public boolean canApplyTheme() {
        if (this.a != null) {
            android.support.v4.b.a.a.d(this.a);
        }
        return false;
    }

    public static f a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 23) {
            f fVar = new f();
            fVar.a = android.support.v4.content.a.d.a(resources, i, theme);
            fVar.h = new g(fVar.a.getConstantState());
            return fVar;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (Throwable e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (Throwable e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static f a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f fVar = new f();
        fVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return fVar;
    }

    private static int b(int i, float f) {
        return (((int) (((float) Color.alpha(i)) * f)) << 24) | (16777215 & i);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.a != null) {
            this.a.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.a != null) {
            android.support.v4.b.a.a.a(this.a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        f fVar = this.c;
        fVar.b = new e();
        TypedArray b = e.b(resources, theme, attributeSet, a.a);
        a(b, xmlPullParser);
        b.recycle();
        fVar.a = getChangingConfigurations();
        fVar.k = true;
        b(resources, xmlPullParser, attributeSet, theme);
        this.d = a(this.d, fVar.c, fVar.d);
    }

    private static Mode a(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        f fVar = this.c;
        e eVar = fVar.b;
        fVar.d = a(d.a(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            fVar.c = colorStateList;
        }
        fVar.e = d.a(typedArray, xmlPullParser, "autoMirrored", 5, fVar.e);
        eVar.c = d.a(typedArray, xmlPullParser, "viewportWidth", 7, eVar.c);
        eVar.d = d.a(typedArray, xmlPullParser, "viewportHeight", 8, eVar.d);
        if (eVar.c <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (eVar.d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            eVar.a = typedArray.getDimension(3, eVar.a);
            eVar.b = typedArray.getDimension(2, eVar.b);
            if (eVar.a <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (eVar.b <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                eVar.a(d.a(typedArray, xmlPullParser, "alpha", 4, eVar.b()));
                String string = typedArray.getString(0);
                if (string != null) {
                    eVar.f = string;
                    eVar.g.put(string, eVar);
                }
            }
        }
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f fVar = this.c;
        e eVar = fVar.b;
        Stack stack = new Stack();
        stack.push(eVar.p);
        int eventType = xmlPullParser.getEventType();
        Object obj = 1;
        while (eventType != 1) {
            if (eventType == 2) {
                Object obj2;
                String name = xmlPullParser.getName();
                c cVar = (c) stack.peek();
                if ("path".equals(name)) {
                    b bVar = new b();
                    bVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.a.add(bVar);
                    if (bVar.b() != null) {
                        eVar.g.put(bVar.b(), bVar);
                    }
                    obj2 = null;
                    fVar.a = bVar.o | fVar.a;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    aVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.a.add(aVar);
                    if (aVar.b() != null) {
                        eVar.g.put(aVar.b(), aVar);
                    }
                    fVar.a |= aVar.o;
                    obj2 = obj;
                } else {
                    if ("group".equals(name)) {
                        c cVar2 = new c();
                        cVar2.a(resources, attributeSet, theme, xmlPullParser);
                        cVar.a.add(cVar2);
                        stack.push(cVar2);
                        if (cVar2.a() != null) {
                            eVar.g.put(cVar2.a(), cVar2);
                        }
                        fVar.a |= cVar2.k;
                    }
                    obj2 = obj;
                }
                obj = obj2;
            } else if (eventType == 3) {
                if ("group".equals(xmlPullParser.getName())) {
                    stack.pop();
                }
            }
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    void a(boolean z) {
        this.g = z;
    }

    private boolean a() {
        return false;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        }
    }

    public int getChangingConfigurations() {
        if (this.a != null) {
            return this.a.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.c.getChangingConfigurations();
    }

    public void invalidateSelf() {
        if (this.a != null) {
            this.a.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.a != null) {
            this.a.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.a != null) {
            return this.a.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.a != null) {
            this.a.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
