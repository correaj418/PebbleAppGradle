package com.getpebble.jskit.android.impl.c.a;

import com.getpebble.jskit.android.impl.runtime.model.JsApplicationInfo;

public class e extends a {
    private String a;

    public e(JsApplicationInfo jsApplicationInfo, String str) {
        super(jsApplicationInfo);
        this.a = str;
    }

    public String toString() {
        return "[JsMsgNotification: mJsApplicationInfo = " + a() + ", mDeliberatelyOverriddenWatchAppUuidString=" + this.a + "]";
    }
}
