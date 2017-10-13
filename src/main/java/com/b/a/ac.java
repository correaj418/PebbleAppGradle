package com.b.a;

import com.b.a.a.a;
import com.b.a.a.d;
import com.b.a.a.f;
import com.b.a.f.g;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ac {
    public static boolean a = false;
    static final /* synthetic */ boolean b;

    static {
        boolean z;
        if (ac.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        b = z;
    }

    public static void a(m mVar, k kVar) {
        Object obj = null;
        while (!mVar.l()) {
            obj = mVar.f();
            if (obj == null) {
                break;
            }
            int d = kVar.d();
            if (d <= 0) {
                break;
            }
            obj.a(mVar, kVar);
            if (d == kVar.d() && obj == mVar.f() && !mVar.l()) {
                System.out.println("handler: " + obj);
                kVar.m();
                if (!a) {
                    if (b) {
                        throw new RuntimeException("mDataHandler failed to consume data, yet remains the mDataHandler.");
                    }
                    throw new AssertionError();
                }
                return;
            }
        }
        if (kVar.d() != 0 && !mVar.l()) {
            System.out.println("handler: " + obj);
            System.out.println("emitter: " + mVar);
            kVar.m();
            if (!a) {
                if (b) {
                    throw new RuntimeException("Not all data was consumed by Util.emitAllData");
                }
                throw new AssertionError();
            }
        }
    }

    public static void a(InputStream inputStream, p pVar, a aVar) {
        a(inputStream, 2147483647L, pVar, aVar);
    }

    public static void a(InputStream inputStream, long j, p pVar, final a aVar) {
        final a anonymousClass1 = new a() {
            boolean a;

            public void a(Exception exception) {
                if (!this.a) {
                    this.a = true;
                    aVar.a(exception);
                }
            }
        };
        final p pVar2 = pVar;
        final InputStream inputStream2 = inputStream;
        final long j2 = j;
        f anonymousClass2 = new f() {
            int a = 0;
            k b = new k();
            com.b.a.f.a c = new com.b.a.f.a();

            private void b() {
                pVar2.a(null);
                pVar2.a(null);
                this.b.m();
                g.a(inputStream2);
            }

            public void a() {
                do {
                    try {
                        if (!this.b.e()) {
                            ByteBuffer a = this.c.a();
                            int read = inputStream2.read(a.array(), 0, (int) Math.min(j2 - ((long) this.a), (long) a.capacity()));
                            if (read == -1 || ((long) this.a) == j2) {
                                b();
                                anonymousClass1.a(null);
                                return;
                            }
                            this.c.a((long) read);
                            this.a += read;
                            a.position(0);
                            a.limit(read);
                            this.b.a(a);
                        }
                        pVar2.a(this.b);
                    } catch (Exception e) {
                        b();
                        anonymousClass1.a(e);
                        return;
                    }
                } while (!this.b.e());
            }
        };
        pVar.a(anonymousClass2);
        pVar.a(anonymousClass1);
        anonymousClass2.a();
    }

    public static void a(final m mVar, final p pVar, final a aVar) {
        mVar.a(new d() {
            public void a(m mVar, k kVar) {
                pVar.a(kVar);
                if (kVar.d() > 0) {
                    mVar.n_();
                }
            }
        });
        pVar.a(new f() {
            public void a() {
                mVar.o_();
            }
        });
        final a anonymousClass5 = new a() {
            boolean a;

            public void a(Exception exception) {
                if (!this.a) {
                    this.a = true;
                    mVar.a(null);
                    mVar.b(null);
                    pVar.a(null);
                    pVar.a(null);
                    aVar.a(exception);
                }
            }
        };
        mVar.b(anonymousClass5);
        pVar.a(new a() {
            public void a(Exception exception) {
                if (exception == null) {
                    exception = new IOException("sink was closed before emitter ended");
                }
                anonymousClass5.a(exception);
            }
        });
    }

    public static void a(final p pVar, final k kVar, final a aVar) {
        f anonymousClass7 = new f() {
            public void a() {
                pVar.a(kVar);
                if (kVar.d() == 0 && aVar != null) {
                    pVar.a(null);
                    aVar.a(null);
                }
            }
        };
        pVar.a(anonymousClass7);
        anonymousClass7.a();
    }

    public static void a(p pVar, byte[] bArr, a aVar) {
        ByteBuffer c = k.c(bArr.length);
        c.put(bArr);
        c.flip();
        k kVar = new k();
        kVar.a(c);
        a(pVar, kVar, aVar);
    }

    public static <T extends i> T a(i iVar, Class<T> cls) {
        if (cls.isInstance(iVar)) {
            return iVar;
        }
        i iVar2 = iVar;
        while (iVar2 instanceof com.b.a.g.a) {
            iVar2 = ((com.b.a.g.a) iVar2).o();
            if (cls.isInstance(iVar2)) {
                return iVar2;
            }
        }
        return null;
    }

    public static void a(m mVar, Exception exception) {
        if (mVar != null) {
            a(mVar.h(), exception);
        }
    }

    public static void a(a aVar, Exception exception) {
        if (aVar != null) {
            aVar.a(exception);
        }
    }

    public static void a(p pVar) {
        if (pVar != null) {
            a(pVar.g());
        }
    }

    public static void a(f fVar) {
        if (fVar != null) {
            fVar.a();
        }
    }
}
