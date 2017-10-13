package com.getpebble.android.framework.install.firmware;

import android.content.Context;
import android.net.Uri;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.common.model.FrameworkState.FirmwareInstallData;
import com.getpebble.android.common.model.v;
import com.getpebble.android.framework.g.l;
import com.getpebble.android.framework.g.r;

public class c {
    private boolean a = false;
    private boolean b = false;
    private b c;
    private boolean d;
    private boolean e;
    private final a f;

    private static class a {
        private Uri a;
        private boolean b;

        private a() {
            this.a = null;
            this.b = false;
        }
    }

    private class b implements com.getpebble.android.framework.g.r.c {
        final /* synthetic */ c a;
        private com.getpebble.android.framework.b.a b;
        private FrameworkState c;

        public b(c cVar, com.getpebble.android.framework.b.a aVar, FrameworkState frameworkState) {
            this.a = cVar;
            this.b = aVar;
            this.c = frameworkState;
        }

        public void a(com.getpebble.android.framework.g.r.a aVar) {
            f.d("FirmwareInstallManager", "Install failed with result: " + aVar.toString());
            if (com.getpebble.android.framework.g.r.a.INTERRUPTED.equals(aVar)) {
                f.d("FirmwareInstallManager", "installFail: install was interrupted. Caching the result");
                this.a.f.b = true;
            } else {
                this.a.f.b = false;
            }
            this.a.a(this.b, this.c, aVar);
        }

        public void b(com.getpebble.android.framework.g.r.a aVar) {
            this.a.f.b = false;
            this.a.a(this.b, this.c, aVar);
        }

        public void a(int i) {
            this.c.a(i);
        }
    }

