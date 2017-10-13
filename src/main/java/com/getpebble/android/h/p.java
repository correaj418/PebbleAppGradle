package com.getpebble.android.h;

import com.getpebble.android.common.model.b.b;
import com.google.b.f;
import com.google.b.g;
import com.google.b.j;
import com.google.b.l;
import com.google.b.o;
import java.io.BufferedReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;

public class p {
    private static final f a = new g().a(b.a()).c();
    private static final f b = new g().b().c();

    public static f a() {
        return a;
    }

    public static <T> T a(String str, Type type) {
        try {
            return a.a(str, type);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> T a(String str, Class<T> cls) {
        return a(str, (Class) cls, a);
    }

    public static <T> T a(BufferedReader bufferedReader, Class<T> cls) {
        try {
            return a.a((Reader) bufferedReader, (Class) cls);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> T a(o oVar, Class<T> cls) {
        return a(oVar, (Class) cls, a);
    }

    public static <T> T a(String str, Class<T> cls, f fVar) {
        try {
            return fVar.a(str, (Class) cls);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> T a(o oVar, Class<T> cls, f fVar) {
        try {
            return fVar.a((l) oVar, (Class) cls);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String a(Object obj) {
        return a.b(obj);
    }

    public static l b(Object obj) {
        return a.a(obj);
    }

    public static <T> T a(Map<String, Class<? extends T>> map, String str, String str2, l lVar, j jVar) {
        if (lVar.i()) {
            o l = lVar.l();
            return jVar.a(l.b(str2), (Class) map.get(l.b(str).c()));
        }
        throw new com.google.b.p("Unexpected JSON: " + lVar.toString());
    }
}
