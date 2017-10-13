package c.b.a.b;

import c.b.a.d;
import c.b.a.e;
import c.b.a.i;
import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class q {
    private static ConcurrentMap<Locale, q> a = new ConcurrentHashMap();
    private final String[] b;
    private final String[] c;
    private final String[] d;
    private final String[] e;
    private final String[] f;
    private final String[] g;
    private final TreeMap<String, Integer> h;
    private final TreeMap<String, Integer> i;
    private final TreeMap<String, Integer> j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;
    private final int p;

    static q a(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        q qVar = (q) a.get(locale);
        if (qVar != null) {
            return qVar;
        }
        q qVar2 = new q(locale);
        qVar = (q) a.putIfAbsent(locale, qVar2);
        return qVar != null ? qVar : qVar2;
    }

    private static String[] a(String[] strArr) {
        String[] strArr2 = new String[13];
        for (int i = 1; i < 13; i++) {
            strArr2[i] = strArr[i - 1];
        }
        return strArr2;
    }

    private static String[] b(String[] strArr) {
        String[] strArr2 = new String[8];
        for (int i = 1; i < 8; i++) {
            int i2;
            if (i < 7) {
                i2 = i + 1;
            } else {
                i2 = 1;
            }
            strArr2[i] = strArr[i2];
        }
        return strArr2;
    }

    private static void a(TreeMap<String, Integer> treeMap, String[] strArr, Integer[] numArr) {
        int length = strArr.length;
        while (true) {
            length--;
            if (length >= 0) {
                Object obj = strArr[length];
                if (obj != null) {
                    treeMap.put(obj, numArr[length]);
                }
            } else {
                return;
            }
        }
    }

    private static void a(TreeMap<String, Integer> treeMap, int i, int i2, Integer[] numArr) {
        while (i <= i2) {
            treeMap.put(String.valueOf(i).intern(), numArr[i]);
            i++;
        }
    }

    private static int c(String[] strArr) {
        int i = 0;
        int length = strArr.length;
        while (true) {
            int i2 = length - 1;
            if (i2 < 0) {
                return i;
            }
            String str = strArr[i2];
            if (str != null) {
                length = str.length();
                if (length > i) {
                    i = length;
                    length = i2;
                }
            }
            length = i;
            i = length;
            length = i2;
        }
    }

    private q(Locale locale) {
        DateFormatSymbols a = e.a(locale);
        this.b = a.getEras();
        this.c = b(a.getWeekdays());
        this.d = b(a.getShortWeekdays());
        this.e = a(a.getMonths());
        this.f = a(a.getShortMonths());
        this.g = a.getAmPmStrings();
        Integer[] numArr = new Integer[13];
        for (int i = 0; i < 13; i++) {
            numArr[i] = Integer.valueOf(i);
        }
        this.h = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        a(this.h, this.b, numArr);
        if ("en".equals(locale.getLanguage())) {
            this.h.put("BCE", numArr[0]);
            this.h.put("CE", numArr[1]);
        }
        this.i = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        a(this.i, this.c, numArr);
        a(this.i, this.d, numArr);
        a(this.i, 1, 7, numArr);
        this.j = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        a(this.j, this.e, numArr);
        a(this.j, this.f, numArr);
        a(this.j, 1, 12, numArr);
        this.k = c(this.b);
        this.l = c(this.c);
        this.m = c(this.d);
        this.n = c(this.e);
        this.o = c(this.f);
        this.p = c(this.g);
    }

    public String a(int i) {
        return this.b[i];
    }

    public int a(String str) {
        Integer num = (Integer) this.h.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new i(d.w(), str);
    }

    public int a() {
        return this.k;
    }

    public String b(int i) {
        return this.e[i];
    }

    public String c(int i) {
        return this.f[i];
    }

    public int b(String str) {
        Integer num = (Integer) this.j.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new i(d.r(), str);
    }

    public int b() {
        return this.n;
    }

    public String d(int i) {
        return this.c[i];
    }

    public String e(int i) {
        return this.d[i];
    }

    public int c(String str) {
        Integer num = (Integer) this.i.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new i(d.l(), str);
    }

    public int c() {
        return this.l;
    }

    public String f(int i) {
        return this.g[i];
    }

    public int d(String str) {
        String[] strArr = this.g;
        int length = strArr.length;
        do {
            length--;
            if (length < 0) {
                throw new i(d.k(), str);
            }
        } while (!strArr[length].equalsIgnoreCase(str));
        return length;
    }

    public int d() {
        return this.p;
    }
}
