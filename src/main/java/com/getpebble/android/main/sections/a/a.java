package com.getpebble.android.main.sections.a;

import com.a.a.a.e;
import com.a.a.a.h;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.model.b;
import com.getpebble.android.common.model.g;
import com.google.a.a.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class a {
    private static a a = null;
    private com.a.a.a.a b;
    private e c;

    public static class a {
        private String a;
        private String b;

        public static class a {
            private List<String> a = new ArrayList();
            private List<String> b = new ArrayList();

            public a(String str) {
                this.b.add("android");
                this.b.add(str);
                a(this.b);
            }

            private void a(List<String> list) {
                com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
                if (p != null && p.hwPlatform != null) {
                    list.add(p.hwPlatform.getPlatformCode().getCode());
                }
            }

            public a a() {
                this.a.add("android");
                return this;
            }

            public a b() {
                a(this.a);
                return this;
            }

            public a a(com.getpebble.android.main.sections.appstore.a.a.a aVar) {
                if (aVar == com.getpebble.android.main.sections.appstore.a.a.a.WATCH_FACES) {
                    this.a.add("watchface");
                } else {
                    this.a.add("(watchapp,companion-app)");
                }
                return this;
            }

            public a c() {
                return new a(f.a(',').a(this.a), f.a(',').a(this.b));
            }
        }

        private a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }
    }

    private a(com.getpebble.android.config.a aVar) {
        this.b = new com.a.a.a.a(aVar.W(), aVar.V());
        this.c = this.b.a(aVar.X());
    }

    public static a a(com.getpebble.android.config.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("BootConfig cannot be null");
        }
        if (a == null) {
            a = new a(aVar);
        }
        return a;
    }

    public void a(String str, int i, a aVar, final com.google.a.h.a.a<g[]> aVar2) {
        this.c.a(a(str, i, aVar), new com.a.a.a.a.a(this) {
            final /* synthetic */ a b;

            public void a(e eVar, h hVar, JSONObject jSONObject) {
                b a = b.a(jSONObject.toString());
                if (a == null || a.a() == null) {
                    aVar2.a(new g[0]);
                } else {
                    aVar2.a(a.a());
                }
            }

            public void a(e eVar, h hVar, com.a.a.a.b bVar) {
                aVar2.a((Throwable) bVar);
            }
        });
    }

    public void b(String str, int i, a aVar, final com.google.a.h.a.a<com.getpebble.android.common.model.f[]> aVar2) {
        this.c.a(a(str, i, aVar), new com.a.a.a.a.a(this) {
            final /* synthetic */ a b;

            public void a(e eVar, h hVar, JSONObject jSONObject) {
                b b = b.b(jSONObject.toString());
                if (b == null || b.a() == null) {
                    aVar2.a(new com.getpebble.android.common.model.f[0]);
                } else {
                    aVar2.a(b.a());
                }
            }

            public void a(e eVar, h hVar, com.a.a.a.b bVar) {
                aVar2.a((Throwable) bVar);
            }
        });
    }

    private static h a(String str, int i, a aVar) {
        return new h(str).b(aVar.a()).a(aVar.b()).b(i).a(0);
    }
}
