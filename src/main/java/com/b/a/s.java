package com.b.a;

import com.b.a.a.d;
import com.b.a.f.g;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class s extends n {
    g c;
    File d;
    d e;
    boolean f;
    k g = new k();
    FileChannel h;
    Runnable i = new Runnable(this) {
        final /* synthetic */ s a;

        {
            this.a = r1;
        }

        public void run() {
            try {
                if (this.a.h == null) {
                    this.a.h = new FileInputStream(this.a.d).getChannel();
                }
                if (!this.a.g.c()) {
                    ac.a(this.a, this.a.g);
                    if (!this.a.g.c()) {
                        return;
                    }
                }
                do {
                    ByteBuffer c = k.c(8192);
                    if (-1 == this.a.h.read(c)) {
                        this.a.b(null);
                        return;
                    }
                    c.flip();
                    this.a.g.a(c);
                    ac.a(this.a, this.a.g);
                    if (this.a.g.d() != 0) {
                        return;
                    }
                } while (!this.a.l());
            } catch (Exception e) {
                this.a.b(e);
            }
        }
    };

    public s(g gVar, File file) {
        this.c = gVar;
        this.d = file;
        this.f = !gVar.c();
        if (!this.f) {
            a();
        }
    }

    public void a(d dVar) {
        this.e = dVar;
    }

    public d f() {
        return this.e;
    }

    public void n_() {
        this.f = true;
    }

    public void o_() {
        this.f = false;
        a();
    }

    protected void b(Exception exception) {
        g.a(this.h);
        super.b(exception);
    }

    private void a() {
        this.c.a(this.i);
    }

    public boolean l() {
        return this.f;
    }

    public g m() {
        return this.c;
    }

    public void d() {
        try {
            this.h.close();
        } catch (Exception e) {
        }
    }
}
