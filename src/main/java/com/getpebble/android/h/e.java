package com.getpebble.android.h;

import android.os.Bundle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
    private static final Map<Class<?>, a> a = new HashMap();

    public interface a {
        void a(JSONObject jSONObject, String str, Object obj);
    }

    static {
        a.put(Boolean.class, new a() {
            public void a(JSONObject jSONObject, String str, Object obj) {
                jSONObject.put(str, obj);
            }
        });
        a.put(Integer.class, new a() {
            public void a(JSONObject jSONObject, String str, Object obj) {
                jSONObject.put(str, obj);
            }
        });
        a.put(Double.class, new a() {
            public void a(JSONObject jSONObject, String str, Object obj) {
                jSONObject.put(str, obj);
            }
        });
        a.put(Long.class, new a() {
            public void a(JSONObject jSONObject, String str, Object obj) {
                jSONObject.put(str, obj);
            }
        });
        a.put(String.class, new a() {
            public void a(JSONObject jSONObject, String str, Object obj) {
                jSONObject.put(str, obj);
            }
        });
        a.put(String[].class, new a() {
            public void a(JSONObject jSONObject, String str, Object obj) {
                JSONArray jSONArray = new JSONArray();
                for (Object put : (String[]) obj) {
                    jSONArray.put(put);
                }
                jSONObject.put(str, jSONArray);
            }
        });
        a.put(JSONArray.class, new a() {
            public void a(JSONObject jSONObject, String str, Object obj) {
            }
        });
    }

    public static JSONObject a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                Object obj = bundle.get(str);
                if (obj != null) {
                    if (obj instanceof List) {
                        try {
                            JSONArray jSONArray = new JSONArray();
                            for (String put : (List) obj) {
                                jSONArray.put(put);
                            }
                            jSONObject.put(str, jSONArray);
                        } catch (Exception e) {
                            jSONObject.put(str, "failed to convert list to json.");
                        }
                    } else if (obj instanceof Bundle) {
                        jSONObject.put(str, a((Bundle) obj));
                    } else {
                        a aVar = (a) a.get(obj.getClass());
                        if (aVar != null) {
                            aVar.a(jSONObject, str, obj);
                        }
                    }
                }
            } catch (JSONException e2) {
            }
        }
        return jSONObject;
    }

    public static JSONObject b(Bundle bundle) {
        if (bundle == null || bundle.keySet().size() == 0) {
            return new JSONObject();
        }
        return a(bundle);
    }
}
