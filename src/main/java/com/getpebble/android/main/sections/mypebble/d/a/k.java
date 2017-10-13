package com.getpebble.android.main.sections.mypebble.d.a;

import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.w;

final class k extends d {

    public static final class a extends w<n> {
        private final w<Long> a;
        private final w<Long> b;
        private final w<Integer> c;
        private final w<String> d;
        private final w<String> e;
        private final w<Integer> f;
        private final w<Integer> g;

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
        }

        public void a(c cVar, n nVar) {
            cVar.d();
            cVar.a("start");
            this.a.a(cVar, Long.valueOf(nVar.a()));
            cVar.a("end");
            this.b.a(cVar, Long.valueOf(nVar.b()));
            cVar.a("startTimeZoneOffset");
            this.c.a(cVar, Integer.valueOf(nVar.c()));
            if (nVar.d() != null) {
                cVar.a("label");
                this.d.a(cVar, nVar.d());
            }
            if (nVar.e() != null) {
                cVar.a("shortLabel");
                this.e.a(cVar, nVar.e());
            }
            if (nVar.f() != null) {
                cVar.a("heartRate");
                this.f.a(cVar, nVar.f());
            }
            if (nVar.g() != null) {
                cVar.a("qualityWeight");
                this.g.a(cVar, nVar.g());
            }
            cVar.e();
        }

        public n a(com.google.b.d.a aVar) {
            long j = 0;
            Integer num = null;
            aVar.c();
            Integer num2 = null;
            String str = null;
            String str2 = null;
            int i = 0;
            long j2 = 0;
            while (aVar.e()) {
                String g = aVar.g();
                if (aVar.f() != b.NULL) {
                    Object obj = -1;
                    switch (g.hashCode()) {
                        case -1026821033:
                            if (g.equals("qualityWeight")) {
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
                        case 200416838:
                            if (g.equals("heartRate")) {
                                obj = 5;
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
                            j2 = ((Long) this.a.b(aVar)).longValue();
                            break;
                        case 1:
                            j = ((Long) this.b.b(aVar)).longValue();
                            break;
                        case 2:
                            i = ((Integer) this.c.b(aVar)).intValue();
                            break;
                        case 3:
                            str2 = (String) this.d.b(aVar);
                            break;
                        case 4:
                            str = (String) this.e.b(aVar);
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
            return new k(j2, j, i, str2, str, num2, num);
        }
    }

    k(long j, long j2, int i, String str, String str2, Integer num, Integer num2) {
        super(j, j2, i, str, str2, num, num2);
    }
}
