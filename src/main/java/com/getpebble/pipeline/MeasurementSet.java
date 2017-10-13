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
import java.util.List;

public final class MeasurementSet extends Message<MeasurementSet, Builder> {
    public static final ProtoAdapter<MeasurementSet> ADAPTER = new ProtoAdapter_MeasurementSet();
    public static final d DEFAULT_SENSOR_SETTINGS = d.b;
    public static final Integer DEFAULT_TIME_END_UTC = Integer.valueOf(0);
    public static final Integer DEFAULT_TIME_UTC = Integer.valueOf(0);
    public static final Integer DEFAULT_UTC_TO_LOCAL = Integer.valueOf(0);
    public static final d DEFAULT_UUID = d.b;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.getpebble.pipeline.Measurement#ADAPTER", label = Label.REPEATED, tag = 8)
    public final List<Measurement> measurements;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 5)
    public final d sensor_settings;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 9)
    public final Integer time_end_utc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", label = Label.REQUIRED, tag = 3)
    public final Integer time_utc;
    @WireField(adapter = "com.getpebble.pipeline.MeasurementSet$Type#ADAPTER", label = Label.REPEATED, tag = 7)
    public final List<Type> types;
    @WireField(adapter = "com.getpebble.pipeline.User#ADAPTER", tag = 2)
    public final User user;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#SINT32", label = Label.REQUIRED, tag = 4)
    public final Integer utc_to_local;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", label = Label.REQUIRED, tag = 1)
    public final d uuid;

    public static final class Builder extends com.squareup.wire.Message.Builder<MeasurementSet, Builder> {
        public List<Measurement> measurements = Internal.newMutableList();
        public d sensor_settings;
        public Integer time_end_utc;
        public Integer time_utc;
        public List<Type> types = Internal.newMutableList();
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

        public Builder time_utc(Integer num) {
            this.time_utc = num;
            return this;
        }

        public Builder utc_to_local(Integer num) {
            this.utc_to_local = num;
            return this;
        }

        public Builder sensor_settings(d dVar) {
            this.sensor_settings = dVar;
            return this;
        }

        public Builder types(List<Type> list) {
            Internal.checkElementsNotNull((List) list);
            this.types = list;
            return this;
        }

        public Builder measurements(List<Measurement> list) {
            Internal.checkElementsNotNull((List) list);
            this.measurements = list;
            return this;
        }

        public Builder time_end_utc(Integer num) {
            this.time_end_utc = num;
            return this;
        }

        public MeasurementSet build() {
            if (this.uuid != null && this.time_utc != null && this.utc_to_local != null) {
                return new MeasurementSet(this.uuid, this.user, this.time_utc, this.utc_to_local, this.sensor_settings, this.types, this.measurements, this.time_end_utc, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(this.uuid, "uuid", this.time_utc, "time_utc", this.utc_to_local, "utc_to_local");
        }
    }

    public enum HeartRateQuality implements WireEnum {
        NoAccel(0),
        OffWrist(1),
        NoSignal(2),
        Worst(3),
        Poor(4),
        Acceptable(5),
        Good(6),
        Excellent(7);
        
        public static final ProtoAdapter<HeartRateQuality> ADAPTER = null;
        private final int value;

        static {
            ADAPTER = ProtoAdapter.newEnumAdapter(HeartRateQuality.class);
        }

        private HeartRateQuality(int i) {
            this.value = i;
        }

        public static HeartRateQuality fromValue(int i) {
            switch (i) {
                case 0:
                    return NoAccel;
                case 1:
                    return OffWrist;
                case 2:
                    return NoSignal;
                case 3:
                    return Worst;
                case 4:
                    return Poor;
                case 5:
                    return Acceptable;
                case 6:
                    return Good;
                case 7:
                    return Excellent;
                default:
                    return null;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    private static final class ProtoAdapter_MeasurementSet extends ProtoAdapter<MeasurementSet> {
        ProtoAdapter_MeasurementSet() {
            super(FieldEncoding.LENGTH_DELIMITED, MeasurementSet.class);
        }

        public int encodedSize(MeasurementSet measurementSet) {
            int encodedSizeWithTag;
            int i = 0;
            int encodedSizeWithTag2 = ProtoAdapter.BYTES.encodedSizeWithTag(1, measurementSet.uuid);
            if (measurementSet.user != null) {
                encodedSizeWithTag = User.ADAPTER.encodedSizeWithTag(2, measurementSet.user);
            } else {
                encodedSizeWithTag = 0;
            }
            encodedSizeWithTag2 = ProtoAdapter.SINT32.encodedSizeWithTag(4, measurementSet.utc_to_local) + ((encodedSizeWithTag + encodedSizeWithTag2) + ProtoAdapter.UINT32.encodedSizeWithTag(3, measurementSet.time_utc));
            if (measurementSet.sensor_settings != null) {
                encodedSizeWithTag = ProtoAdapter.BYTES.encodedSizeWithTag(5, measurementSet.sensor_settings);
            } else {
                encodedSizeWithTag = 0;
            }
            encodedSizeWithTag = ((encodedSizeWithTag + encodedSizeWithTag2) + Type.ADAPTER.asRepeated().encodedSizeWithTag(7, measurementSet.types)) + Measurement.ADAPTER.asRepeated().encodedSizeWithTag(8, measurementSet.measurements);
            if (measurementSet.time_end_utc != null) {
                i = ProtoAdapter.UINT32.encodedSizeWithTag(9, measurementSet.time_end_utc);
            }
            return (encodedSizeWithTag + i) + measurementSet.unknownFields().c();
        }

        public void encode(ProtoWriter protoWriter, MeasurementSet measurementSet) {
            ProtoAdapter.BYTES.encodeWithTag(protoWriter, 1, measurementSet.uuid);
            if (measurementSet.user != null) {
                User.ADAPTER.encodeWithTag(protoWriter, 2, measurementSet.user);
            }
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 3, measurementSet.time_utc);
            ProtoAdapter.SINT32.encodeWithTag(protoWriter, 4, measurementSet.utc_to_local);
            if (measurementSet.sensor_settings != null) {
                ProtoAdapter.BYTES.encodeWithTag(protoWriter, 5, measurementSet.sensor_settings);
            }
            Type.ADAPTER.asRepeated().encodeWithTag(protoWriter, 7, measurementSet.types);
            Measurement.ADAPTER.asRepeated().encodeWithTag(protoWriter, 8, measurementSet.measurements);
            if (measurementSet.time_end_utc != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 9, measurementSet.time_end_utc);
            }
            protoWriter.writeBytes(measurementSet.unknownFields());
        }

        public MeasurementSet decode(ProtoReader protoReader) {
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
                        case 3:
                            builder.time_utc((Integer) ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 4:
                            builder.utc_to_local((Integer) ProtoAdapter.SINT32.decode(protoReader));
                            break;
                        case 5:
                            builder.sensor_settings((d) ProtoAdapter.BYTES.decode(protoReader));
                            break;
                        case 7:
                            try {
                                builder.types.add(Type.ADAPTER.decode(protoReader));
                                break;
                            } catch (EnumConstantNotFoundException e) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e.value));
                                break;
                            }
                        case 8:
                            builder.measurements.add(Measurement.ADAPTER.decode(protoReader));
                            break;
                        case 9:
                            builder.time_end_utc((Integer) ProtoAdapter.UINT32.decode(protoReader));
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

        public MeasurementSet redact(MeasurementSet measurementSet) {
            Builder newBuilder = measurementSet.newBuilder();
            if (newBuilder.user != null) {
                newBuilder.user = (User) User.ADAPTER.redact(newBuilder.user);
            }
            Internal.redactElements(newBuilder.measurements, Measurement.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public enum Type implements WireEnum {
        UnknownEvent(0),
        TimeMS(1),
        VMC(2),
        Steps(3),
        DistanceCM(4),
        RestingGCalories(5),
        ActiveGCalories(6),
        BPM(7),
        RR(8),
        Orientation(9),
        Light(10),
        Temperature(11),
        HRQuality(12),
        RestingHR(13);
        
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
                    return TimeMS;
                case 2:
                    return VMC;
                case 3:
                    return Steps;
                case 4:
                    return DistanceCM;
                case 5:
                    return RestingGCalories;
                case 6:
                    return ActiveGCalories;
                case 7:
                    return BPM;
                case 8:
                    return RR;
                case 9:
                    return Orientation;
                case 10:
                    return Light;
                case 11:
                    return Temperature;
                case 12:
                    return HRQuality;
                case 13:
                    return RestingHR;
                default:
                    return null;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    public MeasurementSet(d dVar, User user, Integer num, Integer num2, d dVar2, List<Type> list, List<Measurement> list2, Integer num3) {
        this(dVar, user, num, num2, dVar2, list, list2, num3, d.b);
    }

    public MeasurementSet(d dVar, User user, Integer num, Integer num2, d dVar2, List<Type> list, List<Measurement> list2, Integer num3, d dVar3) {
        super(ADAPTER, dVar3);
        this.uuid = dVar;
        this.user = user;
        this.time_utc = num;
        this.utc_to_local = num2;
        this.sensor_settings = dVar2;
        this.types = Internal.immutableCopyOf("types", (List) list);
        this.measurements = Internal.immutableCopyOf("measurements", (List) list2);
        this.time_end_utc = num3;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.uuid = this.uuid;
        builder.user = this.user;
        builder.time_utc = this.time_utc;
        builder.utc_to_local = this.utc_to_local;
        builder.sensor_settings = this.sensor_settings;
        builder.types = Internal.copyOf("types", this.types);
        builder.measurements = Internal.copyOf("measurements", this.measurements);
        builder.time_end_utc = this.time_end_utc;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MeasurementSet)) {
            return false;
        }
        MeasurementSet measurementSet = (MeasurementSet) obj;
        if (unknownFields().equals(measurementSet.unknownFields()) && this.uuid.equals(measurementSet.uuid) && Internal.equals(this.user, measurementSet.user) && this.time_utc.equals(measurementSet.time_utc) && this.utc_to_local.equals(measurementSet.utc_to_local) && Internal.equals(this.sensor_settings, measurementSet.sensor_settings) && this.types.equals(measurementSet.types) && this.measurements.equals(measurementSet.measurements) && Internal.equals(this.time_end_utc, measurementSet.time_end_utc)) {
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
        int hashCode = ((((((this.user != null ? this.user.hashCode() : 0) + (((unknownFields().hashCode() * 37) + this.uuid.hashCode()) * 37)) * 37) + this.time_utc.hashCode()) * 37) + this.utc_to_local.hashCode()) * 37;
        if (this.sensor_settings != null) {
            i2 = this.sensor_settings.hashCode();
        } else {
            i2 = 0;
        }
        i2 = (((((i2 + hashCode) * 37) + this.types.hashCode()) * 37) + this.measurements.hashCode()) * 37;
        if (this.time_end_utc != null) {
            i = this.time_end_utc.hashCode();
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
        stringBuilder.append(", time_utc=").append(this.time_utc);
        stringBuilder.append(", utc_to_local=").append(this.utc_to_local);
        if (this.sensor_settings != null) {
            stringBuilder.append(", sensor_settings=").append(this.sensor_settings);
        }
        if (!this.types.isEmpty()) {
            stringBuilder.append(", types=").append(this.types);
        }
        if (!this.measurements.isEmpty()) {
            stringBuilder.append(", measurements=").append(this.measurements);
        }
        if (this.time_end_utc != null) {
            stringBuilder.append(", time_end_utc=").append(this.time_end_utc);
        }
        return stringBuilder.replace(0, 2, "MeasurementSet{").append('}').toString();
    }
}
