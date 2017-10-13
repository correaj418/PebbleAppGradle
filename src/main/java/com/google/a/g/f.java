package com.google.a.g;

import com.google.a.a.g;
import com.google.a.a.h;
import com.google.a.b.af;
import com.google.a.b.ay;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

public final class f {
    private final b a;

    private static final class a extends h {
        private static final d a = new d();
        private final Map<c, Type> b = ay.c();

        private a() {
        }

        static af<c, Type> a(Type type) {
            a aVar = new a();
            aVar.a(a.a(type));
            return af.a(aVar.b);
        }

        void a(Class<?> cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        void a(ParameterizedType parameterizedType) {
            boolean z;
            TypeVariable[] typeParameters = ((Class) parameterizedType.getRawType()).getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (typeParameters.length == actualTypeArguments.length) {
                z = true;
            } else {
                z = false;
            }
            h.b(z);
            for (int i = 0; i < typeParameters.length; i++) {
                a(new c(typeParameters[i]), actualTypeArguments[i]);
            }
            a(r0);
            a(parameterizedType.getOwnerType());
        }

        void a(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        void a(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }

        private void a(c cVar, Type type) {
            if (!this.b.containsKey(cVar)) {
                Type type2 = type;
                while (type2 != null) {
                    if (cVar.b(type2)) {
                        while (type != null) {
                            type = (Type) this.b.remove(c.a(type));
                        }
                        return;
                    }
                    type2 = (Type) this.b.get(c.a(type2));
                }
                this.b.put(cVar, type);
            }
        }
    }

    private static class b {
        private final af<c, Type> a;

        b() {
            this.a = af.e();
        }

        private b(af<c, Type> afVar) {
            this.a = afVar;
        }

        final b a(Map<c, ? extends Type> map) {
            com.google.a.b.af.a f = af.f();
            f.a(this.a);
            for (Entry entry : map.entrySet()) {
                boolean z;
                c cVar = (c) entry.getKey();
                Type type = (Type) entry.getValue();
                if (cVar.b(type)) {
                    z = false;
                } else {
                    z = true;
                }
                h.a(z, "Type variable %s bound to itself", cVar);
                f.a(cVar, type);
            }
            return new b(f.a());
        }

        final Type a(final TypeVariable<?> typeVariable) {
            return a(typeVariable, new b(this) {
                final /* synthetic */ b c;

                public Type a(TypeVariable<?> typeVariable, b bVar) {
                    return typeVariable.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) ? typeVariable : this.a(typeVariable, bVar);
                }
            });
        }

        Type a(TypeVariable<?> typeVariable, b bVar) {
            Type type = (Type) this.a.get(new c(typeVariable));
            if (type != null) {
                return new f(bVar).b(type);
            }
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length == 0) {
                return typeVariable;
            }
            Type[] a = new f(bVar).a(bounds);
            if (d.a && Arrays.equals(bounds, a)) {
                return typeVariable;
            }
            return i.a(typeVariable.getGenericDeclaration(), typeVariable.getName(), a);
        }
    }

    static final class c {
        private final TypeVariable<?> a;

        c(TypeVariable<?> typeVariable) {
            this.a = (TypeVariable) h.a((Object) typeVariable);
        }

        public int hashCode() {
            return g.a(this.a.getGenericDeclaration(), this.a.getName());
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return a(((c) obj).a);
            }
            return false;
        }

        public String toString() {
            return this.a.toString();
        }

        static Object a(Type type) {
            if (type instanceof TypeVariable) {
                return new c((TypeVariable) type);
            }
            return null;
        }

        boolean b(Type type) {
            if (type instanceof TypeVariable) {
                return a((TypeVariable) type);
            }
            return false;
        }

