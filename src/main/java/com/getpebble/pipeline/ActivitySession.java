package com.getpebble.pipeline;

import b.d;
import com.getpebble.pipeline.MeasurementSet.Type;
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
import java.util.List;

public final class ActivitySession extends Message<ActivitySession, Builder> {
    public static final ProtoAdapter<ActivitySession> ADAPTER = new ProtoAdapter_ActivitySession();
    public static final StartReason DEFAULT_START_REASON = StartReason.UnknownReason;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.getpebble.pipeline.ActivityInterval#ADAPTER", label = Label.REPEATED, tag = 6)
    public final List<ActivityInterval> intervals;
    @WireField(adapter = "com.getpebble.pipeline.ActivitySession$StartReason#ADAPTER", label = Label.REQUIRED, tag = 5)
    public final StartReason start_reason;
    @WireField(adapter = "com.getpebble.pipeline.ActivitySession$Summary#ADAPTER", tag = 7)
    public final Summary summary;
    @WireField(adapter = "com.getpebble.pipeline.ActivityType#ADAPTER", label = Label.REQUIRED, tag = 1)
    public final ActivityType type;

    public static final class Builder extends com.squareup.wire.Message.Builder<ActivitySession, Builder> {
        public List<ActivityInterval> intervals = Internal.newMutableList();
        public StartReason start_reason;
        public Summary summary;
        public ActivityType type;

        public Builder type(ActivityType activityType) {
            this.type = activityType;
            return this;
        }

        public Builder start_reason(StartReason startReason) {
            this.start_reason = startReason;
            return this;
        }

        public Builder intervals(List<ActivityInterval> list) {
            Internal.checkElementsNotNull((List) list);
            this.intervals = list;
            return this;
        }

        public Builder summary(Summary summary) {
            this.summary = summary;
            return this;
        }

        public ActivitySession build() {
            if (this.type != null && this.start_reason != null) {
                return new ActivitySession(this.type, this.start_reason, this.intervals, this.summary, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(this.type, "type", this.start_reason, "start_reason");
        }
    }

    private static final class ProtoAdapter_ActivitySession extends ProtoAdapter<ActivitySession> {
        ProtoAdapter_ActivitySession() {
            super(FieldEncoding.LENGTH_DELIMITED, ActivitySession.class);
        }

        public int encodedSize(ActivitySession activitySession) {
            return ((activitySession.summary != null ? Summary.ADAPTER.encodedSizeWithTag(7, activitySession.summary) : 0) + (ActivityInterval.ADAPTER.asRepeated().encodedSizeWithTag(6, activitySession.intervals) + (ActivityType.ADAPTER.encodedSizeWithTag(1, activitySession.type) + StartReason.ADAPTER.encodedSizeWithTag(5, activitySession.start_reason)))) + activitySession.unknownFields().c();
        }

        public void encode(ProtoWriter protoWriter, ActivitySession activitySession) {
            ActivityType.ADAPTER.encodeWithTag(protoWriter, 1, activitySession.type);
            StartReason.ADAPTER.encodeWithTag(protoWriter, 5, activitySession.start_reason);
            ActivityInterval.ADAPTER.asRepeated().encodeWithTag(protoWriter, 6, activitySession.intervals);
            if (activitySession.summary != null) {
                Summary.ADAPTER.encodeWithTag(protoWriter, 7, activitySession.summary);
            }
            protoWriter.writeBytes(activitySession.unknownFields());
        }

        public ActivitySession decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.type((ActivityType) ActivityType.ADAPTER.decode(protoReader));
                            break;
                        case 5:
                            try {
                                builder.start_reason((StartReason) StartReason.ADAPTER.decode(protoReader));
                                break;
                            } catch (EnumConstantNotFoundException e) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e.value));
                                break;
                            }
                        case 6:
                            builder.intervals.add(ActivityInterval.ADAPTER.decode(protoReader));
                            break;
                        case 7:
                            builder.summary((Summary) Summary.ADAPTER.decode(protoReader));
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

