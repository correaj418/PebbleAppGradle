package com.b.a.c;

import android.net.Uri;
import com.b.a.b.h;
import com.b.a.c.b.g;
import com.b.a.k;
import com.b.a.m;
import java.util.Hashtable;

public class i extends y {
    String e;
    int f;
    int g;
    protected a h;
    boolean i;
    String j;
    int k;
    Hashtable<String, a> l;
    int m;

    static class a {
        int a;
        com.b.a.a<com.b.a.c.b.a> b = new com.b.a.a();
        com.b.a.a<b> c = new com.b.a.a();

        a() {
        }
    }

    class b {
        com.b.a.i a;
        long b = System.currentTimeMillis();
        final /* synthetic */ i c;

        public b(i iVar, com.b.a.i iVar2) {
            this.c = iVar;
            this.a = iVar2;
        }
    }

    public i(a aVar, String str, int i) {
        this.g = 300000;
        this.l = new Hashtable();
        this.m = Integer.MAX_VALUE;
        this.h = aVar;
        this.e = str;
        this.f = i;
    }

    public int a(Uri uri) {
        if (uri.getScheme() == null || !uri.getScheme().equals(this.e)) {
            return -1;
        }
        if (uri.getPort() == -1) {
            return this.f;
        }
        return uri.getPort();
    }

    public i(a aVar) {
        this(aVar, "http", 80);
    }

    protected com.b.a.a.b a(com.b.a.c.b.a aVar, Uri uri, int i, boolean z, com.b.a.a.b bVar) {
        return bVar;
    }

    public void a(boolean z) {
        this.i = z;
    }

