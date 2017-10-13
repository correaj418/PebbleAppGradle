package com.getpebble.android.main.sections.mypebble.d.a;

import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.w;

final class l extends e {

    public static final class a extends w<p> {
        private final w<Long> a;
        private final w<Long> b;
        private final w<String> c;
        private final w<String> d;
        private final w<Integer> e;
        private final w<Integer> f;
        private final w<Integer> g;

        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public a(f fVar) {
            this.a = fVar.a(Long.class);
            this.b = fVar.a(Long.class);
            this.c = fVar.a(String.class);
            this.d = fVar.a(String.class);
            this.e = fVar.a(Integer.class);
            this.f = fVar.a(Integer.class);
            this.g = fVar.a(Integer.class);
        }

        public void a(c cVar, p pVar) {
            cVar.d();
            cVar.a("start");
            this.a.a(cVar, Long.valueOf(pVar.a()));
            cVar.a("end");
            this.b.a(cVar, Long.valueOf(pVar.b()));
            if (pVar.c() != null) {
                cVar.a("label");
                this.c.a(cVar, pVar.c());
            }
            if (pVar.d() != null) {
                cVar.a("shortLabel");
                this.d.a(cVar, pVar.d());
            }
            if (pVar.e() != null) {
                cVar.a("minutesInZone1");
                this.e.a(cVar, pVar.e());
            }
            if (pVar.f() != null) {
                cVar.a("minutesInZone2");
                this.f.a(cVar, pVar.f());
            }
            if (pVar.g() != null) {
                cVar.a("minutesInZone3");
                this.g.a(cVar, pVar.g());
            }
            cVar.e();
        }

        public p a(com.google.b.d.a aVar) {
            long j = 0;
            Integer num = null;
            aVar.c();
            Integer num2 = null;
            Integer num3 = null;
            String str = null;
            String str2 = null;
            long j2 = 0;
            while (aVar.e()) {
                String g = aVar.g();
                if (aVar.f() != b.NULL) {
                    Object obj = -1;
                    switch (g.hashCode()) {
                        case 100571:
                            if (g.equals("end")) {
                                obj = 1;
                                break;
                            }
                            break;
                        case 102727412:
                            if (g.equals("label")) {
                                obj = 2;
                                break;
                            }
                            break;
                        case 109757538:
                            if (g.equals("start")) {
                                obj = null;
                                break;
                            }
                            break;
                        case 184145409:
                            if (g.equals("minutesInZone1")) {
                                obj = 4;
                                break;
                            }
                            break;
                        case 184145410:
                            if (g.equals("minutesInZone2")) {
                                obj = 5;
                                break;
                            }
                            break;
                        case 184145411:
                            if (g.equals("minutesInZone3")) {
                                obj = 6;
                                break;
                            }
                            break;
                        case 1547859928:
                            if (g.equals("shortLabel")) {
                                obj = 3;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            j2 = ((Long) this.a.b(aVar)).longValue();
                            break;
                        case 1:
                            j = ((Long) this.b.b(aVar)).longValue();
                            break;
                        case 2:
                            str2 = (String) this.c.b(aVar);
                            break;
                        case 3:
                            str = (String) this.d.b(aVar);
                            break;
                        case 4:
                            num3 = (Integer) this.e.b(aVar);
                            break;
                        case 5:
                            num2 = (Integer) this.f.b(aVar);
                            break;
                        case 6:
                            num = (Integer) this.g.b(aVar);
                            break;
                        default:
                            aVar.n();
                            break;
                    }
                }
                aVar.n();
            }
            aVar.d();
            return new l(j2, j, str2, str, num3, num2, num);
        }
    }

    l(long j, long j2, String str, String str2, Integer num, Integer num2, Integer num3) {
        super(j, j2, str, str2, num, num2, num3);
    }
}
