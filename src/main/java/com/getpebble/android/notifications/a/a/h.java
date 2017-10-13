package com.getpebble.android.notifications.a.a;

import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.an;
import com.getpebble.android.common.model.an.a;
import com.getpebble.android.common.model.c;
import com.getpebble.android.notifications.a.b;

public class h {
    public static boolean a(b bVar) {
        switch (bVar.e()) {
            case SMS:
            case JSKIT:
            case DEMO:
                return false;
            default:
                a findDupNotification = an.findDupNotification(bVar, c.b(com.getpebble.android.common.a.K().getContentResolver(), bVar.g()), com.getpebble.android.common.a.K().getContentResolver());
                if (findDupNotification != null) {
                    f.d("NotificationDedupUtil", bVar.a() + " is a dup of " + findDupNotification.notificationUuid);
                }
                return findDupNotification != null;
        }
    }

    public static f b(b bVar) {
        i a = b.a(bVar).a(bVar);
        return new f(a, a(an.findPreviousNotification(bVar.g(), null, null, com.getpebble.android.common.a.K().getContentResolver(), false, bVar), a));
    }

    public static String a(a aVar, i iVar) {
        if (aVar != null) {
            return a(iVar.c(), aVar.text);
        }
        return iVar.c();
    }

    static String a(String str, String str2) {
        f.e("NotificationDedupUtil", "extractNewText new = '" + com.getpebble.android.common.b.b.a.a((Object) str) + "' previous = '" + com.getpebble.android.common.b.b.a.a((Object) str2) + "'");
        if (str == null) {
            return null;
        }
        String stringBuilder;
        if (str2 != null) {
            String[] split = str2.split("\n");
            String[] split2 = str.split("\n");
            if (str2.equals(str)) {
                return str;
            }
            int i;
            int i2 = 0;
            for (String str3 : split) {
                if (i2 < split2.length && str3.equals(split2[i2])) {
                    i2++;
                }
            }
            int length = split2.length - 1;
            if (i2 == 0) {
                i = length;
                while (i >= 0) {
                    int length2 = (split.length - split2.length) + i;
                    if (length2 >= split.length || length2 < 0 || !split[length2].equals(split2[i])) {
                        break;
                    }
                    i--;
                    length--;
                }
            }
            i = length;
            if (i2 > 0 || i < split2.length - 1) {
                StringBuilder stringBuilder2 = new StringBuilder();
                int i3 = i2;
                Object obj = 1;
                for (length = i3; length <= i; length++) {
                    if (obj == null) {
                        stringBuilder2.append("\n");
                    } else {
                        obj = null;
                    }
                    stringBuilder2.append(split2[length]);
                }
                if (stringBuilder2.length() > 0) {
                    stringBuilder = stringBuilder2.toString();
                    if (!str.equals(stringBuilder)) {
                        f.d("NotificationDedupUtil", "extractNewText(): Replacing '" + com.getpebble.android.common.b.b.a.a((Object) str) + "' with '" + com.getpebble.android.common.b.b.a.a((Object) stringBuilder) + "'");
                    }
                    return stringBuilder;
                }
            }
        }
        stringBuilder = str;
        if (str.equals(stringBuilder)) {
            f.d("NotificationDedupUtil", "extractNewText(): Replacing '" + com.getpebble.android.common.b.b.a.a((Object) str) + "' with '" + com.getpebble.android.common.b.b.a.a((Object) stringBuilder) + "'");
        }
        return stringBuilder;
    }
}
