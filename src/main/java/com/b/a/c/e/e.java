package com.b.a.c.e;

import android.text.TextUtils;
import com.b.a.a.a;
import com.b.a.a.f;
import com.b.a.ac;
import com.b.a.c.d.c;
import com.b.a.c.n;
import com.b.a.c.q;
import com.b.a.c.u;
import com.b.a.g;
import com.b.a.i;
import com.b.a.k;
import com.b.a.p;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class e implements d {
    static final /* synthetic */ boolean k = (!e.class.desiredAssertionStatus());
    private n a = new n();
    i b;
    c c;
    boolean d = false;
    p e;
    f f;
    boolean g;
    boolean h;
    int i = 200;
    a j;
    private long l = -1;

    public n c() {
        return this.a;
    }

    e(i iVar, c cVar) {
        this.b = iVar;
        this.c = cVar;
        if (q.a(u.HTTP_1_1, cVar.b())) {
            this.a.a("Connection", "Keep-Alive");
        }
    }

    public void a(k kVar) {
        if (k || !this.h) {
            if (!this.d) {
                e();
            }
            if (kVar.d() != 0 && this.e != null) {
                this.e.a(kVar);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    void e() {
        if (!this.d) {
            this.d = true;
            String a = this.a.a("Transfer-Encoding");
            if ("".equals(a)) {
                this.a.c("Transfer-Encoding");
            }
            boolean z = ("Chunked".equalsIgnoreCase(a) || a == null) && !"close".equalsIgnoreCase(this.a.a("Connection"));
            if (this.l < 0) {
                Object a2 = this.a.a("Content-Length");
                if (!TextUtils.isEmpty(a2)) {
                    this.l = Long.valueOf(a2).longValue();
                }
            }
            if (this.l >= 0 || !z) {
                z = false;
            } else {
                this.a.a("Transfer-Encoding", "Chunked");
                z = true;
            }
            ac.a(this.b, this.a.e(String.format(Locale.ENGLISH, "HTTP/1.1 %s %s", new Object[]{Integer.valueOf(this.i), a.b(this.i)})).getBytes(), new a(this) {
                final /* synthetic */ e b;

                public void a(Exception exception) {
                    if (exception != null) {
                        this.b.b(exception);
                        return;
                    }
                    if (z) {
                        p cVar = new c(this.b.b);
                        cVar.a(0);
                        this.b.e = cVar;
                    } else {
                        this.b.e = this.b.b;
                    }
                    this.b.e.a(this.b.j);
                    this.b.j = null;
                    this.b.e.a(this.b.f);
                    this.b.f = null;
                    if (this.b.g) {
                        this.b.a();
                    } else {
                        this.b.m().a(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 a;

                            {
                                this.a = r1;
                            }

                            public void run() {
                                f g = this.a.b.g();
                                if (g != null) {
                                    g.a();
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void a(f fVar) {
        if (this.e != null) {
            this.e.a(fVar);
        } else {
            this.f = fVar;
        }
    }

    public f g() {
        if (this.e != null) {
            return this.e.g();
        }
        return this.f;
    }

    public void a() {
        if (!this.g) {
            this.g = true;
            if (!this.d || this.e != null) {
                if (!this.d) {
                    this.a.d("Transfer-Encoding");
                }
                if (this.e instanceof c) {
                    ((c) this.e).a(Integer.MAX_VALUE);
                    this.e.a(new k());
                    b();
                } else if (this.d) {
                    b();
                } else if (this.c.i().equalsIgnoreCase("HEAD")) {
                    d();
                    b();
                } else {
                    a("text/html", "");
                }
            }
        }
    }

    public void d() {
        e();
    }

    public void a(String str, byte[] bArr) {
        if (k || this.l < 0) {
            this.l = (long) bArr.length;
            this.a.a("Content-Length", Integer.toString(bArr.length));
            this.a.a("Content-Type", str);
            ac.a((p) this, bArr, new a(this) {
                final /* synthetic */ e a;

                {
                    this.a = r1;
                }

                public void a(Exception exception) {
                    this.a.b();
                }
            });
            return;
        }
        throw new AssertionError();
    }

    public void a(String str, String str2) {
        try {
            a(str, str2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    protected void b() {
        this.h = true;
    }

    protected void b(Exception exception) {
    }

    public d a(int i) {
        this.i = i;
        return this;
    }

    public int f() {
        return this.i;
    }

    public void a(Exception exception) {
        a();
    }

    public boolean i() {
        if (this.e != null) {
            return this.e.i();
        }
        return this.b.i();
    }

    public void a(a aVar) {
        if (this.e != null) {
            this.e.a(aVar);
        } else {
            this.j = aVar;
        }
    }

    public g m() {
        return this.b.m();
    }

    public String toString() {
        if (this.a == null) {
            return super.toString();
        }
        return this.a.e(String.format(Locale.ENGLISH, "HTTP/1.1 %s %s", new Object[]{Integer.valueOf(this.i), a.b(this.i)}));
    }
}
