package com.getpebble.android.bluetooth.i;

import com.google.a.f.e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class b {
    final byte[] a;

    b(byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 8);
        allocate.put(com.getpebble.android.bluetooth.b.b.b(a.a, ByteOrder.BIG_ENDIAN));
        allocate.put(com.getpebble.android.bluetooth.b.b.b(a.c, ByteOrder.BIG_ENDIAN));
        allocate.put(com.getpebble.android.bluetooth.b.b.b(e.a((long) bArr.length), ByteOrder.BIG_ENDIAN));
        allocate.put(bArr);
        allocate.put(com.getpebble.android.bluetooth.b.b.b(a.b, ByteOrder.BIG_ENDIAN));
        this.a = allocate.array();
    }
}
