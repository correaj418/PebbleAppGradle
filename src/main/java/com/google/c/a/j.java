package com.google.c.a;

import java.io.Serializable;

public final class j {

    public static class a implements Serializable {
        private boolean a;
        private int b = 0;
        private boolean c;
        private long d = 0;
        private boolean e;
        private String f = "";
        private boolean g;
        private boolean h = false;
        private boolean i;
        private int j = 1;
        private boolean k;
        private String l = "";
        private boolean m;
        private a n = a.FROM_NUMBER_WITH_PLUS_SIGN;
        private boolean o;
        private String p = "";

        public enum a {
            FROM_NUMBER_WITH_PLUS_SIGN,
            FROM_NUMBER_WITH_IDD,
            FROM_NUMBER_WITHOUT_PLUS_SIGN,
            FROM_DEFAULT_COUNTRY
        }

        public int a() {
            return this.b;
        }

        public a a(int i) {
            this.a = true;
            this.b = i;
            return this;
        }

        public long b() {
            return this.d;
        }

        public a a(long j) {
            this.c = true;
            this.d = j;
            return this;
        }

        public boolean c() {
            return this.e;
        }

        public String d() {
            return this.f;
        }

        public a a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.e = true;
            this.f = str;
            return this;
        }

        public boolean e() {
            return this.g;
        }

        public boolean f() {
            return this.h;
        }

        public a a(boolean z) {
            this.g = true;
            this.h = z;
            return this;
        }

        public boolean g() {
            return this.i;
        }

        public int h() {
            return this.j;
        }

        public a b(int i) {
            this.i = true;
            this.j = i;
            return this;
        }

        public boolean i() {
            return this.k;
        }

        public String j() {
            return this.l;
        }

        public a b(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.k = true;
            this.l = str;
            return this;
        }

        public boolean k() {
            return this.m;
        }

        public a l() {
            return this.n;
        }

        public a a(a aVar) {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.m = true;
            this.n = aVar;
            return this;
        }

        public a m() {
            this.m = false;
            this.n = a.FROM_NUMBER_WITH_PLUS_SIGN;
            return this;
        }

        public boolean n() {
            return this.o;
        }

        public String o() {
            return this.p;
        }

        public a c(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.o = true;
            this.p = str;
            return this;
        }

        public boolean a(a aVar) {
            if (aVar == null) {
                return false;
            }
            if (this == aVar) {
                return true;
            }
            if (this.b == aVar.b && this.d == aVar.d && this.f.equals(aVar.f) && this.h == aVar.h && this.j == aVar.j && this.l.equals(aVar.l) && this.n == aVar.n && this.p.equals(aVar.p) && n() == aVar.n()) {
                return true;
            }
            return false;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && a((a) obj);
        }

        public int hashCode() {
            int i = 1231;
            int a = ((((((((((f() ? 1231 : 1237) + ((((((a() + 2173) * 53) + Long.valueOf(b()).hashCode()) * 53) + d().hashCode()) * 53)) * 53) + h()) * 53) + j().hashCode()) * 53) + l().hashCode()) * 53) + o().hashCode()) * 53;
            if (!n()) {
                i = 1237;
            }
            return a + i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Country Code: ").append(this.b);
            stringBuilder.append(" National Number: ").append(this.d);
            if (e() && f()) {
                stringBuilder.append(" Leading Zero(s): true");
            }
            if (g()) {
                stringBuilder.append(" Number of leading zeros: ").append(this.j);
            }
            if (c()) {
                stringBuilder.append(" Extension: ").append(this.f);
            }
            if (k()) {
                stringBuilder.append(" Country Code Source: ").append(this.n);
            }
            if (n()) {
                stringBuilder.append(" Preferred Domestic Carrier Code: ").append(this.p);
            }
            return stringBuilder.toString();
        }
    }
}
