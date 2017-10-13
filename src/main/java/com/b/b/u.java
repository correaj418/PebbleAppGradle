package com.b.b;

import android.content.Context;
import com.b.a.b.e;
import com.b.a.b.f;
import com.b.a.c.d;
import com.b.a.m;
import com.b.b.a.b;
import java.lang.reflect.Type;

public interface u {

    public static class a {
        m a;
        long b;
        y c;
        h d;
        d e;

        public a(m mVar, long j, y yVar, h hVar, d dVar) {
            this.b = j;
            this.a = mVar;
            this.c = yVar;
            this.d = hVar;
            this.e = dVar;
        }

        public m a() {
            return this.a;
        }

        public long b() {
            return this.b;
        }

        public y c() {
            return this.c;
        }

        public h d() {
            return this.d;
        }

        public d e() {
            return this.e;
        }
    }

    e<d> a(Context context, j jVar, d dVar);

    e<b> a(Context context, j jVar, String str, String str2, int i, int i2, boolean z);

    e<m> a(j jVar, d dVar, f<a> fVar);

    <T> com.b.b.e.b<T> a(j jVar, d dVar, Type type);
}
