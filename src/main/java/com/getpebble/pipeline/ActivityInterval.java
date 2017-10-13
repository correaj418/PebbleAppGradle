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

public final class ActivityInterval extends Message<ActivityInterval, Builder> {
    public static final ProtoAdapter<ActivityInterval> ADAPTER = new ProtoAdapter_ActivityInterval();
    public static final Integer DEFAULT_DURATION_SEC = Integer.valueOf(0);
    public static final Integer DEFAULT_OFFSET_SEC = Integer.valueOf(0);
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", label = Label.REQUIRED, tag = 2)
    public final Integer duration_sec;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", label = Label.REQUIRED, tag = 1)
    public final Integer offset_sec;

    public static final class Builder extends com.squareup.wire.Message.Builder<ActivityInterval, Builder> {
        public Integer duration_sec;
        public Integer offset_sec;

        public Builder offset_sec(Integer num) {
            this.offset_sec = num;
            return this;
        }

        public Builder duration_sec(Integer num) {
            this.duration_sec = num;
            return this;
        }

        public ActivityInterval build() {
            if (this.offset_sec != null && this.duration_sec != null) {
                return new ActivityInterval(this.offset_sec, this.duration_sec, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(this.offset_sec, "offset_sec", this.duration_sec, "duration_sec");
        }
    }

    private static final class ProtoAdapter_ActivityInterval extends ProtoAdapter<ActivityInterval> {
        ProtoAdapter_ActivityInterval() {
            super(FieldEncoding.LENGTH_DELIMITED, ActivityInterval.class);
        }

        public int encodedSize(ActivityInterval activityInterval) {
            return (ProtoAdapter.UINT32.encodedSizeWithTag(1, activityInterval.offset_sec) + ProtoAdapter.UINT32.encodedSizeWithTag(2, activityInterval.duration_sec)) + activityInterval.unknownFields().c();
        }

        public void encode(ProtoWriter protoWriter, ActivityInterval activityInterval) {
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 1, activityInterval.offset_sec);
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 2, activityInterval.duration_sec);
            protoWriter.writeBytes(activityInterval.unknownFields());
        }

        public ActivityInterval decode(ProtoReader protoReader) {
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
                            builder.duration_sec((Integer) ProtoAdapter.UINT32.decode(protoReader));
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

        public ActivityInterval redact(ActivityInterval activityInterval) {
            Builder newBuilder = activityInterval.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public ActivityInterval(Integer num, Integer num2) {
        this(num, num2, d.b);
    }

    public ActivityInterval(Integer num, Integer num2, d dVar) {
        super(ADAPTER, dVar);
        this.offset_sec = num;
        this.duration_sec = num2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.offset_sec = this.offset_sec;
        builder.duration_sec = this.duration_sec;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActivityInterval)) {
            return false;
        }
        ActivityInterval activityInterval = (ActivityInterval) obj;
        if (unknownFields().equals(activityInterval.unknownFields()) && this.offset_sec.equals(activityInterval.offset_sec) && this.duration_sec.equals(activityInterval.duration_sec)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        i = (((unknownFields().hashCode() * 37) + this.offset_sec.hashCode()) * 37) + this.duration_sec.hashCode();
        this.hashCode = i;
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", offset_sec=").append(this.offset_sec);
        stringBuilder.append(", duration_sec=").append(this.duration_sec);
        return stringBuilder.replace(0, 2, "ActivityInterval{").append('}').toString();
    }
}
