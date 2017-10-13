package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.a.c.l;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.r;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean a = false;
    int b = -1;
    int[] c;
    View[] d;
    final SparseIntArray e = new SparseIntArray();
    final SparseIntArray f = new SparseIntArray();
    c g = new a();
    final Rect h = new Rect();

    public static abstract class c {
        final SparseIntArray a = new SparseIntArray();
        private boolean b = false;

        public abstract int a(int i);

        public void a() {
            this.a.clear();
        }

        int b(int i, int i2) {
            if (!this.b) {
                return a(i, i2);
            }
            int i3 = this.a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            i3 = a(i, i2);
            this.a.put(i, i3);
            return i3;
        }

        public int a(int i, int i2) {
            int a = a(i);
            if (a == i2) {
                return 0;
            }
            int b;
            int a2;
            int i3;
            if (this.b && this.a.size() > 0) {
                b = b(i);
                if (b >= 0) {
                    a2 = this.a.get(b) + a(b);
                    b++;
                    i3 = b;
                    while (i3 < i) {
                        b = a(i3);
                        a2 += b;
                        if (a2 == i2) {
                            b = 0;
                        } else if (a2 <= i2) {
                            b = a2;
                        }
                        i3++;
                        a2 = b;
                    }
                    if (a2 + a > i2) {
                        return a2;
                    }
                    return 0;
                }
            }
            b = 0;
            a2 = 0;
            i3 = b;
            while (i3 < i) {
                b = a(i3);
                a2 += b;
                if (a2 == i2) {
                    b = 0;
                } else if (a2 <= i2) {
                    b = a2;
                }
                i3++;
                a2 = b;
            }
            if (a2 + a > i2) {
                return 0;
            }
            return a2;
        }

        int b(int i) {
            int i2 = 0;
            int size = this.a.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            size = i2 - 1;
            if (size < 0 || size >= this.a.size()) {
                return -1;
            }
            return this.a.keyAt(size);
        }

        public int c(int i, int i2) {
            int a = a(i);
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                int a2 = a(i3);
                i5 += a2;
                if (i5 == i2) {
                    i4++;
                    a2 = 0;
                } else if (i5 > i2) {
                    i4++;
                } else {
                    a2 = i5;
                }
                i3++;
                i5 = a2;
            }
            if (i5 + a > i2) {
                return i4 + 1;
            }
            return i4;
        }
    }

    public static final class a extends c {
        public int a(int i) {
            return 1;
        }

        public int a(int i, int i2) {
            return i % i2;
        }
    }

    public static class b extends i {
        private int e = -1;
        private int f = 0;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int a() {
            return this.e;
        }

        public int b() {
            return this.f;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(h.a(context, attributeSet, i, i2).b);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        a(i);
    }

    public void a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.a(false);
    }

    public int a(n nVar, r rVar) {
        if (this.i == 0) {
            return this.b;
        }
        if (rVar.e() < 1) {
            return 0;
        }
        return a(nVar, rVar, rVar.e() - 1) + 1;
    }

    public int b(n nVar, r rVar) {
        if (this.i == 1) {
            return this.b;
        }
        if (rVar.e() < 1) {
            return 0;
        }
        return a(nVar, rVar, rVar.e() - 1) + 1;
    }

    public void a(n nVar, r rVar, View view, android.support.v4.view.a.c cVar) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof b) {
            b bVar = (b) layoutParams;
            int a = a(nVar, rVar, bVar.e());
            if (this.i == 0) {
                int a2 = bVar.a();
                int b = bVar.b();
                boolean z = this.b > 1 && bVar.b() == this.b;
                cVar.b(l.a(a2, b, a, 1, z, false));
                return;
            }
            int a3 = bVar.a();
            int b2 = bVar.b();
            boolean z2 = this.b > 1 && bVar.b() == this.b;
            cVar.b(l.a(a, 1, a3, b2, z2, false));
            return;
        }
        super.a(view, cVar);
    }

    public void c(n nVar, r rVar) {
        if (rVar.a()) {
            J();
        }
        super.c(nVar, rVar);
        I();
    }

    public void a(r rVar) {
        super.a(rVar);
        this.a = false;
    }

    private void I() {
        this.e.clear();
        this.f.clear();
    }

    private void J() {
        int t = t();
        for (int i = 0; i < t; i++) {
            b bVar = (b) i(i).getLayoutParams();
            int e = bVar.e();
            this.e.put(e, bVar.b());
            this.f.put(e, bVar.a());
        }
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.g.a();
    }

    public void a(RecyclerView recyclerView) {
        this.g.a();
    }

    public void b(RecyclerView recyclerView, int i, int i2) {
        this.g.a();
    }

    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.g.a();
    }

    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.g.a();
    }

    public i a() {
        if (this.i == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    public i a(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    public i a(LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new b((MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    public boolean a(i iVar) {
        return iVar instanceof b;
    }

    public void a(c cVar) {
        this.g = cVar;
    }

    private void K() {
        int w;
        if (f() == 1) {
            w = (w() - A()) - y();
        } else {
            w = (x() - B()) - z();
        }
        m(w);
    }

    public void a(Rect rect, int i, int i2) {
        if (this.c == null) {
            super.a(rect, i, i2);
        }
        int A = A() + y();
        int z = z() + B();
        if (this.i == 1) {
            z = h.a(i2, z + rect.height(), E());
            A = h.a(i, A + this.c[this.c.length - 1], D());
        } else {
            A = h.a(i, A + rect.width(), D());
            z = h.a(i2, z + this.c[this.c.length - 1], E());
        }
        e(A, z);
    }

    private void m(int i) {
        this.c = a(this.c, this.b, i);
    }

    static int[] a(int[] iArr, int i, int i2) {
        int i3 = 0;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        iArr[0] = 0;
        int i4 = i2 / i;
        int i5 = i2 % i;
        int i6 = 0;
        for (int i7 = 1; i7 <= i; i7++) {
            int i8;
            i3 += i5;
            if (i3 <= 0 || i - i3 >= i5) {
                i8 = i4;
            } else {
                i8 = i4 + 1;
                i3 -= i;
            }
            i6 += i8;
            iArr[i7] = i6;
        }
        return iArr;
    }

    void a(n nVar, r rVar, a aVar, int i) {
        super.a(nVar, rVar, aVar, i);
        K();
        if (rVar.e() > 0 && !rVar.a()) {
            b(nVar, rVar, aVar, i);
        }
        L();
    }

    private void L() {
        if (this.d == null || this.d.length != this.b) {
            this.d = new View[this.b];
        }
    }

    public int a(int i, n nVar, r rVar) {
        K();
        L();
        return super.a(i, nVar, rVar);
    }

    public int b(int i, n nVar, r rVar) {
        K();
        L();
        return super.b(i, nVar, rVar);
    }

    private void b(n nVar, r rVar, a aVar, int i) {
        Object obj = 1;
        if (i != 1) {
            obj = null;
        }
        int b = b(nVar, rVar, aVar.a);
        if (obj != null) {
            while (b > 0 && aVar.a > 0) {
                aVar.a--;
                b = b(nVar, rVar, aVar.a);
            }
            return;
        }
        int e = rVar.e() - 1;
        int i2 = aVar.a;
        int i3 = b;
        while (i2 < e) {
            b = b(nVar, rVar, i2 + 1);
            if (b <= i3) {
                break;
            }
            i2++;
            i3 = b;
        }
        aVar.a = i2;
    }

    View a(n nVar, r rVar, int i, int i2, int i3) {
        View view = null;
        h();
        int c = this.j.c();
        int d = this.j.d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View i5 = i(i);
            int d2 = d(i5);
            if (d2 >= 0 && d2 < i3) {
                if (b(nVar, rVar, d2) != 0) {
                    view3 = view;
                    i5 = view2;
                } else if (((i) i5.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view3 = view;
                    }
                } else if (this.j.a(i5) < d && this.j.b(i5) >= c) {
                    return i5;
                } else {
                    if (view == null) {
                        view3 = i5;
                        i5 = view2;
                    }
                }
                i += i4;
                view = view3;
                view2 = i5;
            }
            view3 = view;
            i5 = view2;
            i += i4;
            view = view3;
            view2 = i5;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    private int a(n nVar, r rVar, int i) {
        if (!rVar.a()) {
            return this.g.c(i, this.b);
        }
        int b = nVar.b(i);
        if (b != -1) {
            return this.g.c(b, this.b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private int b(n nVar, r rVar, int i) {
        if (!rVar.a()) {
            return this.g.b(i, this.b);
        }
        int i2 = this.f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = nVar.b(i);
        if (i2 != -1) {
            return this.g.b(i2, this.b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private int c(n nVar, r rVar, int i) {
        if (!rVar.a()) {
            return this.g.a(i);
        }
        int i2 = this.e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = nVar.b(i);
        if (i2 != -1) {
            return this.g.a(i2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    void a(n nVar, r rVar, c cVar, b bVar) {
        int i = this.j.i();
        Object obj = i != 1073741824 ? 1 : null;
        int i2 = t() > 0 ? this.c[this.b] : 0;
        if (obj != null) {
            K();
        }
        boolean z = cVar.e == 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.b;
        if (!z) {
            i5 = b(nVar, rVar, cVar.d) + c(nVar, rVar, cVar.d);
        }
        while (i3 < this.b && cVar.a(rVar) && i5 > 0) {
            int i6 = cVar.d;
            int c = c(nVar, rVar, i6);
            if (c <= this.b) {
                i5 -= c;
                if (i5 >= 0) {
                    View a = cVar.a(nVar);
                    if (a == null) {
                        break;
                    }
                    i4 += c;
                    this.d[i3] = a;
                    i3++;
                } else {
                    break;
                }
            }
            throw new IllegalArgumentException("Item at position " + i6 + " requires " + c + " spans but GridLayoutManager has only " + this.b + " spans.");
        }
        if (i3 == 0) {
            bVar.b = true;
            return;
        }
        int a2;
        int a3;
        View view;
        int a4;
        int a5;
        a(nVar, rVar, i3, i4, z);
        int i7 = 0;
        float f = 0.0f;
        c = 0;
        while (i7 < i3) {
            View view2 = this.d[i7];
            if (cVar.k == null) {
                if (z) {
                    b(view2);
                } else {
                    b(view2, 0);
                }
            } else if (z) {
                a(view2);
            } else {
                a(view2, 0);
            }
            b bVar2 = (b) view2.getLayoutParams();
            a2 = h.a(this.c[bVar2.e + bVar2.f] - this.c[bVar2.e], i, 0, this.i == 0 ? bVar2.height : bVar2.width, false);
            a3 = h.a(this.j.f(), this.j.h(), 0, this.i == 1 ? bVar2.height : bVar2.width, true);
            if (this.i == 1) {
                a(view2, a2, a3, bVar2.height == -1, false);
            } else {
                a(view2, a3, a2, bVar2.width == -1, false);
            }
            i6 = this.j.e(view2);
            if (i6 <= c) {
                i6 = c;
            }
            float f2 = (1.0f * ((float) this.j.f(view2))) / ((float) bVar2.f);
            if (f2 <= f) {
                f2 = f;
            }
            i7++;
            f = f2;
            c = i6;
        }
        if (obj != null) {
            a(f, i2);
            c = 0;
            int i8 = 0;
            while (i8 < i3) {
                view = this.d[i8];
                bVar2 = (b) view.getLayoutParams();
                a4 = h.a(this.c[bVar2.e + bVar2.f] - this.c[bVar2.e], 1073741824, 0, this.i == 0 ? bVar2.height : bVar2.width, false);
                a5 = h.a(this.j.f(), this.j.h(), 0, this.i == 1 ? bVar2.height : bVar2.width, true);
                if (this.i == 1) {
                    a(view, a4, a5, false, true);
                } else {
                    a(view, a5, a4, false, true);
                }
                i5 = this.j.e(view);
                if (i5 <= c) {
                    i5 = c;
                }
                i8++;
                c = i5;
            }
        }
        a5 = MeasureSpec.makeMeasureSpec(c, 1073741824);
        for (i6 = 0; i6 < i3; i6++) {
            view = this.d[i6];
            if (this.j.e(view) != c) {
                bVar2 = (b) view.getLayoutParams();
                a4 = h.a(this.c[bVar2.e + bVar2.f] - this.c[bVar2.e], 1073741824, 0, this.i == 0 ? bVar2.height : bVar2.width, false);
                if (this.i == 1) {
                    a(view, a4, a5, true, true);
                } else {
                    a(view, a5, a4, true, true);
                }
            }
        }
        bVar.a = c;
        i6 = 0;
        i5 = 0;
        if (this.i == 1) {
            if (cVar.f == -1) {
                i5 = cVar.b;
                i6 = i5 - c;
                c = 0;
                i4 = 0;
            } else {
                i6 = cVar.b;
                i5 = i6 + c;
                c = 0;
                i4 = 0;
            }
        } else if (cVar.f == -1) {
            i4 = cVar.b;
            int i9 = i4;
            i4 -= c;
            c = i9;
        } else {
            i4 = cVar.b;
            c += i4;
        }
        a3 = i5;
        a5 = i6;
        a2 = c;
        a4 = i4;
        for (i6 = 0; i6 < i3; i6++) {
            view = this.d[i6];
            bVar2 = (b) view.getLayoutParams();
            if (this.i != 1) {
                a5 = z() + this.c[bVar2.e];
                a3 = a5 + this.j.f(view);
            } else if (g()) {
                a2 = y() + this.c[bVar2.e + bVar2.f];
                a4 = a2 - this.j.f(view);
            } else {
                a4 = y() + this.c[bVar2.e];
                a2 = a4 + this.j.f(view);
            }
            a(view, a4, a5, a2, a3);
            if (bVar2.c() || bVar2.d()) {
                bVar.c = true;
            }
            bVar.d |= view.isFocusable();
        }
        Arrays.fill(this.d, null);
    }

    private void a(float f, int i) {
        m(Math.max(Math.round(((float) this.b) * f), i));
    }

    private void a(View view, int i, int i2, boolean z, boolean z2) {
        boolean a;
        b(view, this.h);
        i iVar = (i) view.getLayoutParams();
        if (z || this.i == 1) {
            i = b(i, iVar.leftMargin + this.h.left, iVar.rightMargin + this.h.right);
        }
        if (z || this.i == 0) {
            i2 = b(i2, iVar.topMargin + this.h.top, iVar.bottomMargin + this.h.bottom);
        }
        if (z2) {
            a = a(view, i, i2, iVar);
        } else {
            a = b(view, i, i2, iVar);
        }
        if (a) {
            view.measure(i, i2);
        }
    }

    private int b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    private void a(n nVar, r rVar, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i3 = 1;
            i4 = 0;
        } else {
            i4 = i - 1;
            i3 = -1;
            i = -1;
        }
        if (this.i == 1 && g()) {
            i5 = this.b - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i7 = i5;
        for (i5 = i4; i5 != i; i5 += i3) {
            View view = this.d[i5];
            b bVar = (b) view.getLayoutParams();
            bVar.f = c(nVar, rVar, d(view));
            if (i6 != -1 || bVar.f <= 1) {
                bVar.e = i7;
            } else {
                bVar.e = i7 - (bVar.f - 1);
            }
            i7 += bVar.f * i6;
        }
    }

    public void a(int i) {
        if (i != this.b) {
            this.a = true;
            if (i < 1) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.b = i;
            this.g.a();
            n();
        }
    }

    public View a(View view, int i, n nVar, r rVar) {
        View e = e(view);
        if (e == null) {
            return null;
        }
        b bVar = (b) e.getLayoutParams();
        int a = bVar.e;
        int a2 = bVar.e + bVar.f;
        if (super.a(view, i, nVar, rVar) == null) {
            return null;
        }
        int t;
        int i2;
        int i3;
        if (((f(i) == 1) != this.k ? 1 : null) != null) {
            t = t() - 1;
            i2 = -1;
            i3 = -1;
        } else {
            t = 0;
            i2 = 1;
            i3 = t();
        }
        Object obj = (this.i == 1 && g()) ? 1 : null;
        View view2 = null;
        int i4 = -1;
        int i5 = 0;
        int i6 = t;
        while (i6 != i3) {
            View i7 = i(i6);
            if (i7 == e) {
                break;
            }
            View view3;
            if (i7.isFocusable()) {
                bVar = (b) i7.getLayoutParams();
                int a3 = bVar.e;
                int a4 = bVar.e + bVar.f;
                if (a3 == a && a4 == a2) {
                    return i7;
                }
                Object obj2 = null;
                if (view2 == null) {
                    obj2 = 1;
                } else {
                    int min = Math.min(a4, a2) - Math.max(a3, a);
                    if (min > i5) {
                        obj2 = 1;
                    } else if (min == i5) {
                        if (obj == (a3 > i4 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                }
                if (obj2 != null) {
                    i5 = bVar.e;
                    t = Math.min(a4, a2) - Math.max(a3, a);
                    view3 = i7;
                } else {
                    t = i5;
                    i5 = i4;
                    view3 = view2;
                }
            } else {
                t = i5;
                i5 = i4;
                view3 = view2;
            }
            i6 += i2;
            view2 = view3;
            i4 = i5;
            i5 = t;
        }
        return view2;
    }

    public boolean b() {
        return this.n == null && !this.a;
    }
}
