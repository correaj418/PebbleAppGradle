package com.getpebble.android.framework.p;

import android.text.TextUtils;
import com.getpebble.android.d.d;
import com.getpebble.android.h.p;
import com.google.b.a.c;
import java.util.Arrays;

public class k {
    @c(a = "Prompt")
    String a;
    @c(a = "Cause")
    int b;
    @c(a = "words")
    public final a[][] c;

    public static class a {
        @c(a = "confidence")
        public String a;
        @c(a = "word")
        public String b;

        boolean a() {
            if (TextUtils.isEmpty(this.b)) {
                return false;
            }
            int indexOf = this.b.indexOf(92);
            if (indexOf < 0) {
                return false;
            }
            this.b = this.b.substring(0, indexOf);
            return true;
        }
    }

    void a() {
        for (a[] aVarArr : this.c) {
            int i = 0;
            while (i < aVarArr.length) {
                a aVar = aVarArr[i];
                if (aVar.a()) {
                    if ((i == 0 ? 1 : null) == null) {
                        aVar.b = '\b' + aVar.b;
                    }
                }
                i++;
            }
        }
    }

    public static k a(String str) {
        return (k) p.a(str, k.class);
    }

    public static k b(String str) {
        k a = a(new d(str).a().a());
        if (a == null) {
            throw new IllegalArgumentException("Unable to parse response (null)");
        }
        if (!a.d()) {
            if (a.c == null) {
                throw new IllegalArgumentException("Unable to parse response");
            }
            a.a();
        }
        return a;
    }

    public String toString() {
        if (this.c == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Object[] arrays : this.c) {
            stringBuilder.append(com.getpebble.android.common.b.b.a.a(Arrays.toString(arrays)));
        }
        return stringBuilder.toString();
    }

    public String b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public boolean d() {
        return this.b > 0;
    }
}
