package com.getpebble.android.h;

import android.content.Context;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.as;
import com.getpebble.android.common.model.as.a;
import com.getpebble.android.common.model.as.b;

public class n {
    public static void a(Context context) {
        int i = 15;
        String a = as.a(context.getContentResolver(), "HockeySDK", "ConfirmedFilenames", b.STRING);
        if (a == null) {
            f.d("HockeyAppUtil", "checkStoredCrashReports: no preference stored");
            return;
        }
        String[] split = a.split("\\|");
        f.d("HockeyAppUtil", "checkStoredCrashReports: found " + split.length);
        if (split.length > 15) {
            while (i < split.length) {
                f.c("HockeyAppUtil", "checkStoredCrashReports: deleting " + split[i] + " (" + i + ")");
                a(context, split[i]);
                i++;
            }
            String a2 = a(a);
            if (a2 == null) {
                f.b("HockeyAppUtil", "checkStoredCrashReports: new pref value is null!");
                return;
            }
            as.a(context.getContentResolver(), "HockeySDK", new a("ConfirmedFilenames", b.STRING, a2));
        }
    }

    static String a(String str) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= 15) {
                return str.substring(0, i);
            }
            if (i + 1 >= str.length()) {
                return null;
            }
            i = str.indexOf(124, i + 1);
            if (i == -1) {
                return null;
            }
            i2 = i3;
        }
    }

    private static void a(Context context, String str) {
        context.deleteFile(str);
        context.deleteFile(str.replace(".stacktrace", ".user"));
        context.deleteFile(str.replace(".stacktrace", ".contact"));
        context.deleteFile(str.replace(".stacktrace", ".description"));
    }
}
