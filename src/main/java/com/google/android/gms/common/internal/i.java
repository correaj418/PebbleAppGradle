package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class i<T extends IInterface> {
    public static final String[] c = new String[]{"service_esmobile", "service_googleme"};
    final Handler a;
    protected AtomicInteger b = new AtomicInteger(0);
    private int d;
    private long e;
    private long f;
    private int g;
    private long h;
    private final Context i;
    private final Looper j;
    private final r k;
    private final com.google.android.gms.common.i l;
    private final Object m = new Object();
    private final Object n = new Object();
    private y o;
    private f p;
    private T q;
    private final ArrayList<e<?>> r = new ArrayList();
    private h s;
    private int t = 1;
    private final b u;
    private final c v;
    private final int w;
    private final String x;

    public interface f {
        void a(ConnectionResult connectionResult);
    }

    protected abstract class e<TListener> {
        private TListener a;
        private boolean b = false;
        final /* synthetic */ i d;

        public e(i iVar, TListener tListener) {
            this.d = iVar;
            this.a = tListener;
        }

        protected abstract void a(TListener tListener);

        protected abstract void b();

        public void c() {
            synchronized (this) {
                Object obj = this.a;
                if (this.b) {
                    String valueOf = String.valueOf(this);
                    Log.w("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.").toString());
                }
            }
            if (obj != null) {
                try {
                    a(obj);
                } catch (RuntimeException e) {
                    b();
                    throw e;
                }
            }
            b();
            synchronized (this) {
                this.b = true;
            }
            d();
        }

        public void d() {
            e();
            synchronized (this.d.r) {
                this.d.r.remove(this);
            }
        }

        public void e() {
            synchronized (this) {
                this.a = null;
            }
        }
    }

    private abstract class a extends e<Boolean> {
        public final int a;
        public final Bundle b;
        final /* synthetic */ i c;

        protected a(i iVar, int i, Bundle bundle) {
            this.c = iVar;
            super(iVar, Boolean.valueOf(true));
            this.a = i;
            this.b = bundle;
        }

        protected abstract void a(ConnectionResult connectionResult);

        protected void a(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                this.c.b(1, null);
                return;
            }
            switch (this.a) {
                case 0:
                    if (!a()) {
                        this.c.b(1, null);
                        a(new ConnectionResult(8, null));
                        return;
                    }
                    return;
                case 10:
                    this.c.b(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    this.c.b(1, null);
                    if (this.b != null) {
                        pendingIntent = (PendingIntent) this.b.getParcelable("pendingIntent");
                    }
                    a(new ConnectionResult(this.a, pendingIntent));
                    return;
            }
        }

        protected /* synthetic */ void a(Object obj) {
            a((Boolean) obj);
        }

        protected abstract boolean a();

        protected void b() {
        }
    }

    public interface b {
        void a(int i);

        void a(Bundle bundle);
    }

    public interface c {
        void a(ConnectionResult connectionResult);
    }

    final class d extends Handler {
        final /* synthetic */ i a;

        public d(i iVar, Looper looper) {
            this.a = iVar;
            super(looper);
        }

        private void a(Message message) {
            e eVar = (e) message.obj;
            eVar.b();
            eVar.d();
        }

        private boolean b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5;
        }

        public void handleMessage(Message message) {
            PendingIntent pendingIntent = null;
            if (this.a.b.get() != message.arg1) {
                if (b(message)) {
                    a(message);
                }
            } else if ((message.what == 1 || message.what == 5) && !this.a.c()) {
                a(message);
            } else if (message.what == 3) {
                if (message.obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) message.obj;
                }
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
                this.a.p.a(connectionResult);
                this.a.a(connectionResult);
            } else if (message.what == 4) {
                this.a.b(4, null);
                if (this.a.u != null) {
                    this.a.u.a(message.arg2);
                }
                this.a.a(message.arg2);
                this.a.a(4, 1, null);
            } else if (message.what == 2 && !this.a.b()) {
                a(message);
            } else if (b(message)) {
                ((e) message.obj).c();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
            }
        }
    }

    public static final class g extends com.google.android.gms.common.internal.x.a {
        private i a;
        private final int b;

        public g(i iVar, int i) {
            this.a = iVar;
            this.b = i;
        }

        private void a() {
            this.a = null;
        }

        public void a(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        public void a(int i, IBinder iBinder, Bundle bundle) {
            b.a(this.a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.a.a(i, iBinder, bundle, this.b);
            a();
        }
    }

    public final class h implements ServiceConnection {
        final /* synthetic */ i a;
        private final int b;

        public h(i iVar, int i) {
            this.a = iVar;
            this.b = i;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.a((Object) iBinder, (Object) "Expecting a valid IBinder");
            synchronized (this.a.n) {
                this.a.o = com.google.android.gms.common.internal.y.a.a(iBinder);
            }
            this.a.a(0, null, this.b);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (this.a.n) {
                this.a.o = null;
            }
            this.a.a.sendMessage(this.a.a.obtainMessage(4, this.b, 1));
        }
    }

    protected class i implements f {
        final /* synthetic */ i a;

        public i(i iVar) {
            this.a = iVar;
        }

        public void a(ConnectionResult connectionResult) {
            if (connectionResult.b()) {
                this.a.a(null, this.a.v());
            } else if (this.a.v != null) {
                this.a.v.a(connectionResult);
            }
        }
    }

    protected final class j extends a {
        public final IBinder e;
        final /* synthetic */ i f;

        public j(i iVar, int i, IBinder iBinder, Bundle bundle) {
            this.f = iVar;
            super(iVar, i, bundle);
            this.e = iBinder;
        }

        protected void a(ConnectionResult connectionResult) {
            if (this.f.v != null) {
                this.f.v.a(connectionResult);
            }
            this.f.a(connectionResult);
        }

        protected boolean a() {
            try {
                String interfaceDescriptor = this.e.getInterfaceDescriptor();
                if (this.f.j().equals(interfaceDescriptor)) {
                    IInterface a = this.f.a(this.e);
                    if (a == null || !this.f.a(2, 3, a)) {
                        return false;
                    }
                    Bundle s = this.f.s();
                    if (this.f.u != null) {
                        this.f.u.a(s);
                    }
                    return true;
                }
                String valueOf = String.valueOf(this.f.j());
                Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(valueOf).append(" vs. ").append(interfaceDescriptor).toString());
                return false;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    protected final class k extends a {
        final /* synthetic */ i e;

        public k(i iVar, int i, Bundle bundle) {
            this.e = iVar;
            super(iVar, i, bundle);
        }

        protected void a(ConnectionResult connectionResult) {
            this.e.p.a(connectionResult);
            this.e.a(connectionResult);
        }

        protected boolean a() {
            this.e.p.a(ConnectionResult.a);
            return true;
        }
    }

    protected i(Context context, Looper looper, r rVar, com.google.android.gms.common.i iVar, int i, b bVar, c cVar, String str) {
        this.i = (Context) b.a((Object) context, (Object) "Context must not be null");
        this.j = (Looper) b.a((Object) looper, (Object) "Looper must not be null");
        this.k = (r) b.a((Object) rVar, (Object) "Supervisor must not be null");
        this.l = (com.google.android.gms.common.i) b.a((Object) iVar, (Object) "API availability must not be null");
        this.a = new d(this, looper);
        this.w = i;
        this.u = bVar;
        this.v = cVar;
        this.x = str;
    }

    private boolean a(int i, int i2, T t) {
        boolean z;
        synchronized (this.m) {
            if (this.t != i) {
                z = false;
            } else {
                b(i2, t);
                z = true;
            }
        }
        return z;
    }

    private void b(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        b.b(z);
        synchronized (this.m) {
            this.t = i;
            this.q = t;
            a(i, (IInterface) t);
            switch (i) {
                case 1:
                    w();
                    break;
                case 2:
                    k();
                    break;
                case 3:
                    a((IInterface) t);
                    break;
            }
        }
    }

    private void k() {
        if (this.s != null) {
            String valueOf = String.valueOf(i());
            String valueOf2 = String.valueOf(f_());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("Calling connect() while still connected, missing disconnect() for ").append(valueOf).append(" on ").append(valueOf2).toString());
            this.k.b(i(), f_(), this.s, m());
            this.b.incrementAndGet();
        }
        this.s = new h(this, this.b.get());
        if (!this.k.a(i(), f_(), this.s, m())) {
            valueOf = String.valueOf(i());
            valueOf2 = String.valueOf(f_());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(valueOf2).length()).append("unable to connect to service: ").append(valueOf).append(" on ").append(valueOf2).toString());
            a(16, null, this.b.get());
        }
    }

    private void w() {
        if (this.s != null) {
            this.k.b(i(), f_(), this.s, m());
            this.s = null;
        }
    }

    protected abstract T a(IBinder iBinder);

    public void a() {
        this.b.incrementAndGet();
        synchronized (this.r) {
            int size = this.r.size();
            for (int i = 0; i < size; i++) {
                ((e) this.r.get(i)).e();
            }
            this.r.clear();
        }
        synchronized (this.n) {
            this.o = null;
        }
        b(1, null);
    }

    protected void a(int i) {
        this.d = i;
        this.e = System.currentTimeMillis();
    }

    protected void a(int i, Bundle bundle, int i2) {
        this.a.sendMessage(this.a.obtainMessage(5, i2, -1, new k(this, i, bundle)));
    }

    protected void a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.a.sendMessage(this.a.obtainMessage(1, i2, -1, new j(this, i, iBinder, bundle)));
    }

    void a(int i, T t) {
    }

    protected void a(T t) {
        this.f = System.currentTimeMillis();
    }

    protected void a(ConnectionResult connectionResult) {
        this.g = connectionResult.c();
        this.h = System.currentTimeMillis();
    }

    public void a(f fVar) {
        this.p = (f) b.a((Object) fVar, (Object) "Connection progress callbacks cannot be null.");
        b(2, null);
    }

    public void a(u uVar, Set<Scope> set) {
        try {
            GetServiceRequest a = new GetServiceRequest(this.w).a(this.i.getPackageName()).a(q());
            if (set != null) {
                a.a((Collection) set);
            }
            if (d()) {
                a.a(p()).a(uVar);
            } else if (u()) {
                a.a(o());
            }
            synchronized (this.n) {
                if (this.o != null) {
                    this.o.a(new g(this, this.b.get()), a);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            b(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (this.m) {
            int i = this.t;
            IInterface iInterface = this.q;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("CONNECTING");
                break;
            case 3:
                printWriter.print("CONNECTED");
                break;
            case 4:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.println("null");
        } else {
            printWriter.append(j()).append("@").println(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.f;
            String valueOf = String.valueOf(simpleDateFormat.format(new Date(this.f)));
            append.println(new StringBuilder(String.valueOf(valueOf).length() + 21).append(j).append(" ").append(valueOf).toString());
        }
        if (this.e > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.d) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append(String.valueOf(this.d));
                    break;
            }
            append = printWriter.append(" lastSuspendedTime=");
            j = this.e;
            valueOf = String.valueOf(simpleDateFormat.format(new Date(this.e)));
            append.println(new StringBuilder(String.valueOf(valueOf).length() + 21).append(j).append(" ").append(valueOf).toString());
        }
        if (this.h > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(com.google.android.gms.common.api.b.a(this.g));
            append = printWriter.append(" lastFailedTime=");
            j = this.h;
            String valueOf2 = String.valueOf(simpleDateFormat.format(new Date(this.h)));
            append.println(new StringBuilder(String.valueOf(valueOf2).length() + 21).append(j).append(" ").append(valueOf2).toString());
        }
    }

    public void b(int i) {
        this.a.sendMessage(this.a.obtainMessage(4, this.b.get(), i));
    }

    public boolean b() {
        boolean z;
        synchronized (this.m) {
            z = this.t == 3;
        }
        return z;
    }

    public boolean c() {
        boolean z;
        synchronized (this.m) {
            z = this.t == 2;
        }
        return z;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return true;
    }

    public boolean f() {
        return false;
    }

    protected String f_() {
        return "com.google.android.gms";
    }

    public Intent g() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public IBinder h() {
        IBinder iBinder;
        synchronized (this.n) {
            if (this.o == null) {
                iBinder = null;
            } else {
                iBinder = this.o.asBinder();
            }
        }
        return iBinder;
    }

    protected abstract String i();

    protected abstract String j();

    protected final String m() {
        return this.x == null ? this.i.getClass().getName() : this.x;
    }

    public final Context n() {
        return this.i;
    }

    public Account o() {
        return null;
    }

    public final Account p() {
        return o() != null ? o() : new Account("<<default account>>", "com.google");
    }

    protected Bundle q() {
        return new Bundle();
    }

    protected final void r() {
        if (!b()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public Bundle s() {
        return null;
    }

    public final T t() {
        T t;
        synchronized (this.m) {
            if (this.t == 4) {
                throw new DeadObjectException();
            }
            r();
            b.a(this.q != null, (Object) "Client is connected but service is null");
            t = this.q;
        }
        return t;
    }

    public boolean u() {
        return false;
    }

    protected Set<Scope> v() {
        return Collections.EMPTY_SET;
    }
}
