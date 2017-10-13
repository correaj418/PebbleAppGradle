package com.google.a.g;

import com.google.a.a.f;
import com.google.a.a.h;
import com.google.a.a.i;
import com.google.a.b.ad;
import com.google.a.b.af;
import com.google.a.b.am;
import com.google.a.b.ay;
import com.google.a.b.bg;
import com.google.a.b.r;
import com.google.a.b.u;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

public abstract class g<T> extends d<T> implements Serializable {
    private final Type runtimeType;
    private transient f typeResolver;

    private static class a {
        private final Type[] a;
        private final boolean b;

        a(Type[] typeArr, boolean z) {
            this.a = typeArr;
            this.b = z;
        }

        boolean a(Type type) {
            for (Type of : this.a) {
                if (g.of(of).isSubtypeOf(type) == this.b) {
                    return this.b;
                }
            }
            if (this.b) {
                return false;
            }
            return true;
        }

        boolean b(Type type) {
            g of = g.of(type);
            for (Type isSubtypeOf : this.a) {
                if (of.isSubtypeOf(isSubtypeOf) == this.b) {
                    return this.b;
                }
            }
            if (this.b) {
                return false;
            }
            return true;
        }
    }

    private static final class b<T> extends g<T> {
        b(Type type) {
            super(type);
        }
    }

    private static abstract class c<K> {
        static final c<g<?>> a = new c<g<?>>() {
            /* synthetic */ Class b(Object obj) {
                return a((g) obj);
            }

            /* synthetic */ Iterable c(Object obj) {
                return b((g) obj);
            }

            /* synthetic */ Object d(Object obj) {
                return c((g) obj);
            }

            Class<?> a(g<?> gVar) {
                return gVar.getRawType();
            }

            Iterable<? extends g<?>> b(g<?> gVar) {
                return gVar.getGenericInterfaces();
            }

            @Nullable
            g<?> c(g<?> gVar) {
                return gVar.getGenericSuperclass();
            }
        };
        static final c<Class<?>> b = new c<Class<?>>() {
            /* synthetic */ Class b(Object obj) {
                return a((Class) obj);
            }

            /* synthetic */ Iterable c(Object obj) {
                return b((Class) obj);
            }

            /* synthetic */ Object d(Object obj) {
                return c((Class) obj);
            }

            Class<?> a(Class<?> cls) {
                return cls;
            }

            Iterable<? extends Class<?>> b(Class<?> cls) {
                return Arrays.asList(cls.getInterfaces());
            }

            @Nullable
            Class<?> c(Class<?> cls) {
                return cls.getSuperclass();
            }
        };

        abstract Class<?> b(K k);

        abstract Iterable<? extends K> c(K k);

        @Nullable
        abstract K d(K k);

        private c() {
        }

        final ad<K> a(K k) {
            return a(ad.a((Object) k));
        }

        ad<K> a(Iterable<? extends K> iterable) {
            Map c = ay.c();
            for (Object a : iterable) {
                a(a, c);
            }
            return a(c, bg.b().a());
        }

        private int a(K k, Map<? super K, Integer> map) {
            Integer num = (Integer) map.get(this);
            if (num != null) {
                return num.intValue();
            }
            int i = b(k).isInterface() ? 1 : 0;
            for (Object a : c(k)) {
                i = Math.max(i, a(a, (Map) map));
            }
            Object d = d(k);
            if (d != null) {
                i = Math.max(i, a(d, (Map) map));
            }
            map.put(k, Integer.valueOf(i + 1));
            return i + 1;
        }

        private static <K, V> ad<K> a(final Map<K, V> map, final Comparator<? super V> comparator) {
            return new bg<K>() {
                public int compare(K k, K k2) {
                    return comparator.compare(map.get(k), map.get(k2));
                }
            }.a(map.keySet());
        }
    }

