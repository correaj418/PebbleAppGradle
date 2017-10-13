package com.google.b.c;

import com.getpebble.android.framework.timeline.e;
import com.google.b.b.b;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class a<T> {
    final int hashCode;
    final Class<? super T> rawType;
    final Type type;

    protected a() {
        this.type = getSuperclassTypeParameter(getClass());
        this.rawType = b.e(this.type);
        this.hashCode = this.type.hashCode();
    }

    a(Type type) {
        this.type = b.d((Type) com.google.b.b.a.a((Object) type));
        this.rawType = b.e(this.type);
        this.hashCode = this.type.hashCode();
    }

    static Type getSuperclassTypeParameter(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return b.d(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> cls) {
        return isAssignableFrom((Type) cls);
    }

    @Deprecated
    public boolean isAssignableFrom(Type type) {
        if (type == null) {
            return false;
        }
        if (this.type.equals(type)) {
            return true;
        }
        if (this.type instanceof Class) {
            return this.rawType.isAssignableFrom(b.e(type));
        }
        if (this.type instanceof ParameterizedType) {
            return isAssignableFrom(type, (ParameterizedType) this.type, new HashMap());
        }
        if (this.type instanceof GenericArrayType) {
            boolean z = this.rawType.isAssignableFrom(b.e(type)) && isAssignableFrom(type, (GenericArrayType) this.type);
            return z;
        }
        throw buildUnexpectedTypeError(this.type, Class.class, ParameterizedType.class, GenericArrayType.class);
    }

    @Deprecated
    public boolean isAssignableFrom(a<?> aVar) {
        return isAssignableFrom(aVar.getType());
    }

    private static boolean isAssignableFrom(Type type, GenericArrayType genericArrayType) {
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (!(genericComponentType instanceof ParameterizedType)) {
            return true;
        }
        if (type instanceof GenericArrayType) {
            type = ((GenericArrayType) type).getGenericComponentType();
        } else if (type instanceof Class) {
            type = (Class) type;
            while (type.isArray()) {
                type = type.getComponentType();
            }
        }
        return isAssignableFrom(type, (ParameterizedType) genericComponentType, new HashMap());
    }

    private static boolean isAssignableFrom(Type type, ParameterizedType parameterizedType, Map<String, Type> map) {
        int i = 0;
        if (type == null) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        int i2;
        Class e = b.e(type);
        if (type instanceof ParameterizedType) {
            type = (ParameterizedType) type;
        } else {
            type = null;
        }
        if (type != null) {
            Type[] actualTypeArguments = type.getActualTypeArguments();
            TypeVariable[] typeParameters = e.getTypeParameters();
            for (i2 = 0; i2 < actualTypeArguments.length; i2++) {
                Object obj = actualTypeArguments[i2];
                TypeVariable typeVariable = typeParameters[i2];
                while (obj instanceof TypeVariable) {
                    Type type2 = (Type) map.get(((TypeVariable) obj).getName());
                }
                map.put(typeVariable.getName(), obj);
            }
            if (typeEquals(type, parameterizedType, map)) {
                return true;
            }
        }
        Type[] genericInterfaces = e.getGenericInterfaces();
        i2 = genericInterfaces.length;
        while (i < i2) {
            if (isAssignableFrom(genericInterfaces[i], parameterizedType, new HashMap(map))) {
                return true;
            }
            i++;
        }
        return isAssignableFrom(e.getGenericSuperclass(), parameterizedType, new HashMap(map));
    }

    private static boolean typeEquals(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, Map<String, Type> map) {
        if (!parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
            return false;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            if (!matches(actualTypeArguments[i], actualTypeArguments2[i], map)) {
                return false;
            }
        }
        return true;
    }

    private static AssertionError buildUnexpectedTypeError(Type type, Class<?>... clsArr) {
        StringBuilder stringBuilder = new StringBuilder("Unexpected type. Expected one of: ");
        for (Class name : clsArr) {
            stringBuilder.append(name.getName()).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
        }
        stringBuilder.append("but got: ").append(type.getClass().getName()).append(", for type token: ").append(type.toString()).append('.');
        return new AssertionError(stringBuilder.toString());
    }

    private static boolean matches(Type type, Type type2, Map<String, Type> map) {
        return type2.equals(type) || ((type instanceof TypeVariable) && type2.equals(map.get(((TypeVariable) type).getName())));
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.a(this.type, ((a) obj).type);
    }

    public final String toString() {
        return b.f(this.type);
    }

    public static a<?> get(Type type) {
        return new a(type);
    }

    public static <T> a<T> get(Class<T> cls) {
        return new a(cls);
    }
}
