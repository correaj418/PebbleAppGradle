package com.getpebble.jskit.android.impl.c.a;

import com.getpebble.jskit.android.impl.runtime.model.JsApplicationInfo;

public class c extends a {
    private final String a;
    private final String b;

    public c(JsApplicationInfo jsApplicationInfo, String str, String str2) {
        super(jsApplicationInfo);
        this.a = str;
        this.b = str2;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public String toString() {
        return "[JsMsgNotification: mJsApplicationInfo = " + a() + ", mTitle=" + this.a + "]";
    }
}
