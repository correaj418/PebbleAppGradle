package android.support.v7.e;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.SparseBooleanArray;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class b {
    private static final b f = new b() {
        public boolean a(int i, float[] fArr) {
            return (b(fArr) || a(fArr) || c(fArr)) ? false : true;
        }

        private boolean a(float[] fArr) {
            return fArr[2] <= 0.05f;
        }

        private boolean b(float[] fArr) {
            return fArr[2] >= 0.95f;
        }

        private boolean c(float[] fArr) {
            return fArr[0] >= 10.0f && fArr[0] <= 37.0f && fArr[1] <= 0.82f;
        }
    };
    private final List<c> a;
    private final List<c> b;
    private final Map<c, c> c;
    private final SparseBooleanArray d;
    private final int e;

    public interface b {
        boolean a(int i, float[] fArr);
    }

    public static final class a {
        private final List<c> a;
        private final Bitmap b;
        private final List<c> c = new ArrayList();
        private int d = 16;
        private int e = 25600;
        private int f = -1;
        private final List<b> g = new ArrayList();
        private Rect h;

        public a(Bitmap bitmap) {
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            this.g.add(b.f);
            this.b = bitmap;
            this.a = null;
            this.c.add(c.a);
            this.c.add(c.b);
            this.c.add(c.c);
            this.c.add(c.d);
            this.c.add(c.e);
            this.c.add(c.f);
        }

        public b a() {
            List a;
            TimingLogger timingLogger = null;
            if (this.b != null) {
                b[] bVarArr;
                Bitmap b = b(this.b);
                if (timingLogger != null) {
                    timingLogger.addSplit("Processed Bitmap");
                }
                Rect rect = this.h;
                if (!(b == this.b || rect == null)) {
                    double width = ((double) b.getWidth()) / ((double) this.b.getWidth());
                    rect.left = (int) Math.floor(((double) rect.left) * width);
                    rect.top = (int) Math.floor(((double) rect.top) * width);
                    rect.right = Math.min((int) Math.ceil(((double) rect.right) * width), b.getWidth());
                    rect.bottom = Math.min((int) Math.ceil(width * ((double) rect.bottom)), b.getHeight());
                }
                int[] a2 = a(b);
                int i = this.d;
                if (this.g.isEmpty()) {
                    bVarArr = timingLogger;
                } else {
                    bVarArr = (b[]) this.g.toArray(new b[this.g.size()]);
                }
                a aVar = new a(a2, i, bVarArr);
                if (b != this.b) {
                    b.recycle();
                }
                a = aVar.a();
                if (timingLogger != null) {
                    timingLogger.addSplit("Color quantization completed");
                }
            } else {
                a = this.a;
            }
            b bVar = new b(a, this.c);
            bVar.b();
            if (timingLogger != null) {
                timingLogger.addSplit("Created Palette");
                timingLogger.dumpToLog();
            }
            return bVar;
        }

        private int[] a(Bitmap bitmap) {
            int i = 0;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Object obj = new int[(width * height)];
            bitmap.getPixels(obj, 0, width, 0, 0, width, height);
            if (this.h == null) {
                return obj;
            }
            int width2 = this.h.width();
            int height2 = this.h.height();
            Object obj2 = new int[(width2 * height2)];
            while (i < height2) {
                System.arraycopy(obj, ((this.h.top + i) * width) + this.h.left, obj2, i * width2, width2);
                i++;
            }
            return obj2;
        }

        private Bitmap b(Bitmap bitmap) {
            double d = -1.0d;
            int width;
            if (this.e > 0) {
                width = bitmap.getWidth() * bitmap.getHeight();
                if (width > this.e) {
                    d = ((double) this.e) / ((double) width);
                }
            } else if (this.f > 0) {
                width = Math.max(bitmap.getWidth(), bitmap.getHeight());
                if (width > this.f) {
                    d = ((double) this.f) / ((double) width);
                }
            }
            return d <= 0.0d ? bitmap : Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * d), (int) Math.ceil(d * ((double) bitmap.getHeight())), false);
        }
    }

    public static final class c {
        private final int a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;
        private boolean f;
        private int g;
        private int h;
        private float[] i;

        public c(int i, int i2) {
            this.a = Color.red(i);
            this.b = Color.green(i);
            this.c = Color.blue(i);
            this.d = i;
            this.e = i2;
        }

        public int a() {
            return this.d;
        }

        public float[] b() {
            if (this.i == null) {
                this.i = new float[3];
            }
            android.support.v4.b.a.a(this.a, this.b, this.c, this.i);
            return this.i;
        }

        public int c() {
            return this.e;
        }

        public int d() {
            f();
            return this.g;
        }

        public int e() {
            f();
            return this.h;
        }

        private void f() {
            if (!this.f) {
                int a = android.support.v4.b.a.a(-1, this.d, 4.5f);
                int a2 = android.support.v4.b.a.a(-1, this.d, 3.0f);
                if (a == -1 || a2 == -1) {
                    int a3 = android.support.v4.b.a.a(-16777216, this.d, 4.5f);
                    int a4 = android.support.v4.b.a.a(-16777216, this.d, 3.0f);
                    if (a3 == -1 || a3 == -1) {
                        if (a != -1) {
                            a = android.support.v4.b.a.c(-1, a);
                        } else {
                            a = android.support.v4.b.a.c(-16777216, a3);
                        }
                        this.h = a;
                        if (a2 != -1) {
                            a = android.support.v4.b.a.c(-1, a2);
                        } else {
                            a = android.support.v4.b.a.c(-16777216, a4);
                        }
                        this.g = a;
                        this.f = true;
                        return;
                    }
                    this.h = android.support.v4.b.a.c(-16777216, a3);
                    this.g = android.support.v4.b.a.c(-16777216, a4);
                    this.f = true;
                    return;
                }
                this.h = android.support.v4.b.a.c(-1, a);
                this.g = android.support.v4.b.a.c(-1, a2);
                this.f = true;
            }
        }

        public String toString() {
            return new StringBuilder(getClass().getSimpleName()).append(" [RGB: #").append(Integer.toHexString(a())).append(']').append(" [HSL: ").append(Arrays.toString(b())).append(']').append(" [Population: ").append(this.e).append(']').append(" [Title Text: #").append(Integer.toHexString(d())).append(']').append(" [Body Text: #").append(Integer.toHexString(e())).append(']').toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.e == cVar.e && this.d == cVar.d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.d * 31) + this.e;
        }
    }

    private b(List<c> list, List<c> list2) {
        this.a = list;
        this.b = list2;
        this.d = new SparseBooleanArray();
        this.c = new android.support.v4.e.a();
        this.e = c();
    }

    public int a(int i) {
        return a(c.b, i);
    }

    public c a(c cVar) {
        return (c) this.c.get(cVar);
    }

    public int a(c cVar, int i) {
        c a = a(cVar);
        return a != null ? a.a() : i;
    }

    private void b() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            c cVar = (c) this.b.get(i);
            cVar.k();
            this.c.put(cVar, b(cVar));
        }
        this.d.clear();
    }

    private c b(c cVar) {
        c c = c(cVar);
        if (c != null && cVar.j()) {
            this.d.append(c.a(), true);
        }
        return c;
    }

    private c c(c cVar) {
        float f = 0.0f;
        c cVar2 = null;
        int size = this.a.size();
        int i = 0;
        while (i < size) {
            float f2;
            c cVar3 = (c) this.a.get(i);
            if (a(cVar3, cVar)) {
                float b = b(cVar3, cVar);
                if (cVar2 == null || b > f) {
                    f2 = b;
                    i++;
                    f = f2;
                    cVar2 = cVar3;
                }
            }
            cVar3 = cVar2;
            f2 = f;
            i++;
            f = f2;
            cVar2 = cVar3;
        }
        return cVar2;
    }

    private boolean a(c cVar, c cVar2) {
        float[] b = cVar.b();
        if (b[1] < cVar2.a() || b[1] > cVar2.c() || b[2] < cVar2.d() || b[2] > cVar2.f() || this.d.get(cVar.a())) {
            return false;
        }
        return true;
    }

    private float b(c cVar, c cVar2) {
        float g;
        float abs;
        float f = 0.0f;
        float[] b = cVar.b();
        if (cVar2.g() > 0.0f) {
            g = cVar2.g() * (1.0f - Math.abs(b[1] - cVar2.b()));
        } else {
            g = 0.0f;
        }
        if (cVar2.h() > 0.0f) {
            abs = (1.0f - Math.abs(b[2] - cVar2.e())) * cVar2.h();
        } else {
            abs = 0.0f;
        }
        if (cVar2.i() > 0.0f) {
            f = cVar2.i() * (((float) cVar.c()) / ((float) this.e));
        }
        return (g + abs) + f;
    }

    private int c() {
        int size = this.a.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(((c) this.a.get(i2)).c(), i);
        }
        return i;
    }
}
