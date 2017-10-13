package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class ActivityRecognitionRequest extends AbstractSafeParcelable {
    public static final Creator<ActivityRecognitionRequest> CREATOR = new n();
    private final int a;
    private long b;
    private boolean c;
    private WorkSource d;
    private String e;
    private int[] f;
    private boolean g;
    private String h;

    ActivityRecognitionRequest(int i, long j, boolean z, WorkSource workSource, String str, int[] iArr, boolean z2, String str2) {
        this.a = i;
        this.b = j;
        this.c = z;
        this.d = workSource;
        this.e = str;
        this.f = iArr;
        this.g = z2;
        this.h = str2;
    }

    public long a() {
        return this.b;
    }

    public boolean b() {
        return this.c;
    }

    public WorkSource c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public int[] e() {
        return this.f;
    }

    public boolean f() {
        return this.g;
    }

    public String g() {
        return this.h;
    }

    int h() {
        return this.a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        n.a(this, parcel, i);
    }
}
