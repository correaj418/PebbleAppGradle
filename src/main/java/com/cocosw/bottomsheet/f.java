package com.cocosw.bottomsheet;

import android.content.Context;
import android.database.DataSetObserver;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Comparator;

class f extends BaseAdapter {
    SparseArray<a> a = new SparseArray();
    private boolean b = true;
    private int c;
    private LayoutInflater d;
    private ListAdapter e;
    private a[] f = new a[0];
    private Context g;
    private View h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private GridView q;
    private int r;
    private int s;

    public static class a {
        int a;
        int b;
        CharSequence c;
        int d = 0;

        public a(int i, CharSequence charSequence) {
            this.a = i;
            this.c = charSequence;
        }
    }

    public f(Context context, BaseAdapter baseAdapter, int i, int i2, int i3) {
        this.d = (LayoutInflater) context.getSystemService("layout_inflater");
        this.c = i;
        this.r = i2;
        this.s = i3;
        this.e = baseAdapter;
        this.g = context;
        this.e.registerDataSetObserver(new DataSetObserver(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public void onChanged() {
                this.a.b = !this.a.e.isEmpty();
                this.a.notifyDataSetChanged();
            }

            public void onInvalidated() {
                this.a.b = false;
                this.a.notifyDataSetInvalidated();
            }
        });
    }

    public void a(GridView gridView) {
        if (gridView instanceof PinnedSectionGridView) {
            this.q = gridView;
            this.n = gridView.getStretchMode();
            this.k = gridView.getWidth() - (this.q.getPaddingLeft() + this.q.getPaddingRight());
            this.j = ((PinnedSectionGridView) gridView).getNumColumns();
            this.o = ((PinnedSectionGridView) gridView).getColumnWidth();
            this.p = ((PinnedSectionGridView) gridView).getHorizontalSpacing();
            return;
        }
        throw new IllegalArgumentException("Does your grid view extends PinnedSectionGridView?");
    }

    private int b() {
        if (this.i > 0) {
            return this.i;
        }
        if (this.k != this.q.getWidth()) {
            this.n = this.q.getStretchMode();
            this.k = ((PinnedSectionGridView) this.q).a() - (this.q.getPaddingLeft() + this.q.getPaddingRight());
            this.j = ((PinnedSectionGridView) this.q).getNumColumns();
            this.o = ((PinnedSectionGridView) this.q).getColumnWidth();
            this.p = ((PinnedSectionGridView) this.q).getHorizontalSpacing();
        }
        int i = (this.k - (this.j * this.o)) - ((this.j - 1) * this.p);
        switch (this.n) {
            case 0:
                this.k -= i;
                this.l = this.o;
                this.m = this.p;
                break;
            case 1:
                this.l = this.o;
                if (this.j <= 1) {
                    this.m = i + this.p;
                    break;
                }
                this.m = (i / (this.j - 1)) + this.p;
                break;
            case 2:
                this.l = (i / this.j) + this.o;
                this.m = this.p;
                break;
            case 3:
                this.l = this.o;
                this.m = this.p;
                this.k = (this.k - i) + (this.m * 2);
                break;
        }
        this.i = this.k + ((this.j - 1) * (this.l + this.m));
        return this.i;
    }

    public void a(a... aVarArr) {
        this.f = aVarArr;
        a();
    }

    public void a() {
        this.a.clear();
        b();
        Arrays.sort(this.f, new Comparator<a>(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public /* synthetic */ int compare(Object obj, Object obj2) {
                return a((a) obj, (a) obj2);
            }

            public int a(a aVar, a aVar2) {
                if (aVar.a == aVar2.a) {
                    return 0;
                }
                return aVar.a < aVar2.a ? -1 : 1;
            }
        });
        int i = 0;
        for (int i2 = 0; i2 < this.f.length; i2++) {
            a aVar = this.f[i2];
            int i3 = i;
            for (i = 0; i < this.j - 1; i++) {
                a aVar2 = new a(aVar.a, aVar.c);
                aVar2.d = 2;
                aVar2.b = aVar2.a + i3;
                this.a.append(aVar2.b, aVar2);
                i3++;
            }
            a aVar3 = new a(aVar.a, aVar.c);
            aVar3.d = 1;
            aVar3.b = aVar3.a + i3;
            this.a.append(aVar3.b, aVar3);
            i = i3 + 1;
            if (i2 < this.f.length - 1) {
                int i4 = this.f[i2 + 1].a;
                int i5 = this.j - ((i4 - aVar.a) % this.j);
                if (this.j != i5) {
                    i3 = 0;
                    while (i3 < i5) {
                        aVar2 = new a(aVar.a, aVar.c);
                        aVar2.d = 0;
                        aVar2.b = i4 + i;
                        this.a.append(aVar2.b, aVar2);
                        i3++;
                        i++;
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    public int a(int i) {
        if (b(i)) {
            return -1;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.a.size() && ((a) this.a.valueAt(i2)).b <= i) {
            i3--;
            i2++;
        }
        return i + i3;
    }

    public boolean b(int i) {
        return this.a.get(i) != null;
    }

    public int getCount() {
        return this.b ? this.e.getCount() + this.a.size() : 0;
    }

    public Object getItem(int i) {
        return b(i) ? this.a.get(i) : this.e.getItem(a(i));
    }

    public long getItemId(int i) {
        return b(i) ? (long) (Integer.MAX_VALUE - this.a.indexOfKey(i)) : this.e.getItemId(a(i));
    }

    public int getItemViewType(int i) {
        return b(i) ? getViewTypeCount() - 1 : this.e.getItemViewType(a(i));
    }

    public boolean isEnabled(int i) {
        return b(i) ? false : this.e.isEnabled(a(i));
    }

    public int getViewTypeCount() {
        return this.e.getViewTypeCount() + 1;
    }

    public boolean areAllItemsEnabled() {
        return this.e.areAllItemsEnabled();
    }

    public boolean hasStableIds() {
        return this.e.hasStableIds();
    }

    public boolean isEmpty() {
        return this.e.isEmpty();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (b(i)) {
            if (view == null) {
                view = this.d.inflate(this.c, viewGroup, false);
            } else if (view.findViewById(this.r) == null) {
                view = this.d.inflate(this.c, viewGroup, false);
            }
            HeaderLayout headerLayout;
            switch (((a) this.a.get(i)).d) {
                case 1:
                    headerLayout = (HeaderLayout) view.findViewById(this.r);
                    if (!TextUtils.isEmpty(((a) this.a.get(i)).c)) {
                        ((TextView) view.findViewById(this.s)).setText(((a) this.a.get(i)).c);
                    }
                    headerLayout.a(b());
                    return view;
                case 2:
                    headerLayout = (HeaderLayout) view.findViewById(this.r);
                    if (!TextUtils.isEmpty(((a) this.a.get(i)).c)) {
                        ((TextView) view.findViewById(this.s)).setText(((a) this.a.get(i)).c);
                    }
                    headerLayout.a(0);
                    return view;
                default:
                    return a(this.h);
            }
        }
        view = this.e.getView(a(i), view, viewGroup);
        this.h = view;
        return view;
    }

    private d a(View view) {
        d dVar = new d(this.g);
        dVar.a(view);
        return dVar;
    }
}
