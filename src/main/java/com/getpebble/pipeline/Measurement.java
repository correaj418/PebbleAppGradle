package com.getpebble.pipeline;

import b.d;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.WireField.Label;
import com.squareup.wire.internal.Internal;
import java.util.List;

public final class Measurement extends Message<Measurement, Builder> {
    public static final ProtoAdapter<Measurement> ADAPTER = new ProtoAdapter_Measurement();
    public static final Integer DEFAULT_OFFSET_SEC = Integer.valueOf(0);
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", label = Label.PACKED, tag = 2)
    public final List<Integer> data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", label = Label.REQUIRED, tag = 1)
    public final Integer offset_sec;

    public static final class Builder extends com.squareup.wire.Message.Builder<Measurement, Builder> {
        public List<Integer> data = Internal.newMutableList();
        public Integer offset_sec;

        public Builder offset_sec(Integer num) {
            this.offset_sec = num;
            return this;
        }

        public Builder data(List<Integer> list) {
            Internal.checkElementsNotNull((List) list);
            this.data = list;
            return this;
        }

        public Measurement build() {
            if (this.offset_sec != null) {
                return new Measurement(this.offset_sec, this.data, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(this.offset_sec, "offset_sec");
        }
    }

    private static final class ProtoAdapter_Measurement extends ProtoAdapter<Measurement> {
        ProtoAdapter_Measurement() {
            super(FieldEncoding.LENGTH_DELIMITED, Measurement.class);
        }

        public int encodedSize(Measurement measurement) {
            return (ProtoAdapter.UINT32.encodedSizeWithTag(1, measurement.offset_sec) + ProtoAdapter.UINT32.asPacked().encodedSizeWithTag(2, measurement.data)) + measurement.unknownFields().c();
        }

        public void encode(ProtoWriter protoWriter, Measurement measurement) {
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 1, measurement.offset_sec);
            ProtoAdapter.UINT32.asPacked().encodeWithTag(protoWriter, 2, measurement.data);
            protoWriter.writeBytes(measurement.unknownFields());
        }

        public Measurement decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.offset_sec((Integer) ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 2:
                            builder.data.add(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                }
                protoReader.endMessage(beginMessage);
                return builder.build();
            }
        }

        public Measurement redact(Measurement measurement) {
            Builder newBuilder = measurement.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public Measurement(Integer num, List<Integer> list) {
        this(num, list, d.b);
    }

    public Measurement(Integer num, List<Integer> list, d dVar) {
        super(ADAPTER, dVar);
        this.offset_sec = num;
        this.data = Internal.immutableCopyOf("data", (List) list);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.offset_sec = this.offset_sec;
        builder.data = Internal.copyOf("data", this.data);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Measurement)) {
            return false;
        }
        Measurement measurement = (Measurement) obj;
        if (unknownFields().equals(measurement.unknownFields()) && this.offset_sec.equals(measurement.offset_sec) && this.data.equals(measurement.data)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        i = (((unknownFields().hashCode() * 37) + this.offset_sec.hashCode()) * 37) + this.data.hashCode();
        this.hashCode = i;
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", offset_sec=").append(this.offset_sec);
        if (!this.data.isEmpty()) {
            stringBuilder.append(", data=").append(this.data);
        }
        return stringBuilder.replace(0, 2, "Measurement{").append('}').toString();
    }
}
