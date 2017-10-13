package com.google.b.b.a;

import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.i;
import com.google.b.l;
import com.google.b.m;
import com.google.b.o;
import com.google.b.r;
import com.google.b.u;
import com.google.b.w;
import com.google.b.x;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class n {
    public static final w<String> A = new w<String>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public String a(com.google.b.d.a aVar) {
            b f = aVar.f();
            if (f == b.NULL) {
                aVar.j();
                return null;
            } else if (f == b.BOOLEAN) {
                return Boolean.toString(aVar.i());
            } else {
                return aVar.h();
            }
        }

        public void a(c cVar, String str) {
            cVar.b(str);
        }
    };
    public static final w<BigDecimal> B = new w<BigDecimal>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public BigDecimal a(com.google.b.d.a aVar) {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return new BigDecimal(aVar.h());
            } catch (Throwable e) {
                throw new u(e);
            }
        }

        public void a(c cVar, BigDecimal bigDecimal) {
            cVar.a((Number) bigDecimal);
        }
    };
    public static final w<BigInteger> C = new w<BigInteger>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public BigInteger a(com.google.b.d.a aVar) {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return new BigInteger(aVar.h());
            } catch (Throwable e) {
                throw new u(e);
            }
        }

        public void a(c cVar, BigInteger bigInteger) {
            cVar.a((Number) bigInteger);
        }
    };
    public static final x D = a(String.class, A);
    public static final w<StringBuilder> E = new w<StringBuilder>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public StringBuilder a(com.google.b.d.a aVar) {
            if (aVar.f() != b.NULL) {
                return new StringBuilder(aVar.h());
            }
            aVar.j();
            return null;
        }

        public void a(c cVar, StringBuilder stringBuilder) {
            cVar.b(stringBuilder == null ? null : stringBuilder.toString());
        }
    };
    public static final x F = a(StringBuilder.class, E);
    public static final w<StringBuffer> G = new w<StringBuffer>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public StringBuffer a(com.google.b.d.a aVar) {
            if (aVar.f() != b.NULL) {
                return new StringBuffer(aVar.h());
            }
            aVar.j();
            return null;
        }

        public void a(c cVar, StringBuffer stringBuffer) {
            cVar.b(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final x H = a(StringBuffer.class, G);
    public static final w<URL> I = new w<URL>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public URL a(com.google.b.d.a aVar) {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            String h = aVar.h();
            if ("null".equals(h)) {
                return null;
            }
            return new URL(h);
        }

        public void a(c cVar, URL url) {
            cVar.b(url == null ? null : url.toExternalForm());
        }
    };
    public static final x J = a(URL.class, I);
    public static final w<URI> K = new w<URI>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public URI a(com.google.b.d.a aVar) {
            URI uri = null;
            if (aVar.f() == b.NULL) {
                aVar.j();
            } else {
                try {
                    String h = aVar.h();
                    if (!"null".equals(h)) {
                        uri = new URI(h);
                    }
                } catch (Throwable e) {
                    throw new m(e);
                }
            }
            return uri;
        }

        public void a(c cVar, URI uri) {
            cVar.b(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final x L = a(URI.class, K);
    public static final w<InetAddress> M = new w<InetAddress>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public InetAddress a(com.google.b.d.a aVar) {
            if (aVar.f() != b.NULL) {
                return InetAddress.getByName(aVar.h());
            }
            aVar.j();
            return null;
        }

        public void a(c cVar, InetAddress inetAddress) {
            cVar.b(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final x N = b(InetAddress.class, M);
    public static final w<UUID> O = new w<UUID>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public UUID a(com.google.b.d.a aVar) {
            if (aVar.f() != b.NULL) {
                return UUID.fromString(aVar.h());
            }
            aVar.j();
            return null;
        }

        public void a(c cVar, UUID uuid) {
            cVar.b(uuid == null ? null : uuid.toString());
        }
    };
    public static final x P = a(UUID.class, O);
    public static final w<Currency> Q = new w<Currency>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public Currency a(com.google.b.d.a aVar) {
            return Currency.getInstance(aVar.h());
        }

        public void a(c cVar, Currency currency) {
            cVar.b(currency.getCurrencyCode());
        }
    }.a();
    public static final x R = a(Currency.class, Q);
    public static final x S = new x() {
        public <T> w<T> a(f fVar, com.google.b.c.a<T> aVar) {
            if (aVar.getRawType() != Timestamp.class) {
                return null;
            }
            final w a = fVar.a(Date.class);
            return new w<Timestamp>(this) {
                final /* synthetic */ AnonymousClass19 b;

                public /* synthetic */ Object b(com.google.b.d.a aVar) {
                    return a(aVar);
                }

                public Timestamp a(com.google.b.d.a aVar) {
                    Date date = (Date) a.b(aVar);
                    return date != null ? new Timestamp(date.getTime()) : null;
                }

                public void a(c cVar, Timestamp timestamp) {
                    a.a(cVar, timestamp);
                }
            };
        }
    };
    public static final w<Calendar> T = new w<Calendar>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public Calendar a(com.google.b.d.a aVar) {
            int i = 0;
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            aVar.c();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (aVar.f() != b.END_OBJECT) {
                String g = aVar.g();
                int m = aVar.m();
                if ("year".equals(g)) {
                    i6 = m;
                } else if ("month".equals(g)) {
                    i5 = m;
                } else if ("dayOfMonth".equals(g)) {
                    i4 = m;
                } else if ("hourOfDay".equals(g)) {
                    i3 = m;
                } else if ("minute".equals(g)) {
                    i2 = m;
                } else if ("second".equals(g)) {
                    i = m;
                }
            }
            aVar.d();
            return new GregorianCalendar(i6, i5, i4, i3, i2, i);
        }

        public void a(c cVar, Calendar calendar) {
            if (calendar == null) {
                cVar.f();
                return;
            }
            cVar.d();
            cVar.a("year");
            cVar.a((long) calendar.get(1));
            cVar.a("month");
            cVar.a((long) calendar.get(2));
            cVar.a("dayOfMonth");
            cVar.a((long) calendar.get(5));
            cVar.a("hourOfDay");
            cVar.a((long) calendar.get(11));
            cVar.a("minute");
            cVar.a((long) calendar.get(12));
            cVar.a("second");
            cVar.a((long) calendar.get(13));
            cVar.e();
        }
    };
    public static final x U = b(Calendar.class, GregorianCalendar.class, T);
    public static final w<Locale> V = new w<Locale>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public Locale a(com.google.b.d.a aVar) {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            String nextToken;
            String nextToken2;
            String nextToken3;
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.h(), "_");
            if (stringTokenizer.hasMoreElements()) {
                nextToken = stringTokenizer.nextToken();
            } else {
                nextToken = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                nextToken2 = stringTokenizer.nextToken();
            } else {
                nextToken2 = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                nextToken3 = stringTokenizer.nextToken();
            } else {
                nextToken3 = null;
            }
            if (nextToken2 == null && nextToken3 == null) {
                return new Locale(nextToken);
            }
            if (nextToken3 == null) {
                return new Locale(nextToken, nextToken2);
            }
            return new Locale(nextToken, nextToken2, nextToken3);
        }

        public void a(c cVar, Locale locale) {
            cVar.b(locale == null ? null : locale.toString());
        }
    };
    public static final x W = a(Locale.class, V);
    public static final w<l> X = new w<l>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public l a(com.google.b.d.a aVar) {
            l iVar;
            switch (aVar.f()) {
                case NUMBER:
                    return new r(new com.google.b.b.f(aVar.h()));
                case BOOLEAN:
                    return new r(Boolean.valueOf(aVar.i()));
                case STRING:
                    return new r(aVar.h());
                case NULL:
                    aVar.j();
                    return com.google.b.n.a;
                case BEGIN_ARRAY:
                    iVar = new i();
                    aVar.a();
                    while (aVar.e()) {
                        iVar.a(a(aVar));
                    }
                    aVar.b();
                    return iVar;
                case BEGIN_OBJECT:
                    iVar = new o();
                    aVar.c();
                    while (aVar.e()) {
                        iVar.a(aVar.g(), a(aVar));
                    }
                    aVar.d();
                    return iVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public void a(c cVar, l lVar) {
            if (lVar == null || lVar.k()) {
                cVar.f();
            } else if (lVar.j()) {
                r n = lVar.n();
                if (n.p()) {
                    cVar.a(n.b());
                } else if (n.a()) {
                    cVar.a(n.g());
                } else {
                    cVar.b(n.c());
                }
            } else if (lVar.h()) {
                cVar.b();
                Iterator it = lVar.m().iterator();
                while (it.hasNext()) {
                    a(cVar, (l) it.next());
                }
                cVar.c();
            } else if (lVar.i()) {
                cVar.d();
                for (Entry entry : lVar.l().a()) {
                    cVar.a((String) entry.getKey());
                    a(cVar, (l) entry.getValue());
                }
                cVar.e();
            } else {
                throw new IllegalArgumentException("Couldn't write " + lVar.getClass());
            }
        }
    };
    public static final x Y = b(l.class, X);
    public static final x Z = new x() {
        public <T> w<T> a(f fVar, com.google.b.c.a<T> aVar) {
            Class rawType = aVar.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new a(rawType);
        }
    };
    public static final w<Class> a = new w<Class>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public void a(c cVar, Class cls) {
            if (cls == null) {
                cVar.f();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        public Class a(com.google.b.d.a aVar) {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    };
    public static final x b = a(Class.class, a);
    public static final w<BitSet> c = new w<BitSet>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public BitSet a(com.google.b.d.a aVar) {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            BitSet bitSet = new BitSet();
            aVar.a();
            b f = aVar.f();
            int i = 0;
            while (f != b.END_ARRAY) {
                boolean z;
                switch (f) {
                    case NUMBER:
                        if (aVar.m() == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case BOOLEAN:
                        z = aVar.i();
                        break;
                    case STRING:
                        String h = aVar.h();
                        try {
                            if (Integer.parseInt(h) == 0) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        } catch (NumberFormatException e) {
                            throw new u("Error: Expecting: bitset number value (1, 0), Found: " + h);
                        }
                    default:
                        throw new u("Invalid bitset value type: " + f);
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                f = aVar.f();
            }
            aVar.b();
            return bitSet;
        }

        public void a(c cVar, BitSet bitSet) {
            if (bitSet == null) {
                cVar.f();
                return;
            }
            cVar.b();
            for (int i = 0; i < bitSet.length(); i++) {
                int i2;
                if (bitSet.get(i)) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                cVar.a((long) i2);
            }
            cVar.c();
        }
    };
    public static final x d = a(BitSet.class, c);
    public static final w<Boolean> e = new w<Boolean>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public Boolean a(com.google.b.d.a aVar) {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            } else if (aVar.f() == b.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.h()));
            } else {
                return Boolean.valueOf(aVar.i());
            }
        }

        public void a(c cVar, Boolean bool) {
            cVar.a(bool);
        }
    };
    public static final w<Boolean> f = new w<Boolean>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public Boolean a(com.google.b.d.a aVar) {
            if (aVar.f() != b.NULL) {
                return Boolean.valueOf(aVar.h());
            }
            aVar.j();
            return null;
        }

        public void a(c cVar, Boolean bool) {
            cVar.b(bool == null ? "null" : bool.toString());
        }
    };
    public static final x g = a(Boolean.TYPE, Boolean.class, e);
    public static final w<Number> h = new w<Number>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public Number a(com.google.b.d.a aVar) {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.m());
            } catch (Throwable e) {
                throw new u(e);
            }
        }

        public void a(c cVar, Number number) {
            cVar.a(number);
        }
    };
    public static final x i = a(Byte.TYPE, Byte.class, h);
    public static final w<Number> j = new w<Number>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public Number a(com.google.b.d.a aVar) {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.m());
            } catch (Throwable e) {
                throw new u(e);
            }
        }

        public void a(c cVar, Number number) {
            cVar.a(number);
        }
    };
    public static final x k = a(Short.TYPE, Short.class, j);
    public static final w<Number> l = new w<Number>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public Number a(com.google.b.d.a aVar) {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Integer.valueOf(aVar.m());
            } catch (Throwable e) {
                throw new u(e);
            }
        }

        public void a(c cVar, Number number) {
            cVar.a(number);
        }
    };
    public static final x m = a(Integer.TYPE, Integer.class, l);
    public static final w<AtomicInteger> n = new w<AtomicInteger>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public AtomicInteger a(com.google.b.d.a aVar) {
            try {
                return new AtomicInteger(aVar.m());
            } catch (Throwable e) {
                throw new u(e);
            }
        }

        public void a(c cVar, AtomicInteger atomicInteger) {
            cVar.a((long) atomicInteger.get());
        }
    }.a();
    public static final x o = a(AtomicInteger.class, n);
    public static final w<AtomicBoolean> p = new w<AtomicBoolean>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public AtomicBoolean a(com.google.b.d.a aVar) {
            return new AtomicBoolean(aVar.i());
        }

        public void a(c cVar, AtomicBoolean atomicBoolean) {
            cVar.a(atomicBoolean.get());
        }
    }.a();
    public static final x q = a(AtomicBoolean.class, p);
    public static final w<AtomicIntegerArray> r = new w<AtomicIntegerArray>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public AtomicIntegerArray a(com.google.b.d.a aVar) {
            List arrayList = new ArrayList();
            aVar.a();
            while (aVar.e()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.m()));
                } catch (Throwable e) {
                    throw new u(e);
                }
            }
            aVar.b();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i = 0; i < size; i++) {
                atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
            }
            return atomicIntegerArray;
        }

        public void a(c cVar, AtomicIntegerArray atomicIntegerArray) {
            cVar.b();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                cVar.a((long) atomicIntegerArray.get(i));
            }
            cVar.c();
        }
    }.a();
    public static final x s = a(AtomicIntegerArray.class, r);
    public static final w<Number> t = new w<Number>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public Number a(com.google.b.d.a aVar) {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Long.valueOf(aVar.l());
            } catch (Throwable e) {
                throw new u(e);
            }
        }

        public void a(c cVar, Number number) {
            cVar.a(number);
        }
    };
    public static final w<Number> u = new w<Number>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public Number a(com.google.b.d.a aVar) {
            if (aVar.f() != b.NULL) {
                return Float.valueOf((float) aVar.k());
            }
            aVar.j();
            return null;
        }

        public void a(c cVar, Number number) {
            cVar.a(number);
        }
    };
    public static final w<Number> v = new w<Number>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public Number a(com.google.b.d.a aVar) {
            if (aVar.f() != b.NULL) {
                return Double.valueOf(aVar.k());
            }
            aVar.j();
            return null;
        }

        public void a(c cVar, Number number) {
            cVar.a(number);
        }
    };
    public static final w<Number> w = new w<Number>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public Number a(com.google.b.d.a aVar) {
            b f = aVar.f();
            switch (f) {
                case NUMBER:
                    return new com.google.b.b.f(aVar.h());
                case NULL:
                    aVar.j();
                    return null;
                default:
                    throw new u("Expecting number, got: " + f);
            }
        }

        public void a(c cVar, Number number) {
            cVar.a(number);
        }
    };
    public static final x x = a(Number.class, w);
    public static final w<Character> y = new w<Character>() {
        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public Character a(com.google.b.d.a aVar) {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            String h = aVar.h();
            if (h.length() == 1) {
                return Character.valueOf(h.charAt(0));
            }
            throw new u("Expecting character, got: " + h);
        }

        public void a(c cVar, Character ch) {
            cVar.b(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final x z = a(Character.TYPE, Character.class, y);

    private static final class a<T extends Enum<T>> extends w<T> {
        private final Map<String, T> a = new HashMap();
        private final Map<T, String> b = new HashMap();

        public /* synthetic */ Object b(com.google.b.d.a aVar) {
            return a(aVar);
        }

        public a(Class<T> cls) {
            try {
                for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                    String name = enumR.name();
                    com.google.b.a.c cVar = (com.google.b.a.c) cls.getField(name).getAnnotation(com.google.b.a.c.class);
                    if (cVar != null) {
                        name = cVar.a();
                        for (Object put : cVar.b()) {
                            this.a.put(put, enumR);
                        }
                    }
                    String str = name;
                    this.a.put(str, enumR);
                    this.b.put(enumR, str);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        public T a(com.google.b.d.a aVar) {
            if (aVar.f() != b.NULL) {
                return (Enum) this.a.get(aVar.h());
            }
            aVar.j();
            return null;
        }

        public void a(c cVar, T t) {
            cVar.b(t == null ? null : (String) this.b.get(t));
        }
    }

    public static <TT> x a(final com.google.b.c.a<TT> aVar, final w<TT> wVar) {
        return new x() {
            public <T> w<T> a(f fVar, com.google.b.c.a<T> aVar) {
                return aVar.equals(aVar) ? wVar : null;
            }
        };
    }

    public static <TT> x a(final Class<TT> cls, final w<TT> wVar) {
        return new x() {
            public <T> w<T> a(f fVar, com.google.b.c.a<T> aVar) {
                return aVar.getRawType() == cls ? wVar : null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + wVar + "]";
            }
        };
    }

    public static <TT> x a(final Class<TT> cls, final Class<TT> cls2, final w<? super TT> wVar) {
        return new x() {
            public <T> w<T> a(f fVar, com.google.b.c.a<T> aVar) {
                Class rawType = aVar.getRawType();
                return (rawType == cls || rawType == cls2) ? wVar : null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + wVar + "]";
            }
        };
    }

    public static <TT> x b(final Class<TT> cls, final Class<? extends TT> cls2, final w<? super TT> wVar) {
        return new x() {
            public <T> w<T> a(f fVar, com.google.b.c.a<T> aVar) {
                Class rawType = aVar.getRawType();
                return (rawType == cls || rawType == cls2) ? wVar : null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + wVar + "]";
            }
        };
    }

    public static <T1> x b(final Class<T1> cls, final w<T1> wVar) {
        return new x() {
            public <T2> w<T2> a(f fVar, com.google.b.c.a<T2> aVar) {
                final Class rawType = aVar.getRawType();
                if (cls.isAssignableFrom(rawType)) {
                    return new w<T1>(this) {
                        final /* synthetic */ AnonymousClass29 b;

                        public void a(c cVar, T1 t1) {
                            wVar.a(cVar, t1);
                        }

                        public T1 b(com.google.b.d.a aVar) {
                            T1 b = wVar.b(aVar);
                            if (b == null || rawType.isInstance(b)) {
                                return b;
                            }
                            throw new u("Expected a " + rawType.getName() + " but was " + b.getClass().getName());
                        }
                    };
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + wVar + "]";
            }
        };
    }
}
