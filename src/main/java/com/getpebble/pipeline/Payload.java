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

public final class Payload extends Message<Payload, Builder> {
    public static final ProtoAdapter<Payload> ADAPTER = new ProtoAdapter_Payload();
    public static final Integer DEFAULT_SEND_RETRY_COUNT = Integer.valueOf(0);
    public static final Integer DEFAULT_SEND_TIME_UTC = Integer.valueOf(0);
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.getpebble.pipeline.Event#ADAPTER", label = Label.REPEATED, tag = 11)
    public final List<Event> events;
    @WireField(adapter = "com.getpebble.pipeline.MeasurementSet#ADAPTER", label = Label.REPEATED, tag = 12)
    public final List<MeasurementSet> measurement_sets;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", label = Label.REPEATED, tag = 10)
    public final List<d> payloads;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer send_retry_count;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", label = Label.REQUIRED, tag = 3)
    public final Integer send_time_utc;
    @WireField(adapter = "com.getpebble.pipeline.Tier#ADAPTER", label = Label.REQUIRED, tag = 2)
    public final Tier sender;
    @WireField(adapter = "com.getpebble.pipeline.User#ADAPTER", tag = 6)
    public final User user;

    public static final class Builder extends com.squareup.wire.Message.Builder<Payload, Builder> {
        public List<Event> events = Internal.newMutableList();
        public List<MeasurementSet> measurement_sets = Internal.newMutableList();
        public List<d> payloads = Internal.newMutableList();
        public Integer send_retry_count;
        public Integer send_time_utc;
        public Tier sender;
        public User user;

        public Builder sender(Tier tier) {
            this.sender = tier;
            return this;
        }

        public Builder send_time_utc(Integer num) {
            this.send_time_utc = num;
            return this;
        }

