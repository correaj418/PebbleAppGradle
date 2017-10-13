package android.support.v4.app;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;

public final class ar extends android.support.v4.app.at.a {
    public static final android.support.v4.app.at.a.a a = new android.support.v4.app.at.a.a() {
        public /* synthetic */ android.support.v4.app.at.a b(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
            return a(str, charSequence, charSequenceArr, z, bundle);
        }

        public /* synthetic */ android.support.v4.app.at.a[] b(int i) {
            return a(i);
        }

        public ar a(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
            return new ar(str, charSequence, charSequenceArr, z, bundle);
        }

        public ar[] a(int i) {
            return new ar[i];
        }
    };
    private static final a g;
    private final String b;
    private final CharSequence c;
    private final CharSequence[] d;
    private final boolean e;
    private final Bundle f;

    interface a {
        void a(ar[] arVarArr, Intent intent, Bundle bundle);
    }

    static class b implements a {
        b() {
        }

        public void a(ar[] arVarArr, Intent intent, Bundle bundle) {
            as.a(arVarArr, intent, bundle);
        }
    }

    static class c implements a {
        c() {
        }

        public void a(ar[] arVarArr, Intent intent, Bundle bundle) {
            Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
        }
    }

    static class d implements a {
        d() {
        }

        public void a(ar[] arVarArr, Intent intent, Bundle bundle) {
            au.a(arVarArr, intent, bundle);
        }
    }

    private ar(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
        this.b = str;
        this.c = charSequence;
        this.d = charSequenceArr;
        this.e = z;
        this.f = bundle;
    }

    public String a() {
        return this.b;
    }

    public CharSequence b() {
        return this.c;
    }

    public CharSequence[] c() {
        return this.d;
    }

    public boolean d() {
        return this.e;
    }

    public Bundle e() {
        return this.f;
    }

    public static void a(ar[] arVarArr, Intent intent, Bundle bundle) {
        g.a(arVarArr, intent, bundle);
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            g = new b();
        } else if (VERSION.SDK_INT >= 16) {
            g = new d();
        } else {
            g = new c();
        }
    }
}
