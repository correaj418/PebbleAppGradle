package com.getpebble.android.main.sections.mypebble.d.a;

import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.w;

final class j extends c {

    public static final class a extends w<m> {
        private final w<Long> a;
        private final w<Long> b;
        private final w<Integer> c;
        private final w<String> d;
        private final w<String> e;
        private final w<Integer> f;
        private final w<Integer> g;
        private final w<Integer> h;
        private final w<Long> i;

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
            this.i = fVar.a(Long.class);
        }

        public void a(c cVar, m mVar) {
            cVar.d();
            cVar.a("start");
            this.a.a(cVar, Long.valueOf(mVar.a()));
            cVar.a("end");
            this.b.a(cVar, Long.valueOf(mVar.b()));
            cVar.a("startTimeZoneOffset");
            this.c.a(cVar, Integer.valueOf(mVar.c()));
            if (mVar.d() != null) {
                cVar.a("label");
                this.d.a(cVar, mVar.d());
            }
            if (mVar.e() != null) {
                cVar.a("shortLabel");
                this.e.a(cVar, mVar.e());
            }
            if (mVar.f() != null) {
                cVar.a("steps");
                this.f.a(cVar, mVar.f());
            }
            if (mVar.g() != null) {
                cVar.a("calories");
                this.g.a(cVar, mVar.g());
            }
            if (mVar.h() != null) {
                cVar.a("distance");
                this.h.a(cVar, mVar.h());
            }
            if (mVar.i() != null) {
                cVar.a("activeTime");
                this.i.a(cVar, mVar.i());
            }
            cVar.e();
        }

        public m a(com.google.b.d.a aVar) {
            aVar.c();
            long j = 0;
            long j2 = 0;
            int i = 0;
            String str = null;
            String str2 = null;
            Integer num = null;
            Integer num2 = null;
            Integer num3 = null;
            Long l = null;
            while (aVar.e()) {
                String g = aVar.g();
                if (aVar.f() != b.NULL) {
                    Object obj = -1;
                    switch (g.hashCode()) {
                        case -168965370:
                            if (g.equals("calories")) {
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
                                obj = 7;
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
                        case 2043958003:
                            if (g.equals("activeTime")) {
                                obj = 8;
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
                            l = (Long) this.i.b(aVar);
                            break;
                        default:
                            aVar.n();
                            break;
                    }
                }
                aVar.n();
            }
            aVar.d();
            return new j(j, j2, i, str, str2, num, num2, num3, l);
        }
    }

    j(long j, long j2, int i, String str, String str2, Integer num, Integer num2, Integer num3, Long l) {
        super(j, j2, i, str, str2, num, num2, num3, l);
    }
}
