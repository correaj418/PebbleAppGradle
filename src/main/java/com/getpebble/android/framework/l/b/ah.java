package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.g.a;
import com.getpebble.android.framework.g.aj;
import com.getpebble.android.framework.g.ak.c;
import com.getpebble.android.framework.l.a.y;
import com.getpebble.android.framework.l.a.y.b;

public class ah extends r {
    final byte a;
    final byte e;
    final aj f;

    public ah(b bVar, c cVar, aj ajVar) {
        super(a.VOICE_CONTROL);
        this.a = bVar.toByte();
        this.e = cVar.toByte();
        this.f = ajVar;
    }

    public synchronized byte[] c_() {
        byte[] c_;
        int i = 1;
        synchronized (this) {
            if (!d()) {
                a(Byte.valueOf(y.a.SESSION_SETUP.toByte()));
                byte[] bArr = new byte[4];
                if (!this.f.flag) {
                    i = 0;
                }
                bArr[0] = (byte) i;
                a(bArr);
                a(Byte.valueOf(this.a));
                a(Byte.valueOf(this.e));
            }
            c_ = super.c_();
        }
        return c_;
    }
}
