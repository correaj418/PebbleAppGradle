package com.getpebble.android.main.sections.mypebble.d;

import com.getpebble.android.h.p;

public abstract class e implements g {
    private com.getpebble.android.main.sections.mypebble.d.d.h a;
    private com.getpebble.android.main.sections.mypebble.d.d.h b;
    private com.getpebble.android.main.sections.mypebble.d.d.h c;

    interface e {
        com.getpebble.android.main.sections.mypebble.d.d.h a();
    }

    static class a implements e {
        @com.google.b.a.c(a = "start")
        long a;
        @com.google.b.a.c(a = "end")
        long b;
        @com.google.b.a.c(a = "typical")
        j c;

        a() {
        }

        public com.getpebble.android.main.sections.mypebble.d.d.h a() {
            return new b(this);
        }
    }

    static class b implements e {
        @com.google.b.a.c(a = "start")
        long a;
        @com.google.b.a.c(a = "end")
        long b;

        b() {
        }

        public com.getpebble.android.main.sections.mypebble.d.d.h a() {
            return new c(this);
        }
    }

    static class c implements e {
        @com.google.b.a.c(a = "start")
        long a;
        @com.google.b.a.c(a = "end")
        long b;
        @com.google.b.a.c(a = "typical")
        j c;

        c() {
        }

        public com.getpebble.android.main.sections.mypebble.d.d.h a() {
            return new d(this);
        }
    }

    static class i {
        @com.google.b.a.c(a = "start")
        long c;
        @com.google.b.a.c(a = "end")
        long d;
    }

    static class d extends i {
        @com.google.b.a.c(a = "label")
        String a;
        @com.google.b.a.c(a = "shortLabel")
        String b;
    }

    static class f implements e {
        @com.google.b.a.c(a = "weeks")
        d[] a;

        f() {
        }

        public com.getpebble.android.main.sections.mypebble.d.d.h a() {
            return new i(this);
        }
    }

    static class g implements e {
        g() {
        }

        public com.getpebble.android.main.sections.mypebble.d.d.h a() {
            com.getpebble.android.common.b.a.f.f("HealthQueryHandler", "Monthly Heart Rate queries are currently unsupported (since 4.1)");
            return null;
        }
    }

    static class h implements e {
        @com.google.b.a.c(a = "weeks")
        d[] a;

        h() {
        }

        public com.getpebble.android.main.sections.mypebble.d.d.h a() {
            return new j(this);
        }
    }

    static class j {
        @com.google.b.a.c(a = "isoWeekday")
        int a;
    }

    static class k implements e {
        @com.google.b.a.c(a = "days")
        d[] a;

        k() {
        }

        public com.getpebble.android.main.sections.mypebble.d.d.h a() {
            return new m(this);
        }
    }

    static class l implements e {
        @com.google.b.a.c(a = "days")
        d[] a;

        l() {
        }

        public com.getpebble.android.main.sections.mypebble.d.d.h a() {
            return new n(this);
        }
    }

    static class m implements e {
        @com.google.b.a.c(a = "days")
        d[] a;

        m() {
        }

        public com.getpebble.android.main.sections.mypebble.d.d.h a() {
            return new o(this);
        }
    }

    public abstract void a(com.getpebble.android.main.sections.mypebble.d.b.c cVar);

    public void a(com.getpebble.android.main.sections.mypebble.d.b.c cVar, com.getpebble.android.main.sections.mypebble.d.b.b bVar, String str) {
        com.getpebble.android.common.b.a.f.d("HealthQueryHandler", "Parsing query: " + str + " type = " + cVar + " resolution = " + bVar);
        Class cls = null;
        try {
            switch (cVar) {
                case SLEEP:
                    switch (bVar) {
                        case DAY:
                            cls = c.class;
                            break;
                        case WEEK:
                            cls = m.class;
                            break;
                        case MONTH:
                            cls = h.class;
                            break;
                        default:
                            com.getpebble.android.common.b.a.f.d("HealthQueryHandler", "Unhandled sleep resolution: " + bVar.key);
                            return;
                    }
                case ACTIVITY:
                    switch (bVar) {
                        case DAY:
                            cls = a.class;
                            break;
                        case WEEK:
                            cls = k.class;
                            break;
                        case MONTH:
                            cls = f.class;
                            break;
                        default:
                            com.getpebble.android.common.b.a.f.d("HealthQueryHandler", "Unhandled activity resolution: " + bVar.key);
                            return;
                    }
                case HEART_RATE:
                    switch (bVar) {
                        case DAY:
                            cls = b.class;
                            break;
                        case WEEK:
                            cls = l.class;
                            break;
                        case MONTH:
                            cls = g.class;
                            break;
                        default:
                            com.getpebble.android.common.b.a.f.d("HealthQueryHandler", "Unhandled activity resolution: " + bVar.key);
                            return;
                    }
            }
            com.getpebble.android.main.sections.mypebble.d.d.h a = a(str, cls);
            if (a == null) {
                com.getpebble.android.common.b.a.f.b("HealthQueryHandler", "onQueryReceived: loadable is null");
                return;
            }
            switch (cVar) {
                case SLEEP:
                    this.b = a;
                    break;
                case ACTIVITY:
                    this.a = a;
                    break;
                case HEART_RATE:
                    this.c = a;
                    break;
            }
            a(cVar);
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.a("HealthQueryHandler", "Exception thrown when handling health chart query", e);
        }
    }

    public com.getpebble.android.main.sections.mypebble.d.d.h a() {
        return this.a;
    }

    public com.getpebble.android.main.sections.mypebble.d.d.h b() {
        return this.b;
    }

    public com.getpebble.android.main.sections.mypebble.d.d.h c() {
        return this.c;
    }

    static com.getpebble.android.main.sections.mypebble.d.d.h a(String str, Class cls) {
        try {
            Object a = p.a(str, cls);
            if (a instanceof e) {
                return ((e) a).a();
            }
            com.getpebble.android.common.b.a.f.c("HealthQueryHandler", "getLoadable: object = " + a);
            return null;
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.d("HealthQueryHandler", "Exception marshalling to: " + cls + " " + str, e);
            return null;
        }
    }
}
