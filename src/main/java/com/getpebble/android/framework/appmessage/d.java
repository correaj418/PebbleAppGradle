package com.getpebble.android.framework.appmessage;

import android.util.Base64;
import android.util.SparseArray;
import com.getpebble.android.common.b.a.f;
import com.google.a.f.e;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class d {
    public static final a[] a = new a[]{a.BYTES, a.STRING, a.UINT, a.INT};
    public static final Map<String, a> b = new HashMap();
    public static final SparseArray<c> c = new SparseArray();
    public static Map<Byte, String> i = c();
    public static Map<Byte, String> j = d();
    public final e d;
    public final a e;
    public final c f;
    public final int g;
    public final Object h;

    public enum a {
        BYTES(0),
        STRING(1),
        UINT(2),
        INT(3);
        
        public final byte ord;

        private a(int i) {
            this.ord = (byte) i;
        }

        public String getName() {
            return name().toLowerCase(Locale.US);
        }
    }

    public static class b extends RuntimeException {
        public b() {
            super("Value exceeds tuple capacity");
        }
    }

    public enum c {
        NONE(0),
        BYTE(1),
        SHORT(2),
        WORD(4);
        
        public final int value;

        private c(int i) {
            this.value = i;
        }
    }

    static {
        int i = 0;
        for (a aVar : a.values()) {
            b.put(aVar.getName(), aVar);
        }
        c[] values = c.values();
        int length = values.length;
        while (i < length) {
            c cVar = values[i];
            c.put(cVar.value, cVar);
            i++;
        }
    }

    private d(e eVar, a aVar, c cVar, int i, Object obj) {
        this.d = eVar;
        this.e = aVar;
        this.f = cVar;
        this.g = i;
        this.h = obj;
    }

    public static d a(e eVar, a aVar, c cVar, int i) {
        return new d(eVar, aVar, cVar, cVar.value, Long.valueOf((long) i));
    }

    public static d a(e eVar, a aVar, c cVar, Object obj) {
        int i = Integer.MAX_VALUE;
        if (cVar != c.NONE) {
            i = cVar.value;
        } else if (aVar == a.BYTES) {
            i = ((byte[]) obj).length;
        } else if (aVar == a.STRING) {
            i = ((String) obj).getBytes(Charset.forName("UTF-8")).length + 1;
        }
        if (i <= 65535) {
            return new d(eVar, aVar, cVar, i, obj);
        }
        throw new b();
    }

    public JSONObject a() {
        JSONObject jSONObject = null;
        try {
            jSONObject = a(this, null);
        } catch (Throwable e) {
            f.b("PebbleTuple", "toJson: ", e);
        }
        return jSONObject;
    }

    public String b() {
        JSONObject a = a();
        return a == null ? "{}" : a.toString();
    }

    public String toString() {
        return b();
    }

    public static JSONObject a(d dVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", dVar.d.longValue());
        jSONObject.put("type", dVar.e.getName());
        jSONObject.put("length", dVar.f.value);
        switch (dVar.e) {
            case BYTES:
                jSONObject.put("value", Base64.encodeToString((byte[]) dVar.h, 2));
                break;
            case STRING:
                jSONObject.put("value", dVar.h);
                break;
            case INT:
            case UINT:
                jSONObject.put("value", dVar.h);
                break;
        }
        return jSONObject;
    }

    public static JSONObject a(d dVar, Map<Byte, String> map) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", dVar.d.longValue());
        jSONObject.put("type", dVar.e.getName());
        jSONObject.put("length", dVar.f.value);
        switch (dVar.e) {
            case BYTES:
                JSONArray jSONArray = new JSONArray();
                for (byte b : (byte[]) dVar.h) {
                    if (map != null) {
                        String str = (String) map.get(Byte.valueOf(b));
                        if (str != null) {
                            jSONArray.put(str);
                        }
                    }
                    jSONArray.put(i.get(Byte.valueOf(b)));
                }
                jSONObject.put("value", jSONArray);
                break;
            case STRING:
                jSONObject.put("value", dVar.h);
                break;
            case INT:
            case UINT:
                jSONObject.put("value", dVar.h);
                break;
        }
        return jSONObject;
    }

    public static Map<Byte, String> c() {
        Map<Byte, String> hashMap = new HashMap();
        for (int i = 0; i < 256; i++) {
            hashMap.put(Byte.valueOf((byte) i), "" + i);
        }
        return hashMap;
    }

    public static Map<Byte, String> d() {
        Map<Byte, String> c = c();
        for (int i = 32; i < 127; i++) {
            c.put(Byte.valueOf((byte) i), new String(new byte[]{(byte) i}));
        }
        return c;
    }
}
