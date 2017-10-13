package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class Application extends AbstractSafeParcelable {
    public static final Creator<Application> CREATOR = new a();
    public static final Application a = new Application("com.google.android.gms", String.valueOf(e.a), null);
    private final int b;
    private final String c;
    private final String d;
    private final String e;

    Application(int i, String str, String str2, String str3) {
        this.b = i;
        this.c = (String) b.a((Object) str);
        this.d = "";
        this.e = str3;
    }

    public Application(String str, String str2, String str3) {
        this(1, str, "", str3);
    }

    public static Application a(String str) {
        return a(str, null, null);
    }

    public static Application a(String str, String str2, String str3) {
        return "com.google.android.gms".equals(str) ? a : new Application(str, str2, str3);
    }

    private boolean a(Application application) {
        return this.c.equals(application.c) && ab.a(this.d, application.d) && ab.a(this.e, application.e);
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    int d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Application) && a((Application) obj));
    }

    public int hashCode() {
        return ab.a(this.c, this.d, this.e);
    }

    public String toString() {
        return String.format("Application{%s:%s:%s}", new Object[]{this.c, this.d, this.e});
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel, i);
    }
}
