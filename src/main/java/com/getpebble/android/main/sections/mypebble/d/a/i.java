package com.getpebble.android.main.sections.mypebble.d.a;

import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.w;

final class i extends b {

    public static final class a extends w<g> {
        private final w<Long> a;
        private final w<Long> b;
        private final w<Integer> c;
        private final w<Integer> d;
        private final w<Integer> e;

        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public a(f fVar) {
            this.a = fVar.a(Long.class);
            this.b = fVar.a(Long.class);
            this.c = fVar.a(Integer.class);
            this.d = fVar.a(Integer.class);
            this.e = fVar.a(Integer.class);
        }

        public void a(c cVar, g gVar) {
            cVar.d();
            cVar.a("start");
            this.a.a(cVar, Long.valueOf(gVar.a()));
            cVar.a("end");
            this.b.a(cVar, Long.valueOf(gVar.b()));
            cVar.a("beatsPerMinute");
            this.c.a(cVar, Integer.valueOf(gVar.c()));
            if (gVar.d() != null) {
                cVar.a("qualityWeight");
                this.d.a(cVar, gVar.d());
            }
            if (gVar.e() != null) {
                cVar.a("vmc");
                this.e.a(cVar, gVar.e());
            }
            cVar.e();
        }

        public g a(com.google.b.d.a aVar) {
            long j = 0;
            Integer num = null;
            aVar.c();
            Integer num2 = null;
            int i = 0;
            long j2 = 0;
            while (aVar.e()) {
                String g = aVar.g();
                if (aVar.f() != b.NULL) {
                    Object obj = -1;
                    switch (g.hashCode()) {
                        case -1026821033:
                            if (g.equals("qualityWeight")) {
                                obj = 3;
                                break;
                            }
                            break;
                        case 100571:
                            if (g.equals("end")) {
                                obj = 1;
                                break;
                            }
                            break;
                        case 116876:
                            if (g.equals("vmc")) {
                                obj = 4;
                                break;
                            }
                            break;
                        case 109757538:
                            if (g.equals("start")) {
                                obj = null;
                                break;
                            }
                            break;
                        case 413635220:
                            if (g.equals("beatsPerMinute")) {
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
                            num2 = (Integer) this.d.b(aVar);
                            break;
                        case 4:
                            num = (Integer) this.e.b(aVar);
                            break;
                        default:
                            aVar.n();
                            break;
                    }
                }
                aVar.n();
            }
            aVar.d();
            return new i(j2, j, i, num2, num);
        }
    }

    i(long j, long j2, int i, Integer num, Integer num2) {
        super(j, j2, i, num, num2);
    }
}
