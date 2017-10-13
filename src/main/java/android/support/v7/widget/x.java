package android.support.v7.widget;

import android.support.v4.view.ah;
import android.support.v4.view.aw;
import android.support.v4.view.az;
import android.support.v7.widget.RecyclerView.u;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class x extends as {
    private ArrayList<u> b = new ArrayList();
    private ArrayList<u> c = new ArrayList();
    private ArrayList<b> d = new ArrayList();
    private ArrayList<a> e = new ArrayList();
    private ArrayList<ArrayList<u>> f = new ArrayList();
    private ArrayList<ArrayList<b>> g = new ArrayList();
    private ArrayList<ArrayList<a>> h = new ArrayList();
    private ArrayList<u> i = new ArrayList();
    private ArrayList<u> j = new ArrayList();
    private ArrayList<u> k = new ArrayList();
    private ArrayList<u> l = new ArrayList();

    private static class c implements az {
        private c() {
        }

        public void a(View view) {
        }

        public void b(View view) {
        }

        public void c(View view) {
        }
    }

    private static class a {
        public u a;
        public u b;
        public int c;
        public int d;
        public int e;
        public int f;

        private a(u uVar, u uVar2) {
            this.a = uVar;
            this.b = uVar2;
        }

        private a(u uVar, u uVar2, int i, int i2, int i3, int i4) {
            this(uVar, uVar2);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
        }
    }

    private static class b {
        public u a;
        public int b;
        public int c;
        public int d;
        public int e;

        private b(u uVar, int i, int i2, int i3, int i4) {
            this.a = uVar;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    public void a() {
        int i;
        int i2;
        int i3;
        int i4 = !this.b.isEmpty() ? 1 : 0;
        if (this.d.isEmpty()) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.e.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.c.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i4 != 0 || i != 0 || i3 != 0 || i2 != 0) {
            final ArrayList arrayList;
            Runnable anonymousClass1;
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                t((u) it.next());
            }
            this.b.clear();
            if (i != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.d);
                this.g.add(arrayList);
                this.d.clear();
                anonymousClass1 = new Runnable(this) {
                    final /* synthetic */ x b;

                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            this.b.b(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e);
                        }
                        arrayList.clear();
                        this.b.g.remove(arrayList);
                    }
                };
                if (i4 != 0) {
                    ah.a(((b) arrayList.get(0)).a.a, anonymousClass1, f());
                } else {
                    anonymousClass1.run();
                }
            }
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.e);
                this.h.add(arrayList);
                this.e.clear();
                anonymousClass1 = new Runnable(this) {
                    final /* synthetic */ x b;

                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            this.b.a((a) it.next());
                        }
                        arrayList.clear();
                        this.b.h.remove(arrayList);
                    }
                };
                if (i4 != 0) {
                    ah.a(((a) arrayList.get(0)).a.a, anonymousClass1, f());
                } else {
                    anonymousClass1.run();
                }
            }
            if (i3 != 0) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.c);
                this.f.add(arrayList2);
                this.c.clear();
                Runnable anonymousClass3 = new Runnable(this) {
                    final /* synthetic */ x b;

                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            this.b.u((u) it.next());
                        }
                        arrayList2.clear();
                        this.b.f.remove(arrayList2);
                    }
                };
                if (i4 == 0 && i == 0 && i2 == 0) {
                    anonymousClass3.run();
                    return;
                }
                long d;
                long g;
                long f = i4 != 0 ? f() : 0;
                if (i != 0) {
                    d = d();
                } else {
                    d = 0;
                }
                if (i2 != 0) {
                    g = g();
                } else {
                    g = 0;
                }
                ah.a(((u) arrayList2.get(0)).a, anonymousClass3, f + Math.max(d, g));
            }
        }
    }

    public boolean a(u uVar) {
        v(uVar);
        this.b.add(uVar);
        return true;
    }

    private void t(final u uVar) {
        final aw p = ah.p(uVar.a);
        this.k.add(uVar);
        p.a(f()).a(0.0f).a(new c(this) {
            final /* synthetic */ x c;

            public void a(View view) {
                this.c.k(uVar);
            }

            public void b(View view) {
                p.a(null);
                ah.c(view, 1.0f);
                this.c.h(uVar);
                this.c.k.remove(uVar);
                this.c.j();
            }
        }).b();
    }

    public boolean b(u uVar) {
        v(uVar);
        ah.c(uVar.a, 0.0f);
        this.c.add(uVar);
        return true;
    }

    private void u(final u uVar) {
        final aw p = ah.p(uVar.a);
        this.i.add(uVar);
        p.a(1.0f).a(e()).a(new c(this) {
            final /* synthetic */ x c;

            public void a(View view) {
                this.c.m(uVar);
            }

            public void c(View view) {
                ah.c(view, 1.0f);
            }

            public void b(View view) {
                p.a(null);
                this.c.j(uVar);
                this.c.i.remove(uVar);
                this.c.j();
            }
        }).b();
    }

    public boolean a(u uVar, int i, int i2, int i3, int i4) {
        View view = uVar.a;
        int k = (int) (((float) i) + ah.k(uVar.a));
        int l = (int) (((float) i2) + ah.l(uVar.a));
        v(uVar);
        int i5 = i3 - k;
        int i6 = i4 - l;
        if (i5 == 0 && i6 == 0) {
            i(uVar);
            return false;
        }
        if (i5 != 0) {
            ah.a(view, (float) (-i5));
        }
        if (i6 != 0) {
            ah.b(view, (float) (-i6));
        }
        this.d.add(new b(uVar, k, l, i3, i4));
        return true;
    }

    private void b(u uVar, int i, int i2, int i3, int i4) {
        View view = uVar.a;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            ah.p(view).b(0.0f);
        }
        if (i6 != 0) {
            ah.p(view).c(0.0f);
        }
        final aw p = ah.p(view);
        this.j.add(uVar);
        final u uVar2 = uVar;
        p.a(d()).a(new c(this) {
            final /* synthetic */ x e;

            public void a(View view) {
                this.e.l(uVar2);
            }

            public void c(View view) {
                if (i5 != 0) {
                    ah.a(view, 0.0f);
                }
                if (i6 != 0) {
                    ah.b(view, 0.0f);
                }
            }

            public void b(View view) {
                p.a(null);
                this.e.i(uVar2);
                this.e.j.remove(uVar2);
                this.e.j();
            }
        }).b();
    }

    public boolean a(u uVar, u uVar2, int i, int i2, int i3, int i4) {
        if (uVar == uVar2) {
            return a(uVar, i, i2, i3, i4);
        }
        float k = ah.k(uVar.a);
        float l = ah.l(uVar.a);
        float f = ah.f(uVar.a);
        v(uVar);
        int i5 = (int) (((float) (i3 - i)) - k);
        int i6 = (int) (((float) (i4 - i2)) - l);
        ah.a(uVar.a, k);
        ah.b(uVar.a, l);
        ah.c(uVar.a, f);
        if (uVar2 != null) {
            v(uVar2);
            ah.a(uVar2.a, (float) (-i5));
            ah.b(uVar2.a, (float) (-i6));
            ah.c(uVar2.a, 0.0f);
        }
        this.e.add(new a(uVar, uVar2, i, i2, i3, i4));
        return true;
    }

    private void a(final a aVar) {
        View view = null;
        u uVar = aVar.a;
        View view2 = uVar == null ? null : uVar.a;
        u uVar2 = aVar.b;
        if (uVar2 != null) {
            view = uVar2.a;
        }
        if (view2 != null) {
            final aw a = ah.p(view2).a(g());
            this.l.add(aVar.a);
            a.b((float) (aVar.e - aVar.c));
            a.c((float) (aVar.f - aVar.d));
            a.a(0.0f).a(new c(this) {
                final /* synthetic */ x c;

                public void a(View view) {
                    this.c.b(aVar.a, true);
                }

                public void b(View view) {
                    a.a(null);
                    ah.c(view, 1.0f);
                    ah.a(view, 0.0f);
                    ah.b(view, 0.0f);
                    this.c.a(aVar.a, true);
                    this.c.l.remove(aVar.a);
                    this.c.j();
                }
            }).b();
        }
        if (view != null) {
            a = ah.p(view);
            this.l.add(aVar.b);
            a.b(0.0f).c(0.0f).a(g()).a(1.0f).a(new c(this) {
                final /* synthetic */ x d;

                public void a(View view) {
                    this.d.b(aVar.b, false);
                }

                public void b(View view) {
                    a.a(null);
                    ah.c(view, 1.0f);
                    ah.a(view, 0.0f);
                    ah.b(view, 0.0f);
                    this.d.a(aVar.b, false);
                    this.d.l.remove(aVar.b);
                    this.d.j();
                }
            }).b();
        }
    }

    private void a(List<a> list, u uVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = (a) list.get(size);
            if (a(aVar, uVar) && aVar.a == null && aVar.b == null) {
                list.remove(aVar);
            }
        }
    }

    private void b(a aVar) {
        if (aVar.a != null) {
            a(aVar, aVar.a);
        }
        if (aVar.b != null) {
            a(aVar, aVar.b);
        }
    }

    private boolean a(a aVar, u uVar) {
        boolean z = false;
        if (aVar.b == uVar) {
            aVar.b = null;
        } else if (aVar.a != uVar) {
            return false;
        } else {
            aVar.a = null;
            z = true;
        }
        ah.c(uVar.a, 1.0f);
        ah.a(uVar.a, 0.0f);
        ah.b(uVar.a, 0.0f);
        a(uVar, z);
        return true;
    }

    public void c(u uVar) {
        int size;
        View view = uVar.a;
        ah.p(view).a();
        for (size = this.d.size() - 1; size >= 0; size--) {
            if (((b) this.d.get(size)).a == uVar) {
                ah.b(view, 0.0f);
                ah.a(view, 0.0f);
                i(uVar);
                this.d.remove(size);
            }
        }
        a(this.e, uVar);
        if (this.b.remove(uVar)) {
            ah.c(view, 1.0f);
            h(uVar);
        }
        if (this.c.remove(uVar)) {
            ah.c(view, 1.0f);
            j(uVar);
        }
        for (size = this.h.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.h.get(size);
            a(list, uVar);
            if (list.isEmpty()) {
                this.h.remove(size);
            }
        }
        for (int size2 = this.g.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.g.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((b) arrayList.get(size3)).a == uVar) {
                    ah.b(view, 0.0f);
                    ah.a(view, 0.0f);
                    i(uVar);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.g.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.f.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.f.get(size);
            if (arrayList.remove(uVar)) {
                ah.c(view, 1.0f);
                j(uVar);
                if (arrayList.isEmpty()) {
                    this.f.remove(size);
                }
            }
        }
        if (this.k.remove(uVar)) {
        }
        if (this.i.remove(uVar)) {
        }
        if (this.l.remove(uVar)) {
        }
        if (this.j.remove(uVar)) {
            j();
        } else {
            j();
        }
    }

    private void v(u uVar) {
        android.support.v4.a.a.a(uVar.a);
        c(uVar);
    }

    public boolean b() {
        return (this.c.isEmpty() && this.e.isEmpty() && this.d.isEmpty() && this.b.isEmpty() && this.j.isEmpty() && this.k.isEmpty() && this.i.isEmpty() && this.l.isEmpty() && this.g.isEmpty() && this.f.isEmpty() && this.h.isEmpty()) ? false : true;
    }

    private void j() {
        if (!b()) {
            h();
        }
    }

    public void c() {
        int size;
        for (size = this.d.size() - 1; size >= 0; size--) {
            b bVar = (b) this.d.get(size);
            View view = bVar.a.a;
            ah.b(view, 0.0f);
            ah.a(view, 0.0f);
            i(bVar.a);
            this.d.remove(size);
        }
        for (size = this.b.size() - 1; size >= 0; size--) {
            h((u) this.b.get(size));
            this.b.remove(size);
        }
        for (size = this.c.size() - 1; size >= 0; size--) {
            u uVar = (u) this.c.get(size);
            ah.c(uVar.a, 1.0f);
            j(uVar);
            this.c.remove(size);
        }
        for (size = this.e.size() - 1; size >= 0; size--) {
            b((a) this.e.get(size));
        }
        this.e.clear();
        if (b()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.g.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.g.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    b bVar2 = (b) arrayList.get(size3);
                    View view2 = bVar2.a.a;
                    ah.b(view2, 0.0f);
                    ah.a(view2, 0.0f);
                    i(bVar2.a);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.g.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    u uVar2 = (u) arrayList.get(size3);
                    ah.c(uVar2.a, 1.0f);
                    j(uVar2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f.remove(arrayList);
                    }
                }
            }
            for (size2 = this.h.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.h.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    b((a) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.h.remove(arrayList);
                    }
                }
            }
            a(this.k);
            a(this.j);
            a(this.i);
            a(this.l);
            h();
        }
    }

    void a(List<u> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ah.p(((u) list.get(size)).a).a();
        }
    }

    public boolean a(u uVar, List<Object> list) {
        return !list.isEmpty() || super.a(uVar, (List) list);
    }
}
