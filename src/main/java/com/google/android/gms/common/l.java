package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.b;

public class l {
    private static l a;
    private final Context b;

    private l(Context context) {
        this.b = context.getApplicationContext();
    }

    public static l a(Context context) {
        b.a((Object) context);
        synchronized (l.class) {
            if (a == null) {
                j.a(context);
                a = new l(context);
            }
        }
        return a;
    }

    a a(PackageInfo packageInfo, a... aVarArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        a bVar = new b(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < aVarArr.length; i++) {
            if (aVarArr[i].equals(bVar)) {
                return aVarArr[i];
            }
        }
        String valueOf = String.valueOf(packageInfo.packageName);
        String valueOf2 = String.valueOf(Base64.encodeToString(bVar.c(), 0));
        Log.v("GoogleSignatureVerifier", new StringBuilder((String.valueOf(valueOf).length() + 31) + String.valueOf(valueOf2).length()).append(valueOf).append(" signature not valid.  Found: \n").append(valueOf2).toString());
        return null;
    }

    public boolean a(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            a a;
            if (z) {
                a = a(packageInfo, d.a);
            } else {
                a = a(packageInfo, d.a[0]);
            }
            if (a != null) {
                return true;
            }
        }
        return false;
    }

    public boolean a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (k.d(this.b)) {
            return a(packageInfo, true);
        }
        boolean a = a(packageInfo, false);
        if (a || !a(packageInfo, true)) {
            return a;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return a;
    }
}
