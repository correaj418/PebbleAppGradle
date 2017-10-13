package com.getpebble.android.common.framework.install;

import com.getpebble.android.common.b.a.d;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.h.p;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public abstract class a<M extends PebbleManifest> {
    private ZipFile a;
    private Map<String, ZipEntry> b;

    public abstract M c();

    public a(ZipFile zipFile, Map<String, ZipEntry> map) {
        if (zipFile == null) {
            throw new IllegalArgumentException("'file' cannot be null!");
        } else if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("'components' cannot be null or empty!");
        } else {
            this.a = zipFile;
            this.b = map;
        }
    }

    protected Map<String, ZipEntry> a() {
        return this.b;
    }

    protected ZipFile b() {
        return this.a;
    }

    public InputStream a(String str) {
        Throwable e;
        if (((ZipEntry) a().get(str)) == null) {
            throw new FileNotFoundException("Cannot find entry for " + str);
        }
        try {
            return b().getInputStream((ZipEntry) a().get(str));
        } catch (ArrayIndexOutOfBoundsException e2) {
            e = e2;
            f.b("PebbleBundle", "Error loading file: '" + str + "'");
            throw new IOException(e);
        } catch (IllegalStateException e3) {
            e = e3;
            f.b("PebbleBundle", "Error loading file: '" + str + "'");
            throw new IOException(e);
        }
    }

    protected M a(Class<M> cls) {
        return a(cls, "");
    }

    protected M a(Class<M> cls, String str) {
        Exception exception;
        Exception exception2;
        M m = null;
        try {
            InputStream a = a(str + "manifest.json");
            M m2 = (PebbleManifest) p.a(new BufferedReader(new InputStreamReader(a)), (Class) cls);
            try {
                a.close();
                return m2;
            } catch (Exception e) {
                exception = e;
                m = m2;
                exception2 = exception;
            } catch (Exception e2) {
                exception = e2;
                m = m2;
                exception2 = exception;
            } catch (Exception e22) {
                exception = e22;
                m = m2;
                exception2 = exception;
            }
        } catch (IOException e3) {
            exception2 = e3;
            f.c("PebbleBundle", "Failed to parse component." + d.a(exception2, 6));
            return m;
        } catch (IllegalArgumentException e4) {
            exception2 = e4;
            f.c("PebbleBundle", "Failed to parse component." + d.a(exception2, 6));
            return m;
        } catch (NullPointerException e5) {
            exception2 = e5;
            f.c("PebbleBundle", "Failed to parse component." + d.a(exception2, 6));
            return m;
        }
    }

    public boolean d() {
        return c().getResourceInfo() != null;
    }

    public void e() {
        try {
            this.a.close();
        } catch (Throwable e) {
            f.d("PebbleBundle", "Error closing file", e);
        }
    }
}
