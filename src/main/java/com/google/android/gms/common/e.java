package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v4.app.ac.d;
import android.support.v4.app.l;
import android.util.TypedValue;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;
import com.google.android.gms.common.a.g;
import com.google.android.gms.common.a.k;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;

public final class e extends k {
    @Deprecated
    public static final int a = k.b;

    @Deprecated
    public static Dialog a(int i, Activity activity, int i2) {
        return a(i, activity, i2, null);
    }

    @Deprecated
    public static Dialog a(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        return a(i, activity, n.a(activity, b.a().a((Context) activity, i, "d"), i2), onCancelListener);
    }

    @TargetApi(14)
    public static Dialog a(int i, Activity activity, n nVar, OnCancelListener onCancelListener) {
        Builder builder = null;
        if (i == 0) {
            return null;
        }
        if (g.a((Context) activity) && i == 2) {
            i = 42;
        }
        if (a(activity, i)) {
            i = 18;
        }
        if (k.c()) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(16843529, typedValue, true);
            if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new Builder(activity, 5);
            }
        }
        if (builder == null) {
            builder = new Builder(activity);
        }
        builder.setMessage(m.a(activity, i, k.g(activity)));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        CharSequence c = m.c(activity, i);
        if (c != null) {
            builder.setPositiveButton(c, nVar);
        }
        c = m.a(activity, i);
        if (c != null) {
            builder.setTitle(c);
        }
        return builder.create();
    }

    static void a(int i, Context context, PendingIntent pendingIntent) {
        a(i, context, null, pendingIntent);
    }

    @TargetApi(20)
    private static void a(int i, Context context, String str, PendingIntent pendingIntent) {
        Notification build;
        int i2;
        Resources resources = context.getResources();
        String g = k.g(context);
        CharSequence b = m.b(context, i);
        if (b == null) {
            b = resources.getString(b.common_google_play_services_notification_ticker);
        }
        CharSequence b2 = m.b(context, i, g);
        if (g.a(context)) {
            com.google.android.gms.common.internal.b.a(k.d());
            build = new Notification.Builder(context).setSmallIcon(a.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new BigTextStyle().bigText(new StringBuilder((String.valueOf(b).length() + 1) + String.valueOf(b2).length()).append(b).append(" ").append(b2).toString())).addAction(a.common_full_open_on_phone, resources.getString(b.common_open_on_phone), pendingIntent).build();
        } else {
            CharSequence string = resources.getString(b.common_google_play_services_notification_ticker);
            if (k.a()) {
                Notification build2;
                Notification.Builder autoCancel = new Notification.Builder(context).setSmallIcon(17301642).setContentTitle(b).setContentText(b2).setContentIntent(pendingIntent).setTicker(string).setAutoCancel(true);
                if (k.g()) {
                    autoCancel.setLocalOnly(true);
                }
                if (k.d()) {
                    autoCancel.setStyle(new BigTextStyle().bigText(b2));
                    build2 = autoCancel.build();
                } else {
                    build2 = autoCancel.getNotification();
                }
                if (VERSION.SDK_INT == 19) {
                    build2.extras.putBoolean("android.support.localOnly", true);
                }
                build = build2;
            } else {
                build = new d(context).a(17301642).c(string).a(System.currentTimeMillis()).c(true).a(pendingIntent).a(b).b(b2).b();
            }
        }
        if (k.a(i)) {
            f.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (str != null) {
            notificationManager.notify(str, i2, build);
        } else {
            notificationManager.notify(i2, build);
        }
    }

    @TargetApi(11)
    public static void a(Activity activity, OnCancelListener onCancelListener, String str, Dialog dialog) {
        boolean z;
        try {
            z = activity instanceof l;
        } catch (NoClassDefFoundError e) {
            z = false;
        }
        if (z) {
            f.a(dialog, onCancelListener).a(((l) activity).f(), str);
        } else if (k.a()) {
            a.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
    }

    public static boolean a(int i, Activity activity, android.support.v4.app.k kVar, int i2, OnCancelListener onCancelListener) {
        Intent a = b.a().a((Context) activity, i, "d");
        Dialog a2 = a(i, activity, kVar == null ? n.a(activity, a, i2) : n.a(kVar, a, i2), onCancelListener);
        if (a2 == null) {
            return false;
        }
        a(activity, onCancelListener, "GooglePlayServicesErrorDialog", a2);
        return true;
    }

    @Deprecated
    public static boolean a(Context context, int i) {
        return k.c(context, i);
    }

    @Deprecated
    public static boolean b(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        return a(i, activity, null, i2, onCancelListener);
    }
}
