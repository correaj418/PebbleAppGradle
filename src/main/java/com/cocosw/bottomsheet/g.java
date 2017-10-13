package com.cocosw.bottomsheet;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Method;

@TargetApi(19)
class g {
    boolean a;
    int b;
    private final Dialog c;
    private boolean d;
    private String e;
    private float f;

    g(Dialog dialog, Context context) {
        this.c = dialog;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.d = context.getResources().getConfiguration().orientation == 1;
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            this.e = (String) declaredMethod.invoke(null, new Object[]{"qemu.hw.mainkeys"});
        } catch (Throwable th) {
            this.e = null;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{16843760});
        try {
            this.a = obtainStyledAttributes.getBoolean(0, false);
            if ((((Activity) context).getWindow().getAttributes().flags & 134217728) != 0) {
                this.a = true;
            }
            this.f = a(windowManager);
            if (this.a) {
                a(true);
            }
            this.b = a(context.getResources(), "status_bar_height");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void a(boolean z) {
        Window window = this.c.getWindow();
        LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= 67108864;
        } else {
            attributes.flags &= -67108865;
        }
        window.setAttributes(attributes);
        window.setFlags(134217728, 134217728);
    }

    private float a(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (VERSION.SDK_INT >= 16) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return Math.min(((float) displayMetrics.widthPixels) / displayMetrics.density, ((float) displayMetrics.heightPixels) / displayMetrics.density);
    }

    int a(Context context) {
        Resources resources = context.getResources();
        if (VERSION.SDK_INT < 14 || !b(context)) {
            return 0;
        }
        String str;
        if (this.d) {
            str = "navigation_bar_height";
        } else if (!a()) {
            return 0;
        } else {
            str = "navigation_bar_height_landscape";
        }
        return a(resources, str);
    }

    private boolean b(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            boolean z2 = resources.getBoolean(identifier);
            if ("1".equals(this.e)) {
                return false;
            }
            if ("0".equals(this.e)) {
                return true;
            }
            return z2;
        }
        if (ViewConfiguration.get(context).hasPermanentMenuKey()) {
            z = false;
        }
        return z;
    }

    private int a(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private boolean a() {
        return this.f >= 600.0f || this.d;
    }
}
