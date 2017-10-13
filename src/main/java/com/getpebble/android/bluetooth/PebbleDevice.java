package com.getpebble.android.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.Locale;

public class PebbleDevice implements Parcelable {
    public static final Creator<PebbleDevice> CREATOR = new Creator<PebbleDevice>() {
        public PebbleDevice createFromParcel(Parcel parcel) {
            return new PebbleDevice(parcel);
        }

        public PebbleDevice[] newArray(int i) {
            throw new UnsupportedOperationException();
        }
    };
    private final String mAddress;
    private final String mName;
    private final short mRssi;
    private final Transport mTransport;

    public PebbleDevice(String str, String str2, Transport transport, short s) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("name null");
        } else if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("address null");
        } else if (transport == null) {
            throw new IllegalArgumentException("transport null");
        } else {
            this.mName = str;
            this.mAddress = str2;
            this.mRssi = s;
            this.mTransport = transport;
        }
    }

    public PebbleDevice(String str, String str2, Transport transport) {
        this(str, str2, transport, Short.MAX_VALUE);
    }

    public PebbleDevice(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), Transport.from(parcel.readInt()), (short) parcel.readInt());
    }

    public String getAddress() {
        return this.mAddress;
    }

    public Transport getTransport() {
        return this.mTransport;
    }

    public String getName() {
        return this.mName.toUpperCase(Locale.US);
    }

    public short getRSSI() {
        return this.mRssi;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeString(this.mAddress);
        parcel.writeInt(this.mTransport.mCode);
        parcel.writeInt(this.mRssi);
    }

    public String toString() {
        return "[ name = " + getName() + ", address = " + getAddress() + ", transport = " + getTransport() + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PebbleDevice pebbleDevice = (PebbleDevice) obj;
        if (!this.mAddress.equals(pebbleDevice.mAddress)) {
            return false;
        }
        if (this.mTransport != pebbleDevice.mTransport) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.mAddress.hashCode() * 31) + this.mTransport.hashCode();
    }
}
