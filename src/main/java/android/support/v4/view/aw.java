package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class aw {
    static final g a;
    private WeakReference<View> b;
    private Runnable c = null;
    private Runnable d = null;
    private int e = -1;

    interface g {
        void a(aw awVar, View view);

        void a(aw awVar, View view, float f);

        void a(aw awVar, View view, long j);

        void a(aw awVar, View view, az azVar);

        void b(aw awVar, View view);

        void b(aw awVar, View view, float f);

        void c(aw awVar, View view, float f);
    }

    static class a implements g {
        WeakHashMap<View, Runnable> a = null;

        class a implements Runnable {
            WeakReference<View> a;
            aw b;
            final /* synthetic */ a c;

            private a(a aVar, aw awVar, View view) {
                this.c = aVar;
                this.a = new WeakReference(view);
                this.b = awVar;
            }

            public void run() {
                View view = (View) this.a.get();
                if (view != null) {
                    this.c.c(this.b, view);
                }
            }
        }

        a() {
        }

        public void a(aw awVar, View view, long j) {
        }

        public void a(aw awVar, View view, float f) {
            d(awVar, view);
        }

        public void b(aw awVar, View view, float f) {
            d(awVar, view);
        }

        public void c(aw awVar, View view, float f) {
            d(awVar, view);
        }

        public void a(aw awVar, View view) {
            d(awVar, view);
        }

        public void b(aw awVar, View view) {
            a(view);
            c(awVar, view);
        }

        public void a(aw awVar, View view, az azVar) {
            view.setTag(2113929216, azVar);
        }

        private void c(aw awVar, View view) {
            az azVar;
            Object tag = view.getTag(2113929216);
            if (tag instanceof az) {
                azVar = (az) tag;
            } else {
                azVar = null;
            }
            Runnable a = awVar.c;
            Runnable b = awVar.d;
            awVar.c = null;
            awVar.d = null;
            if (a != null) {
                a.run();
            }
            if (azVar != null) {
                azVar.a(view);
                azVar.b(view);
            }
            if (b != null) {
                b.run();
            }
            if (this.a != null) {
                this.a.remove(view);
            }
        }

        private void a(View view) {
            if (this.a != null) {
                Runnable runnable = (Runnable) this.a.get(view);
                if (runnable != null) {
                    view.removeCallbacks(runnable);
                }
            }
        }

        private void d(aw awVar, View view) {
            Runnable runnable;
            if (this.a != null) {
                runnable = (Runnable) this.a.get(view);
            } else {
                runnable = null;
            }
            if (runnable == null) {
                runnable = new a(awVar, view);
                if (this.a == null) {
                    this.a = new WeakHashMap();
                }
                this.a.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }
    }

    static class b extends a {
        WeakHashMap<View, Integer> b = null;

        static class a implements az {
            aw a;
            boolean b;

            a(aw awVar) {
                this.a = awVar;
            }

            public void a(View view) {
                az azVar;
                this.b = false;
                if (this.a.e >= 0) {
                    ah.a(view, 2, null);
                }
                if (this.a.c != null) {
                    Runnable a = this.a.c;
                    this.a.c = null;
                    a.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof az) {
                    azVar = (az) tag;
                } else {
                    azVar = null;
                }
                if (azVar != null) {
                    azVar.a(view);
                }
            }

            public void b(View view) {
                if (this.a.e >= 0) {
                    ah.a(view, this.a.e, null);
                    this.a.e = -1;
                }
                if (VERSION.SDK_INT >= 16 || !this.b) {
                    az azVar;
                    if (this.a.d != null) {
                        Runnable b = this.a.d;
                        this.a.d = null;
                        b.run();
                    }
                    Object tag = view.getTag(2113929216);
                    if (tag instanceof az) {
                        azVar = (az) tag;
                    } else {
                        azVar = null;
                    }
                    if (azVar != null) {
                        azVar.b(view);
                    }
                    this.b = true;
                }
            }

            public void c(View view) {
                az azVar;
                Object tag = view.getTag(2113929216);
                if (tag instanceof az) {
                    azVar = (az) tag;
                } else {
                    azVar = null;
                }
                if (azVar != null) {
                    azVar.c(view);
                }
            }
        }

        b() {
        }

        public void a(aw awVar, View view, long j) {
            ax.a(view, j);
        }

        public void a(aw awVar, View view, float f) {
            ax.a(view, f);
        }

        public void b(aw awVar, View view, float f) {
            ax.b(view, f);
        }

        public void c(aw awVar, View view, float f) {
            ax.c(view, f);
        }

        public void a(aw awVar, View view) {
            ax.a(view);
        }

        public void b(aw awVar, View view) {
            ax.b(view);
        }

        public void a(aw awVar, View view, az azVar) {
            view.setTag(2113929216, azVar);
            ax.a(view, new a(awVar));
        }
    }

    static class d extends b {
        d() {
        }

        public void a(aw awVar, View view, az azVar) {
            ay.a(view, azVar);
        }
    }

    static class c extends d {
        c() {
        }
    }

    static class e extends c {
        e() {
        }
    }

    static class f extends e {
        f() {
        }
    }

    aw(View view) {
        this.b = new WeakReference(view);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            a = new f();
        } else if (i >= 19) {
            a = new e();
        } else if (i >= 18) {
            a = new c();
        } else if (i >= 16) {
            a = new d();
        } else if (i >= 14) {
            a = new b();
        } else {
            a = new a();
        }
    }

    public aw a(long j) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, j);
        }
        return this;
    }

    public aw a(float f) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, f);
        }
        return this;
    }

    public aw b(float f) {
        View view = (View) this.b.get();
        if (view != null) {
            a.b(this, view, f);
        }
        return this;
    }

    public aw c(float f) {
        View view = (View) this.b.get();
        if (view != null) {
            a.c(this, view, f);
        }
        return this;
    }

    public void a() {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view);
        }
    }

    public void b() {
        View view = (View) this.b.get();
        if (view != null) {
            a.b(this, view);
        }
    }

    public aw a(az azVar) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, azVar);
        }
        return this;
    }
}
