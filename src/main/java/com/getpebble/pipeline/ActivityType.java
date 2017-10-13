package com.getpebble.pipeline;

import b.d;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoAdapter.EnumConstantNotFoundException;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

public final class ActivityType extends Message<ActivityType, Builder> {
    public static final ProtoAdapter<ActivityType> ADAPTER = new ProtoAdapter_ActivityType();
    public static final String DEFAULT_CUSTOM_TYPE = "";
    public static final InternalType DEFAULT_INTERNAL_TYPE = InternalType.UnknownType;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String custom_type;
    @WireField(adapter = "com.getpebble.pipeline.ActivityType$InternalType#ADAPTER", tag = 1)
    public final InternalType internal_type;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String name;

    public static final class Builder extends com.squareup.wire.Message.Builder<ActivityType, Builder> {
        public String custom_type;
        public InternalType internal_type;
        public String name;

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder internal_type(InternalType internalType) {
            this.internal_type = internalType;
            this.custom_type = null;
            return this;
        }

        public Builder custom_type(String str) {
            this.custom_type = str;
            this.internal_type = null;
            return this;
        }

        public ActivityType build() {
            return new ActivityType(this.name, this.internal_type, this.custom_type, super.buildUnknownFields());
        }
    }

    public enum InternalType implements WireEnum {
        UnknownType(0),
        Sleep(1),
        DeepSleep(2),
        Nap(3),
        DeepNap(4),
        Walk(5),
        Run(6);
        
        public static final ProtoAdapter<InternalType> ADAPTER = null;
        private final int value;

        static {
            ADAPTER = ProtoAdapter.newEnumAdapter(InternalType.class);
        }

        private InternalType(int i) {
            this.value = i;
        }

        public static InternalType fromValue(int i) {
            switch (i) {
                case 0:
                    return UnknownType;
                case 1:
                    return Sleep;
                case 2:
                    return DeepSleep;
                case 3:
                    return Nap;
                case 4:
                    return DeepNap;
                case 5:
                    return Walk;
                case 6:
                    return Run;
                default:
                    return null;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    private static final class ProtoAdapter_ActivityType extends ProtoAdapter<ActivityType> {
        ProtoAdapter_ActivityType() {
            super(FieldEncoding.LENGTH_DELIMITED, ActivityType.class);
        }

        public int encodedSize(ActivityType activityType) {
            int encodedSizeWithTag;
            int i = 0;
            int encodedSizeWithTag2 = activityType.name != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, activityType.name) : 0;
            if (activityType.internal_type != null) {
                encodedSizeWithTag = InternalType.ADAPTER.encodedSizeWithTag(1, activityType.internal_type);
            } else {
                encodedSizeWithTag = 0;
            }
            encodedSizeWithTag2 += encodedSizeWithTag;
            if (activityType.custom_type != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(2, activityType.custom_type);
            }
            return (encodedSizeWithTag2 + i) + activityType.unknownFields().c();
        }

        public void encode(ProtoWriter protoWriter, ActivityType activityType) {
            if (activityType.name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, activityType.name);
            }
            if (activityType.internal_type != null) {
                InternalType.ADAPTER.encodeWithTag(protoWriter, 1, activityType.internal_type);
            }
            if (activityType.custom_type != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, activityType.custom_type);
            }
            protoWriter.writeBytes(activityType.unknownFields());
        }

        public ActivityType decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            try {
                                builder.internal_type((InternalType) InternalType.ADAPTER.decode(protoReader));
                                break;
                            } catch (EnumConstantNotFoundException e) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e.value));
                                break;
                            }
                        case 2:
                            builder.custom_type((String) ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.name((String) ProtoAdapter.STRING.decode(protoReader));
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

        public ActivityType redact(ActivityType activityType) {
            Builder newBuilder = activityType.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public ActivityType(String str, InternalType internalType, String str2) {
        this(str, internalType, str2, d.b);
    }

    public ActivityType(String str, InternalType internalType, String str2, d dVar) {
        super(ADAPTER, dVar);
        if (Internal.countNonNull(internalType, str2) > 1) {
            throw new IllegalArgumentException("at most one of internal_type, custom_type may be non-null");
        }
        this.name = str;
        this.internal_type = internalType;
        this.custom_type = str2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.name = this.name;
        builder.internal_type = this.internal_type;
        builder.custom_type = this.custom_type;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActivityType)) {
            return false;
        }
        ActivityType activityType = (ActivityType) obj;
        if (unknownFields().equals(activityType.unknownFields()) && Internal.equals(this.name, activityType.name) && Internal.equals(this.internal_type, activityType.internal_type) && Internal.equals(this.custom_type, activityType.custom_type)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int i2 = this.hashCode;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = ((this.name != null ? this.name.hashCode() : 0) + (unknownFields().hashCode() * 37)) * 37;
        if (this.internal_type != null) {
            i2 = this.internal_type.hashCode();
        } else {
            i2 = 0;
        }
        i2 = (i2 + hashCode) * 37;
        if (this.custom_type != null) {
            i = this.custom_type.hashCode();
        }
        i2 += i;
        this.hashCode = i2;
        return i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.name != null) {
            stringBuilder.append(", name=").append(this.name);
        }
        if (this.internal_type != null) {
            stringBuilder.append(", internal_type=").append(this.internal_type);
        }
        if (this.custom_type != null) {
            stringBuilder.append(", custom_type=").append(this.custom_type);
        }
        return stringBuilder.replace(0, 2, "ActivityType{").append('}').toString();
    }
}
