package com.getpebble.android.notifications;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.getpebble.android.bluetooth.b.c;
import com.getpebble.android.common.b.a.a;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.af;
import com.getpebble.android.f.d;
import com.getpebble.android.framework.i.b;
import com.getpebble.android.notifications.b.e;

public class PblNotificationService extends NotificationListenerService {
    private static PblNotificationService a = null;

    public void onCreate() {
        try {
            f.d("PblNotificationService", "onCreate()");
            super.onCreate();
            if (VERSION.SDK_INT >= 21) {
                d a = d.a();
                if (a == null) {
                    f.b("PblNotificationService", "onCreate() music manager is null!");
                } else {
                    a.b();
                }
            }
            c.a(new Runnable(this) {
                final /* synthetic */ PblNotificationService a;

                {
                    this.a = r1;
                }

                public void run() {
                    e.a(this.a.getApplicationContext(), true);
                }
            });
            b.a();
            a = this;
        } catch (Throwable e) {
            f.a("PblNotificationService", "Error handling notification", e);
            a.c.a("PblNotificationService", false, e);
        } catch (Throwable e2) {
            f.a("PblNotificationService", "Unrecoverable error occurred handling notification", e2);
            a.c.a("PblNotificationService", true, e2);
        }
    }

    public void onNotificationPosted(final StatusBarNotification statusBarNotification) {
        if (statusBarNotification == null) {
            try {
                f.b("PblNotificationService", "onNotificationPosted: sbn is null");
            } catch (Throwable e) {
                f.a("PblNotificationService", "Error handling notification", e);
                a.c.a("PblNotificationService", false, e);
            } catch (Throwable e2) {
                f.a("PblNotificationService", "Unrecoverable error occurred handling notification", e2);
                a.c.a("PblNotificationService", true, e2);
            }
        } else {
            f.e("PblNotificationService", "onNotificationPosted(" + statusBarNotification + ")");
            c.a(new Runnable(this) {
                final /* synthetic */ PblNotificationService b;

                public void run() {
                    e.a(this.b.getApplicationContext(), false);
                    com.getpebble.android.notifications.a.b a = com.getpebble.android.notifications.a.b.a(statusBarNotification, com.getpebble.android.notifications.a.b.c.NOTIFICATION, System.currentTimeMillis());
                    String g = a.g();
                    if (!(TextUtils.isEmpty(g) || a.o() || g.equals("com.getpebble.android.basalt"))) {
                        af.a(g, System.currentTimeMillis(), com.getpebble.android.common.a.K().getContentResolver());
                    }
                    b.a(a);
                }
            });
            f.e("PblNotificationService", "end onNotificationPosted id = " + statusBarNotification.getId());
        }
    }

    @SuppressLint({"NewApi"})
    public void onNotificationRemoved(final StatusBarNotification statusBarNotification) {
        if (statusBarNotification == null) {
            try {
                f.b("PblNotificationService", "onNotificationPosted: sbn is null");
            } catch (Throwable e) {
                f.a("PblNotificationService", "Error handling notification removal", e);
                a.c.a("PblNotificationService", false, e);
            } catch (Throwable e2) {
                f.a("PblNotificationService", "Unrecoverable error occurred handling notification", e2);
                a.c.a("PblNotificationService", true, e2);
            }
        } else {
            String key;
            f.e("PblNotificationService", "onNotificationRemoved(" + statusBarNotification + ")");
            if (VERSION.SDK_INT >= 20) {
                key = statusBarNotification.getKey();
            } else {
                key = null;
            }
            c.a(new Runnable(this) {
                final /* synthetic */ PblNotificationService c;

                public void run() {
                    e.a(this.c.getApplicationContext(), false);
                    b.a(statusBarNotification.getId(), statusBarNotification.getTag(), statusBarNotification.getPackageName(), key, System.currentTimeMillis());
                }
            });
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(com.getpebble.android.notifications.a.a.a aVar) {
        try {
            PblNotificationService pblNotificationService = a;
            if (pblNotificationService == null) {
                f.d("PblNotificationService", "Cannot cancel notification, service is null");
            } else if (VERSION.SDK_INT >= 21) {
                f.d("PblNotificationService", "cancelNotification() key = " + aVar.d);
                pblNotificationService.cancelNotification(aVar.d);
            } else {
                f.d("PblNotificationService", "cancelNotification() packageName = " + aVar.c + " tag = " + aVar.b + " id = " + aVar.a);
                pblNotificationService.cancelNotification(aVar.c, aVar.b, aVar.a);
            }
        } catch (Throwable e) {
            f.a("PblNotificationService", "Error in dismissNotification", e);
            a.c.a("PblNotificationService", false, e);
        } catch (Throwable e2) {
            f.a("PblNotificationService", "Unrecoverable error occurred dismissing notification", e2);
            a.c.a("PblNotificationService", true, e2);
        }
    }

    public void onDestroy() {
        try {
            f.d("PblNotificationService", "onDestroy()");
            a = null;
            super.onDestroy();
        } catch (Throwable e) {
            f.a("PblNotificationService", "Error in onDestroy", e);
        } catch (Throwable e2) {
            f.a("PblNotificationService", "Unrecoverable error occurred", e2);
        }
    }

    public SharedPreferences getSharedPreferences(String str, int i) {
        try {
            return new com.getpebble.android.common.framework.d(getApplicationContext(), str);
        } catch (Throwable e) {
            f.a("PblNotificationService", "Error returning shared preferences reference", e);
            a.c.a("PblNotificationService", false, e);
            return null;
        } catch (Throwable e2) {
            f.a("PblNotificationService", "Unrecoverable error occurred handling notification", e2);
            a.c.a("PblNotificationService", true, e2);
        }
    }
}
