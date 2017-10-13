package com.getpebble.jskit.android.impl.runtime.a.a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.getpebble.android.framework.timeline.e;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
    protected b a;
    protected final Handler b = new Handler(Looper.getMainLooper());

    enum a {
        LoadScript("loadScript"),
        NewAppMessageData("signalNewAppMessageData"),
        AppMessageAck("signalAppMessageAck"),
        AppMessageNack("signalAppMessageNack"),
        LaunchSettings("signalSettingsWebuiLaunchOpportunity"),
        Ready("signalReady"),
        Closed("signalWebviewClosedEvent"),
        TimelineTokenSuccess("signalTimelineTokenSuccess"),
        TimelineTokenFailure("signalTimelineTokenFailure");
        
        final String command;

        private a(String str) {
            this.command = str;
        }

        String command() {
            return "javascript:" + this.command + "()";
        }

        String commandWithArg(String str) {
            if (str == null) {
                return command();
            }
            return "javascript:" + this.command + "('" + str + "')";
        }
    }

    public a(b bVar) {
        this.a = bVar;
    }

    public boolean a(String str) {
        String jSONObject;
        com.getpebble.jskit.android.a.a.a(3, null, "JavascriptHandlerWebView", "loadStartUpScript: params = ", str);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("loadUrl", str);
            jSONObject = jSONObject2.toString();
        } catch (Throwable e) {
            com.getpebble.jskit.android.a.a.a(6, e, "JavascriptHandlerWebView", "Error thrown when loading startup script");
            jSONObject = null;
        }
        if (jSONObject != null) {
            try {
                jSONObject = "params=" + URLEncoder.encode(jSONObject, "UTF-8");
            } catch (Throwable e2) {
                com.getpebble.jskit.android.a.a.a(6, e2, "JavascriptHandlerWebView", "Failed to encode parameters; not valid UTF-8", jSONObject);
                jSONObject = null;
            }
        }
        com.getpebble.jskit.android.a.a.a(3, null, "JavascriptHandlerWebView", "loadStartUpScript: finalParam = ", jSONObject);
        if (jSONObject != null) {
            final WebView h = this.a.h();
            if (h == null) {
                com.getpebble.jskit.android.a.a.a(5, null, "JavascriptHandlerWebView", "loadStartUpScript: the JsRunnverWebview's webview is null");
                return false;
            }
            this.b.post(new Runnable(this) {
                final /* synthetic */ a c;

                public void run() {
                    com.getpebble.jskit.android.a.a.a(3, null, "JavascriptHandlerWebView", "loadStartUpScript: RUN  loadUrl");
                    h.loadUrl("file:///android_asset/webview_startup.html?" + jSONObject);
                }
            });
        }
        return true;
    }

    public boolean b(String str) {
        com.getpebble.jskit.android.a.a.a(3, null, "JavascriptHandlerWebView", "loadAppScript: extraDataForLoading = ", str);
        if (str == null) {
            com.getpebble.jskit.android.a.a.a(3, null, "JavascriptHandlerWebView", "loadAppScript: extraDataFromJsLoading is null");
            return false;
        }
        try {
            try {
                final String optString = new JSONObject(URLDecoder.decode(str, "UTF-8")).optString("loadUrl");
                if (optString.isEmpty() || !optString.endsWith("js")) {
                    com.getpebble.jskit.android.a.a.a(3, null, "JavascriptHandlerWebView", "loadAppScript: urlSpec is null or invalid ");
                } else {
                    final WebView h = this.a.h();
                    if (h == null) {
                        com.getpebble.jskit.android.a.a.a(5, null, "JavascriptHandlerWebView", "loadScript: the JsRunnverWebview's webview is null");
                        return false;
                    }
                    this.b.post(new Runnable(this) {
                        final /* synthetic */ a c;

                        public void run() {
                            h.loadUrl(a.LoadScript.commandWithArg(optString));
                        }
                    });
                }
                return true;
            } catch (Throwable e) {
                com.getpebble.jskit.android.a.a.a(6, e, "JavascriptHandlerWebView", "loadAppScript: onBootstrapScriptLoadedAndReady");
                return false;
            }
        } catch (Throwable e2) {
            com.getpebble.jskit.android.a.a.a(3, e2, "JavascriptHandlerWebView", "loadAppScript: onBootstrapScriptLoadedAndReady:");
            return false;
        }
    }

    public boolean a(String[] strArr) {
        String str;
        final WebView h;
        Object[] objArr = new Object[4];
        objArr[0] = "JavascriptHandlerWebView";
        objArr[1] = "signalReady: pebbleDeviceIdsThatAreReady = [";
        if (strArr == null) {
            str = null;
        } else {
            str = TextUtils.join(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR, strArr);
        }
        objArr[2] = str;
        objArr[3] = "]";
        com.getpebble.jskit.android.a.a.a(3, null, objArr);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (strArr != null) {
                for (Object obj : strArr) {
                    if (obj != null) {
                        jSONArray.put(obj);
                    }
                }
                jSONObject.put("pebblesReady", jSONArray);
                str = jSONObject.toString();
                h = this.a.h();
                if (h != null) {
                    com.getpebble.jskit.android.a.a.a(5, null, "JavascriptHandlerWebView", "signalReady: the JsRunnverWebview's webview is null");
                    return false;
                }
                this.b.post(new Runnable(this) {
                    final /* synthetic */ a c;

                    public void run() {
                        h.loadUrl(a.Ready.commandWithArg(str));
                    }
                });
                return true;
            }
        } catch (Throwable e) {
            com.getpebble.jskit.android.a.a.a(6, e, "JavascriptHandlerWebView");
        }
        str = null;
        h = this.a.h();
        if (h != null) {
            this.b.post(/* anonymous class already generated */);
            return true;
        }
        com.getpebble.jskit.android.a.a.a(5, null, "JavascriptHandlerWebView", "signalReady: the JsRunnverWebview's webview is null");
        return false;
    }

    public boolean c(final String str) {
        com.getpebble.jskit.android.a.a.a(3, null, "JavascriptHandlerWebView", "signalNewAppMessageData: appMessageData = ", str);
        final WebView h = this.a.h();
        if (h == null) {
            com.getpebble.jskit.android.a.a.a(5, null, "JavascriptHandlerWebView", "signalNewAppMessageData: the JsRunnverWebview's webview is null");
            return false;
        }
        this.b.post(new Runnable(this) {
            final /* synthetic */ a c;

            public void run() {
                h.loadUrl(a.NewAppMessageData.commandWithArg(str));
            }
        });
        return true;
    }

    public boolean d(final String str) {
        com.getpebble.jskit.android.a.a.a(3, null, "JavascriptHandlerWebView", "signalAppMessageAck: data = ", str);
        final WebView h = this.a.h();
        if (h == null) {
            com.getpebble.jskit.android.a.a.a(5, null, "JavascriptHandlerWebView", "signalAppMessageAck: the JsRunnverWebview's webview is null");
            return false;
        }
        this.b.post(new Runnable(this) {
            final /* synthetic */ a c;

            public void run() {
                h.loadUrl(a.AppMessageAck.commandWithArg(str));
            }
        });
        return true;
    }

    public boolean e(final String str) {
        com.getpebble.jskit.android.a.a.a(3, null, "JavascriptHandlerWebView", "signalAppMessageNack: data = ", str);
        final WebView h = this.a.h();
        if (h == null) {
            com.getpebble.jskit.android.a.a.a(5, null, "JavascriptHandlerWebView", "signalAppMessageNack: the JsRunnverWebview's webview is null");
            return false;
        }
        this.b.post(new Runnable(this) {
            final /* synthetic */ a c;

            public void run() {
                h.loadUrl(a.AppMessageNack.commandWithArg(str));
            }
        });
        return true;
    }

    public boolean f(final String str) {
        com.getpebble.jskit.android.a.a.a(3, null, "JavascriptHandlerWebView", "signalShowConfiguration: data = ", str);
        final WebView h = this.a.h();
        if (h == null) {
            com.getpebble.jskit.android.a.a.a(5, null, "JavascriptHandlerWebView", "signalShowConfiguration: the JsRunnverWebview's webview is null");
            return false;
        }
        this.b.post(new Runnable(this) {
            final /* synthetic */ a c;

            public void run() {
                h.loadUrl(a.LaunchSettings.commandWithArg(str));
            }
        });
        return true;
    }

    public boolean g(final String str) {
        com.getpebble.jskit.android.a.a.a(3, null, "JavascriptHandlerWebView", "signalWebviewClosedEvent: data = ", str);
        final WebView h = this.a.h();
        if (h == null) {
            com.getpebble.jskit.android.a.a.a(5, null, "JavascriptHandlerWebView", "signalWebviewClosedEvent: the JsRunnverWebview's webview is null");
            return false;
        }
        this.b.post(new Runnable(this) {
            final /* synthetic */ a c;

            public void run() {
                h.loadUrl(a.Closed.commandWithArg(str));
            }
        });
        return true;
    }

    public boolean h(final String str) {
        com.getpebble.jskit.android.a.a.a(3, null, "JavascriptHandlerWebView", "signalTimelineTokenSuccess: data = ", str);
        final WebView h = this.a.h();
        if (h == null) {
            com.getpebble.jskit.android.a.a.a(5, null, "JavascriptHandlerWebView", "signalTimelineTokenSuccess: the JsRunnverWebview's webview is null");
            return false;
        }
        this.b.post(new Runnable(this) {
            final /* synthetic */ a c;

            public void run() {
                h.loadUrl(a.TimelineTokenSuccess.commandWithArg(str));
            }
        });
        return true;
    }

    public boolean i(final String str) {
        com.getpebble.jskit.android.a.a.a(3, null, "JavascriptHandlerWebView", "signalTimelineTokenFailure: data = ", str);
        final WebView h = this.a.h();
        if (h == null) {
            com.getpebble.jskit.android.a.a.a(5, null, "JavascriptHandlerWebView", "signalTimelineTokenFailure: the JsRunnverWebview's webview is null");
            return false;
        }
        this.b.post(new Runnable(this) {
            final /* synthetic */ a c;

            public void run() {
                h.loadUrl(a.TimelineTokenFailure.commandWithArg(str));
            }
        });
        return true;
    }
}
