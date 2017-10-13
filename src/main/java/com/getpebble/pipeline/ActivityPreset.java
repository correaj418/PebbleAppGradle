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

public final class ActivityPreset extends Message<ActivityPreset, Builder> {
    public static final ProtoAdapter<ActivityPreset> ADAPTER = new ProtoAdapter_ActivityPreset();
    public static final Widget DEFAULT_MAIN_WIDGET = Widget.UnknownWidget;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.getpebble.pipeline.ActivityPreset$Widget#ADAPTER", label = Label.REPEATED, tag = 5)
    public final List<Widget> bottom_widgets;
    @WireField(adapter = "com.getpebble.pipeline.ActivityPreset$Widget#ADAPTER", tag = 4)
    public final Widget main_widget;
    @WireField(adapter = "com.getpebble.pipeline.ActivityType#ADAPTER", label = Label.REQUIRED, tag = 1)
    public final ActivityType type;

    public static final class Builder extends com.squareup.wire.Message.Builder<ActivityPreset, Builder> {
        public List<Widget> bottom_widgets = Internal.newMutableList();
        public Widget main_widget;
        public ActivityType type;

        public Builder type(ActivityType activityType) {
            this.type = activityType;
            return this;
        }

        public Builder main_widget(Widget widget) {
            this.main_widget = widget;
            return this;
        }

        public Builder bottom_widgets(List<Widget> list) {
            Internal.checkElementsNotNull((List) list);
            this.bottom_widgets = list;
            return this;
        }

        public ActivityPreset build() {
            if (this.type != null) {
                return new ActivityPreset(this.type, this.main_widget, this.bottom_widgets, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(this.type, "type");
        }
    }

    private static final class ProtoAdapter_ActivityPreset extends ProtoAdapter<ActivityPreset> {
        ProtoAdapter_ActivityPreset() {
            super(FieldEncoding.LENGTH_DELIMITED, ActivityPreset.class);
        }

        public int encodedSize(ActivityPreset activityPreset) {
            return (((activityPreset.main_widget != null ? Widget.ADAPTER.encodedSizeWithTag(4, activityPreset.main_widget) : 0) + ActivityType.ADAPTER.encodedSizeWithTag(1, activityPreset.type)) + Widget.ADAPTER.asRepeated().encodedSizeWithTag(5, activityPreset.bottom_widgets)) + activityPreset.unknownFields().c();
        }

        public void encode(ProtoWriter protoWriter, ActivityPreset activityPreset) {
            ActivityType.ADAPTER.encodeWithTag(protoWriter, 1, activityPreset.type);
            if (activityPreset.main_widget != null) {
                Widget.ADAPTER.encodeWithTag(protoWriter, 4, activityPreset.main_widget);
            }
            Widget.ADAPTER.asRepeated().encodeWithTag(protoWriter, 5, activityPreset.bottom_widgets);
            protoWriter.writeBytes(activityPreset.unknownFields());
        }

        public ActivityPreset decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.type((ActivityType) ActivityType.ADAPTER.decode(protoReader));
                            break;
                        case 4:
                            try {
                                builder.main_widget((Widget) Widget.ADAPTER.decode(protoReader));
                                break;
                            } catch (EnumConstantNotFoundException e) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e.value));
                                break;
                            }
                        case 5:
                            try {
                                builder.bottom_widgets.add(Widget.ADAPTER.decode(protoReader));
                                break;
                            } catch (EnumConstantNotFoundException e2) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e2.value));
                                break;
                            }
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

        public ActivityPreset redact(ActivityPreset activityPreset) {
            Builder newBuilder = activityPreset.newBuilder();
            newBuilder.type = (ActivityType) ActivityType.ADAPTER.redact(newBuilder.type);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public enum Widget implements WireEnum {
        UnknownWidget(0),
        PaceTimePerDistance(1),
        SpeedDistancePerTime(2),
        HeartRateBeatsPerMinute(3);
        
        public static final ProtoAdapter<Widget> ADAPTER = null;
        private final int value;

        static {
            ADAPTER = ProtoAdapter.newEnumAdapter(Widget.class);
        }

        private Widget(int i) {
            this.value = i;
        }

        public static Widget fromValue(int i) {
            switch (i) {
                case 0:
                    return UnknownWidget;
                case 1:
                    return PaceTimePerDistance;
                case 2:
                    return SpeedDistancePerTime;
                case 3:
                    return HeartRateBeatsPerMinute;
                default:
                    return null;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    public ActivityPreset(ActivityType activityType, Widget widget, List<Widget> list) {
        this(activityType, widget, list, d.b);
    }

    public ActivityPreset(ActivityType activityType, Widget widget, List<Widget> list, d dVar) {
        super(ADAPTER, dVar);
        this.type = activityType;
        this.main_widget = widget;
        this.bottom_widgets = Internal.immutableCopyOf("bottom_widgets", (List) list);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.type = this.type;
        builder.main_widget = this.main_widget;
        builder.bottom_widgets = Internal.copyOf("bottom_widgets", this.bottom_widgets);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActivityPreset)) {
            return false;
        }
        ActivityPreset activityPreset = (ActivityPreset) obj;
        if (unknownFields().equals(activityPreset.unknownFields()) && this.type.equals(activityPreset.type) && Internal.equals(this.main_widget, activityPreset.main_widget) && this.bottom_widgets.equals(activityPreset.bottom_widgets)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        i = (((this.main_widget != null ? this.main_widget.hashCode() : 0) + (((unknownFields().hashCode() * 37) + this.type.hashCode()) * 37)) * 37) + this.bottom_widgets.hashCode();
        this.hashCode = i;
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", type=").append(this.type);
        if (this.main_widget != null) {
            stringBuilder.append(", main_widget=").append(this.main_widget);
        }
        if (!this.bottom_widgets.isEmpty()) {
            stringBuilder.append(", bottom_widgets=").append(this.bottom_widgets);
        }
        return stringBuilder.replace(0, 2, "ActivityPreset{").append('}').toString();
    }
}
