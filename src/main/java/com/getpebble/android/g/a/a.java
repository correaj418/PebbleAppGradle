package com.getpebble.android.g.a;

import android.os.Handler;
import android.os.HandlerThread;
import com.getpebble.android.common.b.a.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a {
    protected String a = "AbstractNlpManager";
    private ArrayList<WeakReference<com.getpebble.android.g.a>> b = new ArrayList();
    private HandlerThread c = new HandlerThread("Worker");
    private Handler d;
    private b e = b.IDLE;
    private Object f = new Object();

    public enum a {
        SERVER_ERROR,
        INVALID_RESULT,
        INVALID_STATE,
        BUSY,
        TIMEOUT
    }

    public enum b {
        IDLE,
        PROCESSING,
        WAITING_RESULT
    }

    public a() {
        this.c.start();
        this.d = new Handler(this.c.getLooper());
    }

    protected Handler a() {
        return this.d;
    }

    protected void a(b bVar) {
        synchronized (this.f) {
            f.e(this.a, "setState: state = " + bVar);
            this.e = bVar;
        }
    }

    protected b b() {
        b bVar;
        synchronized (this.f) {
            bVar = this.e;
        }
        return bVar;
    }

    public void a(com.getpebble.android.g.a aVar) {
        if (aVar != null && c(aVar) == null) {
            this.b.add(new WeakReference(aVar));
        }
    }

    public void b(com.getpebble.android.g.a aVar) {
        if (aVar != null) {
            WeakReference c = c(aVar);
            if (c != null) {
                this.b.remove(c);
            }
        }
    }

    protected void a(short s, b bVar) {
        Iterator it = c().iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            com.getpebble.android.g.a aVar = (com.getpebble.android.g.a) weakReference.get();
            if (aVar == null) {
                this.b.remove(weakReference);
            } else {
                aVar.a(s, bVar);
            }
        }
        a(b.IDLE);
    }

    protected void a(short s, a aVar, String str) {
        Iterator it = c().iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            com.getpebble.android.g.a aVar2 = (com.getpebble.android.g.a) weakReference.get();
            if (aVar2 == null) {
                this.b.remove(weakReference);
            } else {
                aVar2.a(s, aVar, str);
            }
        }
        a(b.IDLE);
    }

    private WeakReference<com.getpebble.android.g.a> c(com.getpebble.android.g.a aVar) {
        Iterator it = c().iterator();
        while (it.hasNext()) {
            WeakReference<com.getpebble.android.g.a> weakReference = (WeakReference) it.next();
            com.getpebble.android.g.a aVar2 = (com.getpebble.android.g.a) weakReference.get();
            if (aVar2 == null) {
                f.b(this.a, "find: remove a null reference");
                this.b.remove(weakReference);
            } else if (aVar2 == aVar) {
                return weakReference;
            }
        }
        return null;
    }

    private ArrayList<WeakReference<com.getpebble.android.g.a>> c() {
        return new ArrayList(this.b);
    }
}
