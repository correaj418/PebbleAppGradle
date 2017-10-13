package com.google.android.gms.auth.api.signin.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.b;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class a {
    private static final Lock a = new ReentrantLock();
    private static a b;
    private final Lock c = new ReentrantLock();
    private final SharedPreferences d;

    a(Context context) {
        this.d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static a a(Context context) {
        b.a((Object) context);
        a.lock();
        try {
            if (b == null) {
                b = new a(context.getApplicationContext());
            }
            a aVar = b;
            return aVar;
        } finally {
            a.unlock();
        }
    }

    private String a(String str, String str2) {
        String valueOf = String.valueOf(":");
        return new StringBuilder(((String.valueOf(str).length() + 0) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString();
    }

    public GoogleSignInAccount a() {
        return a(b("defaultGoogleSignInAccount"));
    }

    GoogleSignInAccount a(String str) {
        GoogleSignInAccount googleSignInAccount = null;
        if (!TextUtils.isEmpty(str)) {
            String b = b(a("googleSignInAccount", str));
            if (b != null) {
                try {
                    googleSignInAccount = GoogleSignInAccount.a(b);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInAccount;
    }

    protected String b(String str) {
        this.c.lock();
        try {
            String string = this.d.getString(str, null);
            return string;
        } finally {
            this.c.unlock();
        }
    }
}
