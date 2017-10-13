package c.b.a.e;

import c.b.a.u;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherChannelDataModels;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class c {
    private ArrayList<Object> a = new ArrayList();
    private Object b;

    static class a implements k, m {
        private final char a;

        a(char c) {
            this.a = c;
        }

        public int estimatePrintedLength() {
            return 1;
        }

        public void printTo(Appendable appendable, long j, c.b.a.a aVar, int i, c.b.a.f fVar, Locale locale) {
            appendable.append(this.a);
        }

        public void printTo(Appendable appendable, u uVar, Locale locale) {
            appendable.append(this.a);
        }

        public int estimateParsedLength() {
            return 1;
        }

        public int parseInto(e eVar, CharSequence charSequence, int i) {
            if (i >= charSequence.length()) {
                return i ^ -1;
            }
            char charAt = charSequence.charAt(i);
            char c = this.a;
            if (charAt != c) {
                charAt = Character.toUpperCase(charAt);
                c = Character.toUpperCase(c);
                if (!(charAt == c || Character.toLowerCase(charAt) == Character.toLowerCase(c))) {
                    return i ^ -1;
                }
            }
            return i + 1;
        }
    }

    static class b implements k, m {
        private final m[] a;
        private final k[] b;
        private final int c;
        private final int d;

        b(List<Object> list) {
            int i;
            int i2;
            int i3 = 0;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            a(list, arrayList, arrayList2);
            if (arrayList.contains(null) || arrayList.isEmpty()) {
                this.a = null;
                this.c = 0;
            } else {
                int size = arrayList.size();
                this.a = new m[size];
                i = 0;
                for (i2 = 0; i2 < size; i2++) {
                    m mVar = (m) arrayList.get(i2);
                    i += mVar.estimatePrintedLength();
                    this.a[i2] = mVar;
                }
                this.c = i;
            }
            if (arrayList2.contains(null) || arrayList2.isEmpty()) {
                this.b = null;
                this.d = 0;
                return;
            }
            i = arrayList2.size();
            this.b = new k[i];
            i2 = 0;
            while (i3 < i) {
                k kVar = (k) arrayList2.get(i3);
                i2 += kVar.estimateParsedLength();
                this.b[i3] = kVar;
                i3++;
            }
            this.d = i2;
        }

        public int estimatePrintedLength() {
            return this.c;
        }

        public void printTo(Appendable appendable, long j, c.b.a.a aVar, int i, c.b.a.f fVar, Locale locale) {
            m[] mVarArr = this.a;
            if (mVarArr == null) {
                throw new UnsupportedOperationException();
            }
            Locale locale2;
            if (locale == null) {
                locale2 = Locale.getDefault();
            } else {
                locale2 = locale;
            }
            for (m printTo : mVarArr) {
                printTo.printTo(appendable, j, aVar, i, fVar, locale2);
            }
        }

        public void printTo(Appendable appendable, u uVar, Locale locale) {
            m[] mVarArr = this.a;
            if (mVarArr == null) {
                throw new UnsupportedOperationException();
            }
            if (locale == null) {
                locale = Locale.getDefault();
            }
            for (m printTo : mVarArr) {
                printTo.printTo(appendable, uVar, locale);
            }
        }

        public int estimateParsedLength() {
            return this.d;
        }

        public int parseInto(e eVar, CharSequence charSequence, int i) {
            k[] kVarArr = this.b;
            if (kVarArr == null) {
                throw new UnsupportedOperationException();
            }
            int length = kVarArr.length;
            for (int i2 = 0; i2 < length && i >= 0; i2++) {
                i = kVarArr[i2].parseInto(eVar, charSequence, i);
            }
            return i;
        }

        boolean a() {
            return this.a != null;
        }

        boolean b() {
            return this.b != null;
        }

        private void a(List<Object> list, List<Object> list2, List<Object> list3) {
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                Object obj = list.get(i);
                if (obj instanceof b) {
                    a(list2, ((b) obj).a);
                } else {
                    list2.add(obj);
                }
                obj = list.get(i + 1);
                if (obj instanceof b) {
                    a(list3, ((b) obj).b);
                } else {
                    list3.add(obj);
                }
            }
        }

        private void a(List<Object> list, Object[] objArr) {
            if (objArr != null) {
                for (Object add : objArr) {
                    list.add(add);
                }
            }
        }
    }

    static abstract class f implements k, m {
        protected final c.b.a.d a;
        protected final int b;
        protected final boolean c;

        f(c.b.a.d dVar, int i, boolean z) {
            this.a = dVar;
            this.b = i;
            this.c = z;
        }

        public int estimateParsedLength() {
            return this.b;
        }

        public int parseInto(e eVar, CharSequence charSequence, int i) {
            Object obj;
            int i2 = 0;
            Object obj2 = null;
            int min = Math.min(this.b, charSequence.length() - i);
            Object obj3 = null;
            while (i2 < min) {
                char charAt = charSequence.charAt(i + i2);
                if (i2 != 0 || ((charAt != '-' && charAt != '+') || !this.c)) {
                    if (charAt < '0') {
                        break;
                    } else if (charAt > '9') {
                        obj = obj2;
                        break;
                    } else {
                        i2++;
                    }
                } else {
                    obj2 = charAt == '-' ? 1 : null;
                    if (charAt == '+') {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (i2 + 1 >= min) {
                        break;
                    }
                    charAt = charSequence.charAt((i + i2) + 1);
                    if (charAt < '0') {
                        break;
                    } else if (charAt > '9') {
                        obj = obj2;
                        break;
                    } else {
                        i2++;
                        min = Math.min(min + 1, charSequence.length() - i);
                    }
                }
            }
            obj = obj2;
            if (i2 == 0) {
                return i ^ -1;
            }
            int i3;
            int i4;
            if (i2 < 9) {
                if (obj == null && obj3 == null) {
                    i3 = i;
                } else {
                    i3 = i + 1;
                }
                i4 = i3 + 1;
                try {
                    int charAt2 = charSequence.charAt(i3) - 48;
                    i3 = i + i2;
                    int i5 = i4;
                    i4 = charAt2;
                    for (charAt2 = i5; charAt2 < i3; charAt2++) {
                        i4 = (charSequence.charAt(charAt2) + ((i4 << 3) + (i4 << 1))) - 48;
                    }
                    if (obj != null) {
                        i4 = -i4;
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    return i ^ -1;
                }
            } else if (obj3 != null) {
                i3 = i + i2;
                i4 = Integer.parseInt(charSequence.subSequence(i + 1, i3).toString());
            } else {
                i3 = i + i2;
                i4 = Integer.parseInt(charSequence.subSequence(i, i3).toString());
            }
            eVar.a(this.a, i4);
            return i3;
        }
    }

    static class g extends f {
        protected final int d;

        protected g(c.b.a.d dVar, int i, boolean z, int i2) {
            super(dVar, i, z);
            this.d = i2;
        }

        public int estimatePrintedLength() {
            return this.b;
        }

        public void printTo(Appendable appendable, long j, c.b.a.a aVar, int i, c.b.a.f fVar, Locale locale) {
            try {
                i.a(appendable, this.a.a(aVar).a(j), this.d);
            } catch (RuntimeException e) {
                c.a(appendable, this.d);
            }
        }

        public void printTo(Appendable appendable, u uVar, Locale locale) {
            if (uVar.b(this.a)) {
                try {
                    i.a(appendable, uVar.a(this.a), this.d);
                    return;
                } catch (RuntimeException e) {
                    c.a(appendable, this.d);
                    return;
                }
            }
            c.a(appendable, this.d);
        }
    }

    static class c extends g {
        protected c(c.b.a.d dVar, int i, boolean z) {
            super(dVar, i, z, i);
        }

        public int parseInto(e eVar, CharSequence charSequence, int i) {
            int parseInto = super.parseInto(eVar, charSequence, i);
            if (parseInto < 0) {
                return parseInto;
            }
            int i2 = this.b + i;
            if (parseInto == i2) {
                return parseInto;
            }
            if (this.c) {
                char charAt = charSequence.charAt(i);
                if (charAt == '-' || charAt == '+') {
                    i2++;
                }
            }
            if (parseInto > i2) {
                return (i2 + 1) ^ -1;
            }
            if (parseInto < i2) {
                return parseInto ^ -1;
            }
            return parseInto;
        }
    }

    static class d implements k, m {
        protected int a;
        protected int b;
        private final c.b.a.d c;

        protected d(c.b.a.d dVar, int i, int i2) {
            this.c = dVar;
            if (i2 > 18) {
                i2 = 18;
            }
            this.a = i;
            this.b = i2;
        }

        public int estimatePrintedLength() {
            return this.b;
        }

        public void printTo(Appendable appendable, long j, c.b.a.a aVar, int i, c.b.a.f fVar, Locale locale) {
            a(appendable, j, aVar);
        }

        public void printTo(Appendable appendable, u uVar, Locale locale) {
            a(appendable, uVar.c().a(uVar, 0), uVar.c());
        }

        protected void a(Appendable appendable, long j, c.b.a.a aVar) {
            c.b.a.c a = this.c.a(aVar);
            int i = this.a;
            try {
                long i2 = a.i(j);
                if (i2 == 0) {
                    while (true) {
                        i--;
                        if (i >= 0) {
                            appendable.append('0');
                        } else {
                            return;
                        }
                    }
                }
                CharSequence num;
                long[] a2 = a(i2, a);
                i2 = a2[0];
                int i3 = (int) a2[1];
                if ((2147483647L & i2) == i2) {
                    num = Integer.toString((int) i2);
                } else {
                    num = Long.toString(i2);
                }
                int length = num.length();
                while (length < i3) {
                    appendable.append('0');
                    i--;
                    i3--;
                }
                if (i < i3) {
                    while (i < i3 && length > 1 && num.charAt(length - 1) == '0') {
                        i3--;
                        length--;
                    }
                    if (length < num.length()) {
                        for (i3 = 0; i3 < length; i3++) {
                            appendable.append(num.charAt(i3));
                        }
                        return;
                    }
                }
                appendable.append(num);
            } catch (RuntimeException e) {
                c.a(appendable, i);
            }
        }

        private long[] a(long j, c.b.a.c cVar) {
            long d = cVar.d().d();
            int i = this.b;
            while (true) {
                long j2;
                switch (i) {
                    case 1:
                        j2 = 10;
                        break;
                    case 2:
                        j2 = 100;
                        break;
                    case 3:
                        j2 = 1000;
                        break;
                    case 4:
                        j2 = 10000;
                        break;
                    case 5:
                        j2 = 100000;
                        break;
                    case 6:
                        j2 = 1000000;
                        break;
                    case 7:
                        j2 = 10000000;
                        break;
                    case 8:
                        j2 = 100000000;
                        break;
                    case 9:
                        j2 = 1000000000;
                        break;
                    case 10:
                        j2 = 10000000000L;
                        break;
                    case 11:
                        j2 = 100000000000L;
                        break;
                    case 12:
                        j2 = 1000000000000L;
                        break;
                    case 13:
                        j2 = 10000000000000L;
                        break;
                    case 14:
                        j2 = 100000000000000L;
                        break;
                    case 15:
                        j2 = 1000000000000000L;
                        break;
                    case 16:
                        j2 = 10000000000000000L;
                        break;
                    case 17:
                        j2 = 100000000000000000L;
                        break;
                    case 18:
                        j2 = 1000000000000000000L;
                        break;
                    default:
                        j2 = 1;
                        break;
                }
                if ((d * j2) / j2 == d) {
                    return new long[]{(j2 * j) / d, (long) i};
                }
                i--;
            }
        }

        public int estimateParsedLength() {
            return this.b;
        }

        public int parseInto(e eVar, CharSequence charSequence, int i) {
            c.b.a.c a = this.c.a(eVar.a());
            int min = Math.min(this.b, charSequence.length() - i);
            long j = 0;
            long d = a.d().d() * 10;
            int i2 = 0;
            while (i2 < min) {
                char charAt = charSequence.charAt(i + i2);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i2++;
                d /= 10;
                j += ((long) (charAt - 48)) * d;
            }
            d = j / 10;
            if (i2 == 0) {
                return i ^ -1;
            }
            if (d > 2147483647L) {
                return i ^ -1;
            }
            eVar.a(new c.b.a.d.l(c.b.a.d.a(), c.b.a.d.j.a, a.d()), (int) d);
            return i2 + i;
        }
    }

    static class e implements k {
        private final k[] a;
        private final int b;

        e(k[] kVarArr) {
            this.a = kVarArr;
            int i = 0;
            int length = kVarArr.length;
            while (true) {
                int i2 = length - 1;
                if (i2 >= 0) {
                    k kVar = kVarArr[i2];
                    if (kVar != null) {
                        length = kVar.estimateParsedLength();
                        if (length > i) {
                            i = length;
                            length = i2;
                        }
                    }
                    length = i;
                    i = length;
                    length = i2;
                } else {
                    this.b = i;
                    return;
                }
            }
        }

        public int estimateParsedLength() {
            return this.b;
        }

        public int parseInto(e eVar, CharSequence charSequence, int i) {
            Object f;
            k[] kVarArr = this.a;
            int length = kVarArr.length;
            Object f2 = eVar.f();
            Object obj = null;
            int i2 = 0;
            int i3 = i;
            int i4 = i;
            while (i2 < length) {
                k kVar = kVarArr[i2];
                if (kVar != null) {
                    int i5;
                    int parseInto = kVar.parseInto(eVar, charSequence, i);
                    if (parseInto >= i) {
                        if (parseInto > i4) {
                            if (parseInto >= charSequence.length() || i2 + 1 >= length || kVarArr[i2 + 1] == null) {
                                return parseInto;
                            }
                            f = eVar.f();
                            i5 = parseInto;
                        }
                        f = obj;
                        i5 = i4;
                    } else {
                        if (parseInto < 0) {
                            int i6 = parseInto ^ -1;
                            if (i6 > i3) {
                                i3 = i6;
                                f = obj;
                                i5 = i4;
                            }
                        }
                        f = obj;
                        i5 = i4;
                    }
                    eVar.a(f2);
                    i2++;
                    i4 = i5;
                    obj = f;
                } else if (i4 <= i) {
                    return i;
                } else {
                    f = 1;
                    if (i4 > i && (i4 != i || r1 == null)) {
                        return i3 ^ -1;
                    }
                    if (obj != null) {
                        eVar.a(obj);
                    }
                    return i4;
                }
            }
            f = null;
            if (i4 > i) {
            }
            if (obj != null) {
                eVar.a(obj);
            }
            return i4;
        }
    }

    static class h implements k, m {
        private final String a;

        h(String str) {
            this.a = str;
        }

        public int estimatePrintedLength() {
            return this.a.length();
        }

        public void printTo(Appendable appendable, long j, c.b.a.a aVar, int i, c.b.a.f fVar, Locale locale) {
            appendable.append(this.a);
        }

        public void printTo(Appendable appendable, u uVar, Locale locale) {
            appendable.append(this.a);
        }

        public int estimateParsedLength() {
            return this.a.length();
        }

        public int parseInto(e eVar, CharSequence charSequence, int i) {
            if (c.c(charSequence, i, this.a)) {
                return this.a.length() + i;
            }
            return i ^ -1;
        }
    }

    static class i implements k, m {
        private static Map<Locale, Map<c.b.a.d, Object[]>> a = new ConcurrentHashMap();
        private final c.b.a.d b;
        private final boolean c;

        i(c.b.a.d dVar, boolean z) {
            this.b = dVar;
            this.c = z;
        }

        public int estimatePrintedLength() {
            return this.c ? 6 : 20;
        }

        public void printTo(Appendable appendable, long j, c.b.a.a aVar, int i, c.b.a.f fVar, Locale locale) {
            try {
                appendable.append(a(j, aVar, locale));
            } catch (RuntimeException e) {
                appendable.append('�');
            }
        }

        public void printTo(Appendable appendable, u uVar, Locale locale) {
            try {
                appendable.append(a(uVar, locale));
            } catch (RuntimeException e) {
                appendable.append('�');
            }
        }

        private String a(long j, c.b.a.a aVar, Locale locale) {
            c.b.a.c a = this.b.a(aVar);
            if (this.c) {
                return a.b(j, locale);
            }
            return a.a(j, locale);
        }

        private String a(u uVar, Locale locale) {
            if (!uVar.b(this.b)) {
                return "�";
            }
            c.b.a.c a = this.b.a(uVar.c());
            if (this.c) {
                return a.b(uVar, locale);
            }
            return a.a(uVar, locale);
        }

        public int estimateParsedLength() {
            return estimatePrintedLength();
        }

        public int parseInto(e eVar, CharSequence charSequence, int i) {
            Map map;
            int c;
            Locale b = eVar.b();
            Map map2 = (Map) a.get(b);
            if (map2 == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                a.put(b, concurrentHashMap);
                map = concurrentHashMap;
            } else {
                map = map2;
            }
            Object[] objArr = (Object[]) map.get(this.b);
            if (objArr == null) {
                Map concurrentHashMap2 = new ConcurrentHashMap(32);
                c.b.a.n.a a = new c.b.a.n(0, c.b.a.f.a).a(this.b);
                int g = a.g();
                int h = a.h();
                if (h - g > 32) {
                    return i ^ -1;
                }
                c = a.c(b);
                while (g <= h) {
                    a.a(g);
                    concurrentHashMap2.put(a.b(b), Boolean.TRUE);
                    concurrentHashMap2.put(a.b(b).toLowerCase(b), Boolean.TRUE);
                    concurrentHashMap2.put(a.b(b).toUpperCase(b), Boolean.TRUE);
                    concurrentHashMap2.put(a.a(b), Boolean.TRUE);
                    concurrentHashMap2.put(a.a(b).toLowerCase(b), Boolean.TRUE);
                    concurrentHashMap2.put(a.a(b).toUpperCase(b), Boolean.TRUE);
                    g++;
                }
                if ("en".equals(b.getLanguage()) && this.b == c.b.a.d.w()) {
                    concurrentHashMap2.put("BCE", Boolean.TRUE);
                    concurrentHashMap2.put("bce", Boolean.TRUE);
                    concurrentHashMap2.put("CE", Boolean.TRUE);
                    concurrentHashMap2.put("ce", Boolean.TRUE);
                    c = 3;
                }
                map.put(this.b, new Object[]{concurrentHashMap2, Integer.valueOf(c)});
                map = concurrentHashMap2;
            } else {
                map = (Map) objArr[0];
                c = ((Integer) objArr[1]).intValue();
            }
            for (c = Math.min(charSequence.length(), c + i); c > i; c--) {
                String obj = charSequence.subSequence(i, c).toString();
                if (map.containsKey(obj)) {
                    eVar.a(this.b, obj, b);
                    return c;
                }
            }
            return i ^ -1;
        }
    }

    enum j implements k, m {
        INSTANCE;
        
        private static final List<String> ALL_IDS = null;
        static final int MAX_LENGTH = 0;

        static {
            ALL_IDS = new ArrayList(c.b.a.f.b());
            Collections.sort(ALL_IDS);
            int i = 0;
            for (String length : ALL_IDS) {
                i = Math.max(i, length.length());
            }
            MAX_LENGTH = i;
        }

        public int estimatePrintedLength() {
            return MAX_LENGTH;
        }

        public void printTo(Appendable appendable, long j, c.b.a.a aVar, int i, c.b.a.f fVar, Locale locale) {
            appendable.append(fVar != null ? fVar.e() : "");
        }

        public void printTo(Appendable appendable, u uVar, Locale locale) {
        }

        public int estimateParsedLength() {
            return MAX_LENGTH;
        }

        public int parseInto(e eVar, CharSequence charSequence, int i) {
            String str = null;
            int prefixedStartPosition = prefixedStartPosition(charSequence, i);
            while (prefixedStartPosition < ALL_IDS.size()) {
                String str2 = (String) ALL_IDS.get(prefixedStartPosition);
                if (!c.b(charSequence, i, str2)) {
                    break;
                }
                if (str != null && str2.length() <= str.length()) {
                    str2 = str;
                }
                prefixedStartPosition++;
                str = str2;
            }
            if (str == null) {
                return i ^ -1;
            }
            eVar.a(c.b.a.f.a(str));
            return str.length() + i;
        }

        private static int prefixedStartPosition(CharSequence charSequence, int i) {
            int i2 = 0;
            int size = ALL_IDS.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                int a = c.a(charSequence, i, (String) ALL_IDS.get(i3));
                if (a > 0) {
                    a = i3 - 1;
                    size = i2;
                } else if (a >= 0) {
                    return i3;
                } else {
                    int i4 = size;
                    size = i3 + 1;
                    a = i4;
                }
                i2 = size;
                size = a;
            }
            return i2;
        }
    }

    static class k implements k, m {
        private final Map<String, c.b.a.f> a;
        private final int b;

        k(int i, Map<String, c.b.a.f> map) {
            this.b = i;
            this.a = map;
        }

        public int estimatePrintedLength() {
            return this.b == 1 ? 4 : 20;
        }

        public void printTo(Appendable appendable, long j, c.b.a.a aVar, int i, c.b.a.f fVar, Locale locale) {
            appendable.append(a(j - ((long) i), fVar, locale));
        }

        private String a(long j, c.b.a.f fVar, Locale locale) {
            if (fVar == null) {
                return "";
            }
            switch (this.b) {
                case 0:
                    return fVar.b(j, locale);
                case 1:
                    return fVar.a(j, locale);
                default:
                    return "";
            }
        }

        public void printTo(Appendable appendable, u uVar, Locale locale) {
        }

        public int estimateParsedLength() {
            return this.b == 1 ? 4 : 20;
        }

        public int parseInto(e eVar, CharSequence charSequence, int i) {
            Map map = this.a;
            Map b = map != null ? map : c.b.a.e.b();
            String str = null;
            for (String str2 : b.keySet()) {
                String str22;
                if (!c.b(charSequence, i, str22) || (str != null && str22.length() <= str.length())) {
                    str22 = str;
                }
                str = str22;
            }
            if (str == null) {
                return i ^ -1;
            }
            eVar.a((c.b.a.f) b.get(str));
            return str.length() + i;
        }
    }

    static class l implements k, m {
        private final String a;
        private final String b;
        private final boolean c;
        private final int d;
        private final int e;

        l(String str, String str2, boolean z, int i, int i2) {
            int i3 = 4;
            this.a = str;
            this.b = str2;
            this.c = z;
            if (i <= 0 || i2 < i) {
                throw new IllegalArgumentException();
            }
            if (i > 4) {
                i2 = 4;
            } else {
                i3 = i;
            }
            this.d = i3;
            this.e = i2;
        }

        public int estimatePrintedLength() {
            int i = (this.d + 1) << 1;
            if (this.c) {
                i += this.d - 1;
            }
            if (this.a == null || this.a.length() <= i) {
                return i;
            }
            return this.a.length();
        }

        public void printTo(Appendable appendable, long j, c.b.a.a aVar, int i, c.b.a.f fVar, Locale locale) {
            if (fVar != null) {
                if (i != 0 || this.a == null) {
                    if (i >= 0) {
                        appendable.append('+');
                    } else {
                        appendable.append('-');
                        i = -i;
                    }
                    int i2 = i / 3600000;
                    i.a(appendable, i2, 2);
                    if (this.e != 1) {
                        i2 = i - (i2 * 3600000);
                        if (i2 != 0 || this.d > 1) {
                            int i3 = i2 / WeatherChannelDataModels.MS_TO_MIN_DIVISOR;
                            if (this.c) {
                                appendable.append(':');
                            }
                            i.a(appendable, i3, 2);
                            if (this.e != 2) {
                                i2 -= i3 * WeatherChannelDataModels.MS_TO_MIN_DIVISOR;
                                if (i2 != 0 || this.d > 2) {
                                    i3 = i2 / 1000;
                                    if (this.c) {
                                        appendable.append(':');
                                    }
                                    i.a(appendable, i3, 2);
                                    if (this.e != 3) {
                                        i2 -= i3 * 1000;
                                        if (i2 != 0 || this.d > 3) {
                                            if (this.c) {
                                                appendable.append('.');
                                            }
                                            i.a(appendable, i2, 3);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                appendable.append(this.a);
            }
        }

        public void printTo(Appendable appendable, u uVar, Locale locale) {
        }

        public int estimateParsedLength() {
            return estimatePrintedLength();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int parseInto(c.b.a.e.e r10, java.lang.CharSequence r11, int r12) {
            /*
            r9 = this;
            r5 = 45;
            r4 = 43;
            r2 = 0;
            r1 = 1;
            r8 = 2;
            r0 = r11.length();
            r3 = r0 - r12;
            r0 = r9.b;
            if (r0 == 0) goto L_0x0023;
        L_0x0011:
            r0 = r9.b;
            r0 = r0.length();
            if (r0 != 0) goto L_0x0030;
        L_0x0019:
            if (r3 <= 0) goto L_0x0028;
        L_0x001b:
            r0 = r11.charAt(r12);
            if (r0 == r5) goto L_0x0023;
        L_0x0021:
            if (r0 != r4) goto L_0x0028;
        L_0x0023:
            if (r3 > r1) goto L_0x0047;
        L_0x0025:
            r12 = r12 ^ -1;
        L_0x0027:
            return r12;
        L_0x0028:
            r0 = java.lang.Integer.valueOf(r2);
            r10.a(r0);
            goto L_0x0027;
        L_0x0030:
            r0 = r9.b;
            r0 = c.b.a.e.c.c(r11, r12, r0);
            if (r0 == 0) goto L_0x0023;
        L_0x0038:
            r0 = java.lang.Integer.valueOf(r2);
            r10.a(r0);
            r0 = r9.b;
            r0 = r0.length();
            r12 = r12 + r0;
            goto L_0x0027;
        L_0x0047:
            r0 = r11.charAt(r12);
            if (r0 != r5) goto L_0x005b;
        L_0x004d:
            r0 = r1;
        L_0x004e:
            r3 = r3 + -1;
            r4 = r12 + 1;
            r5 = r9.a(r11, r4, r8);
            if (r5 >= r8) goto L_0x0062;
        L_0x0058:
            r12 = r4 ^ -1;
            goto L_0x0027;
        L_0x005b:
            if (r0 != r4) goto L_0x005f;
        L_0x005d:
            r0 = r2;
            goto L_0x004e;
        L_0x005f:
            r12 = r12 ^ -1;
            goto L_0x0027;
        L_0x0062:
            r5 = c.b.a.e.i.a(r11, r4);
            r6 = 23;
            if (r5 <= r6) goto L_0x006d;
        L_0x006a:
            r12 = r4 ^ -1;
            goto L_0x0027;
        L_0x006d:
            r6 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
            r5 = r5 * r6;
            r3 = r3 + -2;
            r4 = r4 + 2;
            if (r3 > 0) goto L_0x0084;
        L_0x0077:
            r1 = r5;
            r12 = r4;
        L_0x0079:
            if (r0 == 0) goto L_0x0157;
        L_0x007b:
            r0 = -r1;
        L_0x007c:
            r0 = java.lang.Integer.valueOf(r0);
            r10.a(r0);
            goto L_0x0027;
        L_0x0084:
            r6 = r11.charAt(r4);
            r7 = 58;
            if (r6 != r7) goto L_0x009e;
        L_0x008c:
            r2 = r3 + -1;
            r3 = r4 + 1;
            r4 = r3;
            r3 = r2;
            r2 = r1;
        L_0x0093:
            r6 = r9.a(r11, r4, r8);
            if (r6 != 0) goto L_0x00a9;
        L_0x0099:
            if (r2 != 0) goto L_0x00a9;
        L_0x009b:
            r1 = r5;
            r12 = r4;
            goto L_0x0079;
        L_0x009e:
            r7 = 48;
            if (r6 < r7) goto L_0x00a6;
        L_0x00a2:
            r7 = 57;
            if (r6 <= r7) goto L_0x0093;
        L_0x00a6:
            r1 = r5;
            r12 = r4;
            goto L_0x0079;
        L_0x00a9:
            if (r6 >= r8) goto L_0x00af;
        L_0x00ab:
            r12 = r4 ^ -1;
            goto L_0x0027;
        L_0x00af:
            r6 = c.b.a.e.i.a(r11, r4);
            r7 = 59;
            if (r6 <= r7) goto L_0x00bb;
        L_0x00b7:
            r12 = r4 ^ -1;
            goto L_0x0027;
        L_0x00bb:
            r7 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
            r6 = r6 * r7;
            r5 = r5 + r6;
            r3 = r3 + -2;
            r4 = r4 + 2;
            if (r3 > 0) goto L_0x00c9;
        L_0x00c6:
            r1 = r5;
            r12 = r4;
            goto L_0x0079;
        L_0x00c9:
            if (r2 == 0) goto L_0x00da;
        L_0x00cb:
            r6 = r11.charAt(r4);
            r7 = 58;
            if (r6 == r7) goto L_0x00d6;
        L_0x00d3:
            r1 = r5;
            r12 = r4;
            goto L_0x0079;
        L_0x00d6:
            r3 = r3 + -1;
            r4 = r4 + 1;
        L_0x00da:
            r6 = r9.a(r11, r4, r8);
            if (r6 != 0) goto L_0x00e5;
        L_0x00e0:
            if (r2 != 0) goto L_0x00e5;
        L_0x00e2:
            r1 = r5;
            r12 = r4;
            goto L_0x0079;
        L_0x00e5:
            if (r6 >= r8) goto L_0x00eb;
        L_0x00e7:
            r12 = r4 ^ -1;
            goto L_0x0027;
        L_0x00eb:
            r6 = c.b.a.e.i.a(r11, r4);
            r7 = 59;
            if (r6 <= r7) goto L_0x00f7;
        L_0x00f3:
            r12 = r4 ^ -1;
            goto L_0x0027;
        L_0x00f7:
            r6 = r6 * 1000;
            r5 = r5 + r6;
            r6 = r3 + -2;
            r3 = r4 + 2;
            if (r6 > 0) goto L_0x0104;
        L_0x0100:
            r1 = r5;
            r12 = r3;
            goto L_0x0079;
        L_0x0104:
            if (r2 == 0) goto L_0x011e;
        L_0x0106:
            r4 = r11.charAt(r3);
            r7 = 46;
            if (r4 == r7) goto L_0x011a;
        L_0x010e:
            r4 = r11.charAt(r3);
            r7 = 44;
            if (r4 == r7) goto L_0x011a;
        L_0x0116:
            r1 = r5;
            r12 = r3;
            goto L_0x0079;
        L_0x011a:
            r4 = r6 + -1;
            r3 = r3 + 1;
        L_0x011e:
            r4 = 3;
            r6 = r9.a(r11, r3, r4);
            if (r6 != 0) goto L_0x012b;
        L_0x0125:
            if (r2 != 0) goto L_0x012b;
        L_0x0127:
            r1 = r5;
            r12 = r3;
            goto L_0x0079;
        L_0x012b:
            if (r6 >= r1) goto L_0x0131;
        L_0x012d:
            r12 = r3 ^ -1;
            goto L_0x0027;
        L_0x0131:
            r4 = r3 + 1;
            r2 = r11.charAt(r3);
            r2 = r2 + -48;
            r2 = r2 * 100;
            r2 = r2 + r5;
            if (r6 <= r1) goto L_0x015d;
        L_0x013e:
            r3 = r4 + 1;
            r1 = r11.charAt(r4);
            r1 = r1 + -48;
            r1 = r1 * 10;
            r1 = r1 + r2;
            if (r6 <= r8) goto L_0x015a;
        L_0x014b:
            r4 = r3 + 1;
            r2 = r11.charAt(r3);
            r2 = r2 + -48;
            r1 = r1 + r2;
            r12 = r4;
            goto L_0x0079;
        L_0x0157:
            r0 = r1;
            goto L_0x007c;
        L_0x015a:
            r12 = r3;
            goto L_0x0079;
        L_0x015d:
            r1 = r2;
            r12 = r4;
            goto L_0x0079;
            */
            throw new UnsupportedOperationException("Method not decompiled: c.b.a.e.c.l.parseInto(c.b.a.e.e, java.lang.CharSequence, int):int");
        }

        private int a(CharSequence charSequence, int i, int i2) {
            int i3 = 0;
            for (int min = Math.min(charSequence.length() - i, i2); min > 0; min--) {
                char charAt = charSequence.charAt(i + i3);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i3++;
            }
            return i3;
        }
    }

    static class m implements k, m {
        private final c.b.a.d a;
        private final int b;
        private final boolean c;

        m(c.b.a.d dVar, int i, boolean z) {
            this.a = dVar;
            this.b = i;
            this.c = z;
        }

        public int estimateParsedLength() {
            return this.c ? 4 : 2;
        }

        public int parseInto(e eVar, CharSequence charSequence, int i) {
            int i2;
            char charAt;
            int charAt2;
            int i3 = 0;
            int length = charSequence.length() - i;
            if (this.c) {
                i2 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = length;
                while (i2 < i6) {
                    charAt = charSequence.charAt(i + i2);
                    if (i2 != 0 || (charAt != '-' && charAt != '+')) {
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i2++;
                    } else {
                        if (charAt == '-') {
                            length = 1;
                        } else {
                            length = 0;
                        }
                        if (length != 0) {
                            i2++;
                            i4 = length;
                            i5 = 1;
                        } else {
                            i++;
                            i5 = 1;
                            i6--;
                            i4 = length;
                        }
                    }
                }
                if (i2 == 0) {
                    return i ^ -1;
                }
                if (!(i5 == 0 && i2 == 2)) {
                    if (i2 >= 9) {
                        length = i + i2;
                        i3 = Integer.parseInt(charSequence.subSequence(i, length).toString());
                    } else {
                        if (i4 != 0) {
                            length = i + 1;
                        } else {
                            length = i;
                        }
                        i3 = length + 1;
                        try {
                            charAt2 = charSequence.charAt(length) - 48;
                            length = i + i2;
                            int i7 = i3;
                            i3 = charAt2;
                            charAt2 = i7;
                            while (charAt2 < length) {
                                i2 = (i3 << 3) + (i3 << 1);
                                i7 = charAt2 + 1;
                                i3 = (charSequence.charAt(charAt2) + i2) - 48;
                                charAt2 = i7;
                            }
                            if (i4 != 0) {
                                i3 = -i3;
                            }
                        } catch (StringIndexOutOfBoundsException e) {
                            return i ^ -1;
                        }
                    }
                    eVar.a(this.a, i3);
                    return length;
                }
            } else if (Math.min(2, length) < 2) {
                return i ^ -1;
            }
            charAt = charSequence.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i ^ -1;
            }
            length = charAt - 48;
            char charAt3 = charSequence.charAt(i + 1);
            if (charAt3 < '0' || charAt3 > '9') {
                return i ^ -1;
            }
            charAt2 = (((length << 1) + (length << 3)) + charAt3) - 48;
            length = this.b;
            if (eVar.e() != null) {
                length = eVar.e().intValue();
            }
            i2 = length - 50;
            if (i2 >= 0) {
                length = i2 % 100;
            } else {
                length = ((i2 + 1) % 100) + 99;
            }
            if (charAt2 < length) {
                i3 = 100;
            }
            eVar.a(this.a, ((i3 + i2) - length) + charAt2);
            return i + 2;
        }

        public int estimatePrintedLength() {
            return 2;
        }

        public void printTo(Appendable appendable, long j, c.b.a.a aVar, int i, c.b.a.f fVar, Locale locale) {
            int a = a(j, aVar);
            if (a < 0) {
                appendable.append('�');
                appendable.append('�');
                return;
            }
            i.a(appendable, a, 2);
        }

        private int a(long j, c.b.a.a aVar) {
            try {
                int a = this.a.a(aVar).a(j);
                if (a < 0) {
                    a = -a;
                }
                return a % 100;
            } catch (RuntimeException e) {
                return -1;
            }
        }

        public void printTo(Appendable appendable, u uVar, Locale locale) {
            int a = a(uVar);
            if (a < 0) {
                appendable.append('�');
                appendable.append('�');
                return;
            }
            i.a(appendable, a, 2);
        }

        private int a(u uVar) {
            if (uVar.b(this.a)) {
                try {
                    int a = uVar.a(this.a);
                    if (a < 0) {
                        a = -a;
                    }
                    return a % 100;
                } catch (RuntimeException e) {
                }
            }
            return -1;
        }
    }

    static class n extends f {
        protected n(c.b.a.d dVar, int i, boolean z) {
            super(dVar, i, z);
        }

        public int estimatePrintedLength() {
            return this.b;
        }

        public void printTo(Appendable appendable, long j, c.b.a.a aVar, int i, c.b.a.f fVar, Locale locale) {
            try {
                i.a(appendable, this.a.a(aVar).a(j));
            } catch (RuntimeException e) {
                appendable.append('�');
            }
        }

        public void printTo(Appendable appendable, u uVar, Locale locale) {
            if (uVar.b(this.a)) {
                try {
                    i.a(appendable, uVar.a(this.a));
                    return;
                } catch (RuntimeException e) {
                    appendable.append('�');
                    return;
                }
            }
            appendable.append('�');
        }
    }

    public b a() {
        m mVar;
        k kVar;
        Object k = k();
        if (b(k)) {
            mVar = (m) k;
        } else {
            mVar = null;
        }
        if (c(k)) {
            kVar = (k) k;
        } else {
            kVar = null;
        }
        if (mVar != null || kVar != null) {
            return new b(mVar, kVar);
        }
        throw new UnsupportedOperationException("Both printing and parsing not supported");
    }

    public d b() {
        Object k = k();
        if (c(k)) {
            return l.a((k) k);
        }
        throw new UnsupportedOperationException("Parsing is not supported");
    }

    public c a(b bVar) {
        if (bVar != null) {
            return a(bVar.a(), bVar.c());
        }
        throw new IllegalArgumentException("No formatter supplied");
    }

    public c a(d dVar) {
        c(dVar);
        return a(null, f.a(dVar));
    }

    public c a(g gVar, d[] dVarArr) {
        int i = 0;
        if (gVar != null) {
            a(gVar);
        }
        if (dVarArr == null) {
            throw new IllegalArgumentException("No parsers supplied");
        }
        int length = dVarArr.length;
        if (length != 1) {
            k[] kVarArr = new k[length];
            while (i < length - 1) {
                k a = f.a(dVarArr[i]);
                kVarArr[i] = a;
                if (a == null) {
                    throw new IllegalArgumentException("Incomplete parser array");
                }
                i++;
            }
            kVarArr[i] = f.a(dVarArr[i]);
            return a(h.a(gVar), new e(kVarArr));
        } else if (dVarArr[0] != null) {
            return a(h.a(gVar), f.a(dVarArr[0]));
        } else {
            throw new IllegalArgumentException("No parser supplied");
        }
    }

    public c b(d dVar) {
        c(dVar);
        return a(null, new e(new k[]{f.a(dVar), null}));
    }

    private void c(d dVar) {
        if (dVar == null) {
            throw new IllegalArgumentException("No parser supplied");
        }
    }

    private void a(g gVar) {
        if (gVar == null) {
            throw new IllegalArgumentException("No printer supplied");
        }
    }

    private c a(Object obj) {
        this.b = null;
        this.a.add(obj);
        this.a.add(obj);
        return this;
    }

    private c a(m mVar, k kVar) {
        this.b = null;
        this.a.add(mVar);
        this.a.add(kVar);
        return this;
    }

    public c a(char c) {
        return a(new a(c));
    }

    public c a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Literal must not be null");
        }
        switch (str.length()) {
            case 0:
                return this;
            case 1:
                return a(new a(str.charAt(0)));
            default:
                return a(new h(str));
        }
    }

    public c a(c.b.a.d dVar, int i, int i2) {
        if (dVar == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i2 < i) {
            i2 = i;
        }
        if (i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        } else if (i <= 1) {
            return a(new n(dVar, i2, false));
        } else {
            return a(new g(dVar, i2, false, i));
        }
    }

    public c a(c.b.a.d dVar, int i) {
        if (dVar == null) {
            throw new IllegalArgumentException("Field type must not be null");
        } else if (i > 0) {
            return a(new c(dVar, i, false));
        } else {
            throw new IllegalArgumentException("Illegal number of digits: " + i);
        }
    }

    public c b(c.b.a.d dVar, int i, int i2) {
        if (dVar == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i2 < i) {
            i2 = i;
        }
        if (i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        } else if (i <= 1) {
            return a(new n(dVar, i2, true));
        } else {
            return a(new g(dVar, i2, true, i));
        }
    }

    public c a(c.b.a.d dVar) {
        if (dVar != null) {
            return a(new i(dVar, false));
        }
        throw new IllegalArgumentException("Field type must not be null");
    }

    public c b(c.b.a.d dVar) {
        if (dVar != null) {
            return a(new i(dVar, true));
        }
        throw new IllegalArgumentException("Field type must not be null");
    }

    public c c(c.b.a.d dVar, int i, int i2) {
        if (dVar == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i2 < i) {
            i2 = i;
        }
        if (i >= 0 && i2 > 0) {
            return a(new d(dVar, i, i2));
        }
        throw new IllegalArgumentException();
    }

    public c a(int i, int i2) {
        return c(c.b.a.d.d(), i, i2);
    }

    public c b(int i, int i2) {
        return c(c.b.a.d.f(), i, i2);
    }

    public c c(int i, int i2) {
        return c(c.b.a.d.g(), i, i2);
    }

    public c a(int i) {
        return a(c.b.a.d.c(), i, 2);
    }

    public c b(int i) {
        return a(c.b.a.d.e(), i, 2);
    }

    public c c(int i) {
        return a(c.b.a.d.g(), i, 2);
    }

    public c d(int i) {
        return a(c.b.a.d.h(), i, 2);
    }

    public c e(int i) {
        return a(c.b.a.d.i(), i, 2);
    }

    public c f(int i) {
        return a(c.b.a.d.j(), i, 2);
    }

    public c g(int i) {
        return a(c.b.a.d.l(), i, 1);
    }

    public c h(int i) {
        return a(c.b.a.d.m(), i, 2);
    }

    public c i(int i) {
        return a(c.b.a.d.n(), i, 3);
    }

    public c j(int i) {
        return a(c.b.a.d.o(), i, 2);
    }

    public c d(int i, int i2) {
        return b(c.b.a.d.p(), i, i2);
    }

    public c k(int i) {
        return a(c.b.a.d.r(), i, 2);
    }

    public c e(int i, int i2) {
        return b(c.b.a.d.s(), i, i2);
    }

    public c a(int i, boolean z) {
        return a(new m(c.b.a.d.s(), i, z));
    }

    public c b(int i, boolean z) {
        return a(new m(c.b.a.d.p(), i, z));
    }

    public c f(int i, int i2) {
        return a(c.b.a.d.t(), i, i2);
    }

    public c g(int i, int i2) {
        return b(c.b.a.d.v(), i, i2);
    }

    public c c() {
        return a(c.b.a.d.k());
    }

    public c d() {
        return a(c.b.a.d.l());
    }

    public c e() {
        return b(c.b.a.d.l());
    }

    public c f() {
        return a(c.b.a.d.r());
    }

    public c g() {
        return b(c.b.a.d.r());
    }

    public c h() {
        return a(c.b.a.d.w());
    }

    public c i() {
        return a(new k(0, null), null);
    }

    public c a(Map<String, c.b.a.f> map) {
        m kVar = new k(1, map);
        return a(kVar, (k) kVar);
    }

    public c j() {
        return a(j.INSTANCE, j.INSTANCE);
    }

    public c a(String str, boolean z, int i, int i2) {
        return a(new l(str, str, z, i, i2));
    }

    public c a(String str, String str2, boolean z, int i, int i2) {
        return a(new l(str, str2, z, i, i2));
    }

    private Object k() {
        Object obj = this.b;
        if (obj == null) {
            if (this.a.size() == 2) {
                Object obj2 = this.a.get(0);
                Object obj3 = this.a.get(1);
                if (obj2 == null) {
                    obj = obj3;
                } else if (obj2 == obj3 || obj3 == null) {
                    obj = obj2;
                }
            }
            if (obj == null) {
                obj = new b(this.a);
            }
            this.b = obj;
        }
        return obj;
    }

    private boolean b(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        if (obj instanceof b) {
            return ((b) obj).a();
        }
        return true;
    }

    private boolean c(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj instanceof b) {
            return ((b) obj).b();
        }
        return true;
    }

    static void a(Appendable appendable, int i) {
        while (true) {
            i--;
            if (i >= 0) {
                appendable.append('�');
            } else {
                return;
            }
        }
    }

    static int a(CharSequence charSequence, int i, String str) {
        int length = charSequence.length() - i;
        int length2 = str.length();
        int min = Math.min(length, length2);
        for (int i2 = 0; i2 < min; i2++) {
            int charAt = str.charAt(i2) - charSequence.charAt(i + i2);
            if (charAt != 0) {
                return charAt;
            }
        }
        return length2 - length;
    }

    static boolean b(CharSequence charSequence, int i, String str) {
        int length = str.length();
        if (charSequence.length() - i < length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (charSequence.charAt(i + i2) != str.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    static boolean c(CharSequence charSequence, int i, String str) {
        int length = str.length();
        if (charSequence.length() - i < length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = charSequence.charAt(i + i2);
            char charAt2 = str.charAt(i2);
            if (charAt != charAt2) {
                charAt = Character.toUpperCase(charAt);
                charAt2 = Character.toUpperCase(charAt2);
                if (!(charAt == charAt2 || Character.toLowerCase(charAt) == Character.toLowerCase(charAt2))) {
                    return false;
                }
            }
        }
        return true;
    }
}
