package com.google.android.gms.b;

import java.util.List;

public class at {
    public static <T> boolean a(List<T> list, List<T> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (T contains : list) {
            if (!list2.contains(contains)) {
                return false;
            }
        }
        return true;
    }
}
