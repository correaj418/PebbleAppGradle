package com.getpebble.android.notifications.a.a;

import android.content.Context;
import com.getpebble.android.common.framework.b.f;
import com.getpebble.android.h.p;
import com.google.b.a.c;
import com.google.b.c.a;
import java.util.Map;

public class e {
    @c(a = "checkWhen")
    public boolean a;
    @c(a = "checkRemovedTime")
    public boolean b;
    @c(a = "removedThresSec")
    public long c;

    public static Map<String, e> a(String str) {
        return (Map) p.a(str, new a<Map<String, e>>() {
        }.getType());
    }

    public static String a(Context context) {
        try {
            return f.a(context, "default_notification_config.json", false);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }
}
