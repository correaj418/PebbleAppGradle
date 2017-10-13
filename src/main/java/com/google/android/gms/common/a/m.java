package com.google.android.gms.common.a;

import com.google.android.gms.common.internal.k;
import java.util.regex.Pattern;

public class m {
    private static final Pattern a = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean a(String str) {
        return str == null || k.a.b((CharSequence) str);
    }
}
