package com.getpebble.android.framework.health.b;

import android.content.Context;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.b.m;
import com.getpebble.android.common.framework.b.m.e;
import com.getpebble.android.common.model.a.w;
import com.getpebble.android.common.model.ap;
import com.getpebble.android.common.model.ba;
import com.getpebble.android.framework.health.d.b;
import com.getpebble.android.h.p;

public class a extends com.getpebble.android.core.sync.a<a> {

    public interface a {
        void a(ap apVar);

        void a(ap apVar, e eVar);
    }

    public a(Context context) {
        super(context, "HeartRateCalculator");
    }

    public a a(final ap apVar, final a aVar) {
        return (a) a(new b(this) {
            final /* synthetic */ a c;

            public void a(String str) {
                try {
                    e eVar = (e) p.a(str, e.class);
                    f.d("HeartRateCalculator", c() + ": success - " + eVar);
                    aVar.a(apVar, eVar);
                } catch (Throwable e) {
                    f.a("HeartRateCalculator", c() + ": apiCallSucceeded: failed to marshall js result: " + str + "; request: " + b(), e);
                    aVar.a(apVar);
                }
            }

            public void a() {
                aVar.a(apVar);
            }

            public String b() {
                return m.a(apVar);
            }

            public String c() {
                return "getRestingHeartRate";
            }
        });
    }

    public a a(final ap apVar, final Integer num) {
        return (a) a(new b(this) {
            final /* synthetic */ a c;

            public void a(String str) {
                try {
                    b bVar = (b) p.a(str, b.class);
                    f.d("HeartRateCalculator", c() + ": success");
                    ba.a(w.a(bVar), this.c.f.getContentResolver());
                } catch (Throwable e) {
                    f.a("HeartRateCalculator", c() + ": apiCallSucceeded: failed to marshall js result: " + str + "; request: " + b(), e);
                }
            }

            public void a() {
            }

            public String b() {
                return m.a(apVar, num);
            }

            public String c() {
                return "updateHeartRateInformation";
            }
        });
    }
}