        public ActivitySession redact(ActivitySession activitySession) {
            Builder newBuilder = activitySession.newBuilder();
            newBuilder.type = (ActivityType) ActivityType.ADAPTER.redact(newBuilder.type);
            Internal.redactElements(newBuilder.intervals, ActivityInterval.ADAPTER);
            if (newBuilder.summary != null) {
                newBuilder.summary = (Summary) Summary.ADAPTER.redact(newBuilder.summary);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public enum StartReason implements WireEnum {
        UnknownReason(0),
        Automatic(1),
        Manual(2),
        AutomaticConvertedToManual(3);
        
        public static final ProtoAdapter<StartReason> ADAPTER = null;
        private final int value;

        static {
            ADAPTER = ProtoAdapter.newEnumAdapter(StartReason.class);
        }

        private StartReason(int i) {
            this.value = i;
        }

        public static StartReason fromValue(int i) {
            switch (i) {
                case 0:
                    return UnknownReason;
                case 1:
                    return Automatic;
                case 2:
                    return Manual;
                case 3:
                    return AutomaticConvertedToManual;
                default:
                    return null;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final class Summary extends Message<Summary, Builder> {
        public static final ProtoAdapter<Summary> ADAPTER = new ProtoAdapter_Summary();
        private static final long serialVersionUID = 0;
        @WireField(adapter = "com.getpebble.pipeline.Measurement#ADAPTER", label = Label.REQUIRED, tag = 2)
        public final Measurement measurement;
        @WireField(adapter = "com.getpebble.pipeline.MeasurementSet$Type#ADAPTER", label = Label.REPEATED, tag = 1)
        public final List<Type> types;

        public static final class Builder extends com.squareup.wire.Message.Builder<Summary, Builder> {
            public Measurement measurement;
            public List<Type> types = Internal.newMutableList();

            public Builder types(List<Type> list) {
                Internal.checkElementsNotNull((List) list);
                this.types = list;
                return this;
            }

            public Builder measurement(Measurement measurement) {
                this.measurement = measurement;
                return this;
            }

            public Summary build() {
                if (this.measurement != null) {
                    return new Summary(this.types, this.measurement, super.buildUnknownFields());
                }
                throw Internal.missingRequiredFields(this.measurement, "measurement");
            }
        }

        private static final class ProtoAdapter_Summary extends ProtoAdapter<Summary> {
            ProtoAdapter_Summary() {
                super(FieldEncoding.LENGTH_DELIMITED, Summary.class);
            }

            public int encodedSize(Summary summary) {
                return (Type.ADAPTER.asRepeated().encodedSizeWithTag(1, summary.types) + Measurement.ADAPTER.encodedSizeWithTag(2, summary.measurement)) + summary.unknownFields().c();
            }

            public void encode(ProtoWriter protoWriter, Summary summary) {
                Type.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, summary.types);
                Measurement.ADAPTER.encodeWithTag(protoWriter, 2, summary.measurement);
                protoWriter.writeBytes(summary.unknownFields());
            }

            public Summary decode(ProtoReader protoReader) {
                Builder builder = new Builder();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag != -1) {
                        switch (nextTag) {
                            case 1:
                                try {
                                    builder.types.add(Type.ADAPTER.decode(protoReader));
                                    break;
                                } catch (EnumConstantNotFoundException e) {
                                    builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e.value));
                                    break;
                                }
                            case 2:
                                builder.measurement((Measurement) Measurement.ADAPTER.decode(protoReader));
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

            public Summary redact(Summary summary) {
                Builder newBuilder = summary.newBuilder();
                newBuilder.measurement = (Measurement) Measurement.ADAPTER.redact(newBuilder.measurement);
                newBuilder.clearUnknownFields();
                return newBuilder.build();
            }
        }

        public Summary(List<Type> list, Measurement measurement) {
            this(list, measurement, d.b);
        }

        public Summary(List<Type> list, Measurement measurement, d dVar) {
            super(ADAPTER, dVar);
            this.types = Internal.immutableCopyOf("types", (List) list);
            this.measurement = measurement;
        }

        public Builder newBuilder() {
            Builder builder = new Builder();
            builder.types = Internal.copyOf("types", this.types);
            builder.measurement = this.measurement;
            builder.addUnknownFields(unknownFields());
            return builder;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Summary)) {
                return false;
            }
            Summary summary = (Summary) obj;
            if (unknownFields().equals(summary.unknownFields()) && this.types.equals(summary.types) && this.measurement.equals(summary.measurement)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            i = (((unknownFields().hashCode() * 37) + this.types.hashCode()) * 37) + this.measurement.hashCode();
            this.hashCode = i;
            return i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (!this.types.isEmpty()) {
                stringBuilder.append(", types=").append(this.types);
            }
            stringBuilder.append(", measurement=").append(this.measurement);
            return stringBuilder.replace(0, 2, "Summary{").append('}').toString();
        }
    }

    public ActivitySession(ActivityType activityType, StartReason startReason, List<ActivityInterval> list, Summary summary) {
        this(activityType, startReason, list, summary, d.b);
    }

    public ActivitySession(ActivityType activityType, StartReason startReason, List<ActivityInterval> list, Summary summary, d dVar) {
        super(ADAPTER, dVar);
        this.type = activityType;
        this.start_reason = startReason;
        this.intervals = Internal.immutableCopyOf("intervals", (List) list);
        this.summary = summary;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.type = this.type;
        builder.start_reason = this.start_reason;
        builder.intervals = Internal.copyOf("intervals", this.intervals);
        builder.summary = this.summary;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActivitySession)) {
            return false;
        }
        ActivitySession activitySession = (ActivitySession) obj;
        if (unknownFields().equals(activitySession.unknownFields()) && this.type.equals(activitySession.type) && this.start_reason.equals(activitySession.start_reason) && this.intervals.equals(activitySession.intervals) && Internal.equals(this.summary, activitySession.summary)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        i = (this.summary != null ? this.summary.hashCode() : 0) + (((((((unknownFields().hashCode() * 37) + this.type.hashCode()) * 37) + this.start_reason.hashCode()) * 37) + this.intervals.hashCode()) * 37);
        this.hashCode = i;
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", type=").append(this.type);
        stringBuilder.append(", start_reason=").append(this.start_reason);
        if (!this.intervals.isEmpty()) {
            stringBuilder.append(", intervals=").append(this.intervals);
        }
        if (this.summary != null) {
            stringBuilder.append(", summary=").append(this.summary);
        }
        return stringBuilder.replace(0, 2, "ActivitySession{").append('}').toString();
    }
}
