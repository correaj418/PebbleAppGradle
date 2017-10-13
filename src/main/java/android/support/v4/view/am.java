package android.support.v4.view;

import android.view.View;

class am {
    public static boolean a(View view) {
        return view.hasTransientState();
    }

    public static void b(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static int c(View view) {
        return view.getImportantForAccessibility();
    }

    public static void a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static int d(View view) {
        return view.getMinimumWidth();
    }

    public static int e(View view) {
        return view.getMinimumHeight();
    }

    public static void f(View view) {
        view.requestFitSystemWindows();
    }

    public static boolean g(View view) {
        return view.hasOverlappingRendering();
    }
}
