package com.google.android.gms.b;

import com.google.android.gms.common.api.a.a.d;

public final class co implements d {
    public static final co a = new a().a();
    private final boolean b;
    private final boolean c;
    private final String d;
    private final boolean e;
    private final String f;
    private final boolean g;

    public static final class a {
        public co a() {
            return new co(false, false, null, false, null, false);
        }
    }

    private co(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4) {
        this.b = z;
        this.c = z2;
        this.d = str;
        this.e = z3;
        this.g = z4;
        this.f = str2;
    }

    public boolean a() {
        return this.b;
    }

    public boolean b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public boolean d() {
        return this.e;
    }

    public String e() {
        return this.f;
    }

    public boolean f() {
        return this.g;
    }
}
