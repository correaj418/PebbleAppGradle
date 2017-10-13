package android.support.v4.content.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public final class d {
    public static Drawable a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            return e.a(resources, i, theme);
        }
        return resources.getDrawable(i);
    }
}
