package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class a implements Creator<ActivityRecognitionResult> {
    static void a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.c(parcel, 1, activityRecognitionResult.a, false);
        b.a(parcel, 2, activityRecognitionResult.b);
        b.a(parcel, 3, activityRecognitionResult.c);
        b.a(parcel, 4, activityRecognitionResult.d);
        b.a(parcel, 5, activityRecognitionResult.e, false);
        b.a(parcel, 1000, activityRecognitionResult.a());
        b.a(parcel, a);
    }

    public ActivityRecognitionResult a(Parcel parcel) {
        long j = 0;
        Bundle bundle = null;
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        long j2 = 0;
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                case 1:
                    list = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, DetectedActivity.CREATOR);
                    break;
                case 2:
                    j2 = com.google.android.gms.common.internal.safeparcel.a.h(parcel, a);
                    break;
                case 3:
                    j = com.google.android.gms.common.internal.safeparcel.a.h(parcel, a);
                    break;
                case 4:
                    i = com.google.android.gms.common.internal.safeparcel.a.f(parcel, a);
                    break;
                case 5:
                    bundle = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    break;
                case 1000:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, a);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ActivityRecognitionResult(i2, list, j2, j, i, bundle);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + b, parcel);
    }

    public ActivityRecognitionResult[] a(int i) {
        return new ActivityRecognitionResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
