package com.google.a.g;

import com.google.a.a.j;
import com.google.a.b.ad;
import com.google.a.b.af;
import com.google.a.b.as;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

final class i {
    private static final com.google.a.a.e<Type, String> a = new com.google.a.a.e<Type, String>() {
        public /* synthetic */ Object apply(Object obj) {
            return a((Type) obj);
        }

        public String a(Type type) {
            return c.CURRENT.typeName(type);
        }
    };
    private static final com.google.a.a.f b = com.google.a.a.f.a(com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR).b("null");

    private enum a {
        OWNED_BY_ENCLOSING_CLASS {
            @Nullable
            Class<?> getOwnerType(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        },
        LOCAL_CLASS_HAS_NO_OWNER {
            @Nullable
            Class<?> getOwnerType(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        };
        
        static final a JVM_BEHAVIOR = null;

        class a<T> {
            a() {
            }
        }

        @Nullable
        abstract Class<?> getOwnerType(Class<?> cls);

        static {
            JVM_BEHAVIOR = detectJvmBehavior();
        }

        private static a detectJvmBehavior() {
            ParameterizedType parameterizedType = (ParameterizedType) new a<String>() {
            }.getClass().getGenericSuperclass();
            for (a aVar : values()) {
                if (aVar.getOwnerType(a.class) == parameterizedType.getOwnerType()) {
                    return aVar;
                }
            }
            throw new AssertionError();
        }
    }

    private static final class b implements Serializable, GenericArrayType {
        private final Type a;

        b(Type type) {
            this.a = c.CURRENT.usedInGenericType(type);
        }

        public Type getGenericComponentType() {
            return this.a;
        }

        public String toString() {
            return i.d(this.a) + "[]";
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof GenericArrayType)) {
                return false;
            }
            return com.google.a.a.g.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
        }
    }

    enum c {
        JAVA6 {
            GenericArrayType newArrayType(Type type) {
                return new b(type);
            }

            Type usedInGenericType(Type type) {
                com.google.a.a.h.a((Object) type);
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                if (cls.isArray()) {
                    return new b(cls.getComponentType());
                }
                return type;
            }
        },
        JAVA7 {
            Type newArrayType(Type type) {
                if (type instanceof Class) {
                    return i.a((Class) type);
                }
                return new b(type);
            }

            Type usedInGenericType(Type type) {
                return (Type) com.google.a.a.h.a((Object) type);
            }
        },
        JAVA8 {
            Type newArrayType(Type type) {
                return JAVA7.newArrayType(type);
            }

            Type usedInGenericType(Type type) {
                return JAVA7.usedInGenericType(type);
            }

            String typeName(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                } catch (NoSuchMethodException e) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (Throwable e2) {
                    throw new RuntimeException(e2);
                } catch (Throwable e22) {
                    throw new RuntimeException(e22);
                }
            }
        };
        
        static final c CURRENT = null;

        abstract Type newArrayType(Type type);

        abstract Type usedInGenericType(Type type);

        String typeName(Type type) {
            return i.d(type);
        }

