package com.getpebble.android.common.framework.b;

import com.getpebble.android.common.framework.b.m.h;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.w;

final class j extends d {

    public static final class a extends w<h> {
        private final w<Integer> a;
        private final w<Integer> b;

        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public a(f fVar) {
            this.a = fVar.a(Integer.class);
            this.b = fVar.a(Integer.class);
        }

        public void a(c cVar, h hVar) {
            cVar.d();
            cVar.a("start");
            this.a.a(cVar, Integer.valueOf(hVar.a()));
            cVar.a("end");
            this.b.a(cVar, Integer.valueOf(hVar.b()));
            cVar.e();
        }

        public h a(com.google.b.d.a aVar) {
            aVar.c();
            int i = 0;
            int i2 = 0;
            while (aVar.e()) {
                String g = aVar.g();
                if (aVar.f() == b.NULL) {
                    aVar.n();
                } else {
                    int i3;
                    Object obj = -1;
                    switch (g.hashCode()) {
                        case 100571:
                            if (g.equals("end")) {
                                obj = 1;
                                break;
                            }
                            break;
                        case 109757538:
                            if (g.equals("start")) {
                                obj = null;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            i3 = i;
                            i = ((Integer) this.a.b(aVar)).intValue();
                            break;
                        case 1:
                            i3 = ((Integer) this.b.b(aVar)).intValue();
                            i = i2;
                            break;
                        default:
                            aVar.n();
                            i3 = i;
                            i = i2;
                            break;
                    }
                    i2 = i;
                    i = i3;
                }
            }
            aVar.d();
            return new j(i2, i);
        }
    }

    j(int i, int i2) {
        super(i, i2);
    }
}
