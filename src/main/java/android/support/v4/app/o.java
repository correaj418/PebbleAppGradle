package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.e.i;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class o<E> extends m {
    private final Activity a;
    final Context b;
    final int c;
    final q d;
    private final Handler e;
    private i<String, v> f;
    private boolean g;
    private w h;
    private boolean i;
    private boolean j;

    o(l lVar) {
        this(lVar, lVar, lVar.c, 0);
    }

    o(Activity activity, Context context, Handler handler, int i) {
        this.d = new q();
        this.a = activity;
        this.b = context;
        this.e = handler;
        this.c = i;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean a(k kVar) {
        return true;
    }

    public LayoutInflater b() {
        return (LayoutInflater) this.b.getSystemService("layout_inflater");
    }

    public void c() {
    }

    public void a(k kVar, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.b.startActivity(intent);
    }

    public boolean d() {
        return true;
    }

    public int e() {
        return this.c;
    }

    public View a(int i) {
        return null;
    }

    public boolean a() {
        return true;
    }

    Activity f() {
        return this.a;
    }

    Context g() {
        return this.b;
    }

    Handler h() {
        return this.e;
    }

    q i() {
        return this.d;
    }

    void a(String str) {
        if (this.f != null) {
            w wVar = (w) this.f.get(str);
            if (wVar != null && !wVar.f) {
                wVar.h();
                this.f.remove(str);
            }
        }
    }

    void b(k kVar) {
    }

    boolean j() {
        return this.g;
    }

    void k() {
        if (!this.j) {
            this.j = true;
            if (this.h != null) {
                this.h.b();
            } else if (!this.i) {
                this.h = a("(root)", this.j, false);
                if (!(this.h == null || this.h.e)) {
                    this.h.b();
                }
            }
            this.i = true;
        }
    }

    void a(boolean z) {
        this.g = z;
        if (this.h != null && this.j) {
            this.j = false;
            if (z) {
                this.h.d();
            } else {
                this.h.c();
            }
        }
    }

    void l() {
        if (this.h != null) {
            this.h.h();
        }
    }

    void m() {
        if (this.f != null) {
            int size = this.f.size();
            w[] wVarArr = new w[size];
            for (int i = size - 1; i >= 0; i--) {
                wVarArr[i] = (w) this.f.c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                w wVar = wVarArr[i2];
                wVar.e();
                wVar.g();
            }
        }
    }

    w a(String str, boolean z, boolean z2) {
        if (this.f == null) {
            this.f = new i();
        }
        w wVar = (w) this.f.get(str);
        if (wVar != null) {
            wVar.a(this);
            return wVar;
        } else if (!z2) {
            return wVar;
        } else {
            wVar = new w(str, this, z);
            this.f.put(str, wVar);
            return wVar;
        }
    }

    i<String, v> n() {
        int i;
        int i2 = 0;
        if (this.f != null) {
            int size = this.f.size();
            w[] wVarArr = new w[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                wVarArr[i3] = (w) this.f.c(i3);
            }
            boolean j = j();
            i = 0;
            while (i2 < size) {
                w wVar = wVarArr[i2];
                if (!wVar.f && j) {
                    if (!wVar.e) {
                        wVar.b();
                    }
                    wVar.d();
                }
                if (wVar.f) {
                    i = 1;
                } else {
                    wVar.h();
                    this.f.remove(wVar.d);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.f;
        }
        return null;
    }

    void a(i<String, v> iVar) {
        this.f = iVar;
    }

    void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.j);
        if (this.h != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.h)));
            printWriter.println(":");
            this.h.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
