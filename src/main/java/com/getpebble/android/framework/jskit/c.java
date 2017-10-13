package com.getpebble.android.framework.jskit;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.g.b;
import com.getpebble.android.common.model.AppInfo;
import com.getpebble.android.common.model.ak.a;
import com.getpebble.android.framework.PebbleFrameworkService;
import com.getpebble.android.framework.e;
import com.getpebble.jskit.android.impl.runtime.model.JsApplicationInfo;
import com.google.b.g;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class c {
    private static c a;
    private final LruCache<UUID, JsApplicationInfo> b;
    private final a c;
    private final File d;
    private final Handler e;

    c(File file, Looper looper, LruCache<UUID, JsApplicationInfo> lruCache, a aVar) {
        this.d = file;
        this.b = lruCache;
        this.c = aVar;
        this.e = new Handler(looper);
    }

    public static String a() {
        return "js_app_files";
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                File dir = context.getDir("js_app_files", 0);
                Executors.newSingleThreadExecutor(new b("JsAppManager"));
                a = new c(dir, e.b().getLooper(), new LruCache(5), new a());
            }
            cVar = a;
        }
        return cVar;
    }

    File a(File file, String str) {
        return new File(file, str);
    }

    boolean a(File file) {
        return c.a.a.a.b.b(file);
    }

    File a(UUID uuid) {
        return a(this.d, uuid.toString());
    }

    boolean b(File file) {
        return file.exists();
    }

    Reader c(File file) {
        return new FileReader(file);
    }

    AppInfo a(Reader reader) {
        try {
            g gVar = new g();
            gVar.a(com.google.a.f.e.class, new com.getpebble.android.common.framework.install.app.b.c());
            return (AppInfo) gVar.c().a(reader, AppInfo.class);
        } catch (Throwable e) {
            f.a("JsAppManager", "getAppInfoFromDisk: bad json!", e);
            return null;
        }
    }

    JsApplicationInfo b(UUID uuid) {
        File a = a(uuid);
        if (b(a)) {
            File a2 = a(a, "pebble-js-app.js");
            try {
                Reader c = c(a(a, "appinfo.json"));
                AppInfo a3 = a(c);
                c.close();
                if (a3 == null) {
                    return null;
                }
                if (uuid.equals(a3.getUuid())) {
                    JsApplicationInfo jsApplicationInfo = new JsApplicationInfo();
                    jsApplicationInfo.a(uuid.toString());
                    jsApplicationInfo.a(a3.getAppKeys());
                    jsApplicationInfo.b(a3.getShortName());
                    jsApplicationInfo.c(a3.getLongName());
                    jsApplicationInfo.d(a3.getCompanyName());
                    jsApplicationInfo.e(a3.getVersionLabel());
                    jsApplicationInfo.f(a3.getSdkVersion());
                    jsApplicationInfo.a(a3.getTargetPlatforms());
                    jsApplicationInfo.a(a3.isWatchFace());
                    jsApplicationInfo.g(a2.toString());
                    jsApplicationInfo.b(a3.getCapabilities());
                    f.d("JsAppManager", "getAppInfoFromDisk: retrieved JsApplicationInfo for " + uuid);
                    return jsApplicationInfo;
                }
                f.a("JsAppManager", "getAppInfoFromDisk: UUID mismatch! expected " + uuid + " but was " + a3.getUuid());
                return null;
            } catch (Throwable e) {
                f.a("JsAppManager", "getAppInfoFromDisk: could not get info for " + uuid, e);
                return null;
            }
        }
        f.d("JsAppManager", "getAppInfoFromDisk: appDirectory does not exist for " + uuid);
        return null;
    }

    JsApplicationInfo c(UUID uuid) {
        return (JsApplicationInfo) this.b.get(uuid);
    }

    JsApplicationInfo d(UUID uuid) {
        return (JsApplicationInfo) this.b.remove(uuid);
    }

    void a(UUID uuid, JsApplicationInfo jsApplicationInfo) {
        this.b.put(uuid, jsApplicationInfo);
    }

    JsApplicationInfo e(UUID uuid) {
        JsApplicationInfo c = c(uuid);
        if (c == null) {
            c = b(uuid);
            if (c != null) {
                a(uuid, c);
            }
        }
        return c;
    }

    public boolean f(UUID uuid) {
        return e(uuid) != null;
    }

    void g(UUID uuid) {
        PebbleFrameworkService.a().a(uuid.toString());
    }

    void a(JsApplicationInfo jsApplicationInfo, boolean z) {
        PebbleFrameworkService.a().a(jsApplicationInfo, z);
    }

    void h(UUID uuid) {
        PebbleFrameworkService.a().a(uuid);
    }

    synchronized void a(boolean z, final UUID uuid, Handler handler) {
        f.d("JsAppManager", "handleLifecycleEvent: started = " + z + " appUuid = " + uuid);
        final boolean b = this.c.b(uuid);
        if (z) {
            final JsApplicationInfo e = e(uuid);
            if (e == null) {
                f.b("JsAppManager", "handleLifecycleEvent: could not get JsApplicationInfo for " + uuid);
            } else {
                handler.post(new Runnable(this) {
                    final /* synthetic */ c c;

                    public void run() {
                        boolean z = false;
                        if (this.c.b() == null) {
                            f.c("JsAppManager", "handleLifecycleEvent: dropping started event because Pebble is disconnected");
                            return;
                        }
                        if (!e.m()) {
                            f.d("JsAppManager", "handleLifecycleEvent: Config is not supported; not launching config window.");
                        } else if (b) {
                            f.d("JsAppManager", "handleLifecycleEvent: Config launch is requested; launching config window.");
                            z = true;
                        } else {
                            f.e("JsAppManager", "handleLifecycleEvent: Not launching config");
                        }
                        this.c.a(e, z);
                    }
                });
            }
        } else {
            handler.post(new Runnable(this) {
                final /* synthetic */ c b;

                public void run() {
                    this.b.g(uuid);
                }
            });
        }
    }

    public void b(final boolean z, final UUID uuid, final Handler handler) {
        this.e.post(new Runnable(this) {
            final /* synthetic */ c d;

            public void run() {
                this.d.a(z, uuid, handler);
            }
        });
    }

    a b() {
        return PebbleApplication.r();
    }

    boolean a(a aVar, UUID uuid) {
        return uuid.equals(aVar.currentRunningApp);
    }

    void i(UUID uuid) {
        PebbleApplication.x().a(uuid);
    }

    synchronized void a(UUID uuid, Handler handler) {
        f.d("JsAppManager", "handleConfigRequest: " + uuid);
        if (this.c.b(uuid)) {
            f.b("JsAppManager", "handleConfigRequest: previous config request found");
        }
        a b = b();
        if (b == null) {
            f.a("JsAppManager", "handleConfigRequest: no Pebble connected");
        } else {
            final JsApplicationInfo e = e(uuid);
            if (e == null) {
                f.a("JsAppManager", "handleConfigRequest: could not get AppInfo - storing config request for post-install launch");
                this.c.a(uuid);
            } else if (a(b, uuid)) {
                f.d("JsAppManager", "handleConfigRequest: app running on watch, running script");
                handler.post(new Runnable(this) {
                    final /* synthetic */ c b;

                    public void run() {
                        this.b.a(e, true);
                    }
                });
            } else {
                f.d("JsAppManager", "handleConfigRequest: app not running on watch, making request");
                this.c.a(uuid);
                i(uuid);
            }
        }
    }

    public void a(final com.getpebble.android.common.framework.install.app.b bVar) {
        if (Looper.myLooper() == this.e.getLooper()) {
            d(bVar);
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.e.post(new Runnable(this) {
            final /* synthetic */ c c;

            public void run() {
                this.c.d(bVar);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (Throwable e) {
            f.a("JsAppManager", "putBlocking", e);
        }
    }

    private void d(com.getpebble.android.common.framework.install.app.b bVar) {
        f.d("JsAppManager", "put: requesting put for AppBundle " + bVar);
        if (!b(bVar) && bVar.f()) {
            f.a("JsAppManager", "put: Could not store JS for " + bVar.i().getUuid());
        }
    }

    public void j(UUID uuid) {
        f.d("JsAppManager", "queueConfigRequest(" + uuid.toString() + ")");
        this.c.a(uuid);
    }

    public void b(final UUID uuid, final Handler handler) {
        this.e.post(new Runnable(this) {
            final /* synthetic */ c c;

            public void run() {
                this.c.a(uuid, handler);
            }
        });
    }

    boolean d(File file) {
        return file.mkdir() || file.isDirectory();
    }

    private boolean a(com.getpebble.android.common.framework.install.app.b bVar, String str, File file) {
        OutputStream fileOutputStream;
        Throwable e;
        InputStream inputStream = null;
        try {
            InputStream a = bVar.a(str);
            try {
                fileOutputStream = new FileOutputStream(a(file, str));
                try {
                    com.google.a.c.b.a(a, fileOutputStream);
                    c.a.a.a.e.a(fileOutputStream);
                    c.a.a.a.e.a(a);
                    return true;
                } catch (IOException e2) {
                    e = e2;
                    inputStream = a;
                    try {
                        f.a("JsAppManager", "writeComponentToFileSystem: Copying " + str + " from AppBundle to storage failed for " + bVar.i().getUuid(), e);
                        c.a.a.a.e.a(fileOutputStream);
                        c.a.a.a.e.a(inputStream);
                        return false;
                    } catch (Throwable th) {
                        e = th;
                        c.a.a.a.e.a(fileOutputStream);
                        c.a.a.a.e.a(inputStream);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    inputStream = a;
                    c.a.a.a.e.a(fileOutputStream);
                    c.a.a.a.e.a(inputStream);
                    throw e;
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
                inputStream = a;
                f.a("JsAppManager", "writeComponentToFileSystem: Copying " + str + " from AppBundle to storage failed for " + bVar.i().getUuid(), e);
                c.a.a.a.e.a(fileOutputStream);
                c.a.a.a.e.a(inputStream);
                return false;
            } catch (Throwable th3) {
                e = th3;
                fileOutputStream = null;
                inputStream = a;
                c.a.a.a.e.a(fileOutputStream);
                c.a.a.a.e.a(inputStream);
                throw e;
            }
        } catch (IOException e4) {
            e = e4;
            fileOutputStream = null;
            f.a("JsAppManager", "writeComponentToFileSystem: Copying " + str + " from AppBundle to storage failed for " + bVar.i().getUuid(), e);
            c.a.a.a.e.a(fileOutputStream);
            c.a.a.a.e.a(inputStream);
            return false;
        } catch (Throwable th4) {
            e = th4;
            fileOutputStream = null;
            c.a.a.a.e.a(fileOutputStream);
            c.a.a.a.e.a(inputStream);
            throw e;
        }
    }

    boolean a(com.getpebble.android.common.framework.install.app.b bVar, File file) {
        return a(bVar, "pebble-js-app.js", file);
    }

    boolean b(com.getpebble.android.common.framework.install.app.b bVar, File file) {
        return a(bVar, "appinfo.json", file);
    }

    synchronized boolean b(com.getpebble.android.common.framework.install.app.b bVar) {
        boolean z = false;
        synchronized (this) {
            if (bVar == null) {
                f.a("JsAppManager", "writeJsAndAppInfoToFileSystem: AppBundle is null");
            } else {
                UUID uuid = bVar.i().getUuid();
                if (d(uuid) != null) {
                    f.d("JsAppManager", "writeJsAndAppInfoToFileSystem: removed  " + uuid + " from cache");
                }
                File a = a(uuid);
                if (!bVar.f()) {
                    f.c("JsAppManager", "writeJsAndAppInfoToFileSystem: No JS contained in AppBundle for " + uuid);
                    a(a);
                } else if (!d(a)) {
                    f.a("JsAppManager", "writeJsAndAppInfoToFileSystem: Could not create app directory for " + uuid);
                } else if (!a(bVar, a)) {
                    a(a);
                } else if (b(bVar, a)) {
                    f.d("JsAppManager", "writeJsAndAppInfoToFileSystem: wrote JS and appinfo.json to filesystem for " + uuid);
                    z = true;
                } else {
                    a(a);
                }
            }
        }
        return z;
    }

    public void c(com.getpebble.android.common.framework.install.app.b bVar) {
        b(bVar);
    }

    synchronized boolean c(final UUID uuid, Handler handler) {
        boolean z = false;
        synchronized (this) {
            f.d("JsAppManager", "removeApp: " + uuid);
            if (d(uuid) != null) {
                f.d("JsAppManager", "removeApp: removed " + uuid + " from cache");
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            if (handler.post(new Runnable(this) {
                final /* synthetic */ c c;

                public void run() {
                    this.c.h(uuid);
                    f.d("JsAppManager", "removeApp (in handler): counting down latch for " + uuid);
                    countDownLatch.countDown();
                }
            })) {
                try {
                    f.d("JsAppManager", "removeApp: starting latch wait for " + uuid);
                    countDownLatch.await(5, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    f.a("JsAppManager", "removeApp: latch wait interrupted. Proceeding with " + uuid + " directory remove");
                }
            } else {
                f.b("JsAppManager", "removeApp: could not post stop and localstorage clear request. Attempting to remove " + uuid + " directory");
            }
            f.d("JsAppManager", "removeApp: latch cleared for " + uuid);
            File a = a(uuid);
            if (!b(a)) {
                f.c("JsAppManager", "removeApp: directory does not exist for " + uuid);
            } else if (a(a)) {
                f.d("JsAppManager", "removeApp: removed app directory for " + uuid);
                z = true;
            } else {
                f.a("JsAppManager", "removeApp: could not remove file for " + uuid);
            }
        }
        return z;
    }

    public void d(final UUID uuid, final Handler handler) {
        f.d("JsAppManager", "remove: " + uuid);
        this.e.post(new Runnable(this) {
            final /* synthetic */ c c;

            public void run() {
                this.c.c(uuid, handler);
            }
        });
    }

    public void c() {
        f.d("JsAppManager", "migrateAppsIfNeeded:");
        this.e.post(new Runnable(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void run() {
                f.d("JsAppManager", "migrateAppsIfNeeded: beginning migration");
                com.getpebble.android.framework.jskit.c.c.a(com.getpebble.android.common.a.K(), this.a.d).f();
            }
        });
    }
}
