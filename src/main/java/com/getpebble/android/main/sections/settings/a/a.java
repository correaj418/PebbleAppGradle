package com.getpebble.android.main.sections.settings.a;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import com.getpebble.android.common.model.ak;

public class a extends CursorAdapter {
    private final String a;

    public a(Context context, Cursor cursor, String str) {
        super(context, cursor, 0);
        this.a = str;
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return new com.getpebble.android.view.a(context);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        if (view instanceof com.getpebble.android.view.a) {
            com.getpebble.android.view.a aVar = (com.getpebble.android.view.a) view;
            String string = cursor.getString(cursor.getColumnIndex("local_language_name"));
            String string2 = cursor.getString(cursor.getColumnIndex(ak.ISO_LOCALE));
            aVar.setLanguageName(string);
            if (this.a != null && string2 != null && string2.equalsIgnoreCase(this.a)) {
                aVar.setInstalled(true);
            }
        }
    }
}
