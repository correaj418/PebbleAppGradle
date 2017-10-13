package com.getpebble.android.framework.g;

import android.content.ContentResolver;
import android.content.Context;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.install.PebbleManifest.ResourceInfo;
import com.getpebble.android.common.framework.install.app.AppManifest;
import com.getpebble.android.common.framework.install.app.b;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.framework.l.a.c;
import com.google.a.b.am;
import com.google.a.f.e;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class a extends ac {
    private final p a;
    private final z b;
    private final com.getpebble.android.common.framework.install.app.b.a c;
    private b d;
    private a e = a.IDLE;
    private int f;
    private e g;
    private int h;
    private List<e> i = new ArrayList();
    private b j = new b(this) {
        final /* synthetic */ a a;

        {
            this.a = r1;
        }

        public void a(e eVar, e eVar2, e eVar3) {
            f.d("AppFetchEndpoint", "ProgressUpdated current = " + eVar2 + " max = " + eVar3);
        }

        public void a(e eVar) {
            this.a.i.add(eVar);
            if (this.a.e()) {
                f.d("AppFetchEndpoint", "transferComplete: Transfer complete. Sending next binary...");
                this.a.d();
                return;
            }
            f.d("AppFetchEndpoint", "transferComplete: Transfer complete. Sending install messages...");
            this.a.h = 0;
            this.a.f();
        }

        public void a(com.getpebble.android.framework.g.z.a aVar) {
            synchronized (this.a) {
                f.a("AppFetchEndpoint", "transferFailed: transfer failed");
                this.a.e = a.IDLE;
                this.a.d.e();
                this.a.b.b(this.a.j);
            }
        }

        public void b(e eVar) {
            if (this.a.h < this.a.d.b(this.a.c).size()) {
                this.a.f();
                return;
            }
            synchronized (this.a) {
                f.d("AppFetchEndpoint", "installComplete: Transfer (install) succeeded. Releasing putbytes client");
                this.a.e = a.IDLE;
                this.a.d.e();
                this.a.b.b(this.a.j);
            }
        }

        public void b(com.getpebble.android.framework.g.z.a aVar) {
            synchronized (this.a) {
                f.a("AppFetchEndpoint", "installFailed: ");
                this.a.e = a.IDLE;
                this.a.d.e();
                this.a.b.b(this.a.j);
            }
        }
    };

    public enum a {
        IDLE,
        FETCHING_BUNDLE,
        SENDING_BYTES
    }

    public a(p pVar, z zVar, ContentResolver contentResolver) {
        this.a = pVar;
        this.b = zVar;
        com.getpebble.android.common.model.ak.a pebbleDeviceRecord = ak.getPebbleDeviceRecord(contentResolver, this.a.e());
        if (pebbleDeviceRecord == null) {
            throw new IllegalStateException("connectedDevice cannot be null (for device " + this.a.e() + ")");
        }
        this.c = pebbleDeviceRecord.hwPlatform.getPlatformCode();
        f.d("AppFetchEndpoint", "mConnectedDevicePlatform = " + this.c);
    }

    boolean a(k kVar, FrameworkState frameworkState) {
        return false;
    }

    Set<com.getpebble.android.bluetooth.g.a> a() {
        return am.b(com.getpebble.android.bluetooth.g.a.APP_FETCH);
    }

    boolean a(com.getpebble.android.bluetooth.g.b bVar) {
        c cVar = new c(bVar);
        switch (cVar.c()) {
            case UNKNOWN:
                f.a("AppFetchEndpoint", "onReceive: Unknown command");
                break;
            case FETCH:
                a(cVar.d(), cVar.e());
                break;
        }
        return true;
    }

    void b() {
    }

    private void a(com.getpebble.android.framework.l.b.e.b bVar) {
        f.d("AppFetchEndpoint", "sendResultToWatch: Sending result to watch: " + bVar);
        this.a.a(com.getpebble.android.framework.l.b.e.a(bVar));
    }

    private synchronized void a(final UUID uuid, e eVar) {
        if (a.IDLE.equals(this.e)) {
            f.d("AppFetchEndpoint", "startInstall: uuid = " + uuid + " appId = " + eVar);
            this.g = eVar;
            new com.getpebble.android.bluetooth.b.f(this) {
                final /* synthetic */ a b;
                private final String c = "AppFetchEndpoint";

                public boolean doInBackground() {
                    Context K = com.getpebble.android.common.a.K();
                    com.getpebble.android.common.model.am.c a = com.getpebble.android.common.model.am.a(uuid, K.getContentResolver(), true);
                    if (a == null) {
                        synchronized (this.b) {
                            f.c("AppFetchEndpoint", "PebbleAsyncTask: doInBackground: app is null - not found in locker");
                            this.b.a(com.getpebble.android.framework.l.b.e.b.UUID_INVALID);
                            this.b.e = a.IDLE;
                        }
                        return false;
                    } else if (a.H.b(this.b.c)) {
                        this.b.d = new com.getpebble.android.framework.install.a.a(K).b(a);
                        if (this.b.d == null) {
                            f.a("AppFetchEndpoint", "PebbleAsyncTask: doInBackground: Failed to get App Bundle");
                            synchronized (this.b) {
                                this.b.a(com.getpebble.android.framework.l.b.e.b.NO_DATA);
                                this.b.e = a.IDLE;
                            }
                            return false;
                        }
                        com.getpebble.android.framework.jskit.c.a(K).a(this.b.d);
                        this.b.c();
                        return true;
                    } else {
                        synchronized (this.b) {
                            f.c("AppFetchEndpoint", "PebbleAsyncTask: doInBackground: App does not support platform " + this.b.c + "; not sending");
                            this.b.a(com.getpebble.android.framework.l.b.e.b.UUID_INVALID);
                            this.b.e = a.IDLE;
                        }
                        return false;
                    }
                }

                public void onTaskSuccess() {
                }

                public void onTaskFailed() {
                }
            }.submit();
        } else {
            f.b("AppFetchEndpoint", "startInstall: Cannot fetch app: state is " + this.e);
            a(com.getpebble.android.framework.l.b.e.b.BUSY);
        }
    }

    private synchronized void c() {
        this.f = 0;
        this.i.clear();
        this.e = a.SENDING_BYTES;
        a(com.getpebble.android.framework.l.b.e.b.STARTING);
        d();
    }

    private synchronized void d() {
        f.d("AppFetchEndpoint", "sendNextFile: Sending byte data: " + this.f);
        com.getpebble.android.common.framework.install.b bVar = (com.getpebble.android.common.framework.install.b) this.d.b(this.c).get(this.f);
        this.f++;
        if (a(bVar)) {
            f.d("AppFetchEndpoint", "sendNextFile: Starting transfer for type " + bVar);
            this.b.c(0);
        } else {
            a(com.getpebble.android.framework.l.b.e.b.BUSY);
            this.b.b(this.j);
            this.e = a.IDLE;
            this.d.e();
        }
    }

    private boolean e() {
        if (this.d == null || this.c == null) {
            f.a("AppFetchEndpoint", "hasNextFile: Failed to check hasNextFile");
            return false;
        } else if (this.f < this.d.b(this.c).size()) {
            return true;
        } else {
            return false;
        }
    }

    private synchronized void f() {
        f.d("AppFetchEndpoint", "installNextCookie: index = " + this.h);
        this.b.c((e) this.i.get(this.h));
        this.h++;
    }

    private boolean a(com.getpebble.android.common.framework.install.b bVar) {
        boolean z = false;
        if (this.b.a(this.j)) {
            AppManifest e = this.d.e(this.c);
            if (e == null) {
                f.d("AppFetchEndpoint", "setupPutBytesEndpoint: Manifest is null. No data to create PutBytesEndpoint.");
                return z;
            }
            ResourceInfo resourceInfo = null;
            switch (bVar) {
                case APP_RESOURCES:
                    resourceInfo = e.getResourceInfo();
                    break;
                case APP:
                    resourceInfo = e.getAppInfo();
                    break;
                case WORKER:
                    resourceInfo = e.getWorker();
                    break;
                default:
                    f.b("AppFetchEndpoint", "setupPutBytesEndpoint: Unhandled PutBytesType: " + bVar);
                    break;
            }
            if (resourceInfo == null) {
                f.d("AppFetchEndpoint", "setupPutBytesEndpoint: No data to create PutBytesEndpoint");
                return z;
            }
            try {
                InputStream a = this.d.a(resourceInfo.getName(), this.c);
                int size = resourceInfo.getSize();
                this.b.a(bVar).a(a).a(size).a(resourceInfo.getCrc()).b(this.g);
                return true;
            } catch (Throwable e2) {
                f.a("AppFetchEndpoint", "setupPutBytesEndpoint: Failed to open app bundle", e2);
                return z;
            }
        }
        f.a("AppFetchEndpoint", "setupPutBytesEndpoint: Failed to set put bytes endpoint listener");
        return z;
    }
}
