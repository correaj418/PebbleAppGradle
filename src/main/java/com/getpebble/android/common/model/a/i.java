package com.getpebble.android.common.model.a;

import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.w;

final class i extends c {

    public static final class a extends w<w> {
        private final w<Short> a;
        private final w<Short> b;
        private final w<Short> c;
        private final w<Short> d;
        private final w<Short> e;
        private final w<Short> f;

        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public a(f fVar) {
            this.a = fVar.a(Short.class);
            this.b = fVar.a(Short.class);
            this.c = fVar.a(Short.class);
            this.d = fVar.a(Short.class);
            this.e = fVar.a(Short.class);
            this.f = fVar.a(Short.class);
        }

        public void a(c cVar, w wVar) {
            cVar.d();
            cVar.a("resting_hr");
            this.a.a(cVar, Short.valueOf(wVar.a()));
            cVar.a("elevated_hr");
            this.b.a(cVar, Short.valueOf(wVar.b()));
            cVar.a("max_hr");
            this.c.a(cVar, Short.valueOf(wVar.c()));
            cVar.a("zone1_threshold");
            this.d.a(cVar, Short.valueOf(wVar.d()));
            cVar.a("zone2_threshold");
            this.e.a(cVar, Short.valueOf(wVar.e()));
            cVar.a("zone3_threshold");
            this.f.a(cVar, Short.valueOf(wVar.f()));
            cVar.e();
        }

        public w a(com.google.b.d.a aVar) {
            aVar.c();
            short s = (short) 0;
            short s2 = (short) 0;
            short s3 = (short) 0;
            short s4 = (short) 0;
            short s5 = (short) 0;
            short s6 = (short) 0;
            while (aVar.e()) {
                String g = aVar.g();
                if (aVar.f() != b.NULL) {
                    Object obj = -1;
                    switch (g.hashCode()) {
                        case -1550228645:
                            if (g.equals("resting_hr")) {
                                obj = null;
                                break;
                            }
                            break;
                        case -1494490766:
                            if (g.equals("zone2_threshold")) {
                                obj = 4;
                                break;
                            }
                            break;
                        case -1081138747:
                            if (g.equals("max_hr")) {
                                obj = 2;
                                break;
                            }
                            break;
                        case 82674111:
                            if (g.equals("elevated_hr")) {
                                obj = 1;
                                break;
                            }
                            break;
                        case 302460593:
                            if (g.equals("zone1_threshold")) {
                                obj = 3;
                                break;
                            }
                            break;
                        case 1003525171:
                            if (g.equals("zone3_threshold")) {
                                obj = 5;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            s6 = ((Short) this.a.b(aVar)).shortValue();
                            break;
                        case 1:
                            s5 = ((Short) this.b.b(aVar)).shortValue();
                            break;
                        case 2:
                            s4 = ((Short) this.c.b(aVar)).shortValue();
                            break;
                        case 3:
                            s3 = ((Short) this.d.b(aVar)).shortValue();
                            break;
                        case 4:
                            s2 = ((Short) this.e.b(aVar)).shortValue();
                            break;
                        case 5:
                            s = ((Short) this.f.b(aVar)).shortValue();
                            break;
                        default:
                            aVar.n();
                            break;
                    }
                }
                aVar.n();
            }
            aVar.d();
            return new i(s6, s5, s4, s3, s2, s);
        }
    }

    i(short s, short s2, short s3, short s4, short s5, short s6) {
        super(s, s2, s3, s4, s5, s6);
    }
}
