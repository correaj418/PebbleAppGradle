package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Comparator;

public class DetectedActivity extends AbstractSafeParcelable {
    public static final b CREATOR = new b();
    public static final Comparator<DetectedActivity> a = new Comparator<DetectedActivity>() {
        public int a(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
            int compareTo = Integer.valueOf(detectedActivity2.b()).compareTo(Integer.valueOf(detectedActivity.b()));
            return compareTo == 0 ? Integer.valueOf(detectedActivity.a()).compareTo(Integer.valueOf(detectedActivity2.a())) : compareTo;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return a((DetectedActivity) obj, (DetectedActivity) obj2);
        }
    };
    public static final int[] b = new int[]{9, 10};
    public static final int[] c = new int[]{0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14};
    int d;
    int e;
    private final int f;

    public DetectedActivity(int i, int i2, int i3) {
        this.f = i;
        this.d = i2;
        this.e = i3;
    }

    public static String a(int i) {
        switch (i) {
            case 0:
                return "IN_VEHICLE";
            case 1:
                return "ON_BICYCLE";
            case 2:
                return "ON_FOOT";
            case 3:
                return "STILL";
            case 4:
                return "UNKNOWN";
            case 5:
                return "TILTING";
            case 7:
                return "WALKING";
            case 8:
                return "RUNNING";
            default:
                return Integer.toString(i);
        }
    }

    private int b(int i) {
        return i > 15 ? 4 : i;
    }

    public int a() {
        return b(this.d);
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DetectedActivity detectedActivity = (DetectedActivity) obj;
        return this.d == detectedActivity.d && this.e == detectedActivity.e;
    }

    public int hashCode() {
        return ab.a(Integer.valueOf(this.d), Integer.valueOf(this.e));
    }

    public String toString() {
        String valueOf = String.valueOf(a(a()));
        return new StringBuilder(String.valueOf(valueOf).length() + 48).append("DetectedActivity [type=").append(valueOf).append(", confidence=").append(this.e).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel, i);
    }
}
