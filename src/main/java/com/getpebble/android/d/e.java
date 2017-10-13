package com.getpebble.android.d;

import android.content.Context;
import com.b.b.x;
import com.getpebble.android.common.b.a.f;

public class e<T> {
    private final Context a;

    public e(Context context) {
        this.a = context;
    }

    public T a(String str, long j, Class<T> cls) {
        T t = null;
        x b = b(str, j, cls);
        if (a(b)) {
            try {
                t = b.b();
            } catch (ClassCastException e) {
                f.b("PebbleHttpClient", String.format("Failed to convert HTTP response to expected type. Expected %s got %s", new Object[]{cls.getSimpleName(), b.b().getClass().getSimpleName()}));
            }
        }
        return t;
    }

    x<T> b(String str, long j, Class<T> cls) {
        return a.a(this.a, str, j, (Class) cls);
    }

    boolean a(x<T> xVar) {
        if (xVar == null || xVar.d() == null) {
            return false;
        }
        int b = xVar.d().b();
        if (b < 200 || b >= 300) {
            return false;
        }
        return true;
    }
}
