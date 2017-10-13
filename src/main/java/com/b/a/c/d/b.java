package com.b.a.c.d;

import com.b.a.ac;
import com.b.a.k;
import com.b.a.m;
import com.b.a.t;

public class b extends t {
    static final /* synthetic */ boolean e = (!b.class.desiredAssertionStatus());
    k d = new k();
    private int f = 0;
    private int g = 0;
    private a h = a.CHUNK_LEN;

    private enum a {
        CHUNK_LEN,
        CHUNK_LEN_CR,
        CHUNK_LEN_CRLF,
        CHUNK,
        CHUNK_CR,
        CHUNK_CRLF,
        COMPLETE
    }

    private boolean a(char c, char c2) {
        if (c == c2) {
            return true;
        }
        b(new a(c2 + " was expected, got " + c));
        return false;
    }

    private boolean a(char c) {
        return a(c, '\n');
    }

    private boolean b(char c) {
        return a(c, '\r');
    }

    protected void b(Exception exception) {
        if (exception == null && this.h != a.COMPLETE) {
            exception = new a("chunked input ended before final chunk");
        }
        super.b(exception);
    }

    public void a(m mVar, k kVar) {
        while (kVar.d() > 0) {
            try {
                switch (this.h) {
                    case CHUNK_LEN:
                        char g = kVar.g();
                        if (g == '\r') {
                            this.h = a.CHUNK_LEN_CR;
                        } else {
                            this.f *= 16;
                            if (g >= 'a' && g <= 'f') {
                                this.f = ((g - 97) + 10) + this.f;
                            } else if (g >= '0' && g <= '9') {
                                this.f = (g - 48) + this.f;
                            } else if (g < 'A' || g > 'F') {
                                b(new a("invalid chunk length: " + g));
                                return;
                            } else {
                                this.f = ((g - 65) + 10) + this.f;
                            }
                        }
                        this.g = this.f;
                        break;
                    case CHUNK_LEN_CR:
                        if (a(kVar.g())) {
                            this.h = a.CHUNK;
                            break;
                        }
                        return;
                    case CHUNK:
                        int min = Math.min(this.g, kVar.d());
                        this.g -= min;
                        if (this.g == 0) {
                            this.h = a.CHUNK_CR;
                        }
                        if (min == 0) {
                            break;
                        }
                        kVar.a(this.d, min);
                        ac.a((m) this, this.d);
                        break;
                    case CHUNK_CR:
                        if (b(kVar.g())) {
                            this.h = a.CHUNK_CRLF;
                            break;
                        }
                        return;
                    case CHUNK_CRLF:
                        if (a(kVar.g())) {
                            if (this.f > 0) {
                                this.h = a.CHUNK_LEN;
                            } else {
                                this.h = a.COMPLETE;
                                b(null);
                            }
                            this.f = 0;
                            break;
                        }
                        return;
                    case COMPLETE:
                        if (!e) {
                            throw new AssertionError();
                        }
                        return;
                    default:
                        break;
                }
            } catch (Exception e) {
                b(e);
                return;
            }
        }
    }
}
