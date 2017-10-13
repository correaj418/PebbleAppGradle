package com.getpebble.android.core.auth.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.getpebble.android.common.a.a;
import com.getpebble.android.common.b.a.f;

public class PebbleAuthenticationService extends Service {
    private final OnAccountsUpdateListener a = new OnAccountsUpdateListener(this) {
        final /* synthetic */ PebbleAuthenticationService a;

        {
            this.a = r1;
        }

        public void onAccountsUpdated(Account[] accountArr) {
            a f = a.f();
            if (a.a() == null) {
                f.d("PebbleAuthenticationService", "No longer have a pebble account");
                f.e();
            }
        }
    };

    public void onCreate() {
        super.onCreate();
        AccountManager.get(this).addOnAccountsUpdatedListener(this.a, new Handler(Looper.getMainLooper()), true);
    }

    public IBinder onBind(Intent intent) {
        return new a(this).getIBinder();
    }

    public void onDestroy() {
        super.onDestroy();
        AccountManager.get(this).removeOnAccountsUpdatedListener(this.a);
    }
}
