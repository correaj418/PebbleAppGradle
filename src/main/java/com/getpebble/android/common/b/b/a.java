package com.getpebble.android.common.b.b;

import com.getpebble.android.bluetooth.b.b;

public class a {
    public static boolean a(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static String a(Object obj) {
        if (obj == null) {
            return "<null>";
        }
        if (obj instanceof CharSequence) {
            return a((CharSequence) obj);
        }
        return c(obj);
    }

    private static String c(Object obj) {
        return b.d(b.b(obj.hashCode()));
    }

    private static String a(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String charSequence2 = charSequence.toString();
        return " (obfuscated): " + c(charSequence2) + " (len = " + charSequence2.length() + " / lines = " + charSequence2.split("\n").length + ")";
    }

    public static String b(Object obj) {
        if (obj == null) {
            return "undefined";
        }
        return String.valueOf(obj);
    }
}
