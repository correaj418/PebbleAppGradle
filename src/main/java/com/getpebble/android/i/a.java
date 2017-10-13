package com.getpebble.android.i;

import android.webkit.WebView;

public class a {
    public static void a(WebView webView) {
        webView.getSettings().setUserAgentString(webView.getSettings().getUserAgentString() + " " + "Pebble/2.0");
    }
}
