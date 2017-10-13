package android.support.v4.view;

import android.os.Build.VERSION;

public final class f {
    static final a a;

    interface a {
        int a(int i, int i2);
    }

    static class b implements a {
        b() {
        }

        public int a(int i, int i2) {
            return -8388609 & i;
        }
    }

    static class c implements a {
        c() {
        }

        public int a(int i, int i2) {
            return g.a(i, i2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            a = new c();
        } else {
            a = new b();
        }
    }

    public static int a(int i, int i2) {
        return a.a(i, i2);
    }
}
