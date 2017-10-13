package com.b.b.c;

import android.content.Context;
import android.util.Log;
import com.b.a.c.h;
import com.b.a.c.y;
import com.b.a.e;
import java.security.Provider;
import java.security.Security;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class a extends y {
    static final Object a = new Object();
    static boolean b;
    static boolean c;
    boolean d;
    boolean e = true;
    h f;
    Context g;

    public static void a(Context context) {
        try {
            synchronized (a) {
                if (b) {
                    return;
                }
                b = true;
                if (Security.getProvider("GmsCore_OpenSSL") != null) {
                    c = true;
                    return;
                }
                SSLContext sSLContext = SSLContext.getDefault();
                SSLSocketFactory defaultSSLSocketFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
                com.google.android.gms.c.a.a(context);
                Provider[] providers = Security.getProviders();
                Provider provider = Security.getProvider("GmsCore_OpenSSL");
                Security.removeProvider("GmsCore_OpenSSL");
                Security.insertProviderAt(provider, providers.length);
                SSLContext.setDefault(sSLContext);
                HttpsURLConnection.setDefaultSSLSocketFactory(defaultSSLSocketFactory);
                c = true;
            }
        } catch (Throwable th) {
            Log.w("IonConscrypt", "Conscrypt initialization failed.", th);
        }
    }

    public void a() {
        a(this.g);
        if (c && !this.d && this.e) {
            this.d = true;
            try {
                SSLContext instance = SSLContext.getInstance("TLS", "GmsCore_OpenSSL");
                instance.init(null, null, null);
                if (this.f.a() == e.c()) {
                    this.f.a(instance);
                }
            } catch (Exception e) {
            }
        }
    }

    public a(Context context, h hVar) {
        this.f = hVar;
        this.g = context.getApplicationContext();
    }

    public com.b.a.b.a a(com.b.a.c.b.a aVar) {
        if (!this.e) {
            return null;
        }
        a();
        return super.a(aVar);
    }
}
