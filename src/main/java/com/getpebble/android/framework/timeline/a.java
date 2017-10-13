package com.getpebble.android.framework.timeline;

import com.google.b.a.c;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import java.lang.reflect.Type;
import java.util.Map;

public class a implements k<a> {
    private static final int DEFAULT_MAX_LENGTH = 64;
    @c(a = "enum")
    private Map<String, Integer> enumMap;
    private int id;
    @c(a = "max_length")
    private Integer maxLength;
    @c(a = "note")
    private String note;
    private com.getpebble.android.framework.l.b.ap.a type;

    public int getId() {
        return this.id;
    }

    public com.getpebble.android.framework.l.b.ap.a getType() {
        return this.type;
    }

    public int getMaxLength() {
        if (this.maxLength == null) {
            return 64;
        }
        return this.maxLength.intValue();
    }

    public Map<String, Integer> getEnumMap() {
        return this.enumMap;
    }

    public a deserialize(l lVar, Type type, j jVar) {
        a aVar = new a();
        o l = lVar.l();
        aVar.id = l.b("id").f();
        l b = l.b("note");
        if (b != null) {
            aVar.note = b.c();
        }
        aVar.type = com.getpebble.android.framework.l.b.ap.a.from(l.b("type").c());
        b = l.b("max_length");
        if (b != null) {
            aVar.maxLength = Integer.valueOf(b.f());
        }
        l b2 = l.b("enum");
        if (b2 != null) {
            aVar.enumMap = (Map) jVar.a(b2, new com.google.b.c.a<Map<String, Integer>>() {
            }.getType());
        }
        return aVar;
    }
}
