package com.getpebble.android.framework.appmessage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.getpebble.android.common.b.a.f;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AppMessage implements Parcelable {
    public static final Creator<AppMessage> CREATOR = new Creator<AppMessage>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public AppMessage a(Parcel parcel) {
            return new AppMessage(parcel);
        }

        public AppMessage[] a(int i) {
            return new AppMessage[i];
        }
    };
    private static AtomicInteger e = new AtomicInteger(0);
    private static ConcurrentHashMap<Byte, UUID> f = new ConcurrentHashMap();
    protected UUID a;
    protected c b;
    protected byte c;
    protected a d;

    public enum a {
        PUSH((byte) 1),
        REQUEST((byte) 2),
        ACK((byte) -1),
        NACK(Byte.MAX_VALUE);
        
        byte mCode;

        private a(byte b) {
            this.mCode = b;
        }

        public byte getCode() {
            return this.mCode;
        }

        public static a fromByte(byte b) {
            for (a aVar : values()) {
                if (aVar.getCode() == b) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public AppMessage(byte b, UUID uuid, a aVar, c cVar) {
        this.a = uuid;
        this.b = cVar;
        this.c = b;
        this.d = aVar;
    }

    public static byte a(UUID uuid) {
        e.compareAndSet(256, 0);
        byte andIncrement = (byte) (e.getAndIncrement() & 255);
        a(andIncrement, uuid);
        return andIncrement;
    }

    public UUID a() {
        return this.a;
    }

    public c b() {
        return this.b;
    }

    public byte c() {
        return this.c;
    }

    public int d() {
        return this.c & 255;
    }

    public a e() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.a);
        parcel.writeString(this.b.c());
        parcel.writeByte(this.c);
        parcel.writeInt(this.d == null ? -1 : this.d.ordinal());
    }

    private AppMessage(Parcel parcel) {
        this.a = (UUID) parcel.readSerializable();
        try {
            this.b = b.a(parcel.readString());
        } catch (Throwable e) {
            f.a("AppMessage", "unable to parse dictionary", e);
        }
        this.c = parcel.readByte();
        int readInt = parcel.readInt();
        this.d = readInt == -1 ? null : a.values()[readInt];
    }

    private static void a(byte b, UUID uuid) {
        f.put(Byte.valueOf(b), uuid);
    }

    public static UUID a(byte b) {
        UUID uuid = (UUID) f.get(Byte.valueOf(b));
        if (uuid == null) {
            f.b("AppMessage", " there is not UUID for transactionId : " + b);
        }
        return uuid;
    }

    public String toString() {
        return "AppMessage [ mUuid = " + this.a + " txid: " + d() + " cmd: " + e().toString() + " mPebbleDictionary = " + this.b + "]";
    }
}
