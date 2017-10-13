package com.getpebble.android.main.sections.mypebble.a;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.am.c;
import java.util.List;

public class d extends CursorLoader {
    private List<c> a;

    public d(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context, uri, strArr, str, strArr2, str2);
    }

    public Cursor loadInBackground() {
        f.e("AppsCursorLoader", "loadInBackground");
        Cursor loadInBackground = super.loadInBackground();
        this.a = am.d(loadInBackground);
        return loadInBackground;
    }

    public List<c> a() {
        return this.a;
    }
}
