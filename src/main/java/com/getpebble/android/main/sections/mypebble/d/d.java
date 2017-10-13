package com.getpebble.android.main.sections.mypebble.d;

import android.content.ContentResolver;
import android.content.Context;
import com.getpebble.android.common.model.a.r;
import com.getpebble.android.common.model.a.w;
import com.getpebble.android.common.model.a.x;
import com.getpebble.android.common.model.a.y;
import com.getpebble.android.common.model.ao;
import com.getpebble.android.common.model.u;
import com.getpebble.android.h.p;
import com.getpebble.android.main.sections.mypebble.d.a.q;
import com.getpebble.android.main.sections.mypebble.d.a.s;
import com.getpebble.android.main.sections.mypebble.d.a.t;
import com.google.a.b.am;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class d extends com.getpebble.android.h.c<c> {
    private static final int a = (((int) TimeUnit.DAYS.toHours(1)) * 4);
    private final h b;

    public interface h {
        void c();

        c d();
    }

    private static abstract class e implements c, h {
        private e() {
        }

        public String b() {
            return p.a(this);
        }

        public c d() {
            return this;
        }
    }

    private static abstract class a extends e {
        transient boolean a;

        private a() {
            super();
            this.a = false;
        }

        public boolean a() {
            return this.a;
        }

        public void c() {
            boolean z = com.getpebble.android.common.model.a.o.a(d.e()) || com.getpebble.android.common.model.a.d.a(d.e(), com.getpebble.android.framework.health.d.a.a.activityTypes());
            this.a = z;
        }
    }

    static class b extends a {
        private transient a b;
        private final transient com.getpebble.android.common.model.a.r.b<y> c = r.a(y.class);
        @com.google.b.a.c(a = "start")
        private final long d;
        @com.google.b.a.c(a = "end")
        private final long e;
        @com.google.b.a.c(a = "sessions")
        private q[] f;
        @com.google.b.a.c(a = "typical")
        private a g;
        @com.google.b.a.c(a = "chunks")
        private com.getpebble.android.main.sections.mypebble.d.a.m[] h;

        private static class a {
            @com.google.b.a.c(a = "isoWeekday")
            private final int a;
            @com.google.b.a.c(a = "stepsPerQuarterHour")
            private int[] b;

            a(j jVar, int[] iArr) {
                this.a = jVar.a;
                this.b = iArr;
            }
        }

        b(a aVar) {
            super();
            this.b = aVar;
            this.d = aVar.a;
            this.e = aVar.b;
        }

        public void c() {
            super.c();
            ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
            this.f = d.e(this.d, this.e, contentResolver);
            this.h = d.a(this.d, this.e, contentResolver);
            j jVar = this.b.c;
            if (jVar == null) {
                com.getpebble.android.common.b.a.f.d("HealthChartDataLoader", "DailyActivityLoadable: load: query.typical is null");
            } else {
                this.g = new a(jVar, d.a(contentResolver, u.from(jVar.a), this.c));
            }
        }
    }

    private static abstract class f extends e {
        transient boolean a;
        transient boolean b;

        private f() {
            super();
            this.a = false;
            this.b = true;
        }

        public boolean a() {
            return this.b && this.a;
        }

        public void c() {
            this.b = ao.isHRMEnabled();
            this.a = com.getpebble.android.common.model.a.o.b(d.e()) != null;
        }
    }

    static class c extends f {
        private transient b c;
        @com.google.b.a.c(a = "start")
        private final long d;
        @com.google.b.a.c(a = "end")
        private final long e;
        @com.google.b.a.c(a = "chunks")
        private com.getpebble.android.main.sections.mypebble.d.a.n[] f;
        @com.google.b.a.c(a = "latest")
        private g g;

        public c(b bVar) {
            super();
            this.c = bVar;
            this.d = bVar.a;
            this.e = bVar.b;
        }

        public void c() {
            super.c();
            this.f = d.c(this.d, this.e, d.e());
            this.g = g.a(d.e());
            com.getpebble.android.common.b.a.f.d("HealthChartDataLoader", String.format(Locale.US, "DailyHeartRateLoadable.load[%d:%d]: loaded %d chunks, latest HR: %d", new Object[]{Long.valueOf(this.d), Long.valueOf(this.e), Integer.valueOf(this.f.length), this.g.a}));
        }
    }

    private static abstract class k extends e {
        transient boolean b;

        private k() {
            super();
            this.b = false;
        }

        public boolean a() {
            return this.b;
        }

        public void c() {
            this.b = com.getpebble.android.common.model.a.d.a(d.e(), com.getpebble.android.framework.health.d.a.a.sleepTypes());
        }
    }

    static class d extends k {
        private transient c a;
        @com.google.b.a.c(a = "start")
        private final long c;
        @com.google.b.a.c(a = "end")
        private final long d;
        @com.google.b.a.c(a = "sessions")
        private s[] e;
        @com.google.b.a.c(a = "deepSleepSessions")
        private s[] f;
        @com.google.b.a.c(a = "napSessions")
        private s[] g;
        @com.google.b.a.c(a = "typical")
        private com.getpebble.android.main.sections.mypebble.d.a.o h;

        d(c cVar) {
            super();
            this.a = cVar;
            this.c = cVar.a;
            this.d = cVar.b;
        }

        public void c() {
            super.c();
            ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
            this.e = d.a(this.c, this.d, com.getpebble.android.framework.health.d.a.a.Sleep, contentResolver);
            this.f = d.a(this.c, this.d, com.getpebble.android.framework.health.d.a.a.DeepSleep, contentResolver);
            this.g = d.a(this.c, this.d, com.getpebble.android.framework.health.d.a.a.Nap, contentResolver);
            if (this.a.c == null) {
                com.getpebble.android.common.b.a.f.d("HealthChartDataLoader", "DailySleepQuery: load: query.typical is null");
            } else {
                this.h = d.b(u.from(this.a.c.a));
            }
        }
    }

    static class g {
        @com.google.b.a.c(a = "heartRate")
        private final Integer a;
        @com.google.b.a.c(a = "date")
        private final Long b;
        @com.google.b.a.c(a = "dateTimeZoneOffset")
        private final Long c;
        @com.google.b.a.c(a = "restingHeartRate")
        private final Integer d;
        @com.google.b.a.c(a = "zone1Threshold")
        private final int e;
        @com.google.b.a.c(a = "zone2Threshold")
        private final int f;
        @com.google.b.a.c(a = "zone3Threshold")
        private final int g;

        public g(Integer num, Long l, Long l2, Integer num2, int i, int i2, int i3) {
            this.a = num;
            this.b = l;
            this.c = l2;
            this.d = num2;
            this.e = i;
            this.f = i2;
            this.g = i3;
        }

        public static g a(ContentResolver contentResolver) {
            Integer valueOf;
            int i;
            com.getpebble.android.common.model.a.o.e b = com.getpebble.android.common.model.a.o.b(contentResolver);
            if (b == null || b.m() == null) {
                valueOf = Integer.valueOf(0);
                i = 0;
            } else {
                valueOf = b.m();
                i = b.d();
            }
            w a = w.a(contentResolver);
            return new g(valueOf, Long.valueOf((long) i), null, Integer.valueOf(a.a()), a.d(), a.e(), a.f());
        }
    }

    static class i extends a {
        private transient f b;
        @com.google.b.a.c(a = "weeks")
        private com.getpebble.android.main.sections.mypebble.d.a.m[] c;
        @com.google.b.a.c(a = "typical")
        private l d;

        i(f fVar) {
            super();
            this.b = fVar;
        }

        public void c() {
            super.c();
            ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
            if (this.b.a == null) {
                com.getpebble.android.common.b.a.f.d("HealthChartDataLoader", "MonthlyActivityLoadable: load: query.weeks is null");
                this.c = new com.getpebble.android.main.sections.mypebble.d.a.m[0];
            } else {
                this.c = new com.getpebble.android.main.sections.mypebble.d.a.m[this.b.a.length];
                for (int i = 0; i < this.b.a.length; i++) {
                    com.getpebble.android.common.model.a.o.a d = com.getpebble.android.common.model.a.o.d(contentResolver, new com.getpebble.android.h.g(this.b.a[i].c), new com.getpebble.android.h.g(this.b.a[i].d));
                    if (d == null) {
                        com.getpebble.android.common.b.a.f.b("HealthChartDataLoader", "weekSummary is null");
                    } else {
                        this.c[i] = com.getpebble.android.main.sections.mypebble.d.a.m.a(this.b.a[i].c, this.b.a[i].d, d, this.b.a[i].a, this.b.a[i].b);
                    }
                }
            }
            this.d = d.a(contentResolver);
        }
    }

    static class j extends k {
        @com.google.b.a.c(a = "weeks")
        h[] a;
        private transient h c;
        @com.google.b.a.c(a = "typical")
        private t d;

        j(h hVar) {
            super();
            this.c = hVar;
            if (hVar.a == null) {
                com.getpebble.android.common.b.a.f.d("HealthChartDataLoader", "MonthlySleepLoadable: query.weeks is null");
                this.a = new h[0];
                return;
            }
            this.a = new h[hVar.a.length];
        }

        public void c() {
            super.c();
            ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
            for (int i = 0; i < this.a.length; i++) {
                d dVar = this.c.a[i];
                long j = dVar.c;
                long j2 = dVar.d;
                s[] a = d.a(j, j2, com.getpebble.android.framework.health.d.a.a.Sleep, contentResolver);
                s[] a2 = d.a(j, j2, com.getpebble.android.framework.health.d.a.a.DeepSleep, contentResolver);
                this.a[i] = new h(j, j2, dVar.a, dVar.b, a, a2);
            }
            this.d = d.d();
        }
    }

    static class l {
        @com.google.b.a.c(a = "steps")
        private final int a;

        l(int i) {
            this.a = i;
        }
    }

    static class m extends a {
        private transient k b;
        @com.google.b.a.c(a = "days")
        private com.getpebble.android.main.sections.mypebble.d.a.m[] c;
        @com.google.b.a.c(a = "typical")
        private l d;

        m(k kVar) {
            super();
            this.b = kVar;
        }

        public void c() {
            super.c();
            ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
            d[] dVarArr = this.b.a;
            if (dVarArr == null) {
                com.getpebble.android.common.b.a.f.d("HealthChartDataLoader", "WeeklyActivityLoadable: load: query.days is null");
                this.c = new com.getpebble.android.main.sections.mypebble.d.a.m[0];
            } else {
                this.c = new com.getpebble.android.main.sections.mypebble.d.a.m[dVarArr.length];
                for (int i = 0; i < dVarArr.length; i++) {
                    com.getpebble.android.common.model.a.o.a d = com.getpebble.android.common.model.a.o.d(contentResolver, new com.getpebble.android.h.g(dVarArr[i].c), new com.getpebble.android.h.g(dVarArr[i].d));
                    if (d == null) {
                        com.getpebble.android.common.b.a.f.b("HealthChartDataLoader", "daySummary is null");
                    } else {
                        this.c[i] = com.getpebble.android.main.sections.mypebble.d.a.m.a(dVarArr[i].c, dVarArr[i].d, d, dVarArr[i].a, dVarArr[i].b);
                    }
                }
            }
            this.d = d.a(contentResolver);
        }
    }

    static class n extends f {
        private transient l c;
        @com.google.b.a.c(a = "days")
        private com.getpebble.android.main.sections.mypebble.d.a.p[] d;
        @com.google.b.a.c(a = "latest")
        private g e;

        n(l lVar) {
            super();
            this.c = lVar;
        }

        public void c() {
            d[] dVarArr;
            super.c();
            d[] dVarArr2 = this.c.a;
            this.e = g.a(d.e());
            if (dVarArr2 == null) {
                com.getpebble.android.common.b.a.f.c("HealthChartDataLoader", "load: no days in WeeklyHeartRateLoadable query");
                dVarArr = new d[0];
            } else {
                dVarArr = dVarArr2;
            }
            this.d = new com.getpebble.android.main.sections.mypebble.d.a.p[dVarArr.length];
            for (int i = 0; i < this.d.length; i++) {
                d dVar = dVarArr[i];
                this.d[i] = com.getpebble.android.main.sections.mypebble.d.a.p.a(dVar.c, dVar.d, dVar.a, dVar.b, d.b(dVar.c, dVar.d));
            }
        }
    }

    static class o extends k {
        @com.google.b.a.c(a = "days")
        h[] a;
        private transient m c;
        @com.google.b.a.c(a = "typical")
        private t d;

        o(m mVar) {
            super();
            this.c = mVar;
            if (mVar.a == null) {
                com.getpebble.android.common.b.a.f.d("HealthChartDataLoader", "WeeklySleepLoadable: query.days is null");
                this.a = new h[0];
                return;
            }
            this.a = new h[mVar.a.length];
        }

        public void c() {
            super.c();
            ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
            for (int i = 0; i < this.a.length; i++) {
                d dVar = this.c.a[i];
                long j = dVar.c;
                long j2 = dVar.d;
                s[] a = d.a(j, j2, com.getpebble.android.framework.health.d.a.a.Sleep, contentResolver);
                s[] a2 = d.a(j, j2, com.getpebble.android.framework.health.d.a.a.DeepSleep, contentResolver);
                this.a[i] = new h(j, j2, dVar.a, dVar.b, a, a2);
            }
            this.d = d.d();
        }
    }

    public /* synthetic */ Object loadInBackground() {
        return a();
    }

    public d(Context context, h hVar) {
        super(context);
        this.b = hVar;
    }

    public c a() {
        com.getpebble.android.common.b.a.f.e("HealthChartDataLoader", "loadInBackground()");
        if (this.b == null) {
            return null;
        }
        this.b.c();
        return this.b.d();
    }

    public static com.getpebble.android.main.sections.mypebble.d.a.m[] a(long j, long j2, ContentResolver contentResolver) {
        List b = com.getpebble.android.common.model.a.o.b(contentResolver, new com.getpebble.android.h.g(j), new com.getpebble.android.h.g(j2));
        com.getpebble.android.main.sections.mypebble.d.a.m[] mVarArr = new com.getpebble.android.main.sections.mypebble.d.a.m[b.size()];
        for (int i = 0; i < b.size(); i++) {
            mVarArr[i] = com.getpebble.android.main.sections.mypebble.d.a.m.a((com.getpebble.android.common.model.a.o.e) b.get(i));
        }
        return mVarArr;
    }

    public static com.getpebble.android.main.sections.mypebble.d.a.f[] b(long j, long j2, ContentResolver contentResolver) {
        List b = com.getpebble.android.common.model.a.o.b(contentResolver, new com.getpebble.android.h.g(j), new com.getpebble.android.h.g(j2));
        com.getpebble.android.main.sections.mypebble.d.a.f[] fVarArr = new com.getpebble.android.main.sections.mypebble.d.a.f[b.size()];
        for (int i = 0; i < b.size(); i++) {
            fVarArr[i] = com.getpebble.android.main.sections.mypebble.d.a.f.a((com.getpebble.android.common.model.a.o.e) b.get(i));
        }
        return fVarArr;
    }

    public static com.getpebble.android.main.sections.mypebble.d.a.n[] c(long j, long j2, ContentResolver contentResolver) {
        List a = com.getpebble.android.common.model.a.o.a(contentResolver, new com.getpebble.android.h.g(j), new com.getpebble.android.h.g(j2));
        com.getpebble.android.main.sections.mypebble.d.a.n[] nVarArr = new com.getpebble.android.main.sections.mypebble.d.a.n[a.size()];
        for (int i = 0; i < a.size(); i++) {
            nVarArr[i] = com.getpebble.android.main.sections.mypebble.d.a.n.a((com.getpebble.android.common.model.a.o.e) a.get(i));
        }
        com.getpebble.android.common.b.a.f.e("HealthChartDataLoader", "loadHeartRateChunksForChart: loaded chunks: " + Arrays.toString(nVarArr));
        return nVarArr;
    }

    public static com.getpebble.android.main.sections.mypebble.d.a.g[] a(int i, int i2, ContentResolver contentResolver) {
        List a = com.getpebble.android.common.model.a.o.a(contentResolver, new com.getpebble.android.h.g((long) i), new com.getpebble.android.h.g((long) i2));
        com.getpebble.android.main.sections.mypebble.d.a.g[] gVarArr = new com.getpebble.android.main.sections.mypebble.d.a.g[a.size()];
        for (int i3 = 0; i3 < a.size(); i3++) {
            gVarArr[i3] = com.getpebble.android.main.sections.mypebble.d.a.g.a((com.getpebble.android.common.model.a.o.e) a.get(i3));
        }
        com.getpebble.android.common.b.a.f.e("HealthChartDataLoader", "loadHeartRateChunksForAPI: loaded chunks: " + Arrays.toString(gVarArr));
        return gVarArr;
    }

    public static int[] a(ContentResolver contentResolver, u uVar, com.getpebble.android.common.model.a.r.b<y> bVar) {
        y yVar = (y) bVar.a(contentResolver, y.a(uVar));
        return yVar != null ? yVar.a() : new int[a];
    }

    public static l a(ContentResolver contentResolver) {
        com.getpebble.android.common.model.a.j jVar = (com.getpebble.android.common.model.a.j) r.a(com.getpebble.android.common.model.a.j.class).a(contentResolver, com.getpebble.android.common.model.a.p.AVERAGE_DAILY_STEPS);
        if (jVar == null) {
            return new l(0);
        }
        return new l((int) jVar.b);
    }

    public static s[] a(long j, long j2, com.getpebble.android.framework.health.d.a.a aVar, ContentResolver contentResolver) {
        List a = a(j, j2, am.b(aVar), contentResolver);
        s[] sVarArr = new s[a.size()];
        for (int i = 0; i < a.size(); i++) {
            sVarArr[i] = s.a((com.getpebble.android.framework.health.d.a) a.get(i));
        }
        return sVarArr;
    }

    private static q[] e(long j, long j2, ContentResolver contentResolver) {
        List a = a(j, j2, am.a(com.getpebble.android.framework.health.d.a.a.Walk, com.getpebble.android.framework.health.d.a.a.Run), contentResolver);
        q[] qVarArr = new q[a.size()];
        for (int i = 0; i < a.size(); i++) {
            qVarArr[i] = q.a((com.getpebble.android.framework.health.d.a) a.get(i));
        }
        return qVarArr;
    }

    private static List<com.getpebble.android.framework.health.d.a> a(long j, long j2, Set<com.getpebble.android.framework.health.d.a.a> set, ContentResolver contentResolver) {
        return com.getpebble.android.common.model.a.d.a(contentResolver, new com.getpebble.android.h.g(j), new com.getpebble.android.h.g(j2), set);
    }

    private static com.getpebble.android.main.sections.mypebble.d.a.o b(u uVar) {
        x xVar = (x) r.a(x.class).a(e(), x.a(uVar));
        if (xVar == null) {
            return new com.getpebble.android.main.sections.mypebble.d.a.o(null, null, null, null);
        }
        return new com.getpebble.android.main.sections.mypebble.d.a.o(Integer.valueOf(xVar.i), Integer.valueOf(xVar.j), Integer.valueOf(xVar.k), Integer.valueOf(xVar.l));
    }

    private static t d() {
        com.getpebble.android.common.model.a.k kVar = (com.getpebble.android.common.model.a.k) r.a(com.getpebble.android.common.model.a.k.class).a(e(), com.getpebble.android.common.model.a.p.AVERAGE_SLEEP_DURATION);
        if (kVar == null) {
            return new t(Integer.valueOf(0));
        }
        return new t(Integer.valueOf(kVar.b));
    }

    private static com.getpebble.android.common.model.a.o.b b(long j, long j2) {
        return com.getpebble.android.common.model.a.o.c(e(), new com.getpebble.android.h.g(j), new com.getpebble.android.h.g(j2));
    }

    private static ContentResolver e() {
        return com.getpebble.android.common.a.K().getContentResolver();
    }
}
