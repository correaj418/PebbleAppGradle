package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.a.d;
import com.google.android.gms.common.a.f;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount extends AbstractSafeParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR = new a();
    public static d a = f.b();
    private static Comparator<Scope> n = new Comparator<Scope>() {
        public int a(Scope scope, Scope scope2) {
            return scope.a().compareTo(scope2.a());
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return a((Scope) obj, (Scope) obj2);
        }
    };
    final int b;
    List<Scope> c;
    private String d;
    private String e;
    private String f;
    private String g;
    private Uri h;
    private String i;
    private long j;
    private String k;
    private String l;
    private String m;

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.b = i;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = uri;
        this.i = str5;
        this.j = j;
        this.k = str6;
        this.c = list;
        this.l = str7;
        this.m = str8;
    }

    public static GoogleSignInAccount a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Object optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        Set hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        return a(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet).b(jSONObject.optString("serverAuthCode", null));
    }

    public static GoogleSignInAccount a(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set<Scope> set) {
        if (l == null) {
            l = Long.valueOf(a.a() / 1000);
        }
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l.longValue(), b.a(str7), new ArrayList((Collection) b.a((Object) set)), str5, str6);
    }

    private JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (a() != null) {
                jSONObject.put("id", a());
            }
            if (b() != null) {
                jSONObject.put("tokenId", b());
            }
            if (c() != null) {
                jSONObject.put("email", c());
            }
            if (d() != null) {
                jSONObject.put("displayName", d());
            }
            if (e() != null) {
                jSONObject.put("givenName", e());
            }
            if (f() != null) {
                jSONObject.put("familyName", f());
            }
            if (g() != null) {
                jSONObject.put("photoUrl", g().toString());
            }
            if (h() != null) {
                jSONObject.put("serverAuthCode", h());
            }
            jSONObject.put("expirationTime", this.j);
            jSONObject.put("obfuscatedIdentifier", j());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.c, n);
            for (Scope a : this.c) {
                jSONArray.put(a.a());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public String a() {
        return this.d;
    }

    public GoogleSignInAccount b(String str) {
        this.i = str;
        return this;
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.g;
    }

    public String e() {
        return this.l;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof GoogleSignInAccount) ? false : ((GoogleSignInAccount) obj).k().equals(k());
    }

    public String f() {
        return this.m;
    }

    public Uri g() {
        return this.h;
    }

    public String h() {
        return this.i;
    }

    public long i() {
        return this.j;
    }

    public String j() {
        return this.k;
    }

    public String k() {
        return l().toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel, i);
    }
}
