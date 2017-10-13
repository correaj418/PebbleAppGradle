package net.hockeyapp.android.e;

import android.content.Context;

public class i {
    private static String a = "versionInfo";

    public static String a(Context context) {
        if (context != null) {
            return context.getSharedPreferences("HockeyApp", 0).getString(a, "[]");
        }
        return "[]";
    }
}
