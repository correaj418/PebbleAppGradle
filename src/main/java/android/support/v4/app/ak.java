package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.getpebble.android.common.model.an;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ak {
    private static final Object a = new Object();
    private static Field b;
    private static boolean c;
    private static final Object d = new Object();
    private static Class<?> e;
    private static Field f;
    private static Field g;
    private static Field h;
    private static Field i;
    private static boolean j;

    public static class a implements aa, ab {
        private Builder a;
        private final Bundle b;
        private List<Bundle> c = new ArrayList();
        private RemoteViews d;
        private RemoteViews e;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            this.a = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.b = new Bundle();
            if (bundle != null) {
                this.b.putAll(bundle);
            }
            if (z3) {
                this.b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.b.putString("android.support.groupKey", str);
                if (z4) {
                    this.b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.b.putString("android.support.sortKey", str2);
            }
            this.d = remoteViews2;
            this.e = remoteViews3;
        }

        public void a(android.support.v4.app.ag.a aVar) {
            this.c.add(ak.a(this.a, aVar));
        }

        public Builder a() {
            return this.a;
        }

        public Notification b() {
            Notification build = this.a.build();
            Bundle a = ak.a(build);
            Bundle bundle = new Bundle(this.b);
            for (String str : this.b.keySet()) {
                if (a.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a.putAll(bundle);
            SparseArray a2 = ak.a(this.c);
            if (a2 != null) {
                ak.a(build).putSparseParcelableArray("android.support.actionExtras", a2);
            }
            if (this.d != null) {
                build.contentView = this.d;
            }
            if (this.e != null) {
                build.bigContentView = this.e;
            }
            return build;
        }
    }

    public static void a(ab abVar, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        BigTextStyle bigText = new BigTextStyle(abVar.a()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    public static void a(ab abVar, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        BigPictureStyle bigPicture = new BigPictureStyle(abVar.a()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public static void a(ab abVar, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        InboxStyle bigContentTitle = new InboxStyle(abVar.a()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine((CharSequence) it.next());
        }
    }

    public static SparseArray<Bundle> a(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle a(Notification notification) {
        synchronized (a) {
            if (c) {
                return null;
            }
            try {
                if (b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        b = declaredField;
                    } else {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        c = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    b.set(notification, bundle);
                }
                return bundle;
            } catch (Throwable e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                c = true;
                return null;
            } catch (Throwable e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                c = true;
                return null;
            }
        }
    }

    public static android.support.v4.app.ag.a a(android.support.v4.app.ag.a.a aVar, android.support.v4.app.at.a.a aVar2, int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        android.support.v4.app.at.a[] aVarArr = null;
        boolean z = false;
        if (bundle != null) {
            aVarArr = au.a(i.a(bundle, "android.support.remoteInputs"), aVar2);
            z = bundle.getBoolean("android.support.allowGeneratedReplies");
        }
        return aVar.a(i, charSequence, pendingIntent, bundle, aVarArr, z);
    }

    public static Bundle a(Builder builder, android.support.v4.app.ag.a aVar) {
        builder.addAction(aVar.a(), aVar.b(), aVar.c());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.g() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", au.a(aVar.g()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e());
        return bundle;
    }

    public static int b(Notification notification) {
        int length;
        synchronized (d) {
            Object[] e = e(notification);
            length = e != null ? e.length : 0;
        }
        return length;
    }

    public static android.support.v4.app.ag.a a(Notification notification, int i, android.support.v4.app.ag.a.a aVar, android.support.v4.app.at.a.a aVar2) {
        android.support.v4.app.ag.a a;
        synchronized (d) {
            try {
                Bundle bundle;
                Object obj = e(notification)[i];
                Bundle a2 = a(notification);
                if (a2 != null) {
                    SparseArray sparseParcelableArray = a2.getSparseParcelableArray("android.support.actionExtras");
                    if (sparseParcelableArray != null) {
                        bundle = (Bundle) sparseParcelableArray.get(i);
                        a = a(aVar, aVar2, g.getInt(obj), (CharSequence) h.get(obj), (PendingIntent) i.get(obj), bundle);
                    }
                }
                bundle = null;
                a = a(aVar, aVar2, g.getInt(obj), (CharSequence) h.get(obj), (PendingIntent) i.get(obj), bundle);
            } catch (Throwable e) {
                Log.e("NotificationCompat", "Unable to access notification actions", e);
                j = true;
                return null;
            }
        }
        return a;
    }

    private static Object[] e(Notification notification) {
        synchronized (d) {
            if (a()) {
                try {
                    Object[] objArr = (Object[]) f.get(notification);
                    return objArr;
                } catch (Throwable e) {
                    Log.e("NotificationCompat", "Unable to access notification actions", e);
                    j = true;
                    return null;
                }
            }
            return null;
        }
    }

    private static boolean a() {
        boolean z = true;
        if (j) {
            return false;
        }
        try {
            if (f == null) {
                e = Class.forName("android.app.Notification$Action");
                g = e.getDeclaredField("icon");
                h = e.getDeclaredField(an.TITLE);
                i = e.getDeclaredField("actionIntent");
                f = Notification.class.getDeclaredField("actions");
                f.setAccessible(true);
            }
        } catch (Throwable e) {
            Log.e("NotificationCompat", "Unable to access notification actions", e);
            j = true;
        } catch (Throwable e2) {
            Log.e("NotificationCompat", "Unable to access notification actions", e2);
            j = true;
        }
        if (j) {
            z = false;
        }
        return z;
    }

    public static android.support.v4.app.ag.a[] a(ArrayList<Parcelable> arrayList, android.support.v4.app.ag.a.a aVar, android.support.v4.app.at.a.a aVar2) {
        if (arrayList == null) {
            return null;
        }
        android.support.v4.app.ag.a[] b = aVar.b(arrayList.size());
        for (int i = 0; i < b.length; i++) {
            b[i] = a((Bundle) arrayList.get(i), aVar, aVar2);
        }
        return b;
    }

    private static android.support.v4.app.ag.a a(Bundle bundle, android.support.v4.app.ag.a.a aVar, android.support.v4.app.at.a.a aVar2) {
        return aVar.a(bundle.getInt("icon"), bundle.getCharSequence(an.TITLE), (PendingIntent) bundle.getParcelable("actionIntent"), bundle.getBundle("extras"), au.a(i.a(bundle, "remoteInputs"), aVar2), bundle.getBoolean("allowGeneratedReplies"));
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

    private static Bundle a(android.support.v4.app.ag.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("icon", aVar.a());
        bundle.putCharSequence(an.TITLE, aVar.b());
        bundle.putParcelable("actionIntent", aVar.c());
        bundle.putBundle("extras", aVar.d());
        bundle.putParcelableArray("remoteInputs", au.a(aVar.g()));
        return bundle;
    }

    public static String c(Notification notification) {
        return a(notification).getString("android.support.groupKey");
    }

    public static boolean d(Notification notification) {
        return a(notification).getBoolean("android.support.isGroupSummary");
    }
}
