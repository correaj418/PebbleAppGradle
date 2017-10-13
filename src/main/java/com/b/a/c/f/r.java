package com.b.a.c.f;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class r {
    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }
}
