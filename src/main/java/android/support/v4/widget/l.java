package android.support.v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

class l {
    private static Field a;

    static {
        try {
            a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            a.setAccessible(true);
        } catch (Throwable e) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
        }
    }

    static void a(PopupWindow popupWindow, boolean z) {
        if (a != null) {
            try {
                a.set(popupWindow, Boolean.valueOf(z));
            } catch (Throwable e) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
            }
        }
    }
}
