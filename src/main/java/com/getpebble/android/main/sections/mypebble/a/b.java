package com.getpebble.android.main.sections.mypebble.a;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.getpebble.android.basalt.R;
import java.util.Set;

public class b extends com.c.a.a.b<Character, a, b> {
    private Set<String> l;

    static class a extends com.c.a.a.a.a {
        public TextView a;

        public a(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.contact_header_tv);
        }
    }

    static class b extends com.c.a.a.a.a {
        public TextView a;

        public b(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.contact_name_tv);
        }
    }

    protected /* synthetic */ com.c.a.a.a.a b(Cursor cursor, View view) {
        return a(cursor, view);
    }

    protected /* synthetic */ Object e(Cursor cursor) {
        return d(cursor);
    }

    public b(Context context, Set<String> set) {
        super(context, null, 0, R.layout.view_contact_header, R.layout.view_contact_item);
        this.l = set;
    }

    protected Character d(Cursor cursor) {
        return Character.valueOf(Character.toUpperCase(cursor.getString(cursor.getColumnIndex("display_name")).charAt(0)));
    }

    protected a a(View view, Character ch) {
        return new a(view);
    }

    protected void a(int i, a aVar, ViewGroup viewGroup, Character ch) {
        aVar.a.setText(String.valueOf(ch));
    }

    protected b a(Cursor cursor, View view) {
        return new b(view);
    }

    protected void a(b bVar, Cursor cursor, ViewGroup viewGroup) {
        Drawable a;
        String string = cursor.getString(cursor.getColumnIndex("lookup"));
        CharSequence string2 = cursor.getString(cursor.getColumnIndex("display_name"));
        boolean contains = this.l.contains(string);
        bVar.a.setText(string2);
        if (contains) {
            Context context = viewGroup.getContext();
            a = android.support.v4.content.a.a(context, (int) R.drawable.heart_icon);
            a.setAlpha(127);
            a.setBounds(0, 0, context.getResources().getDimensionPixelSize(R.dimen.sms_heart_width), context.getResources().getDimensionPixelSize(R.dimen.sms_heart_height));
        } else {
            a = null;
        }
        bVar.a.setCompoundDrawables(null, null, a, null);
    }
}
