package com.getpebble.jskit.android.impl.runtime.a;

import com.getpebble.jskit.android.impl.b;
import com.getpebble.jskit.android.impl.runtime.model.JsApplicationInfo;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public abstract class a {
    private b a;
    private JsApplicationInfo b;
    private com.getpebble.jskit.android.a c;
    private final boolean d;

    public abstract boolean b(String str);

    public abstract boolean c(String str);

    public abstract boolean d();

    public abstract boolean d(String str);

    public abstract boolean e();

    public abstract boolean e(String str);

    public abstract boolean f(String str);

    public abstract boolean g(String str);

    public abstract boolean h(String str);

    public a(b bVar, JsApplicationInfo jsApplicationInfo, boolean z) {
        this.a = bVar;
        this.b = jsApplicationInfo;
        this.d = z;
    }

    public b a() {
        return this.a;
    }

    public JsApplicationInfo b() {
        return this.b;
    }

    public void a(com.getpebble.jskit.android.a.a aVar) {
        if (this.c != null) {
            this.c.b(aVar);
        }
    }

    public boolean c() {
        com.getpebble.jskit.android.a.a.a(2, null, "JsRunner", "needToShowConfiguration: mNeedToShowConfiguration = ", Boolean.valueOf(this.d), ", hasConfigurationCaps = ", Boolean.valueOf(this.b.m()));
        if (this.d && r2) {
            return true;
        }
        return false;
    }

    public void a(int i, String str) {
        a().c().d(String.format("%s:%d %s", new Object[]{h(), Integer.valueOf(i), str}));
    }

    private boolean i(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(str.trim());
            com.getpebble.jskit.android.impl.b.a c = a().c();
            Map j = this.b.j();
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                if (i(str2) || j.containsKey(str2)) {
                    jSONObject.put(str2, jSONObject2.get(str2));
                } else {
                    c.d(String.format("Unknown message key '%s', you should add it in your appinfo.json/appKeys file, for now it'll be removed from the final message sent.", new Object[]{str2}));
                    com.getpebble.jskit.android.a.a.a(5, null, "JsRunner", "removeInvalidKey: Unknown key = ", str2);
                }
            }
        } catch (Throwable e) {
            com.getpebble.jskit.android.a.a.a(6, e, "JsRunner");
        }
        return jSONObject.toString();
    }

    private String h() {
        JsApplicationInfo b = b();
        if (b == null) {
            return "";
        }
        if (b.b() != null) {
            return b.b();
        }
        if (b.c() != null) {
            return b.c();
        }
        return b.a().toString();
    }

    protected String f() {
        return "Pebble";
    }

    protected String g() {
        return "_Pebble";
    }
}
