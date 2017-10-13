package com.google.b.b.a;

import com.google.b.b.g;
import com.google.b.c.a;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.w;
import com.google.b.x;
import java.util.ArrayList;
import java.util.List;

public final class h extends w<Object> {
    public static final x a = new x() {
        public <T> w<T> a(f fVar, a<T> aVar) {
            if (aVar.getRawType() == Object.class) {
                return new h(fVar);
            }
            return null;
        }
    };
    private final f b;

    h(f fVar) {
        this.b = fVar;
    }

    public Object b(com.google.b.d.a aVar) {
        switch (aVar.f()) {
            case BEGIN_ARRAY:
                List arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(b(aVar));
                }
                aVar.b();
                return arrayList;
            case BEGIN_OBJECT:
                Object gVar = new g();
                aVar.c();
                while (aVar.e()) {
                    gVar.put(aVar.g(), b(aVar));
                }
                aVar.d();
                return gVar;
            case STRING:
                return aVar.h();
            case NUMBER:
                return Double.valueOf(aVar.k());
            case BOOLEAN:
                return Boolean.valueOf(aVar.i());
            case NULL:
                aVar.j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    public void a(c cVar, Object obj) {
        if (obj == null) {
            cVar.f();
            return;
        }
        w a = this.b.a(obj.getClass());
        if (a instanceof h) {
            cVar.d();
            cVar.e();
            return;
        }
        a.a(cVar, obj);
    }
}
