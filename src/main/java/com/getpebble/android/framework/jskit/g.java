package com.getpebble.android.framework.jskit;

import android.accounts.Account;
import android.content.Context;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.common.a.a;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.am.c;
import java.util.Locale;
import java.util.UUID;

public class g {
    private static g a;
    private final Context b;

    public g(Context context) {
        this.b = context.getApplicationContext();
    }

    public static synchronized g a(Context context) {
        g gVar;
        synchronized (g.class) {
            if (a == null) {
                a = new g(context);
            }
            gVar = a;
        }
        return gVar;
    }

    Account a() {
        return a.f().g();
    }

    String a(Account account) {
        return a.f().a(account);
    }

    String b() {
        ak.a r = PebbleApplication.r();
        if (r == null) {
            f.d("TokenBridge", "getWatchSerialNumber: Connected Device Record was null");
            r = PebbleApplication.p();
            if (r == null) {
                f.d("TokenBridge", "getWatchSerialNumber: Last Connected Device Record was null: Returning blank string.");
                return "";
            }
        }
        return r.serialNumber;
    }

    String c() {
        Account a = a();
        if (a != null) {
            return a(a);
        }
        return null;
    }

    String a(UUID uuid) {
        c a = am.a(uuid, this.b.getContentResolver(), true);
        if (a == null) {
            return null;
        }
        return a.j;
    }

    private String a(UUID uuid, String str) {
        if (uuid == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        String a = a(uuid);
        if (a == null) {
            a = uuid.toString().toUpperCase(Locale.US);
        }
        stringBuilder.append(a);
        stringBuilder.append("MMIxeUT[G9/U#(7V67O^EuADSw,{$C;B}`>|-nlrQCs|t|k=P_!*LETm,RKc,BG*'");
        return b.b(stringBuilder.toString());
    }

    public String b(UUID uuid) {
        return a(uuid, b());
    }

    public String c(UUID uuid) {
        return a(uuid, c());
    }
}
