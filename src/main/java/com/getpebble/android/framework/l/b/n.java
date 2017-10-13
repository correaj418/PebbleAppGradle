package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.g.aj;
import com.getpebble.android.framework.g.ak.c;
import com.getpebble.android.framework.l.a.y;
import com.getpebble.android.framework.l.a.z;
import com.getpebble.android.framework.p.k.a;
import com.google.a.f.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public class n extends ag {
    private final a[][] i;

    public n(short s, c cVar, a[][] aVarArr, aj ajVar, UUID uuid) {
        super(s, y.a.DICTATION_RESULT, ajVar, cVar, uuid);
        this.i = aVarArr;
    }

    protected void a(ByteBuffer byteBuffer) {
        if (this.i == null) {
            f.d("PebbleOutboundDictationResultMessage", "Null Word Arrays");
            if (this.f == aj.THIRD_PARTY) {
                a(Byte.valueOf((byte) 1));
                ag.a(byteBuffer, this.g);
                e();
                return;
            }
            a(Byte.valueOf((byte) 0));
            return;
        }
        byte b = this.f == aj.FIRST_PARTY ? (byte) 1 : (byte) 2;
        a(Byte.valueOf(b));
        byteBuffer.put(z.TRANSCRIPTION.toByte());
        byteBuffer.mark();
        byteBuffer.putShort((short) 0);
        int position = byteBuffer.position();
        a(this.i, byteBuffer);
        int position2 = byteBuffer.position();
        byteBuffer.reset();
        byteBuffer.put(b.a(position2 - position));
        byteBuffer.position(position2);
        if (this.f == aj.THIRD_PARTY) {
            ag.a(byteBuffer, this.g);
        }
        e();
    }

    static void a(a[][] aVarArr, ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        if (aVarArr != null) {
            byteBuffer.put((byte) 1);
            byteBuffer.put(d.a((long) aVarArr.length));
            for (a[] aVarArr2 : aVarArr) {
                byteBuffer.put(b.a(aVarArr2.length));
                for (a a : aVarArr2) {
                    a(a, byteBuffer);
                }
            }
        }
    }

    static void a(a aVar, ByteBuffer byteBuffer) {
        byteBuffer.put(d.a((long) Double.valueOf(Double.valueOf(aVar.a).doubleValue() * 100.0d).intValue()));
        b.a(byteBuffer, aVar.b, 32767);
    }
}
