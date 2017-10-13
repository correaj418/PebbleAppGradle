package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class ay {
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
