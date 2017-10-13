package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class FragmentState implements Parcelable {
    public static final Creator<FragmentState> CREATOR = new Creator<FragmentState>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public FragmentState a(Parcel parcel) {
            return new FragmentState(parcel);
        }

        public FragmentState[] a(int i) {
            return new FragmentState[i];
        }
    };
    final String a;
    final int b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    final boolean j;
    Bundle k;
    k l;

    public FragmentState(k kVar) {
        this.a = kVar.getClass().getName();
        this.b = kVar.p;
        this.c = kVar.x;
        this.d = kVar.G;
        this.e = kVar.H;
        this.f = kVar.I;
        this.g = kVar.L;
        this.h = kVar.K;
        this.i = kVar.r;
        this.j = kVar.J;
    }

    public FragmentState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readInt() != 0;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.g = z;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.h = z;
        this.i = parcel.readBundle();
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.j = z2;
        this.k = parcel.readBundle();
    }

    public k a(o oVar, k kVar, r rVar) {
        if (this.l == null) {
            Context g = oVar.g();
            if (this.i != null) {
                this.i.setClassLoader(g.getClassLoader());
            }
            this.l = k.a(g, this.a, this.i);
            if (this.k != null) {
                this.k.setClassLoader(g.getClassLoader());
                this.l.n = this.k;
            }
            this.l.a(this.b, kVar);
            this.l.x = this.c;
            this.l.z = true;
            this.l.G = this.d;
            this.l.H = this.e;
            this.l.I = this.f;
            this.l.L = this.g;
            this.l.K = this.h;
            this.l.J = this.j;
            this.l.B = oVar.d;
            if (q.a) {
                Log.v("FragmentManager", "Instantiated fragment " + this.l);
            }
        }
        this.l.E = rVar;
        return this.l;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        if (this.g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.h) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.i);
        if (!this.j) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeBundle(this.k);
    }
}
