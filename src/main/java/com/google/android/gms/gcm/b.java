package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;

public class b {
    private static b a;
    private Context b;
    private final PendingIntent c = PendingIntent.getBroadcast(this.b, 0, new Intent(), 0);

    private b(Context context) {
        this.b = context;
    }

    private Intent a() {
        int b = e.b(this.b);
        if (b < e.a) {
            Log.e("GcmNetworkManager", "Google Play Services is not available, dropping GcmNetworkManager request. code=" + b);
            return null;
        }
        Intent intent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
        intent.setPackage(e.a(this.b));
        intent.putExtra("app", this.c);
        return intent;
    }

    public static b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b(context.getApplicationContext());
            }
            bVar = a;
        }
        return bVar;
    }

    static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must provide a valid tag.");
        } else if (100 < str.length()) {
            throw new IllegalArgumentException("Tag is larger than max permissible tag length (100)");
        }
    }

    private void b(String str) {
        boolean z = true;
        com.google.android.gms.common.internal.b.a((Object) str, (Object) "GcmTaskService must not be null.");
        Intent intent = new Intent("com.google.android.gms.gcm.ACTION_TASK_READY");
        intent.setPackage(this.b.getPackageName());
        List<ResolveInfo> queryIntentServices = this.b.getPackageManager().queryIntentServices(intent, 0);
        boolean z2 = (queryIntentServices == null || queryIntentServices.size() == 0) ? false : true;
        com.google.android.gms.common.internal.b.b(z2, "There is no GcmTaskService component registered within this package. Have you extended GcmTaskService correctly?");
        for (ResolveInfo resolveInfo : queryIntentServices) {
            if (resolveInfo.serviceInfo.name.equals(str)) {
                break;
            }
        }
        z = false;
        com.google.android.gms.common.internal.b.b(z, new StringBuilder(String.valueOf(str).length() + 119).append("The GcmTaskService class you provided ").append(str).append(" does not seem to support receiving com.google.android.gms.gcm.ACTION_TASK_READY.").toString());
    }

    public void a(Task task) {
        b(task.c());
        Intent a = a();
        if (a != null) {
            Bundle extras = a.getExtras();
            extras.putString("scheduler_action", "SCHEDULE_TASK");
            task.a(extras);
            a.putExtras(extras);
            this.b.sendBroadcast(a);
        }
    }
}
