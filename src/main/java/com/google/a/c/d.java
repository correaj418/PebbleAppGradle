package com.google.a.c;

import com.google.a.a.h;
import com.google.a.a.m;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import javax.annotation.Nullable;

public final class d implements Closeable {
    private static final c b = (b.a() ? b.a : a.a);
    final c a;
    private final Deque<Closeable> c = new ArrayDeque(4);
    private Throwable d;

    interface c {
        void a(Closeable closeable, Throwable th, Throwable th2);
    }

    static final class a implements c {
        static final a a = new a();

        a() {
        }

        public void a(Closeable closeable, Throwable th, Throwable th2) {
            c.a.log(Level.WARNING, "Suppressing exception thrown when closing " + closeable, th2);
        }
    }

    static final class b implements c {
        static final b a = new b();
        static final Method b = b();

        b() {
        }

        static boolean a() {
            return b != null;
        }

        private static Method b() {
            try {
                return Throwable.class.getMethod("addSuppressed", new Class[]{Throwable.class});
            } catch (Throwable th) {
                return null;
            }
        }

        public void a(Closeable closeable, Throwable th, Throwable th2) {
            if (th != th2) {
                try {
                    b.invoke(th, new Object[]{th2});
                } catch (Throwable th3) {
                    a.a.a(closeable, th, th2);
                }
            }
        }
    }

    public static d a() {
        return new d(b);
    }

    d(c cVar) {
        this.a = (c) h.a((Object) cVar);
    }

    public <C extends Closeable> C a(@Nullable C c) {
        if (c != null) {
            this.c.addFirst(c);
        }
        return c;
    }

    public RuntimeException a(Throwable th) {
        h.a((Object) th);
        this.d = th;
        m.b(th, IOException.class);
        throw new RuntimeException(th);
    }

    public void close() {
        Throwable th = this.d;
        while (!this.c.isEmpty()) {
            Throwable th2;
            Closeable closeable = (Closeable) this.c.removeFirst();
            try {
                closeable.close();
                th2 = th;
            } catch (Throwable th3) {
                if (th == null) {
                    th2 = th3;
                } else {
                    this.a.a(closeable, th, th3);
                    th2 = th;
                }
            }
            th = th2;
        }
        if (this.d == null && th != null) {
            m.b(th, IOException.class);
            throw new AssertionError(th);
        }
    }
}
