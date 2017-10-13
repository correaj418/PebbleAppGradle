package com.getpebble.android.notifications.b;

import com.getpebble.android.common.a;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.af;

public class g {
    public static String a(String str) {
        try {
            return af.a(str, a.K().getContentResolver()).b;
        } catch (Exception e) {
            f.a("PackageUtil", "Failed to get application label for " + str);
            return null;
        }
    }

    public static String b(String str) {
        try {
            return af.a(str, a.K().getContentResolver()).c;
        } catch (Exception e) {
            f.a("PackageUtil", "Failed to get application version for " + str);
            return null;
        }
    }
}
