package com.getpebble.android.framework.l.a;

import com.getpebble.android.bluetooth.g.b;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class g extends h {
    List<byte[]> a;

    public g(b bVar) {
        super(bVar);
        try {
            byte b = this.b.get();
            this.a = new LinkedList();
            while (this.b.remaining() > 0) {
                this.a.add(a(this.b));
            }
            if (b != this.a.size()) {
                throw new IllegalArgumentException(String.format("Expected %d frames, got %d", new Object[]{Integer.valueOf(b), Integer.valueOf(this.a.size())}));
            }
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static byte[] a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.get()];
        byteBuffer.get(bArr, 0, bArr.length);
        return bArr;
    }

    public List<byte[]> c() {
        return this.a;
    }
}
