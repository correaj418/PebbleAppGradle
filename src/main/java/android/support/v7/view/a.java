package android.support.v7.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ar;
import android.support.v7.b.a.b;
import android.support.v7.b.a.d;
import android.support.v7.b.a.k;
import android.view.ViewConfiguration;

public class a {
    private Context a;

    public static a a(Context context) {
        return new a(context);
    }

    private a(Context context) {
        this.a = context;
    }

    public int a() {
        Resources resources = this.a.getResources();
        int b = android.support.v4.content.a.a.b(resources);
        int a = android.support.v4.content.a.a.a(resources);
        if (android.support.v4.content.a.a.c(resources) > 600 || b > 600 || ((b > 960 && a > 720) || (b > 720 && a > 960))) {
            return 5;
        }
        if (b >= 500 || ((b > 640 && a > 480) || (b > 480 && a > 640))) {
            return 4;
        }
        if (b >= 360) {
            return 3;
        }
        return 2;
    }

    public boolean b() {
        if (VERSION.SDK_INT < 19 && ar.b(ViewConfiguration.get(this.a))) {
            return false;
        }
        return true;
    }

    public int c() {
        return this.a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean d() {
        return this.a.getResources().getBoolean(b.abc_action_bar_embed_tabs);
    }

    public int e() {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(null, k.ActionBar, android.support.v7.b.a.a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(k.ActionBar_height, 0);
        Resources resources = this.a.getResources();
        if (!d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public int f() {
        return this.a.getResources().getDimensionPixelSize(d.abc_action_bar_stacked_tab_max_width);
    }
}
