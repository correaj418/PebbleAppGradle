package com.squareup.wire;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import b.d;
import com.squareup.wire.Message.Builder;
import java.lang.reflect.Array;

public abstract class AndroidMessage<M extends Message<M, B>, B extends Builder<M, B>> extends Message<M, B> implements Parcelable {

    private static final class ProtoAdapterCreator<M> implements Creator<M> {
        private final ProtoAdapter<M> adapter;

        ProtoAdapterCreator(ProtoAdapter<M> protoAdapter) {
            this.adapter = protoAdapter;
        }

        public M createFromParcel(Parcel parcel) {
            try {
                return this.adapter.decode(parcel.createByteArray());
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public M[] newArray(int i) {
            return (Object[]) Array.newInstance(this.adapter.javaType, i);
        }
    }

    public static <E> Creator<E> newCreator(ProtoAdapter<E> protoAdapter) {
        return new ProtoAdapterCreator(protoAdapter);
    }

    protected AndroidMessage(ProtoAdapter<M> protoAdapter, d dVar) {
        super(protoAdapter, dVar);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(encode());
    }

    public final int describeContents() {
        return 0;
    }
}
