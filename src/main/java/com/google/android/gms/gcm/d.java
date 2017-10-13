package com.google.android.gms.gcm;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

public abstract class d extends Service {
    private final Set<String> a = new HashSet();
    private int b;

    private class a extends Thread {
        final /* synthetic */ d a;
        private final String b;
        private final h c;
        private final Bundle d;

        a(d dVar, String str, IBinder iBinder, Bundle bundle) {
            this.a = dVar;
            super(String.valueOf(str).concat(" GCM Task"));
            this.b = str;
            this.c = com.google.android.gms.gcm.h.a.a(iBinder);
            this.d = bundle;
        }

        public void run() {
            Process.setThreadPriority(10);
            try {
                this.c.a(this.a.a(new f(this.b, this.d)));
            } catch (RemoteException e) {
                String str = "GcmTaskService";
                String str2 = "Error reporting result of operation to scheduler for ";
                String valueOf = String.valueOf(this.b);
                Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            } finally {
                this.a.a(this.b);
            }
        }
    }

    private void a(int i) {
        synchronized (this.a) {
            this.b = i;
            if (this.a.size() == 0) {
                stopSelf(this.b);
            }
        }
    }

    private void a(String str) {
        synchronized (this.a) {
            this.a.remove(str);
            if (this.a.size() == 0) {
                stopSelf(this.b);
            }
        }
    }

    public abstract int a(f fVar);

    public void a() {
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            a(i2);
        } else {
            try {
                intent.setExtrasClassLoader(PendingCallback.class.getClassLoader());
                String action = intent.getAction();
                if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(action)) {
                    String stringExtra = intent.getStringExtra("tag");
                    Parcelable parcelableExtra = intent.getParcelableExtra("callback");
                    Bundle bundle = (Bundle) intent.getParcelableExtra("extras");
                    if (parcelableExtra == null || !(parcelableExtra instanceof PendingCallback)) {
                        String valueOf = String.valueOf(getPackageName());
                        Log.e("GcmTaskService", new StringBuilder((String.valueOf(valueOf).length() + 47) + String.valueOf(stringExtra).length()).append(valueOf).append(" ").append(stringExtra).append(": Could not process request, invalid callback.").toString());
                    } else {
                        synchronized (this.a) {
                            this.a.add(stringExtra);
                        }
                        new a(this, stringExtra, ((PendingCallback) parcelableExtra).a(), bundle).start();
                    }
                } else if ("com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(action)) {
                    a();
                } else {
                    Log.e("GcmTaskService", new StringBuilder(String.valueOf(action).length() + 37).append("Unknown action received ").append(action).append(", terminating").toString());
                }
                a(i2);
            } finally {
                a(i2);
            }
        }
        return 2;
    }
}
