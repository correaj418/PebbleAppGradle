package com.getpebble.android.common.framework.b;

import android.content.ContentResolver;
import android.webkit.JavascriptInterface;
import com.getpebble.android.common.model.ap;
import com.getpebble.android.common.model.u;
import com.getpebble.android.h.p;
import com.getpebble.android.main.sections.mypebble.d.a.s;
import com.google.b.w;

public class m {
    private final com.getpebble.jskit.android.impl.runtime.a.a.e a;
    private a b = new a();
    private c c;

    public static abstract class d {
        @com.google.b.a.c(a = "lastProcessedAt")
        public abstract int a();

        @com.google.b.a.c(a = "steps")
        public abstract int b();

        @com.google.b.a.c(a = "activeKiloCalories")
        public abstract int c();

        @com.google.b.a.c(a = "restingKiloCalories")
        public abstract int d();

        @com.google.b.a.c(a = "distance")
        public abstract int e();

        @com.google.b.a.c(a = "activeSeconds")
        public abstract int f();

        public static w<d> a(com.google.b.f fVar) {
            return new com.getpebble.android.common.framework.b.g.a(fVar);
        }
    }

    public static abstract class e {
        @com.google.b.a.c(a = "restingHeartRate")
        public abstract Integer a();

        @com.google.b.a.c(a = "scannedRange")
        public abstract h b();

        public static w<e> a(com.google.b.f fVar) {
            return new com.getpebble.android.common.framework.b.h.a(fVar);
        }
    }

    public static abstract class f {
        @com.google.b.a.c(a = "lastProcessedAt")
        public abstract int a();

        @com.google.b.a.c(a = "sleepDuration")
        public abstract int b();

        @com.google.b.a.c(a = "deepSleepDuration")
        public abstract int c();

        @com.google.b.a.c(a = "fallAsleepTime")
        public abstract int d();

        @com.google.b.a.c(a = "wakeUpTime")
        public abstract int e();

        public static f a(int i, int i2, int i3, int i4, int i5) {
            return new i(i, i2, i3, i4, i5);
        }

        public static f f() {
            return new i(0, 0, 0, 0, 0);
        }

        public static w<f> a(com.google.b.f fVar) {
            return new com.getpebble.android.common.framework.b.i.a(fVar);
        }
    }

    public static abstract class h {
        @com.google.b.a.c(a = "start")
        public abstract int a();

        @com.google.b.a.c(a = "end")
        public abstract int b();

        public static w<h> a(com.google.b.f fVar) {
            return new com.getpebble.android.common.framework.b.j.a(fVar);
        }
    }

    public static abstract class i {
        @com.google.b.a.c(a = "sleepDuration")
        public abstract Integer a();

        @com.google.b.a.c(a = "deepSleepDuration")
        public abstract Integer b();

        @com.google.b.a.c(a = "fallAsleepTime")
        public abstract Integer c();

        @com.google.b.a.c(a = "wakeUpTime")
        public abstract Integer d();

        public static i a(Integer num, Integer num2, Integer num3, Integer num4) {
            return new k(num, num2, num3, num4);
        }

        public static i e() {
            return new k(null, null, null, null);
        }

        public static w<i> a(com.google.b.f fVar) {
            return new com.getpebble.android.common.framework.b.k.a(fVar);
        }
    }

    public static class a implements com.getpebble.jskit.android.impl.runtime.a.a.e.c {
        public String getInterfaceName() {
            return "_native";
        }

        @JavascriptInterface
        public String getChunksBetweenDates(int i, int i2) {
            return p.a(com.getpebble.android.main.sections.mypebble.d.d.b((long) i, (long) i2, com.getpebble.android.common.a.K().getContentResolver()));
        }

        @JavascriptInterface
        public String getHeartRateSamplesBetweenDates(int i, int i2) {
            return p.a(com.getpebble.android.main.sections.mypebble.d.d.a(i, i2, com.getpebble.android.common.a.K().getContentResolver()));
        }

        @JavascriptInterface
        public String getSleepSessionsBetweenDates(int i, int i2) {
            ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
            return p.a(new g(com.getpebble.android.main.sections.mypebble.d.d.a((long) i, (long) i2, com.getpebble.android.framework.health.d.a.a.Sleep, contentResolver), com.getpebble.android.main.sections.mypebble.d.d.a((long) i, (long) i2, com.getpebble.android.framework.health.d.a.a.DeepSleep, contentResolver), com.getpebble.android.main.sections.mypebble.d.d.a((long) i, (long) i2, com.getpebble.android.framework.health.d.a.a.Nap, contentResolver)));
        }
    }

