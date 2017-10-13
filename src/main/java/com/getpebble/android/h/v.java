package com.getpebble.android.h;

import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.au;
import com.google.a.b.am;
import java.util.Set;

public class v {

    public enum a {
        CALENDAR("android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"),
        CONTACTS("android.permission.READ_CONTACTS"),
        LOCATION("android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"),
        SMS("android.permission.RECEIVE_SMS"),
        STORAGE("android.permission.WRITE_EXTERNAL_STORAGE"),
        TELEPHONE("android.permission.READ_PHONE_STATE", "android.permission.READ_CALL_LOG"),
        GCM("com.google.android.c2dm.permission.RECEIVE");
        
        final Set<String> names;

        private a(String... strArr) {
            this.names = strArr == null ? am.h() : am.a((Object[]) strArr);
        }
    }

    public static boolean a(a aVar) {
        for (String a : aVar.names) {
            if (android.support.v4.content.a.a(com.getpebble.android.common.a.K(), a) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void a(String str, a aVar, String str2) {
        f.a(str, "Permission denied! Method = " + str2 + " permission = " + aVar);
        au.a(com.getpebble.android.common.model.au.a.PERMISSION_DENIED, com.getpebble.android.common.a.K().getContentResolver());
    }
}
