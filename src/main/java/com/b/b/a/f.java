package com.b.b.a;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

final class f extends InputStream {
    private final InputStream a;
    private long b;
    private long c;
    private long d;
    private long e = -1;

    public f(InputStream inputStream) {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        this.a = inputStream;
    }

    public void mark(int i) {
        this.e = a(i);
    }

    public long a(int i) {
        long j = this.b + ((long) i);
        if (this.d < j) {
            b(j);
        }
        return this.b;
    }

    private void b(long j) {
        try {
            if (this.c >= this.b || this.b > this.d) {
                this.c = this.b;
                this.a.mark((int) (j - this.b));
            } else {
                this.a.reset();
                this.a.mark((int) (j - this.c));
                a(this.c, this.b);
            }
            this.d = j;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to mark: " + e);
        }
    }

    public void reset() {
        a(this.e);
    }

    public void a(long j) {
        if (this.b > this.d || j < this.c) {
            throw new IOException("Cannot reset");
        }
        this.a.reset();
        a(this.c, j);
        this.b = j;
    }

    private void a(long j, long j2) {
        while (j < j2) {
            long skip = this.a.skip(j2 - j);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j += skip;
        }
    }

    public int read() {
        int read = this.a.read();
        if (read != -1) {
            this.b++;
        }
        return read;
    }

    public int read(byte[] bArr) {
        int read = this.a.read(bArr);
        if (read != -1) {
            this.b += (long) read;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = this.a.read(bArr, i, i2);
        if (read != -1) {
            this.b += (long) read;
        }
        return read;
    }

    public long skip(long j) {
        long skip = this.a.skip(j);
        this.b += skip;
        return skip;
    }

    public int available() {
        return this.a.available();
    }

    public void close() {
        this.a.close();
    }

    public boolean markSupported() {
        return this.a.markSupported();
    }
}
