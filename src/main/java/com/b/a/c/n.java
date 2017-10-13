package com.b.a.c;

import com.b.a.f.h;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class n {
    final s a = new s(this) {
        final /* synthetic */ n a;

        {
            this.a = r1;
        }

        protected List<String> a() {
            return new h();
        }
    };

    public n(Map<String, List<String>> map) {
        this.a.putAll(map);
    }

    public s a() {
        return this.a;
    }

    public String a(String str) {
        return this.a.a(str.toLowerCase(Locale.US));
    }

    public n a(String str, String str2) {
        if (str2 == null || !(str2.contains("\n") || str2.contains("\r"))) {
            String toLowerCase = str.toLowerCase(Locale.US);
            this.a.b(toLowerCase, str2);
            ((h) this.a.get(toLowerCase)).b(str);
            return this;
        }
        throw new IllegalArgumentException("value must not contain a new line or line feed");
    }

    public n b(String str, String str2) {
        String toLowerCase = str.toLowerCase(Locale.US);
        this.a.a(toLowerCase, str2);
        ((h) this.a.get(toLowerCase)).b(str);
        return this;
    }

    public n b(String str) {
        if (str != null) {
            String[] split = str.trim().split(":", 2);
            if (split.length == 2) {
                b(split[0].trim(), split[1].trim());
            } else {
                b(split[0].trim(), "");
            }
        }
        return this;
    }

    public n a(String str, List<String> list) {
        for (String b : list) {
            b(str, b);
        }
        return this;
    }

    public List<String> c(String str) {
        return (List) this.a.remove(str.toLowerCase(Locale.US));
    }

    public String d(String str) {
        List c = c(str.toLowerCase(Locale.US));
        if (c == null || c.size() == 0) {
            return null;
        }
        return (String) c.get(0);
    }

    public StringBuilder b() {
        StringBuilder stringBuilder = new StringBuilder(256);
        for (String str : this.a.keySet()) {
            h hVar = (h) this.a.get(str);
            Iterator it = hVar.iterator();
            while (it.hasNext()) {
                stringBuilder.append((String) hVar.a()).append(": ").append((String) it.next()).append("\r\n");
            }
        }
        stringBuilder.append("\r\n");
        return stringBuilder;
    }

    public String toString() {
        return b().toString();
    }

    public String e(String str) {
        return b().insert(0, str + "\r\n").toString();
    }
}
