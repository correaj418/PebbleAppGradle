package com.getpebble.android.mms;

import android.content.Context;
import com.getpebble.android.mms.b.a;
import com.getpebble.android.mms.b.b;

public class c {
    private f a = null;
    private b b;
    private a c;

    public c(Context context) {
        this.b = new i(new com.getpebble.android.common.b.b.c(context));
        this.c = new a(context);
        this.a = new f(this.c, this.b, new h());
    }

    public void a(Context context) {
        context.getContentResolver().registerContentObserver(j.b.a, true, this.a);
        this.b.a(this.c.a());
    }
}
