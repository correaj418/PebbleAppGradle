package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.g.a;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.aq;
import com.getpebble.android.common.model.s.b;
import com.getpebble.android.framework.o.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;

public class am {
    private final byte[] a;

    public static <T> List<T> a(int i, List<T> list) {
        if (list.size() > i) {
            list.subList(i, list.size()).clear();
        }
        return list;
    }

    public static am a(b bVar) {
        ByteBuffer allocate = ByteBuffer.allocate(r.a(a.BLOBDB_V1));
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        List a = aq.a(com.getpebble.android.common.a.K().getContentResolver(), bVar);
        f.c("SerializedContact", "from(), phoneNumber Size: " + a.size());
        if (a.size() > 10) {
            a = a(10, a);
        }
        allocate.put(com.getpebble.android.bluetooth.b.b.a(bVar.c));
        allocate.put(com.getpebble.android.bluetooth.b.b.c(bVar.f));
        allocate.put((byte) 1);
        allocate.put((byte) r0.size());
        allocate.put((byte) 1);
        allocate.put(com.getpebble.android.bluetooth.b.b.a(bVar.e, 32, ByteOrder.LITTLE_ENDIAN));
        for (aq.a aVar : r0) {
            f.c("SerializedContact", "from(), byteBuffer pos: " + allocate.position());
            allocate.put(com.getpebble.android.bluetooth.b.b.a(aVar.b));
            allocate.put((byte) 1);
            allocate.put((byte) 1);
            allocate.put((byte) 39);
            allocate.put(com.getpebble.android.bluetooth.b.b.a(c.b(aVar.d), 32, ByteOrder.LITTLE_ENDIAN));
        }
        return new am(Arrays.copyOf(allocate.array(), allocate.position()));
    }

    private am(byte[] bArr) {
        this.a = bArr;
    }

    public byte[] a() {
        return this.a;
    }
}
