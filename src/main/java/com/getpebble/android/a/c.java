package com.getpebble.android.a;

import android.content.ContentResolver;
import android.os.Handler;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.d;
import com.getpebble.android.common.b.b.c.a;
import com.getpebble.android.common.model.au;
import java.util.HashMap;
import java.util.Map;

public class c {
    private static Handler a;
    private static Boolean b;

    public static synchronized void a(final String str, final String str2, final Map<String, Object> map) {
        boolean z = true;
        synchronized (c.class) {
            if (b == null) {
                if (PebbleApplication.w().E()) {
                    z = false;
                }
                b = Boolean.valueOf(z);
            }
            if (!b.booleanValue()) {
                if (b.isInitialised() && PebbleApplication.y().a(a.ANALYTICS_OPTIN, true)) {
                    if (a == null) {
                        a = new Handler(d.b().getLooper());
                    }
                    a.post(new Runnable() {
                        public void run() {
                            c.b(str, str2, map);
                        }
                    });
                }
            }
        }
    }

    static void b(String str, String str2, Map<String, Object> map) {
        Map hashMap;
        if (map == null) {
            hashMap = new HashMap();
        } else {
            Map<String, Object> map2 = map;
        }
        ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
        contentResolver.insert(a.a, new a.a(str, str2, hashMap, System.currentTimeMillis() / 1000, b.getGlobalEventProperties()).a());
        au.a(au.a.PHONE_ANALYTICS_EVENTS_ADDED, contentResolver);
    }
}
