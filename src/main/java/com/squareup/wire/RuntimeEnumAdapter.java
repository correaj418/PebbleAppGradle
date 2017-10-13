package com.squareup.wire;

import com.squareup.wire.ProtoAdapter.EnumConstantNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class RuntimeEnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    private Method fromValueMethod;
    private final Class<E> type;

    RuntimeEnumAdapter(Class<E> cls) {
        super(FieldEncoding.VARINT, cls);
        this.type = cls;
    }

    private Method getFromValueMethod() {
        Method method = this.fromValueMethod;
        if (method == null) {
            try {
                method = this.type.getMethod("fromValue", new Class[]{Integer.TYPE});
                this.fromValueMethod = method;
            } catch (NoSuchMethodException e) {
                throw new AssertionError(e);
            }
        }
        return method;
    }

    public int encodedSize(E e) {
        return ProtoWriter.varint32Size(e.getValue());
    }

    public void encode(ProtoWriter protoWriter, E e) {
        protoWriter.writeVarint32(e.getValue());
    }

    public E decode(ProtoReader protoReader) {
        Object e;
        int readVarint32 = protoReader.readVarint32();
        try {
            WireEnum wireEnum = (WireEnum) getFromValueMethod().invoke(null, new Object[]{Integer.valueOf(readVarint32)});
            if (wireEnum != null) {
                return wireEnum;
            }
            throw new EnumConstantNotFoundException(readVarint32, this.type);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new AssertionError(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof RuntimeEnumAdapter) && ((RuntimeEnumAdapter) obj).type == this.type;
    }

    public int hashCode() {
        return this.type.hashCode();
    }
}
