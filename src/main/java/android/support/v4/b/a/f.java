package android.support.v4.b.a;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

class f {
    private static Method a;
    private static boolean b;

    public static int a(Drawable drawable) {
        if (!b) {
            try {
                a = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", e);
            }
            b = true;
        }
        if (a != null) {
            try {
                return ((Integer) a.invoke(drawable, new Object[0])).intValue();
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", e2);
                a = null;
            }
        }
        return -1;
    }
}
