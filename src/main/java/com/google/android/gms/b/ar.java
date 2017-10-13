package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.google.android.gms.common.a.k;

public class ar {
    protected final Context a;

    public ar(Context context) {
        this.a = context;
    }

    public ApplicationInfo a(String str, int i) {
        return this.a.getPackageManager().getApplicationInfo(str, i);
    }

    @TargetApi(19)
    public boolean a(int i, String str) {
        if (k.f()) {
            try {
                ((AppOpsManager) this.a.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = this.a.getPackageManager().getPackagesForUid(i);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public PackageInfo b(String str, int i) {
        return this.a.getPackageManager().getPackageInfo(str, i);
    }
}
