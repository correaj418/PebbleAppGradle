package android.support.v7.widget.a;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.af;
import android.support.v4.view.ah;
import android.support.v4.view.e;
import android.support.v4.view.t;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.j;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.u;
import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public class a extends g implements j {
    private final k A = new k(this) {
        final /* synthetic */ a a;

        {
            this.a = r1;
        }

        public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
            this.a.z.a(motionEvent);
            int a = t.a(motionEvent);
            if (a == 0) {
                this.a.k = t.b(motionEvent, 0);
                this.a.c = motionEvent.getX();
                this.a.d = motionEvent.getY();
                this.a.f();
                if (this.a.b == null) {
                    c a2 = this.a.c(motionEvent);
                    if (a2 != null) {
                        a aVar = this.a;
                        aVar.c -= a2.k;
                        aVar = this.a;
                        aVar.d -= a2.l;
                        this.a.a(a2.h, true);
                        if (this.a.a.remove(a2.h.a)) {
                            this.a.l.c(this.a.r, a2.h);
                        }
                        this.a.a(a2.h, a2.i);
                        this.a.a(motionEvent, this.a.n, 0);
                    }
                }
            } else if (a == 3 || a == 1) {
                this.a.k = -1;
                this.a.a(null, 0);
            } else if (this.a.k != -1) {
                int a3 = t.a(motionEvent, this.a.k);
                if (a3 >= 0) {
                    this.a.a(a, motionEvent, a3);
                }
            }
            if (this.a.t != null) {
                this.a.t.addMovement(motionEvent);
            }
            if (this.a.b != null) {
                return true;
            }
            return false;
        }

        public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
            int i = 0;
            this.a.z.a(motionEvent);
            if (this.a.t != null) {
                this.a.t.addMovement(motionEvent);
            }
            if (this.a.k != -1) {
                int a = t.a(motionEvent);
                int a2 = t.a(motionEvent, this.a.k);
                if (a2 >= 0) {
                    this.a.a(a, motionEvent, a2);
                }
                u uVar = this.a.b;
                if (uVar != null) {
                    switch (a) {
                        case 1:
                            break;
                        case 2:
                            if (a2 >= 0) {
                                this.a.a(motionEvent, this.a.n, a2);
                                this.a.c(uVar);
                                this.a.r.removeCallbacks(this.a.s);
                                this.a.s.run();
                                this.a.r.invalidate();
                                return;
                            }
                            return;
                        case 3:
                            if (this.a.t != null) {
                                this.a.t.clear();
                                break;
                            }
                            break;
                        case 6:
                            a = t.b(motionEvent);
                            if (t.b(motionEvent, a) == this.a.k) {
                                if (a == 0) {
                                    i = 1;
                                }
                                this.a.k = t.b(motionEvent, i);
                                this.a.a(motionEvent, this.a.n, a);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                    this.a.a(null, 0);
                    this.a.k = -1;
                }
            }
        }

        public void a(boolean z) {
            if (z) {
                this.a.a(null, 0);
            }
        }
    };
    private Rect B;
    private long C;
    final List<View> a = new ArrayList();
    u b = null;
    float c;
    float d;
    float e;
    float f;
    float g;
    float h;
    float i;
    float j;
    int k = -1;
    a l;
    int m = 0;
    int n;
    List<c> o = new ArrayList();
    private final float[] p = new float[2];
    private int q;
    private RecyclerView r;
    private final Runnable s = new Runnable(this) {
        final /* synthetic */ a a;

        {
            this.a = r1;
        }

        public void run() {
            if (this.a.b != null && this.a.e()) {
                if (this.a.b != null) {
                    this.a.c(this.a.b);
                }
                this.a.r.removeCallbacks(this.a.s);
                ah.a(this.a.r, (Runnable) this);
            }
        }
    };
    private VelocityTracker t;
    private List<u> u;
    private List<Integer> v;
    private android.support.v7.widget.RecyclerView.d w = null;
    private View x = null;
    private int y = -1;
    private e z;

    public interface d {
        void a(View view, View view2, int i, int i2);
    }

    private class c implements android.support.v4.a.b {
        private final android.support.v4.a.g a;
        private final int b;
        private boolean c = false;
        final float d;
        final float e;
        final float f;
        final float g;
        final u h;
        final int i;
        public boolean j;
        float k;
        float l;
        boolean m = false;
        final /* synthetic */ a n;
        private float o;

        public c(final a aVar, u uVar, int i, int i2, float f, float f2, float f3, float f4) {
            this.n = aVar;
            this.i = i2;
            this.b = i;
            this.h = uVar;
            this.d = f;
            this.e = f2;
            this.f = f3;
            this.g = f4;
            this.a = android.support.v4.a.a.a();
            this.a.a(new android.support.v4.a.d(this) {
                final /* synthetic */ c b;

                public void a(android.support.v4.a.g gVar) {
                    this.b.a(gVar.c());
                }
            });
            this.a.a(uVar.a);
            this.a.a((android.support.v4.a.b) this);
            a(0.0f);
        }

        public void a(long j) {
            this.a.a(j);
        }

        public void a() {
            this.h.a(false);
            this.a.a();
        }

        public void b() {
            this.a.b();
        }

        public void a(float f) {
            this.o = f;
        }

        public void c() {
            if (this.d == this.f) {
                this.k = ah.k(this.h.a);
            } else {
                this.k = this.d + (this.o * (this.f - this.d));
            }
            if (this.e == this.g) {
                this.l = ah.l(this.h.a);
            } else {
                this.l = this.e + (this.o * (this.g - this.e));
            }
        }

        public void a(android.support.v4.a.g gVar) {
        }

        public void b(android.support.v4.a.g gVar) {
            if (!this.c) {
                this.h.a(true);
            }
            this.c = true;
        }

        public void c(android.support.v4.a.g gVar) {
            a(1.0f);
        }

        public void d(android.support.v4.a.g gVar) {
        }
    }

    public static abstract class a {
        private static final b a;
        private static final Interpolator b = new Interpolator() {
            public float getInterpolation(float f) {
                return (((f * f) * f) * f) * f;
            }
        };
        private static final Interpolator c = new Interpolator() {
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
            }
        };
        private int d = -1;

        public abstract int a(RecyclerView recyclerView, u uVar);

        public abstract void a(u uVar, int i);

        public abstract boolean b(RecyclerView recyclerView, u uVar, u uVar2);

        static {
            if (VERSION.SDK_INT >= 21) {
                a = new c();
            } else if (VERSION.SDK_INT >= 11) {
                a = new b();
            } else {
                a = new a();
            }
        }

        public static int a(int i, int i2) {
            int i3 = i & 789516;
            if (i3 == 0) {
                return i;
            }
            int i4 = (i3 ^ -1) & i;
            if (i2 == 0) {
                return i4 | (i3 << 2);
            }
            return (i4 | ((i3 << 1) & -789517)) | (((i3 << 1) & 789516) << 2);
        }

        public static int b(int i, int i2) {
            return (c(0, i2 | i) | c(1, i2)) | c(2, i);
        }

        public static int c(int i, int i2) {
            return i2 << (i * 8);
        }

        public int d(int i, int i2) {
            int i3 = i & 3158064;
            if (i3 == 0) {
                return i;
            }
            int i4 = (i3 ^ -1) & i;
            if (i2 == 0) {
                return i4 | (i3 >> 2);
            }
            return (i4 | ((i3 >> 1) & -3158065)) | (((i3 >> 1) & 3158064) >> 2);
        }

        final int b(RecyclerView recyclerView, u uVar) {
            return d(a(recyclerView, uVar), ah.h(recyclerView));
        }

        private boolean d(RecyclerView recyclerView, u uVar) {
            return (b(recyclerView, uVar) & 16711680) != 0;
        }

        public boolean a(RecyclerView recyclerView, u uVar, u uVar2) {
            return true;
        }

        public boolean a() {
            return true;
        }

        public boolean b() {
            return true;
        }

        public int c() {
            return 0;
        }

        public float a(u uVar) {
            return 0.5f;
        }

        public float b(u uVar) {
            return 0.5f;
        }

        public float a(float f) {
            return f;
        }

        public float b(float f) {
            return f;
        }

        public u a(u uVar, List<u> list, int i, int i2) {
            int width = i + uVar.a.getWidth();
            int height = i2 + uVar.a.getHeight();
            u uVar2 = null;
            int i3 = -1;
            int left = i - uVar.a.getLeft();
            int top = i2 - uVar.a.getTop();
            int size = list.size();
            int i4 = 0;
            while (i4 < size) {
                int i5;
                u uVar3;
                int i6;
                u uVar4;
                int i7;
                u uVar5 = (u) list.get(i4);
                if (left > 0) {
                    int right = uVar5.a.getRight() - width;
                    if (right < 0 && uVar5.a.getRight() > uVar.a.getRight()) {
                        right = Math.abs(right);
                        if (right > i3) {
                            i5 = right;
                            uVar3 = uVar5;
                            if (left < 0) {
                                i3 = uVar5.a.getLeft() - i;
                                if (i3 > 0 && uVar5.a.getLeft() < uVar.a.getLeft()) {
                                    i3 = Math.abs(i3);
                                    if (i3 > i5) {
                                        uVar3 = uVar5;
                                        if (top < 0) {
                                            i5 = uVar5.a.getTop() - i2;
                                            if (i5 > 0 && uVar5.a.getTop() < uVar.a.getTop()) {
                                                i5 = Math.abs(i5);
                                                if (i5 > i3) {
                                                    uVar3 = uVar5;
                                                    if (top > 0) {
                                                        i3 = uVar5.a.getBottom() - height;
                                                        if (i3 < 0 && uVar5.a.getBottom() > uVar.a.getBottom()) {
                                                            i3 = Math.abs(i3);
                                                            if (i3 > i5) {
                                                                i6 = i3;
                                                                uVar4 = uVar5;
                                                                i7 = i6;
                                                                i4++;
                                                                uVar2 = uVar4;
                                                                i3 = i7;
                                                            }
                                                        }
                                                    }
                                                    i7 = i5;
                                                    uVar4 = uVar3;
                                                    i4++;
                                                    uVar2 = uVar4;
                                                    i3 = i7;
                                                }
                                            }
                                        }
                                        i5 = i3;
                                        if (top > 0) {
                                            i3 = uVar5.a.getBottom() - height;
                                            i3 = Math.abs(i3);
                                            if (i3 > i5) {
                                                i6 = i3;
                                                uVar4 = uVar5;
                                                i7 = i6;
                                                i4++;
                                                uVar2 = uVar4;
                                                i3 = i7;
                                            }
                                        }
                                        i7 = i5;
                                        uVar4 = uVar3;
                                        i4++;
                                        uVar2 = uVar4;
                                        i3 = i7;
                                    }
                                }
                            }
                            i3 = i5;
                            if (top < 0) {
                                i5 = uVar5.a.getTop() - i2;
                                i5 = Math.abs(i5);
                                if (i5 > i3) {
                                    uVar3 = uVar5;
                                    if (top > 0) {
                                        i3 = uVar5.a.getBottom() - height;
                                        i3 = Math.abs(i3);
                                        if (i3 > i5) {
                                            i6 = i3;
                                            uVar4 = uVar5;
                                            i7 = i6;
                                            i4++;
                                            uVar2 = uVar4;
                                            i3 = i7;
                                        }
                                    }
                                    i7 = i5;
                                    uVar4 = uVar3;
                                    i4++;
                                    uVar2 = uVar4;
                                    i3 = i7;
                                }
                            }
                            i5 = i3;
                            if (top > 0) {
                                i3 = uVar5.a.getBottom() - height;
                                i3 = Math.abs(i3);
                                if (i3 > i5) {
                                    i6 = i3;
                                    uVar4 = uVar5;
                                    i7 = i6;
                                    i4++;
                                    uVar2 = uVar4;
                                    i3 = i7;
                                }
                            }
                            i7 = i5;
                            uVar4 = uVar3;
                            i4++;
                            uVar2 = uVar4;
                            i3 = i7;
                        }
                    }
                }
                uVar3 = uVar2;
                i5 = i3;
                if (left < 0) {
                    i3 = uVar5.a.getLeft() - i;
                    i3 = Math.abs(i3);
                    if (i3 > i5) {
                        uVar3 = uVar5;
                        if (top < 0) {
                            i5 = uVar5.a.getTop() - i2;
                            i5 = Math.abs(i5);
                            if (i5 > i3) {
                                uVar3 = uVar5;
                                if (top > 0) {
                                    i3 = uVar5.a.getBottom() - height;
                                    i3 = Math.abs(i3);
                                    if (i3 > i5) {
                                        i6 = i3;
                                        uVar4 = uVar5;
                                        i7 = i6;
                                        i4++;
                                        uVar2 = uVar4;
                                        i3 = i7;
                                    }
                                }
                                i7 = i5;
                                uVar4 = uVar3;
                                i4++;
                                uVar2 = uVar4;
                                i3 = i7;
                            }
                        }
                        i5 = i3;
                        if (top > 0) {
                            i3 = uVar5.a.getBottom() - height;
                            i3 = Math.abs(i3);
                            if (i3 > i5) {
                                i6 = i3;
                                uVar4 = uVar5;
                                i7 = i6;
                                i4++;
                                uVar2 = uVar4;
                                i3 = i7;
                            }
                        }
                        i7 = i5;
                        uVar4 = uVar3;
                        i4++;
                        uVar2 = uVar4;
                        i3 = i7;
                    }
                }
                i3 = i5;
                if (top < 0) {
                    i5 = uVar5.a.getTop() - i2;
                    i5 = Math.abs(i5);
                    if (i5 > i3) {
                        uVar3 = uVar5;
                        if (top > 0) {
                            i3 = uVar5.a.getBottom() - height;
                            i3 = Math.abs(i3);
                            if (i3 > i5) {
                                i6 = i3;
                                uVar4 = uVar5;
                                i7 = i6;
                                i4++;
                                uVar2 = uVar4;
                                i3 = i7;
                            }
                        }
                        i7 = i5;
                        uVar4 = uVar3;
                        i4++;
                        uVar2 = uVar4;
                        i3 = i7;
                    }
                }
                i5 = i3;
                if (top > 0) {
                    i3 = uVar5.a.getBottom() - height;
                    i3 = Math.abs(i3);
                    if (i3 > i5) {
                        i6 = i3;
                        uVar4 = uVar5;
                        i7 = i6;
                        i4++;
                        uVar2 = uVar4;
                        i3 = i7;
                    }
                }
                i7 = i5;
                uVar4 = uVar3;
                i4++;
                uVar2 = uVar4;
                i3 = i7;
            }
            return uVar2;
        }

        public void b(u uVar, int i) {
            if (uVar != null) {
                a.b(uVar.a);
            }
        }

        private int a(RecyclerView recyclerView) {
            if (this.d == -1) {
                this.d = recyclerView.getResources().getDimensionPixelSize(android.support.v7.f.a.a.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.d;
        }

        public void a(RecyclerView recyclerView, u uVar, int i, u uVar2, int i2, int i3, int i4) {
            h layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof d) {
                ((d) layoutManager).a(uVar.a, uVar2.a, i3, i4);
                return;
            }
            if (layoutManager.d()) {
                if (layoutManager.h(uVar2.a) <= recyclerView.getPaddingLeft()) {
                    recyclerView.a(i2);
                }
                if (layoutManager.j(uVar2.a) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.a(i2);
                }
            }
            if (layoutManager.e()) {
                if (layoutManager.i(uVar2.a) <= recyclerView.getPaddingTop()) {
                    recyclerView.a(i2);
                }
                if (layoutManager.k(uVar2.a) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.a(i2);
                }
            }
        }

        private void a(Canvas canvas, RecyclerView recyclerView, u uVar, List<c> list, int i, float f, float f2) {
            int i2;
            int size = list.size();
            for (i2 = 0; i2 < size; i2++) {
                c cVar = (c) list.get(i2);
                cVar.c();
                int save = canvas.save();
                a(canvas, recyclerView, cVar.h, cVar.k, cVar.l, cVar.i, false);
                canvas.restoreToCount(save);
            }
            if (uVar != null) {
                i2 = canvas.save();
                a(canvas, recyclerView, uVar, f, f2, i, true);
                canvas.restoreToCount(i2);
            }
        }

        private void b(Canvas canvas, RecyclerView recyclerView, u uVar, List<c> list, int i, float f, float f2) {
            int i2;
            int size = list.size();
            for (i2 = 0; i2 < size; i2++) {
                c cVar = (c) list.get(i2);
                int save = canvas.save();
                b(canvas, recyclerView, cVar.h, cVar.k, cVar.l, cVar.i, false);
                canvas.restoreToCount(save);
            }
            if (uVar != null) {
                i2 = canvas.save();
                b(canvas, recyclerView, uVar, f, f2, i, true);
                canvas.restoreToCount(i2);
            }
            Object obj = null;
            int i3 = size - 1;
            while (i3 >= 0) {
                Object obj2;
                cVar = (c) list.get(i3);
                if (cVar.c && !cVar.j) {
                    list.remove(i3);
                    obj2 = obj;
                } else if (cVar.c) {
                    obj2 = obj;
                } else {
                    obj2 = 1;
                }
                i3--;
                obj = obj2;
            }
            if (obj != null) {
                recyclerView.invalidate();
            }
        }

        public void c(RecyclerView recyclerView, u uVar) {
            a.a(uVar.a);
        }

        public void a(Canvas canvas, RecyclerView recyclerView, u uVar, float f, float f2, int i, boolean z) {
            a.a(canvas, recyclerView, uVar.a, f, f2, i, z);
        }

        public void b(Canvas canvas, RecyclerView recyclerView, u uVar, float f, float f2, int i, boolean z) {
            a.b(canvas, recyclerView, uVar.a, f, f2, i, z);
        }

        public long a(RecyclerView recyclerView, int i, float f, float f2) {
            RecyclerView.e itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i == 8 ? 200 : 250;
            } else {
                if (i == 8) {
                    return itemAnimator.d();
                }
                return itemAnimator.f();
            }
        }

        public int a(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            float f = 1.0f;
            int a = (int) (((float) (a(recyclerView) * ((int) Math.signum((float) i2)))) * c.getInterpolation(Math.min(1.0f, (((float) Math.abs(i2)) * 1.0f) / ((float) i))));
            if (j <= 2000) {
                f = ((float) j) / 2000.0f;
            }
            int interpolation = (int) (b.getInterpolation(f) * ((float) a));
            if (interpolation == 0) {
                return i2 > 0 ? 1 : -1;
            } else {
                return interpolation;
            }
        }
    }

    private class b extends SimpleOnGestureListener {
        final /* synthetic */ a a;

        private b(a aVar) {
            this.a = aVar;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            View b = this.a.b(motionEvent);
            if (b != null) {
                u a = this.a.r.a(b);
                if (a != null && this.a.l.d(this.a.r, a) && t.b(motionEvent, 0) == this.a.k) {
                    int a2 = t.a(motionEvent, this.a.k);
                    float c = t.c(motionEvent, a2);
                    float d = t.d(motionEvent, a2);
                    this.a.c = c;
                    this.a.d = d;
                    a aVar = this.a;
                    this.a.h = 0.0f;
                    aVar.g = 0.0f;
                    if (this.a.l.a()) {
                        this.a.a(a, 2);
                    }
                }
            }
        }
    }

    public a(a aVar) {
        this.l = aVar;
    }

    private static boolean a(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= ((float) view.getWidth()) + f3 && f2 >= f4 && f2 <= ((float) view.getHeight()) + f4;
    }

    public void a(RecyclerView recyclerView) {
        if (this.r != recyclerView) {
            if (this.r != null) {
                b();
            }
            this.r = recyclerView;
            if (this.r != null) {
                Resources resources = recyclerView.getResources();
                this.e = resources.getDimension(android.support.v7.f.a.a.item_touch_helper_swipe_escape_velocity);
                this.f = resources.getDimension(android.support.v7.f.a.a.item_touch_helper_swipe_escape_max_velocity);
                a();
            }
        }
    }

    private void a() {
        this.q = ViewConfiguration.get(this.r.getContext()).getScaledTouchSlop();
        this.r.a((g) this);
        this.r.a(this.A);
        this.r.a((j) this);
        c();
    }

    private void b() {
        this.r.b((g) this);
        this.r.b(this.A);
        this.r.b((j) this);
        for (int size = this.o.size() - 1; size >= 0; size--) {
            this.l.c(this.r, ((c) this.o.get(0)).h);
        }
        this.o.clear();
        this.x = null;
        this.y = -1;
        g();
    }

    private void c() {
        if (this.z == null) {
            this.z = new e(this.r.getContext(), new b());
        }
    }

    private void a(float[] fArr) {
        if ((this.n & 12) != 0) {
            fArr[0] = (this.i + this.g) - ((float) this.b.a.getLeft());
        } else {
            fArr[0] = ah.k(this.b.a);
        }
        if ((this.n & 3) != 0) {
            fArr[1] = (this.j + this.h) - ((float) this.b.a.getTop());
        } else {
            fArr[1] = ah.l(this.b.a);
        }
    }

    public void b(Canvas canvas, RecyclerView recyclerView, r rVar) {
        float f;
        float f2 = 0.0f;
        if (this.b != null) {
            a(this.p);
            f = this.p[0];
            f2 = this.p[1];
        } else {
            f = 0.0f;
        }
        this.l.b(canvas, recyclerView, this.b, this.o, this.m, f, f2);
    }

    public void a(Canvas canvas, RecyclerView recyclerView, r rVar) {
        float f;
        float f2 = 0.0f;
        this.y = -1;
        if (this.b != null) {
            a(this.p);
            f = this.p[0];
            f2 = this.p[1];
        } else {
            f = 0.0f;
        }
        this.l.a(canvas, recyclerView, this.b, this.o, this.m, f, f2);
    }

    private void a(u uVar, int i) {
        if (uVar != this.b || i != this.m) {
            this.C = Long.MIN_VALUE;
            int i2 = this.m;
            a(uVar, true);
            this.m = i;
            if (i == 2) {
                this.x = uVar.a;
                h();
            }
            int i3 = (1 << ((i * 8) + 8)) - 1;
            Object obj = null;
            if (this.b != null) {
                u uVar2 = this.b;
                if (uVar2.a.getParent() != null) {
                    int i4;
                    float f;
                    float signum;
                    int i5;
                    if (i2 == 2) {
                        i4 = 0;
                    } else {
                        i4 = d(uVar2);
                    }
                    g();
                    switch (i4) {
                        case 1:
                        case 2:
                            f = 0.0f;
                            signum = Math.signum(this.h) * ((float) this.r.getHeight());
                            break;
                        case 4:
                        case 8:
                        case 16:
                        case 32:
                            signum = 0.0f;
                            f = Math.signum(this.g) * ((float) this.r.getWidth());
                            break;
                        default:
                            f = 0.0f;
                            signum = 0.0f;
                            break;
                    }
                    if (i2 == 2) {
                        i5 = 8;
                    } else if (i4 > 0) {
                        i5 = 2;
                    } else {
                        i5 = 4;
                    }
                    a(this.p);
                    float f2 = this.p[0];
                    float f3 = this.p[1];
                    final u uVar3 = uVar2;
                    c anonymousClass3 = new c(this, uVar2, i5, i2, f2, f3, f, signum) {
                        final /* synthetic */ a c;

                        public void b(android.support.v4.a.g gVar) {
                            super.b(gVar);
                            if (!this.m) {
                                if (i4 <= 0) {
                                    this.c.l.c(this.c.r, uVar3);
                                } else {
                                    this.c.a.add(uVar3.a);
                                    this.j = true;
                                    if (i4 > 0) {
                                        this.c.a((c) this, i4);
                                    }
                                }
                                if (this.c.x == uVar3.a) {
                                    this.c.c(uVar3.a);
                                }
                            }
                        }
                    };
                    anonymousClass3.a(this.l.a(this.r, i5, f - f2, signum - f3));
                    this.o.add(anonymousClass3);
                    anonymousClass3.a();
                    obj = 1;
                } else {
                    c(uVar2.a);
                    this.l.c(this.r, uVar2);
                }
                this.b = null;
            }
            Object obj2 = obj;
            if (uVar != null) {
                this.n = (this.l.b(this.r, uVar) & i3) >> (this.m * 8);
                this.i = (float) uVar.a.getLeft();
                this.j = (float) uVar.a.getTop();
                this.b = uVar;
                if (i == 2) {
                    this.b.a.performHapticFeedback(0);
                }
            }
            ViewParent parent = this.r.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(this.b != null);
            }
            if (obj2 == null) {
                this.r.getLayoutManager().G();
            }
            this.l.b(this.b, this.m);
            this.r.invalidate();
        }
    }

    private void a(final c cVar, final int i) {
        this.r.post(new Runnable(this) {
            final /* synthetic */ a c;

            public void run() {
                if (this.c.r != null && this.c.r.isAttachedToWindow() && !cVar.m && cVar.h.e() != -1) {
                    RecyclerView.e itemAnimator = this.c.r.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.a(null)) && !this.c.d()) {
                        this.c.l.a(cVar.h, i);
                    } else {
                        this.c.r.post(this);
                    }
                }
            }
        });
    }

    private boolean d() {
        int size = this.o.size();
        for (int i = 0; i < size; i++) {
            if (!((c) this.o.get(i)).c) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e() {
        /*
        r14 = this;
        r12 = -9223372036854775808;
        r0 = 0;
        r5 = 0;
        r1 = r14.b;
        if (r1 != 0) goto L_0x000b;
    L_0x0008:
        r14.C = r12;
    L_0x000a:
        return r0;
    L_0x000b:
        r10 = java.lang.System.currentTimeMillis();
        r2 = r14.C;
        r1 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
        if (r1 != 0) goto L_0x00bb;
    L_0x0015:
        r6 = 0;
    L_0x0017:
        r1 = r14.r;
        r1 = r1.getLayoutManager();
        r2 = r14.B;
        if (r2 != 0) goto L_0x0028;
    L_0x0021:
        r2 = new android.graphics.Rect;
        r2.<init>();
        r14.B = r2;
    L_0x0028:
        r2 = r14.b;
        r2 = r2.a;
        r3 = r14.B;
        r1.b(r2, r3);
        r2 = r1.d();
        if (r2 == 0) goto L_0x00e6;
    L_0x0037:
        r2 = r14.i;
        r3 = r14.g;
        r2 = r2 + r3;
        r2 = (int) r2;
        r3 = r14.B;
        r3 = r3.left;
        r3 = r2 - r3;
        r4 = r14.r;
        r4 = r4.getPaddingLeft();
        r4 = r3 - r4;
        r3 = r14.g;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 >= 0) goto L_0x00c1;
    L_0x0051:
        if (r4 >= 0) goto L_0x00c1;
    L_0x0053:
        r1 = r1.e();
        if (r1 == 0) goto L_0x010e;
    L_0x0059:
        r1 = r14.j;
        r2 = r14.h;
        r1 = r1 + r2;
        r1 = (int) r1;
        r2 = r14.B;
        r2 = r2.top;
        r2 = r1 - r2;
        r3 = r14.r;
        r3 = r3.getPaddingTop();
        r8 = r2 - r3;
        r2 = r14.h;
        r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x00e9;
    L_0x0073:
        if (r8 >= 0) goto L_0x00e9;
    L_0x0075:
        if (r4 == 0) goto L_0x0117;
    L_0x0077:
        r1 = r14.l;
        r2 = r14.r;
        r3 = r14.b;
        r3 = r3.a;
        r3 = r3.getWidth();
        r5 = r14.r;
        r5 = r5.getWidth();
        r4 = r1.a(r2, r3, r4, r5, r6);
        r9 = r4;
    L_0x008e:
        if (r8 == 0) goto L_0x0115;
    L_0x0090:
        r1 = r14.l;
        r2 = r14.r;
        r3 = r14.b;
        r3 = r3.a;
        r3 = r3.getHeight();
        r4 = r14.r;
        r5 = r4.getHeight();
        r4 = r8;
        r1 = r1.a(r2, r3, r4, r5, r6);
    L_0x00a7:
        if (r9 != 0) goto L_0x00ab;
    L_0x00a9:
        if (r1 == 0) goto L_0x0111;
    L_0x00ab:
        r2 = r14.C;
        r0 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
        if (r0 != 0) goto L_0x00b3;
    L_0x00b1:
        r14.C = r10;
    L_0x00b3:
        r0 = r14.r;
        r0.scrollBy(r9, r1);
        r0 = 1;
        goto L_0x000a;
    L_0x00bb:
        r2 = r14.C;
        r6 = r10 - r2;
        goto L_0x0017;
    L_0x00c1:
        r3 = r14.g;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 <= 0) goto L_0x00e6;
    L_0x00c7:
        r3 = r14.b;
        r3 = r3.a;
        r3 = r3.getWidth();
        r2 = r2 + r3;
        r3 = r14.B;
        r3 = r3.right;
        r2 = r2 + r3;
        r3 = r14.r;
        r3 = r3.getWidth();
        r4 = r14.r;
        r4 = r4.getPaddingRight();
        r3 = r3 - r4;
        r4 = r2 - r3;
        if (r4 > 0) goto L_0x0053;
    L_0x00e6:
        r4 = r0;
        goto L_0x0053;
    L_0x00e9:
        r2 = r14.h;
        r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x010e;
    L_0x00ef:
        r2 = r14.b;
        r2 = r2.a;
        r2 = r2.getHeight();
        r1 = r1 + r2;
        r2 = r14.B;
        r2 = r2.bottom;
        r1 = r1 + r2;
        r2 = r14.r;
        r2 = r2.getHeight();
        r3 = r14.r;
        r3 = r3.getPaddingBottom();
        r2 = r2 - r3;
        r8 = r1 - r2;
        if (r8 > 0) goto L_0x0075;
    L_0x010e:
        r8 = r0;
        goto L_0x0075;
    L_0x0111:
        r14.C = r12;
        goto L_0x000a;
    L_0x0115:
        r1 = r8;
        goto L_0x00a7;
    L_0x0117:
        r9 = r4;
        goto L_0x008e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.a.a.e():boolean");
    }

    private List<u> b(u uVar) {
        if (this.u == null) {
            this.u = new ArrayList();
            this.v = new ArrayList();
        } else {
            this.u.clear();
            this.v.clear();
        }
        int c = this.l.c();
        int round = Math.round(this.i + this.g) - c;
        int round2 = Math.round(this.j + this.h) - c;
        int width = (uVar.a.getWidth() + round) + (c * 2);
        int height = (uVar.a.getHeight() + round2) + (c * 2);
        int i = (round + width) / 2;
        int i2 = (round2 + height) / 2;
        h layoutManager = this.r.getLayoutManager();
        int t = layoutManager.t();
        for (int i3 = 0; i3 < t; i3++) {
            View i4 = layoutManager.i(i3);
            if (i4 != uVar.a && i4.getBottom() >= round2 && i4.getTop() <= height && i4.getRight() >= round && i4.getLeft() <= width) {
                u a = this.r.a(i4);
                if (this.l.a(this.r, this.b, a)) {
                    int abs = Math.abs(i - ((i4.getLeft() + i4.getRight()) / 2));
                    c = Math.abs(i2 - ((i4.getBottom() + i4.getTop()) / 2));
                    int i5 = (abs * abs) + (c * c);
                    int size = this.u.size();
                    int i6 = 0;
                    abs = 0;
                    while (abs < size && i5 > ((Integer) this.v.get(abs)).intValue()) {
                        i6++;
                        abs++;
                    }
                    this.u.add(i6, a);
                    this.v.add(i6, Integer.valueOf(i5));
                }
            }
        }
        return this.u;
    }

    private void c(u uVar) {
        if (!this.r.isLayoutRequested() && this.m == 2) {
            float b = this.l.b(uVar);
            int i = (int) (this.i + this.g);
            int i2 = (int) (this.j + this.h);
            if (((float) Math.abs(i2 - uVar.a.getTop())) >= ((float) uVar.a.getHeight()) * b || ((float) Math.abs(i - uVar.a.getLeft())) >= b * ((float) uVar.a.getWidth())) {
                List b2 = b(uVar);
                if (b2.size() != 0) {
                    u a = this.l.a(uVar, b2, i, i2);
                    if (a == null) {
                        this.u.clear();
                        this.v.clear();
                        return;
                    }
                    int e = a.e();
                    int e2 = uVar.e();
                    if (this.l.b(this.r, uVar, a)) {
                        this.l.a(this.r, uVar, e2, a, e, i, i2);
                    }
                }
            }
        }
    }

    public void a(View view) {
    }

    public void b(View view) {
        c(view);
        u a = this.r.a(view);
        if (a != null) {
            if (this.b == null || a != this.b) {
                a(a, false);
                if (this.a.remove(a.a)) {
                    this.l.c(this.r, a);
                    return;
                }
                return;
            }
            a(null, 0);
        }
    }

    private int a(u uVar, boolean z) {
        for (int size = this.o.size() - 1; size >= 0; size--) {
            c cVar = (c) this.o.get(size);
            if (cVar.h == uVar) {
                cVar.m |= z;
                if (!cVar.c) {
                    cVar.b();
                }
                this.o.remove(size);
                return cVar.b;
            }
        }
        return 0;
    }

    public void a(Rect rect, View view, RecyclerView recyclerView, r rVar) {
        rect.setEmpty();
    }

    private void f() {
        if (this.t != null) {
            this.t.recycle();
        }
        this.t = VelocityTracker.obtain();
    }

    private void g() {
        if (this.t != null) {
            this.t.recycle();
            this.t = null;
        }
    }

    private u a(MotionEvent motionEvent) {
        h layoutManager = this.r.getLayoutManager();
        if (this.k == -1) {
            return null;
        }
        int a = t.a(motionEvent, this.k);
        float c = t.c(motionEvent, a) - this.c;
        float d = t.d(motionEvent, a) - this.d;
        c = Math.abs(c);
        d = Math.abs(d);
        if (c < ((float) this.q) && d < ((float) this.q)) {
            return null;
        }
        if (c > d && layoutManager.d()) {
            return null;
        }
        if (d > c && layoutManager.e()) {
            return null;
        }
        View b = b(motionEvent);
        if (b != null) {
            return this.r.a(b);
        }
        return null;
    }

    private boolean a(int i, MotionEvent motionEvent, int i2) {
        if (this.b != null || i != 2 || this.m == 2 || !this.l.b() || this.r.getScrollState() == 1) {
            return false;
        }
        u a = a(motionEvent);
        if (a == null) {
            return false;
        }
        int b = (this.l.b(this.r, a) & 65280) >> 8;
        if (b == 0) {
            return false;
        }
        float c = t.c(motionEvent, i2);
        c -= this.c;
        float d = t.d(motionEvent, i2) - this.d;
        float abs = Math.abs(c);
        float abs2 = Math.abs(d);
        if (abs < ((float) this.q) && abs2 < ((float) this.q)) {
            return false;
        }
        if (abs > abs2) {
            if (c < 0.0f && (b & 4) == 0) {
                return false;
            }
            if (c > 0.0f && (b & 8) == 0) {
                return false;
            }
        } else if (d < 0.0f && (b & 1) == 0) {
            return false;
        } else {
            if (d > 0.0f && (b & 2) == 0) {
                return false;
            }
        }
        this.h = 0.0f;
        this.g = 0.0f;
        this.k = t.b(motionEvent, 0);
        a(a, 1);
        return true;
    }

    private View b(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.b != null) {
            View view = this.b.a;
            if (a(view, x, y, this.i + this.g, this.j + this.h)) {
                return view;
            }
        }
        for (int size = this.o.size() - 1; size >= 0; size--) {
            c cVar = (c) this.o.get(size);
            View view2 = cVar.h.a;
            if (a(view2, x, y, cVar.k, cVar.l)) {
                return view2;
            }
        }
        return this.r.a(x, y);
    }

    public void a(u uVar) {
        if (!this.l.d(this.r, uVar)) {
            Log.e("ItemTouchHelper", "Start drag has been called but swiping is not enabled");
        } else if (uVar.a.getParent() != this.r) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        } else {
            f();
            this.h = 0.0f;
            this.g = 0.0f;
            a(uVar, 2);
        }
    }

    private c c(MotionEvent motionEvent) {
        if (this.o.isEmpty()) {
            return null;
        }
        View b = b(motionEvent);
        for (int size = this.o.size() - 1; size >= 0; size--) {
            c cVar = (c) this.o.get(size);
            if (cVar.h.a == b) {
                return cVar;
            }
        }
        return null;
    }

    private void a(MotionEvent motionEvent, int i, int i2) {
        float c = t.c(motionEvent, i2);
        float d = t.d(motionEvent, i2);
        this.g = c - this.c;
        this.h = d - this.d;
        if ((i & 4) == 0) {
            this.g = Math.max(0.0f, this.g);
        }
        if ((i & 8) == 0) {
            this.g = Math.min(0.0f, this.g);
        }
        if ((i & 1) == 0) {
            this.h = Math.max(0.0f, this.h);
        }
        if ((i & 2) == 0) {
            this.h = Math.min(0.0f, this.h);
        }
    }

    private int d(u uVar) {
        if (this.m == 2) {
            return 0;
        }
        int a = this.l.a(this.r, uVar);
        int d = (this.l.d(a, ah.h(this.r)) & 65280) >> 8;
        if (d == 0) {
            return 0;
        }
        int i = (a & 65280) >> 8;
        if (Math.abs(this.g) > Math.abs(this.h)) {
            a = b(uVar, d);
            if (a > 0) {
                return (i & a) == 0 ? a.a(a, ah.h(this.r)) : a;
            } else {
                a = c(uVar, d);
                if (a > 0) {
                    return a;
                }
                return 0;
            }
        }
        a = c(uVar, d);
        if (a > 0) {
            return a;
        }
        a = b(uVar, d);
        if (a > 0) {
            return (i & a) == 0 ? a.a(a, ah.h(this.r)) : a;
        } else {
            return 0;
        }
    }

    private int b(u uVar, int i) {
        int i2 = 8;
        if ((i & 12) != 0) {
            int i3 = this.g > 0.0f ? 8 : 4;
            if (this.t != null && this.k > -1) {
                this.t.computeCurrentVelocity(1000, this.l.b(this.f));
                float a = af.a(this.t, this.k);
                float b = af.b(this.t, this.k);
                if (a <= 0.0f) {
                    i2 = 4;
                }
                float abs = Math.abs(a);
                if ((i2 & i) != 0 && i3 == i2 && abs >= this.l.a(this.e) && abs > Math.abs(b)) {
                    return i2;
                }
            }
            float width = ((float) this.r.getWidth()) * this.l.a(uVar);
            if ((i & i3) != 0 && Math.abs(this.g) > width) {
                return i3;
            }
        }
        return 0;
    }

    private int c(u uVar, int i) {
        int i2 = 2;
        if ((i & 3) != 0) {
            int i3 = this.h > 0.0f ? 2 : 1;
            if (this.t != null && this.k > -1) {
                this.t.computeCurrentVelocity(1000, this.l.b(this.f));
                float a = af.a(this.t, this.k);
                float b = af.b(this.t, this.k);
                if (b <= 0.0f) {
                    i2 = 1;
                }
                float abs = Math.abs(b);
                if ((i2 & i) != 0 && i2 == i3 && abs >= this.l.a(this.e) && abs > Math.abs(a)) {
                    return i2;
                }
            }
            float height = ((float) this.r.getHeight()) * this.l.a(uVar);
            if ((i & i3) != 0 && Math.abs(this.h) > height) {
                return i3;
            }
        }
        return 0;
    }

    private void h() {
        if (VERSION.SDK_INT < 21) {
            if (this.w == null) {
                this.w = new android.support.v7.widget.RecyclerView.d(this) {
                    final /* synthetic */ a a;

                    {
                        this.a = r1;
                    }

                    public int a(int i, int i2) {
                        if (this.a.x == null) {
                            return i2;
                        }
                        int i3 = this.a.y;
                        if (i3 == -1) {
                            i3 = this.a.r.indexOfChild(this.a.x);
                            this.a.y = i3;
                        }
                        if (i2 == i - 1) {
                            return i3;
                        }
                        return i2 >= i3 ? i2 + 1 : i2;
                    }
                };
            }
            this.r.setChildDrawingOrderCallback(this.w);
        }
    }

    private void c(View view) {
        if (view == this.x) {
            this.x = null;
            if (this.w != null) {
                this.r.setChildDrawingOrderCallback(null);
            }
        }
    }
}