        public Builder send_retry_count(Integer num) {
            this.send_retry_count = num;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder payloads(List<d> list) {
            Internal.checkElementsNotNull((List) list);
            this.payloads = list;
            return this;
        }

        public Builder events(List<Event> list) {
            Internal.checkElementsNotNull((List) list);
            this.events = list;
            return this;
        }

        public Builder measurement_sets(List<MeasurementSet> list) {
            Internal.checkElementsNotNull((List) list);
            this.measurement_sets = list;
            return this;
        }

        public Payload build() {
            if (this.sender != null && this.send_time_utc != null) {
                return new Payload(this.sender, this.send_time_utc, this.send_retry_count, this.user, this.payloads, this.events, this.measurement_sets, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(this.sender, "sender", this.send_time_utc, "send_time_utc");
        }
    }

    private static final class ProtoAdapter_Payload extends ProtoAdapter<Payload> {
        ProtoAdapter_Payload() {
            super(FieldEncoding.LENGTH_DELIMITED, Payload.class);
        }

        public int encodedSize(Payload payload) {
            int encodedSizeWithTag;
            int i = 0;
            int encodedSizeWithTag2 = ProtoAdapter.UINT32.encodedSizeWithTag(3, payload.send_time_utc) + Tier.ADAPTER.encodedSizeWithTag(2, payload.sender);
            if (payload.send_retry_count != null) {
                encodedSizeWithTag = ProtoAdapter.UINT32.encodedSizeWithTag(4, payload.send_retry_count);
            } else {
                encodedSizeWithTag = 0;
            }
            encodedSizeWithTag += encodedSizeWithTag2;
            if (payload.user != null) {
                i = User.ADAPTER.encodedSizeWithTag(6, payload.user);
            }
            return ((((encodedSizeWithTag + i) + ProtoAdapter.BYTES.asRepeated().encodedSizeWithTag(10, payload.payloads)) + Event.ADAPTER.asRepeated().encodedSizeWithTag(11, payload.events)) + MeasurementSet.ADAPTER.asRepeated().encodedSizeWithTag(12, payload.measurement_sets)) + payload.unknownFields().c();
        }

        public void encode(ProtoWriter protoWriter, Payload payload) {
            Tier.ADAPTER.encodeWithTag(protoWriter, 2, payload.sender);
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 3, payload.send_time_utc);
            if (payload.send_retry_count != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 4, payload.send_retry_count);
            }
            if (payload.user != null) {
                User.ADAPTER.encodeWithTag(protoWriter, 6, payload.user);
            }
            ProtoAdapter.BYTES.asRepeated().encodeWithTag(protoWriter, 10, payload.payloads);
            Event.ADAPTER.asRepeated().encodeWithTag(protoWriter, 11, payload.events);
            MeasurementSet.ADAPTER.asRepeated().encodeWithTag(protoWriter, 12, payload.measurement_sets);
            protoWriter.writeBytes(payload.unknownFields());
        }

        public Payload decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 2:
                            builder.sender((Tier) Tier.ADAPTER.decode(protoReader));
                            break;
                        case 3:
                            builder.send_time_utc((Integer) ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 4:
                            builder.send_retry_count((Integer) ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 6:
                            builder.user((User) User.ADAPTER.decode(protoReader));
                            break;
                        case 10:
                            builder.payloads.add(ProtoAdapter.BYTES.decode(protoReader));
                            break;
                        case 11:
                            builder.events.add(Event.ADAPTER.decode(protoReader));
                            break;
                        case 12:
                            builder.measurement_sets.add(MeasurementSet.ADAPTER.decode(protoReader));
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

        public Payload redact(Payload payload) {
            Builder newBuilder = payload.newBuilder();
            newBuilder.sender = (Tier) Tier.ADAPTER.redact(newBuilder.sender);
            if (newBuilder.user != null) {
                newBuilder.user = (User) User.ADAPTER.redact(newBuilder.user);
            }
            Internal.redactElements(newBuilder.events, Event.ADAPTER);
            Internal.redactElements(newBuilder.measurement_sets, MeasurementSet.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public Payload(Tier tier, Integer num, Integer num2, User user, List<d> list, List<Event> list2, List<MeasurementSet> list3) {
        this(tier, num, num2, user, list, list2, list3, d.b);
    }

    public Payload(Tier tier, Integer num, Integer num2, User user, List<d> list, List<Event> list2, List<MeasurementSet> list3, d dVar) {
        super(ADAPTER, dVar);
        this.sender = tier;
        this.send_time_utc = num;
        this.send_retry_count = num2;
        this.user = user;
        this.payloads = Internal.immutableCopyOf("payloads", (List) list);
        this.events = Internal.immutableCopyOf("events", (List) list2);
        this.measurement_sets = Internal.immutableCopyOf("measurement_sets", (List) list3);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.sender = this.sender;
        builder.send_time_utc = this.send_time_utc;
        builder.send_retry_count = this.send_retry_count;
        builder.user = this.user;
        builder.payloads = Internal.copyOf("payloads", this.payloads);
        builder.events = Internal.copyOf("events", this.events);
        builder.measurement_sets = Internal.copyOf("measurement_sets", this.measurement_sets);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Payload)) {
            return false;
        }
        Payload payload = (Payload) obj;
        if (unknownFields().equals(payload.unknownFields()) && this.sender.equals(payload.sender) && this.send_time_utc.equals(payload.send_time_utc) && Internal.equals(this.send_retry_count, payload.send_retry_count) && Internal.equals(this.user, payload.user) && this.payloads.equals(payload.payloads) && this.events.equals(payload.events) && this.measurement_sets.equals(payload.measurement_sets)) {
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
        i2 = ((this.send_retry_count != null ? this.send_retry_count.hashCode() : 0) + (((((unknownFields().hashCode() * 37) + this.sender.hashCode()) * 37) + this.send_time_utc.hashCode()) * 37)) * 37;
        if (this.user != null) {
            i = this.user.hashCode();
        }
        i2 = ((((((i2 + i) * 37) + this.payloads.hashCode()) * 37) + this.events.hashCode()) * 37) + this.measurement_sets.hashCode();
        this.hashCode = i2;
        return i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", sender=").append(this.sender);
        stringBuilder.append(", send_time_utc=").append(this.send_time_utc);
        if (this.send_retry_count != null) {
            stringBuilder.append(", send_retry_count=").append(this.send_retry_count);
        }
        if (this.user != null) {
            stringBuilder.append(", user=").append(this.user);
        }
        if (!this.payloads.isEmpty()) {
            stringBuilder.append(", payloads=").append(this.payloads);
        }
        if (!this.events.isEmpty()) {
            stringBuilder.append(", events=").append(this.events);
        }
        if (!this.measurement_sets.isEmpty()) {
            stringBuilder.append(", measurement_sets=").append(this.measurement_sets);
        }
        return stringBuilder.replace(0, 2, "Payload{").append('}').toString();
    }
}
