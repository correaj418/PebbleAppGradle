package com.getpebble.android.framework.health.c;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.b.b.h;
import com.b.b.j;
import com.b.b.x;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.q.b;
import com.getpebble.android.common.model.z;
import com.getpebble.android.framework.firmware.FirmwareManifestBundle;
import com.getpebble.android.framework.firmware.FirmwareManifestBundle.FirmwareMetadata;
import com.getpebble.android.framework.timeline.e;
import com.getpebble.android.h.p;
import com.google.b.o;
import com.google.b.q;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class a {
    private final Context a;
    private final z b;

    public static class a {
        public static String a(com.getpebble.android.common.model.q.a aVar, z zVar) {
            return a(aVar.key, zVar);
        }

        public static String a(Iterable<com.getpebble.android.common.model.q.a> iterable, z zVar) {
            Iterable linkedList = new LinkedList();
            for (com.getpebble.android.common.model.q.a aVar : iterable) {
                linkedList.add(aVar.key);
            }
            return a(TextUtils.join(",", linkedList), zVar);
        }

        public static String a(z zVar) {
            return a(com.getpebble.android.common.model.q.a.selections(), zVar);
        }

        public static String a(String str, z zVar) {
            return new Builder().encodedPath(PebbleApplication.w().J()).appendQueryParameter("hardware", zVar.getName()).appendQueryParameter("mobilePlatform", "android").appendQueryParameter("mobileVersion", VERSION.RELEASE).appendQueryParameter("mobileHardware", Build.MANUFACTURER + " " + Build.MODEL).appendQueryParameter("pebbleAppVersion", PebbleApplication.z().a).appendQueryParameter("select", str).build().toString();
        }
    }

    public a(Context context, z zVar) {
        this.a = context;
        this.b = zVar;
        Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
    }

    public x<o> a() {
        f.d("CohortsFetcher", "fetchAll()");
        x<o> a = a(a.a(this.b));
        if (a == null) {
            return null;
        }
        h d = a.d();
        if (d == null) {
            return null;
        }
        int b = d.b();
        String c = d.c();
        if (b == 200) {
            return a;
        }
        f.a("CohortsFetcher", "fetchAll: Request failed with response code = " + b + " message: " + c);
        return null;
    }

    public b b() {
        try {
            o oVar = (o) a(a.a(com.getpebble.android.common.model.q.a.HEALTH_INSIGHTS, this.b)).b();
            if (oVar == null) {
                f.a("CohortsFetcher", "fetch: Response json result was null");
                return null;
            }
            String str = com.getpebble.android.common.model.q.a.HEALTH_INSIGHTS.key;
            if (oVar.a(str)) {
                try {
                    return (b) p.a(oVar.d(str), b.class);
                } catch (Throwable e) {
                    f.a("CohortsFetcher", "fetch: Failed to marshall json", e);
                    return null;
                }
            }
            f.a("CohortsFetcher", "fetch: Result does not contain " + str + ". Result = " + oVar.toString());
            return null;
        } catch (Throwable e2) {
            f.a("CohortsFetcher", "fetch: Failed to retrieve json result", e2);
            return null;
        }
    }

    private o d() {
        String a = a.a(com.getpebble.android.common.model.q.a.FIRMWARE, this.b);
        x a2 = a(a);
        if (a2 == null) {
            return null;
        }
        int b = a2.d().b();
        if (b != 200) {
            f.a("CohortsFetcher", "fetch: Request failed: " + b + e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + a2.d().c() + " for:" + a);
            return null;
        }
        o oVar = (o) a2.b();
        if (oVar != null) {
            return oVar;
        }
        f.a("CohortsFetcher", "fetch: Found null jsonObject for result for " + this.b);
        return null;
    }

    private o e() {
        String str = "fw/latest_" + this.b.getName() + ".json";
        try {
            String a = com.getpebble.android.common.framework.b.f.a(this.a, str, false);
            f.d("CohortsFetcher", "loadBundleJsonFromAssets: file = " + str + " content = '" + a + "'");
            return new q().a(a).l();
        } catch (IOException e) {
            f.c("CohortsFetcher", "loadBundleJsonFromAssets: no bundled manifest found for " + this.b.getName());
            return null;
        } catch (IllegalStateException e2) {
            f.c("CohortsFetcher", "loadBundleJsonFromAssets: no bundled manifest found for " + this.b.getName());
            return null;
        }
    }

    public FirmwareManifestBundle c() {
        o d = d();
        if (d == null) {
            d = e();
            if (d == null) {
                f.b("CohortsFetcher", "fetchFirmwareBundle: could not download or find bundled manifest for " + this.b.getName());
                return null;
            }
            f.c("CohortsFetcher", "fetchFirmwareBundle: using bundled manifest for " + this.b.getName());
        }
        FirmwareManifestBundle firmwareManifestBundle = new FirmwareManifestBundle(this.b);
        com.google.b.f fVar = new com.google.b.f();
        f.e("CohortsFetcher", "fetch: jsonObject: " + d);
        try {
            FirmwareMetadata firmwareMetadata;
            FirmwareMetadata firmwareMetadata2;
            o d2 = d.a("fw") ? d.d("fw") : d;
            if (d2.a("recovery")) {
                firmwareMetadata = (FirmwareMetadata) fVar.a(d2.b("recovery"), FirmwareMetadata.class);
            } else {
                firmwareMetadata = null;
            }
            FirmwareMetadata firmwareMetadata3 = (FirmwareMetadata) fVar.a(d2.b("normal"), FirmwareMetadata.class);
            if (d2.a("3.x-migration")) {
                firmwareMetadata2 = (FirmwareMetadata) fVar.a(d2.b("3.x-migration"), FirmwareMetadata.class);
            } else {
                firmwareMetadata2 = null;
            }
            firmwareManifestBundle.setRecoveryMetadata(firmwareMetadata);
            firmwareManifestBundle.setNormalMetadata(firmwareMetadata3);
            firmwareManifestBundle.set3xMigrationMetadata(firmwareMetadata2);
            f.e("CohortsFetcher", "fetch: recoveryMetadata = " + firmwareMetadata + ", normalMetadata = " + firmwareMetadata3 + ", migrationMetadata = " + firmwareMetadata2);
            return firmwareManifestBundle;
        } catch (Throwable e) {
            f.a("CohortsFetcher", "fetch: Failed to parse metadata.", e);
            return null;
        } catch (Throwable e2) {
            f.a("CohortsFetcher", "fetch: Failed to parse metadata.", e2);
            return null;
        }
    }

    x<o> a(String str) {
        Throwable e;
        f.c("CohortsFetcher", "fetch: Requesting " + str);
        try {
            return (x) ((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) j.a(this.a).d(str)).d("Authorization", "Bearer " + PebbleApplication.u().b())).a().n().get(30, TimeUnit.SECONDS);
        } catch (ExecutionException e2) {
            e = e2;
        } catch (InterruptedException e3) {
            e = e3;
        } catch (TimeoutException e4) {
            e = e4;
        }
        f.a("CohortsFetcher", "fetch: Failed", e);
        return null;
    }

    public b b(String str) {
        return (b) p.a(str, new b().getClass());
    }
}
