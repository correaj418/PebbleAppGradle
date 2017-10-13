package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class LocationRequestInternal extends AbstractSafeParcelable {
    public static final l CREATOR = new l();
    static final List<ClientIdentity> a = Collections.emptyList();
    LocationRequest b;
    boolean c;
    List<ClientIdentity> d;
    String e;
    boolean f;
    private final int g;

    LocationRequestInternal(int i, LocationRequest locationRequest, boolean z, List<ClientIdentity> list, String str, boolean z2) {
        this.g = i;
        this.b = locationRequest;
        this.c = z;
        this.d = list;
        this.e = str;
        this.f = z2;
    }

    @Deprecated
    public static LocationRequestInternal a(LocationRequest locationRequest) {
        return a(null, locationRequest);
    }

    public static LocationRequestInternal a(String str, LocationRequest locationRequest) {
        return new LocationRequestInternal(1, locationRequest, true, a, str, false);
    }

    int a() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationRequestInternal)) {
            return false;
        }
        LocationRequestInternal locationRequestInternal = (LocationRequestInternal) obj;
        return ab.a(this.b, locationRequestInternal.b) && this.c == locationRequestInternal.c && this.f == locationRequestInternal.f && ab.a(this.d, locationRequestInternal.d);
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b.toString());
        if (this.e != null) {
            stringBuilder.append(" tag=").append(this.e);
        }
        stringBuilder.append(" trigger=").append(this.c);
        stringBuilder.append(" hideAppOps=").append(this.f);
        stringBuilder.append(" clients=").append(this.d);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        l.a(this, parcel, i);
    }
}
