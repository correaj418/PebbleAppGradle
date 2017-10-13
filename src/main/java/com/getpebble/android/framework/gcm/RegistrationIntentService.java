package com.getpebble.android.framework.gcm;

import android.accounts.Account;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.a.g;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.common.model.au;
import com.getpebble.android.h.ad;
import com.getpebble.android.h.v;
import com.google.android.gms.common.b;
import java.util.concurrent.TimeUnit;

public class RegistrationIntentService extends IntentService {
    private static final long a = TimeUnit.SECONDS.toMillis(30);
    private c b;

    private static class a {
        @com.google.b.a.c(a = "device")
        private final a a;

        private static class a {
            @com.google.b.a.c(a = "token")
            final String a;
            @com.google.b.a.c(a = "app_version")
            final int b;
            @com.google.b.a.c(a = "environment")
            final String c;
            @com.google.b.a.c(a = "name")
            final String d;
            @com.google.b.a.c(a = "type")
            final String e;
            @com.google.b.a.c(a = "identifier")
            final String f;

            private a(String str, String str2) {
                this.b = 1404;
                this.c = RegistrationIntentService.m();
                this.d = Build.MODEL;
                this.e = "android";
                this.a = str;
                this.f = str2;
            }
        }

        a(String str, String str2) {
            this.a = new a(str, str2);
        }
    }

    public RegistrationIntentService() {
        super("RegistrationIntentService");
    }

    public static void a(Context context) {
        if (v.a(com.getpebble.android.h.v.a.GCM)) {
            context.startService(new Intent(context, RegistrationIntentService.class));
        } else {
            v.a("RegistrationIntentService", com.getpebble.android.h.v.a.GCM, "Couldn't start GCM registration intent service");
        }
    }

    public static void a(c cVar) {
        f.d("RegistrationIntentService", "invalidateToken()");
        cVar.b(com.getpebble.android.common.b.b.c.a.GCM_REGISTRATION_ID, l());
    }

    public void onCreate() {
        super.onCreate();
        this.b = new c(this);
    }

    protected void onHandleIntent(Intent intent) {
        f.c("RegistrationIntentService", "onHandleIntent()");
        long currentTimeMillis = System.currentTimeMillis();
        int a = b.a().a((Context) this);
        if (a != 0) {
            f.b("RegistrationIntentService", "Google API not available, result = " + a);
            a(currentTimeMillis);
        } else if (f()) {
            f.d("RegistrationIntentService", "GCM registration not required; short-circuiting, already registered with: " + i());
            a(currentTimeMillis);
        } else if (TextUtils.isEmpty(c())) {
            f.d("RegistrationIntentService", "Not registering; user ID unavailable");
            a(currentTimeMillis);
        } else {
            Object obj = (h() || g()) ? null : 1;
            if (obj != null) {
                f.d("RegistrationIntentService", "Unregister is required; token was invalidated");
                b();
            }
            String j = j();
            if (j == null) {
                f.d("RegistrationIntentService", "Not registering; senderId unavailable");
                a(currentTimeMillis);
                return;
            }
            String i = i();
            if (!h()) {
                f.d("RegistrationIntentService", "Registering with ID: " + j);
                try {
                    i = com.google.android.gms.iid.a.c(this).b(j, "GCM", null);
                    this.b.b(com.getpebble.android.common.b.b.c.a.GCM_REGISTRATION_ID, i);
                } catch (Throwable e) {
                    f.a("RegistrationIntentService", "Error registering token", e);
                    a(currentTimeMillis);
                    return;
                }
            }
            boolean a2 = a(i);
            if (a2) {
                f.d("RegistrationIntentService", "Storing GCM sync version: " + k());
                this.b.b(com.getpebble.android.common.b.b.c.a.GCM_SYNC_VERSION, (long) k());
            }
            f.d("RegistrationIntentService", "Token sync succeeded? " + a2);
            a(currentTimeMillis);
        }
    }

    private void a(long j) {
        au.a(com.getpebble.android.common.model.au.a.PUSH_TOKEN_SYNC, getContentResolver(), System.currentTimeMillis() - j);
    }

    private void b() {
        try {
            com.google.android.gms.iid.a.c(this).a("GCM", null);
            f.d("RegistrationIntentService", "Unregister complete");
        } catch (Throwable e) {
            f.a("RegistrationIntentService", "Error deleting token", e);
        }
    }

    private boolean a(String str) {
        f.d("RegistrationIntentService", "sendTokenToBackend()");
        String e = e();
        f.d("RegistrationIntentService", "Fetching from " + e);
        try {
            int b = com.getpebble.android.d.a.a((Context) this, e, new a(str, d()), a).d().b();
            f.d("RegistrationIntentService", "Got response with code: " + b);
            if (b == 200 || b == 201 || b == 202) {
                return true;
            }
            return false;
        } catch (com.getpebble.android.d.a.a e2) {
            return false;
        }
    }

    private String c() {
        com.getpebble.android.common.a.a f = com.getpebble.android.common.a.a.f();
        if (f == null) {
            f.d("RegistrationIntentService", "SessionManager unavailable");
            return "";
        }
        Account h = f.h();
        if (h != null) {
            return f.b(h);
        }
        f.d("RegistrationIntentService", "Account is null");
        return "";
    }

    private String d() {
        return g.a(this);
    }

    private String e() {
        return com.getpebble.android.config.a.c().G();
    }

    private boolean f() {
        return h() && this.b.a(com.getpebble.android.common.b.b.c.a.GCM_SYNC_VERSION, Long.MIN_VALUE) == ((long) k());
    }

    private boolean g() {
        return this.b.a(com.getpebble.android.common.b.b.c.a.GCM_SYNC_VERSION, Long.MIN_VALUE) == Long.MIN_VALUE;
    }

    private boolean h() {
        return !i().equals(l());
    }

    private String i() {
        return this.b.a(com.getpebble.android.common.b.b.c.a.GCM_REGISTRATION_ID, l());
    }

    private String j() {
        return com.getpebble.android.config.a.c().T();
    }

    private int k() {
        return ad.b();
    }

    private static String l() {
        return "";
    }

    private static String m() {
        String S = com.getpebble.android.config.a.c().S();
        return TextUtils.isEmpty(S) ? "appstore-time-production" : S;
    }
}
