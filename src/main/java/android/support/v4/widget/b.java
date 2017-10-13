package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import com.getpebble.android.common.model.ai;

public abstract class b extends BaseAdapter implements a, Filterable {
    protected boolean a;
    protected boolean b;
    protected Cursor c;
    protected Context d;
    protected int e;
    protected a f;
    protected DataSetObserver g;
    protected c h;
    protected FilterQueryProvider i;

    private class a extends ContentObserver {
        final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            this.a.b();
        }
    }

    private class b extends DataSetObserver {
        final /* synthetic */ b a;

        private b(b bVar) {
            this.a = bVar;
        }

        public void onChanged() {
            this.a.a = true;
            this.a.notifyDataSetChanged();
        }

        public void onInvalidated() {
            this.a.a = false;
            this.a.notifyDataSetInvalidated();
        }
    }

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void a(View view, Context context, Cursor cursor);

    public b(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    public b(Context context, Cursor cursor, int i) {
        a(context, cursor, i);
    }

    void a(Context context, Cursor cursor, int i) {
        boolean z = true;
        if ((i & 1) == 1) {
            i |= 2;
            this.b = true;
        } else {
            this.b = false;
        }
        if (cursor == null) {
            z = false;
        }
        this.c = cursor;
        this.a = z;
        this.d = context;
        this.e = z ? cursor.getColumnIndexOrThrow(ai.COLUMN_ID) : -1;
        if ((i & 2) == 2) {
            this.f = new a(this);
            this.g = new b();
        } else {
            this.f = null;
            this.g = null;
        }
        if (z) {
            if (this.f != null) {
                cursor.registerContentObserver(this.f);
            }
            if (this.g != null) {
                cursor.registerDataSetObserver(this.g);
            }
        }
    }

    public Cursor a() {
        return this.c;
    }

    public int getCount() {
        if (!this.a || this.c == null) {
            return 0;
        }
        return this.c.getCount();
    }

    public Object getItem(int i) {
        if (!this.a || this.c == null) {
            return null;
        }
        this.c.moveToPosition(i);
        return this.c;
    }

    public long getItemId(int i) {
        if (this.a && this.c != null && this.c.moveToPosition(i)) {
            return this.c.getLong(this.e);
        }
        return 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.c.moveToPosition(i)) {
            if (view == null) {
                view = a(this.d, this.c, viewGroup);
            }
            a(view, this.d, this.c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.a) {
            return null;
        }
        this.c.moveToPosition(i);
        if (view == null) {
            view = b(this.d, this.c, viewGroup);
        }
        a(view, this.d, this.c);
        return view;
    }

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return a(context, cursor, viewGroup);
    }

    public void a(Cursor cursor) {
        Cursor b = b(cursor);
        if (b != null) {
            b.close();
        }
    }

    public Cursor b(Cursor cursor) {
        if (cursor == this.c) {
            return null;
        }
        Cursor cursor2 = this.c;
        if (cursor2 != null) {
            if (this.f != null) {
                cursor2.unregisterContentObserver(this.f);
            }
            if (this.g != null) {
                cursor2.unregisterDataSetObserver(this.g);
            }
        }
        this.c = cursor;
        if (cursor != null) {
            if (this.f != null) {
                cursor.registerContentObserver(this.f);
            }
            if (this.g != null) {
                cursor.registerDataSetObserver(this.g);
            }
            this.e = cursor.getColumnIndexOrThrow(ai.COLUMN_ID);
            this.a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.e = -1;
        this.a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    public CharSequence c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor a(CharSequence charSequence) {
        if (this.i != null) {
            return this.i.runQuery(charSequence);
        }
        return this.c;
    }

    public Filter getFilter() {
        if (this.h == null) {
            this.h = new c(this);
        }
        return this.h;
    }

    protected void b() {
        if (this.b && this.c != null && !this.c.isClosed()) {
            this.a = this.c.requery();
        }
    }
}
