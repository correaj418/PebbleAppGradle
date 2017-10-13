package android.support.v4.content.a;

import android.content.res.Resources;
import android.util.DisplayMetrics;

class b {
    static int a(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
    }

    static int b(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) (((float) displayMetrics.widthPixels) / displayMetrics.density);
    }

    static int c(Resources resources) {
        return Math.min(b(resources), a(resources));
    }
}
