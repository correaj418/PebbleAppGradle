package com.getpebble.android.framework.a;

import android.content.ContentResolver;
import com.getpebble.android.common.model.aw;
import com.getpebble.android.common.model.aw.d;
import com.getpebble.android.common.model.n;
import com.getpebble.android.common.model.n.c;
import com.getpebble.android.common.model.o;
import java.util.UUID;

public class a extends b {
    private final ContentResolver a;

    public a(ContentResolver contentResolver) {
        this.a = contentResolver;
    }

    public void a(d dVar) {
        aw.a(this.a, dVar);
    }

    public void b(d dVar) {
        aw.b(this.a, dVar);
    }

    public void a(UUID uuid) {
        aw.c(this.a, uuid);
    }

    public void a(c cVar, long j, UUID uuid) {
        n.a(this.a, cVar, j, uuid);
    }

    public void a(c cVar) {
        n.a(this.a, cVar);
    }

    public void b(c cVar) {
        n.b(this.a, cVar);
    }

    public void a(com.getpebble.android.common.model.o.a aVar) {
        o.a(this.a, aVar);
    }

    public void b(com.getpebble.android.common.model.o.a aVar) {
        o.b(this.a, aVar);
    }

    public void c(com.getpebble.android.common.model.o.a aVar) {
        o.c(this.a, aVar);
    }
}
