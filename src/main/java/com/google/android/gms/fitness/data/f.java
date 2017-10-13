package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class f implements Creator<DataSource> {
    static void a(DataSource dataSource, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, dataSource.a(), i, false);
        b.a(parcel, 2, dataSource.c(), false);
        b.a(parcel, 3, dataSource.b());
        b.a(parcel, 4, dataSource.e(), i, false);
        b.a(parcel, 5, dataSource.d(), i, false);
        b.a(parcel, 6, dataSource.f(), false);
        b.a(parcel, 1000, dataSource.i());
        b.a(parcel, a);
    }

    public DataSource a(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = a.b(parcel);
        Application application = null;
        Device device = null;
        String str2 = null;
        DataType dataType = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    dataType = (DataType) a.a(parcel, a, DataType.CREATOR);
                    break;
                case 2:
                    str2 = a.l(parcel, a);
                    break;
                case 3:
                    i = a.f(parcel, a);
                    break;
                case 4:
                    device = (Device) a.a(parcel, a, Device.CREATOR);
                    break;
                case 5:
                    application = (Application) a.a(parcel, a, Application.CREATOR);
                    break;
                case 6:
                    str = a.l(parcel, a);
                    break;
                case 1000:
                    i2 = a.f(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new DataSource(i2, dataType, str2, i, device, application, str);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DataSource[] a(int i) {
        return new DataSource[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
