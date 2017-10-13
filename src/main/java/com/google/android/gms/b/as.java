package com.google.android.gms.b;

import android.content.Context;

public class as {
    private static as b = new as();
    private ar a = null;

    public static ar b(Context context) {
        return b.a(context);
    }

    public synchronized ar a(Context context) {
        if (this.a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.a = new ar(context);
        }
        return this.a;
    }
}
