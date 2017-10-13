package com.getpebble.jskit.android.impl.runtime.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.getpebble.jskit.android.a.b;
import com.google.a.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class JsApplicationInfo implements Parcelable {
    public static final Creator<JsApplicationInfo> CREATOR = new Creator<JsApplicationInfo>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public JsApplicationInfo a(Parcel parcel) {
            return new JsApplicationInfo(parcel);
        }

        public JsApplicationInfo[] a(int i) {
            return new JsApplicationInfo[i];
        }
    };
    private String a;
    private String b;
    private String c;
    private String d;
    private int e;
    private String f;
    private String g;
    private String[] h;
    private boolean i;
    private Map<String, e> j;
    private String k;
    private String[] l;

    public JsApplicationInfo(Parcel parcel) {
        b(parcel);
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public int e() {
        return this.e;
    }

    public int a(int i) {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public void e(String str) {
        this.f = str;
    }

    public String g() {
        return this.g;
    }

    public void f(String str) {
        this.g = str;
    }

    public String[] h() {
        return this.h;
    }

    public void a(String[] strArr) {
        this.h = strArr;
    }

    public boolean i() {
        return this.i;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public Map<String, e> j() {
        return this.j;
    }

    public void a(Map<String, e> map) {
        this.j = map;
    }

    public String k() {
        return this.k;
    }

    public void g(String str) {
        this.k = str;
    }

    public String[] l() {
        return this.l;
    }

    public void b(String[] strArr) {
        this.l = strArr;
    }

    public boolean m() {
        return b.a(this, "configurable");
    }

    public String toString() {
        String str;
        Object obj;
        StringBuilder append = new StringBuilder().append("JsApplicationInfo: appId = ").append(this.a).append(", mShortName = ").append(this.b).append(", mLongName = ").append(this.c).append(", mCompanyName = ").append(this.d).append(", mVersionCode = ").append(this.e).append(", mVersionLabel = ").append(this.f).append(", mSdkVersion = ").append(this.g).append(", mTargetPlatforms = ");
        if (this.h == null) {
            str = null;
        } else {
            str = TextUtils.join(com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR, this.h);
        }
        append = append.append(str).append(", mIsWatchFaceApp = ").append(this.i).append(", mAppKeys size = ");
        if (this.j == null) {
            obj = "<null>";
        } else {
            obj = Integer.valueOf(this.j.size());
        }
        return append.append(obj).append(", mScriptFile = ").append(this.k).toString();
    }

    public static void a(Parcel parcel, Map<String, e> map) {
        if (map == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(map.size());
        for (Entry entry : map.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeLong(((e) entry.getValue()).longValue());
        }
    }

    public static Map<String, e> a(Parcel parcel) {
        Map<String, e> hashMap = new HashMap();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            hashMap.put(parcel.readString(), e.a(parcel.readLong()));
        }
        return hashMap;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(a());
        parcel.writeString(b());
        parcel.writeString(c());
        parcel.writeString(d());
        parcel.writeInt(e());
        parcel.writeString(f());
        parcel.writeString(g());
        parcel.writeStringArray(h());
        parcel.writeInt(i() ? 1 : 0);
        parcel.writeString(k());
        parcel.writeStringArray(l());
        a(parcel, j());
    }

    public void b(Parcel parcel) {
        boolean z = true;
        a(parcel.readString());
        b(parcel.readString());
        c(parcel.readString());
        d(parcel.readString());
        a(parcel.readInt());
        e(parcel.readString());
        f(parcel.readString());
        a(parcel.createStringArray());
        if (parcel.readInt() != 1) {
            z = false;
        }
        a(z);
        g(parcel.readString());
        b(parcel.createStringArray());
        a(a(parcel));
    }

    public int describeContents() {
        return 0;
    }
}
