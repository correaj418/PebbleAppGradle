package android.support.v4.b.a;

import android.graphics.drawable.Drawable;

class g {
    public static void a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static boolean a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable b(Drawable drawable) {
        if (drawable instanceof o) {
            return drawable;
        }
        return new m(drawable);
    }

    public static int c(Drawable drawable) {
        return drawable.getAlpha();
    }
}
