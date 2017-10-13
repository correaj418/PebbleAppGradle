package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataType;

public class g implements Creator<DataTypeResult> {
    static void a(DataTypeResult dataTypeResult, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, dataTypeResult.a(), i, false);
        b.a(parcel, 3, dataTypeResult.b(), i, false);
        b.a(parcel, 1000, dataTypeResult.c());
        b.a(parcel, a);
    }

    public DataTypeResult a(Parcel parcel) {
        DataType dataType = null;
        int b = a.b(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < b) {
            int i2;
            DataType dataType2;
            Status status2;
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    i2 = i;
                    Status status3 = (Status) a.a(parcel, a, Status.CREATOR);
                    dataType2 = dataType;
                    status2 = status3;
                    break;
                case 3:
                    dataType2 = (DataType) a.a(parcel, a, DataType.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    DataType dataType3 = dataType;
                    status2 = status;
                    i2 = a.f(parcel, a);
                    dataType2 = dataType3;
                    break;
                default:
                    a.b(parcel, a);
                    dataType2 = dataType;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            dataType = dataType2;
        }
        if (parcel.dataPosition() == b) {
            return new DataTypeResult(i, status, dataType);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DataTypeResult[] a(int i) {
        return new DataTypeResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
