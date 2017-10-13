package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PeriodicTask extends Task {
    public static final Creator<PeriodicTask> CREATOR = new Creator<PeriodicTask>() {
        public PeriodicTask a(Parcel parcel) {
            return new PeriodicTask(parcel);
        }

        public PeriodicTask[] a(int i) {
            return new PeriodicTask[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }
    };
    protected long a;
    protected long b;

    public static class a extends com.google.android.gms.gcm.Task.a {
        private long i;
        private long j;

        public a() {
            this.i = -1;
            this.j = -1;
            this.e = true;
        }

        public a a(int i) {
            this.a = i;
            return this;
        }

        public a a(long j) {
            this.i = j;
            return this;
        }

        public a a(Class<? extends d> cls) {
            this.b = cls.getName();
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        protected void a() {
            super.a();
            if (this.i == -1) {
                throw new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
            } else if (this.i <= 0) {
                throw new IllegalArgumentException("Period set cannot be less than or equal to 0: " + this.i);
            } else if (this.j == -1) {
                this.j = (long) (((float) this.i) * 0.1f);
            } else if (this.j > this.i) {
                this.j = this.i;
            }
        }

        public PeriodicTask b() {
            a();
            return new PeriodicTask();
        }
    }

    @Deprecated
    private PeriodicTask(Parcel parcel) {
        super(parcel);
        this.a = -1;
        this.b = -1;
        this.a = parcel.readLong();
        this.b = Math.min(parcel.readLong(), this.a);
    }

    private PeriodicTask(a aVar) {
        super((com.google.android.gms.gcm.Task.a) aVar);
        this.a = -1;
        this.b = -1;
        this.a = aVar.i;
        this.b = Math.min(aVar.j, this.a);
    }

    public long a() {
        return this.a;
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        bundle.putLong("period", this.a);
        bundle.putLong("period_flex", this.b);
    }

    public long b() {
        return this.b;
    }

    public String toString() {
        String valueOf = String.valueOf(super.toString());
        long a = a();
        return new StringBuilder(String.valueOf(valueOf).length() + 54).append(valueOf).append(" period=").append(a).append(" flex=").append(b()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
    }
}
