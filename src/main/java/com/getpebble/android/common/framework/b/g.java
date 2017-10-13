package com.getpebble.android.common.framework.b;

import com.getpebble.android.common.framework.b.m.d;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.w;

final class g extends a {

    public static final class a extends w<d> {
        private final w<Integer> a;
        private final w<Integer> b;
        private final w<Integer> c;
        private final w<Integer> d;
        private final w<Integer> e;
        private final w<Integer> f;

        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public a(f fVar) {
            this.a = fVar.a(Integer.class);
            this.b = fVar.a(Integer.class);
            this.c = fVar.a(Integer.class);
            this.d = fVar.a(Integer.class);
            this.e = fVar.a(Integer.class);
            this.f = fVar.a(Integer.class);
        }

        public void a(c cVar, d dVar) {
            cVar.d();
            cVar.a("lastProcessedAt");
            this.a.a(cVar, Integer.valueOf(dVar.a()));
            cVar.a("steps");
            this.b.a(cVar, Integer.valueOf(dVar.b()));
            cVar.a("activeKiloCalories");
            this.c.a(cVar, Integer.valueOf(dVar.c()));
            cVar.a("restingKiloCalories");
            this.d.a(cVar, Integer.valueOf(dVar.d()));
            cVar.a("distance");
            this.e.a(cVar, Integer.valueOf(dVar.e()));
            cVar.a("activeSeconds");
            this.f.a(cVar, Integer.valueOf(dVar.f()));
            cVar.e();
        }

        public d a(com.google.b.d.a aVar) {
            aVar.c();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (aVar.e()) {
                String g = aVar.g();
                if (aVar.f() != b.NULL) {
                    Object obj = -1;
                    switch (g.hashCode()) {
                        case -1904708693:
                            if (g.equals("lastProcessedAt")) {
                                obj = null;
                                break;
                            }
                            break;
                        case -1723599955:
                            if (g.equals("activeKiloCalories")) {
                                obj = 2;
                                break;
                            }
                            break;
                        case 109761319:
                            if (g.equals("steps")) {
                                obj = 1;
                                break;
                            }
                            break;
                        case 288459765:
                            if (g.equals("distance")) {
                                obj = 4;
                                break;
                            }
                            break;
                        case 438346805:
                            if (g.equals("restingKiloCalories")) {
                                obj = 3;
                                break;
                            }
                            break;
                        case 790663321:
                            if (g.equals("activeSeconds")) {
                                obj = 5;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            i6 = ((Integer) this.a.b(aVar)).intValue();
                            break;
                        case 1:
                            i5 = ((Integer) this.b.b(aVar)).intValue();
                            break;
                        case 2:
                            i4 = ((Integer) this.c.b(aVar)).intValue();
                            break;
                        case 3:
                            i3 = ((Integer) this.d.b(aVar)).intValue();
                            break;
                        case 4:
                            i2 = ((Integer) this.e.b(aVar)).intValue();
                            break;
                        case 5:
                            i = ((Integer) this.f.b(aVar)).intValue();
                            break;
                        default:
                            aVar.n();
                            break;
                    }
                }
                aVar.n();
            }
            aVar.d();
            return new g(i6, i5, i4, i3, i2, i);
        }
    }

    g(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, i5, i6);
    }
}
