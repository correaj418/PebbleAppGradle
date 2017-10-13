package com.getpebble.android.main.sections.appstore.a;

import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.getpebble.android.PebbleApplication;

public final class a {

    public enum a {
        WATCH_FACES,
        WATCH_APPS,
        APPLICATION,
        DEVELOPER_APPS,
        UNSUPPORTED
    }

    public static String a(a aVar, String str) {
        String str2 = null;
        switch (aVar) {
            case WATCH_APPS:
                str2 = PebbleApplication.w().d();
                break;
            case WATCH_FACES:
                str2 = PebbleApplication.w().e();
                break;
            case APPLICATION:
                str2 = PebbleApplication.w().g();
                break;
            case DEVELOPER_APPS:
                str2 = PebbleApplication.w().i();
                break;
        }
        if (TextUtils.isEmpty(str2)) {
            return str2;
        }
        str2 = b(str2);
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return a(str2, "id", str);
    }

    public static String b(a aVar, String str) {
        String j = PebbleApplication.w().j();
        if (TextUtils.isEmpty(j)) {
            return j;
        }
        j = b(j);
        if (a.WATCH_FACES.equals(aVar)) {
            j = a(j, "search_type", "watchfaces");
        } else {
            j = a(j, "search_type", "watchapps");
        }
        return a(j, "query", str);
    }

    public static String a(String str) {
        String h = PebbleApplication.w().h();
        if (TextUtils.isEmpty(h)) {
            return h;
        }
        return a(h, "id", str);
    }

    private static String b(String str) {
        com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
        String string = Secure.getString(com.getpebble.android.common.a.K().getContentResolver(), "android_id");
        String b = PebbleApplication.u().b(PebbleApplication.u().g());
        if (p != null) {
            str = a(a(a(str, "pebble_id", p.serialNumber), "pebble_color", String.valueOf(p.color.getIntValue())), "hardware", p.hwPlatform.getPlatformCode().getCode());
        }
        return a(a(str, "phone_id", string), "user_id", b);
    }

    private static String a(String str, String str2, String str3) {
        CharSequence format = String.format("$$%s$$", new Object[]{str2});
        if (str3 == null) {
            str3 = "";
        }
        if (TextUtils.isEmpty(str) || !str.contains(format)) {
            return str;
        }
        return str.replace(format, str3);
    }
}
