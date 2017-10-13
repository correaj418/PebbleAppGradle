package com.squareup.wire;

import b.b;
import b.d;

public final class ProtoWriter {
    private final b sink;

    private static int makeTag(int i, FieldEncoding fieldEncoding) {
        return (i << 3) | fieldEncoding.value;
    }

    static int tagSize(int i) {
        return varint32Size(makeTag(i, FieldEncoding.VARINT));
    }

    static int utf8Length(String str) {
        int i = 0;
        int length = str.length();
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt < '') {
                i2++;
            } else if (charAt < 'ࠀ') {
                i2 += 2;
            } else if (charAt < '?' || charAt > '?') {
                i2 += 3;
            } else if (charAt > '?' || i + 1 >= length || str.charAt(i + 1) < '?' || str.charAt(i + 1) > '?') {
                i2++;
            } else {
                i2 += 4;
                i++;
            }
            i++;
        }
        return i2;
    }

    static int int32Size(int i) {
        if (i >= 0) {
            return varint32Size(i);
        }
        return 10;
    }

    static int varint32Size(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((-268435456 & i) == 0) {
            return 4;
        }
        return 5;
    }

    static int varint64Size(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & j) == 0) {
            return 9;
        }
        return 10;
    }

    static int encodeZigZag32(int i) {
        return (i << 1) ^ (i >> 31);
    }

    static int decodeZigZag32(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    static long encodeZigZag64(long j) {
        return (j << 1) ^ (j >> 63);
    }

    static long decodeZigZag64(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public ProtoWriter(b bVar) {
        this.sink = bVar;
    }

    public void writeBytes(d dVar) {
        this.sink.b(dVar);
    }

    public void writeString(String str) {
        this.sink.b(str);
    }

    public void writeTag(int i, FieldEncoding fieldEncoding) {
        writeVarint32(makeTag(i, fieldEncoding));
    }

    void writeSignedVarint32(int i) {
        if (i >= 0) {
            writeVarint32(i);
        } else {
            writeVarint64((long) i);
        }
    }

    public void writeVarint32(int i) {
        while ((i & -128) != 0) {
            this.sink.g((i & 127) | 128);
            i >>>= 7;
        }
        this.sink.g(i);
    }

    public void writeVarint64(long j) {
        while ((-128 & j) != 0) {
            this.sink.g((((int) j) & 127) | 128);
            j >>>= 7;
        }
        this.sink.g((int) j);
    }

    public void writeFixed32(int i) {
        this.sink.f(i);
    }

    public void writeFixed64(long j) {
        this.sink.i(j);
    }
}
