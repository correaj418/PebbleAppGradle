package com.google.b.b;

import com.google.b.c.a;
import com.google.b.h;
import com.google.b.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class c {
    private final Map<Type, h<?>> a;

    public c(Map<Type, h<?>> map) {
        this.a = map;
    }

    public <T> h<T> a(a<T> aVar) {
        final Type type = aVar.getType();
        Class rawType = aVar.getRawType();
        final h hVar = (h) this.a.get(type);
        if (hVar != null) {
            return new h<T>(this) {
                final /* synthetic */ c c;

                public T a() {
                    return hVar.a(type);
                }
            };
        }
        hVar = (h) this.a.get(rawType);
        if (hVar != null) {
            return new h<T>(this) {
                final /* synthetic */ c c;

                public T a() {
                    return hVar.a(type);
                }
            };
        }
        h<T> a = a(rawType);
        if (a != null) {
            return a;
        }
        a = a(type, rawType);
        return a == null ? b(type, rawType) : a;
    }

    private <T> h<T> a(Class<? super T> cls) {
        try {
            final Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new h<T>(this) {
                final /* synthetic */ c b;

                public T a() {
                    try {
                        return declaredConstructor.newInstance(null);
                    } catch (Throwable e) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e);
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2.getTargetException());
                    } catch (IllegalAccessException e3) {
                        throw new AssertionError(e3);
                    }
                }
            };
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private <T> h<T> a(final Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new h<T>(this) {
                    final /* synthetic */ c a;

                    {
                        this.a = r1;
                    }

                    public T a() {
                        return new TreeSet();
                    }
                };
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new h<T>(this) {
                    final /* synthetic */ c b;

                    public T a() {
                        if (type instanceof ParameterizedType) {
                            Type type = ((ParameterizedType) type).getActualTypeArguments()[0];
                            if (type instanceof Class) {
                                return EnumSet.noneOf((Class) type);
                            }
                            throw new m("Invalid EnumSet type: " + type.toString());
                        }
                        throw new m("Invalid EnumSet type: " + type.toString());
                    }
                };
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new h<T>(this) {
                    final /* synthetic */ c a;

                    {
                        this.a = r1;
                    }

                    public T a() {
                        return new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new h<T>(this) {
                    final /* synthetic */ c a;

                    {
                        this.a = r1;
                    }

                    public T a() {
                        return new ArrayDeque();
                    }
                };
            }
            return new h<T>(this) {
                final /* synthetic */ c a;

                {
                    this.a = r1;
                }

                public T a() {
                    return new ArrayList();
                }
            };
        } else if (!Map.class.isAssignableFrom(cls)) {
            return null;
        } else {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new h<T>(this) {
                    final /* synthetic */ c a;

                    {
                        this.a = r1;
                    }

                    public T a() {
                        return new ConcurrentSkipListMap();
                    }
                };
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new h<T>(this) {
                    final /* synthetic */ c a;

                    {
                        this.a = r1;
                    }

                    public T a() {
                        return new ConcurrentHashMap();
                    }
                };
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new h<T>(this) {
                    final /* synthetic */ c a;

                    {
                        this.a = r1;
                    }

                    public T a() {
                        return new TreeMap();
                    }
                };
            }
            if (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                return new h<T>(this) {
                    final /* synthetic */ c a;

                    {
                        this.a = r1;
                    }

                    public T a() {
                        return new g();
                    }
                };
            }
            return new h<T>(this) {
                final /* synthetic */ c a;

                {
                    this.a = r1;
                }

                public T a() {
                    return new LinkedHashMap();
                }
            };
        }
    }

    private <T> h<T> b(final Type type, final Class<? super T> cls) {
        return new h<T>(this) {
            final /* synthetic */ c c;
            private final k d = k.a();

            public T a() {
                try {
                    return this.d.a(cls);
                } catch (Throwable e) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", e);
                }
            }
        };
    }

    public String toString() {
        return this.a.toString();
    }
}
