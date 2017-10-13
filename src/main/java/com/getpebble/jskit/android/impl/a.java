package com.getpebble.jskit.android.impl;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.getpebble.jskit.android.impl.c.a.b;
import com.getpebble.jskit.android.impl.c.a.c;
import com.getpebble.jskit.android.impl.c.a.d;
import com.getpebble.jskit.android.impl.c.a.e;
import com.getpebble.jskit.android.impl.c.a.f;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

public abstract class a extends Activity {
    private String a;
    private String b;
    private WebView c;
    private ProgressBar d;
    private com.getpebble.jskit.android.impl.c.a e = new com.getpebble.jskit.android.impl.c.a(this) {
        final /* synthetic */ a a;

        {
            this.a = r1;
        }

        public void a(c cVar) {
        }

        public void a(b bVar) {
        }

        public void a(d dVar) {
        }

        public void a(e eVar) {
        }

        public void a(f fVar) {
        }

        public void a(String str, String str2) {
            com.getpebble.jskit.android.a.a.a(2, null, "AbstractAppSettingsActivity", "onLoadConfigurationScreen(", str, a.d(str2), ")");
            if (str.equals(this.a.a)) {
                this.a.b = str2;
                this.a.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        this.a.a.c(this.a.a.b);
                    }
                });
                return;
            }
            com.getpebble.jskit.android.a.a.a(3, null, "AbstractAppSettingsActivity", "onLoadConfigurationScreen: expected application ID", this.a.a, " got ", str, " dropping event");
        }

        public void a(String str) {
            com.getpebble.jskit.android.a.a.a(2, null, "AbstractAppSettingsActivity", "onCloseConfigurationScreen(", str, ")");
            if (str.equals(this.a.a)) {
                this.a.finish();
                return;
            }
            com.getpebble.jskit.android.a.a.a(3, null, "AbstractAppSettingsActivity", "onCloseConfigurationScreen: expected application ID", this.a.a, " got ", str, " dropping event");
        }
    };
    private WebViewClient f = new WebViewClient(this) {
        final /* synthetic */ a a;

        {
            this.a = r1;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (a(str) || b(str)) {
                return true;
            }
            com.getpebble.jskit.android.a.a.a(5, null, "AbstractAppSettingsActivity", "shouldOverrideUrlLoading: app can not handle this url");
            return false;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            this.a.d.setVisibility(0);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            com.getpebble.jskit.android.a.a.a(3, null, "AbstractAppSettingsActivity", "onPageFinished: url = ", a.d(str));
            this.a.d.setVisibility(8);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            com.getpebble.jskit.android.a.a.a(6, null, "AbstractAppSettingsActivity", "onReceivedError: errorCode = ", Integer.valueOf(i), ", description = ", str, " failingUrl = ", a.d(str2));
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            com.getpebble.jskit.android.a.a.a(6, null, "AbstractAppSettingsActivity", "onReceivedSslError: sslError = ", sslError);
            sslErrorHandler.proceed();
        }

        private boolean a(String str) {
            try {
                URI uri = new URI(str);
                String scheme = uri.getScheme();
                if (c(str)) {
                    String encode;
                    scheme = d(str);
                    try {
                        encode = URLEncoder.encode(scheme, "UTF-8");
                    } catch (Throwable e) {
                        com.getpebble.jskit.android.a.a.a(6, e, "shouldOverrideUrlLoading: error ");
                        encode = null;
                    }
                    a aVar = this.a;
                    String a = this.a.a;
                    if (encode == null) {
                        encode = scheme;
                    }
                    aVar.a(a, encode);
                    this.a.finish();
                    return true;
                }
                if (scheme.contains("mailto")) {
                    return com.getpebble.jskit.android.a.b.a(this.a, uri);
                }
                return false;
            } catch (URISyntaxException e2) {
                com.getpebble.jskit.android.a.a.a(5, null, "AbstractAppSettingsActivity", "handleCloseUrl: url is not URI it will be handle as a string");
            }
        }

        private boolean b(String str) {
            if (!c(str)) {
                return false;
            }
            this.a.a(this.a.a, d(str));
            this.a.finish();
            return true;
        }

        private boolean c(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("pebblejs://close");
        }

        private String d(String str) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str.replace("pebblejs://close#", "").replace("pebblejs://close", "");
        }
    };

    public abstract void a(String str);

    public abstract void a(String str, com.getpebble.jskit.android.impl.c.a aVar);

    public abstract void a(String str, String str2);

    public abstract void b(String str, com.getpebble.jskit.android.impl.c.a aVar);

    protected void onNewIntent(Intent intent) {
        com.getpebble.jskit.android.a.a.a(2, null, "AbstractAppSettingsActivity", "onNewIntent()");
        setIntent(intent);
        a();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.getpebble.jskit.android.a.a.a(2, null, "AbstractAppSettingsActivity", "onCreate()");
        setContentView(com.getpebble.jskit.android.b.b.activity_app_setting);
        a();
    }

    private void a() {
        b();
        c();
        c(this.b);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    private void b() {
        Intent intent = getIntent();
        this.a = intent.getStringExtra("android.app.Activity.EXTRA_APPLICATION_ID");
        this.b = intent.getStringExtra("android.app.Activity.EXTRA_URL");
    }

    private void c() {
        this.c = (WebView) findViewById(com.getpebble.jskit.android.b.a.webview);
        this.c.setWebViewClient(this.f);
        this.c.setWebChromeClient(new WebChromeClient());
        WebSettings settings = this.c.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowContentAccess(false);
        settings.setDomStorageEnabled(true);
        this.d = (ProgressBar) findViewById(com.getpebble.jskit.android.b.a.progress_bar);
        this.d.setVisibility(8);
    }

    private void c(String str) {
        this.c.loadUrl(str);
    }

    protected void onResume() {
        super.onResume();
        a(this.a, this.e);
    }

    protected void onPause() {
        super.onPause();
        b(this.a, this.e);
        a(this.a);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.c.canGoBack()) {
            this.c.goBack();
            return true;
        }
        a(this.a, "");
        return super.onKeyDown(i, keyEvent);
    }

    private static String d(String str) {
        if (str == null) {
            return null;
        }
        return str.length() >= 500 ? str.substring(0, 500) : str;
    }
}
