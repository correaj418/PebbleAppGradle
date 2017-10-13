package com.squareup.wire;

import com.squareup.wire.Message.Builder;
import java.io.IOException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

final class MessageSerializedForm<M extends Message<M, B>, B extends Builder<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;
    private final byte[] bytes;
    private final Class<M> messageClass;

    public MessageSerializedForm(byte[] bArr, Class<M> cls) {
        this.bytes = bArr;
        this.messageClass = cls;
    }

    Object readResolve() {
        try {
            return ProtoAdapter.get(this.messageClass).decode(this.bytes);
        } catch (IOException e) {
            throw new StreamCorruptedException(e.getMessage());
        }
    }
}
