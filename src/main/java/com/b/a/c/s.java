package com.b.a.c;

import android.net.Uri;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class s extends LinkedHashMap<String, List<String>> implements Iterable<t> {
    private static final a a = new a() {
        public String a(String str) {
            return Uri.decode(str);
        }
    };
    private static final a b = new a() {
        public String a(String str) {
            return URLDecoder.decode(str);
        }
    };

    public interface a {
        String a(String str);
    }

    protected List<String> a() {
        return new ArrayList();
    }

    public String a(String str) {
        List list = (List) get(str);
        if (list == null || list.size() == 0) {
            return null;
        }
        return (String) list.get(0);
    }

    public void a(String str, String str2) {
        List list = (List) get(str);
        if (list == null) {
            list = a();
            put(str, list);
        }
        list.add(str2);
    }

    public void b(String str, String str2) {
        List a = a();
        a.add(str2);
        put(str, a);
    }

    public static s a(String str, String str2, boolean z, a aVar) {
        s sVar = new s();
        if (str == null) {
            return sVar;
        }
        for (String split : str.split(str2)) {
            String[] split2 = split.split("=", 2);
            String trim = split2[0].trim();
            String split3 = null;
            if (split2.length > 1) {
                split3 = split2[1];
            }
            if (z && split3 != null && split3.endsWith("\"") && split3.startsWith("\"")) {
                split3 = split3.substring(1, split3.length() - 1);
            }
            if (aVar != null) {
                trim = aVar.a(trim);
                split3 = aVar.a(split3);
            }
            sVar.a(trim, split3);
        }
        return sVar;
    }

    public static s b(String str) {
        return a(str, ";", true, null);
    }

    public static s c(String str) {
        return a(str, "&", false, b);
    }

    public Iterator<t> iterator() {
        ArrayList arrayList = new ArrayList();
        for (String str : keySet()) {
            for (String jVar : (List) get(str)) {
                arrayList.add(new j(str, jVar));
            }
        }
        return arrayList.iterator();
    }
}
