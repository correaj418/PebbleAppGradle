package c.b.a.e;

import c.b.a.b;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class a {
    private static final ConcurrentHashMap<String, b> a = new ConcurrentHashMap();
    private static final AtomicReferenceArray<b> b = new AtomicReferenceArray(25);

    public static b a(String str) {
        return c(str);
    }

    private static void a(c cVar, String str) {
        int length = str.length();
        int[] iArr = new int[1];
        int i = 0;
        while (i < length) {
            iArr[0] = i;
            String a = a(str, iArr);
            int i2 = iArr[0];
            int length2 = a.length();
            if (length2 != 0) {
                char charAt = a.charAt(0);
                switch (charAt) {
                    case '\'':
                        a = a.substring(1);
                        if (a.length() != 1) {
                            cVar.a(new String(a));
                            break;
                        } else {
                            cVar.a(a.charAt(0));
                            break;
                        }
                    case 'C':
                        cVar.g(length2, length2);
                        break;
                    case 'D':
                        cVar.i(length2);
                        break;
                    case 'E':
                        if (length2 < 4) {
                            cVar.e();
                            break;
                        } else {
                            cVar.d();
                            break;
                        }
                    case 'G':
                        cVar.h();
                        break;
                    case 'H':
                        cVar.c(length2);
                        break;
                    case 'K':
                        cVar.e(length2);
                        break;
                    case 'M':
                        if (length2 >= 3) {
                            if (length2 < 4) {
                                cVar.g();
                                break;
                            } else {
                                cVar.f();
                                break;
                            }
                        }
                        cVar.k(length2);
                        break;
                    case 'S':
                        cVar.a(length2, length2);
                        break;
                    case 'Y':
                    case 'x':
                    case 'y':
                        if (length2 != 2) {
                            i = 9;
                            if (i2 + 1 < length) {
                                iArr[0] = iArr[0] + 1;
                                if (b(a(str, iArr))) {
                                    i = length2;
                                }
                                iArr[0] = iArr[0] - 1;
                            }
                            switch (charAt) {
                                case 'Y':
                                    cVar.f(length2, i);
                                    break;
                                case 'x':
                                    cVar.d(length2, i);
                                    break;
                                case 'y':
                                    cVar.e(length2, i);
                                    break;
                                default:
                                    break;
                            }
                        }
                        boolean z = true;
                        if (i2 + 1 < length) {
                            iArr[0] = iArr[0] + 1;
                            if (b(a(str, iArr))) {
                                z = false;
                            }
                            iArr[0] = iArr[0] - 1;
                        }
                        switch (charAt) {
                            case 'x':
                                cVar.b(new b().g() - 30, z);
                                break;
                            default:
                                cVar.a(new b().f() - 30, z);
                                break;
                        }
                    case 'Z':
                        if (length2 != 1) {
                            if (length2 != 2) {
                                cVar.j();
                                break;
                            }
                            cVar.a(null, "Z", true, 2, 2);
                            break;
                        }
                        cVar.a(null, "Z", false, 2, 2);
                        break;
                    case 'a':
                        cVar.c();
                        break;
                    case 'd':
                        cVar.h(length2);
                        break;
                    case 'e':
                        cVar.g(length2);
                        break;
                    case 'h':
                        cVar.f(length2);
                        break;
                    case 'k':
                        cVar.d(length2);
                        break;
                    case 'm':
                        cVar.b(length2);
                        break;
                    case 's':
                        cVar.a(length2);
                        break;
                    case 'w':
                        cVar.j(length2);
                        break;
                    case 'z':
                        if (length2 < 4) {
                            cVar.a(null);
                            break;
                        } else {
                            cVar.i();
                            break;
                        }
                    default:
                        throw new IllegalArgumentException("Illegal pattern component: " + a);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private static String a(String str, int[] iArr) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i);
        if ((charAt < 'A' || charAt > 'Z') && (charAt < 'a' || charAt > 'z')) {
            stringBuilder.append('\'');
            int i2 = 0;
            while (i < length) {
                char charAt2 = str.charAt(i);
                if (charAt2 != '\'') {
                    if (i2 == 0 && ((charAt2 >= 'A' && charAt2 <= 'Z') || (charAt2 >= 'a' && charAt2 <= 'z'))) {
                        i--;
                        break;
                    }
                    stringBuilder.append(charAt2);
                } else if (i + 1 >= length || str.charAt(i + 1) != '\'') {
                    i2 = i2 == 0 ? 1 : 0;
                } else {
                    i++;
                    stringBuilder.append(charAt2);
                }
                i++;
            }
        } else {
            stringBuilder.append(charAt);
            while (i + 1 < length && str.charAt(i + 1) == charAt) {
                stringBuilder.append(charAt);
                i++;
            }
        }
        iArr[0] = i;
        return stringBuilder.toString();
    }

    private static boolean b(String str) {
        int length = str.length();
        if (length > 0) {
            switch (str.charAt(0)) {
                case 'C':
                case 'D':
                case 'F':
                case 'H':
                case 'K':
                case 'S':
                case 'W':
                case 'Y':
                case 'c':
                case 'd':
                case 'e':
                case 'h':
                case 'k':
                case 'm':
                case 's':
                case 'w':
                case 'x':
                case 'y':
                    return true;
                case 'M':
                    if (length <= 2) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    private static b c(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Invalid pattern specification");
        }
        b bVar = (b) a.get(str);
        if (bVar != null) {
            return bVar;
        }
        c cVar = new c();
        a(cVar, str);
        b a = cVar.a();
        if (a.size() < 500) {
            bVar = (b) a.putIfAbsent(str, a);
            if (bVar != null) {
                return bVar;
            }
        }
        return a;
    }
}
