package com.getpebble.android.framework.install;

import android.content.Context;
import android.net.Uri;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.install.a;
import com.getpebble.android.framework.o.d;
import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public abstract class c<B extends a> {
    protected final a a;
    private Context b;

    public abstract B a(File file);

    public abstract String a();

    protected abstract void a(B b);

    public c(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        }
        this.b = context;
        Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
        this.a = new a(this.b, a());
    }

    protected Context b() {
        return this.b;
    }

    public B a(Uri uri) {
        B b = null;
        File b2 = b(uri);
        if (b2 == null) {
            f.b("PebbleBundleManager", "fetchBundleFromUri() file is null");
        } else {
            try {
                a a = a(b2);
                a(a);
            } catch (Throwable e) {
                f.a("PebbleBundleManager", "Failed to get local file for " + b2, e);
                if (b != null) {
                    b.e();
                }
            } catch (Throwable e2) {
                if (b != null) {
                    b.e();
                }
                f.a("PebbleBundleManager", "Failed to parse bundle.", e2);
            } catch (Throwable e22) {
                if (b != null) {
                    b.e();
                }
                f.a("PebbleBundleManager", "Failed to parse bundle.", e22);
            }
        }
        return b;
    }

    public File b(Uri uri) {
        if (uri == null || uri.getScheme() == null) {
            return null;
        }
        File a;
        f.d("PebbleBundleManager", "fetchBundleFromUri bundleUri = " + uri);
        if (uri.getScheme().equals("content")) {
            a = d.a(this.b, uri, d.a.FIRMWARE);
        } else if (uri.getScheme().equals("file")) {
            a = new File(uri.getPath());
        } else if (uri.getScheme().equals("http") || uri.getScheme().equals("https")) {
            a = this.a.e(uri.getPath());
        } else {
            a = null;
        }
        if (a == null) {
            f.a("PebbleBundleManager", "File was null, no content scheme matched");
            return null;
        }
        f.d("PebbleBundleManager", "fetchBundleFromUri file = " + a);
        if (a.exists()) {
            return a;
        }
        f.d("PebbleBundleManager", "fetchBundleFromUri: File does not exist, downloading...");
        return this.a.a(uri.toString(), null);
    }

    protected Map<String, ZipEntry> a(ZipFile zipFile) {
        Map hashMap = new HashMap();
        Enumeration entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            hashMap.put(zipEntry.getName(), zipEntry);
        }
        return hashMap;
    }

    public File a(String str) {
        return this.a.a(str, null);
    }

    public boolean b(String str) {
        return this.a.c(str);
    }
}
