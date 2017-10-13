package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;

public abstract class r {
    private static final Object a = new Object();
    private static r b;

    public static r a(Context context) {
        synchronized (a) {
            if (b == null) {
                b = new s(context.getApplicationContext());
            }
        }
        return b;
    }

    public abstract boolean a(String str, String str2, ServiceConnection serviceConnection, String str3);

    public abstract void b(String str, String str2, ServiceConnection serviceConnection, String str3);
}
