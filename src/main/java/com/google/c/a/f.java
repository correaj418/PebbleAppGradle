package com.google.c.a;

import com.google.c.a.i.b;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

final class f implements e {
    private static final Logger a = Logger.getLogger(f.class.getName());
    private final ConcurrentHashMap<String, b> b;
    private final ConcurrentHashMap<Integer, b> c;
    private final String d;
    private final c e;

    f(String str, c cVar) {
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = str;
        this.e = cVar;
    }

    public f(c cVar) {
        this("/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto", cVar);
    }

    public b a(String str) {
        b bVar = (b) this.b.get(str);
        return bVar != null ? bVar : a(str, this.b, this.d, this.e);
    }

    public b a(int i) {
        b bVar = (b) this.c.get(Integer.valueOf(i));
        if (bVar != null) {
            return bVar;
        }
        if (b(i)) {
            return a(Integer.valueOf(i), this.c, this.d, this.e);
        }
        return null;
    }

    private boolean b(int i) {
        List list = (List) b.a().get(Integer.valueOf(i));
        return list.size() == 1 && "001".equals(list.get(0));
    }

    static <T> b a(T t, ConcurrentHashMap<T, b> concurrentHashMap, String str, c cVar) {
        String str2 = str + "_" + t;
        InputStream a = cVar.a(str2);
        if (a == null) {
            throw new IllegalStateException("missing metadata: " + str2);
        }
        List a2 = d.a(a).a();
        if (a2.isEmpty()) {
            throw new IllegalStateException("empty metadata: " + str2);
        }
        if (a2.size() > 1) {
            a.log(Level.WARNING, "invalid metadata (too many entries): " + str2);
        }
        b bVar = (b) a2.get(0);
        b bVar2 = (b) concurrentHashMap.putIfAbsent(t, bVar);
        return bVar2 != null ? bVar2 : bVar;
    }
}
