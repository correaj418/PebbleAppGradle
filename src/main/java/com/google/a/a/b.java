package com.google.a.a;

import java.util.Arrays;

public abstract class b implements i<Character> {
    public static final b a = c();
    public static final b b = d();
    public static final b c = e();
    public static final b d = f();
    public static final b e = g();
    public static final b f = h();
    public static final b g = i();
    public static final b h = j();
    public static final b i = k();
    public static final b j = l();
    public static final b k = m();
    public static final b l = n();
    public static final b m = a();
    public static final b n = b();

    private static final class a extends b {
        final b o;
        final b p;

        public /* synthetic */ boolean apply(Object obj) {
            return super.a((Character) obj);
        }

        a(b bVar, b bVar2) {
            this.o = (b) h.a((Object) bVar);
            this.p = (b) h.a((Object) bVar2);
        }

        public boolean c(char c) {
            return this.o.c(c) && this.p.c(c);
        }

        public String toString() {
            return "CharMatcher.and(" + this.o + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + this.p + ")";
        }
    }

    static abstract class g extends b {
        g() {
        }

        public /* synthetic */ boolean apply(Object obj) {
            return super.a((Character) obj);
        }

        public b o() {
            return new t(this);
        }
    }

    static abstract class r extends g {
        private final String o;

        r(String str) {
            this.o = (String) h.a((Object) str);
        }

        public final String toString() {
            return this.o;
        }
    }

    private static final class b extends r {
        static final b o = new b();

        private b() {
            super("CharMatcher.any()");
        }

        public boolean c(char c) {
            return true;
        }

