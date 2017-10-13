package com.getpebble.android.framework.appmessage;

import android.util.Base64;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.appmessage.d.a;
import com.getpebble.android.framework.appmessage.d.c;
import com.google.a.f.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends c {
    public b(c cVar) {
        super(cVar);
    }

    public String a() {
        JSONArray jSONArray = new JSONArray();
        for (d a : this.a.values()) {
            jSONArray.put(d.a(a));
        }
        return jSONArray.toString();
    }

    public JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            Object b = super.b();
            jSONObject.put("instance", getClass().getSimpleName());
            String str = "contents";
            if (b == null) {
                b = "((null))";
            }
            jSONObject.put(str, b);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    public static b a(String str) {
        b bVar = new b();
        JSONArray jSONArray = new JSONArray(str);
        int i = 0;
        while (i < jSONArray.length()) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            e a = e.a(jSONObject.getLong("key"));
            a aVar = (a) d.b.get(jSONObject.getString("type"));
            c cVar = (c) d.c.get(jSONObject.getInt("length"));
            if (aVar == null) {
                f.b("JsonPebbleDictionary", "JsonPebbleDictionary: invalid type:" + jSONObject.getString("type"));
                throw new JSONException("invalid type: " + jSONObject.getString("type"));
            } else if (cVar == null) {
                f.b("JsonPebbleDictionary", "JsonPebbleDictionary: invalid length:" + jSONObject.getInt("length"));
                throw new JSONException("invalid length: " + jSONObject.getInt("length"));
            } else {
                switch (aVar) {
                    case BYTES:
                        bVar.a(a, Base64.decode(jSONObject.getString("value"), 2));
                        break;
                    case STRING:
                        bVar.a(a, jSONObject.getString("value"));
                        break;
                    case INT:
                        if (cVar != c.BYTE) {
                            if (cVar != c.SHORT) {
                                if (cVar != c.WORD) {
                                    break;
                                }
                                bVar.a(a, jSONObject.getInt("value"));
                                break;
                            }
                            bVar.a(a, (short) jSONObject.getInt("value"));
                            break;
                        }
                        bVar.a(a, (byte) jSONObject.getInt("value"));
                        break;
                    case UINT:
                        if (cVar != c.BYTE) {
                            if (cVar != c.SHORT) {
                                if (cVar != c.WORD) {
                                    break;
                                }
                                bVar.b(a, jSONObject.getInt("value"));
                                break;
                            }
                            bVar.b(a, (short) jSONObject.getInt("value"));
                            break;
                        }
                        bVar.b(a, (byte) jSONObject.getInt("value"));
                        break;
                    default:
                        break;
                }
                i++;
            }
        }
        return bVar;
    }
}
