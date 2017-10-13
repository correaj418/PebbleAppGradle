package com.c.a.a;

import android.content.Context;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SectionIndexer;
import com.c.a.a.a.a;
import com.getpebble.android.common.model.ai;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public abstract class b<T, S extends a, H extends a> extends android.support.v4.widget.b implements SectionIndexer {
    protected SortedMap<Integer, T> j = new TreeMap();
    ArrayList<Integer> k = new ArrayList();
    private int l;
    private int m;
    private Object[] n;
    private LayoutInflater o;

    protected abstract S a(View view, T t);

    protected abstract void a(int i, S s, ViewGroup viewGroup, T t);

    protected abstract void a(H h, Cursor cursor, ViewGroup viewGroup);

    protected abstract H b(Cursor cursor, View view);

    protected abstract T e(Cursor cursor);

    public b(Context context, Cursor cursor, int i, int i2, int i3) {
        super(context, cursor, i);
        a(context, null, i2, i3);
    }

    private void a(Context context, SortedMap<Integer, T> sortedMap, int i, int i2) {
        this.l = i;
        this.m = i2;
        this.o = LayoutInflater.from(context);
        if (sortedMap != null) {
            this.j = sortedMap;
        } else {
            f();
        }
    }

    protected LayoutInflater c() {
        return this.o;
    }

    private void f() {
        if (d()) {
            Cursor a = a();
            a.moveToPosition(-1);
            try {
                this.j = f(a);
                if (this.j == null) {
                    this.j = new TreeMap();
                }
            } catch (Throwable e) {
                Log.w(b.class.getName(), "IllegalStateException during build sections. More then likely your cursor has been disconnected from the database, so your cursor will be set to null. In most cases your content observer has already been notified of a database change and SectionCursorAdapter should get a new cursor shortly.", e);
                b(null);
                this.j = new TreeMap();
            }
        }
    }

    protected SortedMap<Integer, T> f(Cursor cursor) {
        SortedMap treeMap = new TreeMap();
        int i = 0;
        while (d() && cursor.moveToNext()) {
            Object e = e(cursor);
            if (cursor.getPosition() != i) {
                throw new com.c.a.b.a("Do no move the cursor's position in getSectionFromCursor.");
            }
            if (!treeMap.containsValue(e)) {
                treeMap.put(Integer.valueOf(treeMap.size() + i), e);
            }
            i++;
        }
        return treeMap;
    }

    public int getCount() {
        return super.getCount() + this.j.size();
    }

    public int getViewTypeCount() {
        return 2;
    }

    public Object getItem(int i) {
        if (a(i)) {
            return this.j.get(Integer.valueOf(i));
        }
        return super.getItem(b(i));
    }

    public long getItemId(int i) {
        if (a(i)) {
            return (long) i;
        }
        int b = b(i);
        Cursor a = a();
        if (d() && a.moveToPosition(b)) {
            return a.getLong(a.getColumnIndex(ai.COLUMN_ID));
        }
        return -99;
    }

    public void notifyDataSetChanged() {
        if (d()) {
            f();
            this.n = null;
            this.k.clear();
        }
        super.notifyDataSetChanged();
    }

    public void notifyDataSetInvalidated() {
        if (d()) {
            f();
            this.n = null;
            this.k.clear();
        }
        super.notifyDataSetInvalidated();
    }

    protected boolean d() {
        Cursor a = a();
        if (a != null && a.isClosed()) {
            b(null);
            return false;
        } else if (a != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean a(int i) {
        return this.j.containsKey(Integer.valueOf(i));
    }

    public int b(int i) {
        if (this.j.size() == 0) {
            return i;
        }
        if (a(i)) {
            return -99;
        }
        int c = c(i);
        if (a(i, c)) {
            return i;
        }
        return i - (c + 1);
    }

    public int c(int i) {
        int i2 = 0;
        int i3 = 0;
        for (Integer num : this.j.keySet()) {
            int i4;
            if (i <= num.intValue()) {
                if (i != num.intValue()) {
                    break;
                }
                i4 = i2;
                i2 = 1;
            } else {
                i4 = i2 + 1;
                i2 = i3;
            }
            i3 = i2;
            i2 = i4;
        }
        return i3 != 0 ? i2 : Math.max(i2 - 1, 0);
    }

    private boolean a(int i, int i2) {
        Object obj;
        if (this.j == null || this.j.size() <= 0) {
            obj = null;
        } else {
            obj = 1;
        }
        if (i2 != 0 || r0 == null || i >= ((Integer) this.j.firstKey()).intValue()) {
            return false;
        }
        return true;
    }

    public int getItemViewType(int i) {
        return a(i) ? 0 : 1;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View a;
        boolean a2 = a(i);
        Cursor a3 = a();
        if (!a2) {
            int b = b(i);
            if (!d()) {
                return new View(viewGroup.getContext());
            }
            if (!a3.moveToPosition(b)) {
                throw new IllegalStateException("couldn't move cursor to position " + b);
            }
        }
        if (view == null) {
            a = a2 ? a(viewGroup, getItem(i)) : a(a3, viewGroup);
        } else {
            a = view;
        }
        if (a2) {
            a(i, (a) a.getTag(), viewGroup, this.j.get(Integer.valueOf(i)));
        } else {
            a((a) a.getTag(), a3, viewGroup);
        }
        return a;
    }

    @Deprecated
    public final View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        throw new IllegalStateException("This method is not used by " + b.class.getSimpleName());
    }

    @Deprecated
    public final void a(View view, Context context, Cursor cursor) {
        throw new IllegalStateException("This method is not used by " + b.class.getSimpleName());
    }

    protected View a(ViewGroup viewGroup, T t) {
        View inflate = c().inflate(this.l, viewGroup, false);
        inflate.setTag(a(inflate, (Object) t));
        return inflate;
    }

    protected View a(Cursor cursor, ViewGroup viewGroup) {
        View inflate = c().inflate(this.m, viewGroup, false);
        inflate.setTag(b(cursor, inflate));
        return inflate;
    }

    public int getPositionForSection(int i) {
        if (this.k.size() == 0) {
            for (Integer add : this.j.keySet()) {
                this.k.add(add);
            }
        }
        return i < this.k.size() ? ((Integer) this.k.get(i)).intValue() : getCount();
    }

    public int getSectionForPosition(int i) {
        Object[] sections = getSections();
        int c = c(i);
        return c < sections.length ? c : 0;
    }

    public Object[] getSections() {
        if (this.n == null) {
            this.n = g();
        }
        return this.n;
    }

    protected int e() {
        return 3;
    }

    private Object[] g() {
        if (this.j == null) {
            return new Object[0];
        }
        String[] strArr = new String[this.j.size()];
        int e = VERSION.SDK_INT < 19 ? e() : Integer.MAX_VALUE;
        int i = 0;
        for (Object next : this.j.values()) {
            if (next == null) {
                strArr[i] = "";
            } else if (next.toString().length() >= e) {
                strArr[i] = next.toString().substring(0, e);
            } else {
                strArr[i] = next.toString();
            }
            i++;
        }
        return strArr;
    }
}
