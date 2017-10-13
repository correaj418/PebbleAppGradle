package android.support.v7.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.app.ab;
import android.support.v4.app.ag.a;
import android.support.v7.b.a.d;
import android.support.v7.b.a.f;
import android.support.v7.b.a.g;
import android.support.v7.b.a.h;
import android.support.v7.b.a.i;
import android.widget.RemoteViews;
import java.text.NumberFormat;
import java.util.List;

class e {
    public static <T extends a> void a(ab abVar, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent) {
        abVar.a().setContent(a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, (List) list, iArr, z2, pendingIntent));
        if (z2) {
            abVar.a().setOngoing(true);
        }
    }

    private static <T extends a> RemoteViews a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent) {
        int i2;
        RemoteViews a = a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, h.notification_template_media, true);
        int size = list.size();
        if (iArr == null) {
            i2 = 0;
        } else {
            i2 = Math.min(iArr.length, 3);
        }
        a.removeAllViews(f.media_actions);
        if (i2 > 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                if (i3 >= size) {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(i3), Integer.valueOf(size - 1)}));
                }
                a.addView(f.media_actions, a(context, (a) list.get(iArr[i3])));
            }
        }
        if (z2) {
            a.setViewVisibility(f.end_padder, 8);
            a.setViewVisibility(f.cancel_action, 0);
            a.setOnClickPendingIntent(f.cancel_action, pendingIntent);
            a.setInt(f.cancel_action, "setAlpha", context.getResources().getInteger(g.cancel_button_image_alpha));
        } else {
            a.setViewVisibility(f.end_padder, 0);
            a.setViewVisibility(f.cancel_action, 8);
        }
        return a;
    }

    public static <T extends a> void a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, boolean z2, PendingIntent pendingIntent) {
        notification.bigContentView = a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, list, z2, pendingIntent);
        if (z2) {
            notification.flags |= 2;
        }
    }

    private static <T extends a> RemoteViews a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, boolean z2, PendingIntent pendingIntent) {
        int min = Math.min(list.size(), 5);
        RemoteViews a = a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, a(min), false);
        a.removeAllViews(f.media_actions);
        if (min > 0) {
            for (int i2 = 0; i2 < min; i2++) {
                a.addView(f.media_actions, a(context, (a) list.get(i2)));
            }
        }
        if (z2) {
            a.setViewVisibility(f.cancel_action, 0);
            a.setInt(f.cancel_action, "setAlpha", context.getResources().getInteger(g.cancel_button_image_alpha));
            a.setOnClickPendingIntent(f.cancel_action, pendingIntent);
        } else {
            a.setViewVisibility(f.cancel_action, 8);
        }
        return a;
    }

    private static RemoteViews a(Context context, a aVar) {
        Object obj = aVar.c() == null ? 1 : null;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), h.notification_media_action);
        remoteViews.setImageViewResource(f.action0, aVar.a());
        if (obj == null) {
            remoteViews.setOnClickPendingIntent(f.action0, aVar.c());
        }
        if (VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(f.action0, aVar.b());
        }
        return remoteViews;
    }

    private static int a(int i) {
        if (i <= 3) {
            return h.notification_template_big_media_narrow;
        }
        return h.notification_template_big_media;
    }

    private static RemoteViews a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, boolean z2) {
        Object obj;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i2);
        Object obj2 = null;
        Object obj3 = null;
        if (bitmap == null || VERSION.SDK_INT < 16) {
            remoteViews.setViewVisibility(f.icon, 8);
        } else {
            remoteViews.setViewVisibility(f.icon, 0);
            remoteViews.setImageViewBitmap(f.icon, bitmap);
        }
        if (charSequence != null) {
            remoteViews.setTextViewText(f.title, charSequence);
        }
        if (charSequence2 != null) {
            remoteViews.setTextViewText(f.text, charSequence2);
            obj2 = 1;
        }
        if (charSequence3 != null) {
            remoteViews.setTextViewText(f.info, charSequence3);
            remoteViews.setViewVisibility(f.info, 0);
            obj = 1;
        } else if (i > 0) {
            if (i > context.getResources().getInteger(g.status_bar_notification_info_maxnum)) {
                remoteViews.setTextViewText(f.info, context.getResources().getString(i.status_bar_notification_info_overflow));
            } else {
                remoteViews.setTextViewText(f.info, NumberFormat.getIntegerInstance().format((long) i));
            }
            remoteViews.setViewVisibility(f.info, 0);
            int i3 = 1;
        } else {
            remoteViews.setViewVisibility(f.info, 8);
            obj = obj2;
        }
        if (charSequence4 != null && VERSION.SDK_INT >= 16) {
            remoteViews.setTextViewText(f.text, charSequence4);
            if (charSequence2 != null) {
                remoteViews.setTextViewText(f.text2, charSequence2);
                remoteViews.setViewVisibility(f.text2, 0);
                obj3 = 1;
            } else {
                remoteViews.setViewVisibility(f.text2, 8);
            }
        }
        if (obj3 != null && VERSION.SDK_INT >= 16) {
            if (z2) {
                remoteViews.setTextViewTextSize(f.text, 0, (float) context.getResources().getDimensionPixelSize(d.notification_subtext_size));
            }
            remoteViews.setViewPadding(f.line1, 0, 0, 0, 0);
        }
        if (j != 0) {
            if (z) {
                remoteViews.setViewVisibility(f.chronometer, 0);
                remoteViews.setLong(f.chronometer, "setBase", (SystemClock.elapsedRealtime() - System.currentTimeMillis()) + j);
                remoteViews.setBoolean(f.chronometer, "setStarted", true);
            } else {
                remoteViews.setViewVisibility(f.time, 0);
                remoteViews.setLong(f.time, "setTime", j);
            }
        }
        remoteViews.setViewVisibility(f.line3, obj != null ? 0 : 8);
        return remoteViews;
    }
}
