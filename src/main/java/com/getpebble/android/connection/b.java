package com.getpebble.android.connection;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import com.getpebble.android.common.model.ak;

public class b extends CursorAdapter {
    private boolean a = false;

    public b(Context context, Cursor cursor, boolean z) {
        super(context, cursor, 0);
        this.a = z;
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return new com.getpebble.android.view.b(context);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        if (view instanceof com.getpebble.android.view.b) {
            ((com.getpebble.android.view.b) view).a(ak.getPebbleDeviceRecordFromCursor(cursor), this.a);
        }
    }
}
