package com.b.b;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.b.a.c.b.e;
import com.b.a.c.n;
import com.b.a.f.c;
import com.b.b.b.g;
import com.b.b.h.d;
import com.b.b.h.h;
import com.b.b.h.i;
import com.b.b.h.l;
import com.google.b.f;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;

public class j {
    private static Comparator<f> D = new Comparator<f>() {
        public /* synthetic */ int compare(Object obj, Object obj2) {
            return a((f) obj, (f) obj2);
        }

        public int a(f fVar, f fVar2) {
            if (fVar.f == fVar2.f) {
                return 0;
            }
            if (fVar.f < fVar2.f) {
                return 1;
            }
            return -1;
        }
    };
    static final Handler a = new Handler(Looper.getMainLooper());
    static int b = Runtime.getRuntime().availableProcessors();
    static ExecutorService c = Executors.newFixedThreadPool(4);
    static ExecutorService d = (b > 2 ? Executors.newFixedThreadPool(b - 1) : Executors.newFixedThreadPool(1));
    static HashMap<String, j> e = new HashMap();
    Context A;
    m B = new m(this);
    WeakHashMap<Object, b> C = new WeakHashMap();
    private Runnable E = new Runnable(this) {
        final /* synthetic */ j a;

        {
            this.a = r1;
        }

        public void run() {
            if (!c.a(this.a)) {
                Iterator it;
                f fVar;
                Object obj = null;
                for (String a : this.a.x.a()) {
                    Object a2 = this.a.x.a(a);
                    if (a2 instanceof f) {
                        fVar = (f) a2;
                        if (obj == null) {
                            obj = new ArrayList();
                        }
                        obj.add(fVar);
                    }
                }
                if (obj != null) {
                    Collections.sort(obj, j.D);
                    it = obj.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        fVar = (f) it.next();
                        this.a.x.a(fVar.a, null);
                        this.a.x.a(fVar.e.b, null);
                        fVar.e.c();
                        int i2 = i + 1;
                        if (i2 <= 5) {
                            i = i2;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    };
    com.b.a.c.a f;
    com.b.b.c.a g;
    com.b.b.d.a h;
    e i;
    c j;
    com.b.b.h.e k;
    com.b.b.h.c l;
    i m;
    com.b.b.h.a n;
    l o;
    h p;
    d q;
    String r;
    int s;
    f t;
    String u;
    ArrayList<u> v = new ArrayList();
    String w;
    com.b.a.f.e<com.b.a.b.f<com.b.b.a.b>> x = new com.b.a.f.e();
    a y = new a(this);
    com.b.b.a.d z;

    public class a {
        com.b.b.h.b a = new com.b.b.h.b(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public com.b.a.c.d a(Uri uri, String str, n nVar) {
                com.b.a.c.d dVar = new com.b.a.c.d(uri, str, nVar);
                if (!TextUtils.isEmpty(this.a.b.u)) {
                    dVar.e().a("User-Agent", this.a.b.u);
                }
                return dVar;
            }
        };
        final /* synthetic */ j b;

        public a(j jVar) {
            this.b = jVar;
        }

        public synchronized f a() {
            if (this.b.t == null) {
                this.b.t = new f();
            }
            return this.b.t;
        }

        public com.b.b.h.b b() {
            return this.a;
        }

        public a a(u uVar) {
            this.b.v.add(uVar);
            return this;
        }

        public List<u> c() {
            return this.b.v;
        }
    }

    static class b extends WeakHashMap<com.b.a.b.e, Boolean> {
        b() {
        }
    }

    public static g<com.b.b.b.c.a.a> a(Context context) {
        return b(context).c(context);
    }

    public static j b(Context context) {
        return a(context, "ion");
    }

    public static j a(Context context, String str) {
        if (context == null) {
            throw new NullPointerException("Can not pass null context in to retrieve ion instance");
        }
        j jVar = (j) e.get(str);
        if (jVar != null) {
            return jVar;
        }
        HashMap hashMap = e;
        jVar = new j(context, str);
        hashMap.put(str, jVar);
        return jVar;
    }

    public static com.b.b.b.c.b.a<? extends com.b.b.b.c.b.a<?>> a(ImageView imageView) {
        return b(imageView.getContext()).b(imageView);
    }

    private j(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.A = applicationContext;
        this.w = str;
        this.f = new com.b.a.c.a(new com.b.a.g("ion-" + str));
        this.f.d().a(new BrowserCompatHostnameVerifier());
        this.f.d().b(false);
        com.b.a.c.a aVar = this.f;
        com.b.a.c.b aVar2 = new com.b.b.c.a(applicationContext, this.f.d());
        this.g = aVar2;
        aVar.a(aVar2);
        File file = new File(applicationContext.getCacheDir(), str);
        try {
            this.i = e.a(this.f, file, 10485760);
        } catch (Exception e) {
            n.a("unable to set up response cache, clearing", e);
            com.b.a.f.d.a(file);
            try {
                this.i = e.a(this.f, file, 10485760);
            } catch (IOException e2) {
                n.a("unable to set up response cache, failing", e);
            }
        }
        this.j = new c(new File(applicationContext.getFilesDir(), str), Long.MAX_VALUE, false);
        if (VERSION.SDK_INT >= 9) {
            j();
        }
        this.f.c().a(true);
        this.f.d().a(true);
        this.z = new com.b.b.a.d(this);
        a g = g();
        u lVar = new l();
        this.o = lVar;
        g = g.a(lVar);
        lVar = new h();
        this.p = lVar;
        g = g.a(lVar);
        lVar = new com.b.b.h.e();
        this.k = lVar;
        g = g.a(lVar);
        lVar = new com.b.b.h.c();
        this.l = lVar;
        g = g.a(lVar);
        lVar = new i();
        this.m = lVar;
        g = g.a(lVar);
        lVar = new com.b.b.h.a();
        this.n = lVar;
        g = g.a(lVar);
        lVar = new d();
        this.q = lVar;
        g.a(lVar);
    }

    public static ExecutorService a() {
        return d;
    }

    public g<com.b.b.b.c.a.a> c(Context context) {
        return new o(d.a(context), this);
    }

    public com.b.b.b.c.b.a<? extends com.b.b.b.c.b.a<?>> b(ImageView imageView) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new IllegalStateException("must be called from UI thread");
        }
        this.B.a();
        this.B.b = this;
        return this.B.a(imageView);
    }

    void b() {
        a.removeCallbacks(this.E);
        a.post(this.E);
    }

    void a(com.b.a.b.e eVar, Object obj) {
        if (obj != null && eVar != null && !eVar.isDone() && !eVar.isCancelled()) {
            b bVar;
            synchronized (this) {
                bVar = (b) this.C.get(obj);
                if (bVar == null) {
                    bVar = new b();
                    this.C.put(obj, bVar);
                }
            }
            bVar.put(eVar, Boolean.valueOf(true));
        }
    }

    public Context c() {
        return this.A;
    }

    private void j() {
        com.b.a.c.a aVar = this.f;
        com.b.a.c.b aVar2 = new com.b.b.d.a(this);
        this.h = aVar2;
        aVar.a(aVar2);
    }

    public String d() {
        return this.w;
    }

    public com.b.a.c.a e() {
        return this.f;
    }

    public com.b.a.g f() {
        return this.f.e();
    }

    public a g() {
        return this.y;
    }

    public com.b.b.a.d h() {
        return this.z;
    }
}
