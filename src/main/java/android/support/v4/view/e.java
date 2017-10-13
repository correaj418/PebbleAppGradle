package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class e {
    private final a a;

    interface a {
        boolean a(MotionEvent motionEvent);
    }

    static class b implements a {
        private static final int e = ViewConfiguration.getLongPressTimeout();
        private static final int f = ViewConfiguration.getTapTimeout();
        private static final int g = ViewConfiguration.getDoubleTapTimeout();
        private int a;
        private int b;
        private int c;
        private int d;
        private final Handler h;
        private final OnGestureListener i;
        private OnDoubleTapListener j;
        private boolean k;
        private boolean l;
        private boolean m;
        private boolean n;
        private boolean o;
        private MotionEvent p;
        private MotionEvent q;
        private boolean r;
        private float s;
        private float t;
        private float u;
        private float v;
        private boolean w;
        private VelocityTracker x;

        private class a extends Handler {
            final /* synthetic */ b a;

            a(b bVar) {
                this.a = bVar;
            }

            a(b bVar, Handler handler) {
                this.a = bVar;
                super(handler.getLooper());
            }

            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        this.a.i.onShowPress(this.a.p);
                        return;
                    case 2:
                        this.a.c();
                        return;
                    case 3:
                        if (this.a.j == null) {
                            return;
                        }
                        if (this.a.k) {
                            this.a.l = true;
                            return;
                        } else {
                            this.a.j.onSingleTapConfirmed(this.a.p);
                            return;
                        }
                    default:
                        throw new RuntimeException("Unknown message " + message);
                }
            }
        }

        public b(Context context, OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.h = new a(this, handler);
            } else {
                this.h = new a(this);
            }
            this.i = onGestureListener;
            if (onGestureListener instanceof OnDoubleTapListener) {
                a((OnDoubleTapListener) onGestureListener);
            }
            a(context);
        }

        private void a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.i == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            } else {
                this.w = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.c = viewConfiguration.getScaledMinimumFlingVelocity();
                this.d = viewConfiguration.getScaledMaximumFlingVelocity();
                this.a = scaledTouchSlop * scaledTouchSlop;
                this.b = scaledDoubleTapSlop * scaledDoubleTapSlop;
            }
        }

        public void a(OnDoubleTapListener onDoubleTapListener) {
            this.j = onDoubleTapListener;
        }

        public boolean a(MotionEvent motionEvent) {
            int i;
            int action = motionEvent.getAction();
            if (this.x == null) {
                this.x = VelocityTracker.obtain();
            }
            this.x.addMovement(motionEvent);
            boolean z = (action & 255) == 6;
            int b = z ? t.b(motionEvent) : -1;
            int c = t.c(motionEvent);
            float f = 0.0f;
            float f2 = 0.0f;
            for (i = 0; i < c; i++) {
                if (b != i) {
                    f2 += t.c(motionEvent, i);
                    f += t.d(motionEvent, i);
                }
            }
            b = z ? c - 1 : c;
            f2 /= (float) b;
            f /= (float) b;
            boolean hasMessages;
            float b2;
            float a;
            switch (action & 255) {
                case 0:
                    if (this.j != null) {
                        hasMessages = this.h.hasMessages(3);
                        if (hasMessages) {
                            this.h.removeMessages(3);
                        }
                        if (this.p == null || this.q == null || !hasMessages || !a(this.p, this.q, motionEvent)) {
                            this.h.sendEmptyMessageDelayed(3, (long) g);
                        } else {
                            this.r = true;
                            b = (this.j.onDoubleTap(this.p) | 0) | this.j.onDoubleTapEvent(motionEvent);
                            this.s = f2;
                            this.u = f2;
                            this.t = f;
                            this.v = f;
                            if (this.p != null) {
                                this.p.recycle();
                            }
                            this.p = MotionEvent.obtain(motionEvent);
                            this.n = true;
                            this.o = true;
                            this.k = true;
                            this.m = false;
                            this.l = false;
                            if (this.w) {
                                this.h.removeMessages(2);
                                this.h.sendEmptyMessageAtTime(2, (this.p.getDownTime() + ((long) f)) + ((long) e));
                            }
                            this.h.sendEmptyMessageAtTime(1, this.p.getDownTime() + ((long) f));
                            return b | this.i.onDown(motionEvent);
                        }
                    }
                    b = 0;
                    this.s = f2;
                    this.u = f2;
                    this.t = f;
                    this.v = f;
                    if (this.p != null) {
                        this.p.recycle();
                    }
                    this.p = MotionEvent.obtain(motionEvent);
                    this.n = true;
                    this.o = true;
                    this.k = true;
                    this.m = false;
                    this.l = false;
                    if (this.w) {
                        this.h.removeMessages(2);
                        this.h.sendEmptyMessageAtTime(2, (this.p.getDownTime() + ((long) f)) + ((long) e));
                    }
                    this.h.sendEmptyMessageAtTime(1, this.p.getDownTime() + ((long) f));
                    return b | this.i.onDown(motionEvent);
                case 1:
                    this.k = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    if (this.r) {
                        hasMessages = this.j.onDoubleTapEvent(motionEvent) | 0;
                    } else if (this.m) {
                        this.h.removeMessages(3);
                        this.m = false;
                        hasMessages = false;
                    } else if (this.n) {
                        hasMessages = this.i.onSingleTapUp(motionEvent);
                        if (this.l && this.j != null) {
                            this.j.onSingleTapConfirmed(motionEvent);
                        }
                    } else {
                        VelocityTracker velocityTracker = this.x;
                        int b3 = t.b(motionEvent, 0);
                        velocityTracker.computeCurrentVelocity(1000, (float) this.d);
                        b2 = af.b(velocityTracker, b3);
                        a = af.a(velocityTracker, b3);
                        hasMessages = (Math.abs(b2) > ((float) this.c) || Math.abs(a) > ((float) this.c)) ? this.i.onFling(this.p, motionEvent, a, b2) : false;
                    }
                    if (this.q != null) {
                        this.q.recycle();
                    }
                    this.q = obtain;
                    if (this.x != null) {
                        this.x.recycle();
                        this.x = null;
                    }
                    this.r = false;
                    this.l = false;
                    this.h.removeMessages(1);
                    this.h.removeMessages(2);
                    return hasMessages;
                case 2:
                    if (this.m) {
                        return false;
                    }
                    a = this.s - f2;
                    b2 = this.t - f;
                    if (this.r) {
                        return false | this.j.onDoubleTapEvent(motionEvent);
                    }
                    if (this.n) {
                        i = (int) (f2 - this.u);
                        int i2 = (int) (f - this.v);
                        i = (i * i) + (i2 * i2);
                        if (i > this.a) {
                            hasMessages = this.i.onScroll(this.p, motionEvent, a, b2);
                            this.s = f2;
                            this.t = f;
                            this.n = false;
                            this.h.removeMessages(3);
                            this.h.removeMessages(1);
                            this.h.removeMessages(2);
                        } else {
                            hasMessages = false;
                        }
                        if (i > this.a) {
                            this.o = false;
                        }
                        return hasMessages;
                    } else if (Math.abs(a) < 1.0f && Math.abs(b2) < 1.0f) {
                        return false;
                    } else {
                        boolean onScroll = this.i.onScroll(this.p, motionEvent, a, b2);
                        this.s = f2;
                        this.t = f;
                        return onScroll;
                    }
                case 3:
                    a();
                    return false;
                case 5:
                    this.s = f2;
                    this.u = f2;
                    this.t = f;
                    this.v = f;
                    b();
                    return false;
                case 6:
                    this.s = f2;
                    this.u = f2;
                    this.t = f;
                    this.v = f;
                    this.x.computeCurrentVelocity(1000, (float) this.d);
                    int b4 = t.b(motionEvent);
                    b = t.b(motionEvent, b4);
                    f2 = af.a(this.x, b);
                    float b5 = af.b(this.x, b);
                    for (b = 0; b < c; b++) {
                        if (b != b4) {
                            int b6 = t.b(motionEvent, b);
                            if ((af.b(this.x, b6) * b5) + (af.a(this.x, b6) * f2) < 0.0f) {
                                this.x.clear();
                                return false;
                            }
                        }
                    }
                    return false;
                default:
                    return false;
            }
        }

        private void a() {
            this.h.removeMessages(1);
            this.h.removeMessages(2);
            this.h.removeMessages(3);
            this.x.recycle();
            this.x = null;
            this.r = false;
            this.k = false;
            this.n = false;
            this.o = false;
            this.l = false;
            if (this.m) {
                this.m = false;
            }
        }

        private void b() {
            this.h.removeMessages(1);
            this.h.removeMessages(2);
            this.h.removeMessages(3);
            this.r = false;
            this.n = false;
            this.o = false;
            this.l = false;
            if (this.m) {
                this.m = false;
            }
        }

        private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.o || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) g)) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            if ((x * x) + (y * y) < this.b) {
                return true;
            }
            return false;
        }

        private void c() {
            this.h.removeMessages(3);
            this.l = false;
            this.m = true;
            this.i.onLongPress(this.p);
        }
    }

    static class c implements a {
        private final GestureDetector a;

        public c(Context context, OnGestureListener onGestureListener, Handler handler) {
            this.a = new GestureDetector(context, onGestureListener, handler);
        }

        public boolean a(MotionEvent motionEvent) {
            return this.a.onTouchEvent(motionEvent);
        }
    }

    public e(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public e(Context context, OnGestureListener onGestureListener, Handler handler) {
        if (VERSION.SDK_INT > 17) {
            this.a = new c(context, onGestureListener, handler);
        } else {
            this.a = new b(context, onGestureListener, handler);
        }
    }

    public boolean a(MotionEvent motionEvent) {
        return this.a.a(motionEvent);
    }
}
