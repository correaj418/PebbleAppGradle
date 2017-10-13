package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.bluetooth.g.a;
import com.google.a.f.e;
import java.nio.ByteOrder;

public class s extends r {
    private String a;
    private String e;
    private String f;
    private boolean g;
    private long h;
    private int i;
    private int j;

    public s(String str, String str2, String str3, long j, int i, int i2, boolean z) {
        super(a.MUSIC_CONTROL);
        this.a = str;
        this.e = str2;
        this.f = str3;
        if (j < 0 || j > e.c.longValue()) {
            j = 0;
        }
        this.h = j;
        this.i = i;
        this.j = i2;
        this.g = z;
    }

    public synchronized byte[] c_() {
        if (!d()) {
            a(Byte.valueOf((byte) 16));
            a(b.c(this.a, 29));
            a(b.c(this.e, 29));
            a(b.c(this.f, 29));
            if (this.g) {
                a(b.c(e.a(this.h)));
                a(b.b(e.a((long) this.i), ByteOrder.LITTLE_ENDIAN));
                a(b.b(e.a((long) this.j), ByteOrder.LITTLE_ENDIAN));
            }
        }
        return super.c_();
    }
}
