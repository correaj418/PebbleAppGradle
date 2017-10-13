package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;

public class c {
    private static final e a;
    private final Object b;

    interface e {
        int a(Object obj);

        Object a(int i, int i2, int i3, int i4, boolean z, boolean z2);

        Object a(int i, int i2, boolean z, int i3);

        void a(Object obj, int i);

        void a(Object obj, Rect rect);

        void a(Object obj, CharSequence charSequence);

        void a(Object obj, Object obj2);

        void a(Object obj, boolean z);

        CharSequence b(Object obj);

        void b(Object obj, Rect rect);

        void b(Object obj, Object obj2);

        CharSequence c(Object obj);

        CharSequence d(Object obj);

        CharSequence e(Object obj);

        boolean f(Object obj);

        boolean g(Object obj);

        boolean h(Object obj);

        boolean i(Object obj);

        boolean j(Object obj);

        boolean k(Object obj);

        boolean l(Object obj);

        boolean m(Object obj);

        boolean n(Object obj);

        boolean o(Object obj);

        String p(Object obj);
    }

    static class j implements e {
        j() {
        }

        public void a(Object obj, int i) {
        }

        public int a(Object obj) {
            return 0;
        }

        public void a(Object obj, Rect rect) {
        }

        public void b(Object obj, Rect rect) {
        }

        public CharSequence b(Object obj) {
            return null;
        }

        public CharSequence c(Object obj) {
            return null;
        }

        public CharSequence d(Object obj) {
            return null;
        }

        public CharSequence e(Object obj) {
            return null;
        }

        public boolean f(Object obj) {
            return false;
        }

        public boolean g(Object obj) {
            return false;
        }

        public boolean h(Object obj) {
            return false;
        }

        public boolean i(Object obj) {
            return false;
        }

        public boolean j(Object obj) {
            return false;
        }

        public boolean k(Object obj) {
            return false;
        }

        public boolean l(Object obj) {
            return false;
        }

        public boolean m(Object obj) {
            return false;
        }

        public boolean n(Object obj) {
            return false;
        }

        public boolean o(Object obj) {
            return false;
        }

        public void a(Object obj, CharSequence charSequence) {
        }

        public void a(Object obj, boolean z) {
        }

        public String p(Object obj) {
            return null;
        }

        public void a(Object obj, Object obj2) {
        }

        public void b(Object obj, Object obj2) {
        }

        public Object a(int i, int i2, boolean z, int i3) {
            return null;
        }

