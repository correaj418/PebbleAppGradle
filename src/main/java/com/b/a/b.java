package com.b.a;

import android.util.Log;
import com.b.a.a.d;
import com.b.a.a.f;
import com.b.a.f.a;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class b implements i {
    static final /* synthetic */ boolean j = (!b.class.desiredAssertionStatus());
    InetSocketAddress a;
    a b;
    boolean c;
    f d;
    d e;
    com.b.a.a.a f;
    boolean g;
    Exception h;
    boolean i = false;
    private l k;
    private SelectionKey l;
    private g m;
    private k n = new k();
    private com.b.a.a.a o;

    b() {
    }

    public void a() {
        this.k.a();
    }

    void a(SocketChannel socketChannel, InetSocketAddress inetSocketAddress) {
        this.a = inetSocketAddress;
        this.b = new a();
        this.k = new aa(socketChannel);
    }

    public void b() {
        if (!this.k.c()) {
            this.l.interestOps(this.l.interestOps() & -5);
        }
        if (this.d != null) {
            this.d.a();
        }
    }

    void a(g gVar, SelectionKey selectionKey) {
        this.m = gVar;
        this.l = selectionKey;
    }

    public void a(final k kVar) {
        if (this.m.b() != Thread.currentThread()) {
            this.m.b(new Runnable(this) {
                final /* synthetic */ b b;

                public void run() {
                    this.b.a(kVar);
                }
            });
        } else if (this.k.b()) {
            try {
                int d = kVar.d();
                ByteBuffer[] b = kVar.b();
                this.k.a(b);
                kVar.a(b);
                a(kVar.d());
                this.m.b(d - kVar.d());
            } catch (Exception e) {
                e();
                c(e);
                a(e);
            }
        } else if (!j && this.k.c()) {
            throw new AssertionError();
        }
    }

    private void a(int i) {
        if (!this.l.isValid()) {
            throw new IOException(new CancelledKeyException());
        } else if (i <= 0) {
            this.l.interestOps(this.l.interestOps() & -5);
        } else if (j || !this.k.c()) {
            this.l.interestOps(this.l.interestOps() | 4);
        } else {
            throw new AssertionError();
        }
    }

    int c() {
        int i = 0;
        o();
        if (!this.i) {
            try {
                int i2;
                ByteBuffer a = this.b.a();
                long read = (long) this.k.read(a);
                if (read < 0) {
                    e();
                    i2 = 1;
                } else {
                    i = (int) (((long) null) + read);
                    i2 = 0;
                }
                if (read > 0) {
                    this.b.a(read);
                    a.flip();
                    this.n.a(a);
                    ac.a((m) this, this.n);
                } else {
                    k.c(a);
                }
                if (i2 != 0) {
                    c(null);
                    a(null);
                }
            } catch (Exception e) {
                e();
                c(e);
                a(e);
            }
        }
        return i;
    }

    protected void a(Exception exception) {
        if (!this.c) {
            this.c = true;
            if (this.f != null) {
                this.f.a(exception);
                this.f = null;
            }
        }
    }

    public void d() {
        e();
        a(null);
    }

    public void e() {
        this.l.cancel();
        try {
            this.k.close();
        } catch (IOException e) {
        }
    }

    public void a(f fVar) {
        this.d = fVar;
    }

    public void a(d dVar) {
        this.e = dVar;
    }

    public d f() {
        return this.e;
    }

    public void a(com.b.a.a.a aVar) {
        this.f = aVar;
    }

    public f g() {
        return this.d;
    }

    void b(Exception exception) {
        if (!this.g) {
            this.g = true;
            if (this.o != null) {
                this.o.a(exception);
            } else if (exception != null) {
                Log.e("NIO", "Unhandled exception", exception);
            }
        }
    }

    void c(Exception exception) {
        if (this.n.e()) {
            this.h = exception;
        } else {
            b(exception);
        }
    }

    public void b(com.b.a.a.a aVar) {
        this.o = aVar;
    }

    public com.b.a.a.a h() {
        return this.o;
    }

    public boolean i() {
        return this.k.b() && this.l.isValid();
    }

    public void n_() {
        if (this.m.b() != Thread.currentThread()) {
            this.m.b(new Runnable(this) {
                final /* synthetic */ b a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.n_();
                }
            });
        } else if (!this.i) {
            this.i = true;
            try {
                this.l.interestOps(this.l.interestOps() & -2);
            } catch (Exception e) {
            }
        }
    }

    private void o() {
        if (this.n.e()) {
            ac.a((m) this, this.n);
        }
    }

    public void o_() {
        if (this.m.b() != Thread.currentThread()) {
            this.m.b(new Runnable(this) {
                final /* synthetic */ b a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.o_();
                }
            });
        } else if (this.i) {
            this.i = false;
            try {
                this.l.interestOps(this.l.interestOps() | 1);
            } catch (Exception e) {
            }
            o();
            if (!i()) {
                c(this.h);
            }
        }
    }

    public boolean l() {
        return this.i;
    }

    public g m() {
        return this.m;
    }

    public String n() {
        return null;
    }
}
