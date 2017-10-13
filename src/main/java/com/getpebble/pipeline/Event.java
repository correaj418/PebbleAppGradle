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
import com.squareup.wire.WireField.Label;
import com.squareup.wire.internal.Internal;

public final class Event extends Message<Event, Builder> {
    public static final ProtoAdapter<Event> ADAPTER = new ProtoAdapter_Event();
    public static final Integer DEFAULT_CREATED_TIME_UTC = Integer.valueOf(0);
    public static final Integer DEFAULT_DURATION = Integer.valueOf(0);
    public static final Integer DEFAULT_TIME_UTC = Integer.valueOf(0);
    public static final Type DEFAULT_TYPE = Type.UnknownEvent;
    public static final Integer DEFAULT_UTC_TO_LOCAL = Integer.valueOf(0);
    public static final d DEFAULT_UUID = d.b;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.getpebble.pipeline.ActivitySession#ADAPTER", tag = 10)
    public final ActivitySession activity_session;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 7)
    public final Integer created_time_utc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 8)
    public final Integer duration;
    @WireField(adapter = "com.getpebble.pipeline.LocationInfo#ADAPTER", tag = 9)
    public final LocationInfo location;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", label = Label.REQUIRED, tag = 5)
    public final Integer time_utc;
    @WireField(adapter = "com.getpebble.pipeline.Event$Type#ADAPTER", label = Label.REQUIRED, tag = 4)
    public final Type type;
    @WireField(adapter = "com.getpebble.pipeline.User#ADAPTER", tag = 2)
    public final User user;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#SINT32", label = Label.REQUIRED, tag = 6)
    public final Integer utc_to_local;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", label = Label.REQUIRED, tag = 1)
    public final d uuid;

    public static final class Builder extends com.squareup.wire.Message.Builder<Event, Builder> {
        public ActivitySession activity_session;
        public Integer created_time_utc;
        public Integer duration;
        public LocationInfo location;
        public Integer time_utc;
        public Type type;
        public User user;
        public Integer utc_to_local;
        public d uuid;

        public Builder uuid(d dVar) {
            this.uuid = dVar;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Builder time_utc(Integer num) {
            this.time_utc = num;
            return this;
        }

        public Builder utc_to_local(Integer num) {
            this.utc_to_local = num;
            return this;
        }

        public Builder created_time_utc(Integer num) {
            this.created_time_utc = num;
            return this;
        }

        public Builder duration(Integer num) {
            this.duration = num;
            return this;
        }

        public Builder location(LocationInfo locationInfo) {
            this.location = locationInfo;
            return this;
        }

        public Builder activity_session(ActivitySession activitySession) {
            this.activity_session = activitySession;
            return this;
        }

        public Event build() {
            if (this.uuid != null && this.type != null && this.time_utc != null && this.utc_to_local != null) {
                return new Event(this.uuid, this.user, this.type, this.time_utc, this.utc_to_local, this.created_time_utc, this.duration, this.location, this.activity_session, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(this.uuid, "uuid", this.type, "type", this.time_utc, "time_utc", this.utc_to_local, "utc_to_local");
        }
    }

    private static final class ProtoAdapter_Event extends ProtoAdapter<Event> {
        ProtoAdapter_Event() {
            super(FieldEncoding.LENGTH_DELIMITED, Event.class);
        }

        public int encodedSize(Event event) {
            int encodedSizeWithTag;
            int i = 0;
            int encodedSizeWithTag2 = ProtoAdapter.BYTES.encodedSizeWithTag(1, event.uuid);
            if (event.user != null) {
                encodedSizeWithTag = User.ADAPTER.encodedSizeWithTag(2, event.user);
            } else {
                encodedSizeWithTag = 0;
            }
            encodedSizeWithTag2 = ProtoAdapter.SINT32.encodedSizeWithTag(6, event.utc_to_local) + (((encodedSizeWithTag + encodedSizeWithTag2) + Type.ADAPTER.encodedSizeWithTag(4, event.type)) + ProtoAdapter.UINT32.encodedSizeWithTag(5, event.time_utc));
            if (event.created_time_utc != null) {
                encodedSizeWithTag = ProtoAdapter.UINT32.encodedSizeWithTag(7, event.created_time_utc);
            } else {
                encodedSizeWithTag = 0;
            }
            encodedSizeWithTag2 += encodedSizeWithTag;
            if (event.duration != null) {
                encodedSizeWithTag = ProtoAdapter.UINT32.encodedSizeWithTag(8, event.duration);
            } else {
                encodedSizeWithTag = 0;
            }
            encodedSizeWithTag2 += encodedSizeWithTag;
            if (event.location != null) {
                encodedSizeWithTag = LocationInfo.ADAPTER.encodedSizeWithTag(9, event.location);
            } else {
                encodedSizeWithTag = 0;
            }
            encodedSizeWithTag += encodedSizeWithTag2;
            if (event.activity_session != null) {
                i = ActivitySession.ADAPTER.encodedSizeWithTag(10, event.activity_session);
            }
            return (encodedSizeWithTag + i) + event.unknownFields().c();
        }

        public void encode(ProtoWriter protoWriter, Event event) {
            ProtoAdapter.BYTES.encodeWithTag(protoWriter, 1, event.uuid);
            if (event.user != null) {
                User.ADAPTER.encodeWithTag(protoWriter, 2, event.user);
            }
            Type.ADAPTER.encodeWithTag(protoWriter, 4, event.type);
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 5, event.time_utc);
            ProtoAdapter.SINT32.encodeWithTag(protoWriter, 6, event.utc_to_local);
            if (event.created_time_utc != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 7, event.created_time_utc);
            }
            if (event.duration != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 8, event.duration);
            }
            if (event.location != null) {
                LocationInfo.ADAPTER.encodeWithTag(protoWriter, 9, event.location);
            }
            if (event.activity_session != null) {
                ActivitySession.ADAPTER.encodeWithTag(protoWriter, 10, event.activity_session);
            }
            protoWriter.writeBytes(event.unknownFields());
        }

        public Event decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.uuid((d) ProtoAdapter.BYTES.decode(protoReader));
                            break;
                        case 2:
                            builder.user((User) User.ADAPTER.decode(protoReader));
                            break;
                        case 4:
                            try {
                                builder.type((Type) Type.ADAPTER.decode(protoReader));
                                break;
                            } catch (EnumConstantNotFoundException e) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e.value));
                                break;
                            }
                        case 5:
                            builder.time_utc((Integer) ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 6:
                            builder.utc_to_local((Integer) ProtoAdapter.SINT32.decode(protoReader));
                            break;
                        case 7:
                            builder.created_time_utc((Integer) ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 8:
                            builder.duration((Integer) ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 9:
                            builder.location((LocationInfo) LocationInfo.ADAPTER.decode(protoReader));
                            break;
                        case 10:
                            builder.activity_session((ActivitySession) ActivitySession.ADAPTER.decode(protoReader));
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

        public Event redact(Event event) {
            Builder newBuilder = event.newBuilder();
            if (newBuilder.user != null) {
                newBuilder.user = (User) User.ADAPTER.redact(newBuilder.user);
            }
            if (newBuilder.location != null) {
                newBuilder.location = (LocationInfo) LocationInfo.ADAPTER.redact(newBuilder.location);
            }
            if (newBuilder.activity_session != null) {
                newBuilder.activity_session = (ActivitySession) ActivitySession.ADAPTER.redact(newBuilder.activity_session);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public enum Type implements WireEnum {
        UnknownEvent(0),
        ActivitySessionEvent(1);
        
        public static final ProtoAdapter<Type> ADAPTER = null;
        private final int value;

        static {
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        private Type(int i) {
            this.value = i;
        }

        public static Type fromValue(int i) {
            switch (i) {
                case 0:
                    return UnknownEvent;
                case 1:
                    return ActivitySessionEvent;
                default:
                    return null;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    public Event(d dVar, User user, Type type, Integer num, Integer num2, Integer num3, Integer num4, LocationInfo locationInfo, ActivitySession activitySession) {
        this(dVar, user, type, num, num2, num3, num4, locationInfo, activitySession, d.b);
    }

    public Event(d dVar, User user, Type type, Integer num, Integer num2, Integer num3, Integer num4, LocationInfo locationInfo, ActivitySession activitySession, d dVar2) {
        super(ADAPTER, dVar2);
        this.uuid = dVar;
        this.user = user;
        this.type = type;
        this.time_utc = num;
        this.utc_to_local = num2;
        this.created_time_utc = num3;
        this.duration = num4;
        this.location = locationInfo;
        this.activity_session = activitySession;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.uuid = this.uuid;
        builder.user = this.user;
        builder.type = this.type;
        builder.time_utc = this.time_utc;
        builder.utc_to_local = this.utc_to_local;
        builder.created_time_utc = this.created_time_utc;
        builder.duration = this.duration;
        builder.location = this.location;
        builder.activity_session = this.activity_session;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        if (unknownFields().equals(event.unknownFields()) && this.uuid.equals(event.uuid) && Internal.equals(this.user, event.user) && this.type.equals(event.type) && this.time_utc.equals(event.time_utc) && this.utc_to_local.equals(event.utc_to_local) && Internal.equals(this.created_time_utc, event.created_time_utc) && Internal.equals(this.duration, event.duration) && Internal.equals(this.location, event.location) && Internal.equals(this.activity_session, event.activity_session)) {
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
        int hashCode = ((((((((this.user != null ? this.user.hashCode() : 0) + (((unknownFields().hashCode() * 37) + this.uuid.hashCode()) * 37)) * 37) + this.type.hashCode()) * 37) + this.time_utc.hashCode()) * 37) + this.utc_to_local.hashCode()) * 37;
        if (this.created_time_utc != null) {
            i2 = this.created_time_utc.hashCode();
        } else {
            i2 = 0;
        }
        hashCode = (i2 + hashCode) * 37;
        if (this.duration != null) {
            i2 = this.duration.hashCode();
        } else {
            i2 = 0;
        }
        hashCode = (i2 + hashCode) * 37;
        if (this.location != null) {
            i2 = this.location.hashCode();
        } else {
            i2 = 0;
        }
        i2 = (i2 + hashCode) * 37;
        if (this.activity_session != null) {
            i = this.activity_session.hashCode();
        }
        i2 += i;
        this.hashCode = i2;
        return i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", uuid=").append(this.uuid);
        if (this.user != null) {
            stringBuilder.append(", user=").append(this.user);
        }
        stringBuilder.append(", type=").append(this.type);
        stringBuilder.append(", time_utc=").append(this.time_utc);
        stringBuilder.append(", utc_to_local=").append(this.utc_to_local);
        if (this.created_time_utc != null) {
            stringBuilder.append(", created_time_utc=").append(this.created_time_utc);
        }
        if (this.duration != null) {
            stringBuilder.append(", duration=").append(this.duration);
        }
        if (this.location != null) {
            stringBuilder.append(", location=").append(this.location);
        }
        if (this.activity_session != null) {
            stringBuilder.append(", activity_session=").append(this.activity_session);
        }
        return stringBuilder.replace(0, 2, "Event{").append('}').toString();
    }
}
