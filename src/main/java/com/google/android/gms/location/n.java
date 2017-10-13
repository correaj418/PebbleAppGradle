package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class n implements Creator<ActivityRecognitionRequest> {
    static void a(ActivityRecognitionRequest activityRecognitionRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, activityRecognitionRequest.a());
        b.a(parcel, 2, activityRecognitionRequest.b());
        b.a(parcel, 3, activityRecognitionRequest.c(), i, false);
        b.a(parcel, 4, activityRecognitionRequest.d(), false);
        b.a(parcel, 5, activityRecognitionRequest.e(), false);
        b.a(parcel, 6, activityRecognitionRequest.f());
        b.a(parcel, 7, activityRecognitionRequest.g(), false);
        b.a(parcel, 1000, activityRecognitionRequest.h());
        b.a(parcel, a);
    }

    public ActivityRecognitionRequest a(Parcel parcel) {
        boolean z = false;
        String str = null;
        int b = a.b(parcel);
        long j = 0;
        int[] iArr = null;
        String str2 = null;
        WorkSource workSource = null;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    j = a.h(parcel, a);
                    break;
                case 2:
                    z2 = a.c(parcel, a);
                    break;
                case 3:
                    workSource = (WorkSource) a.a(parcel, a, WorkSource.CREATOR);
                    break;
                case 4:
                    str2 = a.l(parcel, a);
                    break;
                case 5:
                    iArr = a.p(parcel, a);
                    break;
                case 6:
                    z = a.c(parcel, a);
                    break;
                case 7:
                    str = a.l(parcel, a);
                    break;
                case 1000:
                    i = a.f(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ActivityRecognitionRequest(i, j, z2, workSource, str2, iArr, z, str);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public ActivityRecognitionRequest[] a(int i) {
        return new ActivityRecognitionRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
