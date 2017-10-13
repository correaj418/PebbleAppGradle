package com.getpebble.jskit.android.impl.runtime.a;

import com.getpebble.jskit.android.impl.runtime.model.JsApplicationInfo;

public class b {
    private static final a a = a.WEBVIEW;

    private enum a {
        WEBVIEW {
            a create(com.getpebble.jskit.android.impl.b bVar, JsApplicationInfo jsApplicationInfo, boolean z) {
                return new com.getpebble.jskit.android.impl.runtime.a.a.b(bVar, jsApplicationInfo, z);
            }
        };

        abstract a create(com.getpebble.jskit.android.impl.b bVar, JsApplicationInfo jsApplicationInfo, boolean z);
    }

    public static a a(com.getpebble.jskit.android.impl.b bVar, JsApplicationInfo jsApplicationInfo, boolean z) {
        return a.create(bVar, jsApplicationInfo, z);
    }
}
