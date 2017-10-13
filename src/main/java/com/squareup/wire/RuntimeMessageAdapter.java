package com.squareup.wire;

import com.getpebble.android.framework.timeline.e;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.ProtoAdapter.EnumConstantNotFoundException;
import com.squareup.wire.WireField.Label;
import com.squareup.wire.internal.Internal;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class RuntimeMessageAdapter<M extends Message<M, B>, B extends Builder<M, B>> extends ProtoAdapter<M> {
    private static final String REDACTED = "██";
    private final Class<B> builderType;
    private final Map<Integer, FieldBinding<M, B>> fieldBindings;
    private final Class<M> messageType;

    static <M extends Message<M, B>, B extends Builder<M, B>> RuntimeMessageAdapter<M, B> create(Class<M> cls) {
        Class builderType = getBuilderType(cls);
        Map linkedHashMap = new LinkedHashMap();
        for (Field field : cls.getDeclaredFields()) {
            WireField wireField = (WireField) field.getAnnotation(WireField.class);
            if (wireField != null) {
                linkedHashMap.put(Integer.valueOf(wireField.tag()), new FieldBinding(wireField, field, builderType));
            }
        }
        return new RuntimeMessageAdapter(cls, builderType, Collections.unmodifiableMap(linkedHashMap));
    }

    RuntimeMessageAdapter(Class<M> cls, Class<B> cls2, Map<Integer, FieldBinding<M, B>> map) {
        super(FieldEncoding.LENGTH_DELIMITED, cls);
        this.messageType = cls;
        this.builderType = cls2;
        this.fieldBindings = map;
    }

    Map<Integer, FieldBinding<M, B>> fieldBindings() {
        return this.fieldBindings;
    }

    B newBuilder() {
        Object e;
        try {
            return (Builder) this.builderType.newInstance();
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new AssertionError(e);
        } catch (InstantiationException e3) {
            e = e3;
            throw new AssertionError(e);
        }
    }

    private static <M extends Message<M, B>, B extends Builder<M, B>> Class<B> getBuilderType(Class<M> cls) {
        try {
            return Class.forName(cls.getName() + "$Builder");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
        }
    }

    public int encodedSize(M m) {
        int i = m.cachedSerializedSize;
        if (i != 0) {
            return i;
        }
        int i2 = 0;
        for (FieldBinding fieldBinding : this.fieldBindings.values()) {
            Object obj = fieldBinding.get(m);
            if (obj != null) {
                i2 = fieldBinding.adapter().encodedSizeWithTag(fieldBinding.tag, obj) + i2;
            }
        }
        i = m.unknownFields().c() + i2;
        m.cachedSerializedSize = i;
        return i;
    }

    public void encode(ProtoWriter protoWriter, M m) {
        for (FieldBinding fieldBinding : this.fieldBindings.values()) {
            Object obj = fieldBinding.get(m);
            if (obj != null) {
                fieldBinding.adapter().encodeWithTag(protoWriter, fieldBinding.tag, obj);
            }
        }
        protoWriter.writeBytes(m.unknownFields());
    }

    public M redact(M m) {
        Builder newBuilder = m.newBuilder();
        for (FieldBinding fieldBinding : this.fieldBindings.values()) {
            if (fieldBinding.redacted && fieldBinding.label == Label.REQUIRED) {
                throw new UnsupportedOperationException(String.format("Field '%s' in %s is required and cannot be redacted.", new Object[]{fieldBinding.name, this.javaType.getName()}));
            }
            boolean isAssignableFrom = Message.class.isAssignableFrom(fieldBinding.singleAdapter().javaType);
            if (fieldBinding.redacted || (isAssignableFrom && !fieldBinding.label.isRepeated())) {
                Object fromBuilder = fieldBinding.getFromBuilder(newBuilder);
                if (fromBuilder != null) {
                    fieldBinding.set(newBuilder, fieldBinding.adapter().redact(fromBuilder));
                }
            } else if (isAssignableFrom && fieldBinding.label.isRepeated()) {
                Internal.redactElements((List) fieldBinding.getFromBuilder(newBuilder), fieldBinding.singleAdapter());
            }
        }
        newBuilder.clearUnknownFields();
        return newBuilder.build();
    }

    public boolean equals(Object obj) {
        return (obj instanceof RuntimeMessageAdapter) && ((RuntimeMessageAdapter) obj).messageType == this.messageType;
    }

    public int hashCode() {
        return this.messageType.hashCode();
    }

    public String toString(M m) {
        StringBuilder stringBuilder = new StringBuilder();
        for (FieldBinding fieldBinding : this.fieldBindings.values()) {
            Object obj = fieldBinding.get(m);
            if (obj != null) {
                Object obj2;
                StringBuilder append = stringBuilder.append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR).append(fieldBinding.name).append('=');
                if (fieldBinding.redacted) {
                    obj2 = REDACTED;
                } else {
                    obj2 = obj;
                }
                append.append(obj2);
            }
        }
        stringBuilder.replace(0, 2, this.messageType.getSimpleName() + '{');
        return stringBuilder.append('}').toString();
    }

    public M decode(ProtoReader protoReader) {
        Builder newBuilder = newBuilder();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                FieldBinding fieldBinding = (FieldBinding) this.fieldBindings.get(Integer.valueOf(nextTag));
                if (fieldBinding != null) {
                    try {
                        ProtoAdapter adapter;
                        if (fieldBinding.isMap()) {
                            adapter = fieldBinding.adapter();
                        } else {
                            adapter = fieldBinding.singleAdapter();
                        }
                        fieldBinding.value(newBuilder, adapter.decode(protoReader));
                    } catch (EnumConstantNotFoundException e) {
                        newBuilder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e.value));
                    }
                } else {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    newBuilder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newBuilder.build();
            }
        }
    }
}
