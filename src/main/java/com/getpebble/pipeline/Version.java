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

public final class Version extends Message<Version, Builder> {
    public static final ProtoAdapter<Version> ADAPTER = new ProtoAdapter_Version();
    public static final Integer DEFAULT_MAJOR = Integer.valueOf(0);
    public static final Integer DEFAULT_MINOR = Integer.valueOf(0);
    public static final String DEFAULT_PATCH = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", label = Label.REQUIRED, tag = 4)
    public final Integer major;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", label = Label.REQUIRED, tag = 5)
    public final Integer minor;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String patch;

    public static final class Builder extends com.squareup.wire.Message.Builder<Version, Builder> {
        public Integer major;
        public Integer minor;
        public String patch;

        public Builder major(Integer num) {
            this.major = num;
            return this;
        }

        public Builder minor(Integer num) {
            this.minor = num;
            return this;
        }

        public Builder patch(String str) {
            this.patch = str;
            return this;
        }

        public Version build() {
            if (this.major != null && this.minor != null) {
                return new Version(this.major, this.minor, this.patch, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(this.major, "major", this.minor, "minor");
        }
    }

    private static final class ProtoAdapter_Version extends ProtoAdapter<Version> {
        ProtoAdapter_Version() {
            super(FieldEncoding.LENGTH_DELIMITED, Version.class);
        }

        public int encodedSize(Version version) {
            return ((version.patch != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, version.patch) : 0) + (ProtoAdapter.UINT32.encodedSizeWithTag(5, version.minor) + ProtoAdapter.UINT32.encodedSizeWithTag(4, version.major))) + version.unknownFields().c();
        }

        public void encode(ProtoWriter protoWriter, Version version) {
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 4, version.major);
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 5, version.minor);
            if (version.patch != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, version.patch);
            }
            protoWriter.writeBytes(version.unknownFields());
        }

        public Version decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 4:
                            builder.major((Integer) ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 5:
                            builder.minor((Integer) ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 6:
                            builder.patch((String) ProtoAdapter.STRING.decode(protoReader));
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

        public Version redact(Version version) {
            Builder newBuilder = version.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public Version(Integer num, Integer num2, String str) {
        this(num, num2, str, d.b);
    }

    public Version(Integer num, Integer num2, String str, d dVar) {
        super(ADAPTER, dVar);
        this.major = num;
        this.minor = num2;
        this.patch = str;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.major = this.major;
        builder.minor = this.minor;
        builder.patch = this.patch;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        if (unknownFields().equals(version.unknownFields()) && this.major.equals(version.major) && this.minor.equals(version.minor) && Internal.equals(this.patch, version.patch)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        i = (this.patch != null ? this.patch.hashCode() : 0) + (((((unknownFields().hashCode() * 37) + this.major.hashCode()) * 37) + this.minor.hashCode()) * 37);
        this.hashCode = i;
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", major=").append(this.major);
        stringBuilder.append(", minor=").append(this.minor);
        if (this.patch != null) {
            stringBuilder.append(", patch=").append(this.patch);
        }
        return stringBuilder.replace(0, 2, "Version{").append('}').toString();
    }
}
