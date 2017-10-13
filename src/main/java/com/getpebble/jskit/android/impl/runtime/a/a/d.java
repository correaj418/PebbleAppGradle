package com.getpebble.jskit.android.impl.runtime.a.a;

import android.webkit.JavascriptInterface;
import com.getpebble.jskit.android.a.a;
import com.getpebble.jskit.android.impl.b;
import com.getpebble.jskit.android.impl.c.a.c;

public class d {
    protected final b a;

    public d(b bVar) {
        this.a = bVar;
    }

    @JavascriptInterface
    public void showSimpleNotificationOnPebble(String str, String str2) {
        a.a(2, null, "PublicJsInterfaceWebView", "showSimpleNotificationOnPebble: title = ", str, " notificationText = ", str2);
        b a = this.a.a();
        com.getpebble.jskit.android.impl.b.a c = a.c();
        c cVar = new c(this.a.b(), str, str2);
        c.a(cVar);
        a.d().a(cVar);
    }

    @JavascriptInterface
    public String getAccountToken() {
        a.a(2, null, "PublicJsInterfaceWebView", "getAccountToken:");
        com.getpebble.jskit.android.impl.b.a a = a();
        if (a == null) {
            return null;
        }
        return a.a(this.a.b().a());
    }

    @JavascriptInterface
    public String getWatchToken() {
        a.a(2, null, "PublicJsInterfaceWebView", "getWatchToken:");
        com.getpebble.jskit.android.impl.b.a a = a();
        if (a == null) {
            return null;
        }
        return a.b(this.a.b().a());
    }

    @JavascriptInterface
    public void showToast(String str) {
        a.a(2, null, "PublicJsInterfaceWebView", "showToast:");
        a.a(2, null, "PublicJsInterfaceWebView", "showToast: toast = ", str);
        b a = this.a.a();
        com.getpebble.jskit.android.impl.b.a c = a.c();
        com.getpebble.jskit.android.impl.c.a.d dVar = new com.getpebble.jskit.android.impl.c.a.d(this.a.b(), str);
        c.a(dVar);
        a.d().a(dVar);
    }

    @JavascriptInterface
    public void showNotificationOnPebble(String str) {
        a.a(2, null, "PublicJsInterfaceWebView", "showNotificationOnPebble: jsonObjectStringNotificationData = ", str);
        b a = this.a.a();
        com.getpebble.jskit.android.impl.b.a c = a.c();
        com.getpebble.jskit.android.impl.c.a.b bVar = new com.getpebble.jskit.android.impl.c.a.b(this.a.b(), str);
        c.a(bVar);
        a.d().a(bVar);
    }

    @JavascriptInterface
    public String openURL(String str) {
        a.a(2, null, "PublicJsInterfaceWebView", "openURL:");
        this.a.a(com.getpebble.jskit.android.a.a.OPEN_URL);
        this.a.j(str);
        return str;
    }

    private com.getpebble.jskit.android.impl.b.a a() {
        b a = this.a.a();
        return a == null ? null : a.c();
    }
}
