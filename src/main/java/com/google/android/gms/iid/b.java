package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.g;
import android.util.Log;

public class b extends Service {
    static String a = "action";
    private static String f = "google.com/iid";
    private static String g = "CMD";
    private static String h = "gcm.googleapis.com/refresh";
    MessengerCompat b = new MessengerCompat(new Handler(this, Looper.getMainLooper()) {
        final /* synthetic */ b a;

        public void handleMessage(Message message) {
            this.a.a(message, MessengerCompat.a(message));
        }
    });
    BroadcastReceiver c = new BroadcastReceiver(this) {
        final /* synthetic */ b a;

        {
            this.a = r1;
        }

        public void onReceive(Context context, Intent intent) {
            if (Log.isLoggable("InstanceID", 3)) {
                intent.getStringExtra("registration_id");
                String valueOf = String.valueOf(intent.getExtras());
                Log.d("InstanceID", new StringBuilder(String.valueOf(valueOf).length() + 46).append("Received GSF callback using dynamic receiver: ").append(valueOf).toString());
            }
            this.a.a(intent);
            this.a.b();
        }
    };
    int d;
    int e;

    static void a(Context context) {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(g, "SYNC");
        context.startService(intent);
    }

    static void a(Context context, f fVar) {
        fVar.b();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra(g, "RST");
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    private void a(Message message, int i) {
        e.a((Context) this);
        getPackageManager();
        if (i == e.c || i == e.b) {
            a((Intent) message.obj);
            return;
        }
        int i2 = e.b;
        Log.w("InstanceID", "Message from unexpected caller " + i + " mine=" + i2 + " appid=" + e.c);
    }

    public void a() {
    }

    void a(int i) {
        synchronized (this) {
            this.d++;
            if (i > this.e) {
                this.e = i;
            }
        }
    }

    public void a(Intent intent) {
        a c;
        String stringExtra = intent.getStringExtra("subtype");
        if (stringExtra == null) {
            c = a.c(this);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("subtype", stringExtra);
            c = a.a((Context) this, bundle);
        }
        String stringExtra2 = intent.getStringExtra(g);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            if (Log.isLoggable("InstanceID", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                Log.d("InstanceID", new StringBuilder(((String.valueOf(stringExtra).length() + 18) + String.valueOf(stringExtra2).length()) + String.valueOf(valueOf).length()).append("Service command ").append(stringExtra).append(" ").append(stringExtra2).append(" ").append(valueOf).toString());
            }
            if (intent.getStringExtra("unregistered") != null) {
                f c2 = c.c();
                if (stringExtra == null) {
                    stringExtra = "";
                }
                c2.e(stringExtra);
                c.d().d(intent);
                return;
            } else if (h.equals(intent.getStringExtra("from"))) {
                c.c().e(stringExtra);
                a(false);
                return;
            } else if ("RST".equals(stringExtra2)) {
                c.b();
                a(true);
                return;
            } else if ("RST_FULL".equals(stringExtra2)) {
                if (!c.c().a()) {
                    c.c().b();
                    a(true);
                    return;
                }
                return;
            } else if ("SYNC".equals(stringExtra2)) {
                c.c().e(stringExtra);
                a(false);
                return;
            } else if (!"PING".equals(stringExtra2)) {
                return;
            } else {
                return;
            }
        }
        if (Log.isLoggable("InstanceID", 3)) {
            stringExtra2 = "InstanceID";
            String str = "Register result in service ";
            stringExtra = String.valueOf(stringExtra);
            Log.d(stringExtra2, stringExtra.length() != 0 ? str.concat(stringExtra) : new String(str));
        }
        c.d().d(intent);
    }

    public void a(boolean z) {
        a();
    }

    void b() {
        synchronized (this) {
            this.d--;
            if (this.d == 0) {
                stopSelf(this.e);
            }
            if (Log.isLoggable("InstanceID", 3)) {
                int i = this.d;
                Log.d("InstanceID", "Stop " + i + " " + this.e);
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return (intent == null || !"com.google.android.gms.iid.InstanceID".equals(intent.getAction())) ? null : this.b.a();
    }

    public void onCreate() {
        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentFilter.addCategory(getPackageName());
        registerReceiver(this.c, intentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    public void onDestroy() {
        unregisterReceiver(this.c);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        a(i2);
        if (intent == null) {
            b();
            return 2;
        }
        try {
            if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
                if (VERSION.SDK_INT <= 18) {
                    Intent intent2 = (Intent) intent.getParcelableExtra("GSF");
                    if (intent2 != null) {
                        startService(intent2);
                        return 1;
                    }
                }
                a(intent);
            }
            b();
            if (intent.getStringExtra("from") != null) {
                g.a(intent);
            }
            return 2;
        } finally {
            b();
        }
    }
}
