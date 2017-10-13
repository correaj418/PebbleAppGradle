package com.getpebble.android.framework.h;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.text.TextUtils;
import com.b.b.x;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.LockerAppJson;
import com.getpebble.android.common.model.LockerAppJson.Application;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.am.c;
import com.getpebble.android.common.model.am.e;
import com.getpebble.android.common.model.aw;
import com.getpebble.android.framework.g.k;
import com.getpebble.android.h.p;
import com.google.b.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class a {
    public static void a(Context context) {
        PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.CLOUD_SYNC_IN_PROGRESS, true);
        PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.LAST_LOCKER_SYNC_ATTEMPT_MILLIS, System.currentTimeMillis());
        b(context);
        d(context);
        boolean c = c(context);
        if (!PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.COMPLETED_FIRST_LOCKER_CLOUD_SYNC, false)) {
            PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.COMPLETED_FIRST_LOCKER_CLOUD_SYNC, true);
        }
        if (c) {
            f.d("LockerWebSync", "syncLockerApps: fetchAppsFromWeb() reported changes; updating locker order and syncing to watch");
            am.a(context.getContentResolver(), e.APP);
            am.a(context.getContentResolver(), e.WATCHFACE);
            com.getpebble.android.framework.b.a.a(new k(com.getpebble.android.bluetooth.g.a.APP_REORDER, com.getpebble.android.framework.g.k.a.SEND_APP_ORDER));
        }
        PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.CLOUD_SYNC_IN_PROGRESS, false);
    }

    private static String a(String str, c cVar) {
        return str.replace("$$app_id$$", cVar.a).replace("$$app_uuid$$", cVar.b.toString());
    }

    private static void b(Context context) {
        f.d("LockerWebSync", "Adding apps to web");
        List<c> b = am.b(context.getContentResolver());
        ArrayList arrayList = new ArrayList();
        for (c cVar : b) {
            String a = a(PebbleApplication.w().M(), cVar);
            f.d("LockerWebSync", "add url = " + a);
            try {
                int b2 = com.getpebble.android.d.a.a(context, a, 30000).d().b();
                if (b2 != 200) {
                    f.a("LockerWebSync", "addAppsToWeb() Request failed: " + b2);
                } else {
                    arrayList.add(cVar.m());
                }
            } catch (Throwable e) {
                f.a("LockerWebSync", "addAppsToWeb", e);
            }
        }
        try {
            context.getContentResolver().applyBatch("com.getpebble.android.basalt.internal.provider", arrayList);
        } catch (Throwable e2) {
            f.a("LockerWebSync", "Failed to update locker apps.", e2);
        } catch (Throwable e22) {
            f.a("LockerWebSync", "Failed to update locker apps.", e22);
        }
        f.d("LockerWebSync", "Updating locker apps complete!");
    }

    private static boolean c(Context context) {
        boolean z = false;
        f.d("LockerWebSync", "fetchAppsFromWeb: Fetching apps from web");
        String L = PebbleApplication.w().L();
        Set hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        HashSet hashSet2 = new HashSet();
        String str = L;
        int i = 0;
        while (str != null) {
            int i2 = i + 1;
            if (i2 > 10) {
                f.c("LockerWebSync", "fetchAppsFromWeb: Max number of pages fetched; aborting locker sync!");
                break;
            }
            try {
                x c = com.getpebble.android.d.a.c(context, str, 30000);
                if (c == null) {
                    f.a("LockerWebSync", "fetchAppsFromWeb: jsonObjectResponse is null");
                    break;
                }
                int b = c.d().b();
                if (b != 200) {
                    f.a("LockerWebSync", "fetchAppsFromWeb: fetchAppsFromWeb() Request failed: " + b);
                    break;
                }
                try {
                    LockerAppJson lockerAppJson = (LockerAppJson) p.a((o) c.b(), LockerAppJson.class);
                    if (lockerAppJson == null) {
                        f.a("LockerWebSync", "fetchAppsFromWeb: synchronizeWebAndLocalApps: lockerApps is null");
                        break;
                    }
                    str = lockerAppJson.nextPageURL;
                    for (Application application : lockerAppJson.applications) {
                        if (!hashSet.contains(application.uuid)) {
                            hashSet.add(application.uuid);
                            ContentProviderOperation a = am.a(context.getContentResolver(), application);
                            if (a != null) {
                                arrayList.add(a);
                                hashSet2.add(application.uuid);
                            }
                        }
                    }
                    i = i2;
                } catch (Throwable e) {
                    f.a("LockerWebSync", "fetchAppsFromWeb: Error deserialising json", e);
                }
            } catch (Throwable e2) {
                f.a("LockerWebSync", "fetchAppsFromWeb: Error syncing locker apps from cloud", e2);
            }
        }
        for (c cVar : am.d(context.getContentResolver())) {
            if (!hashSet.contains(cVar.b.toString())) {
                arrayList.add(cVar.n());
            }
        }
        if (!arrayList.isEmpty()) {
            z = true;
        }
        try {
            context.getContentResolver().applyBatch("com.getpebble.android.basalt.internal.provider", arrayList);
            am.a(context.getContentResolver());
            if (z) {
                new com.getpebble.android.framework.install.a.a(context).f();
            }
        } catch (Throwable e22) {
            f.a("LockerWebSync", "fetchAppsFromWeb: Failed to insert locker apps.", e22);
        } catch (Throwable e222) {
            f.a("LockerWebSync", "fetchAppsFromWeb: Failed to insert locker apps.", e222);
        } catch (Throwable e2222) {
            f.a("LockerWebSync", "fetchAppsFromWeb: Error inserting [" + TextUtils.join(com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR, arrayList.toArray()) + "] ", e2222);
        }
        f.d("LockerWebSync", "Inserting locker apps complete!");
        f.d("LockerWebSync", "Updating timeline data for newly inserted and updated apps");
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            try {
                aw.a(context.getContentResolver(), UUID.fromString((String) it.next()));
            } catch (IllegalArgumentException e3) {
            }
        }
        return z;
    }

    private static void d(Context context) {
        f.d("LockerWebSync", "Deleting apps from web");
        List<c> c = am.c(context.getContentResolver());
        ArrayList arrayList = new ArrayList();
        for (c cVar : c) {
            try {
                int b = com.getpebble.android.d.a.b(context, a(PebbleApplication.w().N(), cVar), 30000).d().b();
                if (b != 204) {
                    f.a("LockerWebSync", "delAppsFromWeb() Request failed: " + b);
                } else {
                    f.d("LockerWebSync", cVar.b + " ( " + cVar.c + ") deleted from web; marking deleted in local locker");
                    arrayList.add(cVar.l());
                }
            } catch (Throwable e) {
                f.a("LockerWebSync", "delAppsFromWeb() Error deleting app from locker", e);
            }
        }
        try {
            context.getContentResolver().applyBatch("com.getpebble.android.basalt.internal.provider", arrayList);
            am.a(context.getContentResolver());
        } catch (Throwable e2) {
            f.a("LockerWebSync", "Failed to update locker apps.", e2);
        } catch (Throwable e22) {
            f.a("LockerWebSync", "Failed to update locker apps.", e22);
        }
        f.d("LockerWebSync", "Deleting locker apps complete!");
    }
}
