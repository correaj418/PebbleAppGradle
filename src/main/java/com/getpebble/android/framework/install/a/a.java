package com.getpebble.android.framework.install.a;

import android.content.Context;
import android.net.Uri;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.b.f;
import com.getpebble.android.common.framework.install.app.b;
import com.getpebble.android.common.model.AppInfo;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.i;
import com.getpebble.android.framework.install.c;
import com.google.b.u;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.zip.ZipFile;

public class a extends c<b> {

    public static class a {
        private final UUID a;
        private final i b;

        public a(UUID uuid, i iVar) {
            this.a = uuid;
            this.b = iVar;
        }

        public a(String str) {
            if (c.a.a.a.c.c(str).equals("pbw")) {
                String[] split = c.a.a.a.c.d(str).split("_");
                this.a = UUID.fromString(split[0]);
                this.b = new i(split[1]);
                return;
            }
            throw new IllegalArgumentException("not .pbw extension: " + str);
        }

        public boolean equals(Object obj) {
            return a().equals(((a) obj).a());
        }

        public int hashCode() {
            return a().hashCode();
        }

        public String a() {
            return this.a + "_" + this.b.a() + "." + this.b.b() + "." + "pbw";
        }

        public UUID b() {
            return this.a;
        }

        public String toString() {
            return a();
        }
    }

    public /* synthetic */ com.getpebble.android.common.framework.install.a a(File file) {
        return b(file);
    }

    public a(Context context) {
        super(context);
    }

    public String a() {
        return "apps";
    }

    public b b(File file) {
        if (!file.exists()) {
            return null;
        }
        try {
            ZipFile zipFile = new ZipFile(file);
            return new b(zipFile, a(zipFile));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IOException(e.getMessage());
        }
    }

    protected void a(b bVar) {
        if (bVar != null) {
            am.a(b().getContentResolver(), bVar.i().getUuid(), bVar.h().toString());
        }
    }

