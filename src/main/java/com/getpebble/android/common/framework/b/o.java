package com.getpebble.android.common.framework.b;

import android.content.Context;
import android.content.res.Configuration;

public class o {
    public static boolean a(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration == null || configuration.fontScale == 1.0f) {
            return false;
        }
        return true;
    }
}
