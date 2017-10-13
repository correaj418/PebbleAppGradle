package com.google.android.gms.common.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class e {
    public static <T> Set<T> a() {
        return Collections.emptySet();
    }

    public static <T> Set<T> a(T t) {
        return Collections.singleton(t);
    }

    public static <T> Set<T> a(T t, T t2) {
        Set aVar = new a(2);
        aVar.add(t);
        aVar.add(t2);
        return Collections.unmodifiableSet(aVar);
    }

    public static <T> Set<T> a(T t, T t2, T t3) {
        Set aVar = new a(3);
        aVar.add(t);
        aVar.add(t2);
        aVar.add(t3);
        return Collections.unmodifiableSet(aVar);
    }

    public static <T> Set<T> a(T t, T t2, T t3, T t4) {
        Set aVar = new a(4);
        aVar.add(t);
        aVar.add(t2);
        aVar.add(t3);
        aVar.add(t4);
        return Collections.unmodifiableSet(aVar);
    }

    public static <T> Set<T> a(T... tArr) {
        switch (tArr.length) {
            case 0:
                return a();
            case 1:
                return a(tArr[0]);
            case 2:
                return a(tArr[0], tArr[1]);
            case 3:
                return a(tArr[0], tArr[1], tArr[2]);
            case 4:
                return a(tArr[0], tArr[1], tArr[2], tArr[3]);
            default:
                return Collections.unmodifiableSet(tArr.length <= 32 ? new a(Arrays.asList(tArr)) : new HashSet(Arrays.asList(tArr)));
        }
    }
}