    public void a(final Uri uri, final FrameworkState frameworkState) {
        new f(this) {
            final /* synthetic */ a c;

            public boolean doInBackground() {
                AppInfo appInfo;
                b bVar = (b) this.c.a(uri);
                if (bVar != null) {
                    AppInfo i = bVar.i();
                    bVar.e();
                    appInfo = i;
                } else {
                    appInfo = null;
                }
                frameworkState.a(appInfo);
                return true;
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
    }

    public boolean a(am.c cVar) {
        return a(new a(cVar.b, cVar.l)).exists();
    }

    public b b(am.c cVar) {
        File a = a(new a(cVar.b, cVar.l));
        if (a.exists()) {
            com.getpebble.android.common.b.a.f.d("AppBundleManager", "pbw is already cached for " + cVar.b + " / " + cVar.c);
            return c(a);
        } else if (cVar.f == null) {
            com.getpebble.android.common.b.a.f.b("AppBundleManager", "pbwUrl is null, not downloading..");
            return null;
        } else {
            File a2 = this.a.a(cVar.f, a);
            if (a2 == null) {
                com.getpebble.android.common.b.a.f.b("AppBundleManager", "downloaded is null");
                a.delete();
                return null;
            }
            b c = c(a2);
            if (c != null) {
                return c;
            }
            com.getpebble.android.common.b.a.f.b("AppBundleManager", "bundle is null");
            a.delete();
            return null;
        }
    }

    public b c(File file) {
        Throwable e;
        try {
            return b(file);
        } catch (IOException e2) {
            e = e2;
            com.getpebble.android.common.b.a.f.b("AppBundleManager", "Error getting pbw bundle from file", e);
            return null;
        } catch (IllegalArgumentException e3) {
            e = e3;
            com.getpebble.android.common.b.a.f.b("AppBundleManager", "Error getting pbw bundle from file", e);
            return null;
        } catch (IllegalStateException e4) {
            e = e4;
            com.getpebble.android.common.b.a.f.b("AppBundleManager", "Error getting pbw bundle from file", e);
            return null;
        } catch (u e5) {
            e = e5;
            com.getpebble.android.common.b.a.f.b("AppBundleManager", "Error getting pbw bundle from file", e);
            return null;
        }
    }

    public boolean a(a aVar, boolean z) {
        com.getpebble.android.common.b.a.f.d("AppBundleManager", "purgePbwCache() id = " + aVar + " deleteJavascript = " + z);
        File a = a(aVar);
        if (z) {
            com.getpebble.android.common.b.a.f.d("AppBundleManager", "deleteFromCache: will also attempt to remove JS for " + aVar.b());
            PebbleApplication.x().b(aVar.b());
        }
        return a.delete();
    }

    public File a(a aVar) {
        return new File(b().getDir("apps_cache", 0), aVar.a());
    }

    public boolean a(a aVar, File file) {
        boolean z;
        try {
            c.a.a.a.b.b(file, a(aVar));
            z = true;
        } catch (IOException e) {
            z = false;
        } finally {
            c.a.a.a.b.b(file);
        }
        return z;
    }

    private Set<a> h() {
        File dir = b().getDir("apps_cache", 0);
        Set<a> hashSet = new HashSet();
        for (File name : dir.listFiles()) {
            try {
                hashSet.add(new a(name.getName()));
            } catch (Throwable e) {
                com.getpebble.android.common.b.a.f.b("AppBundleManager", "Error getting file uuidVersion", e);
            }
        }
        return hashSet;
    }

    private long i() {
        int i = 0;
        long j = 0;
        File[] listFiles = b().getDir("apps_cache", 0).listFiles();
        while (i < listFiles.length) {
            j += listFiles[i].length();
            i++;
        }
        return j;
    }

    private boolean j() {
        return i() < 10000000;
    }

    private boolean a(a aVar, Set<a> set) {
        for (a b : set) {
            if (aVar.b().equals(b.b())) {
                return true;
            }
        }
        return false;
    }

    public void c() {
        com.getpebble.android.common.b.a.f.d("AppBundleManager", "purgeAllCachedPbws()");
        for (a aVar : h()) {
            am.c a = am.a(aVar.b(), com.getpebble.android.common.a.K().getContentResolver(), false);
            if (a == null || !a.z) {
                a(aVar, true);
            }
        }
        com.getpebble.android.common.b.a.f.d("AppBundleManager", "purgeAllCachedPbws finished");
    }

    public void d() {
        com.getpebble.android.common.b.a.f.d("AppBundleManager", "purgePbwCache()");
        Set<a> h = h();
        Set a = am.a(com.getpebble.android.common.a.K().getContentResolver(), true);
        h.removeAll(a);
        for (a aVar : h) {
            boolean z;
            com.getpebble.android.common.b.a.f.d("AppBundleManager", "Deleting pbw from cache (not in locker): " + aVar);
            if (a(aVar, a)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                com.getpebble.android.common.b.a.f.d("AppBundleManager", "Deleting from cache because not in locker, but not deleting js because another version is still cached for " + aVar);
            }
            a(aVar, z);
        }
        for (a aVar2 : am.a(com.getpebble.android.common.a.K().getContentResolver(), false)) {
            if (!j()) {
                com.getpebble.android.common.b.a.f.d("AppBundleManager", "Deleting non-sideloaded pbw from cache to trim size: " + aVar2);
                a(aVar2, false);
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e() {
        /*
        r8 = this;
        r2 = 1;
        r1 = 0;
        r3 = "mancy";
        monitor-enter(r3);
        r0 = "AppBundleManager";
        r4 = "cachePbwsForLockerApps() bg";
        com.getpebble.android.common.b.a.f.d(r0, r4);	 Catch:{ all -> 0x00b8 }
        r0 = new com.getpebble.android.common.b.b.c;	 Catch:{ all -> 0x00b8 }
        r4 = com.getpebble.android.common.a.K();	 Catch:{ all -> 0x00b8 }
        r0.<init>(r4);	 Catch:{ all -> 0x00b8 }
        r4 = com.getpebble.android.common.b.b.c.a.AUTO_APP_UPDATES_WIFI_ONLY;	 Catch:{ all -> 0x00b8 }
        r5 = 1;
        r0 = r0.a(r4, r5);	 Catch:{ all -> 0x00b8 }
        r4 = com.getpebble.android.common.a.K();	 Catch:{ all -> 0x00b8 }
        r4 = com.getpebble.android.h.h.a(r4);	 Catch:{ all -> 0x00b8 }
        if (r4 == 0) goto L_0x0032;
    L_0x0026:
        if (r0 == 0) goto L_0x003c;
    L_0x0028:
        r0 = com.getpebble.android.common.a.K();	 Catch:{ all -> 0x00b8 }
        r0 = com.getpebble.android.h.h.b(r0);	 Catch:{ all -> 0x00b8 }
        if (r0 != 0) goto L_0x003c;
    L_0x0032:
        r0 = "AppBundleManager";
        r2 = "Not caching any pbw files: not connected to a valid network.";
        com.getpebble.android.common.b.a.f.d(r0, r2);	 Catch:{ all -> 0x00b8 }
        monitor-exit(r3);	 Catch:{ all -> 0x00b8 }
        r0 = r1;
    L_0x003b:
        return r0;
    L_0x003c:
        r0 = r8.h();	 Catch:{ all -> 0x00b8 }
        r4 = com.getpebble.android.common.a.K();	 Catch:{ all -> 0x00b8 }
        r4 = r4.getContentResolver();	 Catch:{ all -> 0x00b8 }
        r5 = 0;
        r4 = com.getpebble.android.common.model.am.a(r4, r5);	 Catch:{ all -> 0x00b8 }
        r4.removeAll(r0);	 Catch:{ all -> 0x00b8 }
        r4 = r4.iterator();	 Catch:{ all -> 0x00b8 }
    L_0x0054:
        r0 = r4.hasNext();	 Catch:{ all -> 0x00b8 }
        if (r0 == 0) goto L_0x006d;
    L_0x005a:
        r0 = r4.next();	 Catch:{ all -> 0x00b8 }
        r0 = (com.getpebble.android.framework.install.a.a.a) r0;	 Catch:{ all -> 0x00b8 }
        r5 = r8.j();	 Catch:{ all -> 0x00b8 }
        if (r5 != 0) goto L_0x0070;
    L_0x0066:
        r0 = "AppBundleManager";
        r1 = "Halting pbw caching; over cache size limit";
        com.getpebble.android.common.b.a.f.d(r0, r1);	 Catch:{ all -> 0x00b8 }
    L_0x006d:
        monitor-exit(r3);	 Catch:{ all -> 0x00b8 }
        r0 = r2;
        goto L_0x003b;
    L_0x0070:
        r5 = "AppBundleManager";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b8 }
        r6.<init>();	 Catch:{ all -> 0x00b8 }
        r7 = "pbw needs to be cached: ";
        r6 = r6.append(r7);	 Catch:{ all -> 0x00b8 }
        r6 = r6.append(r0);	 Catch:{ all -> 0x00b8 }
        r6 = r6.toString();	 Catch:{ all -> 0x00b8 }
        com.getpebble.android.common.b.a.f.d(r5, r6);	 Catch:{ all -> 0x00b8 }
        r5 = r0.b();	 Catch:{ all -> 0x00b8 }
        r6 = com.getpebble.android.common.a.K();	 Catch:{ all -> 0x00b8 }
        r6 = r6.getContentResolver();	 Catch:{ all -> 0x00b8 }
        r7 = 0;
        r5 = com.getpebble.android.common.model.am.a(r5, r6, r7);	 Catch:{ all -> 0x00b8 }
        if (r5 != 0) goto L_0x00bb;
    L_0x009b:
        r5 = "AppBundleManager";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b8 }
        r6.<init>();	 Catch:{ all -> 0x00b8 }
        r7 = "cachePbwsForLockerApps() app is null: ";
        r6 = r6.append(r7);	 Catch:{ all -> 0x00b8 }
        r0 = r0.b();	 Catch:{ all -> 0x00b8 }
        r0 = r6.append(r0);	 Catch:{ all -> 0x00b8 }
        r0 = r0.toString();	 Catch:{ all -> 0x00b8 }
        com.getpebble.android.common.b.a.f.b(r5, r0);	 Catch:{ all -> 0x00b8 }
        goto L_0x0054;
    L_0x00b8:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x00b8 }
        throw r0;
    L_0x00bb:
        r0 = r8.b(r5);	 Catch:{ all -> 0x00b8 }
        if (r0 != 0) goto L_0x00eb;
    L_0x00c1:
        r0 = "AppBundleManager";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b8 }
        r2.<init>();	 Catch:{ all -> 0x00b8 }
        r4 = "Bundle was null for cache / ";
        r2 = r2.append(r4);	 Catch:{ all -> 0x00b8 }
        r4 = r5.b;	 Catch:{ all -> 0x00b8 }
        r2 = r2.append(r4);	 Catch:{ all -> 0x00b8 }
        r4 = " / ";
        r2 = r2.append(r4);	 Catch:{ all -> 0x00b8 }
        r4 = r5.c;	 Catch:{ all -> 0x00b8 }
        r2 = r2.append(r4);	 Catch:{ all -> 0x00b8 }
        r2 = r2.toString();	 Catch:{ all -> 0x00b8 }
        com.getpebble.android.common.b.a.f.b(r0, r2);	 Catch:{ all -> 0x00b8 }
        monitor-exit(r3);	 Catch:{ all -> 0x00b8 }
        r0 = r1;
        goto L_0x003b;
    L_0x00eb:
        r5 = r8.b();	 Catch:{ all -> 0x00b8 }
        r5 = com.getpebble.android.framework.jskit.c.a(r5);	 Catch:{ all -> 0x00b8 }
        r5.a(r0);	 Catch:{ all -> 0x00b8 }
        r0.e();	 Catch:{ all -> 0x00b8 }
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.framework.install.a.a.e():boolean");
    }

    public void f() {
        new f(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public boolean doInBackground() {
                return this.a.e();
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
    }

    public void g() {
        if (!PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.DONE_JSKIT_INSTALL_FIX, false)) {
            new f(this) {
                final /* synthetic */ a a;

                {
                    this.a = r1;
                }

                public boolean doInBackground() {
                    synchronized ("mancy") {
                        com.getpebble.android.common.b.a.f.c(f.TAG, "fixJsInstallForCachedApps()");
                        for (a aVar : this.a.h()) {
                            b c = this.a.c(this.a.a(aVar));
                            if (c == null) {
                                com.getpebble.android.common.b.a.f.b(f.TAG, "fixJsInstallForCachedApps: bundle is null for " + aVar);
                            } else {
                                com.getpebble.android.framework.jskit.c.a(this.a.b()).a(c);
                                c.e();
                            }
                        }
                        PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.DONE_JSKIT_INSTALL_FIX, true);
                        com.getpebble.android.common.b.a.f.c(f.TAG, "fixJsInstallForCachedApps: done!");
                    }
                    return true;
                }

                public void onTaskSuccess() {
                }

                public void onTaskFailed() {
                }
            }.submit();
        }
    }
}
