package com.getpebble.jskit.android.impl.c.a;

import com.getpebble.jskit.android.impl.runtime.model.JsApplicationInfo;

public class d extends a {
    private final String a;

    public d(JsApplicationInfo jsApplicationInfo, String str) {
        super(jsApplicationInfo);
        this.a = str;
    }

    public String b() {
        return this.a;
    }

    public String toString() {
        return "[JsMsgNotification: mJsApplicationInfo = " + a() + ", mToast=" + this.a + "]";
    }
}
