package com.getpebble.android.core.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.getpebble.android.common.b.a.f;

public class PebbleSyncService extends Service {
    private static c a = null;
    private static final Object b = new Object();

    public void onCreate() {
        synchronized (b) {
            if (a == null) {
                a = new c(getApplicationContext(), true);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return a.getSyncAdapterBinder();
    }

    public void onTaskRemoved(Intent intent) {
        f.d("PebbleSyncService", "onTaskRemoved()");
        super.onTaskRemoved(intent);
    }
}
