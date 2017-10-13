package com.getpebble.android.common.framework.b;

import com.getpebble.android.common.framework.b.m.i;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.w;

final class k extends e {

    public static final class a extends w<i> {
        private final w<Integer> a;
        private final w<Integer> b;
        private final w<Integer> c;
        private final w<Integer> d;

        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public a(f fVar) {
            this.a = fVar.a(Integer.class);
            this.b = fVar.a(Integer.class);
            this.c = fVar.a(Integer.class);
            this.d = fVar.a(Integer.class);
        }

        public void a(c cVar, i iVar) {
            cVar.d();
            if (iVar.a() != null) {
                cVar.a("sleepDuration");
                this.a.a(cVar, iVar.a());
            }
            if (iVar.b() != null) {
                cVar.a("deepSleepDuration");
                this.b.a(cVar, iVar.b());
            }
            if (iVar.c() != null) {
                cVar.a("fallAsleepTime");
                this.c.a(cVar, iVar.c());
            }
            if (iVar.d() != null) {
                cVar.a("wakeUpTime");
                this.d.a(cVar, iVar.d());
            }
            cVar.e();
        }

        public i a(com.google.b.d.a aVar) {
            Integer num = null;
            aVar.c();
            Integer num2 = null;
            Integer num3 = null;
            Integer num4 = null;
            while (aVar.e()) {
                String g = aVar.g();
                if (aVar.f() == b.NULL) {
                    aVar.n();
                } else {
                    Integer num5;
                    Object obj = -1;
                    switch (g.hashCode()) {
                        case -1654471988:
                            if (g.equals("wakeUpTime")) {
                                obj = 3;
                                break;
                            }
                            break;
                        case -483349505:
                            if (g.equals("deepSleepDuration")) {
                                obj = 1;
                                break;
                            }
                            break;
                        case -300869237:
                            if (g.equals("sleepDuration")) {
                                obj = null;
                                break;
                            }
                            break;
                        case 1934910686:
                            if (g.equals("fallAsleepTime")) {
                                obj = 2;
                                break;
                            }
                            break;
                    }
                    Integer num6;
                    switch (obj) {
                        case null:
                            num6 = num;
                            num = num2;
                            num2 = num3;
                            num3 = (Integer) this.a.b(aVar);
                            num5 = num6;
                            break;
                        case 1:
                            num3 = num4;
                            num6 = num2;
                            num2 = (Integer) this.b.b(aVar);
                            num5 = num;
                            num = num6;
                            break;
                        case 2:
                            num2 = num3;
                            num3 = num4;
                            num6 = num;
                            num = (Integer) this.c.b(aVar);
                            num5 = num6;
                            break;
                        case 3:
                            num5 = (Integer) this.d.b(aVar);
                            num = num2;
                            num2 = num3;
                            num3 = num4;
                            break;
                        default:
                            aVar.n();
                            num5 = num;
                            num = num2;
                            num2 = num3;
                            num3 = num4;
                            break;
                    }
                    num4 = num3;
                    num3 = num2;
                    num2 = num;
                    num = num5;
                }
            }
            aVar.d();
            return new k(num4, num3, num2, num);
        }
    }

    k(Integer num, Integer num2, Integer num3, Integer num4) {
        super(num, num2, num3, num4);
    }
}
