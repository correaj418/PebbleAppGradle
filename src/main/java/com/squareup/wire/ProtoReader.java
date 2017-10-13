package com.squareup.wire;

import b.c;
import b.d;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;

public final class ProtoReader {
    private static final int FIELD_ENCODING_MASK = 7;
    private static final int RECURSION_LIMIT = 65;
    private static final int STATE_END_GROUP = 4;
    private static final int STATE_FIXED32 = 5;
    private static final int STATE_FIXED64 = 1;
    private static final int STATE_LENGTH_DELIMITED = 2;
    private static final int STATE_PACKED_TAG = 7;
    private static final int STATE_START_GROUP = 3;
    private static final int STATE_TAG = 6;
    private static final int STATE_VARINT = 0;
    static final int TAG_FIELD_ENCODING_BITS = 3;
    private long limit = Long.MAX_VALUE;
    private FieldEncoding nextFieldEncoding;
    private long pos = 0;
    private long pushedLimit = -1;
    private int recursionDepth;
    private final c source;
    private int state = 2;
    private int tag = -1;

    public ProtoReader(c cVar) {
        this.source = cVar;
    }

    public long beginMessage() {
        if (this.state != 2) {
            throw new IllegalStateException("Unexpected call to beginMessage()");
        }
        int i = this.recursionDepth + 1;
        this.recursionDepth = i;
        if (i > 65) {
            throw new IOException("Wire recursion limit exceeded");
        }
        long j = this.pushedLimit;
        this.pushedLimit = -1;
        this.state = 6;
        return j;
    }

