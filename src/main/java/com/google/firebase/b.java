package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.a.m;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.f;

public final class b {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;

    private b(String str, String str2, String str3, String str4, String str5, String str6) {
        com.google.android.gms.common.internal.b.a(!m.a(str), (Object) "ApplicationId must be set.");
        this.b = str;
        this.a = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
    }

    public static b a(Context context) {
        f fVar = new f(context);
        Object a = fVar.a("google_app_id");
        return TextUtils.isEmpty(a) ? null : new b(a, fVar.a("google_api_key"), fVar.a("firebase_database_url"), fVar.a("ga_trackingId"), fVar.a("gcm_defaultSenderId"), fVar.a("google_storage_bucket"));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return ab.a(this.b, bVar.b) && ab.a(this.a, bVar.a) && ab.a(this.c, bVar.c) && ab.a(this.d, bVar.d) && ab.a(this.e, bVar.e) && ab.a(this.f, bVar.f);
    }

    public int hashCode() {
        return ab.a(this.b, this.a, this.c, this.d, this.e, this.f);
    }

    public String toString() {
        return ab.a((Object) this).a("applicationId", this.b).a("apiKey", this.a).a("databaseUrl", this.c).a("gcmSenderId", this.e).a("storageBucket", this.f).toString();
    }
}
