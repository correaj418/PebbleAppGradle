package com.google.android.gms.c;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.c;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.k;
import java.lang.reflect.Method;

public class a {
    private static final i a = i.b();
    private static final Object b = new Object();
    private static Method c = null;

    public static void a(Context context) {
        b.a((Object) context, (Object) "Context must not be null");
        a.b(context);
        Context f = k.f(context);
        if (f == null) {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new c(8);
        }
        synchronized (b) {
            try {
                if (c == null) {
                    b(f);
                }
                c.invoke(null, new Object[]{f});
            } catch (Exception e) {
                String str = "ProviderInstaller";
                String str2 = "Failed to install provider: ";
                String valueOf = String.valueOf(e.getMessage());
                Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                throw new c(8);
            }
        }
    }

    private static void b(Context context) {
        c = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[]{Context.class});
    }
}
