package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.view.View;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

public class ah {
    static final n a;

    interface n {
        int a(int i, int i2, int i3);

        int a(View view);

        bb a(View view, bb bbVar);

        void a(View view, float f);

        void a(View view, int i, Paint paint);

        void a(View view, ColorStateList colorStateList);

        void a(View view, Mode mode);

        void a(View view, a aVar);

        void a(View view, ab abVar);

        void a(View view, Runnable runnable);

        void a(View view, Runnable runnable, long j);

        void a(View view, boolean z);

        boolean a(View view, int i);

        bb b(View view, bb bbVar);

        void b(View view, float f);

        void b(View view, boolean z);

        boolean b(View view);

        boolean b(View view, int i);

        void c(View view, float f);

        void c(View view, int i);

        boolean c(View view);

        void d(View view);

        void d(View view, float f);

        void d(View view, int i);

        int e(View view);

        void e(View view, int i);

        float f(View view);

        int g(View view);

        int h(View view);

        int i(View view);

        int j(View view);

        boolean k(View view);

        float l(View view);

        float m(View view);

        Matrix n(View view);

        int o(View view);

        int p(View view);

        aw q(View view);

        int r(View view);

        void s(View view);

        float t(View view);

        void u(View view);

        ColorStateList v(View view);

        Mode w(View view);

        void x(View view);

        boolean y(View view);
    }

    static class b implements n {
        WeakHashMap<View, aw> a = null;

        b() {
        }

        public boolean a(View view, int i) {
            return (view instanceof ad) && a((ad) view, i);
        }

        public boolean b(View view, int i) {
            return (view instanceof ad) && b((ad) view, i);
        }

        public int a(View view) {
            return 2;
        }

        public void a(View view, a aVar) {
        }

        public boolean b(View view) {
            return false;
        }

        public boolean c(View view) {
            return false;
        }

        public void d(View view) {
            view.invalidate();
        }

        public void a(View view, Runnable runnable) {
            view.postDelayed(runnable, a());
        }