    public interface b {
        void a();
    }

    public interface c {
        void a(String str);
    }

    private static class g {
        @com.google.b.a.c(a = "sleep")
        public s[] a;
        @com.google.b.a.c(a = "deepSleep")
        public s[] b;
        @com.google.b.a.c(a = "naps")
        public s[] c;

        g(s[] sVarArr, s[] sVarArr2, s[] sVarArr3) {
            this.a = sVarArr;
            this.b = sVarArr2;
            this.c = sVarArr3;
        }
    }

    private static class j {
        @com.google.b.a.c(a = "ageInYears")
        public byte a;

        public j(byte b) {
            this.a = b;
        }
    }

    public m(com.getpebble.jskit.android.impl.runtime.a.a.e eVar) {
        this.a = eVar;
    }

    public void a(final b bVar) {
        if (!this.a.isInit()) {
            this.a.init();
            this.a.addJsInterface(this.b);
            com.getpebble.jskit.android.impl.runtime.a.a.e.a anonymousClass1 = new com.getpebble.jskit.android.impl.runtime.a.a.e.a(this) {
                final /* synthetic */ m b;

                public void a(com.getpebble.jskit.android.impl.runtime.a.a.e eVar) {
                    com.getpebble.android.common.b.a.f.e("HealthJsRunner", "File ready: on result");
                    bVar.a();
                }
            };
            com.getpebble.jskit.android.impl.runtime.a.a.e.d anonymousClass2 = new com.getpebble.jskit.android.impl.runtime.a.a.e.d(this) {
                final /* synthetic */ m a;

                {
                    this.a = r1;
                }

                public void a(com.getpebble.jskit.android.impl.runtime.a.a.e eVar, String str) {
                    com.getpebble.android.common.b.a.f.e("HealthJsRunner", "JS Result: " + str);
                    c a = this.a.c;
                    if (a == null) {
                        com.getpebble.android.common.b.a.f.b("HealthJsRunner", "Not passing result, no callback set");
                    } else {
                        a.a(str);
                    }
                }
            };
            this.a.setFileLoadCallback(anonymousClass1);
            this.a.setJsResultCallback(anonymousClass2);
            com.getpebble.android.common.b.a.f.e("HealthJsRunner", "init: loadFile");
            this.a.loadFile("file:///android_asset/health-background-chart.html");
        }
    }

    public void a(String str, c cVar) {
        this.c = cVar;
        this.a.evaluateJavascript(str);
    }

    public void a() {
        this.a.removeJsInterface(this.b);
        this.a.destroyOnMainThread();
    }

    public static Integer[] a(String str) {
        Double[] dArr = (Double[]) p.a(str, Double[].class);
        if (dArr == null) {
            throw new IllegalArgumentException("Null doubles array from: " + str);
        }
        Integer[] numArr = new Integer[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            numArr[i] = dArr[i] == null ? null : Integer.valueOf((int) Math.round(dArr[i].doubleValue()));
        }
        return numArr;
    }

    public static String a(u uVar) {
        return "js.health.movement.getTypicalStepsForDayOfWeek(" + uVar.isoIndex + ")";
    }

    public static String b(u uVar) {
        return "js.health.movement.getSummaryForDayOfWeek(" + uVar.isoIndex + ")";
    }

    public static String c(u uVar) {
        return "js.health.sleep.getTypicalSleepForDayOfWeek(" + uVar.isoIndex + ")";
    }

    public static String d(u uVar) {
        return "js.health.sleep.getSummaryForDayOfWeek(" + uVar.isoIndex + ")";
    }

    public static String a(ap apVar, Integer num) {
        j jVar = new j(apVar.ageYears);
        return "js.health.heartRate.heartRatePreferences(" + p.a(jVar) + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + com.getpebble.android.common.b.b.a.b(num) + ")";
    }

    public static String a(ap apVar) {
        j jVar = new j(apVar.ageYears);
        return "js.health.heartRate.restingHeartRate(" + p.a(jVar) + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + com.getpebble.android.common.b.b.a.b(null) + ")";
    }

    public static String b() {
        return "js.health.movement.getTypicalStepsSum()";
    }

    public static String c() {
        return "js.health.sleep.getTypicalSleep()";
    }
}
