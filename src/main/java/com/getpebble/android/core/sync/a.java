package com.getpebble.android.core.sync;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.b.m;
import com.getpebble.android.common.model.a.q;
import com.getpebble.android.common.model.a.r.d;
import com.getpebble.android.common.model.u;
import com.getpebble.jskit.android.impl.runtime.a.a.e;
import java.util.concurrent.TimeUnit;

public abstract class a<T extends a> {
    public static final long a = TimeUnit.DAYS.toSeconds(1);
    public static final long b = TimeUnit.DAYS.toSeconds(1);
    public static final long c = TimeUnit.HOURS.toSeconds(6);
    public static final long d = TimeUnit.DAYS.toSeconds(1);
    public static final long e = TimeUnit.DAYS.toSeconds(1);
    private static final long k = TimeUnit.SECONDS.toMillis(3);
    protected final Context f;
    protected final String g;
    protected final m h;
    protected final Handler i = new Handler(Looper.getMainLooper());
    protected final com.getpebble.android.common.b.b.g.a j;

    interface c {
        void a(String str);
    }

    protected interface b {
        void a();

        void a(String str);

        String b();

        String c();
    }

    protected static abstract class a<T extends q> implements b {
        protected final u a;
        protected d<T> b;
        protected Context c;

        public a(u uVar, d<T> dVar, Context context) {
            this.a = uVar;
            this.b = dVar;
            this.c = context;
        }
    }

    public a(Context context, final String str) {
        this.f = context;
        this.g = str;
        this.h = new m(new e(context));
        this.j = new com.getpebble.android.common.b.b.g.a(k);
        this.i.post(new Runnable(this) {
            final /* synthetic */ a b;

            public void run() {
                this.b.h.a(new com.getpebble.android.common.framework.b.m.b(this) {
                    final /* synthetic */ AnonymousClass1 a;

                    {
                        this.a = r1;
                    }

                    public void a() {
                        f.e(str, "onInit: health JS runner got init callback");
                        this.a.b.j.b();
                    }
                });
            }
        });
    }

    public void a() {
        f.e(this.g, "destroy: destroying Webview");
        final com.getpebble.android.common.b.b.g.a aVar = new com.getpebble.android.common.b.b.g.a(k);
        this.i.post(new Runnable(this) {
            final /* synthetic */ a b;

            public void run() {
                this.b.h.a();
                aVar.b();
            }
        });
        aVar.a();
    }

    protected T a(final b bVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        final String b = bVar.b();
        if (this.j.a()) {
            c anonymousClass3 = new c(this) {
                final /* synthetic */ a c;

                public void a(String str) {
                    if (str == null || "undefined".equals(str)) {
                        f.a(this.c.g, bVar.c() + ": onJsResult: result of command is undefined: " + b);
                        bVar.a();
                        return;
                    }
                    bVar.a(str);
                }
            };
            f.e(this.g, bVar.c() + ": initialized");
            try {
                if (!a(this.h, this.i, b, anonymousClass3)) {
                    f.b(this.g, bVar.c() + ": evaluateBlocking was interrupted");
                    bVar.a();
                }
            } catch (Throwable e) {
                f.a(this.g, bVar.c() + ": failed when executing command: " + b, e);
                com.getpebble.android.common.a.b(new Throwable(this.g + ":" + bVar.c(), e));
            }
            f.d(this.g, bVar.c() + ": took " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
        } else {
            f.a(this.g, bVar.c() + ": failed to init health JS runner, failing calculation");
            bVar.a();
        }
        return this;
    }

    private boolean a(final m mVar, Handler handler, final String str, final c cVar) {
        final com.getpebble.android.common.b.b.g.a aVar = new com.getpebble.android.common.b.b.g.a(k);
        f.e(this.g, "evaluating: " + str);
        final com.getpebble.android.common.framework.b.m.c anonymousClass4 = new com.getpebble.android.common.framework.b.m.c(this) {
            final /* synthetic */ a c;

            public void a(String str) {
                cVar.a(str);
                aVar.b();
            }
        };
        handler.post(new Runnable(this) {
            final /* synthetic */ a d;

            public void run() {
                mVar.a(str, anonymousClass4);
            }
        });
        return aVar.a();
    }
}
