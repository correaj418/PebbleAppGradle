package com.getpebble.android.core.auth.account;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.getpebble.android.basalt.R;

public class a extends AbstractAccountAuthenticator {
    private static Handler a = new Handler(Looper.getMainLooper());
    private Context b;

    public a(Context context) {
        super(context);
        this.b = context;
    }

    public Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        throw new UnsupportedOperationException();
    }

    public Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (a(this.b, com.getpebble.android.common.a.a.a())) {
            a.post(new Runnable(this) {
                final /* synthetic */ a a;

                {
                    this.a = r1;
                }

                public void run() {
                    Toast.makeText(this.a.b, this.a.b.getString(R.string.login_only_one_account), 0).show();
                }
            });
            bundle2.putInt("errorCode", 9);
            bundle2.putString("errorMessage", this.b.getString(R.string.login_only_one_account));
        }
        return bundle2;
    }

    private boolean a(Context context, Account account) {
        AccountManager accountManager = AccountManager.get(context);
        if (accountManager == null || account == null || accountManager.peekAuthToken(account, "com.getpebble") == null) {
            return false;
        }
        return true;
    }

    public Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    public Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        Bundle bundle2;
        if (str.equals("com.getpebble")) {
            bundle2 = new Bundle();
            AccountManager accountManager = AccountManager.get(this.b);
            if (accountManager == null) {
                return bundle2;
            }
            Object peekAuthToken = accountManager.peekAuthToken(account, str);
            if (TextUtils.isEmpty(peekAuthToken)) {
                return bundle2;
            }
            bundle2.putString("authAccount", account.name);
            bundle2.putString("accountType", account.type);
            bundle2.putString("authtoken", peekAuthToken);
            return bundle2;
        }
        bundle2 = new Bundle();
        bundle2.putString("errorMessage", this.b.getString(R.string.login_invalid_token_type));
        return bundle2;
    }

    public String getAuthTokenLabel(String str) {
        if (str.equals("com.getpebble")) {
            return this.b.getString(R.string.app_name);
        }
        return null;
    }

    public Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    public Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
        throw new UnsupportedOperationException();
    }
}
