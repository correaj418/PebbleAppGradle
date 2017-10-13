package com.getpebble.android.common.b.a;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.getpebble.android.a.b;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class h implements OnAccountsUpdateListener {
    private static final long a = TimeUnit.SECONDS.toMillis(2);
    private WeakReference<Context> b;
    private final Handler c = new Handler(Looper.getMainLooper());

    public h(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        this.b = new WeakReference(context);
        a();
        AccountManager accountManager = AccountManager.get((Context) this.b.get());
        if (accountManager != null) {
            Account[] accountsByType = accountManager.getAccountsByType("com.getpebble.android.basalt");
            if (accountsByType != null && accountsByType.length > 0) {
                a(accountsByType[0], true);
            }
        }
    }

    public void onAccountsUpdated(Account[] accountArr) {
        AccountManager accountManager = AccountManager.get((Context) this.b.get());
        if (accountManager != null) {
            Account[] accountsByType = accountManager.getAccountsByType("com.getpebble.android.basalt");
            if (accountsByType != null && accountsByType.length > 0) {
                a(accountsByType[0], true);
            }
        }
    }

    public void a(final Account account, boolean z) {
        AccountManager accountManager = AccountManager.get((Context) this.b.get());
        if (accountManager != null) {
            Map orCreateChildMap = b.getOrCreateChildMap(b.getGlobalEventProperties(), "identity");
            Object userData = accountManager.getUserData(account, "uid");
            if (userData == null) {
                if (z) {
                    f.c("UserObserver", "updateAccountInfo: null id; retrying in 2 seconds...");
                    this.c.postDelayed(new Runnable(this) {
                        final /* synthetic */ h b;

                        public void run() {
                            this.b.a(account, false);
                        }
                    }, a);
                    return;
                }
                userData = "<unknown>";
                f.b("UserObserver", "updateAccountInfo: id is null");
            }
            orCreateChildMap.put("user", userData);
        }
    }

    public void a() {
        Context context = (Context) this.b.get();
        if (context != null) {
            AccountManager accountManager = AccountManager.get(context);
            if (accountManager != null) {
                accountManager.addOnAccountsUpdatedListener(this, this.c, true);
                return;
            }
            return;
        }
        throw new IllegalStateException("context went out of scope, should never happen");
    }
}
