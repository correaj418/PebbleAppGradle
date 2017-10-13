package com.google.android.gms.gcm;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.ac.d;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

class g {
    static g a;
    private final Context b;

    private class a extends IllegalArgumentException {
    }

    private g(Context context) {
        this.b = context.getApplicationContext();
    }

    private int a() {
        return (int) SystemClock.uptimeMillis();
    }

    static synchronized g a(Context context) {
        g gVar;
        synchronized (g.class) {
            if (a == null) {
                a = new g(context);
            }
            gVar = a;
        }
        return gVar;
    }

    static String a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private String a(String str) {
        return str.substring("gcm.n.".length());
    }

    private void a(String str, Notification notification) {
        if (Log.isLoggable("GcmNotification", 3)) {
            Log.d("GcmNotification", "Showing notification");
        }
        NotificationManager notificationManager = (NotificationManager) this.b.getSystemService("notification");
        if (TextUtils.isEmpty(str)) {
            str = "GCM-Notification:" + SystemClock.uptimeMillis();
        }
        notificationManager.notify(str, 0, notification);
    }

    static boolean a(Bundle bundle) {
        return "1".equals(a(bundle, "gcm.n.e")) || a(bundle, "gcm.n.icon") != null;
    }

    private int b(String str) {
        int identifier;
        if (!TextUtils.isEmpty(str)) {
            Resources resources = this.b.getResources();
            identifier = resources.getIdentifier(str, "drawable", this.b.getPackageName());
            if (identifier != 0) {
                return identifier;
            }
            identifier = resources.getIdentifier(str, "mipmap", this.b.getPackageName());
            if (identifier != 0) {
                return identifier;
            }
            Log.w("GcmNotification", new StringBuilder(String.valueOf(str).length() + 57).append("Icon resource ").append(str).append(" not found. Notification will use app icon.").toString());
        }
        identifier = this.b.getApplicationInfo().icon;
        return identifier == 0 ? 17301651 : identifier;
    }

    private String b(Bundle bundle, String str) {
        Object a = a(bundle, str);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_key");
        valueOf = a(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (TextUtils.isEmpty(valueOf)) {
            return null;
        }
        Resources resources = this.b.getResources();
        int identifier = resources.getIdentifier(valueOf, "string", this.b.getPackageName());
        if (identifier == 0) {
            String str2 = "GcmNotification";
            String valueOf3 = String.valueOf(str);
            valueOf2 = String.valueOf("_loc_key");
            valueOf2 = String.valueOf(a(valueOf2.length() != 0 ? valueOf3.concat(valueOf2) : new String(valueOf3)));
            Log.w(str2, new StringBuilder((String.valueOf(valueOf2).length() + 49) + String.valueOf(valueOf).length()).append(valueOf2).append(" resource not found: ").append(valueOf).append(" Default value will be used.").toString());
            return null;
        }
        String valueOf4 = String.valueOf(str);
        valueOf2 = String.valueOf("_loc_args");
        valueOf4 = a(bundle, valueOf2.length() != 0 ? valueOf4.concat(valueOf2) : new String(valueOf4));
        if (TextUtils.isEmpty(valueOf4)) {
            return resources.getString(identifier);
        }
        try {
            JSONArray jSONArray = new JSONArray(valueOf4);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = jSONArray.opt(i);
            }
            return resources.getString(identifier, strArr);
        } catch (JSONException e) {
            valueOf = "GcmNotification";
            str2 = String.valueOf(str);
            valueOf2 = String.valueOf("_loc_args");
            valueOf2 = String.valueOf(a(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2)));
            Log.w(valueOf, new StringBuilder((String.valueOf(valueOf2).length() + 41) + String.valueOf(valueOf4).length()).append("Malformed ").append(valueOf2).append(": ").append(valueOf4).append("  Default value will be used.").toString());
            return null;
        } catch (Throwable e2) {
            Log.w("GcmNotification", new StringBuilder((String.valueOf(valueOf).length() + 58) + String.valueOf(valueOf4).length()).append("Missing format argument for ").append(valueOf).append(": ").append(valueOf4).append(" Default value will be used.").toString(), e2);
            return null;
        }
    }

    static void b(Bundle bundle) {
        String str;
        Bundle bundle2 = new Bundle();
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            String string = bundle.getString(str);
            if (str.startsWith("gcm.notification.")) {
                str = str.replace("gcm.notification.", "gcm.n.");
            }
            if (str.startsWith("gcm.n.")) {
                if (!"gcm.n.e".equals(str)) {
                    bundle2.putString(str.substring("gcm.n.".length()), string);
                }
                it.remove();
            }
        }
        str = bundle2.getString("sound2");
        if (str != null) {
            bundle2.remove("sound2");
            bundle2.putString("sound", str);
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle("notification", bundle2);
        }
    }

    static boolean b(Context context) {
        if (((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        int myPid = Process.myPid();
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    private Uri c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if ("default".equals(str) || this.b.getResources().getIdentifier(str, "raw", this.b.getPackageName()) == 0) {
            return RingtoneManager.getDefaultUri(2);
        }
        String valueOf = String.valueOf("android.resource://");
        String valueOf2 = String.valueOf(this.b.getPackageName());
        return Uri.parse(new StringBuilder(((String.valueOf(valueOf).length() + 5) + String.valueOf(valueOf2).length()) + String.valueOf(str).length()).append(valueOf).append(valueOf2).append("/raw/").append(str).toString());
    }

    private Notification d(Bundle bundle) {
        CharSequence b = b(bundle, "gcm.n.title");
        CharSequence b2 = b(bundle, "gcm.n.body");
        int b3 = b(a(bundle, "gcm.n.icon"));
        Object a = a(bundle, "gcm.n.color");
        Uri c = c(a(bundle, "gcm.n.sound2"));
        PendingIntent e = e(bundle);
        d a2 = new d(this.b).c(true).a(b3);
        if (TextUtils.isEmpty(b)) {
            a2.a(this.b.getApplicationInfo().loadLabel(this.b.getPackageManager()));
        } else {
            a2.a(b);
        }
        if (!TextUtils.isEmpty(b2)) {
            a2.b(b2);
        }
        if (!TextUtils.isEmpty(a)) {
            a2.b(Color.parseColor(a));
        }
        if (c != null) {
            a2.a(c);
        }
        if (e != null) {
            a2.a(e);
        }
        return a2.b();
    }

    private PendingIntent e(Bundle bundle) {
        Intent intent;
        Object a = a(bundle, "gcm.n.click_action");
        Intent launchIntentForPackage;
        if (TextUtils.isEmpty(a)) {
            launchIntentForPackage = this.b.getPackageManager().getLaunchIntentForPackage(this.b.getPackageName());
            if (launchIntentForPackage == null) {
                Log.w("GcmNotification", "No activity found to launch app");
                return null;
            }
            intent = launchIntentForPackage;
        } else {
            launchIntentForPackage = new Intent(a);
            launchIntentForPackage.setPackage(this.b.getPackageName());
            launchIntentForPackage.setFlags(268435456);
            intent = launchIntentForPackage;
        }
        Bundle bundle2 = new Bundle(bundle);
        a.a(bundle2);
        intent.putExtras(bundle2);
        for (String str : bundle2.keySet()) {
            if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                intent.removeExtra(str);
            }
        }
        return PendingIntent.getActivity(this.b, a(), intent, 1073741824);
    }

    boolean c(Bundle bundle) {
        try {
            a(a(bundle, "gcm.n.tag"), d(bundle));
            return true;
        } catch (a e) {
            String str = "GcmNotification";
            String str2 = "Failed to show notification: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return false;
        }
    }
}
