package com.google.b.b;

import com.google.b.b.a.n;
import com.google.b.d.c;
import com.google.b.l;
import com.google.b.m;
import com.google.b.u;
import java.io.Writer;

public final class j {

    private static final class a extends Writer {
        private final Appendable a;
        private final a b = new a();

        static class a implements CharSequence {
            char[] a;

            a() {
            }

            public int length() {
                return this.a.length;
            }

            public char charAt(int i) {
                return this.a[i];
            }

            public CharSequence subSequence(int i, int i2) {
                return new String(this.a, i, i2 - i);
            }
        }

        a(Appendable appendable) {
            this.a = appendable;
        }

        public void write(char[] cArr, int i, int i2) {
            this.b.a = cArr;
            this.a.append(this.b, i, i + i2);
        }

        public void write(int i) {
            this.a.append((char) i);
        }

        public void flush() {
        }

        public void close() {
        }
    }

    public static l a(com.google.b.d.a aVar) {
        Object obj = 1;
        try {
            aVar.f();
            obj = null;
            return (l) n.X.b(aVar);
        } catch (Throwable e) {
            if (obj != null) {
                return com.google.b.n.a;
            }
            throw new u(e);
        } catch (Throwable e2) {
            throw new u(e2);
        } catch (Throwable e22) {
            throw new m(e22);
        } catch (Throwable e222) {
            throw new u(e222);
        }
    }

    public static void a(l lVar, c cVar) {
        n.X.a(cVar, lVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }
}
