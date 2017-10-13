package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class a {
    private static final d a;

    interface d {
        int a(AccessibilityEvent accessibilityEvent);

        void a(AccessibilityEvent accessibilityEvent, int i);
    }

    static class c implements d {
        c() {
        }

        public void a(AccessibilityEvent accessibilityEvent, int i) {
        }

        public int a(AccessibilityEvent accessibilityEvent) {
            return 0;
        }
    }

    static class a extends c {
        a() {
        }
    }

    static class b extends a {
        b() {
        }

        public void a(AccessibilityEvent accessibilityEvent, int i) {
            b.a(accessibilityEvent, i);
        }

        public int a(AccessibilityEvent accessibilityEvent) {
            return b.a(accessibilityEvent);
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            a = new b();
        } else if (VERSION.SDK_INT >= 14) {
            a = new a();
        } else {
            a = new c();
        }
    }

    public static k a(AccessibilityEvent accessibilityEvent) {
        return new k(accessibilityEvent);
    }

    public static void a(AccessibilityEvent accessibilityEvent, int i) {
        a.a(accessibilityEvent, i);
    }

    public static int b(AccessibilityEvent accessibilityEvent) {
        return a.a(accessibilityEvent);
    }
}
