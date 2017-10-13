package com.getpebble.android.framework.gcm;

import android.os.Bundle;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.au;
import com.getpebble.android.framework.timeline.TimelineWebSyncService;
import com.google.android.gms.gcm.a;

public class PebbleGcmListenerService extends a {
    public void a(String str, Bundle bundle) {
        au.a(au.a.GCM_RECEIVED, getContentResolver());
        String string = bundle.getString("type");
        if ("timeline:update".equals(string)) {
            string = bundle.getString("reason");
            f.d("PebbleGcmListenerService", "Received a push message; triggering a web sync (reason = " + string + ")");
            PebbleApplication.v().d();
            Bundle bundle2 = new Bundle();
            bundle2.putString("bundle_key_gcm_reason", string);
            TimelineWebSyncService.a(this, bundle2);
            return;
        }
        f.d("PebbleGcmListenerService", "Dropping unknown message type: " + string);
    }
}
