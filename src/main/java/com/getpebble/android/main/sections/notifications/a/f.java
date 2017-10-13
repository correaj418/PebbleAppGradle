package com.getpebble.android.main.sections.notifications.a;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import com.getpebble.android.common.model.ae;

public class f extends CursorAdapter {
    public f(Context context, Cursor cursor, boolean z) {
        super(context, cursor, z);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return new e(context);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        if (view instanceof e) {
            ((e) view).setModel(ae.a(cursor));
        }
    }
}
