package com.getpebble.android.common.d;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {
    private int a;
    private int b;
    private int c;

    private a(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public static a d() {
        int i = 0;
        CharSequence charSequence = "4.4.1-1404-01abd2f76-endframe";
        a aVar = new a(2, 0, 0);
        if (charSequence == null || charSequence.length() < 1) {
            return aVar;
        }
        int parseInt;
        int parseInt2;
        if (charSequence.charAt(0) == 'v') {
            charSequence = charSequence.substring(1);
        }
        Matcher matcher = Pattern.compile("(\\d*)\\.(\\d*)\\.(\\d*)").matcher(charSequence);
        if (matcher.find() && matcher.groupCount() == 3) {
            parseInt = Integer.parseInt(matcher.group(1));
            i = Integer.parseInt(matcher.group(2));
            parseInt2 = Integer.parseInt(matcher.group(3));
        } else {
            parseInt2 = 0;
            parseInt = 2;
        }
        return new a(parseInt, i, parseInt2);
    }
}
