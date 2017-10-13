package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.bluetooth.g.a;
import com.getpebble.android.framework.appmessage.AppMessage;

public class f extends r {
    private AppMessage a;

    public f(AppMessage appMessage) {
        this(a.APP_MESSAGE, appMessage);
    }

    protected f(a aVar, AppMessage appMessage) {
        super(aVar);
        this.a = appMessage;
    }

    public synchronized byte[] c_() {
        if (!d()) {
            a(Byte.valueOf(this.a.e().getCode()));
            a(Byte.valueOf(this.a.c()));
            if (!(this.a.e() == AppMessage.a.ACK || this.a.e() == AppMessage.a.NACK)) {
                a(b.a(this.a.a()));
                a(new com.getpebble.android.framework.appmessage.a(this.a.b()).a().array());
            }
        }
        return super.c_();
    }
}
