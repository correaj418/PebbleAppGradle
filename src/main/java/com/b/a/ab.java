package com.b.a;

import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.Semaphore;

public class ab extends LinkedList<Runnable> {
    private static final WeakHashMap<Thread, ab> c = new WeakHashMap();
    f a;
    Semaphore b = new Semaphore(0);

    public /* synthetic */ boolean add(Object obj) {
        return a((Runnable) obj);
    }

    public /* synthetic */ Object remove() {
        return a();
    }

    static ab a(Thread thread) {
        ab abVar;
        synchronized (c) {
            abVar = (ab) c.get(thread);
            if (abVar == null) {
                abVar = new ab();
                c.put(thread, abVar);
            }
        }
        return abVar;
    }

    static void a(f fVar) {
        synchronized (c) {
            for (ab abVar : c.values()) {
                if (abVar.a == fVar) {
                    abVar.b.release();
                }
            }
        }
    }

    public boolean a(Runnable runnable) {
        boolean add;
        synchronized (this) {
            add = super.add(runnable);
        }
        return add;
    }

    public boolean remove(Object obj) {
        boolean remove;
        synchronized (this) {
            remove = super.remove(obj);
        }
        return remove;
    }

    public Runnable a() {
        Runnable runnable;
        synchronized (this) {
            if (isEmpty()) {
                runnable = null;
            } else {
                runnable = (Runnable) super.remove();
            }
        }
        return runnable;
    }
}
