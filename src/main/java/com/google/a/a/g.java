package com.google.a.a;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public final class g {
    @CheckReturnValue
    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    @CheckReturnValue
    public static int a(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
