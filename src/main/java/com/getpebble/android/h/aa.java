package com.getpebble.android.h;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Locale;

public class aa {
    public static String a(String str) {
        return TextUtils.isEmpty(str) ? str : str.substring(0, 1).toUpperCase(Locale.getDefault()) + str.substring(1);
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        return str.matches(".*\\<[^>]+>.*") ? Html.fromHtml(str).toString() : str;
    }

    public static String[] a(Collection<String> collection) {
        return (String[]) collection.toArray(new String[collection.size()]);
    }

    public static String a(Bundle bundle, String str, String str2) {
        CharSequence charSequence = bundle.getCharSequence(str);
        return charSequence == null ? str2 : charSequence.toString();
    }
}
