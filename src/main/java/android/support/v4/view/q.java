package android.support.v4.view;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public final class q {
    static final d a;

    interface d {
        MenuItem a(MenuItem menuItem, View view);

        View a(MenuItem menuItem);

        void a(MenuItem menuItem, int i);

        MenuItem b(MenuItem menuItem, int i);

        boolean b(MenuItem menuItem);
    }

    static class a implements d {
        a() {
        }

        public void a(MenuItem menuItem, int i) {
        }

        public MenuItem a(MenuItem menuItem, View view) {
            return menuItem;
        }

        public MenuItem b(MenuItem menuItem, int i) {
            return menuItem;
        }

        public View a(MenuItem menuItem) {
            return null;
        }

        public boolean b(MenuItem menuItem) {
            return false;
        }
    }

    static class b implements d {
        b() {
        }

        public void a(MenuItem menuItem, int i) {
            r.a(menuItem, i);
        }

        public MenuItem a(MenuItem menuItem, View view) {
            return r.a(menuItem, view);
        }

        public MenuItem b(MenuItem menuItem, int i) {
            return r.b(menuItem, i);
        }

        public View a(MenuItem menuItem) {
            return r.a(menuItem);
        }

        public boolean b(MenuItem menuItem) {
            return false;
        }
    }

    static class c extends b {
        c() {
        }

        public boolean b(MenuItem menuItem) {
            return s.a(menuItem);
        }
    }

    public interface e {
        boolean a(MenuItem menuItem);

        boolean b(MenuItem menuItem);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            a = new c();
        } else if (i >= 11) {
            a = new b();
        } else {
            a = new a();
        }
    }

    public static void a(MenuItem menuItem, int i) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            ((android.support.v4.c.a.b) menuItem).setShowAsAction(i);
        } else {
            a.a(menuItem, i);
        }
    }

    public static MenuItem a(MenuItem menuItem, View view) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            return ((android.support.v4.c.a.b) menuItem).setActionView(view);
        }
        return a.a(menuItem, view);
    }

    public static MenuItem b(MenuItem menuItem, int i) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            return ((android.support.v4.c.a.b) menuItem).setActionView(i);
        }
        return a.b(menuItem, i);
    }

    public static View a(MenuItem menuItem) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            return ((android.support.v4.c.a.b) menuItem).getActionView();
        }
        return a.a(menuItem);
    }

    public static MenuItem a(MenuItem menuItem, d dVar) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            return ((android.support.v4.c.a.b) menuItem).a(dVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static boolean b(MenuItem menuItem) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            return ((android.support.v4.c.a.b) menuItem).expandActionView();
        }
        return a.b(menuItem);
    }
}
