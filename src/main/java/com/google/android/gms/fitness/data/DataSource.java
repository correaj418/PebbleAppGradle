package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class DataSource extends AbstractSafeParcelable {
    public static final Creator<DataSource> CREATOR = new f();
    private final int a;
    private final DataType b;
    private final String c;
    private final int d;
    private final Device e;
    private final Application f;
    private final String g;
    private final String h;

    public static final class a {
        private DataType a;
        private int b = -1;
        private String c;
        private Device d;
        private Application e;
        private String f = "";

        public a a(int i) {
            this.b = i;
            return this;
        }

        public a a(Context context) {
            return b(context.getPackageName());
        }

        public a a(DataType dataType) {
            this.a = dataType;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public DataSource a() {
            boolean z = true;
            b.a(this.a != null, (Object) "Must set data type");
            if (this.b < 0) {
                z = false;
            }
            b.a(z, (Object) "Must set data source type");
            return new DataSource();
        }

        public a b(String str) {
            this.e = Application.a(str);
            return this;
        }
    }

    DataSource(int i, DataType dataType, String str, int i2, Device device, Application application, String str2) {
        this.a = i;
        this.b = dataType;
        this.d = i2;
        this.c = str;
        this.e = device;
        this.f = application;
        this.g = str2;
        this.h = j();
    }

    private DataSource(a aVar) {
        this.a = 3;
        this.b = aVar.a;
        this.d = aVar.b;
        this.c = aVar.c;
        this.e = aVar.d;
        this.f = aVar.e;
        this.g = aVar.f;
        this.h = j();
    }

    private boolean a(DataSource dataSource) {
        return this.h.equals(dataSource.h);
    }

    private String j() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(k());
        stringBuilder.append(":").append(this.b.a());
        if (this.f != null) {
            stringBuilder.append(":").append(this.f.a());
        }
        if (this.e != null) {
            stringBuilder.append(":").append(this.e.g());
        }
        if (this.g != null) {
            stringBuilder.append(":").append(this.g);
        }
        return stringBuilder.toString();
    }

    private String k() {
        switch (this.d) {
            case 0:
                return "raw";
            case 1:
                return "derived";
            default:
                throw new IllegalArgumentException("invalid type value");
        }
    }

    public DataType a() {
        return this.b;
    }

    public int b() {
        return this.d;
    }

    public String c() {
        return this.c;
    }

    public Application d() {
        return this.f;
    }

    public Device e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataSource) && a((DataSource) obj));
    }

    public String f() {
        return this.g;
    }

    public String g() {
        return this.h;
    }

    public String h() {
        String str;
        String str2;
        String valueOf;
        String str3 = this.d == 0 ? "r" : "d";
        String valueOf2 = String.valueOf(this.b.c());
        if (this.f == null) {
            str = "";
        } else if (this.f.equals(Application.a)) {
            str = ":gms";
        } else {
            str2 = ":";
            str = String.valueOf(this.f.a());
            str = str.length() != 0 ? str2.concat(str) : new String(str2);
        }
        if (this.e != null) {
            str2 = String.valueOf(this.e.b());
            valueOf = String.valueOf(this.e.d());
            str2 = new StringBuilder((String.valueOf(str2).length() + 2) + String.valueOf(valueOf).length()).append(":").append(str2).append(":").append(valueOf).toString();
        } else {
            str2 = "";
        }
        if (this.g != null) {
            String str4 = ":";
            valueOf = String.valueOf(this.g);
            valueOf = valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4);
        } else {
            valueOf = "";
        }
        return new StringBuilder(((((String.valueOf(str3).length() + 1) + String.valueOf(valueOf2).length()) + String.valueOf(str).length()) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()).append(str3).append(":").append(valueOf2).append(str).append(str2).append(valueOf).toString();
    }

    public int hashCode() {
        return this.h.hashCode();
    }

    int i() {
        return this.a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DataSource{");
        stringBuilder.append(k());
        if (this.c != null) {
            stringBuilder.append(":").append(this.c);
        }
        if (this.f != null) {
            stringBuilder.append(":").append(this.f);
        }
        if (this.e != null) {
            stringBuilder.append(":").append(this.e);
        }
        if (this.g != null) {
            stringBuilder.append(":").append(this.g);
        }
        stringBuilder.append(":").append(this.b);
        return stringBuilder.append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        f.a(this, parcel, i);
    }
}
