package com.google.android.gms.common.a;

import java.util.ArrayList;

public final class b {
    public static <T> ArrayList<T> a(T[] tArr) {
        ArrayList<T> arrayList = new ArrayList(r1);
        for (Object add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }
}
