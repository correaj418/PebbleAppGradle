package com.getpebble.android;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.bluetooth.BluetoothClass;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.an;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.Transport;
import com.getpebble.android.bluetooth.d.g;
import com.getpebble.android.bluetooth.h.e;
import com.getpebble.android.common.a;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.common.framework.b;
import com.getpebble.android.common.model.ag;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.au;
import com.getpebble.android.core.sync.d;
import com.getpebble.android.framework.e.f;
import com.getpebble.android.framework.service.TaskService;
import com.getpebble.android.h.ad;
import com.getpebble.android.h.r;
import com.getpebble.android.onboarding.activity.OnboardingActivity;
import com.google.android.gms.gcm.OneoffTask;
import com.google.android.gms.gcm.PeriodicTask;
import com.google.android.gms.gcm.Task;
import java.util.LinkedList;
import java.util.List;

public class PebbleApplication extends a {
    public static String a = "PebbleApplication";
    protected static f b = null;
    private static com.getpebble.android.common.a.a d = null;
    private static d e = null;
    private static com.getpebble.android.config.a f = null;
    private static com.getpebble.android.framework.d g = null;
    private static com.getpebble.android.common.b.b.d.a h = null;
    private static c i = null;
    private static ag j = null;
    private static SQLiteDatabase k = null;
    private static net.hockeyapp.android.c l = new net.hockeyapp.android.c() {
        public boolean a() {
            return true;
        }

        public String b() {
            String str = null;
            com.getpebble.android.common.a.a J = PebbleApplication.d;
            if (J != null) {
                Account g = J.g();
                if (g != null) {
                    str = J.b(g);
                }
            }
            return str != null ? str : "unknown";
        }

        public String c() {
            return com.getpebble.android.common.c.d.a();
        }

        public boolean d() {
            return true;
        }
    };
    private static int m;

