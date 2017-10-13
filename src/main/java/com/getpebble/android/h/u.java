package com.getpebble.android.h;

import android.text.TextUtils;
import java.util.Locale;

public enum u {
    GERMAN("de_DE"),
    FRENCH("fr_FR"),
    ENGLISH("en_US"),
    SPANISH("es_ES"),
    DUTCH("nl_NL"),
    PORTUGUESE("pt_PT"),
    ITALIEN("it_IT"),
    CHINESE_SIMPLIFIED("zh_CN"),
    CHINESE_TRADITIONAL("zh_TW");
    
    public static final u CHINESE_FALLBACK = null;
    private static final String CHINESE_SIMPLIFIED_LOCALIZED_NAME = "中文 (简体)";
    private static final String CHINESE_TRADITIONAL_LOCALIZED_NAME = "中文 (繁體)";
    public static final u DEFAULT_FALLBACK = null;
    public static final String DUTCH_LANGUAGE_CODE = "nl";
    public static final String HAN_SIMPLIFIED_CODE = "hans";
    public static final String HAN_TRADITIONAL_CODE = "hant";
    public static final String HK_COUNTRY_CODE = "hk";
    public static final String ITALIAN_LANGUAGE_CODE = "it";
    public static final String PORTUGUESE_LANGUAGE_CODE = "pt";
    public static final String SPANISH_LANGUAGE_CODE = "es";
    private final String locale;

    static {
        CHINESE_FALLBACK = CHINESE_SIMPLIFIED;
        DEFAULT_FALLBACK = ENGLISH;
    }

    private u(String str) {
        this.locale = str;
    }

    public static u from(Locale locale) {
        if (locale == null) {
            return DEFAULT_FALLBACK;
        }
        String language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return DEFAULT_FALLBACK;
        }
        if (language.equalsIgnoreCase(Locale.ENGLISH.getLanguage())) {
            return ENGLISH;
        }
        if (language.equalsIgnoreCase(Locale.FRENCH.getLanguage())) {
            return FRENCH;
        }
        if (language.equalsIgnoreCase(Locale.GERMAN.getLanguage())) {
            return GERMAN;
        }
        if (language.equalsIgnoreCase(PORTUGUESE_LANGUAGE_CODE)) {
            return PORTUGUESE;
        }
        if (language.equalsIgnoreCase(ITALIAN_LANGUAGE_CODE)) {
            return ITALIEN;
        }
        if (language.equalsIgnoreCase(SPANISH_LANGUAGE_CODE)) {
            return SPANISH;
        }
        if (language.equalsIgnoreCase(DUTCH_LANGUAGE_CODE)) {
            return DUTCH;
        }
        if (!language.equalsIgnoreCase(Locale.CHINESE.getLanguage())) {
            return DEFAULT_FALLBACK;
        }
        language = locale.getCountry();
        if (language == null) {
            return CHINESE_FALLBACK;
        }
        if (language.equalsIgnoreCase(Locale.TRADITIONAL_CHINESE.getCountry())) {
            return CHINESE_TRADITIONAL;
        }
        if (language.equalsIgnoreCase(Locale.SIMPLIFIED_CHINESE.getCountry())) {
            return CHINESE_SIMPLIFIED;
        }
        if (language.equalsIgnoreCase(HK_COUNTRY_CODE)) {
            return CHINESE_TRADITIONAL;
        }
        if (language.toLowerCase(Locale.getDefault()).contains(HAN_SIMPLIFIED_CODE)) {
            return CHINESE_SIMPLIFIED;
        }
        if (language.toLowerCase(Locale.getDefault()).contains(HAN_TRADITIONAL_CODE)) {
            return CHINESE_TRADITIONAL;
        }
        return CHINESE_FALLBACK;
    }

    public String getLocale() {
        return this.locale;
    }

    public String getLocalizedDisplayName() {
        switch (this) {
            case CHINESE_SIMPLIFIED:
                return CHINESE_SIMPLIFIED_LOCALIZED_NAME;
            case CHINESE_TRADITIONAL:
                return CHINESE_TRADITIONAL_LOCALIZED_NAME;
            default:
                Locale a = q.a(this.locale);
                return a.getDisplayName(a);
        }
    }
}
