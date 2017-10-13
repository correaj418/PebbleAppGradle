package com.b.a;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class x implements com.b.a.a.d {
    static Hashtable<Class, Method> d = new Hashtable();
    m a;
    ByteOrder b = ByteOrder.BIG_ENDIAN;
    k c = new k();
    private d e = new d(this, 0) {
        final /* synthetic */ x a;

        public d a(m mVar, k kVar) {
            this.a.n.add(null);
            return null;
        }
    };
    private d f = new d(this, 1) {
        final /* synthetic */ x a;

        public d a(m mVar, k kVar) {
            this.a.n.add(Byte.valueOf(kVar.i()));
            return null;
        }
    };
    private d g = new d(this, 2) {
        final /* synthetic */ x a;

        public d a(m mVar, k kVar) {
            this.a.n.add(Short.valueOf(kVar.h()));
            return null;
        }
    };
    private d h = new d(this, 4) {
        final /* synthetic */ x a;

        public d a(m mVar, k kVar) {
            this.a.n.add(Integer.valueOf(kVar.f()));
            return null;
        }
    };
    private d i = new d(this, 8) {
        final /* synthetic */ x a;

        public d a(m mVar, k kVar) {
            this.a.n.add(Long.valueOf(kVar.j()));
            return null;
        }
    };
    private b<byte[]> j = new b<byte[]>(this) {
        final /* synthetic */ x a;

        {
            this.a = r1;
        }

        public void a(byte[] bArr) {
            this.a.n.add(bArr);
        }
    };
    private b<k> k = new b<k>(this) {
        final /* synthetic */ x a;

        {
            this.a = r1;
        }

        public void a(k kVar) {
            this.a.n.add(kVar);
        }
    };
    private b<byte[]> l = new b<byte[]>(this) {
        final /* synthetic */ x a;

        {
            this.a = r1;
        }

        public void a(byte[] bArr) {
            this.a.n.add(new String(bArr));
        }
    };
    private LinkedList<d> m = new LinkedList();
    private ArrayList<Object> n = new ArrayList();

    public interface b<T> {
        void a(T t);
    }

    static abstract class d {
        int c;

        public abstract d a(m mVar, k kVar);

        public d(int i) {
            this.c = i;
        }
    }

    static class a extends d {
        b<byte[]> a;

        public a(int i, b<byte[]> bVar) {
            super(i);
            if (i <= 0) {
                throw new IllegalArgumentException("length should be > 0");
            }
            this.a = bVar;
        }

        public d a(m mVar, k kVar) {
            byte[] bArr = new byte[this.c];
            kVar.a(bArr);
            this.a.a(bArr);
            return null;
        }
    }

    static class c extends d {
        byte a;
        com.b.a.a.d b;

        public c(byte b, com.b.a.a.d dVar) {
            super(1);
            this.a = b;
            this.b = dVar;
        }

        public d a(m mVar, k kVar) {
            k kVar2 = new k();
            Object obj = 1;
            while (kVar.o() > 0) {
                ByteBuffer n = kVar.n();
                n.mark();
                int i = 0;
                while (n.remaining() > 0) {
                    Object obj2;
                    if (n.get() == this.a) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        obj = obj2;
                        break;
                    }
                    i++;
                    obj = obj2;
                }
                n.reset();
                if (obj != null) {
                    kVar.b(n);
                    kVar.a(kVar2, i);
                    kVar.i();
                    break;
                }
                kVar2.a(n);
            }
            this.b.a(mVar, kVar2);
            if (obj != null) {
                return null;
            }
            return this;
        }
    }

    public x(m mVar) {
        this.a = mVar;
        this.a.a(this);
    }

    public x a(int i, b<byte[]> bVar) {
        this.m.add(new a(i, bVar));
        return this;
    }

    public x a(byte b, com.b.a.a.d dVar) {
        this.m.add(new c(b, dVar));
        return this;
    }

    public void a(m mVar, k kVar) {
        kVar.a(this.c);
        while (this.m.size() > 0 && this.c.d() >= ((d) this.m.peek()).c) {
            this.c.a(this.b);
            d a = ((d) this.m.poll()).a(mVar, this.c);
            if (a != null) {
                this.m.addFirst(a);
            }
        }
        if (this.m.size() == 0) {
            this.c.a(kVar);
        }
    }
}
