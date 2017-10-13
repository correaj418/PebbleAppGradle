package android.support.v4.b.a;

import android.graphics.drawable.Drawable;

class d {
    public static Drawable a(Drawable drawable) {
        if (drawable instanceof o) {
            return drawable;
        }
        return new k(drawable);
    }
}
