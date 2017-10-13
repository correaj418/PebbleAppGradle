package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

class n {
    private static Method a;
    private static boolean b;

    static void a(PopupWindow popupWindow, int i) {
        if (!b) {
            try {
                a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                a.setAccessible(true);
            } catch (Exception e) {
            }
            b = true;
        }
        if (a != null) {
            try {
                a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
            }
        }
    }
}
