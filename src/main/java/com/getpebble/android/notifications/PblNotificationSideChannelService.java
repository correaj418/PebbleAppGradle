package com.getpebble.android.notifications;

import android.app.Notification;
import android.support.v4.app.am;
import com.getpebble.android.bluetooth.b.c;
import com.getpebble.android.common.b.a.a;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.i.b;

public class PblNotificationSideChannelService extends am {
    public void a(final String str, int i, String str2, final Notification notification) {
        try {
            f.d("PblNotificationSideChannelService", "notify: packageName = " + str + " id = " + i + " tag = " + str2);
            c.a(new Runnable(this) {
                final /* synthetic */ PblNotificationSideChannelService c;

                public void run() {
                    if (notification == null) {
                        f.a("PblNotificationSideChannelService", "Failed to create PebbleNotification: notification was null");
                    } else if (str == null) {
                        f.a("PblNotificationSideChannelService", "Failed to create PebbleNotification: packageName was null.");
                    } else {
                        b.a(com.getpebble.android.notifications.a.b.a(notification, str, com.getpebble.android.notifications.a.b.c.SIDECHANNEL, System.currentTimeMillis()));
                    }
                }
            });
        } catch (Throwable e) {
            f.a("PblNotificationSideChannelService", "Error handling sidechannel notification", e);
            a.c.a("PblNotificationSideChannelService", false, e);
        } catch (Throwable e2) {
            f.a("PblNotificationSideChannelService", "Unrecoverable error occurred handling sidechannel notification", e2);
            a.c.a("PblNotificationSideChannelService", true, e2);
        }
    }

    public void a(final String str, final int i, final String str2) {
        try {
            f.d("PblNotificationSideChannelService", "cancel: packageName = " + str + " id = " + i + " tag = " + str2);
            c.a(new Runnable(this) {
                final /* synthetic */ PblNotificationSideChannelService d;

                public void run() {
                    b.a(i, str2, str, null, System.currentTimeMillis());
                }
            });
        } catch (Throwable e) {
            f.a("PblNotificationSideChannelService", "Error handling sidechannel notification", e);
            a.c.a("PblNotificationSideChannelService", false, e);
        } catch (Throwable e2) {
            f.a("PblNotificationSideChannelService", "Unrecoverable error occurred handling sidechannel notification", e2);
            a.c.a("PblNotificationSideChannelService", true, e2);
        }
    }

    public void a(final String str) {
        try {
            f.d("PblNotificationSideChannelService", "cancelAll: packageName = " + str);
            c.a(new Runnable(this) {
                final /* synthetic */ PblNotificationSideChannelService b;

                public void run() {
                    b.a(str, System.currentTimeMillis());
                }
            });
        } catch (Throwable e) {
            f.a("PblNotificationSideChannelService", "Error handling sidechannel notification", e);
            a.c.a("PblNotificationSideChannelService", false, e);
        } catch (Throwable e2) {
            f.a("PblNotificationSideChannelService", "Unrecoverable error occurred handling sidechannel notification", e2);
            a.c.a("PblNotificationSideChannelService", true, e2);
        }
    }
}
