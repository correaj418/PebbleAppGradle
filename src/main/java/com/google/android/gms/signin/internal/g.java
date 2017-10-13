package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.a.a;
import com.google.android.gms.b.cn;
import com.google.android.gms.b.co;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.u;

public class g extends p<e> implements cn {
    private final boolean d;
    private final l e;
    private final Bundle f;
    private Integer g;

    public g(Context context, Looper looper, boolean z, l lVar, Bundle bundle, b bVar, c cVar) {
        super(context, looper, 44, lVar, bVar, cVar);
        this.d = z;
        this.e = lVar;
        this.f = bundle;
        this.g = lVar.i();
    }

    public g(Context context, Looper looper, boolean z, l lVar, co coVar, b bVar, c cVar) {
        this(context, looper, z, lVar, a(lVar), bVar, cVar);
    }

    public static Bundle a(l lVar) {
        co h = lVar.h();
        Integer i = lVar.i();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", lVar.a());
        if (i != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", i.intValue());
        }
        if (h != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", h.a());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", h.b());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", h.c());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", h.d());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", h.e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", h.f());
        }
        return bundle;
    }

    private ResolveAccountRequest w() {
        Account b = this.e.b();
        GoogleSignInAccount googleSignInAccount = null;
        if ("<<default account>>".equals(b.name)) {
            googleSignInAccount = a.a(n()).a();
        }
        return new ResolveAccountRequest(b, this.g.intValue(), googleSignInAccount);
    }

    protected /* synthetic */ IInterface a(IBinder iBinder) {
        return b(iBinder);
    }

    public void a(u uVar, boolean z) {
        try {
            ((e) t()).a(uVar, this.g.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void a(d dVar) {
        com.google.android.gms.common.internal.b.a((Object) dVar, (Object) "Expecting a valid ISignInCallbacks");
        try {
            ((e) t()).a(new SignInRequest(w()), dVar);
        } catch (Throwable e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                dVar.a(new SignInResponse(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    protected e b(IBinder iBinder) {
        return e.a.a(iBinder);
    }

    public boolean d() {
        return this.d;
    }

    protected String i() {
        return "com.google.android.gms.signin.service.START";
    }

    protected String j() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public void k() {
        try {
            ((e) t()).a(this.g.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public void l() {
        a(new i(this));
    }

    protected Bundle q() {
        if (!n().getPackageName().equals(this.e.f())) {
            this.f.putString("com.google.android.gms.signin.internal.realClientPackageName", this.e.f());
        }
        return this.f;
    }
}
