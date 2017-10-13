package com.c.a.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class a<K, V, S extends com.c.a.a.a.a, H extends com.c.a.a.a.a> extends BaseAdapter implements SectionIndexer {
    private int a;
    private int b;
    int c = 0;
    private LayoutInflater d;
    private LinkedHashMap<K, List<V>> e;
    private Object[] f;
    private boolean g = true;
    private LinkedHashSet<Integer> h = new LinkedHashSet();
    private boolean i;

    protected abstract H a(int i, View view, V v);

    protected abstract S a(View view, K k);

    protected abstract K a(V v);

    protected abstract void a(int i, int i2, H h, ViewGroup viewGroup, V v);

    protected abstract void a(int i, S s, ViewGroup viewGroup, K k);

    public a(Context context, int i, int i2, List<V> list) {
        a(context, i, i2);
        b((List) list);
    }

    private void a(Context context, int i, int i2) {
        this.d = LayoutInflater.from(context);
        this.a = i;
        this.b = i2;
    }

    protected LayoutInflater c() {
        return this.d;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getCount() {
        if (this.c == 0 && this.e != null) {
            b();
        }
        return this.c;
    }

    private void b() {
        this.c = 0;
        for (Object next : this.e.keySet()) {
            List list = (List) this.e.get(next);
            if (next != null) {
                this.c++;
            }
            if (list != null) {
                this.c = list.size() + this.c;
            }
        }
    }

    public int getViewTypeCount() {
        return 2;
    }

    public void b(List<V> list) {
        if (list == null) {
            list = new ArrayList();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : r6) {
            Object a = a(next);
            List arrayList = linkedHashMap.containsKey(a) ? (List) linkedHashMap.get(a) : new ArrayList();
            arrayList.add(next);
            linkedHashMap.put(a, arrayList);
        }
        a(linkedHashMap);
    }

    public void a(LinkedHashMap<K, List<V>> linkedHashMap) {
        this.e = linkedHashMap;
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.c = 0;
        this.g = true;
        this.i = this.e.containsKey(null);
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        this.c = 0;
        this.g = true;
        this.i = this.e.containsKey(null);
    }

    public Set<Integer> d() {
        if (this.g && this.e != null) {
            this.h.clear();
            int i = 0;
            for (Object next : this.e.keySet()) {
                int i2;
                if (next != null) {
                    this.h.add(Integer.valueOf(i));
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                if (this.e.get(next) != null) {
                    i = ((List) this.e.get(next)).size() + i2;
                } else {
                    i = i2;
                }
            }
            this.g = false;
        } else if (this.g) {
            this.h.clear();
            this.g = false;
        }
        return this.h;
    }

    public K a(int i) {
        int i2 = this.i ? -1 : 0;
        for (K next : this.e.keySet()) {
            if (i2 == i) {
                return next;
            }
            i2++;
        }
        return null;
    }

    public V a(int i, int i2) {
        if (i >= d().size()) {
            return null;
        }
        List list = (List) this.e.get(a(i));
        return i2 < list.size() ? list.get(i2) : null;
    }

    public Object getItem(int i) {
        if (this.e == null || i >= getCount()) {
            return null;
        }
        int b = b(i);
        if (d().contains(Integer.valueOf(i))) {
            return a(b);
        }
        return a(b, c(i));
    }

    public int b(int i) {
        if (d().size() == 0) {
            return -1;
        }
        Object obj = 1;
        int i2 = -1;
        for (Integer num : d()) {
            i2++;
            if (num.intValue() == i) {
                break;
            } else if (num.intValue() <= i) {
                obj = null;
            } else if (obj == null) {
                return i2 - 1;
            } else {
                return -1;
            }
        }
        return i2;
    }

    public int c(int i) {
        if (i >= getCount()) {
            return -1;
        }
        int i2 = i;
        for (Integer num : d()) {
            if (i < num.intValue()) {
                return i2;
            }
            i2 = (i - num.intValue()) - 1;
        }
        return i2;
    }

    public boolean d(int i) {
        return d().contains(Integer.valueOf(i));
    }

    public int getItemViewType(int i) {
        if (d().contains(Integer.valueOf(i))) {
            return 0;
        }
        return 1;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int b = b(i);
        if (d().contains(Integer.valueOf(i))) {
            Object a = a(b);
            if (view == null) {
                view = a(viewGroup, a);
            }
            a(b, (com.c.a.a.a.a) view.getTag(), viewGroup, a);
        } else if (getItemViewType(i) >= 1) {
            int c = c(i);
            Object a2 = a(b, c);
            if (view == null) {
                view = a(b, viewGroup, a2);
            }
            a(b, c, (com.c.a.a.a.a) view.getTag(), viewGroup, a2);
        }
        return view;
    }

    protected View a(ViewGroup viewGroup, K k) {
        View inflate = c().inflate(this.a, viewGroup, false);
        inflate.setTag(a(inflate, (Object) k));
        return inflate;
    }

    protected View a(int i, ViewGroup viewGroup, V v) {
        View inflate = c().inflate(this.b, viewGroup, false);
        inflate.setTag(a(i, inflate, (Object) v));
        return inflate;
    }

    public int getPositionForSection(int i) {
        int i2 = 0;
        if (this.i && i == 0) {
            return 0;
        }
        int i3;
        if (this.i) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        for (Integer intValue : d()) {
            int intValue2 = intValue.intValue();
            if (i2 + i3 == i) {
                return intValue2;
            }
            i2++;
        }
        return getCount();
    }

    public int getSectionForPosition(int i) {
        int b = b(i) + 1;
        return b > 0 ? b : 0;
    }

    public Object[] getSections() {
        if (this.f == null) {
            this.f = e();
        }
        return this.f;
    }

    protected int a() {
        return 3;
    }

    private Object[] e() {
        if (this.e == null) {
            return new Object[0];
        }
        String[] strArr = new String[this.e.size()];
        int a = VERSION.SDK_INT < 19 ? a() : Integer.MAX_VALUE;
        int i = 0;
        for (Object next : this.e.keySet()) {
            if (next == null) {
                strArr[i] = "";
            } else if (next.toString().length() >= a) {
                strArr[i] = next.toString().substring(0, a);
            } else {
                strArr[i] = next.toString();
            }
            i++;
        }
        return strArr;
    }
}
