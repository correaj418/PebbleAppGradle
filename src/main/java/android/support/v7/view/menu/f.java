package android.support.v7.view.menu;

import android.support.v7.b.a.h;
import android.support.v7.view.menu.n.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class f extends BaseAdapter {
    static final int a = h.abc_popup_menu_item_layout;
    g b;
    private int c = -1;
    private boolean d;
    private final boolean e;
    private final LayoutInflater f;

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public f(g gVar, LayoutInflater layoutInflater, boolean z) {
        this.e = z;
        this.f = layoutInflater;
        this.b = gVar;
        b();
    }

    public void a(boolean z) {
        this.d = z;
    }

    public int getCount() {
        ArrayList k = this.e ? this.b.k() : this.b.h();
        if (this.c < 0) {
            return k.size();
        }
        return k.size() - 1;
    }

    public g a() {
        return this.b;
    }

    public h a(int i) {
        ArrayList k = this.e ? this.b.k() : this.b.h();
        if (this.c >= 0 && i >= this.c) {
            i++;
        }
        return (h) k.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = this.f.inflate(a, viewGroup, false);
        } else {
            inflate = view;
        }
        a aVar = (a) inflate;
        if (this.d) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        aVar.a(a(i), 0);
        return inflate;
    }

    void b() {
        h o = this.b.o();
        if (o != null) {
            ArrayList k = this.b.k();
            int size = k.size();
            for (int i = 0; i < size; i++) {
                if (((h) k.get(i)) == o) {
                    this.c = i;
                    return;
                }
            }
        }
        this.c = -1;
    }

    public void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}
