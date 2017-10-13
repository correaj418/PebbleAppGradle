package com.getpebble.android.framework.health;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.a.o;
import com.getpebble.android.common.model.ar;
import com.getpebble.android.common.model.u;
import com.getpebble.android.framework.health.a.c;
import com.getpebble.android.framework.health.a.c.a;
import com.getpebble.android.framework.health.d.d;
import com.getpebble.android.framework.service.TaskService;
import com.getpebble.android.h.t;
import com.getpebble.pipeline.Payload;
import com.google.a.b.am;
import com.google.a.f.e;
import com.google.android.gms.gcm.OneoffTask;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class HealthDataReceiver extends IntentService implements a {
    public static final e a = e.a(81);
    public static final e b = e.a(83);
    public static final e c = e.a(84);
    public static final e d = e.a(85);
    public static final UUID e = new UUID(0, 0);
    public static final Set<e> f = am.a(a, b, c, d);
    private static final long g = TimeUnit.SECONDS.toMillis(2);
    private static final long h = TimeUnit.SECONDS.toMillis(2);
    private static final long i = TimeUnit.SECONDS.toMillis(2);
    private static Handler j = new Handler(Looper.getMainLooper());
    private static t<u> k = new t(Looper.getMainLooper());
    private static t<u> l = new t(Looper.getMainLooper());
    private c m;
    private com.getpebble.android.framework.health.a.a n;

    public HealthDataReceiver() {
        super("HealthDataReceiver");
    }

    public void onCreate() {
        super.onCreate();
        this.m = new c(com.getpebble.android.common.a.K(), null, null, this, false);
        this.n = new com.getpebble.android.framework.health.a.a(this, this.m);
    }

    protected void onHandleIntent(Intent intent) {
        Throwable e;
        e b = b(intent);
        if (b.equals(a)) {
            try {
                a(d.a(c(intent)));
            } catch (IllegalArgumentException e2) {
                e = e2;
                f.a("HealthDataReceiver", "onHandleIntent: invalid data from intent", e);
                a(intent);
            } catch (UnsupportedOperationException e3) {
                e = e3;
                f.a("HealthDataReceiver", "onHandleIntent: invalid data from intent", e);
                a(intent);
            }
        } else if (b.equals(b)) {
            f.d("HealthDataReceiver", "onHandleIntent: received sleep data (ignoring)");
        } else if (b.equals(c)) {
            try {
                a(com.getpebble.android.framework.health.d.a.a(getContentResolver(), c(intent)));
            } catch (Throwable e4) {
                f.a("HealthDataReceiver", "onHandleIntent: invalid data from intent", e4);
            }
        } else if (b.equals(d)) {
            a(c(intent));
        } else {
            f.b("HealthDataReceiver", "onHandleIntent: received unexpected intent: " + intent.toString());
        }
        a(intent);
    }

    private void a(byte[] bArr) {
        Throwable e;
        int intValue = b.b(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN)).intValue();
        f.d("HealthDataReceiver", "processMeasurementsPayload: received payload of size " + intValue);
        try {
            b.c b = new b.a().b(bArr, 2, intValue);
            Payload.ADAPTER.decode(b);
            b.l();
            ar.a(getApplicationContext(), new b.a().b(bArr, 2, intValue));
        } catch (IOException e2) {
            e = e2;
            f.a("HealthDataReceiver", "onHandleIntent: failed to handle payload data", e);
            f.d("HealthDataReceiver", "bytes: " + com.getpebble.android.bluetooth.b.a.a(bArr));
            d();
        } catch (ArrayIndexOutOfBoundsException e3) {
            e = e3;
            f.a("HealthDataReceiver", "onHandleIntent: failed to handle payload data", e);
            f.d("HealthDataReceiver", "bytes: " + com.getpebble.android.bluetooth.b.a.a(bArr));
            d();
        } catch (IllegalStateException e4) {
            e = e4;
            f.a("HealthDataReceiver", "onHandleIntent: failed to handle payload data", e);
            f.d("HealthDataReceiver", "bytes: " + com.getpebble.android.bluetooth.b.a.a(bArr));
            d();
        }
        d();
    }

    private void a(com.getpebble.android.framework.health.d.a aVar) {
        f.d("HealthDataReceiver", "received activity session of type " + aVar.b);
        if (com.getpebble.android.common.model.a.d.a(getContentResolver(), aVar)) {
            b(aVar);
            d();
            if (aVar.b.isSleep()) {
                final u from = u.from(aVar.a() + aVar.b(), aVar.e);
                k.removeCallbacksAndMessages(from);
                k.a(new Runnable(this) {
                    final /* synthetic */ HealthDataReceiver b;

                    public void run() {
                        Bundle bundle = new Bundle();
                        bundle.putInt("dayOfWeek", from.isoIndex);
                        TaskService.a(new OneoffTask.a().a(bundle).a(TaskService.class).a("health-update-sleepSummary-once").a(0, 5).a(2).b());
                    }
                }, from, h);
                return;
            }
            return;
        }
        f.a("HealthDataReceiver", "processActivitySession: failed to insert activity session");
        f.e("HealthDataReceiver", "processActivitySession: " + aVar);
    }

    private void a(com.getpebble.android.framework.health.d.c cVar) {
        f.d("HealthDataReceiver", "received MLS for " + cVar.a().b);
        b(cVar);
        o.a(getContentResolver(), cVar);
        d();
        for (final u uVar : cVar.b()) {
            l.removeCallbacksAndMessages(uVar);
            l.a(new Runnable(this) {
                final /* synthetic */ HealthDataReceiver b;

                public void run() {
                    Bundle bundle = new Bundle();
                    bundle.putInt("dayOfWeek", uVar.isoIndex);
                    TaskService.a(new OneoffTask.a().a(bundle).a(TaskService.class).a("health-update-movementData-single-once").a(0, 5).a(2).b());
                }
            }, uVar, i);
        }
    }

    private void d() {
        PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.HEALTH_LAST_SYNC_TIME_MS, System.currentTimeMillis());
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.m != null) {
            this.m.c();
            this.m = null;
        }
    }

    private void b(com.getpebble.android.framework.health.d.c cVar) {
        if (e()) {
            try {
                if (this.m.b().b()) {
                    this.n.a(cVar);
                }
            } catch (Throwable e) {
                f.f("HealthDataReceiver", "connectToFitAndInsert: unable to insert ActivityRecord into Fit", e);
            }
        }
    }

    private void b(com.getpebble.android.framework.health.d.a aVar) {
        if (e()) {
            try {
                if (this.m.b().b()) {
                    this.n.a(aVar);
                }
            } catch (Throwable e) {
                f.c("HealthDataReceiver", "connectToFitAndInsert: unable to insert ActivitySessionRecord into Fit", e);
            }
        }
    }

    private static e b(Intent intent) {
        return e.a(((Long) intent.getSerializableExtra("data_log_tag")).longValue());
    }

    private static byte[] c(Intent intent) {
        String stringExtra = intent.getStringExtra("pbl_data_object");
        if (stringExtra != null) {
            return Base64.decode(stringExtra, 2);
        }
        throw new IllegalArgumentException("Data logging object was not found in intent");
    }

    public static void a(Intent intent) {
        com.getpebble.android.framework.d.a.a().a((UUID) intent.getSerializableExtra("data_log_uuid"), intent.getIntExtra("pbl_data_id", -1));
    }

    private boolean e() {
        return PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.ENABLE_FIT_SYNC, false);
    }

    public void a(com.google.android.gms.common.api.c cVar) {
        f.c("HealthDataReceiver", "onConnectionSuccess: connected to Google Fit");
    }

    public void a() {
        f.c("HealthDataReceiver", "onConnectionFailed: couldn't connect to Google Fit");
    }

    public void b() {
        f.c("HealthDataReceiver", "onConnectionCompletelyFailed: couldn't connect to Google Fit");
    }

    public void d_() {
        f.c("HealthDataReceiver", "onConnectionSuspended: connection to Google Fit suspended");
    }
}
