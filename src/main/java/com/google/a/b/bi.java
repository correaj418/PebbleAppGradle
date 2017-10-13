package com.google.a.b;

import com.google.a.b.ay.c;
import java.lang.reflect.Array;
import java.util.NavigableMap;
import java.util.SortedMap;

final class bi {
    static <T> T[] a(T[] tArr, int i) {
        return (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
    }

    static <K, V1, V2> SortedMap<K, V2> a(SortedMap<K, V1> sortedMap, c<? super K, ? super V1, V2> cVar) {
        return sortedMap instanceof NavigableMap ? ay.a((NavigableMap) sortedMap, (c) cVar) : ay.b((SortedMap) sortedMap, (c) cVar);
    }
}
