package net.a.a.a;

import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class c {
    private static Map<Class<?>, Map<String, Integer>> a = new ConcurrentHashMap();

    private static String b(String str) {
        File file = new File(str);
        List arrayList = new ArrayList();
        do {
            arrayList.add(file.getName());
            file = file.getParentFile();
        } while (file != null);
        StringBuffer stringBuffer = new StringBuffer();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append("_");
            }
            stringBuffer.append((String) arrayList.get(size));
        }
        return stringBuffer.toString().replace('-', '_').replace("+", "plus").toLowerCase(Locale.US);
    }

    public static String a(String str) {
        return "joda_" + b(str);
    }

    public static int a(Class<?> cls, String str) {
        Map map;
        if (a.containsKey(cls)) {
            map = (Map) a.get(cls);
        } else {
            map = new ConcurrentHashMap();
            a.put(cls, map);
        }
        if (map.containsKey(str)) {
            return ((Integer) map.get(str)).intValue();
        }
        try {
            int i = cls.getField(str).getInt(null);
            if (i != 0) {
                map.put(str, Integer.valueOf(i));
            }
            return i;
        } catch (Throwable e) {
            Log.e("JodaTimeAndroid", "Failed to retrieve identifier: type=" + cls + " name=" + str, e);
            return 0;
        }
    }
}
