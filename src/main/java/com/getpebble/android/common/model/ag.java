package com.getpebble.android.common.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.getpebble.android.common.b.a.f;

public class ag {
    public final String a;
    public final int b;

    public ag(Context context) {
        int i;
        Throwable e;
        String str = "unknown";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            str = packageInfo.versionName;
            i = packageInfo.versionCode;
        } catch (NameNotFoundException e2) {
            e = e2;
            f.a("PebbleAppVersion", "Error getting Pebble app version!", e);
            i = -1;
            this.a = str;
            this.b = i;
        } catch (RuntimeException e3) {
            e = e3;
            f.a("PebbleAppVersion", "Error getting Pebble app version!", e);
            i = -1;
            this.a = str;
            this.b = i;
        }
        this.a = str;
        this.b = i;
    }
}
