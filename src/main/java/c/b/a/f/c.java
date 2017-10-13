package c.b.a.f;

import c.b.a.e;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class c implements e {
    private HashMap<Locale, Map<String, Map<String, Object>>> a = a();
    private HashMap<Locale, Map<String, Map<Boolean, Object>>> b = a();

    public String a(Locale locale, String str, String str2) {
        String[] c = c(locale, str, str2);
        return c == null ? null : c[0];
    }

    public String b(Locale locale, String str, String str2) {
        String[] c = c(locale, str, str2);
        return c == null ? null : c[1];
    }

    private synchronized String[] c(Locale locale, String str, String str2) {
        String[] strArr;
        Object[] objArr = null;
        synchronized (this) {
            if (locale == null || str == null || str2 == null) {
                strArr = null;
            } else {
                Map map;
                Map map2 = (Map) this.a.get(locale);
                if (map2 == null) {
                    HashMap hashMap = this.a;
                    HashMap a = a();
                    hashMap.put(locale, a);
                    map = a;
                } else {
                    map = map2;
                }
                map2 = (Map) map.get(str);
                if (map2 == null) {
                    Object[] objArr2;
                    map2 = a();
                    map.put(str, map2);
                    for (Object[] objArr3 : e.a(Locale.ENGLISH).getZoneStrings()) {
                        if (objArr3 != null && objArr3.length >= 5 && str.equals(objArr3[0])) {
                            objArr2 = objArr3;
                            break;
                        }
                    }
                    objArr2 = null;
                    for (Object[] objArr4 : e.a(locale).getZoneStrings()) {
                        if (objArr4 != null && objArr4.length >= 5 && str.equals(objArr4[0])) {
                            objArr = objArr4;
                            break;
                        }
                    }
                    if (!(objArr2 == null || objArr == null)) {
                        map2.put(objArr2[2], new String[]{objArr[2], objArr[1]});
                        if (objArr2[2].equals(objArr2[4])) {
                            map2.put(objArr2[4] + "-Summer", new String[]{objArr[4], objArr[3]});
                        } else {
                            map2.put(objArr2[4], new String[]{objArr[4], objArr[3]});
                        }
                    }
                }
                strArr = (String[]) map2.get(str2);
            }
        }
        return strArr;
    }

    public String a(Locale locale, String str, String str2, boolean z) {
        String[] c = c(locale, str, str2, z);
        return c == null ? null : c[0];
    }

    public String b(Locale locale, String str, String str2, boolean z) {
        String[] c = c(locale, str, str2, z);
        return c == null ? null : c[1];
    }

    private synchronized String[] c(Locale locale, String str, String str2, boolean z) {
        String[] strArr;
        Object[] objArr = null;
        synchronized (this) {
            if (locale == null || str == null || str2 == null) {
                strArr = null;
            } else {
                Map map;
                if (str.startsWith("Etc/")) {
                    str = str.substring(4);
                }
                Map map2 = (Map) this.b.get(locale);
                if (map2 == null) {
                    HashMap hashMap = this.b;
                    HashMap a = a();
                    hashMap.put(locale, a);
                    map = a;
                } else {
                    map = map2;
                }
                map2 = (Map) map.get(str);
                if (map2 == null) {
                    Object[] objArr2;
                    map2 = a();
                    map.put(str, map2);
                    for (Object[] objArr3 : e.a(Locale.ENGLISH).getZoneStrings()) {
                        if (objArr3 != null && objArr3.length >= 5 && str.equals(objArr3[0])) {
                            objArr2 = objArr3;
                            break;
                        }
                    }
                    objArr2 = null;
                    for (Object[] objArr4 : e.a(locale).getZoneStrings()) {
                        if (objArr4 != null && objArr4.length >= 5 && str.equals(objArr4[0])) {
                            objArr = objArr4;
                            break;
                        }
                    }
                    if (!(objArr2 == null || objArr == null)) {
                        map2.put(Boolean.TRUE, new String[]{objArr[2], objArr[1]});
                        map2.put(Boolean.FALSE, new String[]{objArr[4], objArr[3]});
                    }
                }
                strArr = (String[]) map2.get(Boolean.valueOf(z));
            }
        }
        return strArr;
    }

    private HashMap a() {
        return new HashMap(7);
    }
}
