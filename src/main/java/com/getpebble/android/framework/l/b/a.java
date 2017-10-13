package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.framework.timeline.h;
import com.google.a.f.d;
import com.google.a.f.e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class a {
    private final ap a;
    private final h b;
    private final com.getpebble.android.common.framework.install.app.b.a c;

    public a(ap apVar, h hVar, com.getpebble.android.common.framework.install.app.b.a aVar) {
        this.a = apVar;
        this.b = hVar;
        this.c = aVar;
    }

    public byte[] a(com.getpebble.android.common.model.d.a aVar) {
        ByteBuffer allocate = ByteBuffer.allocate(r.a(com.getpebble.android.bluetooth.g.a.BLOBDB_V1));
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(d.a(1));
        allocate.put(b.c(e.a(aVar.b / 1000)));
        for (com.getpebble.android.common.model.d.b bVar : aVar.c) {
            int position = allocate.position();
            allocate.position(position + 2);
            allocate.put(d.a((long) bVar.b.serializedValue));
            com.getpebble.android.framework.timeline.e[] eVarArr = bVar.a;
            int position2 = allocate.position();
            allocate.position(position2 + 1);
            int serializeAttributes = this.a.serializeAttributes(allocate, eVarArr, this.b, this.c);
            int position3 = allocate.position();
            int i = position3 - position;
            allocate.position(position);
            allocate.put(b.b(e.a((long) i), ByteOrder.LITTLE_ENDIAN));
            allocate.position(position2);
            allocate.put(d.a((long) serializeAttributes));
            allocate.position(position3);
        }
        int position4 = allocate.position();
        byte[] bArr = new byte[position4];
        allocate.position(0);
        allocate.get(bArr, 0, position4);
        return bArr;
    }
}
