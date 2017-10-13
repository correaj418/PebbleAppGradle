package com.google.android.gms.gcm;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.util.Iterator;

public abstract class a extends Service {
    private final Object a = new Object();
    private int b;
    private int c = 0;

    @TargetApi(11)
    private void a(final Intent intent) {
        if (VERSION.SDK_INT >= 11) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable(this) {
                final /* synthetic */ a b;

                public void run() {
                    this.b.b(intent);
                }
            });
        } else {
            new AsyncTask<Void, Void, Void>(this) {
                final /* synthetic */ a b;

                protected Void a(Void... voidArr) {
                    this.b.b(intent);
                    return null;
                }

                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return a((Void[]) objArr);
                }
            }.execute(new Void[0]);
        }
    }

    static void a(Bundle bundle) {
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null && str.startsWith("google.c.")) {
                it.remove();
            }
        }
    }

    private void b() {
        synchronized (this.a) {
            this.c--;
            if (this.c == 0) {
                a(this.b);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(android.content.Intent r5) {
        /*
        r4 = this;
        r1 = r5.getAction();	 Catch:{ all -> 0x003d }
        r0 = -1;
        r2 = r1.hashCode();	 Catch:{ all -> 0x003d }
        switch(r2) {
            case 366519424: goto L_0x002f;
            default: goto L_0x000c;
        };	 Catch:{ all -> 0x003d }
    L_0x000c:
        switch(r0) {
            case 0: goto L_0x0039;
            default: goto L_0x000f;
        };	 Catch:{ all -> 0x003d }
    L_0x000f:
        r1 = "GcmListenerService";
        r2 = "Unknown intent action: ";
        r0 = r5.getAction();	 Catch:{ all -> 0x003d }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x003d }
        r3 = r0.length();	 Catch:{ all -> 0x003d }
        if (r3 == 0) goto L_0x0042;
    L_0x0021:
        r0 = r2.concat(r0);	 Catch:{ all -> 0x003d }
    L_0x0025:
        android.util.Log.d(r1, r0);	 Catch:{ all -> 0x003d }
    L_0x0028:
        r4.b();	 Catch:{ all -> 0x003d }
        android.support.v4.content.g.a(r5);
        return;
    L_0x002f:
        r2 = "com.google.android.c2dm.intent.RECEIVE";
        r1 = r1.equals(r2);	 Catch:{ all -> 0x003d }
        if (r1 == 0) goto L_0x000c;
    L_0x0037:
        r0 = 0;
        goto L_0x000c;
    L_0x0039:
        r4.c(r5);	 Catch:{ all -> 0x003d }
        goto L_0x0028;
    L_0x003d:
        r0 = move-exception;
        android.support.v4.content.g.a(r5);
        throw r0;
    L_0x0042:
        r0 = new java.lang.String;	 Catch:{ all -> 0x003d }
        r0.<init>(r2);	 Catch:{ all -> 0x003d }
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.a.b(android.content.Intent):void");
    }

    private void c(Intent intent) {
        String stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null) {
            stringExtra = "gcm";
        }
        Object obj = -1;
        switch (stringExtra.hashCode()) {
            case -2062414158:
                if (stringExtra.equals("deleted_messages")) {
                    obj = 1;
                    break;
                }
                break;
            case 102161:
                if (stringExtra.equals("gcm")) {
                    obj = null;
                    break;
                }
                break;
            case 814694033:
                if (stringExtra.equals("send_error")) {
                    obj = 3;
                    break;
                }
                break;
            case 814800675:
                if (stringExtra.equals("send_event")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                d(intent);
                return;
            case 1:
                a();
                return;
            case 2:
                a(intent.getStringExtra("google.message_id"));
                return;
            case 3:
                a(intent.getStringExtra("google.message_id"), intent.getStringExtra("error"));
                return;
            default:
                String str = "GcmListenerService";
                String str2 = "Received message with unknown type: ";
                stringExtra = String.valueOf(stringExtra);
                Log.w(str, stringExtra.length() != 0 ? str2.concat(stringExtra) : new String(str2));
                return;
        }
    }

    private void d(Intent intent) {
        Bundle extras = intent.getExtras();
        extras.remove("message_type");
        extras.remove("android.support.content.wakelockid");
        if (g.a(extras)) {
            if (g.b((Context) this)) {
                g.b(extras);
            } else {
                g.a((Context) this).c(extras);
                return;
            }
        }
        String string = extras.getString("from");
        extras.remove("from");
        a(extras);
        a(string, extras);
    }

    public void a() {
    }

    public void a(String str) {
    }

    public void a(String str, Bundle bundle) {
    }

    public void a(String str, String str2) {
    }

    boolean a(int i) {
        return stopSelfResult(i);
    }

    public final IBinder onBind(Intent intent) {
        return null;
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.a) {
            this.b = i2;
            this.c++;
        }
        if (intent == null) {
            b();
            return 2;
        }
        a(intent);
        return 3;
    }
}
