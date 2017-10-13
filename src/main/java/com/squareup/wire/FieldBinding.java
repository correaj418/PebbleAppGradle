package com.squareup.wire;

import com.squareup.wire.Message.Builder;
import com.squareup.wire.WireField.Label;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

final class FieldBinding<M extends Message<M, B>, B extends Builder<M, B>> {
    private ProtoAdapter<Object> adapter;
    private final String adapterString;
    private final Field builderField;
    private final Method builderMethod;
    private ProtoAdapter<?> keyAdapter;
    private final String keyAdapterString;
    public final Label label;
    private final Field messageField;
    public final String name;
    public final boolean redacted;
    private ProtoAdapter<?> singleAdapter;
    public final int tag;

    private static Field getBuilderField(Class<?> cls, String str) {
        try {
            return cls.getField(str);
        } catch (NoSuchFieldException e) {
            throw new AssertionError("No builder field " + cls.getName() + "." + str);
        }
    }

    private static Method getBuilderMethod(Class<?> cls, String str, Class<?> cls2) {
        try {
            return cls.getMethod(str, new Class[]{cls2});
        } catch (NoSuchMethodException e) {
            throw new AssertionError("No builder method " + cls.getName() + "." + str + "(" + cls2.getName() + ")");
        }
    }

    FieldBinding(WireField wireField, Field field, Class<B> cls) {
        this.label = wireField.label();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.keyAdapterString = wireField.keyAdapter();
        this.adapterString = wireField.adapter();
        this.redacted = wireField.redacted();
        this.messageField = field;
        this.builderField = getBuilderField(cls, this.name);
        this.builderMethod = getBuilderMethod(cls, this.name, field.getType());
    }

    boolean isMap() {
        return !this.keyAdapterString.isEmpty();
    }

    ProtoAdapter<?> singleAdapter() {
        ProtoAdapter<?> protoAdapter = this.singleAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        protoAdapter = ProtoAdapter.get(this.adapterString);
        this.singleAdapter = protoAdapter;
        return protoAdapter;
    }

    ProtoAdapter<?> keyAdapter() {
        ProtoAdapter<?> protoAdapter = this.keyAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        protoAdapter = ProtoAdapter.get(this.keyAdapterString);
        this.keyAdapter = protoAdapter;
        return protoAdapter;
    }

    ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        if (isMap()) {
            protoAdapter = ProtoAdapter.newMapAdapter(keyAdapter(), singleAdapter());
            this.adapter = protoAdapter;
            return protoAdapter;
        }
        protoAdapter = singleAdapter().withLabel(this.label);
        this.adapter = protoAdapter;
        return protoAdapter;
    }

    void value(B b, Object obj) {
        if (this.label.isRepeated()) {
            ((List) getFromBuilder(b)).add(obj);
        } else if (this.keyAdapterString.isEmpty()) {
            set(b, obj);
        } else {
            ((Map) getFromBuilder(b)).putAll((Map) obj);
        }
    }

    void set(B b, Object obj) {
        Object e;
        try {
            if (this.label.isOneOf()) {
                this.builderMethod.invoke(b, new Object[]{obj});
                return;
            }
            this.builderField.set(b, obj);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new AssertionError(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new AssertionError(e);
        }
    }

    Object get(M m) {
        try {
            return this.messageField.get(m);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    Object getFromBuilder(B b) {
        try {
            return this.builderField.get(b);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
