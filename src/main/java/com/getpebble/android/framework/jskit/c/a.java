package com.getpebble.android.framework.jskit.c;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.install.app.b;
import com.getpebble.android.common.model.am;
import com.getpebble.android.framework.jskit.c;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class a {
    private SharedPreferences a;

    public a(SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
    }

    private void a(Set<String> set) {
        this.a.edit().putStringSet("js_app_redownload_list", set).apply();
    }

    public void a(UUID uuid) {
        Set a = a();
        if (a.contains(uuid.toString())) {
            f.b("AppRefetcher", "addAppToRefetchList: " + uuid + " already exists in the redownload queue");
            return;
        }
        a.add(uuid.toString());
        a(a);
        f.d("AppRefetcher", "addAppToRefetchList: added " + uuid);
    }

    void b(UUID uuid) {
        Set a = a();
        if (a.remove(uuid.toString())) {
            a(a);
        }
    }

    Set<String> a() {
        return new HashSet(this.a.getStringSet("js_app_redownload_list", new HashSet()));
    }

    public void b() {
        this.a.edit().remove("js_app_redownload_list").apply();
    }

    void a(b bVar, c cVar) {
        cVar.c(bVar);
    }

    com.getpebble.android.framework.install.a.a.a a(String str, ContentResolver contentResolver) {
        am.c a = am.a(UUID.fromString(str), contentResolver, true);
        if (a != null) {
            return new com.getpebble.android.framework.install.a.a.a(a.b, a.l);
        }
        f.a("AppRefetcher", "getVersionForApp: could not get app from PebbleLockerAppDataModel");
        return null;
    }

    File a(com.getpebble.android.framework.install.a.a.a aVar, com.getpebble.android.framework.install.a.a aVar2) {
        return aVar2.a(aVar);
    }

    b a(File file, com.getpebble.android.framework.install.a.a aVar) {
        return aVar.c(file);
    }

    boolean a(com.getpebble.android.framework.install.a.a aVar) {
        return aVar.e();
    }

    void c() {
        PebbleApplication.v().b();
    }

    void a(Set<String> set, c cVar, com.getpebble.android.framework.install.a.a aVar, ContentResolver contentResolver) {
        f.d("AppRefetcher", "fetchApps:");
        if (set.isEmpty()) {
            f.d("AppRefetcher", "fetchApps: refetchList is empty");
            return;
        }
        Object obj = null;
        for (String a : set) {
            com.getpebble.android.framework.install.a.a.a a2 = a(a, contentResolver);
            if (a2 != null) {
                File a3 = a(a2, aVar);
                if (a3.exists()) {
                    Object obj2;
                    b a4 = a(a3, aVar);
                    if (a4 == null) {
                        f.b("AppRefetcher", "fetchApps: bundle was null, but should have been cached");
                        obj2 = 1;
                    } else {
                        a(a4, cVar);
                        a4.e();
                        obj2 = obj;
                    }
                    obj = obj2;
                } else {
                    f.d("AppRefetcher", "fetchApps: cached pbw does not exist");
                    obj = 1;
                }
            }
        }
        if (obj != null) {
            f.d("AppRefetcher", "fetchApps: must use network to fetch");
            if (!a(aVar)) {
                f.d("AppRefetcher", "fetchApps: could not fetch directly from network, making sync request");
                c();
            }
        }
    }

    public void d() {
        Context K = com.getpebble.android.common.a.K();
        a(a(), c.a(K), new com.getpebble.android.framework.install.a.a(K), K.getContentResolver());
    }
}
