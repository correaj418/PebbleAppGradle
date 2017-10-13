package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.provider.Settings.Secure;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class an {
    private static final int a = i.a();
    private static final Object b = new Object();
    private static String c;
    private static Set<String> d = new HashSet();
    private static final Object g = new Object();
    private static j h;
    private static final b i;
    private final Context e;
    private final NotificationManager f = ((NotificationManager) this.e.getSystemService("notification"));

    private interface k {
        void a(u uVar);
    }

    private static class a implements k {
        final String a;
        final int b;
        final String c;
        final boolean d = false;

        public a(String str, int i, String str2) {
            this.a = str;
            this.b = i;
            this.c = str2;
        }

        public void a(u uVar) {
            if (this.d) {
                uVar.a(this.a);
            } else {
                uVar.a(this.a, this.b, this.c);
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("CancelTask[");
            stringBuilder.append("packageName:").append(this.a);
            stringBuilder.append(", id:").append(this.b);
            stringBuilder.append(", tag:").append(this.c);
            stringBuilder.append(", all:").append(this.d);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    interface b {
        int a();

        void a(NotificationManager notificationManager, String str, int i);

        void a(NotificationManager notificationManager, String str, int i, Notification notification);

        boolean a(Context context, NotificationManager notificationManager);
    }

    static class d implements b {
        d() {
        }

        public void a(NotificationManager notificationManager, String str, int i) {
            notificationManager.cancel(i);
        }

        public void a(NotificationManager notificationManager, String str, int i, Notification notification) {
            notificationManager.notify(i, notification);
        }

        public int a() {
            return 1;
        }

        public boolean a(Context context, NotificationManager notificationManager) {
            return true;
        }
    }

    static class e extends d {
        e() {
        }

        public void a(NotificationManager notificationManager, String str, int i) {
            ap.a(notificationManager, str, i);
        }

        public void a(NotificationManager notificationManager, String str, int i, Notification notification) {
            ap.a(notificationManager, str, i, notification);
        }
    }

    static class f extends e {
        f() {
        }

        public int a() {
            return 33;
        }
    }

    static class g extends f {
        g() {
        }

        public boolean a(Context context, NotificationManager notificationManager) {
            return aq.a(context);
        }
    }

    static class c extends g {
        c() {
        }

        public boolean a(Context context, NotificationManager notificationManager) {
            return ao.a(notificationManager);
        }
    }

    private static class h implements k {
        final String a;
        final int b;
        final String c;
        final Notification d;

        public h(String str, int i, String str2, Notification notification) {
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = notification;
        }

        public void a(u uVar) {
            uVar.a(this.a, this.b, this.c, this.d);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
            stringBuilder.append("packageName:").append(this.a);
            stringBuilder.append(", id:").append(this.b);
            stringBuilder.append(", tag:").append(this.c);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    private static class i {
        final ComponentName a;
        final IBinder b;

        public i(ComponentName componentName, IBinder iBinder) {
            this.a = componentName;
            this.b = iBinder;
        }
    }

    private static class j implements ServiceConnection, Callback {
        private final Context a;
        private final HandlerThread b;
        private final Handler c;
        private final Map<ComponentName, a> d = new HashMap();
        private Set<String> e = new HashSet();

        private static class a {
            public final ComponentName a;
            public boolean b = false;
            public u c;
            public LinkedList<k> d = new LinkedList();
            public int e = 0;

            public a(ComponentName componentName) {
                this.a = componentName;
            }
        }

        public j(Context context) {
            this.a = context;
            this.b = new HandlerThread("NotificationManagerCompat");
            this.b.start();
            this.c = new Handler(this.b.getLooper(), this);
        }

        public void a(k kVar) {
            this.c.obtainMessage(0, kVar).sendToTarget();
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    b((k) message.obj);
                    return true;
                case 1:
                    i iVar = (i) message.obj;
                    a(iVar.a, iVar.b);
                    return true;
                case 2:
                    a((ComponentName) message.obj);
                    return true;
                case 3:
                    b((ComponentName) message.obj);
                    return true;
                default:
                    return false;
            }
        }

        private void b(k kVar) {
            a();
            for (a aVar : this.d.values()) {
                aVar.d.add(kVar);
                d(aVar);
            }
        }

        private void a(ComponentName componentName, IBinder iBinder) {
            a aVar = (a) this.d.get(componentName);
            if (aVar != null) {
                aVar.c = android.support.v4.app.u.a.a(iBinder);
                aVar.e = 0;
                d(aVar);
            }
        }

        private void a(ComponentName componentName) {
            a aVar = (a) this.d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        private void b(ComponentName componentName) {
            a aVar = (a) this.d.get(componentName);
            if (aVar != null) {
                d(aVar);
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.c.obtainMessage(1, new i(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.c.obtainMessage(2, componentName).sendToTarget();
        }

        private void a() {
            Set b = an.b(this.a);
            if (!b.equals(this.e)) {
                this.e = b;
                List<ResolveInfo> queryIntentServices = this.a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
                Set<ComponentName> hashSet = new HashSet();
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (b.contains(resolveInfo.serviceInfo.packageName)) {
                        ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                        if (resolveInfo.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.d.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        this.d.put(componentName2, new a(componentName2));
                    }
                }
                Iterator it = this.d.entrySet().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (!hashSet.contains(entry.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                        }
                        b((a) entry.getValue());
                        it.remove();
                    }
                }
            }
        }

        private boolean a(a aVar) {
            if (aVar.b) {
                return true;
            }
            aVar.b = this.a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.a), this, an.a);
            if (aVar.b) {
                aVar.e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.a);
                this.a.unbindService(this);
            }
            return aVar.b;
        }

        private void b(a aVar) {
            if (aVar.b) {
                this.a.unbindService(this);
                aVar.b = false;
            }
            aVar.c = null;
        }

        private void c(a aVar) {
            if (!this.c.hasMessages(3, aVar.a)) {
                aVar.e++;
                if (aVar.e > 6) {
                    Log.w("NotifManCompat", "Giving up on delivering " + aVar.d.size() + " tasks to " + aVar.a + " after " + aVar.e + " retries");
                    aVar.d.clear();
                    return;
                }
                int i = (1 << (aVar.e - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i + " ms");
                }
                this.c.sendMessageDelayed(this.c.obtainMessage(3, aVar.a), (long) i);
            }
        }

        private void d(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.a + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + aVar.d.size() + " queued tasks");
            }
            if (!aVar.d.isEmpty()) {
                if (!a(aVar) || aVar.c == null) {
                    c(aVar);
                    return;
                }
                while (true) {
                    k kVar = (k) aVar.d.peek();
                    if (kVar == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + kVar);
                        }
                        kVar.a(aVar.c);
                        aVar.d.remove();
                    } catch (DeadObjectException e) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + aVar.a);
                        }
                    } catch (Throwable e2) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + aVar.a, e2);
                    }
                }
                if (!aVar.d.isEmpty()) {
                    c(aVar);
                }
            }
        }
    }

    static {
        if (android.support.v4.d.c.a()) {
            i = new c();
        } else if (VERSION.SDK_INT >= 19) {
            i = new g();
        } else if (VERSION.SDK_INT >= 14) {
            i = new f();
        } else if (VERSION.SDK_INT >= 5) {
            i = new e();
        } else {
            i = new d();
        }
    }

    public static an a(Context context) {
        return new an(context);
    }

    private an(Context context) {
        this.e = context;
    }

    public void a(int i) {
        a(null, i);
    }

    public void a(String str, int i) {
        i.a(this.f, str, i);
        if (VERSION.SDK_INT <= 19) {
            a(new a(this.e.getPackageName(), i, str));
        }
    }

    public void a(int i, Notification notification) {
        a(null, i, notification);
    }

    public void a(String str, int i, Notification notification) {
        if (a(notification)) {
            a(new h(this.e.getPackageName(), i, str, notification));
            i.a(this.f, str, i);
            return;
        }
        i.a(this.f, str, i, notification);
    }

    public boolean a() {
        return i.a(this.e, this.f);
    }

    public static Set<String> b(Context context) {
        String string = Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (b) {
            if (string != null) {
                if (!string.equals(c)) {
                    String[] split = string.split(":");
                    Set hashSet = new HashSet(split.length);
                    for (String unflattenFromString : split) {
                        ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                        if (unflattenFromString2 != null) {
                            hashSet.add(unflattenFromString2.getPackageName());
                        }
                    }
                    d = hashSet;
                    c = string;
                }
            }
        }
        return d;
    }

    private static boolean a(Notification notification) {
        Bundle a = ac.a(notification);
        return a != null && a.getBoolean("android.support.useSideChannel");
    }

    private void a(k kVar) {
        synchronized (g) {
            if (h == null) {
                h = new j(this.e.getApplicationContext());
            }
            h.a(kVar);
        }
    }
}
