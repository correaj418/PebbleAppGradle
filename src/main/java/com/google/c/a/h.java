package com.google.c.a;

import com.google.c.a.i.d;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class h {
    private static final Pattern A = Pattern.compile("\\$FG");
    private static final Pattern B = Pattern.compile("\\$CC");
    private static final Pattern C = Pattern.compile("\\(?\\$1\\)?");
    private static h D = null;
    static final c a = new c() {
        public InputStream a(String str) {
            return h.class.getResourceAsStream(str);
        }
    };
    static final Pattern b = Pattern.compile("[+＋]+");
    static final Pattern c = Pattern.compile("[\\\\/] *x");
    static final Pattern d = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
    static final String e;
    static final Pattern f = Pattern.compile("(\\D+)");
    private static final Logger g = Logger.getLogger(h.class.getName());
    private static final Map<Integer, String> h;
    private static final Set<Integer> i;
    private static final Set<Integer> j;
    private static final Map<Character, Character> k;
    private static final Map<Character, Character> l;
    private static final Map<Character, Character> m;
    private static final Map<Character, Character> n;
    private static final Pattern o = Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
    private static final String p = (Arrays.toString(l.keySet().toArray()).replaceAll("[, \\[\\]]", "") + Arrays.toString(l.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
    private static final Pattern q = Pattern.compile("[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]+");
    private static final Pattern r = Pattern.compile("(\\p{Nd})");
    private static final Pattern s = Pattern.compile("[+＋\\p{Nd}]");
    private static final Pattern t = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
    private static final String u = ("\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*" + p + "\\p{Nd}" + "]*");
    private static final String v;
    private static final Pattern w = Pattern.compile("(?:" + v + ")$", 66);
    private static final Pattern x = Pattern.compile(u + "(?:" + v + ")?", 66);
    private static final Pattern y = Pattern.compile("(\\$\\d)");
    private static final Pattern z = Pattern.compile("\\$NP");
    private final e E;
    private final Map<Integer, List<String>> F;
    private final Set<String> G = new HashSet(35);
    private final k H = new k(100);
    private final Set<String> I = new HashSet(320);
    private final Set<Integer> J = new HashSet();

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a = new int[com.google.c.a.j.a.a.values().length];
        static final /* synthetic */ int[] c = new int[b.values().length];

        static {
            try {
                c[b.PREMIUM_RATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                c[b.TOLL_FREE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                c[b.MOBILE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                c[b.FIXED_LINE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                c[b.FIXED_LINE_OR_MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                c[b.SHARED_COST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                c[b.VOIP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                c[b.PERSONAL_NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                c[b.PAGER.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                c[b.UAN.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                c[b.VOICEMAIL.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            b = new int[a.values().length];
            try {
                b[a.E164.ordinal()] = 1;
            } catch (NoSuchFieldError e12) {
            }
            try {
                b[a.INTERNATIONAL.ordinal()] = 2;
            } catch (NoSuchFieldError e13) {
            }
            try {
                b[a.RFC3966.ordinal()] = 3;
            } catch (NoSuchFieldError e14) {
            }
            try {
                b[a.NATIONAL.ordinal()] = 4;
            } catch (NoSuchFieldError e15) {
            }
            try {
                a[com.google.c.a.j.a.a.FROM_NUMBER_WITH_PLUS_SIGN.ordinal()] = 1;
            } catch (NoSuchFieldError e16) {
            }
            try {
                a[com.google.c.a.j.a.a.FROM_NUMBER_WITH_IDD.ordinal()] = 2;
            } catch (NoSuchFieldError e17) {
            }
            try {
                a[com.google.c.a.j.a.a.FROM_NUMBER_WITHOUT_PLUS_SIGN.ordinal()] = 3;
            } catch (NoSuchFieldError e18) {
            }
            try {
                a[com.google.c.a.j.a.a.FROM_DEFAULT_COUNTRY.ordinal()] = 4;
            } catch (NoSuchFieldError e19) {
            }
        }
    }

    public enum a {
        E164,
        INTERNATIONAL,
        NATIONAL,
        RFC3966
    }

    public enum b {
        FIXED_LINE,
        MOBILE,
        FIXED_LINE_OR_MOBILE,
        TOLL_FREE,
        PREMIUM_RATE,
        SHARED_COST,
        VOIP,
        PERSONAL_NUMBER,
        PAGER,
        UAN,
        VOICEMAIL,
        UNKNOWN
    }

    public enum c {
        IS_POSSIBLE,
        INVALID_COUNTRY_CODE,
        TOO_SHORT,
        TOO_LONG
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put(Integer.valueOf(52), "1");
        hashMap.put(Integer.valueOf(54), "9");
        h = Collections.unmodifiableMap(hashMap);
        Collection hashSet = new HashSet();
        hashSet.add(Integer.valueOf(86));
        i = Collections.unmodifiableSet(hashSet);
        Set hashSet2 = new HashSet();
        hashSet2.add(Integer.valueOf(52));
        hashSet2.add(Integer.valueOf(54));
        hashSet2.add(Integer.valueOf(55));
        hashSet2.add(Integer.valueOf(62));
        hashSet2.addAll(hashSet);
        j = Collections.unmodifiableSet(hashSet2);
        Map hashMap2 = new HashMap();
        hashMap2.put(Character.valueOf('0'), Character.valueOf('0'));
        hashMap2.put(Character.valueOf('1'), Character.valueOf('1'));
        hashMap2.put(Character.valueOf('2'), Character.valueOf('2'));
        hashMap2.put(Character.valueOf('3'), Character.valueOf('3'));
        hashMap2.put(Character.valueOf('4'), Character.valueOf('4'));
        hashMap2.put(Character.valueOf('5'), Character.valueOf('5'));
        hashMap2.put(Character.valueOf('6'), Character.valueOf('6'));
        hashMap2.put(Character.valueOf('7'), Character.valueOf('7'));
        hashMap2.put(Character.valueOf('8'), Character.valueOf('8'));
        hashMap2.put(Character.valueOf('9'), Character.valueOf('9'));
        hashMap = new HashMap(40);
        hashMap.put(Character.valueOf('A'), Character.valueOf('2'));
        hashMap.put(Character.valueOf('B'), Character.valueOf('2'));
        hashMap.put(Character.valueOf('C'), Character.valueOf('2'));
        hashMap.put(Character.valueOf('D'), Character.valueOf('3'));
        hashMap.put(Character.valueOf('E'), Character.valueOf('3'));
        hashMap.put(Character.valueOf('F'), Character.valueOf('3'));
        hashMap.put(Character.valueOf('G'), Character.valueOf('4'));
        hashMap.put(Character.valueOf('H'), Character.valueOf('4'));
        hashMap.put(Character.valueOf('I'), Character.valueOf('4'));
        hashMap.put(Character.valueOf('J'), Character.valueOf('5'));
        hashMap.put(Character.valueOf('K'), Character.valueOf('5'));
        hashMap.put(Character.valueOf('L'), Character.valueOf('5'));
        hashMap.put(Character.valueOf('M'), Character.valueOf('6'));
        hashMap.put(Character.valueOf('N'), Character.valueOf('6'));
        hashMap.put(Character.valueOf('O'), Character.valueOf('6'));
        hashMap.put(Character.valueOf('P'), Character.valueOf('7'));
        hashMap.put(Character.valueOf('Q'), Character.valueOf('7'));
        hashMap.put(Character.valueOf('R'), Character.valueOf('7'));
        hashMap.put(Character.valueOf('S'), Character.valueOf('7'));
        hashMap.put(Character.valueOf('T'), Character.valueOf('8'));
        hashMap.put(Character.valueOf('U'), Character.valueOf('8'));
        hashMap.put(Character.valueOf('V'), Character.valueOf('8'));
        hashMap.put(Character.valueOf('W'), Character.valueOf('9'));
        hashMap.put(Character.valueOf('X'), Character.valueOf('9'));
        hashMap.put(Character.valueOf('Y'), Character.valueOf('9'));
        hashMap.put(Character.valueOf('Z'), Character.valueOf('9'));
        l = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap(100);
        hashMap.putAll(l);
        hashMap.putAll(hashMap2);
        m = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.putAll(hashMap2);
        hashMap.put(Character.valueOf('+'), Character.valueOf('+'));
        hashMap.put(Character.valueOf('*'), Character.valueOf('*'));
        k = Collections.unmodifiableMap(hashMap);
        Map hashMap3 = new HashMap();
        for (Character charValue : l.keySet()) {
            char charValue2 = charValue.charValue();
            hashMap3.put(Character.valueOf(Character.toLowerCase(charValue2)), Character.valueOf(charValue2));
            hashMap3.put(Character.valueOf(charValue2), Character.valueOf(charValue2));
        }
        hashMap3.putAll(hashMap2);
        hashMap3.put(Character.valueOf('-'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('－'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('‐'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('‑'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('‒'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('–'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('—'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('―'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('−'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('/'), Character.valueOf('/'));
        hashMap3.put(Character.valueOf('／'), Character.valueOf('/'));
        hashMap3.put(Character.valueOf(' '), Character.valueOf(' '));
        hashMap3.put(Character.valueOf('　'), Character.valueOf(' '));
        hashMap3.put(Character.valueOf('⁠'), Character.valueOf(' '));
        hashMap3.put(Character.valueOf('.'), Character.valueOf('.'));
        hashMap3.put(Character.valueOf('．'), Character.valueOf('.'));
        n = Collections.unmodifiableMap(hashMap3);
        String str = "xｘ#＃~～";
        v = f("," + str);
        e = f(str);
    }

    private static String f(String str) {
        return ";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|[" + str + "]|int|anexo|ｉｎｔ)" + "[:\\.．]?[  \\t,-]*" + "(\\p{Nd}{1,7})" + "#?|" + "[- ]+(" + "\\p{Nd}" + "{1,5})#";
    }

    h(e eVar, Map<Integer, List<String>> map) {
        this.E = eVar;
        this.F = map;
        for (Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            if (list.size() == 1 && "001".equals(list.get(0))) {
                this.J.add(entry.getKey());
            } else {
                this.I.addAll(list);
            }
        }
        if (this.I.remove("001")) {
            g.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.G.addAll((Collection) map.get(Integer.valueOf(1)));
    }

    static String a(String str) {
        Matcher matcher = s.matcher(str);
        if (!matcher.find()) {
            return "";
        }
        String substring = str.substring(matcher.start());
        Matcher matcher2 = d.matcher(substring);
        if (matcher2.find()) {
            substring = substring.substring(0, matcher2.start());
            g.log(Level.FINER, "Stripped trailing characters: " + substring);
        }
        matcher2 = c.matcher(substring);
        if (matcher2.find()) {
            return substring.substring(0, matcher2.start());
        }
        return substring;
    }

    static boolean b(String str) {
        if (str.length() < 2) {
            return false;
        }
        return x.matcher(str).matches();
    }

    static String c(String str) {
        if (t.matcher(str).matches()) {
            return a(str, m, true);
        }
        return d(str);
    }

    static void a(StringBuilder stringBuilder) {
        stringBuilder.replace(0, stringBuilder.length(), c(stringBuilder.toString()));
    }

    public static String d(String str) {
        return a(str, false).toString();
    }

    static StringBuilder a(String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            int digit = Character.digit(c, 10);
            if (digit != -1) {
                stringBuilder.append(digit);
            } else if (z) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder;
    }

    private static String a(String str, Map<Character, Character> map, boolean z) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            Character ch = (Character) map.get(Character.valueOf(Character.toUpperCase(charAt)));
            if (ch != null) {
                stringBuilder.append(ch);
            } else if (!z) {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }

    static synchronized void a(h hVar) {
        synchronized (h.class) {
            D = hVar;
        }
    }

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            if (D == null) {
                a(a(a));
            }
            hVar = D;
        }
        return hVar;
    }

    public static h a(e eVar) {
        if (eVar != null) {
            return new h(eVar, b.a());
        }
        throw new IllegalArgumentException("metadataSource could not be null.");
    }

    public static h a(c cVar) {
        if (cVar != null) {
            return a(new f(cVar));
        }
        throw new IllegalArgumentException("metadataLoader could not be null.");
    }

    private boolean g(String str) {
        return str != null && this.I.contains(str);
    }

    private boolean c(int i) {
        return this.F.containsKey(Integer.valueOf(i));
    }

    public String a(com.google.c.a.j.a aVar, a aVar2) {
        if (aVar.b() == 0 && aVar.i()) {
            String j = aVar.j();
            if (j.length() > 0) {
                return j;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(20);
        a(aVar, aVar2, stringBuilder);
        return stringBuilder.toString();
    }

    public void a(com.google.c.a.j.a aVar, a aVar2, StringBuilder stringBuilder) {
        stringBuilder.setLength(0);
        int a = aVar.a();
        String a2 = a(aVar);
        if (aVar2 == a.E164) {
            stringBuilder.append(a2);
            a(a, a.E164, stringBuilder);
        } else if (c(a)) {
            com.google.c.a.i.b a3 = a(a, b(a));
            stringBuilder.append(a(a2, a3, aVar2));
            a(aVar, a3, aVar2, stringBuilder);
            a(a, aVar2, stringBuilder);
        } else {
            stringBuilder.append(a2);
        }
    }

    private com.google.c.a.i.b a(int i, String str) {
        if ("001".equals(str)) {
            return a(i);
        }
        return e(str);
    }

    public String a(com.google.c.a.j.a aVar) {
        StringBuilder stringBuilder = new StringBuilder();
        if (aVar.f()) {
            char[] cArr = new char[aVar.h()];
            Arrays.fill(cArr, '0');
            stringBuilder.append(new String(cArr));
        }
        stringBuilder.append(aVar.b());
        return stringBuilder.toString();
    }

    private void a(int i, a aVar, StringBuilder stringBuilder) {
        switch (aVar) {
            case E164:
                stringBuilder.insert(0, i).insert(0, '+');
                return;
            case INTERNATIONAL:
                stringBuilder.insert(0, " ").insert(0, i).insert(0, '+');
                return;
            case RFC3966:
                stringBuilder.insert(0, "-").insert(0, i).insert(0, '+').insert(0, "tel:");
                return;
            default:
                return;
        }
    }

    private String a(String str, com.google.c.a.i.b bVar, a aVar) {
        return a(str, bVar, aVar, null);
    }

    private String a(String str, com.google.c.a.i.b bVar, a aVar, String str2) {
        List h;
        if (bVar.j().size() == 0 || aVar == a.NATIONAL) {
            h = bVar.h();
        } else {
            h = bVar.j();
        }
        com.google.c.a.i.a a = a(h, str);
        return a == null ? str : a(str, a, aVar, str2);
    }

    com.google.c.a.i.a a(List<com.google.c.a.i.a> list, String str) {
        for (com.google.c.a.i.a aVar : list) {
            int c = aVar.c();
            if ((c == 0 || this.H.a(aVar.a(c - 1)).matcher(str).lookingAt()) && this.H.a(aVar.a()).matcher(str).matches()) {
                return aVar;
            }
        }
        return null;
    }

    private String a(String str, com.google.c.a.i.a aVar, a aVar2, String str2) {
        CharSequence replaceAll;
        Object b = aVar.b();
        Matcher matcher = this.H.a(aVar.a()).matcher(str);
        String str3 = "";
        if (aVar2 != a.NATIONAL || str2 == null || str2.length() <= 0 || aVar.e().length() <= 0) {
            str3 = aVar.d();
            if (aVar2 != a.NATIONAL || str3 == null || str3.length() <= 0) {
                replaceAll = matcher.replaceAll(b);
            } else {
                replaceAll = matcher.replaceAll(y.matcher(b).replaceFirst(str3));
            }
        } else {
            replaceAll = matcher.replaceAll(y.matcher(b).replaceFirst(B.matcher(aVar.e()).replaceFirst(str2)));
        }
        if (aVar2 != a.RFC3966) {
            return replaceAll;
        }
        matcher = q.matcher(replaceAll);
        if (matcher.lookingAt()) {
            replaceAll = matcher.replaceFirst("");
        }
        return matcher.reset(replaceAll).replaceAll("-");
    }

    private void a(com.google.c.a.j.a aVar, com.google.c.a.i.b bVar, a aVar2, StringBuilder stringBuilder) {
        if (aVar.c() && aVar.d().length() > 0) {
            if (aVar2 == a.RFC3966) {
                stringBuilder.append(";ext=").append(aVar.d());
            } else if (bVar.d()) {
                stringBuilder.append(bVar.e()).append(aVar.d());
            } else {
                stringBuilder.append(" ext. ").append(aVar.d());
            }
        }
    }

    com.google.c.a.i.b e(String str) {
        if (g(str)) {
            return this.E.a(str);
        }
        return null;
    }

    com.google.c.a.i.b a(int i) {
        if (this.F.containsKey(Integer.valueOf(i))) {
            return this.E.a(i);
        }
        return null;
    }

    public String b(int i) {
        List list = (List) this.F.get(Integer.valueOf(i));
        return list == null ? "ZZ" : (String) list.get(0);
    }

    private c a(Pattern pattern, String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return c.IS_POSSIBLE;
        }
        if (matcher.lookingAt()) {
            return c.TOO_LONG;
        }
        return c.TOO_SHORT;
    }

    private boolean a(com.google.c.a.i.b bVar, String str) {
        return a(this.H.a(bVar.a().b()), str) == c.TOO_SHORT;
    }

    int a(StringBuilder stringBuilder, StringBuilder stringBuilder2) {
        if (stringBuilder.length() == 0 || stringBuilder.charAt(0) == '0') {
            return 0;
        }
        int length = stringBuilder.length();
        int i = 1;
        while (i <= 3 && i <= length) {
            int parseInt = Integer.parseInt(stringBuilder.substring(0, i));
            if (this.F.containsKey(Integer.valueOf(parseInt))) {
                stringBuilder2.append(stringBuilder.substring(i));
                return parseInt;
            }
            i++;
        }
        return 0;
    }

    int a(String str, com.google.c.a.i.b bVar, StringBuilder stringBuilder, boolean z, com.google.c.a.j.a aVar) {
        if (str.length() == 0) {
            return 0;
        }
        StringBuilder stringBuilder2 = new StringBuilder(str);
        String str2 = "NonMatch";
        if (bVar != null) {
            str2 = bVar.c();
        }
        com.google.c.a.j.a.a a = a(stringBuilder2, str2);
        if (z) {
            aVar.a(a);
        }
        int b;
        if (a == com.google.c.a.j.a.a.FROM_DEFAULT_COUNTRY) {
            if (bVar != null) {
                b = bVar.b();
                String valueOf = String.valueOf(b);
                String stringBuilder3 = stringBuilder2.toString();
                if (stringBuilder3.startsWith(valueOf)) {
                    StringBuilder stringBuilder4 = new StringBuilder(stringBuilder3.substring(valueOf.length()));
                    d a2 = bVar.a();
                    Pattern a3 = this.H.a(a2.a());
                    a(stringBuilder4, bVar, null);
                    Pattern a4 = this.H.a(a2.b());
                    if ((!a3.matcher(stringBuilder2).matches() && a3.matcher(stringBuilder4).matches()) || a(a4, stringBuilder2.toString()) == c.TOO_LONG) {
                        stringBuilder.append(stringBuilder4);
                        if (z) {
                            aVar.a(com.google.c.a.j.a.a.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                        }
                        aVar.a(b);
                        return b;
                    }
                }
            }
            aVar.a(0);
            return 0;
        } else if (stringBuilder2.length() <= 2) {
            throw new g(com.google.c.a.g.a.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
        } else {
            b = a(stringBuilder2, stringBuilder);
            if (b != 0) {
                aVar.a(b);
                return b;
            }
            throw new g(com.google.c.a.g.a.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
        }
    }

    private boolean a(Pattern pattern, StringBuilder stringBuilder) {
        Matcher matcher = pattern.matcher(stringBuilder);
        if (!matcher.lookingAt()) {
            return false;
        }
        int end = matcher.end();
        Matcher matcher2 = r.matcher(stringBuilder.substring(end));
        if (matcher2.find() && d(matcher2.group(1)).equals("0")) {
            return false;
        }
        stringBuilder.delete(0, end);
        return true;
    }

    com.google.c.a.j.a.a a(StringBuilder stringBuilder, String str) {
        if (stringBuilder.length() == 0) {
            return com.google.c.a.j.a.a.FROM_DEFAULT_COUNTRY;
        }
        Matcher matcher = b.matcher(stringBuilder);
        if (matcher.lookingAt()) {
            stringBuilder.delete(0, matcher.end());
            a(stringBuilder);
            return com.google.c.a.j.a.a.FROM_NUMBER_WITH_PLUS_SIGN;
        }
        Pattern a = this.H.a(str);
        a(stringBuilder);
        return a(a, stringBuilder) ? com.google.c.a.j.a.a.FROM_NUMBER_WITH_IDD : com.google.c.a.j.a.a.FROM_DEFAULT_COUNTRY;
    }

    boolean a(StringBuilder stringBuilder, com.google.c.a.i.b bVar, StringBuilder stringBuilder2) {
        int length = stringBuilder.length();
        String f = bVar.f();
        if (length == 0 || f.length() == 0) {
            return false;
        }
        Matcher matcher = this.H.a(f).matcher(stringBuilder);
        if (!matcher.lookingAt()) {
            return false;
        }
        Pattern a = this.H.a(bVar.a().a());
        boolean matches = a.matcher(stringBuilder).matches();
        int groupCount = matcher.groupCount();
        String g = bVar.g();
        if (g != null && g.length() != 0 && matcher.group(groupCount) != null) {
            StringBuilder stringBuilder3 = new StringBuilder(stringBuilder);
            stringBuilder3.replace(0, length, matcher.replaceFirst(g));
            if (matches && !a.matcher(stringBuilder3.toString()).matches()) {
                return false;
            }
            if (stringBuilder2 != null && groupCount > 1) {
                stringBuilder2.append(matcher.group(1));
            }
            stringBuilder.replace(0, stringBuilder.length(), stringBuilder3.toString());
            return true;
        } else if (matches && !a.matcher(stringBuilder.substring(matcher.end())).matches()) {
            return false;
        } else {
            if (!(stringBuilder2 == null || groupCount <= 0 || matcher.group(groupCount) == null)) {
                stringBuilder2.append(matcher.group(1));
            }
            stringBuilder.delete(0, matcher.end());
            return true;
        }
    }

    String b(StringBuilder stringBuilder) {
        Matcher matcher = w.matcher(stringBuilder);
        if (matcher.find() && b(stringBuilder.substring(0, matcher.start()))) {
            int groupCount = matcher.groupCount();
            for (int i = 1; i <= groupCount; i++) {
                if (matcher.group(i) != null) {
                    String group = matcher.group(i);
                    stringBuilder.delete(matcher.start(), stringBuilder.length());
                    return group;
                }
            }
        }
        return "";
    }

    private boolean b(String str, String str2) {
        if (g(str2) || (str != null && str.length() != 0 && b.matcher(str).lookingAt())) {
            return true;
        }
        return false;
    }

    public com.google.c.a.j.a a(String str, String str2) {
        com.google.c.a.j.a aVar = new com.google.c.a.j.a();
        a(str, str2, aVar);
        return aVar;
    }

    public void a(String str, String str2, com.google.c.a.j.a aVar) {
        a(str, str2, false, true, aVar);
    }

    static void a(String str, com.google.c.a.j.a aVar) {
        if (str.length() > 1 && str.charAt(0) == '0') {
            aVar.a(true);
            int i = 1;
            while (i < str.length() - 1 && str.charAt(i) == '0') {
                i++;
            }
            if (i != 1) {
                aVar.b(i);
            }
        }
    }

    private void a(String str, String str2, boolean z, boolean z2, com.google.c.a.j.a aVar) {
        if (str == null) {
            throw new g(com.google.c.a.g.a.NOT_A_NUMBER, "The phone number supplied was null.");
        } else if (str.length() > 250) {
            throw new g(com.google.c.a.g.a.TOO_LONG, "The string supplied was too long to parse.");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            a(str, stringBuilder);
            if (!b(stringBuilder.toString())) {
                throw new g(com.google.c.a.g.a.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
            } else if (!z2 || b(stringBuilder.toString(), str2)) {
                int a;
                if (z) {
                    aVar.b(str);
                }
                String b = b(stringBuilder);
                if (b.length() > 0) {
                    aVar.a(b);
                }
                com.google.c.a.i.b e = e(str2);
                StringBuilder stringBuilder2 = new StringBuilder();
                try {
                    a = a(stringBuilder.toString(), e, stringBuilder2, z, aVar);
                } catch (g e2) {
                    Matcher matcher = b.matcher(stringBuilder.toString());
                    if (e2.a() == com.google.c.a.g.a.INVALID_COUNTRY_CODE && matcher.lookingAt()) {
                        a = a(stringBuilder.substring(matcher.end()), e, stringBuilder2, z, aVar);
                        if (a == 0) {
                            throw new g(com.google.c.a.g.a.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
                        }
                    }
                    throw new g(e2.a(), e2.getMessage());
                }
                if (a != 0) {
                    String b2 = b(a);
                    if (!b2.equals(str2)) {
                        e = a(a, b2);
                    }
                } else {
                    a(stringBuilder);
                    stringBuilder2.append(stringBuilder);
                    if (str2 != null) {
                        aVar.a(e.b());
                    } else if (z) {
                        aVar.m();
                    }
                }
                if (stringBuilder2.length() < 2) {
                    throw new g(com.google.c.a.g.a.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                }
                if (e != null) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    StringBuilder stringBuilder4 = new StringBuilder(stringBuilder2);
                    a(stringBuilder4, e, stringBuilder3);
                    if (!a(e, stringBuilder4.toString())) {
                        if (z) {
                            aVar.c(stringBuilder3.toString());
                        }
                        stringBuilder2 = stringBuilder4;
                    }
                }
                a = stringBuilder2.length();
                if (a < 2) {
                    throw new g(com.google.c.a.g.a.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                } else if (a > 17) {
                    throw new g(com.google.c.a.g.a.TOO_LONG, "The string supplied is too long to be a phone number.");
                } else {
                    a(stringBuilder2.toString(), aVar);
                    aVar.a(Long.parseLong(stringBuilder2.toString()));
                }
            } else {
                throw new g(com.google.c.a.g.a.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
            }
        }
    }

    private void a(String str, StringBuilder stringBuilder) {
        int length;
        int indexOf = str.indexOf(";phone-context=");
        if (indexOf > 0) {
            length = ";phone-context=".length() + indexOf;
            if (str.charAt(length) == '+') {
                int indexOf2 = str.indexOf(59, length);
                if (indexOf2 > 0) {
                    stringBuilder.append(str.substring(length, indexOf2));
                } else {
                    stringBuilder.append(str.substring(length));
                }
            }
            length = str.indexOf("tel:");
            stringBuilder.append(str.substring(length >= 0 ? length + "tel:".length() : 0, indexOf));
        } else {
            stringBuilder.append(a(str));
        }
        length = stringBuilder.indexOf(";isub=");
        if (length > 0) {
            stringBuilder.delete(length, stringBuilder.length());
        }
    }
}
