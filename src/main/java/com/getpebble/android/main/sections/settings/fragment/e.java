package com.getpebble.android.main.sections.settings.fragment;

import android.os.Bundle;

public class e {
    public static Bundle a(String str, String str2, String str3, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("extra_install_language_url", str);
        bundle.putString("extra_install_language_name", str2);
        bundle.putString("extra_install_language_locale", str3);
        bundle.putInt("extra_install_language_version", i);
        bundle.putBoolean("extra_install_successful", true);
        return bundle;
    }

    public static Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("extra_install_successful", false);
        return bundle;
    }
}