        public int e(CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        public int a(CharSequence charSequence, int i) {
            int length = charSequence.length();
            h.b(i, length);
            return i == length ? -1 : i;
        }

        public boolean c(CharSequence charSequence) {
            h.a((Object) charSequence);
            return true;
        }

        public boolean d(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        public b a(b bVar) {
            return (b) h.a((Object) bVar);
        }

        public b o() {
            return b.b();
        }
    }

    private static final class c extends b {
        private final char[] o;

        public /* synthetic */ boolean apply(Object obj) {
            return super.a((Character) obj);
        }

        public c(CharSequence charSequence) {
            this.o = charSequence.toString().toCharArray();
            Arrays.sort(this.o);
        }

        public boolean c(char c) {
            return Arrays.binarySearch(this.o, c) >= 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("CharMatcher.anyOf(\"");
            for (char d : this.o) {
                stringBuilder.append(b.e(d));
            }
            stringBuilder.append("\")");
            return stringBuilder.toString();
        }
    }

    private static final class d extends r {
        static final d o = new d();

        d() {
            super("CharMatcher.ascii()");
        }

        public boolean c(char c) {
            return c <= '';
        }
    }

    private static final class e extends b {
        static final b o = new e();

        private e() {
        }

        public /* synthetic */ boolean apply(Object obj) {
            return super.a((Character) obj);
        }

        public boolean c(char c) {
            switch (c) {
                case '\t':
                case '\n':
                case '\u000b':
                case '\f':
                case '\r':
                case ' ':
                case '':
                case ' ':
                case ' ':
                case ' ':
                case ' ':
                case '　':
                    return true;
                case ' ':
                    return false;
                default:
                    if (c < ' ' || c > ' ') {
                        return false;
                    }
                    return true;
            }
        }

        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    private static class v extends b {
        private final String o;
        private final char[] p;
        private final char[] q;

        public /* synthetic */ boolean apply(Object obj) {
            return super.a((Character) obj);
        }

        v(String str, char[] cArr, char[] cArr2) {
            boolean z;
            this.o = str;
            this.p = cArr;
            this.q = cArr2;
            if (cArr.length == cArr2.length) {
                z = true;
            } else {
                z = false;
            }
            h.a(z);
            for (int i = 0; i < cArr.length; i++) {
                boolean z2;
                if (cArr[i] <= cArr2[i]) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                h.a(z2);
                if (i + 1 < cArr.length) {
                    if (cArr2[i] < cArr[i + 1]) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    h.a(z2);
                }
            }
        }

        public boolean c(char c) {
            int binarySearch = Arrays.binarySearch(this.p, c);
            if (binarySearch >= 0) {
                return true;
            }
            binarySearch = (binarySearch ^ -1) - 1;
            if (binarySearch < 0 || c > this.q[binarySearch]) {
                return false;
            }
            return true;
        }

        public String toString() {
            return this.o;
        }
    }

    private static final class f extends v {
        static final f o = new f();

        private static char[] p() {
            return "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray();
        }

        private static char[] q() {
            char[] cArr = new char["0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".length()];
            for (int i = 0; i < "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".length(); i++) {
                cArr[i] = (char) ("0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".charAt(i) + 9);
            }
            return cArr;
        }

        private f() {
            super("CharMatcher.digit()", p(), q());
        }
    }

    private static final class h extends v {
        static final h o = new h();

        private h() {
            super("CharMatcher.invisible()", "\u0000­؀؜۝܏ ᠎   ⁦⁧⁨⁩⁪　?﻿￹￺".toCharArray(), "  ­؄؜۝܏ ᠎‏ ⁤⁦⁧⁨⁩⁯　﻿￹￻".toCharArray());
        }
    }

    private static final class i extends g {
        private final char o;

        i(char c) {
            this.o = c;
        }

        public boolean c(char c) {
            return c == this.o;
        }

        public b a(b bVar) {
            return bVar.c(this.o) ? this : b.b();
        }

        public b o() {
            return b.b(this.o);
        }

        public String toString() {
            return "CharMatcher.is('" + b.e(this.o) + "')";
        }
    }

    private static final class j extends g {
        private final char o;
        private final char p;

        j(char c, char c2) {
            this.o = c;
            this.p = c2;
        }

        public boolean c(char c) {
            return c == this.o || c == this.p;
        }

        public String toString() {
            return "CharMatcher.anyOf(\"" + b.e(this.o) + b.e(this.p) + "\")";
        }
    }

    private static final class k extends g {
        private final char o;

        k(char c) {
            this.o = c;
        }

        public boolean c(char c) {
            return c != this.o;
        }

        public b a(b bVar) {
            return bVar.c(this.o) ? super.a(bVar) : bVar;
        }

        public b o() {
            return b.a(this.o);
        }

        public String toString() {
            return "CharMatcher.isNot('" + b.e(this.o) + "')";
        }
    }

    private static final class l extends b {
        static final l o = new l();

        private l() {
        }

        public /* synthetic */ boolean apply(Object obj) {
            return super.a((Character) obj);
        }

        public boolean c(char c) {
            return Character.isDigit(c);
        }

        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    private static final class m extends r {
        static final m o = new m();

        private m() {
            super("CharMatcher.javaIsoControl()");
        }

        public boolean c(char c) {
            return c <= '\u001f' || (c >= '' && c <= '');
        }
    }

    private static final class n extends b {
        static final n o = new n();

        private n() {
        }

        public /* synthetic */ boolean apply(Object obj) {
            return super.a((Character) obj);
        }

        public boolean c(char c) {
            return Character.isLetter(c);
        }

        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    private static final class o extends b {
        static final o o = new o();

        private o() {
        }

        public /* synthetic */ boolean apply(Object obj) {
            return super.a((Character) obj);
        }

        public boolean c(char c) {
            return Character.isLetterOrDigit(c);
        }

        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    private static final class p extends b {
        static final p o = new p();

        private p() {
        }

        public /* synthetic */ boolean apply(Object obj) {
            return super.a((Character) obj);
        }

        public boolean c(char c) {
            return Character.isLowerCase(c);
        }

        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    private static final class q extends b {
        static final q o = new q();

        private q() {
        }

        public /* synthetic */ boolean apply(Object obj) {
            return super.a((Character) obj);
        }

        public boolean c(char c) {
            return Character.isUpperCase(c);
        }

        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    private static class s extends b {
        final b o;

        public /* synthetic */ boolean apply(Object obj) {
            return super.a((Character) obj);
        }

        s(b bVar) {
            this.o = (b) h.a((Object) bVar);
        }

        public boolean c(char c) {
            return !this.o.c(c);
        }

        public boolean c(CharSequence charSequence) {
            return this.o.d(charSequence);
        }

        public boolean d(CharSequence charSequence) {
            return this.o.c(charSequence);
        }

        public b o() {
            return this.o;
        }

        public String toString() {
            return this.o + ".negate()";
        }
    }

    static class t extends s {
        t(b bVar) {
            super(bVar);
        }
    }

    private static final class u extends r {
        static final u o = new u();

        private u() {
            super("CharMatcher.none()");
        }

        public boolean c(char c) {
            return false;
        }

        public int e(CharSequence charSequence) {
            h.a((Object) charSequence);
            return -1;
        }

        public int a(CharSequence charSequence, int i) {
            h.b(i, charSequence.length());
            return -1;
        }

        public boolean c(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        public boolean d(CharSequence charSequence) {
            h.a((Object) charSequence);
            return true;
        }

        public b a(b bVar) {
            h.a((Object) bVar);
            return this;
        }

        public b o() {
            return b.a();
        }
    }

    private static final class w extends v {
        static final w o = new w();

        private w() {
            super("CharMatcher.singleWidth()", "\u0000־א׳؀ݐ฀Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ๿₯℺﷿﻿ￜ".toCharArray());
        }
    }

    static final class x extends r {
        static final int o = Integer.numberOfLeadingZeros(" 　\r   　 \u000b　   　 \t     \f 　 　　 \n 　".length() - 1);
        static final x p = new x();

        x() {
            super("CharMatcher.whitespace()");
        }

        public boolean c(char c) {
            return " 　\r   　 \u000b　   　 \t     \f 　 　　 \n 　".charAt((1682554634 * c) >>> o) == c;
        }
    }

    public abstract boolean c(char c);

    public /* synthetic */ boolean apply(Object obj) {
        return a((Character) obj);
    }

    public static b a() {
        return b.o;
    }

    public static b b() {
        return u.o;
    }

    public static b c() {
        return x.p;
    }

    public static b d() {
        return e.o;
    }

    public static b e() {
        return d.o;
    }

    public static b f() {
        return f.o;
    }

    public static b g() {
        return l.o;
    }

    public static b h() {
        return n.o;
    }

    public static b i() {
        return o.o;
    }

    public static b j() {
        return q.o;
    }

    public static b k() {
        return p.o;
    }

    public static b l() {
        return m.o;
    }

    public static b m() {
        return h.o;
    }

    public static b n() {
        return w.o;
    }

    public static b a(char c) {
        return new i(c);
    }

    public static b b(char c) {
        return new k(c);
    }

    public static b a(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return b();
            case 1:
                return a(charSequence.charAt(0));
            case 2:
                return a(charSequence.charAt(0), charSequence.charAt(1));
            default:
                return new c(charSequence);
        }
    }

    public static b b(CharSequence charSequence) {
        return a(charSequence).o();
    }

    protected b() {
    }

    public b o() {
        return new s(this);
    }

    public b a(b bVar) {
        return new a(this, bVar);
    }

    public boolean c(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!c(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean d(CharSequence charSequence) {
        return e(charSequence) == -1;
    }

    public int e(CharSequence charSequence) {
        return a(charSequence, 0);
    }

    public int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        h.b(i, length);
        for (int i2 = i; i2 < length; i2++) {
            if (c(charSequence.charAt(i2))) {
                return i2;
            }
        }
        return -1;
    }

    @Deprecated
    public boolean a(Character ch) {
        return c(ch.charValue());
    }

    public String toString() {
        return super.toString();
    }

    private static String e(char c) {
        String str = "0123456789ABCDEF";
        char[] cArr = new char[]{'\\', 'u', '\u0000', '\u0000', '\u0000', '\u0000'};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = str.charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }

    private static j a(char c, char c2) {
        return new j(c, c2);
    }
}
