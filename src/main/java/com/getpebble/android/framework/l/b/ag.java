package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.g.aj;
import com.getpebble.android.framework.g.ak.c;
import com.getpebble.android.framework.l.a.y.a;
import com.getpebble.android.framework.l.a.z;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public abstract class ag extends r {
    protected final short a;
    protected final c e;
    protected final aj f;
    protected final UUID g;
    protected final a h;

    protected abstract void a(ByteBuffer byteBuffer);

    public ag(short s, a aVar, aj ajVar, c cVar, UUID uuid) {
        super(com.getpebble.android.bluetooth.g.a.VOICE_CONTROL);
        this.a = s;
        this.f = ajVar;
        this.e = cVar;
        this.g = uuid;
        this.h = aVar;
    }

    protected void b() {
        a(Byte.valueOf(this.h.toByte()));
        byte[] bArr = new byte[4];
        if (this.f == aj.THIRD_PARTY) {
            bArr[0] = (byte) (bArr[0] | 1);
        } else {
            f.d("PebbleOutboundVoiceControlResultMessage", "Not a third party request - not setting app initiated flag.");
        }
        a(bArr);
        a(b.a(this.a));
        a(Byte.valueOf(this.e.toByte()));
    }

    protected static void a(ByteBuffer byteBuffer, UUID uuid) {
        byteBuffer.put(z.APP_UUID.toByte());
        byteBuffer.putShort((short) 16);
        byteBuffer.put(b.a(uuid));
    }

    public final synchronized byte[] c_() {
        if (!d()) {
            b();
            ByteBuffer c = c();
            c.order(ByteOrder.LITTLE_ENDIAN);
            a(c);
        }
        return super.c_();
    }
}
