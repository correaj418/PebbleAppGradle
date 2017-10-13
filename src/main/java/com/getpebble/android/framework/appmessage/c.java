package com.getpebble.android.framework.appmessage;

import com.getpebble.android.common.b.a.f;
import com.google.a.f.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

public abstract class c implements Iterable<d> {
    protected final Map<e, d> a = new HashMap();

    public static class a extends RuntimeException {
        public a() {
            super("Too many tuples in dict");
        }
    }

    public c(c cVar) {
        if (cVar != null) {
            this.a.putAll(cVar.a);
        }
    }

    public synchronized Iterator<d> iterator() {
        return this.a.values().iterator();
    }

    public void a(e eVar, byte[] bArr) {
        c(d.a(eVar, com.getpebble.android.framework.appmessage.d.a.BYTES, com.getpebble.android.framework.appmessage.d.c.NONE, (Object) bArr));
    }

    public void a(e eVar, String str) {
        c(d.a(eVar, com.getpebble.android.framework.appmessage.d.a.STRING, com.getpebble.android.framework.appmessage.d.c.NONE, (Object) str));
    }

    public void a(e eVar, byte b) {
        c(d.a(eVar, com.getpebble.android.framework.appmessage.d.a.INT, com.getpebble.android.framework.appmessage.d.c.BYTE, (int) b));
    }

    public void b(e eVar, byte b) {
        c(d.a(eVar, com.getpebble.android.framework.appmessage.d.a.UINT, com.getpebble.android.framework.appmessage.d.c.BYTE, (int) b));
    }

    public void a(e eVar, short s) {
        c(d.a(eVar, com.getpebble.android.framework.appmessage.d.a.INT, com.getpebble.android.framework.appmessage.d.c.SHORT, (int) s));
    }

    public void b(e eVar, short s) {
        c(d.a(eVar, com.getpebble.android.framework.appmessage.d.a.UINT, com.getpebble.android.framework.appmessage.d.c.SHORT, (int) s));
    }

    public void a(e eVar, int i) {
        c(d.a(eVar, com.getpebble.android.framework.appmessage.d.a.INT, com.getpebble.android.framework.appmessage.d.c.WORD, i));
    }

    public void b(e eVar, int i) {
        c(d.a(eVar, com.getpebble.android.framework.appmessage.d.a.UINT, com.getpebble.android.framework.appmessage.d.c.WORD, i));
    }

    protected synchronized void c(d dVar) {
        if (this.a.size() > 255) {
            throw new a();
        }
        this.a.put(dVar.d, dVar);
    }

    public synchronized JSONObject b() {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            for (Entry entry : this.a.entrySet()) {
                d dVar = (d) entry.getValue();
                if (dVar == null) {
                    jSONObject3.put("" + entry.getKey(), "((null))");
                } else {
                    jSONObject3.put("" + entry.getKey(), dVar.a());
                }
            }
            jSONObject2.put("tuples", jSONObject3);
            jSONObject = jSONObject2;
        } catch (Throwable e) {
            f.b("PebbleDictionary", "toJson: ", e);
            jSONObject = null;
        }
        return jSONObject;
    }

    public String c() {
        JSONObject b = b();
        return b == null ? "{}" : b.toString();
    }

    public String toString() {
        return c();
    }
}