        private boolean a(TypeVariable<?> typeVariable) {
            return this.a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.a.getName().equals(typeVariable.getName());
        }
    }

    private static final class d {
        private final AtomicInteger a;

        private d() {
            this.a = new AtomicInteger();
        }

        Type a(Type type) {
            h.a((Object) type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return i.a(a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                return i.a(b(parameterizedType.getOwnerType()), (Class) parameterizedType.getRawType(), a(parameterizedType.getActualTypeArguments()));
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                if (wildcardType.getLowerBounds().length != 0) {
                    return type;
                }
                return i.a((GenericDeclaration) d.class, "capture#" + this.a.incrementAndGet() + "-of ? extends " + com.google.a.a.f.a('&').a(wildcardType.getUpperBounds()), wildcardType.getUpperBounds());
            } else {
                throw new AssertionError("must have been one of the known types");
            }
        }

        private Type b(@Nullable Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        private Type[] a(Type[] typeArr) {
            Type[] typeArr2 = new Type[typeArr.length];
            for (int i = 0; i < typeArr.length; i++) {
                typeArr2[i] = a(typeArr[i]);
            }
            return typeArr2;
        }
    }

    public f() {
        this.a = new b();
    }

    private f(b bVar) {
        this.a = bVar;
    }

    static f a(Type type) {
        return new f().a(a.a(type));
    }

    public f a(Type type, Type type2) {
        Map c = ay.c();
        b(c, (Type) h.a((Object) type), (Type) h.a((Object) type2));
        return a(c);
    }

    f a(Map<c, ? extends Type> map) {
        return new f(this.a.a((Map) map));
    }

    private static void b(final Map<c, Type> map, Type type, final Type type2) {
        if (!type.equals(type2) && (type2 instanceof WildcardType) == (type instanceof WildcardType)) {
            new h() {
                void a(TypeVariable<?> typeVariable) {
                    map.put(new c(typeVariable), type2);
                }

                void a(WildcardType wildcardType) {
                    boolean z;
                    int i = 0;
                    WildcardType wildcardType2 = (WildcardType) f.b(WildcardType.class, type2);
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    Type[] upperBounds2 = wildcardType2.getUpperBounds();
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                    if (upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length) {
                        z = true;
                    } else {
                        z = false;
                    }
                    h.a(z, "Incompatible type: %s vs. %s", wildcardType, type2);
                    for (int i2 = 0; i2 < upperBounds.length; i2++) {
                        f.b(map, upperBounds[i2], upperBounds2[i2]);
                    }
                    while (i < lowerBounds.length) {
                        f.b(map, lowerBounds[i], lowerBounds2[i]);
                        i++;
                    }
                }

                void a(ParameterizedType parameterizedType) {
                    boolean z;
                    int i = 0;
                    ParameterizedType parameterizedType2 = (ParameterizedType) f.b(ParameterizedType.class, type2);
                    h.a(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, type2);
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                    if (actualTypeArguments.length == actualTypeArguments2.length) {
                        z = true;
                    } else {
                        z = false;
                    }
                    h.a(z, "%s not compatible with %s", parameterizedType, parameterizedType2);
                    while (i < actualTypeArguments.length) {
                        f.b(map, actualTypeArguments[i], actualTypeArguments2[i]);
                        i++;
                    }
                }

                void a(GenericArrayType genericArrayType) {
                    boolean z;
                    Type e = i.e(type2);
                    if (e != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    h.a(z, "%s is not an array type.", type2);
                    f.b(map, genericArrayType.getGenericComponentType(), e);
                }

                void a(Class<?> cls) {
                    throw new IllegalArgumentException("No type mapping from " + cls);
                }
            }.a(type);
        }
    }

    public Type b(Type type) {
        h.a((Object) type);
        if (type instanceof TypeVariable) {
            return this.a.a((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return a((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return a((GenericArrayType) type);
        }
        if (type instanceof WildcardType) {
            return a((WildcardType) type);
        }
        return type;
    }

    private Type[] a(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = b(typeArr[i]);
        }
        return typeArr2;
    }

    private WildcardType a(WildcardType wildcardType) {
        return new h(a(wildcardType.getLowerBounds()), a(wildcardType.getUpperBounds()));
    }

    private Type a(GenericArrayType genericArrayType) {
        return i.a(b(genericArrayType.getGenericComponentType()));
    }

    private ParameterizedType a(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        return i.a(ownerType == null ? null : b(ownerType), (Class) b(parameterizedType.getRawType()), a(parameterizedType.getActualTypeArguments()));
    }

    private static <T> T b(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
        }
    }
}
