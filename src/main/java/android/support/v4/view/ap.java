package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewParent;
import android.view.WindowInsets;

class ap {
    private static ThreadLocal<Rect> a;

    public static void a(View view) {
        view.requestApplyInsets();
    }

    public static void a(View view, float f) {
        view.setElevation(f);
    }

    public static float b(View view) {
        return view.getElevation();
    }

    public static void a(View view, final ab abVar) {
        if (abVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return ((bc) abVar.a(view, new bc(windowInsets))).f();
                }
            });
        }
    }

    static ColorStateList c(View view) {
        return view.getBackgroundTintList();
    }

    static void a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    static Mode d(View view) {
        return view.getBackgroundTintMode();
    }

    static void a(View view, Mode mode) {
        view.setBackgroundTintMode(mode);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    public static bb a(View view, bb bbVar) {
        if (!(bbVar instanceof bc)) {
            return bbVar;
        }
        WindowInsets f = ((bc) bbVar).f();
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(f);
        if (onApplyWindowInsets != f) {
            return new bc(onApplyWindowInsets);
        }
        return bbVar;
    }

    public static bb b(View view, bb bbVar) {
        if (!(bbVar instanceof bc)) {
            return bbVar;
        }
        WindowInsets f = ((bc) bbVar).f();
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(f);
        if (dispatchApplyWindowInsets != f) {
            return new bc(dispatchApplyWindowInsets);
        }
        return bbVar;
    }

    public static void e(View view) {
        view.stopNestedScroll();
    }

    static void a(View view, int i) {
        Object obj;
        Rect a = a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        ak.a(view, i);
        if (obj != null && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }

    static void b(View view, int i) {
        Object obj;
        Rect a = a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        ak.b(view, i);
        if (obj != null && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }

    private static Rect a() {
        if (a == null) {
            a = new ThreadLocal();
        }
        Rect rect = (Rect) a.get();
        if (rect == null) {
            rect = new Rect();
            a.set(rect);
        }
        rect.setEmpty();
        return rect;
    }
}
