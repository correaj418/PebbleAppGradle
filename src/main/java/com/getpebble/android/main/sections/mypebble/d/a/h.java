package com.getpebble.android.main.sections.mypebble.d.a;

import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.w;

final class h extends a {

    public static final class a extends w<f> {
        private final w<Long> a;
        private final w<Long> b;
        private final w<Integer> c;
        private final w<String> d;
        private final w<String> e;
        private final w<Integer> f;
        private final w<Integer> g;
        private final w<Integer> h;
        private final w<Integer> i;
        private final w<Long> j;

        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public a(f fVar) {
            this.a = fVar.a(Long.class);
            this.b = fVar.a(Long.class);
            this.c = fVar.a(Integer.class);
            this.d = fVar.a(String.class);
            this.e = fVar.a(String.class);
            this.f = fVar.a(Integer.class);
            this.g = fVar.a(Integer.class);
            this.h = fVar.a(Integer.class);
            this.i = fVar.a(Integer.class);
            this.j = fVar.a(Long.class);
        }

        public void a(c cVar, f fVar) {
            cVar.d();
            cVar.a("start");
            this.a.a(cVar, Long.valueOf(fVar.a()));
            cVar.a("end");
            this.b.a(cVar, Long.valueOf(fVar.b()));
            cVar.a("startTimeZoneOffset");
            this.c.a(cVar, Integer.valueOf(fVar.c()));
            if (fVar.d() != null) {
                cVar.a("label");
                this.d.a(cVar, fVar.d());
            }
            if (fVar.e() != null) {
                cVar.a("shortLabel");
                this.e.a(cVar, fVar.e());
            }
            if (fVar.f() != null) {
                cVar.a("steps");
                this.f.a(cVar, fVar.f());
            }
            if (fVar.g() != null) {
                cVar.a("activeKiloCalories");
                this.g.a(cVar, fVar.g());
            }
            if (fVar.h() != null) {
                cVar.a("restingKiloCalories");
                this.h.a(cVar, fVar.h());
            }
            if (fVar.i() != null) {
                cVar.a("distance");
                this.i.a(cVar, fVar.i());
            }
            if (fVar.j() != null) {
                cVar.a("activeSeconds");
                this.j.a(cVar, fVar.j());
            }
            cVar.e();
        }

        public f a(com.google.b.d.a aVar) {
            aVar.c();
            long j = 0;
            long j2 = 0;
            int i = 0;
            String str = null;
            String str2 = null;
            Integer num = null;
            Integer num2 = null;
            Integer num3 = null;
            Integer num4 = null;
            Long l = null;
            while (aVar.e()) {
                String g = aVar.g();
                if (aVar.f() != b.NULL) {
                    Object obj = -1;
                    switch (g.hashCode()) {
                        case -1723599955:
                            if (g.equals("activeKiloCalories")) {
                                obj = 6;
                                break;
                            }
                            break;
                        case 100571:
                            if (g.equals("end")) {
                                obj = 1;
                                break;
                            }
                            break;
                        case 102727412:
                            if (g.equals("label")) {
                                obj = 3;
                                break;
                            }
                            break;
                        case 109757538:
                            if (g.equals("start")) {
                                obj = null;
                                break;
                            }
                            break;
                        case 109761319:
                            if (g.equals("steps")) {
                                obj = 5;
                                break;
                            }
                            break;
                        case 288459765:
                            if (g.equals("distance")) {
                                obj = 8;
                                break;
                            }
                            break;
                        case 438346805:
                            if (g.equals("restingKiloCalories")) {
                                obj = 7;
                                break;
                            }
                            break;
                        case 790663321:
                            if (g.equals("activeSeconds")) {
                                obj = 9;
                                break;
                            }
                            break;
                        case 1547859928:
                            if (g.equals("shortLabel")) {
                                obj = 4;
                                break;
                            }
                            break;
                        case 1601508110:
                            if (g.equals("startTimeZoneOffset")) {
                                obj = 2;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            j = ((Long) this.a.b(aVar)).longValue();
                            break;
                        case 1:
                            j2 = ((Long) this.b.b(aVar)).longValue();
                            break;
                        case 2:
                            i = ((Integer) this.c.b(aVar)).intValue();
                            break;
                        case 3:
                            str = (String) this.d.b(aVar);
                            break;
                        case 4:
                            str2 = (String) this.e.b(aVar);
                            break;
                        case 5:
                            num = (Integer) this.f.b(aVar);
                            break;
                        case 6:
                            num2 = (Integer) this.g.b(aVar);
                            break;
                        case 7:
                            num3 = (Integer) this.h.b(aVar);
                            break;
                        case 8:
                            num4 = (Integer) this.i.b(aVar);
                            break;
                        case 9:
                            l = (Long) this.j.b(aVar);
                            break;
                        default:
                            aVar.n();
                            break;
                    }
                }
                aVar.n();
            }
            aVar.d();
            return new h(j, j2, i, str, str2, num, num2, num3, num4, l);
        }
    }

    h(long j, long j2, int i, String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, Long l) {
        super(j, j2, i, str, str2, num, num2, num3, num4, l);
    }
}
