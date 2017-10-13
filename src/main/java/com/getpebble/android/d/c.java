package com.getpebble.android.d;

import com.getpebble.android.common.b.a.f;
import java.util.List;
import java.util.Map;

public class c {
    public static String a(Map<String, List<String>> map, String str) {
        if (map == null) {
            f.a("HttpUtil", "getValueFromHeaders: Headers are null");
            return "";
        } else if (map.containsKey(str)) {
            List list = (List) map.get(str);
            if (list == null) {
                f.a("HttpUtil", "getValueFromHeaders: Value is null: " + map.toString());
                return "";
            } else if (list.isEmpty()) {
                f.a("HttpUtil", "getValueFromHeaders: Value is empty: " + map.toString());
                return "";
            } else {
                String str2 = (String) list.get(0);
                return str2 == null ? "" : str2;
            }
        } else {
            f.a("HttpUtil", "getValueFromHeaders: No header found: " + map.toString());
            return "";
        }
    }
}
