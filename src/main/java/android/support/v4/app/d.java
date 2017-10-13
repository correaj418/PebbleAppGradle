package android.support.v4.app;

import android.os.Build.VERSION;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

final class d extends s implements Runnable {
    static final boolean a = (VERSION.SDK_INT >= 21);
    final q b;
    a c;
    a d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    int k;
    boolean l;
    boolean m = true;
    String n;
    boolean o;
    int p = -1;
    int q;
    CharSequence r;
    int s;
    CharSequence t;
    ArrayList<String> u;
    ArrayList<String> v;

    static final class a {
        a a;
        a b;
        int c;
        k d;
        int e;
        int f;
        int g;
        int h;
        ArrayList<k> i;

        a() {
        }
    }

    public class b {
        public android.support.v4.e.a<String, String> a = new android.support.v4.e.a();
        public ArrayList<View> b = new ArrayList();
        public android.support.v4.app.t.a c = new android.support.v4.app.t.a();
        public View d;
        final /* synthetic */ d e;

        public b(d dVar) {
            this.e = dVar;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.p);
        }
        if (this.n != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.n);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.n);
            printWriter.print(" mIndex=");
            printWriter.print(this.p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.o);
            if (this.j != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.k));
            }
            if (!(this.f == 0 && this.g == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.g));
            }
            if (!(this.h == 0 && this.i == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.i));
            }
            if (!(this.q == 0 && this.r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.r);
            }
            if (!(this.s == 0 && this.t == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.t);
            }
        }
        if (this.c != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            a aVar = this.c;
            while (aVar != null) {
                String str3;
                switch (aVar.c) {
                    case 0:
                        str3 = "NULL";
                        break;
                    case 1:
                        str3 = "ADD";
                        break;
                    case 2:
                        str3 = "REPLACE";
                        break;
                    case 3:
                        str3 = "REMOVE";
                        break;
                    case 4:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + aVar.c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(aVar.d);
                if (z) {
                    if (!(aVar.e == 0 && aVar.f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f));
                    }
                    if (!(aVar.g == 0 && aVar.h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.h));
                    }
                }
                if (aVar.i != null && aVar.i.size() > 0) {
                    for (int i2 = 0; i2 < aVar.i.size(); i2++) {
                        printWriter.print(str2);
                        if (aVar.i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(aVar.i.get(i2));
                    }
                }
                aVar = aVar.a;
                i++;
            }
        }
    }

    public d(q qVar) {
        this.b = qVar;
    }

    void a(a aVar) {
        if (this.c == null) {
            this.d = aVar;
            this.c = aVar;
        } else {
            aVar.b = this.d;
            this.d.a = aVar;
            this.d = aVar;
        }
        aVar.e = this.f;
        aVar.f = this.g;
        aVar.g = this.h;
        aVar.h = this.i;
        this.e++;
    }

    public s a(k kVar, String str) {
        a(0, kVar, str, 1);
        return this;
    }

    private void a(int i, k kVar, String str, int i2) {
        kVar.B = this.b;
        if (str != null) {
            if (kVar.I == null || str.equals(kVar.I)) {
                kVar.I = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + kVar + ": was " + kVar.I + " now " + str);
            }
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + kVar + " with tag " + str + " to container view with no id");
            } else if (kVar.G == 0 || kVar.G == i) {
                kVar.G = i;
                kVar.H = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + kVar + ": was " + kVar.G + " now " + i);
            }
        }
        a aVar = new a();
        aVar.c = i2;
        aVar.d = kVar;
        a(aVar);
    }

    public s a(k kVar) {
        a aVar = new a();
        aVar.c = 3;
        aVar.d = kVar;
        a(aVar);
        return this;
    }

    void a(int i) {
        if (this.l) {
            if (q.a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (a aVar = this.c; aVar != null; aVar = aVar.a) {
                k kVar;
                if (aVar.d != null) {
                    kVar = aVar.d;
                    kVar.A += i;
                    if (q.a) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.d + " to " + aVar.d.A);
                    }
                }
                if (aVar.i != null) {
                    for (int size = aVar.i.size() - 1; size >= 0; size--) {
                        kVar = (k) aVar.i.get(size);
                        kVar.A += i;
                        if (q.a) {
                            Log.v("FragmentManager", "Bump nesting of " + kVar + " to " + kVar.A);
                        }
                    }
                }
            }
        }
    }

    public int a() {
        return a(false);
    }

    public int b() {
        return a(true);
    }

    int a(boolean z) {
        if (this.o) {
            throw new IllegalStateException("commit already called");
        }
        if (q.a) {
            Log.v("FragmentManager", "Commit: " + this);
            a("  ", null, new PrintWriter(new android.support.v4.e.d("FragmentManager")), null);
        }
        this.o = true;
        if (this.l) {
            this.p = this.b.a(this);
        } else {
            this.p = -1;
        }
        this.b.a((Runnable) this, z);
        return this.p;
    }

    public void run() {
        if (q.a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.l || this.p >= 0) {
            b bVar;
            a(1);
            if (!a || this.b.n < 1) {
                bVar = null;
            } else {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                b(sparseArray, sparseArray2);
                bVar = a(sparseArray, sparseArray2, false);
            }
            int i = bVar != null ? 0 : this.k;
            int i2 = bVar != null ? 0 : this.j;
            a aVar = this.c;
            while (aVar != null) {
                int i3 = bVar != null ? 0 : aVar.e;
                int i4 = bVar != null ? 0 : aVar.f;
                k kVar;
                switch (aVar.c) {
                    case 1:
                        kVar = aVar.d;
                        kVar.Q = i3;
                        this.b.a(kVar, false);
                        break;
                    case 2:
                        k kVar2 = aVar.d;
                        int i5 = kVar2.H;
                        if (this.b.g != null) {
                            int size = this.b.g.size() - 1;
                            while (size >= 0) {
                                kVar = (k) this.b.g.get(size);
                                if (q.a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + kVar2 + " old=" + kVar);
                                }
                                if (kVar.H == i5) {
                                    if (kVar == kVar2) {
                                        kVar = null;
                                        aVar.d = null;
                                        size--;
                                        kVar2 = kVar;
                                    } else {
                                        if (aVar.i == null) {
                                            aVar.i = new ArrayList();
                                        }
                                        aVar.i.add(kVar);
                                        kVar.Q = i4;
                                        if (this.l) {
                                            kVar.A++;
                                            if (q.a) {
                                                Log.v("FragmentManager", "Bump nesting of " + kVar + " to " + kVar.A);
                                            }
                                        }
                                        this.b.a(kVar, i2, i);
                                    }
                                }
                                kVar = kVar2;
                                size--;
                                kVar2 = kVar;
                            }
                        }
                        if (kVar2 == null) {
                            break;
                        }
                        kVar2.Q = i3;
                        this.b.a(kVar2, false);
                        break;
                    case 3:
                        kVar = aVar.d;
                        kVar.Q = i4;
                        this.b.a(kVar, i2, i);
                        break;
                    case 4:
                        kVar = aVar.d;
                        kVar.Q = i4;
                        this.b.b(kVar, i2, i);
                        break;
                    case 5:
                        kVar = aVar.d;
                        kVar.Q = i3;
                        this.b.c(kVar, i2, i);
                        break;
                    case 6:
                        kVar = aVar.d;
                        kVar.Q = i4;
                        this.b.d(kVar, i2, i);
                        break;
                    case 7:
                        kVar = aVar.d;
                        kVar.Q = i3;
                        this.b.e(kVar, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.c);
                }
                aVar = aVar.a;
            }
            this.b.a(this.b.n, i2, i, true);
            if (this.l) {
                this.b.b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    private static void a(SparseArray<k> sparseArray, SparseArray<k> sparseArray2, k kVar) {
        if (kVar != null) {
            int i = kVar.H;
            if (i != 0 && !kVar.m()) {
                if (kVar.k() && kVar.n() != null && sparseArray.get(i) == null) {
                    sparseArray.put(i, kVar);
                }
                if (sparseArray2.get(i) == kVar) {
                    sparseArray2.remove(i);
                }
            }
        }
    }

    private void b(SparseArray<k> sparseArray, SparseArray<k> sparseArray2, k kVar) {
        if (kVar != null) {
            int i = kVar.H;
            if (i != 0) {
                if (!kVar.k()) {
                    sparseArray2.put(i, kVar);
                }
                if (sparseArray.get(i) == kVar) {
                    sparseArray.remove(i);
                }
            }
            if (kVar.k < 1 && this.b.n >= 1) {
                this.b.c(kVar);
                this.b.a(kVar, 1, 0, 0, false);
            }
        }
    }

    private void b(SparseArray<k> sparseArray, SparseArray<k> sparseArray2) {
        if (this.b.p.a()) {
            for (a aVar = this.c; aVar != null; aVar = aVar.a) {
                switch (aVar.c) {
                    case 1:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.d);
                        break;
                    case 2:
                        k kVar = aVar.d;
                        if (this.b.g != null) {
                            k kVar2 = kVar;
                            for (int i = 0; i < this.b.g.size(); i++) {
                                k kVar3 = (k) this.b.g.get(i);
                                if (kVar2 == null || kVar3.H == kVar2.H) {
                                    if (kVar3 == kVar2) {
                                        kVar2 = null;
                                        sparseArray2.remove(kVar3.H);
                                    } else {
                                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, kVar3);
                                    }
                                }
                            }
                        }
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.d);
                        break;
                    case 3:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.d);
                        break;
                    case 4:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.d);
                        break;
                    case 5:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.d);
                        break;
                    case 6:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.d);
                        break;
                    case 7:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void a(SparseArray<k> sparseArray, SparseArray<k> sparseArray2) {
        if (this.b.p.a()) {
            for (a aVar = this.d; aVar != null; aVar = aVar.b) {
                switch (aVar.c) {
                    case 1:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.d);
                        break;
                    case 2:
                        if (aVar.i != null) {
                            for (int size = aVar.i.size() - 1; size >= 0; size--) {
                                b((SparseArray) sparseArray, (SparseArray) sparseArray2, (k) aVar.i.get(size));
                            }
                        }
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.d);
                        break;
                    case 3:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.d);
                        break;
                    case 4:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.d);
                        break;
                    case 5:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.d);
                        break;
                    case 6:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.d);
                        break;
                    case 7:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public b a(boolean z, b bVar, SparseArray<k> sparseArray, SparseArray<k> sparseArray2) {
        if (q.a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            a("  ", null, new PrintWriter(new android.support.v4.e.d("FragmentManager")), null);
        }
        if (a && this.b.n >= 1) {
            if (bVar == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    bVar = a((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
                }
            } else if (!z) {
                a(bVar, this.v, this.u);
            }
        }
        a(-1);
        int i = bVar != null ? 0 : this.k;
        int i2 = bVar != null ? 0 : this.j;
        a aVar = this.d;
        while (aVar != null) {
            int i3 = bVar != null ? 0 : aVar.g;
            int i4 = bVar != null ? 0 : aVar.h;
            k kVar;
            k kVar2;
            switch (aVar.c) {
                case 1:
                    kVar = aVar.d;
                    kVar.Q = i4;
                    this.b.a(kVar, q.d(i2), i);
                    break;
                case 2:
                    kVar = aVar.d;
                    if (kVar != null) {
                        kVar.Q = i4;
                        this.b.a(kVar, q.d(i2), i);
                    }
                    if (aVar.i == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < aVar.i.size(); i5++) {
                        kVar2 = (k) aVar.i.get(i5);
                        kVar2.Q = i3;
                        this.b.a(kVar2, false);
                    }
                    break;
                case 3:
                    kVar2 = aVar.d;
                    kVar2.Q = i3;
                    this.b.a(kVar2, false);
                    break;
                case 4:
                    kVar2 = aVar.d;
                    kVar2.Q = i3;
                    this.b.c(kVar2, q.d(i2), i);
                    break;
                case 5:
                    kVar = aVar.d;
                    kVar.Q = i4;
                    this.b.b(kVar, q.d(i2), i);
                    break;
                case 6:
                    kVar2 = aVar.d;
                    kVar2.Q = i3;
                    this.b.e(kVar2, q.d(i2), i);
                    break;
                case 7:
                    kVar2 = aVar.d;
                    kVar2.Q = i3;
                    this.b.d(kVar2, q.d(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.c);
            }
            aVar = aVar.b;
        }
        if (z) {
            this.b.a(this.b.n, q.d(i2), i, true);
            bVar = null;
        }
        if (this.p >= 0) {
            this.b.c(this.p);
            this.p = -1;
        }
        return bVar;
    }

    public String c() {
        return this.n;
    }

    private b a(SparseArray<k> sparseArray, SparseArray<k> sparseArray2, boolean z) {
        int i;
        int i2 = 0;
        b bVar = new b(this);
        bVar.d = new View(this.b.o.g());
        int i3 = 0;
        int i4 = 0;
        while (i3 < sparseArray.size()) {
            if (a(sparseArray.keyAt(i3), bVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i = 1;
            } else {
                i = i4;
            }
            i3++;
            i4 = i;
        }
        while (i2 < sparseArray2.size()) {
            i = sparseArray2.keyAt(i2);
            if (sparseArray.get(i) == null && a(i, bVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i4 = 1;
            }
            i2++;
        }
        if (i4 == 0) {
            return null;
        }
        return bVar;
    }

    private static Object a(k kVar, boolean z) {
        if (kVar == null) {
            return null;
        }
        return t.a(z ? kVar.w() : kVar.t());
    }

    private static Object b(k kVar, boolean z) {
        if (kVar == null) {
            return null;
        }
        return t.a(z ? kVar.u() : kVar.v());
    }

    private static Object a(k kVar, k kVar2, boolean z) {
        if (kVar == null || kVar2 == null) {
            return null;
        }
        Object y;
        if (z) {
            y = kVar2.y();
        } else {
            y = kVar.x();
        }
        return t.b(y);
    }

    private static Object a(Object obj, k kVar, ArrayList<View> arrayList, android.support.v4.e.a<String, View> aVar, View view) {
        if (obj != null) {
            return t.a(obj, kVar.n(), (ArrayList) arrayList, (Map) aVar, view);
        }
        return obj;
    }

    private android.support.v4.e.a<String, View> a(b bVar, k kVar, boolean z) {
        android.support.v4.e.a aVar = new android.support.v4.e.a();
        if (this.u != null) {
            t.a((Map) aVar, kVar.n());
            if (z) {
                aVar.a(this.v);
            } else {
                aVar = a(this.u, this.v, aVar);
            }
        }
        if (z) {
            if (kVar.ah != null) {
                kVar.ah.a(this.v, aVar);
            }
            a(bVar, aVar, false);
        } else {
            if (kVar.ai != null) {
                kVar.ai.a(this.v, aVar);
            }
            b(bVar, aVar, false);
        }
        return aVar;
    }

    private boolean a(int i, b bVar, boolean z, SparseArray<k> sparseArray, SparseArray<k> sparseArray2) {
        View view = (ViewGroup) this.b.p.a(i);
        if (view == null) {
            return false;
        }
        Object obj;
        ArrayList arrayList;
        Object a;
        View view2;
        android.support.v4.app.t.b anonymousClass1;
        ArrayList arrayList2;
        Map aVar;
        boolean z2;
        Object a2;
        final k kVar = (k) sparseArray2.get(i);
        k kVar2 = (k) sparseArray.get(i);
        Object a3 = a(kVar, z);
        Object a4 = a(kVar, kVar2, z);
        Object b = b(kVar2, z);
        Map map = null;
        ArrayList arrayList3 = new ArrayList();
        if (a4 != null) {
            map = a(bVar, kVar2, z);
            if (map.isEmpty()) {
                map = null;
                obj = null;
                if (a3 != null && obj == null && b == null) {
                    return false;
                }
                arrayList = new ArrayList();
                a = a(b, kVar2, arrayList, (android.support.v4.e.a) map, bVar.d);
                if (!(this.v == null || map == null)) {
                    view2 = (View) map.get(this.v.get(0));
                    if (view2 != null) {
                        if (a != null) {
                            t.a(a, view2);
                        }
                        if (obj != null) {
                            t.a(obj, view2);
                        }
                    }
                }
                anonymousClass1 = new android.support.v4.app.t.b(this) {
                    final /* synthetic */ d b;

                    public View a() {
                        return kVar.n();
                    }
                };
                arrayList2 = new ArrayList();
                aVar = new android.support.v4.e.a();
                z2 = true;
                if (kVar != null) {
                    if (z) {
                        z2 = kVar.z();
                    } else {
                        z2 = kVar.A();
                    }
                }
                a2 = t.a(a3, a, obj, z2);
                if (a2 != null) {
                    t.a(a3, obj, a, view, anonymousClass1, bVar.d, bVar.c, bVar.a, arrayList2, arrayList, map, aVar, arrayList3);
                    a(view, bVar, i, a2);
                    t.a(a2, bVar.d, true);
                    a(bVar, i, a2);
                    t.a((ViewGroup) view, a2);
                    t.a(view, bVar.d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, bVar.b, aVar);
                }
                if (a2 == null) {
                    return true;
                }
                return false;
            }
            av avVar = z ? kVar2.ah : kVar.ah;
            if (avVar != null) {
                avVar.a(new ArrayList(map.keySet()), new ArrayList(map.values()), null);
            }
            a(bVar, view, a4, kVar, kVar2, z, arrayList3, a3, b);
        }
        obj = a4;
        if (a3 != null) {
        }
        arrayList = new ArrayList();
        a = a(b, kVar2, arrayList, (android.support.v4.e.a) map, bVar.d);
        view2 = (View) map.get(this.v.get(0));
        if (view2 != null) {
            if (a != null) {
                t.a(a, view2);
            }
            if (obj != null) {
                t.a(obj, view2);
            }
        }
        anonymousClass1 = /* anonymous class already generated */;
        arrayList2 = new ArrayList();
        aVar = new android.support.v4.e.a();
        z2 = true;
        if (kVar != null) {
            if (z) {
                z2 = kVar.z();
            } else {
                z2 = kVar.A();
            }
        }
        a2 = t.a(a3, a, obj, z2);
        if (a2 != null) {
            t.a(a3, obj, a, view, anonymousClass1, bVar.d, bVar.c, bVar.a, arrayList2, arrayList, map, aVar, arrayList3);
            a(view, bVar, i, a2);
            t.a(a2, bVar.d, true);
            a(bVar, i, a2);
            t.a((ViewGroup) view, a2);
            t.a(view, bVar.d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, bVar.b, aVar);
        }
        if (a2 == null) {
            return false;
        }
        return true;
    }

    private void a(b bVar, View view, Object obj, k kVar, k kVar2, boolean z, ArrayList<View> arrayList, Object obj2, Object obj3) {
        if (obj != null) {
            final View view2 = view;
            final Object obj4 = obj;
            final ArrayList<View> arrayList2 = arrayList;
            final b bVar2 = bVar;
            final Object obj5 = obj2;
            final Object obj6 = obj3;
            final boolean z2 = z;
            final k kVar3 = kVar;
            final k kVar4 = kVar2;
            view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                final /* synthetic */ d j;

                public boolean onPreDraw() {
                    view2.getViewTreeObserver().removeOnPreDrawListener(this);
                    t.a(obj4, arrayList2);
                    arrayList2.remove(bVar2.d);
                    t.a(obj5, obj6, obj4, arrayList2, false);
                    arrayList2.clear();
                    android.support.v4.e.a a = this.j.a(bVar2, z2, kVar3);
                    t.a(obj4, bVar2.d, (Map) a, arrayList2);
                    this.j.a(a, bVar2);
                    this.j.a(bVar2, kVar3, kVar4, z2, a);
                    t.a(obj5, obj6, obj4, arrayList2, true);
                    return true;
                }
            });
        }
    }

    private void a(b bVar, k kVar, k kVar2, boolean z, android.support.v4.e.a<String, View> aVar) {
        av avVar = z ? kVar2.ah : kVar.ah;
        if (avVar != null) {
            avVar.b(new ArrayList(aVar.keySet()), new ArrayList(aVar.values()), null);
        }
    }

    private void a(android.support.v4.e.a<String, View> aVar, b bVar) {
        if (this.v != null && !aVar.isEmpty()) {
            View view = (View) aVar.get(this.v.get(0));
            if (view != null) {
                bVar.c.a = view;
            }
        }
    }

    private android.support.v4.e.a<String, View> a(b bVar, boolean z, k kVar) {
        android.support.v4.e.a b = b(bVar, kVar, z);
        if (z) {
            if (kVar.ai != null) {
                kVar.ai.a(this.v, b);
            }
            a(bVar, b, true);
        } else {
            if (kVar.ah != null) {
                kVar.ah.a(this.v, b);
            }
            b(bVar, b, true);
        }
        return b;
    }

    private static android.support.v4.e.a<String, View> a(ArrayList<String> arrayList, ArrayList<String> arrayList2, android.support.v4.e.a<String, View> aVar) {
        if (aVar.isEmpty()) {
            return aVar;
        }
        android.support.v4.e.a<String, View> aVar2 = new android.support.v4.e.a();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) aVar.get(arrayList.get(i));
            if (view != null) {
                aVar2.put(arrayList2.get(i), view);
            }
        }
        return aVar2;
    }

    private android.support.v4.e.a<String, View> b(b bVar, k kVar, boolean z) {
        android.support.v4.e.a aVar = new android.support.v4.e.a();
        View n = kVar.n();
        if (n == null || this.u == null) {
            return aVar;
        }
        t.a((Map) aVar, n);
        if (z) {
            return a(this.u, this.v, aVar);
        }
        aVar.a(this.v);
        return aVar;
    }

    private void a(View view, b bVar, int i, Object obj) {
        final View view2 = view;
        final b bVar2 = bVar;
        final int i2 = i;
        final Object obj2 = obj;
        view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ d e;

            public boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                this.e.a(bVar2, i2, obj2);
                return true;
            }
        });
    }

    private void a(b bVar, int i, Object obj) {
        if (this.b.g != null) {
            for (int i2 = 0; i2 < this.b.g.size(); i2++) {
                k kVar = (k) this.b.g.get(i2);
                if (!(kVar.S == null || kVar.R == null || kVar.H != i)) {
                    if (!kVar.J) {
                        t.a(obj, kVar.S, false);
                        bVar.b.remove(kVar.S);
                    } else if (!bVar.b.contains(kVar.S)) {
                        t.a(obj, kVar.S, true);
                        bVar.b.add(kVar.S);
                    }
                }
            }
        }
    }

    private static void a(android.support.v4.e.a<String, String> aVar, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < aVar.size(); i++) {
                if (str.equals(aVar.c(i))) {
                    aVar.a(i, (Object) str2);
                    return;
                }
            }
            aVar.put(str, str2);
        }
    }

    private static void a(b bVar, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                a(bVar.a, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void a(b bVar, android.support.v4.e.a<String, View> aVar, boolean z) {
        int size = this.v == null ? 0 : this.v.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.u.get(i);
            View view = (View) aVar.get((String) this.v.get(i));
            if (view != null) {
                String a = t.a(view);
                if (z) {
                    a(bVar.a, str, a);
                } else {
                    a(bVar.a, a, str);
                }
            }
        }
    }

    private void b(b bVar, android.support.v4.e.a<String, View> aVar, boolean z) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            String str = (String) aVar.b(i);
            String a = t.a((View) aVar.c(i));
            if (z) {
                a(bVar.a, str, a);
            } else {
                a(bVar.a, a, str);
            }
        }
    }
}
