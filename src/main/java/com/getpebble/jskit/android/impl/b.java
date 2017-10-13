package com.getpebble.jskit.android.impl;

import android.content.Context;
import android.os.Handler;
import com.getpebble.jskit.android.impl.runtime.a;

public class b {
    private final com.getpebble.jskit.android.impl.c.b a;
    private final a b;
    private final com.getpebble.jskit.android.impl.a.a c;
    private final com.getpebble.jskit.android.impl.d.b d;
    private final Context e;
    private final Handler f = new Handler();
    private com.getpebble.jskit.android.impl.b.a g;

    public b(Context context) {
        com.getpebble.jskit.android.a.a.a(3, null, "JsClient", "JsClient: <contructor>");
        this.e = context;
        this.c = new com.getpebble.jskit.android.impl.a.a(this);
        this.c.a();
        this.b = new a(this);
        this.b.a();
        this.a = new com.getpebble.jskit.android.impl.c.b();
        this.a.a();
        this.d = new com.getpebble.jskit.android.impl.d.b(this.e);
        this.d.a();
    }

    public Context a() {
        return this.e;
    }

    public int b() {
        com.getpebble.jskit.android.a.a.a(3, null, "JsClient", "getVersionCode:");
        return 0;
    }

    public void a(com.getpebble.jskit.android.impl.b.a aVar) {
        this.g = aVar;
        com.getpebble.jskit.android.a.a.a(this.g);
    }

    public com.getpebble.jskit.android.impl.b.a c() {
        return this.g;
    }

    public com.getpebble.jskit.android.impl.c.b d() {
        return this.a;
    }

    public a e() {
        return this.b;
    }

    public com.getpebble.jskit.android.impl.a.a f() {
        return this.c;
    }

    public com.getpebble.jskit.android.impl.d.b g() {
        return this.d;
    }
}
