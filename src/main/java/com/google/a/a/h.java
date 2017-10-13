package com.google.a.a;

import com.getpebble.android.framework.timeline.e;
import javax.annotation.Nullable;

public final class h {
    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void a(boolean z, @Nullable Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void a(boolean z, @Nullable String str, @Nullable Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(a(str, objArr));
        }
    }

    public static void b(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void b(boolean z, @Nullable Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void b(boolean z, @Nullable String str, @Nullable Object... objArr) {
        if (!z) {
            throw new IllegalStateException(a(str, objArr));
        }
    }

    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static <T> T a(T t, @Nullable Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T a(T t, @Nullable String str, @Nullable Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, objArr));
    }

    public static int a(int i, int i2) {
        return a(i, i2, "index");
    }

    public static int a(int i, int i2, @Nullable String str) {
        if (i >= 0 && i < i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(c(i, i2, str));
    }

    private static String c(int i, int i2, String str) {
        if (i < 0) {
            return a("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        } else {
            return a("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public static int b(int i, int i2) {
        return b(i, i2, "index");
    }

    public static int b(int i, int i2, @Nullable String str) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(d(i, i2, str));
    }

    private static String d(int i, int i2, String str) {
        if (i < 0) {
            return a("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        } else {
            return a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public static void a(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(b(i, i2, i3));
        }
    }

    private static String b(int i, int i2, int i3) {
        if (i < 0 || i > i3) {
            return d(i, i3, "start index");
        }
        if (i2 < 0 || i2 > i3) {
            return d(i2, i3, "end index");
        }
        return a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }

    static String a(String str, @Nullable Object... objArr) {
        int i = 0;
        String valueOf = String.valueOf(str);
        StringBuilder stringBuilder = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i2 = 0;
        while (i < objArr.length) {
            int indexOf = valueOf.indexOf("%s", i2);
            if (indexOf == -1) {
                break;
            }
            stringBuilder.append(valueOf.substring(i2, indexOf));
            i2 = i + 1;
            stringBuilder.append(objArr[i]);
            int i3 = i2;
            i2 = indexOf + 2;
            i = i3;
        }
        stringBuilder.append(valueOf.substring(i2));
        if (i < objArr.length) {
            stringBuilder.append(" [");
            i2 = i + 1;
            stringBuilder.append(objArr[i]);
            i = i2;
            while (i < objArr.length) {
                stringBuilder.append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
                i2 = i + 1;
                stringBuilder.append(objArr[i]);
                i = i2;
            }
            stringBuilder.append(']');
        }
        return stringBuilder.toString();
    }
}
