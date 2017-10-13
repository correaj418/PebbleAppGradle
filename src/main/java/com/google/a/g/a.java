package com.google.a.g;

import com.google.a.a.h;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import javax.annotation.Nullable;

class a extends AccessibleObject implements Member {
    private final AccessibleObject a;
    private final Member b;

    <M extends AccessibleObject & Member> a(M m) {
        h.a((Object) m);
        this.a = m;
        this.b = (Member) m;
    }

    public g<?> a() {
        return g.of(getDeclaringClass());
    }

    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.a.isAnnotationPresent(cls);
    }

    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this.a.getAnnotation(cls);
    }

    public final Annotation[] getAnnotations() {
        return this.a.getAnnotations();
    }

    public final Annotation[] getDeclaredAnnotations() {
        return this.a.getDeclaredAnnotations();
    }

    public final void setAccessible(boolean z) {
        this.a.setAccessible(z);
    }

    public final boolean isAccessible() {
        return this.a.isAccessible();
    }

    public Class<?> getDeclaringClass() {
        return this.b.getDeclaringClass();
    }

    public final String getName() {
        return this.b.getName();
    }

    public final int getModifiers() {
        return this.b.getModifiers();
    }

    public final boolean isSynthetic() {
        return this.b.isSynthetic();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (a().equals(aVar.a()) && this.b.equals(aVar.b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return this.b.toString();
    }
}
