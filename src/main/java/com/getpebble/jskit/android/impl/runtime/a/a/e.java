package com.getpebble.jskit.android.impl.runtime.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

@SuppressLint({"SetJavaScriptEnabled"})
public class e {
    private final Context a;
    private WebView b;
    private final Handler c = new Handler(Looper.getMainLooper());

    public interface a {
        void a(e eVar);
    }

    public interface d {
        void a(e eVar, String str);
    }

    public interface c {
        @JavascriptInterface
        String getInterfaceName();
    }

    public static class b implements c {
        private static String c = "_fileLoader";
        final e a;
        final a b;

        public b(e eVar, a aVar) {
            this.a = eVar;
            this.b = aVar;
        }

        @JavascriptInterface
        public String getInterfaceName() {
            return c;
        }

        @JavascriptInterface
        public void onFileLoaded() {
            this.a.c.post(new Runnable(this) {
                final /* synthetic */ b a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.b.a(this.a.a);
                }
            });
        }
    }

    public static class e implements c {
        final e a;
        final d b;

        public e(e eVar, d dVar) {
            this.a = eVar;
            this.b = dVar;
        }

        @JavascriptInterface
        public String getInterfaceName() {
            return "_jsRunner";
        }

        @JavascriptInterface
        public void onJsResult(final String str) {
            com.getpebble.jskit.android.a.a.a(2, null, "onJsResult: " + str);
            this.a.c.post(new Runnable(this) {
                final /* synthetic */ e b;

                public void run() {
                    this.b.b.a(this.b.a, str);
                }
            });
        }
    }

    public e(Context context) {
        this.a = context;
    }

    public void init() {
        com.getpebble.jskit.android.a.a.a(3, null, "WebviewJsRunner", "init()");
        this.b = new WebView(this.a);
        this.b.setWillNotDraw(true);
        WebSettings settings = this.b.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(false);
    }

    public e setFileLoadCallback(a aVar) {
        if (aVar != null) {
            addJsInterface(new b(this, aVar));
        }
        return this;
    }

    public e setJsResultCallback(d dVar) {
        if (dVar != null) {
            addJsInterface(new e(this, dVar));
        }
        return this;
    }

    public void destroyOnMainThread() {
        com.getpebble.jskit.android.a.a.a(3, null, "WebviewJsRunner", "destroyOnMainThread");
        if (isInit()) {
            this.c.removeCallbacksAndMessages(null);
            this.b.removeJavascriptInterface(b.c);
            this.b.removeJavascriptInterface("_jsRunner");
            this.b.loadUrl("about:blank");
            this.b.stopLoading();
            if (VERSION.SDK_INT < 19) {
                this.b.freeMemory();
            }
            this.b.clearHistory();
            this.b.removeAllViews();
            this.b.destroyDrawingCache();
            this.b.clearCache(true);
            this.b.destroy();
            this.b = null;
            return;
        }
        com.getpebble.jskit.android.a.a.a(3, null, "WebviewJsRunner", "destroyOnMainThread: already destroyed");
    }

    public void loadFile(String str) {
        this.b.loadUrl(str);
    }

    public void evaluateJavascript(String str) {
        this.b.loadUrl("javascript:(_jsRunner.onJsResult(JSON.stringify(" + str + ")));");
    }

    public void addJsInterface(c cVar) {
        com.getpebble.jskit.android.a.a.a(2, null, "WebviewJsRunner", "addJsInterface: " + cVar.getInterfaceName());
        this.b.addJavascriptInterface(cVar, cVar.getInterfaceName());
    }

    public void removeJsInterface(c cVar) {
        com.getpebble.jskit.android.a.a.a(2, null, "WebviewJsRunner", "removeJsInterface " + cVar.getInterfaceName());
        this.b.removeJavascriptInterface(cVar.getInterfaceName());
    }

    WebView a() {
        return this.b;
    }

    public boolean isInit() {
        return this.b != null;
    }
}
