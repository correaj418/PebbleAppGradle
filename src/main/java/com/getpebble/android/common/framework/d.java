package com.getpebble.android.common.framework;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.getpebble.android.common.b.a.f;

public class d extends b {
    public d(Context context, String str) {
        super(context, str);
    }

    public Editor edit() {
        f.f("ReadOnlyPreferences", "Cannot edit ReadyOnlyPreferences");
        return null;
    }
}
