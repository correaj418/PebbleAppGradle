package android.support.v4.b.a;

import android.graphics.drawable.Drawable;

class e {
    public static void a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static Drawable b(Drawable drawable) {
        if (drawable instanceof o) {
            return drawable;
        }
        return new l(drawable);
    }
}
