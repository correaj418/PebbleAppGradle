package com.getpebble.android.h;

import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.getpebble.android.framework.o.c;
import java.util.Comparator;

public class w implements Comparator<String> {
    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((String) obj, (String) obj2);
    }

    public int a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        if (PhoneNumberUtils.compare(str, str2)) {
            return 0;
        }
        if (c.a(str).equalsIgnoreCase(c.a(str2))) {
            return 0;
        }
        return -1;
    }
}
