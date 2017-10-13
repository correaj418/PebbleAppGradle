package com.getpebble.android.framework.l.b;

import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.g.aj;
import com.getpebble.android.framework.g.ak.c;
import com.getpebble.android.framework.l.a.y.a;
import com.getpebble.android.g.a.b;
import com.google.a.f.d;
import java.nio.ByteBuffer;
import java.util.UUID;

public class w extends ag {
    private final b i;
    private final b j;

    public w(short s, c cVar, b bVar, aj ajVar, UUID uuid, b bVar2) {
        super(s, a.NLP_RESULT, ajVar, cVar, uuid);
        this.i = bVar;
        this.j = bVar2;
    }

    protected void a(ByteBuffer byteBuffer) {
        int i = 0;
        if (this.i != null) {
            byteBuffer.mark();
            byteBuffer.put(i);
            try {
                i = this.j.a(this.i, byteBuffer, byteBuffer.order());
            } catch (Throwable e) {
                f.a("PebbleOutboundVoiceResultMessage", "Failed to serialize attributes for NLP result message in session " + this.a, e);
            }
            if (this.f == aj.THIRD_PARTY) {
                ag.a(byteBuffer, this.g);
                i = (byte) (i + 1);
            }
            int position = byteBuffer.position();
            byteBuffer.reset();
            byteBuffer.put(d.a((long) i));
            byteBuffer.position(position);
        } else if (this.f == aj.THIRD_PARTY) {
            a(Byte.valueOf((byte) 1));
            ag.a(byteBuffer, this.g);
        } else {
            a(Byte.valueOf(i));
        }
    }
}
