package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v4.view.t;
import android.support.v7.view.menu.q;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public abstract class ab implements OnTouchListener {
    private final float a;
    private final int b;
    private final int c;
    private final View d;
    private Runnable e;
    private Runnable f;
    private boolean g;
    private int h;
    private final int[] i = new int[2];

    private class a implements Runnable {
        final /* synthetic */ ab a;

        private a(ab abVar) {
            this.a = abVar;
        }

        public void run() {
            this.a.d.getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    private class b implements Runnable {
        final /* synthetic */ ab a;

        private b(ab abVar) {
            this.a = abVar;
        }

        public void run() {
            this.a.e();
        }
    }

    public abstract q a();

    public ab(View view) {
        this.d = view;
        this.a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.b = ViewConfiguration.getTapTimeout();
        this.c = (this.b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.g;
        if (!z2) {
            boolean z3 = a(motionEvent) && b();
            if (z3) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.d.onTouchEvent(obtain);
                obtain.recycle();
            }
            z = z3;
        } else if (b(motionEvent) || !c()) {
            z = true;
        } else {
            z = false;
        }
        this.g = z;
        if (z || z2) {
            return true;
        }
        return false;
    }

    protected boolean b() {
        q a = a();
        if (!(a == null || a.d())) {
            a.a();
        }
        return true;
    }

    protected boolean c() {
        q a = a();
        if (a != null && a.d()) {
            a.c();
        }
        return true;
    }

    private boolean a(MotionEvent motionEvent) {
        View view = this.d;
        if (!view.isEnabled()) {
            return false;
        }
        switch (t.a(motionEvent)) {
            case 0:
                this.h = motionEvent.getPointerId(0);
                if (this.e == null) {
                    this.e = new a();
                }
                view.postDelayed(this.e, (long) this.b);
                if (this.f == null) {
                    this.f = new b();
                }
                view.postDelayed(this.f, (long) this.c);
                return false;
            case 1:
            case 3:
                d();
                return false;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.h);
                if (findPointerIndex < 0 || a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.a)) {
                    return false;
                }
                d();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            default:
                return false;
        }
    }

    private void d() {
        if (this.f != null) {
            this.d.removeCallbacks(this.f);
        }
        if (this.e != null) {
            this.d.removeCallbacks(this.e);
        }
    }

    private void e() {
        d();
        View view = this.d;
        if (view.isEnabled() && !view.isLongClickable() && b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.g = true;
        }
    }

    private boolean b(MotionEvent motionEvent) {
        View view = this.d;
        q a = a();
        if (a == null || !a.d()) {
            return false;
        }
        z zVar = (z) a.e();
        if (zVar == null || !zVar.isShown()) {
            return false;
        }
        boolean z;
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        b(view, obtainNoHistory);
        a(zVar, obtainNoHistory);
        boolean a2 = zVar.a(obtainNoHistory, this.h);
        obtainNoHistory.recycle();
        int a3 = t.a(motionEvent);
        if (a3 == 1 || a3 == 3) {
            z = false;
        } else {
            z = true;
        }
        if (a2 && r0) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private static boolean a(View view, float f, float f2, float f3) {
        return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = this.i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    private boolean b(View view, MotionEvent motionEvent) {
        int[] iArr = this.i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }
}
