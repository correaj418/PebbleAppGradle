package com.getpebble.android.framework.g;

import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.g.a;
import com.getpebble.android.bluetooth.g.b;
import java.util.Set;

abstract class j {
    abstract Set<a> a();

    abstract boolean a(b bVar);

    abstract void b();

    j() {
    }

    final void g() {
        b();
        PebbleApplication.a((Object) this);
    }
}
