package com.getpebble.android.core.sync;

import android.content.Context;
import android.text.TextUtils;
import com.b.b.h;
import com.b.b.x;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.model.a.n;
import com.getpebble.android.common.model.ap;
import com.getpebble.android.common.model.v;
import com.getpebble.android.common.model.z;
import com.getpebble.android.h.ac;
import com.getpebble.android.h.k;
import com.getpebble.android.h.l;
import com.getpebble.android.h.p;
import com.google.a.b.ad;
import com.google.a.b.as;
import com.google.b.i;
import com.google.b.o;
import com.google.b.q;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class b {
    public static final long a = TimeUnit.HOURS.toSeconds(12);
    public static final long b = TimeUnit.HOURS.toSeconds(1);
    private final Context c;
    private final n d;
    private final com.getpebble.android.common.b.b.c e = h();
    private ap f;
    private List<com.getpebble.android.framework.health.d.e> g;
    private List<com.getpebble.android.common.model.a.o.c> h;

    static abstract class b<T> {
        final List<String> a;
        final List<T> b;

        abstract i a(T t);

        public b(List<String> list, List<T> list2) {
            this.a = list;
            this.b = list2;
        }

        i[] a() {
            i[] iVarArr = new i[(this.b.size() + 1)];
            iVarArr[0] = new i();
            for (String a : this.a) {
                iVarArr[0].a(a);
            }
            if (iVarArr.length == 1) {
                return iVarArr;
            }
            for (int i = 1; i < iVarArr.length; i++) {
                iVarArr[i] = a(this.b.get(i - 1));
            }
            if (this.a.size() == iVarArr[1].a()) {
                return iVarArr;
            }
            throw new IllegalArgumentException("Expected " + this.a.size() + " fields, got " + this.b.size());
        }
    }

    static class a extends b<com.getpebble.android.framework.health.d.e> {
        private static final List<String> c = ad.a("type", "utcOffset", "date", "elapsedSeconds", "steps", "activeKCalories", "restingKCalories", "distanceMeters");

        public a(List<com.getpebble.android.framework.health.d.e> list) {
            super(c, list);
        }

        i a(com.getpebble.android.framework.health.d.e eVar) {
            i iVar = new i();
            iVar.a(eVar.b.jsName);
            iVar.a(Integer.valueOf(eVar.e));
            iVar.a(Long.valueOf(eVar.c));
            iVar.a(Long.valueOf(eVar.b()));
            if (eVar.b.isSleep()) {
                iVar.a(com.google.b.n.a);
                iVar.a(com.google.b.n.a);
                iVar.a(com.google.b.n.a);
                iVar.a(com.google.b.n.a);
            } else {
                iVar.a(Integer.valueOf(eVar.h));
                iVar.a(Integer.valueOf((int) l.GRAM_CALORIES.toKiloCalories(eVar.j)));
                iVar.a(Integer.valueOf((int) l.GRAM_CALORIES.toKiloCalories(eVar.k)));
                iVar.a(Long.valueOf(k.MILLIMETRES.toMetres(eVar.i)));
            }
            return iVar;
        }
    }

    private static class c {
        @com.google.b.a.c(a = "watch")
        final g a;
        @com.google.b.a.c(a = "phone")
        final f b;
        @com.google.b.a.c(a = "steps")
        final i[] c;
        @com.google.b.a.c(a = "activity")
        final i[] d;

        public c(g gVar, f fVar, i[] iVarArr, i[] iVarArr2) {
            this.a = gVar;
            this.b = fVar;
            this.c = iVarArr;
            this.d = iVarArr2;
        }
    }

    private static class d {
        @com.google.b.a.c(a = "age")
        private final int a;
        @com.google.b.a.c(a = "height")
        private final int b;
        @com.google.b.a.c(a = "weight")
        private final int c;
        @com.google.b.a.c(a = "gender")
        private final String d;

        public d(int i, int i2, int i3, String str) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = str;
        }

        static d a(ap apVar) {
            return new d(apVar.ageYears, ac.c(apVar.heightMm), ac.d(apVar.weightDag), apVar.gender == null ? null : apVar.gender.jsName);
        }

        public o a() {
            return new q().a(new com.google.b.g().a().c().b((Object) this)).l();
        }
    }

    private static class e extends b<com.getpebble.android.common.model.a.o.c> {
        private static final List<String> c = ad.a("date", "utcOffset", "steps", "orientation", "vmc", "light", "restingCalories", "activeCalories", "distance", "active", "pluggedIn", "hrZone", new String[0]);

        public e(List<com.getpebble.android.common.model.a.o.c> list) {
            super(c, list);
        }

        i a(com.getpebble.android.common.model.a.o.c cVar) {
            i iVar = new i();
            com.getpebble.android.common.model.a.o.e a = cVar.a();
            iVar.a(Integer.valueOf(a.d()));
            iVar.a(Integer.valueOf(a.e()));
            iVar.a(Integer.valueOf(a.c()));
            iVar.a(Integer.valueOf(a.f()));
            iVar.a(Integer.valueOf(a.g()));
            iVar.a(Integer.valueOf(a.h()));
            iVar.a(Integer.valueOf(a.k()));
            iVar.a(Integer.valueOf(a.l()));
            iVar.a(Long.valueOf(k.MILLIMETRES.toCentimetres((long) a.j())));
            iVar.a(Integer.valueOf(a.q()));
            iVar.a(Boolean.valueOf(a.i()));
            iVar.a(a.o());
            return iVar;
        }
    }

    private static class f {
        @com.google.b.a.c(a = "platform")
        final String a = "android";
        @com.google.b.a.c(a = "appVersion")
        final String b;
        @com.google.b.a.c(a = "locale")
        final String c;

        public f(String str, String str2) {
            this.b = str;
            this.c = str2;
        }
    }

    private static class g {
        @com.google.b.a.c(a = "hwVersion")
        final String a;
        @com.google.b.a.c(a = "serialNumber")
        final String b;
        @com.google.b.a.c(a = "firmwareVersion")
        final String c;
        @com.google.b.a.c(a = "locale")
        final String d;

        public g(String str, String str2, String str3, String str4) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }
    }

    public b(Context context, n nVar) {
        this.c = context;
        this.d = nVar;
    }

    public b a() {
        if (!i()) {
            com.getpebble.android.common.b.a.f.d("HealthUploader", "uploadSettings: analytics not enabled; not uploading");
        } else if (c()) {
            e();
        } else {
            com.getpebble.android.common.b.a.f.e("HealthUploader", "uploadSettings: not required");
        }
        return this;
    }

    public b b() {
        if (!d()) {
            com.getpebble.android.common.b.a.f.e("HealthUploader", "uploadData: not required");
        } else if (i()) {
            f();
        } else {
            com.getpebble.android.common.b.a.f.d("HealthUploader", "uploadData: analytics not enabled; not uploading");
            g();
        }
        return this;
    }

    boolean c() {
        String a = this.e.a(com.getpebble.android.common.b.b.c.a.HEALTH_SETTINGS_LAST_CLOUD_SYNC_HASHCODE_STRING, null);
        this.f = ap.load(this.c.getContentResolver());
        if (TextUtils.isEmpty(a)) {
            com.getpebble.android.common.b.a.f.e("HealthUploader", "isHealthSettingsUploadRequired: no known hashcode; upload required");
            return true;
        }
        try {
            int intValue = Integer.valueOf(a).intValue();
            com.getpebble.android.common.b.a.f.e("HealthUploader", "DB hashcode: " + this.f.hashCode() + "; last cloud sync: " + intValue);
            if (this.f.hashCode() == intValue) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.d("HealthUploader", "syncHealth: loaded bad health settings hashcode: " + a, e);
            return true;
        }
    }

    boolean d() {
        int a = (int) this.d.a();
        this.g = com.getpebble.android.common.model.a.d.a(this.c.getContentResolver(), this.e.a(com.getpebble.android.common.b.b.c.a.HEALTH_ACTIVITY_LAST_SYNC_ROW, 0), 1000);
        this.h = com.getpebble.android.common.model.a.o.a(this.c.getContentResolver(), a, 1000);
        if (this.g.isEmpty() && this.h.isEmpty()) {
            return false;
        }
        return true;
    }

    void e() {
        String Z = com.getpebble.android.config.a.c().Z();
        if (TextUtils.isEmpty(Z)) {
            com.getpebble.android.common.b.a.f.a("HealthUploader", "Failed to upload health settings: failed to resolve health write endpoint");
        } else if (a(Z, d.a(this.f).a())) {
            com.getpebble.android.common.b.a.f.d("HealthUploader", "Sync health settings success");
            this.e.b(com.getpebble.android.common.b.b.c.a.HEALTH_SETTINGS_LAST_CLOUD_SYNC_HASHCODE_STRING, String.valueOf(this.f.hashCode()));
        } else {
            com.getpebble.android.common.b.a.f.d("HealthUploader", "syncHealthSettings: POST failed");
        }
    }

    void f() {
        com.getpebble.android.common.b.a.f.d("HealthUploader", "postData: uploading <" + this.h.size() + "> MLS records; <" + this.g.size() + "> activity records");
        com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
        if (p == null) {
            com.getpebble.android.common.b.a.f.d("HealthUploader", "postData: not posting data, null device record");
            return;
        }
        String str;
        z hwPlatform = p.getHwPlatform();
        v fwVersion = p.getFwVersion();
        String name = hwPlatform == null ? "" : hwPlatform.getName();
        String str2 = p.serialNumber;
        if (fwVersion == null) {
            str = "";
        } else {
            str = fwVersion.getVersionTag();
        }
        Object cVar = new c(new g(name, str2, str, p.isoLocale), new f("4.4.1-1404-01abd2f76-endframe", com.getpebble.android.h.q.b().toString()), new e(this.h).a(), new a(this.g).a());
        name = com.getpebble.android.config.a.c().Y();
        if (TextUtils.isEmpty(name)) {
            com.getpebble.android.common.b.a.f.a("HealthUploader", "Failed to upload health settings: failed to resolve health write endpoint");
        } else if (a(name, cVar)) {
            com.getpebble.android.common.b.a.f.d("HealthUploader", "Sync health data success");
            g();
        } else {
            com.getpebble.android.common.b.a.f.d("HealthUploader", "syncHealthSettings: POST failed");
        }
    }

    void g() {
        if (!this.g.isEmpty()) {
            this.d.a((long) ((com.getpebble.android.framework.health.d.e) as.d(this.g)).e());
        }
        if (!this.h.isEmpty()) {
            this.e.b(com.getpebble.android.common.b.b.c.a.HEALTH_MLS_LAST_SYNC_ROW, ((com.getpebble.android.common.model.a.o.c) as.d(this.h)).b());
        }
    }

    private boolean a(String str, o oVar) {
        try {
            com.getpebble.android.common.b.a.f.e("HealthUploader", "upload: Uploading health data: " + p.a(oVar));
            return a(com.getpebble.android.d.a.a(this.c, str, oVar, com.getpebble.android.d.a.a), str);
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.d("HealthUploader", "Failed to sync health data", e);
            return false;
        }
    }

    private boolean a(String str, Object obj) {
        try {
            com.getpebble.android.common.b.a.f.e("HealthUploader", "upload: Uploading health data: " + p.a(obj));
            return a(com.getpebble.android.d.a.a(this.c, str, obj, com.getpebble.android.d.a.a), str);
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.d("HealthUploader", "Failed to sync health data", e);
            return false;
        }
    }

    private boolean a(x<o> xVar, String str) {
        if (xVar == null) {
            com.getpebble.android.common.b.a.f.d("HealthUploader", "upload: null response");
            return false;
        }
        h d = xVar.d();
        if (d == null) {
            com.getpebble.android.common.b.a.f.d("HealthUploader", "upload: null headers");
            return false;
        }
        boolean z = d.b() >= 200 && d.b() < 300;
        if (!z) {
            o oVar = (o) xVar.b();
            com.getpebble.android.common.b.a.f.d("HealthUploader", "upload: <" + str + "> failed with code <" + d.b() + "> and response: " + (oVar == null ? "<null>" : p.a(oVar)));
        }
        return z;
    }

    com.getpebble.android.common.b.b.c h() {
        return PebbleApplication.y();
    }

    boolean i() {
        return false;
    }
}
