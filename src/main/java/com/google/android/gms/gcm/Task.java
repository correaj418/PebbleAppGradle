package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.b;

public abstract class Task implements Parcelable {
    private final String a;
    private final String b;
    private final boolean c;
    private final boolean d;
    private final int e;
    private final boolean f;
    private final i g;
    private final Bundle h;

    public static abstract class a {
        protected int a;
        protected String b;
        protected String c;
        protected boolean d;
        protected boolean e;
        protected boolean f;
        protected i g = i.a;
        protected Bundle h;

        protected void a() {
            b.b(this.b != null, "Must provide an endpoint for this task by calling setService(ComponentName).");
            b.a(this.c);
            Task.a(this.g);
            if (this.e) {
                Task.b(this.h);
            }
        }
    }

    @Deprecated
    Task(Parcel parcel) {
        boolean z = true;
        Log.e("Task", "Constructing a Task object using a parcel.");
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.d = z;
        this.e = 2;
        this.f = false;
        this.g = i.a;
        this.h = null;
    }

    Task(a aVar) {
        this.a = aVar.b;
        this.b = aVar.c;
        this.c = aVar.d;
        this.d = aVar.e;
        this.e = aVar.a;
        this.f = aVar.f;
        this.h = aVar.h;
        this.g = aVar.g != null ? aVar.g : i.a;
    }

    public static void a(i iVar) {
        if (iVar != null) {
            int a = iVar.a();
            if (a == 1 || a == 0) {
                int b = iVar.b();
                int c = iVar.c();
                if (a == 0 && b < 0) {
                    throw new IllegalArgumentException("InitialBackoffSeconds can't be negative: " + b);
                } else if (a == 1 && b < 10) {
                    throw new IllegalArgumentException("RETRY_POLICY_LINEAR must have an initial backoff at least 10 seconds.");
                } else if (c < b) {
                    throw new IllegalArgumentException("MaximumBackoffSeconds must be greater than InitialBackoffSeconds: " + iVar.c());
                } else {
                    return;
                }
            }
            throw new IllegalArgumentException("Must provide a valid RetryPolicy: " + a);
        }
    }

    private static boolean a(Object obj) {
        return (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof Boolean);
    }

    public static void b(Bundle bundle) {
        if (bundle != null) {
            Parcel obtain = Parcel.obtain();
            bundle.writeToParcel(obtain, 0);
            int dataSize = obtain.dataSize();
            if (dataSize > 10240) {
                obtain.recycle();
                String valueOf = String.valueOf("Extras exceeding maximum size(10240 bytes): ");
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 11).append(valueOf).append(dataSize).toString());
            }
            obtain.recycle();
            for (String str : bundle.keySet()) {
                if (!a(bundle.get(str))) {
                    throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean. ");
                }
            }
        }
    }

    public void a(Bundle bundle) {
        bundle.putString("tag", this.b);
        bundle.putBoolean("update_current", this.c);
        bundle.putBoolean("persisted", this.d);
        bundle.putString("service", this.a);
        bundle.putInt("requiredNetwork", this.e);
        bundle.putBoolean("requiresCharging", this.f);
        bundle.putBundle("retryStrategy", this.g.a(new Bundle()));
        bundle.putBundle("extras", this.h);
    }

    public String c() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        if (!this.d) {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }
}
