package android.support.v4.content.a;

import android.content.res.Resources;
import android.os.Build.VERSION;

public final class a {
    private static final a a;

    private interface a {
        int a(Resources resources);

        int b(Resources resources);

        int c(Resources resources);
    }

    private static class b implements a {
        private b() {
        }

        public int a(Resources resources) {
            return b.a(resources);
        }

        public int b(Resources resources) {
            return b.b(resources);
        }

        public int c(Resources resources) {
            return b.c(resources);
        }
    }

    private static class c extends b {
        private c() {
            super();
        }

        public int a(Resources resources) {
            return c.a(resources);
        }

        public int b(Resources resources) {
            return c.b(resources);
        }

        public int c(Resources resources) {
            return c.c(resources);
        }
    }

    private static class d extends c {
        private d() {
            super();
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            a = new d();
        } else if (i >= 13) {
            a = new c();
        } else {
            a = new b();
        }
    }

    public static int a(Resources resources) {
        return a.a(resources);
    }

    public static int b(Resources resources) {
        return a.b(resources);
    }

    public static int c(Resources resources) {
        return a.c(resources);
    }
}
