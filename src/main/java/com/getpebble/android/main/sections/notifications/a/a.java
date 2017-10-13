package com.getpebble.android.main.sections.notifications.a;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import com.getpebble.android.common.model.af;

public class a extends CursorAdapter {
    public a(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return new b(context);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        if (view instanceof b) {
            ((b) view).setModel(new c(af.a(cursor), context));
        }
    }
}
