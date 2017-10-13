package com.getpebble.android.framework.install;

import android.content.Context;
import b.a;
import b.e;
import java.io.Closeable;
import java.io.File;

public class b {
    protected final Context a;
    protected final String b;
    private final String c;

    public b(String str, Context context, String str2) {
        this.c = str;
        this.a = context;
        this.b = str2;
    }

    public boolean c(String str) {
        return a(e(str));
    }

    public boolean d(String str) {
        return a(a(str));
    }

    private boolean a(File file) {
        return file.exists() ? file.delete() : true;
    }

    public File a(String str) {
        return new File(b(), str);
    }

    public File e(String str) {
        return a(b(f(str)));
    }

    private String b(String str) {
        return str.split("\\?")[0];
    }

    private String f(String str) {
        String[] split = str.split("/");
        return split[split.length - 1];
    }

    public File a(File file, byte[] bArr) {
        return a(file, new a().b(bArr));
    }

    public File a(File file, a aVar) {
        Closeable closeable = null;
        try {
            closeable = e.a(e.a(file));
            closeable.a(aVar);
            closeable.flush();
            return file;
        } finally {
            c.a.a.a.e.a(closeable);
        }
    }

    protected File b() {
        return this.a.getDir(this.b, 0);
    }
}
