package com.b.a.c.e;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.b.a.a.e;
import com.b.a.ac;
import com.b.a.c.ab;
import com.b.a.c.n;
import com.b.a.c.q;
import com.b.a.c.u;
import com.b.a.c.z;
import com.b.a.g;
import com.b.a.h;
import com.b.a.i;
import com.b.a.k;
import com.b.a.m;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@TargetApi(5)
public class a {
    static Hashtable<String, String> e = new Hashtable();
    static final /* synthetic */ boolean f;
    private static Hashtable<Integer, String> g = new Hashtable();
    ArrayList<h> a = new ArrayList();
    e b = new e(this) {
        final /* synthetic */ a a;

        {
            this.a = r1;
        }

        public void a(final i iVar) {
            new c(this) {
                g d;
                String e;
                String f;
                boolean g;
                boolean h;
                e i;
                boolean j;
                final /* synthetic */ AnonymousClass1 l;

                protected com.b.a.c.a.a a(n nVar) {
                    return this.l.a.a(nVar);
                }

                protected void a() {
                    n b = b();
                    if (this.j || !"100-continue".equals(b.a("Expect"))) {
                        String[] split = e().split(" ");
                        this.e = split[1];
                        this.f = this.e.split("\\?")[0];
                        this.p = split[0];
                        synchronized (this.l.a.d) {
                            ArrayList arrayList = (ArrayList) this.l.a.d.get(this.p);
                            if (arrayList != null) {
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    a aVar = (a) it.next();
                                    Matcher matcher = aVar.a.matcher(this.f);
                                    if (matcher.matches()) {
                                        this.n = matcher;
                                        this.d = aVar.b;
                                        break;
                                    }
                                }
                            }
                        }
                        this.i = new e(this, iVar, this) {
                            final /* synthetic */ AnonymousClass1 a;

                            protected void b(Exception exception) {
                                super.b(exception);
                                if (exception != null) {
                                    iVar.a(new com.b.a.a.d.a());
                                    iVar.b(new com.b.a.a.a.a());
                                    iVar.d();
                                }
                            }

                            protected void b() {
                                super.b();
                                this.b.b(null);
                                this.a.g = true;
                                this.a.p();
                            }
                        };
                        boolean a = this.l.a.a((b) this, this.i);
                        if (this.d == null && !a) {
                            this.i.a(404);
                            this.i.a();
                            return;
                        } else if (!o().b()) {
                            this.l.a.a(this.d, (b) this, this.i);
                            return;
                        } else if (this.h) {
                            this.l.a.a(this.d, (b) this, this.i);
                            return;
                        } else {
                            return;
                        }
                    }
                    n_();
                    ac.a(this.m, "HTTP/1.1 100 Continue\r\n\r\n".getBytes(), new com.b.a.a.a(this) {
                        final /* synthetic */ AnonymousClass1 a;

                        {
                            this.a = r1;
                        }

                        public void a(Exception exception) {
                            this.a.o_();
                            if (exception != null) {
                                this.a.b(exception);
                                return;
                            }
                            this.a.j = true;
                            this.a.a();
                        }
                    });
                }

                public void a(Exception exception) {
                    if (this.i.f() != 101) {
                        this.h = true;
                        super.a(exception);
                        this.m.a(new com.b.a.a.d.a(this) {
                            final /* synthetic */ AnonymousClass1 a;

                            {
                                this.a = r1;
                            }

                            public void a(m mVar, k kVar) {
                                super.a(mVar, kVar);
                                this.a.m.d();
                            }
                        });
                        p();
                        if (o().b()) {
                            this.l.a.a(this.d, (b) this, this.i);
                        }
                    }
                }

                private void p() {
                    if (!this.h || !this.g) {
                        return;
                    }
                    if (q.a(u.HTTP_1_1, b())) {
                        this.l.a(iVar);
                    } else {
                        iVar.d();
                    }
                }
            }.a(iVar);
            iVar.o_();
        }

        public void a(Exception exception) {
            this.a.a(exception);
        }

        public void a(h hVar) {
            this.a.a.add(hVar);
        }
    };
    com.b.a.a.a c;
    final Hashtable<String, ArrayList<a>> d = new Hashtable();

    private static class a {
        Pattern a;
        g b;

        private a() {
        }
    }

    public interface b {
        void a(z zVar, b bVar);
    }

    static {
        boolean z;
        if (a.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f = z;
        g.put(Integer.valueOf(200), "OK");
        g.put(Integer.valueOf(202), "Accepted");
        g.put(Integer.valueOf(206), "Partial Content");
        g.put(Integer.valueOf(101), "Switching Protocols");
        g.put(Integer.valueOf(301), "Moved Permanently");
        g.put(Integer.valueOf(302), "Found");
        g.put(Integer.valueOf(404), "Not Found");
    }

    public a() {
        e.put("js", "application/javascript");
        e.put("json", "application/json");
        e.put("png", "image/png");
        e.put("jpg", "image/jpeg");
        e.put("html", "text/html");
        e.put("css", "text/css");
        e.put("mp4", "video/mp4");
        e.put("mov", "video/quicktime");
        e.put("wmv", "video/x-ms-wmv");
    }

    public void a() {
        if (this.a != null) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((h) it.next()).a();
            }
        }
    }

    protected boolean a(b bVar, d dVar) {
        return false;
    }

    protected void a(g gVar, b bVar, d dVar) {
        if (gVar != null) {
            gVar.a(bVar, dVar);
        }
    }

    protected com.b.a.c.a.a a(n nVar) {
        return new i(nVar.a("Content-Type"));
    }

    public h a(g gVar, int i) {
        return gVar.a(null, i, this.b);
    }

    private void a(Exception exception) {
        if (this.c != null) {
            this.c.a(exception);
        }
    }

    public h a(int i) {
        return a(g.a(), i);
    }

    public void a(com.b.a.a.a aVar) {
        this.c = aVar;
    }

    public void a(String str, String str2, g gVar) {
        a aVar = new a();
        aVar.a = Pattern.compile("^" + str2);
        aVar.b = gVar;
        synchronized (this.d) {
            ArrayList arrayList = (ArrayList) this.d.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.d.put(str, arrayList);
            }
            arrayList.add(aVar);
        }
    }

    public void a(String str, b bVar) {
        a(str, null, bVar);
    }

    public void a(String str, final String str2, final b bVar) {
        a(str, new g(this) {
            final /* synthetic */ a c;

            public void a(b bVar, d dVar) {
                Object obj = null;
                String a = bVar.b().a("Connection");
                if (a != null) {
                    for (String trim : a.split(",")) {
                        if ("Upgrade".equalsIgnoreCase(trim.trim())) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (!"websocket".equalsIgnoreCase(bVar.b().a("Upgrade")) || r0 == null) {
                    dVar.a(404);
                    dVar.a();
                    return;
                }
                if (TextUtils.equals(str2, bVar.b().a("Sec-WebSocket-Protocol"))) {
                    bVar.a(new ab(bVar, dVar), bVar);
                    return;
                }
                dVar.a(404);
                dVar.a();
            }
        });
    }

    public void a(String str, g gVar) {
        a("GET", str, gVar);
    }

    public static String a(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1) {
            String str2 = (String) e.get(str.substring(lastIndexOf + 1));
            if (str2 != null) {
                return str2;
            }
        }
        return null;
    }

    public static String b(int i) {
        String str = (String) g.get(Integer.valueOf(i));
        if (str == null) {
            return "Unknown";
        }
        return str;
    }
}
