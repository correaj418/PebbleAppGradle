package com.getpebble.android.d;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class d {
    final String a;

    public d(String str) {
        this.a = str;
    }

    public b a() {
        String str;
        String[] a = a(this.a);
        Map hashMap = new HashMap();
        int i = 0;
        for (String trim : a) {
            String trim2 = trim2.trim();
            if (i != 0) {
                str = trim2;
                break;
            }
            if (trim2.equals("")) {
                i = 1;
            } else {
                String[] split = trim2.split(":");
                if (split.length != 2) {
                    throw new IllegalArgumentException("Invalid header: <" + trim2 + ">");
                }
                hashMap.put(split[0], split[1]);
            }
        }
        str = null;
        return new b(hashMap, str);
    }

    String[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Cannot trim empty input");
        }
        Object trim = str.trim();
        while (!TextUtils.isEmpty(trim) && !trim.startsWith("-")) {
            try {
                trim = trim.substring(1);
            } catch (Throwable e) {
                throw new IllegalArgumentException(e);
            }
        }
        if (TextUtils.isEmpty(trim)) {
            throw new IllegalArgumentException("Cannot parseFirstPart, failed to trim boundary");
        }
        String[] split = trim.split("\n");
        if (split.length >= 2) {
            return (String[]) Arrays.copyOfRange(split, 1, split.length);
        }
        throw new IllegalArgumentException("Illegal input; number of newlines: " + split.length);
    }
}
