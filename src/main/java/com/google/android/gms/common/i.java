package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.a.g;
import com.google.android.gms.common.internal.t;

public class i {
    private static final i a = new i();
    public static final int b = k.b;

    i() {
    }

    public static i b() {
        return a;
    }

    private String b(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(b);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context != null) {
            try {
                stringBuilder.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        return stringBuilder.toString();
    }

    public int a(Context context) {
        int a = k.a(context);
        return k.c(context, a) ? 18 : a;
    }

    public PendingIntent a(Context context, int i, int i2) {
        return a(context, i, i2, null);
    }

    public PendingIntent a(Context context, int i, int i2, String str) {
        if (g.a(context) && i == 2) {
            i = 42;
        }
        Intent a = a(context, i, str);
        return a == null ? null : PendingIntent.getActivity(context, i2, a, 268435456);
    }

    public Intent a(Context context, int i, String str) {
        switch (i) {
            case 1:
            case 2:
                return t.a("com.google.android.gms", b(context, str));
            case 3:
                return t.a("com.google.android.gms");
            case 42:
                return t.a();
            default:
                return null;
        }
    }

    public boolean a(int i) {
        return k.b(i);
    }

    public boolean a(Context context, int i) {
        return k.c(context, i);
    }

    public boolean a(Context context, String str) {
        return k.a(context, str);
    }

    @Deprecated
    public Intent b(int i) {
        return a(null, i, null);
    }

    public void b(Context context) {
        k.b(context);
    }

    public void c(Context context) {
        k.e(context);
    }
}
