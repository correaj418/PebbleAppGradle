package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.ah;
import android.support.v7.view.menu.m.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b implements m {
    protected Context a;
    protected Context b;
    protected g c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    protected n f;
    private a g;
    private int h;
    private int i;

    public abstract void a(h hVar, n.a aVar);

    public b(Context context, int i, int i2) {
        this.a = context;
        this.d = LayoutInflater.from(context);
        this.h = i;
        this.i = i2;
    }

    public void a(Context context, g gVar) {
        this.b = context;
        this.e = LayoutInflater.from(this.b);
        this.c = gVar;
    }

    public void b(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup != null) {
            int i;
            if (this.c != null) {
                this.c.i();
                ArrayList h = this.c.h();
                int size = h.size();
                int i2 = 0;
                i = 0;
                while (i2 < size) {
                    int i3;
                    h hVar = (h) h.get(i2);
                    if (a(i, hVar)) {
                        View childAt = viewGroup.getChildAt(i);
                        h itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                        View a = a(hVar, childAt, viewGroup);
                        if (hVar != itemData) {
                            a.setPressed(false);
                            ah.t(a);
                        }
                        if (a != childAt) {
                            a(a, i);
                        }
                        i3 = i + 1;
                    } else {
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    protected void a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f).addView(view, i);
    }

    protected boolean a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public void a(a aVar) {
        this.g = aVar;
    }

    public a a() {
        return this.g;
    }

    public n.a a(ViewGroup viewGroup) {
        return (n.a) this.d.inflate(this.i, viewGroup, false);
    }

    public View a(h hVar, View view, ViewGroup viewGroup) {
        n.a aVar;
        if (view instanceof n.a) {
            aVar = (n.a) view;
        } else {
            aVar = a(viewGroup);
        }
        a(hVar, aVar);
        return (View) aVar;
    }

    public boolean a(int i, h hVar) {
        return true;
    }

    public void a(g gVar, boolean z) {
        if (this.g != null) {
            this.g.a(gVar, z);
        }
    }

    public boolean a(s sVar) {
        if (this.g != null) {
            return this.g.a(sVar);
        }
        return false;
    }

    public boolean b() {
        return false;
    }

    public boolean a(g gVar, h hVar) {
        return false;
    }

    public boolean b(g gVar, h hVar) {
        return false;
    }
}
