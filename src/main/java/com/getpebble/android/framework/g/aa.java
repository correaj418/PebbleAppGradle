package com.getpebble.android.framework.g;

import com.getpebble.android.bluetooth.g.a;
import com.getpebble.android.bluetooth.g.b;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class aa extends j {
    private static final Set<a> b = Collections.unmodifiableSet(EnumSet.of(a.PHONE_VERSION));
    Queue<b> a = new LinkedList();

    public synchronized Queue<b> c() {
        Queue<b> queue;
        queue = this.a;
        this.a = new LinkedList();
        return queue;
    }

    Set<a> a() {
        return EnumSet.allOf(a.class);
    }

    public synchronized boolean a(b bVar) {
        if (this.a.size() >= 20) {
            this.a.poll();
        }
        return this.a.add(bVar);
    }

    void b() {
    }

    public boolean a(a aVar) {
        return b.contains(aVar);
    }
}
