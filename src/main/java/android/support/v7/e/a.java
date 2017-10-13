package android.support.v7.e;

import android.graphics.Color;
import android.support.v7.e.b.b;
import android.support.v7.e.b.c;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

final class a {
    private static final Comparator<a> g = new Comparator<a>() {
        public /* synthetic */ int compare(Object obj, Object obj2) {
            return a((a) obj, (a) obj2);
        }

        public int a(a aVar, a aVar2) {
            return aVar2.a() - aVar.a();
        }
    };
    final int[] a;
    final int[] b;
    final List<c> c;
    final TimingLogger d = null;
    final b[] e;
    private final float[] f = new float[3];

    private class a {
        final /* synthetic */ a a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;

        a(a aVar, int i, int i2) {
            this.a = aVar;
            this.b = i;
            this.c = i2;
            d();
        }

        final int a() {
            return (((this.f - this.e) + 1) * ((this.h - this.g) + 1)) * ((this.j - this.i) + 1);
        }

        final boolean b() {
            return c() > 1;
        }

        final int c() {
            return (this.c + 1) - this.b;
        }

        final void d() {
            int[] iArr = this.a.a;
            int[] iArr2 = this.a.b;
            int i = Integer.MIN_VALUE;
            int i2 = 0;
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MIN_VALUE;
            for (int i8 = this.b; i8 <= this.c; i8++) {
                int i9 = iArr[i8];
                i2 += iArr2[i9];
                int a = a.h(i9);
                int b = a.i(i9);
                i9 = a.j(i9);
                if (a > i3) {
                    i3 = a;
                }
                if (a < i6) {
                    i6 = a;
                }
                if (b > i7) {
                    i7 = b;
                }
                if (b < i5) {
                    i5 = b;
                }
                if (i9 > i) {
                    i = i9;
                }
                if (i9 < i4) {
                    i4 = i9;
                }
            }
            this.e = i6;
            this.f = i3;
            this.g = i5;
            this.h = i7;
            this.i = i4;
            this.j = i;
            this.d = i2;
        }

        final a e() {
            if (b()) {
                int g = g();
                a aVar = new a(this.a, g + 1, this.c);
                this.c = g;
                d();
                return aVar;
            }
            throw new IllegalStateException("Can not split a box with only 1 color");
        }

        final int f() {
            int i = this.f - this.e;
            int i2 = this.h - this.g;
            int i3 = this.j - this.i;
            if (i >= i2 && i >= i3) {
                return -3;
            }
            if (i2 < i || i2 < i3) {
                return -1;
            }
            return -2;
        }

        final int g() {
            int f = f();
            int[] iArr = this.a.a;
            int[] iArr2 = this.a.b;
            a.b(iArr, f, this.b, this.c);
            Arrays.sort(iArr, this.b, this.c + 1);
            a.b(iArr, f, this.b, this.c);
            int i = this.d / 2;
            f = 0;
            for (int i2 = this.b; i2 <= this.c; i2++) {
                f += iArr2[iArr[i2]];
                if (f >= i) {
                    return i2;
                }
            }
            return this.b;
        }

