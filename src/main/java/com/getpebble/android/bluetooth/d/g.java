package com.getpebble.android.bluetooth.d;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class g {
    public static final byte[] a = new byte[]{(byte) 84, (byte) 1};
    public final byte[] b;
    public final byte c;
    public final String d;
    public final a e;
    public final byte[] f;

    public static class a {
        public final int a;
        public final byte b;
        public final int c;
        public final int d;
        public final int e;
        public final boolean f;
        public final boolean g;
        private final boolean[] h;

        private a(ByteBuffer byteBuffer) {
            this.a = com.getpebble.android.bluetooth.b.b.a(byteBuffer).intValue();
            this.b = byteBuffer.get();
            this.c = com.getpebble.android.bluetooth.b.b.a(byteBuffer).intValue();
            this.d = com.getpebble.android.bluetooth.b.b.a(byteBuffer).intValue();
            this.e = com.getpebble.android.bluetooth.b.b.a(byteBuffer).intValue();
            this.h = com.getpebble.android.bluetooth.b.b.f(new byte[]{byteBuffer.get()});
            this.f = this.h[0];
            this.g = this.h[1];
        }

        public String toString() {
            return "<ExtendedInfo hardwarePlatform = " + this.a + " color = " + this.b + " major = " + this.c + " minor = " + this.d + " patch = " + this.e + " flagRunningPrf = " + this.f + " flagFirstUse = " + this.g + ">";
        }
    }

    public static class b extends Exception {
    }

    public g(byte[] bArr) {
        if (bArr == null) {
            throw new b();
        }
        this.f = bArr;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.b = new byte[2];
        wrap.get(this.b);
        if (!Arrays.equals(a, this.b)) {
            throw new b();
        } else if (a()) {
            this.d = "";
            this.e = null;
            this.c = (byte) 0;
        } else {
            this.c = wrap.get();
            byte[] bArr2 = new byte[12];
            wrap.get(bArr2);
            this.d = new String(bArr2, "ASCII");
            if (wrap.hasRemaining()) {
                this.e = new a(wrap);
            } else {
                this.e = null;
            }
        }
    }

    public boolean a() {
        return Arrays.equals(a, this.b) && Arrays.equals(com.getpebble.android.bluetooth.f.a.a, Arrays.copyOfRange(this.f, 2, 4));
    }

    public String toString() {
        return "<PebbleScanData vendorId = " + com.getpebble.android.bluetooth.b.b.c(this.b) + " payloadType = " + this.c + " serialNumber = " + this.d + " extendedInfo = " + this.e + ">";
    }
}
