package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.b.ad;
import com.google.android.gms.b.y;
import com.google.android.gms.b.y.a;
import com.google.android.gms.common.a.g;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.n;

public class b extends i {
    public static final int a = i.b;
    private static final b c = new b();

    b() {
    }

    public static b a() {
        return c;
    }

    public int a(Context context) {
        return super.a(context);
    }

    public Dialog a(Activity activity, int i, int i2) {
        return e.a(i, activity, i2);
    }

    public Dialog a(Activity activity, OnCancelListener onCancelListener) {
        View progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        Builder builder = new Builder(activity);
        builder.setView(progressBar);
        String g = k.g(activity);
        builder.setMessage(activity.getResources().getString(com.google.android.gms.a.b.common_google_play_services_updating_text, new Object[]{g}));
        builder.setTitle(com.google.android.gms.a.b.common_google_play_services_updating_title);
        builder.setPositiveButton("", null);
        Dialog create = builder.create();
        e.a(activity, onCancelListener, "GooglePlayServicesUpdatingDialog", create);
        return create;
    }

    public PendingIntent a(Context context, int i, int i2) {
        return super.a(context, i, i2);
    }

    public PendingIntent a(Context context, int i, int i2, String str) {
        return super.a(context, i, i2, str);
    }

    public PendingIntent a(Context context, ConnectionResult connectionResult) {
        if (connectionResult.a()) {
            return connectionResult.d();
        }
        int c = connectionResult.c();
        if (g.a(context) && c == 2) {
            c = 42;
        }
        return a(context, c, 0);
    }

    public Intent a(Context context, int i, String str) {
        return super.a(context, i, str);
    }

    public y a(Context context, a aVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        BroadcastReceiver yVar = new y(aVar);
        context.registerReceiver(yVar, intentFilter);
        yVar.a(context);
        if (a(context, "com.google.android.gms")) {
            return yVar;
        }
        aVar.a();
        yVar.a();
        return null;
    }

    public void a(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent a = a(context, connectionResult);
        if (a != null) {
            e.a(connectionResult.c(), context, GoogleApiActivity.a(context, a, i));
        }
    }

    public final boolean a(int i) {
        return super.a(i);
    }

    public boolean a(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        return e.b(i, activity, i2, onCancelListener);
    }

    public boolean a(Activity activity, ad adVar, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = e.a(i, activity, n.a(adVar, a((Context) activity, i, "d"), i2), onCancelListener);
        if (a == null) {
            return false;
        }
        e.a(activity, onCancelListener, "GooglePlayServicesErrorDialog", a);
        return true;
    }

    public boolean a(Context context, int i) {
        return super.a(context, i);
    }

    @Deprecated
    public Intent b(int i) {
        return super.b(i);
    }
}
