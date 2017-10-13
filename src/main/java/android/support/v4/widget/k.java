package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.view.ah;
import android.view.View;
import android.widget.PopupWindow;

public final class k {
    static final f a;

    interface f {
        void a(PopupWindow popupWindow, int i);

        void a(PopupWindow popupWindow, View view, int i, int i2, int i3);

        void a(PopupWindow popupWindow, boolean z);
    }

    static class c implements f {
        c() {
        }

        public void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            if ((android.support.v4.view.f.a(i3, ah.h(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }

        public void a(PopupWindow popupWindow, boolean z) {
        }

        public void a(PopupWindow popupWindow, int i) {
        }
    }

    static class d extends c {
        d() {
        }

        public void a(PopupWindow popupWindow, int i) {
            n.a(popupWindow, i);
        }
    }

    static class e extends d {
        e() {
        }

        public void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            o.a(popupWindow, view, i, i2, i3);
        }
    }

    static class a extends e {
        a() {
        }

        public void a(PopupWindow popupWindow, boolean z) {
            l.a(popupWindow, z);
        }
    }

    static class b extends a {
        b() {
        }

        public void a(PopupWindow popupWindow, boolean z) {
            m.a(popupWindow, z);
        }

        public void a(PopupWindow popupWindow, int i) {
            m.a(popupWindow, i);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            a = new b();
        } else if (i >= 21) {
            a = new a();
        } else if (i >= 19) {
            a = new e();
        } else if (i >= 9) {
            a = new d();
        } else {
            a = new c();
        }
    }

    public static void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        a.a(popupWindow, view, i, i2, i3);
    }

    public static void a(PopupWindow popupWindow, boolean z) {
        a.a(popupWindow, z);
    }

    public static void a(PopupWindow popupWindow, int i) {
        a.a(popupWindow, i);
    }
}
