package com.b.a.e;

import com.b.a.a.a;
import com.b.a.a.d;
import com.b.a.ac;
import com.b.a.g;
import com.b.a.k;
import com.b.a.m;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class c implements m {
    g a;
    InputStream b;
    d c;
    boolean d;
    int e = 0;
    k f = new k();
    Runnable g = new Runnable(this) {
        final /* synthetic */ c a;

        {
            this.a = r1;
        }

        public void run() {
            try {
                if (!this.a.f.c()) {
                    this.a.m().b(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            ac.a(this.a.a, this.a.a.f);
                        }
                    });
                    if (!this.a.f.c()) {
                        return;
                    }
                }
                do {
                    ByteBuffer c = k.c(Math.min(Math.max(this.a.e, 4096), 262144));
                    int read = this.a.b.read(c.array());
                    if (-1 == read) {
                        this.a.a(null);
                        return;
                    }
                    this.a.e = read * 2;
                    c.limit(read);
                    this.a.f.a(c);
                    this.a.m().b(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            ac.a(this.a.a, this.a.a.f);
                        }
                    });
                    if (this.a.f.d() != 0) {
                        return;
                    }
                } while (!this.a.l());
            } catch (Exception e) {
                this.a.a(e);
            }
        }
    };
    a h;

    public c(g gVar, InputStream inputStream) {
        this.a = gVar;
        this.b = inputStream;
        a();
    }

    public void a(d dVar) {
        this.c = dVar;
    }

    public d f() {
        return this.c;
    }

    public void n_() {
        this.d = true;
    }

    public void o_() {
        this.d = false;
        a();
    }

    private void a(final Exception exception) {
        m().a(new Runnable(this) {
            final /* synthetic */ c b;

            public void run() {
                Exception exception = exception;
                try {
                    this.b.b.close();
                } catch (Exception e) {
                    exception = e;
                }
                if (this.b.h != null) {
                    this.b.h.a(exception);
                }
            }
        });
    }

    private void a() {
        new Thread(this.g).start();
    }

    public boolean l() {
        return this.d;
    }

    public void b(a aVar) {
        this.h = aVar;
    }

    public a h() {
        return this.h;
    }

    public g m() {
        return this.a;
    }

    public void d() {
        a(null);
        try {
            this.b.close();
        } catch (Exception e) {
        }
    }

    public String n() {
        return null;
    }
}
