package com.getpebble.android.framework.jskit;

import com.getpebble.android.common.b.a.f;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class a {
    private Set<UUID> a = Collections.newSetFromMap(new ConcurrentHashMap());

    public void a(UUID uuid) {
        this.a.add(uuid);
        f.e("ConfigurationRequestStore", "putConfigRequest: configuration request set after add():" + this.a.toString());
    }

    public boolean b(UUID uuid) {
        boolean remove = this.a.remove(uuid);
        f.e("ConfigurationRequestStore", "getAndClearConfigRequest: configuration request set after remove():" + this.a.toString() + " isRemoved? " + remove);
        return remove;
    }
}
