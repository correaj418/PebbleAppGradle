package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public final class o {
    static final a a;

    interface a {
        int a(MarginLayoutParams marginLayoutParams);

        int b(MarginLayoutParams marginLayoutParams);
    }

    static class b implements a {
        b() {
        }

        public int a(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.leftMargin;
        }

        public int b(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.rightMargin;
        }
    }

    static class c implements a {
        c() {
        }

        public int a(MarginLayoutParams marginLayoutParams) {
            return p.a(marginLayoutParams);
        }

        public int b(MarginLayoutParams marginLayoutParams) {
            return p.b(marginLayoutParams);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            a = new c();
        } else {
            a = new b();
        }
    }

    public static int a(MarginLayoutParams marginLayoutParams) {
        return a.a(marginLayoutParams);
    }

    public static int b(MarginLayoutParams marginLayoutParams) {
        return a.b(marginLayoutParams);
    }
}
