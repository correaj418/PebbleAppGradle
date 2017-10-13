package com.google.a.a;

import java.lang.reflect.Method;
import javax.annotation.Nullable;

public final class m {
    @Nullable
    private static final Object a = a();
    @Nullable
    private static final Method b = (a == null ? null : b());
    @Nullable
    private static final Method c;

    public static <X extends Throwable> void a(@Nullable Throwable th, Class<X> cls) {
        if (th != null && cls.isInstance(th)) {
            throw ((Throwable) cls.cast(th));
        }
    }

    public static void a(@Nullable Throwable th) {
        a(th, Error.class);
        a(th, RuntimeException.class);
    }

    public static <X extends Throwable> void b(@Nullable Throwable th, Class<X> cls) {
        a(th, (Class) cls);
        a(th);
    }

    static {
        Method method = null;
        if (a != null) {
            method = c();
        }
        c = method;
    }

    @Nullable
    private static Object a() {
        Object obj = null;
        try {
            obj = Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable th) {
        }
        return obj;
    }

    @Nullable
    private static Method b() {
        return a("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    @Nullable
    private static Method c() {
        return a("getStackTraceDepth", Throwable.class);
    }

    @Nullable
    private static Method a(String str, Class<?>... clsArr) {
        Method method = null;
        try {
            method = Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable th) {
        }
        return method;
    }
}
