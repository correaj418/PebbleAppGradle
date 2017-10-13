package com.getpebble.android.common.model;

import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.framework.install.app.b.a;
import com.google.b.a.c;

public class ax {
    @c(a = "search_terms")
    private String[] a;

    public String[] a() {
        return this.a;
    }

    public static String a(a aVar) {
        String z = PebbleApplication.w().z();
        if (z != null) {
            return z.replace("$$hardware$$", aVar.getCode());
        }
        return z;
    }
}
