package com.getpebble.android.common.model.timeline.weatherchannel;

import android.location.Location;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.h.u;
import java.util.Map;

public class a {
    private static Map<String, String> a = new com.google.a.b.af.a().a("ar_AE", "ar-AE").a("bn_BD", "bn-BD").a("bn_IN", "bn-IN").a("bn", "bn-IN").a("ca_ES", "ca-ES").a("ca", "ca-ES").a("cs_CZ", "cs-CZ").a("cs", "cs-CZ").a("da_DK", "da-DK").a("da", "da-DK").a("de_DE", "de-DE").a("de", "de-DE").a("el_GR", "el-GR").a("el", "el-GR").a("en_GB", "en-GB").a("en_IN", "en-IN").a("en_US", "en-US").a("en", "en-US").a("es_AR", "es-AR").a("es_ES", "es-ES").a("es_US", "es-US").a("es_LA", "es-LA").a("es_MX", "es-MX").a("es_UN", "es-UN").a(u.SPANISH_LANGUAGE_CODE, "es-ES").a("fa_IR", "fa-IR").a("fa", "fa-IR").a("fi_FI", "fi-FI").a("fi", "fi-FI").a("fr_CA", "fr-CA").a("fr_FR", "fr-FR").a("fr", "fr-FR").a("he_IL", "he-IL").a("he", "he-IL").a("hi_IN", "hi-IN").a("hi", "hi-IN").a("hr_HR", "hr-HR").a("hr", "hr-HR").a("hu_HU", "hu-HU").a("hu", "hu-HU").a("in_ID", "in-ID").a("in", "in-ID").a("it_IT", "it-IT").a("it_CH", "it-CH").a(u.ITALIAN_LANGUAGE_CODE, "it-IT").a("iw_IL", "iw-IL").a("iw", "iw-IL").a("ja_JP", "ja-JP").a("ja", "ja-JP").a("kk_KZ", "kk-KZ").a("kk", "kk-KZ").a("ko_KR", "ko-KR").a("ko", "ko-KR").a("ms_MY", "ms-MY").a("ms", "ms-MY").a("nl_NL", "nl-NL").a(u.DUTCH_LANGUAGE_CODE, "nl-NL").a("no_NO", "no-NO").a("no", "no-NO").a("nn_NO", "nn-NO").a("nn", "nn-NO").a("pl_PL", "pl-PL").a("pl", "pl-PL").a("pt_BR", "pt-BR").a("pt_PT", "pt-PT").a(u.PORTUGUESE_LANGUAGE_CODE, "pt-BR").a("ro_RO", "ro-RO").a("ro", "ro-RO").a("ru_RU", "ru-RU").a("ru", "ru-RU").a("sk_SK", "sk-SK").a("sk", "sk-SK").a("sv_SE", "sv-SE").a("sv", "sv-SE").a("th_TH", "th-TH").a("th", "th-TH").a("tl_PH", "tl-PH").a("tl", "tl-PH").a("tr_TR", "tr-TR").a("tr", "tr-TR").a("uk_UA", "uk-UA").a("uk", "uk-UA").a("ur_PK", "ur-PK").a("ur", "ur-PK").a("vi_VN", "vi-VN").a("vi", "vi-VN").a("zh_CN", "zh-CN").a("zh_HK", "zh-HK").a("zh_TW", "zh-TW").a("zh", "zh-CN").a();

    public enum a {
        IMPERIAL("e"),
        METRIC("m"),
        METRIC_SI("s"),
        HYBRID("h");
        
        public final String unitsTypeName;

        private a(String str) {
            this.unitsTypeName = str;
        }

        public static a from(String str) {
            for (a aVar : values()) {
                if (aVar.unitsTypeName.equals(str)) {
                    return aVar;
                }
            }
            return null;
        }

        public static int convertTemp(int i, a aVar, a aVar2) {
            Object obj = null;
            if (aVar == null || aVar2 == null) {
                throw new IllegalArgumentException("Null units!");
            }
            Object obj2 = (aVar == METRIC || aVar == HYBRID) ? 1 : null;
            if (aVar2 == METRIC || aVar2 == HYBRID) {
                obj = 1;
            }
            if (aVar == aVar2) {
                return i;
            }
            if (obj2 != null && r1 != null) {
                return i;
            }
            if (obj2 == null || aVar2 != IMPERIAL) {
                return (int) Math.round(((double) (i - 32)) / 1.8d);
            }
            return (int) Math.round((((double) i) * 1.8d) + 32.0d);
        }
    }

    static String a(String str) {
        String b = b(str);
        if (a.containsKey(b)) {
            return (String) a.get(b);
        }
        return "en-US";
    }

    private static String b(String str) {
        String[] split = str.split("_");
        switch (split.length) {
            case 1:
                return split[0];
            case 2:
                return str;
            case 3:
                return str.contains("__") ? split[0].trim() : split[0] + "_" + split[1];
            default:
                return "en";
        }
    }

    public static String a(Location location, a aVar, String str) {
        if (PebbleApplication.w().B()) {
            String A = PebbleApplication.w().A();
            if (A == null) {
                f.c("WeatherChannelDefinitions", "getUrl: baseUrl is null!");
                return null;
            }
            return A.replace("$$longitude$$", Double.toString(location.getLongitude())).replace("$$latitude$$", Double.toString(location.getLatitude())).replace("$$language$$", a(str)).replace("$$units$$", aVar.unitsTypeName);
        }
        f.c("WeatherChannelDefinitions", "getUrl: No weather key in boot!");
        return null;
    }
}
