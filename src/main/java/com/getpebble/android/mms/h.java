package com.getpebble.android.mms;

import com.getpebble.android.common.b.a.f;
import com.getpebble.android.mms.b.c;
import java.util.List;

public class h implements c {
    public a a(List<Mms> list) {
        a aVar = new a();
        for (Mms mms : list) {
            if (!mms.a() && b(mms.j)) {
                f.c("MmsValidator", "mms with id: " + mms.a + " lacks a message or media. INVALID");
                aVar.b(mms);
            } else if (b(mms.k)) {
                f.c("MmsValidator", "mms with id: " + mms.a + " lacks an address. INCOMPLETE");
                aVar.c(mms);
            } else {
                f.c("MmsValidator", "mms with id: " + mms.a + " is VALID.");
                aVar.a(mms);
            }
        }
        return aVar;
    }

    private static <T> boolean b(List<T> list) {
        return list == null || list.size() == 0;
    }
}
