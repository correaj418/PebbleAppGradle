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

public final class User extends Message<User, Builder> {
    public static final ProtoAdapter<User> ADAPTER = new ProtoAdapter_User();
    public static final String DEFAULT_ID = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = Label.REQUIRED, tag = 1)
    public final String id;

    public static final class Builder extends com.squareup.wire.Message.Builder<User, Builder> {
        public String id;

        public Builder id(String str) {
            this.id = str;
            return this;
        }

        public User build() {
            if (this.id != null) {
                return new User(this.id, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(this.id, "id");
        }
    }

    private static final class ProtoAdapter_User extends ProtoAdapter<User> {
        ProtoAdapter_User() {
            super(FieldEncoding.LENGTH_DELIMITED, User.class);
        }

        public int encodedSize(User user) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, user.id) + user.unknownFields().c();
        }

        public void encode(ProtoWriter protoWriter, User user) {
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, user.id);
            protoWriter.writeBytes(user.unknownFields());
        }

        public User decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.id((String) ProtoAdapter.STRING.decode(protoReader));
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

        public User redact(User user) {
            Builder newBuilder = user.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public User(String str) {
        this(str, d.b);
    }

    public User(String str, d dVar) {
        super(ADAPTER, dVar);
        this.id = str;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.id = this.id;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        if (unknownFields().equals(user.unknownFields()) && this.id.equals(user.id)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        i = (unknownFields().hashCode() * 37) + this.id.hashCode();
        this.hashCode = i;
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", id=").append(this.id);
        return stringBuilder.replace(0, 2, "User{").append('}').toString();
    }
}