    @SuppressLint({"NewApi"})
    public void onCreate() {
        super.onCreate();
        long currentTimeMillis = System.currentTimeMillis();
        if (!d()) {
            h = m();
            com.getpebble.android.common.b.a.d.a(this, h.name(), new c(this).a(c.a.VERBOSE_LOGCAT, false), h.isFramework(), h.isFramework());
            L();
            a();
            com.getpebble.android.common.b.a.f.d(a, "onCreate()");
            com.getpebble.android.common.b.a.f.b(a, "process: " + h);
            com.getpebble.android.common.b.a.f.b(a, "DEBUG = false");
            com.getpebble.android.common.b.a.f.b(a, "BUILD_TYPE = release");
            com.getpebble.android.common.b.a.f.b(a, "FLAVOR = prod");
            com.getpebble.android.common.b.a.f.b(a, "endframe");
            r rVar = null;
            if (com.getpebble.android.common.b.b.d.a.UI.equals(h)) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                h();
                j = new ag(this);
                b.a(a.K());
                i = new c(this);
                f = com.getpebble.android.config.a.a((Context) this);
                d = g();
                e = d.a((Context) this);
            } else {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                h();
                j = new ag(this);
                b.a(a.K());
                i = new c(this);
                f = com.getpebble.android.config.a.a((Context) this);
                d = g();
                e = d.a((Context) this);
            }
            if (com.getpebble.android.common.b.b.d.a.UI.equals(h)) {
                ad.a(this);
            }
            if (h.isFramework()) {
                new com.getpebble.android.framework.install.a.a(this).g();
                e.a();
                e.j();
            }
            s();
            j();
            f();
            if (com.getpebble.android.common.b.b.d.a.UI.equals(h)) {
                k();
                if (rVar != null) {
                    PebbleDevice a = rVar.a();
                    if (a != null) {
                        com.getpebble.android.common.b.a.f.d(a, "Migration: requesting connect to " + a);
                        x().a(a);
                    }
                }
            }
            if (h.isFramework()) {
                i();
            }
            b();
            if (h.isFramework()) {
                i.b(c.a.DISABLE_RESUMED_UPDATES_ERROR, false);
            }
            com.getpebble.android.common.b.a.f.d(a, "onCreate: took = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    protected void a() {
        new com.getpebble.android.bluetooth.b.f(this) {
            final /* synthetic */ PebbleApplication a;
            private final String b = PebbleApplication.a;

            {
                this.a = r2;
            }

            public boolean doInBackground() {
                long currentTimeMillis = System.currentTimeMillis();
                this.a.c();
                this.a.e();
                com.getpebble.android.common.b.a.f.b(this.b, "PebbleAndroidInfo: " + new com.google.b.f().b(com.getpebble.android.main.sections.support.b.generatePebbleAndroidInfo(this.a)));
                this.a.l();
                if (com.getpebble.android.common.b.b.d.a.FRAMEWORK.equals(PebbleApplication.h)) {
                    com.getpebble.android.notifications.b.f.a();
                }
                com.getpebble.android.common.b.a.f.d(this.b, "doAsyncInit: took " + (System.currentTimeMillis() - currentTimeMillis));
                return false;
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
    }

    protected void b() {
        if (com.getpebble.android.common.b.b.d.a.UI.equals(h)) {
            new com.getpebble.android.bluetooth.b.f(this) {
                final /* synthetic */ PebbleApplication a;
                private final String b = PebbleApplication.a;

                {
                    this.a = r2;
                }

                public boolean doInBackground() {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.getpebble.android.common.b.a.f.d(this.b, "Starting GeoDatabase creation.");
                    PebbleApplication.k = new com.getpebble.android.main.sections.mypebble.b.a(a.K()).getReadableDatabase();
                    if (PebbleApplication.k != null) {
                        com.getpebble.android.common.b.a.f.d(this.b, "Finishing GeoDatabase creation. Total time (in millis): " + (System.currentTimeMillis() - currentTimeMillis));
                    } else {
                        com.getpebble.android.common.b.a.f.d(this.b, "Error creating GeoDatabase.");
                    }
                    return false;
                }

                public void onTaskSuccess() {
                }

                public void onTaskFailed() {
                }
            }.submit();
        }
    }

    protected void c() {
        net.a.a.a.a.a(this);
    }

    private void L() {
        com.getpebble.android.bluetooth.h.d.a(new com.getpebble.android.bluetooth.h.d.a(this) {
            final /* synthetic */ PebbleApplication a;

            {
                this.a = r1;
            }

            public void a(e.a aVar, ContentResolver contentResolver) {
                au.a(aVar, contentResolver);
            }

            public boolean a() {
                if (PebbleApplication.i != null) {
                    return PebbleApplication.i.a(c.a.HEX_DUMP, false);
                }
                com.getpebble.android.common.b.a.f.f(PebbleApplication.a, "getHexDumpEnabled: sPrefs is null");
                return false;
            }

            public void a(PebbleDevice pebbleDevice, boolean z) {
                com.getpebble.android.common.b.a.a.f.b(pebbleDevice, z);
            }

            public boolean b() {
                if (PebbleApplication.i == null) {
                    com.getpebble.android.common.b.a.f.f(PebbleApplication.a, "getVerboseBleLoggingEnabled: sPrefs is null");
                }
                return false;
            }

            public boolean a(String str, String str2, Transport transport, BluetoothClass bluetoothClass, int i, g gVar) {
                return com.getpebble.android.common.c.b.a(str, str2, transport, bluetoothClass, i, gVar);
            }

            public void c() {
                com.getpebble.android.common.b.a.f.c(PebbleApplication.a, "sendResetBluetoothNotification()");
                an.a(this.a).a(676583, new android.support.v7.a.c.a(this.a).a((int) R.drawable.disconnected_notification).a(this.a.getString(R.string.bt_reset_notification_title)).b(this.a.getString(R.string.bt_reset_notification_content)).a(PendingIntent.getActivity(this.a, 0, new Intent("android.settings.BLUETOOTH_SETTINGS"), 134217728)).c(true).b());
            }

            public void a(PebbleDevice pebbleDevice, com.getpebble.android.bluetooth.a.a aVar, boolean z, com.getpebble.android.bluetooth.b.d dVar) {
                com.getpebble.android.common.b.a.a.f.a(pebbleDevice, aVar, z, dVar);
            }

            public void a(com.getpebble.android.bluetooth.a.a aVar, boolean z) {
                com.getpebble.android.common.b.a.a.f.a(aVar, z);
            }

            public void a(PebbleDevice pebbleDevice, int i, int i2, Boolean bool) {
                com.getpebble.android.common.b.a.a.f.a(pebbleDevice, i, i2, bool);
            }

            public void a(PebbleDevice pebbleDevice, String str) {
                ak.setExtraUiStatus(a.K().getContentResolver(), pebbleDevice, str);
            }
        });
    }

    protected boolean d() {
        return a.a((Context) this);
    }

    protected void e() {
        new a(this, h).c().a().b().d().a(this).e();
    }

    public static void a(Object obj) {
        a.a(obj);
    }

    protected void f() {
        com.getpebble.android.a.b.initialise();
        com.getpebble.android.a.b.addDefaultProperties();
        com.getpebble.android.common.b.a.c.a(a.K());
    }

    protected com.getpebble.android.common.a.a g() {
        return com.getpebble.android.common.a.a.f();
    }

    protected void h() {
        if ("prod".equals("dev")) {
            com.getpebble.android.common.b.a.f.d(a, "Not enabling HockeyApp for DEV build");
        } else {
            net.hockeyapp.android.b.a((Context) this, "fcca466be5aa6ae73c82d7729866d502", l);
        }
    }

    protected void i() {
        List<Task> linkedList = new LinkedList();
        linkedList.add(new PeriodicTask.a().a(TaskService.class).a("health-upload-metered").a(com.getpebble.android.core.sync.b.a).a(0).b());
        linkedList.add(new PeriodicTask.a().a(TaskService.class).a("health-upload-unmetered").a(com.getpebble.android.core.sync.b.b).a(1).b());
        linkedList.add(new PeriodicTask.a().a(TaskService.class).a("pipeline-upload-metered").a(com.getpebble.android.a.g.a).a(0).b());
        linkedList.add(new PeriodicTask.a().a(TaskService.class).a("pipeline-upload-unmetered").a(com.getpebble.android.a.g.b).a(1).b());
        linkedList.add(new PeriodicTask.a().a(TaskService.class).a("health-update-typical-periodic").a(com.getpebble.android.core.sync.a.c).a(2).b());
        linkedList.add(new PeriodicTask.a().a(TaskService.class).a("health-update-averageDailySteps-periodic").a(com.getpebble.android.core.sync.a.b).a(2).b());
        linkedList.add(new PeriodicTask.a().a(TaskService.class).a("health-update-averageSleepDuration-periodic").a(com.getpebble.android.core.sync.a.a).a(2).b());
        linkedList.add(new PeriodicTask.a().a(TaskService.class).a("health-update-typical-sleep-periodic").a(com.getpebble.android.core.sync.a.d).a(2).b());
        linkedList.add(new PeriodicTask.a().a(TaskService.class).a("health-update-heartRateInfo-periodic").a(com.getpebble.android.core.sync.a.e).a(2).b());
        linkedList.add(new OneoffTask.a().a(TaskService.class).a("health-update-typical-once").a(0, 1).a(2).b());
        linkedList.add(new OneoffTask.a().a(TaskService.class).a("health-update-averageDailySteps-once").a(0, 1).a(2).b());
        linkedList.add(new OneoffTask.a().a(TaskService.class).a("health-update-averageSleepDuration-once").a(0, 1).a(2).b());
        linkedList.add(new OneoffTask.a().a(TaskService.class).a("health-update-heartRateInfo-once").a(0, 1).a(2).b());
        for (Task a : linkedList) {
            TaskService.a(a);
        }
    }

    protected void j() {
        b = new f(this);
        b.a((Context) this);
    }

    protected void k() {
        com.getpebble.android.config.b.a(getApplicationContext(), null, true);
    }

    protected void l() {
        com.getpebble.android.notifications.b.b.a((Context) this);
    }

    protected com.getpebble.android.common.b.b.d.a m() {
        return com.getpebble.android.common.b.b.d.a((Context) this);
    }

    public static PebbleDevice n() {
        return b.a();
    }

    public static boolean o() {
        return n() != null;
    }

    public static ak.a p() {
        if (b == null) {
            return null;
        }
        return b.b();
    }

    public static ak.a q() {
        if (b == null) {
            return null;
        }
        return b.c();
    }

    public static ak.a r() {
        if (b == null) {
            return null;
        }
        return b.d();
    }

    public static void a(f.a aVar) {
        b.a(aVar);
    }

    public static void b(f.a aVar) {
        b.b(aVar);
    }

    public static void s() {
        if (a.K() == null) {
            com.getpebble.android.common.b.a.f.a(a, "context is null");
        } else {
            ((PebbleApplication) a.K()).t();
        }
    }

    protected void t() {
        if (g == null) {
            com.getpebble.android.common.b.a.f.d(a, "Binding to framework service");
            g = new com.getpebble.android.framework.d(a.K(), h);
            g.a();
        }
    }

    public void a(Throwable th) {
        if (!"prod".equals("dev")) {
            net.hockeyapp.android.d.a(th, l);
        }
    }

    public void onTerminate() {
        d = null;
        e = null;
        f = null;
        if (b != null) {
            b.b((Context) this);
            b = null;
        }
        if (g != null) {
            g.b();
            g = null;
        }
        super.onTerminate();
    }

    public static com.getpebble.android.common.a.a u() {
        return d;
    }

    public static d v() {
        return e;
    }

    public static com.getpebble.android.config.a w() {
        return f;
    }

    public static com.getpebble.android.framework.d x() {
        return g;
    }

    public static c y() {
        return i;
    }

    public static ag z() {
        return j;
    }

    public static SQLiteDatabase A() {
        return k;
    }

    public SharedPreferences getSharedPreferences(String str, int i) {
        return new b(getApplicationContext(), str);
    }

    public SharedPreferences a(String str, int i) {
        return super.getSharedPreferences(str, i);
    }

    public static SharedPreferences B() {
        return ((PebbleApplication) c).a(c.getPackageName() + "_preferences", 0);
    }

    public static void a(boolean z) {
        m++;
        if (m == 1) {
            M();
        }
        if (!z && u().h() == null) {
            Intent intent = new Intent(a.K(), OnboardingActivity.class);
            intent.setFlags(268468224);
            m = 0;
            a.K().startActivity(intent);
        }
    }

    public static void C() {
        a(false);
    }

    private static void M() {
        com.getpebble.android.common.b.a.a.c.i();
    }

    public static void D() {
        m--;
        if (m == 0) {
            N();
        }
    }

    private static void N() {
        com.getpebble.android.common.b.a.a.c.h();
    }

    public static com.getpebble.android.common.b.b.d.a E() {
        return h;
    }

    public static f F() {
        return b;
    }
}