    String a(Uri uri, int i, String str, int i2) {
        String str2;
        if (str != null) {
            str2 = str + ":" + i2;
        } else {
            str2 = "";
        }
        if (str != null) {
            str2 = str + ":" + i2;
        }
        return uri.getScheme() + "//" + uri.getHost() + ":" + i + "?proxy=" + str2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.b.a.b.a a(final com.b.a.c.b.a r11) {
        /*
        r10 = this;
        r0 = 0;
        r1 = r11.j;
        r2 = r1.d();
        r1 = r11.j;
        r1 = r1.d();
        r3 = r10.a(r1);
        r1 = -1;
        if (r3 != r1) goto L_0x0015;
    L_0x0014:
        return r0;
    L_0x0015:
        r0 = r11.i;
        r1 = "socket-owner";
        r0.a(r1, r10);
        r0 = r11.j;
        r0 = r0.i();
        r1 = r11.j;
        r1 = r1.j();
        r0 = r10.a(r2, r3, r0, r1);
        r1 = r10.a(r0);
        monitor-enter(r10);
        r0 = r1.a;	 Catch:{ all -> 0x0043 }
        r4 = r10.m;	 Catch:{ all -> 0x0043 }
        if (r0 < r4) goto L_0x0046;
    L_0x0037:
        r0 = new com.b.a.b.h;	 Catch:{ all -> 0x0043 }
        r0.<init>();	 Catch:{ all -> 0x0043 }
        r1 = r1.b;	 Catch:{ all -> 0x0043 }
        r1.add(r11);	 Catch:{ all -> 0x0043 }
        monitor-exit(r10);	 Catch:{ all -> 0x0043 }
        goto L_0x0014;
    L_0x0043:
        r0 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x0043 }
        throw r0;
    L_0x0046:
        r0 = r1.a;	 Catch:{ all -> 0x0043 }
        r0 = r0 + 1;
        r1.a = r0;	 Catch:{ all -> 0x0043 }
    L_0x004c:
        r0 = r1.c;	 Catch:{ all -> 0x0043 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0043 }
        if (r0 != 0) goto L_0x0091;
    L_0x0054:
        r0 = r1.c;	 Catch:{ all -> 0x0043 }
        r0 = r0.g();	 Catch:{ all -> 0x0043 }
        r0 = (com.b.a.c.i.b) r0;	 Catch:{ all -> 0x0043 }
        r4 = r0.a;	 Catch:{ all -> 0x0043 }
        r6 = r0.b;	 Catch:{ all -> 0x0043 }
        r0 = r10.g;	 Catch:{ all -> 0x0043 }
        r8 = (long) r0;	 Catch:{ all -> 0x0043 }
        r6 = r6 + r8;
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0043 }
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 >= 0) goto L_0x0074;
    L_0x006c:
        r0 = 0;
        r4.a(r0);	 Catch:{ all -> 0x0043 }
        r4.d();	 Catch:{ all -> 0x0043 }
        goto L_0x004c;
    L_0x0074:
        r0 = r4.i();	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x004c;
    L_0x007a:
        r0 = r11.j;	 Catch:{ all -> 0x0043 }
        r1 = "Reusing keep-alive socket";
        r0.c(r1);	 Catch:{ all -> 0x0043 }
        r0 = r11.a;	 Catch:{ all -> 0x0043 }
        r1 = 0;
        r0.a(r1, r4);	 Catch:{ all -> 0x0043 }
        r0 = new com.b.a.b.h;	 Catch:{ all -> 0x0043 }
        r0.<init>();	 Catch:{ all -> 0x0043 }
        r0.f();	 Catch:{ all -> 0x0043 }
        monitor-exit(r10);	 Catch:{ all -> 0x0043 }
        goto L_0x0014;
    L_0x0091:
        monitor-exit(r10);	 Catch:{ all -> 0x0043 }
        r0 = r10.i;
        if (r0 == 0) goto L_0x00a2;
    L_0x0096:
        r0 = r10.j;
        if (r0 != 0) goto L_0x00a2;
    L_0x009a:
        r0 = r11.j;
        r0 = r0.i();
        if (r0 == 0) goto L_0x0115;
    L_0x00a2:
        r0 = r11.j;
        r1 = "Connecting socket";
        r0.c(r1);
        r4 = 0;
        r0 = r11.j;
        r0 = r0.i();
        if (r0 != 0) goto L_0x00bf;
    L_0x00b2:
        r0 = r10.j;
        if (r0 == 0) goto L_0x00bf;
    L_0x00b6:
        r0 = r11.j;
        r1 = r10.j;
        r5 = r10.k;
        r0.a(r1, r5);
    L_0x00bf:
        r0 = r11.j;
        r0 = r0.i();
        if (r0 == 0) goto L_0x010e;
    L_0x00c7:
        r0 = r11.j;
        r1 = r0.i();
        r0 = r11.j;
        r0 = r0.j();
        r4 = 1;
        r6 = r0;
        r7 = r1;
    L_0x00d6:
        if (r4 == 0) goto L_0x00fa;
    L_0x00d8:
        r0 = r11.j;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r5 = "Using proxy: ";
        r1 = r1.append(r5);
        r1 = r1.append(r7);
        r5 = ":";
        r1 = r1.append(r5);
        r1 = r1.append(r6);
        r1 = r1.toString();
        r0.b(r1);
    L_0x00fa:
        r0 = r10.h;
        r8 = r0.e();
        r5 = r11.a;
        r0 = r10;
        r1 = r11;
        r0 = r0.a(r1, r2, r3, r4, r5);
        r0 = r8.a(r7, r6, r0);
        goto L_0x0014;
    L_0x010e:
        r0 = r2.getHost();
        r6 = r3;
        r7 = r0;
        goto L_0x00d6;
    L_0x0115:
        r0 = r11.j;
        r1 = "Resolving domain and connecting to all available addresses";
        r0.b(r1);
        r0 = r10.h;
        r0 = r0.e();
        r1 = r2.getHost();
        r0 = r0.a(r1);
        r1 = new com.b.a.c.i$1;
        r1.<init>(r10, r11, r2, r3);
        r0 = r0.b(r1);
        r0 = (com.b.a.b.a) r0;
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.c.i.a(com.b.a.c.b$a):com.b.a.b.a");
    }

    private a a(String str) {
        a aVar = (a) this.l.get(str);
        if (aVar != null) {
            return aVar;
        }
        aVar = new a();
        this.l.put(str, aVar);
        return aVar;
    }

    private void b(String str) {
        a aVar = (a) this.l.get(str);
        if (aVar != null) {
            while (!aVar.c.isEmpty()) {
                b bVar = (b) aVar.c.f();
                com.b.a.i iVar = bVar.a;
                if (bVar.b + ((long) this.g) > System.currentTimeMillis()) {
                    break;
                }
                aVar.c.g();
                iVar.a(null);
                iVar.d();
            }
            if (aVar.a == 0 && aVar.b.isEmpty() && aVar.c.isEmpty()) {
                this.l.remove(str);
            }
        }
    }

    private void a(com.b.a.i iVar, d dVar) {
        if (iVar != null) {
            final com.b.a.a aVar;
            Uri d = dVar.d();
            final String a = a(d, a(d), dVar.i(), dVar.j());
            final b bVar = new b(this, iVar);
            synchronized (this) {
                aVar = a(a).c;
                aVar.e(bVar);
            }
            iVar.a(new com.b.a.a.a(this) {
                final /* synthetic */ i d;

                public void a(Exception exception) {
                    synchronized (this.d) {
                        aVar.remove(bVar);
                        this.d.b(a);
                    }
                }
            });
        }
    }

    private void a(final com.b.a.i iVar) {
        iVar.b(new com.b.a.a.a(this) {
            final /* synthetic */ i b;

            public void a(Exception exception) {
                iVar.a(null);
                iVar.d();
            }
        });
        iVar.a(null);
        iVar.a(new com.b.a.a.d.a(this) {
            final /* synthetic */ i b;

            public void a(m mVar, k kVar) {
                super.a(mVar, kVar);
                kVar.m();
                iVar.a(null);
                iVar.d();
            }
        });
    }

    private void a(d dVar) {
        Uri d = dVar.d();
        String a = a(d, a(d), dVar.i(), dVar.j());
        synchronized (this) {
            a aVar = (a) this.l.get(a);
            if (aVar == null) {
                return;
            }
            aVar.a--;
            while (aVar.a < this.m && aVar.b.size() > 0) {
                com.b.a.c.b.a aVar2 = (com.b.a.c.b.a) aVar.b.remove();
                h hVar = (h) aVar2.b;
                if (!hVar.isCancelled()) {
                    hVar.b(a(aVar2));
                }
            }
            b(a);
        }
    }

    public void a(g gVar) {
        if (gVar.i.b("socket-owner") == this) {
            try {
                a(gVar.e);
                if (gVar.k != null || !gVar.e.i()) {
                    gVar.j.b("closing out socket (exception)");
                    gVar.e.a(null);
                    gVar.e.d();
                } else if (q.a(gVar.f.k_(), gVar.f.k()) && q.a(u.HTTP_1_1, gVar.j.e())) {
                    gVar.j.c("Recycling keep-alive socket");
                    a(gVar.e, gVar.j);
                    a(gVar.j);
                } else {
                    gVar.j.b("closing out socket (not keep alive)");
                    gVar.e.a(null);
                    gVar.e.d();
                    a(gVar.j);
                }
            } finally {
                a(gVar.j);
            }
        }
    }
}
