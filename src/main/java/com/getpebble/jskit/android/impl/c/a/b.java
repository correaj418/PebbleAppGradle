package com.getpebble.jskit.android.impl.c.a;

import com.getpebble.jskit.android.impl.runtime.model.JsApplicationInfo;

public class b extends a {
    private final String a;

    public b(JsApplicationInfo jsApplicationInfo, String str) {
        super(jsApplicationInfo);
        this.a = str;
    }

    public String toString() {
        return "[JsMsgNotification: mJsApplicationInfo = " + a() + ", mJsonObjectStringNotificationData=" + this.a + "]";
    }
}
