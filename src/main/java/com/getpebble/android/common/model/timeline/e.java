package com.getpebble.android.common.model.timeline;

import android.text.TextUtils;
import com.getpebble.android.h.p;
import com.google.b.a.c;
import com.google.b.g;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import java.lang.reflect.Type;
import java.util.UUID;

public class e {
    @c(a = "updates")
    public f[] a;
    @c(a = "syncURL")
    public String b;
    @c(a = "nextPageURL")
    public String c;
    @c(a = "mustResync")
    public boolean d;

    private static class a implements k<UUID> {
        private a() {
        }

        public /* synthetic */ Object deserialize(l lVar, Type type, j jVar) {
            return a(lVar, type, jVar);
        }

        public UUID a(l lVar, Type type, j jVar) {
            String c = lVar.c();
            if (TextUtils.isEmpty(c)) {
                throw new IllegalArgumentException();
            }
            if (c.startsWith("uuid:")) {
                c = c.substring("uuid:".length(), c.length());
            } else if (c.startsWith("sandbox-")) {
                c = c.substring("sandbox-".length() + "uuid:".length(), c.length());
            } else {
                throw new IllegalArgumentException();
            }
            return UUID.fromString(c);
        }
    }

    public static e a(String str) {
        return (e) p.a(str, e.class, new g().a(f.class, new f()).a(com.getpebble.android.common.model.timeline.c.a.class, new com.getpebble.android.common.model.timeline.c.a()).a(UUID.class, new a()).c());
    }
}