    public c(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        }
        this.f = new a();
    }

    private Context a() {
        return com.getpebble.android.common.a.K();
    }

    public void a(final com.getpebble.android.framework.b.a aVar, final Uri uri, final FrameworkState frameworkState) {
        f.d("FirmwareInstallManager", "installFirmware() device = " + aVar.a() + " uri = " + uri);
        a(aVar, new Runnable(this) {
            final /* synthetic */ c d;

            public void run() {
                this.d.f.a = uri;
                a a = this.d.a(uri);
                if (a == null) {
                    f.c("FirmwareInstallManager", "installFirmware: bundle is null");
                    this.d.a(aVar, frameworkState, com.getpebble.android.framework.g.r.a.BUNDLE_NOT_FOUND);
                    return;
                }
                this.d.a(a, aVar, frameworkState);
            }
        }, frameworkState);
    }

    public void a(final com.getpebble.android.framework.b.a aVar, final FrameworkState frameworkState) {
        f.d("FirmwareInstallManager", "installLatestFirmware() device = " + aVar.a());
        a(aVar, new Runnable(this) {
            final /* synthetic */ c c;

            public void run() {
                a a = this.c.a(aVar.a());
                if (this.c.b) {
                    this.c.a(a);
                    this.c.b = false;
                }
                this.c.a(a, aVar, frameworkState);
            }
        }, frameworkState);
    }

    private void a(com.getpebble.android.framework.b.a aVar, final Runnable runnable, FrameworkState frameworkState) {
        f.d("FirmwareInstallManager", "installAsync()");
        synchronized (this) {
            if (this.a) {
                f.b("FirmwareInstallManager", "installAsync: Attempting to install while busy. Dropping this install request...");
                return;
            }
            this.a = true;
            f.d("FirmwareInstallManager", "Initializing...");
            this.e = false;
            frameworkState.a(com.getpebble.android.framework.g.r.a.IN_PROGRESS);
            this.d = aVar.c();
            new com.getpebble.android.bluetooth.b.f(this) {
                final /* synthetic */ c b;

                public boolean doInBackground() {
                    runnable.run();
                    return true;
                }

                public void onTaskSuccess() {
                }

                public void onTaskFailed() {
                }
            }.submit();
        }
    }

    private void a(a aVar, com.getpebble.android.framework.b.a aVar2, FrameworkState frameworkState) {
        if (aVar == null) {
            f.a("FirmwareInstallManager", "Failed to find bundle");
            com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
            com.getpebble.android.common.b.a.a.c.c(r == null ? "<unknown>" : r.getFwVersion().getVersionTag());
            a(aVar2, frameworkState, com.getpebble.android.framework.g.r.a.BUNDLE_NOT_FOUND);
            return;
        }
        this.c = new b(this, aVar2, frameworkState);
        v l = aVar.l();
        FirmwareManifest h = aVar.h();
        if (!(l == null || h == null)) {
            frameworkState.a(new FirmwareInstallData(l.getVersionTag(), h.getFirmware().getType().mTypeName));
        }
        l rVar = new r(aVar2, aVar, this.c, a().getContentResolver());
        this.e = aVar2.b(rVar);
        if (this.e) {
            rVar.i();
            return;
        }
        f.d("FirmwareInstallManager", "Couldn't set firmware install endpoint set");
        a(aVar2, frameworkState, com.getpebble.android.framework.g.r.a.ENDPOINT_NOT_ACTIVE);
        aVar.e();
    }

    private a a(Uri uri) {
        if (a() != null) {
            return (a) new b(a()).a(uri);
        }
        f.a("FirmwareInstallManager", "Cannot get firmware bundle, context is null");
        return null;
    }

    private a a(PebbleDevice pebbleDevice) {
        String b = new com.getpebble.android.framework.firmware.a(a()).b(pebbleDevice);
        if (b == null) {
            f.d("FirmwareInstallManager", "No firmware found for device.");
            return null;
        }
        b bVar = new b(a());
        Uri parse = Uri.parse(b);
        this.f.a = parse;
        return (a) bVar.a(parse);
    }

    private void a(com.getpebble.android.framework.b.a aVar, FrameworkState frameworkState, com.getpebble.android.framework.g.r.a aVar2) {
        f.d("FirmwareInstallManager", "Sending install result: " + aVar2);
        frameworkState.a(aVar2);
        a(aVar, aVar2);
    }

    private void a(com.getpebble.android.framework.b.a aVar, com.getpebble.android.framework.g.r.a aVar2) {
        f.d("FirmwareInstallManager", "cleanup()");
        if (this.e) {
            switch (aVar2) {
                case WRONG_HW_VERSION:
                case BUNDLE_NOT_FOUND:
                case ENDPOINT_NOT_ACTIVE:
                    if (!this.d) {
                        aVar.a(a());
                        break;
                    } else {
                        aVar.b(a());
                        break;
                    }
                default:
                    f.d("FirmwareInstallManager", "Not initing an endpoint set (waiting for reboot); forcing disconnection for result: " + aVar2);
                    break;
            }
        }
        this.c = null;
        synchronized (this) {
            this.a = false;
        }
    }

    public void b(com.getpebble.android.framework.b.a aVar, FrameworkState frameworkState) {
        if (b()) {
            f.d("FirmwareInstallManager", "requestRestart: restarting update");
            this.b = true;
            a(aVar, this.f.a, frameworkState);
            return;
        }
        f.d("FirmwareInstallManager", "requestRestart: dropping request, no restart required");
    }

    private boolean b() {
        com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
        com.getpebble.android.common.b.b.c y = PebbleApplication.y();
        boolean a = a(p);
        boolean a2 = a(y);
        f.d("FirmwareInstallManager", "shouldRestart: isResumableUpdateSupported=" + a + "; isResumableUpdateDisabled=" + a2);
        a = a && !a2;
        if (!a) {
            return false;
        }
        if (this.f.a != null) {
            return this.f.b;
        }
        f.d("FirmwareInstallManager", "shouldRestart: no uri");
        return false;
    }

    private boolean a(com.getpebble.android.common.b.b.c cVar) {
        if (cVar.a(com.getpebble.android.common.b.b.c.a.DISABLE_RESUMED_UPDATES_USER, false)) {
            return true;
        }
        return cVar.a(com.getpebble.android.common.b.b.c.a.DISABLE_RESUMED_UPDATES_ERROR, false);
    }

    private boolean a(com.getpebble.android.common.model.ak.a aVar) {
        if (aVar == null) {
            return false;
        }
        return aVar.capabilities.supportsFwUpdateAcrossDisconnection;
    }

    private void a(a aVar) {
        String str = "";
        if (!(aVar == null || aVar.l() == null)) {
            str = aVar.l().toString();
        }
        String str2 = "";
        if (!(aVar == null || aVar.h() == null || aVar.h().getFirmware() == null || aVar.h().getType() == null)) {
            str2 = aVar.h().getFirmware().getType().toString();
        }
        com.getpebble.android.common.b.a.a.c.g(str, str2);
    }
}
