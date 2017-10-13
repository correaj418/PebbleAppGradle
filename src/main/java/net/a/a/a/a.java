package net.a.a.a;

import android.content.Context;
import android.content.IntentFilter;
import c.b.a.f;

public final class a {
    private static boolean a = false;

    public static void a(Context context) {
        if (!a) {
            a = true;
            try {
                f.a(new d(context));
                context.getApplicationContext().registerReceiver(new e(), new IntentFilter("android.intent.action.TIMEZONE_CHANGED"));
            } catch (Throwable e) {
                throw new RuntimeException("Could not read ZoneInfoMap. You are probably using Proguard wrong.", e);
            }
        }
    }
}
