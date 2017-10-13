package com.getpebble.android.font;

import android.content.Context;
import android.graphics.Typeface;
import java.lang.ref.WeakReference;

public class a {
    public static final Integer a = Integer.valueOf(a.REGULAR.ordinal());
    private static WeakReference<Typeface> b = null;
    private static WeakReference<Typeface> c = null;
    private static WeakReference<Typeface> d = null;

    public enum a {
        BOLD,
        LIGHT,
        REGULAR
    }

    public static Typeface a(Context context, Integer num) {
        try {
            switch (a.values()[num.intValue()]) {
                case BOLD:
                    return b(context);
                case LIGHT:
                    return c(context);
                case REGULAR:
                    return a(context);
                default:
                    return Typeface.DEFAULT;
            }
        } catch (Exception e) {
            return Typeface.DEFAULT;
        }
        return Typeface.DEFAULT;
    }

    public static Typeface a(Context context) {
        if (b == null || b.get() == null) {
            b = new WeakReference(Typeface.createFromAsset(context.getAssets(), "fonts/PFDinDisplayPro_Reg.ttf"));
        }
        return (Typeface) b.get();
    }

    public static Typeface b(Context context) {
        if (c == null || c.get() == null) {
            c = new WeakReference(Typeface.createFromAsset(context.getAssets(), "fonts/PFDinDisplayPro_Bold.ttf"));
        }
        return (Typeface) c.get();
    }

    public static Typeface c(Context context) {
        if (d == null || d.get() == null) {
            d = new WeakReference(Typeface.createFromAsset(context.getAssets(), "fonts/PFDinDisplayPro_Light.ttf"));
        }
        return (Typeface) d.get();
    }
}
