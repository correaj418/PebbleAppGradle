package com.getpebble.android.h;

import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.ak.a;
import java.util.Locale;
import java.util.MissingResourceException;

public class q {
    public static String a(a aVar) {
        if (aVar == null) {
            return "";
        }
        if (aVar.isoLocale == null) {
            return "";
        }
        f.d("LocaleUtil", "Language tag: " + aVar.isoLocale);
        try {
            Locale a = a(aVar.isoLocale);
            if (a(a)) {
                return a.getDisplayLanguage(a);
            }
            f.d("LocaleUtil", "Locale does not have known language name");
            return "";
        } catch (IllegalArgumentException e) {
            f.d("LocaleUtil", "Failed to parse locale " + aVar.isoLocale);
            return "";
        }
    }

    public static Locale a(String str) {
        String[] split = str.split("_");
        switch (split.length) {
            case 1:
                return new Locale(split[0]);
            case 2:
                return new Locale(split[0], split[1]);
            case 3:
                return new Locale(split[0], split[1], split[2]);
            default:
                throw new IllegalArgumentException("Invalid locale: " + str);
        }
    }

    static boolean a(Locale locale) {
        try {
            return (locale.getISO3Language() == null || locale.getISO3Country() == null) ? false : true;
        } catch (MissingResourceException e) {
            return false;
        }
    }

    public static String a() {
        Locale b = b();
        f.d("LocaleUtil", "Retrieved current locale: " + b);
        return u.from(b).getLocale();
    }

    public static Locale b() {
        return com.getpebble.android.common.a.K().getResources().getConfiguration().locale;
    }

    public static com.getpebble.android.common.model.timeline.weatherchannel.a.a c() {
        String country = b().getCountry();
        Object obj = -1;
        switch (country.hashCode()) {
            case 2718:
                if (country.equals("US")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return com.getpebble.android.common.model.timeline.weatherchannel.a.a.IMPERIAL;
            default:
                return com.getpebble.android.common.model.timeline.weatherchannel.a.a.METRIC;
        }
    }
}
