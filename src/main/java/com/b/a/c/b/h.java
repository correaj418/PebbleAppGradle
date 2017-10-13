package com.b.a.c.b;

import com.b.a.f.b;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

class h implements Closeable {
    private final InputStream a;
    private byte[] b;
    private int c;
    private int d;

    public h(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public h(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null) {
            throw new NullPointerException("in == null");
        } else if (charset == null) {
            throw new NullPointerException("charset == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(b.a) || charset.equals(b.b)) {
            this.a = inputStream;
            this.b = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() {
        synchronized (this.a) {
            if (this.b != null) {
                this.b = null;
                this.a.close();
            }
        }
    }

    public String a() {
        String str;
        synchronized (this.a) {
            if (this.b == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.c >= this.d) {
                c();
            }
            int i2 = this.c;
            while (i2 != this.d) {
                if (this.b[i2] == (byte) 10) {
                    int i3 = (i2 == this.c || this.b[i2 - 1] != (byte) 13) ? i2 : i2 - 1;
                    str = new String(this.b, this.c, i3 - this.c);
                    this.c = i2 + 1;
                } else {
                    i2++;
                }
            }
            ByteArrayOutputStream anonymousClass1 = new ByteArrayOutputStream(this, (this.d - this.c) + 80) {
                final /* synthetic */ h a;

                public String toString() {
                    int i = (this.count <= 0 || this.buf[this.count - 1] != (byte) 13) ? this.count : this.count - 1;
                    return new String(this.buf, 0, i);
                }
            };
            loop1:
            while (true) {
                anonymousClass1.write(this.b, this.c, this.d - this.c);
                this.d = -1;
                c();
                i = this.c;
                while (i != this.d) {
                    if (this.b[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.c) {
                anonymousClass1.write(this.b, this.c, i - this.c);
            }
            this.c = i + 1;
            str = anonymousClass1.toString();
        }
        return str;
    }

    public int b() {
        String a = a();
        try {
            return Integer.parseInt(a);
        } catch (NumberFormatException e) {
            throw new IOException("expected an int but was \"" + a + "\"");
        }
    }

    private void c() {
        int read = this.a.read(this.b, 0, this.b.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.c = 0;
        this.d = read;
    }
}
