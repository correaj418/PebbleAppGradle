package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.k;

public class a extends com.google.android.gms.common.internal.u.a {
    int a;

    public static Account a(u uVar) {
        Account account = null;
        if (uVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = uVar.a();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public Account a() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.a) {
            if (k.b(null, callingUid)) {
                this.a = callingUid;
            } else {
                throw new SecurityException("Caller is not GooglePlayServices");
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        Account account = null;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return account.equals(account);
    }
}
