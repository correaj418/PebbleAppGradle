package com.getpebble.android.framework;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.support.v4.app.ac;
import android.support.v4.app.an;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.b.d;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.au;
import com.getpebble.android.framework.jskit.c;
import com.getpebble.android.main.activity.MainActivity;

public class PebbleFrameworkService extends Service {
    private static Messenger a;
    private static e b;
    private static boolean c;
    private com.getpebble.android.framework.e.f.a d = new com.getpebble.android.framework.e.f.a(this) {
        final /* synthetic */ PebbleFrameworkService a;

        {
            this.a = r1;
        }

        public void e_() {
            com.getpebble.android.common.model.ak.a q = PebbleApplication.q();
            if (q == null) {
                this.a.a(q);
                this.a.a(false);
            } else if (q.connectionStatus.equals(d.CONNECTED)) {
                this.a.d();
                this.a.a(true);
                e b = PebbleFrameworkService.b;
                if (b != null) {
                    b.a(q.pebbleDevice);
                }
            } else if (q.connectionStatus.equals(d.CONNECTING)) {
                this.a.c();
            } else {
                this.a.a(q);
                this.a.a(false);
            }
        }
    };
    private OnSharedPreferenceChangeListener e = new OnSharedPreferenceChangeListener(this) {
        final /* synthetic */ PebbleFrameworkService a;

        {
            this.a = r1;
        }

        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (this.a.getString(com.getpebble.android.common.b.b.c.a.HIDE_PERSISTENT_NOTIFICATION.getResId()).equals(str)) {
                f.d("PebbleFrameworkService", "onSharedPreferenceChanged: " + str);
                this.a.d.e_();
            }
        }
    };
    private a f = a.NONE;

    private enum a {
        NONE,
        CONNECTING,
        CONNECTED,
        NOT_CONNECTED
    }

    private void a(boolean z) {
        if (!z) {
            f.d("PebbleFrameworkService", "handleJsFromConnectedEvent: watch disconnected, stopping all JS");
            c = false;
            a().d();
        } else if (!c) {
            com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
            if (r == null) {
                f.b("PebbleFrameworkService", "handleJsFromConnectedEvent: connectedDeviceRecord is null, but a connected event call was received");
            } else if (r.currentRunningApp == null) {
                f.a("PebbleFrameworkService", "handleJsFromConnectedEvent: current watch has no running app");
            } else {
                f.d("PebbleFrameworkService", "handleJsFromConnectedEvent: starting app " + r.currentRunningApp);
                c.a((Context) this).b(true, r.currentRunningApp, new Handler(Looper.getMainLooper()));
                c = true;
            }
        }
    }

    public void onCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        f.d("PebbleFrameworkService", "onCreate()");
        super.onCreate();
        this.d.e_();
        PebbleApplication.a(this.d);
        PebbleApplication.y().a(this.e);
        if (b != null) {
            f.a("PebbleFrameworkService", "onCreate, sFrameworkManager != null!");
            au.a(com.getpebble.android.common.model.au.a.FRAMEWORK_RESTARTED, getContentResolver());
            return;
        }
        c = false;
        a();
        c.a((Context) this).c();
        b = e.a(getApplicationContext());
        a = new Messenger(b.a(Looper.getMainLooper()));
        f.d("PebbleFrameworkService", "onCreate: took = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void onDestroy() {
        f.d("PebbleFrameworkService", "onDestroy()");
        PebbleApplication.b(this.d);
        PebbleApplication.y().b(this.e);
        super.onDestroy();
    }

    public SharedPreferences getSharedPreferences(String str, int i) {
        return new com.getpebble.android.common.framework.d(this, str);
    }

    public IBinder onBind(Intent intent) {
        f.e("PebbleFrameworkService", "onBind()");
        Messenger messenger = a;
        if (messenger == null) {
            return null;
        }
        return messenger.getBinder();
    }

    public boolean onUnbind(Intent intent) {
        f.e("PebbleFrameworkService", "onUnbind()");
        return super.onUnbind(intent);
    }

    public void onRebind(Intent intent) {
        f.e("PebbleFrameworkService", "onRebind()");
        super.onRebind(intent);
    }

    @SuppressLint({"NewApi"})
    private void a(String str, int i, boolean z) {
        Notification b = new ac.d(this).a(getString(R.string.app_name)).b((CharSequence) str).a(i).c(false).a(true).b(true).a(PendingIntent.getActivity(this, 1, new Intent(getApplicationContext(), MainActivity.class), 134217728)).b();
        if (z) {
            b.priority = -2;
        }
        startForeground(4244, b);
    }

    private synchronized void c() {
        if (!a.CONNECTING.equals(this.f)) {
            f.d("PebbleFrameworkService", "Showing connecting notification");
            a(getString(R.string.connecting_to_pebble), R.drawable.disconnected_notification, true);
            this.f = a.CONNECTING;
        }
    }

    private synchronized void d() {
        if (!a.CONNECTED.equals(this.f)) {
            f.d("PebbleFrameworkService", "Showing connected notification");
            a(getString(R.string.your_pebble_is_connected), R.drawable.connected_status_bar, true);
            this.f = a.CONNECTED;
            an.a((Context) this).a(676583);
        }
    }

    private synchronized void e() {
        if (!a.NOT_CONNECTED.equals(this.f)) {
            f.d("PebbleFrameworkService", "Showing disconnected notification");
            a(getString(R.string.no_pebble_connected), R.drawable.disconnected_notification, true);
            this.f = a.NOT_CONNECTED;
        }
    }

    private synchronized void f() {
        if (!a.NONE.equals(this.f)) {
            f.d("PebbleFrameworkService", "hideNotification: calling stopForeground()");
            stopForeground(true);
            this.f = a.NONE;
        }
    }

    private synchronized void a(com.getpebble.android.common.model.ak.a aVar) {
        if (!PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.HIDE_PERSISTENT_NOTIFICATION, false)) {
            e();
        } else if (aVar == null) {
            f.d("PebbleFrameworkService", "decideWhichIdleNotificationToShow: lastConnectedDevice is null, so showing not-connected notification");
            e();
        } else if (aVar.connectionGoal.equals(com.getpebble.android.b.a.DISCONNECT)) {
            f();
        } else {
            e();
        }
    }

    private static synchronized com.getpebble.android.framework.jskit.d b(boolean z) {
        com.getpebble.android.framework.jskit.d a;
        synchronized (PebbleFrameworkService.class) {
            a = com.getpebble.android.framework.jskit.d.a(com.getpebble.android.common.a.K());
            if (z && !a.b()) {
                a.a();
            }
        }
        return a;
    }

    public static com.getpebble.android.framework.jskit.d a() {
        return b(true);
    }
}
