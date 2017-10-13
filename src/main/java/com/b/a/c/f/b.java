package com.b.a.c.f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

interface b {

    public static final class a implements b {
        long a = 0;

        public void a() {
            this.a = 0;
        }

        public void a(int i) {
            this.a |= 1 << e(i);
        }

        public void b(int i) {
            this.a ^= 1 << e(i);
        }

        public boolean c(int i) {
            return ((this.a >> e(i)) & 1) == 1;
        }

        public void d(int i) {
            this.a <<= e(i);
        }

        public String toString() {
            return Long.toBinaryString(this.a);
        }

        public b b() {
            return new b();
        }

        private static int e(int i) {
            if (i >= 0 && i <= 63) {
                return i;
            }
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "input must be between 0 and 63: %s", new Object[]{Integer.valueOf(i)}));
        }
    }

    public static final class b implements b {
        long[] a;
        private int b;

        public b() {
            this.a = new long[1];
        }

        private b(a aVar) {
            this.a = new long[]{aVar.a, 0};
        }

        private void e(int i) {
            Object obj = new long[i];
            if (this.a != null) {
                System.arraycopy(this.a, 0, obj, 0, this.a.length);
            }
            this.a = obj;
        }

        private int f(int i) {
            int i2 = (this.b + i) / 64;
            if (i2 > this.a.length - 1) {
                e(i2 + 1);
            }
            return i2;
        }

        private int g(int i) {
            return (this.b + i) % 64;
        }

        public void a() {
            Arrays.fill(this.a, 0);
        }

        public void a(int i) {
            h(i);
            int f = f(i);
            long[] jArr = this.a;
            jArr[f] = jArr[f] | (1 << g(i));
        }

        public void b(int i) {
            h(i);
            int f = f(i);
            long[] jArr = this.a;
            jArr[f] = jArr[f] ^ (1 << g(i));
        }

        public boolean c(int i) {
            h(i);
            return (this.a[f(i)] & (1 << g(i))) != 0;
        }

        public void d(int i) {
            this.b -= h(i);
            if (this.b < 0) {
                int i2 = (this.b / -64) + 1;
                Object obj = new long[(this.a.length + i2)];
                System.arraycopy(this.a, 0, obj, i2, this.a.length);
                this.a = obj;
                this.b = (this.b % 64) + 64;
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{");
            List b = b();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    stringBuilder.append(',');
                }
                stringBuilder.append(b.get(i));
            }
            return stringBuilder.append('}').toString();
        }

        List<Integer> b() {
            List<Integer> arrayList = new ArrayList();
            int length = (this.a.length * 64) - this.b;
            for (int i = 0; i < length; i++) {
                if (c(i)) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            return arrayList;
        }

        private static int h(int i) {
            if (i >= 0) {
                return i;
            }
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "input must be a positive number: %s", new Object[]{Integer.valueOf(i)}));
        }
    }

    void a();

    void a(int i);

    void b(int i);

    boolean c(int i);

    void d(int i);
}
