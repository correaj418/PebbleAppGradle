package com.getpebble.android.common;

import android.app.Application;
import android.content.Context;

public abstract class a extends Application {
    protected static a c = null;

    protected abstract void a(Throwable th);

    public void onCreate() {
        super.onCreate();
        c = this;
    }

    public static Context K() {
        return c;
    }

    public static void b(Throwable th) {
        c.a(th);
    }
}
