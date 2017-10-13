package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.List;

public class GeofencingRequest extends AbstractSafeParcelable {
    public static final Creator<GeofencingRequest> CREATOR = new o();
    private final int a;
    private final List<ParcelableGeofence> b;
    private final int c;

    public static final class a {
        private final List<ParcelableGeofence> a = new ArrayList();
        private int b = 5;

        public static int b(int i) {
            return i & 7;
        }

        public a a(int i) {
            this.b = b(i);
            return this;
        }

        public a a(d dVar) {
            b.a((Object) dVar, (Object) "geofence can't be null.");
            b.b(dVar instanceof ParcelableGeofence, "Geofence must be created using Geofence.Builder.");
            this.a.add((ParcelableGeofence) dVar);
            return this;
        }

        public a a(List<d> list) {
            if (!(list == null || list.isEmpty())) {
                for (d dVar : list) {
                    if (dVar != null) {
                        a(dVar);
                    }
                }
            }
            return this;
        }

        public GeofencingRequest a() {
            b.b(!this.a.isEmpty(), "No geofence has been added to this request.");
            return new GeofencingRequest(this.a, this.b);
        }
    }

    GeofencingRequest(int i, List<ParcelableGeofence> list, int i2) {
        this.a = i;
        this.b = list;
        this.c = i2;
    }

    private GeofencingRequest(List<ParcelableGeofence> list, int i) {
        this(1, (List) list, i);
    }

    public int a() {
        return this.a;
    }

    public List<ParcelableGeofence> b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        o.a(this, parcel, i);
    }
}
