package com.getpebble.android.a;

import com.getpebble.android.common.a;
import com.getpebble.android.h.h;
import java.util.List;

public abstract class f<T> {
    private final String a;

    protected abstract int a();

    protected abstract boolean a(List<T> list);

    protected abstract List<T> b();

    public f(String str) {
        this.a = str;
    }

    public void c() {
        int a = a();
        if (a > 0) {
            com.getpebble.android.common.b.a.f.d(this.a, "Removed " + a + " records");
        }
        while (h.a(a.K())) {
            List b = b();
            if (b == null) {
                com.getpebble.android.common.b.a.f.a(this.a, "getDataForUploading() returned null data");
                return;
            } else if (b.isEmpty()) {
                com.getpebble.android.common.b.a.f.c(this.a, "No (more) events to upload");
                return;
            } else if (!a(b)) {
                return;
            }
        }
        com.getpebble.android.common.b.a.f.a(this.a, "Can't upload data without internet connection");
    }
}
