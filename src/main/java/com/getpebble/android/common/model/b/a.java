package com.getpebble.android.common.model.b;

import com.getpebble.android.common.framework.b.m;
import com.getpebble.android.common.framework.b.m.d;
import com.getpebble.android.common.framework.b.m.e;
import com.getpebble.android.common.framework.b.m.h;
import com.getpebble.android.common.framework.b.m.i;
import com.getpebble.android.main.sections.mypebble.d.a.g;
import com.getpebble.android.main.sections.mypebble.d.a.n;
import com.getpebble.android.main.sections.mypebble.d.a.p;
import com.google.b.f;
import com.google.b.w;

public final class a extends b {
    public <T> w<T> a(f fVar, com.google.b.c.a<T> aVar) {
        Class rawType = aVar.getRawType();
        if (d.class.isAssignableFrom(rawType)) {
            return d.a(fVar);
        }
        if (m.f.class.isAssignableFrom(rawType)) {
            return m.f.a(fVar);
        }
        if (i.class.isAssignableFrom(rawType)) {
            return i.a(fVar);
        }
        if (e.class.isAssignableFrom(rawType)) {
            return e.a(fVar);
        }
        if (h.class.isAssignableFrom(rawType)) {
            return h.a(fVar);
        }
        if (com.getpebble.android.common.model.a.w.class.isAssignableFrom(rawType)) {
            return com.getpebble.android.common.model.a.w.a(fVar);
        }
        if (com.getpebble.android.main.sections.mypebble.d.a.f.class.isAssignableFrom(rawType)) {
            return com.getpebble.android.main.sections.mypebble.d.a.f.a(fVar);
        }
        if (g.class.isAssignableFrom(rawType)) {
            return g.a(fVar);
        }
        if (com.getpebble.android.main.sections.mypebble.d.a.m.class.isAssignableFrom(rawType)) {
            return com.getpebble.android.main.sections.mypebble.d.a.m.a(fVar);
        }
        if (n.class.isAssignableFrom(rawType)) {
            return n.a(fVar);
        }
        if (p.class.isAssignableFrom(rawType)) {
            return p.a(fVar);
        }
        return null;
    }
}
