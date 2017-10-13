package net.hockeyapp.android.e;

import java.io.UnsupportedEncodingException;

public class b {

    static abstract class a {
        public byte[] a;
        public int b;

        a() {
        }
    }

    static class b extends a {
        private static final byte[] g = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
        private static final byte[] h = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
        int c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        private final byte[] i;
        private int j;
        private final byte[] k;

        public b(int i, byte[] bArr) {
            boolean z;
            boolean z2 = true;
            this.a = bArr;
            this.d = (i & 1) == 0;
            if ((i & 2) == 0) {
                z = true;
            } else {
                z = false;
            }
            this.e = z;
            if ((i & 4) == 0) {
                z2 = false;
            }
            this.f = z2;
            this.k = (i & 8) == 0 ? g : h;
            this.i = new byte[2];
            this.c = 0;
            this.j = this.e ? 19 : -1;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(byte[] r12, int r13, int r14, boolean r15) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r11 = this;
            r6 = r11.k;
            r7 = r11.a;
            r1 = 0;
            r0 = r11.j;
            r8 = r14 + r13;
            r2 = -1;
            r3 = r11.c;
            switch(r3) {
                case 0: goto L_0x00a7;
                case 1: goto L_0x00aa;
                case 2: goto L_0x00cd;
                default: goto L_0x000f;
            };
        L_0x000f:
            r3 = r13;
        L_0x0010:
            r4 = -1;
            if (r2 == r4) goto L_0x0238;
        L_0x0013:
            r4 = 1;
            r5 = r2 >> 18;
            r5 = r5 & 63;
            r5 = r6[r5];
            r7[r1] = r5;
            r1 = 2;
            r5 = r2 >> 12;
            r5 = r5 & 63;
            r5 = r6[r5];
            r7[r4] = r5;
            r4 = 3;
            r5 = r2 >> 6;
            r5 = r5 & 63;
            r5 = r6[r5];
            r7[r1] = r5;
            r1 = 4;
            r2 = r2 & 63;
            r2 = r6[r2];
            r7[r4] = r2;
            r0 = r0 + -1;
            if (r0 != 0) goto L_0x0238;
        L_0x0039:
            r0 = r11.f;
            if (r0 == 0) goto L_0x023c;
        L_0x003d:
            r0 = 5;
            r2 = 13;
            r7[r1] = r2;
        L_0x0042:
            r1 = r0 + 1;
            r2 = 10;
            r7[r0] = r2;
            r0 = 19;
            r5 = r0;
            r4 = r1;
        L_0x004c:
            r0 = r3 + 3;
            if (r0 > r8) goto L_0x00f0;
        L_0x0050:
            r0 = r12[r3];
            r0 = r0 & 255;
            r0 = r0 << 16;
            r1 = r3 + 1;
            r1 = r12[r1];
            r1 = r1 & 255;
            r1 = r1 << 8;
            r0 = r0 | r1;
            r1 = r3 + 2;
            r1 = r12[r1];
            r1 = r1 & 255;
            r0 = r0 | r1;
            r1 = r0 >> 18;
            r1 = r1 & 63;
            r1 = r6[r1];
            r7[r4] = r1;
            r1 = r4 + 1;
            r2 = r0 >> 12;
            r2 = r2 & 63;
            r2 = r6[r2];
            r7[r1] = r2;
            r1 = r4 + 2;
            r2 = r0 >> 6;
            r2 = r2 & 63;
            r2 = r6[r2];
            r7[r1] = r2;
            r1 = r4 + 3;
            r0 = r0 & 63;
            r0 = r6[r0];
            r7[r1] = r0;
            r3 = r3 + 3;
            r1 = r4 + 4;
            r0 = r5 + -1;
            if (r0 != 0) goto L_0x0238;
        L_0x0092:
            r0 = r11.f;
            if (r0 == 0) goto L_0x0235;
        L_0x0096:
            r0 = r1 + 1;
            r2 = 13;
            r7[r1] = r2;
        L_0x009c:
            r1 = r0 + 1;
            r2 = 10;
            r7[r0] = r2;
            r0 = 19;
            r5 = r0;
            r4 = r1;
            goto L_0x004c;
        L_0x00a7:
            r3 = r13;
            goto L_0x0010;
        L_0x00aa:
            r3 = r13 + 2;
            if (r3 > r8) goto L_0x000f;
        L_0x00ae:
            r2 = r11.i;
            r3 = 0;
            r2 = r2[r3];
            r2 = r2 & 255;
            r2 = r2 << 16;
            r3 = r13 + 1;
            r4 = r12[r13];
            r4 = r4 & 255;
            r4 = r4 << 8;
            r2 = r2 | r4;
            r13 = r3 + 1;
            r3 = r12[r3];
            r3 = r3 & 255;
            r2 = r2 | r3;
            r3 = 0;
            r11.c = r3;
            r3 = r13;
            goto L_0x0010;
        L_0x00cd:
            r3 = r13 + 1;
            if (r3 > r8) goto L_0x000f;
        L_0x00d1:
            r2 = r11.i;
            r3 = 0;
            r2 = r2[r3];
            r2 = r2 & 255;
            r2 = r2 << 16;
            r3 = r11.i;
            r4 = 1;
            r3 = r3[r4];
            r3 = r3 & 255;
            r3 = r3 << 8;
            r2 = r2 | r3;
            r3 = r13 + 1;
            r4 = r12[r13];
            r4 = r4 & 255;
            r2 = r2 | r4;
            r4 = 0;
            r11.c = r4;
            goto L_0x0010;
        L_0x00f0:
            if (r15 == 0) goto L_0x01ff;
        L_0x00f2:
            r0 = r11.c;
            r0 = r3 - r0;
            r1 = r8 + -1;
            if (r0 != r1) goto L_0x016a;
        L_0x00fa:
            r2 = 0;
            r0 = r11.c;
            if (r0 <= 0) goto L_0x0162;
        L_0x00ff:
            r0 = r11.i;
            r1 = 1;
            r0 = r0[r2];
            r2 = r3;
        L_0x0105:
            r0 = r0 & 255;
            r3 = r0 << 4;
            r0 = r11.c;
            r0 = r0 - r1;
            r11.c = r0;
            r1 = r4 + 1;
            r0 = r3 >> 6;
            r0 = r0 & 63;
            r0 = r6[r0];
            r7[r4] = r0;
            r0 = r1 + 1;
            r3 = r3 & 63;
            r3 = r6[r3];
            r7[r1] = r3;
            r1 = r11.d;
            if (r1 == 0) goto L_0x0130;
        L_0x0124:
            r1 = r0 + 1;
            r3 = 61;
            r7[r0] = r3;
            r0 = r1 + 1;
            r3 = 61;
            r7[r1] = r3;
        L_0x0130:
            r1 = r11.e;
            if (r1 == 0) goto L_0x0146;
        L_0x0134:
            r1 = r11.f;
            if (r1 == 0) goto L_0x013f;
        L_0x0138:
            r1 = r0 + 1;
            r3 = 13;
            r7[r0] = r3;
            r0 = r1;
        L_0x013f:
            r1 = r0 + 1;
            r3 = 10;
            r7[r0] = r3;
            r0 = r1;
        L_0x0146:
            r3 = r2;
            r4 = r0;
        L_0x0148:
            r0 = r11.c;
            if (r0 == 0) goto L_0x0153;
        L_0x014c:
            r0 = "BASE64";
            r1 = "Error during encoding";
            android.util.Log.e(r0, r1);
        L_0x0153:
            if (r3 == r8) goto L_0x015c;
        L_0x0155:
            r0 = "BASE64";
            r1 = "Error during encoding";
            android.util.Log.e(r0, r1);
        L_0x015c:
            r11.b = r4;
            r11.j = r5;
            r0 = 1;
            return r0;
        L_0x0162:
            r1 = r3 + 1;
            r0 = r12[r3];
            r10 = r2;
            r2 = r1;
            r1 = r10;
            goto L_0x0105;
        L_0x016a:
            r0 = r11.c;
            r0 = r3 - r0;
            r1 = r8 + -2;
            if (r0 != r1) goto L_0x01e3;
        L_0x0172:
            r2 = 0;
            r0 = r11.c;
            r1 = 1;
            if (r0 <= r1) goto L_0x01d6;
        L_0x0178:
            r0 = r11.i;
            r1 = 1;
            r0 = r0[r2];
        L_0x017d:
            r0 = r0 & 255;
            r9 = r0 << 10;
            r0 = r11.c;
            if (r0 <= 0) goto L_0x01dd;
        L_0x0185:
            r0 = r11.i;
            r2 = r1 + 1;
            r0 = r0[r1];
            r1 = r2;
        L_0x018c:
            r0 = r0 & 255;
            r0 = r0 << 2;
            r0 = r0 | r9;
            r2 = r11.c;
            r1 = r2 - r1;
            r11.c = r1;
            r1 = r4 + 1;
            r2 = r0 >> 12;
            r2 = r2 & 63;
            r2 = r6[r2];
            r7[r4] = r2;
            r2 = r1 + 1;
            r4 = r0 >> 6;
            r4 = r4 & 63;
            r4 = r6[r4];
            r7[r1] = r4;
            r1 = r2 + 1;
            r0 = r0 & 63;
            r0 = r6[r0];
            r7[r2] = r0;
            r0 = r11.d;
            if (r0 == 0) goto L_0x0233;
        L_0x01b7:
            r0 = r1 + 1;
            r2 = 61;
            r7[r1] = r2;
        L_0x01bd:
            r1 = r11.e;
            if (r1 == 0) goto L_0x01d3;
        L_0x01c1:
            r1 = r11.f;
            if (r1 == 0) goto L_0x01cc;
        L_0x01c5:
            r1 = r0 + 1;
            r2 = 13;
            r7[r0] = r2;
            r0 = r1;
        L_0x01cc:
            r1 = r0 + 1;
            r2 = 10;
            r7[r0] = r2;
            r0 = r1;
        L_0x01d3:
            r4 = r0;
            goto L_0x0148;
        L_0x01d6:
            r1 = r3 + 1;
            r0 = r12[r3];
            r3 = r1;
            r1 = r2;
            goto L_0x017d;
        L_0x01dd:
            r2 = r3 + 1;
            r0 = r12[r3];
            r3 = r2;
            goto L_0x018c;
        L_0x01e3:
            r0 = r11.e;
            if (r0 == 0) goto L_0x0148;
        L_0x01e7:
            if (r4 <= 0) goto L_0x0148;
        L_0x01e9:
            r0 = 19;
            if (r5 == r0) goto L_0x0148;
        L_0x01ed:
            r0 = r11.f;
            if (r0 == 0) goto L_0x0231;
        L_0x01f1:
            r0 = r4 + 1;
            r1 = 13;
            r7[r4] = r1;
        L_0x01f7:
            r4 = r0 + 1;
            r1 = 10;
            r7[r0] = r1;
            goto L_0x0148;
        L_0x01ff:
            r0 = r8 + -1;
            if (r3 != r0) goto L_0x0211;
        L_0x0203:
            r0 = r11.i;
            r1 = r11.c;
            r2 = r1 + 1;
            r11.c = r2;
            r2 = r12[r3];
            r0[r1] = r2;
            goto L_0x015c;
        L_0x0211:
            r0 = r8 + -2;
            if (r3 != r0) goto L_0x015c;
        L_0x0215:
            r0 = r11.i;
            r1 = r11.c;
            r2 = r1 + 1;
            r11.c = r2;
            r2 = r12[r3];
            r0[r1] = r2;
            r0 = r11.i;
            r1 = r11.c;
            r2 = r1 + 1;
            r11.c = r2;
            r2 = r3 + 1;
            r2 = r12[r2];
            r0[r1] = r2;
            goto L_0x015c;
        L_0x0231:
            r0 = r4;
            goto L_0x01f7;
        L_0x0233:
            r0 = r1;
            goto L_0x01bd;
        L_0x0235:
            r0 = r1;
            goto L_0x009c;
        L_0x0238:
            r5 = r0;
            r4 = r1;
            goto L_0x004c;
        L_0x023c:
            r0 = r1;
            goto L_0x0042;
            */
            throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.e.b.b.a(byte[], int, int, boolean):boolean");
        }
    }

    public static String a(byte[] bArr, int i) {
        try {
            return new String(b(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] b(byte[] bArr, int i) {
        return a(bArr, 0, bArr.length, i);
    }

    public static byte[] a(byte[] bArr, int i, int i2, int i3) {
        b bVar = new b(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!bVar.d) {
            switch (i2 % 3) {
                case 0:
                    break;
                case 1:
                    i4 += 2;
                    break;
                case 2:
                    i4 += 3;
                    break;
                default:
                    break;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (bVar.e && i2 > 0) {
            int i5;
            int i6 = ((i2 - 1) / 57) + 1;
            if (bVar.f) {
                i5 = 2;
            } else {
                i5 = 1;
            }
            i4 += i5 * i6;
        }
        bVar.a = new byte[i4];
        bVar.a(bArr, i, i2, true);
        if (bVar.b == i4) {
            return bVar.a;
        }
        throw new AssertionError();
    }
}
