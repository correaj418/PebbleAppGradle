package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OneoffTask extends Task {
    public static final Creator<OneoffTask> CREATOR = new Creator<OneoffTask>() {
        public OneoffTask a(Parcel parcel) {
            return new OneoffTask(parcel);
        }

        public OneoffTask[] a(int i) {
            return new OneoffTask[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }
    };
    private final long a;
    private final long b;

    public static class a extends com.google.android.gms.gcm.Task.a {
        private long i;
        private long j;

        public a() {
            this.i = -1;
            this.j = -1;
            this.e = false;
        }

        public a a(int i) {
            this.a = i;
            return this;
        }

        public a a(long j, long j2) {
            this.i = j;
            this.j = j2;
            return this;
        }

        public a a(Bundle bundle) {
            this.h = bundle;
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
            if (this.i == -1 || this.j == -1) {
                throw new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
            } else if (this.i >= this.j) {
                throw new IllegalArgumentException("Window start must be shorter than window end.");
            }
        }

        public OneoffTask b() {
            a();
            return new OneoffTask();
        }
    }

    @Deprecated
    private OneoffTask(Parcel parcel) {
        super(parcel);
        this.a = parcel.readLong();
        this.b = parcel.readLong();
    }

    private OneoffTask(a aVar) {
        super((com.google.android.gms.gcm.Task.a) aVar);
        this.a = aVar.i;
        this.b = aVar.j;
    }

    public long a() {
        return this.a;
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        bundle.putLong("window_start", this.a);
        bundle.putLong("window_end", this.b);
    }

    public long b() {
        return this.b;
    }

    public String toString() {
        String valueOf = String.valueOf(super.toString());
        long a = a();
        return new StringBuilder(String.valueOf(valueOf).length() + 64).append(valueOf).append(" windowStart=").append(a).append(" windowEnd=").append(b()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
    }
}
