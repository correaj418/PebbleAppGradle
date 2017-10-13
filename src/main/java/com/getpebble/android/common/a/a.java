package com.getpebble.android.common.a;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.b.b.x;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.common.b.a.c;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.gcm.RegistrationIntentService;
import com.getpebble.android.framework.timeline.TimelineWebSyncService;
import com.google.b.i;
import com.google.b.o;

public class a {
    protected static a a = null;
    private Account b = null;
    private String c = null;

    private class a implements AccountManagerCallback<Bundle> {
        final /* synthetic */ a a;

        private a(a aVar) {
            this.a = aVar;
        }

        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
            try {
                this.a.c = ((Bundle) accountManagerFuture.getResult()).getString("authtoken");
            } catch (Throwable e) {
                f.a("PebbleSessionManager", "Failed to retrieve token, unable to read from disk!", e);
            } catch (Throwable e2) {
                f.a("PebbleSessionManager", "Failed to retrieve token, unable to communicate with Authenticator!", e2);
            } catch (Throwable e22) {
                f.a("PebbleSessionManager", "Failed to retrieve token, unable to continue, operation has been canceled!", e22);
            }
        }
    }

    protected a() {
        h();
    }

    private static Account a(Account[] accountArr) {
        for (Account account : accountArr) {
            if ("com.getpebble.android.basalt".equalsIgnoreCase(account.type)) {
                return account;
            }
        }
        return null;
    }

    public static Account a() {
        AccountManager l = l();
        if (l == null) {
            f.b("PebbleSessionManager", "getPebbleAccount: manager is null");
            return null;
        }
        Account[] accountsByType = l.getAccountsByType("com.getpebble.android.basalt");
        if (a != null) {
            a.c(a(accountsByType));
            return a.g();
        }
        f.b("PebbleSessionManager", "getPebbleAccount: sInstance is null");
        return null;
    }

    private void c(Account account) {
        this.b = account;
        if (this.b != null) {
            j();
        }
    }

    public String b() {
        Account a = a();
        if (a == null) {
            f.b("PebbleSessionManager", "peekAuthToken: account is null");
            return null;
        }
        AccountManager l = l();
        if (l != null) {
            return l.peekAuthToken(a, "com.getpebble");
        }
        f.b("PebbleSessionManager", "peekAuthToken: manager is null");
        return null;
    }

    private void j() {
        AccountManager l = l();
        if (l == null) {
            f.b("PebbleSessionManager", "verifyAccountToken: manager is null");
            return;
        }
        try {
            this.c = l.peekAuthToken(this.b, "com.getpebble");
            k();
        } catch (IllegalArgumentException e) {
            this.b = null;
        }
    }

    public static o a(x<o> xVar) {
        int i;
        if (xVar == null || xVar.d() == null) {
            i = 0;
        } else {
            i = xVar.d().b();
        }
        if (i != 200) {
            f.a("PebbleSessionManager", "Failed to get account info. Response Code = " + i);
            return null;
        }
        o oVar = (o) xVar.b();
        if (oVar == null) {
            f.a("PebbleSessionManager", "onCompleted: result was null");
            return null;
        }
        i c = oVar.c("users");
        if (c != null && c.a() >= 1) {
            return c.a(0).l();
        }
        f.a("PebbleSessionManager", "onCompleted: user array was null");
        return null;
    }

    private void k() {
        boolean z = false;
        if (!TextUtils.isEmpty(this.c)) {
            z = true;
        }
        if (!z && this.b != null) {
            AccountManager l = l();
            if (l == null) {
                f.b("PebbleSessionManager", "handleToken: manager is null");
            } else {
                l.getAuthToken(this.b, "com.getpebble", null, true, new a(), null);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        Account account = new Account(str, "com.getpebble.android.basalt");
        AccountManager l = l();
        if (l == null) {
            f.b("PebbleSessionManager", "createAccount: manager is null");
            return;
        }
        l.addAccountExplicitly(account, str2, null);
        l.invalidateAuthToken("com.getpebble.android.basalt", null);
        l.setAuthToken(account, "com.getpebble", str3);
        this.c = str3;
        l.setUserData(account, "id", str4);
        l.setUserData(account, "uid", str5);
        l.setUserData(account, "refresh_token", str6);
        c(account);
        i();
    }

    public void c() {
        String b = c.b(com.getpebble.android.common.a.K());
        a("Pebble", "DUMMY_PASSWORD", "DUMMY_TOKEN", b, "uid" + b, "DUMMY_REFRESH_TOKEN");
    }

    public boolean d() {
        Account g = g();
        if (g != null) {
            return "Pebble".equals(g.name);
        }
        f.b("PebbleSessionManager", "isDummyAccount: account is null!");
        return false;
    }

    public void e() {
        if (this.b != null) {
            AccountManager l = l();
            if (l == null) {
                f.b("PebbleSessionManager", "removeAccount: manager is null");
                return;
            }
            l.removeAccount(this.b, null, null);
        }
        this.c = null;
        c(null);
        f.d("PebbleSessionManager", "Invalidating the GCM token");
        Context K = com.getpebble.android.common.a.K();
        RegistrationIntentService.a(PebbleApplication.y());
        f.d("PebbleSessionManager", "Resetting the web sync");
        TimelineWebSyncService.a(K);
        PebbleDevice n = PebbleApplication.n();
        com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
        if (n == null && p != null) {
            n = p.pebbleDevice;
        }
        if (n != null) {
            PebbleApplication.x().b(n);
        }
    }

    public static synchronized a f() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public Account g() {
        return this.b;
    }

    private static AccountManager l() {
        return AccountManager.get(com.getpebble.android.common.a.K());
    }

    public Account h() {
        AccountManager l = l();
        if (l == null) {
            f.b("PebbleSessionManager", "fetchUserAccount: manager is null");
            return null;
        }
        c(a(l.getAccountsByType("com.getpebble.android.basalt")));
        return g();
    }

    public String a(Account account) {
        AccountManager l = l();
        if (l == null) {
            f.b("PebbleSessionManager", "getDevPortalId: manager is null");
            return null;
        }
        String userData = l.getUserData(account, "id");
        if (!TextUtils.isEmpty(userData)) {
            return userData;
        }
        f.b("PebbleSessionManager", "Null / empty 'id' in account " + account.toString());
        return userData;
    }

    public String b(Account account) {
        if (account == null) {
            f.b("PebbleSessionManager", "getAuthId: account is null");
            return "";
        }
        AccountManager l = l();
        if (l == null) {
            f.b("PebbleSessionManager", "getAuthId: manager is null");
            return null;
        }
        String userData = l.getUserData(account, "uid");
        if (!TextUtils.isEmpty(userData)) {
            return userData;
        }
        f.b("PebbleSessionManager", "Null / empty 'uid' in account " + account.toString());
        return userData;
    }

    public void i() {
        f.d("PebbleSessionManager", "setAppStoreAuthCookie()");
        String b = PebbleApplication.u().b();
        if (VERSION.SDK_INT < 21) {
            CookieSyncManager.createInstance(com.getpebble.android.common.a.K());
        }
        CookieManager instance = CookieManager.getInstance();
        CookieManager.getInstance().setAcceptCookie(true);
        String str = ".getpebble.com";
        instance.setCookie(str, "access_token=" + b + "; Max-Age=31536000; Domain=" + str + "; Path=/" + "; secure");
        if (VERSION.SDK_INT >= 21) {
            instance.flush();
        } else {
            CookieSyncManager.getInstance().sync();
        }
    }
}
