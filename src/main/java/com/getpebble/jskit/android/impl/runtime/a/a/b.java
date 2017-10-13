package com.getpebble.jskit.android.impl.runtime.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.getpebble.android.common.b.a.f;
import com.getpebble.jskit.android.impl.runtime.model.JsApplicationInfo;
import java.io.ByteArrayInputStream;
import java.io.File;

public class b extends com.getpebble.jskit.android.impl.runtime.a.a {
    protected e a;
    protected d b = new d(this);
    protected c c = new c(this);
    protected a d = new a(this);
    private WebChromeClient e = new WebChromeClient(this) {
        final /* synthetic */ b a;

        {
            this.a = r1;
        }

        public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
            com.getpebble.jskit.android.a.a.a(3, null, "JsRunnerWebView", "WebChromeClient: onGeolocationPermissionsShowPrompt origin = " + str);
            callback.invoke(str, true, false);
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            this.a.a(consoleMessage.lineNumber(), consoleMessage.message());
            return false;
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            return false;
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            return false;
        }

        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            return false;
        }

        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            return false;
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return false;
        }

        public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            System.out.checkError();
        }
    };
    private WebViewClient f = new WebViewClient(this) {
        final /* synthetic */ b a;

        {
            this.a = r1;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            com.getpebble.jskit.android.a.a.a(3, null, "JsRunnerWebView", "shouldOverrideUrlLoading: url = ", str);
            if (str.startsWith("pebblejs://close")) {
                com.getpebble.jskit.android.a.a.a(6, null, "shouldOverrideUrlLoading: should not happened this url pebblejs://close# is for the configuration page which is lunch by AppSettingsActivity.");
            }
            return true;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            com.getpebble.jskit.android.a.a.a(3, null, "JsRunnerWebView", "onPageFinished: url = ", str);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            com.getpebble.jskit.android.a.a.a(6, null, "JsRunnerWebView", "onReceivedError: errorCode = ", Integer.valueOf(i), ", description = ", str, " failingUrl = ", str2);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            com.getpebble.jskit.android.a.a.a(6, null, "JsRunnerWebView", "onReceivedSslError: sslError = ", sslError);
            sslErrorHandler.proceed();
        }

        @TargetApi(21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            com.getpebble.jskit.android.a.a.a(2, null, "JsRunnerWebView", "shouldInterceptRequest: request = ", webResourceRequest);
            if (a(webResourceRequest.getUrl())) {
                return new a(this.a);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            com.getpebble.jskit.android.a.a.a(3, null, "JsRunnerWebView", "shouldInterceptRequest: url = ", str);
            if (a(Uri.parse(str))) {
                return new a(this.a);
            }
            return super.shouldInterceptRequest(webView, str);
        }

        boolean a(Uri uri) {
            if (uri.getScheme().equalsIgnoreCase("file")) {
                if (uri.getPath().equalsIgnoreCase(this.a.b().k())) {
                    com.getpebble.jskit.android.a.a.a(2, null, "JsRunnerWebView", "shouldInterceptRequest: loading script file");
                    return false;
                }
                Object[] objArr = new Object[2];
                objArr[0] = "JsRunnerWebView";
                objArr[1] = String.format("shouldInterceptRequest: blocking access to file. Expected %s, got %s", new Object[]{r2, uri.toString()});
                com.getpebble.jskit.android.a.a.a(2, null, objArr);
                return true;
            }
            com.getpebble.jskit.android.a.a.a(2, null, "JsRunnerWebView", "Not file scheme; allowing: request = ", uri.toString());
            return false;
        }
    };

    private final class a extends WebResourceResponse {
        final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
            super("text/html", "UTF-8", new ByteArrayInputStream("Forbidden".getBytes()));
        }

        public int getStatusCode() {
            return 403;
        }

        public String getReasonPhrase() {
            return "This resource is forbidden";
        }
    }

    public b(com.getpebble.jskit.android.impl.b bVar, JsApplicationInfo jsApplicationInfo, boolean z) {
        super(bVar, jsApplicationInfo, z);
    }

    public boolean d() {
        com.getpebble.jskit.android.a.a.a(3, null, "JsRunnerWebView", "start:");
        Context a = a().a();
        if (this.a != null) {
            f.f("JsRunnerWebView", "mWebviewJsRunner is not null, webview may be leaked!");
        }
        this.a = new e(a);
        this.a.init();
        WebView a2 = this.a.a();
        a2.setWebViewClient(this.f);
        a2.setWebChromeClient(this.e);
        WebSettings settings = a2.getSettings();
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowFileAccessFromFileURLs(true);
        File dir = a.getDir("webapps_stor", 0);
        if (!dir.mkdirs()) {
            com.getpebble.jskit.android.a.a.a(5, null, "JsRunnerWebView", "mkdirs " + dir.getAbsolutePath() + " returned FALSE");
        }
        settings.setDatabasePath(dir.getAbsolutePath());
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        File cacheDir = a.getCacheDir();
        if (!cacheDir.mkdirs()) {
            com.getpebble.jskit.android.a.a.a(5, null, "JsRunnerWebView", "mkdirs " + cacheDir.getAbsolutePath() + " returned FALSE");
        }
        settings.setAppCachePath(cacheDir.getAbsolutePath());
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(2);
        a2.clearCache(true);
        a2.addJavascriptInterface(this.b, f());
        a2.addJavascriptInterface(this.c, g());
        this.d.a(b().k());
        return true;
    }

    public WebView h() {
        return this.a == null ? null : this.a.a();
    }

    public void i(String str) {
        this.d.b(str);
    }

    public void i() {
        this.d.a(a().c().a());
    }

    public boolean b(String str) {
        return this.d.c(str);
    }

    public boolean c(String str) {
        return this.d.d(str);
    }

    public boolean d(String str) {
        return this.d.e(str);
    }

    public boolean f(String str) {
        return this.d.h(str);
    }

    public boolean g(String str) {
        return this.d.i(str);
    }

    public boolean e() {
        com.getpebble.jskit.android.impl.a.a f = a().f();
        String a = b().a();
        if (f.c(a)) {
            a().d().a(a);
        }
        final e eVar = this.a;
        if (eVar == null) {
            com.getpebble.jskit.android.a.a.a(5, null, "JsRunnerWebView", "stop: mWebviewJsRunner is null.");
            return false;
        }
        com.getpebble.jskit.android.a.a.a(3, null, "JsRunnerWebView", "stop:");
        this.a = null;
        return new Handler(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ b b;

            public void run() {
                WebView a = eVar.a();
                if (a != null) {
                    a.removeJavascriptInterface(this.b.f());
                    a.removeJavascriptInterface(this.b.f());
                }
                eVar.destroyOnMainThread();
            }
        });
    }

    public void a(boolean z) {
        com.getpebble.jskit.android.a.a.a(2, null, "JsRunnerWebView", "setConfirmReadySignal: isConfirmReadySignal = ", Boolean.valueOf(z));
        if (!z) {
            com.getpebble.jskit.android.a.a.a(5, null, "JsRunnerWebView", "setConfirmReadySignal: the app <" + b().a() + "> did not define a listener for 'ready' event in javascript code");
        }
        if (c()) {
            h("{}");
        }
    }

    public boolean h(String str) {
        return this.d.f(str);
    }

    public boolean e(String str) {
        return this.d.g(str);
    }

    public void j(String str) {
        com.getpebble.jskit.android.impl.a.a f = a().f();
        String a = b().a();
        if (f.c(a)) {
            a().d().a(a, str);
            return;
        }
        Context a2 = a().a();
        Intent intent = new Intent("com.getpebble.jskit.android.action.LAUNCH_APP_SETTINGS");
        intent.putExtra("android.app.Activity.EXTRA_APPLICATION_ID", b().a());
        intent.putExtra("android.app.Activity.EXTRA_URL", str);
        intent.addFlags(268435456);
        a2.startActivity(intent);
    }
}
