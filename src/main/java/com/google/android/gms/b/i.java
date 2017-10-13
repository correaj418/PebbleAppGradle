package com.google.android.gms.b;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.internal.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class i extends l {
    private final SparseArray<a> e = new SparseArray();

    private class a implements c {
        public final int a;
        public final com.google.android.gms.common.api.c b;
        public final c c;
        final /* synthetic */ i d;

        public a(i iVar, int i, com.google.android.gms.common.api.c cVar, c cVar2) {
            this.d = iVar;
            this.a = i;
            this.b = cVar;
            this.c = cVar2;
            cVar.a((c) this);
        }

        public void a() {
            this.b.b((c) this);
            this.b.d();
        }

        public void a(ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 27).append("beginFailureResolution for ").append(valueOf).toString());
            this.d.b(connectionResult, this.a);
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.append(str).append("GoogleApiClient #").print(this.a);
            printWriter.println(":");
            this.b.a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        }
    }

    private i(ad adVar) {
        super(adVar);
        this.d.a("AutoManageHelper", (ac) this);
    }

    public static i a(ab abVar) {
        ad b = ac.b(abVar);
        i iVar = (i) b.a("AutoManageHelper", i.class);
        return iVar != null ? iVar : new i(b);
    }

    public void a() {
        super.a();
        boolean z = this.a;
        String valueOf = String.valueOf(this.e);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 14).append("onStart ").append(z).append(" ").append(valueOf).toString());
        if (!this.b) {
            for (int i = 0; i < this.e.size(); i++) {
                ((a) this.e.valueAt(i)).b.b();
            }
        }
    }

    public void a(int i) {
        a aVar = (a) this.e.get(i);
        this.e.remove(i);
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(int i, com.google.android.gms.common.api.c cVar, c cVar2) {
        b.a((Object) cVar, (Object) "GoogleApiClient instance cannot be null");
        b.a(this.e.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        Log.d("AutoManageHelper", "starting AutoManage for client " + i + " " + this.a + " " + this.b);
        this.e.put(i, new a(this, i, cVar, cVar2));
        if (this.a && !this.b) {
            String valueOf = String.valueOf(cVar);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 11).append("connecting ").append(valueOf).toString());
            cVar.b();
        }
    }

    protected void a(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        a aVar = (a) this.e.get(i);
        if (aVar != null) {
            a(i);
            c cVar = aVar.c;
            if (cVar != null) {
                cVar.a(connectionResult);
            }
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.e.size(); i++) {
            ((a) this.e.valueAt(i)).a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void b() {
        super.b();
        for (int i = 0; i < this.e.size(); i++) {
            ((a) this.e.valueAt(i)).b.d();
        }
    }

    protected void c() {
        for (int i = 0; i < this.e.size(); i++) {
            ((a) this.e.valueAt(i)).b.b();
        }
    }
}
