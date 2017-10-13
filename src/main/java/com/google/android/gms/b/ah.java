package com.google.android.gms.b;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class ah {
    private final Set<ag<?>> a = Collections.newSetFromMap(new WeakHashMap());

    public void a() {
        for (ag a : this.a) {
            a.a();
        }
        this.a.clear();
    }
}
