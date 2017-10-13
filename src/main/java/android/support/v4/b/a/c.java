package android.support.v4.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class c {
    public static void a(Drawable drawable, int i) {
        if (drawable instanceof o) {
            ((o) drawable).setTint(i);
        }
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof o) {
            ((o) drawable).setTintList(colorStateList);
        }
    }

    public static void a(Drawable drawable, Mode mode) {
        if (drawable instanceof o) {
            ((o) drawable).setTintMode(mode);
        }
    }

    public static Drawable a(Drawable drawable) {
        if (drawable instanceof o) {
            return drawable;
        }
        return new j(drawable);
    }

    public static void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet);
    }
}
