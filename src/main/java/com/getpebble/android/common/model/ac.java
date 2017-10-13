package com.getpebble.android.common.model;

import android.content.ContentValues;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.h.p;
import com.google.b.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ac {
    @c(a = "languages")
    public aa[] a;

    public static ac a(String str) {
        return (ac) p.a(str, ac.class);
    }

    public List<ContentValues> a() {
        if (this.a == null) {
            return Collections.EMPTY_LIST;
        }
        List<ContentValues> arrayList = new ArrayList(this.a.length);
        for (aa aaVar : this.a) {
            if (aaVar.i()) {
                arrayList.add(aaVar.j());
            } else {
                f.b("LanguagePackResponse", "Invalid language pack");
            }
        }
        return arrayList;
    }
}
