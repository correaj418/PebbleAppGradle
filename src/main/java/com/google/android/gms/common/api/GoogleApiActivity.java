package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.b.x;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.b;

public class GoogleApiActivity extends Activity implements OnCancelListener {
    protected int a = 0;

    public static PendingIntent a(Context context, PendingIntent pendingIntent, int i) {
        return a(context, pendingIntent, i, true);
    }

    public static PendingIntent a(Context context, PendingIntent pendingIntent, int i, boolean z) {
        return PendingIntent.getActivity(context, 0, b(context, pendingIntent, i, z), 134217728);
    }

    private void a() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
        } else if (pendingIntent != null) {
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                this.a = 1;
            } catch (Throwable e) {
                Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e);
                finish();
            }
        } else {
            b.a().a((Activity) this, num.intValue(), 2, (OnCancelListener) this);
            this.a = 1;
        }
    }

    private void a(int i, x xVar) {
        switch (i) {
            case -1:
                xVar.b();
                return;
            case 0:
                xVar.b(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                return;
            default:
                return;
        }
    }

    public static Intent b(Context context, PendingIntent pendingIntent, int i, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    protected void a(int i) {
        setResult(i);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.a = 0;
            x a = x.a();
            a(i2);
            if (booleanExtra) {
                a(i2, a);
            }
        } else if (i == 2) {
            this.a = 0;
            a(i2);
        }
        finish();
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.a = 0;
        setResult(0);
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.a = bundle.getInt("resolution");
        }
        if (this.a != 1) {
            a();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.a);
        super.onSaveInstanceState(bundle);
    }
}
