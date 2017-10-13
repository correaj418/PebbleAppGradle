package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

public final class j {
    static final a a;

    interface a {
        void a(LayoutInflater layoutInflater, n nVar);
    }

    static class b implements a {
        b() {
        }

        public void a(LayoutInflater layoutInflater, n nVar) {
            k.a(layoutInflater, nVar);
        }
    }

    static class c extends b {
        c() {
        }

        public void a(LayoutInflater layoutInflater, n nVar) {
            l.a(layoutInflater, nVar);
        }
    }

    static class d extends c {
        d() {
        }

        public void a(LayoutInflater layoutInflater, n nVar) {
            m.a(layoutInflater, nVar);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            a = new d();
        } else if (i >= 11) {
            a = new c();
        } else {
            a = new b();
        }
    }

    public static void a(LayoutInflater layoutInflater, n nVar) {
        a.a(layoutInflater, nVar);
    }
}
