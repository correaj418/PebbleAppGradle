package com.getpebble.android.framework.health.f;

import android.content.Context;
import android.os.SystemClock;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.b.m;
import com.getpebble.android.common.framework.b.m.i;
import com.getpebble.android.common.model.a.k;
import com.getpebble.android.common.model.a.q;
import com.getpebble.android.common.model.a.r.b;
import com.getpebble.android.common.model.a.r.d;
import com.getpebble.android.common.model.a.x;
import com.getpebble.android.common.model.u;
import com.getpebble.android.h.p;

public class a extends com.getpebble.android.core.sync.a<a> {
    public a(Context context) {
        super(context, "SleepCalculator");
    }

    public a a(final d<k> dVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        a(new b(this) {
            final /* synthetic */ a b;

            public void a(String str) {
                f.d("SleepCalculator", "got average sleep: " + str);
                com.getpebble.android.common.model.k.b(this.b.f.getContentResolver(), dVar.a(new k(Integer.valueOf(str).intValue())));
            }

            public void a() {
            }

            public String b() {
                return m.c();
            }

            public String c() {
                return "updateAverageSleepDuration";
            }
        });
        f.e("SleepCalculator", "updateAverageSleepDuration: took " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
        return this;
    }

    public a a(b<x> bVar, d<x> dVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (u a : u.values()) {
            a((b) bVar, (d) dVar, a);
        }
        f.e("SleepCalculator", "updateTypicalSleep: took " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
        return this;
    }

    public a a(b<x> bVar, d<x> dVar, u[] uVarArr) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (u b : uVarArr) {
            b(bVar, dVar, b);
        }
        f.e("SleepCalculator", "updateSummary: took " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
        return this;
    }

    private void a(b<x> bVar, d<x> dVar, u uVar) {
        final b<x> bVar2 = bVar;
        a(new a<x>(this, uVar, dVar, this.f) {
            final /* synthetic */ a e;

            public void a(String str) {
                q xVar;
                i iVar = (i) p.a(str, i.class);
                f.d("SleepCalculator", "got typical sleep for " + this.a);
                f.e("SleepCalculator", iVar.toString());
                x xVar2 = (x) bVar2.a(this.c.getContentResolver(), x.a(this.a));
                if (xVar2 == null) {
                    xVar = new x(this.a, m.f.f(), iVar);
                } else {
                    xVar2.getClass();
                    xVar = new com.getpebble.android.common.model.a.x.a(xVar2).a(iVar).a();
                }
                com.getpebble.android.common.model.k.b(this.c.getContentResolver(), this.b.a(xVar));
            }

            public void a() {
            }

            public String b() {
                return m.c(this.a);
            }

            public String c() {
                return "updateTypicalSleep:" + this.a;
            }
        });
    }

    private void b(b<x> bVar, d<x> dVar, u uVar) {
        final b<x> bVar2 = bVar;
        a(new a<x>(this, uVar, dVar, this.f) {
            final /* synthetic */ a e;

            public void a(String str) {
                q xVar;
                m.f fVar = (m.f) p.a(str, m.f.class);
                f.d("SleepCalculator", "got day summary for " + this.a);
                f.e("SleepCalculator", fVar.toString());
                x xVar2 = (x) bVar2.a(this.c.getContentResolver(), x.a(this.a));
                if (xVar2 == null) {
                    xVar = new x(this.a, fVar, i.e());
                } else {
                    xVar2.getClass();
                    xVar = new com.getpebble.android.common.model.a.x.a(xVar2).a(fVar).a();
                }
                com.getpebble.android.common.model.k.b(this.c.getContentResolver(), this.b.a(xVar));
            }

            public void a() {
            }

            public String b() {
                return m.d(this.a);
            }

            public String c() {
                return "updateSummary";
            }
        });
    }
}
