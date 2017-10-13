package com.squareup.wire;

import b.a;
import b.b;
import b.d;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

public abstract class Message<M extends Message<M, B>, B extends Builder<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;
    private final transient ProtoAdapter<M> adapter;
    transient int cachedSerializedSize = 0;
    protected transient int hashCode = 0;
    private final transient d unknownFields;

    public static abstract class Builder<T extends Message<T, B>, B extends Builder<T, B>> {
        a unknownFieldsBuffer;
        ProtoWriter unknownFieldsWriter;

        public abstract T build();

        protected Builder() {
        }

        public final Builder<T, B> addUnknownFields(d dVar) {
            if (dVar.c() > 0) {
                if (this.unknownFieldsWriter == null) {
                    this.unknownFieldsBuffer = new a();
                    this.unknownFieldsWriter = new ProtoWriter(this.unknownFieldsBuffer);
                }
                try {
                    this.unknownFieldsWriter.writeBytes(dVar);
                } catch (IOException e) {
                    throw new AssertionError();
                }
            }
            return this;
        }

        public final Builder<T, B> addUnknownField(int i, FieldEncoding fieldEncoding, Object obj) {
            if (this.unknownFieldsWriter == null) {
                this.unknownFieldsBuffer = new a();
                this.unknownFieldsWriter = new ProtoWriter(this.unknownFieldsBuffer);
            }
            try {
                fieldEncoding.rawProtoAdapter().encodeWithTag(this.unknownFieldsWriter, i, obj);
                return this;
            } catch (IOException e) {
                throw new AssertionError();
            }
        }

        public final Builder<T, B> clearUnknownFields() {
            this.unknownFieldsWriter = null;
            this.unknownFieldsBuffer = null;
            return this;
        }

        public final d buildUnknownFields() {
            return this.unknownFieldsBuffer != null ? this.unknownFieldsBuffer.m().j() : d.b;
        }
    }

    public abstract Builder<M, B> newBuilder();

    protected Message(ProtoAdapter<M> protoAdapter, d dVar) {
        if (protoAdapter == null) {
            throw new NullPointerException("adapter == null");
        } else if (dVar == null) {
            throw new NullPointerException("unknownFields == null");
        } else {
            this.adapter = protoAdapter;
            this.unknownFields = dVar;
        }
    }

    public final d unknownFields() {
        d dVar = this.unknownFields;
        return dVar != null ? dVar : d.b;
    }

    public final M withoutUnknownFields() {
        return newBuilder().clearUnknownFields().build();
    }

    public String toString() {
        return this.adapter.toString(this);
    }

    protected final Object writeReplace() {
        return new MessageSerializedForm(encode(), getClass());
    }

    public final ProtoAdapter<M> adapter() {
        return this.adapter;
    }

    public final void encode(b bVar) {
        this.adapter.encode(bVar, (Object) this);
    }

    public final byte[] encode() {
        return this.adapter.encode(this);
    }

    public final void encode(OutputStream outputStream) {
        this.adapter.encode(outputStream, (Object) this);
    }
}
