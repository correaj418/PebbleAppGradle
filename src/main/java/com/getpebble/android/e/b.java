package com.getpebble.android.e;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.core.auth.a.a;
import com.getpebble.android.main.activity.MainActivity;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b extends WebViewClient {
    protected abstract void a(String str, JSONObject jSONObject);

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith("pebble-method-call-js-frame://")) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        try {
            a(a.a(str));
        } catch (Throwable e) {
            f.a("JsBridgeWebClient", "Failed to handle queryParams.", e);
        }
        return false;
    }

    private void a(Map<String, String> map) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Throwable e;
        String str = (String) map.get("args");
        if (str != null) {
            String optString;
            try {
                jSONObject = new JSONObject(str);
                try {
                    JSONObject jSONObject3 = jSONObject;
                    optString = jSONObject.optString("methodName");
                    jSONObject2 = jSONObject3;
                } catch (JSONException e2) {
                    e = e2;
                    f.a("JsBridgeWebClient", "JSONException in handleQueryParams for methodArgsJson:" + str, e);
                    jSONObject2 = jSONObject;
                    optString = null;
                    if (TextUtils.isEmpty(optString)) {
                        f.b("JsBridgeWebClient", "Got empty methodName");
                    } else {
                        a(optString, jSONObject2);
                    }
                }
            } catch (Throwable e3) {
                e = e3;
                jSONObject = null;
                f.a("JsBridgeWebClient", "JSONException in handleQueryParams for methodArgsJson:" + str, e);
                jSONObject2 = jSONObject;
                optString = null;
                if (TextUtils.isEmpty(optString)) {
                    f.b("JsBridgeWebClient", "Got empty methodName");
                } else {
                    a(optString, jSONObject2);
                }
            }
            if (TextUtils.isEmpty(optString)) {
                a(optString, jSONObject2);
            } else {
                f.b("JsBridgeWebClient", "Got empty methodName");
            }
        }
    }

    protected void a(JSONObject jSONObject, WebView webView, Fragment fragment) {
        a(a.a(jSONObject), fragment);
        a.a(webView, true, jSONObject);
    }

    private void a(String str, Fragment fragment) {
        if (!TextUtils.isEmpty(str)) {
            b(str, fragment);
        }
    }

    private void b(String str, Fragment fragment) {
        Activity activity = fragment.getActivity();
        if (activity == null) {
            f.a("JsBridgeWebClient", "setPageTitle: Activity was null");
        } else if (!fragment.isAdded()) {
        } else {
            if (activity instanceof MainActivity) {
                ((MainActivity) activity).a(str);
            } else if (fragment instanceof a) {
                ((a) fragment).a(str);
            }
        }
    }

    protected void b(JSONObject jSONObject, WebView webView, Fragment fragment) {
        if (jSONObject != null) {
            try {
                c(jSONObject.getJSONObject("data").optString("url", null), fragment);
                a.a(webView, true, jSONObject);
            } catch (Throwable e) {
                f.a("JsBridgeWebClient", "handleOpenUrlRequest - JSONException while parsing:" + jSONObject, e);
            }
        }
    }

    private void c(String str, Fragment fragment) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        Activity activity = fragment.getActivity();
        if (activity == null) {
            f.a("JsBridgeWebClient", "launchUrl: Activity was null");
        } else {
            activity.startActivity(intent);
        }
    }
}
