package com.google.android.gms.b;

public interface f {

    public static final class a extends d {
        public String b;
        public b[] c;

        public a() {
            b();
        }

        public a b() {
            this.b = null;
            this.c = b.b();
            this.a = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.b == null) {
                if (aVar.b != null) {
                    return false;
                }
            } else if (!this.b.equals(aVar.b)) {
                return false;
            }
            return c.a(this.c, aVar.c);
        }

        public int hashCode() {
            return (((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + c.a(this.c);
        }
    }

    public static final class b extends d {
        private static volatile b[] e;
        public String b;
        public Integer c;
        public Boolean d;

        public b() {
            c();
        }

        public static b[] b() {
            if (e == null) {
                synchronized (c.c) {
                    if (e == null) {
                        e = new b[0];
                    }
                }
            }
            return e;
        }

        public b c() {
            this.b = null;
            this.d = null;
            this.a = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.b == null) {
                if (bVar.b != null) {
                    return false;
                }
            } else if (!this.b.equals(bVar.b)) {
                return false;
            }
            if (this.c == null) {
                if (bVar.c != null) {
                    return false;
                }
            } else if (!this.c.equals(bVar.c)) {
                return false;
            }
            return this.d == null ? bVar.d == null : this.d.equals(bVar.d);
        }

        public int hashCode() {
            int i = 0;
            int intValue = ((this.c == null ? 0 : this.c.intValue()) + (((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.d != null) {
                i = this.d.hashCode();
            }
            return intValue + i;
        }
    }
}
