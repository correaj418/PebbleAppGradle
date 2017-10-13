package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.k;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.u;
import android.support.v7.widget.a.a.d;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends h implements d {
    private c a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    int i;
    ak j;
    boolean k;
    int l;
    int m;
    SavedState n;
    final a o;

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return a(i);
            }

            public SavedState a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] a(int i) {
                return new SavedState[i];
            }
        };
        int a;
        int b;
        boolean c;

        SavedState(Parcel parcel) {
            boolean z = true;
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.c = z;
        }

        public SavedState(SavedState savedState) {
            this.a = savedState.a;
            this.b = savedState.b;
            this.c = savedState.c;
        }

        boolean a() {
            return this.a >= 0;
        }

        void b() {
            this.a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }
    }

    class a {
        int a;
        int b;
        boolean c;
        boolean d;
        final /* synthetic */ LinearLayoutManager e;

        a(LinearLayoutManager linearLayoutManager) {
            this.e = linearLayoutManager;
            a();
        }

        void a() {
            this.a = -1;
            this.b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
        }

        void b() {
            int d;
            if (this.c) {
                d = this.e.j.d();
            } else {
                d = this.e.j.c();
            }
            this.b = d;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.a + ", mCoordinate=" + this.b + ", mLayoutFromEnd=" + this.c + ", mValid=" + this.d + '}';
        }

        private boolean a(View view, r rVar) {
            i iVar = (i) view.getLayoutParams();
            return !iVar.c() && iVar.e() >= 0 && iVar.e() < rVar.e();
        }

        public void a(View view) {
            int b = this.e.j.b();
            if (b >= 0) {
                b(view);
                return;
            }
            this.a = this.e.d(view);
            int e;
            if (this.c) {
                b = (this.e.j.d() - b) - this.e.j.b(view);
                this.b = this.e.j.d() - b;
                if (b > 0) {
                    e = this.b - this.e.j.e(view);
                    int c = this.e.j.c();
                    e -= c + Math.min(this.e.j.a(view) - c, 0);
                    if (e < 0) {
                        this.b = Math.min(b, -e) + this.b;
                        return;
                    }
                    return;
                }
                return;
            }
            e = this.e.j.a(view);
            c = e - this.e.j.c();
            this.b = e;
            if (c > 0) {
                b = (this.e.j.d() - Math.min(0, (this.e.j.d() - b) - this.e.j.b(view))) - (e + this.e.j.e(view));
                if (b < 0) {
                    this.b -= Math.min(c, -b);
                }
            }
        }

        public void b(View view) {
            if (this.c) {
                this.b = this.e.j.b(view) + this.e.j.b();
            } else {
                this.b = this.e.j.a(view);
            }
            this.a = this.e.d(view);
        }
    }

    protected static class b {
        public int a;
        public boolean b;
        public boolean c;
        public boolean d;

        protected b() {
        }

        void a() {
            this.a = 0;
            this.b = false;
            this.c = false;
            this.d = false;
        }
    }

    static class c {
        boolean a = true;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h = 0;
        boolean i = false;
        int j;
        List<u> k = null;
        boolean l;

        c() {
        }

        boolean a(r rVar) {
            return this.d >= 0 && this.d < rVar.e();
        }

        View a(n nVar) {
            if (this.k != null) {
                return b();
            }
            View c = nVar.c(this.d);
            this.d += this.e;
            return c;
        }

        private View b() {
            int size = this.k.size();
            for (int i = 0; i < size; i++) {
                View view = ((u) this.k.get(i)).a;
                i iVar = (i) view.getLayoutParams();
                if (!iVar.c() && this.d == iVar.e()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            a(null);
        }

        public void a(View view) {
            View b = b(view);
            if (b == null) {
                this.d = -1;
            } else {
                this.d = ((i) b.getLayoutParams()).e();
            }
        }

        public View b(View view) {
            int size = this.k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            while (i2 < size) {
                int i3;
                View view3;
                View view4 = ((u) this.k.get(i2)).a;
                i iVar = (i) view4.getLayoutParams();
                if (view4 != view) {
                    if (iVar.c()) {
                        i3 = i;
                        view3 = view2;
                    } else {
                        i3 = (iVar.e() - this.d) * this.e;
                        if (i3 < 0) {
                            i3 = i;
                            view3 = view2;
                        } else if (i3 < i) {
                            if (i3 == 0) {
                                return view4;
                            }
                            view3 = view4;
                        }
                    }
                    i2++;
                    view2 = view3;
                    i = i3;
                }
                i3 = i;
                view3 = view2;
                i2++;
                view2 = view3;
                i = i3;
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.c = false;
        this.k = false;
        this.d = false;
        this.e = true;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.n = null;
        this.o = new a(this);
        b(i);
        b(z);
        c(true);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.c = false;
        this.k = false;
        this.d = false;
        this.e = true;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.n = null;
        this.o = new a(this);
        android.support.v7.widget.RecyclerView.h.a a = h.a(context, attributeSet, i, i2);
        b(a.a);
        b(a.c);
        a(a.d);
        c(true);
    }

    public i a() {
        return new i(-2, -2);
    }

    public void a(RecyclerView recyclerView, n nVar) {
        super.a(recyclerView, nVar);
        if (this.f) {
            c(nVar);
            nVar.a();
        }
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (t() > 0) {
            k a = android.support.v4.view.a.a.a(accessibilityEvent);
            a.b(l());
            a.c(m());
        }
    }

    public Parcelable c() {
        if (this.n != null) {
            return new SavedState(this.n);
        }
        Parcelable savedState = new SavedState();
        if (t() > 0) {
            h();
            boolean z = this.b ^ this.k;
            savedState.c = z;
            View K;
            if (z) {
                K = K();
                savedState.b = this.j.d() - this.j.b(K);
                savedState.a = d(K);
                return savedState;
            }
            K = J();
            savedState.a = d(K);
            savedState.b = this.j.a(K) - this.j.c();
            return savedState;
        }
        savedState.b();
        return savedState;
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.n = (SavedState) parcelable;
            n();
        }
    }

    public boolean d() {
        return this.i == 0;
    }

    public boolean e() {
        return this.i == 1;
    }

    public void a(boolean z) {
        a(null);
        if (this.d != z) {
            this.d = z;
            n();
        }
    }

    public int f() {
        return this.i;
    }

    public void b(int i) {
        if (i == 0 || i == 1) {
            a(null);
            if (i != this.i) {
                this.i = i;
                this.j = null;
                n();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    private void I() {
        boolean z = true;
        if (this.i == 1 || !g()) {
            this.k = this.c;
            return;
        }
        if (this.c) {
            z = false;
        }
        this.k = z;
    }

    public void b(boolean z) {
        a(null);
        if (z != this.c) {
            this.c = z;
            n();
        }
    }

    public View c(int i) {
        int t = t();
        if (t == 0) {
            return null;
        }
        int d = i - d(i(0));
        if (d >= 0 && d < t) {
            View i2 = i(d);
            if (d(i2) == i) {
                return i2;
            }
        }
        return super.c(i);
    }

    protected int b(r rVar) {
        if (rVar.d()) {
            return this.j.f();
        }
        return 0;
    }

    public void a(RecyclerView recyclerView, r rVar, int i) {
        q anonymousClass1 = new ae(this, recyclerView.getContext()) {
            final /* synthetic */ LinearLayoutManager a;

            public PointF a(int i) {
                return this.a.d(i);
            }
        };
        anonymousClass1.d(i);
        a(anonymousClass1);
    }

    public PointF d(int i) {
        int i2 = 1;
        boolean z = false;
        if (t() == 0) {
            return null;
        }
        if (i < d(i(0))) {
            z = true;
        }
        if (z != this.k) {
            i2 = -1;
        }
        if (this.i == 0) {
            return new PointF((float) i2, 0.0f);
        }
        return new PointF(0.0f, (float) i2);
    }

    public void c(n nVar, r rVar) {
        int i = -1;
        if (!(this.n == null && this.l == -1) && rVar.e() == 0) {
            c(nVar);
            return;
        }
        int i2;
        int d;
        if (this.n != null && this.n.a()) {
            this.l = this.n.a;
        }
        h();
        this.a.a = false;
        I();
        if (!(this.o.d && this.l == -1 && this.n == null)) {
            this.o.a();
            this.o.c = this.k ^ this.d;
            a(nVar, rVar, this.o);
            this.o.d = true;
        }
        int b = b(rVar);
        if (this.a.j >= 0) {
            i2 = 0;
        } else {
            i2 = b;
            b = 0;
        }
        i2 += this.j.c();
        b += this.j.g();
        if (!(!rVar.a() || this.l == -1 || this.m == Integer.MIN_VALUE)) {
            View c = c(this.l);
            if (c != null) {
                if (this.k) {
                    d = (this.j.d() - this.j.b(c)) - this.m;
                } else {
                    d = this.m - (this.j.a(c) - this.j.c());
                }
                if (d > 0) {
                    i2 += d;
                } else {
                    b -= d;
                }
            }
        }
        if (this.o.c) {
            if (this.k) {
                i = 1;
            }
        } else if (!this.k) {
            i = 1;
        }
        a(nVar, rVar, this.o, i);
        a(nVar);
        this.a.l = j();
        this.a.i = rVar.a();
        if (this.o.c) {
            b(this.o);
            this.a.h = i2;
            a(nVar, this.a, rVar, false);
            i2 = this.a.b;
            d = this.a.d;
            if (this.a.c > 0) {
                b += this.a.c;
            }
            a(this.o);
            this.a.h = b;
            c cVar = this.a;
            cVar.d += this.a.e;
            a(nVar, this.a, rVar, false);
            i = this.a.b;
            if (this.a.c > 0) {
                b = this.a.c;
                g(d, i2);
                this.a.h = b;
                a(nVar, this.a, rVar, false);
                b = this.a.b;
            } else {
                b = i2;
            }
            i2 = b;
            b = i;
        } else {
            a(this.o);
            this.a.h = b;
            a(nVar, this.a, rVar, false);
            b = this.a.b;
            i = this.a.d;
            if (this.a.c > 0) {
                i2 += this.a.c;
            }
            b(this.o);
            this.a.h = i2;
            c cVar2 = this.a;
            cVar2.d += this.a.e;
            a(nVar, this.a, rVar, false);
            i2 = this.a.b;
            if (this.a.c > 0) {
                d = this.a.c;
                f(i, b);
                this.a.h = d;
                a(nVar, this.a, rVar, false);
                b = this.a.b;
            }
        }
        if (t() > 0) {
            int b2;
            if ((this.k ^ this.d) != 0) {
                i = a(b, nVar, rVar, true);
                i2 += i;
                b += i;
                b2 = b(i2, nVar, rVar, false);
                i2 += b2;
                b += b2;
            } else {
                i = b(i2, nVar, rVar, true);
                i2 += i;
                b += i;
                b2 = a(b, nVar, rVar, false);
                i2 += b2;
                b += b2;
            }
        }
        b(nVar, rVar, i2, b);
        if (rVar.a()) {
            this.o.a();
        } else {
            this.j.a();
        }
        this.b = this.d;
    }

    public void a(r rVar) {
        super.a(rVar);
        this.n = null;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.o.a();
    }

    void a(n nVar, r rVar, a aVar, int i) {
    }

    private void b(n nVar, r rVar, int i, int i2) {
        if (rVar.b() && t() != 0 && !rVar.a() && b()) {
            int i3 = 0;
            int i4 = 0;
            List b = nVar.b();
            int size = b.size();
            int d = d(i(0));
            int i5 = 0;
            while (i5 < size) {
                int i6;
                int i7;
                u uVar = (u) b.get(i5);
                if (uVar.q()) {
                    i6 = i4;
                    i7 = i3;
                } else {
                    if (((uVar.d() < d) != this.k ? -1 : 1) == -1) {
                        i7 = this.j.e(uVar.a) + i3;
                        i6 = i4;
                    } else {
                        i6 = this.j.e(uVar.a) + i4;
                        i7 = i3;
                    }
                }
                i5++;
                i3 = i7;
                i4 = i6;
            }
            this.a.k = b;
            if (i3 > 0) {
                g(d(J()), i);
                this.a.h = i3;
                this.a.c = 0;
                this.a.a();
                a(nVar, this.a, rVar, false);
            }
            if (i4 > 0) {
                f(d(K()), i2);
                this.a.h = i4;
                this.a.c = 0;
                this.a.a();
                a(nVar, this.a, rVar, false);
            }
            this.a.k = null;
        }
    }

    private void a(n nVar, r rVar, a aVar) {
        if (!a(rVar, aVar) && !b(nVar, rVar, aVar)) {
            aVar.b();
            aVar.a = this.d ? rVar.e() - 1 : 0;
        }
    }

    private boolean b(n nVar, r rVar, a aVar) {
        boolean z = false;
        if (t() == 0) {
            return false;
        }
        View C = C();
        if (C != null && aVar.a(C, rVar)) {
            aVar.a(C);
            return true;
        } else if (this.b != this.d) {
            return false;
        } else {
            if (aVar.c) {
                C = f(nVar, rVar);
            } else {
                C = g(nVar, rVar);
            }
            if (C == null) {
                return false;
            }
            aVar.b(C);
            if (!rVar.a() && b()) {
                if (this.j.a(C) >= this.j.d() || this.j.b(C) < this.j.c()) {
                    z = true;
                }
                if (z) {
                    int d;
                    if (aVar.c) {
                        d = this.j.d();
                    } else {
                        d = this.j.c();
                    }
                    aVar.b = d;
                }
            }
            return true;
        }
    }

    private boolean a(r rVar, a aVar) {
        boolean z = false;
        if (rVar.a() || this.l == -1) {
            return false;
        }
        if (this.l < 0 || this.l >= rVar.e()) {
            this.l = -1;
            this.m = Integer.MIN_VALUE;
            return false;
        }
        aVar.a = this.l;
        if (this.n != null && this.n.a()) {
            aVar.c = this.n.c;
            if (aVar.c) {
                aVar.b = this.j.d() - this.n.b;
                return true;
            }
            aVar.b = this.j.c() + this.n.b;
            return true;
        } else if (this.m == Integer.MIN_VALUE) {
            View c = c(this.l);
            if (c == null) {
                if (t() > 0) {
                    boolean z2;
                    if (this.l < d(i(0))) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 == this.k) {
                        z = true;
                    }
                    aVar.c = z;
                }
                aVar.b();
                return true;
            } else if (this.j.e(c) > this.j.f()) {
                aVar.b();
                return true;
            } else if (this.j.a(c) - this.j.c() < 0) {
                aVar.b = this.j.c();
                aVar.c = false;
                return true;
            } else if (this.j.d() - this.j.b(c) < 0) {
                aVar.b = this.j.d();
                aVar.c = true;
                return true;
            } else {
                int b;
                if (aVar.c) {
                    b = this.j.b(c) + this.j.b();
                } else {
                    b = this.j.a(c);
                }
                aVar.b = b;
                return true;
            }
        } else {
            aVar.c = this.k;
            if (this.k) {
                aVar.b = this.j.d() - this.m;
                return true;
            }
            aVar.b = this.j.c() + this.m;
            return true;
        }
    }

    private int a(int i, n nVar, r rVar, boolean z) {
        int d = this.j.d() - i;
        if (d <= 0) {
            return 0;
        }
        d = -c(-d, nVar, rVar);
        int i2 = i + d;
        if (!z) {
            return d;
        }
        i2 = this.j.d() - i2;
        if (i2 <= 0) {
            return d;
        }
        this.j.a(i2);
        return d + i2;
    }

    private int b(int i, n nVar, r rVar, boolean z) {
        int c = i - this.j.c();
        if (c <= 0) {
            return 0;
        }
        c = -c(c, nVar, rVar);
        int i2 = i + c;
        if (!z) {
            return c;
        }
        i2 -= this.j.c();
        if (i2 <= 0) {
            return c;
        }
        this.j.a(-i2);
        return c - i2;
    }

    private void a(a aVar) {
        f(aVar.a, aVar.b);
    }

    private void f(int i, int i2) {
        this.a.c = this.j.d() - i2;
        this.a.e = this.k ? -1 : 1;
        this.a.d = i;
        this.a.f = 1;
        this.a.b = i2;
        this.a.g = Integer.MIN_VALUE;
    }

    private void b(a aVar) {
        g(aVar.a, aVar.b);
    }

    private void g(int i, int i2) {
        this.a.c = i2 - this.j.c();
        this.a.d = i;
        this.a.e = this.k ? 1 : -1;
        this.a.f = -1;
        this.a.b = i2;
        this.a.g = Integer.MIN_VALUE;
    }

    protected boolean g() {
        return r() == 1;
    }

    void h() {
        if (this.a == null) {
            this.a = i();
        }
        if (this.j == null) {
            this.j = ak.a(this, this.i);
        }
    }

    c i() {
        return new c();
    }

    public void e(int i) {
        this.l = i;
        this.m = Integer.MIN_VALUE;
        if (this.n != null) {
            this.n.b();
        }
        n();
    }

    public void a(int i, int i2) {
        this.l = i;
        this.m = i2;
        if (this.n != null) {
            this.n.b();
        }
        n();
    }

    public int a(int i, n nVar, r rVar) {
        if (this.i == 1) {
            return 0;
        }
        return c(i, nVar, rVar);
    }

    public int b(int i, n nVar, r rVar) {
        if (this.i == 0) {
            return 0;
        }
        return c(i, nVar, rVar);
    }

    public int c(r rVar) {
        return i(rVar);
    }

    public int d(r rVar) {
        return i(rVar);
    }

    public int e(r rVar) {
        return j(rVar);
    }

    public int f(r rVar) {
        return j(rVar);
    }

    public int g(r rVar) {
        return k(rVar);
    }

    public int h(r rVar) {
        return k(rVar);
    }

    private int i(r rVar) {
        boolean z = false;
        if (t() == 0) {
            return 0;
        }
        h();
        ak akVar = this.j;
        View a = a(!this.e, true);
        if (!this.e) {
            z = true;
        }
        return aq.a(rVar, akVar, a, b(z, true), this, this.e, this.k);
    }

    private int j(r rVar) {
        boolean z = false;
        if (t() == 0) {
            return 0;
        }
        h();
        ak akVar = this.j;
        View a = a(!this.e, true);
        if (!this.e) {
            z = true;
        }
        return aq.a(rVar, akVar, a, b(z, true), this, this.e);
    }

    private int k(r rVar) {
        boolean z = false;
        if (t() == 0) {
            return 0;
        }
        h();
        ak akVar = this.j;
        View a = a(!this.e, true);
        if (!this.e) {
            z = true;
        }
        return aq.b(rVar, akVar, a, b(z, true), this, this.e);
    }

    private void a(int i, int i2, boolean z, r rVar) {
        int i3 = -1;
        int i4 = 1;
        this.a.l = j();
        this.a.h = b(rVar);
        this.a.f = i;
        View K;
        c cVar;
        if (i == 1) {
            c cVar2 = this.a;
            cVar2.h += this.j.g();
            K = K();
            cVar = this.a;
            if (!this.k) {
                i3 = 1;
            }
            cVar.e = i3;
            this.a.d = d(K) + this.a.e;
            this.a.b = this.j.b(K);
            i3 = this.j.b(K) - this.j.d();
        } else {
            K = J();
            cVar = this.a;
            cVar.h += this.j.c();
            cVar = this.a;
            if (!this.k) {
                i4 = -1;
            }
            cVar.e = i4;
            this.a.d = d(K) + this.a.e;
            this.a.b = this.j.a(K);
            i3 = (-this.j.a(K)) + this.j.c();
        }
        this.a.c = i2;
        if (z) {
            c cVar3 = this.a;
            cVar3.c -= i3;
        }
        this.a.g = i3;
    }

    boolean j() {
        return this.j.h() == 0 && this.j.e() == 0;
    }

    int c(int i, n nVar, r rVar) {
        if (t() == 0 || i == 0) {
            return 0;
        }
        this.a.a = true;
        h();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, rVar);
        int a = this.a.g + a(nVar, this.a, rVar, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.j.a(-i);
        this.a.j = i;
        return i;
    }

    public void a(String str) {
        if (this.n == null) {
            super.a(str);
        }
    }

    private void a(n nVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    a(i3, nVar);
                }
                return;
            }
            while (i > i2) {
                a(i, nVar);
                i--;
            }
        }
    }

    private void a(n nVar, int i) {
        if (i >= 0) {
            int t = t();
            int i2;
            if (this.k) {
                for (i2 = t - 1; i2 >= 0; i2--) {
                    View i3 = i(i2);
                    if (this.j.b(i3) > i || this.j.c(i3) > i) {
                        a(nVar, t - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = 0; i2 < t; i2++) {
                View i4 = i(i2);
                if (this.j.b(i4) > i || this.j.c(i4) > i) {
                    a(nVar, 0, i2);
                    return;
                }
            }
        }
    }

    private void b(n nVar, int i) {
        int t = t();
        if (i >= 0) {
            int e = this.j.e() - i;
            int i2;
            if (this.k) {
                for (i2 = 0; i2 < t; i2++) {
                    View i3 = i(i2);
                    if (this.j.a(i3) < e || this.j.d(i3) < e) {
                        a(nVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = t - 1; i2 >= 0; i2--) {
                View i4 = i(i2);
                if (this.j.a(i4) < e || this.j.d(i4) < e) {
                    a(nVar, t - 1, i2);
                    return;
                }
            }
        }
    }

    private void a(n nVar, c cVar) {
        if (cVar.a && !cVar.l) {
            if (cVar.f == -1) {
                b(nVar, cVar.g);
            } else {
                a(nVar, cVar.g);
            }
        }
    }

    int a(n nVar, c cVar, r rVar, boolean z) {
        int i = cVar.c;
        if (cVar.g != Integer.MIN_VALUE) {
            if (cVar.c < 0) {
                cVar.g += cVar.c;
            }
            a(nVar, cVar);
        }
        int i2 = cVar.c + cVar.h;
        b bVar = new b();
        while (true) {
            if ((!cVar.l && i2 <= 0) || !cVar.a(rVar)) {
                break;
            }
            bVar.a();
            a(nVar, rVar, cVar, bVar);
            if (!bVar.b) {
                cVar.b += bVar.a * cVar.f;
                if (!(bVar.c && this.a.k == null && rVar.a())) {
                    cVar.c -= bVar.a;
                    i2 -= bVar.a;
                }
                if (cVar.g != Integer.MIN_VALUE) {
                    cVar.g += bVar.a;
                    if (cVar.c < 0) {
                        cVar.g += cVar.c;
                    }
                    a(nVar, cVar);
                }
                if (z && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.c;
    }

    void a(n nVar, r rVar, c cVar, b bVar) {
        View a = cVar.a(nVar);
        if (a == null) {
            bVar.b = true;
            return;
        }
        int f;
        int i;
        int i2;
        int i3;
        i iVar = (i) a.getLayoutParams();
        if (cVar.k == null) {
            if (this.k == (cVar.f == -1)) {
                b(a);
            } else {
                b(a, 0);
            }
        } else {
            boolean z;
            boolean z2 = this.k;
            if (cVar.f == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z2 == z) {
                a(a);
            } else {
                a(a, 0);
            }
        }
        a(a, 0, 0);
        bVar.a = this.j.e(a);
        if (this.i == 1) {
            int w;
            if (g()) {
                w = w() - A();
                f = w - this.j.f(a);
            } else {
                f = y();
                w = this.j.f(a) + f;
            }
            if (cVar.f == -1) {
                i = cVar.b;
                i2 = cVar.b - bVar.a;
                i3 = w;
            } else {
                i2 = cVar.b;
                i = bVar.a + cVar.b;
                i3 = w;
            }
        } else {
            i2 = z();
            i = i2 + this.j.f(a);
            if (cVar.f == -1) {
                f = cVar.b - bVar.a;
                i3 = cVar.b;
            } else {
                f = cVar.b;
                i3 = cVar.b + bVar.a;
            }
        }
        a(a, f, i2, i3, i);
        if (iVar.c() || iVar.d()) {
            bVar.c = true;
        }
        bVar.d = a.isFocusable();
    }

    boolean k() {
        return (v() == 1073741824 || u() == 1073741824 || !H()) ? false : true;
    }

    int f(int i) {
        int i2 = Integer.MIN_VALUE;
        int i3 = 1;
        switch (i) {
            case 1:
                if (this.i == 1 || !g()) {
                    return -1;
                }
                return 1;
            case 2:
                if (this.i == 1) {
                    return 1;
                }
                if (g()) {
                    return -1;
                }
                return 1;
            case 17:
                if (this.i != 0) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 33:
                if (this.i != 1) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 66:
                if (this.i != 0) {
                    i3 = Integer.MIN_VALUE;
                }
                return i3;
            case 130:
                if (this.i == 1) {
                    i2 = 1;
                }
                return i2;
            default:
                return Integer.MIN_VALUE;
        }
    }

    private View J() {
        return i(this.k ? t() - 1 : 0);
    }

    private View K() {
        return i(this.k ? 0 : t() - 1);
    }

    private View a(boolean z, boolean z2) {
        if (this.k) {
            return a(t() - 1, -1, z, z2);
        }
        return a(0, t(), z, z2);
    }

    private View b(boolean z, boolean z2) {
        if (this.k) {
            return a(0, t(), z, z2);
        }
        return a(t() - 1, -1, z, z2);
    }

    private View f(n nVar, r rVar) {
        if (this.k) {
            return h(nVar, rVar);
        }
        return i(nVar, rVar);
    }

    private View g(n nVar, r rVar) {
        if (this.k) {
            return i(nVar, rVar);
        }
        return h(nVar, rVar);
    }

    private View h(n nVar, r rVar) {
        return a(nVar, rVar, 0, t(), rVar.e());
    }

    private View i(n nVar, r rVar) {
        return a(nVar, rVar, t() - 1, -1, rVar.e());
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
                if (((i) i5.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = i5;
                    }
                } else if (this.j.a(i5) < d && this.j.b(i5) >= c) {
                    return i5;
                } else {
                    if (view == null) {
                        view3 = i5;
                        i5 = view2;
                        i += i4;
                        view = view3;
                        view2 = i5;
                    }
                }
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

    public int l() {
        View a = a(0, t(), false, true);
        return a == null ? -1 : d(a);
    }

    public int m() {
        View a = a(t() - 1, -1, false, true);
        if (a == null) {
            return -1;
        }
        return d(a);
    }

    View a(int i, int i2, boolean z, boolean z2) {
        h();
        int c = this.j.c();
        int d = this.j.d();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View i4 = i(i);
            int a = this.j.a(i4);
            int b = this.j.b(i4);
            if (a < d && b > c) {
                if (!z) {
                    return i4;
                }
                if (a >= c && b <= d) {
                    return i4;
                }
                if (z2 && view == null) {
                    i += i3;
                    view = i4;
                }
            }
            i4 = view;
            i += i3;
            view = i4;
        }
        return view;
    }

    public View a(View view, int i, n nVar, r rVar) {
        I();
        if (t() == 0) {
            return null;
        }
        int f = f(i);
        if (f == Integer.MIN_VALUE) {
            return null;
        }
        View g;
        h();
        if (f == -1) {
            g = g(nVar, rVar);
        } else {
            g = f(nVar, rVar);
        }
        if (g == null) {
            return null;
        }
        View J;
        h();
        a(f, (int) (0.33333334f * ((float) this.j.f())), false, rVar);
        this.a.g = Integer.MIN_VALUE;
        this.a.a = false;
        a(nVar, this.a, rVar, true);
        if (f == -1) {
            J = J();
        } else {
            J = K();
        }
        if (J == g || !J.isFocusable()) {
            return null;
        }
        return J;
    }

    public boolean b() {
        return this.n == null && this.b == this.d;
    }

    public void a(View view, View view2, int i, int i2) {
        a("Cannot drop a view during a scroll or layout calculation");
        h();
        I();
        int d = d(view);
        int d2 = d(view2);
        if (d < d2) {
            Object obj = 1;
        } else {
            d = -1;
        }
        if (this.k) {
            if (obj == 1) {
                a(d2, this.j.d() - (this.j.a(view2) + this.j.e(view)));
            } else {
                a(d2, this.j.d() - this.j.b(view2));
            }
        } else if (obj == -1) {
            a(d2, this.j.a(view2));
        } else {
            a(d2, this.j.b(view2) - this.j.e(view));
        }
    }
}
