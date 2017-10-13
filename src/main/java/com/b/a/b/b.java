package com.b.a.b;

import com.b.a.a.a;
import com.b.a.a.c;
import java.util.LinkedList;

public class b extends h implements c, a, Runnable {
    a a;
    Runnable b;
    LinkedList<c> c;
    boolean d;
    private boolean i;
    private boolean j;

    public void a(a aVar) {
        this.a = aVar;
    }

    public b() {
        this(null);
    }

    public b(a aVar) {
        this(aVar, null);
    }

    public b(a aVar, Runnable runnable) {
        this.c = new LinkedList();
        this.b = runnable;
        this.a = aVar;
    }

    private a h() {
        return new a(this) {
            static final /* synthetic */ boolean b = (!b.class.desiredAssertionStatus());
            boolean a;
            final /* synthetic */ b c;

            {
                this.c = r1;
            }

            public void a(Exception exception) {
                if (!this.a) {
                    this.a = true;
                    if (b || this.c.j) {
                        this.c.j = false;
                        if (exception == null) {
                            this.c.i();
                            return;
                        } else {
                            this.c.a(exception);
                            return;
                        }
                    }
                    throw new AssertionError();
                }
            }
        };
    }

    void a(Exception exception) {
        if (f() && this.a != null) {
            this.a.a(exception);
        }
    }

    private c b(c cVar) {
        if (cVar instanceof c) {
            ((c) cVar).a(this);
        }
        return cVar;
    }

    public b a(c cVar) {
        this.c.add(b(cVar));
        return this;
    }

    private void i() {
        if (!this.i) {
            while (this.c.size() > 0 && !this.j && !isDone() && !isCancelled()) {
                c cVar = (c) this.c.remove();
                try {
                    this.i = true;
                    this.j = true;
                    cVar.a(this, h());
                } catch (Exception e) {
                    a(e);
                } finally {
                    this.i = false;
                }
            }
            if (!this.j && !isDone() && !isCancelled()) {
                a(null);
            }
        }
    }

    public boolean b() {
        if (!super.b()) {
            return false;
        }
        if (this.b != null) {
            this.b.run();
        }
        return true;
    }

    public b c() {
        if (this.d) {
            throw new IllegalStateException("already started");
        }
        this.d = true;
        i();
        return this;
    }

    public void a(b bVar, a aVar) {
        a(aVar);
        c();
    }

    public void run() {
        c();
    }
}
