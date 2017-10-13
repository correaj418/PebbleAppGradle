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

public final class Tier extends Message<Tier, Builder> {
    public static final ProtoAdapter<Tier> ADAPTER = new ProtoAdapter_Tier();
    public static final String DEFAULT_COMMENT = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_TYPE = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String comment;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = Label.REQUIRED, tag = 2)
    public final String id;
    @WireField(adapter = "com.getpebble.pipeline.LocationInfo#ADAPTER", tag = 3)
    public final LocationInfo location;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = Label.REQUIRED, tag = 1)
    public final String type;
    @WireField(adapter = "com.getpebble.pipeline.Version#ADAPTER", tag = 5)
    public final Version version;

    public static final class Builder extends com.squareup.wire.Message.Builder<Tier, Builder> {
        public String comment;
        public String id;
        public LocationInfo location;
        public String type;
        public Version version;

        public Builder type(String str) {
            this.type = str;
            return this;
        }

        public Builder id(String str) {
            this.id = str;
            return this;
        }

        public Builder location(LocationInfo locationInfo) {
            this.location = locationInfo;
            return this;
        }

        public Builder comment(String str) {
            this.comment = str;
            return this;
        }

        public Builder version(Version version) {
            this.version = version;
            return this;
        }

        public Tier build() {
            if (this.type != null && this.id != null) {
                return new Tier(this.type, this.id, this.location, this.comment, this.version, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(this.type, "type", this.id, "id");
        }
    }

    private static final class ProtoAdapter_Tier extends ProtoAdapter<Tier> {
        ProtoAdapter_Tier() {
            super(FieldEncoding.LENGTH_DELIMITED, Tier.class);
        }

        public int encodedSize(Tier tier) {
            int encodedSizeWithTag;
            int i = 0;
            int encodedSizeWithTag2 = ProtoAdapter.STRING.encodedSizeWithTag(2, tier.id) + ProtoAdapter.STRING.encodedSizeWithTag(1, tier.type);
            if (tier.location != null) {
                encodedSizeWithTag = LocationInfo.ADAPTER.encodedSizeWithTag(3, tier.location);
            } else {
                encodedSizeWithTag = 0;
            }
            encodedSizeWithTag2 += encodedSizeWithTag;
            if (tier.comment != null) {
                encodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(4, tier.comment);
            } else {
                encodedSizeWithTag = 0;
            }
            encodedSizeWithTag += encodedSizeWithTag2;
            if (tier.version != null) {
                i = Version.ADAPTER.encodedSizeWithTag(5, tier.version);
            }
            return (encodedSizeWithTag + i) + tier.unknownFields().c();
        }

        public void encode(ProtoWriter protoWriter, Tier tier) {
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, tier.type);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, tier.id);
            if (tier.location != null) {
                LocationInfo.ADAPTER.encodeWithTag(protoWriter, 3, tier.location);
            }
            if (tier.comment != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, tier.comment);
            }
            if (tier.version != null) {
                Version.ADAPTER.encodeWithTag(protoWriter, 5, tier.version);
            }
            protoWriter.writeBytes(tier.unknownFields());
        }

        public Tier decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.type((String) ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            builder.id((String) ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.location((LocationInfo) LocationInfo.ADAPTER.decode(protoReader));
                            break;
                        case 4:
                            builder.comment((String) ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.version((Version) Version.ADAPTER.decode(protoReader));
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

        public Tier redact(Tier tier) {
            Builder newBuilder = tier.newBuilder();
            if (newBuilder.location != null) {
                newBuilder.location = (LocationInfo) LocationInfo.ADAPTER.redact(newBuilder.location);
            }
            if (newBuilder.version != null) {
                newBuilder.version = (Version) Version.ADAPTER.redact(newBuilder.version);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public Tier(String str, String str2, LocationInfo locationInfo, String str3, Version version) {
        this(str, str2, locationInfo, str3, version, d.b);
    }

    public Tier(String str, String str2, LocationInfo locationInfo, String str3, Version version, d dVar) {
        super(ADAPTER, dVar);
        this.type = str;
        this.id = str2;
        this.location = locationInfo;
        this.comment = str3;
        this.version = version;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.type = this.type;
        builder.id = this.id;
        builder.location = this.location;
        builder.comment = this.comment;
        builder.version = this.version;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Tier)) {
            return false;
        }
        Tier tier = (Tier) obj;
        if (unknownFields().equals(tier.unknownFields()) && this.type.equals(tier.type) && this.id.equals(tier.id) && Internal.equals(this.location, tier.location) && Internal.equals(this.comment, tier.comment) && Internal.equals(this.version, tier.version)) {
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
        int hashCode = ((this.location != null ? this.location.hashCode() : 0) + (((((unknownFields().hashCode() * 37) + this.type.hashCode()) * 37) + this.id.hashCode()) * 37)) * 37;
        if (this.comment != null) {
            i2 = this.comment.hashCode();
        } else {
            i2 = 0;
        }
        i2 = (i2 + hashCode) * 37;
        if (this.version != null) {
            i = this.version.hashCode();
        }
        i2 += i;
        this.hashCode = i2;
        return i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", type=").append(this.type);
        stringBuilder.append(", id=").append(this.id);
        if (this.location != null) {
            stringBuilder.append(", location=").append(this.location);
        }
        if (this.comment != null) {
            stringBuilder.append(", comment=").append(this.comment);
        }
        if (this.version != null) {
            stringBuilder.append(", version=").append(this.version);
        }
        return stringBuilder.replace(0, 2, "Tier{").append('}').toString();
    }
}
