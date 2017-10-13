package com.getpebble.android.common.framework.b;

import com.getpebble.android.common.framework.b.m.e;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.w;

final class h extends b {

    public static final class a extends w<e> {
        private final w<Integer> a;
        private final w<com.getpebble.android.common.framework.b.m.h> b;

        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public a(f fVar) {
            this.a = fVar.a(Integer.class);
            this.b = fVar.a(com.getpebble.android.common.framework.b.m.h.class);
        }

        public void a(c cVar, e eVar) {
            cVar.d();
            cVar.a("restingHeartRate");
            this.a.a(cVar, eVar.a());
            if (eVar.b() != null) {
                cVar.a("scannedRange");
                this.b.a(cVar, eVar.b());
            }
            cVar.e();
        }

        public e a(com.google.b.d.a aVar) {
            com.getpebble.android.common.framework.b.m.h hVar = null;
            aVar.c();
            Integer num = null;
            while (aVar.e()) {
                String g = aVar.g();
                if (aVar.f() == b.NULL) {
                    aVar.n();
                } else {
                    Integer num2;
                    com.getpebble.android.common.framework.b.m.h hVar2;
                    Object obj = -1;
                    switch (g.hashCode()) {
                        case 1603838552:
                            if (g.equals("restingHeartRate")) {
                                obj = null;
                                break;
                            }
                            break;
                        case 2137426221:
                            if (g.equals("scannedRange")) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            com.getpebble.android.common.framework.b.m.h hVar3 = hVar;
                            num2 = (Integer) this.a.b(aVar);
                            hVar2 = hVar3;
                            break;
                        case 1:
                            hVar2 = (com.getpebble.android.common.framework.b.m.h) this.b.b(aVar);
                            num2 = num;
                            break;
                        default:
                            aVar.n();
                            hVar2 = hVar;
                            num2 = num;
                            break;
                    }
                    num = num2;
                    hVar = hVar2;
                }
            }
            aVar.d();
            return new h(num, hVar);
        }
    }

    h(Integer num, com.getpebble.android.common.framework.b.m.h hVar) {
        super(num, hVar);
    }
}
