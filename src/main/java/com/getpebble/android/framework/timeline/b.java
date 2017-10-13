package com.getpebble.android.framework.timeline;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseArray;
import com.getpebble.android.common.framework.b.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class b {
    private static b a;
    private Map<String, a> b = new HashMap();
    private SparseArray<a> c = new SparseArray();

    public static class a {
        public final String a;
        public final String b;
        public final int c;

        public byte a() {
            return (byte) ((((((Color.red(this.c) / 85) & 255) << 4) | 192) | (((Color.green(this.c) / 85) & 255) << 2)) | ((Color.blue(this.c) / 85) & 255));
        }

        a(String str, String str2) {
            this.a = str;
            this.b = str2;
            this.c = Color.parseColor(str2);
        }
    }

    private b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject(f.a(context, "snowy_colours.zip", true));
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                JSONObject jSONObject2 = jSONObject.getJSONObject((String) keys.next());
                String string = jSONObject2.getString("identifier");
                a aVar = new a(string, jSONObject2.getString("html"));
                this.b.put(string.toUpperCase(Locale.US), aVar);
                this.c.put(aVar.c, aVar);
            }
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.a("Colors", "Error loading colours json", e);
        } catch (Throwable e2) {
            com.getpebble.android.common.b.a.f.a("Colors", "Error loading colours json", e2);
        } catch (Throwable e22) {
            com.getpebble.android.common.b.a.f.a("Colors", "Error loading colours json", e22);
        }
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b(com.getpebble.android.common.a.K());
            }
            bVar = a;
        }
        return bVar;
    }

    public a a(String str) {
        return (a) this.b.get(str.toUpperCase(Locale.US));
    }

    public a b(String str) {
        return a(Color.parseColor(str));
    }

    public a a(int i) {
        return (a) this.c.get(Color.rgb((Color.red(i) / 85) * 85, (Color.green(i) / 85) * 85, (Color.blue(i) / 85) * 85));
    }
}
