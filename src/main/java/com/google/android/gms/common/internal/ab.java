package com.google.android.gms.common.internal;

import com.getpebble.android.framework.timeline.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ab {

    public static final class a {
        private final List<String> a;
        private final Object b;

        private a(Object obj) {
            this.b = b.a(obj);
            this.a = new ArrayList();
        }

        public a a(String str, Object obj) {
            List list = this.a;
            String str2 = (String) b.a((Object) str);
            String valueOf = String.valueOf(String.valueOf(obj));
            list.add(new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(valueOf).length()).append(str2).append("=").append(valueOf).toString());
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.b.getClass().getSimpleName()).append('{');
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.a.get(i));
                if (i < size - 1) {
                    append.append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
                }
            }
            return append.append('}').toString();
        }
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a a(Object obj) {
        return new a(obj);
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
