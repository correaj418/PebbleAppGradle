package com.getpebble.android.e;

import android.text.TextUtils;
import android.webkit.WebView;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.an;
import com.getpebble.android.common.model.e;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class a {
    public static Map<String, String> a(String str) {
        Map<String, String> hashMap = new HashMap();
        str.replace("pebble-method-call-js-frame://", "");
        try {
            for (String split : URLDecoder.decode(str, "UTF-8").split("&", 2)) {
                String[] split2 = split.split("=", 2);
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        } catch (Throwable e) {
            f.a("JsBridgeUtil", "Failed to decode url: " + str, e);
        }
        return hashMap;
    }

    public static void a(WebView webView, boolean z, JSONObject jSONObject) {
        CharSequence optString = jSONObject.optString("callbackId", null);
        a(jSONObject, "execution_result", Boolean.valueOf(z));
        if (!TextUtils.isEmpty(optString)) {
            try {
                webView.loadUrl(String.format("javascript:PebbleBridge.handleResponse(%s);", new Object[]{jSONObject.toString()}));
            } catch (Throwable e) {
                f.a("JsBridgeUtil", "Failed to notifyLoadResult.", e);
            }
        }
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                    jSONObject.put("data", optJSONObject);
                }
                optJSONObject.put(str, obj);
            } catch (Throwable e) {
                f.a("JsBridgeUtil", "appendResultToMethodArgs - JSONException:", e);
            }
        }
    }

    public static String a(JSONObject jSONObject) {
        String str = null;
        if (jSONObject != null) {
            try {
                str = jSONObject.getJSONObject("data").optString(an.TITLE, null);
            } catch (Throwable e) {
                f.a("JsBridgeUtil", "handleSetNavBarTitleRequest - JSONException while parsing:" + jSONObject, e);
            }
        }
        return str;
    }

    public static boolean b(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                f.d("JsBridgeUtil", jSONObject2.toString());
                z = jSONObject2.optBoolean("show_share", false);
            } catch (Throwable e) {
                f.a("JsBridgeUtil", "handleSetNavBarTitleRequest - JSONException while parsing:" + jSONObject, e);
            }
        }
        return z;
    }

    public static String c(JSONObject jSONObject) {
        String str = null;
        if (jSONObject != null) {
            try {
                str = jSONObject.getJSONObject("data").getJSONObject("links").optString("share");
            } catch (Throwable e) {
                f.a("JsBridgeUtil", "getShareUrlForApp: JSONException while parsing: " + jSONObject, e);
            }
        }
        return str;
    }

    public static e d(JSONObject jSONObject) {
        try {
            return (e) new com.google.b.f().a(jSONObject.getJSONObject("data").toString(), e.class);
        } catch (Throwable e) {
            f.a("JsBridgeUtil", "Failed to parse watchapp from methodArgs: " + jSONObject.toString(), e);
            return null;
        }
    }
}
