package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class ax {
    public static void a(View view, long j) {
        view.animate().setDuration(j);
    }

    public static void a(View view, float f) {
        view.animate().alpha(f);
    }

    public static void b(View view, float f) {
        view.animate().translationX(f);
    }

    public static void c(View view, float f) {
        view.animate().translationY(f);
    }

    public static void a(View view) {
        view.animate().cancel();
    }

    public static void b(View view) {
        view.animate().start();
    }

    public static void a(final View view, final az azVar) {
        if (azVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    azVar.c(view);
                }

                public void onAnimationEnd(Animator animator) {
                    azVar.b(view);
                }

                public void onAnimationStart(Animator animator) {
                    azVar.a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }
}
