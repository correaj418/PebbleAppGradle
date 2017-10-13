package com.google.b.b.a;

import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.i;
import com.google.b.l;
import com.google.b.n;
import com.google.b.o;
import com.google.b.r;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;

public final class e extends a {
    private static final Reader b = new Reader() {
        public int read(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        public void close() {
            throw new AssertionError();
        }
    };
    private static final Object c = new Object();
    private Object[] d = new Object[32];
    private int e = 0;
    private String[] f = new String[32];
    private int[] g = new int[32];

    public e(l lVar) {
        super(b);
        a((Object) lVar);
    }

    public void a() {
        a(b.BEGIN_ARRAY);
        a(((i) s()).iterator());
        this.g[this.e - 1] = 0;
    }

    public void b() {
        a(b.END_ARRAY);
        t();
        t();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    public void c() {
        a(b.BEGIN_OBJECT);
        a(((o) s()).a().iterator());
    }

    public void d() {
        a(b.END_OBJECT);
        t();
        t();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    public boolean e() {
        b f = f();
        return (f == b.END_OBJECT || f == b.END_ARRAY) ? false : true;
    }

    public b f() {
        if (this.e == 0) {
            return b.END_DOCUMENT;
        }
        Object s = s();
        if (s instanceof Iterator) {
            boolean z = this.d[this.e - 2] instanceof o;
            Iterator it = (Iterator) s;
            if (!it.hasNext()) {
                return z ? b.END_OBJECT : b.END_ARRAY;
            } else {
                if (z) {
                    return b.NAME;
                }
                a(it.next());
                return f();
            }
        } else if (s instanceof o) {
            return b.BEGIN_OBJECT;
        } else {
            if (s instanceof i) {
                return b.BEGIN_ARRAY;
            }
            if (s instanceof r) {
                r rVar = (r) s;
                if (rVar.q()) {
                    return b.STRING;
                }
                if (rVar.a()) {
                    return b.BOOLEAN;
                }
                if (rVar.p()) {
                    return b.NUMBER;
                }
                throw new AssertionError();
            } else if (s instanceof n) {
                return b.NULL;
            } else {
                if (s == c) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object s() {
        return this.d[this.e - 1];
    }

    private Object t() {
        Object[] objArr = this.d;
        int i = this.e - 1;
        this.e = i;
        Object obj = objArr[i];
        this.d[this.e] = null;
        return obj;
    }

    private void a(b bVar) {
        if (f() != bVar) {
            throw new IllegalStateException("Expected " + bVar + " but was " + f() + u());
        }
    }

    public String g() {
        a(b.NAME);
        Entry entry = (Entry) ((Iterator) s()).next();
        String str = (String) entry.getKey();
        this.f[this.e - 1] = str;
        a(entry.getValue());
        return str;
    }

    public String h() {
        b f = f();
        if (f == b.STRING || f == b.NUMBER) {
            String c = ((r) t()).c();
            if (this.e > 0) {
                int[] iArr = this.g;
                int i = this.e - 1;
                iArr[i] = iArr[i] + 1;
            }
            return c;
        }
        throw new IllegalStateException("Expected " + b.STRING + " but was " + f + u());
    }

    public boolean i() {
        a(b.BOOLEAN);
        boolean g = ((r) t()).g();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
        return g;
    }

    public void j() {
        a(b.NULL);
        t();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    public double k() {
        b f = f();
        if (f == b.NUMBER || f == b.STRING) {
            double d = ((r) s()).d();
            if (q() || !(Double.isNaN(d) || Double.isInfinite(d))) {
                t();
                if (this.e > 0) {
                    int[] iArr = this.g;
                    int i = this.e - 1;
                    iArr[i] = iArr[i] + 1;
                }
                return d;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + d);
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f + u());
    }

    public long l() {
        b f = f();
        if (f == b.NUMBER || f == b.STRING) {
            long e = ((r) s()).e();
            t();
            if (this.e > 0) {
                int[] iArr = this.g;
                int i = this.e - 1;
                iArr[i] = iArr[i] + 1;
            }
            return e;
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f + u());
    }

    public int m() {
        b f = f();
        if (f == b.NUMBER || f == b.STRING) {
            int f2 = ((r) s()).f();
            t();
            if (this.e > 0) {
                int[] iArr = this.g;
                int i = this.e - 1;
                iArr[i] = iArr[i] + 1;
            }
            return f2;
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f + u());
    }

    public void close() {
        this.d = new Object[]{c};
        this.e = 1;
    }

    public void n() {
        if (f() == b.NAME) {
            g();
            this.f[this.e - 2] = "null";
        } else {
            t();
            this.f[this.e - 1] = "null";
        }
        int[] iArr = this.g;
        int i = this.e - 1;
        iArr[i] = iArr[i] + 1;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public void o() {
        a(b.NAME);
        Entry entry = (Entry) ((Iterator) s()).next();
        a(entry.getValue());
        a(new r((String) entry.getKey()));
    }

    private void a(Object obj) {
        if (this.e == this.d.length) {
            Object obj2 = new Object[(this.e * 2)];
            Object obj3 = new int[(this.e * 2)];
            Object obj4 = new String[(this.e * 2)];
            System.arraycopy(this.d, 0, obj2, 0, this.e);
            System.arraycopy(this.g, 0, obj3, 0, this.e);
            System.arraycopy(this.f, 0, obj4, 0, this.e);
            this.d = obj2;
            this.g = obj3;
            this.f = obj4;
        }
        Object[] objArr = this.d;
        int i = this.e;
        this.e = i + 1;
        objArr[i] = obj;
    }

    public String p() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.e) {
            if (this.d[i] instanceof i) {
                i++;
                if (this.d[i] instanceof Iterator) {
                    append.append('[').append(this.g[i]).append(']');
                }
            } else if (this.d[i] instanceof o) {
                i++;
                if (this.d[i] instanceof Iterator) {
                    append.append('.');
                    if (this.f[i] != null) {
                        append.append(this.f[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String u() {
        return " at path " + p();
    }
}
