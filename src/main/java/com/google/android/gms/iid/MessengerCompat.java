package com.google.android.gms.iid;

import android.annotation.TargetApi;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MessengerCompat implements Parcelable {
    public static final Creator<MessengerCompat> CREATOR = new Creator<MessengerCompat>() {
        public MessengerCompat a(Parcel parcel) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            return readStrongBinder != null ? new MessengerCompat(readStrongBinder) : null;
        }

        public MessengerCompat[] a(int i) {
            return new MessengerCompat[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }
    };
    Messenger a;
    d b;

    private final class a extends com.google.android.gms.iid.d.a {
        Handler a;
        final /* synthetic */ MessengerCompat b;

        a(MessengerCompat messengerCompat, Handler handler) {
            this.b = messengerCompat;
            this.a = handler;
        }

        public void a(Message message) {
            message.arg2 = Binder.getCallingUid();
            this.a.dispatchMessage(message);
        }
    }

    public MessengerCompat(Handler handler) {
        if (VERSION.SDK_INT >= 21) {
            this.a = new Messenger(handler);
        } else {
            this.b = new a(this, handler);
        }
    }

    public MessengerCompat(IBinder iBinder) {
        if (VERSION.SDK_INT >= 21) {
            this.a = new Messenger(iBinder);
        } else {
            this.b = com.google.android.gms.iid.d.a.a(iBinder);
        }
    }

    public static int a(Message message) {
        return VERSION.SDK_INT >= 21 ? c(message) : message.arg2;
    }

    @TargetApi(21)
    private static int c(Message message) {
        return message.sendingUid;
    }

    public IBinder a() {
        return this.a != null ? this.a.getBinder() : this.b.asBinder();
    }

    public void b(Message message) {
        if (this.a != null) {
            this.a.send(message);
        } else {
            this.b.a(message);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                z = a().equals(((MessengerCompat) obj).a());
            } catch (ClassCastException e) {
            }
        }
        return z;
    }

    public int hashCode() {
        return a().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.a != null) {
            parcel.writeStrongBinder(this.a.getBinder());
        } else {
            parcel.writeStrongBinder(this.b.asBinder());
        }
    }
}