        public void a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, a() + j);
        }

        long a() {
            return 10;
        }

        public int e(View view) {
            return 0;
        }

        public void c(View view, int i) {
        }

        public float f(View view) {
            return 1.0f;
        }

        public void a(View view, int i, Paint paint) {
        }

        public int g(View view) {
            return 0;
        }

        public int h(View view) {
            return 0;
        }

        public int a(int i, int i2, int i3) {
            return View.resolveSize(i, i2);
        }

        public int i(View view) {
            return view.getMeasuredWidth();
        }

        public int j(View view) {
            return 0;
        }

        public boolean k(View view) {
            return true;
        }

        public float l(View view) {
            return 0.0f;
        }

        public float m(View view) {
            return 0.0f;
        }

        public Matrix n(View view) {
            return null;
        }

        public int o(View view) {
            return ai.c(view);
        }

        public int p(View view) {
            return ai.d(view);
        }

        public aw q(View view) {
            return new aw(view);
        }

        public void a(View view, float f) {
        }

        public void b(View view, float f) {
        }

        public void c(View view, float f) {
        }

        public int r(View view) {
            return 0;
        }

        public void s(View view) {
        }

        public void d(View view, float f) {
        }

        public float t(View view) {
            return 0.0f;
        }

        public void u(View view) {
        }

        public void a(View view, ab abVar) {
        }

        public bb a(View view, bb bbVar) {
            return bbVar;
        }

        public bb b(View view, bb bbVar) {
            return bbVar;
        }

        public void a(View view, boolean z) {
        }

        public void b(View view, boolean z) {
        }

        public ColorStateList v(View view) {
            return ai.a(view);
        }

        public void a(View view, ColorStateList colorStateList) {
            ai.a(view, colorStateList);
        }

        public void a(View view, Mode mode) {
            ai.a(view, mode);
        }

        public Mode w(View view) {
            return ai.b(view);
        }

        private boolean a(ad adVar, int i) {
            int computeHorizontalScrollOffset = adVar.computeHorizontalScrollOffset();
            int computeHorizontalScrollRange = adVar.computeHorizontalScrollRange() - adVar.computeHorizontalScrollExtent();
            if (computeHorizontalScrollRange == 0) {
                return false;
            }
            if (i < 0) {
                if (computeHorizontalScrollOffset <= 0) {
                    return false;
                }
                return true;
            } else if (computeHorizontalScrollOffset >= computeHorizontalScrollRange - 1) {
                return false;
            } else {
                return true;
            }
        }

        private boolean b(ad adVar, int i) {
            int computeVerticalScrollOffset = adVar.computeVerticalScrollOffset();
            int computeVerticalScrollRange = adVar.computeVerticalScrollRange() - adVar.computeVerticalScrollExtent();
            if (computeVerticalScrollRange == 0) {
                return false;
            }
            if (i < 0) {
                if (computeVerticalScrollOffset <= 0) {
                    return false;
                }
                return true;
            } else if (computeVerticalScrollOffset >= computeVerticalScrollRange - 1) {
                return false;
            } else {
                return true;
            }
        }

        public void x(View view) {
            if (view instanceof x) {
                ((x) view).stopNestedScroll();
            }
        }

        public boolean y(View view) {
            return ai.e(view);
        }

        public void d(View view, int i) {
            ai.b(view, i);
        }

        public void e(View view, int i) {
            ai.a(view, i);
        }
    }

    static class c extends b {
        c() {
        }
    }

    static class d extends c {
        d() {
        }

        public int a(View view) {
            return aj.a(view);
        }
    }

    static class e extends d {
        e() {
        }

        long a() {
            return ak.a();
        }

        public float f(View view) {
            return ak.a(view);
        }

        public void a(View view, int i, Paint paint) {
            ak.a(view, i, paint);
        }

        public int g(View view) {
            return ak.b(view);
        }

        public int a(int i, int i2, int i3) {
            return ak.a(i, i2, i3);
        }

        public int i(View view) {
            return ak.c(view);
        }

        public int j(View view) {
            return ak.d(view);
        }

        public float l(View view) {
            return ak.e(view);
        }

        public float m(View view) {
            return ak.f(view);
        }

        public Matrix n(View view) {
            return ak.g(view);
        }

        public void a(View view, float f) {
            ak.a(view, f);
        }

        public void b(View view, float f) {
            ak.b(view, f);
        }

        public void c(View view, float f) {
            ak.c(view, f);
        }

        public void u(View view) {
            ak.h(view);
        }

        public void a(View view, boolean z) {
            ak.a(view, z);
        }

        public void b(View view, boolean z) {
            ak.b(view, z);
        }

        public void d(View view, int i) {
            ak.b(view, i);
        }

        public void e(View view, int i) {
            ak.a(view, i);
        }
    }

    static class g extends e {
        static Field b;
        static boolean c = false;

        g() {
        }

        public boolean a(View view, int i) {
            return al.a(view, i);
        }

        public boolean b(View view, int i) {
            return al.b(view, i);
        }

        public void a(View view, a aVar) {
            Object obj;
            if (aVar == null) {
                obj = null;
            } else {
                obj = aVar.a();
            }
            al.a(view, obj);
        }

        public boolean b(View view) {
            boolean z = true;
            if (c) {
                return false;
            }
            if (b == null) {
                try {
                    b = View.class.getDeclaredField("mAccessibilityDelegate");
                    b.setAccessible(true);
                } catch (Throwable th) {
                    c = true;
                    return false;
                }
            }
            try {
                if (b.get(view) == null) {
                    z = false;
                }
                return z;
            } catch (Throwable th2) {
                c = true;
                return false;
            }
        }

        public aw q(View view) {
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            aw awVar = (aw) this.a.get(view);
            if (awVar != null) {
                return awVar;
            }
            awVar = new aw(view);
            this.a.put(view, awVar);
            return awVar;
        }
    }

    static class f extends g {
        f() {
        }
    }

    static class h extends f {
        h() {
        }

        public boolean c(View view) {
            return am.a(view);
        }

        public void d(View view) {
            am.b(view);
        }

        public void a(View view, Runnable runnable) {
            am.a(view, runnable);
        }

        public void a(View view, Runnable runnable, long j) {
            am.a(view, runnable, j);
        }

        public int e(View view) {
            return am.c(view);
        }

        public void c(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            am.a(view, i);
        }

        public int o(View view) {
            return am.d(view);
        }

        public int p(View view) {
            return am.e(view);
        }

        public void s(View view) {
            am.f(view);
        }

        public boolean k(View view) {
            return am.g(view);
        }
    }

    static class i extends h {
        i() {
        }

        public int h(View view) {
            return an.a(view);
        }

        public int r(View view) {
            return an.b(view);
        }
    }

    static class j extends i {
        j() {
        }
    }

    static class k extends j {
        k() {
        }

        public void c(View view, int i) {
            am.a(view, i);
        }

        public boolean y(View view) {
            return ao.a(view);
        }
    }

    static class l extends k {
        l() {
        }

        public void s(View view) {
            ap.a(view);
        }

        public void d(View view, float f) {
            ap.a(view, f);
        }

        public float t(View view) {
            return ap.b(view);
        }

        public void a(View view, ab abVar) {
            ap.a(view, abVar);
        }

        public void x(View view) {
            ap.e(view);
        }

        public ColorStateList v(View view) {
            return ap.c(view);
        }

        public void a(View view, ColorStateList colorStateList) {
            ap.a(view, colorStateList);
        }

        public void a(View view, Mode mode) {
            ap.a(view, mode);
        }

        public Mode w(View view) {
            return ap.d(view);
        }

        public bb a(View view, bb bbVar) {
            return ap.a(view, bbVar);
        }

        public bb b(View view, bb bbVar) {
            return ap.b(view, bbVar);
        }

        public void d(View view, int i) {
            ap.b(view, i);
        }

        public void e(View view, int i) {
            ap.a(view, i);
        }
    }

    static class m extends l {
        m() {
        }

        public void d(View view, int i) {
            aq.b(view, i);
        }

        public void e(View view, int i) {
            aq.a(view, i);
        }
    }

    static class a extends m {
        a() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (android.support.v4.d.c.a()) {
            a = new a();
        } else if (i >= 23) {
            a = new m();
        } else if (i >= 21) {
            a = new l();
        } else if (i >= 19) {
            a = new k();
        } else if (i >= 18) {
            a = new j();
        } else if (i >= 17) {
            a = new i();
        } else if (i >= 16) {
            a = new h();
        } else if (i >= 15) {
            a = new f();
        } else if (i >= 14) {
            a = new g();
        } else if (i >= 11) {
            a = new e();
        } else if (i >= 9) {
            a = new d();
        } else if (i >= 7) {
            a = new c();
        } else {
            a = new b();
        }
    }

    public static boolean a(View view, int i) {
        return a.a(view, i);
    }

    public static boolean b(View view, int i) {
        return a.b(view, i);
    }

    public static int a(View view) {
        return a.a(view);
    }

    public static void a(View view, a aVar) {
        a.a(view, aVar);
    }

    public static boolean b(View view) {
        return a.b(view);
    }

    public static boolean c(View view) {
        return a.c(view);
    }

    public static void d(View view) {
        a.d(view);
    }

    public static void a(View view, Runnable runnable) {
        a.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        a.a(view, runnable, j);
    }

    public static int e(View view) {
        return a.e(view);
    }

    public static void c(View view, int i) {
        a.c(view, i);
    }

    public static float f(View view) {
        return a.f(view);
    }

    public static void a(View view, int i, Paint paint) {
        a.a(view, i, paint);
    }

    public static int g(View view) {
        return a.g(view);
    }

    public static int h(View view) {
        return a.h(view);
    }

    public static int a(int i, int i2, int i3) {
        return a.a(i, i2, i3);
    }

    public static int i(View view) {
        return a.i(view);
    }

    public static int j(View view) {
        return a.j(view);
    }

    public static float k(View view) {
        return a.l(view);
    }

    public static float l(View view) {
        return a.m(view);
    }

    public static Matrix m(View view) {
        return a.n(view);
    }

    public static int n(View view) {
        return a.o(view);
    }

    public static int o(View view) {
        return a.p(view);
    }

    public static aw p(View view) {
        return a.q(view);
    }

    public static void a(View view, float f) {
        a.a(view, f);
    }

    public static void b(View view, float f) {
        a.b(view, f);
    }

    public static void c(View view, float f) {
        a.c(view, f);
    }

    public static void d(View view, float f) {
        a.d(view, f);
    }

    public static float q(View view) {
        return a.t(view);
    }

    public static int r(View view) {
        return a.r(view);
    }

    public static void s(View view) {
        a.s(view);
    }

    public static void t(View view) {
        a.u(view);
    }

    public static void a(View view, ab abVar) {
        a.a(view, abVar);
    }

    public static bb a(View view, bb bbVar) {
        return a.a(view, bbVar);
    }

    public static bb b(View view, bb bbVar) {
        return a.b(view, bbVar);
    }

    public static void a(View view, boolean z) {
        a.a(view, z);
    }

    public static void b(View view, boolean z) {
        a.b(view, z);
    }

    public static boolean u(View view) {
        return a.k(view);
    }

    public static ColorStateList v(View view) {
        return a.v(view);
    }

    public static void a(View view, ColorStateList colorStateList) {
        a.a(view, colorStateList);
    }

    public static Mode w(View view) {
        return a.w(view);
    }

    public static void a(View view, Mode mode) {
        a.a(view, mode);
    }

    public static void x(View view) {
        a.x(view);
    }

    public static void d(View view, int i) {
        a.e(view, i);
    }

    public static void e(View view, int i) {
        a.d(view, i);
    }

    public static boolean y(View view) {
        return a.y(view);
    }
}
