package com.getpebble.android.framework.timeline;

import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.am;
import com.getpebble.android.d.a;
import com.google.b.o;
import java.util.UUID;

public class i {
    public static String a(UUID uuid) {
        try {
            String c = ((o) a.c(com.getpebble.android.common.a.K(), PebbleApplication.w().K().replace("$$uuid$$", uuid.toString()), 8000).b()).b("token").c();
            f.d("TimelineSandboxTokenFetcher", "got token " + c + " for uuid " + uuid);
            am.b(com.getpebble.android.common.a.K().getContentResolver(), uuid, c);
            return c;
        } catch (Throwable e) {
            f.c("TimelineSandboxTokenFetcher", "Sandbox token reuqest failed", e);
            return null;
        } catch (Throwable e2) {
            f.c("TimelineSandboxTokenFetcher", "Sandbox token reuqest error", e2);
            return null;
        }
    }
}
