package com.getpebble.android.framework.g;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.framework.jskit.c;
import com.getpebble.android.framework.l.b.h;
import com.getpebble.android.framework.l.b.r;
import com.google.a.b.am;
import java.util.Set;
import java.util.UUID;

public class d extends ac {
    private final Context a;
    private final p b;
    private final a c;

    interface a {
        void a(UUID uuid);
    }

    public d(Context context, p pVar, a aVar) {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        } else if (pVar == null) {
            throw new IllegalArgumentException("'messageSender' cannot be null!");
        } else {
            this.a = context;
            this.b = pVar;
            this.c = aVar;
        }
    }

    boolean a(k kVar, FrameworkState frameworkState) {
        f.d("AppRunStateEndpoint", "onRequest: ");
        if (!b(kVar)) {
            f.d("AppRunStateEndpoint", "onRequest: Request is not supported.");
            return false;
        } else if (kVar.a() == com.getpebble.android.bluetooth.g.a.APP_RUN_STATE) {
            return a(kVar);
        } else {
            return true;
        }
    }

    Set<com.getpebble.android.bluetooth.g.a> a() {
        return am.b(com.getpebble.android.bluetooth.g.a.APP_RUN_STATE);
    }

    boolean a(b bVar) {
        final com.getpebble.android.framework.l.a.f fVar = new com.getpebble.android.framework.l.a.f(bVar);
        ContentValues contentValues;
        if (com.getpebble.android.framework.l.a.f.a.RUNNING.equals(fVar.c())) {
            f.d("AppRunStateEndpoint", "onReceive: running: " + fVar.d());
            if (this.c != null) {
                this.c.a(fVar.d());
            } else {
                contentValues = new ContentValues();
                contentValues.put(ak.CURRENT_RUNNING_APP, fVar.d().toString());
                ak.updateDevice(this.a.getContentResolver(), this.b.e(), contentValues);
                c.a(this.a).b(true, fVar.d(), new Handler(Looper.getMainLooper()));
            }
            new com.getpebble.android.bluetooth.b.f(this) {
                final /* synthetic */ d b;

                public boolean doInBackground() {
                    return com.getpebble.android.common.model.am.a(fVar.d(), this.b.a.getContentResolver());
                }

                public void onTaskSuccess() {
                }

                public void onTaskFailed() {
                }
            }.submit();
        } else if (com.getpebble.android.framework.l.a.f.a.STOPPED.equals(fVar.c())) {
            f.d("AppRunStateEndpoint", "onReceive: stopped: " + fVar.d());
            contentValues = new ContentValues();
            contentValues.putNull(ak.CURRENT_RUNNING_APP);
            ak.updateDevice(this.a.getContentResolver(), this.b.e(), contentValues);
            c.a(this.a).b(false, fVar.d(), new Handler(Looper.getMainLooper()));
        }
        return true;
    }

    void b() {
    }

    protected boolean a(k kVar) {
        com.getpebble.android.framework.g.k.a b = kVar.b();
        r rVar = null;
        if (b == com.getpebble.android.framework.g.k.a.REQUEST_RUNNING_APP) {
            f.d("AppRunStateEndpoint", "handleAppRunStateRequest: action: REQUEST_RUNNING_APP");
            rVar = h.b();
        } else if (b == com.getpebble.android.framework.g.k.a.START_APP || b == com.getpebble.android.framework.g.k.a.STOP_APP) {
            f.d("AppRunStateEndpoint", "handleAppRunStateRequest: action: " + b);
            Object b2 = kVar.b(k.b.UUID);
            if (TextUtils.isEmpty(b2)) {
                f.a("AppRunStateEndpoint", "handleAppRunStateRequest: missing UUID in app run state message");
                return false;
            }
            UUID fromString = UUID.fromString(b2);
            if (fromString == null) {
                f.a("AppRunStateEndpoint", "handleAppRunStateRequest: invalid UUID in app run state message");
                return false;
            } else if (b == com.getpebble.android.framework.g.k.a.START_APP) {
                rVar = h.a(fromString);
            } else if (b == com.getpebble.android.framework.g.k.a.STOP_APP) {
                rVar = h.b(fromString);
            }
        }
        if (rVar != null && this.b.a(rVar)) {
            return true;
        }
        f.d("AppRunStateEndpoint", "handleAppRunStateRequest: send failed");
        return false;
    }
}
