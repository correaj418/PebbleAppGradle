package com.getpebble.android.framework.gcm;

import android.content.Context;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.c;
import com.google.android.gms.iid.b;

public class PebbleInstanceIDService extends b {
    public void a() {
        f.c("PebbleInstanceIDService", "Token refresh");
        RegistrationIntentService.a(new c(this));
        RegistrationIntentService.a((Context) this);
    }
}
