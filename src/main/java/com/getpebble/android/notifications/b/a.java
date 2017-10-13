package com.getpebble.android.notifications.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.getpebble.android.common.b.a.f;

public class a extends BroadcastReceiver {
    private static a a;

    public interface a {
        void a();
    }

    public static void a(a aVar) {
        a = aVar;
    }

    public a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        f.d("AndroidAppInstallListener", "Registering receiver");
        com.getpebble.android.common.a.K().registerReceiver(this, intentFilter);
    }

    public void onReceive(Context context, Intent intent) {
        f.d("AndroidAppInstallListener", "onReceive intent = " + intent + " dataString = " + intent.getDataString());
        f.a(intent);
        if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction()) && "com.google.android.wearable.app".equals(f.b(intent)) && a != null) {
            a.a();
            a = null;
        }
    }
}
