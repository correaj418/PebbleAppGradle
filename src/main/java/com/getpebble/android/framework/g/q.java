package com.getpebble.android.framework.g;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.common.model.ad;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.framework.install.d;
import com.google.a.b.am;
import com.google.a.f.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class q extends ac {
    private final Context a;
    private Uri b = null;
    private b c = b.IDLE;
    private FrameworkState d;
    private String e;
    private String f = null;
    private int g = 0;
    private final z h;
    private final b i = new b(this) {
        final /* synthetic */ q a;

        {
            this.a = r1;
        }

        public void a(e eVar, e eVar2, e eVar3) {
            f.d("InstallFileEndpoint", "ProgressUpdated; current progress: " + eVar2.intValue());
            int round = Math.round((eVar2.floatValue() / eVar3.floatValue()) * 100.0f);
            if (this.a.d != null) {
                this.a.d.b(round);
            }
        }

        public void a(e eVar) {
            f.d("InstallFileEndpoint", "Transfer complete");
            synchronized (this.a) {
                this.a.c = b.INSTALLING;
                if (eVar == null) {
                    f.d("InstallFileEndpoint", "Missing cookie!");
                    this.a.a(a.ERROR_FILE_INSTALL_FAILED);
                    return;
                }
                f.d("InstallFileEndpoint", "Installing file object");
                this.a.h.c(eVar);
            }
        }

        public void a(com.getpebble.android.framework.g.z.a aVar) {
            f.d("InstallFileEndpoint", "Transfer failed");
            this.a.a(a.from(aVar));
        }

        public void b(e eVar) {
            f.d("InstallFileEndpoint", "Install complete");
            if ("lang".equals(this.a.e)) {
                c.a(this.a.f);
                PebbleDevice n = PebbleApplication.n();
                if (n != null) {
                    ak.updateLanguageInfo(this.a.a.getContentResolver(), n, this.a.f, this.a.g);
                }
            }
            this.a.a(a.SUCCESS);
        }

        public void b(com.getpebble.android.framework.g.z.a aVar) {
            f.d("InstallFileEndpoint", "Install failed");
            if ("lang".equals(this.a.e)) {
                c.b(this.a.f);
            }
            this.a.a(a.ERROR_FILE_INSTALL_FAILED);
        }
    };

    public enum a {
        SUCCESS(0),
        ERROR_PRF(-1),
        ERROR_INSTALL_IN_PROGRESS(-2),
        ERROR_FILE_LOAD(-7),
        ERROR_FILE_INSTALL_FAILED(-10),
        ERROR_TIMEOUT(-12),
        ERROR_NO_CONNECTED_DEVICE(-15),
        ERROR_CANCELLED(-16),
        ERROR_UNKNOWN(-100);
        
        private int mValue;

        private a(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }

        public static a fromValue(int i) {
            for (a aVar : values()) {
                if (aVar.getValue() == i) {
                    return aVar;
                }
            }
            return ERROR_UNKNOWN;
        }

        public static a from(com.getpebble.android.framework.g.z.a aVar) {
            if (aVar == null) {
                return ERROR_FILE_INSTALL_FAILED;
            }
            switch (aVar) {
                case OK:
                    return SUCCESS;
                case CANCELLED:
                    return ERROR_CANCELLED;
                case TIMEOUT:
                    return ERROR_TIMEOUT;
                default:
                    return ERROR_FILE_INSTALL_FAILED;
            }
        }
    }

    public enum b {
        IDLE,
        SENDING_FILE,
        INSTALLING
    }

    public q(final Context context, p pVar, z zVar) {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        } else if (pVar == null) {
            throw new IllegalArgumentException("'messageSender' cannot be null!");
        } else {
            this.a = context;
            this.h = zVar;
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ q b;

                public void run() {
                    ad adVar = new ad(context, PebbleApplication.r());
                    if (adVar.a()) {
                        f.d("InstallFileEndpoint", "Updating language pack");
                        adVar.b();
                        return;
                    }
                    f.e("InstallFileEndpoint", "Not updating language pack");
                }
            });
        }
    }

    Set<com.getpebble.android.bluetooth.g.a> a() {
        return am.b(com.getpebble.android.bluetooth.g.a.FILE_INSTALL_MANAGER);
    }

    private void a(a aVar) {
        f.d("InstallFileEndpoint", "finish: Install complete with result: " + aVar);
        if (this.d != null) {
            this.d.a(aVar.getValue(), this.b);
        }
        c();
    }

    private synchronized void c() {
        this.c = b.IDLE;
        this.b = null;
        this.h.b(this.i);
        this.d = null;
    }

    synchronized void a(final Uri uri, final String str) {
        new com.getpebble.android.bluetooth.b.f(this) {
            final /* synthetic */ q c;

            public boolean doInBackground() {
                return this.c.b(uri, str);
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
    }

    synchronized boolean b(Uri uri, String str) {
        boolean z = false;
        synchronized (this) {
            if (this.c != b.IDLE) {
                f.d("InstallFileEndpoint", "addFileSync: Already installing");
                if (this.d != null) {
                    this.d.a(a.ERROR_INSTALL_IN_PROGRESS.getValue(), uri);
                }
            } else {
                File file = new File(uri.getPath());
                if (file.exists()) {
                    f.d("InstallFileEndpoint", "addFileSync: Sending byte data");
                    this.c = b.SENDING_FILE;
                    this.b = uri;
                    if (a(file, str)) {
                        f.d("InstallFileEndpoint", "addFileSync: Starting transfer");
                        this.h.c(0);
                        z = true;
                    } else {
                        f.a("InstallFileEndpoint", "addFileSync: Failed to set up put bytes endpoint");
                        a(a.ERROR_FILE_LOAD);
                    }
                } else {
                    f.a("InstallFileEndpoint", "addFileSync: Failed to open file for URI: " + uri);
                    a(a.ERROR_FILE_LOAD);
                }
            }
        }
        return z;
    }

    private boolean a(File file, String str) {
        if (file == null) {
            f.a("InstallFileEndpoint", "setupPutBytesEndpoint: No data to create PutBytesEndpoint");
            return false;
        } else if (TextUtils.isEmpty(str)) {
            f.a("InstallFileEndpoint", "setupPutBytesEndpoint: Filename required");
            return false;
        } else if (this.h.a(this.i)) {
            try {
                InputStream fileInputStream = new FileInputStream(file);
                int intValue = Long.valueOf(file.length()).intValue();
                try {
                    this.h.a(com.getpebble.android.common.framework.install.b.FILE).a(fileInputStream).a(str).a(intValue).a(e.a(a(file))).b(0);
                    return true;
                } catch (IOException e) {
                    c.a.a.a.e.a(fileInputStream);
                    return false;
                }
            } catch (Throwable e2) {
                f.a("InstallFileEndpoint", "setupPutBytesEndpoint: Failed to open input stream", e2);
                c.a.a.a.e.a(null);
                return false;
            }
        } else {
            f.a("InstallFileEndpoint", "setupPutBytesEndpoint: Failed to register listener with put bytes endpoint");
            return false;
        }
    }

    private int a(File file) {
        byte[] b = com.google.a.c.e.b(file);
        return new d().a(b, b.length).a();
    }

    boolean a(k kVar, FrameworkState frameworkState) {
        f.d("InstallFileEndpoint", "onRequest: Got request: " + kVar.b());
        this.d = frameworkState;
        switch (kVar.b()) {
            case ADD_FILE:
                Uri uri = (Uri) kVar.c(com.getpebble.android.framework.g.k.b.URI);
                this.e = kVar.b(com.getpebble.android.framework.g.k.b.FILE_NAME);
                this.f = kVar.b(com.getpebble.android.framework.g.k.b.ISO_LOCALE);
                this.g = kVar.a(com.getpebble.android.framework.g.k.b.LANGUAGE_VERSION).intValue();
                a(uri, this.e);
                return true;
            default:
                f.d("InstallFileEndpoint", "onRequest: Got unexpected request: " + kVar.b());
                return false;
        }
    }

    boolean a(com.getpebble.android.bluetooth.g.b bVar) {
        f.a("InstallFileEndpoint", "onRequest: Received unsupported, unexpected protocol message " + bVar.toString());
        return false;
    }

    void b() {
    }
}
