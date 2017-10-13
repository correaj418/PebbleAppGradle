package com.getpebble.android.main.sections.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.view.View;
import com.getpebble.android.common.model.g;
import com.getpebble.android.main.sections.a.a.d;
import com.google.a.a.i;
import com.google.a.b.as;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class b extends a {
    private List<d> a;
    private boolean b;
    private View c;
    private int d;

    public b(View view, int i) {
        this.c = view;
        this.a = new ArrayList();
        this.b = true;
        this.d = i;
        a(true);
        g();
    }

    public b(View view) {
        this(view, -1);
    }

    public void a(u uVar, int i) {
        ((d) this.a.get(i)).a(uVar);
    }

    public int a() {
        return this.a.size();
    }

    public long b(int i) {
        return ((d) this.a.get(i)).d();
    }

    public void e() {
        this.b = true;
    }

    public void f() {
        this.a.clear();
        g();
        d();
    }

    public void a(List<d> list) {
        if (this.b) {
            this.a.clear();
            this.b = false;
        }
        this.a.addAll(0, list);
        h();
        g();
        d();
    }

    public void b(List<d> list) {
        if (this.b) {
            this.a.clear();
            this.b = false;
        }
        this.a.addAll(list);
        h();
        g();
        d();
    }

    private void h() {
        if (this.d != -1 && this.a.size() > this.d) {
            this.a = this.a.subList(0, this.d);
        }
    }

    private boolean b(final Set<String> set) {
        return as.a(this.a, new i<d>(this) {
            final /* synthetic */ b b;

            public /* synthetic */ boolean apply(Object obj) {
                return a((d) obj);
            }

            public boolean a(d dVar) {
                return set.contains(dVar.a());
            }
        });
    }

    public void a(Set<String> set) {
        if (b((Set) set)) {
            g();
            d();
        }
    }

    public boolean a(final g gVar) {
        int c = as.c(this.a, new i<d>(this) {
            final /* synthetic */ b b;

            public /* synthetic */ boolean apply(Object obj) {
                return a((d) obj);
            }

            public boolean a(d dVar) {
                if (dVar instanceof com.getpebble.android.main.sections.a.a.a) {
                    com.getpebble.android.main.sections.a.a.a aVar = (com.getpebble.android.main.sections.a.a.a) dVar;
                    String uuid = aVar.c().getUUID();
                    if (uuid != null && uuid.equals(gVar.getUUID())) {
                        aVar.b();
                        return true;
                    }
                }
                return false;
            }
        });
        if (c < 0) {
            return false;
        }
        c(c);
        return true;
    }

    public void g() {
        this.c.setVisibility(this.a.isEmpty() ? 8 : 0);
    }
}
