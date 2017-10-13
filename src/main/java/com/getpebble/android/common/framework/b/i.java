package com.getpebble.android.common.framework.b;

import com.getpebble.android.common.framework.b.m.f;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.w;

final class i extends c {

    public static final class a extends w<f> {
        private final w<Integer> a;
        private final w<Integer> b;
        private final w<Integer> c;
        private final w<Integer> d;
        private final w<Integer> e;

        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public a(com.google.b.f fVar) {
            this.a = fVar.a(Integer.class);
            this.b = fVar.a(Integer.class);
            this.c = fVar.a(Integer.class);
            this.d = fVar.a(Integer.class);
            this.e = fVar.a(Integer.class);
        }

        public void a(c cVar, f fVar) {
            cVar.d();
            cVar.a("lastProcessedAt");
            this.a.a(cVar, Integer.valueOf(fVar.a()));
            cVar.a("sleepDuration");
            this.b.a(cVar, Integer.valueOf(fVar.b()));
            cVar.a("deepSleepDuration");
            this.c.a(cVar, Integer.valueOf(fVar.c()));
            cVar.a("fallAsleepTime");
            this.d.a(cVar, Integer.valueOf(fVar.d()));
            cVar.a("wakeUpTime");
            this.e.a(cVar, Integer.valueOf(fVar.e()));
            cVar.e();
        }

        public f a(com.google.b.d.a aVar) {
            aVar.c();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
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
                        case -1654471988:
                            if (g.equals("wakeUpTime")) {
                                obj = 4;
                                break;
                            }
                            break;
                        case -483349505:
                            if (g.equals("deepSleepDuration")) {
                                obj = 2;
                                break;
                            }
                            break;
                        case -300869237:
                            if (g.equals("sleepDuration")) {
                                obj = 1;
                                break;
                            }
                            break;
                        case 1934910686:
                            if (g.equals("fallAsleepTime")) {
                                obj = 3;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            i5 = ((Integer) this.a.b(aVar)).intValue();
                            break;
                        case 1:
                            i4 = ((Integer) this.b.b(aVar)).intValue();
                            break;
                        case 2:
                            i3 = ((Integer) this.c.b(aVar)).intValue();
                            break;
                        case 3:
                            i2 = ((Integer) this.d.b(aVar)).intValue();
                            break;
                        case 4:
                            i = ((Integer) this.e.b(aVar)).intValue();
                            break;
                        default:
                            aVar.n();
                            break;
                    }
                }
                aVar.n();
            }
            aVar.d();
            return new i(i5, i4, i3, i2, i);
        }
    }

    i(int i, int i2, int i3, int i4, int i5) {
        super(i, i2, i3, i4, i5);
    }
}
