package com.getpebble.jskit.android.impl.runtime.a.a;

import android.webkit.JavascriptInterface;
import com.getpebble.jskit.android.a.a;
import com.getpebble.jskit.android.impl.b;
import com.getpebble.jskit.android.impl.c.a.e;
import com.getpebble.jskit.android.impl.c.a.f;
import com.getpebble.jskit.android.impl.runtime.model.JsApplicationInfo;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;

public class c {
    private static String b = a();
    private final b a;

    public c(b bVar) {
        this.a = bVar;
    }

    @JavascriptInterface
    public void logInterceptedSend() {
        this.a.a(a.HTTP_REQUEST);
    }

    @JavascriptInterface
    public void logLocationRequest() {
        this.a.a(a.GEOLOCATION_REQUEST);
    }

    @JavascriptInterface
    public int getVersionCode() {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "getVersionCode:");
        return this.a.a().b();
    }

    @JavascriptInterface
    public void privateLog(String str) {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "privateLog: ", str);
    }

    @JavascriptInterface
    public void privateFnConfirmReadySignal(boolean z) {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "privateFnConfirmReadySignal: success = ", Boolean.valueOf(z));
        this.a.a(z);
    }

    @JavascriptInterface
    public void privateFnLocalStorageWrite(String str, String str2) {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "privateFnLocalStorageWrite:");
        this.a.a().g().c().a(this.a.b().a(), str, str2);
    }

    @JavascriptInterface
    public String privateFnLocalStorageRead(String str) {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "privateFnLocalStorageRead:");
        return this.a.a().g().c().a(this.a.b().a(), str);
    }

    @JavascriptInterface
    public String privateFnLocalStorageReadAll() {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "privateFnLocalStorageReadAll:");
        return this.a.a().g().c().a(this.a.b().a());
    }

    @JavascriptInterface
    public String privateFnLocalStorageReadAll_AtPreregistrationStage(String str) {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "privateFnLocalStorageReadAll_AtPreregistrationStage:");
        return privateFnLocalStorageReadAll();
    }

    @JavascriptInterface
    public void privateFnLocalStorageRemove(String str) {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "privateFnLocalStorageRemove:");
        this.a.a().g().c().b(this.a.b().a(), str);
    }

    @JavascriptInterface
    public void privateFnLocalStorageClear() {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "privateFnLocalStorageClear:");
        this.a.a().g().c().b(this.a.b().a());
    }

    private static String a() {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "makeExtensionsPreparedDataString:");
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("android");
            jSONArray.put("native_http_get");
            jSONArray.put("native_http_post");
            jSONArray.put("native_settings_storage");
            return jSONArray.toString();
        } catch (Throwable e) {
            com.getpebble.jskit.android.a.a.a(3, e, "PrivateJsInterfaceWebView", "makeExtensionsPreparedDataString:");
            return "{}";
        }
    }

    @JavascriptInterface
    public String getExtensions() {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "getExtensions:");
        return b;
    }

    @JavascriptInterface
    public void sendStartWatchAppMessage() {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "sendStartWatchAppMessage:");
        com.getpebble.jskit.android.a.a.a(3, null, "PrivateJsInterfaceWebView", "sendStartWatchAppMessage:");
        this.a.a().d().a(new e(this.a.b(), null));
    }

    @JavascriptInterface
    public void sendStartWatchAppMessage(String str) {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "sendStartWatchAppMessage:");
        b a = this.a.a();
        a.d().a(new e(this.a.b(), str));
    }

    @JavascriptInterface
    public String sendAppMessageString(String str) {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "sendAppMessageString: jsonAppMessage = ", str);
        b a = this.a.a();
        com.getpebble.jskit.android.impl.b.a c = a.c();
        JsApplicationInfo b = this.a.b();
        String a2 = this.a.a(str);
        com.getpebble.jskit.android.impl.c.b d = a.d();
        f fVar = new f(b, a2);
        int a3 = c.a(fVar);
        d.a(fVar);
        return Integer.toString(a3);
    }

    private static Map<String, List<String>> a(String str) {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "getUrlParameters:");
        Map<String, List<String>> hashMap = new HashMap();
        String[] split = str.split("\\?");
        if (split.length > 1) {
            for (String split2 : split[1].split("&")) {
                Object decode;
                String[] split3 = split2.split("=", 2);
                String decode2 = URLDecoder.decode(split3[0], "UTF-8");
                String split22 = "";
                if (split3.length > 1) {
                    decode = URLDecoder.decode(split3[1], "UTF-8");
                } else {
                    String str2 = split22;
                }
                List list = (List) hashMap.get(decode2);
                if (list == null) {
                    list = new ArrayList();
                    hashMap.put(decode2, list);
                }
                list.add(decode);
            }
        }
        return hashMap;
    }

    @JavascriptInterface
    public void startupScriptHasLoaded(String str) {
        String str2;
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "startupScriptHasLoaded: url = ", str);
        try {
            List list = (List) a(new URL(str).toString()).get("params");
            if (list != null && list.size() > 0) {
                str2 = (String) list.get(0);
                this.a.i(str2);
            }
        } catch (Throwable e) {
            com.getpebble.jskit.android.a.a.a(6, e, "PrivateJsInterfaceWebView");
        }
        str2 = null;
        this.a.i(str2);
    }

    @JavascriptInterface
    public String getTimelineTokenAsync() {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "getTimelineTokenAsync:");
        com.getpebble.jskit.android.impl.b.a b = b();
        if (b == null) {
            return null;
        }
        return b.c(this.a.b().a());
    }

    @JavascriptInterface
    public void signalAppScriptLoadedByBootstrap() {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "signalAppScriptLoadedByBootstrap:");
        this.a.i();
    }

    public String nativeSettingWrite(String str, String str2) {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "nativeSettingWrite:");
        JsApplicationInfo b = this.a.b();
        com.getpebble.jskit.android.impl.d.b g = this.a.a().g();
        String a = g.c().a(b.a(), str);
        g.c().a(b.a(), str, str2);
        return a;
    }

    @JavascriptInterface
    public String nativeSettingWriteWithOptions(String str, String str2, String str3) {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "nativeSettingWriteWithOptions:");
        return nativeSettingWrite(str, str2);
    }

    @JavascriptInterface
    public String nativeSettingRemove(String str) {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "nativeSettingRemove:");
        this.a.a().g().c().b(this.a.b().a(), str);
        return null;
    }

    @JavascriptInterface
    public String nativeSettingRemoveWithOptions(String str, String str2) {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "nativeSettingRemoveWithOptions:");
        this.a.a().g().c().b(this.a.b().a(), str);
        return null;
    }

    @JavascriptInterface
    public String nativeSettingRead(String str) {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "nativeSettingRead:");
        return this.a.a().g().c().a(this.a.b().a(), str);
    }

    @JavascriptInterface
    public String nativeSettingReadWithOptions(String str, String str2) {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "nativeSettingReadWithOptions:");
        return this.a.a().g().c().a(this.a.b().a(), str);
    }

    @JavascriptInterface
    public String getActivePebbleWatchInfo() {
        com.getpebble.jskit.android.a.a.a(2, null, "PrivateJsInterfaceWebView", "getActivePebbleWatchInfo:");
        com.getpebble.jskit.android.impl.b.a b = b();
        com.getpebble.jskit.android.a.a.a(3, null, "PrivateJsInterfaceWebView", "getActivePebbleWatchInfo: info = " + (b == null ? null : b.a(UUID.fromString(this.a.b().a()))));
        return b == null ? null : b.a(UUID.fromString(this.a.b().a()));
    }

    @JavascriptInterface
    public boolean reloadAppGlances(String str) {
        return this.a.a().c().a(this.a.b().a(), str);
    }

    private com.getpebble.jskit.android.impl.b.a b() {
        b a = this.a.a();
        return a == null ? null : a.c();
    }
}
