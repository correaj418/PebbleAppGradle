package com.google.a.a;

import javax.annotation.CheckReturnValue;

@CheckReturnValue
public final class a {
    public static String a(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (a(str.charAt(i))) {
                char[] toCharArray = str.toCharArray();
                while (i < length) {
                    char c = toCharArray[i];
                    if (a(c)) {
                        toCharArray[i] = (char) (c ^ 32);
                    }
                    i++;
                }
                return String.valueOf(toCharArray);
            }
            i++;
        }
        return str;
    }

    public static boolean a(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
