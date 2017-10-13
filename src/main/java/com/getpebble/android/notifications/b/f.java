package com.getpebble.android.notifications.b;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.support.v4.app.ac;
import android.support.v4.app.ac.t;
import android.support.v4.app.ar;
import android.text.SpannableString;
import android.text.TextUtils;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.common.b.b.e;
import com.getpebble.android.common.model.af;
import com.getpebble.android.common.model.af.b;
import com.getpebble.android.common.model.an;
import com.google.a.b.am;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class f {
    protected static final Set<String> a = am.a("android.title", "android.subText", "android.text", "groupKey", "android.bigText", "android.support.groupKey", "android.summaryText");
    private static final Set<String> b = am.a("android.progressIndeterminate", "android.originatingUserId", "android.infoText", "android.largeIcon", "android.people", "android.rebuild.applicationInfo", "android.showWhen", "android.progressMax", "android.progress", "android.icon", "android.showChronometer");
    private static final Pattern c = Pattern.compile("\\w+(\\.\\w+)+");

    private static class a extends com.getpebble.android.bluetooth.b.f {
        private final Intent a;

        public a(Intent intent) {
            this.a = intent;
        }

        public boolean doInBackground() {
            boolean z;
            synchronized (f.class) {
                String b;
                String str;
                PackageManager packageManager;
                Set a;
                PackageManager packageManager2;
                List<PackageInfo> installedPackages;
                Set<String> a2;
                PackageManager packageManager3;
                boolean z2;
                boolean z3;
                c cVar;
                com.getpebble.android.common.b.a.f.d("LoadAndroidAppsTask", "Loading Android apps... intent = " + this.a);
                if (this.a != null) {
                    b = f.b(this.a);
                    if (b != null) {
                        if (this.a.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
                            str = b;
                            packageManager = com.getpebble.android.common.a.K().getPackageManager();
                            if (packageManager != null) {
                                com.getpebble.android.common.b.a.f.b("LoadAndroidAppsTask", "PackageManager is null");
                                return false;
                            }
                            try {
                                a = b.a(packageManager);
                                packageManager2 = packageManager;
                            } catch (Throwable e) {
                                com.getpebble.android.common.b.a.f.b("LoadAndroidAppsTask", "error getting sms packages!", e);
                                if (!(e.getCause() instanceof DeadObjectException)) {
                                    return false;
                                }
                                packageManager = com.getpebble.android.common.a.K().getPackageManager();
                                if (packageManager == null) {
                                    com.getpebble.android.common.b.a.f.b("LoadAndroidAppsTask", "PackageManager is null (during DeadObjectException retry)");
                                    return false;
                                }
                                try {
                                    Object a3 = b.a(packageManager);
                                    packageManager2 = packageManager;
                                } catch (Throwable e2) {
                                    com.getpebble.android.common.b.a.f.a("LoadAndroidAppsTask", "error getting sms packages (during retry!)", e2);
                                    return false;
                                }
                            }
                            if (str == null) {
                                com.getpebble.android.common.b.a.f.d("LoadAndroidAppsTask", "Adding single package: " + str);
                                packageManager = packageManager2;
                                z = false;
                                boolean z4;
                                do {
                                    try {
                                        a(packageManager.getPackageInfo(str, 0), packageManager, a);
                                        a();
                                        return true;
                                    } catch (Throwable e3) {
                                        com.getpebble.android.common.b.a.f.b("LoadAndroidAppsTask", "Error adding single app", e3);
                                        z4 = false;
                                        continue;
                                    } catch (RuntimeException e4) {
                                        if (!(e4.getCause() instanceof DeadObjectException) || r0) {
                                            z4 = false;
                                            continue;
                                        } else {
                                            packageManager = com.getpebble.android.common.a.K().getPackageManager();
                                            if (packageManager == null) {
                                                com.getpebble.android.common.b.a.f.b("LoadAndroidAppsTask", "PackageManager is null (during DeadObjectException retry)");
                                                return false;
                                            }
                                            z = true;
                                            z4 = true;
                                            continue;
                                        }
                                    }
                                } while (z4);
                                installedPackages = packageManager.getInstalledPackages(0);
                                a2 = af.a(com.getpebble.android.common.a.K().getContentResolver());
                                for (PackageInfo packageInfo : installedPackages) {
                                    if (a2.contains(packageInfo.packageName)) {
                                        a2.remove(packageInfo.packageName);
                                    }
                                    packageManager3 = packageManager;
                                    z2 = false;
                                    do {
                                        try {
                                            a(packageInfo, packageManager3, a);
                                            z3 = false;
                                            continue;
                                        } catch (Throwable e5) {
                                            com.getpebble.android.common.b.a.f.b("LoadAndroidAppsTask", "Error adding single app", e5);
                                            z3 = false;
                                            continue;
                                        } catch (RuntimeException e6) {
                                            if (!(e6.getCause() instanceof DeadObjectException) || r2) {
                                                z3 = false;
                                                continue;
                                            } else {
                                                packageManager3 = com.getpebble.android.common.a.K().getPackageManager();
                                                if (packageManager3 == null) {
                                                    com.getpebble.android.common.b.a.f.b("LoadAndroidAppsTask", "PackageManager is null (during DeadObjectException retry)");
                                                    return false;
                                                }
                                                z2 = true;
                                                z3 = true;
                                                continue;
                                            }
                                        }
                                    } while (z3);
                                    packageManager = packageManager3;
                                }
                                for (String b2 : a2) {
                                    af.a(com.getpebble.android.common.a.K().getContentResolver(), b2);
                                }
                                cVar = new c(com.getpebble.android.common.a.K());
                                if (cVar.a(com.getpebble.android.common.b.b.c.a.DONE_NOTIFICATION_PREFS_TO_DB_MIGRATION, false)) {
                                    a(cVar, true);
                                } else if (!cVar.a(com.getpebble.android.common.b.b.c.a.DONE_NOTIFICATION_PREFS_TO_DB_MIGRATION_WITH_DELETION, false)) {
                                    a(cVar, false);
                                }
                                a();
                                return true;
                            }
                            packageManager = packageManager2;
                            installedPackages = packageManager.getInstalledPackages(0);
                            a2 = af.a(com.getpebble.android.common.a.K().getContentResolver());
                            for (PackageInfo packageInfo2 : installedPackages) {
                                if (a2.contains(packageInfo2.packageName)) {
                                    a2.remove(packageInfo2.packageName);
                                }
                                packageManager3 = packageManager;
                                z2 = false;
                                do {
                                    a(packageInfo2, packageManager3, a);
                                    z3 = false;
                                    continue;
                                } while (z3);
                                packageManager = packageManager3;
                            }
                            while (r1.hasNext()) {
                                af.a(com.getpebble.android.common.a.K().getContentResolver(), b2);
                            }
                            cVar = new c(com.getpebble.android.common.a.K());
                            if (cVar.a(com.getpebble.android.common.b.b.c.a.DONE_NOTIFICATION_PREFS_TO_DB_MIGRATION, false)) {
                                a(cVar, true);
                            } else if (cVar.a(com.getpebble.android.common.b.b.c.a.DONE_NOTIFICATION_PREFS_TO_DB_MIGRATION_WITH_DELETION, false)) {
                                a(cVar, false);
                            }
                            a();
                            return true;
                        } else if (this.a.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
                            if (this.a.getBooleanExtra("android.intent.extra.REPLACING", false)) {
                                return false;
                            }
                            com.getpebble.android.common.b.a.f.d("LoadAndroidAppsTask", "Deleting single package: " + b2);
                            af.a(com.getpebble.android.common.a.K().getContentResolver(), b2);
                            return true;
                        }
                    }
                }
                str = null;
                packageManager = com.getpebble.android.common.a.K().getPackageManager();
                if (packageManager != null) {
                    a = b.a(packageManager);
                    packageManager2 = packageManager;
                    if (str == null) {
                        packageManager = packageManager2;
                    } else {
                        com.getpebble.android.common.b.a.f.d("LoadAndroidAppsTask", "Adding single package: " + str);
                        packageManager = packageManager2;
                        z = false;
                        do {
                            a(packageManager.getPackageInfo(str, 0), packageManager, a);
                            a();
                            return true;
                        } while (z4);
                    }
                    installedPackages = packageManager.getInstalledPackages(0);
                    a2 = af.a(com.getpebble.android.common.a.K().getContentResolver());
                    for (PackageInfo packageInfo22 : installedPackages) {
                        if (a2.contains(packageInfo22.packageName)) {
                            a2.remove(packageInfo22.packageName);
                        }
                        packageManager3 = packageManager;
                        z2 = false;
                        do {
                            a(packageInfo22, packageManager3, a);
                            z3 = false;
                            continue;
                        } while (z3);
                        packageManager = packageManager3;
                    }
                    while (r1.hasNext()) {
                        af.a(com.getpebble.android.common.a.K().getContentResolver(), b2);
                    }
                    cVar = new c(com.getpebble.android.common.a.K());
                    if (cVar.a(com.getpebble.android.common.b.b.c.a.DONE_NOTIFICATION_PREFS_TO_DB_MIGRATION, false)) {
                        a(cVar, true);
                    } else if (cVar.a(com.getpebble.android.common.b.b.c.a.DONE_NOTIFICATION_PREFS_TO_DB_MIGRATION_WITH_DELETION, false)) {
                        a(cVar, false);
                    }
                    a();
                    return true;
                }
                com.getpebble.android.common.b.a.f.b("LoadAndroidAppsTask", "PackageManager is null");
                return false;
            }
        }

        private void a() {
            b.a(com.getpebble.android.common.a.K());
            b.b(com.getpebble.android.common.a.K());
        }

        private void a(PackageInfo packageInfo, PackageManager packageManager, Set<String> set) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null) {
                com.getpebble.android.common.b.a.f.d("LoadAndroidAppsTask", "appInfo is null for " + packageInfo.packageName);
                return;
            }
            if (packageManager.getLaunchIntentForPackage(applicationInfo.packageName) != null) {
                CharSequence loadLabel = applicationInfo.loadLabel(packageManager);
                String str = null;
                if (loadLabel != null) {
                    str = loadLabel.toString();
                }
                boolean a = b.a(packageInfo.packageName);
                af.a(com.getpebble.android.common.a.K().getContentResolver(), new b(packageInfo.packageName, str, packageInfo.versionName, a, b.a(packageInfo.packageName, com.getpebble.android.common.a.K()), 0, 0, false, com.getpebble.android.common.model.af.a.NEVER, set.contains(packageInfo.packageName)));
            }
        }

        private void a(c cVar, boolean z) {
            com.getpebble.android.common.b.a.f.d("LoadAndroidAppsTask", "Doing migration of notifications preferences to database... doDatabaseUpdate = " + z);
            Map all = cVar.a().getAll();
            Editor edit = cVar.a().edit();
            for (String str : all.keySet()) {
                if (f.c.matcher(str).matches()) {
                    Object obj = all.get(str);
                    if (obj instanceof Boolean) {
                        boolean booleanValue = ((Boolean) obj).booleanValue();
                        com.getpebble.android.common.b.a.f.d("LoadAndroidAppsTask", "package '" + str + "' .. chosen = " + booleanValue);
                        if (z) {
                            af.a(str, booleanValue, com.getpebble.android.common.a.K().getContentResolver());
                        }
                        edit.remove(str);
                    } else {
                        com.getpebble.android.common.b.a.f.b("LoadAndroidAppsTask", "key '" + str + "'.. not a boolean?");
                    }
                }
            }
            edit.apply();
            cVar.b(com.getpebble.android.common.b.b.c.a.DONE_NOTIFICATION_PREFS_TO_DB_MIGRATION, true);
            cVar.b(com.getpebble.android.common.b.b.c.a.DONE_NOTIFICATION_PREFS_TO_DB_MIGRATION_WITH_DELETION, true);
        }

        public void onTaskSuccess() {
        }

        public void onTaskFailed() {
        }
    }

    public static boolean a(Context context) {
        return e.b(context);
    }

    public static void b(Context context) {
        e.a(context);
    }

    public static void c(Context context) {
        e.c(context);
    }

    public static boolean a(com.getpebble.android.notifications.a.b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.g())) {
            return false;
        }
        Object obj = ac.a(bVar.n()).get("android.text");
        if (!(obj instanceof SpannableString)) {
            return false;
        }
        String obj2 = obj.toString();
        if (TextUtils.isEmpty(obj2)) {
            return false;
        }
        return a(obj2);
    }

    static boolean a(String str) {
        return Pattern.compile("\\p{L}+:\\s.+\\d{4}.+\\(\\S.+\\)$", 2).matcher(str).matches();
    }

    public static void a(com.getpebble.android.notifications.a.b bVar, boolean z) {
        int i = 0;
        if (!bVar.o()) {
            if ((e.a(0, 100) < 30 ? 1 : 0) != 0) {
                Map hashMap = new HashMap();
                hashMap.put("isClearable", bVar.w() ? "1" : "0");
                hashMap.put(an.SOURCE, bVar.e().toString());
                hashMap.put("isDuplicate", bVar.p() ? "1" : "0");
                hashMap.put("sentToWatch", z ? "1" : "0");
                Notification n = bVar.n();
                if (n != null) {
                    int b = ac.b(n);
                    if (b >= 1) {
                        int i2;
                        int size;
                        t tVar = new t(n);
                        hashMap.put("actionCount", String.valueOf(b));
                        List arrayList = new ArrayList();
                        for (i2 = 0; i2 < b; i2++) {
                            arrayList.add(a(ac.a(n, i2)));
                        }
                        hashMap.put("actions", arrayList);
                        hashMap.put("hasContentIntent", n.contentIntent != null ? "1" : "0");
                        hashMap.put("isGroupSummary", ac.d(n) ? "1" : "0");
                        hashMap.put("contentAction", String.valueOf(tVar.d()));
                        List c = tVar.c();
                        if (c != null) {
                            i2 = c.size();
                        } else {
                            i2 = 0;
                        }
                        hashMap.put("pagesCount", String.valueOf(i2));
                        arrayList = tVar.b();
                        if (arrayList != null) {
                            size = arrayList.size();
                        } else {
                            size = 0;
                        }
                        hashMap.put("wearActionCount", String.valueOf(size));
                        List arrayList2 = new ArrayList();
                        for (b = 0; b < size; b++) {
                            arrayList2.add(a((android.support.v4.app.ac.a) arrayList.get(b)));
                        }
                        hashMap.put("wearActions", arrayList2);
                        Bundle a = ac.a(n);
                        if (a != null) {
                            i = a.containsKey("android.selfDisplayName");
                        }
                        hashMap.put("hasMessagingStyle", i != 0 ? "1" : "0");
                        b v = bVar.v();
                        Object obj = "";
                        Object obj2 = "";
                        Object obj3 = null;
                        Object obj4 = "";
                        if (v != null) {
                            obj = v.b;
                            obj2 = v.c;
                            obj3 = Boolean.valueOf(v.d);
                            obj4 = v.i.name();
                        }
                        hashMap.put("package_name", bVar.g());
                        hashMap.put("app_name", obj);
                        hashMap.put("app_version", obj2);
                        hashMap.put("notifications_enabled", obj3);
                        hashMap.put("notifications_muted", obj4);
                        com.getpebble.android.common.b.a.a.c.a(hashMap);
                    }
                }
            }
        }
    }

    private static Map<String, String> a(android.support.v4.app.ac.a aVar) {
        int length;
        Map<String, String> hashMap = new HashMap();
        hashMap.put("Title", aVar.b.toString());
        ar[] f = aVar.f();
        if (f != null) {
            length = f.length;
        } else {
            length = 0;
        }
        hashMap.put("RemoteInputCount", String.valueOf(length));
        if (f != null) {
            for (int i = 0; i < length; i++) {
                int length2;
                int i2;
                hashMap.put("RemoteInputAllowsFreeform", f[i].d() ? "1" : "0");
                CharSequence b = f[i].b();
                hashMap.put("RemoteInputLabel", b != null ? b.toString() : "<null>");
                CharSequence[] c = f[i].c();
                if (c != null) {
                    length2 = c.length;
                    i2 = 0;
                    for (CharSequence charSequence : c) {
                        if (charSequence.length() > i2) {
                            i2 = charSequence.length();
                        }
                    }
                } else {
                    i2 = 0;
                    length2 = 0;
                }
                hashMap.put("RemoteInputChoicesCount", String.valueOf(length2));
                hashMap.put("RemoteInputChoicesMaxLen", String.valueOf(i2));
            }
        }
        return hashMap;
    }

    public static String a(List<Notification> list) {
        if (list == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(i);
            stringBuilder.append(": ");
            stringBuilder.append(((Notification) list.get(i)).tickerText);
            stringBuilder.append("|");
        }
        return stringBuilder.toString();
    }

    public static String a(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : bundle.keySet()) {
            if (!b.contains(str)) {
                Object obj = bundle.get(str);
                String str2 = "";
                if (obj != null) {
                    obj.getClass().getSimpleName();
                }
                if (a.contains(str)) {
                    obj = obj == null ? "<null>" : com.getpebble.android.common.b.b.a.a(obj);
                }
                stringBuilder.append("(");
                stringBuilder.append(str);
                stringBuilder.append("|");
                stringBuilder.append(obj);
                stringBuilder.append(")");
            }
        }
        return stringBuilder.toString();
    }

    public static String a(Notification notification) {
        StringBuilder stringBuilder = new StringBuilder();
        int b = ac.b(notification);
        for (int i = 0; i < b; i++) {
            stringBuilder.append(b(ac.a(notification, i)));
        }
        return stringBuilder.toString();
    }

    private static String b(android.support.v4.app.ac.a aVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("title: ").append(aVar.b);
        stringBuilder.append("Actions: ").append(aVar.d());
        ar[] f = aVar.f();
        if (f != null) {
            int length = f.length;
            stringBuilder.append("RemoteInput: ");
            for (int i = 0; i < length; i++) {
                stringBuilder.append("Label: ").append(f[i].b());
                stringBuilder.append("SupportsFreeformInput?: ").append(f[i].d());
                CharSequence[] c = f[i].c();
                if (c != null) {
                    stringBuilder.append("Choices: ");
                    for (CharSequence append : c) {
                        stringBuilder.append(append).append(com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
                    }
                }
                stringBuilder.append(a(f[i].e()));
            }
        }
        return stringBuilder.toString();
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            if (a.contains(str)) {
                try {
                    jSONObject2.put(str, com.getpebble.android.common.b.b.a.a(jSONObject.get(str)));
                } catch (JSONException e) {
                    com.getpebble.android.common.b.a.f.d("NotificationUtil", "Failed to obfuscate: " + str);
                }
            }
        }
        return jSONObject2;
    }

    public static com.getpebble.android.common.model.an.a a(com.getpebble.android.common.model.an.a aVar) {
        String a = com.getpebble.android.common.b.b.a.a(aVar.text);
        String a2 = com.getpebble.android.common.b.b.a.a(aVar.title);
        String a3 = com.getpebble.android.common.b.b.a.a(aVar.body);
        return new com.getpebble.android.common.model.an.a(aVar.notificationUuid, aVar.androidPackageName, aVar.androidNotificationId, aVar.androidNotificationTag, aVar.androidNotificationKey, a, aVar.groupKey, aVar.isSummary, aVar.timestampMillis, aVar.removedTimestampMillis, aVar.source, aVar.isOngoing, aVar.postTimeLocal, aVar.isClearable, aVar.color, aVar.wearInstalled, aVar.category, aVar.number, aVar.when, aVar.hasContentIntent, aVar.contentAction, aVar.pagesCount, aVar.pagesDump, a(aVar.extrasDump), aVar.actionsDump, aVar.wearableActionsDump, aVar.sentToWatch, aVar.dismissedFromWatch, aVar.isDup, a2, a3);
    }

    @SuppressLint({"NewApi"})
    public static void b(com.getpebble.android.notifications.a.b bVar) {
        boolean z = true;
        com.getpebble.android.framework.timeline.b.a aVar = null;
        int i = 0;
        try {
            Object obj;
            Notification n = bVar.n();
            com.getpebble.android.common.b.a.f.d("NotificationUtil", "dumpNotification() source = " + bVar.e());
            String str = "NotificationUtil";
            StringBuilder append = new StringBuilder().append("package: ").append(bVar.g()).append(" tag: ").append(bVar.l()).append(" key: ").append(bVar.m()).append(" deleteIntent = ");
            if (n == null) {
                obj = "false";
            } else {
                obj = Boolean.valueOf(n.deleteIntent != null);
            }
            com.getpebble.android.common.b.a.f.d(str, append.append(obj).toString());
            com.getpebble.android.common.b.a.f.d("NotificationUtil", "isOngoing: " + bVar.o() + " id: " + bVar.k() + " postTimeLocal: " + bVar.d() + " isClearable: " + bVar.w());
            com.getpebble.android.common.b.a.f.d("NotificationUtil", "isGroupSummary: " + bVar.r() + " groupKey: " + com.getpebble.android.common.b.b.a.a(bVar.q()) + " color = " + (bVar.s() == null ? "<none>" : bVar.s().b) + " wearInstalled: " + b());
            if (!bVar.o() && n != null) {
                String toUpperCase;
                int i2;
                int size;
                int i3;
                t tVar = new t(n);
                if (VERSION.SDK_INT >= 21) {
                    str = n.category;
                    toUpperCase = Integer.toHexString(n.color).toUpperCase(Locale.US);
                    aVar = com.getpebble.android.framework.timeline.b.a().a(n.color);
                } else {
                    toUpperCase = null;
                    str = null;
                }
                com.getpebble.android.common.b.a.f.d("NotificationUtil", "alertType: " + str + " number: " + n.number + " when: " + n.when + " color = " + toUpperCase + " nearest = " + (aVar == null ? "<none>" : aVar.b));
                if (n.contentIntent == null) {
                    z = false;
                }
                com.getpebble.android.common.b.a.f.d("NotificationUtil", "hasContentIntent: " + z + " tickerText: " + com.getpebble.android.common.b.b.a.a(n.tickerText) + " contentAction: " + tVar.d());
                Bundle a = ac.a(n);
                if (a == null) {
                    com.getpebble.android.common.b.a.f.d("NotificationUtil", "> No notification extras\n");
                } else {
                    a(a, "Notification");
                    try {
                        CharSequence[] charSequenceArray = a.getCharSequenceArray("android.textLines");
                        if (charSequenceArray != null) {
                            for (i2 = 0; i2 < charSequenceArray.length; i2++) {
                                com.getpebble.android.common.b.a.f.d("NotificationUtil", ">> TextLine " + i2 + ": '" + com.getpebble.android.common.b.b.a.a(charSequenceArray[i2]) + "'");
                            }
                        }
                    } catch (Exception e) {
                        com.getpebble.android.common.b.a.f.d("NotificationUtil", "Error getting text lines");
                    }
                    try {
                        CharSequence[] charSequenceArray2 = a.getCharSequenceArray("android.people");
                        if (charSequenceArray2 != null) {
                            for (i2 = 0; i2 < charSequenceArray2.length; i2++) {
                                com.getpebble.android.common.b.a.f.d("NotificationUtil", ">> People " + i2 + ": '" + charSequenceArray2[i2] + "'");
                            }
                        }
                    } catch (Exception e2) {
                        com.getpebble.android.common.b.a.f.d("NotificationUtil", "Error getting people");
                    }
                }
                List c = tVar.c();
                if (c != null) {
                    size = c.size();
                } else {
                    size = 0;
                }
                com.getpebble.android.common.b.a.f.d("NotificationUtil", "pages count = " + size);
                for (i3 = 0; i3 < size; i3++) {
                    com.getpebble.android.common.b.a.f.d("NotificationUtil", "> page " + i3 + ": " + ((Notification) c.get(i3)).tickerText);
                }
                i3 = ac.b(n);
                com.getpebble.android.common.b.a.f.d("NotificationUtil", "action count: " + i3);
                for (i2 = 0; i2 < i3; i2++) {
                    a(ac.a(n, i2), i2);
                }
                List<android.support.v4.app.ac.a> b = tVar.b();
                com.getpebble.android.common.b.a.f.d("NotificationUtil", "WearableExtender action count: " + b.size());
                for (android.support.v4.app.ac.a a2 : b) {
                    i3 = i + 1;
                    a(a2, i);
                    i = i3;
                }
            }
        } catch (Throwable e3) {
            com.getpebble.android.common.b.a.f.d("NotificationUtil", "Error dumping sbn", e3);
        }
    }

    private static void a(android.support.v4.app.ac.a aVar, int i) {
        com.getpebble.android.common.b.a.f.d("NotificationUtil", "> Action " + i + ": " + aVar.b);
        a(aVar.d(), "Action");
        ar[] f = aVar.f();
        if (f == null) {
            com.getpebble.android.common.b.a.f.d("NotificationUtil", ">> Remote inputs are null");
            return;
        }
        int length = f.length;
        for (int i2 = 0; i2 < length; i2++) {
            com.getpebble.android.common.b.a.f.d("NotificationUtil", ">> Remote input " + i2 + ": " + f[i2].b() + " Supports freeform input: " + f[i2].d());
            StringBuilder stringBuilder = new StringBuilder(">> Choices: ");
            CharSequence[] c = f[i2].c();
            if (c == null) {
                stringBuilder.append("<none>");
            } else {
                for (CharSequence append : c) {
                    stringBuilder.append(append).append(com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
                }
            }
            com.getpebble.android.common.b.a.f.d("NotificationUtil", stringBuilder.toString());
            a(f[i2].e(), "RemoteInput");
        }
    }

    private static void a(Bundle bundle, String str) {
        if (bundle == null) {
            com.getpebble.android.common.b.a.f.d("NotificationUtil", "null extras");
            return;
        }
        for (String str2 : bundle.keySet()) {
            String simpleName;
            Object obj = bundle.get(str2);
            String str3 = "";
            if (obj != null) {
                simpleName = obj.getClass().getSimpleName();
            } else {
                simpleName = str3;
            }
            Object a = a.contains(str2) ? obj == null ? "<null>" : com.getpebble.android.common.b.b.a.a(obj) : obj;
            if (a instanceof Bundle) {
                a((Bundle) a, str2);
            } else {
                com.getpebble.android.common.b.a.f.d("NotificationUtil", ">> " + str + ">> Extra: key = " + str2 + " type = " + simpleName + " value = " + a);
            }
        }
    }

    public static void a() {
        a(null);
    }

    public static void a(Intent intent) {
        new a(intent).submit();
    }

    public static String b(Intent intent) {
        if (intent == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (dataString.startsWith("package:")) {
            return dataString.substring("package:".length());
        }
        return null;
    }

    public static String b(List<android.support.v4.app.ac.a> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (android.support.v4.app.ac.a b : list) {
            stringBuilder.append(b(b));
        }
        return stringBuilder.toString();
    }

    public static boolean b() {
        return af.a("com.google.android.wearable.app", com.getpebble.android.common.a.K().getContentResolver()) != null;
    }

    public static boolean b(String str) {
        if ("com.google.android.talk".equals(str) || "com.google.android.apps.inbox".equals(str) || "com.google.android.gm".equals(str)) {
            return true;
        }
        return false;
    }

    public static String b(Notification notification) {
        if (VERSION.SDK_INT >= 21) {
            return notification.category;
        }
        return "";
    }
}
