package com.google.b.b.a;

import com.google.b.b.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.w;
import com.google.b.x;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class a<E> extends w<Object> {
    public static final x a = new x() {
        public <T> w<T> a(f fVar, com.google.b.c.a<T> aVar) {
            Type type = aVar.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            type = b.g(type);
            return new a(fVar, fVar.a(com.google.b.c.a.get(type)), b.e(type));
        }
    };
    private final Class<E> b;
    private final w<E> c;

    public a(f fVar, w<E> wVar, Class<E> cls) {
        this.c = new m(fVar, wVar, cls);
        this.b = cls;
    }

    public Object b(com.google.b.d.a aVar) {
        if (aVar.f() == com.google.b.d.b.NULL) {
            aVar.j();
            return null;
        }
        List arrayList = new ArrayList();
        aVar.a();
        while (aVar.e()) {
            arrayList.add(this.c.b(aVar));
        }
        aVar.b();
        Object newInstance = Array.newInstance(this.b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    public void a(c cVar, Object obj) {
        if (obj == null) {
            cVar.f();
            return;
        }
        cVar.b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.c.a(cVar, Array.get(obj, i));
        }
        cVar.c();
    }
}
