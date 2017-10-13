package com.b.a.c.d;

import com.b.a.a.d;
import com.b.a.a.d.a;
import com.b.a.k;
import com.b.a.m;
import com.b.a.x;
import com.b.a.x.b;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public class f extends g {
    boolean d = true;
    protected CRC32 e = new CRC32();

    static short a(byte[] bArr, int i, ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (short) ((bArr[i] << 8) | (bArr[i + 1] & 255));
        }
        return (short) ((bArr[i + 1] << 8) | (bArr[i] & 255));
    }

    public f() {
        super(new Inflater(true));
    }

    public void a(final m mVar, k kVar) {
        if (this.d) {
            final x xVar = new x(mVar);
            xVar.a(10, new b<byte[]>(this) {
                int a;
                boolean b;
                final /* synthetic */ f e;

                public void a(byte[] bArr) {
                    boolean z = true;
                    if (f.a(bArr, 0, ByteOrder.LITTLE_ENDIAN) != (short) -29921) {
                        this.e.b(new IOException(String.format(Locale.ENGLISH, "unknown format (magic number %x)", new Object[]{Short.valueOf(r2)})));
                        mVar.a(new a());
                        return;
                    }
                    this.a = bArr[3];
                    if ((this.a & 2) == 0) {
                        z = false;
                    }
                    this.b = z;
                    if (this.b) {
                        this.e.e.update(bArr, 0, bArr.length);
                    }
                    if ((this.a & 4) != 0) {
                        xVar.a(2, new b<byte[]>(this) {
                            final /* synthetic */ AnonymousClass1 a;

                            {
                                this.a = r1;
                            }

                            public void a(byte[] bArr) {
                                if (this.a.b) {
                                    this.a.e.e.update(bArr, 0, 2);
                                }
                                xVar.a(f.a(bArr, 0, ByteOrder.LITTLE_ENDIAN) & 65535, new b<byte[]>(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = r1;
                                    }

                                    public void a(byte[] bArr) {
                                        if (this.a.a.b) {
                                            this.a.a.e.e.update(bArr, 0, bArr.length);
                                        }
                                        this.a.a.a();
                                    }
                                });
                            }
                        });
                    } else {
                        a();
                    }
                }

                private void a() {
                    x xVar = new x(mVar);
                    d anonymousClass2 = new d(this) {
                        final /* synthetic */ AnonymousClass1 a;

                        {
                            this.a = r1;
                        }

                        public void a(m mVar, k kVar) {
                            if (this.a.b) {
                                while (kVar.o() > 0) {
                                    ByteBuffer n = kVar.n();
                                    this.a.e.e.update(n.array(), n.arrayOffset() + n.position(), n.remaining());
                                    k.c(n);
                                }
                            }
                            kVar.m();
                            this.a.b();
                        }
                    };
                    if ((this.a & 8) != 0) {
                        xVar.a((byte) 0, anonymousClass2);
                    } else if ((this.a & 16) != 0) {
                        xVar.a((byte) 0, anonymousClass2);
                    } else {
                        b();
                    }
                }

                private void b() {
                    if (this.b) {
                        xVar.a(2, new b<byte[]>(this) {
                            final /* synthetic */ AnonymousClass1 a;

                            {
                                this.a = r1;
                            }

                            public void a(byte[] bArr) {
                                if (((short) ((int) this.a.e.e.getValue())) != f.a(bArr, 0, ByteOrder.LITTLE_ENDIAN)) {
                                    this.a.e.b(new IOException("CRC mismatch"));
                                    return;
                                }
                                this.a.e.e.reset();
                                this.a.e.d = false;
                                this.a.e.a(mVar);
                            }
                        });
                        return;
                    }
                    this.e.d = false;
                    this.e.a(mVar);
                }
            });
            return;
        }
        super.a(mVar, kVar);
    }
}
