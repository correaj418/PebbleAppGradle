package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.e.c;
import android.support.v4.e.i;
import android.support.v4.view.j;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class k implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final i<String, Class<?>> a = new i();
    static final Object j = new Object();
    int A;
    q B;
    o C;
    q D;
    r E;
    k F;
    int G;
    int H;
    String I;
    boolean J;
    boolean K;
    boolean L;
    boolean M;
    boolean N;
    boolean O = true;
    boolean P;
    int Q;
    ViewGroup R;
    View S;
    View T;
    boolean U;
    boolean V = true;
    w W;
    boolean X;
    boolean Y;
    Object Z = null;
    Object aa = j;
    Object ab = null;
    Object ac = j;
    Object ad = null;
    Object ae = j;
    Boolean af;
    Boolean ag;
    av ah = null;
    av ai = null;
    int k = 0;
    View l;
    int m;
    Bundle n;
    SparseArray<Parcelable> o;
    int p = -1;
    String q;
    Bundle r;
    k s;
    int t = -1;
    int u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    boolean z;

    public static class a extends RuntimeException {
        public a(String str, Exception exception) {
            super(str, exception);
        }
    }

    public static k a(Context context, String str) {
        return a(context, str, null);
    }

    public static k a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                a.put(str, cls);
            }
            k kVar = (k) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(kVar.getClass().getClassLoader());
                kVar.r = bundle;
            }
            return kVar;
        } catch (Exception e) {
            throw new a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        }
    }

    static boolean b(Context context, String str) {
        try {
            Class cls = (Class) a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                a.put(str, cls);
            }
            return k.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    final void f(Bundle bundle) {
        if (this.o != null) {
            this.T.restoreHierarchyState(this.o);
            this.o = null;
        }
        this.P = false;
        h(bundle);
        if (!this.P) {
            throw new aw("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    final void a(int i, k kVar) {
        this.p = i;
        if (kVar != null) {
            this.q = kVar.q + ":" + this.p;
        } else {
            this.q = "android:fragment:" + this.p;
        }
    }

    final boolean f() {
        return this.A > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        c.a(this, stringBuilder);
        if (this.p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.p);
        }
        if (this.G != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.G));
        }
        if (this.I != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.I);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final l g() {
        return this.C == null ? null : (l) this.C.f();
    }

    public final Resources h() {
        if (this.C != null) {
            return this.C.g().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final p i() {
        return this.B;
    }

    public final p j() {
        if (this.D == null) {
            B();
            if (this.k >= 5) {
                this.D.n();
            } else if (this.k >= 4) {
                this.D.m();
            } else if (this.k >= 2) {
                this.D.l();
            } else if (this.k >= 1) {
                this.D.k();
            }
        }
        return this.D;
    }

    public final boolean k() {
        return this.C != null && this.v;
    }

    public final boolean l() {
        return this.w;
    }

    public final boolean m() {
        return this.J;
    }

    public void c(boolean z) {
    }

    public void startActivityForResult(Intent intent, int i) {
        a(intent, i, null);
    }

    public void a(Intent intent, int i, Bundle bundle) {
        if (this.C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.C.a(this, intent, i, bundle);
    }

    public void a(int i, int i2, Intent intent) {
    }

    public void a(int i, String[] strArr, int[] iArr) {
    }

    public LayoutInflater b(Bundle bundle) {
        LayoutInflater b = this.C.b();
        j();
        j.a(b, this.D.u());
        return b;
    }

    public void a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.P = true;
        Activity f = this.C == null ? null : this.C.f();
        if (f != null) {
            this.P = false;
            a(f, attributeSet, bundle);
        }
    }

    @Deprecated
    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.P = true;
    }

    public void a(k kVar) {
    }

    public void a(Context context) {
        this.P = true;
        Activity f = this.C == null ? null : this.C.f();
        if (f != null) {
            this.P = false;
            a(f);
        }
    }

    @Deprecated
    public void a(Activity activity) {
        this.P = true;
    }

    public Animation a(int i, boolean z, int i2) {
        return null;
    }

    public void a(Bundle bundle) {
        this.P = true;
        g(bundle);
        if (this.D != null && !this.D.a(1)) {
            this.D.k();
        }
    }

    void g(Bundle bundle) {
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.D == null) {
                    B();
                }
                this.D.a(parcelable, this.E);
                this.E = null;
                this.D.k();
            }
        }
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void a(View view, Bundle bundle) {
    }

    public View n() {
        return this.S;
    }

    public void d(Bundle bundle) {
        this.P = true;
    }

    public void h(Bundle bundle) {
        this.P = true;
    }

    public void c() {
        this.P = true;
        if (!this.X) {
            this.X = true;
            if (!this.Y) {
                this.Y = true;
                this.W = this.C.a(this.q, this.X, false);
            }
            if (this.W != null) {
                this.W.b();
            }
        }
    }

    public void o() {
        this.P = true;
    }

    public void e(Bundle bundle) {
    }

    public void d(boolean z) {
    }

    public void e(boolean z) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.P = true;
    }

    public void p() {
        this.P = true;
    }

    public void d() {
        this.P = true;
    }

    public void onLowMemory() {
        this.P = true;
    }

    public void e() {
        this.P = true;
    }

    public void q() {
        this.P = true;
        if (!this.Y) {
            this.Y = true;
            this.W = this.C.a(this.q, this.X, false);
        }
        if (this.W != null) {
            this.W.h();
        }
    }

    void r() {
        this.p = -1;
        this.q = null;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = 0;
        this.B = null;
        this.D = null;
        this.C = null;
        this.G = 0;
        this.H = 0;
        this.I = null;
        this.J = false;
        this.K = false;
        this.M = false;
        this.W = null;
        this.X = false;
        this.Y = false;
    }

    public void b() {
        this.P = true;
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    public void a(Menu menu) {
    }

    public void s() {
    }

    public boolean a(MenuItem menuItem) {
        return false;
    }

    public void b(Menu menu) {
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        g().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    public Object t() {
        return this.Z;
    }

    public Object u() {
        return this.aa == j ? t() : this.aa;
    }

    public Object v() {
        return this.ab;
    }

    public Object w() {
        return this.ac == j ? v() : this.ac;
    }

    public Object x() {
        return this.ad;
    }

    public Object y() {
        return this.ae == j ? x() : this.ae;
    }

    public boolean z() {
        return this.ag == null ? true : this.ag.booleanValue();
    }

    public boolean A() {
        return this.af == null ? true : this.af.booleanValue();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.G));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.H));
        printWriter.print(" mTag=");
        printWriter.println(this.I);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.k);
        printWriter.print(" mIndex=");
        printWriter.print(this.p);
        printWriter.print(" mWho=");
        printWriter.print(this.q);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.A);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.v);
        printWriter.print(" mRemoving=");
        printWriter.print(this.w);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.x);
        printWriter.print(" mInLayout=");
        printWriter.println(this.y);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.J);
        printWriter.print(" mDetached=");
        printWriter.print(this.K);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.O);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.N);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.L);
        printWriter.print(" mRetaining=");
        printWriter.print(this.M);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.V);
        if (this.B != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.B);
        }
        if (this.C != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.C);
        }
        if (this.F != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.F);
        }
        if (this.r != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.r);
        }
        if (this.n != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.n);
        }
        if (this.o != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.o);
        }
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.s);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.u);
        }
        if (this.Q != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.Q);
        }
        if (this.R != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.R);
        }
        if (this.S != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.S);
        }
        if (this.T != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.S);
        }
        if (this.l != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.m);
        }
        if (this.W != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.W.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.D != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.D + ":");
            this.D.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    k a(String str) {
        if (str.equals(this.q)) {
            return this;
        }
        if (this.D != null) {
            return this.D.b(str);
        }
        return null;
    }

    void B() {
        this.D = new q();
        this.D.a(this.C, new m(this) {
            final /* synthetic */ k a;

            {
                this.a = r1;
            }

            public View a(int i) {
                if (this.a.S != null) {
                    return this.a.S.findViewById(i);
                }
                throw new IllegalStateException("Fragment does not have a view");
            }

            public boolean a() {
                return this.a.S != null;
            }
        }, this);
    }

    void i(Bundle bundle) {
        if (this.D != null) {
            this.D.j();
        }
        this.k = 1;
        this.P = false;
        a(bundle);
        if (!this.P) {
            throw new aw("Fragment " + this + " did not call through to super.onCreate()");
        }
    }

    View b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.D != null) {
            this.D.j();
        }
        return a(layoutInflater, viewGroup, bundle);
    }

    void j(Bundle bundle) {
        if (this.D != null) {
            this.D.j();
        }
        this.k = 2;
        this.P = false;
        d(bundle);
        if (!this.P) {
            throw new aw("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.D != null) {
            this.D.l();
        }
    }

    void C() {
        if (this.D != null) {
            this.D.j();
            this.D.e();
        }
        this.k = 4;
        this.P = false;
        c();
        if (this.P) {
            if (this.D != null) {
                this.D.m();
            }
            if (this.W != null) {
                this.W.g();
                return;
            }
            return;
        }
        throw new aw("Fragment " + this + " did not call through to super.onStart()");
    }

    void D() {
        if (this.D != null) {
            this.D.j();
            this.D.e();
        }
        this.k = 5;
        this.P = false;
        o();
        if (!this.P) {
            throw new aw("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.D != null) {
            this.D.n();
            this.D.e();
        }
    }

    void f(boolean z) {
        d(z);
        if (this.D != null) {
            this.D.a(z);
        }
    }

    void g(boolean z) {
        e(z);
        if (this.D != null) {
            this.D.b(z);
        }
    }

    void a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.D != null) {
            this.D.a(configuration);
        }
    }

    void E() {
        onLowMemory();
        if (this.D != null) {
            this.D.t();
        }
    }

    boolean b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.J) {
            return false;
        }
        if (this.N && this.O) {
            z = true;
            a(menu, menuInflater);
        }
        if (this.D != null) {
            return z | this.D.a(menu, menuInflater);
        }
        return z;
    }

    boolean c(Menu menu) {
        boolean z = false;
        if (this.J) {
            return false;
        }
        if (this.N && this.O) {
            z = true;
            a(menu);
        }
        if (this.D != null) {
            return z | this.D.a(menu);
        }
        return z;
    }

    boolean c(MenuItem menuItem) {
        if (!this.J) {
            if (this.N && this.O && a(menuItem)) {
                return true;
            }
            if (this.D != null && this.D.a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean d(MenuItem menuItem) {
        if (!this.J) {
            if (b(menuItem)) {
                return true;
            }
            if (this.D != null && this.D.b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void d(Menu menu) {
        if (!this.J) {
            if (this.N && this.O) {
                b(menu);
            }
            if (this.D != null) {
                this.D.b(menu);
            }
        }
    }

    void k(Bundle bundle) {
        e(bundle);
        if (this.D != null) {
            Parcelable i = this.D.i();
            if (i != null) {
                bundle.putParcelable("android:support:fragments", i);
            }
        }
    }

    void F() {
        if (this.D != null) {
            this.D.o();
        }
        this.k = 4;
        this.P = false;
        p();
        if (!this.P) {
            throw new aw("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void G() {
        if (this.D != null) {
            this.D.p();
        }
        this.k = 3;
        this.P = false;
        d();
        if (!this.P) {
            throw new aw("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void H() {
        if (this.D != null) {
            this.D.q();
        }
        this.k = 2;
        if (this.X) {
            this.X = false;
            if (!this.Y) {
                this.Y = true;
                this.W = this.C.a(this.q, this.X, false);
            }
            if (this.W == null) {
                return;
            }
            if (this.C.j()) {
                this.W.d();
            } else {
                this.W.c();
            }
        }
    }

    void I() {
        if (this.D != null) {
            this.D.r();
        }
        this.k = 1;
        this.P = false;
        e();
        if (!this.P) {
            throw new aw("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.W != null) {
            this.W.f();
        }
    }

    void J() {
        if (this.D != null) {
            this.D.s();
        }
        this.k = 0;
        this.P = false;
        q();
        if (this.P) {
            this.D = null;
            return;
        }
        throw new aw("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void K() {
        this.P = false;
        b();
        if (!this.P) {
            throw new aw("Fragment " + this + " did not call through to super.onDetach()");
        } else if (this.D == null) {
        } else {
            if (this.M) {
                this.D.s();
                this.D = null;
                return;
            }
            throw new IllegalStateException("Child FragmentManager of " + this + " was not " + " destroyed and this fragment is not retaining instance");
        }
    }
}
