package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;

class ai {
    private static Field a;
    private static boolean b;
    private static Field c;
    private static boolean d;

    static ColorStateList a(View view) {
        return view instanceof ae ? ((ae) view).getSupportBackgroundTintList() : null;
    }

    static void a(View view, ColorStateList colorStateList) {
        if (view instanceof ae) {
            ((ae) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    static Mode b(View view) {
        return view instanceof ae ? ((ae) view).getSupportBackgroundTintMode() : null;
    }

    static void a(View view, Mode mode) {
        if (view instanceof ae) {
            ((ae) view).setSupportBackgroundTintMode(mode);
        }
    }

    static int c(View view) {
        if (!b) {
            try {
                a = View.class.getDeclaredField("mMinWidth");
                a.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            b = true;
        }
        if (a != null) {
            try {
                return ((Integer) a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static int d(View view) {
        if (!d) {
            try {
                c = View.class.getDeclaredField("mMinHeight");
                c.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            d = true;
        }
        if (c != null) {
            try {
                return ((Integer) c.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static boolean e(View view) {
        return view.getWindowToken() != null;
    }

    static void a(View view, int i) {
        int top = view.getTop();
        view.offsetTopAndBottom(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(view.getLeft(), top - abs, view.getRight(), (top + view.getHeight()) + abs);
                return;
            }
            view.invalidate();
        }
    }

    static void b(View view, int i) {
        int left = view.getLeft();
        view.offsetLeftAndRight(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(left - abs, view.getTop(), (left + view.getWidth()) + abs, view.getBottom());
                return;
            }
            view.invalidate();
        }
    }
}
