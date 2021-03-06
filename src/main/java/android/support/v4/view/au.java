package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public final class au {
    static final b a;

    interface b {
        void a(ViewParent viewParent, View view);

        void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4);

        void a(ViewParent viewParent, View view, int i, int i2, int[] iArr);

        boolean a(ViewParent viewParent, View view, float f, float f2);

        boolean a(ViewParent viewParent, View view, float f, float f2, boolean z);

        boolean a(ViewParent viewParent, View view, View view2, int i);

        void b(ViewParent viewParent, View view, View view2, int i);
    }

    static class e implements b {
        e() {
        }

        public boolean a(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof z) {
                return ((z) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        public void b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof z) {
                ((z) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        public void a(ViewParent viewParent, View view) {
            if (viewParent instanceof z) {
                ((z) viewParent).onStopNestedScroll(view);
            }
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof z) {
                ((z) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof z) {
                ((z) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            if (viewParent instanceof z) {
                return ((z) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2) {
            if (viewParent instanceof z) {
                return ((z) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }
    }

    static class a extends e {
        a() {
        }
    }

    static class c extends a {
        c() {
        }
    }

    static class d extends c {
        d() {
        }

        public boolean a(ViewParent viewParent, View view, View view2, int i) {
            return av.a(viewParent, view, view2, i);
        }

        public void b(ViewParent viewParent, View view, View view2, int i) {
            av.b(viewParent, view, view2, i);
        }

        public void a(ViewParent viewParent, View view) {
            av.a(viewParent, view);
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            av.a(viewParent, view, i, i2, i3, i4);
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            av.a(viewParent, view, i, i2, iArr);
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return av.a(viewParent, view, f, f2, z);
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2) {
            return av.a(viewParent, view, f, f2);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            a = new d();
        } else if (i >= 19) {
            a = new c();
        } else if (i >= 14) {
            a = new a();
        } else {
            a = new e();
        }
    }

    public static boolean a(ViewParent viewParent, View view, View view2, int i) {
        return a.a(viewParent, view, view2, i);
    }

    public static void b(ViewParent viewParent, View view, View view2, int i) {
        a.b(viewParent, view, view2, i);
    }

    public static void a(ViewParent viewParent, View view) {
        a.a(viewParent, view);
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        a.a(viewParent, view, i, i2, i3, i4);
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        a.a(viewParent, view, i, i2, iArr);
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return a.a(viewParent, view, f, f2, z);
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2) {
        return a.a(viewParent, view, f, f2);
    }
}
