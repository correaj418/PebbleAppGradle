package com.google.a.a;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
public final class k {
    public static boolean a(@Nullable String str) {
        return str == null || str.length() == 0;
    }
}
