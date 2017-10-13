package com.getpebble.android.framework.health.e;

import android.content.Context;
import android.os.SystemClock;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.b.m;
import com.getpebble.android.common.model.a.j;
import com.getpebble.android.common.model.a.r.d;
import com.getpebble.android.common.model.a.v;
import com.getpebble.android.common.model.a.y;
import com.getpebble.android.common.model.k;
import com.getpebble.android.common.model.u;
import com.getpebble.android.h.p;
import java.util.Arrays;

public class a extends com.getpebble.android.core.sync.a<a> {
    public a(Context context) {
        super(context, "MovementCalculator");
    }

    public a a(d<y> dVar) {
        for (u a : u.values()) {
            a((d) dVar, a);
        }
        return this;
    }

    public a a(d<v> dVar, u[] uVarArr) {
        for (u b : uVarArr) {
            b(dVar, b);
        }
        return this;
    }

    public a b(final d<j> dVar) {
        SystemClock.elapsedRealtime();
        a(new b(this) {
            final /* synthetic */ a b;

            public void a(String str) {
                f.d("MovementCalculator", "got averageDailySteps: " + str);
                k.b(this.b.f.getContentResolver(), dVar.a(new j((long) Integer.valueOf(str).intValue())));
            }

            public void a() {
            }

            public String b() {
                return m.b();
            }

            public String c() {
                return "updateAverageDailySteps";
            }
        });
        return this;
    }

    private void a(d<y> dVar, u uVar) {
        a(new a<y>(this, uVar, dVar, this.f) {
            final /* synthetic */ a d;

            public void a(String str) {
                Integer[] a = m.a(str);
                f.d("MovementCalculator", "got typical steps");
                f.e("MovementCalculator", Arrays.toString(a));
                k.b(this.c.getContentResolver(), this.b.a(new y(this.a, a)));
            }

            public void a() {
            }

            public String b() {
                return m.a(this.a);
            }

            public String c() {
                return "updateTypicalSteps:" + this.a;
            }
        });
    }

    private void b(d<v> dVar, u uVar) {
        a(new a<v>(this, uVar, dVar, this.f) {
            final /* synthetic */ a d;

            public void a(String str) {
                m.d dVar = (m.d) p.a(str, m.d.class);
                f.d("MovementCalculator", "got movement data for " + this.a);
                f.e("MovementCalculator", dVar.toString());
                k.b(this.c.getContentResolver(), this.b.a(new v(this.a, dVar)));
            }

            public void a() {
            }

            public String b() {
                return m.b(this.a);
            }

            public String c() {
                return "updateMovementData";
            }
        });
    }
}
