package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public final class af {
    static final c a;

    interface c {
        float a(VelocityTracker velocityTracker, int i);

        float b(VelocityTracker velocityTracker, int i);
    }

    static class a implements c {
        a() {
        }

        public float a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity();
        }

        public float b(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity();
        }
    }

    static class b implements c {
        b() {
        }

        public float a(VelocityTracker velocityTracker, int i) {
            return ag.a(velocityTracker, i);
        }

        public float b(VelocityTracker velocityTracker, int i) {
            return ag.b(velocityTracker, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            a = new b();
        } else {
            a = new a();
        }
    }

    public static float a(VelocityTracker velocityTracker, int i) {
        return a.a(velocityTracker, i);
    }

    public static float b(VelocityTracker velocityTracker, int i) {
        return a.b(velocityTracker, i);
    }
}
