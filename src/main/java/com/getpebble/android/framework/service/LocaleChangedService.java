package com.getpebble.android.framework.service;

import android.app.IntentService;
import android.content.Intent;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.a;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.af;
import com.getpebble.android.common.model.am;
import com.getpebble.android.config.b;

public class LocaleChangedService extends IntentService {
    public LocaleChangedService() {
        super("LocaleChangedService");
    }

    protected void onHandleIntent(Intent intent) {
        f.d("LocaleChangedService", "onHandleIntent: ");
        com.getpebble.android.notifications.b.f.a();
        new am().updateLocalizedInfos();
        new af().updateLocalizedInfos();
        b.a(a.K(), null, true, true);
        PebbleApplication.v().a();
    }
}
