package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.f;
import android.support.v4.content.f.b;
import android.support.v4.e.c;
import android.support.v4.e.j;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class w extends v {
    static boolean a = false;
    final j<a> b = new j();
    final j<a> c = new j();
    final String d;
    boolean e;
    boolean f;
    private o g;

    final class a implements android.support.v4.content.f.a<Object>, b<Object> {
        final int a;
        final Bundle b;
        android.support.v4.app.v.a<Object> c;
        f<Object> d;
        boolean e;
        boolean f;
        Object g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        a n;
        final /* synthetic */ w o;

        void a() {
            if (this.i && this.j) {
                this.h = true;
            } else if (!this.h) {
                this.h = true;
                if (w.a) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.d == null && this.c != null) {
                    this.d = this.c.a(this.a, this.b);
                }
                if (this.d == null) {
                    return;
                }
                if (!this.d.getClass().isMemberClass() || Modifier.isStatic(this.d.getClass().getModifiers())) {
                    if (!this.m) {
                        this.d.a(this.a, this);
                        this.d.a((android.support.v4.content.f.a) this);
                        this.m = true;
                    }
                    this.d.a();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.d);
            }
        }

        void b() {
            if (w.a) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.i = true;
            this.j = this.h;
            this.h = false;
            this.c = null;
        }

        void c() {
            if (this.i) {
                if (w.a) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.i = false;
                if (!(this.h == this.j || this.h)) {
                    e();
                }
            }
            if (this.h && this.e && !this.k) {
                a(this.d, this.g);
            }
        }

        void d() {
            if (this.h && this.k) {
                this.k = false;
                if (this.e && !this.i) {
                    a(this.d, this.g);
                }
            }
        }

        void e() {
            if (w.a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.h = false;
            if (!this.i && this.d != null && this.m) {
                this.m = false;
                this.d.a((b) this);
                this.d.b(this);
                this.d.c();
            }
        }

        void f() {
            String str;
            android.support.v4.app.v.a aVar = null;
            if (w.a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.l = true;
            boolean z = this.f;
            this.f = false;
            if (this.c != null && this.d != null && this.e && z) {
                if (w.a) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.o.g != null) {
                    String str2 = this.o.g.d.v;
                    this.o.g.d.v = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.c.a(this.d);
                } finally {
                    aVar = this.o.g;
                    if (aVar != null) {
                        aVar = this.o.g.d;
                        aVar.v = str;
                    }
                }
            }
            this.c = aVar;
            this.g = aVar;
            this.e = false;
            if (this.d != null) {
                if (this.m) {
                    this.m = false;
                    this.d.a((b) this);
                    this.d.b(this);
                }
                this.d.e();
            }
            if (this.n != null) {
                this.n.f();
            }
        }

        void a(f<Object> fVar, Object obj) {
            String str;
            if (this.c != null) {
                if (this.o.g != null) {
                    String str2 = this.o.g.d.v;
                    this.o.g.d.v = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (w.a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + fVar + ": " + fVar.a(obj));
                    }
                    this.c.a((f) fVar, obj);
                    this.f = true;
                } finally {
                    if (this.o.g != null) {
                        this.o.g.d.v = str;
                    }
                }
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.a);
            stringBuilder.append(" : ");
            c.a(this.d, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.a);
            printWriter.print(" mArgs=");
            printWriter.println(this.b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.d);
            if (this.d != null) {
                this.d.a(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.e || this.f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.m);
            if (this.n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.n);
                printWriter.println(":");
                this.n.a(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    w(String str, o oVar, boolean z) {
        this.d = str;
        this.g = oVar;
        this.e = z;
    }

    void a(o oVar) {
        this.g = oVar;
    }

    void b() {
        if (a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.e) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.e = true;
        for (int b = this.b.b() - 1; b >= 0; b--) {
            ((a) this.b.e(b)).a();
        }
    }

    void c() {
        if (a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.e) {
            for (int b = this.b.b() - 1; b >= 0; b--) {
                ((a) this.b.e(b)).e();
            }
            this.e = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    void d() {
        if (a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.e) {
            this.f = true;
            this.e = false;
            for (int b = this.b.b() - 1; b >= 0; b--) {
                ((a) this.b.e(b)).b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void e() {
        if (this.f) {
            if (a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f = false;
            for (int b = this.b.b() - 1; b >= 0; b--) {
                ((a) this.b.e(b)).c();
            }
        }
    }

    void f() {
        for (int b = this.b.b() - 1; b >= 0; b--) {
            ((a) this.b.e(b)).k = true;
        }
    }

    void g() {
        for (int b = this.b.b() - 1; b >= 0; b--) {
            ((a) this.b.e(b)).d();
        }
    }

    void h() {
        int b;
        if (!this.f) {
            if (a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.b.b() - 1; b >= 0; b--) {
                ((a) this.b.e(b)).f();
            }
            this.b.c();
        }
        if (a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.c.b() - 1; b >= 0; b--) {
            ((a) this.c.e(b)).f();
        }
        this.c.c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        c.a(this.g, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.b.b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.b.b(); i2++) {
                a aVar = (a) this.b.e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.b.d(i2));
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.c.b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.c.b()) {
                aVar = (a) this.c.e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.c.d(i));
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean a() {
        int b = this.b.b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            int i2;
            a aVar = (a) this.b.e(i);
            if (!aVar.h || aVar.f) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
