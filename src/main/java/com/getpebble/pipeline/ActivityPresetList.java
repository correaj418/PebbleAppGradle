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

public final class ActivityPresetList extends Message<ActivityPresetList, Builder> {
    public static final ProtoAdapter<ActivityPresetList> ADAPTER = new ProtoAdapter_ActivityPresetList();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.getpebble.pipeline.ActivityPreset#ADAPTER", label = Label.REPEATED, tag = 1)
    public final List<ActivityPreset> presets;

    public static final class Builder extends com.squareup.wire.Message.Builder<ActivityPresetList, Builder> {
        public List<ActivityPreset> presets = Internal.newMutableList();

        public Builder presets(List<ActivityPreset> list) {
            Internal.checkElementsNotNull((List) list);
            this.presets = list;
            return this;
        }

        public ActivityPresetList build() {
            return new ActivityPresetList(this.presets, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_ActivityPresetList extends ProtoAdapter<ActivityPresetList> {
        ProtoAdapter_ActivityPresetList() {
            super(FieldEncoding.LENGTH_DELIMITED, ActivityPresetList.class);
        }

        public int encodedSize(ActivityPresetList activityPresetList) {
            return ActivityPreset.ADAPTER.asRepeated().encodedSizeWithTag(1, activityPresetList.presets) + activityPresetList.unknownFields().c();
        }

        public void encode(ProtoWriter protoWriter, ActivityPresetList activityPresetList) {
            ActivityPreset.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, activityPresetList.presets);
            protoWriter.writeBytes(activityPresetList.unknownFields());
        }

        public ActivityPresetList decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.presets.add(ActivityPreset.ADAPTER.decode(protoReader));
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

        public ActivityPresetList redact(ActivityPresetList activityPresetList) {
            Builder newBuilder = activityPresetList.newBuilder();
            Internal.redactElements(newBuilder.presets, ActivityPreset.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public ActivityPresetList(List<ActivityPreset> list) {
        this(list, d.b);
    }

    public ActivityPresetList(List<ActivityPreset> list, d dVar) {
        super(ADAPTER, dVar);
        this.presets = Internal.immutableCopyOf("presets", (List) list);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.presets = Internal.copyOf("presets", this.presets);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActivityPresetList)) {
            return false;
        }
        ActivityPresetList activityPresetList = (ActivityPresetList) obj;
        if (unknownFields().equals(activityPresetList.unknownFields()) && this.presets.equals(activityPresetList.presets)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        i = (unknownFields().hashCode() * 37) + this.presets.hashCode();
        this.hashCode = i;
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!this.presets.isEmpty()) {
            stringBuilder.append(", presets=").append(this.presets);
        }
        return stringBuilder.replace(0, 2, "ActivityPresetList{").append('}').toString();
    }
}