    private enum d implements i<g<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD {
            public boolean apply(g<?> gVar) {
                return ((gVar.runtimeType instanceof TypeVariable) || (gVar.runtimeType instanceof WildcardType)) ? false : true;
            }
        },
        INTERFACE_ONLY {
            public boolean apply(g<?> gVar) {
                return gVar.getRawType().isInterface();
            }
        }
    }

    public class e extends u<g<? super T>> implements Serializable {
        final /* synthetic */ g a;
        private transient am<g<? super T>> b;

        protected /* synthetic */ Collection a() {
            return c();
        }

        protected /* synthetic */ Object b() {
            return c();
        }

        e(g gVar) {
            this.a = gVar;
        }

        protected Set<g<? super T>> c() {
            Set<g<? super T>> set = this.b;
            if (set != null) {
                return set;
            }
            Set a = r.a(c.a.a(this.a)).a(d.IGNORE_TYPE_VARIABLE_OR_WILDCARD).a();
            this.b = a;
            return a;
        }
    }

    protected g() {
        this.runtimeType = capture();
        h.b(!(this.runtimeType instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", this.runtimeType);
    }

    protected g(Class<?> cls) {
        Type capture = super.capture();
        if (capture instanceof Class) {
            this.runtimeType = capture;
        } else {
            this.runtimeType = of((Class) cls).resolveType(capture).runtimeType;
        }
    }

    private g(Type type) {
        this.runtimeType = (Type) h.a((Object) type);
    }

    public static <T> g<T> of(Class<T> cls) {
        return new b(cls);
    }

    public static g<?> of(Type type) {
        return new b(type);
    }

    public final Class<? super T> getRawType() {
        return (Class) getRawTypes().j_().next();
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final <X> g<T> where(e<X> eVar, g<X> gVar) {
        return new b(new f().a(af.b(new c(eVar.a), gVar.runtimeType)).b(this.runtimeType));
    }

    public final <X> g<T> where(e<X> eVar, Class<X> cls) {
        return where((e) eVar, of((Class) cls));
    }

    public final g<?> resolveType(Type type) {
        h.a((Object) type);
        f fVar = this.typeResolver;
        if (fVar == null) {
            fVar = f.a(this.runtimeType);
            this.typeResolver = fVar;
        }
        return of(fVar.b(type));
    }

    private Type[] resolveInPlace(Type[] typeArr) {
        for (int i = 0; i < typeArr.length; i++) {
            typeArr[i] = resolveType(typeArr[i]).getType();
        }
        return typeArr;
    }

    private g<?> resolveSupertype(Type type) {
        g<?> resolveType = resolveType(type);
        resolveType.typeResolver = this.typeResolver;
        return resolveType;
    }

    @Nullable
    final g<? super T> getGenericSuperclass() {
        if (this.runtimeType instanceof TypeVariable) {
            return boundAsSuperclass(((TypeVariable) this.runtimeType).getBounds()[0]);
        }
        if (this.runtimeType instanceof WildcardType) {
            return boundAsSuperclass(((WildcardType) this.runtimeType).getUpperBounds()[0]);
        }
        Type genericSuperclass = getRawType().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return resolveSupertype(genericSuperclass);
    }

    @Nullable
    private g<? super T> boundAsSuperclass(Type type) {
        g<? super T> of = of(type);
        if (of.getRawType().isInterface()) {
            return null;
        }
        return of;
    }

    final ad<g<? super T>> getGenericInterfaces() {
        if (this.runtimeType instanceof TypeVariable) {
            return boundsAsInterfaces(((TypeVariable) this.runtimeType).getBounds());
        }
        if (this.runtimeType instanceof WildcardType) {
            return boundsAsInterfaces(((WildcardType) this.runtimeType).getUpperBounds());
        }
        com.google.a.b.ad.a i = ad.i();
        for (Type resolveSupertype : getRawType().getGenericInterfaces()) {
            i.c(resolveSupertype(resolveSupertype));
        }
        return i.a();
    }

    private ad<g<? super T>> boundsAsInterfaces(Type[] typeArr) {
        com.google.a.b.ad.a i = ad.i();
        for (Type of : typeArr) {
            g of2 = of(of);
            if (of2.getRawType().isInterface()) {
                i.c(of2);
            }
        }
        return i.a();
    }

    public final e getTypes() {
        return new e(this);
    }

    public final g<? super T> getSupertype(Class<? super T> cls) {
        h.a(someRawTypeIsSubclassOf(cls), "%s is not a super class of %s", cls, this);
        if (this.runtimeType instanceof TypeVariable) {
            return getSupertypeFromUpperBounds(cls, ((TypeVariable) this.runtimeType).getBounds());
        }
        if (this.runtimeType instanceof WildcardType) {
            return getSupertypeFromUpperBounds(cls, ((WildcardType) this.runtimeType).getUpperBounds());
        }
        if (cls.isArray()) {
            return getArraySupertype(cls);
        }
        return resolveSupertype(toGenericType(cls).runtimeType);
    }

    public final g<? extends T> getSubtype(Class<?> cls) {
        h.a(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        if (this.runtimeType instanceof WildcardType) {
            return getSubtypeFromLowerBounds(cls, ((WildcardType) this.runtimeType).getLowerBounds());
        }
        if (isArray()) {
            return getArraySubtype(cls);
        }
        h.a(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        return of(replaceTypeVariablesWithWildcard(resolveTypeArgsForSubclass(cls), (Class) cls));
    }

    private static final Type replaceTypeVariablesWithWildcard(Type type, final Class<?> cls) {
        h.a((Object) cls);
        final AtomicReference atomicReference = new AtomicReference();
        atomicReference.set(type);
        new h() {
            void a(TypeVariable<?> typeVariable) {
                if (typeVariable.getGenericDeclaration() == cls) {
                    atomicReference.set(i.b((Type) Object.class));
                }
            }

            void a(ParameterizedType parameterizedType) {
                atomicReference.set(i.a(cls.getEnclosingClass() == null ? parameterizedType.getOwnerType() : g.replaceTypeVariablesWithWildcard(parameterizedType.getOwnerType(), cls.getEnclosingClass()), (Class) parameterizedType.getRawType(), g.replaceTypeVariablesWithWildcard(parameterizedType.getActualTypeArguments(), cls)));
            }

            void a(WildcardType wildcardType) {
            }

            void a(GenericArrayType genericArrayType) {
            }

            void a(Class<?> cls) {
            }
        }.a(type);
        return (Type) atomicReference.get();
    }

    private static final Type[] replaceTypeVariablesWithWildcard(Type[] typeArr, Class<?> cls) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = replaceTypeVariablesWithWildcard(typeArr[i], (Class) cls);
        }
        return typeArr2;
    }

    @Deprecated
    public final boolean isAssignableFrom(g<?> gVar) {
        return isSupertypeOf((g) gVar);
    }

    @Deprecated
    public final boolean isAssignableFrom(Type type) {
        return isSupertypeOf(type);
    }

    public final boolean isSupertypeOf(g<?> gVar) {
        return gVar.isSubtypeOf(getType());
    }

    public final boolean isSupertypeOf(Type type) {
        return of(type).isSubtypeOf(getType());
    }

    public final boolean isSubtypeOf(g<?> gVar) {
        return isSubtypeOf(gVar.getType());
    }

    public final boolean isSubtypeOf(Type type) {
        h.a((Object) type);
        if (type instanceof WildcardType) {
            return any(((WildcardType) type).getLowerBounds()).b(this.runtimeType);
        }
        if (this.runtimeType instanceof WildcardType) {
            return any(((WildcardType) this.runtimeType).getUpperBounds()).a(type);
        }
        if (this.runtimeType instanceof TypeVariable) {
            return this.runtimeType.equals(type) || any(((TypeVariable) this.runtimeType).getBounds()).a(type);
        } else {
            if (this.runtimeType instanceof GenericArrayType) {
                return of(type).isSuperTypeOfArray((GenericArrayType) this.runtimeType);
            }
            if (type instanceof Class) {
                return someRawTypeIsSubclassOf((Class) type);
            }
            if (type instanceof ParameterizedType) {
                return isSubtypeOfParameterizedType((ParameterizedType) type);
            }
            return type instanceof GenericArrayType ? isSubTypeOfArrayType((GenericArrayType) type) : false;
        }
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    public final boolean isPrimitive() {
        return (this.runtimeType instanceof Class) && ((Class) this.runtimeType).isPrimitive();
    }

    public final g<T> wrap() {
        if (isPrimitive()) {
            return of(com.google.a.f.c.a((Class) this.runtimeType));
        }
        return this;
    }

    private boolean isWrapper() {
        return com.google.a.f.c.a().contains(this.runtimeType);
    }

    public final g<T> unwrap() {
        if (isWrapper()) {
            return of(com.google.a.f.c.b((Class) this.runtimeType));
        }
        return this;
    }

    @Nullable
    public final g<?> getComponentType() {
        Type e = i.e(this.runtimeType);
        if (e == null) {
            return null;
        }
        return of(e);
    }

    public final b<T, Object> method(Method method) {
        h.a(someRawTypeIsSubclassOf(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new b<T>(this, method) {
            final /* synthetic */ g b;

            Type[] b() {
                return this.b.resolveInPlace(super.b());
            }

            public g<T> a() {
                return this.b;
            }

            public String toString() {
                return a() + "." + super.toString();
            }
        };
    }

    public final b<T, T> constructor(Constructor<?> constructor) {
        boolean z;
        if (constructor.getDeclaringClass() == getRawType()) {
            z = true;
        } else {
            z = false;
        }
        h.a(z, "%s not declared by %s", constructor, getRawType());
        return new a<T>(this, constructor) {
            final /* synthetic */ g b;

            Type[] b() {
                return this.b.resolveInPlace(super.b());
            }

            public g<T> a() {
                return this.b;
            }

            public String toString() {
                return a() + "(" + f.a(com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR).a(b()) + ")";
            }
        };
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        return this.runtimeType.equals(((g) obj).runtimeType);
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public String toString() {
        return i.d(this.runtimeType);
    }

    protected Object writeReplace() {
        return of(new f().b(this.runtimeType));
    }

    final g<T> rejectTypeVariables() {
        new h(this) {
            final /* synthetic */ g a;

            {
                this.a = r1;
            }

            void a(TypeVariable<?> typeVariable) {
                throw new IllegalArgumentException(this.a.runtimeType + "contains a type variable and is not safe for the operation");
            }

            void a(WildcardType wildcardType) {
                a(wildcardType.getLowerBounds());
                a(wildcardType.getUpperBounds());
            }

            void a(ParameterizedType parameterizedType) {
                a(parameterizedType.getActualTypeArguments());
                a(parameterizedType.getOwnerType());
            }

            void a(GenericArrayType genericArrayType) {
                a(genericArrayType.getGenericComponentType());
            }
        }.a(this.runtimeType);
        return this;
    }

    private boolean someRawTypeIsSubclassOf(Class<?> cls) {
        Iterator it = getRawTypes().iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom((Class) it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean isSubtypeOfParameterizedType(ParameterizedType parameterizedType) {
        Class rawType = of((Type) parameterizedType).getRawType();
        if (!someRawTypeIsSubclassOf(rawType)) {
            return false;
        }
        TypeVariable[] typeParameters = rawType.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < typeParameters.length; i++) {
            if (!resolveType(typeParameters[i]).is(actualTypeArguments[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean isSubTypeOfArrayType(GenericArrayType genericArrayType) {
        if (!(this.runtimeType instanceof Class)) {
            return this.runtimeType instanceof GenericArrayType ? of(((GenericArrayType) this.runtimeType).getGenericComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType()) : false;
        } else {
            Class cls = (Class) this.runtimeType;
            if (cls.isArray()) {
                return of(cls.getComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
            }
            return false;
        }
    }

    private boolean isSuperTypeOfArray(GenericArrayType genericArrayType) {
        if (this.runtimeType instanceof Class) {
            Class cls = (Class) this.runtimeType;
            if (cls.isArray()) {
                return of(genericArrayType.getGenericComponentType()).isSubtypeOf(cls.getComponentType());
            }
            return cls.isAssignableFrom(Object[].class);
        } else if (this.runtimeType instanceof GenericArrayType) {
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
        } else {
            return false;
        }
    }

    private boolean is(Type type) {
        if (this.runtimeType.equals(type)) {
            return true;
        }
        if (!(type instanceof WildcardType)) {
            return false;
        }
        boolean z = every(((WildcardType) type).getUpperBounds()).b(this.runtimeType) && every(((WildcardType) type).getLowerBounds()).a(this.runtimeType);
        return z;
    }

    private static a every(Type[] typeArr) {
        return new a(typeArr, false);
    }

    private static a any(Type[] typeArr) {
        return new a(typeArr, true);
    }

    private am<Class<? super T>> getRawTypes() {
        final com.google.a.b.am.a i = am.i();
        new h(this) {
            final /* synthetic */ g b;

            void a(TypeVariable<?> typeVariable) {
                a(typeVariable.getBounds());
            }

            void a(WildcardType wildcardType) {
                a(wildcardType.getUpperBounds());
            }

            void a(ParameterizedType parameterizedType) {
                i.c((Class) parameterizedType.getRawType());
            }

            void a(Class<?> cls) {
                i.c(cls);
            }

            void a(GenericArrayType genericArrayType) {
                i.c(i.a(g.of(genericArrayType.getGenericComponentType()).getRawType()));
            }
        }.a(this.runtimeType);
        return i.a();
    }

    static <T> g<? extends T> toGenericType(Class<T> cls) {
        if (cls.isArray()) {
            return of(i.a(toGenericType(cls.getComponentType()).runtimeType));
        }
        Type[] typeParameters = cls.getTypeParameters();
        Type type = cls.isMemberClass() ? toGenericType(cls.getEnclosingClass()).runtimeType : null;
        if (typeParameters.length > 0 || type != cls.getEnclosingClass()) {
            return of(i.a(type, (Class) cls, typeParameters));
        }
        return of((Class) cls);
    }

    private g<? super T> getSupertypeFromUpperBounds(Class<? super T> cls, Type[] typeArr) {
        for (Type of : typeArr) {
            g of2 = of(of);
            if (of2.isSubtypeOf((Type) cls)) {
                return of2.getSupertype(cls);
            }
        }
        throw new IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    private g<? extends T> getSubtypeFromLowerBounds(Class<?> cls, Type[] typeArr) {
        if (0 < typeArr.length) {
            return of(typeArr[0]).getSubtype(cls);
        }
        throw new IllegalArgumentException(cls + " isn't a subclass of " + this);
    }

    private g<? super T> getArraySupertype(Class<? super T> cls) {
        return of(newArrayClassOrGenericArrayType(((g) h.a(getComponentType(), "%s isn't a super type of %s", cls, this)).getSupertype(cls.getComponentType()).runtimeType));
    }

    private g<? extends T> getArraySubtype(Class<?> cls) {
        return of(newArrayClassOrGenericArrayType(getComponentType().getSubtype(cls.getComponentType()).runtimeType));
    }

    private Type resolveTypeArgsForSubclass(Class<?> cls) {
        if (this.runtimeType instanceof Class) {
            return cls;
        }
        g toGenericType = toGenericType(cls);
        return new f().a(toGenericType.getSupertype(getRawType()).runtimeType, this.runtimeType).b(toGenericType.runtimeType);
    }

    private static Type newArrayClassOrGenericArrayType(Type type) {
        return c.JAVA7.newArrayType(type);
    }
}
