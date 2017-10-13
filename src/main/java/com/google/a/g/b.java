package com.google.a.g;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public abstract class b<T, R> extends a implements GenericDeclaration {

    static class a<T> extends b<T, T> {
        final Constructor<?> a;

        a(Constructor<?> constructor) {
            super(constructor);
            this.a = constructor;
        }

        Type[] b() {
            Type[] genericParameterTypes = this.a.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !c()) {
                return genericParameterTypes;
            }
            Class[] parameterTypes = this.a.getParameterTypes();
            if (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) {
                return (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
            }
            return genericParameterTypes;
        }

        public final TypeVariable<?>[] getTypeParameters() {
            Object typeParameters = getDeclaringClass().getTypeParameters();
            Object typeParameters2 = this.a.getTypeParameters();
            Object obj = new TypeVariable[(typeParameters.length + typeParameters2.length)];
            System.arraycopy(typeParameters, 0, obj, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, obj, typeParameters.length, typeParameters2.length);
            return obj;
        }

        private boolean c() {
            Class declaringClass = this.a.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            Method enclosingMethod = declaringClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                if (Modifier.isStatic(enclosingMethod.getModifiers())) {
                    return false;
                }
                return true;
            } else if (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) {
                return false;
            } else {
                return true;
            }
        }
    }

    static class b<T> extends b<T, Object> {
        final Method a;

        b(Method method) {
            super(method);
            this.a = method;
        }

        Type[] b() {
            return this.a.getGenericParameterTypes();
        }

        public final TypeVariable<?>[] getTypeParameters() {
            return this.a.getTypeParameters();
        }
    }

    abstract Type[] b();

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    <M extends AccessibleObject & Member> b(M m) {
        super(m);
    }

    public final Class<? super T> getDeclaringClass() {
        return super.getDeclaringClass();
    }

    public g<T> a() {
        return g.of(getDeclaringClass());
    }
}
