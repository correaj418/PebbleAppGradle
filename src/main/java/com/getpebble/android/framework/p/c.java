package com.getpebble.android.framework.p;

import com.getpebble.android.PebbleApplication;
import com.getpebble.android.config.JsonConfigHolder.Voice.Language;

public abstract class c {
    protected String a(String str) {
        for (Language language : PebbleApplication.w().P()) {
            if (str.equals(language.sixCharLocale)) {
                return language.endpoint;
            }
        }
        return null;
    }
}
