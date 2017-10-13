package android.support.v4.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class f implements c {
    private TimeInterpolator a;

    static class a implements AnimatorListener {
        final b a;
        final g b;

        public a(b bVar, g gVar) {
            this.a = bVar;
            this.b = gVar;
        }

        public void onAnimationStart(Animator animator) {
            this.a.a(this.b);
        }

        public void onAnimationEnd(Animator animator) {
            this.a.b(this.b);
        }

        public void onAnimationCancel(Animator animator) {
            this.a.c(this.b);
        }

        public void onAnimationRepeat(Animator animator) {
            this.a.d(this.b);
        }
    }

    static class b implements g {
        final Animator a;

        public b(Animator animator) {
            this.a = animator;
        }

        public void a(View view) {
            this.a.setTarget(view);
        }

        public void a(b bVar) {
            this.a.addListener(new a(bVar, this));
        }

        public void a(long j) {
            this.a.setDuration(j);
        }

        public void a() {
            this.a.start();
        }

        public void b() {
            this.a.cancel();
        }

        public void a(final d dVar) {
            if (this.a instanceof ValueAnimator) {
                ((ValueAnimator) this.a).addUpdateListener(new AnimatorUpdateListener(this) {
                    final /* synthetic */ b b;

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        dVar.a(this.b);
                    }
                });
            }
        }

        public float c() {
            return ((ValueAnimator) this.a).getAnimatedFraction();
        }
    }

    f() {
    }

    public g a() {
        return new b(ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}));
    }

    public void a(View view) {
        if (this.a == null) {
            this.a = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.a);
    }
}
