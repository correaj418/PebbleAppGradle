package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RemoteViews;
import java.util.ArrayList;

class ad {

    public static class a implements aa, ab {
        private Builder a;
        private Bundle b;
        private RemoteViews c;
        private RemoteViews d;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            this.a = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
            this.b = new Bundle();
            if (bundle != null) {
                this.b.putAll(bundle);
            }
            if (!(arrayList == null || arrayList.isEmpty())) {
                this.b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            this.c = remoteViews2;
            this.d = remoteViews3;
        }

        public void a(android.support.v4.app.ag.a aVar) {
            ad.a(this.a, aVar);
        }

        public Builder a() {
            return this.a;
        }

        public Notification b() {
            this.a.setExtras(this.b);
            Notification build = this.a.build();
            if (this.c != null) {
                build.contentView = this.c;
            }
            if (this.d != null) {
                build.bigContentView = this.d;
            }
            return build;
        }
    }

    public static void a(Builder builder, android.support.v4.app.ag.a aVar) {
        Bundle bundle;
        Action.Builder builder2 = new Action.Builder(aVar.a(), aVar.b(), aVar.c());
        if (aVar.g() != null) {
            for (RemoteInput addRemoteInput : as.a(aVar.g())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (aVar.d() != null) {
            bundle = new Bundle(aVar.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e());
        builder2.addExtras(bundle);
        builder.addAction(builder2.build());
    }

    public static android.support.v4.app.ag.a a(Notification notification, int i, android.support.v4.app.ag.a.a aVar, android.support.v4.app.at.a.a aVar2) {
        return a(notification.actions[i], aVar, aVar2);
    }

    private static android.support.v4.app.ag.a a(Action action, android.support.v4.app.ag.a.a aVar, android.support.v4.app.at.a.a aVar2) {
        return aVar.a(action.icon, action.title, action.actionIntent, action.getExtras(), as.a(action.getRemoteInputs(), aVar2), action.getExtras().getBoolean("android.support.allowGeneratedReplies"));
    }

    private static Action a(android.support.v4.app.ag.a aVar) {
        Action.Builder addExtras = new Action.Builder(aVar.a(), aVar.b(), aVar.c()).addExtras(aVar.d());
        android.support.v4.app.at.a[] g = aVar.g();
        if (g != null) {
            for (RemoteInput addRemoteInput : as.a(g)) {
                addExtras.addRemoteInput(addRemoteInput);
            }
        }
        return addExtras.build();
    }

    public static android.support.v4.app.ag.a[] a(ArrayList<Parcelable> arrayList, android.support.v4.app.ag.a.a aVar, android.support.v4.app.at.a.a aVar2) {
        if (arrayList == null) {
            return null;
        }
        android.support.v4.app.ag.a[] b = aVar.b(arrayList.size());
        for (int i = 0; i < b.length; i++) {
            b[i] = a((Action) arrayList.get(i), aVar, aVar2);
        }
        return b;
    }

    public static ArrayList<Parcelable> a(android.support.v4.app.ag.a[] aVarArr) {
        if (aVarArr == null) {
            return null;
        }
        ArrayList<Parcelable> arrayList = new ArrayList(aVarArr.length);
        for (android.support.v4.app.ag.a a : aVarArr) {
            arrayList.add(a(a));
        }
        return arrayList;
    }

    public static String a(Notification notification) {
        return notification.getGroup();
    }

    public static boolean b(Notification notification) {
        return (notification.flags & 512) != 0;
    }
}
