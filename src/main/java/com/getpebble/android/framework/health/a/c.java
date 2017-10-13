package com.getpebble.android.framework.health.a;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.widget.Toast;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.c.b;
import java.lang.ref.WeakReference;

public class c implements b, com.google.android.gms.common.api.c.c {
    private com.getpebble.android.common.b.b.c a;
    private com.google.android.gms.common.api.c b;
    private a c;
    private ProgressDialog d;
    private Context e;
    private WeakReference<Activity> f;
    private boolean g = false;

    public interface a {
        void a();

        void a(com.google.android.gms.common.api.c cVar);

        void b();

        void d_();
    }

    public c(Context context, Activity activity, ProgressDialog progressDialog, a aVar, boolean z) {
        this.e = context;
        this.f = new WeakReference(activity);
        this.a = new com.getpebble.android.common.b.b.c(this.e);
        this.d = progressDialog;
        this.c = aVar;
        this.g = z;
        this.b = new com.google.android.gms.common.api.c.a(context).a(com.google.android.gms.fitness.c.o).a(com.google.android.gms.fitness.c.m).a(new Scope("https://www.googleapis.com/auth/fitness.activity.write")).a(new Scope("https://www.googleapis.com/auth/fitness.location.write")).a(new Scope("https://www.googleapis.com/auth/fitness.body.write")).a(new Scope("profile")).a((b) this).a((com.google.android.gms.common.api.c.c) this).b();
    }

    public void a() {
        f.c("PebbleGoogleFitClient", "connect: Connecting");
        if (e()) {
            this.c.a(this.b);
        } else {
            this.b.b();
        }
    }

    public ConnectionResult b() {
        f.c("PebbleGoogleFitClient", "blockingConnect: Connecting");
        return this.b.c();
    }

    private void f() {
        if (this.d != null) {
            this.d.show();
        }
    }

    private void g() {
        if (this.d != null) {
            this.d.dismiss();
            this.d = null;
        }
    }

    public void c() {
        f.c("PebbleGoogleFitClient", "disconnect: Disconnecting");
        this.f.clear();
        g();
        if (this.b != null) {
            this.b.a((b) this);
            this.b.d();
            this.b = null;
        }
        if (this.c != null) {
            this.c = null;
        }
        this.e = null;
    }

    public com.google.android.gms.common.api.c d() {
        if (e()) {
            return this.b;
        }
        return null;
    }

    public boolean e() {
        return this.b != null && this.b.e() && this.b.a(com.google.android.gms.fitness.c.o) && this.b.a(com.google.android.gms.fitness.c.m);
    }

    public void a(int i, int i2, Intent intent) {
        if (i != 123) {
            return;
        }
        if (i2 == -1) {
            f();
            a();
        } else if (i2 == 0) {
            Toast.makeText(this.e, R.string.onboarding_enable_fit_sync_connection_failed, 0).show();
            this.c.a();
        }
    }

    private boolean h() {
        return this.f.get() != null;
    }

    public void a(Bundle bundle) {
        f.c("PebbleGoogleFitClient", "onConnected: bundle = " + bundle);
        if (h()) {
            Toast.makeText(this.e, R.string.fit_sync_success, 0).show();
        }
        this.a.b(com.getpebble.android.common.b.b.c.a.ENABLE_FIT_SYNC, true);
        g();
        this.c.a(this.b);
    }

    public void a(int i) {
        if (this.g) {
            i();
        } else {
            this.c.d_();
        }
    }

    public void a(ConnectionResult connectionResult) {
        f.c("PebbleGoogleFitClient", "onConnectionFailed: result = " + connectionResult);
        g();
        if (connectionResult == null && this.g) {
            i();
            return;
        }
        int i;
        Activity activity = (Activity) this.f.get();
        if (connectionResult == null || activity == null) {
            if (activity == null) {
                f.b("PebbleGoogleFitClient", "onConnectionFailed: activity is null");
                i = 0;
            } else {
                Toast.makeText(this.e, R.string.onboarding_enable_fit_sync_connection_failed, 1).show();
                i = 0;
            }
        } else if (connectionResult.a()) {
            try {
                f.c("PebbleGoogleFitClient", "onConnectionFailed: Starting Fit OAuth");
                connectionResult.a(activity, 123);
                i = 1;
            } catch (SendIntentException e) {
                f.a("PebbleGoogleFitClient", "onConnectionFailed: Failed to perform Fit OAuth. " + e.getMessage());
                i = 0;
            }
        } else {
            com.google.android.gms.common.b.a().a(activity, connectionResult.c(), 0).show();
            i = 0;
        }
        if (i == 0) {
            this.c.a();
        }
    }

    private void i() {
        new Builder(this.e).setTitle(R.string.fit_sync_retry_title).setMessage(R.string.fit_sync_retry_message).setNegativeButton(R.string.fit_sync_retry_decline, new OnClickListener(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.a.c.b();
            }
        }).setPositiveButton(R.string.fit_sync_retry_accept, new OnClickListener(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.a.a();
            }
        }).create().show();
    }
}
