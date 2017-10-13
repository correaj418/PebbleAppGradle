package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.d.c;
import android.support.v4.e.d;
import android.support.v4.view.ah;
import android.support.v4.view.n;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class q extends p implements n {
    static final Interpolator A = new DecelerateInterpolator(2.5f);
    static final Interpolator B = new DecelerateInterpolator(1.5f);
    static final Interpolator C = new AccelerateInterpolator(2.5f);
    static final Interpolator D = new AccelerateInterpolator(1.5f);
    static boolean a = false;
    static final boolean b;
    static Field r = null;
    ArrayList<Runnable> c;
    Runnable[] d;
    boolean e;
    ArrayList<k> f;
    ArrayList<k> g;
    ArrayList<Integer> h;
    ArrayList<d> i;
    ArrayList<k> j;
    ArrayList<d> k;
    ArrayList<Integer> l;
    ArrayList<android.support.v4.app.p.a> m;
    int n = 0;
    o o;
    m p;
    k q;
    boolean s;
    boolean t;
    boolean u;
    String v;
    boolean w;
    Bundle x = null;
    SparseArray<Parcelable> y = null;
    Runnable z = new Runnable(this) {
        final /* synthetic */ q a;

        {
            this.a = r1;
        }

        public void run() {
            this.a.e();
        }
    };

    static class a implements AnimationListener {
        private AnimationListener a;
        private boolean b;
        private View c;

        public a(View view, Animation animation) {
            if (view != null && animation != null) {
                this.c = view;
            }
        }

        public a(View view, Animation animation, AnimationListener animationListener) {
            if (view != null && animation != null) {
                this.a = animationListener;
                this.c = view;
                this.b = true;
            }
        }

        public void onAnimationStart(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationStart(animation);
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.c != null && this.b) {
                if (ah.y(this.c) || c.a()) {
                    this.c.post(new Runnable(this) {
                        final /* synthetic */ a a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            ah.a(this.a.c, 0, null);
                        }
                    });
                } else {
                    ah.a(this.c, 0, null);
                }
            }
            if (this.a != null) {
                this.a.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationRepeat(animation);
            }
        }
    }

    static class b {
        public static final int[] a = new int[]{16842755, 16842960, 16842961};
    }

    q() {
    }

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        b = z;
    }

    static boolean a(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return false;
        }
        List animations = ((AnimationSet) animation).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    static boolean a(View view, Animation animation) {
        return VERSION.SDK_INT >= 19 && ah.g(view) == 0 && ah.u(view) && a(animation);
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new d("FragmentManager"));
        if (this.o != null) {
            try {
                this.o.a("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public s a() {
        return new d(this);
    }

    public boolean c() {
        return e();
    }

    public boolean b() {
        v();
        c();
        return a(this.o.h(), null, -1, 0);
    }

    public void a(final int i, final int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        a(new Runnable(this) {
            final /* synthetic */ q c;

            public void run() {
                this.c.a(this.c.o.h(), null, i, i2);
            }
        }, false);
    }

    public void a(Bundle bundle, String str, k kVar) {
        if (kVar.p < 0) {
            a(new IllegalStateException("Fragment " + kVar + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, kVar.p);
    }

    public k a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f.size()) {
            a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        k kVar = (k) this.f.get(i);
        if (kVar != null) {
            return kVar;
        }
        a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return kVar;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.q != null) {
            android.support.v4.e.c.a(this.q, stringBuilder);
        } else {
            android.support.v4.e.c.a(this.o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        k kVar;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f != null) {
            size = this.f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    kVar = (k) this.f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(kVar);
                    if (kVar != null) {
                        kVar.a(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.g != null) {
            size = this.g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    kVar = (k) this.g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(kVar.toString());
                }
            }
        }
        if (this.j != null) {
            size = this.j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    kVar = (k) this.j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(kVar.toString());
                }
            }
        }
        if (this.i != null) {
            size = this.i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    d dVar = (d) this.i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(dVar.toString());
                    dVar.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.k != null) {
                int size2 = this.k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        dVar = (d) this.k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(dVar);
                    }
                }
            }
            if (this.l != null && this.l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.l.toArray()));
            }
        }
        if (this.c != null) {
            i = this.c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.p);
        if (this.q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.u);
        if (this.s) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.s);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.v);
        }
        if (this.h != null && this.h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.h.toArray()));
        }
    }

    static Animation a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(B);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    static Animation a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(B);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    Animation a(k kVar, int i, boolean z, int i2) {
        Animation a = kVar.a(i, z, kVar.Q);
        if (a != null) {
            return a;
        }
        if (kVar.Q != 0) {
            a = AnimationUtils.loadAnimation(this.o.g(), kVar.Q);
            if (a != null) {
                return a;
            }
        }
        if (i == 0) {
            return null;
        }
        int b = b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case 1:
                return a(this.o.g(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return a(this.o.g(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return a(this.o.g(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return a(this.o.g(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return a(this.o.g(), 0.0f, 1.0f);
            case 6:
                return a(this.o.g(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.o.d()) {
                    i2 = this.o.e();
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    public void a(k kVar) {
        if (!kVar.U) {
            return;
        }
        if (this.e) {
            this.w = true;
            return;
        }
        kVar.U = false;
        a(kVar, this.n, 0, 0, false);
    }

    private void b(View view, Animation animation) {
        if (view != null && animation != null && a(view, animation)) {
            AnimationListener animationListener;
            try {
                if (r == null) {
                    r = Animation.class.getDeclaredField("mListener");
                    r.setAccessible(true);
                }
                animationListener = (AnimationListener) r.get(animation);
            } catch (Throwable e) {
                Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
                animationListener = null;
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
                animationListener = null;
            }
            ah.a(view, 2, null);
            animation.setAnimationListener(new a(view, animation, animationListener));
        }
    }

    boolean a(int i) {
        return this.n >= i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void a(final android.support.v4.app.k r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r3 = 0;
        r5 = 1;
        r7 = 0;
        r0 = r11.v;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.K;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.w;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r11.k;
        if (r12 <= r0) goto L_0x001a;
    L_0x0018:
        r12 = r11.k;
    L_0x001a:
        r0 = r11.U;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r11.k;
        if (r0 >= r9) goto L_0x0025;
    L_0x0022:
        if (r12 <= r6) goto L_0x0025;
    L_0x0024:
        r12 = r6;
    L_0x0025:
        r0 = r11.k;
        if (r0 >= r12) goto L_0x02eb;
    L_0x0029:
        r0 = r11.x;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r11.y;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r11.l;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r11.l = r7;
        r2 = r11.m;
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r11.k;
        switch(r0) {
            case 0: goto L_0x0080;
            case 1: goto L_0x0176;
            case 2: goto L_0x026d;
            case 3: goto L_0x0272;
            case 4: goto L_0x0293;
            default: goto L_0x0045;
        };
    L_0x0045:
        r0 = r11.k;
        if (r0 == r12) goto L_0x0031;
    L_0x0049:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveToState: Fragment state for ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " not updated inline; ";
        r1 = r1.append(r2);
        r2 = "expected state ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = " found ";
        r1 = r1.append(r2);
        r2 = r11.k;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r11.k = r12;
        goto L_0x0031;
    L_0x0080:
        r0 = a;
        if (r0 == 0) goto L_0x009c;
    L_0x0084:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x009c:
        r0 = r11.n;
        if (r0 == 0) goto L_0x00e4;
    L_0x00a0:
        r0 = r11.n;
        r1 = r10.o;
        r1 = r1.g();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.n;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.o = r0;
        r0 = r11.n;
        r1 = "android:target_state";
        r0 = r10.a(r0, r1);
        r11.s = r0;
        r0 = r11.s;
        if (r0 == 0) goto L_0x00d1;
    L_0x00c7:
        r0 = r11.n;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.u = r0;
    L_0x00d1:
        r0 = r11.n;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.V = r0;
        r0 = r11.V;
        if (r0 != 0) goto L_0x00e4;
    L_0x00df:
        r11.U = r5;
        if (r12 <= r6) goto L_0x00e4;
    L_0x00e3:
        r12 = r6;
    L_0x00e4:
        r0 = r10.o;
        r11.C = r0;
        r0 = r10.q;
        r11.F = r0;
        r0 = r10.q;
        if (r0 == 0) goto L_0x0124;
    L_0x00f0:
        r0 = r10.q;
        r0 = r0.D;
    L_0x00f4:
        r11.B = r0;
        r11.P = r3;
        r0 = r10.o;
        r0 = r0.g();
        r11.a(r0);
        r0 = r11.P;
        if (r0 != 0) goto L_0x012b;
    L_0x0105:
        r0 = new android.support.v4.app.aw;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0124:
        r0 = r10.o;
        r0 = r0.i();
        goto L_0x00f4;
    L_0x012b:
        r0 = r11.F;
        if (r0 != 0) goto L_0x02ba;
    L_0x012f:
        r0 = r10.o;
        r0.b(r11);
    L_0x0134:
        r0 = r11.M;
        if (r0 != 0) goto L_0x02c1;
    L_0x0138:
        r0 = r11.n;
        r11.i(r0);
    L_0x013d:
        r11.M = r3;
        r0 = r11.x;
        if (r0 == 0) goto L_0x0176;
    L_0x0143:
        r0 = r11.n;
        r0 = r11.b(r0);
        r1 = r11.n;
        r0 = r11.b(r0, r7, r1);
        r11.S = r0;
        r0 = r11.S;
        if (r0 == 0) goto L_0x02d4;
    L_0x0155:
        r0 = r11.S;
        r11.T = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x02ca;
    L_0x015f:
        r0 = r11.S;
        android.support.v4.view.ah.a(r0, r3);
    L_0x0164:
        r0 = r11.J;
        if (r0 == 0) goto L_0x016f;
    L_0x0168:
        r0 = r11.S;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x016f:
        r0 = r11.S;
        r1 = r11.n;
        r11.a(r0, r1);
    L_0x0176:
        if (r12 <= r5) goto L_0x026d;
    L_0x0178:
        r0 = a;
        if (r0 == 0) goto L_0x0194;
    L_0x017c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0194:
        r0 = r11.x;
        if (r0 != 0) goto L_0x025d;
    L_0x0198:
        r0 = r11.H;
        if (r0 == 0) goto L_0x0421;
    L_0x019c:
        r0 = r11.H;
        r1 = -1;
        if (r0 != r1) goto L_0x01c2;
    L_0x01a1:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Cannot create fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " for a container view with no id";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        r10.a(r0);
    L_0x01c2:
        r0 = r10.p;
        r1 = r11.H;
        r0 = r0.a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x0211;
    L_0x01ce:
        r1 = r11.z;
        if (r1 != 0) goto L_0x0211;
    L_0x01d2:
        r1 = r11.h();	 Catch:{ NotFoundException -> 0x02d8 }
        r2 = r11.H;	 Catch:{ NotFoundException -> 0x02d8 }
        r1 = r1.getResourceName(r2);	 Catch:{ NotFoundException -> 0x02d8 }
    L_0x01dc:
        r2 = new java.lang.IllegalArgumentException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = "No view found for id 0x";
        r4 = r4.append(r8);
        r8 = r11.H;
        r8 = java.lang.Integer.toHexString(r8);
        r4 = r4.append(r8);
        r8 = " (";
        r4 = r4.append(r8);
        r1 = r4.append(r1);
        r4 = ") for fragment ";
        r1 = r1.append(r4);
        r1 = r1.append(r11);
        r1 = r1.toString();
        r2.<init>(r1);
        r10.a(r2);
    L_0x0211:
        r11.R = r0;
        r1 = r11.n;
        r1 = r11.b(r1);
        r2 = r11.n;
        r1 = r11.b(r1, r0, r2);
        r11.S = r1;
        r1 = r11.S;
        if (r1 == 0) goto L_0x02e7;
    L_0x0225:
        r1 = r11.S;
        r11.T = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x02dd;
    L_0x022f:
        r1 = r11.S;
        android.support.v4.view.ah.a(r1, r3);
    L_0x0234:
        if (r0 == 0) goto L_0x024b;
    L_0x0236:
        r1 = r10.a(r11, r13, r5, r14);
        if (r1 == 0) goto L_0x0246;
    L_0x023c:
        r2 = r11.S;
        r10.b(r2, r1);
        r2 = r11.S;
        r2.startAnimation(r1);
    L_0x0246:
        r1 = r11.S;
        r0.addView(r1);
    L_0x024b:
        r0 = r11.J;
        if (r0 == 0) goto L_0x0256;
    L_0x024f:
        r0 = r11.S;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0256:
        r0 = r11.S;
        r1 = r11.n;
        r11.a(r0, r1);
    L_0x025d:
        r0 = r11.n;
        r11.j(r0);
        r0 = r11.S;
        if (r0 == 0) goto L_0x026b;
    L_0x0266:
        r0 = r11.n;
        r11.f(r0);
    L_0x026b:
        r11.n = r7;
    L_0x026d:
        r0 = 2;
        if (r12 <= r0) goto L_0x0272;
    L_0x0270:
        r11.k = r6;
    L_0x0272:
        if (r12 <= r6) goto L_0x0293;
    L_0x0274:
        r0 = a;
        if (r0 == 0) goto L_0x0290;
    L_0x0278:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0290:
        r11.C();
    L_0x0293:
        if (r12 <= r9) goto L_0x0045;
    L_0x0295:
        r0 = a;
        if (r0 == 0) goto L_0x02b1;
    L_0x0299:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02b1:
        r11.D();
        r11.n = r7;
        r11.o = r7;
        goto L_0x0045;
    L_0x02ba:
        r0 = r11.F;
        r0.a(r11);
        goto L_0x0134;
    L_0x02c1:
        r0 = r11.n;
        r11.g(r0);
        r11.k = r5;
        goto L_0x013d;
    L_0x02ca:
        r0 = r11.S;
        r0 = android.support.v4.app.z.a(r0);
        r11.S = r0;
        goto L_0x0164;
    L_0x02d4:
        r11.T = r7;
        goto L_0x0176;
    L_0x02d8:
        r1 = move-exception;
        r1 = "unknown";
        goto L_0x01dc;
    L_0x02dd:
        r1 = r11.S;
        r1 = android.support.v4.app.z.a(r1);
        r11.S = r1;
        goto L_0x0234;
    L_0x02e7:
        r11.T = r7;
        goto L_0x025d;
    L_0x02eb:
        r0 = r11.k;
        if (r0 <= r12) goto L_0x0045;
    L_0x02ef:
        r0 = r11.k;
        switch(r0) {
            case 1: goto L_0x02f6;
            case 2: goto L_0x0374;
            case 3: goto L_0x0353;
            case 4: goto L_0x0332;
            case 5: goto L_0x0310;
            default: goto L_0x02f4;
        };
    L_0x02f4:
        goto L_0x0045;
    L_0x02f6:
        if (r12 >= r5) goto L_0x0045;
    L_0x02f8:
        r0 = r10.u;
        if (r0 == 0) goto L_0x0307;
    L_0x02fc:
        r0 = r11.l;
        if (r0 == 0) goto L_0x0307;
    L_0x0300:
        r0 = r11.l;
        r11.l = r7;
        r0.clearAnimation();
    L_0x0307:
        r0 = r11.l;
        if (r0 == 0) goto L_0x03e3;
    L_0x030b:
        r11.m = r12;
        r12 = r5;
        goto L_0x0045;
    L_0x0310:
        r0 = 5;
        if (r12 >= r0) goto L_0x0332;
    L_0x0313:
        r0 = a;
        if (r0 == 0) goto L_0x032f;
    L_0x0317:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x032f:
        r11.F();
    L_0x0332:
        if (r12 >= r9) goto L_0x0353;
    L_0x0334:
        r0 = a;
        if (r0 == 0) goto L_0x0350;
    L_0x0338:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0350:
        r11.G();
    L_0x0353:
        if (r12 >= r6) goto L_0x0374;
    L_0x0355:
        r0 = a;
        if (r0 == 0) goto L_0x0371;
    L_0x0359:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0371:
        r11.H();
    L_0x0374:
        r0 = 2;
        if (r12 >= r0) goto L_0x02f6;
    L_0x0377:
        r0 = a;
        if (r0 == 0) goto L_0x0393;
    L_0x037b:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0393:
        r0 = r11.S;
        if (r0 == 0) goto L_0x03a6;
    L_0x0397:
        r0 = r10.o;
        r0 = r0.a(r11);
        if (r0 == 0) goto L_0x03a6;
    L_0x039f:
        r0 = r11.o;
        if (r0 != 0) goto L_0x03a6;
    L_0x03a3:
        r10.e(r11);
    L_0x03a6:
        r11.I();
        r0 = r11.S;
        if (r0 == 0) goto L_0x03db;
    L_0x03ad:
        r0 = r11.R;
        if (r0 == 0) goto L_0x03db;
    L_0x03b1:
        r0 = r10.n;
        if (r0 <= 0) goto L_0x041f;
    L_0x03b5:
        r0 = r10.u;
        if (r0 != 0) goto L_0x041f;
    L_0x03b9:
        r0 = r10.a(r11, r13, r3, r14);
    L_0x03bd:
        if (r0 == 0) goto L_0x03d4;
    L_0x03bf:
        r1 = r11.S;
        r11.l = r1;
        r11.m = r12;
        r1 = r11.S;
        r2 = new android.support.v4.app.q$3;
        r2.<init>(r10, r1, r0, r11);
        r0.setAnimationListener(r2);
        r1 = r11.S;
        r1.startAnimation(r0);
    L_0x03d4:
        r0 = r11.R;
        r1 = r11.S;
        r0.removeView(r1);
    L_0x03db:
        r11.R = r7;
        r11.S = r7;
        r11.T = r7;
        goto L_0x02f6;
    L_0x03e3:
        r0 = a;
        if (r0 == 0) goto L_0x03ff;
    L_0x03e7:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03ff:
        r0 = r11.M;
        if (r0 != 0) goto L_0x0414;
    L_0x0403:
        r11.J();
    L_0x0406:
        r11.K();
        if (r15 != 0) goto L_0x0045;
    L_0x040b:
        r0 = r11.M;
        if (r0 != 0) goto L_0x0417;
    L_0x040f:
        r10.d(r11);
        goto L_0x0045;
    L_0x0414:
        r11.k = r3;
        goto L_0x0406;
    L_0x0417:
        r11.C = r7;
        r11.F = r7;
        r11.B = r7;
        goto L_0x0045;
    L_0x041f:
        r0 = r7;
        goto L_0x03bd;
    L_0x0421:
        r0 = r7;
        goto L_0x0211;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.q.a(android.support.v4.app.k, int, int, int, boolean):void");
    }

    void b(k kVar) {
        a(kVar, this.n, 0, 0, false);
    }

    void a(int i, boolean z) {
        a(i, 0, 0, z);
    }

    void a(int i, int i2, int i3, boolean z) {
        if (this.o == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.n != i) {
            this.n = i;
            if (this.f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f.size()) {
                    int a;
                    k kVar = (k) this.f.get(i4);
                    if (kVar != null) {
                        a(kVar, i, i2, i3, false);
                        if (kVar.W != null) {
                            a = i5 | kVar.W.a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    d();
                }
                if (this.s && this.o != null && this.n == 5) {
                    this.o.c();
                    this.s = false;
                }
            }
        }
    }

    void d() {
        if (this.f != null) {
            for (int i = 0; i < this.f.size(); i++) {
                k kVar = (k) this.f.get(i);
                if (kVar != null) {
                    a(kVar);
                }
            }
        }
    }

    void c(k kVar) {
        if (kVar.p < 0) {
            if (this.h == null || this.h.size() <= 0) {
                if (this.f == null) {
                    this.f = new ArrayList();
                }
                kVar.a(this.f.size(), this.q);
                this.f.add(kVar);
            } else {
                kVar.a(((Integer) this.h.remove(this.h.size() - 1)).intValue(), this.q);
                this.f.set(kVar.p, kVar);
            }
            if (a) {
                Log.v("FragmentManager", "Allocated fragment index " + kVar);
            }
        }
    }

    void d(k kVar) {
        if (kVar.p >= 0) {
            if (a) {
                Log.v("FragmentManager", "Freeing fragment index " + kVar);
            }
            this.f.set(kVar.p, null);
            if (this.h == null) {
                this.h = new ArrayList();
            }
            this.h.add(Integer.valueOf(kVar.p));
            this.o.a(kVar.q);
            kVar.r();
        }
    }

    public void a(k kVar, boolean z) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        if (a) {
            Log.v("FragmentManager", "add: " + kVar);
        }
        c(kVar);
        if (!kVar.K) {
            if (this.g.contains(kVar)) {
                throw new IllegalStateException("Fragment already added: " + kVar);
            }
            this.g.add(kVar);
            kVar.v = true;
            kVar.w = false;
            if (kVar.N && kVar.O) {
                this.s = true;
            }
            if (z) {
                b(kVar);
            }
        }
    }

    public void a(k kVar, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "remove: " + kVar + " nesting=" + kVar.A);
        }
        boolean z = !kVar.f();
        if (!kVar.K || z) {
            int i3;
            if (this.g != null) {
                this.g.remove(kVar);
            }
            if (kVar.N && kVar.O) {
                this.s = true;
            }
            kVar.v = false;
            kVar.w = true;
            if (z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            a(kVar, i3, i, i2, false);
        }
    }

    public void b(k kVar, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "hide: " + kVar);
        }
        if (!kVar.J) {
            kVar.J = true;
            if (kVar.S != null) {
                Animation a = a(kVar, i, false, i2);
                if (a != null) {
                    b(kVar.S, a);
                    kVar.S.startAnimation(a);
                }
                kVar.S.setVisibility(8);
            }
            if (kVar.v && kVar.N && kVar.O) {
                this.s = true;
            }
            kVar.c(true);
        }
    }

    public void c(k kVar, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "show: " + kVar);
        }
        if (kVar.J) {
            kVar.J = false;
            if (kVar.S != null) {
                Animation a = a(kVar, i, true, i2);
                if (a != null) {
                    b(kVar.S, a);
                    kVar.S.startAnimation(a);
                }
                kVar.S.setVisibility(0);
            }
            if (kVar.v && kVar.N && kVar.O) {
                this.s = true;
            }
            kVar.c(false);
        }
    }

    public void d(k kVar, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "detach: " + kVar);
        }
        if (!kVar.K) {
            kVar.K = true;
            if (kVar.v) {
                if (this.g != null) {
                    if (a) {
                        Log.v("FragmentManager", "remove from detach: " + kVar);
                    }
                    this.g.remove(kVar);
                }
                if (kVar.N && kVar.O) {
                    this.s = true;
                }
                kVar.v = false;
                a(kVar, 1, i, i2, false);
            }
        }
    }

    public void e(k kVar, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "attach: " + kVar);
        }
        if (kVar.K) {
            kVar.K = false;
            if (!kVar.v) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                if (this.g.contains(kVar)) {
                    throw new IllegalStateException("Fragment already added: " + kVar);
                }
                if (a) {
                    Log.v("FragmentManager", "add from attach: " + kVar);
                }
                this.g.add(kVar);
                kVar.v = true;
                if (kVar.N && kVar.O) {
                    this.s = true;
                }
                a(kVar, this.n, i, i2, false);
            }
        }
    }

    public k b(int i) {
        int size;
        k kVar;
        if (this.g != null) {
            for (size = this.g.size() - 1; size >= 0; size--) {
                kVar = (k) this.g.get(size);
                if (kVar != null && kVar.G == i) {
                    return kVar;
                }
            }
        }
        if (this.f != null) {
            for (size = this.f.size() - 1; size >= 0; size--) {
                kVar = (k) this.f.get(size);
                if (kVar != null && kVar.G == i) {
                    return kVar;
                }
            }
        }
        return null;
    }

    public k a(String str) {
        int size;
        k kVar;
        if (!(this.g == null || str == null)) {
            for (size = this.g.size() - 1; size >= 0; size--) {
                kVar = (k) this.g.get(size);
                if (kVar != null && str.equals(kVar.I)) {
                    return kVar;
                }
            }
        }
        if (!(this.f == null || str == null)) {
            for (size = this.f.size() - 1; size >= 0; size--) {
                kVar = (k) this.f.get(size);
                if (kVar != null && str.equals(kVar.I)) {
                    return kVar;
                }
            }
        }
        return null;
    }

    public k b(String str) {
        if (!(this.f == null || str == null)) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                k kVar = (k) this.f.get(size);
                if (kVar != null) {
                    kVar = kVar.a(str);
                    if (kVar != null) {
                        return kVar;
                    }
                }
            }
        }
        return null;
    }

    private void v() {
        if (this.t) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.v != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.v);
        }
    }

    public void a(Runnable runnable, boolean z) {
        if (!z) {
            v();
        }
        synchronized (this) {
            if (this.u || this.o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.c == null) {
                this.c = new ArrayList();
            }
            this.c.add(runnable);
            if (this.c.size() == 1) {
                this.o.h().removeCallbacks(this.z);
                this.o.h().post(this.z);
            }
        }
    }

    public int a(d dVar) {
        int size;
        synchronized (this) {
            if (this.l == null || this.l.size() <= 0) {
                if (this.k == null) {
                    this.k = new ArrayList();
                }
                size = this.k.size();
                if (a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + dVar);
                }
                this.k.add(dVar);
            } else {
                size = ((Integer) this.l.remove(this.l.size() - 1)).intValue();
                if (a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + dVar);
                }
                this.k.set(size, dVar);
            }
        }
        return size;
    }

    public void a(int i, d dVar) {
        synchronized (this) {
            if (this.k == null) {
                this.k = new ArrayList();
            }
            int size = this.k.size();
            if (i < size) {
                if (a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + dVar);
                }
                this.k.set(i, dVar);
            } else {
                while (size < i) {
                    this.k.add(null);
                    if (this.l == null) {
                        this.l = new ArrayList();
                    }
                    if (a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.l.add(Integer.valueOf(size));
                    size++;
                }
                if (a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + dVar);
                }
                this.k.add(dVar);
            }
        }
    }

    public void c(int i) {
        synchronized (this) {
            this.k.set(i, null);
            if (this.l == null) {
                this.l = new ArrayList();
            }
            if (a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.l.add(Integer.valueOf(i));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e() {
        /*
        r6 = this;
        r2 = 1;
        r1 = 0;
        r0 = r6.e;
        if (r0 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "FragmentManager is already executing transactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r0 = android.os.Looper.myLooper();
        r3 = r6.o;
        r3 = r3.h();
        r3 = r3.getLooper();
        if (r0 == r3) goto L_0x0026;
    L_0x001e:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of fragment host";
        r0.<init>(r1);
        throw r0;
    L_0x0026:
        r0 = r1;
    L_0x0027:
        monitor-enter(r6);
        r3 = r6.c;	 Catch:{ all -> 0x0078 }
        if (r3 == 0) goto L_0x0034;
    L_0x002c:
        r3 = r6.c;	 Catch:{ all -> 0x0078 }
        r3 = r3.size();	 Catch:{ all -> 0x0078 }
        if (r3 != 0) goto L_0x0039;
    L_0x0034:
        monitor-exit(r6);	 Catch:{ all -> 0x0078 }
        r6.f();
        return r0;
    L_0x0039:
        r0 = r6.c;	 Catch:{ all -> 0x0078 }
        r3 = r0.size();	 Catch:{ all -> 0x0078 }
        r0 = r6.d;	 Catch:{ all -> 0x0078 }
        if (r0 == 0) goto L_0x0048;
    L_0x0043:
        r0 = r6.d;	 Catch:{ all -> 0x0078 }
        r0 = r0.length;	 Catch:{ all -> 0x0078 }
        if (r0 >= r3) goto L_0x004c;
    L_0x0048:
        r0 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x0078 }
        r6.d = r0;	 Catch:{ all -> 0x0078 }
    L_0x004c:
        r0 = r6.c;	 Catch:{ all -> 0x0078 }
        r4 = r6.d;	 Catch:{ all -> 0x0078 }
        r0.toArray(r4);	 Catch:{ all -> 0x0078 }
        r0 = r6.c;	 Catch:{ all -> 0x0078 }
        r0.clear();	 Catch:{ all -> 0x0078 }
        r0 = r6.o;	 Catch:{ all -> 0x0078 }
        r0 = r0.h();	 Catch:{ all -> 0x0078 }
        r4 = r6.z;	 Catch:{ all -> 0x0078 }
        r0.removeCallbacks(r4);	 Catch:{ all -> 0x0078 }
        monitor-exit(r6);	 Catch:{ all -> 0x0078 }
        r6.e = r2;
        r0 = r1;
    L_0x0067:
        if (r0 >= r3) goto L_0x007b;
    L_0x0069:
        r4 = r6.d;
        r4 = r4[r0];
        r4.run();
        r4 = r6.d;
        r5 = 0;
        r4[r0] = r5;
        r0 = r0 + 1;
        goto L_0x0067;
    L_0x0078:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0078 }
        throw r0;
    L_0x007b:
        r6.e = r1;
        r0 = r2;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.q.e():boolean");
    }

    void f() {
        if (this.w) {
            int i = 0;
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                k kVar = (k) this.f.get(i2);
                if (!(kVar == null || kVar.W == null)) {
                    i |= kVar.W.a();
                }
            }
            if (i == 0) {
                this.w = false;
                d();
            }
        }
    }

    void g() {
        if (this.m != null) {
            for (int i = 0; i < this.m.size(); i++) {
                ((android.support.v4.app.p.a) this.m.get(i)).a();
            }
        }
    }

    void b(d dVar) {
        if (this.i == null) {
            this.i = new ArrayList();
        }
        this.i.add(dVar);
        g();
    }

    boolean a(Handler handler, String str, int i, int i2) {
        if (this.i == null) {
            return false;
        }
        int size;
        d dVar;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.i.size() - 1;
            if (size < 0) {
                return false;
            }
            dVar = (d) this.i.remove(size);
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            if (this.n >= 1) {
                dVar.a(sparseArray, sparseArray2);
            }
            dVar.a(true, null, sparseArray, sparseArray2);
            g();
        } else {
            int size2;
            size = -1;
            if (str != null || i >= 0) {
                size2 = this.i.size() - 1;
                while (size2 >= 0) {
                    dVar = (d) this.i.get(size2);
                    if ((str != null && str.equals(dVar.c())) || (i >= 0 && i == dVar.p)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        dVar = (d) this.i.get(size2);
                        if ((str == null || !str.equals(dVar.c())) && (i < 0 || i != dVar.p)) {
                            break;
                        }
                        size2--;
                    }
                }
                size = size2;
            }
            if (size == this.i.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (size2 = this.i.size() - 1; size2 > size; size2--) {
                arrayList.add(this.i.remove(size2));
            }
            int size3 = arrayList.size() - 1;
            SparseArray sparseArray3 = new SparseArray();
            SparseArray sparseArray4 = new SparseArray();
            if (this.n >= 1) {
                for (size2 = 0; size2 <= size3; size2++) {
                    ((d) arrayList.get(size2)).a(sparseArray3, sparseArray4);
                }
            }
            android.support.v4.app.d.b bVar = null;
            int i3 = 0;
            while (i3 <= size3) {
                boolean z;
                if (a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i3));
                }
                dVar = (d) arrayList.get(i3);
                if (i3 == size3) {
                    z = true;
                } else {
                    z = false;
                }
                i3++;
                bVar = dVar.a(z, bVar, sparseArray3, sparseArray4);
            }
            g();
        }
        return true;
    }

    r h() {
        List list;
        List list2;
        if (this.f != null) {
            int i = 0;
            list = null;
            list2 = null;
            while (i < this.f.size()) {
                ArrayList arrayList;
                k kVar = (k) this.f.get(i);
                if (kVar != null) {
                    boolean z;
                    if (kVar.L) {
                        if (list2 == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(kVar);
                        kVar.M = true;
                        kVar.t = kVar.s != null ? kVar.s.p : -1;
                        if (a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + kVar);
                        }
                    }
                    if (kVar.D != null) {
                        r h = kVar.D.h();
                        if (h != null) {
                            ArrayList arrayList2;
                            if (list == null) {
                                arrayList2 = new ArrayList();
                                for (int i2 = 0; i2 < i; i2++) {
                                    arrayList2.add(null);
                                }
                            } else {
                                arrayList2 = list;
                            }
                            arrayList2.add(h);
                            list = arrayList2;
                            z = true;
                            if (!(list == null || r0)) {
                                list.add(null);
                            }
                        }
                    }
                    z = false;
                    list.add(null);
                }
                i++;
                Object obj = arrayList;
            }
        } else {
            list = null;
            list2 = null;
        }
        if (list2 == null && list == null) {
            return null;
        }
        return new r(list2, list);
    }

    void e(k kVar) {
        if (kVar.T != null) {
            if (this.y == null) {
                this.y = new SparseArray();
            } else {
                this.y.clear();
            }
            kVar.T.saveHierarchyState(this.y);
            if (this.y.size() > 0) {
                kVar.o = this.y;
                this.y = null;
            }
        }
    }

    Bundle f(k kVar) {
        Bundle bundle;
        if (this.x == null) {
            this.x = new Bundle();
        }
        kVar.k(this.x);
        if (this.x.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.x;
            this.x = null;
        }
        if (kVar.S != null) {
            e(kVar);
        }
        if (kVar.o != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", kVar.o);
        }
        if (!kVar.V) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", kVar.V);
        }
        return bundle;
    }

    Parcelable i() {
        BackStackState[] backStackStateArr = null;
        e();
        if (b) {
            this.t = true;
        }
        if (this.f == null || this.f.size() <= 0) {
            return null;
        }
        int size = this.f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            k kVar = (k) this.f.get(i);
            if (kVar != null) {
                if (kVar.p < 0) {
                    a(new IllegalStateException("Failure saving state: active " + kVar + " has cleared index: " + kVar.p));
                }
                FragmentState fragmentState = new FragmentState(kVar);
                fragmentStateArr[i] = fragmentState;
                if (kVar.k <= 0 || fragmentState.k != null) {
                    fragmentState.k = kVar.n;
                } else {
                    fragmentState.k = f(kVar);
                    if (kVar.s != null) {
                        if (kVar.s.p < 0) {
                            a(new IllegalStateException("Failure saving state: " + kVar + " has target not in fragment manager: " + kVar.s));
                        }
                        if (fragmentState.k == null) {
                            fragmentState.k = new Bundle();
                        }
                        a(fragmentState.k, "android:target_state", kVar.s);
                        if (kVar.u != 0) {
                            fragmentState.k.putInt("android:target_req_state", kVar.u);
                        }
                    }
                }
                if (a) {
                    Log.v("FragmentManager", "Saved state of " + kVar + ": " + fragmentState.k);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            FragmentManagerState fragmentManagerState;
            if (this.g != null) {
                i = this.g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((k) this.g.get(i2)).p;
                        if (iArr[i2] < 0) {
                            a(new IllegalStateException("Failure saving state: active " + this.g.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.g.get(i2));
                        }
                    }
                    if (this.i != null) {
                        i = this.i.size();
                        if (i > 0) {
                            backStackStateArr = new BackStackState[i];
                            for (i2 = 0; i2 < i; i2++) {
                                backStackStateArr[i2] = new BackStackState((d) this.i.get(i2));
                                if (a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.i.get(i2));
                                }
                            }
                        }
                    }
                    fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.a = fragmentStateArr;
                    fragmentManagerState.b = iArr;
                    fragmentManagerState.c = backStackStateArr;
                    return fragmentManagerState;
                }
            }
            iArr = null;
            if (this.i != null) {
                i = this.i.size();
                if (i > 0) {
                    backStackStateArr = new BackStackState[i];
                    for (i2 = 0; i2 < i; i2++) {
                        backStackStateArr[i2] = new BackStackState((d) this.i.get(i2));
                        if (a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.i.get(i2));
                        }
                    }
                }
            }
            fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.a = fragmentStateArr;
            fragmentManagerState.b = iArr;
            fragmentManagerState.c = backStackStateArr;
            return fragmentManagerState;
        } else if (!a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    void a(Parcelable parcelable, r rVar) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.a != null) {
                List a;
                int size;
                int i;
                k kVar;
                List list;
                if (rVar != null) {
                    a = rVar.a();
                    List b = rVar.b();
                    if (a != null) {
                        size = a.size();
                    } else {
                        boolean z = false;
                    }
                    for (i = 0; i < size; i++) {
                        kVar = (k) a.get(i);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + kVar);
                        }
                        FragmentState fragmentState = fragmentManagerState.a[kVar.p];
                        fragmentState.l = kVar;
                        kVar.o = null;
                        kVar.A = 0;
                        kVar.y = false;
                        kVar.v = false;
                        kVar.s = null;
                        if (fragmentState.k != null) {
                            fragmentState.k.setClassLoader(this.o.g().getClassLoader());
                            kVar.o = fragmentState.k.getSparseParcelableArray("android:view_state");
                            kVar.n = fragmentState.k;
                        }
                    }
                    list = b;
                } else {
                    list = null;
                }
                this.f = new ArrayList(fragmentManagerState.a.length);
                if (this.h != null) {
                    this.h.clear();
                }
                int i2 = 0;
                while (i2 < fragmentManagerState.a.length) {
                    FragmentState fragmentState2 = fragmentManagerState.a[i2];
                    if (fragmentState2 != null) {
                        r rVar2;
                        if (list == null || i2 >= list.size()) {
                            rVar2 = null;
                        } else {
                            rVar2 = (r) list.get(i2);
                        }
                        kVar = fragmentState2.a(this.o, this.q, rVar2);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + kVar);
                        }
                        this.f.add(kVar);
                        fragmentState2.l = null;
                    } else {
                        this.f.add(null);
                        if (this.h == null) {
                            this.h = new ArrayList();
                        }
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.h.add(Integer.valueOf(i2));
                    }
                    i2++;
                }
                if (rVar != null) {
                    a = rVar.a();
                    if (a != null) {
                        i2 = a.size();
                    } else {
                        boolean z2 = false;
                    }
                    for (i = 0; i < i2; i++) {
                        kVar = (k) a.get(i);
                        if (kVar.t >= 0) {
                            if (kVar.t < this.f.size()) {
                                kVar.s = (k) this.f.get(kVar.t);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + kVar + " target no longer exists: " + kVar.t);
                                kVar.s = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.b != null) {
                    this.g = new ArrayList(fragmentManagerState.b.length);
                    for (size = 0; size < fragmentManagerState.b.length; size++) {
                        kVar = (k) this.f.get(fragmentManagerState.b[size]);
                        if (kVar == null) {
                            a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.b[size]));
                        }
                        kVar.v = true;
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + size + ": " + kVar);
                        }
                        if (this.g.contains(kVar)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.g.add(kVar);
                    }
                } else {
                    this.g = null;
                }
                if (fragmentManagerState.c != null) {
                    this.i = new ArrayList(fragmentManagerState.c.length);
                    for (int i3 = 0; i3 < fragmentManagerState.c.length; i3++) {
                        d a2 = fragmentManagerState.c[i3].a(this);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i3 + " (index " + a2.p + "): " + a2);
                            a2.a("  ", new PrintWriter(new d("FragmentManager")), false);
                        }
                        this.i.add(a2);
                        if (a2.p >= 0) {
                            a(a2.p, a2);
                        }
                    }
                    return;
                }
                this.i = null;
            }
        }
    }

    public void a(o oVar, m mVar, k kVar) {
        if (this.o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.o = oVar;
        this.p = mVar;
        this.q = kVar;
    }

    public void j() {
        this.t = false;
    }

    public void k() {
        this.t = false;
        a(1, false);
    }

    public void l() {
        this.t = false;
        a(2, false);
    }

    public void m() {
        this.t = false;
        a(4, false);
    }

    public void n() {
        this.t = false;
        a(5, false);
    }

    public void o() {
        a(4, false);
    }

    public void p() {
        this.t = true;
        a(3, false);
    }

    public void q() {
        a(2, false);
    }

    public void r() {
        a(1, false);
    }

    public void s() {
        this.u = true;
        e();
        a(0, false);
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public void a(boolean z) {
        if (this.g != null) {
            for (int size = this.g.size() - 1; size >= 0; size--) {
                k kVar = (k) this.g.get(size);
                if (kVar != null) {
                    kVar.f(z);
                }
            }
        }
    }

    public void b(boolean z) {
        if (this.g != null) {
            for (int size = this.g.size() - 1; size >= 0; size--) {
                k kVar = (k) this.g.get(size);
                if (kVar != null) {
                    kVar.g(z);
                }
            }
        }
    }

    public void a(Configuration configuration) {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                k kVar = (k) this.g.get(i);
                if (kVar != null) {
                    kVar.a(configuration);
                }
            }
        }
    }

    public void t() {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                k kVar = (k) this.g.get(i);
                if (kVar != null) {
                    kVar.E();
                }
            }
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        k kVar;
        int i = 0;
        ArrayList arrayList = null;
        if (this.g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.g.size()) {
                kVar = (k) this.g.get(i2);
                if (kVar != null && kVar.b(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(kVar);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.j != null) {
            while (i < this.j.size()) {
                kVar = (k) this.j.get(i);
                if (arrayList == null || !arrayList.contains(kVar)) {
                    kVar.s();
                }
                i++;
            }
        }
        this.j = arrayList;
        return z;
    }

    public boolean a(Menu menu) {
        if (this.g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.g.size(); i++) {
            k kVar = (k) this.g.get(i);
            if (kVar != null && kVar.c(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean a(MenuItem menuItem) {
        if (this.g == null) {
            return false;
        }
        for (int i = 0; i < this.g.size(); i++) {
            k kVar = (k) this.g.get(i);
            if (kVar != null && kVar.c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean b(MenuItem menuItem) {
        if (this.g == null) {
            return false;
        }
        for (int i = 0; i < this.g.size(); i++) {
            k kVar = (k) this.g.get(i);
            if (kVar != null && kVar.d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void b(Menu menu) {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                k kVar = (k) this.g.get(i);
                if (kVar != null) {
                    kVar.d(menu);
                }
            }
        }
    }

    public static int d(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public static int b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String string;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.a);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!k.b(this.o.g(), string)) {
            return null;
        }
        int id;
        if (view != null) {
            id = view.getId();
        } else {
            id = 0;
        }
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        k kVar;
        k b = resourceId != -1 ? b(resourceId) : null;
        if (b == null && string2 != null) {
            b = a(string2);
        }
        if (b == null && id != -1) {
            b = b(id);
        }
        if (a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + b);
        }
        if (b == null) {
            k a = k.a(context, string);
            a.x = true;
            a.G = resourceId != 0 ? resourceId : id;
            a.H = id;
            a.I = string2;
            a.y = true;
            a.B = this;
            a.C = this.o;
            a.a(this.o.g(), attributeSet, a.n);
            a(a, true);
            kVar = a;
        } else if (b.y) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            b.y = true;
            b.C = this.o;
            if (!b.M) {
                b.a(this.o.g(), attributeSet, b.n);
            }
            kVar = b;
        }
        if (this.n >= 1 || !kVar.x) {
            b(kVar);
        } else {
            a(kVar, 1, 0, 0, false);
        }
        if (kVar.S == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            kVar.S.setId(resourceId);
        }
        if (kVar.S.getTag() == null) {
            kVar.S.setTag(string2);
        }
        return kVar.S;
    }

    n u() {
        return this;
    }
}