        final c h() {
            int i = 0;
            int[] iArr = this.a.a;
            int[] iArr2 = this.a.b;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = this.b; i5 <= this.c; i5++) {
                int i6 = iArr[i5];
                int i7 = iArr2[i6];
                i += i7;
                i4 += a.h(i6) * i7;
                i3 += a.i(i6) * i7;
                i2 += a.j(i6) * i7;
            }
            return new c(a.b(Math.round(((float) i4) / ((float) i)), Math.round(((float) i3) / ((float) i)), Math.round(((float) i2) / ((float) i))), i);
        }
    }

    a(int[] iArr, int i, b[] bVarArr) {
        int i2;
        int f;
        int i3 = 0;
        this.e = bVarArr;
        int[] iArr2 = new int[32768];
        this.b = iArr2;
        for (i2 = 0; i2 < iArr.length; i2++) {
            f = f(iArr[i2]);
            iArr[i2] = f;
            iArr2[f] = iArr2[f] + 1;
        }
        i2 = 0;
        f = 0;
        while (i2 < iArr2.length) {
            if (iArr2[i2] > 0 && e(i2)) {
                iArr2[i2] = 0;
            }
            if (iArr2[i2] > 0) {
                f++;
            }
            i2++;
        }
        int[] iArr3 = new int[f];
        this.a = iArr3;
        int i4 = 0;
        for (i2 = 0; i2 < iArr2.length; i2++) {
            if (iArr2[i2] > 0) {
                int i5 = i4 + 1;
                iArr3[i4] = i2;
                i4 = i5;
            }
        }
        if (f <= i) {
            this.c = new ArrayList();
            i2 = iArr3.length;
            while (i3 < i2) {
                f = iArr3[i3];
                this.c.add(new c(g(f), iArr2[f]));
                i3++;
            }
            return;
        }
        this.c = d(i);
    }

    List<c> a() {
        return this.c;
    }

    private List<c> d(int i) {
        Collection priorityQueue = new PriorityQueue(i, g);
        priorityQueue.offer(new a(this, 0, this.a.length - 1));
        a((PriorityQueue) priorityQueue, i);
        return a(priorityQueue);
    }

    private void a(PriorityQueue<a> priorityQueue, int i) {
        while (priorityQueue.size() < i) {
            a aVar = (a) priorityQueue.poll();
            if (aVar != null && aVar.b()) {
                priorityQueue.offer(aVar.e());
                priorityQueue.offer(aVar);
            } else {
                return;
            }
        }
    }

    private List<c> a(Collection<a> collection) {
        List arrayList = new ArrayList(collection.size());
        for (a h : collection) {
            c h2 = h.h();
            if (!a(h2)) {
                arrayList.add(h2);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(int[] r3, int r4, int r5, int r6) {
        /*
        switch(r4) {
            case -3: goto L_0x0003;
            case -2: goto L_0x0004;
            case -1: goto L_0x001f;
            default: goto L_0x0003;
        };
    L_0x0003:
        return;
    L_0x0004:
        if (r5 > r6) goto L_0x0003;
    L_0x0006:
        r0 = r3[r5];
        r1 = i(r0);
        r1 = r1 << 10;
        r2 = h(r0);
        r2 = r2 << 5;
        r1 = r1 | r2;
        r0 = j(r0);
        r0 = r0 | r1;
        r3[r5] = r0;
        r5 = r5 + 1;
        goto L_0x0004;
    L_0x001f:
        if (r5 > r6) goto L_0x0003;
    L_0x0021:
        r0 = r3[r5];
        r1 = j(r0);
        r1 = r1 << 10;
        r2 = i(r0);
        r2 = r2 << 5;
        r1 = r1 | r2;
        r0 = h(r0);
        r0 = r0 | r1;
        r3[r5] = r0;
        r5 = r5 + 1;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.e.a.b(int[], int, int, int):void");
    }

    private boolean e(int i) {
        int g = g(i);
        android.support.v4.b.a.a(g, this.f);
        return a(g, this.f);
    }

    private boolean a(c cVar) {
        return a(cVar.a(), cVar.b());
    }

    private boolean a(int i, float[] fArr) {
        if (this.e == null || this.e.length <= 0) {
            return false;
        }
        for (b a : this.e) {
            if (!a.a(i, fArr)) {
                return true;
            }
        }
        return false;
    }

    private static int f(int i) {
        return ((c(Color.red(i), 8, 5) << 10) | (c(Color.green(i), 8, 5) << 5)) | c(Color.blue(i), 8, 5);
    }

    private static int b(int i, int i2, int i3) {
        return Color.rgb(c(i, 5, 8), c(i2, 5, 8), c(i3, 5, 8));
    }

    private static int g(int i) {
        return b(h(i), i(i), j(i));
    }

    private static int h(int i) {
        return (i >> 10) & 31;
    }

    private static int i(int i) {
        return (i >> 5) & 31;
    }

    private static int j(int i) {
        return i & 31;
    }

    private static int c(int i, int i2, int i3) {
        int i4;
        if (i3 > i2) {
            i4 = (((1 << i3) - 1) * i) / ((1 << i2) - 1);
        } else {
            i4 = i >> (i2 - i3);
        }
        return i4 & ((1 << i3) - 1);
    }
}
