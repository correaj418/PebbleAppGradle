package com.getpebble.android.framework.l.a;

import com.getpebble.android.common.b.a.f;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class n extends o {
    private final b a;
    private final byte[] b;
    private final a c;

    public static class a {
        private static final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        public final long a;
        public final int b;
        public final String c;
        public final String d;
        public final int e;

        public a(long j, int i, String str, int i2, String str2) {
            this.a = j;
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = i2;
        }

        private String a(int i) {
            switch (i) {
                case 0:
                    return "*";
                case 1:
                    return "E";
                case 50:
                    return "W";
                case 100:
                    return "I";
                case 200:
                    return "D";
                case 255:
                    return "V";
                default:
                    return "?";
            }
        }

        private static String a(long j) {
            Date date = new Date(1000 * j);
            f.setTimeZone(TimeZone.getTimeZone("UTC"));
            return f.format(date);
        }

        public String a() {
            return String.format("%s %s %s:%s> %s", new Object[]{a(this.b), a(this.a), this.c, Integer.valueOf(this.e), this.d});
        }

        public static a a(ByteBuffer byteBuffer, int i) {
            try {
                Charset.forName("US-ASCII").newDecoder();
                return new a((long) byteBuffer.getInt(), byteBuffer.get() & 255, com.getpebble.android.bluetooth.b.b.a(byteBuffer, 16), byteBuffer.getShort() & 65535, com.getpebble.android.bluetooth.b.b.a(byteBuffer, byteBuffer.get() & 255));
            } catch (Throwable e) {
                f.b("PebbleInboundLogDumpMessage", "Error reading logs", e);
                return new a(0, 0, "corrupt.c", 0, "corrupt");
            }
        }
    }

    public enum b {
        LOG(Byte.MIN_VALUE),
        DONE((byte) -127),
        NO_LOGS((byte) -126),
        STATS_DUMP_DONE((byte) -125);
        
        final byte id;

        private b(byte b) {
            this.id = b;
        }
    }

    com.getpebble.android.bluetooth.g.a a() {
        return com.getpebble.android.bluetooth.g.a.LOG_DUMP;
    }

    protected int b() {
        return 5;
    }

    public n(com.getpebble.android.bluetooth.g.b bVar) {
        super(bVar);
        ByteBuffer b = bVar.b();
        byte b2 = b.get();
        if (b2 == b.DONE.id) {
            this.a = b.DONE;
            this.b = new byte[4];
            b.get(this.b);
            this.c = null;
        } else if (b2 == b.LOG.id) {
            this.a = b.LOG;
            this.b = new byte[4];
            b.get(this.b);
            this.c = a.a(b, b.remaining());
        } else if (b2 == b.NO_LOGS.id) {
            this.a = b.NO_LOGS;
            this.b = new byte[4];
            b.get(this.b);
            this.c = null;
        } else if (b2 == b.STATS_DUMP_DONE.id) {
            this.a = b.STATS_DUMP_DONE;
            this.b = new byte[4];
            b.get(this.b);
            this.c = null;
        } else {
            throw new IllegalArgumentException("Invalid type: " + b2);
        }
    }

    public b c() {
        return this.a;
    }

    public byte[] d() {
        return this.b;
    }

    public a e() {
        return this.c;
    }
}
