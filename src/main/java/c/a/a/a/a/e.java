package c.a.a.a.a;

import c.a.a.a.d;
import java.util.ArrayList;
import java.util.List;

public class e {
    private static final f a = a(a(a(), a("CVS")));
    private static final f b = a(a(a(), a(".svn")));

    public static f a(String str) {
        return new g(str);
    }

    public static f a(String str, d dVar) {
        return new g(str, dVar);
    }

    public static f a() {
        return c.a;
    }

    public static f a(f... fVarArr) {
        return new b(c(fVarArr));
    }

    public static f b(f... fVarArr) {
        return new i(c(fVarArr));
    }

    public static List<f> c(f... fVarArr) {
        if (fVarArr == null) {
            throw new IllegalArgumentException("The filters must not be null");
        }
        List<f> arrayList = new ArrayList(fVarArr.length);
        for (int i = 0; i < fVarArr.length; i++) {
            if (fVarArr[i] == null) {
                throw new IllegalArgumentException("The filter[" + i + "] is null");
            }
            arrayList.add(fVarArr[i]);
        }
        return arrayList;
    }

    public static f a(f fVar) {
        return new h(fVar);
    }
}
