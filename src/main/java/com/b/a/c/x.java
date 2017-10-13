package com.b.a.c;

import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.util.Hashtable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

public class x implements g {
    Hashtable<String, a> a = new Hashtable();

    private static class a implements g {
        Field a;
        Field b;
        Field c;
        Field d;
        boolean e;

        public SSLEngine a(SSLContext sSLContext, String str, int i) {
            return null;
        }

        public a(Class cls) {
            try {
                this.a = cls.getSuperclass().getDeclaredField("peerHost");
                this.a.setAccessible(true);
                this.b = cls.getSuperclass().getDeclaredField("peerPort");
                this.b.setAccessible(true);
                this.c = cls.getDeclaredField("sslParameters");
                this.c.setAccessible(true);
                this.d = this.c.getType().getDeclaredField("useSni");
                this.d.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
        }

        public void a(SSLEngine sSLEngine, com.b.a.c.b.a aVar, String str, int i) {
            if (this.d != null && !this.e) {
                try {
                    this.a.set(sSLEngine, str);
                    this.b.set(sSLEngine, Integer.valueOf(i));
                    this.d.set(this.c.get(sSLEngine), Boolean.valueOf(true));
                } catch (IllegalAccessException e) {
                }
            }
        }
    }

    public SSLEngine a(SSLContext sSLContext, String str, int i) {
        Object obj = ("GmsCore_OpenSSL".equals(sSLContext.getProvider().getName()) || VERSION.SDK_INT >= 23) ? 1 : null;
        if (obj != null) {
            return sSLContext.createSSLEngine(str, i);
        }
        return sSLContext.createSSLEngine();
    }

    a a(SSLEngine sSLEngine) {
        String canonicalName = sSLEngine.getClass().getCanonicalName();
        a aVar = (a) this.a.get(canonicalName);
        if (aVar != null) {
            return aVar;
        }
        aVar = new a(sSLEngine.getClass());
        this.a.put(canonicalName, aVar);
        return aVar;
    }

    public void a(SSLEngine sSLEngine, com.b.a.c.b.a aVar, String str, int i) {
        a(sSLEngine).a(sSLEngine, aVar, str, i);
    }
}
