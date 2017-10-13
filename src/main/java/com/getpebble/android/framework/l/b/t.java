package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.bluetooth.g.a;

public class t extends r {
    private String a;
    private String e;

    public t(String str, String str2) {
        super(a.MUSIC_CONTROL);
        this.e = str2;
        this.a = str;
    }

    public synchronized byte[] c_() {
        if (!d()) {
            a(Byte.valueOf((byte) 19));
            a(b.c(this.a, 29));
            a(b.c(this.e, 29));
        }
        return super.c_();
    }
}
