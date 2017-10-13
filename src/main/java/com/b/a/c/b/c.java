package com.b.a.c.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

final class c {
    private static final Comparator<String> a = new Comparator<String>() {
        public /* synthetic */ int compare(Object obj, Object obj2) {
            return a((String) obj, (String) obj2);
        }

        public int a(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    };
    private final List<String> b = new ArrayList(20);
    private String c;
    private int d = 1;
    private int e = -1;
    private String f;

    public void a(String str) {
        String trim = str.trim();
        this.c = trim;
        if (trim != null && trim.startsWith("HTTP/")) {
            String trim2 = trim.trim();
            int indexOf = trim2.indexOf(" ") + 1;
            if (indexOf != 0) {
                if (trim2.charAt(indexOf - 2) != '1') {
                    this.d = 0;
                }
                int i = indexOf + 3;
                if (i > trim2.length()) {
                    i = trim2.length();
                }
                this.e = Integer.parseInt(trim2.substring(indexOf, i));
                if (i + 1 <= trim2.length()) {
                    this.f = trim2.substring(i + 1);
                }
            }
        }
    }

    public String a() {
        return this.c;
    }

    public int b() {
        return this.e;
    }

    public String c() {
        return this.f;
    }

    public void b(String str) {
        int indexOf = str.indexOf(":");
        if (indexOf == -1) {
            a("", str);
        } else {
            a(str.substring(0, indexOf), str.substring(indexOf + 1));
        }
    }

    public void a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("fieldName == null");
        } else if (str2 == null) {
            System.err.println("Ignoring HTTP header field '" + str + "' because its value is null");
        } else {
            this.b.add(str);
            this.b.add(str2.trim());
        }
    }

    public void c(String str) {
        for (int i = 0; i < this.b.size(); i += 2) {
            if (str.equalsIgnoreCase((String) this.b.get(i))) {
                this.b.remove(i);
                this.b.remove(i);
            }
        }
    }

    public void a(String str, List<String> list) {
        for (String a : list) {
            a(str, a);
        }
    }

    public void b(String str, String str2) {
        c(str);
        a(str, str2);
    }

    public int d() {
        return this.b.size() / 2;
    }

    public String a(int i) {
        int i2 = i * 2;
        if (i2 < 0 || i2 >= this.b.size()) {
            return null;
        }
        return (String) this.b.get(i2);
    }

    public String b(int i) {
        int i2 = (i * 2) + 1;
        if (i2 < 0 || i2 >= this.b.size()) {
            return null;
        }
        return (String) this.b.get(i2);
    }

    public String d(String str) {
        for (int size = this.b.size() - 2; size >= 0; size -= 2) {
            if (str.equalsIgnoreCase((String) this.b.get(size))) {
                return (String) this.b.get(size + 1);
            }
        }
        return null;
    }

    public c a(Set<String> set) {
        c cVar = new c();
        for (int i = 0; i < this.b.size(); i += 2) {
            String str = (String) this.b.get(i);
            if (set.contains(str)) {
                cVar.a(str, (String) this.b.get(i + 1));
            }
        }
        return cVar;
    }

    public String e() {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append(this.c).append("\r\n");
        for (int i = 0; i < this.b.size(); i += 2) {
            stringBuilder.append((String) this.b.get(i)).append(": ").append((String) this.b.get(i + 1)).append("\r\n");
        }
        stringBuilder.append("\r\n");
        return stringBuilder.toString();
    }

    public Map<String, List<String>> f() {
        Map treeMap = new TreeMap(a);
        for (int i = 0; i < this.b.size(); i += 2) {
            String str = (String) this.b.get(i);
            String str2 = (String) this.b.get(i + 1);
            List arrayList = new ArrayList();
            List list = (List) treeMap.get(str);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(str2);
            treeMap.put(str, Collections.unmodifiableList(arrayList));
        }
        if (this.c != null) {
            treeMap.put(null, Collections.unmodifiableList(Collections.singletonList(this.c)));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    public static c a(Map<String, List<String>> map) {
        c cVar = new c();
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (str != null) {
                cVar.a(str, list);
            } else if (!list.isEmpty()) {
                cVar.a((String) list.get(list.size() - 1));
            }
        }
        return cVar;
    }
}
