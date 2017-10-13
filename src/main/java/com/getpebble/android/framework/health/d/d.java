package com.getpebble.android.framework.health.d;

import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.framework.health.d.c.a;
import com.getpebble.android.framework.health.d.c.c;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class d {
    public static c a(byte[] bArr) {
        Throwable e;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        try {
            a a = a(wrap);
            if (!a(a.a)) {
                return new c(a, b(a, wrap));
            }
            throw new UnsupportedOperationException("Health record version: " + a.a + " is unsupported");
        } catch (UnsupportedOperationException e2) {
            e = e2;
            throw new IllegalArgumentException(e);
        } catch (BufferUnderflowException e3) {
            e = e3;
            throw new IllegalArgumentException(e);
        }
    }

    private static a a(ByteBuffer byteBuffer) {
        return new a(b.b(byteBuffer).intValue(), b.c(byteBuffer).longValue(), byteBuffer.get(), b.a(byteBuffer).intValue(), b.a(byteBuffer).intValue());
    }

    static c.b a(a aVar, ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int intValue = b.a(byteBuffer).intValue();
        int intValue2 = b.a(byteBuffer).intValue();
        int intValue3 = b.b(byteBuffer).intValue();
        int intValue4 = b.a(byteBuffer).intValue();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        Integer num = null;
        Byte b = null;
        if (aVar.a >= c.VERSION_FW_3_10_AND_UNDER.number) {
            i = b.a(byteBuffer).intValue();
        }
        if (aVar.a >= c.VERSION_FW_3_11.number) {
            i3 = b.b(byteBuffer).intValue();
            i2 = b.b(byteBuffer).intValue();
            i4 = b.b(byteBuffer).intValue();
        }
        if (aVar.a >= c.VERSION_FW_4_0.number) {
            i5 = b.a(byteBuffer).intValue();
        }
        if (aVar.a >= c.VERSION_FW_4_1.number) {
            num = Integer.valueOf(b.b(byteBuffer).intValue());
        }
        if (aVar.a >= c.VERSION_FW_4_3.number) {
            b = Byte.valueOf(b.a(byteBuffer).byteValue());
        }
        int position2 = byteBuffer.position();
        int i6 = aVar.d - (position2 - position);
        if ((i6 > 0 ? 1 : null) != null) {
            byteBuffer.position(position2 + i6);
        }
        return new c.b(intValue, intValue2, intValue3, intValue4, i, i3, i2, i4, i5, num, b);
    }

    private static c.b[] b(a aVar, ByteBuffer byteBuffer) {
        if (a(aVar.a)) {
            throw new UnsupportedOperationException("Health record version is unsupported");
        }
        c.b[] bVarArr = new c.b[aVar.e];
        for (int i = 0; i < aVar.e; i++) {
            bVarArr[i] = a(aVar, byteBuffer);
        }
        return bVarArr;
    }

    private static boolean a(int i) {
        return false;
    }
}
