package com.getpebble.android.h;

import android.text.TextUtils;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.ak.a;

public class ae {
    public static String a() {
        a p = PebbleApplication.p();
        if (p == null) {
            f.b("UserIdUtil", "No connected device record. Unknown device serial number.");
            return "unknown";
        } else if (!TextUtils.isEmpty(p.serialNumber)) {
            return b.b(p.serialNumber);
        } else {
            f.b("UserIdUtil", "Connected device record has empty serial number.");
            return "unknown";
        }
    }
}
