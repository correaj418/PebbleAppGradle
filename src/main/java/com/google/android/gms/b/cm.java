package com.google.android.gms.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.a.g;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.internal.l;

public final class cm {
    public static final g<com.google.android.gms.signin.internal.g> a = new g();
    public static final g<com.google.android.gms.signin.internal.g> b = new g();
    public static final b<com.google.android.gms.signin.internal.g, co> c = new b<com.google.android.gms.signin.internal.g, co>() {
        public com.google.android.gms.signin.internal.g a(Context context, Looper looper, l lVar, co coVar, c.b bVar, c.c cVar) {
            return new com.google.android.gms.signin.internal.g(context, looper, true, lVar, coVar == null ? co.a : coVar, bVar, cVar);
        }
    };
    static final b<com.google.android.gms.signin.internal.g, a> d = new b<com.google.android.gms.signin.internal.g, a>() {
        public com.google.android.gms.signin.internal.g a(Context context, Looper looper, l lVar, a aVar, c.b bVar, c.c cVar) {
            return new com.google.android.gms.signin.internal.g(context, looper, false, lVar, aVar.a(), bVar, cVar);
        }
    };
    public static final Scope e = new Scope("profile");
    public static final Scope f = new Scope("email");
    public static final com.google.android.gms.common.api.a<co> g = new com.google.android.gms.common.api.a("SignIn.API", c, a);
    public static final com.google.android.gms.common.api.a<a> h = new com.google.android.gms.common.api.a("SignIn.INTERNAL_API", d, b);

    public static class a implements com.google.android.gms.common.api.a.a.a {
        public Bundle a() {
            return null;
        }
    }
}
