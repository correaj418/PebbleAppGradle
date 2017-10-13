package com.getpebble.android.bluetooth.b;

import android.text.TextUtils;
import com.getpebble.android.common.b.a.f;
import com.google.a.a.k;
import com.google.a.f.e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

public class b {
    public static final Charset a = Charset.forName("US-ASCII");
    public static final Charset b = Charset.forName("UTF-8");
    private static final Random c = new Random();
    private static final byte[] d = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    private static final byte[] e = "…".getBytes(b);

    public interface a {
        void a(byte[] bArr);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        int min = Math.min(bArr.length, bArr2.length);
        byte[] bArr3 = new byte[min];
        for (int i = 0; i < min; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    public static e a(ByteBuffer byteBuffer) {
        return e.a(byteBuffer.get() & 255);
    }

    public static e b(ByteBuffer byteBuffer) {
        return e.a(byteBuffer.getShort() & 65535);
    }

    public static e c(ByteBuffer byteBuffer) {
        return e.a(byteBuffer.getInt());
    }

    public static int a(String str) {
        return str.getBytes(b).length;
    }

    public static byte[] a(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255)};
    }

    public static String a(ByteBuffer byteBuffer, int i) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        int position = byteBuffer.position() + i;
        if (position < 0 || position > byteBuffer.capacity()) {
            f.a("ByteUtils", String.format("Invalid buffer limit; newLimit=%d, capacity=%d", new Object[]{Integer.valueOf(position), Integer.valueOf(byteBuffer.capacity())}));
            return "";
        }
        duplicate.limit(position);
        byteBuffer.position(byteBuffer.position() + i);
        ByteBuffer duplicate2 = duplicate.duplicate();
        String charBuffer;
        try {
            charBuffer = b.newDecoder().decode(duplicate2).toString();
            int indexOf = charBuffer.indexOf(0);
            if (indexOf < 0) {
                return charBuffer;
            }
            return charBuffer.substring(0, indexOf);
        } catch (Throwable e) {
            f.a("ByteUtils", "Failed to decode string via " + b.toString(), e);
            f.a("ByteUtils", d(duplicate2));
            if (null != null) {
                return null;
            }
            duplicate = duplicate.duplicate();
            try {
                charBuffer = a.newDecoder().decode(duplicate).toString();
                int indexOf2 = charBuffer.indexOf(0);
                if (indexOf2 < 0) {
                    return charBuffer;
                }
                return charBuffer.substring(0, indexOf2);
            } catch (Throwable e2) {
                f.a("ByteUtils", "Failed to decode string via " + a.toString(), e2);
                f.a("ByteUtils", d(duplicate));
                if (null == null) {
                    return "";
                }
                return null;
            }
        }
    }

    public static String a(byte[] bArr) {
        return a(ByteBuffer.wrap(bArr), bArr.length);
    }

    public static List<String> b(byte[] bArr) {
        List<Byte[]> arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] == (byte) 0) {
                arrayList.add(arrayList2.toArray(new Byte[arrayList2.size()]));
                arrayList2.clear();
            } else {
                arrayList2.add(Byte.valueOf(bArr[i]));
            }
        }
        arrayList.add(arrayList2.toArray(new Byte[arrayList2.size()]));
        List<String> arrayList3 = new ArrayList();
        for (Byte[] a : arrayList) {
            arrayList3.add(a(a(a)));
        }
        return arrayList3;
    }

    public static byte[] a(String str, int i) {
        int i2 = 0;
        if (str == null) {
            str = "";
        }
        byte[] bArr = new byte[i];
        byte[] bytes = str.getBytes(b);
        if (bytes.length > i) {
            throw new IllegalArgumentException("String exceeds maximum length");
        }
        Arrays.fill(bArr, (byte) 0);
        while (i2 < bytes.length) {
            bArr[i2] = bytes[i2];
            i2++;
        }
        return bArr;
    }

    @Deprecated
    public static void a(a aVar, String str, int i) {
        aVar.a(b(str, i));
    }

    @Deprecated
    public static byte[] b(String str, int i) {
        int i2 = 0;
        byte[] bArr = new byte[i];
        byte[] bytes = str.getBytes(b);
        if (bytes.length > i) {
            throw new IllegalArgumentException("String exceeds maximum length");
        }
        Arrays.fill(bArr, (byte) 0);
        while (i2 < bytes.length) {
            bArr[i2] = bytes[i2];
            i2++;
        }
        return bArr;
    }

    @Deprecated
    public static void a(a aVar, String str) {
        if (a(str) > 254) {
            str = new String(Arrays.copyOf(str.getBytes(b), 254 - e.length));
        }
        a(aVar, str, a(str) + 1);
    }

    static byte[] a(CharSequence charSequence, int i) {
        int i2 = 0;
        byte[] bArr = new byte[i];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        CharBuffer wrap2 = CharBuffer.wrap(charSequence);
        CharsetEncoder newEncoder = b.newEncoder();
        wrap.limit(i - e.length);
        if (newEncoder.encode(wrap2, wrap, false) == CoderResult.OVERFLOW) {
            wrap.limit(i);
            wrap.mark();
            if (newEncoder.encode(wrap2, wrap, true) == CoderResult.OVERFLOW) {
                wrap.reset();
                while (true) {
                    wrap.mark();
                    byte b = wrap.get();
                    wrap.reset();
                    if ((b & 192) != 128) {
                        break;
                    }
                    try {
                        wrap.position(wrap.position() - 1);
                    } catch (Throwable e) {
                        f.b("ByteUtils", "Error doing utf8-safe truncation", e);
                        return new byte[0];
                    }
                }
                wrap.put(e);
            }
        } else {
            newEncoder.encode(wrap2, wrap, true);
        }
        int position = wrap.position();
        byte[] bArr2 = new byte[position];
        while (i2 < position) {
            bArr2[i2] = bArr[i2];
            i2++;
        }
        return bArr2;
    }

    public static int a(ByteBuffer byteBuffer, CharSequence charSequence, int i) {
        byte[] a = a(charSequence, i);
        byteBuffer.put(a(a.length));
        byteBuffer.put(a);
        return a.length;
    }

    public static byte[] c(String str, int i) {
        if (e.length > i) {
            throw new IllegalArgumentException("maxBytes must be at least " + e.length);
        } else if (i > 255) {
            throw new IllegalArgumentException("maxBytes too large");
        } else if (k.a(str)) {
            return new byte[]{(byte) 0};
        } else {
            Object a = a((CharSequence) str, i);
            byte[] bArr = new byte[(a.length + 1)];
            bArr[0] = (byte) a.length;
            System.arraycopy(a, 0, bArr, 1, a.length);
            return bArr;
        }
    }

    public static byte[] a(String str, int i, ByteOrder byteOrder) {
        if (e.length > i) {
            throw new IllegalArgumentException("maxBytes must be at least " + e.length);
        } else if (i > 65535) {
            throw new IllegalArgumentException("maxBytes too large");
        } else if (k.a(str)) {
            return new byte[]{(byte) 0, (byte) 0};
        } else {
            Object a = a((CharSequence) str, i);
            byte[] bArr = new byte[(a.length + 2)];
            Object b = b(e.a((long) a.length), byteOrder);
            if (b.length != 2) {
                f.a("ByteUtils", "stringLength byte array should contain 2 bytes!");
            }
            System.arraycopy(b, 0, bArr, 0, 2);
            System.arraycopy(a, 0, bArr, 2, a.length);
            return bArr;
        }
    }

    private static boolean a(CharSequence charSequence) {
        return b(charSequence) > 5;
    }

    private static int b(CharSequence charSequence) {
        return TextUtils.isEmpty(charSequence) ? 0 : charSequence.toString().getBytes(b).length;
    }

    static List<CharSequence> a(List<CharSequence> list, int i) {
        Iterable arrayList = new ArrayList();
        int i2 = i;
        int i3 = 0;
        for (CharSequence charSequence : list) {
            CharSequence charSequence2;
            int i4;
            int b = b(charSequence2);
            if (a(charSequence2)) {
                i4 = i2;
                i2 = i3 + b;
            } else {
                i4 = i2 - b;
                i2 = i3;
            }
            i3 = i2;
            i2 = i4;
        }
        if (i3 <= i2) {
            return list;
        }
        float f = ((float) i2) / ((float) i3);
        int length = e.length;
        float f2 = f;
        b = i2;
        i2 = 0;
        for (CharSequence charSequence22 : list) {
            if (a(charSequence22)) {
                int round = Math.round(((float) b(charSequence22)) * f2) - length;
                if (round <= 5) {
                    b -= b(charSequence22);
                    f2 = ((float) b) / ((float) i3);
                    arrayList.add(charSequence22);
                    i2 = b(charSequence22) + i2;
                } else {
                    do {
                        charSequence22 = charSequence22.subSequence(0, charSequence22.length() - 1);
                    } while (b(charSequence22) > round);
                    charSequence22 = charSequence22 + "…";
                }
            }
            arrayList.add(charSequence22);
            i2 = b(charSequence22) + i2;
        }
        f.e("ByteUtils", "truncate: strings = [" + TextUtils.join(com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR, list) + "], result = [" + TextUtils.join(com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR, arrayList) + "], maxLength = " + i + ", totalToTruncate = " + i3 + ", availableLength = " + b + ", resultTotal = " + i2);
        return arrayList;
    }

    public static byte[] b(List<CharSequence> list, int i) {
        List<CharSequence> a = a((List) list, i);
        if (a == null) {
            return new byte[0];
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        boolean z = false;
        for (CharSequence charSequence : a) {
            if (charSequence != null) {
                CharBuffer wrap = CharBuffer.wrap(charSequence);
                CharsetEncoder newEncoder = b.newEncoder();
                allocate.limit(i - e.length);
                if (z) {
                    newEncoder.encode(CharBuffer.wrap("\u0000"), allocate, false);
                }
                if (newEncoder.encode(wrap, allocate, false) == CoderResult.OVERFLOW) {
                    allocate.limit(i);
                    allocate.mark();
                    if (newEncoder.encode(wrap, allocate, true) == CoderResult.OVERFLOW) {
                        allocate.reset();
                        while (true) {
                            allocate.mark();
                            byte b = allocate.get();
                            allocate.reset();
                            if ((b & 192) != 128) {
                                break;
                            }
                            try {
                                allocate.position(allocate.position() - 1);
                            } catch (Throwable e) {
                                f.b("ByteUtils", "Error doing utf8-safe truncation", e);
                                return new byte[0];
                            }
                        }
                        allocate.put(e);
                    }
                } else {
                    newEncoder.encode(wrap, allocate, false);
                }
                z = true;
            }
        }
        byte[] bArr = new byte[allocate.position()];
        allocate.position(0);
        allocate.get(bArr);
        return bArr;
    }

    public static byte[] b(CharSequence charSequence, int i) {
        if (charSequence == null) {
            return new byte[0];
        }
        return a(charSequence, i);
    }

    public static String d(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        StringBuilder stringBuilder = new StringBuilder();
        while (duplicate.remaining() > 0) {
            stringBuilder.append(String.format("%02x ", new Object[]{Byte.valueOf(duplicate.get())}));
        }
        return stringBuilder.toString();
    }

    public static String c(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(String.format("%02x ", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuilder.toString().substring(0, stringBuilder.length() - 1);
    }

    public static boolean e(ByteBuffer byteBuffer) {
        return a(byteBuffer).e(e.a) > 0;
    }

    public static byte[] b(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static String d(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            int i = b & 255;
            stringBuilder.append((char) d[(i >> 4) & 15]).append((char) d[i & 15]).append(' ');
        }
        return stringBuilder.toString();
    }

    public static String e(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            int i = b & 255;
            stringBuilder.append((char) d[(i >> 4) & 15]).append((char) d[i & 15]);
        }
        return stringBuilder.toString();
    }

    public static byte[] b(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] c(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(i);
        byte[] bArr = new byte[4];
        allocate.position(0);
        allocate.get(bArr);
        return bArr;
    }

    public static byte[] a(short s) {
        return new byte[]{(byte) ((s >> 8) & 255), (byte) (s & 255)};
    }

    public static byte[] a(e eVar, ByteOrder byteOrder) {
        return ByteBuffer.allocate(4).order(byteOrder).putInt(eVar.intValue()).array();
    }

    public static byte[] b(e eVar, ByteOrder byteOrder) {
        return ByteBuffer.allocate(2).order(byteOrder).putShort(eVar.shortValue()).array();
    }

    public static byte[] a(e eVar) {
        return a(eVar, ByteOrder.BIG_ENDIAN);
    }

    public static byte b(e eVar) {
        return (byte) (eVar.intValue() & 255);
    }

    public static byte[] c(e eVar) {
        return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(eVar.intValue()).array();
    }

    public static byte[] a() {
        return b(c.nextInt());
    }

    public static byte[] b() {
        return a(c.nextInt());
    }

    public static String b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("md5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(digest[i])}));
            }
            return stringBuilder.toString().toLowerCase(Locale.US);
        } catch (Exception e) {
            return "";
        }
    }

    public static UUID f(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.order(ByteOrder.BIG_ENDIAN);
        UUID uuid = new UUID(duplicate.getLong(), duplicate.getLong());
        byteBuffer.position(duplicate.position());
        return uuid;
    }

    public static byte[] a(UUID uuid) {
        byte[] bArr = new byte[16];
        if (uuid != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.BIG_ENDIAN);
            wrap.putLong(uuid.getMostSignificantBits());
            wrap.putLong(uuid.getLeastSignificantBits());
        }
        return bArr;
    }

    private static Boolean a(byte b, int i) {
        boolean z = true;
        if (((1 << i) & b) == 0) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public static byte[] a(boolean[] zArr) {
        byte[] bArr = new byte[((zArr.length + 7) / 8)];
        for (int i = 0; i < zArr.length; i++) {
            int i2 = i / 8;
            int i3 = i % 8;
            if (zArr[i]) {
                bArr[i2] = (byte) ((1 << i3) | bArr[i2]);
            }
        }
        return bArr;
    }

    public static boolean[] f(byte[] bArr) {
        boolean[] zArr = new boolean[(bArr.length * 8)];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2;
            for (i2 = 0; i2 < 8; i2++) {
                zArr[i3] = a(b, i2).booleanValue();
                i3++;
            }
            i++;
            i2 = i3;
        }
        return zArr;
    }

    public static byte[] a(Byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[i].byteValue();
        }
        return bArr2;
    }
}
