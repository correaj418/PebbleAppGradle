package com.getpebble.android.framework.timeline;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.getpebble.android.common.b.a.f;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimelineWebSyncService extends Service {
    private j a;
    private ThreadPoolExecutor b;
    private BlockingQueue<Runnable> c;

    public void onCreate() {
        super.onCreate();
        this.c = new LinkedBlockingQueue();
        this.b = new ThreadPoolExecutor(1, 1, TimeUnit.SECONDS.toMillis(30), TimeUnit.MILLISECONDS, this.c);
        this.a = new j(this);
    }

    public int onStartCommand(final Intent intent, int i, int i2) {
        int size = this.c.size();
        f.e("TimelineWebSyncService", "onStartCommand: size = " + size);
        if (size < 1) {
            this.b.execute(new Runnable(this) {
                final /* synthetic */ TimelineWebSyncService b;

                public void run() {
                    this.b.a(intent);
                }
            });
        }
        return 3;
    }

    public void onDestroy() {
        this.b.shutdown();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    protected void a(Intent intent) {
        f.d("TimelineWebSyncService", "onHandleIntent()");
        String str = null;
        Object obj = (!intent.hasExtra("bundle_key") || intent.getBundleExtra("bundle_key") == null) ? null : 1;
        if (obj != null) {
            Bundle bundleExtra = intent.getBundleExtra("bundle_key");
            if (bundleExtra.containsKey("bundle_key_side_load_json")) {
                f.d("TimelineWebSyncService", "onHandleIntent: Side-loading timeline response");
                this.a.b(bundleExtra.getString("bundle_key_side_load_json"));
                return;
            } else if (bundleExtra.containsKey("bundle_key_reset_target")) {
                f.d("TimelineWebSyncService", "onHandleIntent: Purging timeline web data and resetting web sync to default syncURL: " + this.a.d());
                this.a.a();
                this.a.e(this.a.d());
                return;
            } else if (bundleExtra.containsKey("bundle_key_gcm_reason")) {
                str = bundleExtra.getString("bundle_key_gcm_reason");
            }
        }
        this.a.a(str);
        f.d("TimelineWebSyncService", "onHandleIntent: Done");
    }

    public static void a(Context context, Bundle bundle) {
        Intent intent = new Intent(context, TimelineWebSyncService.class);
        intent.putExtra("bundle_key", bundle);
        context.startService(intent);
    }

    public static void a(Context context) {
        f.d("TimelineWebSyncService", "resetSync()");
        Bundle bundle = new Bundle();
        bundle.putString("bundle_key_reset_target", "");
        a(context, bundle);
    }
}