        public Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return null;
        }
    }

    static class d extends j {
        d() {
        }

        public void a(Object obj, int i) {
            e.a(obj, i);
        }

        public int a(Object obj) {
            return e.a(obj);
        }

        public void a(Object obj, Rect rect) {
            e.a(obj, rect);
        }

        public void b(Object obj, Rect rect) {
            e.b(obj, rect);
        }

        public CharSequence b(Object obj) {
            return e.b(obj);
        }

        public CharSequence c(Object obj) {
            return e.c(obj);
        }

        public CharSequence d(Object obj) {
            return e.d(obj);
        }

        public CharSequence e(Object obj) {
            return e.e(obj);
        }

        public boolean f(Object obj) {
            return e.f(obj);
        }

        public boolean g(Object obj) {
            return e.g(obj);
        }

        public boolean h(Object obj) {
            return e.h(obj);
        }

        public boolean i(Object obj) {
            return e.i(obj);
        }

        public boolean j(Object obj) {
            return e.j(obj);
        }

        public boolean k(Object obj) {
            return e.k(obj);
        }

        public boolean l(Object obj) {
            return e.l(obj);
        }

        public boolean m(Object obj) {
            return e.m(obj);
        }

        public boolean n(Object obj) {
            return e.n(obj);
        }

        public boolean o(Object obj) {
            return e.o(obj);
        }

        public void a(Object obj, CharSequence charSequence) {
            e.a(obj, charSequence);
        }

        public void a(Object obj, boolean z) {
            e.a(obj, z);
        }
    }

    static class f extends d {
        f() {
        }
    }

    static class g extends f {
        g() {
        }
    }

    static class h extends g {
        h() {
        }

        public String p(Object obj) {
            return f.a(obj);
        }
    }

    static class i extends h {
        i() {
        }

        public void a(Object obj, Object obj2) {
            g.a(obj, obj2);
        }

        public Object a(int i, int i2, boolean z, int i3) {
            return g.a(i, i2, z, i3);
        }

        public Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return g.a(i, i2, i3, i4, z);
        }

        public void b(Object obj, Object obj2) {
            g.b(obj, obj2);
        }
    }

    static class a extends i {
        a() {
        }

        public Object a(int i, int i2, boolean z, int i3) {
            return d.a(i, i2, z, i3);
        }

        public Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return d.a(i, i2, i3, i4, z, z2);
        }
    }

    static class b extends a {
        b() {
        }
    }

    static class c extends b {
        c() {
        }
    }

    public static class k {
        final Object a;

        public static k a(int i, int i2, boolean z, int i3) {
            return new k(c.a.a(i, i2, z, i3));
        }

        private k(Object obj) {
            this.a = obj;
        }
    }

    public static class l {
        private final Object a;

        public static l a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new l(c.a.a(i, i2, i3, i4, z, z2));
        }

        private l(Object obj) {
            this.a = obj;
        }
    }

    static {
        if (VERSION.SDK_INT >= 24) {
            a = new c();
        } else if (VERSION.SDK_INT >= 22) {
            a = new b();
        } else if (VERSION.SDK_INT >= 21) {
            a = new a();
        } else if (VERSION.SDK_INT >= 19) {
            a = new i();
        } else if (VERSION.SDK_INT >= 18) {
            a = new h();
        } else if (VERSION.SDK_INT >= 17) {
            a = new g();
        } else if (VERSION.SDK_INT >= 16) {
            a = new f();
        } else if (VERSION.SDK_INT >= 14) {
            a = new d();
        } else {
            a = new j();
        }
    }

    public c(Object obj) {
        this.b = obj;
    }

    public Object a() {
        return this.b;
    }

    public int b() {
        return a.a(this.b);
    }

    public void a(int i) {
        a.a(this.b, i);
    }

    public void a(Rect rect) {
        a.a(this.b, rect);
    }

    public void b(Rect rect) {
        a.b(this.b, rect);
    }

    public boolean c() {
        return a.f(this.b);
    }

    public boolean d() {
        return a.g(this.b);
    }

    public boolean e() {
        return a.j(this.b);
    }

    public boolean f() {
        return a.k(this.b);
    }

    public boolean g() {
        return a.o(this.b);
    }

    public boolean h() {
        return a.h(this.b);
    }

    public boolean i() {
        return a.l(this.b);
    }

    public boolean j() {
        return a.i(this.b);
    }

    public boolean k() {
        return a.m(this.b);
    }

    public boolean l() {
        return a.n(this.b);
    }

    public void a(boolean z) {
        a.a(this.b, z);
    }

    public CharSequence m() {
        return a.d(this.b);
    }

    public CharSequence n() {
        return a.b(this.b);
    }

    public void a(CharSequence charSequence) {
        a.a(this.b, charSequence);
    }

    public CharSequence o() {
        return a.e(this.b);
    }

    public CharSequence p() {
        return a.c(this.b);
    }

    public String q() {
        return a.p(this.b);
    }

    public void a(Object obj) {
        a.a(this.b, ((k) obj).a);
    }

    public void b(Object obj) {
        a.b(this.b, ((l) obj).a);
    }

    public int hashCode() {
        return this.b == null ? 0 : this.b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.b == null) {
            if (cVar.b != null) {
                return false;
            }
            return true;
        } else if (this.b.equals(cVar.b)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        b(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(m());
        stringBuilder.append("; className: ").append(n());
        stringBuilder.append("; text: ").append(o());
        stringBuilder.append("; contentDescription: ").append(p());
        stringBuilder.append("; viewId: ").append(q());
        stringBuilder.append("; checkable: ").append(c());
        stringBuilder.append("; checked: ").append(d());
        stringBuilder.append("; focusable: ").append(e());
        stringBuilder.append("; focused: ").append(f());
        stringBuilder.append("; selected: ").append(g());
        stringBuilder.append("; clickable: ").append(h());
        stringBuilder.append("; longClickable: ").append(i());
        stringBuilder.append("; enabled: ").append(j());
        stringBuilder.append("; password: ").append(k());
        stringBuilder.append("; scrollable: " + l());
        stringBuilder.append("; [");
        int b = b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(b(numberOfTrailingZeros));
            if (b != 0) {
                stringBuilder.append(com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String b(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
