package com.getpebble.android.main.sections.notifications;

import android.os.Build.VERSION;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.b.a.a.c.a;
import com.getpebble.android.h.ab;
import java.util.HashMap;
import java.util.Map;

public class b {
    private final String a;
    private final int b;
    private final a c;
    private double d = 0.0d;
    private int e = 0;
    private int f = 0;

    public b(String str, int i, a aVar) {
        this.a = str;
        this.b = i;
        this.c = aVar;
    }

    public void a(boolean z, CharSequence charSequence) {
        if (z) {
            this.e++;
        }
        this.f++;
        this.d = a(this.d, charSequence == null ? 0 : charSequence.length(), this.f);
    }

    public Map<String, Object> a() {
        String b = PebbleApplication.u().b(PebbleApplication.u().g());
        Map hashMap = new HashMap();
        hashMap.put("user_id", b);
        hashMap.put("timestamp_response_configured", Integer.valueOf(ab.a()));
        hashMap.put("responses_sdk_version", Integer.valueOf(VERSION.SDK_INT));
        hashMap.put("responses_firmware_version", this.a);
        hashMap.put("max_num_responses", Integer.valueOf(this.b));
        hashMap.put("num_responses_configured", Integer.valueOf(this.e));
        hashMap.put("average_response_length", Double.valueOf(this.d));
        c.a(this.c, hashMap);
        return hashMap;
    }

    protected static double a(double d, int i, int i2) {
        return ((((double) (i2 - 1)) * d) + ((double) i)) / ((double) i2);
    }
}
