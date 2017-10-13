package android.support.v7.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.ah;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;

public class bd {
    private static Method a;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                a = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});
                if (!a.isAccessible()) {
                    a.setAccessible(true);
                }
            } catch (NoSuchMethodException e) {
                Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }

    public static boolean a(View view) {
        return ah.h(view) == 1;
    }

    public static int a(int i, int i2) {
        return i | i2;
    }

    public static void a(View view, Rect rect, Rect rect2) {
        if (a != null) {
            try {
                a.invoke(view, new Object[]{rect, rect2});
            } catch (Throwable e) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
            }
        }
    }
}
