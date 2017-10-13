package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class k {
    public static final k a = a((CharSequence) "\t\n\u000b\f\r     　 ᠎ ").a(a(' ', ' '));
    public static final k b = a((CharSequence) "\t\n\u000b\f\r     　").a(a(' ', ' ')).a(a(' ', ' '));
    public static final k c = a('\u0000', '');
    public static final k d;
    public static final k e = a('\t', '\r').a(a('\u001c', ' ')).a(a(' ')).a(a('᠎')).a(a(' ', ' ')).a(a(' ', '​')).a(a(' ', ' ')).a(a(' ')).a(a('　'));
    public static final k f = new k() {
        public boolean b(char c) {
            return Character.isDigit(c);
        }
    };
    public static final k g = new k() {
        public boolean b(char c) {
            return Character.isLetter(c);
        }
    };
    public static final k h = new k() {
        public boolean b(char c) {
            return Character.isLetterOrDigit(c);
        }
    };
    public static final k i = new k() {
        public boolean b(char c) {
            return Character.isUpperCase(c);
        }
    };
    public static final k j = new k() {
        public boolean b(char c) {
            return Character.isLowerCase(c);
        }
    };
    public static final k k = a('\u0000', '\u001f').a(a('', ''));
    public static final k l = a('\u0000', ' ').a(a('', ' ')).a(a('­')).a(a('؀', '؃')).a(a((CharSequence) "۝܏ ឴឵᠎")).a(a(' ', '‏')).a(a(' ', ' ')).a(a(' ', '⁤')).a(a('⁪', '⁯')).a(a('　')).a(a('?', '')).a(a((CharSequence) "﻿￹￺￻"));
    public static final k m = a('\u0000', 'ӹ').a(a('־')).a(a('א', 'ת')).a(a('׳')).a(a('״')).a(a('؀', 'ۿ')).a(a('ݐ', 'ݿ')).a(a('฀', '๿')).a(a('Ḁ', '₯')).a(a('℀', '℺')).a(a('ﭐ', '﷿')).a(a('ﹰ', '﻿')).a(a('｡', 'ￜ'));
    public static final k n = new k() {
        public k a(k kVar) {
            b.a((Object) kVar);
            return this;
        }

        public boolean b(char c) {
            return true;
        }

        public boolean b(CharSequence charSequence) {
            b.a((Object) charSequence);
            return true;
        }
    };
    public static final k o = new k() {
        public k a(k kVar) {
            return (k) b.a((Object) kVar);
        }

        public boolean b(char c) {
            return false;
        }

        public boolean b(CharSequence charSequence) {
            return charSequence.length() == 0;
        }
    };

    class AnonymousClass3 extends k {
        final /* synthetic */ char p;

        AnonymousClass3(char c) {
            this.p = c;
        }

        public k a(k kVar) {
            return kVar.b(this.p) ? kVar : super.a(kVar);
        }

        public boolean b(char c) {
            return c == this.p;
        }
    }

    class AnonymousClass4 extends k {
        final /* synthetic */ char p;
        final /* synthetic */ char q;

        AnonymousClass4(char c, char c2) {
            this.p = c;
            this.q = c2;
        }

        public boolean b(char c) {
            return c == this.p || c == this.q;
        }
    }

    class AnonymousClass5 extends k {
        final /* synthetic */ char[] p;

        AnonymousClass5(char[] cArr) {
            this.p = cArr;
        }

        public boolean b(char c) {
            return Arrays.binarySearch(this.p, c) >= 0;
        }
    }

    class AnonymousClass6 extends k {
        final /* synthetic */ char p;
        final /* synthetic */ char q;

        AnonymousClass6(char c, char c2) {
            this.p = c;
            this.q = c2;
        }

        public boolean b(char c) {
            return this.p <= c && c <= this.q;
        }
    }

    private static class a extends k {
        List<k> p;

        a(List<k> list) {
            this.p = list;
        }

        public k a(k kVar) {
            List arrayList = new ArrayList(this.p);
            arrayList.add((k) b.a((Object) kVar));
            return new a(arrayList);
        }

        public boolean b(char c) {
            for (k b : this.p) {
                if (b.b(c)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        k a = a('0', '9');
        k kVar = a;
        for (char c : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            kVar = kVar.a(a(c, (char) (c + 9)));
        }
        d = kVar;
    }

    public static k a(char c) {
        return new AnonymousClass3(c);
    }

    public static k a(char c, char c2) {
        b.b(c2 >= c);
        return new AnonymousClass6(c, c2);
    }

    public static k a(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return o;
            case 1:
                return a(charSequence.charAt(0));
            case 2:
                return new AnonymousClass4(charSequence.charAt(0), charSequence.charAt(1));
            default:
                char[] toCharArray = charSequence.toString().toCharArray();
                Arrays.sort(toCharArray);
                return new AnonymousClass5(toCharArray);
        }
    }

    public k a(k kVar) {
        return new a(Arrays.asList(new k[]{this, (k) b.a((Object) kVar)}));
    }

    public abstract boolean b(char c);

    public boolean b(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!b(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }
}
