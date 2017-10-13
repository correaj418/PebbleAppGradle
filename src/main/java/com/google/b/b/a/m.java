package com.google.b.b.a;

import com.google.b.d.a;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.w;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class m<T> extends w<T> {
    private final f a;
    private final w<T> b;
    private final Type c;

    m(f fVar, w<T> wVar, Type type) {
        this.a = fVar;
        this.b = wVar;
        this.c = type;
    }

    public T b(a aVar) {
        return this.b.b(aVar);
    }

    public void a(c cVar, T t) {
        w wVar = this.b;
        Type a = a(this.c, (Object) t);
        if (a != this.c) {
            wVar = this.a.a(com.google.b.c.a.get(a));
            if ((wVar instanceof i.a) && !(this.b instanceof i.a)) {
                wVar = this.b;
            }
        }
        wVar.a(cVar, t);
    }

    private Type a(Type type, Object obj) {
        if (obj == null) {
            return type;
        }
        if (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) {
            return obj.getClass();
        }
        return type;
    }
}
