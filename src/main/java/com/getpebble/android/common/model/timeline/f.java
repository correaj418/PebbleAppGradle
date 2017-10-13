package com.getpebble.android.common.model.timeline;

import com.getpebble.android.h.p;
import com.google.a.b.af;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import java.lang.reflect.Type;
import java.util.Map;

public class f implements k<f> {
    private static final Map<String, Class<? extends f>> a = af.f().a("timeline.topic.subscribe", g.class).a("timeline.topic.unsubscribe", h.class).a("timeline.pin.create", c.class).a("timeline.pin.delete", d.class).a("appglance.slice.create", a.class).a();

    public /* synthetic */ Object deserialize(l lVar, Type type, j jVar) {
        return a(lVar, type, jVar);
    }

    public f a(l lVar, Type type, j jVar) {
        return (f) p.a(a, "type", "data", lVar, jVar);
    }
}
