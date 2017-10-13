package com.google.android.gms.b;

import com.google.android.gms.common.a.j;

public class cb {
    private static final ThreadLocal<String> a = new ThreadLocal();

    public static String a(String str) {
        return a() ? str : a(str, (String) a.get());
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return str;
        }
        Object obj = new byte[(str.length() + str2.length())];
        System.arraycopy(str.getBytes(), 0, obj, 0, str.length());
        System.arraycopy(str2.getBytes(), 0, obj, str.length(), str2.length());
        return Integer.toHexString(j.a(obj, 0, obj.length, 0));
    }

    public static boolean a() {
        String str = (String) a.get();
        return str == null || str.startsWith("com.google");
    }
}
