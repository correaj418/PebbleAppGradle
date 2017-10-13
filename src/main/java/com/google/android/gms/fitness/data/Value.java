package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.e.a;
import com.google.android.gms.common.a.i;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.d;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class Value extends AbstractSafeParcelable {
    public static final Creator<Value> CREATOR = new s();
    private final int a;
    private final int b;
    private boolean c;
    private float d;
    private String e;
    private Map<String, MapValue> f;
    private int[] g;
    private float[] h;
    private byte[] i;

    public Value(int i) {
        this(3, i, false, 0.0f, null, null, null, null, null);
    }

    Value(int i, int i2, boolean z, float f, String str, Bundle bundle, int[] iArr, float[] fArr, byte[] bArr) {
        this.a = i;
        this.b = i2;
        this.c = z;
        this.d = f;
        this.e = str;
        this.f = a(bundle);
        this.g = iArr;
        this.h = fArr;
        this.i = bArr;
    }

    private static Map<String, MapValue> a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(MapValue.class.getClassLoader());
        Map<String, MapValue> aVar = new a(bundle.size());
        for (String str : bundle.keySet()) {
            aVar.put(str, (MapValue) bundle.getParcelable(str));
        }
        return aVar;
    }

    private boolean a(Value value) {
        if (this.b != value.b || this.c != value.c) {
            return false;
        }
        switch (this.b) {
            case 1:
                return c() == value.c();
            case 2:
                return this.d == value.d;
            case 3:
                return ab.a(this.e, value.e);
            case 4:
                return ab.a(this.f, value.f);
            case 5:
                return Arrays.equals(this.g, value.g);
            case 6:
                return Arrays.equals(this.h, value.h);
            case 7:
                return Arrays.equals(this.i, value.i);
            default:
                return this.d == value.d;
        }
    }

    public void a(float f) {
        b.a(this.b == 2, (Object) "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        this.c = true;
        this.d = f;
    }

    public void a(int i) {
        b.a(this.b == 1, (Object) "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        this.c = true;
        this.d = Float.intBitsToFloat(i);
    }

    public void a(String str) {
        a(d.a(str));
    }

    public boolean a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        boolean z = true;
        if (this.b != 1) {
            z = false;
        }
        b.a(z, (Object) "Value is not in int format");
        return Float.floatToRawIntBits(this.d);
    }

    public float d() {
        b.a(this.b == 2, (Object) "Value is not in float format");
        return this.d;
    }

    int e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Value) && a((Value) obj));
    }

    float f() {
        return this.d;
    }

    String g() {
        return this.e;
    }

    Bundle h() {
        if (this.f == null) {
            return null;
        }
        Bundle bundle = new Bundle(this.f.size());
        for (Entry entry : this.f.entrySet()) {
            bundle.putParcelable((String) entry.getKey(), (Parcelable) entry.getValue());
        }
        return bundle;
    }

    public int hashCode() {
        return ab.a(Float.valueOf(this.d), this.e, this.f, this.g, this.h, this.i);
    }

    int[] i() {
        return this.g;
    }

    float[] j() {
        return this.h;
    }

    byte[] k() {
        return this.i;
    }

    public String toString() {
        if (!this.c) {
            return "unset";
        }
        switch (this.b) {
            case 1:
                return Integer.toString(c());
            case 2:
                return Float.toString(this.d);
            case 3:
                return this.e;
            case 4:
                return new TreeMap(this.f).toString();
            case 5:
                return Arrays.toString(this.g);
            case 6:
                return Arrays.toString(this.h);
            case 7:
                return i.a(this.i, 0, this.i.length, false);
            default:
                return "unknown";
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        s.a(this, parcel, i);
    }
}
