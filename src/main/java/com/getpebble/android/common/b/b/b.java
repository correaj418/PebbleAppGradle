package com.getpebble.android.common.b.b;

import android.net.Uri;
import android.net.Uri.Builder;

public class b {
    public static Uri a(String str) {
        return new Builder().scheme("content").authority("com.getpebble.android.basalt.internal.provider").path(str).build();
    }
}