    public void endMessage(long j) {
        if (this.state != 6) {
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
        int i = this.recursionDepth - 1;
        this.recursionDepth = i;
        if (i < 0 || this.pushedLimit != -1) {
            throw new IllegalStateException("No corresponding call to beginMessage()");
        } else if (this.pos == this.limit || this.recursionDepth == 0) {
            this.limit = j;
        } else {
            throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
        }
    }

    public int nextTag() {
        if (this.state == 7) {
            this.state = 2;
            return this.tag;
        } else if (this.state != 6) {
            throw new IllegalStateException("Unexpected call to nextTag()");
        } else {
            while (this.pos < this.limit && !this.source.c()) {
                int internalReadVarint32 = internalReadVarint32();
                if (internalReadVarint32 == 0) {
                    throw new ProtocolException("Unexpected tag 0");
                }
                this.tag = internalReadVarint32 >> 3;
                internalReadVarint32 &= 7;
                switch (internalReadVarint32) {
                    case 0:
                        this.nextFieldEncoding = FieldEncoding.VARINT;
                        this.state = 0;
                        return this.tag;
                    case 1:
                        this.nextFieldEncoding = FieldEncoding.FIXED64;
                        this.state = 1;
                        return this.tag;
                    case 2:
                        this.nextFieldEncoding = FieldEncoding.LENGTH_DELIMITED;
                        this.state = 2;
                        internalReadVarint32 = internalReadVarint32();
                        if (internalReadVarint32 < 0) {
                            throw new ProtocolException("Negative length: " + internalReadVarint32);
                        } else if (this.pushedLimit != -1) {
                            throw new IllegalStateException();
                        } else {
                            this.pushedLimit = this.limit;
                            this.limit = ((long) internalReadVarint32) + this.pos;
                            if (this.limit <= this.pushedLimit) {
                                return this.tag;
                            }
                            throw new EOFException();
                        }
                    case 3:
                        skipGroup(this.tag);
                    case 4:
                        throw new ProtocolException("Unexpected end group");
                    case 5:
                        this.nextFieldEncoding = FieldEncoding.FIXED32;
                        this.state = 5;
                        return this.tag;
                    default:
                        throw new ProtocolException("Unexpected field encoding: " + internalReadVarint32);
                }
            }
            return -1;
        }
    }

    public FieldEncoding peekFieldEncoding() {
        return this.nextFieldEncoding;
    }

    public void skip() {
        switch (this.state) {
            case 0:
                readVarint64();
                return;
            case 1:
                readFixed64();
                return;
            case 2:
                this.source.f(beforeLengthDelimitedScalar());
                return;
            case 5:
                readFixed32();
                return;
            default:
                throw new IllegalStateException("Unexpected call to skip()");
        }
    }

    private void skipGroup(int i) {
        while (this.pos < this.limit && !this.source.c()) {
            int internalReadVarint32 = internalReadVarint32();
            if (internalReadVarint32 == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i2 = internalReadVarint32 >> 3;
            internalReadVarint32 &= 7;
            switch (internalReadVarint32) {
                case 0:
                    this.state = 0;
                    readVarint64();
                    break;
                case 1:
                    this.state = 1;
                    readFixed64();
                    break;
                case 2:
                    internalReadVarint32 = internalReadVarint32();
                    this.pos += (long) internalReadVarint32;
                    this.source.f((long) internalReadVarint32);
                    break;
                case 3:
                    skipGroup(i2);
                    break;
                case 4:
                    if (i2 != i) {
                        throw new ProtocolException("Unexpected end group");
                    }
                    return;
                case 5:
                    this.state = 5;
                    readFixed32();
                    break;
                default:
                    throw new ProtocolException("Unexpected field encoding: " + internalReadVarint32);
            }
        }
        throw new EOFException();
    }

    public d readBytes() {
        return this.source.c(beforeLengthDelimitedScalar());
    }

    public String readString() {
        return this.source.d(beforeLengthDelimitedScalar());
    }

    public int readVarint32() {
        if (this.state == 0 || this.state == 2) {
            int internalReadVarint32 = internalReadVarint32();
            afterPackableScalar(0);
            return internalReadVarint32;
        }
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
    }

    private int internalReadVarint32() {
        this.pos++;
        byte e = this.source.e();
        if (e >= (byte) 0) {
            return e;
        }
        int i = e & 127;
        this.pos++;
        byte e2 = this.source.e();
        if (e2 >= (byte) 0) {
            return i | (e2 << 7);
        }
        i |= (e2 & 127) << 7;
        this.pos++;
        e2 = this.source.e();
        if (e2 >= (byte) 0) {
            return i | (e2 << 14);
        }
        i |= (e2 & 127) << 14;
        this.pos++;
        e2 = this.source.e();
        if (e2 >= (byte) 0) {
            return i | (e2 << 21);
        }
        i |= (e2 & 127) << 21;
        this.pos++;
        e2 = this.source.e();
        i |= e2 << 28;
        if (e2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            this.pos++;
            if (this.source.e() >= (byte) 0) {
                return i;
            }
        }
        throw new ProtocolException("Malformed VARINT");
    }

    public long readVarint64() {
        if (this.state == 0 || this.state == 2) {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                this.pos++;
                byte e = this.source.e();
                j |= ((long) (e & 127)) << i;
                if ((e & 128) == 0) {
                    afterPackableScalar(0);
                    return j;
                }
            }
            throw new ProtocolException("WireInput encountered a malformed varint");
        }
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
    }

    public int readFixed32() {
        if (this.state == 5 || this.state == 2) {
            this.source.a(4);
            this.pos += 4;
            int h = this.source.h();
            afterPackableScalar(5);
            return h;
        }
        throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.state);
    }

    public long readFixed64() {
        if (this.state == 1 || this.state == 2) {
            this.source.a(8);
            this.pos += 8;
            long i = this.source.i();
            afterPackableScalar(1);
            return i;
        }
        throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.state);
    }

    private void afterPackableScalar(int i) {
        if (this.state == i) {
            this.state = 6;
        } else if (this.pos > this.limit) {
            throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
        } else if (this.pos == this.limit) {
            this.limit = this.pushedLimit;
            this.pushedLimit = -1;
            this.state = 6;
        } else {
            this.state = 7;
        }
    }

    private long beforeLengthDelimitedScalar() {
        if (this.state != 2) {
            throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.state);
        }
        long j = this.limit - this.pos;
        this.source.a(j);
        this.state = 6;
        this.pos = this.limit;
        this.limit = this.pushedLimit;
        this.pushedLimit = -1;
        return j;
    }
}
