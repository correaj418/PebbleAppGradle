package com.b.a.c.f;

import com.b.a.a.d;
import com.b.a.a.f;
import com.b.a.ac;
import com.b.a.c.u;
import com.b.a.g;
import com.b.a.i;
import com.b.a.j;
import com.b.a.k;
import com.b.a.m;
import com.b.a.p;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class a implements com.b.a.c.f.e.a {
    i a;
    j b;
    e c;
    f d;
    s e;
    Hashtable<Integer, a> f = new Hashtable();
    u g;
    boolean h = true;
    int i;
    final n j = new n();
    long k;
    n l = new n();
    boolean m;
    private int n;
    private int o;
    private int p;
    private boolean q = false;
    private Map<Integer, m> r;

    public class a implements i {
        long a = ((long) this.m.l.d(65536));
        f b;
        final int c;
        com.b.a.a.a d;
        com.b.a.a.a e;
        d f;
        k g = new k();
        com.b.a.b.i<List<g>> h = new com.b.a.b.i();
        boolean i = true;
        int j;
        boolean k;
        k l = new k();
        final /* synthetic */ a m;

        public a b() {
            return this.m;
        }

        public com.b.a.b.i<List<g>> c() {
            return this.h;
        }

        void a(int i) {
            this.j += i;
            if (this.j >= this.m.j.d(65536) / 2) {
                try {
                    this.m.d.a(this.c, (long) this.j);
                    this.j = 0;
                } catch (IOException e) {
                    throw new AssertionError(e);
                }
            }
            this.m.a(i);
        }

        public a(a aVar, int i, boolean z, boolean z2, List<g> list) {
            this.m = aVar;
            this.c = i;
        }

        public boolean e() {
            boolean z;
            if ((this.c & 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            return this.m.h == z;
        }

        public void a(long j) {
            long j2 = this.a;
            this.a += j;
            if (this.a > 0 && j2 <= 0) {
                ac.a(this.b);
            }
        }

        public g m() {
            return this.m.a.m();
        }

        public void a(d dVar) {
            this.f = dVar;
        }

        public d f() {
            return this.f;
        }

        public void n_() {
            this.k = true;
        }

        public void o_() {
            this.k = false;
        }

        public void d() {
            this.i = false;
        }

        public boolean l() {
            return this.k;
        }

        public void b(com.b.a.a.a aVar) {
            this.e = aVar;
        }

        public com.b.a.a.a h() {
            return this.e;
        }

        public String n() {
            return null;
        }

        public void a(k kVar) {
            int min = Math.min(kVar.d(), (int) Math.min(this.a, this.m.k));
            if (min != 0) {
                if (min < kVar.d()) {
                    if (this.l.e()) {
                        throw new AssertionError("wtf");
                    }
                    kVar.a(this.l, min);
                    kVar = this.l;
                }
                try {
                    this.m.d.a(false, this.c, kVar);
                    this.a -= (long) min;
                } catch (IOException e) {
                    throw new AssertionError(e);
                }
            }
        }

        public void a(f fVar) {
            this.b = fVar;
        }

        public f g() {
            return this.b;
        }

        public boolean i() {
            return this.i;
        }

        public void a() {
            try {
                this.m.d.a(true, this.c, this.l);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        public void a(com.b.a.a.a aVar) {
            this.d = aVar;
        }

        public void a(List<g> list, i iVar) {
            this.h.b((Object) list);
        }
    }

    public a a(List<g> list, boolean z, boolean z2) {
        return a(0, (List) list, z, z2);
    }

    private a a(int i, List<g> list, boolean z, boolean z2) {
        boolean z3 = true;
        boolean z4 = !z;
        if (z2) {
            z3 = false;
        }
        if (this.m) {
            return null;
        }
        int i2 = this.p;
        this.p += 2;
        a aVar = new a(this, i2, z4, z3, list);
        if (aVar.i()) {
            this.f.put(Integer.valueOf(i2), aVar);
        }
        if (i == 0) {
            try {
                this.d.a(z4, z3, i2, i, list);
                return aVar;
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        } else if (this.h) {
            throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
        } else {
            this.d.a(i, i2, (List) list);
            return aVar;
        }
    }

    void a(int i) {
        this.i += i;
        if (this.i >= this.j.d(65536) / 2) {
            try {
                this.d.a(0, (long) this.i);
                this.i = 0;
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    public a(i iVar, u uVar) {
        this.g = uVar;
        this.a = iVar;
        this.b = new j(iVar);
        if (uVar == u.SPDY_3) {
            this.e = new o();
        } else if (uVar == u.HTTP_2) {
            this.e = new k();
        }
        this.c = this.e.a(iVar, this, true);
        this.d = this.e.a(this.b, true);
        this.p = 1;
        if (uVar == u.HTTP_2) {
            this.p += 2;
        }
        this.n = 1;
        this.j.a(7, 0, 16777216);
    }

    public void a() {
        this.d.a();
        this.d.a(this.j);
        int d = this.j.d(65536);
        if (d != 65536) {
            this.d.a(0, (long) (d - 65536));
        }
    }

    private boolean b(int i) {
        return this.g == u.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    public void a(boolean z, int i, k kVar) {
        if (b(i)) {
            throw new AssertionError("push");
        }
        m mVar = (a) this.f.get(Integer.valueOf(i));
        if (mVar == null) {
            try {
                this.d.a(i, d.INVALID_STREAM);
                kVar.m();
                return;
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
        int d = kVar.d();
        kVar.a(mVar.g);
        mVar.a(d);
        ac.a(mVar, mVar.g);
        if (z) {
            this.f.remove(Integer.valueOf(i));
            mVar.d();
            ac.a(mVar, null);
        }
    }

    public void a(boolean z, boolean z2, int i, int i2, List<g> list, i iVar) {
        if (b(i)) {
            throw new AssertionError("push");
        } else if (!this.m) {
            m mVar = (a) this.f.get(Integer.valueOf(i));
            if (mVar == null) {
                if (iVar.failIfStreamAbsent()) {
                    try {
                        this.d.a(i, d.INVALID_STREAM);
                    } catch (IOException e) {
                        throw new AssertionError(e);
                    }
                } else if (i > this.o && i % 2 != this.p % 2) {
                    throw new AssertionError("unexpected receive stream");
                }
            } else if (iVar.failIfStreamPresent()) {
                try {
                    this.d.a(i, d.INVALID_STREAM);
                    this.f.remove(Integer.valueOf(i));
                } catch (IOException e2) {
                    throw new AssertionError(e2);
                }
            } else {
                mVar.a(list, iVar);
                if (z2) {
                    this.f.remove(Integer.valueOf(i));
                    ac.a(mVar, null);
                }
            }
        }
    }

    public void a(int i, d dVar) {
        if (b(i)) {
            throw new AssertionError("push");
        }
        m mVar = (a) this.f.remove(Integer.valueOf(i));
        if (mVar != null) {
            ac.a(mVar, new IOException(dVar.toString()));
        }
    }

    public void a(boolean z, n nVar) {
        long j = 0;
        int d = this.l.d(65536);
        if (z) {
            this.l.a();
        }
        this.l.a(nVar);
        try {
            this.d.b();
            int d2 = this.l.d(65536);
            if (!(d2 == -1 || d2 == d)) {
                j = (long) (d2 - d);
                if (!this.q) {
                    a(j);
                    this.q = true;
                }
            }
            long j2 = j;
            for (a a : this.f.values()) {
                a.a(j2);
            }
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    void a(long j) {
        this.k += j;
        for (p a : this.f.values()) {
            ac.a(a);
        }
    }

    public void b() {
        try {
            this.d.b();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    private void a(boolean z, int i, int i2, m mVar) {
        if (mVar != null) {
            mVar.a();
        }
        this.d.a(z, i, i2);
    }

    private synchronized m c(int i) {
        return this.r != null ? (m) this.r.remove(Integer.valueOf(i)) : null;
    }

    public void a(boolean z, int i, int i2) {
        if (z) {
            m c = c(i);
            if (c != null) {
                c.b();
                return;
            }
            return;
        }
        try {
            a(true, i, i2, null);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public void a(int i, d dVar, c cVar) {
        this.m = true;
        Iterator it = this.f.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (((Integer) entry.getKey()).intValue() > i && ((a) entry.getValue()).e()) {
                ac.a((m) entry.getValue(), new IOException(d.REFUSED_STREAM.toString()));
                it.remove();
            }
        }
    }

    public void a(int i, long j) {
        if (i == 0) {
            a(j);
            return;
        }
        a aVar = (a) this.f.get(Integer.valueOf(i));
        if (aVar != null) {
            aVar.a(j);
        }
    }

    public void a(int i, int i2, int i3, boolean z) {
    }

    public void a(int i, int i2, List<g> list) {
        throw new AssertionError("pushPromise");
    }

    public void a(Exception exception) {
        this.a.d();
        Iterator it = this.f.entrySet().iterator();
        while (it.hasNext()) {
            ac.a((m) ((Entry) it.next()).getValue(), exception);
            it.remove();
        }
    }
}