        final ad<Type> usedInGenericType(Type[] typeArr) {
            com.google.a.b.ad.a i = ad.i();
            for (Type usedInGenericType : typeArr) {
                i.c(usedInGenericType(usedInGenericType));
            }
            return i.a();
        }
    }

    static final class d<X> {
        static final boolean a;

        d() {
        }

        static {
            boolean z = false;
            if (!d.class.getTypeParameters()[0].equals(i.a((GenericDeclaration) d.class, "X", new Type[0]))) {
                z = true;
            }
            a = z;
        }
    }

    private static final class e implements Serializable, ParameterizedType {
        private final Type a;
        private final ad<Type> b;
        private final Class<?> c;

        e(@Nullable Type type, Class<?> cls, Type[] typeArr) {
            com.google.a.a.h.a((Object) cls);
            com.google.a.a.h.a(typeArr.length == cls.getTypeParameters().length);
            i.b(typeArr, "type parameter");
            this.a = type;
            this.c = cls;
            this.b = c.CURRENT.usedInGenericType(typeArr);
        }

        public Type[] getActualTypeArguments() {
            return i.b(this.b);
        }

        public Type getRawType() {
            return this.c;
        }

        public Type getOwnerType() {
            return this.a;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (this.a != null) {
                stringBuilder.append(c.CURRENT.typeName(this.a)).append('.');
            }
            stringBuilder.append(this.c.getName()).append('<').append(i.b.a(as.a(this.b, i.a))).append('>');
            return stringBuilder.toString();
        }

        public int hashCode() {
            return ((this.a == null ? 0 : this.a.hashCode()) ^ this.b.hashCode()) ^ this.c.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (getRawType().equals(parameterizedType.getRawType()) && com.google.a.a.g.a(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
            return false;
        }
    }

    private static final class f<D extends GenericDeclaration> {
        private final D a;
        private final String b;
        private final ad<Type> c;

        f(D d, String str, Type[] typeArr) {
            i.b(typeArr, "bound for type variable");
            this.a = (GenericDeclaration) com.google.a.a.h.a((Object) d);
            this.b = (String) com.google.a.a.h.a((Object) str);
            this.c = ad.a((Object[]) typeArr);
        }

        public D a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public String toString() {
            return this.b;
        }

        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (d.a) {
                if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof g)) {
                    return false;
                }
                boolean z2;
                f a = ((g) Proxy.getInvocationHandler(obj)).b;
                if (this.b.equals(a.b()) && this.a.equals(a.a()) && this.c.equals(a.c)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                return z2;
            } else if (!(obj instanceof TypeVariable)) {
                return false;
            } else {
                TypeVariable typeVariable = (TypeVariable) obj;
                if (!(this.b.equals(typeVariable.getName()) && this.a.equals(typeVariable.getGenericDeclaration()))) {
                    z = false;
                }
                return z;
            }
        }
    }

    private static final class g implements InvocationHandler {
        private static final af<String, Method> a;
        private final f<?> b;

        static {
            com.google.a.b.af.a f = af.f();
            for (Method method : f.class.getMethods()) {
                if (method.getDeclaringClass().equals(f.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException e) {
                    }
                    f.a(method.getName(), method);
                }
            }
            a = f.a();
        }

        g(f<?> fVar) {
            this.b = fVar;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Method method2 = (Method) a.get(name);
            if (method2 == null) {
                throw new UnsupportedOperationException(name);
            }
            try {
                return method2.invoke(this.b, objArr);
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }
    }

    static final class h implements Serializable, WildcardType {
        private final ad<Type> a;
        private final ad<Type> b;

        h(Type[] typeArr, Type[] typeArr2) {
            i.b(typeArr, "lower bound for wildcard");
            i.b(typeArr2, "upper bound for wildcard");
            this.a = c.CURRENT.usedInGenericType(typeArr);
            this.b = c.CURRENT.usedInGenericType(typeArr2);
        }

        public Type[] getLowerBounds() {
            return i.b(this.a);
        }

        public Type[] getUpperBounds() {
            return i.b(this.b);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            if (this.a.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.b.equals(Arrays.asList(wildcardType.getUpperBounds()))) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("?");
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                stringBuilder.append(" super ").append(c.CURRENT.typeName((Type) it.next()));
            }
            for (Type typeName : i.b(this.b)) {
                stringBuilder.append(" extends ").append(c.CURRENT.typeName(typeName));
            }
            return stringBuilder.toString();
        }
    }

    static Type a(Type type) {
        boolean z = true;
        if (!(type instanceof WildcardType)) {
            return c.CURRENT.newArrayType(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        com.google.a.a.h.a(lowerBounds.length <= 1, (Object) "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return c(a(lowerBounds[0]));
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length != 1) {
            z = false;
        }
        com.google.a.a.h.a(z, (Object) "Wildcard should have only one upper bound.");
        return b(a(upperBounds[0]));
    }

    static ParameterizedType a(@Nullable Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return a((Class) cls, typeArr);
        }
        boolean z;
        com.google.a.a.h.a((Object) typeArr);
        if (cls.getEnclosingClass() != null) {
            z = true;
        } else {
            z = false;
        }
        com.google.a.a.h.a(z, "Owner type for unenclosed %s", cls);
        return new e(type, cls, typeArr);
    }

    static ParameterizedType a(Class<?> cls, Type... typeArr) {
        return new e(a.JVM_BEHAVIOR.getOwnerType(cls), cls, typeArr);
    }

    static <D extends GenericDeclaration> TypeVariable<D> a(D d, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return b(d, str, typeArr);
    }

    static WildcardType b(Type type) {
        return new h(new Type[0], new Type[]{type});
    }

    static WildcardType c(Type type) {
        return new h(new Type[]{type}, new Type[]{Object.class});
    }

    static String d(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    @Nullable
    static Type e(Type type) {
        com.google.a.a.h.a((Object) type);
        final AtomicReference atomicReference = new AtomicReference();
        new h() {
            void a(TypeVariable<?> typeVariable) {
                atomicReference.set(i.b(typeVariable.getBounds()));
            }

            void a(WildcardType wildcardType) {
                atomicReference.set(i.b(wildcardType.getUpperBounds()));
            }

            void a(GenericArrayType genericArrayType) {
                atomicReference.set(genericArrayType.getGenericComponentType());
            }

            void a(Class<?> cls) {
                atomicReference.set(cls.getComponentType());
            }
        }.a(type);
        return (Type) atomicReference.get();
    }

    @Nullable
    private static Type b(Type[] typeArr) {
        for (Type e : typeArr) {
            Type e2 = e(e2);
            if (e2 != null) {
                if (e2 instanceof Class) {
                    Class cls = (Class) e2;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return b(e2);
            }
        }
        return null;
    }

    private static <D extends GenericDeclaration> TypeVariable<D> b(D d, String str, Type[] typeArr) {
        return (TypeVariable) c.a(TypeVariable.class, new g(new f(d, str, typeArr)));
    }

    private static Type[] b(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[collection.size()]);
    }

    private static Iterable<Type> b(Iterable<Type> iterable) {
        return as.b(iterable, j.a(j.a((Object) Object.class)));
    }

    private static void b(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                boolean z;
                if (((Class) type).isPrimitive()) {
                    z = false;
                } else {
                    z = true;
                }
                com.google.a.a.h.a(z, "Primitive type '%s' used as %s", (Class) type, str);
            }
        }
    }

    static Class<?> a(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }
}
