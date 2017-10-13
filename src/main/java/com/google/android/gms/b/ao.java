package com.google.android.gms.b;

public abstract class ao<T> {
    private static final Object c = new Object();
    private static a d = null;
    private static int e = 0;
    private static String f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    protected final String a;
    protected final T b;
    private T g = null;

    class AnonymousClass1 extends ao<Long> {
        AnonymousClass1(String str, Long l) {
            super(str, l);
        }

        protected /* synthetic */ Object a(String str) {
            return b(str);
        }

        protected Long b(String str) {
            return null.a(this.a, (Long) this.b);
        }
    }

    class AnonymousClass2 extends ao<Integer> {
        AnonymousClass2(String str, Integer num) {
            super(str, num);
        }

        protected /* synthetic */ Object a(String str) {
            return b(str);
        }

        protected Integer b(String str) {
            return null.a(this.a, (Integer) this.b);
        }
    }

    class AnonymousClass3 extends ao<String> {
        AnonymousClass3(String str, String str2) {
            super(str, str2);
        }

        protected /* synthetic */ Object a(String str) {
            return b(str);
        }

        protected String b(String str) {
            return null.a(this.a, (String) this.b);
        }
    }

    private interface a {
        Integer a(String str, Integer num);

        Long a(String str, Long l);

        String a(String str, String str2);
    }

    protected ao(String str, T t) {
        this.a = str;
        this.b = t;
    }

    public static ao<Integer> a(String str, Integer num) {
        return new AnonymousClass2(str, num);
    }

    public static ao<Long> a(String str, Long l) {
        return new AnonymousClass1(str, l);
    }

    public static ao<String> a(String str, String str2) {
        return new AnonymousClass3(str, str2);
    }

    public final T a() {
        return a(this.a);
    }

    protected abstract T a(String str);
}
