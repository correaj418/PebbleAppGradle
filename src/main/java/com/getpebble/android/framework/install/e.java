package com.getpebble.android.framework.install;

import com.getpebble.android.common.b.a.f;
import java.io.Closeable;
import java.io.InputStream;

public abstract class e {
    public abstract InputStream a();

    com.google.a.f.e a(int i) {
        Closeable closeable = null;
        try {
            closeable = b.e.a(b.e.a(a()));
            com.google.a.f.e a = com.google.a.f.e.a(new d().a(closeable.e((long) i), i).a());
            return a;
        } finally {
            c.a.a.a.e.a(closeable);
        }
    }

    public boolean a(com.google.a.f.e eVar, int i) {
        try {
            return a(i).equals(eVar);
        } catch (Throwable e) {
            f.a("Stm32CrcStreamAdapter", "isMatch: error computing CRC ", e);
            return false;
        }
    }
}
