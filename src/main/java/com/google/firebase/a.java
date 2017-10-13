package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.a.k;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.b;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class a {
    static final Map<String, a> a = new android.support.v4.e.a();
    private static final List<String> b = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> c = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> d = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final Set<String> e = Collections.emptySet();
    private static final Object f = new Object();
    private final Context g;
    private final String h;
    private final b i;
    private final AtomicBoolean j = new AtomicBoolean(true);
    private final AtomicBoolean k = new AtomicBoolean();
    private final List<Object> l = new CopyOnWriteArrayList();
    private final List<a> m = new CopyOnWriteArrayList();
    private final List<Object> n = new CopyOnWriteArrayList();

    public interface a {
        void a(boolean z);
    }

    protected a(Context context, String str, b bVar) {
        this.g = (Context) b.a((Object) context);
        this.h = b.a(str);
        this.i = (b) b.a((Object) bVar);
    }

    public static a a(Context context) {
        b a = b.a(context);
        return a == null ? null : a(context, a);
    }

    public static a a(Context context, b bVar) {
        return a(context, bVar, "[DEFAULT]");
    }

    public static a a(Context context, b bVar, String str) {
        Object aVar;
        com.google.android.gms.b.b a = com.google.android.gms.b.b.a(context);
        b(context);
        String a2 = a(str);
        Object applicationContext = context.getApplicationContext();
        synchronized (f) {
            b.a(!a.containsKey(a2), new StringBuilder(String.valueOf(a2).length() + 33).append("FirebaseApp name ").append(a2).append(" already exists!").toString());
            b.a(applicationContext, (Object) "Application context cannot be null.");
            aVar = new a(applicationContext, a2, bVar);
            a.put(a2, aVar);
        }
        a.a((a) aVar);
        a(a.class, aVar, b);
        if (aVar.c()) {
            a(a.class, aVar, c);
            a(Context.class, aVar.a(), d);
        }
        return aVar;
    }

    private static String a(String str) {
        return str.trim();
    }

    private static <T> void a(Class<T> cls, T t, Iterable<String> iterable) {
        for (String str : iterable) {
            String str2;
            try {
                Class cls2 = Class.forName(str2);
                Method method = cls2.getMethod("getInstance", new Class[]{cls});
                if ((method.getModifiers() & 9) == 9) {
                    method.invoke(null, new Object[]{t});
                }
                String valueOf = String.valueOf(cls2);
                Log.d("FirebaseApp", new StringBuilder(String.valueOf(valueOf).length() + 13).append("Initialized ").append(valueOf).append(".").toString());
            } catch (ClassNotFoundException e) {
                if (e.contains(str2)) {
                    throw new IllegalStateException(String.valueOf(str2).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                }
                Log.d("FirebaseApp", String.valueOf(str2).concat(" is not linked. Skipping initialization."));
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException(String.valueOf(str2).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
            } catch (Throwable e3) {
                Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
            } catch (Throwable e4) {
                String str3 = "FirebaseApp";
                String str4 = "Failed to initialize ";
                str2 = String.valueOf(str2);
                Log.wtf(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4), e4);
            }
        }
    }

    public static void a(boolean z) {
        synchronized (f) {
            Iterator it = new ArrayList(a.values()).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.j.get()) {
                    aVar.b(z);
                }
            }
        }
    }

    @TargetApi(14)
    private static void b(Context context) {
        if (k.c() && (context.getApplicationContext() instanceof Application)) {
            com.google.android.gms.b.a.a((Application) context.getApplicationContext());
        }
    }

    private void b(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (a a : this.m) {
            a.a(z);
        }
    }

    private void d() {
        b.a(!this.k.get(), (Object) "FirebaseApp was deleted");
    }

    public Context a() {
        d();
        return this.g;
    }

    public String b() {
        d();
        return this.h;
    }

    public boolean c() {
        return "[DEFAULT]".equals(b());
    }

    public boolean equals(Object obj) {
        return !(obj instanceof a) ? false : this.h.equals(((a) obj).b());
    }

    public int hashCode() {
        return this.h.hashCode();
    }

    public String toString() {
        return ab.a((Object) this).a("name", this.h).a("options", this.i).toString();
    }
}
