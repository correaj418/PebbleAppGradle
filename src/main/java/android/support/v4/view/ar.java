package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public final class ar {
    static final e a;

    interface e {
        int a(ViewConfiguration viewConfiguration);

        boolean b(ViewConfiguration viewConfiguration);
    }

    static class a implements e {
        a() {
        }

        public int a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledTouchSlop();
        }

        public boolean b(ViewConfiguration viewConfiguration) {
            return true;
        }
    }

    static class b extends a {
        b() {
        }

        public int a(ViewConfiguration viewConfiguration) {
            return as.a(viewConfiguration);
        }
    }

    static class c extends b {
        c() {
        }

        public boolean b(ViewConfiguration viewConfiguration) {
            return false;
        }
    }

    static class d extends c {
        d() {
        }

        public boolean b(ViewConfiguration viewConfiguration) {
            return at.a(viewConfiguration);
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            a = new d();
        } else if (VERSION.SDK_INT >= 11) {
            a = new c();
        } else if (VERSION.SDK_INT >= 8) {
            a = new b();
        } else {
            a = new a();
        }
    }

    public static int a(ViewConfiguration viewConfiguration) {
        return a.a(viewConfiguration);
    }

    public static boolean b(ViewConfiguration viewConfiguration) {
        return a.b(viewConfiguration);
    }
}
