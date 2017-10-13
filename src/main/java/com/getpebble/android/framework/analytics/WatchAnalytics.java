package com.getpebble.android.framework.analytics;

import android.app.IntentService;
import android.content.Intent;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.b;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.c.a;
import com.getpebble.android.framework.l.a.k.d;
import com.google.a.b.am;
import com.google.a.f.e;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class WatchAnalytics extends IntentService {
    public static final UUID a = new UUID(0, 0);
    public static final Set<e> b = am.a(e.a(78), e.a(79), e.a(80));
    private static final long c = TimeUnit.SECONDS.toMillis(20);
    private static final Random d = new Random();
    private long e = 0;

    public WatchAnalytics() {
        super("WatchAnalytics");
    }

    public void onHandleIntent(Intent intent) {
        try {
            int a = a(intent);
            b(intent);
            UUID c = c(intent);
            try {
                if (b.a().isOn() && PebbleApplication.y().a(a.ANALYTICS_OPTIN, true)) {
                    a(a, c);
                } else {
                    a(a, c);
                }
            } catch (Throwable e) {
                f.c("WatchAnalytics", "unexpected exception processing watch analytics", e);
            }
        } catch (Throwable e2) {
            f.c("WatchAnalytics", "missing or invalid data from intent", e2);
        } catch (Throwable e22) {
            f.c("WatchAnalytics", "unexpected data type found while parsing intent", e22);
        } catch (Throwable e222) {
            f.c("WatchAnalytics", "unexpected exception while parsing intent", e222);
        }
    }

    private static int a(Intent intent) {
        int intExtra = intent.getIntExtra("pbl_data_id", -1);
        if (intExtra >= 0) {
            return intExtra;
        }
        throw new IllegalArgumentException("Invalid data id");
    }

    private static String b(Intent intent) {
        byte byteExtra = intent.getByteExtra("pbl_data_type", (byte) -1);
        d fromCode = d.fromCode(byteExtra);
        if (fromCode != null && d.BYTE_ARRAY.equals(fromCode)) {
            return intent.getStringExtra("pbl_data_object");
        }
        throw new IllegalArgumentException("Invalid data type: " + byteExtra);
    }

    private static UUID c(Intent intent) {
        return (UUID) intent.getSerializableExtra("data_log_uuid");
    }

    private void a(int i, UUID uuid) {
        com.getpebble.android.framework.d.a.a().a(uuid, i);
    }
}
